package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.MultiCameraLinkedRoomPagerAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PortraitVerticalLinkedCameraDialogWidget f159640a;

    public m(PortraitVerticalLinkedCameraDialogWidget r100) {
        this.f159640a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.f159640a.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L11;
        MultiCameraLinkedRoomPagerAdapter r100 = this.f159640a.f159613e;     // Catch: Throwable -> L8
        if (r100 == null) goto L15;
        r100.onPageSelected(0);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    }
}
