package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/model/MusicOperateType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "ADJUST", "PAUSE_RESTART", "CHALLENGE", "SILENCE", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MusicOperateType extends Enum<MusicOperateType> {
    public static final MusicOperateType ADJUST = null;
    public static final MusicOperateType CHALLENGE = null;
    public static final MusicOperateType PAUSE_RESTART = null;
    public static final MusicOperateType SILENCE = null;
    public static final MusicOperateType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MusicOperateType[] f144128a = null;
    private final int value;

    static {
        MusicOperateType r100 = new MusicOperateType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        MusicOperateType r101 = new MusicOperateType("ADJUST", 1, 1);
        ADJUST = r101;
        MusicOperateType r102 = new MusicOperateType("PAUSE_RESTART", 2, 2);
        PAUSE_RESTART = r102;
        MusicOperateType r103 = new MusicOperateType("CHALLENGE", 3, 3);
        CHALLENGE = r103;
        MusicOperateType r104 = new MusicOperateType("SILENCE", 4, 4);
        SILENCE = r104;
        f144128a = new MusicOperateType[]{r100, r101, r102, r103, r104};
    }

    public static MusicOperateType valueOf(String r100) {
        return (MusicOperateType) a.a(MusicOperateType.class, r100);
    }

    public static MusicOperateType[] values() {
        return (MusicOperateType[]) f144128a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MusicOperateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
