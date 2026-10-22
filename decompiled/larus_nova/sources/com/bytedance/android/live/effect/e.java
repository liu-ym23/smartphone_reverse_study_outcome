package com.bytedance.android.live.effect;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBeautifyDialogFragment f67998a;

    public e(LiveBeautifyDialogFragment r100) {
        this.f67998a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveBeautifyDialogFragment r100 = this.f67998a;     // Catch: Throwable -> L6
        int r101 = LiveBeautifyDialogFragment.f66670j;     // Catch: Throwable -> L6
        r100.getClass();     // Catch: Throwable -> L6
        ConstraintLayout r102 = (ConstraintLayout) this.f67998a.S90(R.id.ll_beauty_mode);     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.setVisibility(0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
