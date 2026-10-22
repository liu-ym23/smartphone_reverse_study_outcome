package com.bytedance.android.livesdk.chatroom.model.interact;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/ThemedCompetitionRole;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "PERFORMER", "CONTESTANT", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ThemedCompetitionRole extends Enum<ThemedCompetitionRole> {
    public static final ThemedCompetitionRole CONTESTANT = null;
    public static final ThemedCompetitionRole PERFORMER = null;
    public static final ThemedCompetitionRole UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemedCompetitionRole[] f106944a = null;
    private final int value;

    static {
        ThemedCompetitionRole r100 = new ThemedCompetitionRole("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ThemedCompetitionRole r101 = new ThemedCompetitionRole("PERFORMER", 1, 1);
        PERFORMER = r101;
        ThemedCompetitionRole r102 = new ThemedCompetitionRole("CONTESTANT", 2, 2);
        CONTESTANT = r102;
        f106944a = new ThemedCompetitionRole[]{r100, r101, r102};
    }

    public static ThemedCompetitionRole valueOf(String r100) {
        return (ThemedCompetitionRole) r27.a.a(ThemedCompetitionRole.class, r100);
    }

    public static ThemedCompetitionRole[] values() {
        return (ThemedCompetitionRole[]) f106944a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ThemedCompetitionRole(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
