package androidx.lifecycle.viewmodel;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class a extends CreationExtras {
    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    public Object a(CreationExtras.Key r10) {
        q.g(r10, "key");
        return b().get(r10);
    }

    public final void c(CreationExtras.Key r10, Object r11) {
        q.g(r10, "key");
        b().put(r10, r11);
    }

    public a(CreationExtras r10) {
        q.g(r10, "initialExtras");
        b().putAll(r10.b());
    }

    public /* synthetic */ a(CreationExtras r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = CreationExtras.a.f3577b;
    L5:
        this(r10);
    }
}
