package com.alibaba.fastjson;

import G1.a;
import H1.b;
import I1.l;
import L1.d;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class JSONObject extends a implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f15915f;

    public JSONObject() {
        this(16, false);
    }

    public Map<String, Object> P() {
        return this.f15915f;
    }

    public int Q(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return d.n(obj).intValue();
    }

    public Integer R(String str) {
        return d.n(get(str));
    }

    public long S(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0L;
        }
        return d.p(obj).longValue();
    }

    public String T(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // java.util.Map
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        return this.f15915f.put(str, obj);
    }

    @Override // java.util.Map
    public void clear() {
        this.f15915f.clear();
    }

    public Object clone() {
        return new JSONObject(new LinkedHashMap(this.f15915f));
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f15915f.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f15915f.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.f15915f.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.f15915f.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.f15915f.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f15915f.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        Class<?> cls = Void.TYPE;
        String strName = null;
        if (length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() != cls) {
                throw new JSONException("illegal setter");
            }
            b bVar = (b) method.getAnnotation(b.class);
            String strName2 = (bVar == null || bVar.name().length() == 0) ? null : bVar.name();
            if (strName2 == null) {
                String name = method.getName();
                if (!name.startsWith("set")) {
                    throw new JSONException("illegal setter");
                }
                String strSubstring = name.substring(3);
                if (strSubstring.length() == 0) {
                    throw new JSONException("illegal setter");
                }
                strName2 = Character.toLowerCase(strSubstring.charAt(0)) + strSubstring.substring(1);
            }
            this.f15915f.put(strName2, objArr[0]);
            return null;
        }
        if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        }
        if (method.getReturnType() == cls) {
            throw new JSONException("illegal getter");
        }
        b bVar2 = (b) method.getAnnotation(b.class);
        if (bVar2 != null && bVar2.name().length() != 0) {
            strName = bVar2.name();
        }
        if (strName == null) {
            String name2 = method.getName();
            if (name2.startsWith("get")) {
                String strSubstring2 = name2.substring(3);
                if (strSubstring2.length() == 0) {
                    throw new JSONException("illegal getter");
                }
                strName = Character.toLowerCase(strSubstring2.charAt(0)) + strSubstring2.substring(1);
            } else {
                if (!name2.startsWith("is")) {
                    if (name2.startsWith("hashCode")) {
                        return Integer.valueOf(hashCode());
                    }
                    if (name2.startsWith("toString")) {
                        return toString();
                    }
                    throw new JSONException("illegal getter");
                }
                String strSubstring3 = name2.substring(2);
                if (strSubstring3.length() == 0) {
                    throw new JSONException("illegal getter");
                }
                strName = Character.toLowerCase(strSubstring3.charAt(0)) + strSubstring3.substring(1);
            }
        }
        return d.c(this.f15915f.get(strName), method.getGenericReturnType(), l.f3331e);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f15915f.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f15915f.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.f15915f.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.f15915f.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.f15915f.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.f15915f.values();
    }

    public JSONObject(Map<String, Object> map) {
        this.f15915f = map;
    }

    public JSONObject(boolean z10) {
        this(16, z10);
    }

    public JSONObject(int i10) {
        this(i10, false);
    }

    public JSONObject(int i10, boolean z10) {
        if (z10) {
            this.f15915f = new LinkedHashMap(i10);
        } else {
            this.f15915f = new HashMap(i10);
        }
    }
}
