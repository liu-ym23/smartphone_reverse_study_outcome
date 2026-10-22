package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class W0 {

    /* renamed from: a, reason: collision with root package name */
    public C0990s2 f2885a;
    public boolean b;
    public boolean c;
    public boolean d;

    public static Object k(X0 x02, Object obj, boolean z10) {
        Object objM;
        if (obj == null) {
            return obj;
        }
        D0 d02 = (D0) x02;
        if (d02.h().f2887a == WireFormat$JavaType.MESSAGE) {
            if (d02.isRepeated()) {
                if (!(obj instanceof List)) {
                    throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + obj.getClass());
                }
                List arrayList = (List) obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    Object obj2 = arrayList.get(i);
                    if (obj2 instanceof W1) {
                        W1 w12 = (W1) obj2;
                        objM = z10 ? w12.m() : w12.k();
                    } else {
                        objM = obj2;
                    }
                    if (objM != obj2) {
                        if (arrayList == obj) {
                            arrayList = new ArrayList(arrayList);
                        }
                        arrayList.set(i, objM);
                    }
                }
                return arrayList;
            }
            if (obj instanceof W1) {
                W1 w13 = (W1) obj;
                return z10 ? w13.m() : w13.k();
            }
        }
        return obj;
    }

    public static void l(C0990s2 c0990s2, boolean z10) {
        for (int i = 0; i < c0990s2.b.size(); i++) {
            Map.Entry entryD = c0990s2.d(i);
            entryD.setValue(k((X0) entryD.getKey(), entryD.getValue(), z10));
        }
        for (Map.Entry entry : c0990s2.e()) {
            entry.setValue(k((X0) entry.getKey(), entry.getValue(), z10));
        }
    }

    public static void n(D0 d02, Object obj) {
        if (Y0.o(d02.h(), obj)) {
            return;
        }
        if (d02.h().f2887a != WireFormat$JavaType.MESSAGE || !(obj instanceof W1)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(d02.b.e), d02.h().f2887a, obj.getClass().getName()));
        }
    }

    public final void a(D0 d02, Object obj) {
        List arrayList;
        d();
        if (!d02.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        this.d = this.d || (obj instanceof W1);
        n(d02, obj);
        Object objF = f(d02);
        if (objF == null) {
            arrayList = new ArrayList();
            this.f2885a.put(d02, arrayList);
        } else {
            arrayList = (List) objF;
        }
        arrayList.add(obj);
    }

    public final Y0 b(boolean z10) {
        if (this.f2885a.isEmpty()) {
            return Y0.d;
        }
        this.c = false;
        C0990s2 c0990s2B = this.f2885a;
        if (this.d) {
            c0990s2B = Y0.b(c0990s2B, false);
            l(c0990s2B, z10);
        }
        Y0 y02 = new Y0(c0990s2B);
        y02.c = this.b;
        return y02;
    }

    public final void c(D0 d02) {
        d();
        this.f2885a.remove(d02);
        if (this.f2885a.isEmpty()) {
            this.b = false;
        }
    }

    public final void d() {
        if (this.c) {
            return;
        }
        this.f2885a = Y0.b(this.f2885a, true);
        this.c = true;
    }

    public final Map e() {
        if (!this.b) {
            C0990s2 c0990s2 = this.f2885a;
            return c0990s2.d ? c0990s2 : Collections.unmodifiableMap(c0990s2);
        }
        C0990s2 c0990s2B = Y0.b(this.f2885a, false);
        if (this.f2885a.d) {
            c0990s2B.g();
            return c0990s2B;
        }
        l(c0990s2B, true);
        return c0990s2B;
    }

    public final Object f(X0 x02) {
        Object obj = this.f2885a.get(x02);
        return obj instanceof AbstractC1001v1 ? ((AbstractC1001v1) obj).a() : obj;
    }

    public final boolean g(D0 d02) {
        if (d02.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f2885a.get(d02) != null;
    }

    public final boolean h() {
        for (int i = 0; i < this.f2885a.b.size(); i++) {
            if (!Y0.n(this.f2885a.d(i))) {
                return false;
            }
        }
        Iterator it = this.f2885a.e().iterator();
        while (it.hasNext()) {
            if (!Y0.n((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void i(Y0 y02) {
        C0990s2 c0990s2;
        d();
        int i = 0;
        while (true) {
            c0990s2 = y02.f2903a;
            if (i >= c0990s2.b.size()) {
                break;
            }
            j(c0990s2.d(i));
            i++;
        }
        Iterator it = c0990s2.e().iterator();
        while (it.hasNext()) {
            j((Map.Entry) it.next());
        }
    }

    public final void j(Map.Entry entry) {
        X0 x02 = (X0) entry.getKey();
        Object value = entry.getValue();
        D0 d02 = (D0) x02;
        if (d02.isRepeated()) {
            List arrayList = (List) f(d02);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f2885a.put(d02, arrayList);
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                arrayList.add(Y0.d(it.next()));
            }
            return;
        }
        if (d02.h().f2887a != WireFormat$JavaType.MESSAGE) {
            this.f2885a.put(d02, Y0.d(value));
            return;
        }
        Object objF = f(d02);
        if (objF == null) {
            this.f2885a.put(d02, Y0.d(value));
        } else if (objF instanceof W1) {
            ((AbstractC0916a) ((W1) objF)).t((AbstractC0924c) ((X1) value));
        } else {
            this.f2885a.put(d02, ((AbstractC0916a) ((X1) objF).toBuilder()).t((AbstractC0924c) ((X1) value)).k());
        }
    }

    public final void m(D0 d02, Object obj) {
        d();
        if (!d02.isRepeated()) {
            n(d02, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                n(d02, next);
                this.d = this.d || (next instanceof W1);
            }
            obj = arrayList;
        }
        this.d = this.d || (obj instanceof W1);
        this.f2885a.put(d02, obj);
    }
}
