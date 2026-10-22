package za;

import E9.C0818x;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ya.S;

/* renamed from: za.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6458d {

    /* renamed from: a, reason: collision with root package name */
    public static final C0818x<C6467m<AbstractC6475u>> f45403a = new C0818x<>("KotlinTypeRefiner");

    public static final C0818x<C6467m<AbstractC6475u>> a() {
        return f45403a;
    }

    public static final List<S> b(kotlin.reflect.jvm.internal.impl.types.checker.c cVar, Iterable<? extends S> types) {
        kotlin.jvm.internal.p.i(cVar, "<this>");
        kotlin.jvm.internal.p.i(types, "types");
        ArrayList arrayList = new ArrayList(C1174w.x(types, 10));
        Iterator<? extends S> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(cVar.a(it.next()));
        }
        return arrayList;
    }
}
