package C8;

import C8.f;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class g implements f {

    /* renamed from: a, reason: collision with root package name */
    public final String f1743a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1744b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, String> f1745c;

    /* renamed from: d, reason: collision with root package name */
    public int f1746d = -1;

    public static class a extends g implements f.a {

        /* renamed from: e, reason: collision with root package name */
        public final a f1747e;

        /* renamed from: f, reason: collision with root package name */
        public List<a> f1748f;

        public a(String str, int i10, Map<String, String> map, a aVar) {
            super(str, i10, map);
            this.f1747e = aVar;
        }

        public static a g(String str, int i10, Map<String, String> map, a aVar) {
            return new a(str, i10, map, aVar);
        }

        public static a h() {
            return new a("", 0, Collections.EMPTY_MAP, null);
        }

        @Override // C8.f
        public f.a a() {
            return this;
        }

        @Override // C8.f.a
        public List<f.a> b() {
            List<a> list = this.f1748f;
            return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
        }

        @Override // C8.f
        public boolean c() {
            return true;
        }

        @Override // C8.g, C8.f
        public Map<String, String> d() {
            return this.f1745c;
        }

        @Override // C8.f.a
        public f.a e() {
            return this.f1747e;
        }

        public void f(int i10) {
            if (isClosed()) {
                return;
            }
            this.f1746d = i10;
            List<a> list = this.f1748f;
            if (list != null) {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    it.next().f(i10);
                }
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BlockImpl{name='");
            sb2.append(this.f1743a);
            sb2.append('\'');
            sb2.append(", start=");
            sb2.append(this.f1744b);
            sb2.append(", end=");
            sb2.append(this.f1746d);
            sb2.append(", attributes=");
            sb2.append(this.f1745c);
            sb2.append(", parent=");
            a aVar = this.f1747e;
            sb2.append(aVar != null ? aVar.f1743a : null);
            sb2.append(", children=");
            sb2.append(this.f1748f);
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static class b extends g implements f.b {
        public b(String str, int i10, Map<String, String> map) {
            super(str, i10, map);
        }

        @Override // C8.f
        public f.a a() {
            throw new ClassCastException("Cannot cast Inline instance to Block");
        }

        @Override // C8.f
        public boolean c() {
            return false;
        }

        public void f(int i10) {
            if (isClosed()) {
                return;
            }
            this.f1746d = i10;
        }

        public String toString() {
            return "InlineImpl{name='" + this.f1743a + "', start=" + this.f1744b + ", end=" + this.f1746d + ", attributes=" + this.f1745c + '}';
        }
    }

    public g(String str, int i10, Map<String, String> map) {
        this.f1743a = str;
        this.f1744b = i10;
        this.f1745c = map;
    }

    @Override // C8.f
    public Map<String, String> d() {
        return this.f1745c;
    }

    @Override // C8.f
    public int end() {
        return this.f1746d;
    }

    @Override // C8.f
    public boolean isClosed() {
        return this.f1746d > -1;
    }

    @Override // C8.f
    public boolean isEmpty() {
        return this.f1744b == this.f1746d;
    }

    @Override // C8.f
    public String name() {
        return this.f1743a;
    }

    @Override // C8.f
    public int start() {
        return this.f1744b;
    }
}
