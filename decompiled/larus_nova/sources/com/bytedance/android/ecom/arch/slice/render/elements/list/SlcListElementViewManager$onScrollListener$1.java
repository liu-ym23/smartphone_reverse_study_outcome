package com.bytedance.android.ecom.arch.slice.render.elements.list;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/ecom/arch/slice/render/elements/list/SlcListElementViewManager$onScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcListElementViewManager$onScrollListener$1 extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f50464a;

    public SlcListElementViewManager$onScrollListener$1(c r100) {
        this.f50464a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, final int r101, final int r102) {
        final IAction r103 = this.f50464a.Q3;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r100.getScrollState() != 0) goto L7;
        return;
    L7:
        super.onScrolled(r100, r101, r102);
        c r104 = this.f50464a;
        yq.a r105 = r104.S3;
        if (r105 != null) goto L10;
        r105 = new yq.a();
        r104.S3 = r105;
    L10:
        long r106 = r103.getScrollCallbackThreshold();
        Function0<Unit> r107 = new SlcListElementViewManager$onScrollListener$1$onScrolled$1(this, r103, r101, r102);
        long r108 = SystemClock.elapsedRealtime();
        if ((r108 - r105.f568738a) < r106) goto L15;
        r107.invoke();
        r105.f568738a = r108;
        return;
    }
}
