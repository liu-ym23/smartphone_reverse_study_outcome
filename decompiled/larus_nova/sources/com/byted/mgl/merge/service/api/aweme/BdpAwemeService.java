package com.byted.mgl.merge.service.api.aweme;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.bytedance.bdp.serviceapi.hostimpl.account.model.BdpUserInfo;
import com.bytedance.bdp.serviceapi.hostimpl.aweme.model.AwemeAccountInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public interface BdpAwemeService extends IBdpService {

    public interface AuthResultCallBack {
        void onUserAuthorized(String r100);

        void onUserDenied(boolean r100);
    }

    public static class AuthTickerRequestResult {
        public final ScopesData normalScopesData;
        public final String ticket;

        public boolean canSkipConfirm() {
            return this.normalScopesData.canSkipConfirm;
        }

        public AuthTickerRequestResult(ScopesData r100, String r101) {
            this.normalScopesData = r100;
            this.ticket = r101;
        }
    }

    public static class AwemeOfficialAccountInfo {
        public final String mAvatar;
        public final boolean mHasFollowed;
        public final String mName;

        public AwemeOfficialAccountInfo(String r100, String r101, boolean r102) {
            this.mName = r100;
            this.mAvatar = r101;
            this.mHasFollowed = r102;
        }
    }

    public interface FetchBulletContentCallBack {
        void onFailed();

        void onSuccess(int r100, Map<String, ?> r101);
    }

    public interface FollowStatusListener {
        void onFollow(int r100);
    }

    public interface GetAwemeAccountInfoListener {
        void onResponse(AwemeAccountInfo r100);
    }

    public interface GetAwemeOfficialAccountInfoListener {
        void onResponse(AwemeOfficialAccountInfo r100);
    }

    public static final enum IMUserMock extends Enum<IMUserMock> {
        private static final /* synthetic */ IMUserMock[] $VALUES = null;
        public static final IMUserMock AVATAR_SMALL = null;
        public static final IMUserMock IS_FREQUENCY_CONTROL = null;
        public static final IMUserMock IS_FRIEND = null;
        public static final IMUserMock NICK_NAME = null;
        public static final IMUserMock SEC_UID = null;
        String value;

        static {
            IMUserMock r100 = new IMUserMock("NICK_NAME", 0, "name");
            NICK_NAME = r100;
            IMUserMock r101 = new IMUserMock("AVATAR_SMALL", 1, "avatar_url");
            AVATAR_SMALL = r101;
            IMUserMock r102 = new IMUserMock("SEC_UID", 2, "sec_uid");
            SEC_UID = r102;
            IMUserMock r103 = new IMUserMock("IS_FRIEND", 3, "is_friend");
            IS_FRIEND = r103;
            IMUserMock r104 = new IMUserMock("IS_FREQUENCY_CONTROL", 4, "is_frequency_control");
            IS_FREQUENCY_CONTROL = r104;
            $VALUES = new IMUserMock[]{r100, r101, r102, r103, r104};
        }

        public static IMUserMock[] values() {
            return (IMUserMock[]) $VALUES.clone();
        }

        public String value() {
            return this.value;
        }

        public static IMUserMock valueOf(String r100) {
            return (IMUserMock) a.a(IMUserMock.class, r100);
        }

        private IMUserMock(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public interface IOperateSceneListener {
        public static final int FAIL = -1;
        public static final int SUCCEED = 0;

        void onResult(int r100, String r101);
    }

    public interface JoinFansGroupListener {
        void onError(int r100, String r101);

        void onSuccess();
    }

    public static class ScopesData {
        final boolean canSkipConfirm;
        public final List<String> scopeNames;

        public ScopesData(List<String> r100, boolean r101) {
            this.scopeNames = r100;
            this.canSkipConfirm = r101;
        }
    }

    public interface UserInfoCallback {
        void onResult(String r100, String r101, String r102);
    }

    void checkFollowAwemeState(String r100, String r101, FollowAwemeCallback r102);

    JSONArray fetchAwemeFriendsList(String r100, int r101);

    void fetchBulletContent(int r100, int r101, Map<String, ?> r102, FetchBulletContentCallBack r103);

    void followAwemeAccountWithOutJump(String r100, String r101, int r102, int r103, int r104, String r105, int r106, String r107, FollowStatusListener r108, String r110);

    void followDesignateAwemeUser(Activity r100, String r101, FollowDesignateAwemeUserCallback r102);

    void getAwemeAccountInfo(String r100, String r101, GetAwemeAccountInfoListener r102);

    void getAwemeOfficialAccountInfo(String r100, String r101, GetAwemeOfficialAccountInfoListener r102);

    boolean getChatGroupInfo(String r100, GroupInfoCallback r101, BdpUserInfo r102);

    String getGameDetailSchema(String r100);

    void getUserInfo(String r100, UserInfoCallback r101);

    boolean hasAwemeImpl();

    boolean hasPOILocationPermission(Context r100);

    boolean isAwemeTeenMode();

    Boolean isColdBoot();

    boolean isPad();

    boolean isSupportAwemeAuthAbility();

    boolean joinChatGroup(Activity r100, String r101, boolean r102, JoinChatGroupCallback r103);

    boolean joinConversation(Map<String, String> r100, JoinConversationCallback r101, Activity r102, BdpUserInfo r103);

    void joinFansGroup(String r100, String r101, String r102, JoinFansGroupListener r103);

    void openAwemeUserProfile(Activity r100, String r101, String r102, boolean r103, boolean r104, OpenAwemeUserProfileCallback r105);

    void openCardProfilePanel(Activity r100, String r101, String r102, OnProfileCardOpenCallback r103);

    void operateScene(String r100, String r101, JSONObject r102, IOperateSceneListener r103);

    void rateAwemeOrder(Activity r100, String r101, RateAwemeOrderCallback r102);

    void requestAuth(FragmentActivity r100, String r101, AuthResultCallBack r102);

    void requestAuthCode(String r100, List<String> r101, String r102, RequestAuthCodeListener r103);

    void requestAuthScopeInfo(String r100, AuthTickerRequestResult r101, RequestAuthInfoListener r102);

    void requestAuthTicket(String r100, List<String> r101, RequestAuthTicketListener r102);

    void requestLynxPayment(Activity r100, String r101, int r102, String r103, String r104, String r105, RequestLynxPaymentCallback r106);

    void sendAuthorLiveCastingPageChanged(String r100, String r101);

    void setIsCanShowShareFlow(boolean r100);

    void showAuth(FragmentActivity r100, String r101, AuthResultCallBack r102);

    void showInvitePanel(Activity r100, HashMap<String, String> r101, HashMap<String, String> r102, OnInvitePanelCallback r103);

    Boolean skipRealNameAuth();

    void tryShowEntranceBubble(String r100, String r101, AwemeHomePageCaptionListener r102);

    void tryShowEntranceCaption(String r100, AwemeHomePageCaptionListener r101);

    void tryShowEntranceGuideAnim(String r100, String r101, AwemeHomePageSideBarEntryAnimListener r102);
}
