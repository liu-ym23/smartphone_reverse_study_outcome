package com.bytedance.android.live.ui;

import android.content.Context;
import android.graphics.LinearGradient;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0011B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\r\u0010\u0014R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/ui/GradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/live/ui/GradientTextView$a;", "value", "d", "Lcom/bytedance/android/live/ui/GradientTextView$a;", "getLinearGradientCreator", "()Lcom/bytedance/android/live/ui/GradientTextView$a;", "setLinearGradientCreator", "(Lcom/bytedance/android/live/ui/GradientTextView$a;)V", "linearGradientCreator", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GradientTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f101950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f101951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f101952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f101953d;

    public interface a {
        LinearGradient a(int r100, int r101);
    }

    public final a getLinearGradientCreator() {
        return this.f101953d;
    }

    public GradientTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f101950a = true;
    }

    public final void setLinearGradientCreator(a r100) {
        this.f101953d = r100;
        this.f101950a = true;
        invalidate();
    }

    public GradientTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f101950a = true;
    }

    public GradientTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f101950a = true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f101950a == false) goto L5;
    L8:
        TextPaint r105 = getPaint();
        a r106 = this.f101953d;
        if (r106 == null) goto L11;
        LinearGradient r107 = r106.a(getWidth(), getHeight());
    L12:
        r105.setShader(r107);
        this.f101951b = getWidth();
        this.f101952c = getHeight();
        this.f101950a = false;
        return;
    L11:
        r107 = null;
        goto L12
    L5:
        if (this.f101951b != getWidth()) goto L8;
        if (this.f101952c != getHeight()) goto L8;
    }
}
