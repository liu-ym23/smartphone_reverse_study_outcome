package com.bytedance.android.live.liveinteract.interactivesong.logger;

import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/logger/UserType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, "ADMIN", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UserType extends Enum<UserType> {
    public static final UserType ADMIN = null;
    public static final UserType ANCHOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserType[] f74046a = null;
    private final String value;

    static {
        UserType r100 = new UserType(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 0, "anchor");
        ANCHOR = r100;
        UserType r101 = new UserType("ADMIN", 1, UserGroupScene.DEFAULT_NAME_SPACE);
        ADMIN = r101;
        f74046a = new UserType[]{r100, r101};
    }

    public static UserType valueOf(String r100) {
        return (UserType) a.a(UserType.class, r100);
    }

    public static UserType[] values() {
        return (UserType[]) f74046a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public UserType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
