package com.bytedance.android.anniex.worker;

import android.content.Context;
import com.bytedance.vmsdk.worker.JsWorker;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f41499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JsWorker f41500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m16.b f41501c;

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f41499a = r100;
    }
}
