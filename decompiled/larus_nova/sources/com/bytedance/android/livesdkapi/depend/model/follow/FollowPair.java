package com.bytedance.android.livesdkapi.depend.model.follow;

import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdk.paas.c;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public class FollowPair implements IFollowPair {
    public static final int BEEN_FOLLOWED = 3;
    public static final int EACH_FOLLOWED = 2;
    public static final int HAS_FOLLOWED = 1;
    public static final int NOT_FOLLOW = 0;
    private HashMap<String, String> extraParams;

    @SerializedName("follow_status")
    public int followStatus;
    String fromLabel;
    private boolean isFollow;
    private IFollowPair.Type mType;
    String openUserId;

    @SerializedName("prompts")
    public String prompts;
    long roomId;
    String secUserId;
    boolean syncFollow;
    String url;
    long userId;

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public int getFollowStatus() {
        int r100 = this.followStatus;
        if (r100 >= 0) goto L5;
    L6:
        this.followStatus = 0;
    L8:
        return this.followStatus;
    L5:
        if (r100 <= 2) goto L8;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public String getUserIdString() {
        return n0.e(Long.valueOf(this.userId), this.openUserId);
    }

    public FollowPair() {
        this.syncFollow = c.f154205b;
        this.mType = IFollowPair.Type.Default;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public HashMap<String, String> getExtraParams() {
        return this.extraParams;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public String getFromLabel() {
        return this.fromLabel;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public long getRoomId() {
        return this.roomId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public String getSecUserId() {
        return this.secUserId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public IFollowPair.Type getType() {
        return this.mType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public String getUrl() {
        return this.url;
    }

    public long getUserId() {
        return this.userId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public boolean isFollow() {
        return this.isFollow;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public boolean isSyncFollow() {
        return this.syncFollow;
    }

    public void assignUserId(o0 r100) {
        this.userId = r100.getAwemeUserId();
        this.openUserId = r100.getOpenUserId();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public void setExtraParams(HashMap<String, String> r100) {
        this.extraParams = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public void setFollow(boolean r100) {
        this.isFollow = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public void setFollowStatus(int r100) {
        this.followStatus = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public void setFromLabel(String r100) {
        this.fromLabel = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public void setRoomId(long r100) {
        this.roomId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public void setSecUserId(String r100) {
        this.secUserId = r100;
    }

    public void setSyncFollow(boolean r100) {
        this.syncFollow = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public void setType(IFollowPair.Type r100) {
        this.mType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair
    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setUserId(String r100) {
        this.openUserId = r100;
        n0.d();
        this.userId = 0;
    }
}
