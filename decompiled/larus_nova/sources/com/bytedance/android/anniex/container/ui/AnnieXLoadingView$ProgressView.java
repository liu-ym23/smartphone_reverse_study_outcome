package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/bytedance/android/anniex/container/ui/AnnieXLoadingView$ProgressView", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anniex_release"}, k = 1, mv = {1, 4, 3})
final class AnnieXLoadingView$ProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f40537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f40538b;

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f40538b.set(0, 0, (getMeasuredWidth() * 0) / 100, getMeasuredHeight());
        r100.drawRect(this.f40538b, this.f40537a);
    }

    public AnnieXLoadingView$ProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint(1);
        r103.setColor(r100.getResources().getColor(R.color.annie_x_loading_color));
        this.f40537a = r103;
        this.f40538b = new Rect();
    }
}
