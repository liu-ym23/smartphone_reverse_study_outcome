package com.typesafe.config.impl;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.typesafe.config.impl.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC3895a {
    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<T> it = b().iterator();
        while (it.hasNext()) {
            sb2.append(((Q) it.next()).e());
        }
        return sb2.toString();
    }

    public abstract Collection<Q> b();

    public final boolean equals(Object obj) {
        return (obj instanceof AbstractC3895a) && a().equals(((AbstractC3895a) obj).a());
    }

    public final int hashCode() {
        return a().hashCode();
    }
}
