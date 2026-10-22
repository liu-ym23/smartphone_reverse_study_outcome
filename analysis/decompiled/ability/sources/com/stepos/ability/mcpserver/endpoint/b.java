package com.stepos.ability.mcpserver.endpoint;

import com.stepos.ability.mcpserver.model.McpServerConfig;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final McpServerConfig f3179a;
    public final S7.a b;
    public final Object c;
    public final SessionManager$sessions$1 d;
    public int e;

    public b(McpServerConfig mcpServerConfig) {
        SessionManager$1 nowMs = SessionManager$1.f3176a;
        k.f(nowMs, "nowMs");
        this.f3179a = mcpServerConfig;
        this.b = nowMs;
        this.c = new Object();
        this.d = new SessionManager$sessions$1(this);
    }
}
