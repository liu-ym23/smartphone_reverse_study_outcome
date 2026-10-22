package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final String f31745a;

    /* renamed from: b, reason: collision with root package name */
    public final D f31746b;

    public D(String str, D d10) {
        this.f31745a = str;
        this.f31746b = d10;
    }

    public static boolean c(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '-' && cCharAt != '_') {
                return true;
            }
        }
        return false;
    }

    public static D f(String str) {
        return new D(str, null);
    }

    public static D g(String str) {
        return F.d(str);
    }

    public final void a(StringBuilder sb2) {
        if (c(this.f31745a) || this.f31745a.isEmpty()) {
            sb2.append(C3904j.g(this.f31745a));
        } else {
            sb2.append(this.f31745a);
        }
        if (this.f31746b != null) {
            sb2.append(".");
            this.f31746b.a(sb2);
        }
    }

    public String b() {
        return this.f31745a;
    }

    public String d() {
        while (true) {
            D d10 = this.f31746b;
            if (d10 == null) {
                return this.f31745a;
            }
            this = d10;
        }
    }

    public int e() {
        int i10 = 1;
        for (D d10 = this.f31746b; d10 != null; d10 = d10.f31746b) {
            i10++;
        }
        return i10;
    }

    public boolean equals(Object obj) {
        if (obj instanceof D) {
            D d10 = (D) obj;
            if (this.f31745a.equals(d10.f31745a) && C3904j.b(this.f31746b, d10.f31746b)) {
                return true;
            }
        }
        return false;
    }

    public D h() {
        if (this.f31746b == null) {
            return null;
        }
        E e10 = new E();
        while (this.f31746b != null) {
            e10.a(this.f31745a);
            this = this.f31746b;
        }
        return e10.d();
    }

    public int hashCode() {
        int iHashCode = (this.f31745a.hashCode() + 41) * 41;
        D d10 = this.f31746b;
        return iHashCode + (d10 == null ? 0 : d10.hashCode());
    }

    public D i(D d10) {
        E e10 = new E();
        e10.b(d10);
        e10.b(this);
        return e10.d();
    }

    public D j() {
        return this.f31746b;
    }

    public String k() {
        StringBuilder sb2 = new StringBuilder();
        a(sb2);
        return sb2.toString();
    }

    public D l(int i10) {
        while (this != null && i10 > 0) {
            i10--;
            this = this.f31746b;
        }
        return this;
    }

    public D m(int i10, int i11) {
        if (i11 < i10) {
            throw new ConfigException.BugOrBroken("bad call to subPath");
        }
        D dL = l(i10);
        E e10 = new E();
        int i12 = i11 - i10;
        while (i12 > 0) {
            i12--;
            e10.a(dL.b());
            dL = dL.j();
            if (dL == null) {
                throw new ConfigException.BugOrBroken("subPath lastIndex out of range " + i11);
            }
        }
        return e10.d();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Path(");
        a(sb2);
        sb2.append(")");
        return sb2.toString();
    }

    public D(Iterator<D> it) {
        if (it.hasNext()) {
            D next = it.next();
            this.f31745a = next.f31745a;
            E e10 = new E();
            D d10 = next.f31746b;
            if (d10 != null) {
                e10.b(d10);
            }
            while (it.hasNext()) {
                e10.b(it.next());
            }
            this.f31746b = e10.d();
            return;
        }
        throw new ConfigException.BugOrBroken("empty path");
    }
}
