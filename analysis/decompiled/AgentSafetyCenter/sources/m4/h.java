package m4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f8228a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8229b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8230c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8231d;

    public h(int i, int i3, long j10, long j11) {
        this.f8228a = i;
        this.f8229b = i3;
        this.f8230c = j10;
        this.f8231d = j11;
    }

    public static h a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            h hVar = new h(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return hVar;
        } finally {
        }
    }

    public final void b(File file) throws IOException {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f8228a);
            dataOutputStream.writeInt(this.f8229b);
            dataOutputStream.writeLong(this.f8230c);
            dataOutputStream.writeLong(this.f8231d);
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
        if (obj != null && (obj instanceof h)) {
            h hVar = (h) obj;
            if (this.f8229b == hVar.f8229b && this.f8230c == hVar.f8230c && this.f8228a == hVar.f8228a && this.f8231d == hVar.f8231d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f8229b), Long.valueOf(this.f8230c), Integer.valueOf(this.f8228a), Long.valueOf(this.f8231d));
    }
}
