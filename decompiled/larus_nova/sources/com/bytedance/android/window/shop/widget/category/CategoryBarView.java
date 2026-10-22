package com.bytedance.android.window.shop.widget.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/window/shop/widget/category/CategoryBarView;", "Landroid/widget/LinearLayout;", "", "b", "I", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentIndex", "c", "getIndex", "setIndex", "index", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryBarView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Function4<WindowProductCategoryVODeprecated.a, Integer, Integer, Integer, Unit>> f189972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f189973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f189974c;

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(28));
        if (this.f189974c != 0) goto L5;
        r100.setMargins(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(4));
    L6:
        return r100;
    L5:
        r100.setMargins(com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(4));
        goto L6
    }

    public final int getCurrentIndex() {
        return this.f189973b;
    }

    public final int getIndex() {
        return this.f189974c;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public final void setCurrentIndex(int r100) {
        this.f189973b = r100;
    }

    public final void setIndex(int r100) {
        this.f189974c = r100;
    }

    public CategoryBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setOrientation(0);
        setGravity(17);
        this.f189972a = new ArrayList();
    }

    public static final void a(CategoryBarView r100, WindowProductCategoryVODeprecated.a r101, int r102, int r103) {
        Iterator r104 = ((ArrayList) r100.f189972a).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((Function4) r104.next()).invoke(r101, Integer.valueOf(r100.f189973b), Integer.valueOf(r102), Integer.valueOf(r103));
        goto L4
    }
}
