package com.obric.cloudsdk.kv.base;

import com.android.contacts.common.SimContactsConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: StubSyncInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/cloudsdk/kv/base/StubSyncInfo;", "Lcom/obric/cloudsdk/kv/base/AbsSyncInfo;", "()V", SimContactsConstants.STR_TAG, "", "getUserId", "isCurrentSyncable", "", "isLogin", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StubSyncInfo extends AbsSyncInfo {
    private final String tag;

    public StubSyncInfo() {
        this.tag = "StubSyncInfo";
    }

    @Override // com.obric.cloudsdk.kv.base.AbsSyncInfo
    public String getUserId() {
        KvLog.INSTANCE.w(this.tag, "getUserId, stub!!!");
        return "";
    }

    @Override // com.obric.cloudsdk.kv.base.AbsSyncInfo
    public boolean isLogin() {
        KvLog.INSTANCE.w(this.tag, "isLogin, stub!!!");
        return false;
    }

    @Override // com.obric.cloudsdk.kv.base.AbsSyncInfo
    public boolean isCurrentSyncable() {
        KvLog.INSTANCE.w(this.tag, "isCurrentSyncable, stub!!!");
        return super.isCurrentSyncable();
    }
}
