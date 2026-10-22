package com.bytedance.android.livesdk.interactivity.api.asr;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/asr/UserActionType;", "", "Unknown", "Welcome", "Thanks", "Congrats", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UserActionType extends Enum<UserActionType> {
    public static final UserActionType Congrats = null;
    public static final UserActionType Thanks = null;
    public static final UserActionType Unknown = null;
    public static final UserActionType Welcome = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserActionType[] f132878a = null;

    static {
        UserActionType r100 = new UserActionType("Unknown", 0);
        Unknown = r100;
        UserActionType r101 = new UserActionType("Welcome", 1);
        Welcome = r101;
        UserActionType r102 = new UserActionType("Thanks", 2);
        Thanks = r102;
        UserActionType r103 = new UserActionType("Congrats", 3);
        Congrats = r103;
        f132878a = new UserActionType[]{r100, r101, r102, r103};
    }

    public static UserActionType valueOf(String r100) {
        return (UserActionType) a.a(UserActionType.class, r100);
    }

    public static UserActionType[] values() {
        return (UserActionType[]) f132878a.clone();
    }

    public UserActionType(String r100, int r101) {
        super(r100, r101);
    }
}
