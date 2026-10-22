package com.obric.oui.segmentedtab;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.obric.common.oea.foundation.animation.h.e;
import com.obric.oui.common.style.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.o;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: ONaviIndicatorDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ONaviIndicatorDrawable extends Drawable {
    private int alpha;
    private a animListener;
    private int color;
    private float currentHeight;
    private float currentLeft;
    private float currentTop;
    private float currentWidth;
    private boolean enableAnim;
    private float height;
    private float inset;
    private boolean isAnimRunning;
    private float lastHeight;
    private float lastLeft;
    private float lastTop;
    private float lastWidth;
    private float left;
    private Rect mBounds;
    private final float maxWidthScale;
    private final float minHeightScale;
    private final Paint paint;
    private com.obric.common.oea.foundation.animation.manager.d positionAnimator;
    private float radius;
    private com.obric.common.oea.foundation.animation.manager.d sizeAnimator;
    private float top;
    private float width;

    /* JADX INFO: compiled from: ONaviIndicatorDrawable.kt */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: compiled from: ONaviIndicatorDrawable.kt */
    static final class b extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ONaviIndicatorDrawable f36150a;

        b(ONaviIndicatorDrawable r1) {
            this.f36150a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            o.e(r2, "$noName_0");
            o.e(r3, "value");
            o.e(r4, "velocity");
            float r5 = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
            if (ONaviIndicatorDrawable.access$getLeft$p(this.f36150a) != r5) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == true) goto L9;
            ONaviIndicatorDrawable.access$setLeft$p(this.f36150a, r5);
            this.f36150a.invalidateSelf();
            return;
        L9:
            return;
        L5:
            r6 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ONaviIndicatorDrawable.kt */
    static final class c extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ONaviIndicatorDrawable f36151a;

        c(ONaviIndicatorDrawable r1) {
            this.f36151a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            o.e(r2, "$noName_0");
            o.e(r3, "value");
            o.e(r4, "velocity");
            ONaviIndicatorDrawable.access$setAnimRunning(this.f36151a, true);
            float r5 = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
            ONaviIndicatorDrawable.access$calculateSizeByFraction(this.f36151a, r5);
        }
    }

    /* JADX INFO: compiled from: ONaviIndicatorDrawable.kt */
    static final class d extends p implements m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ONaviIndicatorDrawable f36152a;

        d(ONaviIndicatorDrawable r1) {
            this.f36152a = r1;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r2, Throwable r3) {
            ONaviIndicatorDrawable.access$setAnimRunning(this.f36152a, false);
            if (r2 == false) goto L8;
            a r1 = ONaviIndicatorDrawable.access$getAnimListener$p(this.f36152a);
            if (r1 == null) goto L14;
            r1.c();
            return;
        L14:
            return;
        L8:
            a r4 = ONaviIndicatorDrawable.access$getAnimListener$p(this.f36152a);
            if (r4 == null) goto L15;
            r4.b();
            return;
        }
    }

    public ONaviIndicatorDrawable() {
        this.paint = new Paint();
        this.alpha = 255;
        this.mBounds = new Rect();
        this.enableAnim = true;
        this.maxWidthScale = 1.15f;
        this.minHeightScale = 0.85f;
    }

    public static final /* synthetic */ void access$calculateSizeByFraction(ONaviIndicatorDrawable r0, float r1) {
        r0.calculateSizeByFraction(r1);
    }

    public static final /* synthetic */ a access$getAnimListener$p(ONaviIndicatorDrawable r0) {
        return r0.animListener;
    }

    public static final /* synthetic */ float access$getLeft$p(ONaviIndicatorDrawable r0) {
        return r0.left;
    }

    public static final /* synthetic */ void access$setAnimRunning(ONaviIndicatorDrawable r0, boolean r1) {
        r0.setAnimRunning(r1);
    }

    public static final /* synthetic */ void access$setLeft$p(ONaviIndicatorDrawable r0, float r1) {
        r0.left = r1;
    }

    public final boolean isAnimRunning() {
        return this.isAnimRunning;
    }

    private final void setAnimRunning(boolean r1) {
        this.isAnimRunning = r1;
    }

    public final int getIndicatorColor() {
        return this.color;
    }

    public final void setIndicatorColor(int r2) {
        if (this.color == r2) goto L6;
        this.color = r2;
        this.paint.setColor(r2);
        invalidateSelf();
        return;
    }

    public final float getIndicatorCornerRadius() {
        return this.radius;
    }

    public final void setIndicatorCornerRadius(float r2) {
        if (this.radius != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.radius = r2;
        invalidateSelf();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final float getInset() {
        return this.inset;
    }

    public final void setInset(float r2) {
        if (this.inset != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.inset = r2;
        invalidateSelf();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.width;
    }

    public final float getIndicatorHeight() {
        return this.currentHeight;
    }

    public final void setIndicatorHeight(float r5) {
        boolean r1 = true;
        if (this.lastHeight != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.lastHeight = r5;
    L8:
        float r2 = this.currentHeight;
        if (r2 == r5) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L15;
        this.lastHeight = r2;
        this.currentHeight = r5;
        this.height = r5;
        invalidateSelf();
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean getEnableAnimation() {
        return this.enableAnim;
    }

    public final void setEnableAnimation(boolean r1) {
        this.enableAnim = r1;
    }

    public final void setAnimListener(a r3) {
        this.animListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public final void checkAndInitHeightAndRadius(int r3, int r4) {
        if (getIndicatorHeight() >= 0.0f) goto L6;
        setIndicatorHeight(r3 - (r4 * 2.0f));
    L6:
        if (getIndicatorCornerRadius() >= 0.0f) goto L8;
    L9:
        setIndicatorCornerRadius(getIndicatorHeight());
        return;
    L8:
        if (getIndicatorCornerRadius() > (getIndicatorHeight() / 2)) goto L9;
    }

    public final void setBound(float r1, float r2, float r3, float r4) {
        this.left = r1;
        this.top = r2;
        this.width = r3;
        this.height = r4;
        this.lastLeft = r1;
        this.lastTop = r2;
        this.lastWidth = r3;
        this.lastHeight = r4;
        this.currentLeft = r1;
        this.currentTop = r2;
        this.currentWidth = r3;
        this.currentHeight = r4;
    }

    public final void updateBound(float r10, float r11, float r12, float r13) {
        float r0 = this.currentWidth;
        if (r0 <= 0.0f) goto L5;
        this.lastLeft = this.currentLeft;
        this.lastWidth = r0;
        this.lastTop = this.currentTop;
    L5:
        float r1 = this.currentHeight;
        if (r1 <= 0.0f) goto L8;
        this.lastHeight = r1;
    L8:
        this.currentTop = r11;
        this.currentLeft = r10;
        this.currentWidth = r12;
        this.height = r13;
        if (this.lastLeft != r10) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == true) goto L14;
    L19:
        com.obric.common.oea.foundation.animation.manager.d r15 = this.positionAnimator;
        if (r15 == null) goto L23;
        com.obric.common.oea.foundation.animation.manager.d.a(r15, false, 1, null);
    L23:
        com.obric.common.oea.foundation.animation.manager.d r16 = this.sizeAnimator;
        if (r16 == null) goto L27;
        com.obric.common.oea.foundation.animation.manager.d.a(r16, false, 1, null);
    L27:
        this.positionAnimator = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), this.lastLeft + ((this.lastWidth * (1 - this.maxWidthScale)) / 2.0f), this.currentLeft, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.a.f32428a, e.c.f, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new b(this), q.class, "com.obric.aiagent.plugin")).a().a();
        this.sizeAnimator = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), 0.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(e.a.i, e.c.n, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new c(this), q.class, "com.obric.aiagent.plugin")).a((m) ZeusTransformUtils.preCheckCast(new d(this), m.class, "com.obric.aiagent.plugin")).a().a();
        a r9 = this.animListener;
        if (r9 == null) goto L33;
        r9.a();
        return;
    L33:
        return;
    L14:
        if (this.lastWidth != r12) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == false) goto L19;
        invalidateSelf();
        return;
    L16:
        r17 = false;
        goto L17
    L11:
        r14 = false;
        goto L12
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r11) {
        o.e(r11, "canvas");
        float r0 = this.lastTop;
        float r1 = (r0 + r0) + this.lastHeight;
        float r2 = 2;
        float r3 = this.height;
        float r5 = (r1 / r2) - (r3 / r2);
        this.top = r5;
        float r4 = this.left;
        l.a(r11, r4, r5, r4 + this.width, r5 + r3, getIndicatorCornerRadius(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (r2 == this.alpha) goto L6;
        this.alpha = r2;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        throw new d.l("An operation is not implemented: Not yet implemented");
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.alpha != 255) goto L5;
        return -1;
    L5:
        return -3;
    }

    private final void calculateSizeByFraction(float r5) {
        float r0 = this.lastWidth * this.maxWidthScale;
        float r1 = r0 + ((this.currentWidth - r0) * r5);
        boolean r2 = true;
        if (this.width != r1) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L8;
        this.width = r1;
        invalidateSelf();
    L8:
        float r4 = this.currentHeight;
        float r6 = this.minHeightScale * r4;
        float r7 = r6 + ((r4 - r6) * r5);
        if (this.height == r7) goto L12;
        r2 = false;
    L12:
        if (r2 == true) goto L15;
        this.height = r7;
        invalidateSelf();
        return;
    L15:
        return;
    L5:
        r3 = false;
        goto L6
    }
}
