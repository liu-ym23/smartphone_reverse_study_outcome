package q2;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f23500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f23503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f23504e;

    public a(long r10, int r11, int r12, List r13) {
        this.f23500a = r10;
        this.f23501b = r11;
        this.f23502c = r12;
        this.f23504e = r13;
    }

    public static a a(File r10) {
        byte[] r11 = r3.c.e(r10);     // Catch: Throwable -> L7
        if (r11 == null) goto L11;
        a r12 = b(ByteBuffer.wrap(r11));     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        r12.f23503d = r10;     // Catch: Throwable -> L7
    L10:
        return r12;
    L9:
        s3.a.b(n2.a.f22354a, "fromMemory bytes is null");     // Catch: Throwable -> L7
        goto L10
    L11:
        s3.a.b(n2.a.f22354a, "fromFile bytes is null");     // Catch: Throwable -> L7
        return null;
    L7:
        th = move-exception;
        s3.a.c(n2.a.f22354a, "fromFile", th);
        return null;
    }

    public static a b(ByteBuffer r10) {
    L14:
        return null;
    L4:
        if (r10.getShort() == 2082) goto L6;
        return null;
    L6:
        long r11 = r10.getLong();     // Catch: Throwable -> L14
        int r12 = r10.getInt();     // Catch: Throwable -> L14
        int r13 = r10.getInt();     // Catch: Throwable -> L14
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L14
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r15 >= r12) goto L12;
        int r17 = r10.getInt();     // Catch: Throwable -> L14
        r16 = r16 + r17;     // Catch: Throwable -> L14
        if (r16 > r13) goto L10;
        byte[] r18 = new byte[r17];     // Catch: Throwable -> L14
        r10.get(r18);     // Catch: Throwable -> L14
        r14.add(new b(r18));     // Catch: Throwable -> L14
        r15 = r15 + 1;     // Catch: Throwable -> L14
        goto L7
    L10:
        return null;
    L12:
        return new a(r11, r12, r13, r14);
    }

    public List c() {
        return this.f23504e;
    }

    public File d() {
        return this.f23503d;
    }

    public long e() {
        return this.f23500a;
    }

    public int f() {
        return this.f23502c;
    }

    public int g() {
        return this.f23501b;
    }

    public String toString() {
        return "LogFile{startID=" + this.f23500a + ", totalCount=" + this.f23501b + ", totalBytes=" + this.f23502c + ", source=" + this.f23503d + ", logList=" + this.f23504e + '}';
    }
}
