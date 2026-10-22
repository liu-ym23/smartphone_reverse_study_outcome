package com.autonavi.aps.protocol.aps.a;

/* loaded from: classes.dex */
public class a {
    public static b a(com.autonavi.aps.protocol.aps.authority.a aVar) {
        if (aVar == null || aVar.a().size() <= 0) {
            throw new IllegalArgumentException("Encrypt key is required");
        }
        b bVar = new b();
        bVar.a(aVar);
        return bVar;
    }
}
