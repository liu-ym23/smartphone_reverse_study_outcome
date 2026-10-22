package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.ToolDedupSignature;
import h8.C4148a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/e1;", "", "<init>", "()V", "key", "Lcom/stepos/agentframework/chatcore/session/b0;", "listener", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Lcom/stepos/agentframework/chatcore/session/b0;)V", "c", "(Ljava/lang/Object;)V", "", "sessionId", "Lw4/c;", "message", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lw4/c;Lcom/stepos/agentframework/chatcore/intent/e;)V", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "", "DEDUP_CAP", "I", "Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$LruDedupCache;", "toolDedupCache", "Lcom/stepos/agentframework/chatcore/session/ToolDedupSignature$LruDedupCache;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class e1 {
    private static final int DEDUP_CAP = 512;
    public static final e1 INSTANCE = new e1();
    private static final ConcurrentHashMap<Object, InterfaceC1861b0> listeners = new ConcurrentHashMap<>();
    private static final String TAG = "ToolEventBus";
    private static final ToolDedupSignature.LruDedupCache<String> toolDedupCache = new ToolDedupSignature.LruDedupCache<>(TAG, 512);

    public static final void a(String sessionId, ChatMessage message, AgentTool tool) {
        Object objB;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(tool, "tool");
        ToolCallReporter.INSTANCE.a(sessionId, message, tool);
        ConcurrentHashMap<Object, InterfaceC1861b0> concurrentHashMap = listeners;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        String toolCallId = tool.getToolCallId();
        if (toolCallId.length() > 0) {
            ToolDedupSignature.ToolFrameSig toolFrameSigA = ToolDedupSignature.INSTANCE.a(message, tool);
            if (toolDedupCache.q(sessionId + "|" + toolCallId, toolFrameSigA)) {
                return;
            }
        }
        for (InterfaceC1861b0 interfaceC1861b0 : concurrentHashMap.values()) {
            kotlin.jvm.internal.p.h(interfaceC1861b0, "next(...)");
            InterfaceC1861b0 interfaceC1861b02 = interfaceC1861b0;
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC1861b02.a(sessionId, message, tool);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "tool event listener failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }

    public static final void b(Object key, InterfaceC1861b0 listener) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(listener, "listener");
        ConcurrentHashMap<Object, InterfaceC1861b0> concurrentHashMap = listeners;
        InterfaceC1861b0 interfaceC1861b0Put = concurrentHashMap.put(key, listener);
        if (interfaceC1861b0Put == null) {
            C4148a.k(TAG, "register key=" + key + " total=" + concurrentHashMap.size(), false, 4, null);
            return;
        }
        if (interfaceC1861b0Put != listener) {
            C4148a.k(TAG, "replace listener for key=" + key + " total=" + concurrentHashMap.size(), false, 4, null);
        }
    }

    public static final void c(Object key) {
        kotlin.jvm.internal.p.i(key, "key");
        ConcurrentHashMap<Object, InterfaceC1861b0> concurrentHashMap = listeners;
        if (concurrentHashMap.remove(key) != null) {
            C4148a.k(TAG, "unregister key=" + key + " total=" + concurrentHashMap.size(), false, 4, null);
        }
    }
}
