package com.bytedance.android.livesdk.maker;

import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes10.dex */
public final class HonorStreamKit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f153492a;

    public final Method a() {
        return (Method) this.f153492a.getValue();
    }

    public HonorStreamKit() {
        this.f153492a = LazyKt.lazy(new HonorStreamKit$method$2(this));
    }
}
