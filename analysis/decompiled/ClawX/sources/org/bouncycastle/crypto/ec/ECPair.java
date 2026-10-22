package org.bouncycastle.crypto.ec;

import p7.r;

/* loaded from: classes.dex */
public class ECPair {

    /* renamed from: x, reason: collision with root package name */
    private final r f4434x;
    private final r y;

    public ECPair(r rVar, r rVar2) {
        this.f4434x = rVar;
        this.y = rVar2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECPair) {
            return equals((ECPair) obj);
        }
        return false;
    }

    public r getX() {
        return this.f4434x;
    }

    public r getY() {
        return this.y;
    }

    public int hashCode() {
        return (this.y.hashCode() * 37) + this.f4434x.hashCode();
    }

    public boolean equals(ECPair eCPair) {
        return eCPair.getX().c(getX()) && eCPair.getY().c(getY());
    }
}
