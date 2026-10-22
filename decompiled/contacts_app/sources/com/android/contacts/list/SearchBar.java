package com.android.contacts.list;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextWatcher;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsTracker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import obric.app.tracker.Agent;
import obric.widget.support.AbsMenuItem;
import obric.widget.support.ListPopMenuStandardAdapter;
import obric.widget.support.ListPopupMenu;

/* JADX INFO: loaded from: classes2.dex */
public class SearchBar extends RelativeLayout implements View.OnClickListener, AdapterView.OnItemClickListener {
    public static final String KEY_ICON_RESOURCE = "resource";
    public static final String KEY_IS_SELECTED = "selected";
    public static final String KEY_SORT_TYPE = "sort_type";
    public static final String KEY_SORT_TYPE_NAME = "sort_type_name";
    public static final int SORT_BY_ADD_TIME = 8;
    public static final int SORT_BY_BUSINESS_CARD = 128;
    public static final int SORT_BY_COMPANY = 16;
    public static final int SORT_BY_FREQUENCY = 4;
    public static final int SORT_BY_LOCATION = 2;
    public static final int SORT_BY_NAME = 1;
    public static final int SORT_BY_PHONE_CONTACTS = 256;
    public static final int SORT_BY_SIM1 = 32;
    public static final int SORT_BY_SIM2 = 64;
    private TextView mBtnCancelSearch;
    private TextView mBtnClearSearch;
    private ImageView mBtnSort;
    private Context mContext;
    private DecelerateInterpolator mDecelerateInterpolator;
    private int mDuration;
    private boolean mIsPlaySearchModeAnimation;
    private boolean mIsSearchMode;
    private boolean mIsSortByBusinessCardSupported;
    private Listener mListener;
    private ListPopupMenu mPopupWindow;
    private RelativeLayout mSearchBarView;
    private EditText mSearchEdit;
    private LinearLayout mSearchView;
    private TextView mSearchViewLeft;
    private TextView mSearchViewRight;
    private TextWatcher mSearchWatcher;
    HashMap<String, Object> mSortByBusinessCard;
    private int mSortByBusinessCardIndex;
    private int mSortByPhoneContactsIndex;
    HashMap<String, Object> mSortBySim1;
    private int mSortBySim1Index;
    HashMap<String, Object> mSortBySim2;
    private int mSortBySim2Index;
    private int mSortMode;
    private List<SortTypeItemResource> mSortTypes;
    private List<SortTypeItemResource> mTopSortTypes;

    public interface Action {
        void execute();
    }

    private class AnimationListenerWrapper implements Animation.AnimationListener {
        final /* synthetic */ SearchBar this$0;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r1) {
        }

