package com.bytedance.android.gamecp.common.track;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<GPCommonFilterName, com.bytedance.android.gamecp.common.track.filter.d<?>> f56794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f56795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f56796c;

    public f(HashMap<GPCommonFilterName, com.bytedance.android.gamecp.common.track.filter.d<?>> r100, h r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "paramFiltersMap");
        Intrinsics.checkNotNullParameter(r101, "inheritConfig");
        this.f56794a = r100;
        this.f56795b = r101;
        this.f56796c = r102;
    }
}
