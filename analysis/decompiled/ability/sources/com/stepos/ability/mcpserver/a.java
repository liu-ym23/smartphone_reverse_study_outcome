package com.stepos.ability.mcpserver;

import com.stepos.ability.mcpserver.security.KeyVerifier;
import k4.d;
import k4.i;
import k4.n;
import kotlin.jvm.internal.k;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public abstract class a implements InterfaceC2137b {
    public static i a(n registry, d identityResolver, KeyVerifier verifier) {
        k.f(registry, "registry");
        k.f(identityResolver, "identityResolver");
        k.f(verifier, "verifier");
        return new i(registry, new McpServerModule$provideKeyValidator$1(0, identityResolver, d.class, "resolveSelf", "resolveSelf()Lcom/stepos/ability/mcpserver/security/AppIdentity;", 0), verifier);
    }
}
