package com.bytedance.android.livehostapi.platform.flavor.xt;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.livehostapi.platform.base.IBaseHostUser;
import com.bytedance.android.livehostapi.platform.depend.user.FollowChangedCallback;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import com.bytedance.android.livehostapi.platform.depend.user.IResultCallback;
import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostUserForXT extends IService, IBaseHostUser {
    public static final int FROM_FOLLOW = 1;
    public static final int FROM_LIVE_COMMENT_PROMOTION = 18;
    public static final int FROM_REDPACKET = 5;
    public static final int MESSAGE_NICKNAME_DUPLICATE = 20014;
    public static final int MESSAGE_NICKNAME_DUPLICATE_2 = 20041;

    String getBindPhoneNumber();

    IUser getCurUser();

    long getCurUserId();

    boolean isLogin();

    void login(FragmentActivity r100, ILoginCallback r101, String r102, String r103, int r104, String r105, String r106, String r107);

    void onFollowStatusChanged(int r100, long r101);

    void registerCurrentUserUpdateListener(UserChangedCallback r100);

    void registerFollowStatusListener(FollowChangedCallback r100);

    void unFollowWithConfirm(Activity r100, int r101, long r102, IResultCallback r103);

    void unRegisterCurrentUserUpdateListener(UserChangedCallback r100);

    void unRegisterFollowStatusListener(FollowChangedCallback r100);

    void updateUser(IUser r100);
}
