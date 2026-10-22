package com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/newcontainer/business/boot/room/TriggerPreloadStage;", "", "", "value", "I", "getValue", "()I", "STAGE_START_LOAD_INTERACTION", "STAGE_START_LOAD_FS", "STAGE_LOAD_FS_FINISH", "STAGE_START_LOAD_P0", "STAGE_LOAD_P0_FINISH", "STAGE_START_LOAD_P1", "STAGE_LOAD_P1_FINISH", "STAGE_START_LOAD_P2", "STAGE_LOAD_P2_FINISH", "STAGE_START_LOAD_ALL", "STAGE_LOAD_ALL_FINISH", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TriggerPreloadStage extends Enum<TriggerPreloadStage> {
    public static final TriggerPreloadStage STAGE_LOAD_ALL_FINISH = null;
    public static final TriggerPreloadStage STAGE_LOAD_FS_FINISH = null;
    public static final TriggerPreloadStage STAGE_LOAD_P0_FINISH = null;
    public static final TriggerPreloadStage STAGE_LOAD_P1_FINISH = null;
    public static final TriggerPreloadStage STAGE_LOAD_P2_FINISH = null;
    public static final TriggerPreloadStage STAGE_START_LOAD_ALL = null;
    public static final TriggerPreloadStage STAGE_START_LOAD_FS = null;
    public static final TriggerPreloadStage STAGE_START_LOAD_INTERACTION = null;
    public static final TriggerPreloadStage STAGE_START_LOAD_P0 = null;
    public static final TriggerPreloadStage STAGE_START_LOAD_P1 = null;
    public static final TriggerPreloadStage STAGE_START_LOAD_P2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerPreloadStage[] f107055a = null;
    private final int value;

    public static TriggerPreloadStage valueOf(String r100) {
        return (TriggerPreloadStage) a.a(TriggerPreloadStage.class, r100);
    }

    public static TriggerPreloadStage[] values() {
        return (TriggerPreloadStage[]) f107055a.clone();
    }

    static {
        TriggerPreloadStage r100 = new TriggerPreloadStage("STAGE_START_LOAD_INTERACTION", 0, 1);
        STAGE_START_LOAD_INTERACTION = r100;
        TriggerPreloadStage r101 = new TriggerPreloadStage("STAGE_START_LOAD_FS", 1, 2);
        STAGE_START_LOAD_FS = r101;
        TriggerPreloadStage r102 = new TriggerPreloadStage("STAGE_LOAD_FS_FINISH", 2, 3);
        STAGE_LOAD_FS_FINISH = r102;
        TriggerPreloadStage r103 = new TriggerPreloadStage("STAGE_START_LOAD_P0", 3, 4);
        STAGE_START_LOAD_P0 = r103;
        TriggerPreloadStage r104 = new TriggerPreloadStage("STAGE_LOAD_P0_FINISH", 4, 5);
        STAGE_LOAD_P0_FINISH = r104;
        TriggerPreloadStage r105 = new TriggerPreloadStage("STAGE_START_LOAD_P1", 5, 6);
        STAGE_START_LOAD_P1 = r105;
        TriggerPreloadStage r106 = new TriggerPreloadStage("STAGE_LOAD_P1_FINISH", 6, 7);
        STAGE_LOAD_P1_FINISH = r106;
        TriggerPreloadStage r107 = new TriggerPreloadStage("STAGE_START_LOAD_P2", 7, 8);
        STAGE_START_LOAD_P2 = r107;
        TriggerPreloadStage r108 = new TriggerPreloadStage("STAGE_LOAD_P2_FINISH", 8, 9);
        STAGE_LOAD_P2_FINISH = r108;
        TriggerPreloadStage r109 = new TriggerPreloadStage("STAGE_START_LOAD_ALL", 9, 10);
        STAGE_START_LOAD_ALL = r109;
        TriggerPreloadStage r110 = new TriggerPreloadStage("STAGE_LOAD_ALL_FINISH", 10, 11);
        STAGE_LOAD_ALL_FINISH = r110;
        f107055a = new TriggerPreloadStage[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public TriggerPreloadStage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
