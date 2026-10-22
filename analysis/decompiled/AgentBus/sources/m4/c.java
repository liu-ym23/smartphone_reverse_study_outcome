package m4;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6161f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f6162g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f6163h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f6164i;

    public /* synthetic */ c(String str, String str2, boolean z4) {
        this.f6163h = str;
        this.f6164i = str2;
        this.f6162g = z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5  */
    @Override // p7.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(java.lang.Object r5) throws org.json.JSONException {
        /*
            r4 = this;
            int r0 = r4.f6161f
            switch(r0) {
                case 0: goto L66;
                default: goto L5;
            }
        L5:
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r0 = "cfg"
            q7.k.e(r5, r0)
            java.lang.String r0 = "skills"
            java.lang.Object r1 = r5.get(r0)
            boolean r2 = q7.z.f(r1)
            r3 = 0
            if (r2 == 0) goto L1c
            java.util.Map r1 = (java.util.Map) r1
            goto L1d
        L1c:
            r1 = r3
        L1d:
            if (r1 != 0) goto L27
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            r5.put(r0, r1)
        L27:
            java.lang.String r5 = "entries"
            java.lang.Object r0 = r1.get(r5)
            boolean r2 = q7.z.f(r0)
            if (r2 == 0) goto L36
            r3 = r0
            java.util.Map r3 = (java.util.Map) r3
        L36:
            if (r3 != 0) goto L40
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            r1.put(r5, r3)
        L40:
            boolean r5 = r4.f6162g
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            c7.j r0 = new c7.j
            java.lang.String r1 = "enabled"
            r0.<init>(r1, r5)
            c7.j[] r5 = new c7.j[]{r0}
            java.util.LinkedHashMap r5 = d7.e0.R(r5)
            java.lang.String r0 = r4.f6163h
            if (r0 == 0) goto L5e
            java.lang.String r1 = "version"
            r5.put(r1, r0)
        L5e:
            java.lang.String r4 = r4.f6164i
            r3.put(r4, r5)
            c7.r r4 = c7.r.f1986a
            return r4
        L66:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            java.lang.String r0 = "cfg"
            q7.k.e(r5, r0)
            java.lang.String r0 = "channels"
            org.json.JSONObject r5 = r5.optJSONObject(r0)
            if (r5 != 0) goto L76
            goto La8
        L76:
            java.lang.String r0 = r4.f6163h
            org.json.JSONObject r5 = r5.optJSONObject(r0)
            if (r5 != 0) goto L7f
            goto La8
        L7f:
            java.lang.String r0 = "accounts"
            org.json.JSONObject r0 = r5.optJSONObject(r0)
            boolean r1 = r4.f6162g
            java.lang.String r2 = "enabled"
            if (r0 == 0) goto La5
            java.lang.String r4 = r4.f6164i
            boolean r3 = r0.has(r4)
            if (r3 == 0) goto La5
            org.json.JSONObject r5 = r0.optJSONObject(r4)
            if (r5 != 0) goto La1
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            r0.put(r4, r5)
        La1:
            r5.put(r2, r1)
            goto La8
        La5:
            r5.put(r2, r1)
        La8:
            c7.r r4 = c7.r.f1986a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.c.invoke(java.lang.Object):java.lang.Object");
    }

    public /* synthetic */ c(boolean z4, String str, String str2) {
        this.f6162g = z4;
        this.f6163h = str;
        this.f6164i = str2;
    }
}
