package com.bytedance.ai.view.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/view/input/FloatingChatStatus;", "", "<init>", "(Ljava/lang/String;I)V", "READY_TO_INPUT", "READY_TO_SPEAK", "READY_TO_SEND", "ON_SPEAK", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FloatingChatStatus extends Enum<FloatingChatStatus> {
    public static final FloatingChatStatus ON_SPEAK = null;
    public static final FloatingChatStatus READY_TO_INPUT = null;
    public static final FloatingChatStatus READY_TO_SEND = null;
    public static final FloatingChatStatus READY_TO_SPEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FloatingChatStatus[] f37719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37720b = null;

    public static EnumEntries<FloatingChatStatus> getEntries() {
        return f37720b;
    }

    static {
        FloatingChatStatus r100 = new FloatingChatStatus("READY_TO_INPUT", 0);
        READY_TO_INPUT = r100;
        FloatingChatStatus r101 = new FloatingChatStatus("READY_TO_SPEAK", 1);
        READY_TO_SPEAK = r101;
        FloatingChatStatus r102 = new FloatingChatStatus("READY_TO_SEND", 2);
        READY_TO_SEND = r102;
        FloatingChatStatus r103 = new FloatingChatStatus("ON_SPEAK", 3);
        ON_SPEAK = r103;
        FloatingChatStatus[] r104 = {r100, r101, r102, r103};
        f37719a = r104;
        f37720b = EnumEntriesKt.enumEntries(r104);
    }

    public static FloatingChatStatus[] values() {
        return (FloatingChatStatus[]) f37719a.clone();
    }

    public static FloatingChatStatus valueOf(String r100) {
        return (FloatingChatStatus) r27.a.a(FloatingChatStatus.class, r100);
    }

    public FloatingChatStatus(String r100, int r101) {
        super(r100, r101);
    }
}
