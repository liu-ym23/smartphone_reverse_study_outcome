package com.typesafe.config.impl;

import com.autonavi.aps.amapapi.config.Const;
import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.SerializedConfigValue;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class M implements b8.k {

    /* renamed from: a, reason: collision with root package name */
    public final String f31768a;

    /* renamed from: b, reason: collision with root package name */
    public final int f31769b;

    /* renamed from: c, reason: collision with root package name */
    public final int f31770c;

    /* renamed from: d, reason: collision with root package name */
    public final OriginType f31771d;

    /* renamed from: e, reason: collision with root package name */
    public final String f31772e;

    /* renamed from: f, reason: collision with root package name */
    public final String f31773f;

    /* renamed from: g, reason: collision with root package name */
    public final List<String> f31774g;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31775a;

        static {
            int[] iArr = new int[SerializedConfigValue.SerializedField.values().length];
            f31775a = iArr;
            try {
                iArr[SerializedConfigValue.SerializedField.ORIGIN_DESCRIPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ORIGIN_LINE_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ORIGIN_END_LINE_NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ORIGIN_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ORIGIN_URL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ORIGIN_RESOURCE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ORIGIN_COMMENTS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ORIGIN_NULL_URL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ORIGIN_NULL_RESOURCE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ORIGIN_NULL_COMMENTS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.END_MARKER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ROOT_VALUE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.ROOT_WAS_CONFIG.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.UNKNOWN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.VALUE_DATA.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f31775a[SerializedConfigValue.SerializedField.VALUE_ORIGIN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public M(String str, int i10, int i11, OriginType originType, String str2, String str3, List<String> list) {
        if (str == null) {
            throw new ConfigException.BugOrBroken("description may not be null");
        }
        this.f31768a = str;
        this.f31769b = i10;
        this.f31770c = i11;
        this.f31771d = originType;
        this.f31772e = str2;
        this.f31773f = str3;
        this.f31774g = list;
    }

    public static Map<SerializedConfigValue.SerializedField, Object> d(Map<SerializedConfigValue.SerializedField, Object> map, Map<SerializedConfigValue.SerializedField, Object> map2) throws IOException {
        EnumMap enumMap = new EnumMap(map2);
        Iterator<Map.Entry<SerializedConfigValue.SerializedField, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            SerializedConfigValue.SerializedField key = it.next().getKey();
            if (!map2.containsKey(key)) {
                switch (a.f31775a[key.ordinal()]) {
                    case 1:
                        enumMap.put((EnumMap) key, (SerializedConfigValue.SerializedField) map.get(key));
                        break;
                    case 2:
                    case 3:
                    case 4:
                        enumMap.put((EnumMap) key, (SerializedConfigValue.SerializedField) map.get(key));
                        break;
                    case 5:
                        SerializedConfigValue.SerializedField serializedField = SerializedConfigValue.SerializedField.ORIGIN_NULL_URL;
                        if (!map2.containsKey(serializedField)) {
                            enumMap.put((EnumMap) key, (SerializedConfigValue.SerializedField) map.get(key));
                            break;
                        } else {
                            enumMap.remove(serializedField);
                            break;
                        }
                    case 6:
                        SerializedConfigValue.SerializedField serializedField2 = SerializedConfigValue.SerializedField.ORIGIN_NULL_RESOURCE;
                        if (!map2.containsKey(serializedField2)) {
                            enumMap.put((EnumMap) key, (SerializedConfigValue.SerializedField) map.get(key));
                            break;
                        } else {
                            enumMap.remove(serializedField2);
                            break;
                        }
                    case 7:
                        SerializedConfigValue.SerializedField serializedField3 = SerializedConfigValue.SerializedField.ORIGIN_NULL_COMMENTS;
                        if (!map2.containsKey(serializedField3)) {
                            enumMap.put((EnumMap) key, (SerializedConfigValue.SerializedField) map.get(key));
                            break;
                        } else {
                            enumMap.remove(serializedField3);
                            break;
                        }
                    case 8:
                    case 9:
                    case 10:
                        throw new ConfigException.BugOrBroken("applying fields, base object should not contain " + key + " " + map);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        throw new ConfigException.BugOrBroken("should not appear here: " + key);
                }
            }
        }
        return enumMap;
    }

    public static Map<SerializedConfigValue.SerializedField, Object> f(Map<SerializedConfigValue.SerializedField, Object> map, Map<SerializedConfigValue.SerializedField, Object> map2) {
        EnumMap enumMap = new EnumMap(map2);
        for (Map.Entry<SerializedConfigValue.SerializedField, Object> entry : map.entrySet()) {
            SerializedConfigValue.SerializedField key = entry.getKey();
            if (enumMap.containsKey(key) && C3904j.b(entry.getValue(), enumMap.get(key))) {
                enumMap.remove(key);
            } else if (enumMap.containsKey(key)) {
                continue;
            } else {
                switch (a.f31775a[key.ordinal()]) {
                    case 1:
                        throw new ConfigException.BugOrBroken("origin missing description field? " + map2);
                    case 2:
                        enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_LINE_NUMBER, (SerializedConfigValue.SerializedField) (-1));
                        break;
                    case 3:
                        enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_END_LINE_NUMBER, (SerializedConfigValue.SerializedField) (-1));
                        break;
                    case 4:
                        throw new ConfigException.BugOrBroken("should always be an ORIGIN_TYPE field");
                    case 5:
                        enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_NULL_URL, (SerializedConfigValue.SerializedField) "");
                        break;
                    case 6:
                        enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_NULL_RESOURCE, (SerializedConfigValue.SerializedField) "");
                        break;
                    case 7:
                        enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_NULL_COMMENTS, (SerializedConfigValue.SerializedField) "");
                        break;
                    case 8:
                    case 9:
                    case 10:
                        throw new ConfigException.BugOrBroken("computing delta, base object should not contain " + key + " " + map);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        throw new ConfigException.BugOrBroken("should not appear here: " + key);
                }
            }
        }
        return enumMap;
    }

    public static M g(M m10, Map<SerializedConfigValue.SerializedField, Object> map) throws IOException {
        return h(d(m10 != null ? m10.w() : Collections.EMPTY_MAP, map));
    }

    public static M h(Map<SerializedConfigValue.SerializedField, Object> map) throws IOException {
        if (map.isEmpty()) {
            return null;
        }
        String str = (String) map.get(SerializedConfigValue.SerializedField.ORIGIN_DESCRIPTION);
        Integer num = (Integer) map.get(SerializedConfigValue.SerializedField.ORIGIN_LINE_NUMBER);
        Integer num2 = (Integer) map.get(SerializedConfigValue.SerializedField.ORIGIN_END_LINE_NUMBER);
        Number number = (Number) map.get(SerializedConfigValue.SerializedField.ORIGIN_TYPE);
        if (number == null) {
            throw new IOException("Missing ORIGIN_TYPE field");
        }
        OriginType originType = number.byteValue() < OriginType.values().length ? OriginType.values()[number.byteValue()] : OriginType.GENERIC;
        String str2 = (String) map.get(SerializedConfigValue.SerializedField.ORIGIN_URL);
        String str3 = (String) map.get(SerializedConfigValue.SerializedField.ORIGIN_RESOURCE);
        List list = (List) map.get(SerializedConfigValue.SerializedField.ORIGIN_COMMENTS);
        return new M(str, num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1, originType, str2, (originType == OriginType.RESOURCE && str3 == null) ? str : str3, list);
    }

    public static b8.k i(b8.k kVar, b8.k kVar2) {
        return m((M) kVar, (M) kVar2);
    }

    public static b8.k j(Collection<? extends b8.k> collection) {
        if (collection.isEmpty()) {
            throw new ConfigException.BugOrBroken("can't merge empty list of origins");
        }
        if (collection.size() == 1) {
            return collection.iterator().next();
        }
        if (collection.size() == 2) {
            Iterator<? extends b8.k> it = collection.iterator();
            return m((M) it.next(), (M) it.next());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<? extends b8.k> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add((M) it2.next());
        }
        while (arrayList.size() > 2) {
            M m10 = (M) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            M m11 = (M) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            M m12 = (M) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            arrayList.add(l(m12, m11, m10));
        }
        return j(arrayList);
    }

    public static b8.k k(List<? extends AbstractConfigValue> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<? extends AbstractConfigValue> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().e());
        }
        return j(arrayList);
    }

    public static M l(M m10, M m11, M m12) {
        return v(m10, m11) >= v(m11, m12) ? m(m(m10, m11), m12) : m(m10, m(m11, m12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static M m(M m10, M m11) {
        int i10;
        int iMax;
        List list;
        OriginType originType = m10.f31771d;
        if (originType != m11.f31771d) {
            originType = OriginType.GENERIC;
        }
        OriginType originType2 = originType;
        String strSubstring = m10.f31768a;
        String strSubstring2 = m11.f31768a;
        if (strSubstring.startsWith("merge of ")) {
            strSubstring = strSubstring.substring(9);
        }
        if (strSubstring2.startsWith("merge of ")) {
            strSubstring2 = strSubstring2.substring(9);
        }
        if (strSubstring.equals(strSubstring2)) {
            int iMin = m10.f31769b;
            if (iMin < 0) {
                iMin = m11.f31769b;
            } else {
                int i11 = m11.f31769b;
                if (i11 >= 0) {
                    iMin = Math.min(iMin, i11);
                }
            }
            i10 = iMin;
            iMax = Math.max(m10.f31770c, m11.f31770c);
        } else {
            String strDescription = m10.description();
            String strDescription2 = m11.description();
            if (strDescription.startsWith("merge of ")) {
                strDescription = strDescription.substring(9);
            }
            if (strDescription2.startsWith("merge of ")) {
                strDescription2 = strDescription2.substring(9);
            }
            strSubstring = "merge of " + strDescription + Const.STR_MART_COMMA + strDescription2;
            i10 = -1;
            iMax = -1;
        }
        String str = strSubstring;
        String str2 = C3904j.b(m10.f31772e, m11.f31772e) ? m10.f31772e : null;
        String str3 = C3904j.b(m10.f31773f, m11.f31773f) ? m10.f31773f : null;
        if (C3904j.b(m10.f31774g, m11.f31774g)) {
            list = m10.f31774g;
        } else {
            List arrayList = new ArrayList();
            List<String> list2 = m10.f31774g;
            if (list2 != null) {
                arrayList.addAll(list2);
            }
            List<String> list3 = m11.f31774g;
            if (list3 != null) {
                arrayList.addAll(list3);
            }
            list = arrayList;
        }
        return new M(str, i10, iMax, originType2, str2, str3, list);
    }

    public static M n(String str) {
        return new M(str, -1, -1, OriginType.ENV_VARIABLE, null, null, null);
    }

    public static M o(String str) {
        String externalForm;
        try {
            externalForm = new File(str).toURI().toURL().toExternalForm();
        } catch (MalformedURLException unused) {
            externalForm = null;
        }
        return new M(str, -1, -1, OriginType.FILE, externalForm, null, null);
    }

    public static M p(String str) {
        return q(str, null);
    }

    public static M q(String str, URL url) {
        String str2;
        if (url != null) {
            str2 = str + " @ " + url.toExternalForm();
        } else {
            str2 = str;
        }
        return new M(str2, -1, -1, OriginType.RESOURCE, url != null ? url.toExternalForm() : null, str, null);
    }

    public static M r(String str) {
        return new M(str, -1, -1, OriginType.GENERIC, null, null, null);
    }

    public static M s(URL url) {
        String externalForm = url.toExternalForm();
        return new M(externalForm, -1, -1, OriginType.URL, externalForm, null, null);
    }

    public static int v(M m10, M m11) {
        int i10 = m10.f31771d == m11.f31771d ? 1 : 0;
        if (!m10.f31768a.equals(m11.f31768a)) {
            return i10;
        }
        int i11 = i10 + 1;
        if (m10.f31769b == m11.f31769b) {
            i11 = i10 + 2;
        }
        if (m10.f31770c == m11.f31770c) {
            i11++;
        }
        if (C3904j.b(m10.f31772e, m11.f31772e)) {
            i11++;
        }
        return C3904j.b(m10.f31773f, m11.f31773f) ? i11 + 1 : i11;
    }

    @Override // b8.k
    public int a() {
        return this.f31769b;
    }

    public M c(List<String> list) {
        if (C3904j.b(list, this.f31774g) || list == null) {
            return this;
        }
        if (this.f31774g == null) {
            return y(list);
        }
        ArrayList arrayList = new ArrayList(list.size() + this.f31774g.size());
        arrayList.addAll(this.f31774g);
        arrayList.addAll(list);
        return y(arrayList);
    }

    @Override // b8.k
    public String description() {
        int i10 = this.f31769b;
        if (i10 < 0) {
            return this.f31768a;
        }
        if (this.f31770c == i10) {
            return this.f31768a + ": " + this.f31769b;
        }
        return this.f31768a + ": " + this.f31769b + O6.l.DATE_SEPARATOR + this.f31770c;
    }

    public List<String> e() {
        List<String> list = this.f31774g;
        return list != null ? Collections.unmodifiableList(list) : Collections.EMPTY_LIST;
    }

    public boolean equals(Object obj) {
        if (obj instanceof M) {
            M m10 = (M) obj;
            if (this.f31768a.equals(m10.f31768a) && this.f31769b == m10.f31769b && this.f31770c == m10.f31770c && this.f31771d == m10.f31771d && C3904j.b(this.f31772e, m10.f31772e) && C3904j.b(this.f31773f, m10.f31773f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f31768a.hashCode() + 41) * 41) + this.f31769b) * 41) + this.f31770c) * 41) + this.f31771d.hashCode()) * 41;
        String str = this.f31772e;
        if (str != null) {
            iHashCode = (iHashCode + str.hashCode()) * 41;
        }
        String str2 = this.f31773f;
        return str2 != null ? (iHashCode + str2.hashCode()) * 41 : iHashCode;
    }

    public OriginType t() {
        return this.f31771d;
    }

    public String toString() {
        return "ConfigOrigin(" + this.f31768a + ")";
    }

    public M u(List<String> list) {
        if (C3904j.b(list, this.f31774g) || list == null) {
            return this;
        }
        if (this.f31774g == null) {
            return y(list);
        }
        ArrayList arrayList = new ArrayList(list.size() + this.f31774g.size());
        arrayList.addAll(list);
        arrayList.addAll(this.f31774g);
        return y(arrayList);
    }

    public Map<SerializedConfigValue.SerializedField, Object> w() {
        EnumMap enumMap = new EnumMap(SerializedConfigValue.SerializedField.class);
        enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_DESCRIPTION, (SerializedConfigValue.SerializedField) this.f31768a);
        int i10 = this.f31769b;
        if (i10 >= 0) {
            enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_LINE_NUMBER, (SerializedConfigValue.SerializedField) Integer.valueOf(i10));
        }
        int i11 = this.f31770c;
        if (i11 >= 0) {
            enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_END_LINE_NUMBER, (SerializedConfigValue.SerializedField) Integer.valueOf(i11));
        }
        enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_TYPE, (SerializedConfigValue.SerializedField) Integer.valueOf(this.f31771d.ordinal()));
        String str = this.f31772e;
        if (str != null) {
            enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_URL, (SerializedConfigValue.SerializedField) str);
        }
        String str2 = this.f31773f;
        if (str2 != null) {
            enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_RESOURCE, (SerializedConfigValue.SerializedField) str2);
        }
        List<String> list = this.f31774g;
        if (list != null) {
            enumMap.put((EnumMap) SerializedConfigValue.SerializedField.ORIGIN_COMMENTS, (SerializedConfigValue.SerializedField) list);
        }
        return enumMap;
    }

    public Map<SerializedConfigValue.SerializedField, Object> x(M m10) {
        return f(m10 != null ? m10.w() : Collections.EMPTY_MAP, w());
    }

    public M y(List<String> list) {
        return C3904j.b(list, this.f31774g) ? this : new M(this.f31768a, this.f31769b, this.f31770c, this.f31771d, this.f31772e, this.f31773f, list);
    }

    @Override // b8.k
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public M b(int i10) {
        return (i10 == this.f31769b && i10 == this.f31770c) ? this : new M(this.f31768a, i10, i10, this.f31771d, this.f31772e, this.f31773f, this.f31774g);
    }
}
