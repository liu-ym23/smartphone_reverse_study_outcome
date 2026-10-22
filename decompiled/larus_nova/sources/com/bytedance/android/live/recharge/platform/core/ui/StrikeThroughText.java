package com.bytedance.android.live.recharge.platform.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/core/ui/StrikeThroughText;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "enable", "", "setDrawLineEnable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StrikeThroughText extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f90255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f90256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f90257c;

    public StrikeThroughText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f90257c == false) goto L5;
        r100.drawLine(0.0f, getHeight() / 2.0f, getWidth(), getHeight() / 2.0f, this.f90255a);
    L5:
        super.onDraw(r100);
    }

    public final void setDrawLineEnable(boolean r100) {
        this.f90257c = r100;
    }

    public StrikeThroughText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public StrikeThroughText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        this.f90255a = r103;
        Paint.Cap r104 = Paint.Cap.ROUND;
        this.f90257c = true;
        r103.setColor(this.f90256b);
        r103.setStrokeCap(r103.getStrokeCap());
        r103.setStrokeWidth(r103.getStrokeWidth());
    }
}
