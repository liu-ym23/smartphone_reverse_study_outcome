package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayDeque;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.u1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1771u1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f20141a = new ArrayDeque();

    public /* synthetic */ C1771u1(C1767t1 c1767t1) {
    }

    public static /* bridge */ /* synthetic */ zzdf a(C1771u1 c1771u1, zzdf zzdfVar, zzdf zzdfVar2) {
        c1771u1.b(zzdfVar);
        c1771u1.b(zzdfVar2);
        zzdf zzgdVar = (zzdf) c1771u1.f20141a.pop();
        while (!c1771u1.f20141a.isEmpty()) {
            zzgdVar = new zzgd((zzdf) c1771u1.f20141a.pop(), zzgdVar);
        }
        return zzgdVar;
    }

    public static final int c(int i10) {
        int iBinarySearch = Arrays.binarySearch(zzgd.f20163h, i10);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    public final void b(zzdf zzdfVar) {
        C1787y1 c1787y1;
        if (!zzdfVar.k()) {
            if (!(zzdfVar instanceof zzgd)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzdfVar.getClass())));
            }
            zzgd zzgdVar = (zzgd) zzdfVar;
            b(zzgdVar.f20165d);
            b(zzgdVar.f20166e);
            return;
        }
        int iC = c(zzdfVar.f());
        ArrayDeque arrayDeque = this.f20141a;
        int iK = zzgd.K(iC + 1);
        if (arrayDeque.isEmpty() || ((zzdf) this.f20141a.peek()).f() >= iK) {
            this.f20141a.push(zzdfVar);
            return;
        }
        int iK2 = zzgd.K(iC);
        zzdf zzgdVar2 = (zzdf) this.f20141a.pop();
        while (true) {
            c1787y1 = null;
            if (this.f20141a.isEmpty() || ((zzdf) this.f20141a.peek()).f() >= iK2) {
                break;
            } else {
                zzgdVar2 = new zzgd((zzdf) this.f20141a.pop(), zzgdVar2);
            }
        }
        zzgd zzgdVar3 = new zzgd(zzgdVar2, zzdfVar);
        while (!this.f20141a.isEmpty()) {
            int iC2 = c(zzgdVar3.f()) + 1;
            ArrayDeque arrayDeque2 = this.f20141a;
            if (((zzdf) arrayDeque2.peek()).f() >= zzgd.K(iC2)) {
                break;
            } else {
                zzgdVar3 = new zzgd((zzdf) this.f20141a.pop(), zzgdVar3);
            }
        }
        this.f20141a.push(zzgdVar3);
    }
}
