package com.stepos.alphame.persona.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/alphame/persona/data/PersonalResponseCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", "NO_AUTHORIZATION", "ERROR", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PersonalResponseCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PersonalResponseCode[] $VALUES;
    private final int code;
    public static final PersonalResponseCode SUCCESS = new PersonalResponseCode("SUCCESS", 0, 0);
    public static final PersonalResponseCode NO_AUTHORIZATION = new PersonalResponseCode("NO_AUTHORIZATION", 1, 1);
    public static final PersonalResponseCode ERROR = new PersonalResponseCode("ERROR", 2, 2);

    private static final /* synthetic */ PersonalResponseCode[] $values() {
        return new PersonalResponseCode[]{SUCCESS, NO_AUTHORIZATION, ERROR};
    }

    static {
        PersonalResponseCode[] personalResponseCodeArr$values = $values();
        $VALUES = personalResponseCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(personalResponseCodeArr$values);
    }

    private PersonalResponseCode(String str, int i4, int i5) {
        this.code = i5;
    }

    @NotNull
    public static EnumEntries<PersonalResponseCode> getEntries() {
        return $ENTRIES;
    }

    public static PersonalResponseCode valueOf(String str) {
        return (PersonalResponseCode) Enum.valueOf(PersonalResponseCode.class, str);
    }

    public static PersonalResponseCode[] values() {
        return (PersonalResponseCode[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
