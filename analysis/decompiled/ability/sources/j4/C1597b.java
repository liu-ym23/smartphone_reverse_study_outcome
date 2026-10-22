package j4;

import D7.C;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: j4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1597b implements C {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4773a;

    public C1597b() {
        this.f4773a = new ArrayList();
    }

    public Object a() {
        return this.f4773a.remove(r1.size() - 1);
    }

    public void b(Object obj) {
        this.f4773a.add(obj);
    }

    @Override // D7.C
    public Object keyOf(Object obj) {
        return (String) obj;
    }

    @Override // D7.C
    public Iterator sourceIterator() {
        return this.f4773a.iterator();
    }

    public C1597b(int i) {
        this.f4773a = new ArrayList(i);
    }

    public C1597b(ArrayList arrayList) {
        this.f4773a = arrayList;
    }
}