        private AnimationListenerWrapper(SearchBar r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AnimationListenerWrapper(SearchBar r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public interface Listener {
        void endContactAnimation();

        void endContactAnimationWithoutAnimation();

        void hideQuickContactView();

        boolean onModeChange(int r1);

        void onModeWillChange();

        void onPopupDismiss();

        void onQueryTextChange(String r1);

        void onSearchAnimationStart();

        void recoverQuickBar();

        void setSoftKeyboardHide();

        void startContactAnimation();
    }

    class MenuItem extends AbsMenuItem {
        int iconRes;
        boolean isSelected;
        final /* synthetic */ SearchBar this$0;
        String title;

        MenuItem(SearchBar r1) {
            this.this$0 = r1;
        }

        @Override // obric.widget.support.AbsMenuItem, obric.widget.support.IMenuItem
        public String getTitle() {
            return this.title;
        }

        @Override // obric.widget.support.AbsMenuItem, obric.widget.support.IMenuItem
        public void setMenuIcon(ImageView r1) {
            r1.setImageResource(this.iconRes);
        }

        @Override // obric.widget.support.AbsMenuItem, obric.widget.support.IMenuItem
        public boolean isSelected() {
            return this.isSelected;
        }
    }

    private class SortTypeItemResource {
        Action action;
        int lable;
        HashMap<String, Object> map;
        final /* synthetic */ SearchBar this$0;

        public SortTypeItemResource(SearchBar r1, int r2, HashMap<String, Object> r3, Action r4) {
            this.this$0 = r1;
            this.lable = r2;
            this.map = r3;
            this.action = r4;
        }
    }

    static /* synthetic */ Listener access$000(SearchBar r0) {
        return r0.mListener;
    }

    static /* synthetic */ boolean access$100(SearchBar r0) {
        return r0.mIsSearchMode;
    }

    static /* synthetic */ TextView access$200(SearchBar r0) {
        return r0.mBtnClearSearch;
    }

    static /* synthetic */ ListPopupMenu access$300(SearchBar r0) {
        return r0.mPopupWindow;
    }

    static /* synthetic */ Context access$400(SearchBar r0) {
        return r0.mContext;
    }

    static /* synthetic */ EditText access$500(SearchBar r0) {
        return r0.mSearchEdit;
    }

    static /* synthetic */ boolean access$702(SearchBar r0, boolean r1) {
        r0.mIsPlaySearchModeAnimation = r1;
        return r1;
    }

    static /* synthetic */ void access$800(SearchBar r0, int r1) {
        r0.resetSearchViewParam(r1);
    }

    public SearchBar(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mIsSearchMode = false;
        this.mIsPlaySearchModeAnimation = false;
        this.mBtnSort = null;
        this.mDuration = 200;
        this.mSortMode = 1;
        this.mIsSortByBusinessCardSupported = false;
        this.mSearchWatcher = new AnonymousClass2(this);
        this.mTopSortTypes = new ArrayList(5);
        this.mSortByPhoneContactsIndex = -1;
        this.mSortBySim1Index = -1;
        this.mSortBySim2Index = -1;
        this.mSortByBusinessCardIndex = -1;
        HashMap r2 = new HashMap();
        r2.put("resource", Integer.valueOf(R.drawable.sort_menu_name_icon));
        r2.put("sort_type", Integer.valueOf(R.string.common_given_name));
        r2.put("selected", true);
        SortTypeItemResource r7 = new SortTypeItemResource(this, 1, r2, new AnonymousClass4(this));
        this.mTopSortTypes.add(r7);
        if (ContactsUtils.isFeatureDomestic() == false) goto L5;
        HashMap r3 = new HashMap();
        r3.put("resource", Integer.valueOf(R.drawable.sort_menu_location_icon));
        r3.put("sort_type", Integer.valueOf(R.string.sort_city));
        r3.put("selected", false);
        SortTypeItemResource r8 = new SortTypeItemResource(this, 2, r3, new AnonymousClass5(this));
        this.mTopSortTypes.add(r8);
    L5:
        HashMap r4 = new HashMap();
        r4.put("resource", Integer.valueOf(R.drawable.sort_menu_frequency_icon));
        r4.put("sort_type", Integer.valueOf(R.string.sort_times));
        r4.put("selected", false);
        SortTypeItemResource r9 = new SortTypeItemResource(this, 4, r4, new AnonymousClass6(this));
        this.mTopSortTypes.add(r9);
        HashMap r5 = new HashMap();
        r5.put("resource", Integer.valueOf(R.drawable.sort_menu_creat_time_icon));
        r5.put("sort_type", Integer.valueOf(R.string.sort_add_times));
        r5.put("selected", false);
        SortTypeItemResource r12 = new SortTypeItemResource(this, 8, r5, new AnonymousClass7(this));
        this.mTopSortTypes.add(r12);
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == false) goto L16;
        if (DSUtils.isMultiSimEnabled() == false) goto L16;
        HashMap r6 = new HashMap();
        r6.put("resource", Integer.valueOf(R.drawable.sort_menu_phone_contacts_icon));
        r6.put("sort_type", Integer.valueOf(R.string.sort_phone_contacts));
        r6.put("selected", false);
        SortTypeItemResource r13 = new SortTypeItemResource(this, 256, r6, new AnonymousClass8(this));
        this.mTopSortTypes.add(r13);
        this.mSortByPhoneContactsIndex = this.mTopSortTypes.size() - 1;
        if (this.mSortBySim1 != null) goto L13;
        HashMap<String, Object> r14 = new HashMap();
        this.mSortBySim1 = r14;
        r14.put("resource", Integer.valueOf(DSUtils.getMenuSimIconResource(0)));
        this.mSortBySim1.put("sort_type_name", MoreContactUtils.getSimAccountName(0));
        this.mSortBySim1.put("selected", false);
    L13:
        if (this.mSortBySim2 != null) goto L16;
        HashMap<String, Object> r15 = new HashMap();
        this.mSortBySim2 = r15;
        r15.put("resource", Integer.valueOf(DSUtils.getMenuSimIconResource(1)));
        this.mSortBySim2.put("sort_type_name", MoreContactUtils.getSimAccountName(1));
        this.mSortBySim2.put("selected", false);
    L16:
        if (this.mSortByBusinessCard != null) goto L18;
        HashMap<String, Object> r16 = new HashMap();
        this.mSortByBusinessCard = r16;
        r16.put("resource", Integer.valueOf(R.drawable.sort_menu_business_icon));
        this.mSortByBusinessCard.put("sort_type", Integer.valueOf(R.string.sort_business_card));
        this.mSortByBusinessCard.put("selected", false);
    L18:
        this.mContext = r10;
        this.mSearchBarView = (RelativeLayout) ((LayoutInflater) r10.getSystemService("layout_inflater")).inflate(R.layout.searchbar, this);
        this.mDecelerateInterpolator = new DecelerateInterpolator(1.5f);
        setViews();
    }

    private void setViews() {
        ImageView r0 = (ImageView) this.mSearchBarView.findViewById(R.id.btn_sort);
        this.mBtnSort = r0;
        r0.setOnClickListener(this);
        LinearLayout r1 = (LinearLayout) this.mSearchBarView.findViewById(R.id.search_view);
        this.mSearchView = r1;
        r1.setOnClickListener(this);
        TextView r2 = (TextView) this.mSearchBarView.findViewById(R.id.searchbarright);
        this.mSearchViewRight = r2;
        r2.setOnClickListener(this);
        TextView r3 = (TextView) this.mSearchBarView.findViewById(R.id.searchbarleft);
        this.mSearchViewLeft = r3;
        r3.setOnClickListener(this);
        TextView r4 = (TextView) this.mSearchBarView.findViewById(R.id.btn_cancel);
        this.mBtnCancelSearch = r4;
        r4.setOnClickListener(this);
        EditText r5 = (EditText) this.mSearchBarView.findViewById(R.id.search_edit_text);
        this.mSearchEdit = r5;
        r5.setOnClickListener(this);
        this.mSearchEdit.addTextChangedListener(this.mSearchWatcher);
        this.mSearchEdit.setOnEditorActionListener(new AnonymousClass1(this));
        TextView r6 = (TextView) this.mSearchBarView.findViewById(R.id.btn_clear_search);
        this.mBtnClearSearch = r6;
        r6.setOnClickListener(this);
    }

    void clearSearchText() {
        EditText r1 = this.mSearchEdit;
        if (r1 == null) goto L6;
        r1.setText("");
        return;
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        switch(r3.getId()) {
            case 2131362107: goto L19;
            case 2131362110: goto L18;
            case 2131362166: goto L13;
            case 2131363492: goto L8;
            case 2131363526: goto L6;
            case 2131363527: goto L6;
            default: goto L25;
        };
    L8:
        Agent.getInstance().onClick("ContactListFragment", Constants.ContactsTracker.EVENT_START_SEARCH);
        Listener r4 = this.mListener;
        if (r4 == null) goto L11;
        r4.hideQuickContactView();
    L11:
        startSearch();
        return;
    L18:
        this.mSearchEdit.setText("");
        return;
    L19:
        cancelSearch();
        return;
    L25:
        return;
    L6:
        if (this.mIsSearchMode == false) goto L8;
        return;
    L13:
        if (ContactsUtils.isJustClicked() == true) goto L22;
        Listener r0 = this.mListener;
        if (r0 == null) goto L17;
        r0.hideQuickContactView();
        this.mListener.recoverQuickBar();
    L17:
        showSortByPopupWindow(r3);
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        List<SortTypeItemResource> r5 = this.mSortTypes;
        if (r5 != null) goto L5;
    L9:
        ContactsTracker.trackSortModeChange(r3);
        return;
    L5:
        if (r5.size() <= 0) goto L9;
        SortTypeItemResource r0 = this.mSortTypes.get(r3);
        if (r0 == null) goto L9;
        r0.action.execute();
        goto L9
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 == 0) goto L8;
        ListPopupMenu r0 = this.mPopupWindow;
        if (r0 == null) goto L9;
        r0.dismiss();
        return;
    L9:
        return;
    }

