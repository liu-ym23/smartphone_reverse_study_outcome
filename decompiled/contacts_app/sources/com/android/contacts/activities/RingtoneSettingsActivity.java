package com.android.contacts.activities;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import bytedanceos.api.VibratorSmt;
import bytedanceos.util.SettingsUtil;
import com.GlobalProxyLancet;
import com.android.common.io.MoreCloseables;
import com.android.contacts.BaseActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.util.LocalRingtonePlayer;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.ui.OUIHelper;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.NavigationBarHelper;

/* JADX INFO: loaded from: classes.dex */
public class RingtoneSettingsActivity extends BaseActivity implements Runnable, View.OnClickListener {
    private static final int COLUMN_ARTIST = 2;
    private static final int COLUMN_ID = 0;
    private static final int COLUMN_TITLE = 1;
    public static final String DEFAULT_URI_FROM_RINGTONEMANAGER = "content://settings/system/ringtone";
    private static final String[] EXTERNAL_RINGTONE_COLUMN = null;
    public static final String EXTRA_TYPE = "ringtone_type";
    private static final String[] INTERNAL_RINGTONE_COLUMN = null;
    private static final int REQUEST_CODE_PICK_PHONE_RINGTONE = 1;
    private static final String SAVE_CLICKED_POS = "clicked_pos";
    private static final String TAG = "RingtoneSettingsActivity";
    private static Uri mDefaultUri;
    private boolean DEBUG;
    private RingtoneAdapter mAdapter;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusListener;
    private AudioManager mAudioManager;
    private int mClickedPos;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    private Uri mCurrentUri;
    private OCardListItem mCustomRingtoneMusic;
    private int mDefaultPos;
    private ArrayList<Ringtone> mExternalRingtones;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private boolean mIncludeDrm;
    private ArrayList<Ringtone> mInternalRingtones;
    private ListView mListView;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private LocalRingtonePlayer mPlayer;
    private RingtoneManager mRingtoneManager;
    private Vibrator mVibrator;

    class Ringtone {
        private String artist;
        private String data;
        private String displayName;
        private int id;
        private boolean isSelected;
        final /* synthetic */ RingtoneSettingsActivity this$0;
        private String title;
        private Uri uri;

        Ringtone(RingtoneSettingsActivity r1) {
            this.this$0 = r1;
        }

        public boolean isSelected() {
            return this.isSelected;
        }

        public void setSelected(boolean r1) {
            this.isSelected = r1;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int r1) {
            this.id = r1;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String r1) {
            this.displayName = r1;
        }

        public String getData() {
            return this.data;
        }

        public void setData(String r1) {
            this.data = r1;
        }

        public Uri getUri() {
            return this.uri;
        }

        public void setUri(Uri r1) {
            this.uri = r1;
        }

        public String getArtist() {
            return this.artist;
        }

        public void setArtist(String r1) {
            this.artist = r1;
        }
    }

    class RingtoneAdapter extends BaseAdapter {
        private Context mContext;
        final /* synthetic */ RingtoneSettingsActivity this$0;

        class ViewHolder {
            OCardListItem ringtoneSettingsItem;
            final /* synthetic */ RingtoneAdapter this$1;

            ViewHolder(RingtoneAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return 0;
        }

