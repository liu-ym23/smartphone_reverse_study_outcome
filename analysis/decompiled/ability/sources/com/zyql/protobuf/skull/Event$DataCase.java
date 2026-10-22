package com.zyql.protobuf.skull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class Event$DataCase {

    /* renamed from: a, reason: collision with root package name */
    public static final Event$DataCase f4279a;
    public static final Event$DataCase b;
    public static final Event$DataCase c;
    public static final Event$DataCase d;
    public static final /* synthetic */ Event$DataCase[] e;

    static {
        Event$DataCase event$DataCase = new Event$DataCase("TASK", 0);
        f4279a = event$DataCase;
        Event$DataCase event$DataCase2 = new Event$DataCase("ITEM", 1);
        b = event$DataCase2;
        Event$DataCase event$DataCase3 = new Event$DataCase("MESSAGE_DELTA", 2);
        c = event$DataCase3;
        Event$DataCase event$DataCase4 = new Event$DataCase("DATA_NOT_SET", 3);
        d = event$DataCase4;
        e = new Event$DataCase[]{event$DataCase, event$DataCase2, event$DataCase3, event$DataCase4};
    }

    public static Event$DataCase valueOf(String str) {
        return (Event$DataCase) Enum.valueOf(Event$DataCase.class, str);
    }

    public static Event$DataCase[] values() {
        return (Event$DataCase[]) e.clone();
    }
}
