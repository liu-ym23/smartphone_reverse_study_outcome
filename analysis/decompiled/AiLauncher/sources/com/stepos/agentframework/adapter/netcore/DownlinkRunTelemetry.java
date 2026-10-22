package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0004*\u0002\u001a\u001d\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry;", "", "<init>", "()V", "", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "", "accumulatedLen", "", "finalFrameArrived", DidiCardProvider.KEY_TRACE_ID, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;IZLjava/lang/String;)V", "Lcom/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry$a;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Lcom/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry$a;", "Lkotlin/Pair;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lkotlin/Pair;", "e", "(Ljava/lang/String;)Z", "CAP", "I", "lock", "Ljava/lang/Object;", "com/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry$byRunId$1", "byRunId", "Lcom/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry$byRunId$1;", "com/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry$reported$1", "reported", "Lcom/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry$reported$1;", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DownlinkRunTelemetry {
    private static final int CAP = 256;
    public static final DownlinkRunTelemetry INSTANCE = new DownlinkRunTelemetry();
    private static final Object lock = new Object();
    private static final DownlinkRunTelemetry$byRunId$1 byRunId = new DownlinkRunTelemetry$byRunId$1();
    private static final DownlinkRunTelemetry$reported$1 reported = new DownlinkRunTelemetry$reported$1();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry$a;", "", "", "accumulatedLen", "", "finalFrameArrived", "", DidiCardProvider.KEY_TRACE_ID, "<init>", "(IZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_PKGNAME, "()Z", "Ljava/lang/String;", "c", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.netcore.DownlinkRunTelemetry$a, reason: from toString */
    public static final /* data */ class Snapshot {
        private final int accumulatedLen;
        private final boolean finalFrameArrived;
        private final String traceId;

        public Snapshot(int i10, boolean z10, String traceId) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
            this.accumulatedLen = i10;
            this.finalFrameArrived = z10;
            this.traceId = traceId;
        }

        /* renamed from: a, reason: from getter */
        public final int getAccumulatedLen() {
            return this.accumulatedLen;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getFinalFrameArrived() {
            return this.finalFrameArrived;
        }

        /* renamed from: c, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return this.accumulatedLen == snapshot.accumulatedLen && this.finalFrameArrived == snapshot.finalFrameArrived && kotlin.jvm.internal.p.d(this.traceId, snapshot.traceId);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.accumulatedLen) * 31) + Boolean.hashCode(this.finalFrameArrived)) * 31) + this.traceId.hashCode();
        }

        public String toString() {
            return "Snapshot(accumulatedLen=" + this.accumulatedLen + ", finalFrameArrived=" + this.finalFrameArrived + ", traceId=" + this.traceId + ")";
        }
    }

    public static /* synthetic */ void c(DownlinkRunTelemetry downlinkRunTelemetry, String str, int i10, boolean z10, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        if ((i11 & 8) != 0) {
            str2 = "";
        }
        downlinkRunTelemetry.b(str, i10, z10, str2);
    }

    public final Pair<String, Snapshot> a(String traceId) {
        Pair<String, Snapshot> pair;
        kotlin.jvm.internal.p.i(traceId, "traceId");
        if (traceId.length() == 0) {
            return null;
        }
        synchronized (lock) {
            try {
                Set<Map.Entry<String, Snapshot>> setEntrySet = byRunId.entrySet();
                kotlin.jvm.internal.p.h(setEntrySet, "<get-entries>(...)");
                Object obj = null;
                for (Object obj2 : setEntrySet) {
                    if (kotlin.jvm.internal.p.d(((Snapshot) ((Map.Entry) obj2).getValue()).getTraceId(), traceId)) {
                        obj = obj2;
                    }
                }
                Map.Entry entry = (Map.Entry) obj;
                pair = entry != null ? new Pair<>(entry.getKey(), entry.getValue()) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pair;
    }

    public final void b(String runId, int accumulatedLen, boolean finalFrameArrived, String traceId) {
        kotlin.jvm.internal.p.i(runId, "runId");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        if (runId.length() == 0) {
            return;
        }
        synchronized (lock) {
            try {
                DownlinkRunTelemetry$byRunId$1 downlinkRunTelemetry$byRunId$1 = byRunId;
                Snapshot snapshot = (Snapshot) downlinkRunTelemetry$byRunId$1.get(runId);
                int iMax = Math.max(accumulatedLen, snapshot != null ? snapshot.getAccumulatedLen() : 0);
                boolean z10 = (snapshot != null && snapshot.getFinalFrameArrived()) || finalFrameArrived;
                if (traceId.length() == 0) {
                    String traceId2 = snapshot != null ? snapshot.getTraceId() : null;
                    if (traceId2 == null) {
                        traceId2 = "";
                    }
                    traceId = traceId2;
                }
                downlinkRunTelemetry$byRunId$1.put(runId, new Snapshot(iMax, z10, traceId));
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Snapshot d(String runId) {
        Snapshot snapshot;
        kotlin.jvm.internal.p.i(runId, "runId");
        if (runId.length() == 0) {
            return null;
        }
        synchronized (lock) {
            snapshot = (Snapshot) byRunId.get(runId);
        }
        return snapshot;
    }

    public final boolean e(String runId) {
        kotlin.jvm.internal.p.i(runId, "runId");
        if (runId.length() == 0) {
            return false;
        }
        synchronized (lock) {
            DownlinkRunTelemetry$reported$1 downlinkRunTelemetry$reported$1 = reported;
            if (downlinkRunTelemetry$reported$1.containsKey(runId)) {
                return false;
            }
            downlinkRunTelemetry$reported$1.put(runId, Boolean.TRUE);
            return true;
        }
    }
}
