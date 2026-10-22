package l3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends l {

    /* renamed from: c, reason: collision with root package name */
    public final String f10199c;

    public c(k3.c cVar, BeanProperty beanProperty, String str) {
        super(cVar, beanProperty);
        this.f10199c = str;
    }

    @Override // k3.e
    public final k3.e a(BeanProperty beanProperty) {
        return this.f10219b == beanProperty ? this : new c(this.f10218a, beanProperty, this.f10199c);
    }

    @Override // l3.l, k3.e
    public final String b() {
        return this.f10199c;
    }

    @Override // k3.e
    public final JsonTypeInfo.As c() {
        return JsonTypeInfo.As.f3484d;
    }
}
