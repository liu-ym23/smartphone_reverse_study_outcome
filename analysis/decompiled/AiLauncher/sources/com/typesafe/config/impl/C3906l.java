package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;

/* renamed from: com.typesafe.config.impl.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3906l extends u {
    public C3906l(Q q10) {
        super(q10);
        if (!S.f(this.f31893a)) {
            throw new ConfigException.BugOrBroken("Tried to create a ConfigNodeComment from a non-comment token");
        }
    }

    public String d() {
        return S.a(this.f31893a);
    }
}
