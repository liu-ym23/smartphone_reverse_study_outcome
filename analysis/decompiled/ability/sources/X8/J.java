package X8;

import a9.InterfaceC0310b;
import java.util.ArrayDeque;

/* loaded from: classes4.dex */
public class J {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1524a;
    public final boolean b;
    public final Y8.b c;
    public final kotlin.reflect.jvm.internal.impl.types.checker.a d;
    public final Y8.f e;
    public int f;
    public ArrayDeque g;
    public g9.i h;

    public J(boolean z10, boolean z11, Y8.b typeSystemContext, kotlin.reflect.jvm.internal.impl.types.checker.a kotlinTypePreparator, Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(typeSystemContext, "typeSystemContext");
        kotlin.jvm.internal.k.f(kotlinTypePreparator, "kotlinTypePreparator");
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.f1524a = z10;
        this.b = z11;
        this.c = typeSystemContext;
        this.d = kotlinTypePreparator;
        this.e = kotlinTypeRefiner;
    }

    public final void a() {
        ArrayDeque arrayDeque = this.g;
        kotlin.jvm.internal.k.c(arrayDeque);
        arrayDeque.clear();
        g9.i iVar = this.h;
        kotlin.jvm.internal.k.c(iVar);
        iVar.clear();
    }

    public final void b() {
        if (this.g == null) {
            this.g = new ArrayDeque(4);
        }
        if (this.h == null) {
            int i = g9.i.c;
            this.h = g9.l.f();
        }
    }

    public final U c(InterfaceC0310b type) {
        kotlin.jvm.internal.k.f(type, "type");
        return this.d.a(type);
    }

    public final w d(InterfaceC0310b type) {
        kotlin.jvm.internal.k.f(type, "type");
        this.e.getClass();
        return (w) type;
    }
}
