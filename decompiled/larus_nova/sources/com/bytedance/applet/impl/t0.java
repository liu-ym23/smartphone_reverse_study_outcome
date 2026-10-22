package com.bytedance.applet.impl;

import com.bytedance.ai.bridge.service.IHostUserDepend;
import com.larus.platform.service.AccountService;

/* JADX INFO: loaded from: classes14.dex */
public final class t0 implements IHostUserDepend {
    public t0() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostUserDepend
    public final void getBoundPhone() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostUserDepend
    public final void getUserModelExt() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostUserDepend
    public final String getAvatarURL() {
        return AccountService.f365697a.s();
    }

    @Override // com.bytedance.ai.bridge.service.IHostUserDepend
    public final String getNickname() {
        return AccountService.f365697a.getNickname();
    }

    @Override // com.bytedance.ai.bridge.service.IHostUserDepend
    public final String getSecUid() {
        return AccountService.f365697a.getSecUserId();
    }

    @Override // com.bytedance.ai.bridge.service.IHostUserDepend
    public final String getUniqueID() {
        return com.larus.platform.service.o.f365780a.getUserUniqueID();
    }

    @Override // com.bytedance.ai.bridge.service.IHostUserDepend
    public final String getUserId() {
        return com.larus.platform.service.o.f365780a.getUserID();
    }

    @Override // com.bytedance.ai.bridge.service.IHostUserDepend
    public final boolean hasLogin() {
        return AccountService.f365697a.isLogin().booleanValue();
    }
}
