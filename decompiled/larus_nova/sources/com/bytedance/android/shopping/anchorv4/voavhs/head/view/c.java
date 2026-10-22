package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4FeaturedCommentView f168935a;

    public c(AnchorV4FeaturedCommentView r100) {
        this.f168935a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f168935a.getRootView().findViewById(R.id.featured_comment_root_view);     // Catch: Throwable -> L9
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L9
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;     // Catch: Throwable -> L9
        if (r102 == null) goto L12;
        int r103 = r102.leftMargin;     // Catch: Throwable -> L9
        r102.bottomMargin = r103;     // Catch: Throwable -> L9
        r102.topMargin = r103;     // Catch: Throwable -> L9
        r100.setLayoutParams(r102);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
