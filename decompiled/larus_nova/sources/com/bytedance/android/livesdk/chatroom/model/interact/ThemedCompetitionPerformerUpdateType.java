package com.bytedance.android.livesdk.chatroom.model.interact;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/ThemedCompetitionPerformerUpdateType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "SET", "UNSET", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ThemedCompetitionPerformerUpdateType extends Enum<ThemedCompetitionPerformerUpdateType> {
    public static final ThemedCompetitionPerformerUpdateType SET = null;
    public static final ThemedCompetitionPerformerUpdateType UNKNOWN = null;
    public static final ThemedCompetitionPerformerUpdateType UNSET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemedCompetitionPerformerUpdateType[] f106943a = null;
    private final int value;

    static {
        ThemedCompetitionPerformerUpdateType r100 = new ThemedCompetitionPerformerUpdateType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ThemedCompetitionPerformerUpdateType r101 = new ThemedCompetitionPerformerUpdateType("SET", 1, 1);
        SET = r101;
        ThemedCompetitionPerformerUpdateType r102 = new ThemedCompetitionPerformerUpdateType("UNSET", 2, 2);
        UNSET = r102;
        f106943a = new ThemedCompetitionPerformerUpdateType[]{r100, r101, r102};
    }

    public static ThemedCompetitionPerformerUpdateType valueOf(String r100) {
        return (ThemedCompetitionPerformerUpdateType) r27.a.a(ThemedCompetitionPerformerUpdateType.class, r100);
    }

    public static ThemedCompetitionPerformerUpdateType[] values() {
        return (ThemedCompetitionPerformerUpdateType[]) f106943a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ThemedCompetitionPerformerUpdateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
