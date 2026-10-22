package com.bytedance.android.gamecp.common.track;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f56803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<View> f56804c;

    public g(String r100, f r101, WeakReference<View> r102) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        Intrinsics.checkNotNullParameter(r101, "paramNode");
        Intrinsics.checkNotNullParameter(r102, "rootView");
        this.f56802a = r100;
        this.f56803b = r101;
        this.f56804c = r102;
    }
}
