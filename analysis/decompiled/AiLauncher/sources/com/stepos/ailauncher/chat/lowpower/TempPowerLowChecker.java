package com.stepos.ailauncher.chat.lowpower;

import La.C;
import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017 B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker;", "", "<init>", "()V", "", "raw", "Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;", "stat", "Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$PLevel;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;)Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$PLevel;", "", "e", "(Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;)Z", Const.INTENT_KEY_UMID, "f", "()Z", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;)I", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "KEY", "Ljava/lang/String;", "cached", "Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;", "c", "()Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;)V", "PLevel", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TempPowerLowChecker {
    public static final TempPowerLowChecker INSTANCE = new TempPowerLowChecker();
    public static final String KEY = "stepos_temp_power_low_stat";
    private static volatile Stat cached;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$PLevel;", "", "<init>", "(Ljava/lang/String;I)V", "P0", "P1", "P2", "P3", "P4", ModelFlowMeta.PLAN_NONE, "isHardBlock", "", "()Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PLevel {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ PLevel[] $VALUES;

        /* renamed from: P0, reason: collision with root package name */
        public static final PLevel f25523P0 = new PLevel("P0", 0);

        /* renamed from: P1, reason: collision with root package name */
        public static final PLevel f25524P1 = new PLevel("P1", 1);

        /* renamed from: P2, reason: collision with root package name */
        public static final PLevel f25525P2 = new PLevel("P2", 2);

        /* renamed from: P3, reason: collision with root package name */
        public static final PLevel f25526P3 = new PLevel("P3", 3);

        /* renamed from: P4, reason: collision with root package name */
        public static final PLevel f25527P4 = new PLevel("P4", 4);
        public static final PLevel NONE = new PLevel(ModelFlowMeta.PLAN_NONE, 5);

        private static final /* synthetic */ PLevel[] $values() {
            return new PLevel[]{f25523P0, f25524P1, f25525P2, f25526P3, f25527P4, NONE};
        }

        static {
            PLevel[] pLevelArr$values = $values();
            $VALUES = pLevelArr$values;
            $ENTRIES = kotlin.enums.a.a(pLevelArr$values);
        }

        private PLevel(String str, int i10) {
        }

        public static InterfaceC4149a<PLevel> getEntries() {
            return $ENTRIES;
        }

        public static PLevel valueOf(String str) {
            return (PLevel) Enum.valueOf(PLevel.class, str);
        }

        public static PLevel[] values() {
            return (PLevel[]) $VALUES.clone();
        }

        public final boolean isHardBlock() {
            return this == f25523P0 || this == f25524P1;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;", "", "", "tempStat", "levelStat", "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.lowpower.TempPowerLowChecker$a, reason: from toString */
    public static final /* data */ class Stat {
        private final int levelStat;
        private final int tempStat;

        public Stat(int i10, int i11) {
            this.tempStat = i10;
            this.levelStat = i11;
        }

        /* renamed from: a, reason: from getter */
        public final int getLevelStat() {
            return this.levelStat;
        }

        /* renamed from: b, reason: from getter */
        public final int getTempStat() {
            return this.tempStat;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stat)) {
                return false;
            }
            Stat stat = (Stat) other;
            return this.tempStat == stat.tempStat && this.levelStat == stat.levelStat;
        }

        public int hashCode() {
            return (Integer.hashCode(this.tempStat) * 31) + Integer.hashCode(this.levelStat);
        }

        public String toString() {
            return "Stat(tempStat=" + this.tempStat + ", levelStat=" + this.levelStat + ")";
        }
    }

    public final int a(Stat stat) {
        return d(stat) ? R$string.temp_power_low_dialog_message : R$string.temp_low_dialog_message;
    }

    public final int b(Stat stat) {
        return d(stat) ? R$string.temp_power_low_dialog_title : R$string.temp_low_dialog_title;
    }

    public final Stat c() {
        return cached;
    }

    public final boolean d(Stat stat) {
        return stat != null && stat.getLevelStat() == 1;
    }

    public final boolean e(Stat stat) {
        return g(stat).isHardBlock();
    }

    public final boolean f() {
        return e(cached);
    }

    public final PLevel g(Stat stat) {
        if (stat == null) {
            return PLevel.NONE;
        }
        int tempStat = stat.getTempStat();
        if (tempStat == -1) {
            int levelStat = stat.getLevelStat();
            return (levelStat == 1 || levelStat == 2) ? PLevel.f25526P3 : levelStat != 3 ? PLevel.NONE : PLevel.f25527P4;
        }
        if (tempStat == 1) {
            int levelStat2 = stat.getLevelStat();
            return levelStat2 != 1 ? (levelStat2 == 2 || levelStat2 == 3) ? PLevel.f25525P2 : PLevel.f25527P4 : PLevel.f25523P0;
        }
        if (tempStat == 2) {
            int levelStat3 = stat.getLevelStat();
            return levelStat3 != 1 ? levelStat3 != 2 ? levelStat3 != 3 ? PLevel.f25527P4 : PLevel.f25526P3 : PLevel.f25525P2 : PLevel.f25524P1;
        }
        if (tempStat != 3) {
            return PLevel.NONE;
        }
        int levelStat4 = stat.getLevelStat();
        return levelStat4 != 1 ? levelStat4 != 2 ? PLevel.f25527P4 : PLevel.f25526P3 : PLevel.f25525P2;
    }

    public final Stat h(String raw) {
        Integer numW;
        if (raw != null && !H.x0(raw)) {
            List listB1 = H.b1(raw, new String[]{Const.STR_MART_COMMA}, false, 0, 6, null);
            if (listB1.size() == 2 && (numW = C.w(H.D1((String) listB1.get(0)).toString())) != null) {
                int iIntValue = numW.intValue();
                Integer numW2 = C.w(H.D1((String) listB1.get(1)).toString());
                if (numW2 != null) {
                    return new Stat(iIntValue, numW2.intValue());
                }
            }
        }
        return null;
    }

    public final void i(Stat stat) {
        cached = stat;
    }

    public final int j(Stat stat) {
        return d(stat) ? R$string.temp_power_low_toast : R$string.temp_low_toast;
    }
}
