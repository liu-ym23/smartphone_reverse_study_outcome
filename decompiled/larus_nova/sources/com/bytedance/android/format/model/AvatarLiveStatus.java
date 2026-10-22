package com.bytedance.android.format.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/format/model/AvatarLiveStatus;", "", "", "value", "I", "getValue", "()I", "UNKOWN", "STARTING", "ESTABLISH_STREAM", "LIVING", "FINISH", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AvatarLiveStatus extends Enum<AvatarLiveStatus> {
    public static final AvatarLiveStatus ESTABLISH_STREAM = null;
    public static final AvatarLiveStatus FINISH = null;
    public static final AvatarLiveStatus LIVING = null;
    public static final AvatarLiveStatus STARTING = null;
    public static final AvatarLiveStatus UNKOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvatarLiveStatus[] f51326a = null;
    private final int value;

    static {
        AvatarLiveStatus r100 = new AvatarLiveStatus("UNKOWN", 0, 0);
        UNKOWN = r100;
        AvatarLiveStatus r101 = new AvatarLiveStatus("STARTING", 1, 1);
        STARTING = r101;
        AvatarLiveStatus r102 = new AvatarLiveStatus("ESTABLISH_STREAM", 2, 2);
        ESTABLISH_STREAM = r102;
        AvatarLiveStatus r103 = new AvatarLiveStatus("LIVING", 3, 3);
        LIVING = r103;
        AvatarLiveStatus r104 = new AvatarLiveStatus("FINISH", 4, 4);
        FINISH = r104;
        f51326a = new AvatarLiveStatus[]{r100, r101, r102, r103, r104};
    }

    public static AvatarLiveStatus valueOf(String r100) {
        return (AvatarLiveStatus) r27.a.a(AvatarLiveStatus.class, r100);
    }

    public static AvatarLiveStatus[] values() {
        return (AvatarLiveStatus[]) f51326a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AvatarLiveStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
