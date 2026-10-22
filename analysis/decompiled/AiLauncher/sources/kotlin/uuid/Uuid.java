package kotlin.uuid;

import La.D;
import Y8.o;
import com.autonavi.aps.amapapi.config.Const;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001fB\u0019\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0010\u001a\u00020\u000f2\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0000H\u0097\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR \u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R \u0010\u0006\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010 \u0012\u0004\b&\u0010$\u001a\u0004\b%\u0010\"¨\u0006'"}, d2 = {"Lkotlin/uuid/Uuid;", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "mostSignificantBits", "leastSignificantBits", "<init>", "(JJ)V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "LY8/t;", "readObject", "(Ljava/io/ObjectInputStream;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "other", "", "equals", "(Ljava/lang/Object;)Z", "", Const.INTENT_KEY_PKGNAME, "(Lkotlin/uuid/Uuid;)I", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "J", "e", "()J", "getMostSignificantBits$annotations", "()V", "c", "getLeastSignificantBits$annotations", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Uuid implements Comparable<Uuid>, Serializable {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final Uuid f36211d = new Uuid(0, 0);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long mostSignificantBits;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long leastSignificantBits;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlin/uuid/Uuid$a;", "", "<init>", "()V", "", "mostSignificantBits", "leastSignificantBits", "Lkotlin/uuid/Uuid;", Const.INTENT_KEY_PKGNAME, "(JJ)Lkotlin/uuid/Uuid;", "", "byteArray", Const.INTENT_KEY_APIKEY, "([B)Lkotlin/uuid/Uuid;", "", "uuidString", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Lkotlin/uuid/Uuid;", "e", "()Lkotlin/uuid/Uuid;", "NIL", "Lkotlin/uuid/Uuid;", "c", "", "SIZE_BYTES", "I", "SIZE_BITS", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.uuid.Uuid$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Uuid a(byte[] byteArray) {
            p.i(byteArray, "byteArray");
            if (byteArray.length == 16) {
                return b(a.b(byteArray, 0), a.b(byteArray, 8));
            }
            throw new IllegalArgumentException(("Expected exactly 16 bytes, but was " + b.m(byteArray, 32) + " of size " + byteArray.length).toString());
        }

        public final Uuid b(long mostSignificantBits, long leastSignificantBits) {
            return (mostSignificantBits == 0 && leastSignificantBits == 0) ? c() : new Uuid(mostSignificantBits, leastSignificantBits, null);
        }

        public final Uuid c() {
            return Uuid.f36211d;
        }

        public final Uuid d(String uuidString) {
            p.i(uuidString, "uuidString");
            int length = uuidString.length();
            if (length == 32) {
                return a.e(uuidString);
            }
            if (length == 36) {
                return a.f(uuidString);
            }
            throw new IllegalArgumentException("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"" + b.l(uuidString, 64) + "\" of length " + uuidString.length());
        }

        public final Uuid e() {
            return a.c();
        }

        public Companion() {
        }
    }

    public /* synthetic */ Uuid(long j10, long j11, i iVar) {
        this(j10, j11);
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return a.d(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Uuid other) {
        p.i(other, "other");
        long j10 = this.mostSignificantBits;
        return j10 != other.mostSignificantBits ? Long.compareUnsigned(o.b(j10), o.b(other.mostSignificantBits)) : Long.compareUnsigned(o.b(this.leastSignificantBits), o.b(other.leastSignificantBits));
    }

    /* renamed from: c, reason: from getter */
    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    /* renamed from: e, reason: from getter */
    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) other;
        return this.mostSignificantBits == uuid.mostSignificantBits && this.leastSignificantBits == uuid.leastSignificantBits;
    }

    public int hashCode() {
        return Long.hashCode(this.mostSignificantBits ^ this.leastSignificantBits);
    }

    public final String i() {
        byte[] bArr = new byte[36];
        a.a(this.mostSignificantBits, bArr, 0, 0, 4);
        bArr[8] = 45;
        a.a(this.mostSignificantBits, bArr, 9, 4, 6);
        bArr[13] = 45;
        a.a(this.mostSignificantBits, bArr, 14, 6, 8);
        bArr[18] = 45;
        a.a(this.leastSignificantBits, bArr, 19, 0, 2);
        bArr[23] = 45;
        a.a(this.leastSignificantBits, bArr, 24, 2, 8);
        return D.D(bArr);
    }

    public String toString() {
        return i();
    }

    public Uuid(long j10, long j11) {
        this.mostSignificantBits = j10;
        this.leastSignificantBits = j11;
    }
}
