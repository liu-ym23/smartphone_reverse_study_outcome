package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* loaded from: classes5.dex */
abstract class NamedLoggerBase implements vc.c, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f37934a;

    @Override // vc.c
    public String getName() {
        return this.f37934a;
    }

    public Object readResolve() throws ObjectStreamException {
        return vc.e.m(getName());
    }
}