    private void showSortByPopupWindow(View r10) {
        Listener r0 = this.mListener;
        if (r0 == null) goto L5;
        r0.onModeWillChange();
    L5:
        ListPopupMenu r1 = new ListPopupMenu(this.mContext);
        this.mPopupWindow = r1;
        r1.setAnchorView(r10);
        initSortModeUI();
        String r11 = getResources().getString(R.string.contacts_sort_menu_top);
        this.mPopupWindow.setMenuListTitleVisible(true);
        this.mPopupWindow.setMenuListTitle(r11);
        final MenuItem[] r2 = new MenuItem[4];
        MenuItem r3 = new MenuItem(this);
        r3.title = getResources().getString(R.string.common_given_name);
        r3.iconRes = R.drawable.sort_menu_name_icon;
        if (this.mSortMode != 1) goto L8;
        boolean r4 = true;
    L9:
        r3.isSelected = r4;
        r2[0] = r3;
        MenuItem r5 = new MenuItem(this);
        r5.title = getResources().getString(R.string.sort_city);
        r5.iconRes = R.drawable.sort_menu_location_icon;
        if (this.mSortMode != 2) goto L12;
        boolean r6 = true;
    L13:
        r5.isSelected = r6;
        r2[1] = r5;
        MenuItem r7 = new MenuItem(this);
        r7.title = getResources().getString(R.string.sort_times);
        r7.iconRes = R.drawable.sort_menu_frequency_icon;
        if (this.mSortMode != 4) goto L16;
        boolean r12 = true;
    L17:
        r7.isSelected = r12;
        r2[2] = r7;
        MenuItem r13 = new MenuItem(this);
        r13.title = getResources().getString(R.string.sort_add_times);
        r13.iconRes = R.drawable.sort_menu_creat_time_icon;
        if (this.mSortMode != 8) goto L20;
        boolean r8 = true;
    L21:
        r13.isSelected = r8;
        r2[3] = r13;
        final ListPopMenuStandardAdapter r14 = new ListPopMenuStandardAdapter(this.mContext, 0, r2);
        this.mPopupWindow.setAdapter(r14);
        this.mBtnSort.setActivated(true);
        this.mPopupWindow.setOnItemClickListener(new AnonymousClass3(this, r2, r14));
        this.mPopupWindow.show(0, -ContactsUtils.dipTopx(this.mContext, 217.60000610351562d), -ContactsUtils.dipTopx(this.mContext, 5.199999809265137d), ContactsUtils.dipTopx(this.mContext, 187.60000610351562d), 0);
        return;
    L20:
        r8 = false;
        goto L21
    L16:
        r12 = false;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r4 = false;
        goto L9
    }

