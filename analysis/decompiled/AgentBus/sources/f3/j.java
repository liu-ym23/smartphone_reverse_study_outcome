package f3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f3392a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3393b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3394c;

    /* renamed from: d, reason: collision with root package name */
    public final long f3395d;

    public j(int i2, int i10, long j2, long j4) {
        this.f3392a = i2;
        this.f3393b = i10;
        this.f3394c = j2;
        this.f3395d = j4;
    }

    public static j a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            j jVar = new j(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return jVar;
        } finally {
        }
    }

    public final void b(File file) throws IOException {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f3392a);
            dataOutputStream.writeInt(this.f3393b);
            dataOutputStream.writeLong(this.f3394c);
            dataOutputStream.writeLong(this.f3395d);
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
        if (obj != null && (obj instanceof j)) {
            j jVar = (j) obj;
            if (this.f3393b == jVar.f3393b && this.f3394c == jVar.f3394c && this.f3392a == jVar.f3392a && this.f3395d == jVar.f3395d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f3393b), Long.valueOf(this.f3394c), Integer.valueOf(this.f3392a), Long.valueOf(this.f3395d));
    }
}
