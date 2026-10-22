package com.bytedance.android.live.revenue.platform.network.dynamic;

import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;

/* JADX INFO: loaded from: classes47.dex */
public final class k implements IPreviewSyncDataType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f91528a;

    @Override // com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType
    public final Class<?> getDataClass() {
        return Object.class;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType
    public final String getSyncKey() {
        return this.f91528a;
    }

    public k(String r100) {
        this.f91528a = r100;
    }
}
