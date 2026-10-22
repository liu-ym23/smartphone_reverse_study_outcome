package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\tJ\u0015\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\tR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u000bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/s;", "Lcom/stepos/agentframework/adapter/netcore/p;", "<init>", "()V", "", "tag", "text", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "e", "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "TAG", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setTAG", "", "DEBUG", "Z", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class s extends p {
    public static final s INSTANCE = new s();
    private static String TAG = "AgentLogger_LLM_API";
    private static boolean DEBUG = true;

    @Override // com.stepos.agentframework.adapter.netcore.p
    public void a(String tag, String text) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(text, "text");
        if (DEBUG) {
            C4148a.c(tag, text, true);
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.p
    public void b(String tag, String text) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(text, "text");
        if (DEBUG) {
            C4148a.f(tag, text, true);
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.p
    public void c(String tag, String text) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(text, "text");
        if (DEBUG) {
            C4148a.j(tag, text, true);
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.p
    public void d(String tag, String text) {
        kotlin.jvm.internal.p.i(tag, "tag");
        kotlin.jvm.internal.p.i(text, "text");
        if (DEBUG) {
            C4148a.s(tag, text, true);
        }
    }

    public final void e(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        a(TAG, text);
    }

    public final String f() {
        return TAG;
    }

    public final void g(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        c(TAG, text);
    }
}
