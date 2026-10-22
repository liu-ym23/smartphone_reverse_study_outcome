package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.protobuf.u1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0997u1 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2944a;
    public Iterator b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f2944a) {
        }
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f2944a) {
            case 0:
                Map.Entry entry = (Map.Entry) this.b.next();
                if (!(entry.getValue() instanceof AbstractC1001v1)) {
                    return entry;
                }
                C0993t1 c0993t1 = new C0993t1();
                c0993t1.f2943a = entry;
                return c0993t1;
            default:
                return (String) this.b.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f2944a) {
            case 0:
                this.b.remove();
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