        public RingtoneAdapter(RingtoneSettingsActivity r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return RingtoneSettingsActivity.access$300(this.this$0).size() + RingtoneSettingsActivity.access$400(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(final int r7, View r8, ViewGroup r9) {
            boolean r0 = false;
            if (r8 != null) goto L5;
            r8 = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.ringtone_settings_item_layout, r9, false);
            ViewHolder r10 = new ViewHolder(this);
            r10.ringtoneSettingsItem = (OCardListItem) r8.findViewById(R.id.ringtone_settings_item);
            r8.setTag(r10);
        L6:
            int r2 = 3;
            if (r7 >= RingtoneSettingsActivity.access$400(this.this$0).size()) goto L16;
            Ringtone r1 = (Ringtone) RingtoneSettingsActivity.access$400(this.this$0).get(r7);
            if (RingtoneSettingsActivity.access$400(this.this$0).size() != 1) goto L12;
        L18:
            r2 = 0;
        L26:
            r10.ringtoneSettingsItem.setTitle(r1.getTitle());
            r10.ringtoneSettingsItem.setOnContentClickListener(new AnonymousClass1(this, r7));
            OCardListItem r3 = r10.ringtoneSettingsItem;
            if (RingtoneSettingsActivity.access$500(this.this$0) != r7) goto L29;
            r0 = true;
        L29:
            r3.showCustomEnd(r0);
            r10.ringtoneSettingsItem.setCardPosition(r2);
            return r8;
        L12:
            if (r7 == (RingtoneSettingsActivity.access$400(this.this$0).size() - 1)) goto L26;
            if (r7 == 0) goto L24;
        L25:
            r2 = 2;
        L24:
            r2 = 1;
            goto L26
        L16:
            r1 = (Ringtone) RingtoneSettingsActivity.access$300(this.this$0).get(r7 - RingtoneSettingsActivity.access$400(this.this$0).size());
            if (RingtoneSettingsActivity.access$300(this.this$0).size() == 1) goto L18;
            if (r7 == (getCount() - 1)) goto L26;
            if (r7 != RingtoneSettingsActivity.access$400(this.this$0).size()) goto L25;
        L5:
            r10 = (ViewHolder) r8.getTag();
            goto L6
        }
    }

    public void com_android_contacts_activities_RingtoneSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_RingtoneSettingsActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_contacts_activities_RingtoneSettingsActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_contacts_activities_RingtoneSettingsActivity_com_obric_privacyhook_PrivacyHook_onPause(this);
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_activities_RingtoneSettingsActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_RingtoneSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public RingtoneSettingsActivity() {
        this.DEBUG = ContactsUtils.DEBUG;
        this.mInternalRingtones = new ArrayList();
        this.mExternalRingtones = new ArrayList();
        this.mDefaultPos = 0;
        this.mClickedPos = -1;
        this.mCompletionListener = new AnonymousClass1(this);
        this.mOnItemClickListener = new AnonymousClass3(this);
        this.mAudioFocusListener = new AnonymousClass4(this);
    }

    static /* synthetic */ AudioManager.OnAudioFocusChangeListener access$000(RingtoneSettingsActivity r0) {
        return r0.mAudioFocusListener;
    }

    static /* synthetic */ AudioManager access$100(RingtoneSettingsActivity r0) {
        return r0.mAudioManager;
    }

