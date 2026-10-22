package com.bytedance.android.livesdk.gift.platform.format.panel.adapter;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1 f132126a;

    public a(FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1 r100) {
        this.f132126a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FormatGiftDialogViewPagerAdapter$createRecyclerView$$inlined$apply$lambda$1 r100 = this.f132126a;     // Catch: Throwable -> L4
        r100.f132122c = -1;     // Catch: Throwable -> L4
        r100.f132123d.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
