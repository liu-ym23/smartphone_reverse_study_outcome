package com.bytedance.android.livesdk.log;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.ability.LiveLoggerScheduleAtomicAbility;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveAppLoggerConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncDegradeCallback;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncExecutor;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncExtKt;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.device.info.TelephonyManagerEntry;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes10.dex */
public class j0 implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TokenCert f153361c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f153362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ExecutorService f153363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile j0 f153364f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILoggerLifeManagerService f153365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableEmitter<d> f153366b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f153367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f153368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object[] f153369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j0 f153370d;

        @Override // java.lang.Runnable
        public final void run() {
            j0.j(this.f153370d, this.f153367a, this.f153368b, this.f153369c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(j0 r100, String r101, Map r102, Object[] r103) {
            this.f153370d = r100;
            this.f153367a = r101;
            this.f153368b = r102;
            this.f153369c = r103;
        }
    }

    public class b implements AtlasAsyncDegradeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f153371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f153372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object[] f153373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j0 f153374d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f153375a;

            @Override // java.lang.Runnable
            public final void run() {
                b r100 = this.f153375a;     // Catch: Throwable -> L4
                j0.j(r100.f153374d, r100.f153371a, r100.f153372b, r100.f153373c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r100) {
                this.f153375a = r100;
            }
        }

        @Override // com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncDegradeCallback
        public void call() {
            ExecutorService r100 = j0.f153363e;
            if (r100 != null) goto L6;
            if (r100 != null) goto L6;
            j0.f153363e = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("MiddlewareLiveLogger"));
        L6:
            ExecutorService r101 = j0.f153363e;
            if (r101 == null) goto L9;
            r101.submit(new a(this));
            return;
        L9:
            j0.j(this.f153374d, this.f153371a, this.f153372b, this.f153373c);
        }

        public b(j0 r100, String r101, Map r102, Object[] r103) {
            this.f153374d = r100;
            this.f153371a = r101;
            this.f153372b = r102;
            this.f153373c = r103;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f153376a = null;

        static {
            int[] r100 = new int[NetworkUtils.NetworkType.values().length];
            f153376a = r100;
            r100[NetworkUtils.NetworkType.MOBILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f153376a[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f153376a[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f153376a[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f153376a[NetworkUtils.NetworkType.WIFI.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f153377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f153378b;

        public d(String r100, Map<String, String> r101) {
            this.f153377a = r100;
            this.f153378b = r101;
        }
    }

    static {
        f153361c = TokenCert.with("bpea-livelogger_get_network_type");
        f153362d = "0";
    }

    public static String k() {
        TokenCert r100 = f153361c;
        int[] r101 = c.f153376a;
        Context r102 = s1.getContext();
        NetworkInfo r103 = ((ConnectivityManager) r102.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L23
        if (r103 != null) goto L6;
    L21:
        NetworkUtils.NetworkType r104 = NetworkUtils.NetworkType.NONE;     // Catch: Throwable -> L23
    L41:
    L24:
        int r105 = r101[r104.ordinal()];
        if (r105 == 1) goto L37;
        if (r105 == 2) goto L37;
        if (r105 == 3) goto L37;
        if (r105 == 4) goto L37;
        if (r105 == 5) goto L35;
        return "none";
    L35:
        return "wifi";
    L37:
        if (TTMiddlewareLiveSDK.hostMiddlewareService().config().appConfig().isFreeFlow() == false) goto L39;
        return "free_card";
    L39:
        return "limited_data";
    L6:
        if (r103.isAvailable() == false) goto L21;
        int r106 = r103.getType();     // Catch: Throwable -> L23
        if (1 != r106) goto L11;
        r104 = NetworkUtils.NetworkType.WIFI;     // Catch: Throwable -> L23
        goto L41
    L11:
        if (r106 != 0) goto L20;
        Integer r107 = TelephonyManagerEntry.getNetworkType((TelephonyManager) r102.getSystemService("phone"), r100);     // Catch: Throwable -> L23
        if (r107 != null) goto L16;
        r104 = NetworkUtils.NetworkType.MOBILE;     // Catch: Throwable -> L23
        goto L41
    L16:
        switch(r107.intValue()) {
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L17;
        };     // Catch: Throwable -> L23
    L17:
        r104 = NetworkUtils.NetworkType.MOBILE;     // Catch: Throwable -> L23
        goto L41
    L18:
        r104 = NetworkUtils.NetworkType.MOBILE_4G;     // Catch: Throwable -> L23
        goto L41
    L19:
        r104 = NetworkUtils.NetworkType.MOBILE_3G;     // Catch: Throwable -> L23
        goto L41
    L20:
        r104 = NetworkUtils.NetworkType.MOBILE;     // Catch: Throwable -> L23
    L23:
        r104 = NetworkUtils.NetworkType.MOBILE;
        goto L24
    }

    public static j0 l() {
        if (f153364f != null) goto L16;
        monitor-enter(g.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f153364f != null) goto L9;
        f153364f = new j0();     // Catch: Throwable -> L12
    L9:
        j0 r100 = f153364f;     // Catch: Throwable -> L12
        monitor-exit(g.class);     // Catch: Throwable -> L12
        return r100;
    L16:
        return f153364f;
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter() {
        ILoggerLifeManagerService r100 = this.f153365a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSendLogFilter();
    }

    public j0() {
        this.f153365a = null;
        this.f153365a = (ILoggerLifeManagerService) jc1.k.f(ILoggerLifeManagerService.class);
        Observable.create(new g0(this)).observeOn(Schedulers.io()).subscribe(new h0(this), new i0());
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void a(int r100) {
        HashMap r101 = new HashMap();
        if (r100 != 1) goto L5;
        r101.put("action_type", "click");
    L6:
        l().sendLog("livesdk_more_anchor_live_take_button", r101, new Object[0]);
        return;
    L5:
        r101.put("action_type", "show");
        goto L6
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void b(String r100) {
        sendLog(r100, null, new Object[0]);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final com.bytedance.android.livesdk.log.filter.o c(Class r100) {
        ILoggerLifeManagerService r101 = this.f153365a;
        if (r101 != null) goto L5;
    L10:
        ILoggerLifeManagerService r102 = this.f153365a;
        if (r102 != null) goto L13;
        return null;
    L13:
        if (r102.getFakeTempMap() != null) goto L15;
        return null;
    L15:
        if (this.f153365a.getFakeTempMap().containsKey(r100) == true) goto L17;
        return null;
    L17:
        return this.f153365a.getFakeTempMap().get(r100);
    L5:
        if (r101.getMap() == null) goto L10;
        if (this.f153365a.getMap().containsKey(r100) == false) goto L10;
        return this.f153365a.getMap().get(r100);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r100) {
        ILoggerLifeManagerService r101 = this.f153365a;
        if (r101 != null) goto L6;
        return null;
    L6:
        com.bytedance.android.livesdk.log.filter.v r102 = r101.removeSendLogFilter(r100);
        if (r102 == null) goto L9;
        r102.onRemove();
    L9:
        return r102;
    }

    public static /* synthetic */ void i(j0 r100, d r101) {
        r100.getClass();
        if (r101 == null) goto L6;
        r100.m(r101.f153377a, r101.f153378b);
        return;
    }

    private void m(String r100, Map<String, String> r101) {
        if (StringUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (this.f153365a == null) goto L14;
        r101 = x.a(r100, r101);     // Catch: Exception -> L10
    L8:
        this.f153365a.onSendAppLog(r100, r101);
        this.f153365a.afterSendAppLog(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final boolean addSendLogFilter(Object r100, com.bytedance.android.livesdk.log.filter.v r101) {
        ILoggerLifeManagerService r102 = this.f153365a;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.addSendLogFilter(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void d(String r100, Object... r101) {
        sendLog(r100, null, r101);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final <T> void register(Class<? extends T> r100, com.bytedance.android.livesdk.log.filter.o<? extends T> r101) {
        ILoggerLifeManagerService r102 = this.f153365a;
        if (r102 == null) goto L6;
        r102.register(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void e(String r100, Map r101, Object... r102) {
        n(r100, false, false, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void f(String r100, Map<String, String> r101, Object... r102) {
        n(r100, true, true, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void h(String r100, Map<String, String> r101, Object... r102) {
        n(r100, false, false, r101, r102);
    }

    public final void o(String r100, Map<String, String> r101, Object... r102) {
        AtlasAsyncExtKt.executeTask(AtlasAsyncExecutor.INSTANCE, "MiddlewareLiveLogger", new a(this, r100, r101, r102), new b(this, r100, r101, r102));
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void sendLog(String r110, Map<String, String> r111, Object... r112) {
        if (r111 != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L10;
        r111.remove("escape_prefix_check");
    L10:
        n(r110, !r100, false, r111, r112);
        return;
    L5:
        if (r111.containsKey("escape_prefix_check") == false) goto L7;
        r100 = true;
        goto L8
    }

    public static /* synthetic */ void j(j0 r100, String r101, Map r102, Object[] r103) {
        r100.n(r101, true, false, r102, r103);
    }

    private void n(String r100, boolean r101, boolean r102, Map<String, String> r103, Object... r104) {
        ILoggerLifeManagerService r105 = this.f153365a;
        if (r105 != null) goto L5;
        return;
    L5:
        String r106 = r105.onChangeEventName(r101, r100);
        LiveAppLoggerConfig.Companion r107 = LiveAppLoggerConfig.Companion;     // Catch: Exception -> L30
        if (r107.getConfig().getEnablePreDrop() == false) goto L14;
        Set<String> r108 = r107.getConfig().getPreDropEventsWhiteSet();     // Catch: Exception -> L30
        boolean r109 = true;
        if (r108 != null) goto L11;
    L15:
        if (r109 == false) goto L20;
        if (this.f153365a.needDropEventBySampling(r106) == false) goto L20;
        return;
    L20:
        if (LiveLoggerScheduleAtomicAbility.INSTANCE.filterLiveLoggerSchedule(r106) == false) goto L22;
        return;
    L22:
        HashMap r110 = new HashMap();
        this.f153365a.beforeExecuteLogFilter(r110);
        this.f153365a.onExecuteLogFilter(r103, r110, r104);
        this.f153365a.afterExecuteLogFilter();
        this.f153365a.beforeSendAppLog(r106, r110);
        if (r102 == false) goto L28;
        ObservableEmitter<d> r111 = this.f153366b;
        if (r111 == null) goto L27;
        r111.onNext(new d(r106, r110));
        return;
    L27:
        m(r106, r110);
        return;
    L28:
        m(r106, r110);
        return;
    L11:
        if (r108.size() <= 0) goto L15;
        r109 = true ^ r108.contains(r106);
    L14:
        r109 = false;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.log.g
    public final void g(String r100, boolean r101, boolean r102, Map<String, String> r103, Object... r104) {
        n(r100, r101, r102, r103, r104);
    }
}
