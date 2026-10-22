package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.profile.model.EnterExitStateType;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f86516a = null;

    static {
        int[] r100 = new int[EnterExitStateType.values().length];
        f86516a = r100;
        r100[EnterExitStateType.ENTER_START.ordinal()] = 1;
        r100[EnterExitStateType.ENTER_END.ordinal()] = 2;
        r100[EnterExitStateType.EXIT_START.ordinal()] = 3;
        r100[EnterExitStateType.EXIT_END.ordinal()] = 4;
        r100[EnterExitStateType.SLIDE_DISMISS.ordinal()] = 5;
    }
}
