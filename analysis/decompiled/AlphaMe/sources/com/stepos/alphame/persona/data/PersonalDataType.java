package com.stepos.alphame.persona.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/alphame/persona/data/PersonalDataType;", "", "type", "", "(Ljava/lang/String;IJ)V", "getType", "()J", "AUTO", "CUSTOM", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PersonalDataType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PersonalDataType[] $VALUES;
    public static final PersonalDataType AUTO = new PersonalDataType("AUTO", 0, 0);
    public static final PersonalDataType CUSTOM = new PersonalDataType("CUSTOM", 1, 1);
    private final long type;

    private static final /* synthetic */ PersonalDataType[] $values() {
        return new PersonalDataType[]{AUTO, CUSTOM};
    }

    static {
        PersonalDataType[] personalDataTypeArr$values = $values();
        $VALUES = personalDataTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(personalDataTypeArr$values);
    }

    private PersonalDataType(String str, int i4, long j4) {
        this.type = j4;
    }

    @NotNull
    public static EnumEntries<PersonalDataType> getEntries() {
        return $ENTRIES;
    }

    public static PersonalDataType valueOf(String str) {
        return (PersonalDataType) Enum.valueOf(PersonalDataType.class, str);
    }

    public static PersonalDataType[] values() {
        return (PersonalDataType[]) $VALUES.clone();
    }

    public final long getType() {
        return this.type;
    }
}
