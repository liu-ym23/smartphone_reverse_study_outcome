package com.bytedance.android.livehostapi.business;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livehostapi/business/GroupInfoStruct;", "", "avatarUrl", "", "groupId", "", "groupName", "(Ljava/lang/String;JLjava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getGroupId", "()J", "getGroupName", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupInfoStruct {
    private final String avatarUrl;
    private final long groupId;
    private final String groupName;

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final long getGroupId() {
        return this.groupId;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public GroupInfoStruct(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "avatarUrl");
        Intrinsics.checkNotNullParameter(r102, "groupName");
        this.avatarUrl = r100;
        this.groupId = r101;
        this.groupName = r102;
    }
}
