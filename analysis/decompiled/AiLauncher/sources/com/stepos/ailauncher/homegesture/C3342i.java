package com.stepos.ailauncher.homegesture;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import h8.C4148a;
import io.ktor.http.ContentType;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/homegesture/i;", "", "<init>", "()V", "Landroid/app/Application;", ContentType.Application.TYPE, "Lkotlin/Function1;", "", "LY8/t;", "onConsume", "Lkotlin/Function0;", "onDismissDesktop", "e", "(Landroid/app/Application;Lp9/l;Lp9/a;)V", "", "registered", "Z", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.homegesture.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3342i {
    public static final C3342i INSTANCE = new C3342i();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static volatile boolean registered;

    public static final Y8.t f(final InterfaceC5074l interfaceC5074l, final long j10) {
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.homegesture.h
            @Override // java.lang.Runnable
            public final void run() {
                C3342i.g(interfaceC5074l, j10);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void g(InterfaceC5074l interfaceC5074l, long j10) {
        interfaceC5074l.invoke(Long.valueOf(j10));
    }

    public static final Y8.t h(final InterfaceC5063a interfaceC5063a) {
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.homegesture.g
            @Override // java.lang.Runnable
            public final void run() {
                C3342i.i(interfaceC5063a);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void i(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public final void e(Application application, final InterfaceC5074l<? super Long, Y8.t> onConsume, final InterfaceC5063a<Y8.t> onDismissDesktop) {
        kotlin.jvm.internal.p.i(application, "application");
        kotlin.jvm.internal.p.i(onConsume, "onConsume");
        kotlin.jvm.internal.p.i(onDismissDesktop, "onDismissDesktop");
        if (registered) {
            return;
        }
        C3337d c3337d = new C3337d(new InterfaceC5074l() { // from class: com.stepos.ailauncher.homegesture.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C3342i.f(onConsume, ((Long) obj).longValue());
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C3342i.h(onDismissDesktop);
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.stepos.ailauncher.action.CONSUME_HOME_GESTURE");
        intentFilter.addAction("com.stepos.ailauncher.action.DISMISS_DESKTOP_CHAT");
        application.registerReceiver(c3337d, intentFilter, "android.permission.INTERNAL_SYSTEM_WINDOW", mainHandler, 2);
        registered = true;
        C4148a.d("HomeConsumeReceiver", "registered CONSUME with INTERNAL_SYSTEM_WINDOW", false, 4, null);
    }
}
