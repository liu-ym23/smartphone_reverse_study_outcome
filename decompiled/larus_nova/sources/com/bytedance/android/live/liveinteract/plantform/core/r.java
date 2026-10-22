package com.bytedance.android.live.liveinteract.plantform.core;

import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f76311a = null;

    static {
        f76311a = new r();
    }

    public r() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        int r102 = com.bytedance.android.live.liveinteract.plantform.utils.x.f77572a;
        LinkedHashMap r103 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.plantform.utils.x.X(r101, r103);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("notify_join_rtc_failed", r103);
    }
}
