package com.obric.cloudsdk.kv.base;

import kotlin.Metadata;

/* JADX INFO: compiled from: AbsSyncInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/obric/cloudsdk/kv/base/AbsSyncInfo;", "", "()V", "getUserId", "", "isCurrentSyncable", "", "isLogin", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbsSyncInfo {
    public abstract String getUserId();

    public boolean isCurrentSyncable() {
        return true;
    }

    public abstract boolean isLogin();

    public AbsSyncInfo() {
    }
}
