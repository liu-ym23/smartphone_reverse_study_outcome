package l3;

import java.util.AbstractQueue;
import m3.AbstractC1677d;

/* loaded from: classes3.dex */
public final class j extends AbstractC1677d {

    /* renamed from: a, reason: collision with root package name */
    public Object f5275a;
    public final /* synthetic */ int b;
    public final /* synthetic */ AbstractQueue c;

    public j(AbstractQueue abstractQueue, y yVar, int i) {
        this.b = i;
        this.c = abstractQueue;
        this.f5275a = yVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5275a != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object next() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f5275a
            if (r0 == 0) goto L31
            int r1 = r3.b
            switch(r1) {
                case 0: goto L1c;
                default: goto L9;
            }
        L9:
            r1 = r0
            l3.y r1 = (l3.y) r1
            l3.y r1 = r1.c()
            java.util.AbstractQueue r2 = r3.c
            com.google.common.cache.c r2 = (com.google.common.cache.c) r2
            l3.h r2 = r2.b
            l3.i r2 = (l3.i) r2
            if (r1 != r2) goto L2e
        L1a:
            r1 = 0
            goto L2e
        L1c:
            r1 = r0
            l3.y r1 = (l3.y) r1
            l3.y r1 = r1.e()
            java.util.AbstractQueue r2 = r3.c
            com.google.common.cache.c r2 = (com.google.common.cache.c) r2
            l3.h r2 = r2.b
            l3.i r2 = (l3.i) r2
            if (r1 != r2) goto L2e
            goto L1a
        L2e:
            r3.f5275a = r1
            return r0
        L31:
            java.util.NoSuchElementException r3 = new java.util.NoSuchElementException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.j.next():java.lang.Object");
    }
}
