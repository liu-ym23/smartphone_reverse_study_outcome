package com.bytedance.android.window.shop.product.pinrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u001cB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout;", "Landroid/widget/FrameLayout;", "", "getPinnedAreaHeight", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapter", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "setLayoutManager", "Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;", "getPinedCallback", "()Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;", "setPinedCallback", "(Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;)V", "pinedCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "InnerRecyclerView", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECRecyclerViewPinnableLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f189262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f189263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InnerRecyclerView f189264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f189265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseIntArray f189266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f189267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f189268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseIntArray f189269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f189270i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$InnerRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InnerRecyclerView extends RecyclerView {
        public InnerRecyclerView(Context r100) {
            AttributeSet r101 = null;
            this(r100, r101, 6, 0);
        }

        public InnerRecyclerView(Context r100, AttributeSet r101) {
            this(r100, r101, 4, 0);
        }

        public InnerRecyclerView(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101, r102);
        }

        public /* synthetic */ InnerRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101, 0);
        }
    }

    public static final class a {
    }

    public interface b {
        void A(InnerRecyclerView r100);

        void S(InnerRecyclerView r100, int r101);
    }

    static {
    }

    public ECRecyclerViewPinnableLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECRecyclerViewPinnableLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void f() {
        this.f189267f = 0;
        this.f189268g = -1;
        this.f189262a = 0;
        this.f189269h.clear();
        Object r100 = this.f189264c.getAdapter();
        if (r100 == null) goto L9;
        ((fq3.b) r100).clear();
        RecyclerView.Adapter r101 = this.f189264c.getAdapter();
        if (r101 == null) goto L10;
        r101.notifyDataSetChanged();
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.product.pinrecyclerview.IECPinAdapterData");
    }

    public final int c() {
        int r100 = this.f189268g;
        if (r100 >= 0) goto L5;
        return -1;
    L5:
        if (r100 < ((ArrayList) this.f189265d).size()) goto L8;
        return -1;
    L8:
        return ((Number) ListProtector.get(this.f189265d, 0)).intValue();
    }

    public final void e() {
        int r100 = this.f189268g;
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (r100 >= ((ArrayList) this.f189265d).size()) goto L41;
        int r101 = ((Number) ListProtector.get(this.f189265d, this.f189268g)).intValue();
        RecyclerView r102 = this.f189263b;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L9:
        if (r102 == null) goto L13;
        RecyclerView.LayoutManager r103 = r102.getLayoutManager();
        if (r103 == null) goto L13;
        View r104 = r103.findViewByPosition(r101);
    L14:
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.getBottom() < (this.f189262a - 500)) goto L26;
        int r105 = this.f189268g;
        if (this.f189269h.indexOfKey(r105) >= 0) goto L26;
        this.f189269h.put(r105, r105);
        RecyclerView r106 = this.f189263b;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L23:
        RecyclerView.Adapter r107 = r106.getAdapter();
        if (r107 == null) goto L26;
        r107.notifyItemChanged(((Number) ListProtector.get(this.f189265d, r105)).intValue());
    L26:
        int r108 = r104.getBottom();
        int r109 = this.f189262a;
        if (r108 < r109) goto L43;
        int r110 = this.f189268g;
        this.f189268g = r110 - 1;
        this.f189267f--;
        this.f189262a = r109 - r104.getHeight();
        RecyclerView r111 = this.f189263b;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L31:
        Object r112 = r111.getAdapter();
        if (r112 == null) goto L39;
        fq3.b r113 = (fq3.b) r112;
        Object r114 = this.f189264c.getAdapter();
        if (r114 == null) goto L37;
        ((fq3.b) r114).remove(r113.getItem(((Number) ListProtector.get(this.f189265d, r110)).intValue()));
        this.f189264c.post(new fq3.a(this, r110));
        e();
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.product.pinrecyclerview.IECPinAdapterData");
    L39:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.product.pinrecyclerview.IECPinAdapterData");
    L43:
        return;
    L13:
        r104 = null;
        goto L14
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 1) goto L17;
        View r100 = getChildAt(0);
        if ((r100 instanceof RecyclerView) == true) goto L7;
        r100 = null;
    L7:
        RecyclerView r101 = (RecyclerView) r100;
        if (r101 == null) goto L15;
        this.f189263b = r101;
        this.f189264c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f189264c.setItemAnimator(null);
        addView(this.f189264c);
        RecyclerView r102 = this.f189263b;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L12:
        r102.addOnScrollListener(new ECRecyclerViewPinnableLayout$initScrollListener$1(this));
        return;
    L15:
        throw new IllegalStateException("ECPinnableRecyclerView must have a recyclerView inside!!!");
    L17:
        throw new IllegalStateException("ECPinnableRecyclerView must have a recyclerView inside!!!");
    }

    public final b getPinedCallback() {
        return this.f189270i;
    }

    public final int getPinnedAreaHeight() {
        return this.f189262a;
    }

    public final void b(int r100) {
        if (((ArrayList) this.f189265d).isEmpty() == false) goto L5;
    L6:
        List<Integer> r101 = this.f189265d;
        ArrayList r102 = (ArrayList) r101;
        r102.add(Integer.valueOf(r100));
        return;
    L5:
        if (((Number) CollectionsKt.last(this.f189265d)).intValue() < r100) goto L6;
    }

    public final void d(int r100) {
        RecyclerView r101 = this.f189263b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L5:
        RecyclerView.Adapter r102 = r101.getAdapter();
        if (r102 == null) goto L8;
        r102.notifyItemChanged(r100);
    L8:
        RecyclerView.Adapter r103 = this.f189264c.getAdapter();
        if (r103 == null) goto L12;
        List<Integer> r104 = this.f189265d;
        ArrayList r105 = (ArrayList) r104;
        r103.notifyItemChanged(r105.indexOf(Integer.valueOf(r100)));
        return;
    }

    public final void setAdapter(RecyclerView.Adapter<?> r100) {
        if ((r100 instanceof fq3.b) == false) goto L7;
        this.f189264c.setAdapter(r100);
        return;
    L7:
        throw new IllegalStateException("ECPinnableRecyclerView adapter must be IECPinAdapterData!!!");
    }

    public final void setLayoutManager(RecyclerView.LayoutManager r100) {
        this.f189264c.setLayoutManager(r100);
    }

    public final void setPinedCallback(b r100) {
        this.f189270i = r100;
    }

    public ECRecyclerViewPinnableLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        AttributeSet r103 = null;
        this.f189264c = new InnerRecyclerView(r100, r103, 6, 0);
        this.f189265d = new ArrayList();
        this.f189266e = new SparseIntArray();
        this.f189268g = -1;
        this.f189269h = new SparseIntArray();
    }

    public static final void a(ECRecyclerViewPinnableLayout r100, int r101, int r102) {
        r100.f189268g++;
        r100.f189267f++;
        r100.f189262a += r102;
        RecyclerView r103 = r100.f189263b;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L5:
        Object r104 = r103.getAdapter();
        if (r104 == null) goto L19;
        fq3.b r105 = (fq3.b) r104;
        Object r106 = r100.f189264c.getAdapter();
        if (r106 == null) goto L17;
        ((fq3.b) r106).add(r105.getItem(((Number) ListProtector.get(r100.f189265d, r101)).intValue()));
        RecyclerView.Adapter r107 = r100.f189264c.getAdapter();
        if (r107 == null) goto L12;
        r107.notifyItemChanged(r101);
    L12:
        b r108 = r100.f189270i;
        if (r108 == null) goto L20;
        r108.S(r100.f189264c, ((Number) ListProtector.get(r100.f189265d, r101)).intValue());
        return;
    L20:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.product.pinrecyclerview.IECPinAdapterData");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.product.pinrecyclerview.IECPinAdapterData");
    }

    public /* synthetic */ ECRecyclerViewPinnableLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
