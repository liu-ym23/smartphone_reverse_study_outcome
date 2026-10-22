package android.view;

import android.os.Handler;
import android.view.Lifecycle;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/lifecycle/O;", "", "Landroidx/lifecycle/LifecycleOwner;", Const.JSON_KEY_PROVIDER, "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "LY8/t;", "c", "()V", Const.INTENT_KEY_PKGNAME, "e", Const.INTENT_KEY_UMID, "Landroidx/lifecycle/Lifecycle$Event;", "event", "f", "(Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/q;", Const.INTENT_KEY_APIKEY, "Landroidx/lifecycle/q;", "registry", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Landroidx/lifecycle/O$a;", "Landroidx/lifecycle/O$a;", "lastDispatchRunnable", "Landroidx/lifecycle/Lifecycle;", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "lifecycle-service_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class O {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C1399q registry;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public a lastDispatchRunnable;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/O$a;", "Ljava/lang/Runnable;", "Landroidx/lifecycle/q;", "registry", "Landroidx/lifecycle/Lifecycle$Event;", "event", "<init>", "(Landroidx/lifecycle/q;Landroidx/lifecycle/Lifecycle$Event;)V", "LY8/t;", "run", "()V", Const.INTENT_KEY_APIKEY, "Landroidx/lifecycle/q;", Const.INTENT_KEY_PKGNAME, "Landroidx/lifecycle/Lifecycle$Event;", "getEvent", "()Landroidx/lifecycle/Lifecycle$Event;", "", "c", "Z", "wasExecuted", "lifecycle-service_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final C1399q registry;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Lifecycle.Event event;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public boolean wasExecuted;

        public a(C1399q registry, Lifecycle.Event event) {
            p.i(registry, "registry");
            p.i(event, "event");
            this.registry = registry;
            this.event = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wasExecuted) {
                return;
            }
            this.registry.i(this.event);
            this.wasExecuted = true;
        }
    }

    public O(LifecycleOwner provider) {
        p.i(provider, "provider");
        this.registry = new C1399q(provider);
        this.handler = new Handler();
    }

    public Lifecycle a() {
        return this.registry;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }

    public final void f(Lifecycle.Event event) {
        a aVar = this.lastDispatchRunnable;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.registry, event);
        this.lastDispatchRunnable = aVar2;
        Handler handler = this.handler;
        p.f(aVar2);
        handler.postAtFrontOfQueue(aVar2);
    }
}
