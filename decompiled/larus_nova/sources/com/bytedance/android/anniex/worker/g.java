package com.bytedance.android.anniex.worker;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g extends me7.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f41503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ue7.d f41504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PlatformType f41505g;

    public final Context getContext() {
        return this.f41503e;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final ue7.d getJsEventDelegate() {
        return this.f41504f;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final PlatformType getPlatformType() {
        return this.f41505g;
    }

    public g(String r100, View r101, Context r102, ue7.d r103) {
        Intrinsics.checkNotNullParameter(r100, "containerID");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "jsEventDelegate");
        Intrinsics.checkNotNullParameter("", "namespace");
        super(r100, r101, "");
        this.f41503e = r102;
        this.f41504f = r103;
        this.f41505g = PlatformType.WORKER;
    }
}
