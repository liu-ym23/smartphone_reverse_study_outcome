package com.stepos.ailauncher.chat;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/PickFileType;", "", UxipConstants.f30680s, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TYPE_IMAGE", "TYPE_DOC", "TYPE_ERASER_IMAGE", "TYPE_AI_EXPAND_IMAGE", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PickFileType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PickFileType[] $VALUES;
    private final String value;
    public static final PickFileType TYPE_IMAGE = new PickFileType("TYPE_IMAGE", 0, "type_choose_image");
    public static final PickFileType TYPE_DOC = new PickFileType("TYPE_DOC", 1, "type_choose_doc");
    public static final PickFileType TYPE_ERASER_IMAGE = new PickFileType("TYPE_ERASER_IMAGE", 2, "type_eraser_image");
    public static final PickFileType TYPE_AI_EXPAND_IMAGE = new PickFileType("TYPE_AI_EXPAND_IMAGE", 3, "type_ai_expand_image");

    private static final /* synthetic */ PickFileType[] $values() {
        return new PickFileType[]{TYPE_IMAGE, TYPE_DOC, TYPE_ERASER_IMAGE, TYPE_AI_EXPAND_IMAGE};
    }

    static {
        PickFileType[] pickFileTypeArr$values = $values();
        $VALUES = pickFileTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(pickFileTypeArr$values);
    }

    private PickFileType(String str, int i10, String str2) {
        this.value = str2;
    }

    public static InterfaceC4149a<PickFileType> getEntries() {
        return $ENTRIES;
    }

    public static PickFileType valueOf(String str) {
        return (PickFileType) Enum.valueOf(PickFileType.class, str);
    }

    public static PickFileType[] values() {
        return (PickFileType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
