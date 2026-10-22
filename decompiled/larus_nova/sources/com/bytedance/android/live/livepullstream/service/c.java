package com.bytedance.android.live.livepullstream.service;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.config.y3;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements gl0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f82514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f82515b = null;

    public c() {
    }

    static {
        f82515b = new c();
        f82514a = y3.f121651a.getValue();
    }

    public final boolean a() {
        return f82514a.booleanValue();
    }

    public static boolean d(Bundle r100) {
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.LIVE_NORMAL) != VSConstants.LIVE_NORMAL) goto L9;
        return r100.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_PSEUDO_LIVING, false);
    }

    public final boolean c(long r100, Bundle r101) {
        return LivePlatformPlayerManager.c(r100, d(r101)).r(r101);
    }

    public final boolean b(Context r100, long r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return LivePlatformPlayerManager.c(r101, d(r102)).e(r100, r102);
    }
}
