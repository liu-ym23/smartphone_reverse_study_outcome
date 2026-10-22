package com.stepos.core.ability.text;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SessionKey {
    private final int callerUid;
    private final String name;

    public SessionKey(int i10, String name) {
        g.f(name, "name");
        this.callerUid = i10;
        this.name = name;
    }

    public static /* synthetic */ SessionKey copy$default(SessionKey sessionKey, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = sessionKey.callerUid;
        }
        if ((i11 & 2) != 0) {
            str = sessionKey.name;
        }
        return sessionKey.copy(i10, str);
    }

    public final int component1() {
        return this.callerUid;
    }

    public final String component2() {
        return this.name;
    }

    public final SessionKey copy(int i10, String name) {
        g.f(name, "name");
        return new SessionKey(i10, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionKey)) {
            return false;
        }
        SessionKey sessionKey = (SessionKey) obj;
        return this.callerUid == sessionKey.callerUid && g.b(this.name, sessionKey.name);
    }

    public final int getCallerUid() {
        return this.callerUid;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode() + (Integer.hashCode(this.callerUid) * 31);
    }

    public String toString() {
        return "SessionKey(callerUid=" + this.callerUid + ", name=" + this.name + ")";
    }
}
