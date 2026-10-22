package com.bytedance.android.live.profit.format.voicechat.model;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f87667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f87668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f87669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f87670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f87671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f87672f;

    public final Context getContext() {
        return this.f87667a;
    }

    public e(Context r100, String r101, String r102, d r103, long r104) {
        long r105 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "authorId");
        Intrinsics.checkNotNullParameter(r103, "startInfo");
        this.f87667a = r100;
        this.f87668b = r101;
        this.f87669c = r102;
        this.f87670d = r103;
        this.f87671e = r104;
        this.f87672f = r105;
    }
}
