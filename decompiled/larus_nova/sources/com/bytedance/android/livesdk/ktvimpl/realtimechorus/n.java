package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f146832a;

    public n(Function1 r100) {
        this.f146832a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f146832a.invoke(r101);
        ALogger.e("RTChorusRoomDressResource", "onError: " + r101);
    }
}
