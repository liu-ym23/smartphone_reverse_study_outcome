package com.bytedance.android.shopping.commentv3.uitree.list;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentListUI.a f172832a;

    public d(CommentListUI.a r100) {
        this.f172832a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommentListUI r100 = this.f172832a.f172826a;     // Catch: Throwable -> L14
        int r101 = CommentListUI.f172819o;     // Catch: Throwable -> L14
        RecyclerView r102 = r100.f172820i;     // Catch: Throwable -> L14
        RecyclerView.LayoutManager r103 = null;
        if (r102 == null) goto L5;
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();     // Catch: Throwable -> L14
    L7:
        if ((r104 instanceof LinearLayoutManager) == false) goto L10;
        r103 = r104;
    L10:
        LinearLayoutManager r105 = (LinearLayoutManager) r103;     // Catch: Throwable -> L14
        if (r105 == null) goto L17;
        r105.scrollToPositionWithOffset(0, 0);     // Catch: Throwable -> L14
        return;
    L17:
        return;
    L5:
        r104 = null;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }
}
