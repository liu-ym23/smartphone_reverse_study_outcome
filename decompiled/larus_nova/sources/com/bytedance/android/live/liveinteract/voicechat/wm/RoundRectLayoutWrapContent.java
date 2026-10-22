package com.bytedance.android.live.liveinteract.voicechat.wm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/wm/RoundRectLayoutWrapContent;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoundRectLayoutWrapContent extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f80930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f80931b;

    public static final class a {
    }

    static {
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public RoundRectLayoutWrapContent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f80930a = new Path();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = this.f80931b;
        this.f80930a.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), new float[]{r101, r101, r101, r101, r101, r101, r101, r101}, Path.Direction.CW);
        r100.clipPath(this.f80930a);
        getWidth();
        getHeight();
        super.dispatchDraw(r100);
    }

    public RoundRectLayoutWrapContent(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        this(r100);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f80931b = View.MeasureSpec.getSize(r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
