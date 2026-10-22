package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.host_api.model.user.IUser;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ies.sve_core.Store;
import com.bytedance.ies.sve_core.o;
import com.bytedance.ies.sve_core.w;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import io.reactivex.Observable;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class NewBetaApplySignUpEffect extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f54068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f54069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f54070f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f54071a;

        public b(Function0 r100) {
            this.f54071a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IUser r101 = (IUser) r100;
            this.f54071a.invoke();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f54072a = null;

        static {
            f54072a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            String r102 = r101.getMessage();
            if (r102 == null) goto L6;
            yr.c.b("NewBetaApplySignUpEffect", r102);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewBetaApplySignUpEffect f54073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.sve_core.a f54074b;

        public d(NewBetaApplySignUpEffect r100, com.bytedance.ies.sve_core.a r101) {
            this.f54073a = r100;
            this.f54074b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            fw.b r101 = (fw.b) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if ((!Intrinsics.areEqual(r101.f478996a, "new_game_beta_test_survey_submit")) == true) goto L30;
            Map<String, Object> r102 = r101.f478997b;     // Catch: Exception -> L23
            if (r102 == null) goto L18;
            boolean r103 = Boolean.parseBoolean(String.valueOf(r102.get("is_success")));     // Catch: Exception -> L23
            String r104 = String.valueOf(r102.get("click_from"));     // Catch: Exception -> L23
            if (r103 == true) goto L12;
            ToastUtil.a(R.string.gamecp_game_detail_beta_apply_sign_up_fail);     // Catch: Exception -> L23
            goto L18
        L12:
            NewBetaApplySignUpEffect r105 = this.f54073a;     // Catch: Exception -> L23
            r105.f54070f = true;     // Catch: Exception -> L23
            JSONObject r106 = com.bytedance.android.gamecp.business.gamedetail.util.d.a("beta_apply_button_v4");     // Catch: Exception -> L23
            if (r106 == null) goto L17;
            JSONObject r107 = r106.optJSONObject("data");     // Catch: Exception -> L23
            if (r107 == null) goto L17;
            r107.put("is_applied", r105.f54070f);     // Catch: Exception -> L23
        L17:
            NewBetaApplySignUpEffect r108 = this.f54073a;     // Catch: Exception -> L23
            com.bytedance.ies.sve_core.a r109 = this.f54074b;     // Catch: Exception -> L23
            Context r110 = ((k) r109).f54131a;     // Catch: Exception -> L23
            int r111 = ((k) r109).f54139i;     // Catch: Exception -> L23
            long r112 = ((k) r109).f54133c;     // Catch: Exception -> L23
            r108.getClass();     // Catch: Exception -> L23
            Observable r113 = Observable.create(new com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton.a(r108, r111, r110, r112));     // Catch: Exception -> L23
            hv.b r114 = hv.d.f487273a;     // Catch: Exception -> L23
            r113.compose(new hv.a()).subscribe(new com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton.b(r104, this), com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton.c.f54096a);     // Catch: Exception -> L23
        L18:
            NewBetaApplySignUpEffect r115 = this.f54073a;     // Catch: Exception -> L23
            int r116 = com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup.f.f53819b;     // Catch: Exception -> L23
            Pair r117 = r115.c(com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup.f.a.a());     // Catch: Exception -> L23
            o r118 = (o) r117.component1();     // Catch: Exception -> L23
            Function1 r119 = (Function1) r117.component2();     // Catch: Exception -> L23
            if (((com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup.f) r118.b()) == null) goto L29;
            r119.invoke(new com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup.f(this.f54073a.f54070f));     // Catch: Exception -> L23
            return;
        L29:
            return;
        L23:
            e = move-exception;
            yr.c.b("NewBetaApplyButtonItemWidget", e.toString());
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sve_core.w
    public final void e() {
        if (this.f54068d.isDisposed() == true) goto L6;
        this.f54068d.dispose();
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

    public NewBetaApplySignUpEffect(Store r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        super(r100);
        new CompositeDisposable();
        this.f54068d = new CompositeDisposable();
    }

    @Override // com.bytedance.ies.sve_core.h
    public final void a(final com.bytedance.ies.sve_core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof k) == false) goto L6;
        com.bytedance.android.gamecp.host_api.a.b().getBrowserService().registerJsEventSubscriber("new_game_beta_test_survey_submit").observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r100));
        return;
    L6:
        if ((r100 instanceof com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton.d) == false) goto L23;
        com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton.d r101 = (com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton.d) r100;
        if (r101.f54101e == false) goto L12;
        ToastUtil.b(r101.f54103g, 0);
        return;
    L12:
        if (r101.f54100d == true) goto L20;
        ToastUtil.a(R.string.gamecp_game_detail_beta_apply_sign_up_un_support);
        return;
    L20:
        g(((com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton.d) r100).f54097a, new NewBetaApplySignUpEffect$receiveAction$2(r100));     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        yr.c.b("NewBetaApplySignUpEffect", e.toString());
        return;
    }

    public final void g(Context r100, Function0<Unit> r101) {
        if (com.bytedance.android.gamecp.host_api.a.b().getUserService().isLogin() == true) goto L5;
        Disposable r102 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user().c(r100, new com.bytedance.android.gamecp.host_api.model.user.c(new com.bytedance.android.gamecp.host_api.model.user.c.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r101), c.f54072a);
        this.f54068d.add(r102);
        return;
    L5:
        r101.invoke();
    }
}
