package com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.video.f;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.k;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.l;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class HeadVideoController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f167564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f167565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f167566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BasePdpVideoView f167567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f167568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HeaderMediaModel f167569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f167570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f167571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f167572i;

    public final b83.a b() {
        return (b83.a) this.f167572i.getValue();
    }

    public final boolean d() {
        BasePdpVideoView r100 = this.f167567d;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isPlaying();
    }

    public final void g() {
        BasePdpVideoView r100 = this.f167567d;
        if (r100 == null) goto L5;
        r100.startPlay();
    L5:
        f r101 = this.f167571h;
        if (r101 == null) goto L9;
        f.a.b(r101, this.f167570g, false, 6);
        return;
    }

    public final void c() {
        if (d() == true) goto L11;
        Function0<Unit> r100 = new HeadVideoController$innerClickMainVideo$1(this);
        l r101 = this.f167566c;
        if (r101 == null) goto L10;
        Function1<? super Function0<Unit>, Unit> r102 = r101.f169112b;
        if (r102 == null) goto L10;
        if (r102.invoke(r100) != null) goto L11;
    L10:
        Unit r103 = r100.invoke();
    L11:
        b83.a r104 = b();
        if (r104 == null) goto L19;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r105 = r104.f18013b;
        if (r105 == null) goto L20;
        c63.c r106 = r104.f18014c;
        if (r106 == null) goto L21;
        int r107 = com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b.f164968f;
        r106.B(null, r105.k(null), r105.h());
        return;
    L21:
        return;
    L20:
        return;
    }

    public HeadVideoController(b r100) {
        Intrinsics.checkNotNullParameter(r100, "videoInfo");
        this.f167565b = -1;
        l r101 = r100.f167574a;
        this.f167566c = r101;
        Object r102 = null;
        if (r101 == null) goto L5;
        x73.a r103 = r101.f169115e;
    L7:
        if ((r103 instanceof BasePdpVideoView) == true) goto L9;
        r103 = null;
    L9:
        this.f167567d = (BasePdpVideoView) r103;
        this.f167568e = r100.f167575b;
        this.f167569f = r100.f167576c;
        if (r101 == null) goto L12;
        k r104 = r101.f169114d;
    L13:
        this.f167570g = r104;
        if (r104 == null) goto L16;
        f r105 = r104.f167580d;
    L17:
        this.f167571h = r105;
        this.f167572i = LazyKt.lazy(new HeadVideoController$videoLogManager$2(this));
        int r106 = ECSdk.f48106a;
        IAdapterService r107 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r107 == null) goto L20;
        j r108 = r107.getLiveWindowService();
    L21:
        if (r108 == null) goto L23;
        r102 = r108.f(new a(this));
    L23:
        this.f167564a = r102;
        return;
    L20:
        r108 = null;
        goto L21
    L16:
        r105 = null;
        goto L17
    L12:
        r104 = null;
        goto L13
    L5:
        r103 = null;
        goto L7
    }

    public final void a(Boolean r100) {
        l r101 = this.f167566c;
        if (r101 == null) goto L5;
        r101.f169113c = r100;
    L5:
        f(Intrinsics.areEqual(r100, Boolean.TRUE), true);
        g();
        b83.a r102 = b();
        if (r102 == null) goto L9;
        b83.a.a(r102, false, false, 7);
        return;
    }

    public final void e(boolean r100) {
        if (d() == false) goto L9;
        b83.a r101 = b();
        if (r101 == null) goto L9;
        c63.c r102 = r101.f18014c;
        if (r102 == null) goto L9;
        r102.u(com.bytedance.android.ec.core.event.a.VALUE_MAIN_PICTURE);
    L9:
        BasePdpVideoView r103 = this.f167567d;
        if (r103 == null) goto L12;
        r103.pausePlay();
    L12:
        f r104 = this.f167571h;
        if (r104 == null) goto L15;
        f.a.a(r104, this.f167570g, false, false, 4);
    L15:
        if (r100 == true) goto L17;
        return;
    L17:
        if (d() == false) goto L23;
        f r105 = this.f167571h;
        if (r105 == null) goto L24;
        r105.a(this.f167570g);
        return;
    L24:
        return;
    }

    public final void f(boolean r100, boolean r101) {
        BasePdpVideoView r102 = this.f167567d;
        if (r102 == null) goto L6;
        r102.f(r100, r101);
        return;
    }
}
