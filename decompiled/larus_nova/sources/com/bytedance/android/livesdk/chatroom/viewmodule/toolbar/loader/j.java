package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TempAreaDynamicLoader f116479a;

    public j(TempAreaDynamicLoader r100) {
        this.f116479a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "e");
        TempAreaDynamicLoader r102 = this.f116479a;
        r102.f116449h = false;
        ALogger.d(r102.f116457p, r101.toString());
    }
}
