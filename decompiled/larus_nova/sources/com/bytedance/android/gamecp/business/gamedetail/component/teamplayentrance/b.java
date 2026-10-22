package com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance;

import android.content.Context;
import com.bytedance.android.gamecp.business.gamedetail.base.AudienceGamePromoteDetailApi;
import com.bytedance.android.gamecp.business.gamedetail.base.ComponentCriteria;
import com.bytedance.android.gamecp.business.patch.GameApkMd5Manager;
import com.bytedance.android.gamecp.host_api.model.user.IUser;
import com.bytedance.ies.sve_core.Store;
import com.bytedance.ies.sve_core.w;
import com.lynx.tasm.LynxError;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f55100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f55101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ yt.a f55102f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance.b$b, reason: collision with other inner class name */
    public static final class C0895b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f55103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.sve_core.a f55104b;

        public C0895b(b r100, com.bytedance.ies.sve_core.a r101) {
            this.f55103a = r100;
            this.f55104b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IUser r101 = (IUser) r100;
            b r102 = this.f55103a;
            String r103 = ((com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance.a) this.f55104b).f55099a;
            r102.getClass();
            com.bytedance.android.gamecp.host_api.a.b().getHostAction().Z0(r102.f55101e, r103);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f55105a = null;

        static {
            f55105a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            yr.c.b("TeamPlayEntranceEffect", "login fail -> " + r101.getMessage());
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sve_core.w
    public final void e() {
        this.f55102f.b();
    }

    public final Context getContext() {
        return this.f55101e;
    }

    @Override // com.bytedance.ies.sve_core.h
    public final void a(com.bytedance.ies.sve_core.a r310) {
        Intrinsics.checkNotNullParameter(r310, "action");
        if ((r310 instanceof com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance.a) == false) goto L9;
        if (com.bytedance.android.gamecp.host_api.a.b().getUserService().isLogin() == false) goto L7;
        com.bytedance.android.gamecp.host_api.a.b().getHostAction().Z0(this.f55101e, ((com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance.a) r310).f55099a);
        return;
    L7:
        Disposable r100 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user().c(this.f55101e, new com.bytedance.android.gamecp.host_api.model.user.c(new com.bytedance.android.gamecp.host_api.model.user.c.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0895b(this, r310), c.f55105a);
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.f55102f.a(r100);
        return;
    L9:
        if ((r310 instanceof h) == false) goto L59;
        Disposable r101 = this.f55100d;
        if (r101 == null) goto L13;
        r101.dispose();
        Intrinsics.checkNotNullParameter(r101, "d");
        yt.a r102 = this.f55102f;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "d");
        r102.f568997a.remove(r101);
    L13:
        Disposable r103 = this.f55100d;
        if (r103 == null) goto L16;
        r103.dispose();
    L16:
        dt.b r104 = (dt.b) b(dt.e.f469988b);
        String r105 = r104.f469958j;
        boolean r106 = false;
        if (r105.length() <= 0) goto L19;
        boolean r107 = true;
    L20:
        Long r108 = null;
        if (r107 == true) goto L24;
        r105 = null;
    L24:
        if (r105 == null) goto L28;
        Integer r109 = StringsKt.toIntOrNull(r105);
        if (r109 == null) goto L28;
        int r110 = r109.intValue();
    L30:
        if (r104.Q.length() <= 0) goto L32;
        boolean r111 = true;
    L34:
        if (r111 == false) goto L36;
        String r112 = r104.Q;
    L43:
        String r113 = r112;
    L45:
        Lazy r114 = GameApkMd5Manager.f56195a;
        Pair r115 = GameApkMd5Manager.d(r104.F, "TeamPlayEntranceEffect.handleRefresh");
        if (r115 == null) goto L49;
        String r116 = (String) r115.getFirst();
        if (r116 == null) goto L49;
    L50:
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r104.E = r116;
        AudienceGamePromoteDetailApi r117 = (AudienceGamePromoteDetailApi) bs.e.a().b(AudienceGamePromoteDetailApi.class);
        String r118 = r104.F;
        String r119 = r104.f469939J;
        String r120 = r104.R;
        if (r120 == null) goto L53;
        r108 = StringsKt.toLongOrNull(r120);
    L53:
        String r121 = r104.G;
        String r122 = r104.f469954h;
        Integer r123 = Integer.valueOf(r110);
        String r124 = r104.f469956i;
        String r125 = r104.Z;
        Integer r210 = Integer.valueOf(r104.f469941a0);
        String r126 = r104.f469943b0;
        Integer r127 = r104.f469951f0;
        String r128 = r104.f469959j0;
        String r129 = r104.f469940a;
        ComponentCriteria r130 = new ComponentCriteria();
        r130.f53477id = "team_play_entrance";
        r130.size = 1;
        Unit r131 = Unit.INSTANCE;
        Observable r132 = AudienceGamePromoteDetailApi.a.a(r117, r118, "live", r113, r119, r108, r121, r122, r123, r124, r125, r210, r126, r127, r130, r128, r129, null, null, r116, 787968).map(com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance.c.f55106a);
        hv.b r133 = hv.d.f487273a;
        Disposable r134 = r132.compose(new hv.a()).subscribe(new d(this), e.f55108a);
        this.f55100d = r134;
        if (r134 == null) goto L60;
        Intrinsics.checkNotNullParameter(r134, "$this$autoDispose");
        this.f55102f.a(r134);
        return;
    L60:
        return;
    L49:
        r116 = "";
        goto L50
    L36:
        String r135 = r104.I;
        if (r135 != null) goto L39;
    L44:
        r113 = "";
        goto L45
    L39:
        if (r135.length() <= 0) goto L41;
        r106 = true;
    L41:
        if (r106 != true) goto L44;
        r112 = r104.I;
        goto L43
    L32:
        r111 = false;
    L28:
        r110 = 0;
        goto L30
    L19:
        r107 = false;
        goto L20
    }

    public b(Context r100, Store r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        super(r101);
        this.f55102f = new yt.a();
        this.f55101e = r100;
    }
}
