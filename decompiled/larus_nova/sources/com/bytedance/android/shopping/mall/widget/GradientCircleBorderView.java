package com.bytedance.android.shopping.mall.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/mall/widget/GradientCircleBorderView;", "Landroid/view/View;", "", "width", "", "setStrokeWidth", "", "color", "setStartColor", "setEndColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GradientCircleBorderView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f178623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f178624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f178625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f178626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f178627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f178628f;

    public static final class a {
    }

    static {
    }

    public GradientCircleBorderView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GradientCircleBorderView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.drawCircle(this.f178624b, this.f178625c, this.f178626d, this.f178623a);
    }

    public final void setEndColor(int r100) {
        this.f178628f = r100;
    }

    public final void setStartColor(int r100) {
        this.f178627e = r100;
    }

    public final void setStrokeWidth(float r100) {
        this.f178623a.setStrokeWidth(r100);
    }

    public GradientCircleBorderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(20.0f);
        Unit r104 = Unit.INSTANCE;
        this.f178623a = r103;
        this.f178627e = -65536;
        this.f178628f = FakePickerAvatarCreator.BLUE;
    }

    public /* synthetic */ GradientCircleBorderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        this.f178624b = r100 / 2.0f;
        this.f178625c = r110 / 2.0f;
        this.f178626d = (float) ((Math.min(r100, r110) / ((double) 2.0f)) - ((double) (this.f178623a.getStrokeWidth() / 2)));
        this.f178623a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{this.f178627e, this.f178628f}, null, Shader.TileMode.CLAMP));
    }
}
