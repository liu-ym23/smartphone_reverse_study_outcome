package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView$a;", "value", "d", "Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView$a;", "getLinearGradientCreator", "()Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView$a;", "setLinearGradientCreator", "(Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView$a;)V", "linearGradientCreator", "", "e", FaceService.girlLabel, "getTextSkewXValue", "()F", "setTextSkewXValue", "(F)V", "textSkewXValue", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GradientAndItalicTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f153198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f153199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f153200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f153201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f153202e;

    public interface a {
        LinearGradient a(int r100, int r101);
    }

    public GradientAndItalicTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GradientAndItalicTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final a getLinearGradientCreator() {
        return this.f153201d;
    }

    public final float getTextSkewXValue() {
        return this.f153202e;
    }

    public final void setLinearGradientCreator(a r100) {
        this.f153201d = r100;
        this.f153198a = true;
        requestLayout();
    }

    public final void setTextSkewXValue(float r100) {
        if (this.f153202e == r100) goto L6;
        this.f153202e = r100;
        getPaint().setTextSkewX(this.f153202e);
        invalidate();
        return;
    }

    public GradientAndItalicTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f153198a = true;
    }

    public /* synthetic */ GradientAndItalicTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f153198a == false) goto L5;
    L8:
        TextPaint r105 = getPaint();
        a r106 = this.f153201d;
        if (r106 == null) goto L11;
        LinearGradient r107 = r106.a(getWidth(), getHeight());
    L12:
        r105.setShader(r107);
        this.f153199b = getWidth();
        this.f153200c = getHeight();
        this.f153198a = false;
        return;
    L11:
        r107 = null;
        goto L12
    L5:
        if (this.f153199b != getWidth()) goto L8;
        if (this.f153200c != getHeight()) goto L8;
    }
}
