package com.stepos.agentframework.adapter.agentbus;

import Z8.C1172u;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.DownlinkRunTelemetry;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.deepbinder.core.constant.Constants;
import h8.C4148a;
import java.util.HashMap;
import java.util.LinkedHashSet;
import kotlin.AbstractC0913i;
import kotlin.C0917m;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 :2\u00020\u0001:\u0002\b;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J)\u0010\u001c\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR0\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020!`\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$RP\u0010'\u001a>\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0%j\b\u0012\u0004\u0012\u00020\u000f`&0 j\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0%j\b\u0012\u0004\u0012\u00020\u000f`&`\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010$R\u0018\u0010*\u001a\u00060(j\u0002`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0004\u0018\u0001048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/s;", "", "<init>", "()V", "LY8/t;", "c", "LK6/m;", Constants.PARAM_REPLY, Const.INTENT_KEY_PKGNAME, "(LK6/m;)LK6/m;", "", "cumulative", "rawDelta", "", "isFinish", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Z)J", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "", "cumulativeLen", "delta", Const.INTENT_KEY_UMID, "(Ljava/lang/String;ILjava/lang/String;)V", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "emittedLen", "finalArrived", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;IZ)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LK6/m;Ljava/lang/String;)LK6/m;", "Ljava/util/HashMap;", "Lcom/stepos/agentframework/adapter/agentbus/s$b;", "Lkotlin/collections/HashMap;", "stateByRunId", "Ljava/util/HashMap;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "seenFramesByRunId", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "pendingDeltaLog", "Ljava/lang/StringBuilder;", "pendingDeltaRunId", "Ljava/lang/String;", "pendingDeltaCumulativeLen", "I", "deltaLogFlushScheduled", "Z", "deltaLogLock", "Ljava/lang/Object;", "Landroid/os/Handler;", "deltaLogHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "flushDeltaLogRunnable", "Ljava/lang/Runnable;", "Companion", Const.INTENT_KEY_APIKEY, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class s {
    private static final long DELTA_LOG_INTERVAL_MS = 100;
    private static final int SEEN_FRAMES_CAP = 4096;
    private static final String TAG = "AgentBusStreamAccumulator";
    private boolean deltaLogFlushScheduled;
    private final Handler deltaLogHandler;
    private final Runnable flushDeltaLogRunnable;
    private int pendingDeltaCumulativeLen;
    private String pendingDeltaRunId;
    private final HashMap<String, RunState> stateByRunId = new HashMap<>();
    private final HashMap<String, LinkedHashSet<Long>> seenFramesByRunId = new HashMap<>();
    private final StringBuilder pendingDeltaLog = new StringBuilder();
    private final Object deltaLogLock = new Object();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/s$b;", "", "", "emitted", "", "segmentBaseLen", "lastCumulativeSeen", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "I", "c", "f", "(I)V", Const.INTENT_KEY_PKGNAME, "e", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.s$b, reason: from toString */
    public static final /* data */ class RunState {
        private String emitted;
        private String lastCumulativeSeen;
        private int segmentBaseLen;

        public RunState() {
            this(null, 0, null, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final String getEmitted() {
            return this.emitted;
        }

        /* renamed from: b, reason: from getter */
        public final String getLastCumulativeSeen() {
            return this.lastCumulativeSeen;
        }

        /* renamed from: c, reason: from getter */
        public final int getSegmentBaseLen() {
            return this.segmentBaseLen;
        }

        public final void d(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.emitted = str;
        }

        public final void e(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.lastCumulativeSeen = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RunState)) {
                return false;
            }
            RunState runState = (RunState) other;
            return kotlin.jvm.internal.p.d(this.emitted, runState.emitted) && this.segmentBaseLen == runState.segmentBaseLen && kotlin.jvm.internal.p.d(this.lastCumulativeSeen, runState.lastCumulativeSeen);
        }

        public final void f(int i10) {
            this.segmentBaseLen = i10;
        }

        public int hashCode() {
            return (((this.emitted.hashCode() * 31) + Integer.hashCode(this.segmentBaseLen)) * 31) + this.lastCumulativeSeen.hashCode();
        }

        public String toString() {
            return "RunState(emitted=" + this.emitted + ", segmentBaseLen=" + this.segmentBaseLen + ", lastCumulativeSeen=" + this.lastCumulativeSeen + ")";
        }

        public RunState(String emitted, int i10, String lastCumulativeSeen) {
            kotlin.jvm.internal.p.i(emitted, "emitted");
            kotlin.jvm.internal.p.i(lastCumulativeSeen, "lastCumulativeSeen");
            this.emitted = emitted;
            this.segmentBaseLen = i10;
            this.lastCumulativeSeen = lastCumulativeSeen;
        }

        public /* synthetic */ RunState(String str, int i10, String str2, int i11, kotlin.jvm.internal.i iVar) {
            this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? "" : str2);
        }
    }

    public s() {
        Looper mainLooper = Looper.getMainLooper();
        this.deltaLogHandler = mainLooper != null ? new Handler(mainLooper) : null;
        this.flushDeltaLogRunnable = new Runnable() { // from class: com.stepos.agentframework.adapter.agentbus.r
            @Override // java.lang.Runnable
            public final void run() {
                s.f(this.f22335a);
            }
        };
    }

    public static final void f(s sVar) {
        sVar.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0289  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.C0917m b(kotlin.C0917m r23) {
        /*
            Method dump skipped, instructions count: 1310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.s.b(K6.m):K6.m");
    }

    public final void c() {
        e();
        this.stateByRunId.clear();
        this.seenFramesByRunId.clear();
    }

    public final void d(String runId, int cumulativeLen, String delta) {
        if (delta.length() == 0) {
            return;
        }
        synchronized (this.deltaLogLock) {
            try {
                String str = this.pendingDeltaRunId;
                if (str != null && !kotlin.jvm.internal.p.d(str, runId) && this.pendingDeltaLog.length() > 0) {
                    j();
                }
                this.pendingDeltaRunId = runId;
                this.pendingDeltaCumulativeLen = cumulativeLen;
                this.pendingDeltaLog.append(delta);
                Handler handler = this.deltaLogHandler;
                if (handler == null) {
                    j();
                    return;
                }
                if (!this.deltaLogFlushScheduled) {
                    this.deltaLogFlushScheduled = true;
                    handler.postDelayed(this.flushDeltaLogRunnable, 100L);
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        synchronized (this.deltaLogLock) {
            try {
                Handler handler = this.deltaLogHandler;
                if (handler != null) {
                    handler.removeCallbacks(this.flushDeltaLogRunnable);
                }
                this.deltaLogFlushScheduled = false;
                if (this.pendingDeltaLog.length() > 0) {
                    j();
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final long g(String cumulative, String rawDelta, boolean isFinish) {
        long jHashCode = ((cumulative.hashCode() & 4294967295L) << 32) | (4294967295L & rawDelta.hashCode());
        return isFinish ? ~jHashCode : jHashCode;
    }

    public final void h(String runId, int emittedLen, boolean finalArrived) {
        if (runId != null) {
            if (runId.length() <= 0) {
                runId = null;
            }
            String str = runId;
            if (str == null) {
                return;
            }
            DownlinkRunTelemetry.c(DownlinkRunTelemetry.INSTANCE, str, Math.max(emittedLen, 0), finalArrived, null, 8, null);
        }
    }

    public final C0917m i(C0917m c0917m, String str) {
        c0917m.N(C1172u.e(new AbstractC0913i.Text(str)));
        return c0917m;
    }

    public final void j() {
        String string = this.pendingDeltaLog.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        String str = this.pendingDeltaRunId;
        int i10 = this.pendingDeltaCumulativeLen;
        this.pendingDeltaLog.setLength(0);
        C4148a.c(TAG, "delta runId=" + str + " cumulativeLen=" + i10 + " deltaLen=" + string.length() + " delta=" + string, true);
    }
}
