package com.bytedance.android.live.profile.model;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/profile/model/LifecycleStateType;", "", ErrorCode.INIT, "BEFORE_UPDATE", "UPDATE_FINISHED", "BEFORE_COMPONENT_SHOW", "COMPONENT_SHOW_FINISHED", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LifecycleStateType extends Enum<LifecycleStateType> {
    public static final LifecycleStateType BEFORE_COMPONENT_SHOW = null;
    public static final LifecycleStateType BEFORE_UPDATE = null;
    public static final LifecycleStateType COMPONENT_SHOW_FINISHED = null;
    public static final LifecycleStateType INIT = null;
    public static final LifecycleStateType UPDATE_FINISHED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LifecycleStateType[] f86057a = null;

    static {
        LifecycleStateType r100 = new LifecycleStateType(ErrorCode.INIT, 0);
        INIT = r100;
        LifecycleStateType r101 = new LifecycleStateType("BEFORE_UPDATE", 1);
        BEFORE_UPDATE = r101;
        LifecycleStateType r102 = new LifecycleStateType("UPDATE_FINISHED", 2);
        UPDATE_FINISHED = r102;
        LifecycleStateType r103 = new LifecycleStateType("BEFORE_COMPONENT_SHOW", 3);
        BEFORE_COMPONENT_SHOW = r103;
        LifecycleStateType r104 = new LifecycleStateType("COMPONENT_SHOW_FINISHED", 4);
        COMPONENT_SHOW_FINISHED = r104;
        f86057a = new LifecycleStateType[]{r100, r101, r102, r103, r104};
    }

    public static LifecycleStateType valueOf(String r100) {
        return (LifecycleStateType) r27.a.a(LifecycleStateType.class, r100);
    }

    public static LifecycleStateType[] values() {
        return (LifecycleStateType[]) f86057a.clone();
    }

    public LifecycleStateType(String r100, int r101) {
        super(r100, r101);
    }
}
