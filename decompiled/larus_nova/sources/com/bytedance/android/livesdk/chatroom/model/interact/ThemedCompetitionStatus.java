package com.bytedance.android.livesdk.chatroom.model.interact;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/ThemedCompetitionStatus;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", GXAnimation.STATE_START, "FINISH", "SHOW_RESULT", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ThemedCompetitionStatus extends Enum<ThemedCompetitionStatus> {
    public static final ThemedCompetitionStatus FINISH = null;
    public static final ThemedCompetitionStatus SHOW_RESULT = null;
    public static final ThemedCompetitionStatus START = null;
    public static final ThemedCompetitionStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemedCompetitionStatus[] f106945a = null;
    private final int value;

    static {
        ThemedCompetitionStatus r100 = new ThemedCompetitionStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ThemedCompetitionStatus r101 = new ThemedCompetitionStatus(GXAnimation.STATE_START, 1, 1);
        START = r101;
        ThemedCompetitionStatus r102 = new ThemedCompetitionStatus("FINISH", 2, 2);
        FINISH = r102;
        ThemedCompetitionStatus r103 = new ThemedCompetitionStatus("SHOW_RESULT", 3, 3);
        SHOW_RESULT = r103;
        f106945a = new ThemedCompetitionStatus[]{r100, r101, r102, r103};
    }

    public static ThemedCompetitionStatus valueOf(String r100) {
        return (ThemedCompetitionStatus) r27.a.a(ThemedCompetitionStatus.class, r100);
    }

    public static ThemedCompetitionStatus[] values() {
        return (ThemedCompetitionStatus[]) f106945a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ThemedCompetitionStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
