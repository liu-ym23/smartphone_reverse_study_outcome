package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import com.typesafe.config.impl.ConfigString;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.typesafe.config.impl.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3913t extends AbstractC3896b {

    /* renamed from: a, reason: collision with root package name */
    public final Q f31892a;

    public C3913t(Q q10) {
        this.f31892a = q10;
    }

    @Override // com.typesafe.config.impl.AbstractC3895a
    public Collection<Q> b() {
        return Collections.singletonList(this.f31892a);
    }

    public Q c() {
        return this.f31892a;
    }

    public AbstractConfigValue d() {
        if (S.k(this.f31892a)) {
            return S.e(this.f31892a);
        }
        if (S.j(this.f31892a)) {
            return new ConfigString.Unquoted(this.f31892a.d(), S.d(this.f31892a));
        }
        if (!S.i(this.f31892a)) {
            throw new ConfigException.BugOrBroken("ConfigNodeSimpleValue did not contain a valid value token");
        }
        return new w(this.f31892a.d(), new P(F.e(S.c(this.f31892a).iterator(), this.f31892a.d()), S.b(this.f31892a)));
    }
}
