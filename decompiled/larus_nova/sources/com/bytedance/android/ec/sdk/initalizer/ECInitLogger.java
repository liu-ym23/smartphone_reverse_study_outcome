package com.bytedance.android.ec.sdk.initalizer;

import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECInitLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f48136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f48137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f48138c;

    public ECInitLogger(int r100) {
        this.f48138c = r100;
        this.f48136a = UUID.randomUUID().toString();
        this.f48137b = LazyKt.lazy(ECInitLogger$mHandler$2.INSTANCE);
    }
}
