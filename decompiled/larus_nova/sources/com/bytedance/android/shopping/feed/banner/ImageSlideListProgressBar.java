package com.bytedance.android.shopping.feed.banner;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/feed/banner/ImageSlideListProgressBar;", "Landroid/widget/LinearLayout;", "", "count", "", "setImageSlideListProgressBar", "Lkotlin/Function1;", "", "d", "Lkotlin/jvm/functions/Function1;", "getOnProgressBarSelected", "()Lkotlin/jvm/functions/Function1;", "setOnProgressBarSelected", "(Lkotlin/jvm/functions/Function1;)V", "onProgressBarSelected", "e", "Z", "getMIsClickEnabled", "()Z", "setMIsClickEnabled", "(Z)V", "mIsClickEnabled", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageSlideListProgressBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f174382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f174383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f174384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f174385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f174386e;

    public ImageSlideListProgressBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ImageSlideListProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getMIsClickEnabled() {
        return this.f174386e;
    }

    public final Function1<Boolean, Unit> getOnProgressBarSelected() {
        return this.f174385d;
    }

    public final void setImageSlideListProgressBar(int r100) {
        removeAllViews();
        this.f174383b = 0;
        if (r100 > 1) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        int r101 = 0;
    L7:
        if (r101 >= r100) goto L15;
        ImageSlideProgressBar r102 = new ImageSlideProgressBar(this.f174382a, null, 6, 0);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        if (r101 == (r100 - 1)) goto L11;
        r103.setMargins(0, 0, this.f174384c, 0);
    L11:
        r102.setLayoutParams(r103);
        if (this.f174386e == false) goto L14;
        r102.setOnClickListener(new a(this, r101));
    L14:
        addView(r102);
        r101 = r101 + 1;
        goto L7
    }

    public final void setMIsClickEnabled(boolean r100) {
        this.f174386e = r100;
    }

    public final void setOnProgressBarSelected(Function1<? super Boolean, Unit> r100) {
        this.f174385d = r100;
    }

    public ImageSlideListProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100, r101, r102);
        this.f174382a = getContext();
        Resources r103 = Resources.getSystem();
        this.f174384c = MathKt.roundToInt(TypedValue.applyDimension(1, (float) 5.0d, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
    }

    public /* synthetic */ ImageSlideListProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
