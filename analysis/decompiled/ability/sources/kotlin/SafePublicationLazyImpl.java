package kotlin;

import C7.f;
import C7.o;
import androidx.exifinterface.media.ExifInterface;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlin/SafePublicationLazyImpl;", ExifInterface.GPS_DIRECTION_TRUE, "LC7/f;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "LC7/r;", "readObject", "(Ljava/io/ObjectInputStream;)V", "b", "Ljava/lang/Object;", "_value", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class SafePublicationLazyImpl<T> implements f, Serializable {
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "b");

    /* renamed from: a, reason: collision with root package name */
    public volatile S7.a f4889a;

    /* renamed from: b, reason: from kotlin metadata */
    public volatile Object _value;

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getF4884a());
    }

    @Override // C7.f
    /* renamed from: getValue */
    public final Object getF4884a() {
        Object obj = this._value;
        o oVar = o.f314a;
        if (obj != oVar) {
            return obj;
        }
        S7.a aVar = this.f4889a;
        if (aVar != null) {
            Object objInvoke = aVar.invoke();
            if (c.compareAndSet(this, oVar, objInvoke)) {
                this.f4889a = null;
                return objInvoke;
            }
        }
        return this._value;
    }

    @Override // C7.f
    public final boolean isInitialized() {
        return this._value != o.f314a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getF4884a()) : "Lazy value not initialized yet.";
    }
}
