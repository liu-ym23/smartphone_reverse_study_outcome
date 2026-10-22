package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: classes43.dex */
public final class RemoteConfigProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f38283a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.bytedance.android.accessibilityLib_Core.config.remote.step.b f38284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f38285c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f38286d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f38287e;

    public static final class InternalHandler extends Handler {
        public InternalHandler(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            CoroutineScope r101 = RemoteConfigProcessor.f38283a;
            BuildersKt.async$default(RemoteConfigProcessor.f38283a, null, null, new RemoteConfigProcessor$InternalHandler$handleMessage$1(null), 3, null);
        }
    }

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            if (("RemoteConfigProcessor error = " + r101.getMessage()) == null) goto L5;
            Context r102 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        L5:
            r101.printStackTrace();
        }
    }

    static {
        f38283a = CoroutineScopeKt.CoroutineScope(w1.a(1, "RemoteConfigProcessor").plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new a(CoroutineExceptionHandler.Key)));
        f38285c = LazyKt.lazy(RemoteConfigProcessor$applyStep$2.INSTANCE);
        f38286d = LazyKt.lazy(RemoteConfigProcessor$internalHandler$2.INSTANCE);
    }

    public static void a(boolean r100) {
        BuildersKt.launch$default(f38283a, null, null, new RemoteConfigProcessor$process$1(r100, null), 3, null);
        if (com.bytedance.android.accessibilityLib_Core.engine.b.f38250b == true) goto L6;
        ((InternalHandler) f38286d.getValue()).sendEmptyMessageDelayed(1, 60000);
        return;
    }
}
