package com.bytedance.android.livesdk.widget;

import com.bytedance.ies.sdk.widgets.KVData;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d3<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d3 f161689a = null;

    static {
        f161689a = new d3();
    }

    public d3() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((KVData) r100, "it");
        return Boolean.TRUE;
    }
}
