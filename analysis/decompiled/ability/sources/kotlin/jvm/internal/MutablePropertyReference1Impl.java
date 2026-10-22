package kotlin.jvm.internal;

import b8.AbstractC0857s;
import java.util.Objects;

/* loaded from: classes3.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    /* JADX WARN: Illegal instructions before constructor call */
    public MutablePropertyReference1Impl(Z7.d dVar, String str, String str2) {
        Object obj = CallableReference.NO_RECEIVER;
        super(!Objects.nonNull(dVar) ? 1 : 0, ((c) dVar).b(), obj, str, str2);
    }

    public Object get(Object obj) {
        return ((AbstractC0857s) getGetter()).call(obj);
    }

    public MutablePropertyReference1Impl(Class cls, String str, String str2, int i) {
        super(i, cls, CallableReference.NO_RECEIVER, str, str2);
    }
}
