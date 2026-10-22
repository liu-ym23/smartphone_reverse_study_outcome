package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenIndividualPriorityState;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f139652a = null;

    static {
        int[] r100 = new int[PublicScreenIndividualPriorityState.values().length];
        f139652a = r100;
        r100[PublicScreenIndividualPriorityState.HIT_ALL.ordinal()] = 1;
        r100[PublicScreenIndividualPriorityState.HIGH_PROTECT.ordinal()] = 2;
        r100[PublicScreenIndividualPriorityState.LOW_DEGRADE.ordinal()] = 3;
    }
}
