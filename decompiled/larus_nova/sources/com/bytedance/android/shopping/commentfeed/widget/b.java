package com.bytedance.android.shopping.commentfeed.widget;

import android.text.method.ScrollingMovementMethod;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECExpandableTextView f172495a;

    public b(ECExpandableTextView r100) {
        this.f172495a = r100;
    }

    public final void a() {
        ECExpandableTextView r100 = this.f172495a;
        if (r100.f172423a.getHeight() < r100.f172430h) goto L5;
        r100.f172423a.setVerticalScrollBarEnabled(true);
        r100.f172423a.setMovementMethod(ScrollingMovementMethod.getInstance());
        r100.f172423a.setText(r100.f172432j + "\n");
        return;
    L5:
        r100.f172423a.setVerticalScrollBarEnabled(false);
        r100.f172423a.setMovementMethod(null);
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
