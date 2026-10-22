package com.bytedance.android.live.room;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/room/PermissionGrantStatus;", "", "", "value", "I", "getValue", "()I", "GRANT_DONE", "GRANT_DOING", "GRANT_SUCCESS", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PermissionGrantStatus extends Enum<PermissionGrantStatus> {
    public static final PermissionGrantStatus GRANT_DOING = null;
    public static final PermissionGrantStatus GRANT_DONE = null;
    public static final PermissionGrantStatus GRANT_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionGrantStatus[] f98859a = null;
    private final int value;

    static {
        PermissionGrantStatus r100 = new PermissionGrantStatus("GRANT_DONE", 0, 0);
        GRANT_DONE = r100;
        PermissionGrantStatus r101 = new PermissionGrantStatus("GRANT_DOING", 1, 1);
        GRANT_DOING = r101;
        PermissionGrantStatus r102 = new PermissionGrantStatus("GRANT_SUCCESS", 2, 2);
        GRANT_SUCCESS = r102;
        f98859a = new PermissionGrantStatus[]{r100, r101, r102};
    }

    public static PermissionGrantStatus valueOf(String r100) {
        return (PermissionGrantStatus) r27.a.a(PermissionGrantStatus.class, r100);
    }

    public static PermissionGrantStatus[] values() {
        return (PermissionGrantStatus[]) f98859a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PermissionGrantStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
