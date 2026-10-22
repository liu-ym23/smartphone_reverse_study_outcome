package g0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* renamed from: g0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0570j {

    /* renamed from: a, reason: collision with root package name */
    public final int f12647a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12648b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12649c;

    /* renamed from: d, reason: collision with root package name */
    public final long f12650d;

    public C0570j(long j4, int i4, long j5, int i5) {
        this.f12647a = i4;
        this.f12648b = i5;
        this.f12649c = j4;
        this.f12650d = j5;
    }

    public static C0570j a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            C0570j c0570j = new C0570j(dataInputStream.readLong(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readInt());
            dataInputStream.close();
            return c0570j;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void b(File file) throws IOException {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f12647a);
            dataOutputStream.writeInt(this.f12648b);
            dataOutputStream.writeLong(this.f12649c);
            dataOutputStream.writeLong(this.f12650d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0570j)) {
            return false;
        }
        C0570j c0570j = (C0570j) obj;
        return this.f12648b == c0570j.f12648b && this.f12649c == c0570j.f12649c && this.f12647a == c0570j.f12647a && this.f12650d == c0570j.f12650d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f12648b), Long.valueOf(this.f12649c), Integer.valueOf(this.f12647a), Long.valueOf(this.f12650d));
    }
}
