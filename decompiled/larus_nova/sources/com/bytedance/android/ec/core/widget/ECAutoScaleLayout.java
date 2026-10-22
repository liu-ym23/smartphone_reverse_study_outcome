package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001eR*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR?\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECAutoScaleLayout;", "Landroid/widget/FrameLayout;", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getScaleType", "()I", "setScaleType", "(I)V", "scaleType", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "parentSize", "b", "Lkotlin/jvm/functions/Function1;", "getCalAllowedWidth", "()Lkotlin/jvm/functions/Function1;", "setCalAllowedWidth", "(Lkotlin/jvm/functions/Function1;)V", "calAllowedWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAutoScaleLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Integer, Integer> f45898b;

    public static final class a {
    }

    static {
    }

    public final Function1<Integer, Integer> getCalAllowedWidth() {
        return this.f45898b;
    }

    public final int getScaleType() {
        return this.f45897a;
    }

    public ECAutoScaleLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f45897a = 1;
    }

    public final void setCalAllowedWidth(Function1<? super Integer, Integer> r100) {
        this.f45898b = r100;
    }

    public final void setScaleType(int r100) {
        if (r100 == this.f45897a) goto L6;
        this.f45897a = r100;
        requestLayout();
        return;
    }

    public ECAutoScaleLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f45897a = 1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE), r101);
        int r102 = View.MeasureSpec.getSize(r100);
        Function1<? super Integer, Integer> r103 = this.f45898b;
        if (r103 == null) goto L8;
        Integer r104 = r103.invoke(Integer.valueOf(r102));
        if (r104 == null) goto L8;
        r102 = r104.intValue();
    L8:
        if (getMeasuredWidth() <= r102) goto L11;
        setMeasuredDimension(r102, getMeasuredHeight());
    L11:
        if (getChildCount() > 0) goto L13;
        return;
    L13:
        if (getMeasuredWidth() <= 0) goto L26;
        View r105 = getChildAt(0);
        float r106 = getMeasuredWidth() / r105.getMeasuredWidth();
        if (r106 >= 1) goto L23;
        r105.setScaleX(r106);
        r105.setScaleY(r106);
        int r107 = this.f45897a;
        if (r107 != 1) goto L19;
        r105.setPivotX(0.0f);
        r105.setPivotY(r105.getMeasuredHeight() / 2.0f);
        return;
    L19:
        if (r107 == 2) goto L21;
        r105.setPivotX(r105.getMeasuredWidth() / 2.0f);
        r105.setPivotY(r105.getMeasuredHeight() / 2.0f);
        return;
    L21:
        r105.setPivotX(r105.getMeasuredWidth());
        r105.setPivotY(r105.getMeasuredHeight() / 2.0f);
        return;
    L23:
        r105.setScaleX(1.0f);
        r105.setScaleY(1.0f);
        return;
    }

    public ECAutoScaleLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f45897a = 1;
    }
}
