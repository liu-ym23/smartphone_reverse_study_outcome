package com.bytedance.android.gamecp.business.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/business/view/GameDetailTitleTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDetailTitleTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f56460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f56463d;

    public GameDetailTitleTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GameDetailTitleTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void x(int r100) {
        String r101 = getText().toString();
        int r102 = this.f56460a;
        int r103 = this.f56461b;
        getPaint().setTextSize(r103);
        float r104 = r100;
        if (getPaint().measureText(r101) > r104) goto L5;
        return;
    L5:
        getPaint().setTextSize(r102);
        if (getPaint().measureText(r101) < r104) goto L8;
        return;
    L8:
        int r105 = r103;
        int r106 = r102;
    L9:
        if (r102 > r105) goto L17;
        int r107 = ((r105 - r102) >> 1) + r102;
        getPaint().setTextSize(r107);
        float r108 = getPaint().measureText(r101);
        if (r108 > r104) goto L12;
        if (r108 >= r104) goto L16;
        r102 = r107 + 1;
        r106 = r107;
        goto L9
    L16:
        r106 = r107;
        goto L17
    L12:
        r105 = r107 - 1;
    L17:
        getPaint().setTextSize(r106);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        int r103 = View.MeasureSpec.getSize(r100);     // Catch: Throwable -> L18
        if (r103 <= 0) goto L11;
        String r104 = getText().toString();     // Catch: Throwable -> L18
        if (this.f56462c == r103) goto L8;
    L9:
        this.f56462c = r103;     // Catch: Throwable -> L18
        this.f56463d = r104;     // Catch: Throwable -> L18
        boolean r105 = true;
    L12:
        if (r105 == true) goto L34;
    L14:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L21:
        super.onMeasure(r100, r101);
        if (r105 == true) goto L38;
    L29:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L38:
        Layout r107 = getLayout();     // Catch: Throwable -> L31
        if (r107.getLineCount() != 1) goto L29;
        int r108 = (int) r107.getLineWidth(0);     // Catch: Throwable -> L31
        int r109 = getMeasuredWidth();     // Catch: Throwable -> L31
        if (r108 <= 0) goto L29;
        if (r108 == r109) goto L29;
        setMeasuredDimension(r108, getMeasuredHeight());     // Catch: Throwable -> L31
    L16:
        th = th;
    L20:
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L34:
        x(r103);     // Catch: Throwable -> L16
        goto L14
    L8:
        if ((!Intrinsics.areEqual(this.f56463d, r104)) == true) goto L9;
    L11:
        r105 = false;
    L18:
        th = th;
        r105 = false;
        goto L20
    }

    public GameDetailTitleTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Resources r103 = r100.getResources();
        float r104 = TypedValue.applyDimension(2, 1.0f, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
        this.f56460a = (int) (16 * r104);
        this.f56461b = (int) (20 * r104);
        this.f56462c = -1;
        this.f56463d = "";
    }

    public /* synthetic */ GameDetailTitleTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
