package com.stepos.agentframework.chatui.longtext;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/LongTextFallbackReason;", "", "<init>", "(Ljava/lang/String;I)V", "TABLE", "TABLE_ROW_TOO_LARGE", "CODE_BLOCK_CONTEXT", "LATEX", "IMAGE", "HTML", "INTERNAL_LINK", "UNSUPPORTED_NODE", "NESTING_LIMIT", "OVERSIZED_CLUSTER", "EMPTY_TEXT", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LongTextFallbackReason {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LongTextFallbackReason[] $VALUES;
    public static final LongTextFallbackReason TABLE = new LongTextFallbackReason("TABLE", 0);
    public static final LongTextFallbackReason TABLE_ROW_TOO_LARGE = new LongTextFallbackReason("TABLE_ROW_TOO_LARGE", 1);
    public static final LongTextFallbackReason CODE_BLOCK_CONTEXT = new LongTextFallbackReason("CODE_BLOCK_CONTEXT", 2);
    public static final LongTextFallbackReason LATEX = new LongTextFallbackReason("LATEX", 3);
    public static final LongTextFallbackReason IMAGE = new LongTextFallbackReason("IMAGE", 4);
    public static final LongTextFallbackReason HTML = new LongTextFallbackReason("HTML", 5);
    public static final LongTextFallbackReason INTERNAL_LINK = new LongTextFallbackReason("INTERNAL_LINK", 6);
    public static final LongTextFallbackReason UNSUPPORTED_NODE = new LongTextFallbackReason("UNSUPPORTED_NODE", 7);
    public static final LongTextFallbackReason NESTING_LIMIT = new LongTextFallbackReason("NESTING_LIMIT", 8);
    public static final LongTextFallbackReason OVERSIZED_CLUSTER = new LongTextFallbackReason("OVERSIZED_CLUSTER", 9);
    public static final LongTextFallbackReason EMPTY_TEXT = new LongTextFallbackReason("EMPTY_TEXT", 10);

    private static final /* synthetic */ LongTextFallbackReason[] $values() {
        return new LongTextFallbackReason[]{TABLE, TABLE_ROW_TOO_LARGE, CODE_BLOCK_CONTEXT, LATEX, IMAGE, HTML, INTERNAL_LINK, UNSUPPORTED_NODE, NESTING_LIMIT, OVERSIZED_CLUSTER, EMPTY_TEXT};
    }

    static {
        LongTextFallbackReason[] longTextFallbackReasonArr$values = $values();
        $VALUES = longTextFallbackReasonArr$values;
        $ENTRIES = kotlin.enums.a.a(longTextFallbackReasonArr$values);
    }

    private LongTextFallbackReason(String str, int i10) {
    }

    public static InterfaceC4149a<LongTextFallbackReason> getEntries() {
        return $ENTRIES;
    }

    public static LongTextFallbackReason valueOf(String str) {
        return (LongTextFallbackReason) Enum.valueOf(LongTextFallbackReason.class, str);
    }

    public static LongTextFallbackReason[] values() {
        return (LongTextFallbackReason[]) $VALUES.clone();
    }
}
