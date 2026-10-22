package com.bytedance.android.livehostapi.business;

import android.content.Context;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002-.J]\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\rH&J1\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u0016H&J7\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u0016H&J¸\u0001\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2h\u0010\f\u001ad\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00030 H&J¸\u0001\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2h\u0010'\u001ad\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00030 H&J)\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u0016H&J)\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u0016H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&¨\u0006/À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial;", "Lcom/bytedance/android/live/base/IService;", "createCommonGroup", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "anchorID", "", "sourceScene", "", "paramMap", "", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "conversationId", "inviteFriendByIM", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "configAction", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig;", "Lkotlin/ExtensionFunctionType;", "inviteFriendsByIM", "friendUidList", "", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$Friend;", "joinCommonGroup", "conversationID", "conversationShortID", "applyUserID", "extraParamMap", "Lkotlin/Function4;", "code", "status", a.KEY_STATUS_MSG, "", "check", "joinKtvGroup", "onResult", "showInviteFriendActivity", "showInviteFriendsDialog", "showNewInviteFriendActivity", "params", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams;", "ICommonInviteParams", "InviteFriendsConfig", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareHostSocial extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IMiddlewareHostSocial$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void createCommonGroup$default(IMiddlewareHostSocial r100, Context r101, String r102, int r103, Map r110, Function1 r111, int r112, Object r113) {
            if (r113 != null) goto L9;
            if ((r112 & 8) == 0) goto L6;
            r110 = null;
        L6:
            r100.createCommonGroup(r101, r102, r103, r110, r111);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createCommonGroup");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void createCommonGroup$default(IMiddlewareHostSocial r100, Context r101, String r102, int r103, Map r104, Function1 r105, int r106, Object r107) {
            CC.createCommonGroup$default(r100, r101, r102, r103, r104, r105, r106, r107);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004;<=>B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR*\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R*\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\u001a\u00102\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams;", "", "()V", "bottomBtnText", "", "getBottomBtnText", "()Ljava/lang/String;", "setBottomBtnText", "(Ljava/lang/String;)V", "clickCallback", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$IClickCallback;", "getClickCallback", "()Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$IClickCallback;", "setClickCallback", "(Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$IClickCallback;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "disableUserList", "", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$ISelectedContact;", "getDisableUserList", "()Ljava/util/List;", "setDisableUserList", "(Ljava/util/List;)V", "enterFrom", "getEnterFrom", "setEnterFrom", "enterMethod", "getEnterMethod", "setEnterMethod", "extMap", "", "getExtMap", "()Ljava/util/Map;", "setExtMap", "(Ljava/util/Map;)V", "initHeight", "", "getInitHeight", "()Ljava/lang/Integer;", "setInitHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mobMap", "getMobMap", "setMobMap", "scene", "getScene", "setScene", "selectType", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$ISelectTypeEnum;", "getSelectType", "()Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$ISelectTypeEnum;", "setSelectType", "(Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$ISelectTypeEnum;)V", "IChatSceneTypeEnum", "IClickCallback", "ISelectTypeEnum", "ISelectedContact", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ICommonInviteParams {
        private String bottomBtnText;
        private IClickCallback clickCallback;
        private Context context;
        private List<ISelectedContact> disableUserList;
        private String enterFrom;
        private String enterMethod;
        private Map<String, String> extMap;
        private Integer initHeight;
        private Map<String, String> mobMap;
        private String scene;
        private ISelectTypeEnum selectType;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$IChatSceneTypeEnum;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SINGLE_PLAY_GAME_INVITE", "GROUP_PLAY_GAME_INVITE", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum IChatSceneTypeEnum extends Enum<IChatSceneTypeEnum> {
            private static final /* synthetic */ IChatSceneTypeEnum[] $VALUES = null;
            public static final IChatSceneTypeEnum GROUP_PLAY_GAME_INVITE = null;
            public static final IChatSceneTypeEnum SINGLE_PLAY_GAME_INVITE = null;
            private final String value;

            static {
                IChatSceneTypeEnum r100 = new IChatSceneTypeEnum("SINGLE_PLAY_GAME_INVITE", 0, "single_play_game_invite");
                SINGLE_PLAY_GAME_INVITE = r100;
                IChatSceneTypeEnum r101 = new IChatSceneTypeEnum("GROUP_PLAY_GAME_INVITE", 1, "group_play_game_invite");
                GROUP_PLAY_GAME_INVITE = r101;
                $VALUES = new IChatSceneTypeEnum[]{r100, r101};
            }

            public static IChatSceneTypeEnum valueOf(String r100) {
                return (IChatSceneTypeEnum) r27.a.a(IChatSceneTypeEnum.class, r100);
            }

            public static IChatSceneTypeEnum[] values() {
                return (IChatSceneTypeEnum[]) $VALUES.clone();
            }

            public final String getValue() {
                return this.value;
            }

            private IChatSceneTypeEnum(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$IClickCallback;", "", "onInvite", "", "list", "", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$ISelectedContact;", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public interface IClickCallback {
            void onInvite(List<ISelectedContact> r100);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$ISelectTypeEnum;", "", "key", "", "(Ljava/lang/String;II)V", "getKey", "()I", "DEFAULT", "MULTI_SELECT_RIGHT", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum ISelectTypeEnum extends Enum<ISelectTypeEnum> {
            private static final /* synthetic */ ISelectTypeEnum[] $VALUES = null;
            public static final ISelectTypeEnum DEFAULT = null;
            public static final ISelectTypeEnum MULTI_SELECT_RIGHT = null;
            private final int key;

            static {
                ISelectTypeEnum r100 = new ISelectTypeEnum("DEFAULT", 0, 0);
                DEFAULT = r100;
                ISelectTypeEnum r101 = new ISelectTypeEnum("MULTI_SELECT_RIGHT", 1, 1);
                MULTI_SELECT_RIGHT = r101;
                $VALUES = new ISelectTypeEnum[]{r100, r101};
            }

            public static ISelectTypeEnum valueOf(String r100) {
                return (ISelectTypeEnum) r27.a.a(ISelectTypeEnum.class, r100);
            }

            public static ISelectTypeEnum[] values() {
                return (ISelectTypeEnum[]) $VALUES.clone();
            }

            public final int getKey() {
                return this.key;
            }

            private ISelectTypeEnum(String r100, int r101, int r102) {
                super(r100, r101);
                this.key = r102;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$ICommonInviteParams$ISelectedContact;", "", "uid", "", "secUid", "(Ljava/lang/String;Ljava/lang/String;)V", "getSecUid", "()Ljava/lang/String;", "getUid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ISelectedContact {
            private final String secUid;
            private final String uid;

            /* JADX WARN: Multi-variable type inference failed */
            public ISelectedContact() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ ISelectedContact copy$default(ISelectedContact r100, String r101, String r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.uid;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.secUid;
            L9:
                return r100.copy(r101, r102);
            }

            public final String component1() {
                return this.uid;
            }

            public final String component2() {
                return this.secUid;
            }

            public final ISelectedContact copy(String r100, String r101) {
                return new ISelectedContact(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof ISelectedContact) == false) goto L10;
                ISelectedContact r101 = (ISelectedContact) r100;
                if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                String r100 = this.uid;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.secUid;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "ISelectedContact(uid=" + this.uid + ", secUid=" + this.secUid + ')';
            }

            public final String getSecUid() {
                return this.secUid;
            }

            public final String getUid() {
                return this.uid;
            }

            public ISelectedContact(String r100, String r101) {
                this.uid = r100;
                this.secUid = r101;
            }

            public /* synthetic */ ISelectedContact(String r100, String r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        public ICommonInviteParams() {
            this.scene = "";
            this.selectType = ISelectTypeEnum.DEFAULT;
        }

        public final String getBottomBtnText() {
            return this.bottomBtnText;
        }

        public final IClickCallback getClickCallback() {
            return this.clickCallback;
        }

        public final Context getContext() {
            return this.context;
        }

        public final List<ISelectedContact> getDisableUserList() {
            return this.disableUserList;
        }

        public final String getEnterFrom() {
            return this.enterFrom;
        }

        public final String getEnterMethod() {
            return this.enterMethod;
        }

        public final Map<String, String> getExtMap() {
            return this.extMap;
        }

        public final Integer getInitHeight() {
            return this.initHeight;
        }

        public final Map<String, String> getMobMap() {
            return this.mobMap;
        }

        public final String getScene() {
            return this.scene;
        }

        public final ISelectTypeEnum getSelectType() {
            return this.selectType;
        }

        public final void setBottomBtnText(String r100) {
            this.bottomBtnText = r100;
        }

        public final void setClickCallback(IClickCallback r100) {
            this.clickCallback = r100;
        }

        public final void setContext(Context r100) {
            this.context = r100;
        }

        public final void setDisableUserList(List<ISelectedContact> r100) {
            this.disableUserList = r100;
        }

        public final void setEnterFrom(String r100) {
            this.enterFrom = r100;
        }

        public final void setEnterMethod(String r100) {
            this.enterMethod = r100;
        }

        public final void setExtMap(Map<String, String> r100) {
            this.extMap = r100;
        }

        public final void setInitHeight(Integer r100) {
            this.initHeight = r100;
        }

        public final void setMobMap(Map<String, String> r100) {
            this.mobMap = r100;
        }

        public final void setScene(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.scene = r100;
        }

        public final void setSelectType(ISelectTypeEnum r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.selectType = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001:\u0004qrstR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u0018\u0010\u0011\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0007R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R\u001a\u0010 \u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u001a\u0010#\u001a\u0004\u0018\u00010$X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010\u0007R\u001a\u0010/\u001a\u0004\u0018\u000100X¦\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00105\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0005\"\u0004\b7\u0010\u0007R&\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000109X¦\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010>\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0005\"\u0004\b@\u0010\u0007R\u001a\u0010A\u001a\u0004\u0018\u00010BX¦\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u0004\u0018\u00010HX¦\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\bN\u0010\u0005\"\u0004\bO\u0010\u0007R\u001a\u0010P\u001a\u0004\u0018\u00010QX¦\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u0004\u0018\u00010QX¦\u000e¢\u0006\f\u001a\u0004\bW\u0010S\"\u0004\bX\u0010UR\u001a\u0010Y\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\bZ\u0010\u0005\"\u0004\b[\u0010\u0007R\u001a\u0010\\\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b]\u0010\u0005\"\u0004\b^\u0010\u0007R\u001a\u0010_\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b`\u0010\u0005\"\u0004\ba\u0010\u0007R\u001a\u0010b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\bc\u0010\u0005\"\u0004\bd\u0010\u0007R$\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020Q0fX¦\u000e¢\u0006\f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0018\u0010k\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bl\u0010\u0005\"\u0004\bm\u0010\u0007R\u0018\u0010n\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bo\u0010\u0005\"\u0004\bp\u0010\u0007¨\u0006uÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig;", "", ReportConstant.COMMON_ACTION_TYPE, "", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "enterFrom", "getEnterFrom", "setEnterFrom", "enterFromMerge", "getEnterFromMerge", "setEnterFromMerge", "enterMethod", "getEnterMethod", "setEnterMethod", "functionType", "getFunctionType", "setFunctionType", "hint", "getHint", "setHint", "inviteBtnTextDisabled", "getInviteBtnTextDisabled", "setInviteBtnTextDisabled", "inviteBtnTextEnabled", "getInviteBtnTextEnabled", "setInviteBtnTextEnabled", "joinBtnTextDisabled", "getJoinBtnTextDisabled", "setJoinBtnTextDisabled", "joinBtnTextEnabled", "getJoinBtnTextEnabled", "setJoinBtnTextEnabled", "listener", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$Listener;", "getListener", "()Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$Listener;", "setListener", "(Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$Listener;)V", "liveType", "getLiveType", "setLiveType", "logPb", "getLogPb", "setLogPb", "maxSelectNumber", "", "getMaxSelectNumber", "()Ljava/lang/Integer;", "setMaxSelectNumber", "(Ljava/lang/Integer;)V", "panelTitle", "getPanelTitle", "setPanelTitle", "reportMap", "", "getReportMap", "()Ljava/util/Map;", "setReportMap", "(Ljava/util/Map;)V", "requestId", "getRequestId", "setRequestId", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "roomType", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$RoomType;", "getRoomType", "()Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$RoomType;", "setRoomType", "(Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$RoomType;)V", "schema", "getSchema", "setSchema", "showInnerPush", "", "getShowInnerPush", "()Ljava/lang/Boolean;", "setShowInnerPush", "(Ljava/lang/Boolean;)V", "showShareItem", "getShowShareItem", "setShowShareItem", "subtitlePart1", "getSubtitlePart1", "setSubtitlePart1", "subtitlePart2", "getSubtitlePart2", "setSubtitlePart2", "titlePart1", "getTitlePart1", "setTitlePart1", "titlePart2", "getTitlePart2", "setTitlePart2", "userListFilter", "Lkotlin/Function1;", "getUserListFilter", "()Lkotlin/jvm/functions/Function1;", "setUserListFilter", "(Lkotlin/jvm/functions/Function1;)V", "userType", "getUserType", "setUserType", "videoId", "getVideoId", "setVideoId", "Friend", "Listener", "RoomInfoWrapper", "RoomType", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface InviteFriendsConfig {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0012\u0010\u000f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR\u0018\u0010\u0010\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\n¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$Friend;", "", "enableInvite", "", "getEnableInvite", "()Ljava/lang/Boolean;", "setEnableInvite", "(Ljava/lang/Boolean;)V", "isFirstInvite", "", "()Ljava/lang/String;", "isMutualStatus", "isNormalUser", "()Z", "isOnline", "isTogetherStatus", "secUid", "getSecUid", "setSecUid", "(Ljava/lang/String;)V", "togetherDays", "", "getTogetherDays", "()I", "uid", "getUid", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public interface Friend {
            Boolean getEnableInvite();

            String getSecUid();

            int getTogetherDays();

            String getUid();

            String isFirstInvite();

            String isMutualStatus();

            boolean isNormalUser();

            Boolean isOnline();

            String isTogetherStatus();

            void setEnableInvite(Boolean r100);

            void setSecUid(String r100);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J6\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u001e\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\fH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u001e\u0010\u000e\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$Listener;", "", "onDismiss", "", "params", "", "", "onInvite", "friendList", "", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$Friend;", "callback", "Lkotlin/Function2;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", SendEventContainerMethodParamModel.EventKinds.onShow, "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public interface Listener {

            /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IMiddlewareHostSocial$InviteFriendsConfig$Listener$-CC, reason: invalid class name */
            public final /* synthetic */ class CC {
                public static void $default$onDismiss(Listener r100) {
                }

                public static void $default$onDismiss(Listener r100, Map r101) {
                }

                public static void $default$onInvite(Listener r100, List r101, Function2 r102) {
                    Intrinsics.checkNotNullParameter(r101, "friendList");
                    Intrinsics.checkNotNullParameter(r102, "callback");
                }

                public static void $default$onShow(Listener r100) {
                }

                public static void $default$onShow(Listener r100, Map r101) {
                }

                public static /* synthetic */ void access$onDismiss$jd(Listener r100) {
                    $default$onDismiss(r100);
                }

                public static /* synthetic */ void access$onShow$jd(Listener r100) {
                    $default$onShow(r100);
                }

                public static /* synthetic */ void access$onDismiss$jd(Listener r100, Map r101) {
                    $default$onDismiss(r100, r101);
                }

                public static /* synthetic */ void access$onShow$jd(Listener r100, Map r101) {
                    $default$onShow(r100, r101);
                }

                public static /* synthetic */ void access$onInvite$jd(Listener r100, List r101, Function2 r102) {
                    $default$onInvite(r100, r101, r102);
                }
            }

            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
            public static final class DefaultImpls {
                public static void onDismiss(Listener r100) {
                    CC.access$onDismiss$jd(r100);
                }

                public static void onShow(Listener r100) {
                    CC.access$onShow$jd(r100);
                }

                public static void onDismiss(Listener r100, Map<String, String> r101) {
                    CC.access$onDismiss$jd(r100, r101);
                }

                public static void onShow(Listener r100, Map<String, String> r101) {
                    CC.access$onShow$jd(r100, r101);
                }

                public static void onInvite(Listener r100, List<? extends Friend> r101, Function2<? super List<? extends Friend>, ? super IRoom, Unit> r102) {
                    CC.access$onInvite$jd(r100, r101, r102);
                }
            }

            void onDismiss();

            void onDismiss(Map<String, String> r100);

            void onInvite(List<? extends Friend> r100, Function2<? super List<? extends Friend>, ? super IRoom, Unit> r101);

            void onShow();

            void onShow(Map<String, String> r100);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$RoomInfoWrapper;", "", "ownerName", "", "getOwnerName", "()Ljava/lang/String;", "setOwnerName", "(Ljava/lang/String;)V", "roomId", "getRoomId", "setRoomId", "roomOwnerId", "getRoomOwnerId", "setRoomOwnerId", "roomOwnerSecId", "getRoomOwnerSecId", "setRoomOwnerSecId", "roomPrivacy", "", "getRoomPrivacy", "()Ljava/lang/Long;", "setRoomPrivacy", "(Ljava/lang/Long;)V", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public interface RoomInfoWrapper {
            String getOwnerName();

            String getRoomId();

            String getRoomOwnerId();

            String getRoomOwnerSecId();

            Long getRoomPrivacy();

            void setOwnerName(String r100);

            void setRoomId(String r100);

            void setRoomOwnerId(String r100);

            void setRoomOwnerSecId(String r100);

            void setRoomPrivacy(Long r100);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostSocial$InviteFriendsConfig$RoomType;", "", "(Ljava/lang/String;I)V", "VIDEO_CHAT", "VOICE_CHAT", "KTV", "SHORT_VIDEO", "FAMILIAR_KEV", "AUDIENCE", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum RoomType extends Enum<RoomType> {
            private static final /* synthetic */ RoomType[] $VALUES = null;
            public static final RoomType AUDIENCE = null;
            public static final RoomType FAMILIAR_KEV = null;
            public static final RoomType KTV = null;
            public static final RoomType SHORT_VIDEO = null;
            public static final RoomType VIDEO_CHAT = null;
            public static final RoomType VOICE_CHAT = null;

            static {
                RoomType r100 = new RoomType("VIDEO_CHAT", 0);
                VIDEO_CHAT = r100;
                RoomType r101 = new RoomType("VOICE_CHAT", 1);
                VOICE_CHAT = r101;
                RoomType r102 = new RoomType("KTV", 2);
                KTV = r102;
                RoomType r103 = new RoomType("SHORT_VIDEO", 3);
                SHORT_VIDEO = r103;
                RoomType r104 = new RoomType("FAMILIAR_KEV", 4);
                FAMILIAR_KEV = r104;
                RoomType r105 = new RoomType("AUDIENCE", 5);
                AUDIENCE = r105;
                $VALUES = new RoomType[]{r100, r101, r102, r103, r104, r105};
            }

            public static RoomType valueOf(String r100) {
                return (RoomType) r27.a.a(RoomType.class, r100);
            }

            public static RoomType[] values() {
                return (RoomType[]) $VALUES.clone();
            }

            private RoomType(String r100, int r101) {
                super(r100, r101);
            }
        }

        String getActionType();

        String getEnterFrom();

        String getEnterFromMerge();

        String getEnterMethod();

        String getFunctionType();

        String getHint();

        String getInviteBtnTextDisabled();

        String getInviteBtnTextEnabled();

        String getJoinBtnTextDisabled();

        String getJoinBtnTextEnabled();

        Listener getListener();

        String getLiveType();

        String getLogPb();

        Integer getMaxSelectNumber();

        String getPanelTitle();

        Map<String, String> getReportMap();

        String getRequestId();

        IRoom getRoom();

        RoomType getRoomType();

        String getSchema();

        Boolean getShowInnerPush();

        Boolean getShowShareItem();

        String getSubtitlePart1();

        String getSubtitlePart2();

        String getTitlePart1();

        String getTitlePart2();

        Function1<String, Boolean> getUserListFilter();

        String getUserType();

        String getVideoId();

        void setActionType(String r100);

        void setEnterFrom(String r100);

        void setEnterFromMerge(String r100);

        void setEnterMethod(String r100);

        void setFunctionType(String r100);

        void setHint(String r100);

        void setInviteBtnTextDisabled(String r100);

        void setInviteBtnTextEnabled(String r100);

        void setJoinBtnTextDisabled(String r100);

        void setJoinBtnTextEnabled(String r100);

        void setListener(Listener r100);

        void setLiveType(String r100);

        void setLogPb(String r100);

        void setMaxSelectNumber(Integer r100);

        void setPanelTitle(String r100);

        void setReportMap(Map<String, String> r100);

        void setRequestId(String r100);

        void setRoom(IRoom r100);

        void setRoomType(RoomType r100);

        void setSchema(String r100);

        void setShowInnerPush(Boolean r100);

        void setShowShareItem(Boolean r100);

        void setSubtitlePart1(String r100);

        void setSubtitlePart2(String r100);

        void setTitlePart1(String r100);

        void setTitlePart2(String r100);

        void setUserListFilter(Function1<? super String, Boolean> r100);

        void setUserType(String r100);

        void setVideoId(String r100);
    }

    void createCommonGroup(Context r100, String r101, int r102, Map<String, String> r103, Function1<? super String, Unit> r104);

    void inviteFriendByIM(Context r100, IBaseUser r101, Function1<? super InviteFriendsConfig, Unit> r102);

    void inviteFriendsByIM(Context r100, List<? extends InviteFriendsConfig.Friend> r101, Function1<? super InviteFriendsConfig, Unit> r102);

    void joinCommonGroup(Context r100, String r101, String r102, String r103, String r104, int r105, Map<String, String> r106, Function4<? super Integer, ? super Integer, ? super String, ? super Long, Unit> r107);

    void joinKtvGroup(Context r100, String r101, String r102, String r103, String r104, int r105, Map<String, String> r106, Function4<? super Integer, ? super Integer, ? super String, ? super Long, Unit> r107);

    void showInviteFriendActivity(Context r100, Function1<? super InviteFriendsConfig, Unit> r101);

    void showInviteFriendsDialog(Context r100, Function1<? super InviteFriendsConfig, Unit> r101);

    void showNewInviteFriendActivity(ICommonInviteParams r100);
}
