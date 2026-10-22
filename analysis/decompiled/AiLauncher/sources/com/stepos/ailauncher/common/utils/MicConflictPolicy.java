package com.stepos.ailauncher.common.utils;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/common/utils/MicConflictPolicy;", "", "<init>", "()V", "Lcom/stepos/ailauncher/common/utils/MicConflictPolicy$AgentEntry;", "entry", "Lcom/stepos/ailauncher/common/utils/MicConflictPolicy$a;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/common/utils/MicConflictPolicy$AgentEntry;)Lcom/stepos/ailauncher/common/utils/MicConflictPolicy$a;", "Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;", "occupancy", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/common/utils/MicConflictPolicy$AgentEntry;Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;)Lcom/stepos/ailauncher/common/utils/MicConflictPolicy$a;", "", Const.INTENT_KEY_UMID, "()Z", "e", "f", "(Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;)Z", "c", "AgentEntry", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MicConflictPolicy {
    public static final MicConflictPolicy INSTANCE = new MicConflictPolicy();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/common/utils/MicConflictPolicy$AgentEntry;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE_WAKEUP", "AI_KEY_OR_HEADSET", "HEADSET_WAKEUP", "MANUAL_PUSH_TO_TALK", "AI_KEY_LONG_PRESS", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AgentEntry {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ AgentEntry[] $VALUES;
        public static final AgentEntry VOICE_WAKEUP = new AgentEntry("VOICE_WAKEUP", 0);
        public static final AgentEntry AI_KEY_OR_HEADSET = new AgentEntry("AI_KEY_OR_HEADSET", 1);
        public static final AgentEntry HEADSET_WAKEUP = new AgentEntry("HEADSET_WAKEUP", 2);
        public static final AgentEntry MANUAL_PUSH_TO_TALK = new AgentEntry("MANUAL_PUSH_TO_TALK", 3);
        public static final AgentEntry AI_KEY_LONG_PRESS = new AgentEntry("AI_KEY_LONG_PRESS", 4);

        private static final /* synthetic */ AgentEntry[] $values() {
            return new AgentEntry[]{VOICE_WAKEUP, AI_KEY_OR_HEADSET, HEADSET_WAKEUP, MANUAL_PUSH_TO_TALK, AI_KEY_LONG_PRESS};
        }

        static {
            AgentEntry[] agentEntryArr$values = $values();
            $VALUES = agentEntryArr$values;
            $ENTRIES = kotlin.enums.a.a(agentEntryArr$values);
        }

        private AgentEntry(String str, int i10) {
        }

        public static InterfaceC4149a<AgentEntry> getEntries() {
            return $ENTRIES;
        }

        public static AgentEntry valueOf(String str) {
            return (AgentEntry) Enum.valueOf(AgentEntry.class, str);
        }

        public static AgentEntry[] values() {
            return (AgentEntry[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AgentEntry.values().length];
            try {
                iArr[AgentEntry.VOICE_WAKEUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentEntry.AI_KEY_OR_HEADSET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentEntry.AI_KEY_LONG_PRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AgentEntry.HEADSET_WAKEUP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AgentEntry.MANUAL_PUSH_TO_TALK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MicOccupancyMonitor.OccupancyKind.values().length];
            try {
                iArr2[MicOccupancyMonitor.OccupancyKind.SYSTEM_CALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MicOccupancyMonitor.OccupancyKind.EXTERNAL_RECORDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[MicOccupancyMonitor.OccupancyKind.EXTERNAL_VOIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final WakeDecision a(AgentEntry entry) {
        kotlin.jvm.internal.p.i(entry, "entry");
        return b(entry, MicOccupancyMonitor.INSTANCE.h());
    }

    public final WakeDecision b(AgentEntry entry, MicOccupancyMonitor.OccupancyKind occupancy) {
        kotlin.jvm.internal.p.i(entry, "entry");
        kotlin.jvm.internal.p.i(occupancy, "occupancy");
        int i10 = b.$EnumSwitchMapping$1[occupancy.ordinal()];
        kotlin.jvm.internal.i iVar = null;
        boolean z10 = false;
        int i11 = 2;
        boolean z11 = true;
        if (i10 == 1) {
            int i12 = b.$EnumSwitchMapping$0[entry.ordinal()];
            if (i12 == 1 || i12 == 2 || i12 == 3 || i12 == 4) {
                return new WakeDecision(z10, z10, i11, iVar);
            }
            if (i12 == 5) {
                return new WakeDecision(z11, z10, i11, iVar);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (i10 == 2) {
            int i13 = b.$EnumSwitchMapping$0[entry.ordinal()];
            if (i13 == 1) {
                return new WakeDecision(z10, z10, i11, iVar);
            }
            if (i13 == 2) {
                return new WakeDecision(z11, z10, i11, iVar);
            }
            if (i13 == 3 || i13 == 4 || i13 == 5) {
                return new WakeDecision(true, true);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (i10 != 3) {
            return new WakeDecision(z11, z10, i11, iVar);
        }
        int i14 = b.$EnumSwitchMapping$0[entry.ordinal()];
        if (i14 == 1) {
            return new WakeDecision(z10, z10, i11, iVar);
        }
        if (i14 == 2) {
            return new WakeDecision(z11, z10, i11, iVar);
        }
        if (i14 == 3 || i14 == 4 || i14 == 5) {
            return new WakeDecision(true, true);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean c() {
        int i10 = b.$EnumSwitchMapping$1[MicOccupancyMonitor.INSTANCE.h().ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3) ? false : true;
    }

    public final boolean d() {
        return a(AgentEntry.MANUAL_PUSH_TO_TALK).getAllowed();
    }

    public final boolean e() {
        return f(MicOccupancyMonitor.INSTANCE.h());
    }

    public final boolean f(MicOccupancyMonitor.OccupancyKind occupancy) {
        kotlin.jvm.internal.p.i(occupancy, "occupancy");
        int i10 = b.$EnumSwitchMapping$1[occupancy.ordinal()];
        return i10 == 1 || i10 == 3;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/common/utils/MicConflictPolicy$a;", "", "", "allowed", "showConcurrentToast", "<init>", "(ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_APIKEY, "()Z", "getShowConcurrentToast", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.utils.MicConflictPolicy$a, reason: from toString */
    public static final /* data */ class WakeDecision {
        private final boolean allowed;
        private final boolean showConcurrentToast;

        public WakeDecision(boolean z10, boolean z11) {
            this.allowed = z10;
            this.showConcurrentToast = z11;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getAllowed() {
            return this.allowed;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WakeDecision)) {
                return false;
            }
            WakeDecision wakeDecision = (WakeDecision) other;
            return this.allowed == wakeDecision.allowed && this.showConcurrentToast == wakeDecision.showConcurrentToast;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.allowed) * 31) + Boolean.hashCode(this.showConcurrentToast);
        }

        public String toString() {
            return "WakeDecision(allowed=" + this.allowed + ", showConcurrentToast=" + this.showConcurrentToast + ")";
        }

        public /* synthetic */ WakeDecision(boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
            this(z10, (i10 & 2) != 0 ? false : z11);
        }
    }
}
