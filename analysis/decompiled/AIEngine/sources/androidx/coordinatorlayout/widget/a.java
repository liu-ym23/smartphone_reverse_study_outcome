package androidx.coordinatorlayout.widget;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashSet;
import p.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public Object f1473a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1474b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1475c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1476d;

    public a(Closeable closeable) {
        this.f1474b = closeable;
    }

    public a a() {
        return new a((Closeable) this.f1474b);
    }

    public void b(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((o) this.f1475c).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                b(arrayList2.get(i10), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public boolean c(String str) {
        String str2 = (String) this.f1475c;
        if (str2 == null) {
            this.f1475c = str;
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        String str3 = (String) this.f1476d;
        if (str3 == null) {
            this.f1476d = str;
            return false;
        }
        if (str.equals(str3)) {
            return true;
        }
        if (((HashSet) this.f1473a) == null) {
            HashSet hashSet = new HashSet(16);
            this.f1473a = hashSet;
            hashSet.add((String) this.f1475c);
            ((HashSet) this.f1473a).add((String) this.f1476d);
        }
        return !((HashSet) this.f1473a).add(str);
    }
}
