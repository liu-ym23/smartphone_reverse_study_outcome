package androidx.room;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 implements nc.h {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ yb.u f1535c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f1536f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ nc.h f1537g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ String[] f1538h;
    public /* synthetic */ int[] i;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r1.emit(r15, r2) == r3) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0098, code lost:
    
        if (r1.emit(r15, r2) == r3) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // nc.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(int[] r14, nb.c r15) {
        /*
            r13 = this;
            java.lang.String[] r0 = r13.f1538h
            nc.h r1 = r13.f1537g
            boolean r2 = r15 instanceof androidx.room.f0
            if (r2 == 0) goto L17
            r2 = r15
            androidx.room.f0 r2 = (androidx.room.f0) r2
            int r3 = r2.i
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.i = r3
            goto L1c
        L17:
            androidx.room.f0 r2 = new androidx.room.f0
            r2.<init>(r13, r15)
        L1c:
            java.lang.Object r15 = r2.f1533g
            ob.a r3 = ob.a.f9351c
            int r4 = r2.i
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L3a
            if (r4 == r6) goto L32
            if (r4 != r5) goto L2b
            goto L32
        L2b:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r13)
            r13 = 0
            return r13
        L32:
            int[] r14 = r2.f1532f
            androidx.room.g0 r13 = r2.f1531c
            id.c.I(r15)
            goto L9b
        L3a:
            id.c.I(r15)
            yb.u r15 = r13.f1535c
            java.lang.Object r4 = r15.f16098c
            if (r4 != 0) goto L58
            boolean r15 = r13.f1536f
            if (r15 == 0) goto L9b
            java.util.Set r15 = kb.k.v0(r0)
            r2.f1531c = r13
            r2.f1532f = r14
            r2.i = r6
            java.lang.Object r15 = r1.emit(r15, r2)
            if (r15 != r3) goto L9b
            goto L9a
        L58:
            int[] r4 = r13.i
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            int r7 = r0.length
            r8 = 0
            r9 = r8
        L62:
            if (r8 >= r7) goto L84
            r10 = r0[r8]
            int r11 = r9 + 1
            java.lang.Object r12 = r15.f16098c
            if (r12 == 0) goto L7d
            int[] r12 = (int[]) r12
            r9 = r4[r9]
            r12 = r12[r9]
            r9 = r14[r9]
            if (r12 == r9) goto L79
            r6.add(r10)
        L79:
            int r8 = r8 + 1
            r9 = r11
            goto L62
        L7d:
            java.lang.String r13 = "Required value was null."
            od.f.e(r13)
            r13 = 0
            return r13
        L84:
            boolean r15 = r6.isEmpty()
            if (r15 != 0) goto L9b
            java.util.Set r15 = kb.l.O0(r6)
            r2.f1531c = r13
            r2.f1532f = r14
            r2.i = r5
            java.lang.Object r15 = r1.emit(r15, r2)
            if (r15 != r3) goto L9b
        L9a:
            return r3
        L9b:
            yb.u r13 = r13.f1535c
            r13.f16098c = r14
            jb.v r13 = jb.v.f6774a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.g0.emit(int[], nb.c):java.lang.Object");
    }
}
