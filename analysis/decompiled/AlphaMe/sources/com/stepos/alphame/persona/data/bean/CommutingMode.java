package com.stepos.alphame.persona.data.bean;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/alphame/persona/data/bean/CommutingMode;", "", "mode", "", "(Ljava/lang/String;IJ)V", "getMode", "()J", "BUS", "DRIVE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CommutingMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CommutingMode[] $VALUES;
    public static final CommutingMode BUS = new CommutingMode("BUS", 0, 0);
    public static final CommutingMode DRIVE = new CommutingMode("DRIVE", 1, 1);
    private final long mode;

    private static final /* synthetic */ CommutingMode[] $values() {
        return new CommutingMode[]{BUS, DRIVE};
    }

    static {
        CommutingMode[] commutingModeArr$values = $values();
        $VALUES = commutingModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(commutingModeArr$values);
    }

    private CommutingMode(String str, int i4, long j4) {
        this.mode = j4;
    }

    @NotNull
    public static EnumEntries<CommutingMode> getEntries() {
        return $ENTRIES;
    }

    public static CommutingMode valueOf(String str) {
        return (CommutingMode) Enum.valueOf(CommutingMode.class, str);
    }

    public static CommutingMode[] values() {
        return (CommutingMode[]) $VALUES.clone();
    }

    public final long getMode() {
        return this.mode;
    }
}
