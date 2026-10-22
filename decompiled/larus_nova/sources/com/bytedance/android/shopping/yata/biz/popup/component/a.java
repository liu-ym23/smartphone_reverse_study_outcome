package com.bytedance.android.shopping.yata.biz.popup.component;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.shopping.yata.biz.popup.a f187554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hl3.c f187555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f187556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final il3.a f187557d;

    public final Context getContext() {
        return this.f187556c;
    }

    public a(Context r100, il3.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f187556c = r100;
        this.f187557d = r101;
    }

    public final <O> O c(String r100, O r101) {
        return (O) this.f187557d.a(r100, r101);
    }
}
