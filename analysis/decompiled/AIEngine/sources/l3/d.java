package l3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class d extends a {

    /* renamed from: c, reason: collision with root package name */
    public final String f10200c;

    public d(k3.c cVar, BeanProperty beanProperty, String str) {
        super(cVar, beanProperty);
        this.f10200c = str;
    }

    @Override // l3.l, k3.e
    public final String b() {
        return this.f10200c;
    }

    @Override // l3.a, k3.e
    public JsonTypeInfo.As c() {
        return JsonTypeInfo.As.f3481a;
    }

    @Override // l3.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public d a(BeanProperty beanProperty) {
        return this.f10219b == beanProperty ? this : new d(this.f10218a, beanProperty, this.f10200c);
    }
}
