package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.AbstractConfigValue;

/* loaded from: classes4.dex */
public final class K<V extends AbstractConfigValue> {

    /* renamed from: a, reason: collision with root package name */
    public final I f31758a;

    /* renamed from: b, reason: collision with root package name */
    public final V f31759b;

    public K(I i10, V v10) {
        this.f31758a = i10;
        this.f31759b = v10;
    }

    public static <V extends AbstractConfigValue> K<V> b(I i10, V v10) {
        return new K<>(i10, v10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public K<AbstractC3897c> a() {
        if (this.f31759b instanceof AbstractC3897c) {
            return this;
        }
        throw new ConfigException.BugOrBroken("Expecting a resolve result to be an object, but it was " + this.f31759b);
    }

    public K<V> c() {
        return b(this.f31758a.g(), this.f31759b);
    }

    public String toString() {
        return "ResolveResult(" + this.f31759b + ")";
    }
}
