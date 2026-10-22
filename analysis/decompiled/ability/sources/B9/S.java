package B9;

import com.uxsense.parse.IdSource;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.EmptyList;
import kotlinx.serialization.SerializationException;

/* loaded from: classes4.dex */
public final class S implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f229a;
    public final List b;
    public final Object c;

    public S(String str, Object objectInstance) {
        kotlin.jvm.internal.k.f(objectInstance, "objectInstance");
        this.f229a = objectInstance;
        this.b = EmptyList.f4893a;
        this.c = kotlin.a.b(LazyThreadSafetyMode.b, new A6.i(2, str, this));
    }

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        int iDecodeElementIndex;
        kotlin.jvm.internal.k.f(decoder, "decoder");
        z9.g descriptor = getDescriptor();
        A9.c cVarBeginStructure = decoder.beginStructure(descriptor);
        if (!cVarBeginStructure.decodeSequentially() && (iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor())) != -1) {
            throw new SerializationException(B7.a.h(iDecodeElementIndex, "Unexpected index "));
        }
        cVarBeginStructure.endStructure(descriptor);
        return this.f229a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return (z9.g) this.c.getF4884a();
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object value) {
        kotlin.jvm.internal.k.f(value, "value");
        fVar.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public S(String str, IdSource objectInstance, Annotation[] annotationArr) {
        this(str, objectInstance);
        kotlin.jvm.internal.k.f(objectInstance, "objectInstance");
        this.b = D7.q.L(annotationArr);
    }
}
