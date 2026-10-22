package sd;

import java.io.RandomAccessFile;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s extends j {

    /* renamed from: d, reason: collision with root package name */
    public final RandomAccessFile f11977d;

    public s(RandomAccessFile randomAccessFile) {
        this.f11977d = randomAccessFile;
    }

    @Override // sd.j
    public final synchronized void a() {
        this.f11977d.close();
    }

    @Override // sd.j
    public final synchronized int o(long j10, byte[] array, int i10, int i11) {
        kotlin.jvm.internal.g.f(array, "array");
        this.f11977d.seek(j10);
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            int i13 = this.f11977d.read(array, i10, i11 - i12);
            if (i13 != -1) {
                i12 += i13;
            } else if (i12 == 0) {
                return -1;
            }
        }
        return i12;
    }

    @Override // sd.j
    public final synchronized long w() {
        return this.f11977d.length();
    }
}
