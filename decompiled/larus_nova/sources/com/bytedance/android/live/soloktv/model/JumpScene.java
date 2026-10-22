package com.bytedance.android.live.soloktv.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/JumpScene;", "", "", "value", "I", "getValue", "()I", "Unknown", "KTV", "Random", "RoomCard", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum JumpScene extends Enum<JumpScene> {
    public static final JumpScene KTV = null;
    public static final JumpScene Random = null;
    public static final JumpScene RoomCard = null;
    public static final JumpScene Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JumpScene[] f101376a = null;
    private final int value;

    static {
        JumpScene r100 = new JumpScene("Unknown", 0, 0);
        Unknown = r100;
        JumpScene r101 = new JumpScene("KTV", 1, 1);
        KTV = r101;
        JumpScene r102 = new JumpScene("Random", 2, 2);
        Random = r102;
        JumpScene r103 = new JumpScene("RoomCard", 3, 3);
        RoomCard = r103;
        f101376a = new JumpScene[]{r100, r101, r102, r103};
    }

    public static JumpScene valueOf(String r100) {
        return (JumpScene) r27.a.a(JumpScene.class, r100);
    }

    public static JumpScene[] values() {
        return (JumpScene[]) f101376a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public JumpScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
