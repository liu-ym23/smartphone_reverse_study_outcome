package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public final class J2 {

    /* renamed from: a, reason: collision with root package name */
    public K2 f2845a = new K2();

    public final K2 a() {
        K2 k22 = new K2();
        if (this.f2845a.f2849a == null) {
            k22.f2849a = Collections.EMPTY_LIST;
        } else {
            k22.f2849a = Collections.unmodifiableList(new ArrayList(this.f2845a.f2849a));
        }
        if (this.f2845a.b == null) {
            k22.b = Collections.EMPTY_LIST;
        } else {
            k22.b = Collections.unmodifiableList(new ArrayList(this.f2845a.b));
        }
        if (this.f2845a.c == null) {
            k22.c = Collections.EMPTY_LIST;
        } else {
            k22.c = Collections.unmodifiableList(new ArrayList(this.f2845a.c));
        }
        if (this.f2845a.d == null) {
            k22.d = Collections.EMPTY_LIST;
        } else {
            k22.d = Collections.unmodifiableList(new ArrayList(this.f2845a.d));
        }
        if (this.f2845a.e == null) {
            k22.e = Collections.EMPTY_LIST;
            return k22;
        }
        k22.e = Collections.unmodifiableList(new ArrayList(this.f2845a.e));
        return k22;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final J2 clone() {
        K2 k22 = new K2();
        if (this.f2845a.f2849a == null) {
            k22.f2849a = null;
        } else {
            k22.f2849a = new ArrayList(this.f2845a.f2849a);
        }
        if (this.f2845a.b == null) {
            k22.b = null;
        } else {
            k22.b = new ArrayList(this.f2845a.b);
        }
        if (this.f2845a.c == null) {
            k22.c = null;
        } else {
            k22.c = new ArrayList(this.f2845a.c);
        }
        if (this.f2845a.d == null) {
            k22.d = null;
        } else {
            k22.d = new ArrayList(this.f2845a.d);
        }
        if (this.f2845a.e == null) {
            k22.e = null;
        } else {
            k22.e = new ArrayList(this.f2845a.e);
        }
        J2 j22 = new J2();
        j22.f2845a = k22;
        return j22;
    }

    public final void c(K2 k22) {
        if (!k22.f2849a.isEmpty()) {
            K2 k23 = this.f2845a;
            if (k23.f2849a == null) {
                k23.f2849a = new ArrayList();
            }
            this.f2845a.f2849a.addAll(k22.f2849a);
        }
        if (!k22.b.isEmpty()) {
            K2 k24 = this.f2845a;
            if (k24.b == null) {
                k24.b = new ArrayList();
            }
            this.f2845a.b.addAll(k22.b);
        }
        if (!k22.c.isEmpty()) {
            K2 k25 = this.f2845a;
            if (k25.c == null) {
                k25.c = new ArrayList();
            }
            this.f2845a.c.addAll(k22.c);
        }
        if (!k22.d.isEmpty()) {
            K2 k26 = this.f2845a;
            if (k26.d == null) {
                k26.d = new ArrayList();
            }
            this.f2845a.d.addAll(k22.d);
        }
        if (k22.e.isEmpty()) {
            return;
        }
        K2 k27 = this.f2845a;
        if (k27.e == null) {
            k27.e = new ArrayList();
        }
        this.f2845a.e.addAll(k22.e);
    }
}
