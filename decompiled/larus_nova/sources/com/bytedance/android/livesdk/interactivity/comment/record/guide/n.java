package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f136182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f136183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.comment.highlight.b f136184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f136185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f136186e;

    public final Context getContext() {
        return this.f136182a;
    }

    public n(Context r100, DataCenter r101, com.bytedance.android.livesdk.interactivity.comment.highlight.b r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "highlightData");
        this.f136182a = r100;
        this.f136183b = r101;
        this.f136184c = r102;
        this.f136185d = r103;
        this.f136186e = r104;
    }
}
