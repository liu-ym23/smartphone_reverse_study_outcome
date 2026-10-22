package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes10.dex */
public final class o implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f146837a = null;

    static {
        f146837a = new o();
    }

    public o() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        ALogger.i("RTChorusRoomDressResource", "onComplete");
    }
}
