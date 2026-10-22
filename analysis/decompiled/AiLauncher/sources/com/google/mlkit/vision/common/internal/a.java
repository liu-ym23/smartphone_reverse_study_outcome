package com.google.mlkit.vision.common.internal;

import com.google.android.gms.common.internal.C1669j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import n3.InterfaceC4938b;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Map f21806a = new HashMap();

    /* renamed from: com.google.mlkit.vision.common.internal.a$a, reason: collision with other inner class name */
    public static class C0239a {

        /* renamed from: a, reason: collision with root package name */
        public final Class f21807a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC4938b f21808b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21809c;

        public final int a() {
            return this.f21809c;
        }

        public final InterfaceC4938b b() {
            return this.f21808b;
        }

        public final Class c() {
            return this.f21807a;
        }
    }

    public a(Set set) {
        HashMap map = new HashMap();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            C0239a c0239a = (C0239a) it.next();
            Class clsC = c0239a.c();
            if (!this.f21806a.containsKey(clsC) || c0239a.a() >= ((Integer) C1669j.k((Integer) map.get(clsC))).intValue()) {
                this.f21806a.put(clsC, c0239a.b());
                map.put(clsC, Integer.valueOf(c0239a.a()));
            }
        }
    }
}
