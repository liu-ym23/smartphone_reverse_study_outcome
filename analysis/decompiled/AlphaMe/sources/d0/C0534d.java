package d0;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: d0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0534d extends AbstractC0533c {
    public C0534d(AbstractC0533c initialExtras) {
        Intrinsics.checkNotNullParameter(initialExtras, "initialExtras");
        this.f12412a.putAll(initialExtras.f12412a);
    }

    public final Object a(InterfaceC0532b key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f12412a.get(key);
    }

    public final void b(InterfaceC0532b key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f12412a.put(key, obj);
    }

    public C0534d() {
        this(C0531a.f12411b);
    }
}
