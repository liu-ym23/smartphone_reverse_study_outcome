package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.ConfigString;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* loaded from: classes4.dex */
public final class G {

    public static class a implements Comparator<D> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(D d10, D d11) {
            return d11.e() - d10.e();
        }
    }

    public static String a(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return null;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static <K, V> AbstractC3897c b(b8.k kVar, Set<Map.Entry<K, V>> set) {
        return d(kVar, g(set), true);
    }

    public static AbstractC3897c c(b8.k kVar, Map<?, ?> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (!(key instanceof String)) {
                throw new ConfigException.BugOrBroken("Map has a non-string as a key, expecting a path expression as a String");
            }
            map2.put(D.g((String) key), entry.getValue());
        }
        return d(kVar, map2, false);
    }

    public static AbstractC3897c d(b8.k kVar, Map<D, Object> map, boolean z10) {
        HashSet hashSet = new HashSet();
        HashSet<D> hashSet2 = new HashSet();
        for (D d10 : map.keySet()) {
            hashSet2.add(d10);
            for (D dH = d10.h(); dH != null; dH = dH.h()) {
                hashSet.add(dH);
            }
        }
        if (z10) {
            hashSet2.removeAll(hashSet);
        } else {
            for (D d11 : hashSet2) {
                if (hashSet.contains(d11)) {
                    throw new ConfigException.BugOrBroken("In the map, path '" + d11.k() + "' occurs as both the parent object of a value and as a value. Because Map has no defined ordering, this is a broken situation.");
                }
            }
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            map3.put((D) it.next(), new HashMap());
        }
        for (D d12 : hashSet2) {
            D dH2 = d12.h();
            Map map4 = dH2 != null ? (Map) map3.get(dH2) : map2;
            String strD = d12.d();
            Object obj = map.get(d12);
            b8.p quoted = z10 ? obj instanceof String ? new ConfigString.Quoted(kVar, (String) obj) : null : C3903i.n(map.get(d12), kVar, FromMapMode.KEYS_ARE_PATHS);
            if (quoted != null) {
                map4.put(strD, quoted);
            }
        }
        ArrayList<D> arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        Collections.sort(arrayList, new a());
        for (D d13 : arrayList) {
            Map map5 = (Map) map3.get(d13);
            D dH3 = d13.h();
            (dH3 != null ? (Map) map3.get(dH3) : map2).put(d13.d(), new SimpleConfigObject(kVar, map5, ResolveStatus.RESOLVED, false));
        }
        return new SimpleConfigObject(kVar, map2, ResolveStatus.RESOLVED, false);
    }

    public static AbstractC3897c e(b8.k kVar, Properties properties) {
        return b(kVar, properties.entrySet());
    }

    public static AbstractC3897c f(b8.k kVar, Map<String, String> map) {
        return b(kVar, map.entrySet());
    }

    public static <K, V> Map<D, Object> g(Set<Map.Entry<K, V>> set) {
        HashMap map = new HashMap();
        for (Map.Entry<K, V> entry : set) {
            K key = entry.getKey();
            if (key instanceof String) {
                map.put(j((String) key), entry.getValue());
            }
        }
        return map;
    }

    public static String h(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf < 0 ? str : str.substring(iLastIndexOf + 1);
    }

    public static AbstractC3897c i(Reader reader, b8.k kVar) throws IOException {
        Properties properties = new Properties();
        properties.load(reader);
        return e(kVar, properties);
    }

    public static D j(String str) {
        String strH = h(str);
        String strA = a(str);
        D d10 = new D(strH, null);
        while (strA != null) {
            String strH2 = h(strA);
            strA = a(strA);
            d10 = new D(strH2, d10);
        }
        return d10;
    }
}
