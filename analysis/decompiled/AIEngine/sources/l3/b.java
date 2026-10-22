package l3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends d {
    @Override // l3.d, l3.a, k3.e
    public final k3.e a(BeanProperty beanProperty) {
        return this.f10219b == beanProperty ? this : new b(this.f10218a, beanProperty, this.f10200c);
    }

    @Override // l3.d, l3.a, k3.e
    public final JsonTypeInfo.As c() {
        return JsonTypeInfo.As.f3485e;
    }

    @Override // l3.d, l3.a
    /* renamed from: g */
    public final a a(BeanProperty beanProperty) {
        return this.f10219b == beanProperty ? this : new b(this.f10218a, beanProperty, this.f10200c);
    }

    @Override // l3.d
    /* renamed from: h */
    public final d a(BeanProperty beanProperty) {
        return this.f10219b == beanProperty ? this : new b(this.f10218a, beanProperty, this.f10200c);
    }
}
