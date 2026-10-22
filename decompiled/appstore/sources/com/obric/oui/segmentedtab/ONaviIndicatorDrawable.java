package com.obric.oui.segmentedtab;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.common.style.l;
import com.ttnet.org.chromium.net.PrivateKeyType;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class ONaviIndicatorDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f16629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f16632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f16633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f16634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f16635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f16637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f16638j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f16639k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f16640l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f16641m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f16642n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f16643o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f16644p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f16645q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f16646r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16647s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AnimListener f16648t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f16649u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f16650v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public jb.d f16651w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public jb.d f16652x;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable$AnimListener;", "", "onAnimCancel", "", "onAnimEnd", "onAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface AnimListener {
        void onAnimCancel();

        void onAnimEnd();

        void onAnimStart();
    }

    public ONaviIndicatorDrawable() {
        this.f16629a = new Paint();
        this.f16630b = PrivateKeyType.INVALID;
        this.f16635g = new Rect();
        this.f16646r = true;
        this.f16649u = 1.15f;
        this.f16650v = 0.85f;
    }

    public static final /* synthetic */ void a(ONaviIndicatorDrawable r10, float r11) {
        r10.f(r11);
    }

    public static final /* synthetic */ AnimListener b(ONaviIndicatorDrawable r10) {
        return r10.f16648t;
    }

    public static final /* synthetic */ float c(ONaviIndicatorDrawable r10) {
        return r10.f16631c;
    }

    public static final /* synthetic */ void d(ONaviIndicatorDrawable r10, boolean r11) {
        r10.n(r11);
    }

    public static final /* synthetic */ void e(ONaviIndicatorDrawable r10, float r11) {
        r10.f16631c = r11;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r11) {
        q.g(r11, "canvas");
        float r10 = this.f16639k;
        float r12 = (r10 + r10) + this.f16641m;
        float r13 = 2;
        float r14 = this.f16634f;
        float r15 = (r12 / r13) - (r14 / r13);
        this.f16632d = r15;
        float r16 = this.f16631c;
        l.h(r11, r16, r15, r16 + this.f16633e, r15 + r14, j(), this.f16629a);
    }

    public final void f(float r10) {
        float r11 = this.f16640l * this.f16649u;
        float r12 = r11 + ((this.f16644p - r11) * r10);
        if (this.f16633e == r12) goto L6;
        this.f16633e = r12;
        invalidateSelf();
    L6:
        float r13 = this.f16645q;
        float r14 = this.f16650v * r13;
        float r15 = r14 + ((r13 - r14) * r10);
        if (this.f16634f == r15) goto L11;
        this.f16634f = r15;
        invalidateSelf();
        return;
    }

    public final void g(int r10, int r11) {
        if (k() >= 0.0f) goto L6;
        s(r10 - (r11 * 2.0f));
    L6:
        if (j() >= 0.0f) goto L8;
    L9:
        r(k());
        return;
    L8:
        if (j() > (k() / 2)) goto L9;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f16630b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f16634f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f16633e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f16630b != 255) goto L5;
        return -1;
    L5:
        return -3;
    }

    public final boolean h() {
        return this.f16646r;
    }

    public final int i() {
        return this.f16636h;
    }

    public final float j() {
        return this.f16637i;
    }

    public final float k() {
        return this.f16645q;
    }

    public final boolean l() {
        return this.f16647s;
    }

    public final void m(AnimListener r10) {
        this.f16648t = r10;
    }

    public final void n(boolean r10) {
        this.f16647s = r10;
    }

    public final void o(float r10, float r11, float r12, float r13) {
        this.f16631c = r10;
        this.f16632d = r11;
        this.f16633e = r12;
        this.f16634f = r13;
        this.f16638j = r10;
        this.f16639k = r11;
        this.f16640l = r12;
        this.f16641m = r13;
        this.f16642n = r10;
        this.f16643o = r11;
        this.f16644p = r12;
        this.f16645q = r13;
    }

    public final void p(boolean r10) {
        this.f16646r = r10;
    }

    public final void q(int r10) {
        if (this.f16636h == r10) goto L6;
        this.f16636h = r10;
        this.f16629a.setColor(r10);
        invalidateSelf();
        return;
    }

    public final void r(float r10) {
        if (this.f16637i == r10) goto L7;
        this.f16637i = r10;
        invalidateSelf();
        return;
    }

    public final void s(float r10) {
        if (this.f16641m != 0.0f) goto L5;
        this.f16641m = r10;
    L5:
        float r11 = this.f16645q;
        if (r11 == r10) goto L10;
        this.f16641m = r11;
        this.f16645q = r10;
        this.f16634f = r10;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        if (r10 == this.f16630b) goto L6;
        this.f16630b = r10;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final void t(float r10, float r11, float r12, float r13) {
        float r14 = this.f16644p;
        if (r14 <= 0.0f) goto L5;
        this.f16638j = this.f16642n;
        this.f16640l = r14;
        this.f16639k = this.f16643o;
    L5:
        float r15 = this.f16645q;
        if (r15 <= 0.0f) goto L8;
        this.f16641m = r15;
    L8:
        this.f16643o = r11;
        this.f16642n = r10;
        this.f16644p = r12;
        this.f16634f = r13;
        if (this.f16638j == r10) goto L11;
    L13:
        jb.d r16 = this.f16651w;
        if (r16 == null) goto L17;
        jb.d.c(r16, false, 1, null);
    L17:
        jb.d r17 = this.f16652x;
        if (r17 == null) goto L21;
        jb.d.c(r17, false, 1, null);
    L21:
        this.f16651w = com.obric.common.oea.foundation.animation.builder.d.a.e(new com.obric.common.oea.foundation.animation.builder.d.a(), this.f16638j + ((this.f16640l * (1 - this.f16649u)) / 2.0f), this.f16642n, kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 8, null).g(new ONaviIndicatorDrawable$updateBound$1(this)).c().a();
        this.f16652x = com.obric.common.oea.foundation.animation.builder.d.a.e(new com.obric.common.oea.foundation.animation.builder.d.a(), 0.0f, 1.0f, kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4, Token$Duration.OUI_ANIMATION_DURATION_VERY_LONG_2, 0, 4, null), null, 8, null).g(new ONaviIndicatorDrawable$updateBound$2(this)).f(new ONaviIndicatorDrawable$updateBound$3(this)).c().a();
        AnimListener r18 = this.f16648t;
        if (r18 == null) goto L27;
        r18.onAnimStart();
        return;
    L27:
        return;
    L11:
        if (this.f16640l != r12) goto L13;
        invalidateSelf();
    }
}
