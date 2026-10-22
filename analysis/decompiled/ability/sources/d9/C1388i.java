package d9;

import java.util.Arrays;
import java.util.Collection;
import kotlin.text.Regex;

/* renamed from: d9.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1388i {

    /* renamed from: a, reason: collision with root package name */
    public final G8.f f4309a;
    public final Regex b;
    public final Collection c;
    public final S7.k d;
    public final InterfaceC1384e[] e;

    public C1388i(G8.f fVar, Regex regex, Collection collection, S7.k kVar, InterfaceC1384e... interfaceC1384eArr) {
        this.f4309a = fVar;
        this.b = regex;
        this.c = collection;
        this.d = kVar;
        this.e = interfaceC1384eArr;
    }

    public /* synthetic */ C1388i(G8.f fVar, InterfaceC1384e[] interfaceC1384eArr) {
        this(fVar, interfaceC1384eArr, C1387h.b);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1388i(G8.f name, InterfaceC1384e[] interfaceC1384eArr, S7.k kVar) {
        this(name, null, null, kVar, (InterfaceC1384e[]) Arrays.copyOf(interfaceC1384eArr, interfaceC1384eArr.length));
        kotlin.jvm.internal.k.f(name, "name");
    }

    public /* synthetic */ C1388i(Collection collection, InterfaceC1384e[] interfaceC1384eArr) {
        this(collection, interfaceC1384eArr, C1387h.d);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1388i(Collection nameList, InterfaceC1384e[] interfaceC1384eArr, S7.k kVar) {
        this(null, null, nameList, kVar, (InterfaceC1384e[]) Arrays.copyOf(interfaceC1384eArr, interfaceC1384eArr.length));
        kotlin.jvm.internal.k.f(nameList, "nameList");
    }
}
