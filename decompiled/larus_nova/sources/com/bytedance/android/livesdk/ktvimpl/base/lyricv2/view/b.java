package com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f143262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f143263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f143264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f143265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f143266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f143267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f143268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f143269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f143270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f143271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f143272k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ScrollLyricConfigV2 f143273l;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f143274a;

        public a(b r100) {
            this.f143274a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            if (this.f143274a.getPos() != this.f143274a.getConfig().f142303i) goto L12;
            b r102 = this.f143274a;
            if (r101 == null) goto L7;
            float r103 = r101.floatValue();
        L9:
            if (r102.f143263b == true) goto L11;
            r102.setInSweeping(true);
        L11:
            float r104 = r102.f143273l.f142315b.measureText(r102.f143267f);
            float r105 = ((r102.getMeasuredWidth() - r104) / 2) + (r103 * r104);
            r102.getMeasuredWidth();
            r102.f143266e.set(0.0f, 0.0f, r105, r102.getMeasuredHeight());
            r102.postInvalidate();
            return;
        L7:
            r103 = 0.0f;
            goto L9
        L12:
            String r106 = "SingleLineLyricView pos：" + this.f143274a.getPos() + ",sweepLine:" + this.f143274a.getConfig().f142303i;
            ALogger.e(bb0.b.b(), r106 + ", invoke class :" + b.class.getSimpleName());
        }
    }

    public final ScrollLyricConfigV2 getConfig() {
        return this.f143273l;
    }

    public final float getDBaseLine() {
        return this.f143264c;
    }

    public final boolean getInSweeping() {
        return this.f143263b;
    }

    public final float getMHeight() {
        return this.f143269h;
    }

    public final float getMWidth() {
        return this.f143268g;
    }

    public final boolean getNeedHighLight() {
        return this.f143272k;
    }

    public final int getPos() {
        return this.f143265d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        this.f143268g = getMeasuredWidth();
        float r100 = getMeasuredHeight();
        this.f143269h = r100;
        String r101 = this.f143267f;
        if (this.f143263b == false) goto L6;
        float r102 = 2;
        r110.drawText(r101, this.f143268g / r102, (r100 / r102) + this.f143264c, this.f143273l.f142316c);
        r110.save();
        r110.clipRect(this.f143266e);
        r110.drawText(r101, this.f143268g / r102, (this.f143269h / r102) + this.f143264c, this.f143273l.f142315b);
        r110.restore();
        return;
    L6:
        if (this.f143272k == false) goto L20;
        boolean r103 = false;
        this.f143273l.f142316c.getTextBounds(r101, 0, r101.length(), this.f143270i);
        int r104 = this.f143270i.width();
        Shader r105 = this.f143273l.f142316c.getShader();
        if (r104 <= ((getWidth() / 5) * 3)) goto L19;
        float r111 = getHeight() / 2.0f;
        float r112 = this.f143271j;
        Float r106 = Float.valueOf(getWidth() - this.f143271j);
        if (r106.floatValue() <= 0) goto L12;
        r103 = true;
    L12:
        if (r103 == true) goto L15;
        r106 = null;
    L15:
        if (r106 == null) goto L17;
        float r107 = r106.floatValue();
    L18:
        this.f143273l.f142316c.setShader(new LinearGradient(r112, r111, r107, r111, new int[]{0, -1, 0}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        goto L19
    L17:
        r107 = getWidth();
    L19:
        float r108 = 2;
        r110.drawText(r101, this.f143268g / r108, (this.f143269h / r108) + this.f143264c, this.f143273l.f142316c);
        this.f143273l.f142316c.setShader(r105);
        return;
    L20:
        float r109 = 2;
        r110.drawText(r101, this.f143268g / r109, (r100 / r109) + this.f143264c, this.f143273l.f142317d);
    }

    public final void setInSweeping(boolean r100) {
        this.f143263b = r100;
        if (r100 == false) goto L5;
        this.f143273l.f142304j.observeForever(this.f143262a, true);
    L6:
        invalidate();
        return;
    L5:
        this.f143273l.f142304j.removeObserver(this.f143262a);
        goto L6
    }

    public final void setLyricLine(com.bytedance.component.lyric.model.b r100) {
        Intrinsics.checkNotNullParameter(r100, "lyricLine");
        String r101 = r100.f203031d;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f143267f = r101;
        invalidate();
    }

    public final void setMHeight(float r100) {
        this.f143269h = r100;
    }

    public final void setMWidth(float r100) {
        this.f143268g = r100;
    }

    public final void setNeedHighLight(boolean r100) {
        this.f143272k = r100;
    }

    public final void setPos(int r100) {
        this.f143265d = r100;
    }

    public b(Context r100, ScrollLyricConfigV2 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        super(r100, null);
        this.f143273l = r101;
        this.f143262a = new a(this);
        Paint.FontMetrics r102 = r101.f142316c.getFontMetrics();
        Intrinsics.checkNotNullParameter(r102, "fontMetrics");
        float r103 = r102.descent;
        this.f143264c = ((r103 - r102.ascent) / 2) - r103;
        this.f143265d = -1;
        this.f143266e = new RectF();
        this.f143267f = "";
        this.f143270i = new Rect();
        this.f143271j = UtilityKotlinExtentionsKt.h(38);
    }
}
