package com.bytedance.android.livesdk.arch.plugin.handler;

import com.bytedance.android.livesdk.arch.lifecycle.ITbLifecycle;
import com.bytedance.android.livesdk.arch.state.source.TbRecordState;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f103838a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f103839b = null;

    static {
        int[] r100 = new int[ITbLifecycle.State.values().length];
        f103838a = r100;
        r100[ITbLifecycle.State.Created.ordinal()] = 1;
        r100[ITbLifecycle.State.Destroyed.ordinal()] = 2;
        int[] r101 = new int[TbRecordState.Action.values().length];
        f103839b = r101;
        r101[TbRecordState.Action.OfferWaitingRecord.ordinal()] = 1;
        r101[TbRecordState.Action.RemoveWaitingRecord.ordinal()] = 2;
    }
}
