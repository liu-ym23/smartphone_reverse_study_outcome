package com.bytedance.android.shopping.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/widget/banner/PrimeHorizontalRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lkotlin/Function0;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/jvm/functions/Function0;", "getTouchCallback", "()Lkotlin/jvm/functions/Function0;", "setTouchCallback", "(Lkotlin/jvm/functions/Function0;)V", "touchCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PrimeHorizontalRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f187260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f187261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f187262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f187263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f187264e;

    public PrimeHorizontalRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PrimeHorizontalRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final Function0<Unit> getTouchCallback() {
        return this.f187260a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        boolean r101 = true;
        if (r100.getActionMasked() != 1) goto L5;
    L8:
        this.f187264e = false;
    L9:
        if (r101 == true) goto L11;
        r(r100);
        return super.onInterceptTouchEvent(r100);
    L11:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r100.getActionMasked() == 3) goto L8;
        r101 = this.f187264e;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        boolean r101 = true;
        if (r100.getActionMasked() != 1) goto L5;
    L8:
        this.f187264e = false;
    L9:
        if (r101 == true) goto L11;
        r(r100);
        return super.onTouchEvent(r100);
    L11:
        return super.onTouchEvent(r100);
    L5:
        if (r100.getActionMasked() == 3) goto L8;
        r101 = this.f187264e;
        goto L9
    }

    public final void r(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        this.f187262c = r100.getX();
        this.f187263d = r100.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        setNestedScrollingEnabled(false);
        this.f187264e = false;
        return;
    L5:
        if (r101 != 2) goto L23;
        float r102 = Math.abs(r100.getX() - this.f187262c);
        float r103 = Math.abs(r100.getY() - this.f187263d);
        int r104 = this.f187261b;
        if (r102 < r104) goto L10;
    L11:
        this.f187264e = true;
        double r105 = r103;
        if (Math.sqrt((r105 * r105) + ((double) (r102 * r102))) <= (r102 * 2)) goto L14;
        getParent().requestDisallowInterceptTouchEvent(false);
        setNestedScrollingEnabled(true);
        return;
    L14:
        Function0<Unit> r106 = this.f187260a;
        if (r106 == null) goto L21;
        Unit r107 = r106.invoke();
        return;
    L21:
        return;
    L10:
        if (r103 >= r104) goto L11;
        return;
    }

    public final void setTouchCallback(Function0<Unit> r100) {
        this.f187260a = r100;
    }

    public PrimeHorizontalRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f187261b = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public /* synthetic */ PrimeHorizontalRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
