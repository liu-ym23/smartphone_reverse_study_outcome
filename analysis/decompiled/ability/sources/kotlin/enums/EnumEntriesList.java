package kotlin.enums;

import D7.AbstractC0214f;
import D7.C0211c;
import D7.q;
import androidx.exifinterface.media.ExifInterface;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00060\u0005j\u0002`\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r2\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/enums/EnumEntriesList;", "", ExifInterface.GPS_DIRECTION_TRUE, "LK7/a;", "LD7/f;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "LC7/r;", "readObject", "(Ljava/io/ObjectInputStream;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class EnumEntriesList<T extends Enum<T>> extends AbstractC0214f implements K7.a, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Enum[] f4912a;

    public EnumEntriesList(Enum[] entries) {
        k.f(entries, "entries");
        this.f4912a = entries;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.f4912a);
    }

    @Override // D7.AbstractC0209a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum element = (Enum) obj;
        k.f(element, "element");
        return ((Enum) q.s0(element.ordinal(), this.f4912a)) == element;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final Object get(int i) {
        C0211c c0211c = AbstractC0214f.Companion;
        Enum[] enumArr = this.f4912a;
        int length = enumArr.length;
        c0211c.getClass();
        C0211c.b(i, length);
        return enumArr[i];
    }

    @Override // D7.AbstractC0214f, D7.AbstractC0209a
    public final int getSize() {
        return this.f4912a.length;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        k.f(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) q.s0(iOrdinal, this.f4912a)) == element) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        k.f(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) q.s0(iOrdinal, this.f4912a)) == element) {
            return iOrdinal;
        }
        return -1;
    }
}
