package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import c0.C0574d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class J {

    /* renamed from: f, reason: collision with root package name */
    public static final a f10812f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Class<? extends Object>[] f10813g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f10814a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, C0574d.c> f10815b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Object> f10816c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, v4.j<Object>> f10817d;

    /* renamed from: e, reason: collision with root package name */
    private final C0574d.c f10818e;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public final J a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new J();
                }
                HashMap map = new HashMap();
                for (String str : bundle2.keySet()) {
                    j4.k.f(str, "key");
                    map.put(str, bundle2.get(str));
                }
                return new J(map);
            }
            ClassLoader classLoader = J.class.getClassLoader();
            j4.k.d(classLoader);
            bundle.setClassLoader(classLoader);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object obj = parcelableArrayList.get(i5);
                j4.k.e(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i5));
            }
            return new J(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : J.f10813g) {
                j4.k.d(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        private a() {
        }
    }

    public J(Map<String, ? extends Object> map) {
        j4.k.g(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f10814a = linkedHashMap;
        this.f10815b = new LinkedHashMap();
        this.f10816c = new LinkedHashMap();
        this.f10817d = new LinkedHashMap();
        this.f10818e = new C0574d.c() { // from class: androidx.lifecycle.I
            @Override // c0.C0574d.c
            public final Bundle a() {
                return J.d(this.f10811a);
            }
        };
        linkedHashMap.putAll(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle d(J j5) {
        j4.k.g(j5, "this$0");
        for (Map.Entry entry : W3.E.i(j5.f10815b).entrySet()) {
            j5.e((String) entry.getKey(), ((C0574d.c) entry.getValue()).a());
        }
        Set<String> setKeySet = j5.f10814a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(j5.f10814a.get(str));
        }
        return androidx.core.os.b.a(V3.r.a("keys", arrayList), V3.r.a("values", arrayList2));
    }

    public final C0574d.c c() {
        return this.f10818e;
    }

    public final <T> void e(String str, T t5) {
        j4.k.g(str, "key");
        if (!f10812f.b(t5)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            j4.k.d(t5);
            sb.append(t5.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj = this.f10816c.get(str);
        B b6 = obj instanceof B ? (B) obj : null;
        if (b6 != null) {
            b6.n(t5);
        } else {
            this.f10814a.put(str, t5);
        }
        v4.j<Object> jVar = this.f10817d.get(str);
        if (jVar == null) {
            return;
        }
        jVar.setValue(t5);
    }

    public J() {
        this.f10814a = new LinkedHashMap();
        this.f10815b = new LinkedHashMap();
        this.f10816c = new LinkedHashMap();
        this.f10817d = new LinkedHashMap();
        this.f10818e = new C0574d.c() { // from class: androidx.lifecycle.I
            @Override // c0.C0574d.c
            public final Bundle a() {
                return J.d(this.f10811a);
            }
        };
    }
}
