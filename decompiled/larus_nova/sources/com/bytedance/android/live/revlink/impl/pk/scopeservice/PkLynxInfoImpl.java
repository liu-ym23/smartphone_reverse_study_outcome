package com.bytedance.android.live.revlink.impl.pk.scopeservice;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.link.biz.doublecomponent.LynxUIOperationImpl;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.revenue.platform.api.core.rx.f;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class PkLynxInfoImpl implements k {
    public static final /* synthetic */ int E = 0;
    public final boolean A;
    public final ld.a B;
    public final com.bytedance.android.livesdk.revenue.service.room.c C;
    public final Function3<vy0.a<Object>, Uri, Function1<? super yy0.c, Unit>, zy0.b> D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f96799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zy0.b f96800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<String> f96801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<ArrayList<String>> f96802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f96803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f96804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LynxPkState f96805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PkBaseResult f96806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f96807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f96808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f96809k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PkLynxInfoImpl$pkStateObserver$1 f96810l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PkLynxInfoImpl$timeLeftObserver$1 f96811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PkLynxInfoImpl$pkTeamTaskLynxDataObserver$1 f96812n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PkLynxInfoImpl$pkResultObserver$1 f96813o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f96814p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final PkLynxInfoImpl$pkTeamTaskObserver$1 f96815q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PkLynxInfoImpl$pkConsecutiveWinObserver$1 f96816r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PkLynxInfoImpl$firstUpdateObserver$1 f96817s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f96818t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e f96819u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c f96820v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.vm.pk.e f96821w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g41.a f96822x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f96823y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.b f96824z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/scopeservice/PkLynxInfoImpl$LynxPkResult;", "", "", "code", "I", "getCode", "()I", "UNDEFINE", "SUCCESS", "FAILURE", "TIE", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LynxPkResult extends Enum<LynxPkResult> {
        public static final LynxPkResult FAILURE = null;
        public static final LynxPkResult SUCCESS = null;
        public static final LynxPkResult TIE = null;
        public static final LynxPkResult UNDEFINE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxPkResult[] f96825a = null;
        private final int code;

        static {
            LynxPkResult r100 = new LynxPkResult("UNDEFINE", 0, -1);
            UNDEFINE = r100;
            LynxPkResult r101 = new LynxPkResult("SUCCESS", 1, 1);
            SUCCESS = r101;
            LynxPkResult r102 = new LynxPkResult("FAILURE", 2, 2);
            FAILURE = r102;
            LynxPkResult r103 = new LynxPkResult("TIE", 3, 3);
            TIE = r103;
            f96825a = new LynxPkResult[]{r100, r101, r102, r103};
        }

        public static LynxPkResult valueOf(String r100) {
            return (LynxPkResult) r27.a.a(LynxPkResult.class, r100);
        }

        public static LynxPkResult[] values() {
            return (LynxPkResult[]) f96825a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public LynxPkResult(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/scopeservice/PkLynxInfoImpl$LynxPkState;", "", "", "code", "I", "getCode", "()I", UserProfileEvent.POSITION_NONE, "PK", "PK_SETTLE", "PUNISH", "LINKING", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LynxPkState extends Enum<LynxPkState> {
        public static final LynxPkState LINKING = null;
        public static final LynxPkState NONE = null;
        public static final LynxPkState PK = null;
        public static final LynxPkState PK_SETTLE = null;
        public static final LynxPkState PUNISH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxPkState[] f96826a = null;
        private final int code;

        static {
            LynxPkState r100 = new LynxPkState(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            LynxPkState r101 = new LynxPkState("PK", 1, 1);
            PK = r101;
            LynxPkState r102 = new LynxPkState("PK_SETTLE", 2, 2);
            PK_SETTLE = r102;
            LynxPkState r103 = new LynxPkState("PUNISH", 3, 3);
            PUNISH = r103;
            LynxPkState r104 = new LynxPkState("LINKING", 4, 4);
            LINKING = r104;
            f96826a = new LynxPkState[]{r100, r101, r102, r103, r104};
        }

        public static LynxPkState valueOf(String r100) {
            return (LynxPkState) r27.a.a(LynxPkState.class, r100);
        }

        public static LynxPkState[] values() {
            return (LynxPkState[]) f96826a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public LynxPkState(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$attach$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lb03/b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lb03/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<b03.b, Unit> {
        public AnonymousClass7(PkLynxInfoImpl r100) {
            super(1, r100, PkLynxInfoImpl.class, "onPlatformConfigChanged", "onPlatformConfigChanged(Lcom/bytedance/android/platform/PlatformConfig;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(b03.b r100) {
            PkLynxInfoImpl r101 = (PkLynxInfoImpl) this.receiver;
            if (r101.f96822x.a() == false) goto L7;
            com.bytedance.android.live.revlink.impl.pk.scopeservice.b r102 = r101.f96824z;
            r101.f96822x.isPortrait();
            r102.d();
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(b03.b r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkLynxInfoImpl f96827a;

        public b(PkLynxInfoImpl r100) {
            this.f96827a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            PkLynxInfoImpl r102 = this.f96827a;
            r102.getClass();
            JSONObject r103 = new JSONObject();
            r103.put("type", "remain_time");
            r103.put("data", 0);
            r102.f(r103);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkLynxInfoImpl f96828a;

        public c(PkLynxInfoImpl r100) {
            this.f96828a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            cy0.e.f465759a.getClass();
            j r102 = cy0.e.a.f465760a;
            m.f163449e.getClass();
            Object r103 = m.b(r102).b(vr2.a.class);
            Intrinsics.checkNotNull(r103);
            if (((vr2.a) ((com.bytedance.live.kmp.core.c) r103)).S8(Boolean.valueOf(this.f96828a.A)) == false) goto L16;
            Object r104 = m.b(r102).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
            Intrinsics.checkNotNull(r104);
            if (((com.bytedance.android.livesdk.revenue.service.interact.d) ((com.bytedance.live.kmp.core.c) r104)).Sl() == true) goto L17;
            PkLynxInfoImpl r105 = this.f96828a;
            Intrinsics.checkNotNullParameter(r105, "$this$clearScreenLinkUtils");
            if (i.getContext(r105).getClearScreenLinkUtils().b() == true) goto L13;
            PkLynxInfoImpl r106 = this.f96828a;
            Intrinsics.checkNotNullParameter(r106, "$this$clearScreenLinkUtils");
            if (i.getContext(r106).getClearScreenLinkUtils().a() == true) goto L13;
            boolean r107 = false;
        L14:
            r105.f96824z.g(!r107);
            return;
        L13:
            r107 = true;
            goto L14
        L17:
            return;
        }
    }

    static {
    }

    public final void attach() {
        this.f96819u.getPkBaseState().observeForever(this.f96810l);
        this.f96819u.getBaseTimeLeft().observeForever(this.f96811m);
        this.f96819u.getPkBaseResult().observeForever(this.f96813o);
        this.f96820v.getTeamTaskOptAddition().observeForever(this.f96815q);
        String r100 = this.f96821w.getPkTeamTaskLynxData().getValue();
        if (r100 == null) goto L5;
        c(r100);
    L5:
        this.f96821w.getPkTeamTaskLynxData().observeForever(this.f96812n);
        ArrayList<String> r101 = this.f96821w.getHandlePkConsecutiveWin().getValue();
        if (r101 != null) goto L8;
    L17:
        this.f96821w.getHandlePkConsecutiveWin().observeForever(this.f96816r);
        this.f96821w.getHandleTeamTaskOverLine().observeForever(this.f96818t);
        this.f96821w.getHandleFirstUpdateMessage().observeForever(this.f96817s);
        this.f96807i.add(this.f96820v.getInstallKillMsgEvent().subscribe(new b(this)));
        if (d51.b.f466913m.a() == false) goto L20;
        p0.a(0, false, true, new AnonymousClass5(this), 3);
    L21:
        StringBuilder r102 = new StringBuilder("load start time = ");
        Intrinsics.checkNotNullParameter(i97.a.f488802a, "$this$elapsedRealtime");
        r102.append(SystemClock.elapsedRealtime());
        jy0.b.d("PkLynxInfoWidget", r102.toString());
        if (this.f96822x.a() == false) goto L25;
        com.bytedance.android.live.revlink.impl.pk.scopeservice.b r103 = this.f96824z;
        this.f96822x.isPortrait();
        r103.d();
    L25:
        f.a(ld.c.a(this.B.getCleanMode()).subscribe(new c(this)), this.f96807i);
        z41.b.f569897d.getClass();
        if (z41.b.f569896c.P0() == false) goto L28;
        this.f96824z.h();
    L28:
        f.a(UtilsKt.d(this.f96824z.b(), new AnonymousClass7(this)), this.f96807i);
        return;
    L20:
        b(WidgetCostModule.TYPE_ON_CREATE);
        goto L21
    L8:
        if (i.o(this).d() == true) goto L17;
        if (i.o(this).i() == true) goto L17;
        Intrinsics.checkNotNullParameter(r101, "message");
        if (this.f96803e == false) goto L15;
        d(r101);
        goto L17
    L15:
        if ((!r101.isEmpty()) == false) goto L17;
        this.f96802d.addLast(r101);
        goto L17
    }

    public final void g() {
        if (this.f96805g != LynxPkState.PUNISH) goto L28;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r100 = i.o(this);
        if (r100 != null) goto L7;
    L8:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r101 = i.o(this);
        if (r101 != null) goto L11;
    L13:
        PkBaseResult r102 = this.f96806h;
        int r103 = com.bytedance.android.live.revlink.impl.pk.scopeservice.c.f96836a[r102.ordinal()];
        if (r103 != 1) goto L16;
        LynxPkResult r104 = LynxPkResult.SUCCESS;
    L24:
        if (r104 == LynxPkResult.UNDEFINE) goto L31;
        JSONObject r105 = new JSONObject();
        r105.put("type", "pk_result");
        r105.put("data", r104.getCode());
        e(r105);
        return;
    L31:
        return;
    L16:
        if (r103 != 2) goto L18;
        r104 = LynxPkResult.FAILURE;
        goto L24
    L18:
        if (r103 == 3) goto L20;
        r104 = LynxPkResult.UNDEFINE;
        goto L24
    L20:
        r104 = LynxPkResult.TIE;
        goto L24
    L11:
        if (r101.i() != true) goto L13;
        return;
    L7:
        if (r100.d() != true) goto L8;
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.f96823y;
    }

    private final HybridType getType(zy0.b r100) {
        if (r100 == null) goto L6;
        xy0.a<?> r101 = r100.g();
        if (r101 == null) goto L6;
        return r101.o();
    L6:
        return null;
    }

    public final void b(String r110) {
        if (this.f96824z.e() == false) goto L7;
        i.R(this).b("PkLynxInfoWidget");
        return;
    L7:
        if (this.f96804f == false) goto L9;
        return;
    L9:
        jy0.b.d("PkLynxInfoWidget", "init lynx from onCreate");
        int r111 = com.bytedance.revenue.platform.api.core.e.f267507a;
        Intrinsics.checkNotNullParameter("sslocal://webcast_lynxview?hybrid_type=lynx", "schemeString");
        Uri.Builder r112 = UriProtector.parse("sslocal://webcast_lynxview?hybrid_type=lynx").buildUpon();
        Uri r100 = com.bytedance.revenue.platform.api.core.e.a(this.f96799a);
        Uri.Builder r101 = r100.buildUpon();
        if (UriProtector.getQueryParameterNames(r100).contains("team_task_type") == true) goto L12;
        h51.a r102 = h51.a.f483870e;
        r102.getClass();
        r101.appendQueryParameter("team_task_type", String.valueOf(((Number) h51.a.f483868c.getValue(r102, h51.a.f483866a[1])).intValue()));
    L12:
        r101.appendQueryParameter("mode_type", String.valueOf(this.f96819u.modType().getType()));
        IBaseUser r103 = this.C.getRoomContext().getCommonRoom().getOwnerKt();
        IBaseUser r104 = null;
        if (r103 == null) goto L15;
        String r105 = r103.getIdString();
    L16:
        r101.appendQueryParameter("anchor_id", r105);
        IBaseUser r106 = this.C.getRoomContext().getCommonRoom().getOwnerKt();
        if (r106 == null) goto L19;
        Intrinsics.checkNotNullParameter(r106, "$this$secUidExt");
        String r107 = r106.getCastSecUid();
    L20:
        r101.appendQueryParameter("sec_anchor_id", r107);
        r101.appendQueryParameter("user_id", this.C.getRoomContext().getCommonUser().getIdString());
        r101.appendQueryParameter("sec_user_id", o.a(this.C.getRoomContext().getCommonUser()));
        com.bytedance.android.livesdk.revenue.service.user.a r108 = i.Y(this).f97675c;
        if (r108 == null) goto L23;
        r104 = r108.b();
    L23:
        if (r104 == null) goto L40;
        String r109 = iz.a.a(r104);
        boolean r113 = false;
        if (r109 != null) goto L27;
    L30:
        boolean r114 = true;
    L31:
        if (r114 == true) goto L33;
        r101.appendQueryParameter("user_id", iz.a.a(r104));
    L33:
        Intrinsics.checkNotNullParameter(r104, "$this$secUidExt");
        String r115 = r104.getCastSecUid();
        if (r115 != null) goto L36;
    L37:
        r113 = true;
    L38:
        if (r113 == true) goto L40;
        Intrinsics.checkNotNullParameter(r104, "$this$secUidExt");
        r101.appendQueryParameter("sec_user_id", r104.getCastSecUid());
        goto L40
    L36:
        if (r115.length() != 0) goto L38;
    L27:
        if (r109.length() == 0) goto L30;
        r114 = false;
    L40:
        r101.appendQueryParameter("room_id", this.C.getRoomContext().getCommonRoom().getIdStr());
        r101.appendQueryParameter("live_pk_enable_contribute_list", "1");
        cy0.e.f465759a.getClass();
        j r116 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r117 = m.b(r116).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r117);
        Uri r118 = r112.appendQueryParameter("url", ((vy0.b) ((f80.a) r117)).appendCommonParams(r101.build().toString())).build();
        zy0.b r119 = this.f96800b;
        if (r119 == null) goto L43;
        r119.dispose();
    L43:
        zy0.b r120 = this.D.invoke(new vy0.a.b(), r118, new PkLynxInfoImpl$createLynxCard$1(this));
        this.f96800b = r120;
        if (r120 == null) goto L49;
        xy0.a<?> r121 = r120.g();
        if (r121 == null) goto L49;
        r121.load();
    L49:
        if (this.f96800b == null) goto L51;
        this.f96804f = true;
    L51:
        this.f96824z.f();
        if (this.f96824z.e() == false) goto L55;
        i.R(this).b("PkLynxInfoWidget");
        return;
    L55:
        return;
    L19:
        r107 = null;
        goto L20
    L15:
        r105 = null;
        goto L16
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f96819u.getCurPKBaseState().b() == false) goto L6;
        return;
    L6:
        if (this.f96803e == false) goto L8;
        JSONObject r101 = new JSONObject();
        r101.put("type", "refresh");
        r101.put("data", r100);
        r101.put("show_like_reword", false);
        f(r101);
        return;
    L8:
        this.f96801c.addLast(r100);
    }

    public final void d(ArrayList<String> r100) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r101 = new JSONObject();
        r101.put("type", "consecutive_win");
        r101.put("data", new JSONArray(r100));
        f(r101);
    }

    public final void e(JSONObject r100) {
        zy0.b r101 = this.f96800b;
        if (r101 == null) goto L8;
        xy0.a<?> r102 = r101.g();
        if (r102 == null) goto L9;
        r102.sendJsEvent("H5_webcastNotification", r100.toString());
        return;
    L9:
        return;
    }

    public final void f(JSONObject r100) {
        PkBaseStateMachine.c r101 = this.f96819u.getCurPKBaseState();
        r101.getClass();
        if ((r101 instanceof PkBaseStateMachine.c.d) == false) goto L5;
        return;
    L5:
        e(r100);
    }

    public final void h(w2 r100) {
        JSONObject r101 = new JSONObject();
        r101.put("type", "shell_config");
        if (r100 == null) goto L5;
        r101.put("data", GsonProtectorUtils.toJson(l97.a.f508113a, r100));
    L5:
        e(r101);
    }

    public static final /* synthetic */ HybridType a(PkLynxInfoImpl r100, zy0.b r101) {
        return r100.getType(r101);
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$timeLeftObserver$1] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$pkTeamTaskLynxDataObserver$1] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$pkResultObserver$1] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$pkTeamTaskObserver$1] */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$pkConsecutiveWinObserver$1] */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$firstUpdateObserver$1] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl$pkStateObserver$1] */
    public PkLynxInfoImpl(e r100, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r101, com.bytedance.android.live.revlink.impl.pk.vm.pk.e r102, com.bytedance.android.live.revlink.link.biz.doublecomponent.d r103, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r104, LynxUIOperationImpl r105, boolean r106, ld.a r107, com.bytedance.android.livesdk.revenue.service.room.c r110, Function3 r111) {
        Intrinsics.checkNotNullParameter(r100, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r101, "pkDataContext");
        Intrinsics.checkNotNullParameter(r102, "pkLynxInfoViewModel");
        Intrinsics.checkNotNullParameter(r103, "layoutManager");
        Intrinsics.checkNotNullParameter(r104, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r105, "uiOperation");
        Intrinsics.checkNotNullParameter(r107, "linkDataSet");
        Intrinsics.checkNotNullParameter(r110, "revRoomService");
        Intrinsics.checkNotNullParameter(r111, "createCardFunc");
        this.f96819u = r100;
        this.f96820v = r101;
        this.f96821w = r102;
        this.f96822x = r103;
        this.f96823y = r104;
        this.f96824z = r105;
        this.A = r106;
        this.B = r107;
        this.C = r110;
        this.D = r111;
        d51.a r108 = d51.a.f466900g;
        r108.getClass();
        this.f96799a = (String) d51.a.f466895b.getValue(r108, d51.a.f466894a[0]);
        this.f96801c = new ArrayDeque();
        this.f96802d = new ArrayDeque();
        this.f96805g = LynxPkState.NONE;
        this.f96806h = PkBaseResult.NOT_FINISH;
        this.f96807i = new CompositeDisposable();
        this.f96810l = new PkLynxInfoImpl$pkStateObserver$1(this);
        this.f96811m = new PkLynxInfoImpl$timeLeftObserver$1(this);
        this.f96812n = new PkLynxInfoImpl$pkTeamTaskLynxDataObserver$1(this);
        this.f96813o = new PkLynxInfoImpl$pkResultObserver$1(this);
        this.f96815q = new PkLynxInfoImpl$pkTeamTaskObserver$1(this);
        this.f96816r = new PkLynxInfoImpl$pkConsecutiveWinObserver$1(this);
        this.f96817s = new PkLynxInfoImpl$firstUpdateObserver$1(this);
        this.f96818t = new d(this);
    }
}
