package com.bytedance.android.shopping.store.arch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002RT\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/store/arch/FoldAdaptedFrameLayout;", "Landroid/widget/FrameLayout;", "", "enabled", "", "setAdaptedEnabled", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "d", "Lkotlin/jvm/functions/Function2;", "getOnTabSizeChangeListener", "()Lkotlin/jvm/functions/Function2;", "setOnTabSizeChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "onTabSizeChangeListener", "get_adapt", "()Z", "_adapt", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class FoldAdaptedFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f183488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f183489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f183490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f183491d;

    public FoldAdaptedFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FoldAdaptedFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final boolean get_adapt() {
        if (ECStoreFoldPhoneHelper.d() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f183488a == false) goto L7;
        return true;
    }

    public final Function2<Integer, Integer, Unit> getOnTabSizeChangeListener() {
        return this.f183491d;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100) {
        if (get_adapt() == false) goto L6;
        if (r100 == null) goto L6;
        r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 1));
    L6:
        super.addView(r100);
    }

    public final void setAdaptedEnabled(boolean r100) {
        if (r100 == this.f183488a) goto L6;
        this.f183488a = r100;
        requestLayout();
        return;
    }

    public final void setOnTabSizeChangeListener(Function2<? super Integer, ? super Integer, Unit> r100) {
        this.f183491d = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (get_adapt() == false) goto L17;
        int r102 = View.MeasureSpec.getSize(r100);
        if ((r102 / View.MeasureSpec.getSize(r101)) <= 0.75d) goto L7;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r102, ExtensionsKt.a(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS))), 1073741824), r101);
    L9:
        if (this.f183489b == getMeasuredWidth()) goto L11;
    L12:
        this.f183489b = getMeasuredWidth();
        this.f183490c = getMeasuredHeight();
        Function2<? super Integer, ? super Integer, Unit> r103 = this.f183491d;
        if (r103 == null) goto L15;
        Unit r104 = r103.invoke(Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()));
    L15:
        getMeasuredWidth();
        getMeasuredHeight();
    L16:
        setMeasuredDimension(r102, getMeasuredHeight());
        return;
    L11:
        if (this.f183490c == getMeasuredHeight()) goto L16;
    L7:
        super.onMeasure(r100, r101);
        goto L9
    L17:
        super.onMeasure(r100, r101);
    }

    public FoldAdaptedFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f183488a = true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (get_adapt() == false) goto L13;
        if (r100 == null) goto L7;
        r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    L7:
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L9;
        ViewGroup.LayoutParams r103 = null;
    L10:
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        if (r104 == null) goto L13;
        r104.gravity = 1;
        goto L13
    L9:
        r103 = r102;
    L13:
        super.addView(r100, r101, r102);
    }

    public /* synthetic */ FoldAdaptedFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
