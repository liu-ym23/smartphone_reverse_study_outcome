package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes46.dex */
public final class LynxJSRegisterUtil$registerImWrdsMessage$1 implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f78646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataCenter f78647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.dynamicframe.b f78648c;

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> a() {
        return (com.bytedance.android.live.liveinteract.jsbridge.method.y) this.f78646a.getValue();
    }

    public LynxJSRegisterUtil$registerImWrdsMessage$1(DataCenter r100, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r101) {
        this.f78647b = r100;
        this.f78648c = r101;
        this.f78646a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new LynxJSRegisterUtil$registerImWrdsMessage$1$registerMethod$2(this));
    }
}
