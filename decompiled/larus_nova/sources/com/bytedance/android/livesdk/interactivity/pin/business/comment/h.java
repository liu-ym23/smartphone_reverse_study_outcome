package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f138675a;

    public h(AutoEllipsesTextView r100) {
        this.f138675a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f138675a.getLineCount() != 1) goto L9;
        TextView r100 = this.f138675a;     // Catch: Throwable -> L6
        r100.setPadding(r100.getPaddingLeft(), this.f138675a.getPaddingTop(), UtilityKotlinExtentionsKt.i(3), this.f138675a.getPaddingBottom());     // Catch: Throwable -> L6
        return;
    }
}
