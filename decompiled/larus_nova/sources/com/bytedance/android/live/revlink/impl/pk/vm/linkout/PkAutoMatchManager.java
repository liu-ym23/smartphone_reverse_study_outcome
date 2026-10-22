package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revlink.impl.control.s;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomCheckDataContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class PkAutoMatchManager implements com.bytedance.android.live.revlink.impl.pk.service.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f97149p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f97150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f97151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f97152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PkAutoMatchDataContext f97153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RandomCheckDataContext f97154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f97155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zy0.d f97156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f97157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m f97158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f97159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.vm.linkout.a f97160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ld.a f97161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f97162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f97163n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final yz0.f f97164o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkAutoMatchManager$AutoMatchRequestSource;", "", "FromPkList", "FromRecordList", "FromJsb", "FromSeasonRank", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AutoMatchRequestSource extends Enum<AutoMatchRequestSource> {
        public static final AutoMatchRequestSource FromJsb = null;
        public static final AutoMatchRequestSource FromPkList = null;
        public static final AutoMatchRequestSource FromRecordList = null;
        public static final AutoMatchRequestSource FromSeasonRank = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AutoMatchRequestSource[] f97165a = null;

        static {
            AutoMatchRequestSource r100 = new AutoMatchRequestSource("FromPkList", 0);
            FromPkList = r100;
            AutoMatchRequestSource r101 = new AutoMatchRequestSource("FromRecordList", 1);
            FromRecordList = r101;
            AutoMatchRequestSource r102 = new AutoMatchRequestSource("FromJsb", 2);
            FromJsb = r102;
            AutoMatchRequestSource r103 = new AutoMatchRequestSource("FromSeasonRank", 3);
            FromSeasonRank = r103;
            f97165a = new AutoMatchRequestSource[]{r100, r101, r102, r103};
        }

        public static AutoMatchRequestSource valueOf(String r100) {
            return (AutoMatchRequestSource) r27.a.a(AutoMatchRequestSource.class, r100);
        }

        public static AutoMatchRequestSource[] values() {
            return (AutoMatchRequestSource[]) f97165a.clone();
        }

        public AutoMatchRequestSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkAutoMatchManager f97166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f97167b;

        @Override // com.bytedance.android.live.revlink.impl.control.s
        public final void onDismiss() {
            this.f97166a.f97150a = false;
            s r100 = this.f97167b;
            if (r100 == null) goto L6;
            r100.onDismiss();
            return;
        }

        public b(PkAutoMatchManager r100, s r101) {
            this.f97166a = r100;
            this.f97167b = r101;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final NextLiveData<y31.k> b() {
        PkAutoMatchDataContext r100 = this.f97153d;
        if (r100 == null) goto L7;
        NextLiveData<y31.k> r101 = r100.getMInvitingUserData();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new NextLiveData();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final h0 d() {
        PkAutoMatchDataContext r100 = this.f97153d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.pkAutoMatchLogInfo();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final void dismissDialog() {
        this.f97160k.f();
        this.f97150a = false;
        zy0.d r100 = this.f97156g;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f97156g = null;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final List<i41.p> getListeners() {
        PkAutoMatchDataContext r100 = this.f97153d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getListeners();
    }

    public final void h() {
        Pair r100 = com.bytedance.live.datacontext.d.a(PkAutoMatchManager$addRandomCheckDataContext$pair$1.INSTANCE);
        RandomCheckDataContext r101 = (RandomCheckDataContext) r100.getFirst();
        this.f97154e = r101;
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.getRandomChecked();
        if (r102 == null) goto L7;
        r102.setValue(Boolean.valueOf(l51.a.d()));
    L7:
        RandomCheckDataContext r103 = this.f97154e;
        if (r103 == null) goto L10;
        com.bytedance.live.datacontext.b.a(r103, RandomCheckDataContext.TAG);
    L10:
        this.f97152c.add((Disposable) r100.getSecond());
    }

    public final d31.d i() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.f97163n;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRevLinkLogHelper();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final boolean isInviting() {
        PkAutoMatchDataContext r100 = this.f97153d;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isInviting();
    }

    public final void j() {
        this.f97152c.dispose();
        PkAutoMatchDataContext r100 = this.f97153d;
        if (r100 == null) goto L7;
        LiveData<Long> r101 = r100.getLeftTime();
        if (r101 == null) goto L7;
        r101.removeObserver(this.f97157h);
    L7:
        PkAutoMatchDataContext r102 = this.f97153d;
        if (r102 == null) goto L12;
        LiveData<Long> r103 = r102.getWaitedTime();
        if (r103 == null) goto L12;
        r103.removeObserver(this.f97158i);
    L12:
        PkAutoMatchDataContext r104 = this.f97153d;
        if (r104 == null) goto L17;
        LiveData<l41.a> r105 = r104.getPkMatchState();
        if (r105 == null) goto L17;
        r105.removeObserver(this.f97159j);
    L17:
        PkAutoMatchDataContext r106 = this.f97153d;
        if (r106 == null) goto L21;
        r106.clearIt();
        return;
    }

    public static final com.bytedance.android.live.revlink.impl.pk.service.i g(PkAutoMatchManager r100) {
        com.bytedance.android.live.revlink.impl.global.c r101 = r100.f97163n;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.Hg();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final void a(final com.bytedance.android.live.revlink.impl.pk.service.j r110) {
        Intrinsics.checkNotNullParameter(r110, "autoMatchParams");
        com.bytedance.android.live.revlink.impl.global.c r100 = this.f97163n;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r101 = null;
        if (r100 == null) goto L5;
        ox0.a r102 = r100.getModeMerge();
    L7:
        if (r102 == null) goto L9;
        int r103 = r102.a();
    L11:
        if (com.bytedance.android.live.utils.c.a(r103, 32) == false) goto L15;
        if (e51.b.f471043d.a() == true) goto L15;
    L16:
        int r104 = ToastUtil.f90810a;
        int r105 = w11.a.f557889a;
        ToastUtil.a(R.string.ttlive_interact_pk_started, 0);
        if (r110.f96859a != 12) goto L90;
        com.bytedance.android.live.revlink.impl.global.c r106 = this.f97163n;
        if (r106 == null) goto L21;
        q r107 = r106.getMultiAnchorLinkLogUtils();
    L22:
        if (r107 == null) goto L90;
        r107.w(r110, "fail_for_audience_connection");
        goto L90
    L21:
        r107 = null;
    L90:
        boolean r108 = false;
    L91:
        if (r108 == true) goto L94;
        r110.f96864f.b();
        return;
    L94:
        com.bytedance.android.livesdk.revenue.service.room.c r109 = this.f97162m;
        if (r109 == null) goto L101;
        com.bytedance.android.livesdk.revenue.room.a r111 = r109.getRoomContext();
        if (r111 == null) goto L101;
        IRoomBase r112 = r111.getCommonRoom();
        if (r112 == null) goto L101;
        IRoom r113 = (IRoom) r112;
    L102:
        if (r113 == null) goto L104;
        long r114 = IRoomKtKt.getId(r113);
    L105:
        long r115 = r114;
        Intrinsics.checkNotNullParameter(r110, "autoMatchParams");
        this.f97151b = false;
        PkAutoMatchDataContext r116 = this.f97153d;
        if (r116 == null) goto L108;
        r116.setJsbInvitePkCallback(r110.f96864f);
    L108:
        b51.b r117 = b51.b.f17721c0;
        r117.getClass();
        b51.a r118 = (b51.a) b51.b.f17744z.getValue(r117, b51.b.f17716a[24]);
        PkAutoMatchDataContext r119 = this.f97153d;
        if (r119 == null) goto L111;
        r119.startMatch(r115, false, r110.f96863e, r110.f96859a, r110.f96862d, r110.f96860b, r110.f96865g, new PkAutoMatchManager$startAutoMatchWithJsb$1(this, r110));
    L111:
        com.bytedance.android.live.revlink.impl.global.c r120 = this.f97163n;
        if (r120 == null) goto L114;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r121 = r120.getLinkOptLogContext();
    L116:
        if (r121 == null) goto L118;
        String r122 = r110.f96861c;
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        r121.f93593c = r122;
    L118:
        com.bytedance.android.live.revlink.impl.global.c r123 = this.f97163n;
        if (r123 == null) goto L121;
        r101 = r123.getLinkOptLogContext();
    L121:
        if (r101 == null) goto L124;
        String r124 = r110.f96860b;
        Intrinsics.checkNotNullParameter(r124, "<set-?>");
        r101.f93594d = r124;
        return;
    L124:
        return;
    L114:
        r121 = null;
        goto L116
    L104:
        r114 = 0;
    L101:
        r113 = null;
    L15:
        if (com.bytedance.android.live.utils.c.a(r103, 8) == true) goto L16;
        if (com.bytedance.android.live.utils.c.a(r103, 4) == false) goto L27;
    L89:
        int r125 = ToastUtil.f90810a;
        int r126 = w11.a.f557889a;
        ToastUtil.a(R.string.ttlive_interact_pk_started, 0);
        goto L90
    L27:
        if (com.bytedance.android.live.utils.c.a(r103, 64) == true) goto L89;
        cy0.e.f465759a.getClass();
        cy0.j r127 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r128 = com.bytedance.android.scope.m.b(r127).b(IRevBroadcastService.class);
        Intrinsics.checkNotNull(r128);
        if (((IRevBroadcastService) ((com.bytedance.live.kmp.core.c) r128)).isPlayingGame() == false) goto L32;
        int r129 = ToastUtil.f90810a;
        int r130 = w11.a.f557889a;
        ToastUtil.a(R.string.ttlive_pk_game_quit_close, 0);
        goto L90
    L32:
        com.bytedance.android.live.revlink.impl.global.c r131 = this.f97163n;
        if (r131 == null) goto L35;
        IPKLinkBizDataService r132 = r131.mk();
    L36:
        if (r132 == null) goto L38;
        q11.c r133 = r132.mo8199getPkLinkState();
    L40:
        if (Intrinsics.areEqual(r133, q11.c.C7266c.f531279b) == true) goto L82;
        com.bytedance.android.live.revlink.impl.global.c r134 = this.f97163n;
        if (r134 == null) goto L44;
        IPKLinkBizDataService r135 = r134.mk();
    L45:
        if (r135 == null) goto L47;
        q11.c r136 = r135.mo8199getPkLinkState();
    L49:
        if (Intrinsics.areEqual(r136, q11.c.a.f531277b) == true) goto L82;
        RandomCheckDataContext.a r137 = RandomCheckDataContext.Companion;
        if (r137.getContext() != null) goto L54;
        h();
    L54:
        RandomCheckDataContext r138 = this.f97154e;
        if (r138 == null) goto L59;
        com.bytedance.live.datacontext.m<Boolean> r139 = r138.getRandomChecked();
        if (r139 == null) goto L59;
        r139.setValue(Boolean.valueOf(r137.b()));
    L59:
        RandomCheckDataContext r140 = this.f97154e;
        if (r140 == null) goto L73;
        com.bytedance.live.datacontext.m<Boolean> r141 = r140.getRandomChecked();
        if (r141 == null) goto L73;
        if (r141.getValue().booleanValue() == true) goto L73;
        com.bytedance.android.live.revlink.impl.global.c r142 = this.f97163n;
        if (r142 == null) goto L68;
        com.bytedance.android.live.revlink.impl.service.internal.a r143 = r142.Do();
    L69:
        if (r143 == null) goto L71;
        r143.m();
    L71:
        h();
        this.f97160k.k(r110);
        goto L90
    L68:
        r143 = null;
    L73:
        if (r110.f96859a != 12) goto L80;
        com.bytedance.android.live.revlink.impl.global.c r144 = this.f97163n;
        if (r144 == null) goto L77;
        q r145 = r144.getMultiAnchorLinkLogUtils();
    L78:
        if (r145 == null) goto L80;
        r145.w(r110, "start_matching");
        goto L80
    L77:
        r145 = null;
    L80:
        r108 = true;
        goto L91
    L47:
        r136 = null;
        goto L49
    L44:
        r135 = null;
    L82:
        if (r110.f96859a != 12) goto L90;
        com.bytedance.android.live.revlink.impl.global.c r146 = this.f97163n;
        if (r146 == null) goto L86;
        q r147 = r146.getMultiAnchorLinkLogUtils();
    L87:
        if (r147 == null) goto L90;
        r147.w(r110, "fail_for_inviting");
        goto L90
    L86:
        r147 = null;
        goto L87
    L38:
        r133 = null;
        goto L40
    L35:
        r132 = null;
        goto L36
    L9:
        r103 = 0;
        goto L11
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final void c(s r100) {
        PkAutoMatchDataContext r101 = this.f97153d;
        Long r102 = null;
        if (r101 == null) goto L5;
        af2.e r103 = r101.getAutoMatchModel();
    L7:
        if (r103 == null) goto L9;
    L12:
        b51.b r104 = b51.b.f17721c0;
        r104.getClass();
        ReadOnlyProperty r105 = b51.b.D;
        KProperty<?>[] r106 = b51.b.f17716a;
        if (((Boolean) r105.getValue(r104, r106[28])).booleanValue() == false) goto L54;
        String r107 = (String) b51.b.E.getValue(r104, r106[29]);
        if (r107.length() <= 0) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L54;
        final x0 r109 = new x0(r107);
        x0 r110 = r109.d("url");
        com.bytedance.android.livesdk.revenue.service.room.c r111 = this.f97162m;
        if (r111 == null) goto L26;
        com.bytedance.android.livesdk.revenue.room.a r112 = r111.getRoomContext();
        if (r112 == null) goto L26;
        IRoomBase r113 = r112.getCommonRoom();
        if (r113 == null) goto L26;
        IRoom r114 = (IRoom) r113;
    L27:
        if (r114 == null) goto L29;
        Long r115 = Long.valueOf(IRoomKtKt.getId(r114));
    L30:
        r110.b("room_id", String.valueOf(r115));
        cy0.e.f465759a.getClass();     // Catch: Exception -> L75
        cy0.j r116 = cy0.e.a.f465760a;     // Catch: Exception -> L75
        com.bytedance.android.scope.m.f163449e.getClass();     // Catch: Exception -> L75
        Object r117 = com.bytedance.android.scope.m.b(r116).b(com.bytedance.android.livesdk.revenue.service.user.a.class);     // Catch: Exception -> L75
        Intrinsics.checkNotNull(r117);     // Catch: Exception -> L75
        IBaseUser r118 = ((com.bytedance.android.livesdk.revenue.service.user.a) ((com.bytedance.live.kmp.core.c) r117)).b();     // Catch: Exception -> L75
        if (r118 == null) goto L39;
        py.k r119 = r118.getAvatarThumbKt();     // Catch: Exception -> L75
        if (r119 == null) goto L39;
        List<String> r120 = r119.getUrls();     // Catch: Exception -> L75
        if (r120 == null) goto L39;
        String r121 = (String) ListProtector.get(r120, 0);     // Catch: Exception -> L75
        if (r121 == null) goto L39;
    L40:
        r110.b("business_type", r41.b.a());
        r110.b("group", r41.b.a());
        r110.b("anchor_avatar", r121);
        PkAutoMatchDataContext r122 = this.f97153d;
        if (r122 == null) goto L45;
        LiveData<Long> r123 = r122.getLeftTime();
        if (r123 == null) goto L45;
        Long r124 = r123.getValue();
    L46:
        r110.b("init_left_time", String.valueOf(r124));
        r110.b(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, String.valueOf(1));
        yz0.g r125 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        if (r125 == null) goto L78;
        Context r126 = r125.getContext();
        if (r126 == null) goto L79;
        cy0.e.f465759a.getClass();
        cy0.j r127 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r128 = com.bytedance.android.scope.m.b(r127).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r128);
        HybridDialogImpl r129 = ((vy0.b) ((f80.a) r128)).U0(r126, r109.c(), null);
        this.f97156g = r129;
        if (r129 == null) goto L80;
        r129.j0(new PkAutoMatchManager$handleToolbarPkClick$$inlined$let$lambda$1(this, r109));
        return;
    L80:
        return;
    L79:
        return;
    L78:
        return;
    L45:
        r124 = null;
    L39:
        r121 = "";
        goto L40
    L29:
        r115 = null;
    L26:
        r114 = null;
        goto L27
    L17:
        r108 = false;
    L54:
        PkAutoMatchDataContext r130 = this.f97153d;
        if (r130 == null) goto L59;
        LiveData<Long> r131 = r130.getLeftTime();
        if (r131 == null) goto L59;
        r102 = r131.getValue();
    L59:
        if (r102 != null) goto L62;
    L72:
        com.bytedance.android.live.revlink.impl.pk.vm.linkout.a r132 = this.f97160k;
        PkAutoMatchDataContext r133 = this.f97153d;
        Intrinsics.checkNotNull(r133);
        r132.e(r133);
    L73:
        this.f97160k.h(new b(this, r100));
        this.f97150a = true;
        return;
    L62:
        if (r102.longValue() != 0) goto L72;
        PkAutoMatchDataContext r134 = this.f97153d;
        if (r134 == null) goto L72;
        if (r134.isSpeedUp() == true) goto L72;
        if (this.f97151b == true) goto L72;
        d51.c r135 = d51.c.A0;
        r135.getClass();
        if (((Boolean) d51.c.f466929h.getValue(r135, d51.c.f466915a[6])).booleanValue() == true) goto L72;
        this.f97160k.b();
        this.f97151b = true;
        goto L73
    L9:
        if (r41.b.f536016a == true) goto L12;
        int r136 = ToastUtil.f90810a;
        int r137 = w11.a.f557889a;
        ToastUtil.a(R.string.ttlive_live_loading, 0);
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final void f(AutoMatchSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        PkAutoMatchDataContext r101 = this.f97153d;
        if (r101 == null) goto L5;
        r101.endMatch(r100);
    L5:
        this.f97160k.d();
        this.f97150a = false;
        this.f97151b = false;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.a
    public final void e(long r110, b0 r111, AutoMatchRequestSource r112, Function1 r113) {
        Intrinsics.checkNotNullParameter(r112, "rqs");
        this.f97151b = false;
        if (j.f97244a[r112.ordinal()] == 1) goto L5;
        int r100 = 1;
    L6:
        PkAutoMatchDataContext r101 = this.f97153d;
        if (r101 == null) goto L9;
        PkAutoMatchDataContext.startMatch$default(r101, r110, false, r111, r100, 0, null, null, r113, 96, null);
    L9:
        jy0.b.d("PkAutoMatchManager", "startMatch");
        return;
    L5:
        r100 = 13;
        goto L6
    }

    public PkAutoMatchManager(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a r100, ld.a r101, com.bytedance.android.livesdk.revenue.service.room.c r102, com.bytedance.android.live.revlink.impl.global.c r103, yz0.f r104) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f97160k = r100;
        this.f97161l = r101;
        this.f97162m = r102;
        this.f97163n = r103;
        this.f97164o = r104;
        AutoMatchRequestSource r105 = AutoMatchRequestSource.FromPkList;
        CompositeDisposable r106 = new CompositeDisposable();
        this.f97152c = r106;
        int r107 = r41.c.f536017a;
        this.f97155f = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_anim_pk_random_point.webp";
        l r108 = new l(this);
        this.f97157h = r108;
        m r109 = new m(this);
        this.f97158i = r109;
        k r110 = new k(this);
        this.f97159j = r110;
        PkAutoMatchDataContext r111 = new PkAutoMatchDataContext(r101, r102, r103, r104);
        this.f97153d = r111;
        com.bytedance.live.datacontext.k<String> r112 = r111.getShowPopupEvent();
        if (r112 == null) goto L9;
        PublishSubject r113 = r112.onEvent();
        if (r113 == null) goto L9;
        Disposable r114 = r113.subscribe(new d(this));
        if (r114 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r114, r106);
    L9:
        com.bytedance.live.datacontext.k<Boolean> r115 = r111.getDismissDialogEvent();
        if (r115 == null) goto L16;
        PublishSubject r116 = r115.onEvent();
        if (r116 == null) goto L16;
        Disposable r117 = r116.subscribe(new e(this));
        if (r117 == null) goto L16;
        com.bytedance.revenue.platform.api.core.rx.f.a(r117, r106);
    L16:
        com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.link.model.bridge.s> r118 = r111.getShowMatchInviteDialogEvent();
        if (r118 == null) goto L23;
        PublishSubject r119 = r118.onEvent();
        if (r119 == null) goto L23;
        Disposable r120 = r119.subscribe(new h(this));
        if (r120 == null) goto L23;
        com.bytedance.revenue.platform.api.core.rx.f.a(r120, r106);
    L23:
        com.bytedance.live.datacontext.k<Boolean> r121 = r111.getDismissMatchInviteDialogEvent();
        if (r121 == null) goto L30;
        PublishSubject r122 = r121.onEvent();
        if (r122 == null) goto L30;
        Disposable r123 = r122.subscribe(new i(this));
        if (r123 == null) goto L30;
        com.bytedance.revenue.platform.api.core.rx.f.a(r123, r106);
    L30:
        LiveData<Long> r124 = r111.getLeftTime();
        if (r124 == null) goto L33;
        r124.observeForever(r108);
    L33:
        LiveData<Long> r125 = r111.getWaitedTime();
        if (r125 == null) goto L36;
        r125.observeForever(r109);
    L36:
        LiveData<l41.a> r126 = r111.getPkMatchState();
        if (r126 == null) goto L39;
        r126.observeForever(r110);
    L39:
        Pair r127 = com.bytedance.live.datacontext.d.a(PkAutoMatchManager$pair$1.INSTANCE);
        ((PKAutoMatchServiceContext) r127.getFirst()).getService().d(this);
        com.bytedance.android.live.revlink.impl.global.d.a((DataContext) r127.getFirst(), "IPKAutoMatchService", r103);
        h();
        r106.add((Disposable) r127.getSecond());
    }
}
