package com.bytedance.android.livesdk.feed;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class t0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f124481a = null;

    static {
        f124481a = new t0();
    }

    public t0() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
        xs2.b.a().post(new uv1.e(0));
        return;
    }
}
