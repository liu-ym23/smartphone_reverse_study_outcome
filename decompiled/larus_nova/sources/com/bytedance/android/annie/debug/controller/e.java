package com.bytedance.android.annie.debug.controller;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f39387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f39388c;

    public e(Context r100, f r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "panel");
        Intrinsics.checkNotNullParameter(r102, "bizKey");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "panel");
        this.f39386a = r100;
        this.f39387b = r101;
        this.f39388c = "host";
        this.f39388c = r102;
    }
}
