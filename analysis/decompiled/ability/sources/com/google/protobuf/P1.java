package com.google.protobuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class P1 extends AbstractC1002v2 {
    public LinkedHashMap c = new LinkedHashMap();
    public ArrayList d = null;
    public final C0956k e = C1014y2.g;

    @Override // com.google.protobuf.AbstractC1002v2
    public final List A() {
        return K();
    }

    public final Map J() {
        LinkedHashMap linkedHashMap = this.c;
        if (linkedHashMap != null) {
            return linkedHashMap;
        }
        this.c = new LinkedHashMap(this.d.size());
        ArrayList arrayList = new ArrayList(this.d.size());
        this.e.getClass();
        Class<?> cls = ((InterfaceC0919a2) AbstractC1018z2.f2989a.c).getClass();
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            AbstractC0924c abstractC0924c = (AbstractC0924c) it.next();
            J1 j12 = (J1) abstractC0924c;
            if (cls.isInstance(j12.c)) {
                arrayList.add(j12);
            } else {
                G1 builder = AbstractC1018z2.f2989a.toBuilder();
                builder.r(abstractC0924c);
                arrayList.add(builder.build());
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            J1 j13 = (J1) it2.next();
            this.c.put(j13.b, (InterfaceC0919a2) j13.c);
        }
        this.d = null;
        return this.c;
    }

    public final List K() {
        Value valueM;
        ArrayList arrayList = this.d;
        if (arrayList != null) {
            return arrayList;
        }
        if (this.c == null) {
            throw null;
        }
        this.d = new ArrayList(this.c.size());
        for (Map.Entry entry : this.c.entrySet()) {
            ArrayList arrayList2 = this.d;
            this.e.getClass();
            G1 builder = AbstractC1018z2.f2989a.toBuilder();
            builder.b = entry.getKey();
            builder.d = true;
            b3 b3Var = (b3) ((InterfaceC0919a2) entry.getValue());
            if (b3Var instanceof Value) {
                valueM = (Value) b3Var;
            } else {
                valueM = ((a3) b3Var).m();
                if (!valueM.isInitialized()) {
                    throw AbstractC0916a.x(valueM);
                }
            }
            builder.c = valueM;
            builder.e = true;
            arrayList2.add(builder.build());
        }
        this.c = null;
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof P1) {
            return MapFieldLite.f(J(), ((P1) obj).J());
        }
        return false;
    }

    public final int hashCode() {
        return MapFieldLite.a(J());
    }

    @Override // com.google.protobuf.AbstractC1002v2
    public final List x() {
        return K();
    }

    @Override // com.google.protobuf.AbstractC1002v2
    public final J1 y() {
        this.e.getClass();
        return AbstractC1018z2.f2989a;
    }
}
