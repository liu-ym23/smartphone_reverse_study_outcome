package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdk.crash.SourceType;
import com.obric.miniapp.alarm.AccountType;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/UserType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, "AUDIENCE", AccountType.ALL, "UNKNOWN", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UserType extends Enum<UserType> {
    private static final /* synthetic */ UserType[] $VALUES = null;
    public static final UserType ALL = null;
    public static final UserType ANCHOR = null;
    public static final UserType AUDIENCE = null;
    public static final UserType UNKNOWN = null;
    private final String value;

    static {
        UserType r100 = new UserType(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 0, "anchor");
        ANCHOR = r100;
        UserType r101 = new UserType("AUDIENCE", 1, SourceType.DEFAULT);
        AUDIENCE = r101;
        UserType r102 = new UserType(AccountType.ALL, 2, "all");
        ALL = r102;
        UserType r103 = new UserType("UNKNOWN", 3, "");
        UNKNOWN = r103;
        $VALUES = new UserType[]{r100, r101, r102, r103};
    }

    public static UserType valueOf(String r100) {
        return (UserType) a.a(UserType.class, r100);
    }

    public static UserType[] values() {
        return (UserType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    private UserType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
