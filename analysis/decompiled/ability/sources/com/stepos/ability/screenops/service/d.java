package com.stepos.ability.screenops.service;

import com.mdisdk.capability.TagWriteMode;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final TagWriteMode f3242a;

    public d(TagWriteMode mode) {
        k.f(mode, "mode");
        this.f3242a = mode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f3242a == ((d) obj).f3242a;
    }

    public final int hashCode() {
        return Long.hashCode(100L) + (this.f3242a.hashCode() * 31);
    }

    public final String toString() {
        return "TagWriteConfig(mode=" + this.f3242a + ", delayMillis=100)";
    }
}
