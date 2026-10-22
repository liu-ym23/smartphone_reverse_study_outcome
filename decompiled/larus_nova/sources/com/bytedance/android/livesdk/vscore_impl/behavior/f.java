package com.bytedance.android.livesdk.vscore_impl.behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f159544a;

    public f(b r100) {
        this.f159544a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        ALogger.i("MultiCameraLinkedRoomBehavior", "onValueChanged hideByUgcMultiTabFilter updateView   ");
        this.f159544a.a();
    }
}
