package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class O1 extends AbstractC1002v2 {
    public volatile boolean c;
    public volatile MapField$StorageMode d;
    public N1 e;
    public ArrayList f;
    public final F1 g;

    public O1(F1 f12, Map map) {
        MapField$StorageMode mapField$StorageMode = MapField$StorageMode.f2855a;
        this.g = f12;
        this.c = true;
        this.d = mapField$StorageMode;
        this.e = new N1(this, map);
        this.f = null;
    }

    @Override // com.google.protobuf.AbstractC1002v2
    public final List A() {
        MapField$StorageMode mapField$StorageMode = this.d;
        MapField$StorageMode mapField$StorageMode2 = MapField$StorageMode.b;
        if (mapField$StorageMode != mapField$StorageMode2) {
            if (this.d == MapField$StorageMode.f2855a) {
                this.f = K(this.e);
            }
            this.e = null;
            this.d = mapField$StorageMode2;
        }
        return this.f;
    }

    public final N1 J(ArrayList arrayList) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AbstractC0924c abstractC0924c = (AbstractC0924c) it.next();
            this.g.getClass();
            J1 j12 = (J1) abstractC0924c;
            linkedHashMap.put(j12.b, j12.c);
        }
        return new N1(this, linkedHashMap);
    }

    public final ArrayList K(N1 n12) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((M1) n12.entrySet()).iterator();
        while (true) {
            Iterator it2 = (Iterator) ((H8.u) it).c;
            if (!it2.hasNext()) {
                return arrayList;
            }
            Map.Entry entry = (Map.Entry) it2.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            G1 g1U = ((J1) this.g.b).newBuilderForType();
            g1U.b = key;
            g1U.d = true;
            g1U.c = value;
            g1U.e = true;
            arrayList.add(new J1(g1U.f2834a, key, value));
        }
    }

    public final void L() {
        if (!this.c) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map M() {
        MapField$StorageMode mapField$StorageMode = this.d;
        MapField$StorageMode mapField$StorageMode2 = MapField$StorageMode.b;
        if (mapField$StorageMode == mapField$StorageMode2) {
            synchronized (this) {
                try {
                    if (this.d == mapField$StorageMode2) {
                        this.e = J(this.f);
                        this.d = MapField$StorageMode.c;
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableMap(this.e);
    }

    public final N1 N() {
        MapField$StorageMode mapField$StorageMode = this.d;
        MapField$StorageMode mapField$StorageMode2 = MapField$StorageMode.f2855a;
        if (mapField$StorageMode != mapField$StorageMode2) {
            if (this.d == MapField$StorageMode.b) {
                this.e = J(this.f);
            }
            this.f = null;
            this.d = mapField$StorageMode2;
        }
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof O1) {
            return MapFieldLite.f(M(), ((O1) obj).M());
        }
        return false;
    }

    public final int hashCode() {
        return MapFieldLite.a(M());
    }

    @Override // com.google.protobuf.AbstractC1002v2
    public final List x() {
        MapField$StorageMode mapField$StorageMode = this.d;
        MapField$StorageMode mapField$StorageMode2 = MapField$StorageMode.f2855a;
        if (mapField$StorageMode == mapField$StorageMode2) {
            synchronized (this) {
                try {
                    if (this.d == mapField$StorageMode2) {
                        this.f = K(this.e);
                        this.d = MapField$StorageMode.c;
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableList(this.f);
    }

    @Override // com.google.protobuf.AbstractC1002v2
    public final J1 y() {
        return (J1) this.g.b;
    }

    public O1(J1 j12, Map map) {
        this(new F1(j12, 6), map);
    }
}
