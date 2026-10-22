package l3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a extends l {
    @Override // k3.e
    public JsonTypeInfo.As c() {
        return JsonTypeInfo.As.f3483c;
    }

    @Override // k3.e
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a a(BeanProperty beanProperty) {
        return this.f10219b == beanProperty ? this : new a(this.f10218a, beanProperty);
    }
}