    static /* synthetic */ Handler access$1000(RingtoneSettingsActivity r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$200(RingtoneSettingsActivity r0) {
        r0.stopAnyPlayingRingtone();
    }

    static /* synthetic */ ArrayList access$300(RingtoneSettingsActivity r0) {
        return r0.mInternalRingtones;
    }

    static /* synthetic */ ArrayList access$400(RingtoneSettingsActivity r0) {
        return r0.mExternalRingtones;
    }

    static /* synthetic */ int access$500(RingtoneSettingsActivity r0) {
        return r0.mClickedPos;
    }

    static /* synthetic */ int access$502(RingtoneSettingsActivity r0, int r1) {
        r0.mClickedPos = r1;
        return r1;
    }

    static /* synthetic */ Uri access$602(RingtoneSettingsActivity r0, Uri r1) {
        r0.mCurrentUri = r1;
        return r1;
    }

    static /* synthetic */ Uri access$700(RingtoneSettingsActivity r0, int r1) {
        return r0.getUri(r1);
    }

    static /* synthetic */ RingtoneAdapter access$800(RingtoneSettingsActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ LocalRingtonePlayer access$900(RingtoneSettingsActivity r0) {
        return r0.mPlayer;
    }

    static {
        INTERNAL_RINGTONE_COLUMN = new String[]{"_id", "title", "artist"};
        EXTERNAL_RINGTONE_COLUMN = new String[]{"_id", "title"};
    }

    public void com_android_contacts_activities_RingtoneSettingsActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        HandlerThread r0 = new HandlerThread("playRingtone");
        this.mHandlerThread = r0;
        r0.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        Intent r1 = getIntent();
        setContentView(R.layout.ringtone_settings_layout);
        UiUtils.setWindowColorStatusBar(this);
        this.mCurrentUri = (Uri) getIntent().getParcelableExtra("android.intent.extra.ringtone.EXISTING_URI");
        this.mIncludeDrm = r1.getBooleanExtra("android.intent.extra.ringtone.INCLUDE_DRM", true);
        this.mAudioManager = (AudioManager) getSystemService("audio");
        this.mVibrator = (Vibrator) getSystemService("vibrator");
        mDefaultUri = RingtoneManager.getActualDefaultRingtoneUri(this, 1);
        Uri r2 = this.mCurrentUri;
        if (r2 != null) goto L5;
    L7:
        updateInternalRingtones();
        if (r4 == null) goto L10;
        this.mClickedPos = r4.getInt(SAVE_CLICKED_POS, -1);
    L10:
        new OFloatingTitleBarHolder((OFloatingTitleBar) findViewById(R.id.otitlebar)).addStartAction(PickerFragment.STATE_BACK, R.drawable.icon_back_22_22, new AnonymousClass2(this));
        ListView r5 = (ListView) findViewById(android.R.id.list);
        this.mListView = r5;
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(r5);
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        RingtoneAdapter r6 = new RingtoneAdapter(this, this);
        this.mAdapter = r6;
        this.mListView.setAdapter(r6);
        addHeaderFooter();
        OUIHelper.OUIList.setHeader(getLayoutInflater(), this.mListView, Integer.valueOf(OUIHelper.OUIList.getHeaderHeight112()));
        return;
    L5:
        if (DEFAULT_URI_FROM_RINGTONEMANAGER.equals(r2.toString()) == false) goto L7;
        this.mCurrentUri = mDefaultUri;
        goto L7
    }

    public void com_android_contacts_activities_RingtoneSettingsActivity__onResume$___twin___() {
        super.onResume();
        RingtoneManager r0 = new RingtoneManager(this);
        this.mRingtoneManager = r0;
        r0.setIncludeDrm(this.mIncludeDrm);
        this.mRingtoneManager.setType(1);
        setVolumeControlStream(this.mRingtoneManager.inferStreamType());
        updateExternalRingtones();
        if (this.mCurrentUri == null) goto L5;
        checkExistingUri();
    L5:
        Uri r1 = this.mCurrentUri;
        if (r1 != null) goto L8;
        this.mClickedPos = this.mDefaultPos;
    L9:
        this.mAdapter.notifyDataSetChanged();
        return;
    L8:
        this.mClickedPos = getListPosition(r1);
        goto L9
    }

    public void com_android_contacts_activities_RingtoneSettingsActivity__onDestroy$___twin___() {
        super.onDestroy();
        this.mHandlerThread.quit();
    }

    private void checkExistingUri() {
        Cursor r0 = getContentResolver().query(this.mCurrentUri, null, null, null, null);     // Catch: SQLiteException -> L13
        if (r0 != null) goto L5;
    L6:
        Uri r1 = mDefaultUri;     // Catch: SQLiteException -> L13
        if (r1 != null) goto L9;
        r1 = null;
    L9:
        this.mCurrentUri = r1;     // Catch: SQLiteException -> L13
    L10:
        if (r0 == null) goto L16;
        r0.close();     // Catch: SQLiteException -> L13
        return;
    L16:
        return;
    L5:
        if (r0.moveToFirst() == true) goto L10;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mClickedPos >= this.mExternalRingtones.size()) goto L5;
        Uri r0 = this.mExternalRingtones.get(this.mClickedPos).getUri();
    L6:
        LocalRingtonePlayer r1 = this.mPlayer;
        if (r1 != null) goto L9;
        LocalRingtonePlayer r2 = new LocalRingtonePlayer(this, r0);
        this.mPlayer = r2;
        r2.setCompletionListener(this.mCompletionListener);
        this.mPlayer.setStreamType(this.mRingtoneManager.inferStreamType());
    L10:
        if (r0 == null) goto L13;
        playRingtone();
    L13:
        if (Settings.Global.getInt(getContentResolver(), "telephony_vibration_enabled", 1) != 1) goto L18;
        int r3 = SettingsUtil.getRingtoneEffectId(this, r0);
        if (r3 == (-1)) goto L19;
        VibratorSmt.vibrateEffect(this.mVibrator, r3);
        return;
    L19:
        return;
    L18:
        return;
    L9:
        r1.setUri(r0);
        goto L10
    L5:
        r0 = this.mInternalRingtones.get(this.mClickedPos - this.mExternalRingtones.size()).getUri();
        goto L6
    }

