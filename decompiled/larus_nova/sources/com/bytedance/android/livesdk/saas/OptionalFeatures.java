package com.bytedance.android.livesdk.saas;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/saas/OptionalFeatures;", "", "ENABLE_PROFILE_PAGE", "MUTLI_TAB", "SESSION_AUTH", "ENABLE_BROADCAST", "ENABLE_XT_FOLLOW_SYNC", "GAME_CP", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OptionalFeatures extends Enum<OptionalFeatures> {
    public static final OptionalFeatures ENABLE_BROADCAST = null;
    public static final OptionalFeatures ENABLE_PROFILE_PAGE = null;
    public static final OptionalFeatures ENABLE_XT_FOLLOW_SYNC = null;
    public static final OptionalFeatures GAME_CP = null;
    public static final OptionalFeatures MUTLI_TAB = null;
    public static final OptionalFeatures SESSION_AUTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OptionalFeatures[] f157863a = null;

    static {
        OptionalFeatures r100 = new OptionalFeatures("ENABLE_PROFILE_PAGE", 0);
        ENABLE_PROFILE_PAGE = r100;
        OptionalFeatures r101 = new OptionalFeatures("MUTLI_TAB", 1);
        MUTLI_TAB = r101;
        OptionalFeatures r102 = new OptionalFeatures("SESSION_AUTH", 2);
        SESSION_AUTH = r102;
        OptionalFeatures r103 = new OptionalFeatures("ENABLE_BROADCAST", 3);
        ENABLE_BROADCAST = r103;
        OptionalFeatures r104 = new OptionalFeatures("ENABLE_XT_FOLLOW_SYNC", 4);
        ENABLE_XT_FOLLOW_SYNC = r104;
        OptionalFeatures r105 = new OptionalFeatures("GAME_CP", 5);
        GAME_CP = r105;
        f157863a = new OptionalFeatures[]{r100, r101, r102, r103, r104, r105};
    }

    public static OptionalFeatures valueOf(String r100) {
        return (OptionalFeatures) r27.a.a(OptionalFeatures.class, r100);
    }

    public static OptionalFeatures[] values() {
        return (OptionalFeatures[]) f157863a.clone();
    }

    public OptionalFeatures(String r100, int r101) {
        super(r100, r101);
    }
}
