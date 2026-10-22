package i;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f20471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f20472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap f20473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20474d;

    public static class a extends e {
        public a(c r10, c r11) {
            super(r10, r11);
        }

        @Override // i.b.e
        public c b(c r10) {
            return r10.f20478d;
        }

        @Override // i.b.e
        public c c(c r10) {
            return r10.f20477c;
        }
    }

    /* JADX INFO: renamed from: i.b$b, reason: collision with other inner class name */
    public static class C0267b extends e {
        public C0267b(c r10, c r11) {
            super(r10, r11);
        }

        @Override // i.b.e
        public c b(c r10) {
            return r10.f20477c;
        }

        @Override // i.b.e
        public c c(c r10) {
            return r10.f20478d;
        }
    }

    public static class c implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f20475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f20476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f20477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f20478d;

        public c(Object r10, Object r11) {
            this.f20475a = r10;
            this.f20476b = r11;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.f20475a.equals(r11.f20475a) == false) goto L14;
            if (this.f20476b.equals(r11.f20476b) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f20475a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f20476b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int r10 = this.f20475a.hashCode();
            return this.f20476b.hashCode() ^ r10;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f20475a + "=" + this.f20476b;
        }
    }

    public class d extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f20479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f20480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f20481c;

        public d(b r10) {
            this.f20481c = r10;
            this.f20480b = true;
        }

        @Override // i.b.f
        public void a(c r10) {
            c r11 = this.f20479a;
            if (r10 != r11) goto L10;
            c r12 = r11.f20478d;
            this.f20479a = r12;
            if (r12 != null) goto L7;
            boolean r13 = true;
        L8:
            this.f20480b = r13;
            return;
        L7:
            r13 = false;
            goto L8
        }

        public Map.Entry b() {
            if (this.f20480b == false) goto L5;
            this.f20480b = false;
            this.f20479a = this.f20481c.f20471a;
        L11:
            return this.f20479a;
        L5:
            c r10 = this.f20479a;
            if (r10 == null) goto L8;
            c r11 = r10.f20477c;
        L9:
            this.f20479a = r11;
            goto L11
        L8:
            r11 = null;
            goto L9
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20480b == true) goto L5;
            c r10 = this.f20479a;
            if (r10 != null) goto L11;
            return false;
        L11:
            if (r10.f20477c != null) goto L13;
            return false;
        L13:
            return true;
        L5:
            if (this.f20481c.f20471a != null) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return b();
        }
    }

    public static abstract class e extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f20482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f20483b;

        public e(c r10, c r11) {
            this.f20482a = r11;
            this.f20483b = r10;
        }

        @Override // i.b.f
        public void a(c r10) {
            if (this.f20482a == r10) goto L5;
        L7:
            c r11 = this.f20482a;
            if (r11 != r10) goto L11;
            this.f20482a = b(r11);
        L11:
            if (this.f20483b != r10) goto L14;
            this.f20483b = e();
            return;
        L14:
            return;
        L5:
            if (r10 != this.f20483b) goto L7;
            this.f20483b = null;
            this.f20482a = null;
            goto L7
        }

        public abstract c b(c r10);

        public abstract c c(c r10);

        public Map.Entry d() {
            c r10 = this.f20483b;
            this.f20483b = e();
            return r10;
        }

        public final c e() {
            c r10 = this.f20483b;
            c r11 = this.f20482a;
            if (r10 == r11) goto L8;
            if (r11 != null) goto L7;
            return null;
        L7:
            return c(r10);
        L8:
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f20483b == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return d();
        }
    }

    public static abstract class f {
        public f() {
        }

        public abstract void a(c r10);
    }

    public b() {
        this.f20473c = new WeakHashMap();
        this.f20474d = 0;
    }

    public Map.Entry a() {
        return this.f20471a;
    }

    public c b(Object r10) {
        c r11 = this.f20471a;
    L3:
        if (r11 == null) goto L8;
        if (r11.f20475a.equals(r10) == true) goto L8;
        r11 = r11.f20477c;
    L8:
        return r11;
    }

    public d c() {
        d r10 = new d(this);
        this.f20473c.put(r10, Boolean.FALSE);
        return r10;
    }

    public Map.Entry d() {
        return this.f20472b;
    }

    public Iterator descendingIterator() {
        C0267b r10 = new C0267b(this.f20472b, this.f20471a);
        this.f20473c.put(r10, Boolean.FALSE);
        return r10;
    }

    public c e(Object r10, Object r11) {
        c r12 = new c(r10, r11);
        this.f20474d++;
        c r13 = this.f20472b;
        if (r13 != null) goto L6;
        this.f20471a = r12;
        this.f20472b = r12;
        return r12;
    L6:
        r13.f20477c = r12;
        r12.f20478d = r13;
        this.f20472b = r12;
        return r12;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (size() == r11.size()) goto L11;
        return false;
    L11:
        Iterator r12 = iterator();
        Iterator r13 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L24;
        if (r13.hasNext() == false) goto L24;
        Map.Entry r14 = (Map.Entry) r12.next();
        Object r15 = r13.next();
        if (r14 != null) goto L19;
        if (r15 == null) goto L19;
    L22:
        return false;
    L19:
        if (r14 == null) goto L13;
        if (r14.equals(r15) == true) goto L13;
    L24:
        if (r12.hasNext() == true) goto L29;
        if (r13.hasNext() == true) goto L29;
        return true;
    L29:
        return false;
    }

    public Object f(Object r10, Object r11) {
        c r12 = b(r10);
        if (r12 != null) goto L5;
        e(r10, r11);
        return null;
    L5:
        return r12.f20476b;
    }

    public Object g(Object r10) {
        c r11 = b(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        this.f20474d--;
        if (this.f20473c.isEmpty() == true) goto L11;
        Iterator r12 = this.f20473c.keySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        ((f) r12.next()).a(r11);
    L11:
        c r13 = r11.f20478d;
        if (r13 == null) goto L14;
        r13.f20477c = r11.f20477c;
    L15:
        c r14 = r11.f20477c;
        if (r14 == null) goto L18;
        r14.f20478d = r13;
    L19:
        r11.f20477c = null;
        r11.f20478d = null;
        return r11.f20476b;
    L18:
        this.f20472b = r13;
        goto L19
    L14:
        this.f20471a = r11.f20477c;
        goto L15
    }

    public int hashCode() {
        Iterator r10 = iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 + ((Map.Entry) r10.next()).hashCode();
        goto L4
    L6:
        return r11;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a r10 = new a(this.f20471a, this.f20472b);
        this.f20473c.put(r10, Boolean.FALSE);
        return r10;
    }

    public int size() {
        return this.f20474d;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("[");
        Iterator r11 = iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        r10.append(((Map.Entry) r11.next()).toString());
        if (r11.hasNext() == false) goto L4;
        r10.append(", ");
        goto L4
    L8:
        r10.append("]");
        return r10.toString();
    }
}
