package os.teatracker;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class TeaHandler extends c implements IBdInstall.a {
    private static final String TAG = "EventHandler";
    private static final Object g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile e f40676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f40677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Class f40678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WorkHandler f40679e;
    private final List<WeakReference<d.b>> f;
    private d.a h;
    private b i;
    private ContentObserver j;
    private String k;
    private String l;
    private String m;
    private Boolean n;

    private static class WorkHandler extends Handler {
        private static final int MAX_CACHE_SIZE = 100;
        private final TeaServiceProxy.a mCallback;
        private volatile Context mContext;
        private List<g> mEventsCache;
        private Map<String, Object> mGlobalParams;
        private final AtomicBoolean mInitDone;
        private final List<g> mSysEventsCache;
        private TeaServiceProxy mTeaServiceProxy;

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.i(r0, r1);
        }

        WorkHandler(Looper r2) {
            super(r2);
            this.mEventsCache = new ArrayList();
            this.mSysEventsCache = new ArrayList();
            this.mInitDone = new AtomicBoolean(false);
            TeaServiceProxy.a r3 = new AnonymousClass1(this);
            this.mCallback = r3;
            TeaServiceProxy r0 = TeaServiceProxy.getTeaServiceProxy(this);
            this.mTeaServiceProxy = r0;
            r0.setBindCallback(r3);
        }

        public void setContext(Context r3) {
            this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            switch(r3.what) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L19;
            };
        L5:
            onEvent((g) ZeusTransformUtils.preCheckCast(r3.obj, g.class, "com.obric.aiagent.plugin"), true);
            return;
        L6:
            setPrivacyPolicyConfirmed(((Boolean) ZeusTransformUtils.preCheckCast(r3.obj, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return;
        L7:
            setAbSdkVersion((String) ZeusTransformUtils.preCheckCast(r3.obj, String.class, "com.obric.aiagent.plugin"));
            return;
        L8:
            onQuit();
            return;
        L9:
            onTeaServiceConnected();
            return;
        L10:
            onEvent((g) ZeusTransformUtils.preCheckCast(r3.obj, g.class, "com.obric.aiagent.plugin"), false);
            return;
        L11:
            onInit((Map) ZeusTransformUtils.preCheckCast(r3.obj, Map.class, "com.obric.aiagent.plugin"));
            return;
        }

        private void setAbSdkVersion(String r2) {
            if (this.mInitDone.get() == true) goto L7;
            INVOKESTATIC_os_teatracker_TeaHandler$WorkHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(e.f40691b, "setAbSdkVersion before init");
            return;
        L7:
            if (this.mTeaServiceProxy.isTeaServiceConnected() == false) goto L10;
            this.mTeaServiceProxy.setAbSdkVersion(r2);
            return;
        }

        private void setPrivacyPolicyConfirmed(boolean r2) {
            if (this.mInitDone.get() == true) goto L7;
            INVOKESTATIC_os_teatracker_TeaHandler$WorkHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(e.f40691b, "setPrivacyPolicyConfirmed before init");
            return;
        L7:
            if (this.mTeaServiceProxy.isTeaServiceConnected() == false) goto L10;
            this.mTeaServiceProxy.setPrivacyPolicyConfirmed(r2);
            return;
        }

        private void onInit(Map<String, Object> r3) {
            Map<String, Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            INVOKESTATIC_os_teatracker_TeaHandler$WorkHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(e.f40691b, "TeaHandler onInit...");
            if (h.a(this.mContext) == true) goto L5;
        L7:
            this.mGlobalParams = r4;
            this.mInitDone.set(true);
            return;
        L5:
            if (this.mTeaServiceProxy.isTeaServiceConnected() == true) goto L7;
            this.mTeaServiceProxy.bindService(this.mContext);
            goto L7
        }

        private void onEvent(g r5, boolean r6) {
            INVOKESTATIC_os_teatracker_TeaHandler$WorkHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TeaHandler.TAG, "onEvent: " + r5.a());
            if (r5 != null) goto L6;
            return;
        L6:
            if (this.mInitDone.get() == true) goto L8;
        L22:
            INVOKESTATIC_os_teatracker_TeaHandler$WorkHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(e.f40691b, "onEvent before Init=" + this.mInitDone.get());
            cacheEvent(r5, false, r6);
            return;
        L8:
            if (hasMessages(3) == true) goto L22;
            if (h.a(this.mContext) == true) goto L14;
            INVOKESTATIC_os_teatracker_TeaHandler$WorkHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(e.f40691b, "mermaid app unGranted.");
            onQuit();
            return;
        L14:
            mergeParams(r5);
            if (this.mTeaServiceProxy.isTeaServiceConnected() == false) goto L20;
            cacheEvent(r5, true, r6);
            if (r6 == false) goto L19;
            onEvent(this.mSysEventsCache, true);
            return;
        L19:
            onEvent(this.mEventsCache, false);
            return;
        L20:
            cacheEvent(r5, false, r6);
            this.mTeaServiceProxy.bindService(this.mContext);
        }

        private void mergeParams(g r6) {
            if (r6 != null) goto L5;
            return;
        L5:
            JSONObject r1 = r6.b();
            if (r1 != null) goto L8;
            r1 = new JSONObject();
        L8:
            Map<String, Object> r2 = this.mGlobalParams;
            if (r2 != null) goto L27;
            return;
        L27:
            if (r2.isEmpty() == true) goto L32;
            Iterator<Map.Entry<String, Object>> r5 = this.mGlobalParams.entrySet().iterator();     // Catch: Throwable -> L18 JSONException -> L20
        L15:
            if (r5.hasNext() == false) goto L22;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18 JSONException -> L20
            r1.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), r3.getValue());     // Catch: Throwable -> L18 JSONException -> L20
        L22:
            r6.a(r1);
            return;
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L18
            goto L22
        L32:
            return;
        L18:
            th = move-exception;
            r6.a(r1);
            throw th;
        }

        private void cacheEvent(g r3, boolean r4, boolean r5) {
            if (r3 != null) goto L5;
            return;
        L5:
            if (r5 == false) goto L12;
            if (this.mSysEventsCache.size() < 100) goto L10;
            if (r4 == true) goto L10;
            this.mSysEventsCache.remove(0);
        L10:
            this.mSysEventsCache.add(r3);
            return;
        L12:
            if (this.mEventsCache.size() < 100) goto L15;
            if (r4 == true) goto L15;
            this.mEventsCache.remove(0);
        L15:
            this.mEventsCache.add(r3);
        }

        private void onTeaServiceConnected() {
            if (this.mEventsCache.isEmpty() == false) goto L8;
            if (this.mSysEventsCache.isEmpty() == false) goto L8;
            return;
        L8:
            if (this.mTeaServiceProxy.isTeaServiceConnected() == false) goto L21;
            Iterator<g> r0 = this.mEventsCache.iterator();
        L11:
            if (r0.hasNext() == false) goto L13;
            mergeParams((g) ZeusTransformUtils.preCheckCast(r0.next(), g.class, "com.obric.aiagent.plugin"));
            goto L11
        L13:
            Iterator<g> r1 = this.mSysEventsCache.iterator();
        L15:
            if (r1.hasNext() == false) goto L17;
            mergeParams((g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.aiagent.plugin"));
            goto L15
        L17:
            onEvent(this.mEventsCache, false);
            onEvent(this.mSysEventsCache, true);
            return;
        }

        private void onEvent(List<g> r3, boolean r4) {
            List<g> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.isEmpty() == false) goto L8;
            return;
        L8:
            if (this.mTeaServiceProxy.isTeaServiceConnected() == true) goto L10;
            this.mTeaServiceProxy.bindService(this.mContext);
            return;
        L10:
            if (this.mTeaServiceProxy.onEvent(r5, r4) == false) goto L15;
            r5.clear();
            return;
        }

        private void onQuit() {
            INVOKESTATIC_os_teatracker_TeaHandler$WorkHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(e.f40691b, "TeaHandler onQuit...");
            List<g> r0 = this.mEventsCache;
            if (r0 == null) goto L5;
            r0.clear();
            this.mEventsCache = null;
        L5:
            TeaServiceProxy r1 = this.mTeaServiceProxy;
            if (r1 == null) goto L8;
            r1.unbindService();
            this.mTeaServiceProxy.setBindCallback(null);
            this.mTeaServiceProxy = null;
        L8:
            this.mContext = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_os_teatracker_TeaHandler$WorkHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }
    }

    /* JADX INFO: renamed from: lambda$1eF_PFiUpnALBOK-sF9pSzUpIKA, reason: not valid java name */
    public static /* synthetic */ void m1253lambda$1eF_PFiUpnALBOKsF9pSzUpIKA(TeaHandler r0, String r1, String r2) {
        r0.d(r1, r2);
    }

    static /* synthetic */ void a(TeaHandler r0) {
        r0.k();
    }

    static /* synthetic */ List b(TeaHandler r0) {
        return r0.f;
    }

    static /* synthetic */ Object i() {
        return g;
    }

    static {
        g = new Object();
    }

    public void a(final String r3, final String r4) {
        this.f40679e.post(new $$Lambda$TeaHandler$1eF_PFiUpnALBOKsF9pSzUpIKA(this, r3, r4));
    }

    private /* synthetic */ void d(String r4, String r5) {
        this.k = r4;
        this.l = r5;
        Object r6 = g;
        monitor-enter(r6);
        Iterator<WeakReference<d.b>> r7 = this.f.iterator();     // Catch: Throwable -> L16
    L6:
        if (r7.hasNext() == false) goto L14;
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(r7.next(), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r0 == null) goto L6;
        d.b r1 = (d.b) ZeusTransformUtils.preCheckCast(r0.get(), d.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r1 == null) goto L6;
        r1.a(this.k);     // Catch: Throwable -> L16
        r1.b(this.l);     // Catch: Throwable -> L16
        goto L6
    L14:
        monitor-exit(r6);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // os.teatracker.c
    public d.a a() {
        return this.h;
    }

    @Override // os.teatracker.c
    public Boolean b() {
        return this.n;
    }

    @Override // os.teatracker.c
    public String c() {
        return this.m;
    }

    @Override // os.teatracker.c
    public void a(Context r9, e r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        b(TAG, "init:");
        if (r11 == null) goto L52;
        if (this.f40675a == null) goto L7;
        return;
    L7:
        String r3 = null;
        PackageInfo r5 = r11.getPackageManager().getPackageInfo(r11.getPackageName(), 128);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
        if (r5.applicationInfo.metaData != null) goto L11;
    L22:
        if (r10 == null) goto L25;
        if (r3 != null) goto L27;
        r3 = r10.a();
    L27:
        if (TextUtils.isEmpty(r3) == true) goto L50;
        r10.a(r3);
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L32;
        r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L32:
        this.f40675a = ZeusTransformUtils.wrapperContext(r11, "com.obric.aiagent.plugin");
        this.f40676b = r10;
        this.f40679e.setContext(this.f40675a);
        Message.obtain(this.f40679e, 1, r10.d()).sendToTarget();
        j();
        String r12 = g();
        String r13 = h();
        if (this.f40677c == false) goto L45;
        if (TextUtils.isEmpty(r12) == true) goto L54;
        k();
        return;
    L54:
    L41:
        e = move-exception;
        e.printStackTrace();
        return;
    L37:
        if (a(this.f40675a, f.f40696a.getAuthority()) == false) goto L39;
        ContentResolver r14 = this.f40675a.getContentResolver();     // Catch: RuntimeException -> L41
        Uri r15 = f.f40699d;     // Catch: RuntimeException -> L41
        final WorkHandler r1 = this.f40679e;     // Catch: RuntimeException -> L41
        ZeusProviderTransform.registerContentObserver(r14, r15, false, new AnonymousClass1(this, r1), "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L41
    L53:
        return;
    L39:
        c(TAG, "onChange: bdInstallRegister, did " + r12);     // Catch: RuntimeException -> L41
        k();     // Catch: RuntimeException -> L41
        goto L53
    L45:
        if (TextUtils.isEmpty(r12) == true) goto L47;
        a(r12, r13);
    L47:
        final WorkHandler r16 = this.f40679e;
        this.j = new AnonymousClass2(this, r16);
        ZeusProviderTransform.registerContentObserver(this.f40675a.getContentResolver(), f.f40699d, false, this.j, "com.obric.aiagent.plugin");
        return;
    L50:
        throw new IllegalArgumentException("teatracker_app_id must be declared in manifest as meta data");
    L25:
        r10 = new e();
        goto L27
    L11:
        if (r5.applicationInfo.metaData.containsKey("teatracker_app_id") == false) goto L22;
        r3 = r5.applicationInfo.metaData.getString("teatracker_app_id", null);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
        if (TextUtils.isEmpty(r3) == false) goto L22;
        int r0 = r5.applicationInfo.metaData.getInt("teatracker_app_id", 0);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
        if (r0 == 0) goto L22;
        r3 = String.valueOf(r0);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
    L20:
        e = move-exception;
        a(e.f40691b, "get package info error!", e);
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L52:
        throw new IllegalArgumentException("context can't be null when initing Tea tracker.");
    }

    private void j() {
        c(TAG, "checkBdInstall");
        this.f40678d = ZeusTransformUtils.forName("os.teatracker.BdInstallImpl", "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L10
    L5:
        if (this.f40678d == null) goto L7;
        boolean r0 = true;
    L8:
        this.f40677c = r0;
        return;
    L7:
        r0 = false;
        goto L8
    }

    private void k() {
        c(TAG, "bdInstallRegister: ");
        if (this.f40677c == true) goto L5;
        return;
    L5:
        Bundle r0 = null;
        PackageInfo r1 = this.f40675a.getPackageManager().getPackageInfo(this.f40675a.getPackageName(), 128);     // Catch: Exception -> L12 PackageManager.NameNotFoundException -> L14
        if (r1.applicationInfo.metaData != null) goto L9;
    L21:
        IBdInstall r2 = (IBdInstall) ZeusTransformUtils.preCheckCast(this.f40678d.newInstance(), IBdInstall.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        Bundle r3 = new Bundle();     // Catch: Throwable -> L18
        r3.putString("app_id", this.f40676b.a());     // Catch: Throwable -> L18
        r3.putString(IBdInstall.PARAM_APP_NAME, this.f40676b.b());     // Catch: Throwable -> L18
        r3.putString(IBdInstall.PARAM_APP_CHANNEL, this.f40676b.c());     // Catch: Throwable -> L18
        r3.putBundle(IBdInstall.PARAM_META_DATA, r0);     // Catch: Throwable -> L18
        r2.register(this.f40675a, this.f40679e, r3, this);     // Catch: Throwable -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        if (r1.applicationInfo.metaData.containsKey("teatracker_app_id") == false) goto L21;
        r0 = r1.applicationInfo.metaData;     // Catch: Exception -> L12 PackageManager.NameNotFoundException -> L14
    L14:
        e = move-exception;
        a(e.f40691b, "get package info error!", e);
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    @Override // os.teatracker.c
    public void a(g r2) {
        Message.obtain(this.f40679e, 2, r2).sendToTarget();
    }

    public String f() {
        if (this.f40677c == false) goto L7;
        return this.k;
    L7:
        return g();
    }

    public String g() {
        Bundle r5 = this.f40675a.getContentResolver().acquireUnstableContentProviderClient(f.f40696a).call("getDeviceId", null, null);     // Catch: Exception -> L9
        if (r5 == null) goto L7;
        c(e.f40691b, "getTeaTrackerDid, " + r5.getString("key_device_info"));     // Catch: Exception -> L9
        return r5.getString("key_device_info");
    L7:
        c(e.f40691b, "getTeaTrackerDid result IS NULL!");     // Catch: Exception -> L9
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String h() {
        if (this.f40677c == true) goto L5;
        return "INVALID_IID_MISSING_BDINSTALL";
    L5:
        return this.l;
    }

    @Override // os.teatracker.c
    e e() {
        return this.f40676b;
    }

    @Override // os.teatracker.c
    Context getContext() {
        return this.f40675a;
    }

    public TeaHandler() {
        this.f40678d = null;
        this.f = Collections.synchronizedList(new ArrayList());
        this.h = null;
        this.i = null;
        this.n = null;
        HandlerThread r0 = new HandlerThread("Tea Handler");
        r0.start();
        this.f40679e = new WorkHandler((Looper) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r0.getLooper()), Looper.class, "com.obric.aiagent.plugin"));
    }

    private boolean a(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        c(e.f40691b, "isProviderExists,  context is null");
        return false;
    L7:
        if (r1.getPackageManager().resolveContentProvider(r3, 0) == null) goto L10;
        return true;
    L10:
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
