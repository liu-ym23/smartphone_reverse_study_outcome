package com.bytedance.android.gamecp.host_api.user;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/user/UserType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, "AUDIENCE", "GUEST", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UserType extends Enum<UserType> {
    public static final UserType ANCHOR = null;
    public static final UserType AUDIENCE = null;
    public static final UserType GUEST = null;
    public static final UserType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserType[] f57432a = null;
    private final int value;

    static {
        UserType r100 = new UserType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        UserType r101 = new UserType(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 1, 1);
        ANCHOR = r101;
        UserType r102 = new UserType("AUDIENCE", 2, 2);
        AUDIENCE = r102;
        UserType r103 = new UserType("GUEST", 3, 3);
        GUEST = r103;
        f57432a = new UserType[]{r100, r101, r102, r103};
    }

    public static UserType valueOf(String r100) {
        return (UserType) a.a(UserType.class, r100);
    }

    public static UserType[] values() {
        return (UserType[]) f57432a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public UserType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
