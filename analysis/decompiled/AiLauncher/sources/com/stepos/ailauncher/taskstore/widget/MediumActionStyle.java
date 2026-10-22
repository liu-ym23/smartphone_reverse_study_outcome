package com.stepos.ailauncher.taskstore.widget;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/MediumActionStyle;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY", "SECONDARY", "OPTION", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class MediumActionStyle {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ MediumActionStyle[] $VALUES;
    public static final MediumActionStyle PRIMARY = new MediumActionStyle("PRIMARY", 0);
    public static final MediumActionStyle SECONDARY = new MediumActionStyle("SECONDARY", 1);
    public static final MediumActionStyle OPTION = new MediumActionStyle("OPTION", 2);

    private static final /* synthetic */ MediumActionStyle[] $values() {
        return new MediumActionStyle[]{PRIMARY, SECONDARY, OPTION};
    }

    static {
        MediumActionStyle[] mediumActionStyleArr$values = $values();
        $VALUES = mediumActionStyleArr$values;
        $ENTRIES = kotlin.enums.a.a(mediumActionStyleArr$values);
    }

    private MediumActionStyle(String str, int i10) {
    }

    public static InterfaceC4149a<MediumActionStyle> getEntries() {
        return $ENTRIES;
    }

    public static MediumActionStyle valueOf(String str) {
        return (MediumActionStyle) Enum.valueOf(MediumActionStyle.class, str);
    }

    public static MediumActionStyle[] values() {
        return (MediumActionStyle[]) $VALUES.clone();
    }
}
