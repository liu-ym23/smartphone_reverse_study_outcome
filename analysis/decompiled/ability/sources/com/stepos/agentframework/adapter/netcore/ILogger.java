package com.stepos.agentframework.adapter.netcore;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/ILogger;", "", AppAgent.CONSTRUCT, "()V", "", "tag", "text", "LC7/r;", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "e", "i", "w", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ILogger {
    public void d(String tag, String text) {
        k.f(tag, "tag");
        k.f(text, "text");
    }

    public void e(String tag, String text) {
        k.f(tag, "tag");
        k.f(text, "text");
    }

    public void i(String tag, String text) {
        k.f(tag, "tag");
        k.f(text, "text");
    }

    public void w(String tag, String text) {
        k.f(tag, "tag");
        k.f(text, "text");
    }
}