    public boolean isPopupWindowShowing() {
        ListPopupMenu r0 = this.mPopupWindow;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    protected void switchSortMode(int r2) {
        ListPopupMenu r0 = this.mPopupWindow;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        this.mPopupWindow.dismiss();
    L8:
        if (this.mSortMode != r2) goto L11;
        return;
    L11:
        if (this.mListener.onModeChange(r2) == false) goto L14;
        this.mSortMode = r2;
        return;
    }

    public void setSortByBusinessCardSupported(boolean r1) {
        this.mIsSortByBusinessCardSupported = r1;
    }

    private void initSortModeUI() {
        ArrayList r0 = new ArrayList(8);
        r0.addAll(this.mTopSortTypes);
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == false) goto L19;
        if (DSUtils.isMultiSimEnabled() == false) goto L19;
        if (DSUtils.hasIccCard(0) == true) goto L9;
    L11:
        this.mSortBySim1Index = -1;
    L13:
        if (DSUtils.hasIccCard(1) == true) goto L15;
    L17:
        this.mSortBySim2Index = -1;
        goto L19
    L15:
        if (DSUtils.isSimEnable(1) == false) goto L17;
        Action r1 = new AnonymousClass10(this);
        r0.add(new SortTypeItemResource(this, 64, this.mSortBySim2, r1));
        this.mSortBySim2Index = r0.size() - 1;
        goto L19
    L9:
        if (DSUtils.isSimEnable(0) == false) goto L11;
        Action r2 = new AnonymousClass9(this);
        r0.add(new SortTypeItemResource(this, 32, this.mSortBySim1, r2));
        this.mSortBySim1Index = r0.size() - 1;
    L19:
        if (this.mIsSortByBusinessCardSupported == true) goto L21;
        this.mSortByBusinessCardIndex = -1;
    L22:
        this.mSortTypes = r0;
        Iterator r3 = r0.iterator();
    L24:
        if (r3.hasNext() == false) goto L29;
        SortTypeItemResource r4 = (SortTypeItemResource) r3.next();
        if (this.mSortMode == r4.lable) goto L27;
        r4.map.put("selected", false);
        goto L24
    L27:
        r4.map.put("selected", true);
        goto L24
    L29:
        return;
    L21:
        Action r5 = new AnonymousClass11(this);
        r0.add(new SortTypeItemResource(this, 128, this.mSortByBusinessCard, r5));
        this.mSortByBusinessCardIndex = r0.size() - 1;
        goto L22
    }

