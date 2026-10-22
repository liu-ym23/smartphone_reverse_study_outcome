package com.stepos.agentframework.adapter.agentbus;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fRT\u0010\u000f\u001aB\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006 \u000e* \u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010RT\u0010\u0011\u001aB\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006 \u000e* \u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/N;", "", "<init>", "()V", "", "toolCallId", "", "c", "(Ljava/lang/String;)Z", Const.INTENT_KEY_PKGNAME, "fingerprint", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Z", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "shown", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "results", "Ljava/util/concurrent/ConcurrentHashMap;", "progressFingerprints", "Ljava/util/concurrent/ConcurrentHashMap;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class N {
    private final ConcurrentHashMap.KeySetView<String, Boolean> shown = ConcurrentHashMap.newKeySet();
    private final ConcurrentHashMap.KeySetView<String, Boolean> results = ConcurrentHashMap.newKeySet();
    private final ConcurrentHashMap<String, String> progressFingerprints = new ConcurrentHashMap<>();

    public final boolean a(String toolCallId, String fingerprint) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(fingerprint, "fingerprint");
        if (toolCallId.length() == 0) {
            return true;
        }
        return !kotlin.jvm.internal.p.d(this.progressFingerprints.put(toolCallId, fingerprint), fingerprint);
    }

    public final boolean b(String toolCallId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        return this.results.add(toolCallId);
    }

    public final boolean c(String toolCallId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        return this.shown.add(toolCallId);
    }
}
