package kotlin.uuid;

import M0.i;
import j9.AbstractC1607a;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/uuid/Uuid;", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "LC7/r;", "readObject", "(Ljava/io/ObjectInputStream;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Uuid implements Comparable<Uuid>, Serializable {
    public static final Uuid c = new Uuid(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f5172a;
    public final long b;

    public Uuid(long j5, long j6) {
        this.f5172a = j5;
        this.b = j6;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        UuidSerialized uuidSerialized = new UuidSerialized();
        uuidSerialized.f5173a = this.f5172a;
        uuidSerialized.b = this.b;
        return uuidSerialized;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Uuid uuid) {
        Uuid other = uuid;
        k.f(other, "other");
        long j5 = other.f5172a;
        long j6 = this.f5172a;
        return j6 != j5 ? Long.compareUnsigned(j6, j5) : Long.compareUnsigned(this.b, other.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) obj;
        return this.f5172a == uuid.f5172a && this.b == uuid.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f5172a ^ this.b);
    }

    public final String toString() {
        byte[] bArr = new byte[36];
        i.t(this.f5172a, bArr, 0, 0, 4);
        bArr[8] = 45;
        i.t(this.f5172a, bArr, 9, 4, 6);
        bArr[13] = 45;
        i.t(this.f5172a, bArr, 14, 6, 8);
        bArr[18] = 45;
        i.t(this.b, bArr, 19, 0, 2);
        bArr[23] = 45;
        i.t(this.b, bArr, 24, 2, 8);
        return new String(bArr, AbstractC1607a.f4778a);
    }
}
