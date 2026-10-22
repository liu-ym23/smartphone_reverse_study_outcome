package com.bytedance.android.livesdkapi.service;

import com.alipay.sdk.m.x.d;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/GlobalLiveLifecycle;", "Lcom/bytedance/android/livesdkapi/service/ILiveLifecycle;", "scope", "", "(I)V", ForwardDependency$ForwardLocation.FLAG, "", "getScope", "()I", "isEnter", "onEnter", "", d.f25928r, "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GlobalLiveLifecycle implements ILiveLifecycle {
    private boolean flag;
    private final int scope;

    @Override // com.bytedance.android.livesdkapi.service.ILiveLifecycle
    public void onEnter() {
        this.flag = true;
        IAcceleratedService r100 = (IAcceleratedService) k.n(IAcceleratedService.class);
        int r101 = this.scope;
        if (r101 != 1) goto L5;
        r100.onPreload(this);
        return;
    L5:
        if (r101 == 2) goto L7;
        r100.onEnter(this);
        return;
    L7:
        r100.onLaunch(this);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveLifecycle
    public void onExit() {
        IAcceleratedService r100 = (IAcceleratedService) k.n(IAcceleratedService.class);
        int r101 = this.scope;
        if (r101 != 1) goto L5;
        r100.onInLive(this);
        return;
    L5:
        if (r101 == 2) goto L7;
        r100.onExit(this);
        return;
    L7:
        r100.onShutdown(this);
    }

    public final int getScope() {
        return this.scope;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveLifecycle
    public boolean isEnter() {
        return this.flag;
    }

    public GlobalLiveLifecycle(int r100) {
        this.scope = r100;
    }
}
