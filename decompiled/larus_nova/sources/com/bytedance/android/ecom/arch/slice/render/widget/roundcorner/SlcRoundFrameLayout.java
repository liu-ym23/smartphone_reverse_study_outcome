package com.bytedance.android.ecom.arch.slice.render.widget.roundcorner;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/widget/roundcorner/SlcRoundFrameLayout;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getWhRadio", "()F", "setWhRadio", "(F)V", "whRadio", "Lkotlin/Function0;", "", "b", "Lkotlin/jvm/functions/Function0;", "getComputeScrollCallBack", "()Lkotlin/jvm/functions/Function0;", "setComputeScrollCallBack", "(Lkotlin/jvm/functions/Function0;)V", "computeScrollCallBack", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public class SlcRoundFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f50961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f50962b;

    public SlcRoundFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SlcRoundFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void computeScroll() {
        Function0<Unit> r100 = this.f50962b;
        if (r100 == null) goto L7;
        if (r100 == null) goto L8;
        Unit r101 = r100.invoke();
        return;
    L8:
        return;
    }

    public final Function0<Unit> getComputeScrollCallBack() {
        return this.f50962b;
    }

    public final float getWhRadio() {
        return this.f50961a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(final Canvas r100) {
        SlcViewExtensionsKt.b(this, r100, new AnonymousClass1(this, r100));
    }

    public final void setComputeScrollCallBack(Function0<Unit> r100) {
        this.f50962b = r100;
    }

    public final void setWhRadio(float r100) {
        this.f50961a = r100;
    }

    public static final /* synthetic */ void a(SlcRoundFrameLayout r100, Canvas r101) {
        super.dispatchDraw(r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f50961a > 0) goto L5;
        return;
    L5:
        if (getMeasuredHeight() > 0) goto L7;
        return;
    L7:
        if (this.f50961a == ((getMeasuredWidth() * 1.0f) / getMeasuredHeight())) goto L12;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec((int) (getMeasuredWidth() / this.f50961a), 1073741824));
        return;
    }

    public SlcRoundFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public /* synthetic */ SlcRoundFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
