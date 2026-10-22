package com.stepos.ailauncher.homegesture;

import android.app.Application;
import com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator;
import h8.C4148a;
import io.ktor.http.ContentType;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/homegesture/w;", "", "<init>", "()V", "Landroid/app/Application;", ContentType.Application.TYPE, "LY8/t;", "c", "(Landroid/app/Application;)V", "", "TAG", "Ljava/lang/String;", "", "initialized", "Z", "Lcom/stepos/ailauncher/homegesture/HomeGestureCoordinatorImpl;", "coordinatorImpl", "Lcom/stepos/ailauncher/homegesture/HomeGestureCoordinatorImpl;", "Lkotlin/Function0;", "dismissDesktopHandler", "Lp9/a;", "getDismissDesktopHandler", "()Lp9/a;", "f", "(Lp9/a;)V", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w {
    public static final w INSTANCE = new w();
    private static final String TAG = "HomeGestureModule";
    private static volatile HomeGestureCoordinatorImpl coordinatorImpl;
    private static volatile InterfaceC5063a<Y8.t> dismissDesktopHandler;
    private static volatile boolean initialized;

    public static final Y8.t d(C3351s c3351s, long j10) {
        c3351s.a(j10);
        return Y8.t.f7040a;
    }

    public static final Y8.t e() {
        InterfaceC5063a<Y8.t> interfaceC5063a = dismissDesktopHandler;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public final void c(Application application) {
        kotlin.jvm.internal.p.i(application, "application");
        if (initialized) {
            return;
        }
        initialized = true;
        C3352t.INSTANCE.b(application);
        HomeGestureCoordinatorImpl homeGestureCoordinatorImpl = new HomeGestureCoordinatorImpl(null, null, null, 7, null);
        final C3351s c3351s = new C3351s(homeGestureCoordinatorImpl);
        homeGestureCoordinatorImpl.o(c3351s);
        coordinatorImpl = homeGestureCoordinatorImpl;
        D5.a.INSTANCE.b(IHomeGestureCoordinator.class, homeGestureCoordinatorImpl);
        application.registerActivityLifecycleCallbacks(new H(homeGestureCoordinatorImpl));
        C3342i.INSTANCE.e(application, new InterfaceC5074l() { // from class: com.stepos.ailauncher.homegesture.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return w.d(c3351s, ((Long) obj).longValue());
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return w.e();
            }
        });
        C3352t.g("home-module-init");
        C4148a.d(TAG, "init", false, 4, null);
    }

    public final void f(InterfaceC5063a<Y8.t> interfaceC5063a) {
        dismissDesktopHandler = interfaceC5063a;
    }
}
