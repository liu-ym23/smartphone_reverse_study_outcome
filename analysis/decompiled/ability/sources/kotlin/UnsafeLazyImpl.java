package kotlin;

import C7.f;
import C7.o;
import androidx.exifinterface.media.ExifInterface;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlin/UnsafeLazyImpl;", ExifInterface.GPS_DIRECTION_TRUE, "LC7/f;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "LC7/r;", "readObject", "(Ljava/io/ObjectInputStream;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnsafeLazyImpl<T> implements f, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public S7.a f4892a;
    public Object b;

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getF4884a());
    }

    @Override // C7.f
    /* renamed from: getValue */
    public final Object getF4884a() {
        if (this.b == o.f314a) {
            S7.a aVar = this.f4892a;
            k.c(aVar);
            this.b = aVar.invoke();
            this.f4892a = null;
        }
        return this.b;
    }

    @Override // C7.f
    public final boolean isInitialized() {
        return this.b != o.f314a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getF4884a()) : "Lazy value not initialized yet.";
    }
}
