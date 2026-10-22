package com.bytedance.android.shopping.anchorv3.anchorv3.detail.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.extensions.b;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h53.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/anchorv3/detail/widget/CategoryView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f164430a;

    public CategoryView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CategoryView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "categoryStyle");
        this.f164430a = r100;
        if ((r100 instanceof a.C6101a) == false) goto L8;
        if (r101 == false) goto L6;
        setBackgroundResource(R.color.shopping_color_F6F7FB);
    L10:
        requestLayout();
        return;
    L6:
        setBackgroundResource(R.color.shopping_space_line);
        goto L10
    L8:
        if ((r100 instanceof a.b) == false) goto L10;
        setBackgroundResource(R.color.shopping_space_category);
        goto L10
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        a r102 = this.f164430a;
        if ((r102 instanceof a.C6101a) == false) goto L6;
        setMeasuredDimension(View.MeasureSpec.getSize(r100), 1);
        return;
    L6:
        if ((r102 instanceof a.b) == false) goto L10;
        setMeasuredDimension(View.MeasureSpec.getSize(r100), b.b(10));
        return;
    }

    public CategoryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a.C6101a r103 = a.C6101a.f483874a;
        this.f164430a = r103;
        if (isInEditMode() == false) goto L5;
        ViewGroup.LayoutParams r104 = getLayoutParams();
        r104.height = 1;
        Unit r105 = Unit.INSTANCE;
        setLayoutParams(r104);
        setBackgroundResource(R.color.shopping_space_line);
    L5:
        a(r103, false);
    }

    public /* synthetic */ CategoryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
