package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class JDKValueInstantiators {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class ArrayListInstantiator extends ValueInstantiator.Base implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public static final ArrayListInstantiator f3914b = new ArrayListInstantiator();

        public ArrayListInstantiator() {
            super((Class<?>) ArrayList.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean j() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean l() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final Object v(DeserializationContext deserializationContext) {
            return new ArrayList();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class ConstantValueInstantiator extends ValueInstantiator.Base implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public final Object f3915b;

        public ConstantValueInstantiator(Object obj) {
            super(obj.getClass());
            this.f3915b = obj;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean j() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean l() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final Object v(DeserializationContext deserializationContext) {
            return this.f3915b;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class HashMapInstantiator extends ValueInstantiator.Base implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public static final HashMapInstantiator f3916b = new HashMapInstantiator();

        public HashMapInstantiator() {
            super((Class<?>) HashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean j() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean l() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final Object v(DeserializationContext deserializationContext) {
            return new HashMap();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class LinkedHashMapInstantiator extends ValueInstantiator.Base implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public static final LinkedHashMapInstantiator f3917b = new LinkedHashMapInstantiator();

        public LinkedHashMapInstantiator() {
            super((Class<?>) LinkedHashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean j() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final boolean l() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final Object v(DeserializationContext deserializationContext) {
            return new LinkedHashMap();
        }
    }

    public static ValueInstantiator.Base a(Class cls) {
        if (cls == JsonLocation.class) {
            return new JsonLocationInstantiator();
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (cls == ArrayList.class) {
                return ArrayListInstantiator.f3914b;
            }
            Set set = Collections.EMPTY_SET;
            if (set.getClass() == cls) {
                return new ConstantValueInstantiator(set);
            }
            List list = Collections.EMPTY_LIST;
            if (list.getClass() == cls) {
                return new ConstantValueInstantiator(list);
            }
            return null;
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (cls == LinkedHashMap.class) {
            return LinkedHashMapInstantiator.f3917b;
        }
        if (cls == HashMap.class) {
            return HashMapInstantiator.f3916b;
        }
        Map map = Collections.EMPTY_MAP;
        if (map.getClass() == cls) {
            return new ConstantValueInstantiator(map);
        }
        return null;
    }
}