    private void playRingtone() {
        this.mAudioManager.requestAudioFocus(this.mAudioFocusListener, 1, 2);
        LocalRingtonePlayer r4 = this.mPlayer;
        if (r4 == null) goto L6;
        r4.play();
        return;
    }

    private void stopAnyPlayingRingtone() {
        this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
        LocalRingtonePlayer r0 = this.mPlayer;
        if (r0 == null) goto L6;
        r0.stop();
        this.mVibrator.cancel();
        return;
    }

    private void addDefaultItem() {
        Ringtone r0 = new Ringtone(this);
        r0.setUri(RingtoneManager.getActualDefaultRingtoneUri(this, 1));
        r0.setTitle(getString(R.string.default_ringtone));
        this.mInternalRingtones.add(0, r0);
    }

    private void addHeaderFooter() {
        if (this.mListView.getFooterViewsCount() != 0) goto L6;
        View r0 = getLayoutInflater().inflate(R.layout.ringtone_settings_custom_item_layout, null, false);
        OCardListItem r1 = (OCardListItem) r0.findViewById(R.id.ringtone_settings_item);
        this.mCustomRingtoneMusic = r1;
        r1.setCardType(2);
        this.mCustomRingtoneMusic.setCardPosition(0);
        this.mCustomRingtoneMusic.setCustomStartView(R.layout.ringtone_settings_custom_button);
        this.mCustomRingtoneMusic.setOnContentClickListener(new AnonymousClass5(this));
        this.mListView.addFooterView(r0);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 != this.mCustomRingtoneMusic) goto L6;
        return;
    L6:
        if (r3.getId() != R.id.left_icon) goto L20;
        Ringtone r4 = (Ringtone) r3.getTag();
        this.mDefaultPos--;
        int r0 = getListPosition(r4.getUri());
        int r1 = this.mClickedPos;
        if (r1 <= r0) goto L10;
        this.mClickedPos = r1 - 1;
    L18:
        this.mExternalRingtones.remove(r4);
        this.mAdapter.notifyDataSetInvalidated();
        return;
    L10:
        if (r1 != r0) goto L18;
        stopAnyPlayingRingtone();
        this.mClickedPos = getListPosition(mDefaultUri) - 1;
        if (mDefaultUri != null) goto L14;
        this.mClickedPos = this.mExternalRingtones.size() - 1;
    L14:
        this.mCurrentUri = mDefaultUri;
        Intent r2 = new Intent();
        Uri r5 = mDefaultUri;
        if (r5 != null) goto L17;
        r5 = null;
    L17:
        setResult(-1, r2.setData(r5));
        goto L18
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r3 != (-1)) goto L11;
        if (r4 != null) goto L6;
        return;
    L6:
        if (r2 != 1) goto L8;
        this.mCurrentUri = r4.getData();
    L9:
        setResult(-1, new Intent().setData(this.mCurrentUri));
        return;
    L8:
        this.mCurrentUri = (Uri) r4.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
        goto L9
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putInt(SAVE_CLICKED_POS, this.mClickedPos);
    }

