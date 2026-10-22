package D8;

import H8.l;
import H8.x;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes4.dex */
public abstract class h {
    public static final Object a(GeneratedMessageLite.ExtendableMessage extendableMessage, l extension) {
        kotlin.jvm.internal.k.f(extendableMessage, "<this>");
        kotlin.jvm.internal.k.f(extension, "extension");
        if (extendableMessage.j(extension)) {
            return extendableMessage.i(extension);
        }
        return null;
    }

    public static final Object b(GeneratedMessageLite.ExtendableMessage extendableMessage, l extension, int i) {
        kotlin.jvm.internal.k.f(extendableMessage, "<this>");
        kotlin.jvm.internal.k.f(extension, "extension");
        extendableMessage.m(extension);
        H8.i iVar = extendableMessage.f5099a;
        H8.k kVar = extension.d;
        iVar.getClass();
        x xVar = iVar.f773a;
        if (!kVar.c) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj = xVar.get(kVar);
        if (i >= (obj == null ? 0 : ((List) obj).size())) {
            return null;
        }
        extendableMessage.m(extension);
        if (!kVar.c) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj2 = xVar.get(kVar);
        if (obj2 != null) {
            return extension.a(((List) obj2).get(i));
        }
        throw new IndexOutOfBoundsException();
    }
}
