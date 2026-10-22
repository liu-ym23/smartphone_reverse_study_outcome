package l0;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import m0.InterfaceC0854b;
import o0.C0896i;
import u0.o;

/* loaded from: classes.dex */
public class e extends AbstractC0822a implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Object> f18029k;

    public e() {
        this(16, false);
    }

    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public e clone() {
        return new e((Map<String, Object>) (this.f18029k instanceof LinkedHashMap ? new LinkedHashMap(this.f18029k) : new HashMap(this.f18029k)));
    }

    public e M(String str, Object obj) {
        this.f18029k.put(str, obj);
        return this;
    }

    public Map<String, Object> N() {
        return this.f18029k;
    }

    public Integer O(String str) {
        return o.t(get(str));
    }

    public Long P(String str) {
        return o.v(get(str));
    }

    public long Q(String str) {
        Long lV = o.v(get(str));
        if (lV == null) {
            return 0L;
        }
        return lV.longValue();
    }

    public String R(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // java.util.Map
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        return this.f18029k.put(str, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T T(Class<T> cls, C0896i c0896i, int i5) {
        return (cls != Map.class && (cls != Object.class || containsKey(AbstractC0822a.f18018c))) ? (T) o.u(this, cls, c0896i) : this;
    }

    @Override // java.util.Map
    public void clear() {
        this.f18029k.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        boolean zContainsKey = this.f18029k.containsKey(obj);
        return (zContainsKey || !((obj instanceof Number) || (obj instanceof Character) || (obj instanceof Boolean) || (obj instanceof UUID))) ? zContainsKey : this.f18029k.containsKey(obj.toString());
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f18029k.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.f18029k.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof e ? this.f18029k.equals(((e) obj).f18029k) : this.f18029k.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        Object obj2 = this.f18029k.get(obj);
        return (obj2 == null && ((obj instanceof Number) || (obj instanceof Character) || (obj instanceof Boolean) || (obj instanceof UUID))) ? this.f18029k.get(obj.toString()) : obj2;
    }

    @Override // java.util.Map
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f18029k.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        Class<?> cls = Void.TYPE;
        String strName = null;
        if (length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() != cls) {
                throw new d("illegal setter");
            }
            InterfaceC0854b interfaceC0854b = (InterfaceC0854b) o.O(method, InterfaceC0854b.class);
            String strName2 = (interfaceC0854b == null || interfaceC0854b.name().length() == 0) ? null : interfaceC0854b.name();
            if (strName2 == null) {
                String name = method.getName();
                if (!name.startsWith("set")) {
                    throw new d("illegal setter");
                }
                String strSubstring = name.substring(3);
                if (strSubstring.length() == 0) {
                    throw new d("illegal setter");
                }
                strName2 = Character.toLowerCase(strSubstring.charAt(0)) + strSubstring.substring(1);
            }
            this.f18029k.put(strName2, objArr[0]);
            return null;
        }
        if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        }
        if (method.getReturnType() == cls) {
            throw new d("illegal getter");
        }
        InterfaceC0854b interfaceC0854b2 = (InterfaceC0854b) o.O(method, InterfaceC0854b.class);
        if (interfaceC0854b2 != null && interfaceC0854b2.name().length() != 0) {
            strName = interfaceC0854b2.name();
        }
        if (strName == null) {
            String name2 = method.getName();
            if (name2.startsWith("get")) {
                String strSubstring2 = name2.substring(3);
                if (strSubstring2.length() == 0) {
                    throw new d("illegal getter");
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
                    throw new d("illegal getter");
                }
                String strSubstring3 = name2.substring(2);
                if (strSubstring3.length() == 0) {
                    throw new d("illegal getter");
                }
                strName = Character.toLowerCase(strSubstring3.charAt(0)) + strSubstring3.substring(1);
            }
        }
        return o.h(this.f18029k.get(strName), method.getGenericReturnType(), C0896i.s());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f18029k.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f18029k.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.f18029k.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.f18029k.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.f18029k.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.f18029k.values();
    }

    public e(Map<String, Object> map) {
        if (map == null) {
            throw new IllegalArgumentException("map is null.");
        }
        this.f18029k = map;
    }

    public e(boolean z5) {
        this(16, z5);
    }

    public e(int i5) {
        this(i5, false);
    }

    public e(int i5, boolean z5) {
        if (z5) {
            this.f18029k = new LinkedHashMap(i5);
        } else {
            this.f18029k = new HashMap(i5);
        }
    }
}
