package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/PdpNestedScrollView;", "Lcom/bytedance/android/shopping/anchorv4/widgets/BasePdpNestedScrollView;", "", "getMainFeedDefaultVisibleHeight", "Lkotlin/Function0;", "h", "Lkotlin/jvm/functions/Function0;", "getCoverAreaHeight", "()Lkotlin/jvm/functions/Function0;", "setCoverAreaHeight", "(Lkotlin/jvm/functions/Function0;)V", "coverAreaHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpNestedScrollView extends BasePdpNestedScrollView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Integer> f170168h;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f170169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PdpNestedScrollView f170170b;

        public a(RecyclerView r100, PdpNestedScrollView r101) {
            this.f170169a = r100;
            this.f170170b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            if (this.f170169a.getHeight() <= 0) goto L10;
            this.f170169a.removeOnLayoutChangeListener(this);
            PdpNestedScrollView r109 = this.f170170b;
            r109.smoothScrollTo(0, PdpNestedScrollView.f(r109));
            RecyclerView r110 = this.f170170b.getRvTop();
            if (r110 != null) goto L7;
            return;
        L7:
            if (r110.canScrollVertically(1) != true) goto L12;
            PdpNestedScrollView r111 = this.f170170b;
            r111.e(r111.getRvTop());
            return;
        L12:
            return;
        }
    }

    public final void i() {
        RecyclerView r100 = this.f170136b;
        if (r100 == null) goto L5;
        r100.stopScroll();
    L5:
        RecyclerView r101 = this.f170137c;
        if (r101 == null) goto L8;
        r101.stopScroll();
    L8:
        e(getRvTop());
        RecyclerView r102 = getRvBottom();
        if (r102 == null) goto L11;
        r102.scrollToPosition(0);
    L11:
        RecyclerView r103 = getRvBottom();
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.getHeight() <= 0) goto L16;
        scrollTo(0, getMainFeedDefaultVisibleHeight());
        return;
    L16:
        r103.addOnLayoutChangeListener(new a(r103, this));
    }

    private final int getMainFeedDefaultVisibleHeight() {
        RecyclerView r100 = getRvTop();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.getHeight();
    L6:
        Function0<Integer> r103 = this.f170168h;
        if (r103 == null) goto L12;
        Integer r104 = r103.invoke();
        if (r104 == null) goto L12;
        r101 = r104.intValue();
    L12:
        return r102 - r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean g() {
        RecyclerView r100 = getRvTop();
        if (r100 != null) goto L5;
    L6:
        RecyclerView r101 = getRvTop();
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if (r101.canScrollVertically(-1) != true) goto L11;
        return true;
    L5:
        if (r100.canScrollVertically(1) != true) goto L6;
        return true;
    }

    public final boolean h() {
        if (getScrollY() >= getMainFeedDefaultVisibleHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Function0<Integer> getCoverAreaHeight() {
        return this.f170168h;
    }

    public PdpNestedScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public static final /* synthetic */ int f(PdpNestedScrollView r100) {
        return r100.getMainFeedDefaultVisibleHeight();
    }

    public final void setCoverAreaHeight(Function0<Integer> r100) {
        this.f170168h = r100;
    }
}
