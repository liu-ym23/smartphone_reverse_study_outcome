package f5;

import d7.n;
import java.io.File;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import k5.g;
import k5.t;
import n7.l;
import q7.k;
import w7.e0;

/* loaded from: classes.dex */
public final class f implements b {

    /* renamed from: a, reason: collision with root package name */
    public final File f3445a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3446b;

    /* renamed from: c, reason: collision with root package name */
    public final t f3447c;

    /* renamed from: d, reason: collision with root package name */
    public final long f3448d;

    /* renamed from: e, reason: collision with root package name */
    public volatile v4.b f3449e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3450f;

    /* renamed from: g, reason: collision with root package name */
    public final e f3451g;

    /* renamed from: h, reason: collision with root package name */
    public final d f3452h;

    /* renamed from: i, reason: collision with root package name */
    public volatile long f3453i;

    public f(int i2, File file, long j2, g gVar, long j4) {
        k.e(gVar, "logger");
        this.f3445a = file;
        this.f3446b = j2;
        this.f3447c = gVar;
        this.f3448d = j4;
        this.f3449e = null;
        this.f3450f = n.f.c(i2, "http://127.0.0.1:");
        this.f3451g = new e(this, i2);
        this.f3452h = new d(0, this);
        file.mkdirs();
    }

    public final void a() {
        while (this.f3453i > this.f3446b) {
            Iterator it = this.f3452h.entrySet().iterator();
            if (!it.hasNext()) {
                return;
            }
            Object next = it.next();
            k.d(next, "next(...)");
            Map.Entry entry = (Map.Entry) next;
            this.f3453i -= ((c) entry.getValue()).f3440b;
            try {
                ((c) entry.getValue()).f3439a.delete();
            } catch (Throwable th) {
                e0.n(th);
            }
            it.remove();
        }
    }

    public final byte[] b(String str) {
        Object objN;
        k.e(str, "sha256");
        File fileD = d(str);
        if (fileD == null) {
            return null;
        }
        try {
            objN = l.L(fileD);
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        return (byte[]) (objN instanceof c7.l ? null : objN);
    }

    public final a c(String str, byte[] bArr) {
        if (bArr.length > this.f3448d) {
            throw new IllegalArgumentException("blob put exceeds maxPutSizeBytes: size=" + bArr.length + " max=" + this.f3448d);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bArr);
        k.d(bArrDigest, "digest(...)");
        String strN0 = n.n0(bArrDigest, "", new c6.d(12), 30);
        File file = new File(this.f3445a, strN0);
        if (file.exists()) {
            synchronized (this.f3452h) {
                this.f3452h.get(strN0);
            }
        } else {
            l.P(file, bArr);
            synchronized (this.f3452h) {
                this.f3452h.put(strN0, new c(file, bArr.length, str));
                this.f3453i += bArr.length;
                a();
            }
        }
        return new a(a1.a.x(this.f3450f, "/blob/", strN0), strN0, bArr.length, str);
    }

    public final File d(String str) {
        c cVar;
        File file;
        synchronized (this.f3452h) {
            cVar = (c) this.f3452h.get(str);
        }
        if (cVar != null && (file = cVar.f3439a) != null) {
            if (!file.exists()) {
                file = null;
            }
            if (file != null) {
                return file;
            }
        }
        if (str.length() == 64) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (('0' <= cCharAt && cCharAt < ':') || ('a' <= cCharAt && cCharAt < 'g')) {
                }
            }
            File file2 = new File(this.f3445a, str);
            if (!file2.exists() || !file2.isFile()) {
                file2 = null;
            }
            if (file2 == null) {
                return null;
            }
            synchronized (this.f3452h) {
                this.f3452h.put(str, new c(file2, (int) file2.length(), "application/octet-stream"));
                this.f3453i += file2.length();
                a();
            }
            return file2;
        }
        return null;
    }
}
