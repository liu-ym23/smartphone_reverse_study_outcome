package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.gamecp.common.utils.l1;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.host_api.model.user.IUser;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sve_core.Store;
import com.lynx.tasm.LynxError;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public abstract class k extends com.bytedance.ies.sve_core.w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f54020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f54021e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f54022a;

        public b(Function0 r100) {
            this.f54022a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IUser r101 = (IUser) r100;
            this.f54022a.invoke();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f54023a = null;

        static {
            f54023a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            String r102 = r101.getMessage();
            if (r102 == null) goto L6;
            yr.c.b("NewBetaDownloadCommonEffect", r102);
            return;
        }
    }

    public static final class d<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f54024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f54025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f54026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f54027d;

        public static final class a implements com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ObservableEmitter f54028a;

            @Override // com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.m
            public final void a() {
            }

            public a(ObservableEmitter r100) {
                this.f54028a = r100;
            }

            @Override // com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.m
            public final void onFail(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
                yr.c.b("BetaApplyDownloadEffect", String.valueOf(r100));
                if (l1.a(r100) != 4014137) goto L5;
                this.f54028a.onNext(new Pair(Boolean.TRUE, "onFail_4014137"));
                return;
            L5:
                this.f54028a.onNext(new Pair(Boolean.FALSE, r100.getMessage()));
            }

            @Override // com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.m
            public final void onSuccess(JSONObject r100) {
                this.f54028a.onNext(new Pair(Boolean.TRUE, "success"));
            }
        }

        public d(k r100, int r101, Context r102, long r103) {
            this.f54024a = r100;
            this.f54025b = r101;
            this.f54026c = r102;
            this.f54027d = r103;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Pair<Boolean, String>> r210) {
            Intrinsics.checkNotNullParameter(r210, "emitter");
            if (this.f54025b != 1) goto L6;
            r210.onNext(new Pair(Boolean.TRUE, "has reserved"));
            return;
        L6:
            dt.b r100 = (dt.b) this.f54024a.b(dt.e.f469988b);
            com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e.a r101 = com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e.f54831i;
            Context r102 = this.f54026c;
            String r103 = r100.I;
            if (r103 != null) goto L9;
            r103 = "";
        L9:
            String r104 = r100.F;
            if (r104 != null) goto L12;
            String r110 = "";
        L13:
            String r105 = r100.C;
            if (r105 != null) goto L16;
            String r111 = "";
        L17:
            JSONObject r112 = new JSONObject();
            String r113 = String.valueOf(r100.P);
            String r106 = r100.R;
            if (r106 != null) goto L20;
            String r114 = "";
        L21:
            com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.q r211 = new com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.q("", r110, r111, r112, r113, r114, r100.I, 0, null, null, null, 3968);
            com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.r r107 = new com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.r("game_test", r100.H, false, 0);
            JSONObject r108 = new JSONObject();
            String r115 = r100.I;     // Catch: Exception -> L47
            if (r115 != null) goto L25;
            r115 = "";
        L25:
            r108.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, r115);     // Catch: Exception -> L47
            int r116 = r100.P;     // Catch: Exception -> L47
            long r117 = 0;
            if (r116 == 0) goto L30;
            if (r116 != 1) goto L45;
            String r118 = r100.R;     // Catch: Exception -> L47
            r101.getClass();     // Catch: Exception -> L47
            r117 = com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e.a.k(r118);     // Catch: Exception -> L47
        L45:
            r108.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r117);     // Catch: Exception -> L47
            r108.put("scene", r100.P);     // Catch: Exception -> L47
            r108.put(BdpAppEventConstant.PARAMS_SUB_SCENE, "game_test");     // Catch: Exception -> L47
            r108.put(AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP, r100.f469955h0);     // Catch: Exception -> L47
            r108.put(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, r100.f469959j0);     // Catch: Exception -> L47
            r108.put(IPerformanceManager.MODULE_LIVE_GAME_PLATFORM, this.f54027d);     // Catch: Exception -> L47
            r108.put("need_show_success_notice_native", false);     // Catch: Exception -> L47
            r108.put("reserve_type", 1);     // Catch: Exception -> L47
            r108.put("reserve_version_num", "");     // Catch: Exception -> L47
        L48:
            Unit r109 = Unit.INSTANCE;
            Disposable r119 = r101.g(r102, r103, r211, r107, r108, new a(r210));
            if (r119 == null) goto L54;
            this.f54024a.f54020d.add(r119);
            return;
        L54:
            return;
        L30:
            String r120 = r100.f469939J;     // Catch: Exception -> L47
            r101.getClass();     // Catch: Exception -> L47
            Long r121 = Long.valueOf(com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e.a.k(r120));     // Catch: Exception -> L47
            if (r121.longValue() == 0) goto L33;
            boolean r122 = true;
        L34:
            Long r123 = null;
            if (r122 == true) goto L38;
            r121 = null;
        L38:
            if (r121 != null) goto L42;
            Room r124 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();     // Catch: Exception -> L47
            if (r124 == null) goto L43;
            r123 = r124.getRoomId();     // Catch: Exception -> L47
        L43:
            if (r123 == null) goto L45;
            r117 = r123.longValue();     // Catch: Exception -> L47
            goto L45
        L42:
            r123 = r121;
            goto L43
        L33:
            r122 = false;
        L47:
            yr.c.b("BetaApplyDownloadEffect", "orderGame build param error");
            goto L48
        L20:
            r114 = r106;
            goto L21
        L16:
            r111 = r105;
            goto L17
        L12:
            r110 = r104;
            goto L13
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sve_core.w
    public final void e() {
        if (this.f54020d.isDisposed() == true) goto L6;
        this.f54020d.dispose();
        return;
    }

    public final Map<String, String> h() {
        String r100 = "";
        Long r101 = null;
        dt.b r102 = (dt.b) Store.useConstant$default(this.f248705c, dt.e.f469988b, null, 2, null);
        String r103 = r102.f469981v;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r103) == true) goto L6;
    L17:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        LinkedHashMap r105 = new LinkedHashMap();
        int r106 = r102.P;
        boolean r107 = false;
        long r108 = 0;
        if (r106 == 0) goto L26;
        if (r106 != 1) goto L40;
        com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e.a r109 = com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e.f54831i;
        String r110 = r102.R;
        r109.getClass();
        r108 = com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e.a.k(r110);
    L40:
        r105.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, String.valueOf(r108));
        String r111 = r102.F;
        if (r111 != null) goto L43;
        r111 = "";
    L43:
        r105.put("game_id", r111);
        r105.put("scene", String.valueOf(r102.P));
        if (r102.Q.length() <= 0) goto L46;
        boolean r112 = true;
    L47:
        if (r112 == false) goto L49;
        String r113 = r102.Q;
    L57:
        r105.put("author_id", r113);
        r105.put(ILoadStallMonitor.START_TIME, String.valueOf(System.currentTimeMillis() / ((long) 1000)));
        String r114 = r102.f469939J;
        if (r114 != null) goto L60;
        r114 = "";
    L60:
        r105.put("room_id", r114);
        String r115 = r102.R;
        if (r115 != null) goto L63;
        r115 = "";
    L63:
        r105.put("video_id", r115);
        String r116 = r102.C;
        if (r116 != null) goto L66;
        r116 = "";
    L66:
        r105.put(EventConstants.ExtraJson.GAME_NAME, r116);
        String r117 = r102.O;
        if (r117 != null) goto L69;
        r117 = "";
    L69:
        r105.put("start_page", r117);
        String r118 = r102.f469959j0;
        if (r118 != null) goto L72;
        r118 = "";
    L72:
        r105.put(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, r118);
        r105.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r102.f469943b0);
        r105.put("biz_type", String.valueOf(r102.f469941a0));
        Integer r119 = r102.f469951f0;
        if (r119 == null) goto L78;
        String r120 = String.valueOf(r119.intValue());
        if (r120 == null) goto L78;
        r100 = r120;
    L78:
        r105.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_MODE, r100);
        r105.put("promote_scene_sub", r103);
        return r105;
    L49:
        String r121 = r102.I;
        if (r121 != null) goto L52;
    L56:
        r113 = "";
        goto L57
    L52:
        if (r121.length() <= 0) goto L54;
        r107 = true;
    L54:
        if (r107 != true) goto L56;
        r113 = r102.I;
        goto L57
    L46:
        r112 = false;
        goto L47
    L26:
        com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e.a r122 = com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e.f54831i;
        String r123 = r102.f469939J;
        r122.getClass();
        Long r124 = Long.valueOf(com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e.a.k(r123));
        if (r124.longValue() == 0) goto L29;
        boolean r125 = true;
    L30:
        if (r125 == true) goto L33;
        r124 = null;
    L33:
        if (r124 != null) goto L37;
        Room r126 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r126 == null) goto L38;
        r101 = r126.getRoomId();
    L38:
        if (r101 == null) goto L40;
        r108 = r101.longValue();
        goto L40
    L37:
        r101 = r124;
        goto L38
    L29:
        r125 = false;
        goto L30
    L6:
        if (TextUtils.isEmpty(r102.L) == true) goto L17;
        String r127 = r102.L;     // Catch: Throwable -> L19
        if (r127 == null) goto L10;
        JSONObject r128 = new JSONObject(r127);     // Catch: Throwable -> L19
    L12:
        if (r128 == null) goto L15;
        String r129 = r128.optString("dygame_track_context");     // Catch: Throwable -> L19
        if (r129 == null) goto L15;
    L16:
        r103 = new JSONObject(r129).optString("promote_scene_sub", "");     // Catch: Throwable -> L19
    L15:
        r129 = "";
        goto L16
    L10:
        r128 = null;
    L19:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public k(Store r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        super(r100);
        this.f54020d = new CompositeDisposable();
    }

    public final void g(Context r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "loginSuccess");
        if (com.bytedance.android.gamecp.host_api.a.b().getUserService().isLogin() == true) goto L5;
        Disposable r102 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user().c(r100, new com.bytedance.android.gamecp.host_api.model.user.c(new com.bytedance.android.gamecp.host_api.model.user.c.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r101), c.f54023a);
        this.f54020d.add(r102);
        return;
    L5:
        r101.invoke();
    }

    public final Observable<Pair<Boolean, String>> i(Context r100, int r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return Observable.create(new d(this, r101, r100, r110));
    }
}
