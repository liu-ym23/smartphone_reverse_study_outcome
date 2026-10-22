package com.bytedance.android.shopping.anchorv4.voavhs.head.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4LoadMoreRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", BitableAnalytic.LinkSceneClickType.EXPAND, "", "setScrollState", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "getScrollToEndCallback", "()Lkotlin/jvm/functions/Function0;", "setScrollToEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "scrollToEndCallback", "", "c", "Ljava/lang/Float;", "getActionDownX", "()Ljava/lang/Float;", "setActionDownX", "(Ljava/lang/Float;)V", "actionDownX", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LoadMoreRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f168792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f168793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f168794c;

    public AnchorV4LoadMoreRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4LoadMoreRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final Float getActionDownX() {
        return this.f168794c;
    }

    public final Function0<Unit> getScrollToEndCallback() {
        return this.f168793b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f168794c = Float.valueOf(r100.getX());
    L18:
        return super.dispatchTouchEvent(r100);
    L5:
        if (r101 == 1) goto L10;
        if (r101 != 3) goto L18;
    L10:
        if (this.f168792a == false) goto L18;
        if ((!Intrinsics.areEqual(this.f168794c, r100.getX())) == false) goto L18;
        Function0<Unit> r102 = this.f168793b;
        if (r102 == null) goto L18;
        Unit r103 = r102.invoke();
        goto L18
    }

    public final void setActionDownX(Float r100) {
        this.f168794c = r100;
    }

    public final void setScrollState(final boolean r100) {
        if (this.f168792a == r100) goto L6;
        this.f168792a = r100;
        final Context r101 = getContext();
        LinearLayoutManager r102 = new AnonymousClass1(r100, r101);
        r102.setOrientation(0);
        Unit r103 = Unit.INSTANCE;
        setLayoutManager(r102);
        return;
    }

    public final void setScrollToEndCallback(Function0<Unit> r100) {
        this.f168793b = r100;
    }

    public AnchorV4LoadMoreRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168792a = true;
    }

    public /* synthetic */ AnchorV4LoadMoreRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
