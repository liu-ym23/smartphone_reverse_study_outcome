package com.bytedance.android.livesdk.followtool.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/followtool/api/RelationSyncSwitch;", "", "followerSync", "", "followedSync", "followerScope", "anchorLiveSync", "(ZZZZ)V", "getAnchorLiveSync", "()Z", "setAnchorLiveSync", "(Z)V", "getFollowedSync", "setFollowedSync", "getFollowerScope", "setFollowerScope", "getFollowerSync", "setFollowerSync", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class RelationSyncSwitch {

    @SerializedName("anchor_live_sync")
    private boolean anchorLiveSync;

    @SerializedName("followed_sync")
    private boolean followedSync;

    @SerializedName("follower_scope")
    private boolean followerScope;

    @SerializedName("follower_sync")
    private boolean followerSync;

    public RelationSyncSwitch() {
        this(false, false, false, false, 15, null);
    }

    public final boolean getAnchorLiveSync() {
        return this.anchorLiveSync;
    }

    public final boolean getFollowedSync() {
        return this.followedSync;
    }

    public final boolean getFollowerScope() {
        return this.followerScope;
    }

    public final boolean getFollowerSync() {
        return this.followerSync;
    }

    public final void setAnchorLiveSync(boolean r100) {
        this.anchorLiveSync = r100;
    }

    public final void setFollowedSync(boolean r100) {
        this.followedSync = r100;
    }

    public final void setFollowerScope(boolean r100) {
        this.followerScope = r100;
    }

    public final void setFollowerSync(boolean r100) {
        this.followerSync = r100;
    }

    public RelationSyncSwitch(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.followerSync = r100;
        this.followedSync = r101;
        this.followerScope = r102;
        this.anchorLiveSync = r103;
    }

    public /* synthetic */ RelationSyncSwitch(boolean r100, boolean r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
