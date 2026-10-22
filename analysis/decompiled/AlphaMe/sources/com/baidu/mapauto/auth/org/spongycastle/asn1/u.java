package com.baidu.mapauto.auth.org.spongycastle.asn1;

import com.baidu.mapauto.auth.org.spongycastle.util.a;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: classes.dex */
public abstract class u extends r implements Iterable<d> {

    /* renamed from: a, reason: collision with root package name */
    public Vector f7771a = new Vector();

    /* renamed from: b, reason: collision with root package name */
    public boolean f7772b = false;

    public u() {
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof u)) {
            return false;
        }
        u uVar = (u) rVar;
        if (this.f7771a.size() != uVar.f7771a.size()) {
            return false;
        }
        Enumeration enumerationElements = this.f7771a.elements();
        Enumeration enumerationElements2 = uVar.f7771a.elements();
        while (enumerationElements.hasMoreElements()) {
            d dVar = (d) enumerationElements.nextElement();
            if (dVar == null) {
                dVar = t0.f7767a;
            }
            d dVar2 = (d) enumerationElements2.nextElement();
            if (dVar2 == null) {
                dVar2 = t0.f7767a;
            }
            r rVarC = dVar.c();
            r rVarC2 = dVar2.c();
            if (rVarC != rVarC2 && !rVarC.equals(rVarC2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() throws IOException {
        if (this.f7772b) {
            b1 b1Var = new b1();
            b1Var.f7771a = this.f7771a;
            return b1Var;
        }
        Vector vector = new Vector();
        for (int i4 = 0; i4 != this.f7771a.size(); i4++) {
            vector.addElement(this.f7771a.elementAt(i4));
        }
        b1 b1Var2 = new b1();
        b1Var2.f7771a = vector;
        b1Var2.i();
        return b1Var2;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        m1 m1Var = new m1();
        m1Var.f7771a = this.f7771a;
        return m1Var;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        Enumeration enumerationElements = this.f7771a.elements();
        int size = this.f7771a.size();
        while (enumerationElements.hasMoreElements()) {
            Object obj = (d) enumerationElements.nextElement();
            if (obj == null) {
                obj = t0.f7767a;
            }
            size = (size * 17) ^ obj.hashCode();
        }
        return size;
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        r4 = r15.f7771a.elementAt(r8);
        r6 = r15.f7771a;
        r6.setElementAt(r6.elementAt(r10), r8);
        r15.f7771a.setElementAt(r4, r10);
        r6 = true;
        r4 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() throws java.io.IOException {
        /*
            r15 = this;
            java.lang.String r0 = "cannot encode object added to SET"
            java.lang.String r1 = "DER"
            boolean r2 = r15.f7772b
            if (r2 != 0) goto L8b
            r2 = 1
            r15.f7772b = r2
            java.util.Vector r3 = r15.f7771a
            int r3 = r3.size()
            if (r3 <= r2) goto L8b
            java.util.Vector r3 = r15.f7771a
            int r3 = r3.size()
            int r3 = r3 - r2
            r4 = r2
        L1b:
            if (r4 == 0) goto L8b
            java.util.Vector r4 = r15.f7771a
            r5 = 0
            java.lang.Object r4 = r4.elementAt(r5)
            com.baidu.mapauto.auth.org.spongycastle.asn1.d r4 = (com.baidu.mapauto.auth.org.spongycastle.asn1.d) r4
            com.baidu.mapauto.auth.org.spongycastle.asn1.r r4 = r4.c()     // Catch: java.io.IOException -> L85
            byte[] r4 = r4.a(r1)     // Catch: java.io.IOException -> L85
            r7 = r4
            r4 = r5
            r6 = r4
            r8 = r6
        L32:
            if (r8 == r3) goto L82
            java.util.Vector r9 = r15.f7771a
            int r10 = r8 + 1
            java.lang.Object r9 = r9.elementAt(r10)
            com.baidu.mapauto.auth.org.spongycastle.asn1.d r9 = (com.baidu.mapauto.auth.org.spongycastle.asn1.d) r9
            com.baidu.mapauto.auth.org.spongycastle.asn1.r r9 = r9.c()     // Catch: java.io.IOException -> L7c
            byte[] r9 = r9.a(r1)     // Catch: java.io.IOException -> L7c
            int r11 = r7.length
            int r12 = r9.length
            int r11 = java.lang.Math.min(r11, r12)
            r12 = r5
        L4d:
            if (r12 == r11) goto L5f
            r13 = r7[r12]
            r14 = r9[r12]
            if (r13 == r14) goto L5c
            r11 = r13 & 255(0xff, float:3.57E-43)
            r12 = r14 & 255(0xff, float:3.57E-43)
            if (r11 >= r12) goto L64
            goto L62
        L5c:
            int r12 = r12 + 1
            goto L4d
        L5f:
            int r12 = r7.length
            if (r11 != r12) goto L64
        L62:
            r7 = r9
            goto L7a
        L64:
            java.util.Vector r4 = r15.f7771a
            java.lang.Object r4 = r4.elementAt(r8)
            java.util.Vector r6 = r15.f7771a
            java.lang.Object r9 = r6.elementAt(r10)
            r6.setElementAt(r9, r8)
            java.util.Vector r6 = r15.f7771a
            r6.setElementAt(r4, r10)
            r6 = r2
            r4 = r8
        L7a:
            r8 = r10
            goto L32
        L7c:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r0)
            throw r15
        L82:
            r3 = r4
            r4 = r6
            goto L1b
        L85:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r0)
            throw r15
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapauto.auth.org.spongycastle.asn1.u.i():void");
    }

    @Override // java.lang.Iterable
    public final Iterator<d> iterator() {
        d[] dVarArr = new d[this.f7771a.size()];
        for (int i4 = 0; i4 != this.f7771a.size(); i4++) {
            dVarArr[i4] = (d) this.f7771a.elementAt(i4);
        }
        return new a.C0021a(dVarArr);
    }

    public final String toString() {
        return this.f7771a.toString();
    }

    public u(e eVar) {
        for (int i4 = 0; i4 != eVar.a(); i4++) {
            this.f7771a.addElement(eVar.a(i4));
        }
    }
}
