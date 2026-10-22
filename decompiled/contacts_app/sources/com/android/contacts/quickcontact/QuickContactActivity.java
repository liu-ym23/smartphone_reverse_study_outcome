package com.android.contacts.quickcontact;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.Intent;
import android.content.Loader;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.GlobalProxyLancet;
import com.android.contacts.Collapser;
import com.android.contacts.R;
import com.android.contacts.common.model.AccountTypeManager;
import com.android.contacts.common.model.Contact;
import com.android.contacts.common.model.ContactLoader;
import com.android.contacts.common.model.RawContact;
import com.android.contacts.common.model.dataitem.DataItem;
import com.android.contacts.common.model.dataitem.DataKind;
import com.android.contacts.common.model.dataitem.EmailDataItem;
import com.android.contacts.common.model.dataitem.ImDataItem;
import com.android.contacts.common.util.DataStatus;
import com.android.contacts.common.util.StopWatch;
import com.android.contacts.util.ImageViewDrawableSetter;
import com.android.contacts.util.SchedulingUtils;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class QuickContactActivity extends FragmentActivity {
    private static final boolean ENABLE_STOPWATCH = false;
    private static final List<String> LEADING_MIMETYPES = null;
    private static final String LEGACY_AUTHORITY = "contacts";
    private static final int LOADER_ID = 0;
    private static final int POST_DRAW_WAIT_DURATION = 60;
    private static final String TAG = "QuickContact";
    private static final boolean TRACE_LAUNCH = false;
    private static final String TRACE_TAG = "quickcontact";
    private static final List<String> TRAILING_MIMETYPES = null;
    private ActionMultiMap mActions;
    final View.OnClickListener mAddToContactsClickHandler;
    private Contact mContactData;
    private ContactLoader mContactLoader;
    private HashMap<String, Action> mDefaultsMap;
    private String[] mExcludeMimes;
    private FloatingChildLayout mFloatingLayout;
    private View mLineAfterTrack;
    private final QuickContactListFragment.Listener mListFragmentListener;
    private ViewPager mListPager;
    private LoaderManager.LoaderCallbacks<Contact> mLoaderCallbacks;
    private Uri mLookupUri;
    final View.OnClickListener mOpenDetailsClickHandler;
    private ImageView mOpenDetailsOrAddContactImage;
    private ViewPagerAdapter mPagerAdapter;
    private View mPhotoContainer;
    private final ImageViewDrawableSetter mPhotoSetter;
    private ImageView mPhotoView;
    private View mSelectedTabRectangle;
    private List<String> mSortedActionMimeTypes;
    private ImageView mStarImage;
    private StopWatch mStopWatch;
    private ViewGroup mTrack;
    private HorizontalScrollView mTrackScroller;
    private final View.OnClickListener mTypeViewClickListener;

    /* JADX INFO: renamed from: com.android.contacts.quickcontact.QuickContactActivity$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ QuickContactActivity this$0;

        AnonymousClass5(QuickContactActivity r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            SchedulingUtils.doAfterDraw(QuickContactActivity.access$600(this.this$0), new AnonymousClass1(this));
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.quickcontact.QuickContactActivity$6, reason: invalid class name */
    public class AnonymousClass6 implements LoaderManager.LoaderCallbacks<Contact> {
        final /* synthetic */ QuickContactActivity this$0;

        @Override // android.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<Contact> r1) {
        }

        AnonymousClass6(QuickContactActivity r1) {
            this.this$0 = r1;
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Contact> r1, Contact r2) {
            onLoadFinished2(r1, r2);
        }

        /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
        public void onLoadFinished2(Loader<Contact> r4, Contact r5) {
            QuickContactActivity.access$700(this.this$0).lap("lf");
            if (this.this$0.isFinishing() == false) goto L7;
            QuickContactActivity.access$200(this.this$0, false);
            return;
        L7:
            if (r5.isError() == true) goto L18;
            if (r5.isNotFound() == false) goto L12;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(QuickContactActivity.TAG, "No contact found: " + ((ContactLoader) r4).getLookupUri());
            Toast.makeText(this.this$0, R.string.invalidContactMessage, 1).show();
            QuickContactActivity.access$200(this.this$0, false);
            return;
        L12:
            QuickContactActivity.access$800(this.this$0, r5);
            QuickContactActivity.access$700(this.this$0).lap("bd");
            if (Log.isLoggable("ContactsPerf", 3) == false) goto L15;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ContactsPerf", "QuickContact shown");
        L15:
            SchedulingUtils.doAfterLayout(QuickContactActivity.access$600(this.this$0), new AnonymousClass1(this));
            QuickContactActivity.access$700(this.this$0).stopAndLog(QuickContactActivity.TAG, 0);
            QuickContactActivity.access$702(this.this$0, StopWatch.getNullStopWatch());
            return;
        L18:
            throw new IllegalStateException("Failed to load contact", r5.getException());
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public Loader<Contact> onCreateLoader(int r8, Bundle r9) {
            if (QuickContactActivity.access$000(this.this$0) != null) goto L6;
            Log.wtf(QuickContactActivity.TAG, "Lookup uri wasn't initialized. Loader was started too early");
        L6:
            return new ContactLoader(this.this$0.getApplicationContext(), QuickContactActivity.access$000(this.this$0), false, false, false, true);
        }
    }

    private class PageChangeListener extends ViewPager.SimpleOnPageChangeListener {
        private int mScrollingState;
        final /* synthetic */ QuickContactActivity this$0;

        private PageChangeListener(QuickContactActivity r1) {
            this.this$0 = r1;
            this.mScrollingState = 0;
        }

        /* synthetic */ PageChangeListener(QuickContactActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r7) {
            CheckableImageView r0 = QuickContactActivity.access$1200(this.this$0, r7);
            if (r0 == null) goto L6;
            QuickContactActivity.access$1300(this.this$0).requestChildRectangleOnScreen(r0, new Rect(0, 0, r0.getWidth(), r0.getHeight()), false);
        L6:
            if (this.mScrollingState != 0) goto L9;
            renderSelectedRectangle(r7, 0.0f);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r1) {
            super.onPageScrollStateChanged(r1);
            this.mScrollingState = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r1, float r2, int r3) {
            renderSelectedRectangle(r1, r2);
        }

        private void renderSelectedRectangle(int r3, float r4) {
            RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) QuickContactActivity.access$1400(this.this$0).getLayoutParams();
            r0.setMarginStart((int) ((r3 + r4) * r0.width));
            QuickContactActivity.access$1400(this.this$0).setLayoutParams(r0);
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        final /* synthetic */ QuickContactActivity this$0;

        public ViewPagerAdapter(QuickContactActivity r1, FragmentManager r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int r2) {
            String r3 = (String) QuickContactActivity.access$900(this.this$0).get(r2);
            QuickContactListFragment r0 = new QuickContactListFragment(r3);
            r0.setActions(QuickContactActivity.access$1100(this.this$0).get(r3));
            return r0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return QuickContactActivity.access$900(this.this$0).size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object r3) {
            String r4 = ((QuickContactListFragment) r3).getMimeType();
            int r0 = 0;
        L4:
            if (r0 >= QuickContactActivity.access$900(this.this$0).size()) goto L9;
            if (r4.equals(QuickContactActivity.access$900(this.this$0).get(r0)) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -2;
        }
    }

    public void com_android_contacts_quickcontact_QuickContactActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_contacts_quickcontact_QuickContactActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public QuickContactActivity() {
        this.mSortedActionMimeTypes = Lists.newArrayList();
        this.mPhotoSetter = new ImageViewDrawableSetter();
        this.mDefaultsMap = new HashMap();
        this.mActions = new ActionMultiMap();
        this.mStopWatch = StopWatch.getNullStopWatch();
        this.mOpenDetailsClickHandler = new AnonymousClass1(this);
        this.mAddToContactsClickHandler = new AnonymousClass2(this);
        this.mLoaderCallbacks = new AnonymousClass6(this);
        this.mTypeViewClickListener = new AnonymousClass7(this);
        this.mListFragmentListener = new AnonymousClass8(this);
    }

    static /* synthetic */ Uri access$000(QuickContactActivity r0) {
        return r0.mLookupUri;
    }

    static /* synthetic */ ContactLoader access$100(QuickContactActivity r0) {
        return r0.mContactLoader;
    }

    static /* synthetic */ ViewPager access$1000(QuickContactActivity r0) {
        return r0.mListPager;
    }

    static /* synthetic */ ActionMultiMap access$1100(QuickContactActivity r0) {
        return r0.mActions;
    }

    static /* synthetic */ CheckableImageView access$1200(QuickContactActivity r0, int r1) {
        return r0.getActionViewAt(r1);
    }

    static /* synthetic */ HorizontalScrollView access$1300(QuickContactActivity r0) {
        return r0.mTrackScroller;
    }

    static /* synthetic */ View access$1400(QuickContactActivity r0) {
        return r0.mSelectedTabRectangle;
    }

    static /* synthetic */ void access$200(QuickContactActivity r0, boolean r1) {
        r0.close(r1);
    }

    static /* synthetic */ Contact access$300(QuickContactActivity r0) {
        return r0.mContactData;
    }

    static /* synthetic */ void access$400(QuickContactActivity r0) {
        r0.handleOutsideTouch();
    }

    static /* synthetic */ FloatingChildLayout access$600(QuickContactActivity r0) {
        return r0.mFloatingLayout;
    }

    static /* synthetic */ StopWatch access$700(QuickContactActivity r0) {
        return r0.mStopWatch;
    }

    static /* synthetic */ StopWatch access$702(QuickContactActivity r0, StopWatch r1) {
        r0.mStopWatch = r1;
        return r1;
    }

    static /* synthetic */ void access$800(QuickContactActivity r0, Contact r1) {
        r0.bindData(r1);
    }

    static /* synthetic */ List access$900(QuickContactActivity r0) {
        return r0.mSortedActionMimeTypes;
    }

    static {
        LEADING_MIMETYPES = Lists.newArrayList(new String[]{"vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/sip_address", "vnd.android.cursor.item/email_v2"});
        TRAILING_MIMETYPES = Lists.newArrayList(new String[]{"vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/website"});
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r5) {
        this.mStopWatch.lap("c");
        super.onCreate(r5);
        this.mStopWatch.lap("sc");
        Intent r6 = getIntent();
        Uri r0 = r6.getData();
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "missing lookupUri");
        finish();
        return;
    L10:
        this.mLookupUri = r0;
        this.mExcludeMimes = r6.getStringArrayExtra("android.provider.extra.EXCLUDE_MIMES");
        this.mStopWatch.lap("i");
        this.mContactLoader = (ContactLoader) getLoaderManager().initLoader(0, null, this.mLoaderCallbacks);
        this.mStopWatch.lap("ld");
        getWindow().setFlags(131072, 131072);
        setContentView(R.layout.quickcontact_activity);
        UiUtils.setWindowColorStatusBar(this);
        this.mStopWatch.lap("l");
        this.mFloatingLayout = (FloatingChildLayout) findViewById(R.id.floating_layout);
        this.mTrack = (ViewGroup) findViewById(R.id.track);
        this.mTrackScroller = (HorizontalScrollView) findViewById(R.id.track_scroller);
        this.mOpenDetailsOrAddContactImage = (ImageView) findViewById(R.id.contact_details_image);
        this.mStarImage = (ImageView) findViewById(R.id.quickcontact_star_button);
        this.mListPager = (ViewPager) findViewById(R.id.item_list_pager);
        this.mSelectedTabRectangle = findViewById(R.id.selected_tab_rectangle);
        this.mLineAfterTrack = findViewById(R.id.line_after_track);
        this.mFloatingLayout.setOnOutsideTouchListener(new AnonymousClass3(this));
        this.mOpenDetailsOrAddContactImage.setOnClickListener(this.mOpenDetailsClickHandler);
        ViewPagerAdapter r1 = new ViewPagerAdapter(this, getSupportFragmentManager());
        this.mPagerAdapter = r1;
        this.mListPager.setAdapter(r1);
        this.mListPager.setOnPageChangeListener(new PageChangeListener(this, null));
        Rect r7 = r6.getSourceBounds();
        if (r7 == null) goto L13;
        this.mFloatingLayout.setChildTargetScreen(r7);
    L13:
        this.mPhotoContainer = findViewById(R.id.photo_container);
        setHeaderNameText(R.id.name, R.string.missing_name);
        ImageView r8 = (ImageView) this.mPhotoContainer.findViewById(R.id.photo);
        this.mPhotoView = r8;
        r8.setOnClickListener(this.mOpenDetailsClickHandler);
        this.mStopWatch.lap(BaseSwitches.V);
        SchedulingUtils.doAfterLayout(this.mFloatingLayout, new AnonymousClass4(this));
        this.mStopWatch.lap("cf");
        return;
    L5:
        if ("contacts".equals(r0.getAuthority()) == false) goto L7;
        long r2 = ContentUris.parseId(r0);
        r0 = ContactsContract.RawContacts.getContactLookupUri(getContentResolver(), ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, r2));
        goto L7
    }

    private void handleOutsideTouch() {
        if (this.mFloatingLayout.isContentFullyVisible() == false) goto L6;
        close(true);
        return;
    }

    private void close(boolean r3) {
        getLoaderManager().destroyLoader(0);
        if (r3 == false) goto L7;
        this.mFloatingLayout.fadeOutBackground();
        if (this.mFloatingLayout.hideContent(new AnonymousClass5(this)) == true) goto L9;
        finish();
        return;
    L9:
        return;
    L7:
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        close(true);
    }

    private void setHeaderNameText(int r1, int r2) {
        setHeaderNameText(r1, getText(r2));
    }

    private void setHeaderNameText(int r1, CharSequence r2) {
        View r0 = this.mPhotoContainer.findViewById(r1);
        if ((r0 instanceof TextView) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        ((TextView) r0).setText(r2);
        return;
    }

    private boolean isMimeExcluded(String r5) {
        String[] r4 = this.mExcludeMimes;
        if (r4 != null) goto L5;
        return false;
    L5:
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (TextUtils.equals(r4[r2], r5) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void bindData(Contact r18) {
        this.mContactData = r18;
        ResolveCache r2 = ResolveCache.getInstance(this);
        ImageView r3 = this.mOpenDetailsOrAddContactImage;
        int r5 = 8;
        if (isMimeExcluded("vnd.android.cursor.item/contact") == false) goto L5;
        int r4 = 8;
    L6:
        r3.setVisibility(r4);
        if (r18.getStarred() == false) goto L9;
        this.mStarImage.setImageResource(R.drawable.ic_favorite_on_lt);
        this.mStarImage.setContentDescription(getResources().getString(R.string.menu_removeStar));
    L10:
        r18.getLookupUri();
        this.mStarImage.setVisibility(8);
        this.mDefaultsMap.clear();
        this.mStopWatch.lap("sph");
        this.mPhotoSetter.setupContactPhoto(r18, this.mPhotoView);
        this.mStopWatch.lap("ph");
        UnmodifiableIterator<RawContact> r6 = r18.getRawContacts().iterator();
    L12:
        if (r6.hasNext() == false) goto L35;
        RawContact r7 = r6.next();
        Iterator<DataItem> r8 = r7.getDataItems().iterator();
    L15:
        if (r8.hasNext() == false) goto L12;
        DataItem r9 = r8.next();
        String r10 = r9.getMimeType();
        DataKind r11 = AccountTypeManager.getInstance(this).getKindOrFallback(r7.getAccountType(this), r10);
        if (isMimeExcluded(r10) == true) goto L15;
        long r12 = r9.getId();
        boolean r13 = r9.isPrimary();
        boolean r14 = r9.isSuperPrimary();
        if (r11 == null) goto L28;
        Action r15 = new DataAction(this, r9, r11);
        if (considerAdd(r15, r2, r14) == false) goto L28;
        if (r14 == true) goto L27;
        if (r13 == false) goto L28;
        if (this.mDefaultsMap.get(r10) != null) goto L28;
    L27:
        this.mDefaultsMap.put(r10, r15);
    L28:
        DataStatus r16 = r18.getStatuses().get(Long.valueOf(r12));
        if (r16 == null) goto L15;
        if ((r9 instanceof EmailDataItem) == false) goto L15;
        ImDataItem r17 = ImDataItem.createFromEmail((EmailDataItem) r9);
        if (r11 == null) goto L15;
        DataAction r19 = new DataAction(this, r17, r11);
        r19.setPresence(r16.getPresence());
        considerAdd(r19, r2, r14);
        goto L15
    L35:
        this.mStopWatch.lap("e");
        Iterator<ArrayList<Action>> r20 = this.mActions.values().iterator();
    L37:
        if (r20.hasNext() == false) goto L39;
        Collapser.collapseList(r20.next());
        goto L37
    L39:
        this.mStopWatch.lap("c");
        setHeaderNameText(R.id.name, r18.getDisplayName());
        HashSet r21 = new HashSet(this.mActions.keySet());
        this.mSortedActionMimeTypes.clear();
        Iterator<String> r22 = LEADING_MIMETYPES.iterator();
    L41:
        if (r22.hasNext() == false) goto L45;
        String r23 = r22.next();
        if (r21.contains(r23) == false) goto L41;
        this.mSortedActionMimeTypes.add(r23);
        r21.remove(r23);
        goto L41
    L45:
        String[] r24 = (String[]) r21.toArray(new String[r21.size()]);
        int r25 = r24.length;
        int r26 = 0;
    L46:
        if (r26 >= r25) goto L51;
        String r27 = r24[r26];
        if (TRAILING_MIMETYPES.contains(r27) == true) goto L50;
        this.mSortedActionMimeTypes.add(r27);
        r21.remove(r27);
    L50:
        r26 = r26 + 1;
        goto L46
    L51:
        Iterator<String> r28 = TRAILING_MIMETYPES.iterator();
    L53:
        if (r28.hasNext() == false) goto L57;
        String r29 = r28.next();
        if (r21.contains(r29) == false) goto L53;
        r21.remove(r29);
        this.mSortedActionMimeTypes.add(r29);
        goto L53
    L57:
        this.mPagerAdapter.notifyDataSetChanged();
        this.mStopWatch.lap("mt");
        this.mTrack.removeAllViews();
        Iterator<String> r30 = this.mSortedActionMimeTypes.iterator();
    L59:
        if (r30.hasNext() == false) goto L61;
        this.mTrack.addView(inflateAction(r30.next(), r2, this.mTrack, r18.getDisplayName()));
        goto L59
    L61:
        this.mStopWatch.lap("mt");
        boolean r1 = !this.mSortedActionMimeTypes.isEmpty();
        HorizontalScrollView r31 = this.mTrackScroller;
        if (r1 == false) goto L64;
        int r32 = 0;
    L65:
        r31.setVisibility(r32);
        View r33 = this.mSelectedTabRectangle;
        if (r1 == false) goto L68;
        int r34 = 0;
    L69:
        r33.setVisibility(r34);
        View r35 = this.mLineAfterTrack;
        if (r1 == false) goto L72;
        int r36 = 0;
    L73:
        r35.setVisibility(r36);
        ViewPager r0 = this.mListPager;
        if (r1 == false) goto L76;
        r5 = 0;
    L76:
        r0.setVisibility(r5);
        return;
    L72:
        r36 = 8;
        goto L73
    L68:
        r34 = 8;
        goto L69
    L64:
        r32 = 8;
        goto L65
    L9:
        this.mStarImage.setImageResource(R.drawable.ic_favorite_off_lt);
        this.mStarImage.setContentDescription(getResources().getString(R.string.menu_addStar));
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    private boolean considerAdd(Action r1, ResolveCache r2, boolean r3) {
        if (r2.hasResolve(r1) == false) goto L6;
        this.mActions.put(r1.getMimeType(), r1, r3);
        return true;
    L6:
        return false;
    }

    private void configureHeaderClickActions(boolean r2) {
        if (r2 == false) goto L4;
        this.mOpenDetailsOrAddContactImage.setImageResource(R.drawable.ic_add_contact_holo_dark);
        this.mOpenDetailsOrAddContactImage.setOnClickListener(this.mAddToContactsClickHandler);
        this.mPhotoView.setOnClickListener(this.mAddToContactsClickHandler);
        return;
    L4:
        this.mOpenDetailsOrAddContactImage.setImageResource(R.drawable.ic_contacts_holo_dark);
        this.mOpenDetailsOrAddContactImage.setOnClickListener(this.mOpenDetailsClickHandler);
        this.mPhotoView.setOnClickListener(this.mOpenDetailsClickHandler);
    }

    private View inflateAction(String r4, ResolveCache r5, ViewGroup r6, String r7) {
        CheckableImageView r8 = (CheckableImageView) getLayoutInflater().inflate(R.layout.quickcontact_track_button, r6, false);
        ArrayList<Action> r0 = this.mActions.get(r4);
        r8.setTag(r4);
        Action r9 = r0.get(0);
        CharSequence r10 = r5.getDescription(r9, r7);
        Drawable r11 = r5.getIcon(r9);
        r8.setChecked(false);
        r8.setContentDescription(r10);
        r8.setImageDrawable(r11);
        r8.setOnClickListener(this.mTypeViewClickListener);
        return r8;
    }

    private CheckableImageView getActionViewAt(int r1) {
        return (CheckableImageView) this.mTrack.getChildAt(r1);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment r1) {
        ((QuickContactListFragment) r1).setListener(this.mListFragmentListener);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_quickcontact_QuickContactActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(QuickContactActivity r1) {
        r1.com_android_contacts_quickcontact_QuickContactActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
