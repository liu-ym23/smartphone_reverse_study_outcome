package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import android.view.ViewGroup;
import com.bytedance.android.shopping.commentv3.view.FilterCardSliceView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterCardViewHolder f172870a;

    public b(FilterCardViewHolder r100) {
        this.f172870a = r100;
    }

    public final void a() {
        int r100 = ((FilterCardSliceView) this.f172870a.f172852a).getHeight();
        if (r100 > 0) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = ((FilterCardSliceView) this.f172870a.f172852a).getLayoutParams();
        if (r101 == null) goto L8;
        r101.height = r100;
        ((FilterCardSliceView) this.f172870a.f172852a).setLayoutParams(r101);
    L8:
        Function1<? super Integer, Unit> r102 = this.f172870a.f172866n;
        if (r102 == null) goto L12;
        Unit r103 = r102.invoke(Integer.valueOf(r100));
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
