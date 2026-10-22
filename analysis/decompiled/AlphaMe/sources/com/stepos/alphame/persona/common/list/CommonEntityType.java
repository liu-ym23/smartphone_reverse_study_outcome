package com.stepos.alphame.persona.common.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/alphame/persona/common/list/CommonEntityType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "SINGLE", "DOUBLE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CommonEntityType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CommonEntityType[] $VALUES;
    private final int type;
    public static final CommonEntityType SINGLE = new CommonEntityType("SINGLE", 0, 0);
    public static final CommonEntityType DOUBLE = new CommonEntityType("DOUBLE", 1, 1);

    private static final /* synthetic */ CommonEntityType[] $values() {
        return new CommonEntityType[]{SINGLE, DOUBLE};
    }

    static {
        CommonEntityType[] commonEntityTypeArr$values = $values();
        $VALUES = commonEntityTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(commonEntityTypeArr$values);
    }

    private CommonEntityType(String str, int i4, int i5) {
        this.type = i5;
    }

    @NotNull
    public static EnumEntries<CommonEntityType> getEntries() {
        return $ENTRIES;
    }

    public static CommonEntityType valueOf(String str) {
        return (CommonEntityType) Enum.valueOf(CommonEntityType.class, str);
    }

    public static CommonEntityType[] values() {
        return (CommonEntityType[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }
}
