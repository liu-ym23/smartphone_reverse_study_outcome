package com.bytedance.android.ec.slice;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.t;
import com.bytedance.android.ec.host.api.core.api.IECImageXService;
import com.bytedance.android.ec.hybrid.service.IECFontService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.slice.api.ISliceInitService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import pq.c;
import s83.g;
import sc3.j;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bE\u0010FJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082\bJ\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0082\bJ\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0082\bJ\b\u0010\b\u001a\u00020\u0001H\u0007J\b\u0010\n\u001a\u00020\tH\u0003J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0014\u001a\u00020\u000b*\u0004\u0018\u00010\u0013H\u0002J\u001e\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0014\u0010\u001c\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0014\u0010#\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R(\u0010'\u001a\u0004\u0018\u00010\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010/\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00102\u001a\u00020\u00198@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R\u0016\u00103\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010,\u001a\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010C\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/bytedance/android/ec/slice/SliceInitService;", "Lcom/bytedance/android/slice/api/ISliceInitService;", "Lcom/bytedance/android/ec/host/api/core/api/IECImageXService;", "getECIECImageXService", "Lcom/bytedance/android/ec/hybrid/service/IECFontService;", "getECFontService", "Lsc3/j;", "getECYataService", "getService", "", "updateSliceSwitch", "Lorg/json/JSONObject;", "config", "putImageLoaderHookConfig", "Lpq/c;", "logParam", "", "level", "slcLog", "", "toJSONObject", "", "e", "msg", "slcEnsureNotReachHere", "", "hasInit", "initSlice", "DISABLE_CUSTOM_RATE", "Ljava/lang/String;", "SLICE_SLARDAR_LOG_TYPE", "SLICE_SLARDAR_LOG_PREFIX", "DEFAULT_SERVICE_PREFIX", "KEY_EVENT_ORIGIN_FEATURE", "VALUE_TEMAI", "DEFAULT_SWITCH", "FIX_TEMPLATE_CACHE_SIZE", "I", "<set-?>", "sliceOptSwitch", "Lorg/json/JSONObject;", "getSliceOptSwitch", "()Lorg/json/JSONObject;", "IS_DEBUG$delegate", "Lkotlin/Lazy;", "getIS_DEBUG", "()Z", "IS_DEBUG", "IS_LOCAL_TEST$delegate", "getIS_LOCAL_TEST$ec_slice_adapter_impl_saasRelease", "IS_LOCAL_TEST", "isInit", "Z", "Ljava/util/concurrent/ThreadPoolExecutor;", "bgExecutor$delegate", "getBgExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "bgExecutor", "Lpq/b;", "slcEnvInfo$delegate", "getSlcEnvInfo", "()Lpq/b;", "slcEnvInfo", "_ecIECImageXService", "Lcom/bytedance/android/ec/host/api/core/api/IECImageXService;", "_ecFontService", "Lcom/bytedance/android/ec/hybrid/service/IECFontService;", "_ecYataService", "Lsc3/j;", "<init>", "()V", "ec-slice-adapter-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SliceInitService implements ISliceInitService {
    private static final String DEFAULT_SERVICE_PREFIX = "DefaultImpl_";
    public static final String DEFAULT_SWITCH = "{}";
    public static final String DISABLE_CUSTOM_RATE = "disable_slardar_custom_rate";
    private static final int FIX_TEMPLATE_CACHE_SIZE = 128;
    public static final SliceInitService INSTANCE = null;
    private static final Lazy IS_DEBUG$delegate = null;
    private static final Lazy IS_LOCAL_TEST$delegate = null;
    private static final String KEY_EVENT_ORIGIN_FEATURE = "EVENT_ORIGIN_FEATURE";
    public static final String SLICE_SLARDAR_LOG_PREFIX = "slice_sdk_exception:";
    public static final String SLICE_SLARDAR_LOG_TYPE = "slice_sdk_monitor";
    private static final String VALUE_TEMAI = "TEMAI";
    private static IECFontService _ecFontService;
    private static IECImageXService _ecIECImageXService;
    private static j _ecYataService;
    private static final Lazy bgExecutor$delegate = null;
    private static boolean isInit;
    private static final Lazy slcEnvInfo$delegate = null;
    private static volatile JSONObject sliceOptSwitch;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f48186a = null;

        /* JADX INFO: renamed from: com.bytedance.android.ec.slice.SliceInitService$a$a, reason: collision with other inner class name */
        public static final class RunnableC0836a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final RunnableC0836a f48187a = null;

            static {
                f48187a = new RunnableC0836a();
            }

            public RunnableC0836a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                SliceInitService.access$updateSliceSwitch(SliceInitService.INSTANCE);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        static {
            f48186a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SliceInitService.access$getBgExecutor$p(SliceInitService.INSTANCE).execute(RunnableC0836a.f48187a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f48188a = null;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f48189a = null;

            static {
                f48189a = new a();
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                SliceInitService.access$updateSliceSwitch(SliceInitService.INSTANCE);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        static {
            f48188a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SliceInitService.access$getBgExecutor$p(SliceInitService.INSTANCE).execute(a.f48189a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private SliceInitService() {
    }

    private final ThreadPoolExecutor getBgExecutor() {
        return (ThreadPoolExecutor) bgExecutor$delegate.getValue();
    }

    private final boolean getIS_DEBUG() {
        return ((Boolean) IS_DEBUG$delegate.getValue()).booleanValue();
    }

    private final pq.b getSlcEnvInfo() {
        return (pq.b) slcEnvInfo$delegate.getValue();
    }

    public final boolean getIS_LOCAL_TEST$ec_slice_adapter_impl_saasRelease() {
        return ((Boolean) IS_LOCAL_TEST$delegate.getValue()).booleanValue();
    }

    static {
        INSTANCE = new SliceInitService();
        IS_DEBUG$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, SliceInitService$IS_DEBUG$2.INSTANCE);
        IS_LOCAL_TEST$delegate = LazyKt.lazy(SliceInitService$IS_LOCAL_TEST$2.INSTANCE);
        bgExecutor$delegate = LazyKt.lazy(SliceInitService$bgExecutor$2.INSTANCE);
        slcEnvInfo$delegate = LazyKt.lazy(SliceInitService$slcEnvInfo$2.INSTANCE);
    }

    private final void updateSliceSwitch() {
        String r100 = DEFAULT_SWITCH;
        int r101 = ECSdk.f48106a;     // Catch: Throwable -> L11
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        String r103 = (String) r102.getLiveSettingsValue("iesec_slice_opt_switch", DEFAULT_SWITCH);     // Catch: Throwable -> L11
        if (r103 == null) goto L9;
        r100 = r103;
    L9:
        JSONObject r104 = toJSONObject(r100);
        putImageLoaderHookConfig(r104);
        sliceOptSwitch = r104;
    }

    @Override // com.bytedance.android.slice.api.ISliceInitService
    public void initSlice() {
        if (isInit == false) goto L5;
        return;
    L5:
        boolean r100 = true;
        isInit = true;
        boolean r101 = ECServiceManager.f42805a;
        if (ECServiceManager.d(g.class) == false) goto L8;
        ((g) ECServiceManager.c(g.class)).v(a.f48186a);
    L9:
        pq.a r102 = new SliceInitService$initSlice$sliceRenderConfig$1();
        SliceRender.f50121o.getClass();
        if (SliceRender.f50108b == null) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L16;
        SliceRender.f50108b = r102;
    L16:
        SlcGeckoTemplateMgr r104 = SlcGeckoTemplateMgr.f51232l;
        SlcGeckoConfig r105 = new SlcGeckoConfig();
        r104.getClass();
        if (SlcGeckoTemplateMgr.f51228h != null) goto L20;
        r100 = false;
    L20:
        if (r100 == true) goto L24;
        SlcGeckoTemplateMgr.f51228h = r105;
        return;
    L24:
        return;
    L12:
        r103 = false;
        goto L13
    L8:
        new Handler(Looper.getMainLooper()).postDelayed(b.f48188a, KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL);
        goto L9
    }

    private final IECFontService getECFontService() {
        IECFontService r100 = access$get_ecFontService$p(this);
        if (r100 != null) goto L9;
        int r101 = ECSdk.f48106a;
        r100 = (IECFontService) ECSdk.a(IECFontService.class);
        if (r100 == null) goto L9;
        if (StringsKt.contains$default(r100.getClass().getSimpleName(), DEFAULT_SERVICE_PREFIX, false, 2, null) == true) goto L9;
        access$set_ecFontService$p(this, r100);
    L9:
        return r100;
    }

    private final IECImageXService getECIECImageXService() {
        IECImageXService r100 = access$get_ecIECImageXService$p(this);
        if (r100 != null) goto L9;
        int r101 = ECSdk.f48106a;
        r100 = (IECImageXService) ECSdk.a(IECImageXService.class);
        if (r100 == null) goto L9;
        if (StringsKt.contains$default(r100.getClass().getSimpleName(), DEFAULT_SERVICE_PREFIX, false, 2, null) == true) goto L9;
        access$set_ecIECImageXService$p(this, r100);
    L9:
        return r100;
    }

    private final j getECYataService() {
        j r100 = access$get_ecYataService$p(this);
        if (r100 != null) goto L10;
        int r101 = ECSdk.f48106a;
        IEShoppingService r102 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r102 == null) goto L7;
        r100 = r102.getYataService();
    L8:
        if (r100 == null) goto L10;
        r100.a();
        access$set_ecYataService$p(this, r100);
        goto L10
    L7:
        r100 = null;
    L10:
        return r100;
    }

    @JvmStatic
    public static final ISliceInitService getService() {
        return INSTANCE;
    }

    public final JSONObject getSliceOptSwitch() {
        return sliceOptSwitch;
    }

    @Override // com.bytedance.android.slice.api.ISliceInitService
    public boolean hasInit() {
        return isInit;
    }

    public static final /* synthetic */ ThreadPoolExecutor access$getBgExecutor$p(SliceInitService r100) {
        return r100.getBgExecutor();
    }

    public static final /* synthetic */ IECFontService access$getECFontService(SliceInitService r100) {
        return r100.getECFontService();
    }

    public static final /* synthetic */ IECImageXService access$getECIECImageXService(SliceInitService r100) {
        return r100.getECIECImageXService();
    }

    public static final /* synthetic */ j access$getECYataService(SliceInitService r100) {
        return r100.getECYataService();
    }

    public static final /* synthetic */ boolean access$getIS_DEBUG$p(SliceInitService r100) {
        return r100.getIS_DEBUG();
    }

    public static final /* synthetic */ pq.b access$getSlcEnvInfo$p(SliceInitService r100) {
        return r100.getSlcEnvInfo();
    }

    public static final /* synthetic */ JSONObject access$getSliceOptSwitch$p(SliceInitService r100) {
        return sliceOptSwitch;
    }

    public static final /* synthetic */ IECFontService access$get_ecFontService$p(SliceInitService r100) {
        return _ecFontService;
    }

    public static final /* synthetic */ IECImageXService access$get_ecIECImageXService$p(SliceInitService r100) {
        return _ecIECImageXService;
    }

    public static final /* synthetic */ j access$get_ecYataService$p(SliceInitService r100) {
        return _ecYataService;
    }

    public static final /* synthetic */ void access$updateSliceSwitch(SliceInitService r100) {
        r100.updateSliceSwitch();
    }

    private final void putImageLoaderHookConfig(JSONObject r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Result.m9449constructorimpl(r100.put("use_image_loader_hook", t.d()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    private final JSONObject toJSONObject(String r100) {
    L6:
        e = move-exception;
        slcEnsureNotReachHere(e, "switch_json_format_error");
    L9:
        return new JSONObject();
    L3:
        if (com.bytedance.android.shopping.anchorv3.a.b(r100) == false) goto L9;
        return new JSONObject(r100);
    }

    public static final /* synthetic */ void access$setSliceOptSwitch$p(SliceInitService r100, JSONObject r101) {
        sliceOptSwitch = r101;
    }

    public static final /* synthetic */ void access$set_ecFontService$p(SliceInitService r100, IECFontService r101) {
        _ecFontService = r101;
    }

    public static final /* synthetic */ void access$set_ecIECImageXService$p(SliceInitService r100, IECImageXService r101) {
        _ecIECImageXService = r101;
    }

    public static final /* synthetic */ void access$set_ecYataService$p(SliceInitService r100, j r101) {
        _ecYataService = r101;
    }

    public static final /* synthetic */ JSONObject access$toJSONObject(SliceInitService r100, String r101) {
        return r100.toJSONObject(r101);
    }

    private final void slcLog(c r100, int r101) {
        if (r101 != 2) goto L5;
        String r102 = r100.f530258a;
        return;
    L5:
        if (r101 != 3) goto L7;
        String r103 = r100.f530258a;
        return;
    L7:
        if (r101 != 4) goto L9;
        String r104 = r100.f530258a;
        return;
    L9:
        if (r101 != 5) goto L11;
        String r105 = r100.f530258a;
        return;
    L11:
        if (r101 != 6) goto L23;
        String r106 = r100.f530258a;
        return;
    }

    public final void slcEnsureNotReachHere(Throwable r100, String r101) {
        JSONObject r102 = sliceOptSwitch;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L6:
        Lazy r104 = ECAppInfoService.f48110a;
        if (ECAppInfoService.j() == false) goto L9;
    L26:
        if (r100 == null) goto L28;
    L29:
        if (r100 == null) goto L36;
    L31:
        ECExceptionMonitor.d(SLICE_SLARDAR_LOG_TYPE, r100, SLICE_SLARDAR_LOG_PREFIX + r101);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        ECExceptionMonitor.f(th, SLICE_SLARDAR_LOG_PREFIX);
        return;
    L36:
        r100 = new Throwable(r101);     // Catch: Throwable -> L33
        goto L31
    L28:
        if (com.bytedance.android.shopping.anchorv3.a.b(r101) == true) goto L29;
        return;
    L9:
        if (ECAppInfoService.k() == true) goto L26;
    L10:
        if (r100 != null) goto L12;
    L14:
        if (r100 == null) goto L16;
    L18:
        if (r100 == null) goto L40;
        if (r101 != null) goto L21;
    L24:
        if (r103 == false) goto L41;
        ECExceptionMonitor.f(r100, SLICE_SLARDAR_LOG_PREFIX);
        return;
    L41:
        return;
    L21:
        if (r101.length() == 0) goto L24;
        r103 = false;
        goto L24
    L40:
        return;
    L16:
        if (com.bytedance.android.shopping.anchorv3.a.b(r101) == false) goto L18;
        ECExceptionMonitor.c(SLICE_SLARDAR_LOG_PREFIX + r101);
        return;
    L12:
        if (com.bytedance.android.shopping.anchorv3.a.b(r101) == false) goto L14;
        ECExceptionMonitor.f(r100, SLICE_SLARDAR_LOG_PREFIX + r101);
        return;
    L5:
        if (r102.optBoolean(DISABLE_CUSTOM_RATE) == true) goto L10;
        goto L6
    }

    public static final /* synthetic */ void access$slcLog(SliceInitService r100, c r101, int r102) {
        r100.slcLog(r101, r102);
    }

    public static /* synthetic */ void slcEnsureNotReachHere$default(SliceInitService r100, Throwable r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.slcEnsureNotReachHere(r101, r102);
    }
}
