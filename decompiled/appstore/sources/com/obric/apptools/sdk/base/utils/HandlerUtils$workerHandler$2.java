package com.obric.apptools.sdk.base.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.obric.apptools.sdk.base.log.L;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class HandlerUtils$workerHandler$2 extends Lambda implements Function0<Handler> {
    public static final HandlerUtils$workerHandler$2 INSTANCE = null;

    static {
        INSTANCE = new HandlerUtils$workerHandler$2();
    }

    public HandlerUtils$workerHandler$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Handler invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Handler invoke() {
        HandlerThread r10 = new HandlerThread("APPTOOLS_WORKER_THREAD");     // Catch: Exception -> L4
        r10.start();     // Catch: Exception -> L4
        Looper r11 = r10.getLooper();     // Catch: Exception -> L4
    L7:
        return new Handler(r11);
    L4:
        e = move-exception;
        L.b("HandlerUtils", "create worker thread failed, use main looper instead", e);
        r11 = Looper.getMainLooper();
        goto L7
    }
}
