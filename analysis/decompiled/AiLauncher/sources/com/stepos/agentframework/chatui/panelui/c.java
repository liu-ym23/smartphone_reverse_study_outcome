package com.stepos.agentframework.chatui.panelui;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatui/panelui/c;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatui/panelui/b;", "handle", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatui/panelui/b;)V", "", "layerId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatui/panelui/d;", "host", "Lcom/stepos/agentframework/chatui/panelui/d;", "getHost", "()Lcom/stepos/agentframework/chatui/panelui/d;", "c", "(Lcom/stepos/agentframework/chatui/panelui/d;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class c {
    public static final c INSTANCE = new c();
    private static volatile d host;

    public final void a(String layerId) {
        t tVar;
        p.i(layerId, "layerId");
        try {
            Result.Companion companion = Result.INSTANCE;
            d dVar = host;
            if (dVar != null) {
                dVar.b(layerId);
                tVar = t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void b(b handle) {
        t tVar;
        p.i(handle, "handle");
        try {
            Result.Companion companion = Result.INSTANCE;
            d dVar = host;
            if (dVar != null) {
                dVar.a(handle);
                tVar = t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void c(d dVar) {
        host = dVar;
    }
}
