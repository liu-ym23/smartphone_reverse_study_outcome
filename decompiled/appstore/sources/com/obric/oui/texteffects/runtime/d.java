package com.obric.oui.texteffects.runtime;

import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f17346c;

    public d(long r10, long r11, List r12) {
        q.g(r12, "layers");
        this.f17344a = r10;
        this.f17345b = r11;
        this.f17346c = r12;
    }

    public final List a() {
        return this.f17346c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (this.f17344a == r11.f17344a) goto L12;
        return false;
    L12:
        if (this.f17345b == r11.f17345b) goto L15;
        return false;
    L15:
        if (q.b(this.f17346c, r11.f17346c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f17344a) * 31) + Long.hashCode(this.f17345b)) * 31) + this.f17346c.hashCode();
    }

    public String toString() {
        return "TextEffectFrame(playTimeMs=" + this.f17344a + ", normalizedPlayTimeMs=" + this.f17345b + ", layers=" + this.f17346c + ')';
    }
}
