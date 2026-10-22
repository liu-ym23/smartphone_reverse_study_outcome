package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.preload;

import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.vscore_api.paidlive.d;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.b;
import com.bytedance.android.livesdk.vscore_impl.paidlive.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Objects;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import pu2.i;
import pu2.p;
import v9.c;

/* JADX INFO: loaded from: classes11.dex */
public final class PaidOpenSchemaWithDataAbility implements i, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f160207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f160208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f160209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HybridDialog f160210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f160211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f160212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f160213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PaidOpenSchemaWithDataAbility$annieLiveDialogCommonLifeCycle$1 f160214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f160215i;

    public static final class a implements v9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f160216a;

        public a(SafeContinuation r100) {
            this.f160216a = r100;
        }

        @Override // v9.b
        public final void onSuccess(String r100) {
            if (r100 != null) goto L4;
        L9:
            Continuation r101 = this.f160216a;
            RuntimeException r102 = new RuntimeException("annie convert success with null");
            Result.Companion r103 = Result.Companion;
            r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r102)));
            return;
        L4:
            if (r100.length() != 0) goto L6;
            boolean r104 = true;
        L7:
            if (r104 == true) goto L9;
            this.f160216a.resumeWith(Result.m9449constructorimpl(r100));
            return;
        L6:
            r104 = false;
            goto L7
        }

        @Override // v9.b
        public final void onFail(int r100, String r101) {
            Continuation r102 = this.f160216a;
            RuntimeException r103 = new RuntimeException(r100 + '_' + r101);
            Result.Companion r104 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r103)));
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final String d() {
        return "PaidOpenSchemaWithDataAbility[" + this.f160215i.w0() + ']';
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ALogger.i(d(), WidgetCostModule.TYPE_ON_START);
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.preload.PaidOpenSchemaWithDataAbility$annieLiveDialogCommonLifeCycle$1] */
    public PaidOpenSchemaWithDataAbility(b r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f160215i = r100;
        this.f160207a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.f160208b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.f160209c = UriProtector.parse("");
        this.f160212f = LazyKt.lazy(PaidOpenSchemaWithDataAbility$preloadConfig$2.INSTANCE);
        this.f160213g = LazyKt.lazy(PaidOpenSchemaWithDataAbility$fullScreenConfig$2.INSTANCE);
        this.f160214h = new PaidOpenSchemaWithDataAbility$annieLiveDialogCommonLifeCycle$1(this);
    }

    @Override // pu2.i
    public final void Ve(p r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        BuildersKt.launch$default(this.f160208b, null, null, new PaidOpenSchemaWithDataAbility$openWithData$1(this, r100, null), 3, null);
    }

    public static Object c(String r100, Continuation r101) {
        SafeContinuation r102 = new SafeContinuation(IntrinsicsKt.intercepted(r101));
        IExternalBrowserService r103 = (IExternalBrowserService) k.f(IExternalBrowserService.class);
        if (r103 == null) goto L5;
        r103.initAnnie();
    L5:
        IExternalBrowserService r104 = (IExternalBrowserService) k.f(IExternalBrowserService.class);
        if (r104 == null) goto L8;
        Boxing.boxBoolean(r104.initAnnieXCardLiveEnv());
    L8:
        ((c) Annie.getService(c.class, "webcast")).X0(r100, new a(r102));
        Object r105 = r102.getOrThrow();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L11:
        return r105;
    }

    public static final Object a(PaidOpenSchemaWithDataAbility r110, String r111, String r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof PaidOpenSchemaWithDataAbility$processUrl$1) == false) goto L7;
        PaidOpenSchemaWithDataAbility$processUrl$1 r100 = (PaidOpenSchemaWithDataAbility$processUrl$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        String r105 = "";
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        Uri r115 = (Uri) r100.L$2;
        String r116 = (String) r100.L$1;
        PaidOpenSchemaWithDataAbility r117 = (PaidOpenSchemaWithDataAbility) r100.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Exception -> L14
        Uri r118 = r115;
        r110 = r117;
        r112 = r116;
        Object r119 = r114;
    L46:
        r105 = (String) r119;     // Catch: Exception -> L48
    L52:
        if (r105.length() <= 0) goto L54;
        r104 = true;
    L54:
        if (r104 == false) goto L68;
        if ((!StringsKt.isBlank(r105)) == false) goto L68;
        r110.f160209c = UriProtector.parse(r105);
        ALogger.i(r110.d(), "processUrl(" + r112 + ") short url redirect process success, uri = " + r110.f160209c);
        return r110.f160209c;
    L68:
        return r118;
    L48:
        e = move-exception;
        String r106 = r112;
        r117 = r110;
        r115 = r118;
        Exception e100 = e;
        r116 = r106;
    L50:
        ALogger.e(r117.d(), "processUrl(" + r116 + ") error:" + e100);
        r118 = r115;
        r110 = r117;
        r112 = r116;
    L14:
        e100 = e;
        goto L50
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r114);
        d r120 = r110.f160215i.D().getRoomContext();
        if (r120 == null) goto L23;
        m<Room> r121 = f.b(r120);
        if (r121 == null) goto L23;
        Room r122 = r121.getValue();
    L24:
        if (r122 == null) goto L61;
        if (r111 == null) goto L61;
        ALogger.i(r110.d(), "processUrl-> start, sourceTag=" + r112);
        Pair[] r123 = new Pair[4];
        r123[0] = TuplesKt.to("ent_bill_data_processor_optimize", "1");
        if (((oq1.a) r110.f160212f.getValue()).a() == false) goto L30;
        String r107 = "1";
    L31:
        r123[1] = TuplesKt.to("is_use_popup_inject", r107);
        r123[2] = TuplesKt.to("show_process_indicator", "1");
        r123[3] = TuplesKt.to("enable_opt_live_bill_fmp", String.valueOf(((oq1.a) r110.f160212f.getValue()).a()));
        Map r124 = MapsKt.mutableMapOf(r123);
        Gson r108 = com.bytedance.android.annie.api.data.subscribe.d.f38409a;
        r124.put("live_ent_bill_fullscreen_support_config", com.bytedance.android.annie.api.data.subscribe.d.c((oq1.c) r110.f160213g.getValue()));
        String r125 = f.a(r111, r124);
        if (r125 != null) goto L34;
        String r126 = "";
    L35:
        r118 = UriProtector.parse(r126);
        String r109 = r118.getHost();
        if (r109 != null) goto L38;
    L40:
        boolean r127 = false;
    L41:
        if (r127 == false) goto L59;
        ALogger.i(r110.d(), " processUrl(" + r112 + ") start short url redirect");
        r100.L$0 = r110;     // Catch: Exception -> L48
        r100.L$1 = r112;     // Catch: Exception -> L48
        r100.L$2 = r118;     // Catch: Exception -> L48
        r100.label = 1;     // Catch: Exception -> L48
        r119 = c(r125, r100);     // Catch: Exception -> L48
        if (r119 != r102) goto L46;
        return r102;
    L59:
        r110.f160209c = r118;
        ALogger.i(r110.d(), "processUrl(" + r112 + "), not short link, direct, uri = " + r110.f160209c);
        r110.d();
        Objects.toString(r110.f160209c);
        goto L68
    L38:
        if (r109.equals("webcast_redirect") != true) goto L40;
        r127 = true;
        goto L41
    L34:
        r126 = r125;
        goto L35
    L30:
        r107 = "0";
    L61:
        return UriProtector.parse("");
    L23:
        r122 = null;
    L7:
        r100 = new PaidOpenSchemaWithDataAbility$processUrl$1(r110, r113);
        goto L8
    }
}
