package com.bytedance.android.livesdkapi.util;

import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0006"}, d2 = {"isFollower", "", "Lcom/bytedance/android/live/base/model/user/User;", "isFollowingButNotFriend", "isFriend", "isStranger", "livebase-model_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class KotlinExtsKt {
    public static final boolean isFollower(User r100) {
        if (r100 == null) goto L10;
        FollowInfo r101 = r100.getFollowInfo();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.getFollowStatus() == 3) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public static final boolean isFollowingButNotFriend(User r100) {
        if (r100 == null) goto L10;
        FollowInfo r101 = r100.getFollowInfo();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.getFollowStatus() == 1) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public static final boolean isFriend(User r100) {
        if (r100 == null) goto L10;
        FollowInfo r101 = r100.getFollowInfo();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.getFollowStatus() == 2) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public static final boolean isStranger(User r100) {
        if (r100 == null) goto L15;
        FollowInfo r101 = r100.getFollowInfo();
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r101.getFollowStatus() == 1) goto L14;
        if (r101.getFollowStatus() == 2) goto L14;
        if (r101.getFollowStatus() != 0) goto L14;
        return true;
    L14:
        return false;
    L15:
        return true;
    }
}
