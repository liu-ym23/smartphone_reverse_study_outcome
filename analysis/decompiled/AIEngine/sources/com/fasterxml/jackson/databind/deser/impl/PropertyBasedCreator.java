package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import f3.f;
import f3.g;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PropertyBasedCreator {

    /* renamed from: a, reason: collision with root package name */
    public final int f3937a;

    /* renamed from: b, reason: collision with root package name */
    public final ValueInstantiator f3938b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, SettableBeanProperty> f3939c;

    /* renamed from: d, reason: collision with root package name */
    public final SettableBeanProperty[] f3940d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class CaseInsensitiveMap extends HashMap<String, SettableBeanProperty> {

        /* renamed from: a, reason: collision with root package name */
        public final Locale f3941a;

        public CaseInsensitiveMap(Locale locale) {
            this.f3941a = locale;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            return (SettableBeanProperty) super.get(((String) obj).toLowerCase(this.f3941a));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Object put(Object obj, Object obj2) {
            return (SettableBeanProperty) super.put(((String) obj).toLowerCase(this.f3941a), (SettableBeanProperty) obj2);
        }
    }

    public PropertyBasedCreator(DeserializationContext deserializationContext, ValueInstantiator valueInstantiator, SettableBeanProperty[] settableBeanPropertyArr, boolean z, boolean z3) {
        AnnotatedMember annotatedMemberD;
        DeserializationConfig deserializationConfig = deserializationContext.f3663c;
        this.f3938b = valueInstantiator;
        if (z) {
            this.f3939c = new CaseInsensitiveMap(deserializationConfig.f3828b.f3794j);
        } else {
            this.f3939c = new HashMap<>();
        }
        int length = settableBeanPropertyArr.length;
        this.f3937a = length;
        this.f3940d = new SettableBeanProperty[length];
        if (z3) {
            for (SettableBeanProperty settableBeanProperty : settableBeanPropertyArr) {
                if (!settableBeanProperty.w()) {
                    List<PropertyName> listD = settableBeanProperty.f4150b;
                    if (listD == null) {
                        AnnotationIntrospector annotationIntrospectorD = deserializationConfig.d();
                        if (annotationIntrospectorD != null && (annotatedMemberD = settableBeanProperty.d()) != null) {
                            listD = annotationIntrospectorD.D(annotatedMemberD);
                        }
                        listD = listD == null ? Collections.EMPTY_LIST : listD;
                        settableBeanProperty.f4150b = listD;
                    }
                    if (!listD.isEmpty()) {
                        Iterator<PropertyName> it = listD.iterator();
                        while (it.hasNext()) {
                            this.f3939c.put(it.next().f3755a, settableBeanProperty);
                        }
                    }
                }
            }
        }
        for (int i10 = 0; i10 < length; i10++) {
            SettableBeanProperty settableBeanProperty2 = settableBeanPropertyArr[i10];
            this.f3940d[i10] = settableBeanProperty2;
            if (!settableBeanProperty2.w()) {
                this.f3939c.put(settableBeanProperty2.f3891c.f3755a, settableBeanProperty2);
            }
        }
    }

    public static PropertyBasedCreator b(DeserializationContext deserializationContext, ValueInstantiator valueInstantiator, SettableBeanProperty[] settableBeanPropertyArr, boolean z) {
        int length = settableBeanPropertyArr.length;
        SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[length];
        for (int i10 = 0; i10 < length; i10++) {
            SettableBeanProperty settableBeanPropertyD = settableBeanPropertyArr[i10];
            if (!settableBeanPropertyD.t()) {
                settableBeanPropertyD = settableBeanPropertyD.D(deserializationContext.o(settableBeanPropertyD.f3892d, settableBeanPropertyD));
            }
            settableBeanPropertyArr2[i10] = settableBeanPropertyD;
        }
        return new PropertyBasedCreator(deserializationContext, valueInstantiator, settableBeanPropertyArr2, z, false);
    }

    public final Object a(DeserializationContext deserializationContext, g gVar) throws MismatchedInputException {
        ValueInstantiator valueInstantiator = this.f3938b;
        valueInstantiator.getClass();
        DeserializationContext deserializationContext2 = gVar.f8725b;
        BitSet bitSet = gVar.f8730g;
        Object[] objArr = gVar.f8727d;
        int i10 = gVar.f8728e;
        SettableBeanProperty[] settableBeanPropertyArr = this.f3940d;
        if (i10 > 0) {
            if (bitSet != null) {
                int length = objArr.length;
                int i11 = 0;
                while (true) {
                    int iNextClearBit = bitSet.nextClearBit(i11);
                    if (iNextClearBit >= length) {
                        break;
                    }
                    objArr[iNextClearBit] = gVar.a(settableBeanPropertyArr[iNextClearBit]);
                    i11 = iNextClearBit + 1;
                }
            } else {
                int i12 = gVar.f8729f;
                int length2 = objArr.length;
                int i13 = 0;
                while (i13 < length2) {
                    if ((i12 & 1) == 0) {
                        objArr[i13] = gVar.a(settableBeanPropertyArr[i13]);
                    }
                    i13++;
                    i12 >>= 1;
                }
            }
        }
        if (deserializationContext2.J(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES)) {
            for (int i14 = 0; i14 < settableBeanPropertyArr.length; i14++) {
                if (objArr[i14] == null) {
                    SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i14];
                    deserializationContext2.Q(settableBeanProperty, "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES` enabled", settableBeanProperty.f3891c.f3755a, Integer.valueOf(settableBeanProperty.m()));
                    throw null;
                }
            }
        }
        Object objS = valueInstantiator.s(deserializationContext, objArr);
        if (objS != null) {
            ObjectIdReader objectIdReader = gVar.f8726c;
            if (objectIdReader != null) {
                SettableBeanProperty settableBeanProperty2 = objectIdReader.h;
                Object obj = gVar.f8731i;
                if (obj == null) {
                    deserializationContext.getClass();
                    deserializationContext.Q(settableBeanProperty2, String.format("No Object Id found for an instance of %s, to assign to property '%s'", com.fasterxml.jackson.databind.util.a.f(objS), objectIdReader.f3929b), new Object[0]);
                    throw null;
                }
                deserializationContext.s(obj, objectIdReader.f3930c, objectIdReader.f3931d).b(objS);
                if (settableBeanProperty2 != null) {
                    objS = settableBeanProperty2.A(objS, gVar.f8731i);
                }
            }
            for (f fVar = gVar.h; fVar != null; fVar = fVar.f8718a) {
                fVar.a(objS);
            }
        }
        return objS;
    }

    public final SettableBeanProperty c(String str) {
        return this.f3939c.get(str);
    }

    public final g d(JsonParser jsonParser, DeserializationContext deserializationContext, ObjectIdReader objectIdReader) {
        return new g(jsonParser, deserializationContext, this.f3937a, objectIdReader);
    }
}
