package kotlin.jvm.internal;

import ec.f;
import ec.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class PropertyReference1 extends PropertyReference implements ec.h {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public ec.b computeReflected() {
        i.f10086a.getClass();
        return this;
    }

    @Override // ec.h
    public Object getDelegate(Object obj) {
        return ((ec.h) getReflected()).getDelegate(obj);
    }

    public /* bridge */ /* synthetic */ f.a getGetter() {
        mo140getGetter();
        return null;
    }

    @Override // zb.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // ec.h
    /* renamed from: getGetter, reason: collision with other method in class */
    public h.a mo140getGetter() {
        ((ec.h) getReflected()).mo140getGetter();
        return null;
    }

    public PropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
