package com.fasterxml.jackson.annotation;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f3504a;

    @Override // com.fasterxml.jackson.annotation.a
    public final void a(ObjectIdGenerator.IdKey idKey, Object obj) {
        HashMap map = this.f3504a;
        if (map == null) {
            this.f3504a = new HashMap();
        } else {
            Object obj2 = map.get(idKey);
            if (obj2 != null) {
                if (obj2 == obj) {
                    return;
                }
                throw new IllegalStateException("Already had POJO for id (" + idKey.f3498c.getClass().getName() + ") [" + idKey + "]");
            }
        }
        this.f3504a.put(idKey, obj);
    }

    @Override // com.fasterxml.jackson.annotation.a
    public final boolean b(a aVar) {
        return aVar.getClass() == b.class;
    }

    @Override // com.fasterxml.jackson.annotation.a
    public final Object c(ObjectIdGenerator.IdKey idKey) {
        HashMap map = this.f3504a;
        if (map == null) {
            return null;
        }
        return map.get(idKey);
    }

    @Override // com.fasterxml.jackson.annotation.a
    public final b d() {
        return new b();
    }
}
