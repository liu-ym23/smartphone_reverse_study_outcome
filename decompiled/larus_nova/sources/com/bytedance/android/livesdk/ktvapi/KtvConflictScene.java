package com.bytedance.android.livesdk.ktvapi;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/KtvConflictScene;", "", "SCENE_NONE", "SCENE_ANCHOR_GAME", "SCENE_DRAW_AND_GUESS", "SCENE_SOUND_EFFECT", "SCENE_KTV", "SCENE_KSONG", "SCENE_KTV_CHORUS", "SCENE_INTERACTIVE_SONG", "SCENE_PAUSE_LIVE", "SCENE_WGAME", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvConflictScene extends Enum<KtvConflictScene> {
    public static final KtvConflictScene SCENE_ANCHOR_GAME = null;
    public static final KtvConflictScene SCENE_DRAW_AND_GUESS = null;
    public static final KtvConflictScene SCENE_INTERACTIVE_SONG = null;
    public static final KtvConflictScene SCENE_KSONG = null;
    public static final KtvConflictScene SCENE_KTV = null;
    public static final KtvConflictScene SCENE_KTV_CHORUS = null;
    public static final KtvConflictScene SCENE_NONE = null;
    public static final KtvConflictScene SCENE_PAUSE_LIVE = null;
    public static final KtvConflictScene SCENE_SOUND_EFFECT = null;
    public static final KtvConflictScene SCENE_WGAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KtvConflictScene[] f142290a = null;

    static {
        KtvConflictScene r100 = new KtvConflictScene("SCENE_NONE", 0);
        SCENE_NONE = r100;
        KtvConflictScene r101 = new KtvConflictScene("SCENE_ANCHOR_GAME", 1);
        SCENE_ANCHOR_GAME = r101;
        KtvConflictScene r102 = new KtvConflictScene("SCENE_DRAW_AND_GUESS", 2);
        SCENE_DRAW_AND_GUESS = r102;
        KtvConflictScene r103 = new KtvConflictScene("SCENE_SOUND_EFFECT", 3);
        SCENE_SOUND_EFFECT = r103;
        KtvConflictScene r104 = new KtvConflictScene("SCENE_KTV", 4);
        SCENE_KTV = r104;
        KtvConflictScene r105 = new KtvConflictScene("SCENE_KSONG", 5);
        SCENE_KSONG = r105;
        KtvConflictScene r106 = new KtvConflictScene("SCENE_KTV_CHORUS", 6);
        SCENE_KTV_CHORUS = r106;
        KtvConflictScene r107 = new KtvConflictScene("SCENE_INTERACTIVE_SONG", 7);
        SCENE_INTERACTIVE_SONG = r107;
        KtvConflictScene r108 = new KtvConflictScene("SCENE_PAUSE_LIVE", 8);
        SCENE_PAUSE_LIVE = r108;
        KtvConflictScene r109 = new KtvConflictScene("SCENE_WGAME", 9);
        SCENE_WGAME = r109;
        f142290a = new KtvConflictScene[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static KtvConflictScene valueOf(String r100) {
        return (KtvConflictScene) a.a(KtvConflictScene.class, r100);
    }

    public static KtvConflictScene[] values() {
        return (KtvConflictScene[]) f142290a.clone();
    }

    public KtvConflictScene(String r100, int r101) {
        super(r100, r101);
    }
}
