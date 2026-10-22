package i8;

import X8.w;
import h8.InterfaceC1503K;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;

/* renamed from: i8.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1563i implements InterfaceC1556b {

    /* renamed from: a, reason: collision with root package name */
    public final e8.i f4613a;
    public final G8.c b;
    public final Map c;
    public final Object d;

    public C1563i(e8.i builtIns, G8.c fqName, Map map) {
        kotlin.jvm.internal.k.f(builtIns, "builtIns");
        kotlin.jvm.internal.k.f(fqName, "fqName");
        this.f4613a = builtIns;
        this.b = fqName;
        this.c = map;
        this.d = kotlin.a.b(LazyThreadSafetyMode.b, new I8.e(this, 21));
    }

    @Override // i8.InterfaceC1556b
    public final Map a() {
        return this.c;
    }

    @Override // i8.InterfaceC1556b
    public final G8.c b() {
        return this.b;
    }

    @Override // i8.InterfaceC1556b
    public final InterfaceC1503K getSource() {
        return InterfaceC1503K.f4577I;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [C7.f, java.lang.Object] */
    @Override // i8.InterfaceC1556b
    public final w getType() {
        Object f4884a = this.d.getF4884a();
        kotlin.jvm.internal.k.e(f4884a, "getValue(...)");
        return (w) f4884a;
    }
}
