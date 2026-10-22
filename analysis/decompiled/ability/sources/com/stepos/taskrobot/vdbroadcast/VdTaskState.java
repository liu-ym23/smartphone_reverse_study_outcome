package com.stepos.taskrobot.vdbroadcast;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/taskrobot/vdbroadcast/VdTaskState;", "", "vdbroadcast_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VdTaskState {

    /* renamed from: a, reason: collision with root package name */
    public static final VdTaskState f4076a;
    public static final VdTaskState b;
    public static final /* synthetic */ VdTaskState[] c;

    static {
        VdTaskState vdTaskState = new VdTaskState("STARTING", 0);
        f4076a = vdTaskState;
        VdTaskState vdTaskState2 = new VdTaskState("RUNNING", 1);
        b = vdTaskState2;
        VdTaskState[] vdTaskStateArr = {vdTaskState, vdTaskState2};
        c = vdTaskStateArr;
        a.a(vdTaskStateArr);
    }

    public static VdTaskState valueOf(String str) {
        return (VdTaskState) Enum.valueOf(VdTaskState.class, str);
    }

    public static VdTaskState[] values() {
        return (VdTaskState[]) c.clone();
    }
}
