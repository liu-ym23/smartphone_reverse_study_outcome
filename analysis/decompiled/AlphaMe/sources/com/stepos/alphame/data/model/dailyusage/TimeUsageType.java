package com.stepos.alphame.data.model.dailyusage;

import ch.qos.logback.core.joran.action.Action;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/alphame/data/model/dailyusage/TimeUsageType;", "", "type", "", Action.KEY_ATTRIBUTE, "", "(Ljava/lang/String;IILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getType", "()I", "FULL_SCREEN_WINDOW", "FOREGROUND_WINDOW", "FLOATING_WINDOW", "AUDIO", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDailyUsage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DailyUsage.kt\ncom/stepos/alphame/data/model/dailyusage/TimeUsageType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
/* loaded from: classes.dex */
public final class TimeUsageType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TimeUsageType[] $VALUES;

    @NotNull
    private final String key;
    private final int type;
    public static final TimeUsageType FULL_SCREEN_WINDOW = new TimeUsageType("FULL_SCREEN_WINDOW", 0, 1, "full_screen_window");
    public static final TimeUsageType FOREGROUND_WINDOW = new TimeUsageType("FOREGROUND_WINDOW", 1, 11, "foreground_window");
    public static final TimeUsageType FLOATING_WINDOW = new TimeUsageType("FLOATING_WINDOW", 2, 12, "floating_window");
    public static final TimeUsageType AUDIO = new TimeUsageType("AUDIO", 3, 20, "audio");

    private static final /* synthetic */ TimeUsageType[] $values() {
        return new TimeUsageType[]{FULL_SCREEN_WINDOW, FOREGROUND_WINDOW, FLOATING_WINDOW, AUDIO};
    }

    static {
        TimeUsageType[] timeUsageTypeArr$values = $values();
        $VALUES = timeUsageTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(timeUsageTypeArr$values);
    }

    private TimeUsageType(String str, int i4, int i5, String str2) {
        this.type = i5;
        this.key = str2;
    }

    @NotNull
    public static EnumEntries<TimeUsageType> getEntries() {
        return $ENTRIES;
    }

    public static TimeUsageType valueOf(String str) {
        return (TimeUsageType) Enum.valueOf(TimeUsageType.class, str);
    }

    public static TimeUsageType[] values() {
        return (TimeUsageType[]) $VALUES.clone();
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final String getKey(int type) {
        TimeUsageType timeUsageType;
        TimeUsageType[] timeUsageTypeArrValues = values();
        int length = timeUsageTypeArrValues.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                timeUsageType = null;
                break;
            }
            timeUsageType = timeUsageTypeArrValues[i4];
            if (timeUsageType.type == type) {
                break;
            }
            i4++;
        }
        if (timeUsageType != null) {
            return timeUsageType.key;
        }
        return null;
    }
}
