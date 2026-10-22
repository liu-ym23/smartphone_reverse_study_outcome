package e8;

import javax.naming.directory.DirContext;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends b {

    /* renamed from: f, reason: collision with root package name */
    public static final z7.b f2401f;

    static {
        z7.b bVarB = z7.d.b(f.class);
        f2401f = bVarB;
        bVarB.l(DirContext.class.getName(), "JNDI class: {}");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    @Override // e8.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r5 = this;
            r5.g()
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            java.lang.String r1 = "java.naming.factory.initial"
            java.lang.String r2 = "com.sun.jndi.dns.DnsContextFactory"
            r0.put(r1, r2)
            java.lang.String r1 = "dns://"
            java.lang.String r2 = "java.naming.provider.url"
            r0.put(r2, r1)
            r1 = 0
            javax.naming.directory.InitialDirContext r3 = new javax.naming.directory.InitialDirContext     // Catch: javax.naming.NamingException -> L2b
            r3.<init>(r0)     // Catch: javax.naming.NamingException -> L2b
            java.util.Hashtable r0 = r3.getEnvironment()     // Catch: javax.naming.NamingException -> L2b
            java.lang.Object r0 = r0.get(r2)     // Catch: javax.naming.NamingException -> L2b
            java.lang.String r0 = (java.lang.String) r0     // Catch: javax.naming.NamingException -> L2b
            r3.close()     // Catch: javax.naming.NamingException -> L2a
            goto L2c
        L2a:
            r1 = r0
        L2b:
            r0 = r1
        L2c:
            if (r0 == 0) goto L6c
            java.util.StringTokenizer r1 = new java.util.StringTokenizer
            java.lang.String r2 = " "
            r1.<init>(r0, r2)
        L35:
            boolean r0 = r1.hasMoreTokens()
            if (r0 == 0) goto L6c
            java.lang.String r0 = r1.nextToken()
            java.net.URI r2 = new java.net.URI     // Catch: java.net.URISyntaxException -> L63
            r2.<init>(r0)     // Catch: java.net.URISyntaxException -> L63
            java.lang.String r3 = r2.getHost()     // Catch: java.net.URISyntaxException -> L63
            if (r3 == 0) goto L35
            boolean r4 = r3.isEmpty()     // Catch: java.net.URISyntaxException -> L63
            if (r4 == 0) goto L51
            goto L35
        L51:
            int r2 = r2.getPort()     // Catch: java.net.URISyntaxException -> L63
            r4 = -1
            if (r2 != r4) goto L5a
            r2 = 53
        L5a:
            java.net.InetSocketAddress r4 = new java.net.InetSocketAddress     // Catch: java.net.URISyntaxException -> L63
            r4.<init>(r3, r2)     // Catch: java.net.URISyntaxException -> L63
            r5.d(r4)     // Catch: java.net.URISyntaxException -> L63
            goto L35
        L63:
            r2 = move-exception
            z7.b r3 = e8.f.f2401f
            java.lang.String r4 = "Could not parse {} as a dns server, ignoring"
            r3.c(r4, r0, r2)
            goto L35
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e8.f.a():void");
    }
}
