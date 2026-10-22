package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/viewmanager/TextViewGradient;", "Landroid/widget/TextView;", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getGradientScope", "()F", "setGradientScope", "(F)V", "gradientScope", "", "c", "I", "getLinearTextColor", "()I", "linearTextColor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextViewGradient extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f186418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Shader f186419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f186420c;

    public TextViewGradient(Context r100) {
        this(r100, null, 0, 14, 0);
    }

    public TextViewGradient(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12, 0);
    }

    public TextViewGradient(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8, 0);
    }

    public final float getGradientScope() {
        return this.f186418a;
    }

    public final int getLinearTextColor() {
        return this.f186420c;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        getPaint().setShader(this.f186419b);
        Paint.FontMetrics r101 = getPaint().getFontMetrics();
        r100.drawText(getText().toString(), 0.0f, (getHeight() / 2) + ((-(r101.descent + r101.ascent)) / 2), getPaint());
    }

    public final void setGradientScope(float r100) {
        this.f186418a = r100;
        invalidate();
    }

    public TextViewGradient(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f186420c = r103;
        this.f186418a = 50.0f;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r110, int r210, int r211, int r212) {
        super.onSizeChanged(r110, r210, r211, r212);
        if (getMeasuredWidth() <= this.f186418a) goto L5;
        LinearGradient r100 = new LinearGradient(getMeasuredWidth() - this.f186418a, 0.0f, getMeasuredWidth(), 0.0f, this.f186420c, 0, Shader.TileMode.CLAMP);
    L6:
        this.f186419b = r100;
        return;
    L5:
        r100 = new LinearGradient(getMeasuredWidth() - this.f186418a, 0.0f, getMeasuredWidth(), 0.0f, this.f186420c, 0, Shader.TileMode.CLAMP);
        goto L6
    }

    public /* synthetic */ TextViewGradient(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        int r105 = 0;
        if ((r103 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r105 = ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT);
    L11:
        this(r100, r101, r102, r105);
    }
}
