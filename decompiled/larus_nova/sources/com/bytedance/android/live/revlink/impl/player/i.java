package com.bytedance.android.live.revlink.impl.player;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f97430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f97431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f97432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f97433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f97434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f97435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f97436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f97437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f97438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f97439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f97440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f97441l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f97442m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f97443n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LiveMode f97444o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super b, Unit> f97445p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public k31.a f97446q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public k31.k f97447r;

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void h(Function1<? super b, Unit> r100) {
        throw null;
    }

    public final String toString() {
        return "RevenueLayoutContext(_requestLayout=" + this.f97430a + ", _cacheInvalid=" + this.f97431b + ", _isLiveTypeAudio=" + this.f97432c + ", _isPcVrRoom=" + this.f97434e + ", _isPad=" + this.f97435f + ", _isFoldScreenFullType=" + this.f97436g + ", _isPortrait=" + this.f97437h + ", _isPreview=" + this.f97438i + ", _containerWidth=" + this.f97439j + ", _containerHeight=" + this.f97440k + ", _tmpContainerHeight=" + this.f97441l + ", _videoWidth=" + this.f97442m + ", _videoHeight=" + this.f97443n + ", _streamType=" + this.f97444o + ", _componentsOption=" + this.f97446q + ", _statusBarOption=" + this.f97447r + ')';
    }

    public i() {
        this.f97431b = true;
        this.f97437h = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void a(int r100) {
        if (this.f97440k != r100) goto L5;
        return;
    L5:
        this.f97440k = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void c(boolean r100) {
        if (this.f97435f != r100) goto L5;
        return;
    L5:
        this.f97435f = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void d(boolean r100) {
        if (this.f97437h != r100) goto L5;
        return;
    L5:
        this.f97437h = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void f(int r100) {
        if (this.f97442m != r100) goto L5;
        return;
    L5:
        this.f97442m = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void g(boolean r100) {
        if (this.f97433d != r100) goto L5;
        return;
    L5:
        this.f97433d = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void i(k31.a r100) {
        k31.a r101 = this.f97446q;
        Integer r102 = null;
        if (r101 == null) goto L5;
        k31.g r103 = r101.f501634a;
    L6:
        if (r100 == null) goto L8;
        k31.g r104 = r100.f501634a;
    L9:
        if (r103 == null) goto L11;
        Boolean r105 = Boolean.valueOf(r103.f501648a);
    L12:
        if (r104 == null) goto L14;
        Boolean r106 = Boolean.valueOf(r104.f501648a);
    L15:
        boolean r107 = Intrinsics.areEqual(r105, r106);
        boolean r108 = false;
        if (r107 == false) goto L26;
        if (r103 == null) goto L19;
        Integer r109 = r103.f501649b;
    L20:
        if (r104 == null) goto L22;
        Integer r110 = r104.f501649b;
    L24:
        if (Intrinsics.areEqual(r109, r110) == false) goto L26;
        boolean r111 = true;
    L27:
        if (r111 == false) goto L53;
        if (r101 == null) goto L30;
        k31.n r112 = r101.f501635b;
    L31:
        if (r100 == null) goto L33;
        k31.n r113 = r100.f501635b;
    L34:
        if (r112 == null) goto L36;
        Boolean r114 = Boolean.valueOf(r112.f501682a);
    L37:
        if (r113 == null) goto L39;
        Boolean r115 = Boolean.valueOf(r113.f501682a);
    L41:
        if (Intrinsics.areEqual(r114, r115) == false) goto L50;
        if (r112 == null) goto L44;
        Integer r116 = Integer.valueOf(r112.f501683b);
    L45:
        if (r113 == null) goto L48;
        r102 = Integer.valueOf(r113.f501683b);
    L48:
        if (Intrinsics.areEqual(r116, r102) == false) goto L50;
        boolean r117 = true;
    L51:
        if (r117 == false) goto L53;
        r108 = true;
        goto L53
    L44:
        r116 = null;
    L50:
        r117 = false;
        goto L51
    L39:
        r115 = null;
        goto L41
    L36:
        r114 = null;
        goto L37
    L33:
        r113 = null;
        goto L34
    L30:
        r112 = null;
    L53:
        if (r108 == false) goto L55;
        return;
    L55:
        this.f97446q = r100;
        this.f97431b = true;
        return;
    L22:
        r110 = null;
        goto L24
    L19:
        r109 = null;
    L26:
        r111 = false;
        goto L27
    L14:
        r106 = null;
        goto L15
    L11:
        r105 = null;
        goto L12
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void j(int r100) {
        if (this.f97439j != r100) goto L5;
        return;
    L5:
        this.f97439j = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void k(boolean r100) {
        if (this.f97436g != r100) goto L5;
        return;
    L5:
        this.f97436g = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void n(boolean r100) {
        if (this.f97434e != r100) goto L5;
        return;
    L5:
        this.f97434e = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void o(boolean r100) {
        if (this.f97438i != r100) goto L5;
        return;
    L5:
        this.f97438i = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void q(boolean r100) {
        if (this.f97432c != r100) goto L5;
        return;
    L5:
        this.f97432c = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void s(LiveMode r100) {
        if (this.f97444o != r100) goto L5;
        return;
    L5:
        this.f97444o = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void w(int r100) {
        if (this.f97443n != r100) goto L5;
        return;
    L5:
        this.f97443n = r100;
        this.f97431b = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.player.c
    public final void x(k31.k r100) {
        k31.k r101 = this.f97447r;
        Integer r102 = null;
        if (r101 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r101.f501667a);
    L6:
        if (r100 == null) goto L8;
        Boolean r104 = Boolean.valueOf(r100.f501667a);
    L10:
        if (Intrinsics.areEqual(r103, r104) == false) goto L19;
        if (r101 == null) goto L13;
        Integer r105 = Integer.valueOf(r101.f501668b);
    L14:
        if (r100 == null) goto L17;
        r102 = Integer.valueOf(r100.f501668b);
    L17:
        if (Intrinsics.areEqual(r105, r102) == false) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
        return;
    L22:
        this.f97447r = r100;
        this.f97431b = true;
        return;
    L13:
        r105 = null;
    L19:
        r106 = false;
        goto L20
    L8:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
