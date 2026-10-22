package com.bytedance.android.live.revenue.common;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revenue/common/FitTextView;", "Lcom/bytedance/android/live/core/widget/LiveTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FitTextView extends LiveTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f90799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f90800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f90801e;

    public FitTextView(Context r100) {
        this(r100, null);
    }

    public FitTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        TextPaint r102 = new TextPaint();
        this.f90799c = r102;
        this.f90801e = 6.0f;
        r102.set(getPaint());
        this.f90800d = getTextSize();
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "type");
        super.setText(r100, r101);
        y(r100.toString(), getWidth());
    }

    public final void y(String r100, int r101) {
        if (r101 <= 0) goto L14;
        int r102 = (r101 - getPaddingLeft()) - getPaddingRight();
        float r103 = this.f90800d;
        this.f90799c.setTextSize(r103);
    L5:
        if (this.f90799c.measureText(r100) <= r102) goto L10;
        r103 = r103 - 1.0f;
        float r104 = this.f90801e;
        if (r103 <= r104) goto L8;
        this.f90799c.setTextSize(r103);
        goto L5
    L8:
        r103 = r104;
    L10:
        setTextSize(0, r103);
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (r100 == r102) goto L5;
        y(getText().toString(), r100);
        return;
    }
}
