package com.stepos.ability.screenops.service;

import java.util.Set;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f3240a;
    public final Set b;

    public b(String str, Set eventTypes) {
        k.f(eventTypes, "eventTypes");
        this.f3240a = str;
        this.b = eventTypes;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.b(this.f3240a, bVar.f3240a) && k.b(this.b, bVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f3240a.hashCode() * 31);
    }

    public final String toString() {
        return "RuleMatch(ruleName=" + this.f3240a + ", eventTypes=" + this.b + ")";
    }
}
