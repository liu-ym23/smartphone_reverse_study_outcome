package com.bytedance.android.livesdk.floatview.inner;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f125224a;

    public o(k r100) {
        this.f125224a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L7;
        ALogger.i("VideoWatchingInnerFloatWindowView", "on firstFrame");
        this.f125224a.f125217y.onPlayDisplayed();
        return;
    }
}
