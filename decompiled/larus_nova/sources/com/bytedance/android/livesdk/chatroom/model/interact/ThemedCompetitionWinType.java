package com.bytedance.android.livesdk.chatroom.model.interact;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/ThemedCompetitionWinType;", "", "", "value", "I", "getValue", "()I", "NOT_WIN", "WIN", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ThemedCompetitionWinType extends Enum<ThemedCompetitionWinType> {
    public static final ThemedCompetitionWinType NOT_WIN = null;
    public static final ThemedCompetitionWinType WIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemedCompetitionWinType[] f106946a = null;
    private final int value;

    static {
        ThemedCompetitionWinType r100 = new ThemedCompetitionWinType("NOT_WIN", 0, 0);
        NOT_WIN = r100;
        ThemedCompetitionWinType r101 = new ThemedCompetitionWinType("WIN", 1, 1);
        WIN = r101;
        f106946a = new ThemedCompetitionWinType[]{r100, r101};
    }

    public static ThemedCompetitionWinType valueOf(String r100) {
        return (ThemedCompetitionWinType) r27.a.a(ThemedCompetitionWinType.class, r100);
    }

    public static ThemedCompetitionWinType[] values() {
        return (ThemedCompetitionWinType[]) f106946a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ThemedCompetitionWinType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
