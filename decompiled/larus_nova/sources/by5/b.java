package by5;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f21402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f21403d;

    public final String toString() {
        return "LogFile{totalCount=" + this.f21400a + ", totalBytes=" + this.f21401b + ", source=" + this.f21402c + ", logList=" + this.f21403d + '}';
    }

    public static b a(ByteBuffer r110) {
    L15:
        th = move-exception;
        fy5.c.c("construct LogFile failed.", th);
        return null;
    L4:
        if (r110.getInt() == 1095781686) goto L6;
        return null;
    L6:
        r110.getInt();     // Catch: Throwable -> L15
        int r100 = r110.getInt();     // Catch: Throwable -> L15
        int r101 = r110.getInt();     // Catch: Throwable -> L15
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L15
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r100) goto L14;
        int r105 = r110.getInt();     // Catch: Throwable -> L15
        r104 = r104 + r105;     // Catch: Throwable -> L15
        if (r104 > r101) goto L10;
        long r111 = r110.getLong();     // Catch: Throwable -> L15
        long r112 = r110.getLong();     // Catch: Throwable -> L15
        byte[] r106 = new byte[r105];     // Catch: Throwable -> L15
        r110.get(r106);     // Catch: Throwable -> L15
        r102.add(new c(r106, r111, r112));     // Catch: Throwable -> L15
        r103 = r103 + 1;     // Catch: Throwable -> L15
        goto L7
    L10:
        fy5.c.b("APM-SDK", "construct LogFile failed.");     // Catch: Throwable -> L15
        return null;
    L14:
        return new b(r100, r101, r102);
    }

    public b(int r100, int r101, List<c> r102) {
        this.f21400a = r100;
        this.f21401b = r101;
        this.f21403d = r102;
    }
}
