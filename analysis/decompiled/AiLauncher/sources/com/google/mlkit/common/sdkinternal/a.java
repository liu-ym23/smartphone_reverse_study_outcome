package com.google.mlkit.common.sdkinternal;

import D2.i;
import D2.j;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import y2.HandlerC5920a;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f21803b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static a f21804c;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f21805a;

    public a(Looper looper) {
        this.f21805a = new HandlerC5920a(looper);
    }

    public static a a() {
        a aVar;
        synchronized (f21803b) {
            try {
                if (f21804c == null) {
                    HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                    handlerThread.start();
                    f21804c = new a(handlerThread.getLooper());
                }
                aVar = f21804c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static Executor d() {
        return zzh.zza;
    }

    public <ResultT> i<ResultT> b(final Callable<ResultT> callable) {
        final j jVar = new j();
        c(new Runnable() { // from class: r3.r
            @Override // java.lang.Runnable
            public final void run() {
                Callable callable2 = callable;
                D2.j jVar2 = jVar;
                try {
                    jVar2.c(callable2.call());
                } catch (MlKitException e10) {
                    jVar2.b(e10);
                } catch (Exception e11) {
                    jVar2.b(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e11));
                }
            }
        });
        return jVar.a();
    }

    public void c(Runnable runnable) {
        d().execute(runnable);
    }
}
