package com.bytedance.android.livesdk.chatroom.vs_base.player;

import com.bytedance.android.live.core.log.ALogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f118039a;

    public g() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) {
        Intrinsics.checkNotNullParameter(r102, "args");
        f r103 = this.f118039a;
        if (r103 == null) goto L21;
        Object r104 = r102[1];
        if (r104 == null) goto L20;
        vic.a r105 = (vic.a) r104;
        Object r106 = r102[2];
        if (r106 == null) goto L18;
        int r107 = ((Integer) r106).intValue();
        Object r108 = r102[3];
        if (r108 == null) goto L16;
        int r109 = ((Integer) r108).intValue();
        Object r110 = r102[4];
        if (r110 == null) goto L14;
        boolean r111 = ((Boolean) r110).booleanValue();
        ALogger.i("ScreenOrientationChangeListenerProxy", "FullScreenOperator: " + r105 + ", targetOrientation: " + r107 + ", currentOrientation: " + r109 + ", systemAutoRotateEnabled: " + r111);
        r103.a(r107, r109, r111);
        return null;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.videoshop.fullscreen.FullScreenOperator");
    L21:
        return null;
    }
}
