package ea;

import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes5.dex */
public final class f {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T a(GeneratedMessageLite.ExtendableMessage<M> extendableMessage, GeneratedMessageLite.e<M, T> extension) {
        p.i(extendableMessage, "<this>");
        p.i(extension, "extension");
        if (extendableMessage.v(extension)) {
            return (T) extendableMessage.s(extension);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T b(GeneratedMessageLite.ExtendableMessage<M> extendableMessage, GeneratedMessageLite.e<M, List<T>> extension, int i10) {
        p.i(extendableMessage, "<this>");
        p.i(extension, "extension");
        if (i10 < extendableMessage.u(extension)) {
            return (T) extendableMessage.t(extension, i10);
        }
        return null;
    }
}