    public void returnToSortByName() {
        if (this.mSortMode != 1) goto L5;
        return;
    L5:
        switchSortMode(1);
    }

    public void requestSeachViewFocus() {
        this.mSearchEdit.requestFocus();
    }

    public void startSearch() {
        if (this.mIsPlaySearchModeAnimation == false) goto L5;
        return;
    L5:
        if (this.mIsSearchMode == true) goto L12;
        this.mBtnSort.setEnabled(false);
        if (isPopupWindowShowing() == false) goto L9;
        this.mPopupWindow.dismiss();
    L9:
        this.mSearchEdit.setCursorVisible(true);
        this.mSearchEdit.setFocusable(true);
        this.mSearchEdit.setFocusableInTouchMode(true);
        this.mSearchEdit.requestFocus();
        startAnimation(this.mBtnSort, this.mBtnCancelSearch);
        this.mIsSearchMode = true;
        return;
    }

    public void cancelSearch() {
        if (this.mIsPlaySearchModeAnimation == false) goto L5;
        return;
    L5:
        if (this.mIsSearchMode == false) goto L9;
        post(new AnonymousClass12(this));
        this.mBtnSort.setEnabled(true);
        TextKeyListener.clear(this.mSearchEdit.getText());
        cancelAnimation(this.mBtnCancelSearch, this.mBtnSort);
        this.mIsSearchMode = false;
        this.mSearchEdit.setFocusable(false);
        this.mSearchEdit.setFocusableInTouchMode(false);
        return;
    }

