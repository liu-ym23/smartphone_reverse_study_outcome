package com.stepos.agentframework.adapter.netcore;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.statsrpk.d;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\nJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\tJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\nR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/Logger;", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", AppAgent.CONSTRUCT, "()V", "", "tag", "text", "LC7/r;", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "e", "i", "w", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "setTAG", "", "DEBUG", "Z", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Logger extends ILogger {
    public static final Logger INSTANCE = new Logger();
    private static String TAG = "AgentLogger_LLM_API";
    private static boolean DEBUG = true;

    private Logger() {
    }

    @Override // com.stepos.agentframework.adapter.netcore.ILogger
    public void d(String tag, String text) {
        k.f(tag, "tag");
        k.f(text, "text");
        if (DEBUG) {
            d.s(tag, text);
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.ILogger
    public void e(String tag, String text) {
        k.f(tag, "tag");
        k.f(text, "text");
        if (DEBUG) {
            d.u(tag, text);
        }
    }

    public final boolean getDEBUG() {
        return DEBUG;
    }

    public final String getTAG() {
        return TAG;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ILogger
    public void i(String tag, String text) {
        k.f(tag, "tag");
        k.f(text, "text");
        if (DEBUG) {
            d.D(tag, text);
        }
    }

    public final void setDEBUG(boolean z10) {
        DEBUG = z10;
    }

    public final void setTAG(String str) {
        k.f(str, "<set-?>");
        TAG = str;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ILogger
    public void w(String tag, String text) {
        k.f(tag, "tag");
        k.f(text, "text");
        if (DEBUG) {
            d.O(tag, text);
        }
    }

    public final void d(String text) {
        k.f(text, "text");
        d(TAG, text);
    }

    public final void e(String text) {
        k.f(text, "text");
        e(TAG, text);
    }

    public final void i(String text) {
        k.f(text, "text");
        i(TAG, text);
    }

    public final void w(String text) {
        k.f(text, "text");
        w(TAG, text);
    }
}
