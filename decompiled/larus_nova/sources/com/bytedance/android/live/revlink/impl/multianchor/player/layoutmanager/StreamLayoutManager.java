package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.impl.player.d;
import com.bytedance.android.live.revlink.impl.player.e;
import com.bytedance.android.live.revlink.impl.player.g;
import com.bytedance.android.live.revlink.impl.player.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import k31.k;
import k31.l;
import kc0.u;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rc0.i;
import rc0.o;
import rc0.p;

/* JADX INFO: loaded from: classes47.dex */
public final class StreamLayoutManager implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f94577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f94578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rc0.g f94579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f94580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k31.a f94581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f94582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public cy0.c f94583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public cy0.a f94584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f94585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.live.revlink.impl.player.a f94586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f94587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<p, Unit> f94588l;

    public static final class a {
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StreamLayoutManager f94589a;

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final h c() {
            rc0.g r100 = this.f94589a.f94579c;
            if (r100 == null) goto L7;
            p r101 = r100.b();
            if (r101 == null) goto L7;
            return new h(r101.f537064a, r101.f537065b, r101.f537066c, r101.f537067d);
        L7:
            return null;
        }

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final void disable() {
            rc0.g r100 = this.f94589a.f94579c;
            if (r100 == null) goto L6;
            r100.disable();
            return;
        }

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final boolean isEnabled() {
            rc0.g r100 = this.f94589a.f94579c;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.isEnabled() != true) goto L7;
            return true;
        }

        public b(StreamLayoutManager r100) {
            this.f94589a = r100;
        }

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final boolean O(String r100) {
            rc0.g r101 = this.f94589a.f94579c;
            if (r101 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.O(r100) != true) goto L7;
            return true;
        }

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final void a(int r100) {
            rc0.g r101 = this.f94589a.f94579c;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        @Override // com.bytedance.android.live.revlink.impl.player.e
        public final h b(String r100, h r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "multiLayoutData");
            int r103 = r101.f97428c;
            int r104 = r101.f97429d;
            Rect r105 = new Rect(r103, r104, r101.f97426a + r103, r101.f97427b + r104);
            rc0.g r106 = this.f94589a.f94579c;
            if (r106 == null) goto L7;
            p r107 = r106.c(r100, r105, r102);
            if (r107 == null) goto L7;
            return new h(r107.f537064a, r107.f537065b, r107.f537066c, r107.f537067d);
        L7:
            return null;
        }
    }

    static {
    }

    @Override // rc0.i
    public final void q1() {
        d r100 = this.f94577a;
        if (r100 == null) goto L5;
        r100.q1();
    L5:
        g r101 = this.f94578b;
        if (r101 == null) goto L8;
        r101.q1();
    L8:
        this.f94580d.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StreamLayoutManager(Function1<? super p, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "requestLayout");
        this.f94588l = r100;
        this.f94580d = new CompositeDisposable();
        this.f94587k = new b(this);
    }

    @Override // rc0.i
    public final void E(cy0.a r100) {
        this.f94584h = r100;
        if (r100 == null) goto L7;
        xq2.a r101 = (xq2.a) m.f163449e.d(r100, xq2.a.class);
        if (r101 == null) goto L7;
        cy0.c r102 = r101.c0();
    L8:
        if (r102 == null) goto L11;
        this.f94583g = r102;
        this.f94586j = new com.bytedance.android.live.revlink.impl.player.a((ld.a) m.f163449e.d(r102, ld.a.class));
        return;
    L11:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final d c(o r100) {
        boolean r101 = r100.f537055f;
        if (r101 == false) goto L7;
        g r102 = this.f94578b;
        if (r102 == null) goto L7;
        return r102;
    L7:
        if (r101 == false) goto L9;
        g r103 = new g();
        this.f94578b = r103;
        return r103;
    L9:
        d r104 = this.f94577a;
        if (r104 != null) goto L20;
        cy0.a r105 = this.f94584h;
        if (r105 == null) goto L15;
        d r106 = (d) m.f163449e.d(r105, d.class);
    L16:
        d r107 = r106;
        this.f94577a = r107;
        return r107;
    L15:
        r106 = null;
        goto L16
    L20:
        return r104;
    }

    public final void d(final o r110) {
        d r100 = c(r110);
        if (r100 == null) goto L87;
        Intrinsics.checkNotNullParameter(r110, "$this$getDeviceType");
        boolean r101 = r110.f537051b;
        if (r101 == true) goto L7;
    L9:
        if (r101 == false) goto L14;
        if (r110.f537053d == true) goto L14;
        DeviceType r102 = DeviceType.PAD_H;
    L17:
        boolean r103 = false;
        if (r102 != DeviceType.FOLD_FULL) goto L20;
        boolean r104 = true;
    L21:
        r100.k(r104);
        r100.d(r110.f537053d);
        r100.j(r110.f537056g);
        r100.f(r110.f537058i);
        r100.w(r110.f537059j);
        r100.o(r110.f537055f);
        r100.c(r110.f537051b);
        Intrinsics.checkNotNullParameter(r110, "$this$isLiveTypeAudio");
        IRoom r105 = r110.f537054e;
        if (r105 == null) goto L24;
        boolean r106 = r105.isLiveTypeAudio();
    L25:
        r100.q(r106);
        Intrinsics.checkNotNullParameter(r110, "$this$isScreenRecord");
        IRoom r107 = r110.f537054e;
        if (r107 == null) goto L28;
        LiveMode r108 = r107.getStreamType();
    L30:
        if (r108 != LiveMode.SCREEN_RECORD) goto L32;
        boolean r109 = true;
    L33:
        r100.g(r109);
        Intrinsics.checkNotNullParameter(r110, "$this$isPcVrRoom");
        IRoom r111 = r110.f537054e;
        if (r111 != null) goto L36;
    L42:
        r100.n(r103);
        r100.s(r110.f537060k);
        rc0.a r112 = r110.f537063n;
        if (r112 == null) goto L77;
        com.bytedance.android.live.revlink.impl.player.a r113 = this.f94586j;
        if (r113 == null) goto L74;
        Pair r114 = TuplesKt.to(Integer.valueOf(r110.f537056g), Integer.valueOf(r110.f537057h));
        h r115 = this.f94587k.c();
        if (r115 == null) goto L51;
        Float r116 = Float.valueOf(r115.f97426a / r115.f97427b);
        if ((!Float.isNaN(r116.floatValue())) == false) goto L51;
    L52:
        Pair r117 = TuplesKt.to(Integer.valueOf(r112.f537024b), Integer.valueOf(r112.f537025c));
        int r118 = r112.f537023a;
        Intrinsics.checkNotNullParameter(r114, "inWHInfo");
        Intrinsics.checkNotNullParameter(r117, "bottomInfo");
        d51.c r119 = d51.c.A0;
        r119.getClass();
        if (((Boolean) d51.c.f466951s.getValue(r119, d51.c.f466915a[17])).booleanValue() == false) goto L72;
        if (r116 == null) goto L72;
        if (r118 == 1) goto L66;
        if (r118 == 2) goto L60;
        int r120 = ((Number) r114.getSecond()).intValue();
    L73:
        Integer r121 = Integer.valueOf(r120);
    L75:
        if (r121 == null) goto L77;
        int r122 = r121.intValue();
    L85:
        r100.a(r122);
        r100.h(new StreamLayoutManager$updateLayoutCore$$inlined$run$lambda$1(this, r110));
        Unit r123 = Unit.INSTANCE;
        return;
    L60:
        float r124 = r116.floatValue();
        float r125 = ((Number) r117.getFirst()).floatValue() / ((Number) r117.getSecond()).intValue();
        float r126 = (((Number) r114.getSecond()).floatValue() * r125) / (r124 + r125);
        float r127 = r124 * r126;
        float r128 = (((Number) r114.getFirst()).floatValue() - r127) / 2.0f;
        RectF r129 = new RectF(r128, 0.0f, r128 + r127, r126);
        kc0.a r130 = new kc0.a(r128, r126, r127, r127 / r125);
        ld.a r131 = r113.f97417a;
        if (r131 == null) goto L65;
        NextLiveData<u> r132 = r131.Le();
        if (r132 == null) goto L65;
        r132.setValue(new u(r130, new kc0.a(r129.left, r129.top, r129.width(), r129.height())));
    L65:
        r120 = (int) r126;
        goto L73
    L66:
        float r133 = r116.floatValue();
        float r134 = ((Number) r114.getSecond()).floatValue() - ((Number) r117.getSecond()).intValue();
        float r135 = r133 * r134;
        float r136 = (((Number) r114.getFirst()).floatValue() - r135) / 2.0f;
        RectF r137 = new RectF(r136, 0.0f, r136 + r135, r134);
        kc0.a r138 = new kc0.a(r136, r134, r135, ((Number) r117.getSecond()).intValue());
        ld.a r139 = r113.f97417a;
        if (r139 == null) goto L71;
        NextLiveData<u> r140 = r139.Le();
        if (r140 == null) goto L71;
        r140.setValue(new u(r138, new kc0.a(r137.left, r137.top, r137.width(), r137.height())));
    L71:
        r120 = (int) r134;
    L72:
        r120 = ((Number) r114.getSecond()).intValue();
    L51:
        r116 = null;
        goto L52
    L74:
        r121 = null;
    L77:
        com.bytedance.android.live.revlink.impl.player.a r141 = this.f94586j;
        if (r141 == null) goto L84;
        ld.a r142 = r141.f97417a;
        if (r142 == null) goto L84;
        NextLiveData<u> r143 = r142.Le();
        if (r143 == null) goto L84;
        r143.setValue(null);
    L84:
        r122 = r110.f537057h;
        goto L85
    L36:
        if (r111.isThirdParty() != true) goto L42;
        if (r111.getVRType() != 1) goto L40;
    L41:
        r103 = true;
        goto L42
    L40:
        if (r111.getVRType() != 2) goto L42;
    L32:
        r109 = false;
        goto L33
    L28:
        r108 = null;
        goto L30
    L24:
        r106 = false;
        goto L25
    L20:
        r104 = false;
    L14:
        if (r110.f537052c == false) goto L16;
        r102 = DeviceType.FOLD_FULL;
        goto L17
    L16:
        r102 = DeviceType.NORMAL_MOBILE;
        goto L17
    L7:
        if (r110.f537053d == false) goto L9;
        r102 = DeviceType.PAD_V;
        goto L17
    }

    @Override // rc0.i
    public final boolean a(String r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r101, "layoutContextExternal");
        d r102 = c(r101);
        boolean r103 = false;
        if (r102 != null) goto L5;
        return false;
    L5:
        r102.me(this.f94587k);
        this.f94579c = r101.f537062m;
        d(r101);
        boolean r104 = r102.O(r100);
        if (this.f94585i == true) goto L9;
        if (r104 == false) goto L9;
        this.f94585i = true;
        PublishSubject r105 = r102.ml();
        final StreamLayoutManager$shouldDeal$1 r106 = new StreamLayoutManager$shouldDeal$1(this);
        RxUtilKt.c(r105.subscribe(new c(r106)), this.f94580d);
    L9:
        b r107 = this.f94587k;
        if (r104 == false) goto L12;
    L16:
        if (r103 == true) goto L19;
        r107 = null;
    L19:
        if (r107 == null) goto L21;
        r107.disable();
    L21:
        return r104;
    L12:
        if (r107.isEnabled() == false) goto L16;
        if (r107.O(r100) == true) goto L16;
        r103 = true;
        goto L16
    }

    @Override // rc0.i
    public final p b(String r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        Intrinsics.checkNotNullParameter(r101, "layoutContextExternal");
        boolean r102 = true;
        if (r101.f537055f == false) goto L14;
        boolean r103 = r101.f537053d;
        Context r104 = r101.f537061l;
        if (r104 != null) goto L8;
    L12:
        boolean r105 = false;
    L15:
        this.f94582f = new k(r105, StatusBarUtil.getStatusBarHeight(r101.f537061l));
        StringBuilder r106 = new StringBuilder("outer ");
        k r107 = this.f94582f;
        if (r107 == null) goto L18;
        String r108 = l.b(r107);
    L19:
        r106.append(r108);
        r106.append("  context: ");
        r106.append(r101.f537061l);
        r106.append("   ");
        r106.append(r101.f537055f);
        jy0.b.c("xuzr", r106.toString(), null, 4);
        if (r101.f537055f == false) goto L23;
        r101.getClass();
        this.f94581e = null;
    L23:
        d(r101);
        d r109 = c(r101);
        if (r109 == null) goto L29;
        r109.x(this.f94582f);
        r109.i(this.f94581e);
        r109.me(this.f94587k);
        h r110 = r109.handleSei(r100);
        if (r110 == null) goto L30;
        Intrinsics.checkNotNullParameter(r110, "$this$toExternal");
        return new p(r110.f97426a, r110.f97427b, r110.f97428c, r110.f97429d);
    L30:
        return null;
    L29:
        return null;
    L18:
        r108 = null;
        goto L19
    L8:
        if (rc0.b.a() == DeviceType.NORMAL_MOBILE) goto L11;
        r102 = false;
    L11:
        if (r102 == true) goto L12;
        r105 = k31.p.c(r103, k31.p.b(r104), false);
        goto L15
    L14:
        r105 = k31.p.c(r101.f537053d, k31.p.b(r101.f537061l), true ^ r101.f537055f);
        goto L15
    }
}
