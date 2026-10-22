package org.chromium;

import com.ttnet.org.chromium.net.v;

/* JADX INFO: loaded from: classes4.dex */
public class b extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f23037a;

    public b() {
    }

    public static b c() {
        if (f23037a != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23037a != null) goto L11;
        f23037a = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f23037a;
    }

    @Override // com.ttnet.org.chromium.net.v
    public void a(boolean r37, String r38, String r39, String r40, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, boolean r61, long r62, long r64, String r66, String r67, String r68, int r69, int r70, String r71) {
        c.N().M(r37, r38, r39, r40, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r62, r64, r66, r67, r68, r69, r70, r71);
    }

    @Override // com.ttnet.org.chromium.net.v
    public void b(String r10, String r11) {
        c.N().k0(r10, r11);
    }
}
