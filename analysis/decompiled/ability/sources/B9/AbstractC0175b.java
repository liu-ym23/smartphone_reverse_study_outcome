package B9;

import ca.AbstractC0897f;
import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.SerializationException;
import x9.InterfaceC2123a;

/* renamed from: B9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0175b implements x9.b {
    public InterfaceC2123a a(A9.c cVar, String str) {
        E9.e serializersModule = cVar.getSerializersModule();
        Z7.d baseClass = c();
        E9.d dVar = (E9.d) serializersModule;
        dVar.getClass();
        kotlin.jvm.internal.k.f(baseClass, "baseClass");
        Map map = (Map) dVar.d.get(baseClass);
        x9.b bVar = map != null ? (x9.b) map.get(str) : null;
        if (!(bVar instanceof x9.b)) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        Object obj = dVar.e.get(baseClass);
        S7.k kVar = kotlin.jvm.internal.p.g(1, obj) ? (S7.k) obj : null;
        if (kVar != null) {
            return (InterfaceC2123a) kVar.invoke(str);
        }
        return null;
    }

    public x9.f b(A9.f fVar, Object value) {
        kotlin.jvm.internal.k.f(value, "value");
        E9.e serializersModule = fVar.getSerializersModule();
        Z7.d baseClass = c();
        E9.d dVar = (E9.d) serializersModule;
        dVar.getClass();
        kotlin.jvm.internal.k.f(baseClass, "baseClass");
        if (baseClass.k(value)) {
            Map map = (Map) dVar.b.get(baseClass);
            x9.b bVar = map != null ? (x9.b) map.get(kotlin.jvm.internal.m.f4928a.b(value.getClass())) : null;
            x9.b bVar2 = bVar instanceof x9.f ? bVar : null;
            if (bVar2 != null) {
                return bVar2;
            }
            Object obj = dVar.c.get(baseClass);
            S7.k kVar = kotlin.jvm.internal.p.g(1, obj) ? (S7.k) obj : null;
            if (kVar != null) {
                return (x9.f) kVar.invoke(value);
            }
        }
        return null;
    }

    public abstract Z7.d c();

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        Object objDecodeSerializableElement;
        kotlin.jvm.internal.k.f(decoder, "decoder");
        z9.g descriptor = getDescriptor();
        A9.c cVarBeginStructure = decoder.beginStructure(descriptor);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (cVarBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement = cVarBeginStructure.decodeSerializableElement(getDescriptor(), 1, AbstractC0897f.x(this, cVarBeginStructure, cVarBeginStructure.decodeStringElement(getDescriptor(), 0)), null);
        } else {
            Object objDecodeSerializableElement2 = null;
            while (true) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex != -1) {
                    if (iDecodeElementIndex == 0) {
                        ref$ObjectRef.f4920a = cVarBeginStructure.decodeStringElement(getDescriptor(), iDecodeElementIndex);
                    } else {
                        if (iDecodeElementIndex != 1) {
                            StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                            String str = (String) ref$ObjectRef.f4920a;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb.append(str);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(iDecodeElementIndex);
                            throw new SerializationException(sb.toString());
                        }
                        Object obj = ref$ObjectRef.f4920a;
                        if (obj == null) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                        }
                        ref$ObjectRef.f4920a = obj;
                        objDecodeSerializableElement2 = cVarBeginStructure.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, AbstractC0897f.x(this, cVarBeginStructure, (String) obj), null);
                    }
                } else {
                    if (objDecodeSerializableElement2 == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) ref$ObjectRef.f4920a)).toString());
                    }
                    objDecodeSerializableElement = objDecodeSerializableElement2;
                }
            }
        }
        cVarBeginStructure.endStructure(descriptor);
        return objDecodeSerializableElement;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object value) {
        kotlin.jvm.internal.k.f(value, "value");
        x9.f fVarY = AbstractC0897f.y(this, fVar, value);
        z9.g descriptor = getDescriptor();
        A9.d dVarBeginStructure = fVar.beginStructure(descriptor);
        dVarBeginStructure.encodeStringElement(getDescriptor(), 0, fVarY.getDescriptor().h());
        dVarBeginStructure.encodeSerializableElement(getDescriptor(), 1, fVarY, value);
        dVarBeginStructure.endStructure(descriptor);
    }
}
