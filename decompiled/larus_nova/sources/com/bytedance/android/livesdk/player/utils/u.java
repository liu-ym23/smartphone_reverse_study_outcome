package com.bytedance.android.livesdk.player.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class u extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s.a f156232a;

    public u(s.a r100, Looper r101) {
        this.f156232a = r100;
        super(r101);
    }

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        s.a r102 = this.f156232a;
        ReentrantLock r103 = r102.f156229a;
        if (r103 == null) goto L12;
        r103.lock();
        Condition r104 = r102.f156230b;     // Catch: Throwable -> L9
        if (r104 == null) goto L8;
        r104.signal();     // Catch: Throwable -> L9
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L8:
        r103.unlock();
    L9:
        th = move-exception;
        r103.unlock();
        throw th;
    L12:
        Runnable r106 = r100.getCallback();
        if (r106 == null) goto L19;
        r106.run();
        return true;
    L19:
        return true;
    }
}
