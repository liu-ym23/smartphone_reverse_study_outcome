package w8;

import d7.t;
import java.util.ArrayList;
import java.util.Collection;
import v9.v;

/* loaded from: classes.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d8  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static w8.c c(v9.z r18, g1.y r19, int r20, int r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.d.c(v9.z, g1.y, int, int, boolean, boolean):w8.c");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static d1.b d(v9.z0 r9, g1.y r10, int r11, boolean r12) {
        /*
            boolean r0 = v9.c.i(r9)
            r1 = 0
            if (r0 == 0) goto Lf
            d1.b r9 = new d1.b
            r10 = 1
            r11 = 7
            r9.<init>(r10, r11, r1)
            return r9
        Lf:
            boolean r0 = r9 instanceof v9.p
            if (r0 == 0) goto L73
            boolean r6 = r9 instanceof t8.f
            r0 = r9
            v9.p r0 = (v9.p) r0
            v9.z r8 = r0.f10581h
            v9.z r2 = r0.f10580g
            r5 = 1
            r3 = r10
            r4 = r11
            r7 = r12
            w8.c r10 = c(r2, r3, r4, r5, r6, r7)
            r11 = r2
            v9.z r2 = r0.f10581h
            r5 = 2
            w8.c r12 = c(r2, r3, r4, r5, r6, r7)
            v9.z r0 = r12.f10886a
            v9.z r2 = r10.f10886a
            if (r2 != 0) goto L35
            if (r0 != 0) goto L35
            goto L6a
        L35:
            boolean r1 = r10.f10888c
            if (r1 != 0) goto L59
            boolean r12 = r12.f10888c
            if (r12 == 0) goto L3e
            goto L59
        L3e:
            if (r6 == 0) goto L4d
            t8.f r1 = new t8.f
            if (r2 != 0) goto L45
            r2 = r11
        L45:
            if (r0 != 0) goto L48
            goto L49
        L48:
            r8 = r0
        L49:
            r1.<init>(r2, r8)
            goto L6a
        L4d:
            if (r2 != 0) goto L50
            r2 = r11
        L50:
            if (r0 != 0) goto L53
            goto L54
        L53:
            r8 = r0
        L54:
            v9.z0 r1 = v9.d.j(r2, r8)
            goto L6a
        L59:
            if (r0 == 0) goto L63
            if (r2 != 0) goto L5e
            r2 = r0
        L5e:
            v9.z0 r2 = v9.d.j(r2, r0)
            goto L66
        L63:
            q7.k.b(r2)
        L66:
            v9.z0 r1 = v9.c.z(r9, r2)
        L6a:
            d1.b r9 = new d1.b
            int r10 = r10.f10887b
            r11 = 7
            r9.<init>(r10, r11, r1)
            return r9
        L73:
            r3 = r10
            r4 = r11
            r7 = r12
            boolean r10 = r9 instanceof v9.z
            if (r10 == 0) goto L96
            r2 = r9
            v9.z r2 = (v9.z) r2
            r5 = 3
            r6 = 0
            w8.c r10 = c(r2, r3, r4, r5, r6, r7)
            v9.z r11 = r10.f10886a
            d1.b r12 = new d1.b
            boolean r0 = r10.f10888c
            if (r0 == 0) goto L8f
            v9.z0 r11 = v9.c.z(r9, r11)
        L8f:
            int r9 = r10.f10887b
            r10 = 7
            r12.<init>(r9, r10, r11)
            return r12
        L96:
            a4.u r9 = new a4.u
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.d.d(v9.z0, g1.y, int, boolean):d1.b");
    }

    public v a(q8.a aVar, f8.b bVar, boolean z4, a3.b bVar2, o8.a aVar2, p pVar, boolean z10, p7.k kVar) {
        o oVar = new o(bVar, z4, bVar2, aVar2, false);
        v vVar = (v) kVar.invoke(aVar);
        Collection collectionR = aVar.r();
        q7.k.d(collectionR, "overriddenDescriptors");
        Collection<f8.c> collection = collectionR;
        ArrayList arrayList = new ArrayList(t.A0(collection, 10));
        for (f8.c cVar : collection) {
            q7.k.d(cVar, "it");
            arrayList.add((v) kVar.invoke(cVar));
        }
        return b(oVar, vVar, arrayList, pVar, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0326 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0404 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0408  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v9.v b(w8.o r30, v9.v r31, java.util.List r32, w8.p r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 1091
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.d.b(w8.o, v9.v, java.util.List, w8.p, boolean):v9.v");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0287 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0304 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f2  */
    /* JADX WARN: Type inference failed for: r22v0, types: [w8.d] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3, types: [f8.b, f8.c, f8.j] */
    /* JADX WARN: Type inference failed for: r5v6, types: [q8.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList e(a3.b r23, java.util.Collection r24) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.d.e(a3.b, java.util.Collection):java.util.ArrayList");
    }
}
