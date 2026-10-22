package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l extends lh0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ih0.b f76995d;

    public static final class a {
    }

    static {
    }

    public l(Context r100, DataCenter r101, ih0.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "service");
        super(r100, r101);
        this.f76995d = r102;
    }
}
