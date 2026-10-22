package com.stepos.ailauncher.container;

import android.os.Handler;
import android.view.C1399q;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0002\t\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/container/q0;", "", "Landroidx/lifecycle/LifecycleOwner;", Const.JSON_KEY_PROVIDER, "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/Lifecycle$Event;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/Lifecycle$Event;)V", "c", "Landroidx/lifecycle/q;", "registry", "Landroidx/lifecycle/q;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/stepos/ailauncher/container/q0$b;", "lastDispatchRunnable", "Lcom/stepos/ailauncher/container/q0$b;", "Landroidx/lifecycle/Lifecycle;", Const.INTENT_KEY_PKGNAME, "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "Companion", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class q0 {
    public static final String TAG = "ScrollOverlayComponentLifecycleDispatcher";
    private final Handler handler;
    private b lastDispatchRunnable;
    private final C1399q registry;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/container/q0$b;", "Ljava/lang/Runnable;", "Landroidx/lifecycle/q;", "registry", "Landroidx/lifecycle/Lifecycle$Event;", "event", "<init>", "(Landroidx/lifecycle/q;Landroidx/lifecycle/Lifecycle$Event;)V", "LY8/t;", "run", "()V", "Landroidx/lifecycle/q;", "Landroidx/lifecycle/Lifecycle$Event;", "getEvent", "()Landroidx/lifecycle/Lifecycle$Event;", "", "wasExecuted", "Z", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Runnable {
        private final Lifecycle.Event event;
        private final C1399q registry;
        private boolean wasExecuted;

        public b(C1399q registry, Lifecycle.Event event) {
            kotlin.jvm.internal.p.i(registry, "registry");
            kotlin.jvm.internal.p.i(event, "event");
            this.registry = registry;
            this.event = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.wasExecuted) {
                    return;
                }
                this.registry.i(this.event);
                this.wasExecuted = true;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public q0(LifecycleOwner provider) {
        kotlin.jvm.internal.p.i(provider, "provider");
        this.registry = new C1399q(provider);
        this.handler = new Handler();
    }

    public void a(Lifecycle.Event event) {
        kotlin.jvm.internal.p.i(event, "event");
        c(event);
    }

    public Lifecycle b() {
        return this.registry;
    }

    public final void c(Lifecycle.Event event) {
        b bVar = this.lastDispatchRunnable;
        if (bVar != null) {
            bVar.run();
        }
        b bVar2 = new b(this.registry, event);
        this.lastDispatchRunnable = bVar2;
        Handler handler = this.handler;
        kotlin.jvm.internal.p.f(bVar2);
        handler.postAtFrontOfQueue(bVar2);
    }
}
