package com.bytedance.android.livesdk.ktvapi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/KtvCommand;", "", "", "value", "I", "getValue", "()I", "NOTHING", "START_KTV", "EXIT_KTV", "SONG_START", "SONG_PAUSE", "SONG_RESTART", "SONG_FINISH", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvCommand extends Enum<KtvCommand> {
    public static final KtvCommand EXIT_KTV = null;
    public static final KtvCommand NOTHING = null;
    public static final KtvCommand SONG_FINISH = null;
    public static final KtvCommand SONG_PAUSE = null;
    public static final KtvCommand SONG_RESTART = null;
    public static final KtvCommand SONG_START = null;
    public static final KtvCommand START_KTV = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KtvCommand[] f142320a = null;
    private final int value;

    static {
        KtvCommand r100 = new KtvCommand("NOTHING", 0, 0);
        NOTHING = r100;
        KtvCommand r101 = new KtvCommand("START_KTV", 1, 1);
        START_KTV = r101;
        KtvCommand r102 = new KtvCommand("EXIT_KTV", 2, 2);
        EXIT_KTV = r102;
        KtvCommand r103 = new KtvCommand("SONG_START", 3, 3);
        SONG_START = r103;
        KtvCommand r104 = new KtvCommand("SONG_PAUSE", 4, 4);
        SONG_PAUSE = r104;
        KtvCommand r105 = new KtvCommand("SONG_RESTART", 5, 5);
        SONG_RESTART = r105;
        KtvCommand r106 = new KtvCommand("SONG_FINISH", 6, 6);
        SONG_FINISH = r106;
        f142320a = new KtvCommand[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static KtvCommand valueOf(String r100) {
        return (KtvCommand) a.a(KtvCommand.class, r100);
    }

    public static KtvCommand[] values() {
        return (KtvCommand[]) f142320a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public KtvCommand(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
