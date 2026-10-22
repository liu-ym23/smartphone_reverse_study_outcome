package com.stepos.core.ota.confirmui;

import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ConfirmDecisionBus {
    private static final long DEFAULT_TTL_MS = 300000;
    public static final ConfirmDecisionBus INSTANCE = new ConfirmDecisionBus();
    private static final ConcurrentHashMap<String, Entry> listeners = new ConcurrentHashMap<>();
    private static final AtomicLong seq = new AtomicLong(0);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Decision {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ Decision[] $VALUES;
        public static final Decision CONFIRM = new Decision("CONFIRM", 0);
        public static final Decision CONFIRM_CELLULAR = new Decision("CONFIRM_CELLULAR", 1);
        public static final Decision ENABLE_WIFI_AUTO_AND_UPDATE = new Decision("ENABLE_WIFI_AUTO_AND_UPDATE", 2);
        public static final Decision ENABLE_WIFI_AUTO_ONLY = new Decision("ENABLE_WIFI_AUTO_ONLY", 3);
        public static final Decision SCHEDULE_WIFI_DOWNLOAD = new Decision("SCHEDULE_WIFI_DOWNLOAD", 4);
        public static final Decision OPEN_SERVICE_SETTINGS = new Decision("OPEN_SERVICE_SETTINGS", 5);
        public static final Decision CANCEL = new Decision("CANCEL", 6);

        private static final /* synthetic */ Decision[] $values() {
            return new Decision[]{CONFIRM, CONFIRM_CELLULAR, ENABLE_WIFI_AUTO_AND_UPDATE, ENABLE_WIFI_AUTO_ONLY, SCHEDULE_WIFI_DOWNLOAD, OPEN_SERVICE_SETTINGS, CANCEL};
        }

        static {
            Decision[] decisionArr$values = $values();
            $VALUES = decisionArr$values;
            $ENTRIES = kotlin.enums.a.a(decisionArr$values);
        }

        private Decision(String str, int i10) {
        }

        public static sb.a<Decision> getEntries() {
            return $ENTRIES;
        }

        public static Decision valueOf(String str) {
            return (Decision) Enum.valueOf(Decision.class, str);
        }

        public static Decision[] values() {
            return (Decision[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface DecisionListener {
        void onDecision(Decision decision);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Entry {
        private final long createdAtMs;
        private final DecisionListener decision;
        private final StageListener stage;

        public Entry(DecisionListener decision, StageListener stage, long j10) {
            kotlin.jvm.internal.g.f(decision, "decision");
            kotlin.jvm.internal.g.f(stage, "stage");
            this.decision = decision;
            this.stage = stage;
            this.createdAtMs = j10;
        }

        public static /* synthetic */ Entry copy$default(Entry entry, DecisionListener decisionListener, StageListener stageListener, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                decisionListener = entry.decision;
            }
            if ((i10 & 2) != 0) {
                stageListener = entry.stage;
            }
            if ((i10 & 4) != 0) {
                j10 = entry.createdAtMs;
            }
            return entry.copy(decisionListener, stageListener, j10);
        }

        public final DecisionListener component1() {
            return this.decision;
        }

        public final StageListener component2() {
            return this.stage;
        }

        public final long component3() {
            return this.createdAtMs;
        }

        public final Entry copy(DecisionListener decision, StageListener stage, long j10) {
            kotlin.jvm.internal.g.f(decision, "decision");
            kotlin.jvm.internal.g.f(stage, "stage");
            return new Entry(decision, stage, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return kotlin.jvm.internal.g.b(this.decision, entry.decision) && kotlin.jvm.internal.g.b(this.stage, entry.stage) && this.createdAtMs == entry.createdAtMs;
        }

        public final long getCreatedAtMs() {
            return this.createdAtMs;
        }

        public final DecisionListener getDecision() {
            return this.decision;
        }

        public final StageListener getStage() {
            return this.stage;
        }

        public int hashCode() {
            return Long.hashCode(this.createdAtMs) + ((this.stage.hashCode() + (this.decision.hashCode() * 31)) * 31);
        }

        public String toString() {
            DecisionListener decisionListener = this.decision;
            StageListener stageListener = this.stage;
            long j10 = this.createdAtMs;
            StringBuilder sb2 = new StringBuilder("Entry(decision=");
            sb2.append(decisionListener);
            sb2.append(", stage=");
            sb2.append(stageListener);
            sb2.append(", createdAtMs=");
            return ai.onnxruntime.a.m(sb2, j10, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface StageListener {
        void onStage(SubStage subStage);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SubStage {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ SubStage[] $VALUES;
        public static final SubStage CELLULAR_REMINDER = new SubStage("CELLULAR_REMINDER", 0);
        public static final SubStage WIFI_GUIDE = new SubStage("WIFI_GUIDE", 1);

        private static final /* synthetic */ SubStage[] $values() {
            return new SubStage[]{CELLULAR_REMINDER, WIFI_GUIDE};
        }

        static {
            SubStage[] subStageArr$values = $values();
            $VALUES = subStageArr$values;
            $ENTRIES = kotlin.enums.a.a(subStageArr$values);
        }

        private SubStage(String str, int i10) {
        }

        public static sb.a<SubStage> getEntries() {
            return $ENTRIES;
        }

        public static SubStage valueOf(String str) {
            return (SubStage) Enum.valueOf(SubStage.class, str);
        }

        public static SubStage[] values() {
            return (SubStage[]) $VALUES.clone();
        }
    }

    private ConfirmDecisionBus() {
    }

    private final void sweepExpired() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        listeners.entrySet().removeIf(new com.stepos.core.common.telemetry.e(new zb.l() { // from class: com.stepos.core.ota.confirmui.a
            @Override // zb.l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ConfirmDecisionBus.sweepExpired$lambda$0(jElapsedRealtime, (Map.Entry) obj));
            }
        }, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sweepExpired$lambda$0(long j10, Map.Entry it) {
        kotlin.jvm.internal.g.f(it, "it");
        return j10 - ((Entry) it.getValue()).getCreatedAtMs() > 300000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sweepExpired$lambda$1(zb.l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    private final Entry takeUnlessExpired(Entry entry, String str) {
        if (SystemClock.elapsedRealtime() - entry.getCreatedAtMs() <= 300000) {
            return entry;
        }
        listeners.remove(str, entry);
        return null;
    }

    public final void clear(String reqId) {
        kotlin.jvm.internal.g.f(reqId, "reqId");
        listeners.remove(reqId);
    }

    public final void notifyStage(String reqId, SubStage stage) {
        Entry entryTakeUnlessExpired;
        kotlin.jvm.internal.g.f(reqId, "reqId");
        kotlin.jvm.internal.g.f(stage, "stage");
        Entry entry = listeners.get(reqId);
        if (entry == null || (entryTakeUnlessExpired = takeUnlessExpired(entry, reqId)) == null) {
            return;
        }
        entryTakeUnlessExpired.getStage().onStage(stage);
    }

    public final String register(DecisionListener decision, StageListener stage) {
        kotlin.jvm.internal.g.f(decision, "decision");
        kotlin.jvm.internal.g.f(stage, "stage");
        sweepExpired();
        String strF = com.stepos.core.ota.d.f(seq.incrementAndGet(), "cfm-");
        listeners.put(strF, new Entry(decision, stage, SystemClock.elapsedRealtime()));
        return strF;
    }

    public final void submit(String reqId, Decision decision) {
        Entry entryTakeUnlessExpired;
        kotlin.jvm.internal.g.f(reqId, "reqId");
        kotlin.jvm.internal.g.f(decision, "decision");
        Entry entryRemove = listeners.remove(reqId);
        if (entryRemove == null || (entryTakeUnlessExpired = takeUnlessExpired(entryRemove, reqId)) == null) {
            return;
        }
        entryTakeUnlessExpired.getDecision().onDecision(decision);
    }
}