    private int getListPosition(Uri r6) {
        if (r6 == null) goto L4;
        int r0 = 0;
        int r1 = 0;
    L7:
        if (r1 >= this.mInternalRingtones.size()) goto L14;
        if (r6.equals(this.mInternalRingtones.get(r1).getUri()) == true) goto L11;
        r1 = r1 + 1;
        goto L7
    L11:
        return this.mExternalRingtones.size() + r1;
    L14:
        if (r0 >= this.mExternalRingtones.size()) goto L19;
        if (ContentUris.parseId(r6) == this.mExternalRingtones.get(r0).getId()) goto L17;
        r0 = r0 + 1;
        goto L14
    L17:
        return r0;
    L19:
        return -1;
    L4:
        return this.mListView.getHeaderViewsCount();
    }

    private Uri getUri(int r3) {
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        if (r3 >= this.mExternalRingtones.size()) goto L10;
        return this.mExternalRingtones.get(r3).getUri();
    L10:
        if (r3 != this.mExternalRingtones.size()) goto L13;
        return null;
    L13:
        return this.mInternalRingtones.get(r3 - this.mExternalRingtones.size()).getUri();
    }

    public void com_android_contacts_activities_RingtoneSettingsActivity__onPause$___twin___() {
        super.onPause();
        stopAnyPlayingRingtone();
    }

