package kotlin.jvm.internal;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class PropertyReference0 extends PropertyReference implements ec.g {
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public ec.b computeReflected() {
        i.f10086a.getClass();
        return this;
    }

    @Override // zb.a
    public Object invoke() {
        return get();
    }
}
