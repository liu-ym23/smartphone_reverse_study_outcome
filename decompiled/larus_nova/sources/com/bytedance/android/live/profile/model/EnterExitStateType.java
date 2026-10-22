package com.bytedance.android.live.profile.model;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profile/model/EnterExitStateType;", "", ErrorCode.INIT, "WILL_ENTER", "ENTER_START", "ENTER_END", "EXIT_START", "EXIT_END", "SLIDE_DISMISS", "COMPLETE", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EnterExitStateType extends Enum<EnterExitStateType> {
    public static final EnterExitStateType COMPLETE = null;
    public static final EnterExitStateType ENTER_END = null;
    public static final EnterExitStateType ENTER_START = null;
    public static final EnterExitStateType EXIT_END = null;
    public static final EnterExitStateType EXIT_START = null;
    public static final EnterExitStateType INIT = null;
    public static final EnterExitStateType SLIDE_DISMISS = null;
    public static final EnterExitStateType WILL_ENTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnterExitStateType[] f86056a = null;

    static {
        EnterExitStateType r100 = new EnterExitStateType(ErrorCode.INIT, 0);
        INIT = r100;
        EnterExitStateType r101 = new EnterExitStateType("WILL_ENTER", 1);
        WILL_ENTER = r101;
        EnterExitStateType r102 = new EnterExitStateType("ENTER_START", 2);
        ENTER_START = r102;
        EnterExitStateType r103 = new EnterExitStateType("ENTER_END", 3);
        ENTER_END = r103;
        EnterExitStateType r104 = new EnterExitStateType("EXIT_START", 4);
        EXIT_START = r104;
        EnterExitStateType r105 = new EnterExitStateType("EXIT_END", 5);
        EXIT_END = r105;
        EnterExitStateType r106 = new EnterExitStateType("SLIDE_DISMISS", 6);
        SLIDE_DISMISS = r106;
        EnterExitStateType r107 = new EnterExitStateType("COMPLETE", 7);
        COMPLETE = r107;
        f86056a = new EnterExitStateType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static EnterExitStateType valueOf(String r100) {
        return (EnterExitStateType) r27.a.a(EnterExitStateType.class, r100);
    }

    public static EnterExitStateType[] values() {
        return (EnterExitStateType[]) f86056a.clone();
    }

    public EnterExitStateType(String r100, int r101) {
        super(r100, r101);
    }
}
