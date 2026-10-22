package com.stepos.ailauncher.chat.view;

import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/chat/view/C5;", "", "<init>", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "LY8/t;", "e", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", "dy", "Lcom/stepos/ailauncher/chat/view/EchelonLayoutManager;", "layoutManager", Const.INTENT_KEY_UMID, "(ILcom/stepos/ailauncher/chat/view/EchelonLayoutManager;)I", "Landroidx/recyclerview/widget/RecyclerView;", "", "isSnapping", "Z", "com/stepos/ailauncher/chat/view/C5$a", "onScrollListener", "Lcom/stepos/ailauncher/chat/view/C5$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class C5 {
    private boolean isSnapping;
    private final a onScrollListener = new a();
    private RecyclerView recyclerView;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/view/C5$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "LY8/t;", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
            if (newState != 0 || C5.this.isSnapping) {
                return;
            }
            C5.this.e(recyclerView);
        }
    }

    public static final void f(C5 c52) {
        c52.isSnapping = false;
    }

    public final int d(int dy, EchelonLayoutManager layoutManager) {
        return C5685n.n((int) (180 + (140 * (Math.abs(dy) / C5685n.f(layoutManager.getMItemViewHeight(), 1)))), 180, 320);
    }

    public final void e(RecyclerView recyclerView) {
        int iU;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        EchelonLayoutManager echelonLayoutManager = layoutManager instanceof EchelonLayoutManager ? (EchelonLayoutManager) layoutManager : null;
        if (echelonLayoutManager == null || (iU = echelonLayoutManager.u(echelonLayoutManager.B())) == 0) {
            return;
        }
        int iD = d(iU, echelonLayoutManager);
        this.isSnapping = true;
        recyclerView.smoothScrollBy(0, iU, new DecelerateInterpolator(), iD);
        recyclerView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.view.B5
            @Override // java.lang.Runnable
            public final void run() {
                C5.f(this.f25721a);
            }
        }, iD + 32);
    }
}
