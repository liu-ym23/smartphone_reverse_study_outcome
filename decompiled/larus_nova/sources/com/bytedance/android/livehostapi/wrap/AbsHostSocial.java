package com.bytedance.android.livehostapi.wrap;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.IHostSocial;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bf\u0010gJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0016J$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0016J2\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0016J1\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u0015H\u0016J$\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H\u0016J+\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b \u0010!J$\u0010&\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00182\u0006\u0010#\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H\u0016JD\u0010'\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00182\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\u0015H\u0016¢\u0006\u0004\b'\u0010(J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0018H\u0016J \u0010-\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020\u0018H\u0016J\u0018\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.2\u0006\u0010\u0005\u001a\u000200H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u000203H\u0016J#\u00107\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b7\u00108J[\u0010B\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u00109\u001a\u00020\u00182\u0006\u0010;\u001a\u00020:2\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010<2#\u0010A\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u00060\nH\u0016J\u0080\u0001\u0010J\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010C\u001a\u00020:2\u0006\u0010E\u001a\u00020D2\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010<2:\u0010A\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u00060F2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060HH\u0016J¸\u0001\u0010T\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010K\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u00182\u0006\u0010;\u001a\u00020:2\u0014\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010<2h\u0010A\u001ad\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(P\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(Q\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(R\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00060OH\u0016J¸\u0001\u0010U\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010K\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u00182\u0006\u0010;\u001a\u00020:2\u0014\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010<2h\u0010A\u001ad\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(P\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(Q\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(R\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00060OH\u0016J8\u0010]\u001a\u00020\u00062\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010Z\u001a\u00020\u00182\u0006\u0010[\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u0018H\u0016J:\u0010e\u001a\u00020d2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020:2\u0006\u0010a\u001a\u00020\u00182\b\u0010c\u001a\u0004\u0018\u00010bH\u0016¨\u0006h"}, d2 = {"Lcom/bytedance/android/livehostapi/wrap/AbsHostSocial;", "Lcom/bytedance/android/livehostapi/business/IHostSocial;", "", "checkHostSocialValid", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams;", "params", "", "showNewInviteFriendActivity", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/Function1;", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig;", "configAction", "showInviteFriendsDialog", "showInviteFriendActivity", "", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$Friend;", "friendUidList", "inviteFriendsByIM", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lkotlin/ExtensionFunctionType;", "inviteFriendByIM", "", "", "", "queryMap", "Lio/reactivex/Observable;", "inviteFriendByCallingPush", "", "roomId", "secUid", "inviteWithCallingPush", "(Ljava/lang/Long;Ljava/lang/String;)Lio/reactivex/Observable;", "targetId", "isConversation", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$RoomInfoWrapper;", "roomInfoWrapper", "inviteWithIMMsg", "inviteFriendByIm", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "userId", "updateFriendInviteStatus", "", LynxError.LYNX_THROWABLE, "makeToastWhenNotShow", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "Lcom/bytedance/android/livehostapi/business/IHostSocial$OpenVideoCommentParams;", "tryOpenVideoCommentPanel", "detachVideoCommentPanel", "Lcom/bytedance/android/livehostapi/business/IHostSocial$PostMessageMan;", "postSeiMan", "injectSyncInfoListener", "syncInfo", "handleSyncInfo", "(Ljava/lang/String;Ljava/lang/Long;)V", "anchorID", "", "sourceScene", "", "paramMap", "Lkotlin/ParameterName;", "name", "conversationId", "onSuccess", "createCommonGroup", "groupType", "", "uidList", "Lkotlin/Function2;", "checkMsg", "Lkotlin/Function0;", "onFailed", "createCustomGroup", "conversationID", "conversationShortID", "applyUserID", "extraParamMap", "Lkotlin/Function4;", "code", "status", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "check", "joinCommonGroup", "joinKtvGroup", "Landroid/app/Activity;", "activity", "circleId", "circleName", "enterFrom", "liveType", "functionType", "showLiveCircleDetailDialog", EffectConfiguration.KEY_CURSOR, "count", "scene", "groupId", "Lcom/bytedance/android/live/base/model/user/a0;", "onResult", "Lcom/bytedance/android/live/base/model/user/c;", "loadAtFriends", "<init>", "()V", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public class AbsHostSocial implements IHostSocial {
    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public final /* synthetic */ boolean canCreateFlsRoom() {
        return IHostSocial.CC.$default$canCreateFlsRoom(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostSocial
    public void createCommonGroup(Context r100, String r101, int r102, Map<String, String> r103, Function1<? super String, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "anchorID");
        Intrinsics.checkNotNullParameter(r104, "onSuccess");
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public void createCustomGroup(Context r100, int r101, long[] r102, Map<String, String> r103, Function2<? super String, ? super String, Unit> r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "uidList");
        Intrinsics.checkNotNullParameter(r104, "onSuccess");
        Intrinsics.checkNotNullParameter(r105, "onFailed");
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public void detachVideoCommentPanel() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public void handleSyncInfo(String r100, Long r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public void injectSyncInfoListener(IHostSocial.PostMessageMan r100) {
        Intrinsics.checkNotNullParameter(r100, "postSeiMan");
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostSocial
    public void joinCommonGroup(Context r100, String r101, String r102, String r103, String r104, int r105, Map<String, String> r106, Function4<? super Integer, ? super Integer, ? super String, ? super Long, Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationID");
        Intrinsics.checkNotNullParameter(r102, "conversationShortID");
        Intrinsics.checkNotNullParameter(r103, "applyUserID");
        Intrinsics.checkNotNullParameter(r104, "anchorID");
        Intrinsics.checkNotNullParameter(r107, "onSuccess");
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostSocial
    public void joinKtvGroup(Context r100, String r101, String r102, String r103, String r104, int r105, Map<String, String> r106, Function4<? super Integer, ? super Integer, ? super String, ? super Long, Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationID");
        Intrinsics.checkNotNullParameter(r102, "conversationShortID");
        Intrinsics.checkNotNullParameter(r103, "applyUserID");
        Intrinsics.checkNotNullParameter(r104, "anchorID");
        Intrinsics.checkNotNullParameter(r107, "onSuccess");
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public void makeToastWhenNotShow(Context r100, Throwable r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r102, "userId");
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public void showLiveCircleDetailDialog(Activity r100, long r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, "circleName");
        Intrinsics.checkNotNullParameter(r103, "enterFrom");
        Intrinsics.checkNotNullParameter(r104, "liveType");
        Intrinsics.checkNotNullParameter(r105, "functionType");
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public void tryOpenVideoCommentPanel(Fragment r100, IHostSocial.OpenVideoCommentParams r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "params");
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public void updateFriendInviteStatus(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userId");
    }

    private final boolean checkHostSocialValid() {
        f2.c("该功能暂不支持，敬请期待", 0);
        return false;
    }

    public AbsHostSocial() {
        k.l(IMiddlewareHostSocial.class, this);
        k.l(IHostSocial.class, this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public Observable<Boolean> inviteFriendByCallingPush(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "queryMap");
        checkHostSocialValid();
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostSocial
    public void showNewInviteFriendActivity(IMiddlewareHostSocial.ICommonInviteParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        checkHostSocialValid();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public Observable<Boolean> inviteWithCallingPush(Long r100, String r101) {
        checkHostSocialValid();
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostSocial
    public void showInviteFriendActivity(Context r100, Function1<? super IMiddlewareHostSocial.InviteFriendsConfig, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "configAction");
        checkHostSocialValid();
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostSocial
    public void showInviteFriendsDialog(Context r100, Function1<? super IMiddlewareHostSocial.InviteFriendsConfig, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "configAction");
        checkHostSocialValid();
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostSocial
    public void inviteFriendByIM(Context r100, IBaseUser r101, Function1<? super IMiddlewareHostSocial.InviteFriendsConfig, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, "configAction");
        checkHostSocialValid();
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostSocial
    public void inviteFriendsByIM(Context r100, List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend> r101, Function1<? super IMiddlewareHostSocial.InviteFriendsConfig, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "friendUidList");
        Intrinsics.checkNotNullParameter(r102, "configAction");
        checkHostSocialValid();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public void inviteWithIMMsg(String r100, boolean r101, IMiddlewareHostSocial.InviteFriendsConfig.RoomInfoWrapper r102) {
        checkHostSocialValid();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public void inviteFriendByIm(Context r100, String r101, Boolean r102, Function1<? super IMiddlewareHostSocial.InviteFriendsConfig, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "configAction");
        checkHostSocialValid();
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSocial
    public com.bytedance.android.live.base.model.user.c loadAtFriends(Context r100, long r101, long r102, int r103, String r104, a0 r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "groupId");
        return new AnonymousClass1();
    }
}
