package com.bytedance.android.livesdk.player.layout;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.model.DisplayRatio;
import com.bytedance.android.livesdkapi.view.IRenderView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements com.bytedance.android.live.platformplayer.layout.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f155517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f155518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f155519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f155520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f155521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f155522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f155523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f155524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f155525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f155526j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f155527k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f155528l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f155529m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DisplayRatio f155530n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final IRenderView f155531o;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final boolean e() {
        if (this.f155531o.getSelfView().getScaleX() == 1.0f) goto L5;
    L8:
        return true;
    L5:
        if (this.f155531o.getSelfView().getScaleY() != 1.0f) goto L8;
        return false;
    }

    public final String toString() {
        return "LivePlayerPosition(width=" + this.f155518b + ", height=" + this.f155519c + ", top=" + this.f155520d + ", left=" + this.f155521e + ", bottom=" + this.f155522f + ", right=" + this.f155523g + ", translationX=" + this.f155524h + ", translationY=" + this.f155525i + ", scaleX=" + this.f155526j + ", scaleY=" + this.f155527k + ", gravity=" + this.f155528l + ", scaleType=" + this.f155529m + ')';
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int d() {
        return this.f155528l;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getBottom() {
        return this.f155522f;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final DisplayRatio getDisplayRatio() {
        return this.f155530n;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getHeight() {
        return this.f155519c;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getLeft() {
        return this.f155521e;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getRight() {
        return this.f155523g;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getScaleType() {
        return this.f155529m;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getScaleX() {
        return this.f155526j;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getScaleY() {
        return this.f155527k;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getTop() {
        return this.f155520d;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getTranslationX() {
        return this.f155524h;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getTranslationY() {
        return this.f155525i;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getWidth() {
        return this.f155518b;
    }

    public e(IRenderView r100) {
        Intrinsics.checkNotNullParameter(r100, "renderView");
        this.f155531o = r100;
        this.f155517a = "live_player_layout_position:(" + hashCode() + ')';
        this.f155526j = 1.0f;
        this.f155527k = 1.0f;
        this.f155528l = 17;
        this.f155529m = 2;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void a(int r100) {
        this.f155523g = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void b(int r100) {
        this.f155521e = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void c(int r100) {
        this.f155522f = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void f(int r100) {
        this.f155520d = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void requestLayout(String r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        ViewGroup.LayoutParams r100 = this.f155531o.getSelfView().getLayoutParams();
        if (r100 == null) goto L52;
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100;
        int r102 = this.f155518b;
        boolean r103 = true;
        boolean r104 = false;
        if (r102 == r101.width) goto L7;
        r101.width = r102;
        boolean r105 = true;
    L8:
        int r106 = this.f155519c;
        if (r106 == r101.height) goto L11;
        r101.height = r106;
        r105 = true;
    L11:
        int r107 = this.f155522f;
        if (r107 == r101.bottomMargin) goto L14;
        r101.bottomMargin = r107;
        r105 = true;
    L14:
        int r108 = this.f155523g;
        if (r108 == r101.rightMargin) goto L17;
        r101.rightMargin = r108;
        r105 = true;
    L17:
        int r109 = this.f155520d;
        if (r109 == r101.topMargin) goto L20;
        r101.topMargin = r109;
        r105 = true;
    L20:
        int r111 = this.f155521e;
        if (r111 == r101.leftMargin) goto L24;
        r101.leftMargin = r111;
        r105 = true;
    L24:
        if (this.f155529m == this.f155531o.getScaleType()) goto L27;
        this.f155531o.setScaleType(this.f155529m);
        r105 = true;
    L27:
        if (this.f155526j == this.f155531o.getSelfView().getScaleX()) goto L30;
        this.f155531o.getSelfView().setScaleX(this.f155526j);
        r104 = true;
    L30:
        if (this.f155527k == this.f155531o.getSelfView().getScaleY()) goto L33;
        this.f155531o.getSelfView().setScaleY(this.f155527k);
        r104 = true;
    L33:
        if (this.f155524h == this.f155531o.getSelfView().getTranslationX()) goto L36;
        this.f155531o.getSelfView().setTranslationX(this.f155524h);
        r104 = true;
    L36:
        if (this.f155525i == this.f155531o.getSelfView().getTranslationY()) goto L38;
        this.f155531o.getSelfView().setTranslationY(this.f155525i);
        r104 = true;
    L38:
        int r112 = this.f155528l;
        if (r112 == r101.gravity) goto L42;
        r101.gravity = r112;
        r105 = true;
    L42:
        if ((!Intrinsics.areEqual(this.f155530n, this.f155531o.getDisplayRatio())) == false) goto L44;
        this.f155531o.setDisplayRatio(this.f155530n);
    L45:
        boolean r113 = r104;
        if (r103 == false) goto L48;
        ALogger.i(this.f155517a, "requestLayout from:" + r110 + ",render view hash:" + this.f155531o.hashCode() + "new width:" + r101.width + ", new height:" + r101.height + ", new top:" + r101.topMargin + ", new left:" + r101.leftMargin + ", new bottom:" + r101.bottomMargin + ", new right:" + r101.rightMargin + ", new scaleType = " + this.f155529m + " , new scaleX = " + this.f155526j + " , new scaleY = " + this.f155527k + " , new translationX = " + this.f155524h + " , new translationY = " + this.f155525i + " , new gravity:" + r101.gravity + ", new displayRatio = " + this.f155530n);
        this.f155531o.getSelfView().setLayoutParams(r101);
        this.f155531o.getSelfView().requestLayout();
        return;
    L48:
        if (r113 == false) goto L54;
        ALogger.i(this.f155517a, "invalidate from:" + r110 + ",new width:" + r101.width + ", new height:" + r101.height + ", new top:" + r101.topMargin + ", new left:" + r101.leftMargin + ", new bottom:" + r101.bottomMargin + ", new right:" + r101.rightMargin + ", new scaleType = " + this.f155529m + " , new scaleX = " + this.f155526j + " , new scaleY = " + this.f155527k + " , new translationX = " + this.f155524h + " , new translationY = " + this.f155525i + " , new gravity:" + r101.gravity + ", new displayRatio = " + this.f155530n);
        this.f155531o.getSelfView().invalidate();
        return;
    L54:
        return;
    L44:
        r103 = r105;
        goto L45
    L7:
        r105 = false;
        goto L8
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setDisplayRatio(DisplayRatio r100) {
        this.f155530n = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setGravity(int r100) {
        this.f155528l = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setHeight(int r100) {
        this.f155519c = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setScaleType(int r100) {
        this.f155529m = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setScaleX(float r100) {
        this.f155526j = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setScaleY(float r100) {
        this.f155527k = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setTranslationX(float r100) {
        this.f155524h = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setTranslationY(float r100) {
        this.f155525i = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setWidth(int r100) {
        this.f155518b = r100;
    }
}
