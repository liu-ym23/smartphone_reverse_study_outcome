package com.bytedance.android.live.platformplayer.layout;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f85610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f85611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f85612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f85613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f85614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f85615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f85616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f85617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ILivePlayerScene f85618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f85619j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f85620k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IRoom f85621l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DataCenter f85622m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LiveMode f85623n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IBaseStreamUrl f85624o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ILivePlayerClient f85625p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f85626q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super e, Unit> f85627r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function0<a> f85628s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function0<a> f85629t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Context f85630u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f85631v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BottomContainerSize f85632w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TranslationAndScaleProperty f85633x;

    public f() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L54;
        f r101 = (f) r100;
        if (this.f85610a == r101.f85610a) goto L8;
        return false;
    L8:
        if (this.f85611b == r101.f85611b) goto L10;
        return false;
    L10:
        if (this.f85612c == r101.f85612c) goto L12;
        return false;
    L12:
        if (this.f85613d == r101.f85613d) goto L14;
        return false;
    L14:
        if (this.f85614e == r101.f85614e) goto L16;
        return false;
    L16:
        if (this.f85615f == r101.f85615f) goto L18;
        return false;
    L18:
        if (this.f85616g == r101.f85616g) goto L20;
        return false;
    L20:
        if (this.f85617h == r101.f85617h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f85618i, r101.f85618i) == true) goto L24;
        return false;
    L24:
        if (this.f85619j == r101.f85619j) goto L26;
        return false;
    L26:
        if (this.f85620k == r101.f85620k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f85621l, r101.f85621l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f85622m, r101.f85622m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f85623n, r101.f85623n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f85624o, r101.f85624o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f85625p, r101.f85625p) == true) goto L38;
        return false;
    L38:
        if (this.f85626q == r101.f85626q) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f85627r, r101.f85627r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f85628s, r101.f85628s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f85629t, r101.f85629t) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f85630u, r101.f85630u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f85631v, r101.f85631v) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.f85632w, r101.f85632w) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f85633x, r101.f85633x) == true) goto L82;
        return false;
    L82:
        return true;
    L54:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f85610a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f85611b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f85612c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f85613d;
        if (r110 == true) goto L15;
        r101 = r110;
    L15:
        int r111 = (((((((((r109 + r101) * 31) + this.f85614e) * 31) + this.f85615f) * 31) + this.f85616g) * 31) + this.f85617h) * 31;
        ILivePlayerScene r112 = this.f85618i;
        int r113 = 0;
        if (r112 == null) goto L18;
        int r114 = r112.hashCode();
    L19:
        int r115 = (((((r111 + r114) * 31) + this.f85619j) * 31) + this.f85620k) * 31;
        IRoom r116 = this.f85621l;
        if (r116 == null) goto L22;
        int r117 = r116.hashCode();
    L23:
        int r118 = (r115 + r117) * 31;
        DataCenter r119 = this.f85622m;
        if (r119 == null) goto L26;
        int r120 = r119.hashCode();
    L27:
        int r121 = (r118 + r120) * 31;
        LiveMode r122 = this.f85623n;
        if (r122 == null) goto L30;
        int r123 = r122.hashCode();
    L31:
        int r124 = (r121 + r123) * 31;
        IBaseStreamUrl r125 = this.f85624o;
        if (r125 == null) goto L34;
        int r126 = r125.hashCode();
    L35:
        int r127 = (r124 + r126) * 31;
        ILivePlayerClient r128 = this.f85625p;
        if (r128 == null) goto L38;
        int r129 = r128.hashCode();
    L39:
        int r130 = (((r127 + r129) * 31) + this.f85626q) * 31;
        Function1<? super e, Unit> r131 = this.f85627r;
        if (r131 == null) goto L42;
        int r132 = r131.hashCode();
    L43:
        int r133 = (r130 + r132) * 31;
        Function0<a> r134 = this.f85628s;
        if (r134 == null) goto L46;
        int r135 = r134.hashCode();
    L47:
        int r136 = (r133 + r135) * 31;
        Function0<a> r137 = this.f85629t;
        if (r137 == null) goto L50;
        int r138 = r137.hashCode();
    L51:
        int r139 = (r136 + r138) * 31;
        Context r140 = this.f85630u;
        if (r140 == null) goto L54;
        int r141 = r140.hashCode();
    L55:
        int r142 = (r139 + r141) * 31;
        c r143 = this.f85631v;
        if (r143 == null) goto L58;
        int r144 = r143.hashCode();
    L59:
        int r145 = (r142 + r144) * 31;
        BottomContainerSize r146 = this.f85632w;
        if (r146 == null) goto L62;
        int r147 = r146.hashCode();
    L63:
        int r148 = (r145 + r147) * 31;
        TranslationAndScaleProperty r149 = this.f85633x;
        if (r149 == null) goto L67;
        r113 = r149.hashCode();
    L67:
        return r148 + r113;
    L62:
        r147 = 0;
        goto L63
    L58:
        r144 = 0;
        goto L59
    L54:
        r141 = 0;
        goto L55
    L50:
        r138 = 0;
        goto L51
    L46:
        r135 = 0;
        goto L47
    L42:
        r132 = 0;
        goto L43
    L38:
        r129 = 0;
        goto L39
    L34:
        r126 = 0;
        goto L35
    L30:
        r123 = 0;
        goto L31
    L26:
        r120 = 0;
        goto L27
    L22:
        r117 = 0;
        goto L23
    L18:
        r114 = 0;
        goto L19
    }

    public final String toString() {
        return "LivePlayerLayoutContext(isPad=" + this.f85610a + ", isFoldScreen=" + this.f85611b + ", isFoldScreenFullType=" + this.f85612c + ", isPortrait=" + this.f85613d + ", screenWidth=" + this.f85614e + ", screenHeight=" + this.f85615f + ", videoWidth=" + this.f85616g + ", videoHeight=" + this.f85617h + ", useScene=" + this.f85618i + ", containerWidth=" + this.f85619j + ", containerHeight=" + this.f85620k + ", room=" + this.f85621l + ", dataCenter=" + this.f85622m + ", streamType=" + this.f85623n + ", streamUrl=" + this.f85624o + ", playerClient=" + this.f85625p + ", topViewHeightPx=" + this.f85626q + ", previewDataEvent=" + this.f85627r + ", extraPreviewLayoutDataFunc=" + this.f85628s + ", extraInRoomLayoutDataFunc=" + this.f85629t + ", activityContext=" + this.f85630u + ", previewPlayerPosition=" + this.f85631v + ", bottomContainerSize=" + this.f85632w + ", translationAndScale=" + this.f85633x + ")";
    }

    public f(Object r100) {
        ILivePlayerScene r101 = ILivePlayerScene.Companion.preview();
        LiveMode r102 = LiveMode.VIDEO;
        Intrinsics.checkNotNullParameter(r101, "useScene");
        Intrinsics.checkNotNullParameter(r102, "streamType");
        this.f85610a = false;
        this.f85611b = false;
        this.f85612c = false;
        this.f85613d = true;
        this.f85614e = -1;
        this.f85615f = -1;
        this.f85616g = -1;
        this.f85617h = -1;
        this.f85618i = r101;
        this.f85619j = -1;
        this.f85620k = -1;
        this.f85621l = null;
        this.f85622m = null;
        this.f85623n = r102;
        this.f85624o = null;
        this.f85625p = null;
        this.f85626q = -1;
        this.f85627r = null;
        this.f85628s = null;
        this.f85629t = null;
        this.f85630u = null;
        this.f85631v = null;
        this.f85632w = null;
        this.f85633x = null;
    }
}
