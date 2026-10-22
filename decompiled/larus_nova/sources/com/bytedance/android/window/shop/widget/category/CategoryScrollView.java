package com.bytedance.android.window.shop.widget.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/window/shop/widget/category/CategoryScrollView;", "Landroid/widget/HorizontalScrollView;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/Integer;", "getXPosition", "()Ljava/lang/Integer;", "setXPosition", "(Ljava/lang/Integer;)V", "xPosition", "Lcom/bytedance/android/window/shop/widget/category/CategoryBarView;", "b", "Lcom/bytedance/android/window/shop/widget/category/CategoryBarView;", "getCategoryBarView", "()Lcom/bytedance/android/window/shop/widget/category/CategoryBarView;", "setCategoryBarView", "(Lcom/bytedance/android/window/shop/widget/category/CategoryBarView;)V", "categoryBarView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f189975d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f189976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CategoryBarView f189977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Function5<View, Integer, Integer, Integer, Integer, Unit>> f189978c;

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f189977b = (CategoryBarView) findViewById(R.id.category_bar_view);
    }

    public final CategoryBarView getCategoryBarView() {
        return this.f189977b;
    }

    public final Integer getXPosition() {
        return this.f189976a;
    }

    public final void setCategoryBarView(CategoryBarView r100) {
        this.f189977b = r100;
    }

    public final void setXPosition(Integer r100) {
        this.f189976a = r100;
    }

    public CategoryScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f189978c = new ArrayList();
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r110, int r111, int r112) {
        super.onScrollChanged(r100, r110, r111, r112);
        Iterator<T> r101 = this.f189978c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function5) r101.next()).invoke(this, Integer.valueOf(r100), Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r112));
        goto L4
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        Integer r105 = this.f189976a;
        if (r105 == null) goto L6;
        scrollTo(r105.intValue(), 0);
        return;
    }
}
