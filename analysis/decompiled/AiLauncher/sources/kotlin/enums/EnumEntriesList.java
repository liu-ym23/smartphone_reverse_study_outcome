package kotlin.enums;

import Z8.AbstractC1156d;
import Z8.r;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import io.ktor.http.ContentDisposition;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00060\u0005j\u0002`\u0006B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001dR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlin/enums/EnumEntriesList;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lh9/a;", "LZ8/d;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "entries", "<init>", "([Ljava/lang/Enum;)V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "LY8/t;", "readObject", "(Ljava/io/ObjectInputStream;)V", "", "index", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Ljava/lang/Enum;", "element", "", "f", "(Ljava/lang/Enum;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Enum;)I", "k", Const.INTENT_KEY_PKGNAME, "[Ljava/lang/Enum;", "c", "()I", ContentDisposition.Parameters.Size, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class EnumEntriesList<T extends Enum<T>> extends AbstractC1156d<T> implements InterfaceC4149a<T>, Serializable {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final T[] entries;

    public EnumEntriesList(T[] entries) {
        p.i(entries, "entries");
        this.entries = entries;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }

    @Override // Z8.AbstractC1154b
    /* renamed from: c */
    public int getSize() {
        return this.entries.length;
    }

    @Override // Z8.AbstractC1154b, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return f((Enum) obj);
        }
        return false;
    }

    public boolean f(T element) {
        p.i(element, "element");
        return ((Enum) r.j0(this.entries, element.ordinal())) == element;
    }

    @Override // Z8.AbstractC1156d, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public T get(int index) {
        AbstractC1156d.INSTANCE.b(index, this.entries.length);
        return this.entries[index];
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return j((Enum) obj);
        }
        return -1;
    }

    public int j(T element) {
        p.i(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) r.j0(this.entries, iOrdinal)) == element) {
            return iOrdinal;
        }
        return -1;
    }

    public int k(T element) {
        p.i(element, "element");
        return j(element);
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return k((Enum) obj);
        }
        return -1;
    }
}
