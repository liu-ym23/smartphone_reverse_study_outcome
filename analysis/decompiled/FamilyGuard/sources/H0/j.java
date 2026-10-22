package H0;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, List<i>> f1984c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f1985d;

    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        private static final String f1986d;

        /* renamed from: e, reason: collision with root package name */
        private static final Map<String, List<i>> f1987e;

        /* renamed from: a, reason: collision with root package name */
        private boolean f1988a = true;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, List<i>> f1989b = f1987e;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1990c = true;

        static {
            String strB = b();
            f1986d = strB;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strB)) {
                map.put("User-Agent", Collections.singletonList(new b(strB)));
            }
            f1987e = Collections.unmodifiableMap(map);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i5 = 0; i5 < length; i5++) {
                char cCharAt = property.charAt(i5);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public j a() {
            this.f1988a = true;
            return new j(this.f1989b);
        }
    }

    static final class b implements i {

        /* renamed from: a, reason: collision with root package name */
        private final String f1991a;

        b(String str) {
            this.f1991a = str;
        }

        @Override // H0.i
        public String a() {
            return this.f1991a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f1991a.equals(((b) obj).f1991a);
            }
            return false;
        }

        public int hashCode() {
            return this.f1991a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f1991a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f1984c = Collections.unmodifiableMap(map);
    }

    private String b(List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            String strA = list.get(i5).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i5 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> c() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f1984c.entrySet()) {
            String strB = b(entry.getValue());
            if (!TextUtils.isEmpty(strB)) {
                map.put(entry.getKey(), strB);
            }
        }
        return map;
    }

    @Override // H0.h
    public Map<String, String> a() {
        if (this.f1985d == null) {
            synchronized (this) {
                try {
                    if (this.f1985d == null) {
                        this.f1985d = Collections.unmodifiableMap(c());
                    }
                } finally {
                }
            }
        }
        return this.f1985d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f1984c.equals(((j) obj).f1984c);
        }
        return false;
    }

    public int hashCode() {
        return this.f1984c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f1984c + '}';
    }
}
