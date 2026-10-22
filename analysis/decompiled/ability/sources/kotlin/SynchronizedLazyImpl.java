package kotlin;

import C7.f;
import C7.o;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/SynchronizedLazyImpl;", ExifInterface.GPS_DIRECTION_TRUE, "LC7/f;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class SynchronizedLazyImpl<T> implements f, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public S7.a f4890a;
    public volatile Object b;
    public final Object c;

    public SynchronizedLazyImpl(S7.a initializer) {
        k.f(initializer, "initializer");
        this.f4890a = initializer;
        this.b = o.f314a;
        this.c = this;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getF4884a());
    }

    @Override // C7.f
    /* renamed from: getValue */
    public final Object getF4884a() {
        Object objInvoke;
        Object obj = this.b;
        o oVar = o.f314a;
        if (obj != oVar) {
            return obj;
        }
        synchronized (this.c) {
            objInvoke = this.b;
            if (objInvoke == oVar) {
                S7.a aVar = this.f4890a;
                k.c(aVar);
                objInvoke = aVar.invoke();
                this.b = objInvoke;
                this.f4890a = null;
            }
        }
        return objInvoke;
    }

    @Override // C7.f
    public final boolean isInitialized() {
        return this.b != o.f314a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getF4884a()) : "Lazy value not initialized yet.";
    }
}