    public void cancelSearchWithoutAnimation() {
        if (this.mIsPlaySearchModeAnimation == false) goto L5;
        return;
    L5:
        if (this.mIsSearchMode == false) goto L11;
        post(new AnonymousClass13(this));
        this.mSearchViewRight.setTranslationX(0.0f);
        TextKeyListener.clear(this.mSearchEdit.getText());
        this.mBtnCancelSearch.setVisibility(8);
        this.mBtnSort.setEnabled(true);
        this.mBtnSort.setVisibility(0);
        this.mIsSearchMode = false;
        this.mSearchEdit.setFocusable(false);
        this.mSearchEdit.setFocusableInTouchMode(false);
        Listener r2 = this.mListener;
        if (r2 == null) goto L12;
        r2.endContactAnimationWithoutAnimation();
        return;
    L12:
        return;
    }

    private void startAnimation(final View r19, final View r20) {
        this.mListener.onSearchAnimationStart();
        int r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r3 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r19.measure(r2, r3);
        int r5 = r19.getMeasuredWidth();
        r20.measure(r2, r3);
        final int r4 = r20.getMeasuredWidth();
        float r11 = -Math.abs(r4 - r5);
        final ObjectAnimator r6 = ObjectAnimator.ofFloat(this.mSearchViewRight, "translationX", new float[]{0.0f, r11});
        r6.setDuration(this.mDuration);
        r6.addListener(new AnonymousClass14(this));
        AnimationSet r7 = new AnimationSet(true);
        r7.addAnimation(new TranslateAnimation(0, r11, 0, 0.0f, 1, 0.0f, 1, 0.0f));
        r7.setFillAfter(true);
        r7.setDuration(this.mDuration);
        final TranslateAnimation r8 = new TranslateAnimation(r4, 0.0f, 0.0f, 0.0f);
        r8.setInterpolator(this.mDecelerateInterpolator);
        r8.setDuration(this.mDuration);
        r8.setAnimationListener(new AnonymousClass15(this, r20));
        AlphaAnimation r9 = new AlphaAnimation(1.0f, 0.0f);
        r9.setDuration(this.mDuration);
        r9.setAnimationListener(new AnonymousClass16(this, r4, r19, r20, r8, r6));
        r19.startAnimation(r9);
    }

    private void cancelAnimation(final View r17, final View r18) {
        final float r2 = r18.getWidth();
        float r0 = r17.getWidth();
        float r3 = Math.abs(r2 - r0);
        AnimationSet r4 = new AnimationSet(true);
        float r5 = -r3;
        r4.addAnimation(new TranslateAnimation(0, 0.0f, 0, r5, 1, 0.0f, 1, 0.0f));
        r4.setFillAfter(true);
        r4.setDuration(this.mDuration);
        r4.setAnimationListener(new AnonymousClass17(this));
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.mSearchViewRight, "translationX", new float[]{r5, 0.0f});
        r6.setDuration(this.mDuration);
        final AlphaAnimation r7 = new AlphaAnimation(0.0f, 1.0f);
        r7.setDuration(this.mDuration);
        r7.setAnimationListener(new AnonymousClass18(this, r18));
        TranslateAnimation r8 = new TranslateAnimation(0.0f, r0, 0.0f, 0.0f);
        r8.setInterpolator(this.mDecelerateInterpolator);
        r8.setDuration(this.mDuration);
        r8.setAnimationListener(new AnonymousClass19(this, r2, r17, r18, r7));
        r17.startAnimation(r8);
        r6.start();
    }

    private void resetSearchViewParam(int r2) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mSearchView.getLayoutParams();
        r0.rightMargin = r2;
        this.mSearchView.setLayoutParams(r0);
    }

    public void setCursorVisible(boolean r1) {
        this.mSearchEdit.setCursorVisible(r1);
    }

    public boolean isPlayingSearchAnimation() {
        return this.mIsPlaySearchModeAnimation;
    }

    public boolean isInSearchMode() {
        return this.mIsSearchMode;
    }

    public void freezeSearchView(boolean r1) {
        this.mSearchEdit.setEnabled(!r1);
    }
}
