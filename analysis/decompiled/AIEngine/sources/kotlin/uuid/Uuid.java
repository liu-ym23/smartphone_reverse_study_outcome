package kotlin.uuid;

import androidx.datastore.preferences.protobuf.b1;
import gc.a;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Uuid implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Uuid f10106c = new Uuid(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f10107a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10108b;

    public Uuid(long j10, long j11) {
        this.f10107a = j10;
        this.f10108b = j11;
    }

    private final Object writeReplace() {
        return new UuidSerialized(this.f10107a, this.f10108b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) obj;
        return this.f10107a == uuid.f10107a && this.f10108b == uuid.f10108b;
    }

    public final int hashCode() {
        long j10 = this.f10107a ^ this.f10108b;
        return ((int) (j10 >> 32)) ^ ((int) j10);
    }

    public final String toString() {
        byte[] bArr = new byte[36];
        long j10 = this.f10108b;
        b1.d(j10, bArr, 24, 6);
        bArr[23] = 45;
        b1.d(j10 >>> 48, bArr, 19, 2);
        bArr[18] = 45;
        long j11 = this.f10107a;
        b1.d(j11, bArr, 14, 2);
        bArr[13] = 45;
        b1.d(j11 >>> 16, bArr, 9, 2);
        bArr[8] = 45;
        b1.d(j11 >>> 32, bArr, 0, 4);
        return new String(bArr, a.f9106b);
    }
}
