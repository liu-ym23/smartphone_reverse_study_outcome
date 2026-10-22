package com.stepos.agentframework.floatcard.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/floatcard/api/FloatCardActionStyle;", "", "<init>", "(Ljava/lang/String;I)V", "Primary", "Secondary", "Danger", "Text", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatCardActionStyle {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FloatCardActionStyle[] $VALUES;
    public static final FloatCardActionStyle Primary = new FloatCardActionStyle("Primary", 0);
    public static final FloatCardActionStyle Secondary = new FloatCardActionStyle("Secondary", 1);
    public static final FloatCardActionStyle Danger = new FloatCardActionStyle("Danger", 2);
    public static final FloatCardActionStyle Text = new FloatCardActionStyle("Text", 3);

    private static final /* synthetic */ FloatCardActionStyle[] $values() {
        return new FloatCardActionStyle[]{Primary, Secondary, Danger, Text};
    }

    static {
        FloatCardActionStyle[] floatCardActionStyleArr$values = $values();
        $VALUES = floatCardActionStyleArr$values;
        $ENTRIES = a.a(floatCardActionStyleArr$values);
    }

    private FloatCardActionStyle(String str, int i10) {
    }

    public static InterfaceC4149a<FloatCardActionStyle> getEntries() {
        return $ENTRIES;
    }

    public static FloatCardActionStyle valueOf(String str) {
        return (FloatCardActionStyle) Enum.valueOf(FloatCardActionStyle.class, str);
    }

    public static FloatCardActionStyle[] values() {
        return (FloatCardActionStyle[]) $VALUES.clone();
    }
}
