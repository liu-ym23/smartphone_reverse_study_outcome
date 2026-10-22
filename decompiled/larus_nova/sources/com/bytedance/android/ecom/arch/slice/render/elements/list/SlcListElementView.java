package com.bytedance.android.ecom.arch.slice.render.elements.list;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016R\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/elements/list/SlcListElementView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapter", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "isUserInputEnable", "()Z", "setUserInputEnable", "(Z)V", "", "<set-?>", "b", "I", "getSlcScrollX", "()I", "slcScrollX", "c", "getSlcScrollY", "slcScrollY", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public class SlcListElementView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f50458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SlcListElementView$adapterDataObserver$1 f50461d;

    public SlcListElementView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SlcListElementView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getSlcScrollX() {
        return this.f50459b;
    }

    public final int getSlcScrollY() {
        return this.f50460c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(final Canvas r100) {
        SlcViewExtensionsKt.b(this, r100, new AnonymousClass1(this, r100));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        return super.dispatchHoverEvent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f50458a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f50458a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void scrollToPosition(int r100) {
        super.scrollToPosition(r100);
        if (r100 != 0) goto L6;
        this.f50459b = 0;
        this.f50460c = 0;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter<?> r100) {
        RecyclerView.Adapter r101 = getAdapter();
        if (r101 == null) goto L5;
        r101.unregisterAdapterDataObserver(this.f50461d);
    L5:
        super.setAdapter(r100);
        if (r100 == null) goto L8;
        r100.registerAdapterDataObserver(this.f50461d);
    L8:
        this.f50459b = 0;
        this.f50460c = 0;
    }

    public final void setUserInputEnable(boolean r100) {
        this.f50458a = r100;
    }

    public static final /* synthetic */ void r(SlcListElementView r100, Canvas r101) {
        super.dispatchDraw(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void onScrolled(int r100, int r101) {
        super.onScrolled(r100, r101);
        this.f50459b += r100;
        int r102 = this.f50460c + r101;
        this.f50460c = r102;
        if (r102 == 0) goto L8;
        if (canScrollVertically(-1) == true) goto L8;
        this.f50460c = 0;
    L8:
        if (this.f50459b != 0) goto L10;
        return;
    L10:
        if (canScrollHorizontally(-1) == true) goto L14;
        this.f50459b = 0;
        return;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.android.ecom.arch.slice.render.elements.list.SlcListElementView$adapterDataObserver$1] */
    public SlcListElementView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f50458a = true;
        this.f50461d = new SlcListElementView$adapterDataObserver$1(this);
    }

    public /* synthetic */ SlcListElementView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
