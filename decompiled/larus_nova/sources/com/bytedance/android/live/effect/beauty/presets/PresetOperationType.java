package com.bytedance.android.live.effect.beauty.presets;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/PresetOperationType;", "", ErrorCode.INIT, "ADD_PRESET", "DELETE_PRESET", "RENAME_PRESET", "SELECT_PRESET", "EDIT_MODE", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PresetOperationType extends Enum<PresetOperationType> {
    public static final PresetOperationType ADD_PRESET = null;
    public static final PresetOperationType DELETE_PRESET = null;
    public static final PresetOperationType EDIT_MODE = null;
    public static final PresetOperationType INIT = null;
    public static final PresetOperationType RENAME_PRESET = null;
    public static final PresetOperationType SELECT_PRESET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PresetOperationType[] f67466a = null;

    static {
        PresetOperationType r100 = new PresetOperationType(ErrorCode.INIT, 0);
        INIT = r100;
        PresetOperationType r101 = new PresetOperationType("ADD_PRESET", 1);
        ADD_PRESET = r101;
        PresetOperationType r102 = new PresetOperationType("DELETE_PRESET", 2);
        DELETE_PRESET = r102;
        PresetOperationType r103 = new PresetOperationType("RENAME_PRESET", 3);
        RENAME_PRESET = r103;
        PresetOperationType r104 = new PresetOperationType("SELECT_PRESET", 4);
        SELECT_PRESET = r104;
        PresetOperationType r105 = new PresetOperationType("EDIT_MODE", 5);
        EDIT_MODE = r105;
        f67466a = new PresetOperationType[]{r100, r101, r102, r103, r104, r105};
    }

    public static PresetOperationType valueOf(String r100) {
        return (PresetOperationType) r27.a.a(PresetOperationType.class, r100);
    }

    public static PresetOperationType[] values() {
        return (PresetOperationType[]) f67466a.clone();
    }

    public PresetOperationType(String r100, int r101) {
        super(r100, r101);
    }
}
