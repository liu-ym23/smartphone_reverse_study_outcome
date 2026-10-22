package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BeanPropertyMap implements Iterable<SettableBeanProperty>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3902a;

    /* renamed from: b, reason: collision with root package name */
    public int f3903b;

    /* renamed from: c, reason: collision with root package name */
    public int f3904c;

    /* renamed from: d, reason: collision with root package name */
    public int f3905d;

    /* renamed from: e, reason: collision with root package name */
    public Object[] f3906e;
    public final SettableBeanProperty[] h;

    /* renamed from: j, reason: collision with root package name */
    public final Map<String, List<PropertyName>> f3907j;

    /* renamed from: k, reason: collision with root package name */
    public final Map<String, String> f3908k;

    /* renamed from: l, reason: collision with root package name */
    public final Locale f3909l;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.HashMap] */
    public BeanPropertyMap(boolean z, Collection<SettableBeanProperty> collection, Map<String, List<PropertyName>> map, Locale locale) {
        ?? map2;
        this.f3902a = z;
        this.h = (SettableBeanProperty[]) collection.toArray(new SettableBeanProperty[collection.size()]);
        this.f3907j = map;
        this.f3909l = locale;
        if (map == null || map.isEmpty()) {
            map2 = Collections.EMPTY_MAP;
        } else {
            map2 = new HashMap();
            for (Map.Entry<String, List<PropertyName>> entry : map.entrySet()) {
                String key = entry.getKey();
                key = z ? key.toLowerCase(locale) : key;
                Iterator<PropertyName> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    String lowerCase = it.next().f3755a;
                    if (z) {
                        lowerCase = lowerCase.toLowerCase(locale);
                    }
                    map2.put(lowerCase, key);
                }
            }
        }
        this.f3908k = map2;
        e(collection);
    }

    public final int a(SettableBeanProperty settableBeanProperty) {
        SettableBeanProperty[] settableBeanPropertyArr = this.h;
        int length = settableBeanPropertyArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (settableBeanPropertyArr[i10] == settableBeanProperty) {
                return i10;
            }
        }
        throw new IllegalStateException(ai.onnxruntime.a.o(new StringBuilder("Illegal state: property '"), settableBeanProperty.f3891c.f3755a, "' missing from _propsInOrder"));
    }

    public final SettableBeanProperty b(String str) {
        if (str == null) {
            return null;
        }
        int iHashCode = str.hashCode() & this.f3903b;
        int i10 = iHashCode << 1;
        Object obj = this.f3906e[i10];
        if (str.equals(obj)) {
            return (SettableBeanProperty) this.f3906e[i10 + 1];
        }
        if (obj == null) {
            return null;
        }
        int i11 = this.f3903b + 1;
        int i12 = ((iHashCode >> 1) + i11) << 1;
        Object obj2 = this.f3906e[i12];
        if (str.equals(obj2)) {
            return (SettableBeanProperty) this.f3906e[i12 + 1];
        }
        if (obj2 != null) {
            int i13 = (i11 + (i11 >> 1)) << 1;
            int i14 = this.f3905d + i13;
            while (i13 < i14) {
                Object obj3 = this.f3906e[i13];
                if (obj3 == str || str.equals(obj3)) {
                    return (SettableBeanProperty) this.f3906e[i13 + 1];
                }
                i13 += 2;
            }
        }
        return null;
    }

    public final SettableBeanProperty c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot pass null property name");
        }
        if (this.f3902a) {
            str = str.toLowerCase(this.f3909l);
        }
        int iHashCode = str.hashCode() & this.f3903b;
        int i10 = iHashCode << 1;
        Object obj = this.f3906e[i10];
        if (obj == str || str.equals(obj)) {
            return (SettableBeanProperty) this.f3906e[i10 + 1];
        }
        Map<String, String> map = this.f3908k;
        if (obj == null) {
            return b(map.get(str));
        }
        int i11 = this.f3903b + 1;
        int i12 = ((iHashCode >> 1) + i11) << 1;
        Object obj2 = this.f3906e[i12];
        if (str.equals(obj2)) {
            return (SettableBeanProperty) this.f3906e[i12 + 1];
        }
        if (obj2 != null) {
            int i13 = (i11 + (i11 >> 1)) << 1;
            int i14 = this.f3905d + i13;
            while (i13 < i14) {
                Object obj3 = this.f3906e[i13];
                if (obj3 == str || str.equals(obj3)) {
                    return (SettableBeanProperty) this.f3906e[i13 + 1];
                }
                i13 += 2;
            }
        }
        return b(map.get(str));
    }

    public final String d(SettableBeanProperty settableBeanProperty) {
        return this.f3902a ? settableBeanProperty.f3891c.f3755a.toLowerCase(this.f3909l) : settableBeanProperty.f3891c.f3755a;
    }

    public final void e(Collection<SettableBeanProperty> collection) {
        int i10;
        int size = collection.size();
        this.f3904c = size;
        if (size <= 5) {
            i10 = 8;
        } else if (size <= 12) {
            i10 = 16;
        } else {
            int i11 = 32;
            while (i11 < size + (size >> 2)) {
                i11 += i11;
            }
            i10 = i11;
        }
        this.f3903b = i10 - 1;
        int i12 = (i10 >> 1) + i10;
        Object[] objArrCopyOf = new Object[i12 * 2];
        int i13 = 0;
        for (SettableBeanProperty settableBeanProperty : collection) {
            if (settableBeanProperty != null) {
                String strD = d(settableBeanProperty);
                int iHashCode = strD.hashCode() & this.f3903b;
                int i14 = iHashCode << 1;
                if (objArrCopyOf[i14] != null) {
                    i14 = ((iHashCode >> 1) + i10) << 1;
                    if (objArrCopyOf[i14] != null) {
                        i14 = (i12 << 1) + i13;
                        i13 += 2;
                        if (i14 >= objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, objArrCopyOf.length + 4);
                        }
                    }
                }
                objArrCopyOf[i14] = strD;
                objArrCopyOf[i14 + 1] = settableBeanProperty;
            }
        }
        this.f3906e = objArrCopyOf;
        this.f3905d = i13;
    }

    public final void f(SettableBeanProperty settableBeanProperty) {
        ArrayList arrayList = new ArrayList(this.f3904c);
        String strD = d(settableBeanProperty);
        int length = this.f3906e.length;
        boolean zEquals = false;
        for (int i10 = 1; i10 < length; i10 += 2) {
            Object[] objArr = this.f3906e;
            SettableBeanProperty settableBeanProperty2 = (SettableBeanProperty) objArr[i10];
            if (settableBeanProperty2 != null) {
                if (zEquals || !(zEquals = strD.equals(objArr[i10 - 1]))) {
                    arrayList.add(settableBeanProperty2);
                } else {
                    this.h[a(settableBeanProperty2)] = null;
                }
            }
        }
        if (!zEquals) {
            throw new NoSuchElementException(ai.onnxruntime.a.o(new StringBuilder("No entry '"), settableBeanProperty.f3891c.f3755a, "' found, can't remove"));
        }
        e(arrayList);
    }

    public final BeanPropertyMap g(ObjectIdValueProperty objectIdValueProperty) {
        String strD = d(objectIdValueProperty);
        int length = this.f3906e.length;
        for (int i10 = 1; i10 < length; i10 += 2) {
            SettableBeanProperty settableBeanProperty = (SettableBeanProperty) this.f3906e[i10];
            if (settableBeanProperty != null && settableBeanProperty.f3891c.f3755a.equals(strD)) {
                return new BeanPropertyMap(this, objectIdValueProperty, i10, a(settableBeanProperty));
            }
        }
        return new BeanPropertyMap(this, objectIdValueProperty, strD, strD.hashCode() & this.f3903b);
    }

    @Override // java.lang.Iterable
    public final Iterator<SettableBeanProperty> iterator() {
        ArrayList arrayList = new ArrayList(this.f3904c);
        int length = this.f3906e.length;
        for (int i10 = 1; i10 < length; i10 += 2) {
            SettableBeanProperty settableBeanProperty = (SettableBeanProperty) this.f3906e[i10];
            if (settableBeanProperty != null) {
                arrayList.add(settableBeanProperty);
            }
        }
        return arrayList.iterator();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Properties=[");
        Iterator<SettableBeanProperty> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            SettableBeanProperty next = it.next();
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(next.f3891c.f3755a);
            sb2.append('(');
            sb2.append(next.f3892d);
            sb2.append(')');
            i10 = i11;
        }
        sb2.append(']');
        Map<String, List<PropertyName>> map = this.f3907j;
        if (!map.isEmpty()) {
            sb2.append("(aliases: ");
            sb2.append(map);
            sb2.append(")");
        }
        return sb2.toString();
    }

    public BeanPropertyMap(BeanPropertyMap beanPropertyMap, ObjectIdValueProperty objectIdValueProperty, int i10, int i11) {
        this.f3902a = beanPropertyMap.f3902a;
        this.f3909l = beanPropertyMap.f3909l;
        this.f3903b = beanPropertyMap.f3903b;
        this.f3904c = beanPropertyMap.f3904c;
        this.f3905d = beanPropertyMap.f3905d;
        this.f3907j = beanPropertyMap.f3907j;
        this.f3908k = beanPropertyMap.f3908k;
        Object[] objArr = beanPropertyMap.f3906e;
        this.f3906e = Arrays.copyOf(objArr, objArr.length);
        SettableBeanProperty[] settableBeanPropertyArr = beanPropertyMap.h;
        SettableBeanProperty[] settableBeanPropertyArr2 = (SettableBeanProperty[]) Arrays.copyOf(settableBeanPropertyArr, settableBeanPropertyArr.length);
        this.h = settableBeanPropertyArr2;
        this.f3906e[i10] = objectIdValueProperty;
        settableBeanPropertyArr2[i11] = objectIdValueProperty;
    }

    public BeanPropertyMap(BeanPropertyMap beanPropertyMap, ObjectIdValueProperty objectIdValueProperty, String str, int i10) {
        this.f3902a = beanPropertyMap.f3902a;
        this.f3909l = beanPropertyMap.f3909l;
        this.f3903b = beanPropertyMap.f3903b;
        this.f3904c = beanPropertyMap.f3904c;
        this.f3905d = beanPropertyMap.f3905d;
        this.f3907j = beanPropertyMap.f3907j;
        this.f3908k = beanPropertyMap.f3908k;
        Object[] objArr = beanPropertyMap.f3906e;
        this.f3906e = Arrays.copyOf(objArr, objArr.length);
        SettableBeanProperty[] settableBeanPropertyArr = beanPropertyMap.h;
        int length = settableBeanPropertyArr.length;
        SettableBeanProperty[] settableBeanPropertyArr2 = (SettableBeanProperty[]) Arrays.copyOf(settableBeanPropertyArr, length + 1);
        this.h = settableBeanPropertyArr2;
        settableBeanPropertyArr2[length] = objectIdValueProperty;
        int i11 = this.f3903b + 1;
        int i12 = i10 << 1;
        Object[] objArr2 = this.f3906e;
        if (objArr2[i12] != null) {
            i12 = ((i10 >> 1) + i11) << 1;
            if (objArr2[i12] != null) {
                int i13 = this.f3905d;
                i12 = ((i11 + (i11 >> 1)) << 1) + i13;
                this.f3905d = i13 + 2;
                if (i12 >= objArr2.length) {
                    this.f3906e = Arrays.copyOf(objArr2, objArr2.length + 4);
                }
            }
        }
        Object[] objArr3 = this.f3906e;
        objArr3[i12] = str;
        objArr3[i12 + 1] = objectIdValueProperty;
    }

    public BeanPropertyMap(BeanPropertyMap beanPropertyMap, boolean z) {
        this.f3902a = z;
        this.f3909l = beanPropertyMap.f3909l;
        this.f3907j = beanPropertyMap.f3907j;
        this.f3908k = beanPropertyMap.f3908k;
        SettableBeanProperty[] settableBeanPropertyArr = beanPropertyMap.h;
        SettableBeanProperty[] settableBeanPropertyArr2 = (SettableBeanProperty[]) Arrays.copyOf(settableBeanPropertyArr, settableBeanPropertyArr.length);
        this.h = settableBeanPropertyArr2;
        e(Arrays.asList(settableBeanPropertyArr2));
    }
}
