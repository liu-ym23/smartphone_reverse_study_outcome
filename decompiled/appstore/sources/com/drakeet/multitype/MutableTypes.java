package com.drakeet.multitype;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.y;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public class MutableTypes implements Types {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f10266b;

    public MutableTypes(int r10, List r11) {
        q.h(r11, "types");
        this.f10265a = r10;
        this.f10266b = r11;
    }

    public List a() {
        return this.f10266b;
    }

    @Override // com.drakeet.multitype.Types
    public int firstIndexOf(Class r10) {
        q.h(r10, "clazz");
        Iterator r11 = a().iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L9;
        if (q.b(((d) r11.next()).a(), r10) == true) goto L10;
        r13 = r13 + 1;
    L10:
        if (r13 == (-1)) goto L12;
        return r13;
    L12:
        Iterator r14 = a().iterator();
    L14:
        if (r14.hasNext() == false) goto L24;
        if (((d) r14.next()).a().isAssignableFrom(r10) == true) goto L19;
        r12 = r12 + 1;
        goto L14
    L19:
        return r12;
    L24:
        return -1;
    L9:
        r13 = -1;
        goto L10
    }

    @Override // com.drakeet.multitype.Types
    public int getSize() {
        return a().size();
    }

    @Override // com.drakeet.multitype.Types
    public d getType(int r10) {
        Object r11 = a().get(r10);
        if (r11 == null) goto L7;
        return (d) r11;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.drakeet.multitype.Type<T>");
    }

    @Override // com.drakeet.multitype.Types
    public void register(d r10) {
        q.h(r10, "type");
        a().add(r10);
    }

    @Override // com.drakeet.multitype.Types
    public boolean unregister(final Class r10) {
        q.h(r10, "clazz");
        return y.B(a(), new AnonymousClass1(r10));
    }

    public /* synthetic */ MutableTypes(int r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = new ArrayList(r10);
    L8:
        this(r10, r11);
    }
}
