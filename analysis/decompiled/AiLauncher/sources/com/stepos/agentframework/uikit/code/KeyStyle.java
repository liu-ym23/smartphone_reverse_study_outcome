package com.stepos.agentframework.uikit.code;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/uikit/code/KeyStyle;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "COLON", "ATTR_EQUALS", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KeyStyle {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ KeyStyle[] $VALUES;
    public static final KeyStyle NONE = new KeyStyle(ModelFlowMeta.PLAN_NONE, 0);
    public static final KeyStyle COLON = new KeyStyle("COLON", 1);
    public static final KeyStyle ATTR_EQUALS = new KeyStyle("ATTR_EQUALS", 2);

    private static final /* synthetic */ KeyStyle[] $values() {
        return new KeyStyle[]{NONE, COLON, ATTR_EQUALS};
    }

    static {
        KeyStyle[] keyStyleArr$values = $values();
        $VALUES = keyStyleArr$values;
        $ENTRIES = a.a(keyStyleArr$values);
    }

    private KeyStyle(String str, int i10) {
    }

    public static InterfaceC4149a<KeyStyle> getEntries() {
        return $ENTRIES;
    }

    public static KeyStyle valueOf(String str) {
        return (KeyStyle) Enum.valueOf(KeyStyle.class, str);
    }

    public static KeyStyle[] values() {
        return (KeyStyle[]) $VALUES.clone();
    }
}
