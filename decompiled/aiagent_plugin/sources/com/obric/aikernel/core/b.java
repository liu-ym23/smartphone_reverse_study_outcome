package com.obric.aikernel.core;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: TransactHandle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "TransactHandle";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22353a = null;

    static {
        f22353a = new b();
    }

    private b() {
    }

    public final void a(IBinder r3, RequestParams r4, int r5) {
        IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        o.e(r6, "binder");
        o.e(r4, "params");
        r4.setTargetComponent(2);
        r4.setEvent(r5);
        a(r6, r4.start());
    }

    private final void a(IBinder r3, Bundle r4) {
        IBinder r2 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        Parcel r5 = Parcel.obtain();
        o.c(r5, "obtain()");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L5
        Object r6 = n.f(Boolean.valueOf(r2.transact(1001, r5, null, 1)));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L10;
        AIKLog.INSTANCE.e(TAG, "postEvent err: " + r7);
    L10:
        r5.recycle();
        return;
    L5:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L7
    }
}
