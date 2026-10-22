package kotlin.jvm.internal;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(ec.d dVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((b) dVar).a(), str, str2, !(dVar instanceof ec.c) ? 1 : 0);
    }

    public Object get(Object obj) {
        mo140getGetter();
        throw null;
    }

    public PropertyReference1Impl(Class cls, String str, String str2, int i10) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    public PropertyReference1Impl(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
