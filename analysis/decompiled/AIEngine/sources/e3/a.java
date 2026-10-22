package e3;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final DeserializationConfig f8597a;

    /* renamed from: b, reason: collision with root package name */
    public final DeserializationContext f8598b;

    /* renamed from: c, reason: collision with root package name */
    public final i3.d f8599c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f8600d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f8601e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, SettableBeanProperty> f8602f;

    /* renamed from: g, reason: collision with root package name */
    public HashSet<String> f8603g;
    public HashSet<String> h;

    /* renamed from: i, reason: collision with root package name */
    public ValueInstantiator f8604i;

    /* renamed from: j, reason: collision with root package name */
    public ObjectIdReader f8605j;

    /* renamed from: k, reason: collision with root package name */
    public SettableAnyProperty f8606k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8607l;

    /* renamed from: m, reason: collision with root package name */
    public AnnotatedMethod f8608m;

    public a(i3.d dVar, DeserializationContext deserializationContext) {
        this.f8599c = dVar;
        this.f8598b = deserializationContext;
        this.f8597a = deserializationContext.f3663c;
    }

    public final Map<String, List<PropertyName>> a(Collection<SettableBeanProperty> collection) {
        AnnotationIntrospector annotationIntrospectorD = this.f8597a.d();
        HashMap map = null;
        if (annotationIntrospectorD != null) {
            for (SettableBeanProperty settableBeanProperty : collection) {
                List<PropertyName> listD = annotationIntrospectorD.D(settableBeanProperty.d());
                if (listD != null && !listD.isEmpty()) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(settableBeanProperty.f3891c.f3755a, listD);
                }
            }
        }
        return map == null ? Collections.EMPTY_MAP : map;
    }

    public final void b(Collection<SettableBeanProperty> collection) {
        DeserializationConfig deserializationConfig = this.f8597a;
        deserializationConfig.getClass();
        if (deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            Iterator<SettableBeanProperty> it = collection.iterator();
            while (it.hasNext()) {
                it.next().l(deserializationConfig);
            }
        }
        SettableAnyProperty settableAnyProperty = this.f8606k;
        if (settableAnyProperty != null) {
            settableAnyProperty.f3882b.g(deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        AnnotatedMethod annotatedMethod = this.f8608m;
        if (annotatedMethod != null) {
            annotatedMethod.g(deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
    }

    public final void c(String str) {
        if (this.f8603g == null) {
            this.f8603g = new HashSet<>();
        }
        this.f8603g.add(str);
    }

    public final void d(SettableBeanProperty settableBeanProperty) {
        PropertyName propertyName = settableBeanProperty.f3891c;
        SettableBeanProperty settableBeanProperty2 = (SettableBeanProperty) this.f8600d.put(propertyName.f3755a, settableBeanProperty);
        if (settableBeanProperty2 == null || settableBeanProperty2 == settableBeanProperty) {
            return;
        }
        throw new IllegalArgumentException("Duplicate property '" + propertyName.f3755a + "' for " + this.f8599c.f3041a);
    }

    public final BeanDeserializer e() {
        boolean z;
        Collection<SettableBeanProperty> collectionValues = this.f8600d.values();
        b(collectionValues);
        Map<String, List<PropertyName>> mapA = a(collectionValues);
        Boolean boolB = this.f8599c.a().b(JsonFormat.Feature.f3435b);
        DeserializationConfig deserializationConfig = this.f8597a;
        BeanPropertyMap beanPropertyMap = new BeanPropertyMap(boolB == null ? deserializationConfig.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES) : boolB.booleanValue(), collectionValues, mapA, deserializationConfig.f3828b.f3794j);
        int length = beanPropertyMap.f3906e.length;
        int i10 = 0;
        for (int i11 = 1; i11 < length; i11 += 2) {
            SettableBeanProperty settableBeanProperty = (SettableBeanProperty) beanPropertyMap.f3906e[i11];
            if (settableBeanProperty != null) {
                settableBeanProperty.g(i10);
                i10++;
            }
        }
        boolean zK = deserializationConfig.k(MapperFeature.DEFAULT_VIEW_INCLUSION);
        boolean z3 = !zK;
        if (zK) {
            Iterator<SettableBeanProperty> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (it.next().v()) {
                    z = true;
                    break;
                }
            }
            z = z3;
        } else {
            z = z3;
        }
        if (this.f8605j != null) {
            beanPropertyMap = beanPropertyMap.g(new ObjectIdValueProperty(this.f8605j, PropertyMetadata.f3742k));
        }
        return new BeanDeserializer(this, this.f8599c, beanPropertyMap, this.f8602f, this.f8603g, this.f8607l, this.h, z);
    }
}
