package com.bytedance.android.shopping.anchorv3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\tB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/widget/FixedHeadView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "status", "", "setRefreshStatus", "getAnimState", "Lcom/bytedance/android/ec/core/widget/LoadMoreStatusView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getStatusView", "()Lcom/bytedance/android/ec/core/widget/LoadMoreStatusView;", "statusView", "Landroid/widget/TextView;", "b", "getStatusText", "()Landroid/widget/TextView;", "statusText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FixedHeadView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f165590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f165591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f165592c;

    public static final class a {
    }

    static {
    }

    public FixedHeadView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FixedHeadView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final TextView getStatusText() {
        return (TextView) this.f165591b.getValue();
    }

    private final LoadMoreStatusView getStatusView() {
        return (LoadMoreStatusView) this.f165590a.getValue();
    }

    public final int getAnimState() {
        return this.f165592c;
    }

    public final void setRefreshStatus(int r100) {
        if (r100 != 0) goto L5;
        getStatusView().setECStatus(-1);
        getStatusText().setVisibility(4);
    L17:
        this.f165592c = r100;
        return;
    L5:
        if (r100 != 1) goto L7;
        getStatusView().setECStatus(-1);
        getStatusText().setVisibility(0);
        goto L17
    L7:
        if (r100 != 2) goto L9;
        getStatusView().setECStatus(-1);
        getStatusText().setVisibility(0);
        goto L17
    L9:
        if (r100 == 3) goto L13;
        if (r100 != 4) goto L17;
        getStatusView().a();
        getStatusText().setVisibility(4);
        goto L17
    L13:
        getStatusView().a();
        getStatusText().setVisibility(4);
        goto L17
    }

    public final void R5(int r100, int r101) {
        ViewGroup.LayoutParams r102 = getStatusView().getLayoutParams();
        if (r102 == null) goto L11;
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = r101;
        ViewGroup.LayoutParams r103 = getStatusView().getLayoutParams();
        if (r103 == null) goto L9;
        ((ViewGroup.MarginLayoutParams) r103).topMargin = r100;
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void S5(int r100, int r101) {
        getStatusView().getLayoutParams().height = r101;
        getStatusView().getLayoutParams().width = r100;
    }

    public FixedHeadView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f165590a = LazyKt.lazy(new FixedHeadView$statusView$2(this));
        this.f165591b = LazyKt.lazy(new FixedHeadView$statusText$2(this));
        th.a.c(r100, R.layout.ec_commerce_anchor_v3_fixed_head_layout, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public /* synthetic */ FixedHeadView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
