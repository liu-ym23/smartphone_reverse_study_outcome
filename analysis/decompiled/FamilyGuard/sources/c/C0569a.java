package c;

import android.content.Context;
import j4.k;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: c.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0569a {

    /* renamed from: a, reason: collision with root package name */
    private final Set<InterfaceC0570b> f11929a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f11930b;

    public final void a(InterfaceC0570b interfaceC0570b) {
        k.g(interfaceC0570b, "listener");
        Context context = this.f11930b;
        if (context != null) {
            interfaceC0570b.a(context);
        }
        this.f11929a.add(interfaceC0570b);
    }

    public final void b() {
        this.f11930b = null;
    }

    public final void c(Context context) {
        k.g(context, "context");
        this.f11930b = context;
        Iterator<InterfaceC0570b> it = this.f11929a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }

    public final Context d() {
        return this.f11930b;
    }

    public final void e(InterfaceC0570b interfaceC0570b) {
        k.g(interfaceC0570b, "listener");
        this.f11929a.remove(interfaceC0570b);
    }
}
