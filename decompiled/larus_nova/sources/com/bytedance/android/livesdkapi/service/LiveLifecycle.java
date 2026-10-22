package com.bytedance.android.livesdkapi.service;

import com.alipay.sdk.m.x.d;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/LiveLifecycle;", "Lcom/bytedance/android/livesdkapi/service/ILiveLifecycle;", "()V", ForwardDependency$ForwardLocation.FLAG, "", "isEnter", "onEnter", "", d.f25928r, "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLifecycle implements ILiveLifecycle {
    private boolean flag;

    public LiveLifecycle() {
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveLifecycle
    public void onEnter() {
        this.flag = true;
        IAcceleratedService r100 = (IAcceleratedService) k.f(IAcceleratedService.class);
        if (r100 == null) goto L6;
        r100.onEnter(this);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveLifecycle
    public void onExit() {
        IAcceleratedService r100 = (IAcceleratedService) k.f(IAcceleratedService.class);
        if (r100 == null) goto L6;
        r100.onExit(this);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveLifecycle
    public boolean isEnter() {
        return this.flag;
    }
}
