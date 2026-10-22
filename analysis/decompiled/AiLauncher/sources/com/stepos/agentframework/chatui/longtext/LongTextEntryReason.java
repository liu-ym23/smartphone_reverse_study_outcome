package com.stepos.agentframework.chatui.longtext;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/LongTextEntryReason;", "", "<init>", "(Ljava/lang/String;I)V", "ELIGIBLE", "NOT_MESSAGE", "NOT_ASSISTANT", "NOT_COMPLETED", "MISSING_ID", "APPROVAL", "ASK_USER", "EMPTY_PARTS", "LAST_PART_NOT_TEXT", "LAST_CONTENT_NOT_TEXT", "LAST_TEXT_TOO_SHORT", "UNSUPPORTED_PREFIX_PART", "PREFIX_APP_UI", "PREFIX_TOO_LONG", "IMAGE_GALLERY", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LongTextEntryReason {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ LongTextEntryReason[] $VALUES;
    public static final LongTextEntryReason ELIGIBLE = new LongTextEntryReason("ELIGIBLE", 0);
    public static final LongTextEntryReason NOT_MESSAGE = new LongTextEntryReason("NOT_MESSAGE", 1);
    public static final LongTextEntryReason NOT_ASSISTANT = new LongTextEntryReason("NOT_ASSISTANT", 2);
    public static final LongTextEntryReason NOT_COMPLETED = new LongTextEntryReason("NOT_COMPLETED", 3);
    public static final LongTextEntryReason MISSING_ID = new LongTextEntryReason("MISSING_ID", 4);
    public static final LongTextEntryReason APPROVAL = new LongTextEntryReason("APPROVAL", 5);
    public static final LongTextEntryReason ASK_USER = new LongTextEntryReason("ASK_USER", 6);
    public static final LongTextEntryReason EMPTY_PARTS = new LongTextEntryReason("EMPTY_PARTS", 7);
    public static final LongTextEntryReason LAST_PART_NOT_TEXT = new LongTextEntryReason("LAST_PART_NOT_TEXT", 8);
    public static final LongTextEntryReason LAST_CONTENT_NOT_TEXT = new LongTextEntryReason("LAST_CONTENT_NOT_TEXT", 9);
    public static final LongTextEntryReason LAST_TEXT_TOO_SHORT = new LongTextEntryReason("LAST_TEXT_TOO_SHORT", 10);
    public static final LongTextEntryReason UNSUPPORTED_PREFIX_PART = new LongTextEntryReason("UNSUPPORTED_PREFIX_PART", 11);
    public static final LongTextEntryReason PREFIX_APP_UI = new LongTextEntryReason("PREFIX_APP_UI", 12);
    public static final LongTextEntryReason PREFIX_TOO_LONG = new LongTextEntryReason("PREFIX_TOO_LONG", 13);
    public static final LongTextEntryReason IMAGE_GALLERY = new LongTextEntryReason("IMAGE_GALLERY", 14);

    private static final /* synthetic */ LongTextEntryReason[] $values() {
        return new LongTextEntryReason[]{ELIGIBLE, NOT_MESSAGE, NOT_ASSISTANT, NOT_COMPLETED, MISSING_ID, APPROVAL, ASK_USER, EMPTY_PARTS, LAST_PART_NOT_TEXT, LAST_CONTENT_NOT_TEXT, LAST_TEXT_TOO_SHORT, UNSUPPORTED_PREFIX_PART, PREFIX_APP_UI, PREFIX_TOO_LONG, IMAGE_GALLERY};
    }

    static {
        LongTextEntryReason[] longTextEntryReasonArr$values = $values();
        $VALUES = longTextEntryReasonArr$values;
        $ENTRIES = kotlin.enums.a.a(longTextEntryReasonArr$values);
    }

    private LongTextEntryReason(String str, int i10) {
    }

    public static InterfaceC4149a<LongTextEntryReason> getEntries() {
        return $ENTRIES;
    }

    public static LongTextEntryReason valueOf(String str) {
        return (LongTextEntryReason) Enum.valueOf(LongTextEntryReason.class, str);
    }

    public static LongTextEntryReason[] values() {
        return (LongTextEntryReason[]) $VALUES.clone();
    }
}
