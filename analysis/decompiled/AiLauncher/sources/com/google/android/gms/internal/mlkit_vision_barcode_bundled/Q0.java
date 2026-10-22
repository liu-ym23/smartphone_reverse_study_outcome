package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Q0 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f20049a;

    public Q0(Iterator it) {
        this.f20049a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f20049a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f20049a.next();
        return entry.getValue() instanceof R0 ? new P0(entry, null) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f20049a.remove();
    }
}
