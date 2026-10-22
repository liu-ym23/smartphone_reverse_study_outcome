package com.bytedance.android.live.core.tetris.layer.view.staticlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import d80.d;
import h70.c;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/view/staticlayout/StaticFullScreenViewLayer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StaticFullScreenViewLayer extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f65883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<View> f65884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<View> f65885c;

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
    }

    public StaticFullScreenViewLayer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        int r101 = d.f467385a;
        boolean r102 = true;
        if ((d.f467385a & 1) > 0) goto L6;
        r102 = false;
    L6:
        this.f65883a = r102;
        this.f65884b = new HashSet();
        this.f65885c = new HashSet();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100) {
        super.addView(r100);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101) {
        super.addView(r100, r101);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r110, int r111) {
        if (this.f65883a == false) goto L27;
        int r100 = c.f483967a;
        int r101 = View.MeasureSpec.getSize(r111);
        int r102 = View.MeasureSpec.getSize(r110);
        int r103 = getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L26;
        View r105 = getChildAt(r104);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ConstraintLayout.LayoutParams) == true) goto L9;
        r106 = null;
    L9:
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
        if (r107 == null) goto L25;
        if (((ViewGroup.MarginLayoutParams) r107).width != (-1)) goto L18;
        if (((ViewGroup.MarginLayoutParams) r107).height != (-1)) goto L18;
        ((HashSet) this.f65885c).add(r105);
        ((ViewGroup.MarginLayoutParams) r107).width = (r102 - ((ViewGroup.MarginLayoutParams) r107).leftMargin) - ((ViewGroup.MarginLayoutParams) r107).rightMargin;
        ((ViewGroup.MarginLayoutParams) r107).height = (r101 - ((ViewGroup.MarginLayoutParams) r107).topMargin) - ((ViewGroup.MarginLayoutParams) r107).bottomMargin;
        int r108 = c.f483967a;
    L18:
        if (((HashSet) this.f65884b).contains(r105) == false) goto L25;
        int r109 = ((ViewGroup.MarginLayoutParams) r107).width;
        int r112 = ((ViewGroup.MarginLayoutParams) r107).leftMargin;
        int r113 = ((ViewGroup.MarginLayoutParams) r107).rightMargin;
        if (r109 == ((r102 - r112) - r113)) goto L22;
    L24:
        ((ViewGroup.MarginLayoutParams) r107).width = (r102 - r112) - r113;
        ((ViewGroup.MarginLayoutParams) r107).height = (r101 - ((ViewGroup.MarginLayoutParams) r107).topMargin) - ((ViewGroup.MarginLayoutParams) r107).bottomMargin;
        ((HashSet) this.f65885c).add(r105);
        goto L25
    L22:
        if (((ViewGroup.MarginLayoutParams) r107).height != ((r101 - ((ViewGroup.MarginLayoutParams) r107).topMargin) - ((ViewGroup.MarginLayoutParams) r107).bottomMargin)) goto L24;
        ((HashSet) this.f65885c).add(r105);
    L25:
        r104 = r104 + 1;
        goto L5
    L26:
        ((HashSet) this.f65884b).clear();
        this.f65884b.addAll(this.f65885c);
        ((HashSet) this.f65885c).clear();
    L27:
        super.onMeasure(r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        super.addView(r100, r101);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, int r102) {
        super.addView(r100, r101, r102);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        super.addView(r100, r101, r102);
    }
}
