package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarkHighlightController.HighlightViewAdapter.HighlightPreviewViewHolder f135951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f135952b;

    public q0(MarkHighlightController.HighlightViewAdapter.HighlightPreviewViewHolder r100, Ref.FloatRef r101) {
        this.f135951a = r100;
        this.f135952b = r101;
    }

    public final void a() {
        int r100 = this.f135951a.itemView.getHeight();
        int r101 = (int) (r100 * this.f135952b.element);
        this.f135951a.f135705d.getLayoutParams().width = r101;
        ViewGroup.LayoutParams r102 = this.f135951a.f135702a.getLayoutParams();
        r102.width = r101;
        r102.height = r100;
        this.f135951a.f135702a.setLayoutParams(r102);
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
