package com.android.contacts;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.location.Country;
import android.location.CountryDetector;
import android.location.CountryListener;
import android.os.Bundle;
import android.os.Looper;
import android.os.StrictMode;
import android.os.UserHandle;
import android.os.UserManager;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.GlobalProxyLancet;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.list.ContactListFilterController;
import com.android.contacts.list.NewContactListFragment;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.obricsync.ObricSyncUtils;
import com.android.contacts.test.InjectedServices;
import com.android.contacts.util.AsyncImageLoader;
import com.android.contacts.util.AvatarImageHelper;
import com.android.contacts.util.BytedanceApi;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ImportantResource;
import com.android.contacts.util.NameSortComparator;
import com.android.contacts.util.SmtPcUtils;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.database.DatabaseHelper;
import com.obric.init.ObricInitHelper;
import com.obric.privacy.PrivacyUtils;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactsAppLaunchEvent;
import com.obric.voice.ASRController;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import obric.app.tracker.Agent;
import obric.util.config.Features;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ContactsApplication extends Application {
    private static Executor CONTACTS_THREAD_POOL_EXECUTOR = null;
    private static final int CORE_POOL_SIZE = 5;
    private static final boolean ENABLE_FRAGMENT_LOG = false;
    private static final boolean ENABLE_LOADER_LOG = false;
    private static final int KEEP_ALIVE = 1;
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final String TAG = "ContactsApplication";
    private static String sCountryIso;
    private static InjectedServices sInjectedServices;
    public static final AtomicBoolean sLaunchReported = null;
    private static ContactsApplication sMe;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = null;
    private static String sSimCountryIso;
    private static final ThreadFactory sThreadFactory = null;
    private static Toast sToast;
    private AccountTypeManager mAccountTypeManager;
    private ContactListFilterController mContactListFilterController;
    private ContactPhotoManager mContactPhotoManager;
    private CountryListener mCountryListener;
    private Configuration mCurrentConfig;
    private AsyncImageLoader masyncImageLoader;

    public ContactsApplication() {
        this.mCountryListener = new AnonymousClass5(this);
    }

    static /* synthetic */ void access$000(ContactsApplication r0) {
        r0.initApplication();
    }

    static /* synthetic */ void access$100(ContactsApplication r0) {
        r0.initObject();
    }

    static /* synthetic */ void access$200(ContactsApplication r0) {
        r0.initResources();
    }

    static /* synthetic */ void access$300(ContactsApplication r0) {
        r0.printVersionCode();
    }

    static /* synthetic */ String access$402(String r0) {
        sCountryIso = r0;
        return r0;
    }

    static {
        sLaunchReported = new AtomicBoolean(false);
        sThreadFactory = new AnonymousClass4();
        sPoolWorkQueue = new LinkedBlockingQueue(10);
    }

    public static void injectServices(InjectedServices r0) {
        sInjectedServices = r0;
    }

    public static InjectedServices getInjectedServices() {
        return sInjectedServices;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        InjectedServices r0 = sInjectedServices;
        if (r0 == null) goto L8;
        ContentResolver r1 = r0.getContentResolver();
        if (r1 == null) goto L8;
        return r1;
    L8:
        return super.getContentResolver();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String r4, int r5) {
        InjectedServices r0 = sInjectedServices;
        if (r0 == null) goto L18;
        SharedPreferences r1 = r0.getSharedPreferences();
        if (r1 == null) goto L18;
        return r1;
    L18:
        return super.getSharedPreferences(r4, r5);
    L9:
        e = move-exception;
        String r2 = e.getMessage();
        if (isUserUnlocked() == true) goto L17;
        if (r2 == null) goto L17;
        if (r2.contains("credential encrypted storage") == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "SharedPreferences in CE storage are unavailable before unlock, fallback to DE: " + r4);
        return createDeviceProtectedStorageContext().getSharedPreferences(r4, r5);
    L17:
        throw e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r2) {
        InjectedServices r0 = sInjectedServices;
        if (r0 == null) goto L8;
        Object r1 = r0.getSystemService(r2);
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (AccountTypeManager.ACCOUNT_TYPE_SERVICE.equals(r2) == false) goto L15;
        if (this.mAccountTypeManager != null) goto L13;
        this.mAccountTypeManager = AccountTypeManager.getInstance(this);
    L13:
        return this.mAccountTypeManager;
    L15:
        if (ContactPhotoManager.CONTACT_PHOTO_SERVICE.equals(r2) == false) goto L22;
        if (this.mContactPhotoManager != null) goto L20;
        ContactPhotoManager r3 = ContactPhotoManager.getInstance(this);
        this.mContactPhotoManager = r3;
        registerComponentCallbacks(r3);
        this.mContactPhotoManager.preloadPhotosInBackground();
    L20:
        return this.mContactPhotoManager;
    L22:
        if (ContactListFilterController.CONTACT_LIST_FILTER_SERVICE.equals(r2) == false) goto L29;
        if (this.mContactListFilterController != null) goto L27;
        this.mContactListFilterController = ContactListFilterController.createContactListFilterController(this);
    L27:
        return this.mContactListFilterController;
    L29:
        return super.getSystemService(r2);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        ObricInitHelper.initOLog(r1);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        sMe = this;
        boolean r0 = PrivacyUtils.hasBasePermissionAndAgree(this);
        ASRController.INSTANCE.checkSettings();
        if (r0 == true) goto L6;
        PrivacyUtils.INSTANCE.setApplicationInitCallback(new AnonymousClass1(this));
        return;
    L6:
        initApplication();
    }

    private void initApplication() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "initApplication start");
        initTrackerAgent();
        if (Log.isLoggable("ContactsPerf", 3) == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ContactsPerf", "ContactsApplication.onCreate start");
    L5:
        initBytedanceOSFeatures();
        if (Log.isLoggable(Constants.STRICT_MODE_TAG, 3) == false) goto L8;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
    L8:
        initObjectInThread();
        if (Log.isLoggable("ContactsPerf", 3) == false) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ContactsPerf", "ContactsApplication.onCreate finish");
    L11:
        ContactsTelephonyUtilImpl.init(this);
        ObricInitHelper.INSTANCE.init(this);
        AtomicCapabilitySdk.init(new AtomicCapabilitySdk.InitConfig(this, null, "", null));
        if (ContactsProcessUtils.isMainProcess(Application.getProcessName(), getPackageName()) == false) goto L14;
        ObricSyncUtils.init(this);
    L14:
        DatabaseHelper.init(this);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "initApplication finished");
    }

    private void initTrackerAgent() {
        Agent r0 = Agent.getInstance();
        r0.init(this);
        boolean r3 = ContactsUtils.contactsWithPhoneOnly(this);
        JSONObject r1 = new JSONObject();
        r1.put("value", r3);     // Catch: JSONException -> L5
    L15:
        Agent.getInstance().onLaunch();     // Catch: Exception -> L9
    L11:
        r0.onStatusDataChanged("ContactsSettingActivity", Constants.ContactsTracker.STATUS_HIDE_EMAIL_CONTACTS, r1.toString());
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static ContactsApplication getInstance() {
        return sMe;
    }

    public static void reportLaunchEnd(String r3) {
        if (sLaunchReported.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        ContactsAppLaunchEvent r0 = DialtactsActivity.sLaunchEvent;
        if (r0 == null) goto L9;
        EventTrackerManager.INSTANCE.endTrack(r0.copy(r3, r0.getEventId()));
        DialtactsActivity.sLaunchEvent = null;
        return;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r3) {
        if (ContactsUtils.isBytedanceFeatureVersion_2_2_0_Enabled() == false) goto L6;
        NameSortComparator.updateCollator();
    L6:
        if (BytedanceApi.isSameCustomTheme(this.mCurrentConfig, r3) == false) goto L8;
    L13:
        Configuration r0 = this.mCurrentConfig;
        if (r0 != null) goto L16;
    L17:
        ImportantResource.getInstance(this).clear();
    L18:
        this.mCurrentConfig = new Configuration(r3);
        if (DSUtils.isMultiSimEnabled() == false) goto L22;
        DSUtils.asyncUpdateOperatorNames(500);
        return;
    L22:
        return;
    L16:
        if (r0.locale.equals(r3.locale) == true) goto L18;
    L8:
        if (this.masyncImageLoader == null) goto L13;
        if (this.mContactPhotoManager != null) goto L12;
        this.mContactPhotoManager = ContactPhotoManager.getInstance(this);
    L12:
        AvatarImageHelper.reInitRoundBG(this);
        this.masyncImageLoader.clearImageCache();
        this.mContactPhotoManager.refreshCache();
        goto L13
    }

    private void initBytedanceOSFeatures() {
        ContactsUtils.FEATURE_CMCC = Features.isFeatureCMCCEnabled(this).booleanValue();
        ContactsUtils.FEATURE_CU = Features.isFeatureCUEnabled(this).booleanValue();
        if (ContactsUtils.FEATURE_CMCC == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        ContactsUtils.FEATURE_SIM_PHONEBOOK = r1;
        return;
    L5:
        if (ContactsUtils.FEATURE_CT == true) goto L10;
        if (ContactsUtils.FEATURE_CU == true) goto L10;
        r1 = false;
        goto L11
    }

    private void initObjectInThread() {
        Thread r0 = new Thread(new AnonymousClass2(this), "initObjectInThread");
        r0.setPriority(10);
        r0.start();
        new Thread(new AnonymousClass3(this), "initResourcesThread").start();
    }

    private void initObject() {
        Context r0 = getApplicationContext();
        this.masyncImageLoader = AsyncImageLoader.getInstances(r0);
        this.mCurrentConfig = new Configuration(getResources().getConfiguration());
        NumberInfosManager.getInstance();
        int r1 = getTabIndex();
        if (r1 != 0) goto L5;
        ImportantResource.getInstance(r0).needPreLoadResource();
        NewContactListFragment.preload(getApplicationContext());
        return;
    L5:
        if (r1 != 1) goto L11;
        NewContactListFragment.preload(getApplicationContext());
        return;
    }

    private void initResources() {
        Context r0 = getApplicationContext();
        AvatarImageHelper.init(r0);
        AccountTypeManager.getInstance(r0);
    }

    public static synchronized Executor getThreadPoolExecutor() {
        monitor-enter(ContactsApplication.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (CONTACTS_THREAD_POOL_EXECUTOR != null) goto L7;
        CONTACTS_THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);     // Catch: Throwable -> L10
    L7:
        Executor r1 = CONTACTS_THREAD_POOL_EXECUTOR;     // Catch: Throwable -> L10
        monitor-exit(ContactsApplication.class);
        return r1;
    }

    private boolean isUserUnlocked() {
        UserManager r1 = (UserManager) super.getSystemService("user");
        if (r1 != null) goto L5;
    L8:
        return true;
    L5:
        if (r1.isUserUnlocked() == true) goto L8;
        return false;
    }

    private int getTabIndex() {
        if (isUserUnlocked() == true) goto L6;
        return 0;
    L6:
        return PreferenceManager.getDefaultSharedPreferences(this).getInt(DialtactsActivity.LAST_TAB_INDEX, 0);
    }

    public static void showToast(CharSequence r1, int r2) {
        Toast r0 = sToast;
        if (r0 == null) goto L5;
        r0.cancel();
        sToast = null;
    L5:
        Context r3 = SmtPcUtils.getFocusedDisplayContext(sMe);
        if (r3 != null) goto L8;
        return;
    L8:
        Toast r4 = Toast.makeText(r3, r1, r2);
        sToast = r4;
        r4.show();
    }

    public static void showToast(int r1, int r2) {
        showToast(sMe.getString(r1), r2);
    }

    public synchronized void initCountryIso() {
        monitor-enter(this);
        String r0 = ((TelephonyManager) getApplicationContext().getSystemService("phone")).getSimCountryIso();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r0) == true) goto L8;
        String r1 = r0.toUpperCase(Locale.US);     // Catch: Throwable -> L19
        sSimCountryIso = r1;     // Catch: Throwable -> L19
        sCountryIso = r1;     // Catch: Throwable -> L19
        ((CountryDetector) sMe.getSystemService("country_detector")).removeCountryListener(this.mCountryListener);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L8:
        CountryDetector r2 = (CountryDetector) sMe.getSystemService("country_detector");     // Catch: Throwable -> L19
        if (r2 == null) goto L11;
        Country r3 = r2.detectCountry();     // Catch: Throwable -> L19
    L12:
        if (r3 != null) goto L16;
        sCountryIso = Locale.getDefault().getCountry();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L16:
        sCountryIso = r3.getCountryIso();     // Catch: Throwable -> L19
        r2.addCountryListener(this.mCountryListener, Looper.getMainLooper());     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L11:
        r3 = null;
    L19:
        th = move-exception;
        throw th;
    }

    public static String getCountryIso() {
        if (sCountryIso != null) goto L6;
        sMe.initCountryIso();
    L6:
        return sCountryIso;
    }

    public static synchronized String getSimCountryIso() {
        monitor-enter(ContactsApplication.class);
        String r1 = sSimCountryIso;     // Catch: Throwable -> L7
        monitor-exit(ContactsApplication.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r2) {
        if (shouldInterceptActivity(r2) == false) goto L5;
        return;
    L5:
        super.startActivity(r2);
    }

    public void startActivityAsUser(Intent r2, UserHandle r3) {
        if (shouldInterceptActivity(r2) == false) goto L5;
        return;
    L5:
        super.startActivityAsUser(r2, r3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r2, Bundle r3) {
        if (shouldInterceptActivity(r2) == false) goto L5;
        return;
    L5:
        super.startActivity(r2, r3);
    }

    public void startActivityAsUser(Intent r2, Bundle r3, UserHandle r4) {
        if (shouldInterceptActivity(r2) == false) goto L5;
        return;
    L5:
        super.startActivityAsUser(r2, r3, r4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (shouldInterceptActivity(r4[r1]) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return;
    L8:
        super.startActivities(r4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r4, Bundle r5) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (shouldInterceptActivity(r4[r1]) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return;
    L8:
        super.startActivities(r4, r5);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r2, Intent r3, int r4, int r5, int r6) throws IntentSender.SendIntentException {
        if (shouldInterceptActivity(r3) == false) goto L5;
        return;
    L5:
        super.startIntentSender(r2, r3, r4, r5, r6);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r2, Intent r3, int r4, int r5, int r6, Bundle r7) throws IntentSender.SendIntentException {
        if (shouldInterceptActivity(r3) == false) goto L5;
        return;
    L5:
        super.startIntentSender(r2, r3, r4, r5, r6, r7);
    }

    private boolean shouldInterceptActivity(Intent r4) {
        boolean r1 = false;
        if (PrivacyUtils.isPrivacyPermissionIntent(r4) == false) goto L6;
        return false;
    L6:
        if (ContactsUtils.isFeaturePhoneMode() == false) goto L8;
        r1 = !ContactsUtils.inPowerSaveWhiteList(this, r4);
    L8:
        if (r1 == false) goto L10;
        showToast(ContactsUtils.getFeaturePhoneModeHintId(), 1);
    L10:
        return r1;
    }

    private void printVersionCode() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ContactsPerf", "Version code upgrade to " + getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0).versionCode);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public ContactsTelephonyUtil getTelephonyUtil() {
        return ContactsTelephonyUtilImpl.getInstance();
    }

    @Override // android.app.Application
    public void onTerminate() {
        ObricInitHelper r0 = ObricInitHelper.INSTANCE;
        ObricInitHelper.unregisterScreenReceiver(this);
        super.onTerminate();
    }
}
