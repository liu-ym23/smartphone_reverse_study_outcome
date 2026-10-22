package kotlin.jvm.internal;

import b8.AbstractC0857s;

/* loaded from: classes3.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    /* JADX WARN: Illegal instructions before constructor call */
    public PropertyReference1Impl(Z7.f fVar, String str, String str2) {
        Object obj = CallableReference.NO_RECEIVER;
        super(!(fVar instanceof Z7.d) ? 1 : 0, ((c) fVar).b(), obj, str, str2);
    }

    public Object get(Object obj) {
        return ((AbstractC0857s) getGetter()).call(obj);
    }

    public PropertyReference1Impl(Class cls, String str, String str2, int i) {
        super(i, cls, CallableReference.NO_RECEIVER, str, str2);
    }
}