    private void updateInternalRingtones() {
        this.mInternalRingtones.clear();
        this.mExternalRingtones.clear();
        Cursor r0 = null;
        r0 = getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, INTERNAL_RINGTONE_COLUMN, "is_ringtone = 1", null, "title_key");     // Catch: Throwable -> L15 Exception -> L17
    L4:
        if (r0 == null) goto L18;
        if (r0.moveToNext() == false) goto L18;
        Ringtone r1 = new Ringtone(this);     // Catch: Throwable -> L15 Exception -> L17
        int r2 = r0.getInt(0);     // Catch: Throwable -> L15 Exception -> L17
        r1.setId(r2);     // Catch: Throwable -> L15 Exception -> L17
        String r3 = r0.getString(1);     // Catch: Throwable -> L15 Exception -> L17
        String r4 = r0.getString(2);     // Catch: Throwable -> L15 Exception -> L17
        Configuration r5 = ContactsUtils.getConfiguration(getApplicationContext());     // Catch: Throwable -> L15 Exception -> L17
        if (r5.locale.toString().equals(Locale.TRADITIONAL_CHINESE.toString()) == false) goto L11;
        r3 = getTwTitle(r3);     // Catch: Throwable -> L15 Exception -> L17
        r4 = getTwArtist(r4);     // Catch: Throwable -> L15 Exception -> L17
    L13:
        r1.setTitle(r3);     // Catch: Throwable -> L15 Exception -> L17
        r1.setArtist(r4);     // Catch: Throwable -> L15 Exception -> L17
        r1.setUri(ContentUris.withAppendedId(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, r2));     // Catch: Throwable -> L15 Exception -> L17
        this.mInternalRingtones.add(r1);     // Catch: Throwable -> L15 Exception -> L17
        goto L4
    L11:
        if (r5.locale.toString().equals(Locale.SIMPLIFIED_CHINESE.toString()) == true) goto L13;
        r3 = getEnTitle(r3);     // Catch: Throwable -> L15 Exception -> L17
        r4 = getEnArtist(r4);     // Catch: Throwable -> L15 Exception -> L17
        goto L13
    L18:
        MoreCloseables.closeQuietly(r0);
        addDefaultItem();
        return;
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed to query internal ring tone list.");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        MoreCloseables.closeQuietly(r0);
        throw th;
    }

    private void updateExternalRingtones() {
        this.mExternalRingtones.clear();
        Uri r0 = this.mCurrentUri;
        if (r0 != null) goto L5;
    L21:
        this.mDefaultPos = this.mExternalRingtones.size();
        return;
    L5:
        if (r0.equals(mDefaultUri) == true) goto L21;
        if (this.mCurrentUri.toString().startsWith(MediaStore.Files.getContentUri("external").toString()) == false) goto L21;
        Cursor r1 = null;
        r1 = getContentResolver().query(this.mCurrentUri, EXTERNAL_RINGTONE_COLUMN, null, null, null);     // Catch: Throwable -> L15 Exception -> L17
    L10:
        if (r1 == null) goto L18;
        if (r1.moveToNext() == false) goto L18;
        Ringtone r2 = new Ringtone(this);     // Catch: Throwable -> L15 Exception -> L17
        int r3 = r1.getInt(0);     // Catch: Throwable -> L15 Exception -> L17
        r2.setId(r3);     // Catch: Throwable -> L15 Exception -> L17
        r2.setTitle(r1.getString(1));     // Catch: Throwable -> L15 Exception -> L17
        r2.setUri(ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), r3));     // Catch: Throwable -> L15 Exception -> L17
        this.mExternalRingtones.add(r2);     // Catch: Throwable -> L15 Exception -> L17
    L18:
        MoreCloseables.closeQuietly(r1);
    L15:
        th = move-exception;
        MoreCloseables.closeQuietly(r1);
        throw th;
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed to query external ring tone list.");     // Catch: Throwable -> L15
        goto L18
    }

    private String getEnTitle(String r4) {
        String[] r0 = getResources().getStringArray(R.array.internal_ringtone_title);
        String[] r3 = getResources().getStringArray(R.array.internal_ringtone_title_en);
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L10;
        if (r0[r1].equals(r4) == true) goto L8;
        r1 = r1 + 1;
        goto L4
    L8:
        return r3[r1];
    L10:
        return r4;
    }

    private String getEnArtist(String r4) {
        String[] r0 = getResources().getStringArray(R.array.internal_ringtone_author);
        String[] r3 = getResources().getStringArray(R.array.internal_ringtone_author_en);
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L10;
        if (r0[r1].equals(r4) == true) goto L8;
        r1 = r1 + 1;
        goto L4
    L8:
        return r3[r1];
    L10:
        return r4;
    }

    private String getTwTitle(String r4) {
        String[] r0 = getResources().getStringArray(R.array.internal_ringtone_title);
        String[] r3 = getResources().getStringArray(R.array.internal_ringtone_title_tw);
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L10;
        if (r0[r1].equals(r4) == true) goto L8;
        r1 = r1 + 1;
        goto L4
    L8:
        return r3[r1];
    L10:
        return r4;
    }

    private String getTwArtist(String r4) {
        String[] r0 = getResources().getStringArray(R.array.internal_ringtone_author);
        String[] r3 = getResources().getStringArray(R.array.internal_ringtone_author_tw);
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L10;
        if (r0[r1].equals(r4) == true) goto L8;
        r1 = r1 + 1;
        goto L4
    L8:
        return r3[r1];
    L10:
        return r4;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_RingtoneSettingsActivity_com_obric_privacyhook_PrivacyHook_onCreate(RingtoneSettingsActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        RingtoneSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_RingtoneSettingsActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_RingtoneSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RingtoneSettingsActivity r1) {
        com_android_contacts_activities_RingtoneSettingsActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_activities_RingtoneSettingsActivity_com_obric_privacyhook_PrivacyHook_onResume(RingtoneSettingsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        RingtoneSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_activities_RingtoneSettingsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public static void com_android_contacts_activities_RingtoneSettingsActivity_com_obric_privacyhook_PrivacyHook_onPause(RingtoneSettingsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        RingtoneSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r2.com_android_contacts_activities_RingtoneSettingsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_RingtoneSettingsActivity_com_obric_privacyhook_PrivacyHook_onStop(RingtoneSettingsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        RingtoneSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_RingtoneSettingsActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_android_contacts_activities_RingtoneSettingsActivity_com_obric_privacyhook_PrivacyHook_onDestroy(RingtoneSettingsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        RingtoneSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_android_contacts_activities_RingtoneSettingsActivity__onDestroy$___twin___();
    }
}
