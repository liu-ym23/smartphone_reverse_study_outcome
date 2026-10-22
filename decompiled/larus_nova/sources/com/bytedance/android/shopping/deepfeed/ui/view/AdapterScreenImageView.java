package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/AdapterScreenImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdapterScreenImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f173869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f173870b;

    public AdapterScreenImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AdapterScreenImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r110) {
        ViewGroup.LayoutParams r101 = getLayoutParams();
        Pair<Integer, Integer> r102 = null;
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r101;
        if (r103 == null) goto L26;
        a r104 = this.f173869a;
        if (r104 == null) goto L26;
        float[] r105 = this.f173870b;
        Intrinsics.checkNotNullParameter(r103, "layoutParams");
        Intrinsics.checkNotNullParameter(r105, GXTemplateKey.FLEXBOX_MARGIN);
        if (r104.f173926b != 1) goto L26;
        if (r105.length != 4) goto L26;
        float r106 = r105[0];
        if (r106 == 0.0f) goto L17;
        r103.leftMargin = Math.round(r106 * r104.f173925a);
    L17:
        float r107 = r105[1];
        if (r107 == 0.0f) goto L20;
        r103.topMargin = Math.round(r107 * r104.f173925a);
    L20:
        float r108 = r105[2];
        if (r108 == 0.0f) goto L23;
        r103.rightMargin = Math.round(r108 * r104.f173925a);
    L23:
        float r109 = r105[3];
        if (r109 == 0.0f) goto L26;
        r103.bottomMargin = Math.round(r109 * r104.f173925a);
    L26:
        a r111 = this.f173869a;
        if (r111 == null) goto L29;
        r102 = r111.b(r100, r110);
    L29:
        if (r102 == null) goto L31;
        super.onMeasure(r102.getFirst().intValue(), r102.getSecond().intValue());
        return;
    L31:
        super.onMeasure(r100, r110);
    }

    public AdapterScreenImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a r103 = a.f173924e;
        this.f173869a = a.f173924e;
        this.f173870b = new float[]{r5.getDimension(1, 0.0f), r5.getDimension(3, 0.0f), r5.getDimension(2, 0.0f), r5.getDimension(0, 0.0f)};
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.customMarginBottom, R.attr.customMarginLeft, R.attr.customMarginRight, R.attr.customMarginTop}, 0, 0);
        r104.recycle();
    }

    public /* synthetic */ AdapterScreenImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
