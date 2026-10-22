package com.bytedance.android.live.revenue.common.message;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes47.dex */
public abstract class DynamicMessageType extends yh6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f90878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f90879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f90880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f90881e;

    public DynamicMessageType() {
        this.f90878b = LazyKt.lazy(new DynamicMessageType$LUCKY_BOX$2(this));
        this.f90879c = LazyKt.lazy(new DynamicMessageType$LUCKY_BOX_END$2(this));
        this.f90880d = LazyKt.lazy(new DynamicMessageType$LUCKY_BOX_TEMP_STATUS$2(this));
        this.f90881e = LazyKt.lazy(new DynamicMessageType$LUCKY_BOX_REWARD_MESSAGE$2(this));
    }
}
