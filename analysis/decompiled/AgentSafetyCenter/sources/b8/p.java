package b8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p implements r0 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2002c;

    /* renamed from: f, reason: collision with root package name */
    public Object f2003f;

    /* renamed from: g, reason: collision with root package name */
    public long f2004g;

    /* renamed from: h, reason: collision with root package name */
    public Object f2005h;

    public /* synthetic */ p(int i) {
        this.f2002c = i;
    }

    @Override // b8.r0
    public String k() {
        switch (this.f2002c) {
        }
        return String.valueOf(this.f2004g);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0057 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059 A[ORIG_RETURN, RETURN] */
    @Override // b8.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o(com.fasterxml.jackson.databind.JsonNode r6) {
        /*
            r5 = this;
            int r0 = r5.f2002c
            switch(r0) {
                case 0: goto L5b;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r5.f2003f
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r5.f2005h
            b8.e0 r1 = (b8.e0) r1
            boolean r1 = r1.f1953h
            boolean r2 = r6.isBigInteger()
            if (r2 == 0) goto L29
            java.math.BigInteger r5 = r6.bigIntegerValue()
            java.math.BigInteger r6 = new java.math.BigInteger
            r6.<init>(r0)
            int r5 = r5.compareTo(r6)
            if (r5 < 0) goto L59
            if (r1 == 0) goto L57
            if (r5 != 0) goto L57
            goto L59
        L29:
            boolean r2 = r6.isTextual()
            if (r2 == 0) goto L48
            java.math.BigDecimal r5 = new java.math.BigDecimal
            r5.<init>(r0)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            java.lang.String r6 = r6.asText()
            r0.<init>(r6)
            int r5 = r0.compareTo(r5)
            if (r5 < 0) goto L59
            if (r1 == 0) goto L57
            if (r5 != 0) goto L57
            goto L59
        L48:
            long r2 = r6.asLong()
            long r5 = r5.f2004g
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 > 0) goto L59
            if (r1 == 0) goto L57
            if (r5 != 0) goto L57
            goto L59
        L57:
            r5 = 0
            goto L5a
        L59:
            r5 = 1
        L5a:
            return r5
        L5b:
            boolean r0 = r6.isBigInteger()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L7f
            java.math.BigInteger r6 = r6.bigIntegerValue()
            java.math.BigInteger r0 = new java.math.BigInteger
            java.lang.Object r5 = r5.f2005h
            com.fasterxml.jackson.databind.JsonNode r5 = (com.fasterxml.jackson.databind.JsonNode) r5
            java.lang.String r5 = r5.asText()
            r0.<init>(r5)
            int r5 = r6.compareTo(r0)
            if (r5 > 0) goto Lae
            if (r5 != 0) goto L7d
            goto Lae
        L7d:
            r1 = r2
            goto Lae
        L7f:
            boolean r0 = r6.isTextual()
            if (r0 == 0) goto La0
            java.math.BigDecimal r0 = new java.math.BigDecimal
            java.lang.Object r5 = r5.f2003f
            java.lang.String r5 = (java.lang.String) r5
            r0.<init>(r5)
            java.math.BigDecimal r5 = new java.math.BigDecimal
            java.lang.String r6 = r6.asText()
            r5.<init>(r6)
            int r5 = r5.compareTo(r0)
            if (r5 > 0) goto Lae
            if (r5 != 0) goto L7d
            goto Lae
        La0:
            long r3 = r6.asLong()
            long r5 = r5.f2004g
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 < 0) goto Lae
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 != 0) goto L7d
        Lae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.p.o(com.fasterxml.jackson.databind.JsonNode):boolean");
    }
}
