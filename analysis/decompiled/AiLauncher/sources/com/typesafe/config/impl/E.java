package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import java.util.Stack;

/* loaded from: classes4.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    public final Stack<String> f31747a = new Stack<>();

    /* renamed from: b, reason: collision with root package name */
    public D f31748b;

    public void a(String str) {
        c();
        this.f31747a.push(str);
    }

    public void b(D d10) {
        c();
        String strB = d10.b();
        D dJ = d10.j();
        while (true) {
            this.f31747a.push(strB);
            if (dJ == null) {
                return;
            }
            strB = dJ.b();
            dJ = dJ.j();
        }
    }

    public final void c() {
        if (this.f31748b != null) {
            throw new ConfigException.BugOrBroken("Adding to PathBuilder after getting result");
        }
    }

    public D d() {
        if (this.f31748b == null) {
            D d10 = null;
            while (!this.f31747a.isEmpty()) {
                d10 = new D(this.f31747a.pop(), d10);
            }
            this.f31748b = d10;
        }
        return this.f31748b;
    }
}
