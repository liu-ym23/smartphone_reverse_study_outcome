package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class RootNameLookup implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final transient LRUMap<ClassKey, PropertyName> f4514a = new LRUMap<>(20, 200);

    public final PropertyName a(Class cls, MapperConfigBase mapperConfigBase) {
        ClassKey classKey = new ClassKey(cls);
        LRUMap<ClassKey, PropertyName> lRUMap = this.f4514a;
        PropertyName propertyName = lRUMap.f4509b.get(classKey);
        if (propertyName != null) {
            return propertyName;
        }
        PropertyName propertyNameO = mapperConfigBase.d().O(mapperConfigBase.j(cls).f9499e);
        if (propertyNameO == null || propertyNameO.f3755a.isEmpty()) {
            propertyNameO = PropertyName.a(cls.getSimpleName());
        }
        lRUMap.a(classKey, propertyNameO);
        return propertyNameO;
    }

    public Object readResolve() {
        return new RootNameLookup();
    }
}
