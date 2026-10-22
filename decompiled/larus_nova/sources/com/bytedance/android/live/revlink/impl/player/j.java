package com.bytedance.android.live.revlink.impl.player;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.StreamLayoutManager;
import com.bytedance.android.live.revlink.impl.player.layout.DynamicLayoutCalculate;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.revenue.platform.api.core.rx.o;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j implements d, c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f97448m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f97449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f97450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f97451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RevSeiFrame f97452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f97453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DynamicLayoutCalculate f97454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f97455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PublishSubject<h> f97456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f97457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final cy0.c f97458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ld.a f97459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f97460l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void a(int r100) {
        this.f97460l.a(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void c(boolean r100) {
        this.f97460l.c(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void d(boolean r100) {
        this.f97460l.d(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void f(int r100) {
        this.f97460l.f(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void g(boolean r100) {
        this.f97460l.g(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void i(k31.a r100) {
        this.f97460l.i(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void j(int r100) {
        this.f97460l.j(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void k(boolean r100) {
        this.f97460l.k(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void n(boolean r100) {
        this.f97460l.n(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void o(boolean r100) {
        this.f97460l.o(r100);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void q(boolean r100) {
        this.f97460l.q(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void s(LiveMode r100) {
        this.f97460l.s(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void w(int r100) {
        this.f97460l.w(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void x(k31.k r100) {
        this.f97460l.x(r100);
    }

    public final wq2.f E() {
        cy0.c r100 = this.f97458j;
        if (r100 == null) goto L5;
        com.bytedance.android.scope.m.f163449e.getClass();
        return (wq2.f) com.bytedance.android.scope.m.b(r100).b(wq2.f.class);
    L5:
        return null;
    }

    public final void F() {
        ld.a r100 = this.f97459k;
        StringBuilder r101 = new StringBuilder("onMultiAnchorEventChange with event: ");
        k31.a r102 = null;
        if (r100 == null) goto L5;
        NextLiveData<gt1.b> r103 = r100.ho();
    L6:
        r101.append(r103);
        jy0.b.c("RevenueLayoutCore", r101.toString(), null, 4);
        if (r100 == null) goto L18;
        NextLiveData<gt1.b> r104 = r100.ho();
        if (r104 == null) goto L19;
        gt1.b r105 = r104.getValue();
        if (r105 == null) goto L20;
        i r106 = this.f97460l;
        if (r105.c() != 1) goto L16;
        r102 = new k31.a(new k31.g(r105.d(), Integer.valueOf(r105.e())), new k31.n(r105.b(), r105.a()));
    L16:
        r106.i(r102);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final void q1() {
        if (this.f97450b == true) goto L5;
        return;
    L5:
        ld.a r100 = this.f97459k;
        if (this.f97451c == false) goto L24;
        this.f97451c = false;
        if (r100 == null) goto L12;
        NextLiveData<Boolean> r101 = r100.O1();
        if (r101 == null) goto L12;
        r101.setValue(Boolean.FALSE);
    L12:
        if (r100 == null) goto L17;
        NextLiveData<Integer> r102 = r100.a2();
        if (r102 == null) goto L17;
        r102.setValue(0);
    L17:
        if (this.f97460l.f97438i == true) goto L24;
        wq2.f r103 = E();
        if (r103 == null) goto L21;
        r103.Zn(false);
    L21:
        wq2.f r104 = E();
        if (r104 == null) goto L24;
        r104.nj(0);
    L24:
        this.f97450b = false;
        if (r100 == null) goto L29;
        NextLiveData<oq2.e> r105 = r100.Rm();
        if (r105 == null) goto L29;
        r105.setValue(null);
    L29:
        Disposable r106 = this.f97455g;
        if (r106 == null) goto L32;
        r106.dispose();
    L32:
        this.f97455g = null;
        this.f97460l.f97431b = true;
        RevSeiFrame.G.getClass();
        this.f97452d = (RevSeiFrame) RevSeiFrame.D.getValue();
        e r107 = this.f97457i;
        if (r107 == null) goto L36;
        r107.a(0);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final PublishSubject ml() {
        return this.f97456h;
    }

    public final h A(String r110) {
        RevSeiFrame r100 = RevSeiFrame.a.a(RevSeiFrame.G, r110, this.f97460l.f97437h, 2);
        this.f97452d = r100;
        jy0.b.c("RevenueLayoutCore", "onLayoutContextChange start with context: " + this.f97460l, null, 4);
        if (this.f97450b == true) goto L25;
        this.f97450b = true;
        jy0.b.c("RevenueLayoutCore", "onBizStart", null, 4);
        com.bytedance.android.live.revlink.impl.settings.live.c r101 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r101.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.f97606k.getValue(r101, com.bytedance.android.live.revlink.impl.settings.live.c.f97596a[9])).booleanValue() == true) goto L16;
        ld.a r102 = this.f97459k;
        if (r102 == null) goto L15;
        NextLiveData<gt1.b> r103 = r102.ho();
        if (r103 == null) goto L15;
        Observable r104 = ld.c.a(r103);
        if (r104 == null) goto L15;
        Disposable r105 = r104.subscribe(new l(this));
        if (r105 == null) goto L15;
        com.bytedance.revenue.platform.api.core.rx.f.a(r105, this.f97453e);
    L15:
        F();
    L16:
        ld.a r106 = this.f97459k;
        if (r106 == null) goto L25;
        NextLiveData<Boolean> r107 = r106.Y8();
        if (r107 == null) goto L25;
        Observable r108 = ld.c.a(r107);
        if (r108 == null) goto L25;
        Disposable r109 = r108.subscribe(new m(this));
        if (r109 == null) goto L25;
        com.bytedance.revenue.platform.api.core.rx.f.a(r109, this.f97453e);
    L25:
        Boolean r111 = r100.o();
        Boolean r112 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r111, r112)) == false) goto L34;
        e r113 = this.f97457i;
        if (r113 == null) goto L34;
        if (r113.isEnabled() != true) goto L34;
        e r114 = this.f97457i;
        if (r114 == null) goto L34;
        r114.disable();
    L34:
        i r115 = this.f97460l;
        int r116 = 0;
        if (r115.f97435f == false) goto L37;
    L46:
        i r117 = this.f97460l;
        r117.getClass();
        Intrinsics.checkNotNullParameter(r100, "seiFrame");
        if (r117.f97444o != LiveMode.SCREEN_RECORD) goto L49;
        boolean r118 = true;
    L50:
        o51.f r119 = r100.t(r118, r117.f97437h);
        Integer r120 = r100.n();
        if (r120 == null) goto L58;
        if (r120.intValue() != 6) goto L58;
        if (r119.a() == false) goto L58;
    L59:
        int r121 = r117.f97440k;
    L66:
        r117.f97441l = r121;
        if (r100.p() == false) goto L84;
        int r122 = this.f97460l.f97441l;
        b03.a r123 = b03.a.f16857a;
        float r124 = s1.w();
        int r125 = s1.y();
        int r126 = (r122 * 9) / 16;
        int r127 = (r125 - r126) / 2;
        RectF r128 = new RectF(0.0f, 0.0f, r125, r124);
        ld.a r129 = this.f97459k;
        if (r129 == null) goto L73;
        NextLiveData<oq2.e> r130 = r129.Rm();
        if (r130 == null) goto L73;
        r130.setValue(new oq2.e(r128, false, this.f97452d.n(), this.f97460l.f97437h));
    L73:
        ld.a r131 = this.f97459k;
        if (r131 == null) goto L82;
        NextLiveData<g90.a> r132 = r131.s9();
        if (r132 == null) goto L82;
        Matrix r133 = new Matrix();
        RevSeiFrame r134 = this.f97452d;
        String r135 = r134.C;
        Integer r136 = r134.m();
        if (r136 == null) goto L80;
        int r137 = r136.intValue();
    L81:
        r132.setValue(new g90.a(r133, r128, r135, r137));
        goto L82
    L80:
        r137 = 0;
    L82:
        jy0.b.c("RevenueLayoutCore", "onLayoutContextChange doLayoutInnerForPartner " + r126 + ' ' + r122 + tb2.c.DEFAULT_TEXT + r122 + ' ' + r125, null, 4);
        return new h(r126, r122, r127, 0);
    L84:
        this.f97454f.a(r100, this.f97460l);
        if (Intrinsics.areEqual(r100.o(), r112) == false) goto L124;
        com.bytedance.live.layout.d r138 = this.f97454f.f97465c.f255214b;
        if (r138 == null) goto L90;
        Matrix r139 = r138.f255212c;
        if (r139 == null) goto L90;
    L91:
        com.bytedance.live.layout.d r140 = this.f97454f.f97465c.f255214b;
        if (r140 == null) goto L94;
        RectF r141 = r140.f255210a;
    L95:
        RevSeiFrame r142 = this.f97452d;
        if (r141 != null) goto L99;
    L103:
        e r143 = this.f97457i;
        if (r143 != null) goto L106;
        return null;
    L106:
        if (r143.O(this.f97452d.C) == true) goto L109;
        r143 = null;
    L109:
        if (r143 != null) goto L111;
        return null;
    L111:
        if (r141 == null) goto L113;
        int r144 = (int) r141.width();
    L114:
        if (r141 == null) goto L116;
        int r145 = (int) r141.height();
    L117:
        if (r141 == null) goto L119;
        int r146 = (int) r141.left;
    L120:
        if (r141 == null) goto L123;
        r116 = (int) r141.top;
    L123:
        return r143.b(this.f97452d.C, new h(r144, r145, r146, r116), null);
    L119:
        r146 = 0;
        goto L120
    L116:
        r145 = 0;
        goto L117
    L113:
        r144 = 0;
        goto L114
    L99:
        if (this.f97460l.f97438i == false) goto L101;
        Function3 r147 = new RevenueLayoutCore$onBizUpdate$broadcastFunc$1(this);
    L102:
        r147.invoke(r139, r142, r141);
        goto L103
    L101:
        r147 = new RevenueLayoutCore$onBizUpdate$broadcastFunc$2(this);
        goto L102
    L94:
        r141 = null;
    L90:
        r139 = new Matrix();
        goto L91
    L124:
        StringBuilder r148 = new StringBuilder("onLayoutContextChange finished with visibleArea: ");
        com.bytedance.live.layout.d r149 = this.f97454f.f97465c.f255214b;
        if (r149 == null) goto L127;
        RectF r150 = r149.f255210a;
    L128:
        r148.append(r150);
        r148.append(" and player: ");
        com.bytedance.live.layout.d r151 = this.f97454f.f97465c.f255214b;
        if (r151 == null) goto L131;
        RectF r152 = r151.f255211b;
    L132:
        r148.append(r152);
        jy0.b.c("RevenueLayoutCore", r148.toString(), null, 4);
        com.bytedance.live.layout.d r153 = this.f97454f.f97465c.f255214b;
        if (r153 == null) goto L136;
        Matrix r154 = r153.f255212c;
        if (r154 == null) goto L136;
    L137:
        RevSeiFrame r155 = this.f97452d;
        com.bytedance.live.layout.d r156 = this.f97454f.f97465c.f255214b;
        if (r156 == null) goto L140;
        RectF r157 = r156.f255210a;
    L141:
        if (r157 != null) goto L144;
    L148:
        com.bytedance.live.layout.d r158 = this.f97454f.f97465c.f255214b;
        if (r158 == null) goto L151;
        RectF r159 = r158.f255211b;
    L152:
        if (r159 == null) goto L158;
        jy0.b.c("RevenueLayoutCore", "updated playerPosition by bizUpdate: " + r159, null, 4);
        return new h((int) r159.width(), (int) r159.height(), (int) r159.left, (int) r159.top);
    L158:
        return null;
    L151:
        r159 = null;
        goto L152
    L144:
        if (this.f97460l.f97438i == false) goto L146;
        Function3 r160 = new RevenueLayoutCore$onBizUpdate$broadcastFunc$1(this);
    L147:
        r160.invoke(r154, r155, r157);
        goto L148
    L146:
        r160 = new RevenueLayoutCore$onBizUpdate$broadcastFunc$2(this);
        goto L147
    L140:
        r157 = null;
    L136:
        r154 = new Matrix();
        goto L137
    L131:
        r152 = null;
        goto L132
    L127:
        r150 = null;
    L58:
        if (r100.p() == true) goto L59;
        k31.k r161 = r117.f97447r;
        if (r161 != null) goto L63;
    L65:
        r121 = r117.f97440k;
        goto L66
    L63:
        if (r161.f501667a != true) goto L65;
        r121 = r117.f97440k - k31.l.a(r161, true);
        goto L66
    L49:
        r118 = false;
        goto L50
    L37:
        if (r115.f97437h == true) goto L46;
        if ((!Intrinsics.areEqual(r100.o(), r112)) == false) goto L46;
        Disposable r162 = this.f97455g;
        if (r162 != null) goto L43;
    L45:
        int r163 = ToastUtil.f90810a;
        int r164 = w11.a.f557889a;
        ToastUtil.a(R.string.ttlive_interact_landscape_crossroom_switch_tip, 0);
        com.bytedance.revenue.platform.api.core.rx.l r165 = com.bytedance.revenue.platform.api.core.rx.l.f267516a;
        int r166 = p.f267522a;
        this.f97455g = Observable.just(1).delay(2000, TimeUnit.MILLISECONDS, Schedulers.computation(), false).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this));
        goto L46
    L43:
        if (r162.isDisposed() == true) goto L45;
        goto L45
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final boolean O(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        Integer r101 = RevSeiFrame.a.a(RevSeiFrame.G, r100, false, 6).n();
        if (r101 != null) goto L6;
    L7:
        if (r101 != null) goto L10;
    L11:
        if (r101 != null) goto L14;
    L16:
        boolean r102 = false;
    L18:
        if (r102 == false) goto L44;
        LiveMode r103 = this.f97460l.f97444o;
        if (r103 == null) goto L31;
        int r104 = k.f97461a[r103.ordinal()];
        if (r104 == 1) goto L32;
        if (r104 == 2) goto L32;
        if (r104 == 3) goto L32;
        if (r104 == 4) goto L32;
        if (r104 != 5) goto L31;
    L32:
        boolean r105 = true;
    L33:
        if (r105 == true) goto L35;
        return false;
    L35:
        if (rc0.n.a((DeviceType) this.f97449a.getValue()) == false) goto L40;
        b03.a r106 = b03.a.f16857a;
        if (b03.a.b() == true) goto L40;
        boolean r107 = false;
    L41:
        if (r107 == false) goto L46;
        return true;
    L46:
        return false;
    L40:
        r107 = true;
    L31:
        r105 = false;
        goto L33
    L44:
        return false;
    L14:
        if (r101.intValue() != 19) goto L16;
    L17:
        r102 = true;
        goto L18
    L10:
        if (r101.intValue() == 6) goto L17;
    L6:
        if (r101.intValue() == 2) goto L17;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void h(Function1<? super b, Unit> r100) {
        this.f97460l.f97445p = r100;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final h handleSei(String r110) {
        Intrinsics.checkNotNullParameter(r110, "sei");
        RevSeiFrame r100 = RevSeiFrame.a.a(RevSeiFrame.G, r110, this.f97460l.f97437h, 2);
        com.bytedance.android.live.revlink.impl.settings.live.c r101 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r101.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.f97605j.getValue(r101, com.bytedance.android.live.revlink.impl.settings.live.c.f97596a[8])).booleanValue() == false) goto L52;
        RevSeiFrame r102 = this.f97452d;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "frame");
        if (Intrinsics.areEqual((String) r102.f90923f.getValue(), (String) r100.f90923f.getValue()) == true) goto L25;
        y41.f r103 = y41.f.N;
        r103.getClass();
        if (((Boolean) y41.f.G.getValue(r103, y41.f.f565960a[31])).booleanValue() == false) goto L27;
        if (r102.e() == null) goto L27;
        if (r100.e() == null) goto L27;
        Long r104 = r102.e();
        if (r104 != null) goto L17;
    L18:
        Long r105 = r100.e();
        if (r105 == null) goto L24;
        if (r105.longValue() == 0) goto L27;
    L24:
        if (Intrinsics.areEqual(r102.e(), r100.e()) == false) goto L27;
    L17:
        if (r104.longValue() != 0) goto L18;
    L27:
        if (((Boolean) ay0.a.f16664c.getValue(null, ay0.a.f16662a[1])).booleanValue() == true) goto L29;
        boolean r106 = false;
    L30:
        if (r106 == false) goto L52;
        if (this.f97460l.f97431b == true) goto L52;
        if (this.f97450b == false) goto L52;
        if (this.f97452d.p() == true) goto L52;
        jy0.b.d("RevenueLayoutCore", "block update by same content check");
        e r111 = this.f97457i;
        if (r111 != null) goto L40;
    L44:
        com.bytedance.live.layout.d r112 = this.f97454f.f97465c.f255214b;
        if (r112 == null) goto L47;
        RectF r113 = r112.f255211b;
    L48:
        if (r113 != null) goto L51;
        return null;
    L51:
        return new h((int) r113.width(), (int) r113.height(), (int) r113.left, (int) r113.top);
    L47:
        r113 = null;
        goto L48
    L40:
        if (r111.isEnabled() != true) goto L44;
        e r114 = this.f97457i;
        if (r114 != null) goto L55;
        return null;
    L55:
        return r114.c();
    L29:
        r106 = Intrinsics.areEqual((String) r102.f90924g.getValue(), (String) r100.f90924g.getValue());
    L25:
        r106 = true;
    L52:
        h r115 = A(r110);
        this.f97460l.f97431b = false;
        return r115;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.d
    public final void me(StreamLayoutManager.b r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        if (this.f97457i != null) goto L6;
        this.f97457i = r100;
        return;
    }

    public j(cy0.c r100, ld.a r101) {
        i r102 = new i();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f97458j = r100;
        this.f97459k = r101;
        this.f97460l = r102;
        this.f97449a = LazyKt.lazy(RevenueLayoutCore$deviceType$2.INSTANCE);
        r102.f97430a = new RevenueLayoutCore$1(this);
        RevSeiFrame.G.getClass();
        this.f97452d = (RevSeiFrame) RevSeiFrame.D.getValue();
        this.f97453e = new CompositeDisposable();
        this.f97454f = new DynamicLayoutCalculate();
        int r103 = o.f267521a;
        this.f97456h = PublishSubject.create();
    }

    public static final void y(j r100, RevSeiFrame r101) {
        r100.getClass();
        if (r101 == null) goto L5;
        String r102 = r101.C;
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L19;
        h r104 = r100.A(r102);
        if (r104 == null) goto L18;
        r100.f97456h.onNext(r104);
        return;
    L18:
        return;
    L19:
        return;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
