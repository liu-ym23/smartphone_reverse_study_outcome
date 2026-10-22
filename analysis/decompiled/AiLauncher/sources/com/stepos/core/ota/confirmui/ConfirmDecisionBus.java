package com.stepos.core.ota.confirmui;

import android.os.SystemClock;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.taskstore.provider.c;
import h9.InterfaceC4149a;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\"#$%&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u0003J\u001d\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus;", "", "<init>", "()V", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Entry;", "", OtaConfirmTrampolineActivity.EXTRA_REQ_ID, "takeUnlessExpired", "(Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Entry;Ljava/lang/String;)Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Entry;", "LY8/t;", "sweepExpired", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$DecisionListener;", "decision", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$StageListener;", "stage", "register", "(Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$DecisionListener;Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$StageListener;)Ljava/lang/String;", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$SubStage;", "notifyStage", "(Ljava/lang/String;Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$SubStage;)V", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;", "submit", "(Ljava/lang/String;Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;)V", "clear", "(Ljava/lang/String;)V", "", "DEFAULT_TTL_MS", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicLong;", c.a.COL_SEQ, "Ljava/util/concurrent/atomic/AtomicLong;", "Decision", "SubStage", "DecisionListener", "StageListener", "Entry", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConfirmDecisionBus {
    private static final long DEFAULT_TTL_MS = 300000;
    public static final ConfirmDecisionBus INSTANCE = new ConfirmDecisionBus();
    private static final ConcurrentHashMap<String, Entry> listeners = new ConcurrentHashMap<>();
    private static final AtomicLong seq = new AtomicLong(0);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIRM", "CONFIRM_CELLULAR", "ENABLE_WIFI_AUTO_AND_UPDATE", "ENABLE_WIFI_AUTO_ONLY", "SCHEDULE_WIFI_DOWNLOAD", "OPEN_SERVICE_SETTINGS", "CANCEL", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Decision {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
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

        public static InterfaceC4149a<Decision> getEntries() {
            return $ENTRIES;
        }

        public static Decision valueOf(String str) {
            return (Decision) Enum.valueOf(Decision.class, str);
        }

        public static Decision[] values() {
            return (Decision[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$DecisionListener;", "", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;", "decision", "LY8/t;", "onDecision", "(Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;)V", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface DecisionListener {
        void onDecision(Decision decision);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Entry;", "", "decision", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$DecisionListener;", "stage", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$StageListener;", "createdAtMs", "", "<init>", "(Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$DecisionListener;Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$StageListener;J)V", "getDecision", "()Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$DecisionListener;", "getStage", "()Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$StageListener;", "getCreatedAtMs", "()J", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Entry {
        private final long createdAtMs;
        private final DecisionListener decision;
        private final StageListener stage;

        public Entry(DecisionListener decision, StageListener stage, long j10) {
            kotlin.jvm.internal.p.i(decision, "decision");
            kotlin.jvm.internal.p.i(stage, "stage");
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

        /* renamed from: component1, reason: from getter */
        public final DecisionListener getDecision() {
            return this.decision;
        }

        /* renamed from: component2, reason: from getter */
        public final StageListener getStage() {
            return this.stage;
        }

        /* renamed from: component3, reason: from getter */
        public final long getCreatedAtMs() {
            return this.createdAtMs;
        }

        public final Entry copy(DecisionListener decision, StageListener stage, long createdAtMs) {
            kotlin.jvm.internal.p.i(decision, "decision");
            kotlin.jvm.internal.p.i(stage, "stage");
            return new Entry(decision, stage, createdAtMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return kotlin.jvm.internal.p.d(this.decision, entry.decision) && kotlin.jvm.internal.p.d(this.stage, entry.stage) && this.createdAtMs == entry.createdAtMs;
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
            return (((this.decision.hashCode() * 31) + this.stage.hashCode()) * 31) + Long.hashCode(this.createdAtMs);
        }

        public String toString() {
            return "Entry(decision=" + this.decision + ", stage=" + this.stage + ", createdAtMs=" + this.createdAtMs + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$StageListener;", "", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$SubStage;", "stage", "LY8/t;", "onStage", "(Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$SubStage;)V", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface StageListener {
        void onStage(SubStage stage);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$SubStage;", "", "<init>", "(Ljava/lang/String;I)V", "CELLULAR_REMINDER", "WIFI_GUIDE", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SubStage {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
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

        public static InterfaceC4149a<SubStage> getEntries() {
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
        Set<Map.Entry<String, Entry>> setEntrySet = listeners.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.core.ota.confirmui.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ConfirmDecisionBus.sweepExpired$lambda$0(jElapsedRealtime, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: com.stepos.core.ota.confirmui.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ConfirmDecisionBus.sweepExpired$lambda$1(interfaceC5074l, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sweepExpired$lambda$0(long j10, Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return j10 - ((Entry) it.getValue()).getCreatedAtMs() > 300000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sweepExpired$lambda$1(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    private final Entry takeUnlessExpired(Entry entry, String str) {
        if (SystemClock.elapsedRealtime() - entry.getCreatedAtMs() <= 300000) {
            return entry;
        }
        listeners.remove(str, entry);
        return null;
    }

    public final void clear(String reqId) {
        kotlin.jvm.internal.p.i(reqId, "reqId");
        listeners.remove(reqId);
    }

    public final void notifyStage(String reqId, SubStage stage) {
        Entry entryTakeUnlessExpired;
        kotlin.jvm.internal.p.i(reqId, "reqId");
        kotlin.jvm.internal.p.i(stage, "stage");
        Entry entry = listeners.get(reqId);
        if (entry == null || (entryTakeUnlessExpired = takeUnlessExpired(entry, reqId)) == null) {
            return;
        }
        entryTakeUnlessExpired.getStage().onStage(stage);
    }

    public final String register(DecisionListener decision, StageListener stage) {
        kotlin.jvm.internal.p.i(decision, "decision");
        kotlin.jvm.internal.p.i(stage, "stage");
        sweepExpired();
        String str = "cfm-" + seq.incrementAndGet();
        listeners.put(str, new Entry(decision, stage, SystemClock.elapsedRealtime()));
        return str;
    }

    public final void submit(String reqId, Decision decision) {
        Entry entryTakeUnlessExpired;
        kotlin.jvm.internal.p.i(reqId, "reqId");
        kotlin.jvm.internal.p.i(decision, "decision");
        Entry entryRemove = listeners.remove(reqId);
        if (entryRemove == null || (entryTakeUnlessExpired = takeUnlessExpired(entryRemove, reqId)) == null) {
            return;
        }
        entryTakeUnlessExpired.getDecision().onDecision(decision);
    }
}
