package com.bytedance.android.shopping.store.recommend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0019\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/store/recommend/widget/FixedItemSizeLinearLayout;", "Landroid/widget/LinearLayout;", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getItemCount", "()I", "setItemCount", "(I)V", "itemCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FixedItemSizeLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f185768c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f185769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f185770b;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FixedItemSizeLinearLayout f185771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f185772b;

        public b(FixedItemSizeLinearLayout r100, View r101) {
            this.f185771a = r100;
            this.f185772b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f185771a.addView(this.f185772b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f185768c = com.bytedance.android.shopping.extensions.b.b(9);
    }

    public final int getItemCount() {
        return this.f185769a;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100) {
        if (this.f185770b == 0) goto L5;
        int r101 = this.f185770b;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(r101, r101);
        r102.rightMargin = f185768c;
        Unit r103 = Unit.INSTANCE;
        addView(r100, r102);
        return;
    L5:
        post(new b(this, r100));
    }

    public final void setItemCount(int r100) {
        if (r100 == this.f185769a) goto L7;
        if (r100 <= 0) goto L8;
        this.f185769a = r100;
        requestLayout();
        return;
    L8:
        return;
    }

    public FixedItemSizeLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        setOrientation(0);
        this.f185769a = 3;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        if (r102 != 0) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        int r103 = this.f185769a;
        int r104 = (r102 - ((r103 - 1) * f185768c)) / r103;
        this.f185770b = r104;
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r104, View.MeasureSpec.getMode(r101)));
    }
}
