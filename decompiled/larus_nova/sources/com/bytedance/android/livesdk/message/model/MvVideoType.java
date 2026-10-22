package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/MvVideoType;", "", "", "value", "I", "getValue", "()I", "VIDEO_TYPE_NORMAL_MATERIAL", "VIDEO_TYPE_MV", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MvVideoType extends Enum<MvVideoType> {
    public static final MvVideoType VIDEO_TYPE_MV = null;
    public static final MvVideoType VIDEO_TYPE_NORMAL_MATERIAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MvVideoType[] f153605a = null;
    private final int value;

    static {
        MvVideoType r100 = new MvVideoType("VIDEO_TYPE_NORMAL_MATERIAL", 0, 0);
        VIDEO_TYPE_NORMAL_MATERIAL = r100;
        MvVideoType r101 = new MvVideoType("VIDEO_TYPE_MV", 1, 1);
        VIDEO_TYPE_MV = r101;
        f153605a = new MvVideoType[]{r100, r101};
    }

    public static MvVideoType valueOf(String r100) {
        return (MvVideoType) r27.a.a(MvVideoType.class, r100);
    }

    public static MvVideoType[] values() {
        return (MvVideoType[]) f153605a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MvVideoType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
