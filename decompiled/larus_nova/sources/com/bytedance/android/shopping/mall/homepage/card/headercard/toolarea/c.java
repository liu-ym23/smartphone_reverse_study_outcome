package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolListAdapter f177859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f177860b;

    public c(ToolListAdapter r100, boolean r101) {
        this.f177859a = r100;
        this.f177860b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<ToolVO> r100 = this.f177859a.f177827c;     // Catch: Throwable -> L14 Exception -> L16
        if (r100 == null) goto L12;
        Iterator<T> r101 = r100.iterator();     // Catch: Throwable -> L14 Exception -> L16
    L6:
        if (r101.hasNext() == false) goto L12;
        ToolVO r102 = (ToolVO) r101.next();     // Catch: Throwable -> L14 Exception -> L16
        if (r102 == null) goto L6;
        ToolVO.Corner r103 = r102.getCorner();     // Catch: Throwable -> L14 Exception -> L16
        if (r103 == null) goto L6;
        r103.setCanShow(this.f177860b);     // Catch: Throwable -> L14 Exception -> L16
    L12:
        this.f177859a.notifyDataSetChanged();     // Catch: Throwable -> L14 Exception -> L16
    L33:
        return;
    L16:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L22;
        return;
    L22:
        throw th;
    }
}
