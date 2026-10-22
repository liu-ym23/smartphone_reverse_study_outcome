package o4;

/* loaded from: classes.dex */
public final class p2 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7509f = 1;

    /* renamed from: g, reason: collision with root package name */
    public int f7510g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f7511h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ t2 f7512i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f7513j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(String str, t2 t2Var, String str2, g7.d dVar) {
        super(2, dVar);
        this.f7511h = str;
        this.f7512i = t2Var;
        this.f7513j = str2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f7509f) {
            case 0:
                return new p2(this.f7512i, this.f7511h, this.f7513j, dVar);
            default:
                return new p2(this.f7511h, this.f7512i, this.f7513j, dVar);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f7509f) {
        }
        return ((p2) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0189, code lost:
    
        if (ia.d0.g(60000, r25) == r11) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x010b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:12:0x0033, B:18:0x0040, B:95:0x018d, B:99:0x01a2, B:101:0x01a9, B:19:0x0045, B:51:0x00ed, B:53:0x00f5, B:56:0x00ff, B:59:0x010b, B:62:0x0115, B:66:0x012b, B:68:0x0139, B:75:0x014a, B:84:0x015f, B:87:0x016c, B:88:0x0171, B:89:0x0172, B:92:0x0180, B:72:0x0141, B:73:0x0144, B:74:0x0147, B:20:0x004a, B:31:0x007e, B:34:0x0087, B:38:0x009d, B:40:0x00af, B:48:0x00c3, B:50:0x00c7, B:42:0x00b4, B:45:0x00bb, B:46:0x00be, B:47:0x00c1, B:23:0x0051, B:26:0x005e, B:28:0x0074), top: B:132:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f5 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:12:0x0033, B:18:0x0040, B:95:0x018d, B:99:0x01a2, B:101:0x01a9, B:19:0x0045, B:51:0x00ed, B:53:0x00f5, B:56:0x00ff, B:59:0x010b, B:62:0x0115, B:66:0x012b, B:68:0x0139, B:75:0x014a, B:84:0x015f, B:87:0x016c, B:88:0x0171, B:89:0x0172, B:92:0x0180, B:72:0x0141, B:73:0x0144, B:74:0x0147, B:20:0x004a, B:31:0x007e, B:34:0x0087, B:38:0x009d, B:40:0x00af, B:48:0x00c3, B:50:0x00c7, B:42:0x00b4, B:45:0x00bb, B:46:0x00be, B:47:0x00c1, B:23:0x0051, B:26:0x005e, B:28:0x0074), top: B:132:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0180 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:12:0x0033, B:18:0x0040, B:95:0x018d, B:99:0x01a2, B:101:0x01a9, B:19:0x0045, B:51:0x00ed, B:53:0x00f5, B:56:0x00ff, B:59:0x010b, B:62:0x0115, B:66:0x012b, B:68:0x0139, B:75:0x014a, B:84:0x015f, B:87:0x016c, B:88:0x0171, B:89:0x0172, B:92:0x0180, B:72:0x0141, B:73:0x0144, B:74:0x0147, B:20:0x004a, B:31:0x007e, B:34:0x0087, B:38:0x009d, B:40:0x00af, B:48:0x00c3, B:50:0x00c7, B:42:0x00b4, B:45:0x00bb, B:46:0x00be, B:47:0x00c1, B:23:0x0051, B:26:0x005e, B:28:0x0074), top: B:132:0x0026 }] */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.p2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(t2 t2Var, String str, String str2, g7.d dVar) {
        super(2, dVar);
        this.f7512i = t2Var;
        this.f7511h = str;
        this.f7513j = str2;
    }
}
