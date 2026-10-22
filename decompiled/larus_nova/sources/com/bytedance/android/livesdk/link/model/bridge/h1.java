package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareInviteContent;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent;
import com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdk.link.model.u5;
import com.bytedance.android.livesdk.message.linker.LinkerLockPositionContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkRoomFightReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerFollowStrongGuideContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerInvitePrepareContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLiveCoreBizTagChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLowBalanceForPaidLinkmicContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUILayoutChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerAudienceWaitingListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerAvatarAuditContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnlargeUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInitChatRoomContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerRemoveWaitingUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000ø\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 î\u00012\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003:\u0002ï\u0001J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0014\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\u00060\u0004j\u0002`\"8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0010\u001a\u0004\b#\u0010\fR\u0014\u0010'\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\fR$\u0010.\u001a\u0004\u0018\u00010(8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\u0010\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u00104\u001a\u0004\u0018\u00010/8&@&X¦\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010:\u001a\u0004\u0018\u0001058&@&X¦\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010@\u001a\u0004\u0018\u00010;8&@&X¦\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\tR\u001c\u0010G\u001a\u0004\u0018\u00010C8&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0010\u001a\u0004\bD\u0010ER\u001c\u0010L\u001a\u0004\u0018\u00010H8&X§\u0004¢\u0006\f\u0012\u0004\bK\u0010\u0010\u001a\u0004\bI\u0010JR\u001c\u0010Q\u001a\u0004\u0018\u00010M8&X§\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0010\u001a\u0004\bN\u0010OR\u001a\u0010V\u001a\u00020R8&X§\u0004¢\u0006\f\u0012\u0004\bU\u0010\u0010\u001a\u0004\bS\u0010TR\u001c\u0010[\u001a\u0004\u0018\u00010W8&X§\u0004¢\u0006\f\u0012\u0004\bZ\u0010\u0010\u001a\u0004\bX\u0010YR\u001c\u0010`\u001a\u0004\u0018\u00010\\8&X§\u0004¢\u0006\f\u0012\u0004\b_\u0010\u0010\u001a\u0004\b]\u0010^R\u001c\u0010e\u001a\u0004\u0018\u00010a8&X§\u0004¢\u0006\f\u0012\u0004\bd\u0010\u0010\u001a\u0004\bb\u0010cR\u001c\u0010j\u001a\u0004\u0018\u00010f8&X§\u0004¢\u0006\f\u0012\u0004\bi\u0010\u0010\u001a\u0004\bg\u0010hR\u001c\u0010o\u001a\u0004\u0018\u00010k8&X§\u0004¢\u0006\f\u0012\u0004\bn\u0010\u0010\u001a\u0004\bl\u0010mR\u001c\u0010t\u001a\u0004\u0018\u00010p8&X§\u0004¢\u0006\f\u0012\u0004\bs\u0010\u0010\u001a\u0004\bq\u0010rR\u001c\u0010y\u001a\u0004\u0018\u00010u8&X§\u0004¢\u0006\f\u0012\u0004\bx\u0010\u0010\u001a\u0004\bv\u0010wR\u0014\u0010}\u001a\u00020z8&X¦\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010~8&X§\u0004¢\u0006\u000e\u0012\u0005\b\u0081\u0001\u0010\u0010\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001f\u0010\u0087\u0001\u001a\u00030\u0083\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b\u0086\u0001\u0010\u0010\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R!\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0088\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b\u008b\u0001\u0010\u0010\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R!\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008d\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b\u0090\u0001\u0010\u0010\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R!\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0092\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b\u0095\u0001\u0010\u0010\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R!\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0097\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b\u009a\u0001\u0010\u0010\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R!\u0010 \u0001\u001a\u0005\u0018\u00010\u009c\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b\u009f\u0001\u0010\u0010\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R!\u0010¥\u0001\u001a\u0005\u0018\u00010¡\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b¤\u0001\u0010\u0010\u001a\u0006\b¢\u0001\u0010£\u0001R!\u0010ª\u0001\u001a\u0005\u0018\u00010¦\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b©\u0001\u0010\u0010\u001a\u0006\b§\u0001\u0010¨\u0001R!\u0010¯\u0001\u001a\u0005\u0018\u00010«\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b®\u0001\u0010\u0010\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R!\u0010´\u0001\u001a\u0005\u0018\u00010°\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b³\u0001\u0010\u0010\u001a\u0006\b±\u0001\u0010²\u0001R!\u0010¹\u0001\u001a\u0005\u0018\u00010µ\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b¸\u0001\u0010\u0010\u001a\u0006\b¶\u0001\u0010·\u0001R\u0018\u0010½\u0001\u001a\u00030º\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b»\u0001\u0010¼\u0001R\u001a\u0010Á\u0001\u001a\u0005\u0018\u00010¾\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b¿\u0001\u0010À\u0001R\u001a\u0010Å\u0001\u001a\u0005\u0018\u00010Â\u00018&X¦\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u001a\u0010É\u0001\u001a\u0005\u0018\u00010Æ\u00018&X¦\u0004¢\u0006\b\u001a\u0006\bÇ\u0001\u0010È\u0001R\u001a\u0010Í\u0001\u001a\u0005\u0018\u00010Ê\u00018&X¦\u0004¢\u0006\b\u001a\u0006\bË\u0001\u0010Ì\u0001R!\u0010Ò\u0001\u001a\u0005\u0018\u00010Î\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\bÑ\u0001\u0010\u0010\u001a\u0006\bÏ\u0001\u0010Ð\u0001R!\u0010×\u0001\u001a\u0005\u0018\u00010Ó\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\bÖ\u0001\u0010\u0010\u001a\u0006\bÔ\u0001\u0010Õ\u0001R!\u0010Ü\u0001\u001a\u0005\u0018\u00010Ø\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\bÛ\u0001\u0010\u0010\u001a\u0006\bÙ\u0001\u0010Ú\u0001R!\u0010á\u0001\u001a\u0005\u0018\u00010Ý\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\bà\u0001\u0010\u0010\u001a\u0006\bÞ\u0001\u0010ß\u0001R!\u0010æ\u0001\u001a\u0005\u0018\u00010â\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\bå\u0001\u0010\u0010\u001a\u0006\bã\u0001\u0010ä\u0001R+\u0010í\u0001\u001a\u0005\u0018\u00010ç\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\bì\u0001\u0010\u0010\u001a\u0006\bè\u0001\u0010é\u0001\"\u0006\bê\u0001\u0010ë\u0001¨\u0006ð\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/h1;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/u3;", "", "", "ntpDiff", "getReceiveNtpTimeFlex", "", "getFromChannelFlex", "()I", "fromChannelFlex", "getTimestampFlex", "()J", "timestampFlex", "getScene", "getScene$annotations", "()V", "scene", "getLinkerId", "getLinkerId$annotations", "linkerId", "Lcom/bytedance/android/livesdk/link/model/bridge/f1;", "getEnter", "()Lcom/bytedance/android/livesdk/link/model/bridge/f1;", "getEnter$annotations", "enter", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUILayoutChangeContent;", "getLinkerUILayoutChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUILayoutChangeContent;", "linkerUILayoutChangeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerInvitePrepareContent;", "getLinkerInvitePrepareContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerInvitePrepareContent;", "linkerInvitePrepareContent", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getType2", "getType2$annotations", "type2", "getMessageId3", "messageId3", "Lcom/bytedance/android/live/base/model/data/h;", "getLinkRoomFightInviteContent", "()Lcom/bytedance/android/live/base/model/data/h;", "setLinkRoomFightInviteContent", "(Lcom/bytedance/android/live/base/model/data/h;)V", "getLinkRoomFightInviteContent$annotations", "linkRoomFightInviteContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkRoomFightReplyContent;", "getLinkRoomFightReplyContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkRoomFightReplyContent;", "setLinkRoomFightReplyContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkRoomFightReplyContent;)V", "linkRoomFightReplyContent", "Lcom/bytedance/android/live/base/model/data/i;", "getLinkerCrossRoomUpdateContentExt", "()Lcom/bytedance/android/live/base/model/data/i;", "setLinkerCrossRoomUpdateContentExt", "(Lcom/bytedance/android/live/base/model/data/i;)V", "linkerCrossRoomUpdateContentExt", "Lcom/bytedance/android/live/base/model/data/g;", "getLinkRoomFightCancelInviteContent", "()Lcom/bytedance/android/live/base/model/data/g;", "setLinkRoomFightCancelInviteContent", "(Lcom/bytedance/android/live/base/model/data/g;)V", "linkRoomFightCancelInviteContent", "getMType", "mType", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;", "getLeave", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;", "getLeave$annotations", "leave", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent;", "getMKickOut", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent;", "getMKickOut$annotations", "mKickOut", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;", "getMUpdateUser", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;", "getMUpdateUser$annotations", "mUpdateUser", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;", "getMLinkerSysKickOutContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;", "getMLinkerSysKickOutContent$annotations", "mLinkerSysKickOutContent", "Lcom/bytedance/android/livesdk/link/model/ILinkerUpdateLinkTypeApplyContent;", "getUpdateLinkTypeApplyContent", "()Lcom/bytedance/android/livesdk/link/model/ILinkerUpdateLinkTypeApplyContent;", "getUpdateLinkTypeApplyContent$annotations", "updateLinkTypeApplyContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeReplyContent;", "getUpdateLinkTypeReplyContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeReplyContent;", "getUpdateLinkTypeReplyContent$annotations", "updateLinkTypeReplyContent", "Lcom/bytedance/android/livesdk/link/model/u5;", "getAnchorStreamSwitchContent", "()Lcom/bytedance/android/livesdk/link/model/u5;", "getAnchorStreamSwitchContent$annotations", "anchorStreamSwitchContent", "Lcom/bytedance/android/live/base/model/data/j;", "getGuestInviteContent", "()Lcom/bytedance/android/live/base/model/data/j;", "getGuestInviteContent$annotations", "guestInviteContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerFollowStrongGuideContent;", "getMFollowStrongGuideContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerFollowStrongGuideContent;", "getMFollowStrongGuideContent$annotations", "mFollowStrongGuideContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLowBalanceForPaidLinkmicContent;", "getMLowBalanceForPaidLinkContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLowBalanceForPaidLinkmicContent;", "getMLowBalanceForPaidLinkContent$annotations", "mLowBalanceForPaidLinkContent", "Lcom/bytedance/android/livesdk/message/linker/d;", "getMChangePlayModeContent", "()Lcom/bytedance/android/livesdk/message/linker/d;", "getMChangePlayModeContent$annotations", "mChangePlayModeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLinkedListChangeContent;", "getMLinkedListChange", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLinkedListChangeContent;", "mLinkedListChange", "Lcom/bytedance/android/livesdk/message/linker/k;", "getLinkerEnlargeGuestInviteContent", "()Lcom/bytedance/android/livesdk/message/linker/k;", "getLinkerEnlargeGuestInviteContent$annotations", "linkerEnlargeGuestInviteContent", "Lcom/bytedance/android/livesdk/message/linker/g;", "getLinkerEnlargeGuestReplyContent", "()Lcom/bytedance/android/livesdk/message/linker/g;", "getLinkerEnlargeGuestReplyContent$annotations", "linkerEnlargeGuestReplyContent", "Lcom/bytedance/android/livesdk/message/linker/f;", "getLinkerEnlargeGuestApplyContent", "()Lcom/bytedance/android/livesdk/message/linker/f;", "getLinkerEnlargeGuestApplyContent$annotations", "linkerEnlargeGuestApplyContent", "Lcom/bytedance/android/livesdk/link/model/l6;", "getLinkerResumeAudienceContent", "()Lcom/bytedance/android/livesdk/link/model/l6;", "getLinkerResumeAudienceContent$annotations", "linkerResumeAudienceContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerBattleConnectContent;", "getLinkerBattleConnectContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerBattleConnectContent;", "getLinkerBattleConnectContent$annotations", "linkerBattleConnectContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerChangeMediaInfoContent;", "getLinkerChangeMediaInfoContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerChangeMediaInfoContent;", "getLinkerChangeMediaInfoContent$annotations", "linkerChangeMediaInfoContent", "Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "getLinkerBaseInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "getLinkerBaseInfo$annotations", "linkerBaseInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRemoveWaitingUserContent;", "getLinkerRemoveWaitingUserContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRemoveWaitingUserContent;", "getLinkerRemoveWaitingUserContent$annotations", "linkerRemoveWaitingUserContent", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareInviteContent;", "getLinkerPrepareInviteContent", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareInviteContent;", "getLinkerPrepareInviteContent$annotations", "linkerPrepareInviteContent", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContent;", "getLinkerPrepareReplyContent", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContent;", "getLinkerPrepareReplyContent$annotations", "linkerPrepareReplyContent", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getPublicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getPublicAreaCommon$annotations", "publicAreaCommon", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent;", "getRtcActionContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent;", "getRtcActionContent$annotations", "rtcActionContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAvatarAuditContent;", "getAvatarAuditContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAvatarAuditContent;", "avatarAuditContent", "Lcom/bytedance/android/livesdk/message/linker/i;", "getApplyStrongReminderContent", "()Lcom/bytedance/android/livesdk/message/linker/i;", "applyStrongReminderContent", "Lcom/bytedance/android/livesdk/message/linker/LinkerLockPositionContent;", "getLockPositionContent", "()Lcom/bytedance/android/livesdk/message/linker/LinkerLockPositionContent;", "lockPositionContent", "Lcom/bytedance/android/livesdk/message/linker/j;", "getLinkerDegradeAlertContent", "()Lcom/bytedance/android/livesdk/message/linker/j;", "linkerDegradeAlertContent", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContent;", "getLinkerConfirmUnsilenceContent", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContent;", "linkerConfirmUnsilenceContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInitChatRoomContent;", "getLinkerInitChatRoomContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInitChatRoomContent;", "getLinkerInitChatRoomContent$annotations", "linkerInitChatRoomContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAudienceWaitingListChangeContent;", "getAudienceWaitingListChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAudienceWaitingListChangeContent;", "getAudienceWaitingListChangeContent$annotations", "audienceWaitingListChangeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContent;", "getUpdateLinkTypeForceOpenCameraContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContent;", "getUpdateLinkTypeForceOpenCameraContent$annotations", "updateLinkTypeForceOpenCameraContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnlargeUpdateContent;", "getLinkerEnlargeUpdateContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnlargeUpdateContent;", "getLinkerEnlargeUpdateContent$annotations", "linkerEnlargeUpdateContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerClientUIInfoChangeContent;", "getLinkerClientUIInfoChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerClientUIInfoChangeContent;", "getLinkerClientUIInfoChangeContent$annotations", "linkerClientUIInfoChangeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLiveCoreBizTagChangeContent;", "getLinkerLiveCoreBizTagChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLiveCoreBizTagChangeContent;", "setLinkerLiveCoreBizTagChangeContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLiveCoreBizTagChangeContent;)V", "getLinkerLiveCoreBizTagChangeContent$annotations", "linkerLiveCoreBizTagChangeContent", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h1 extends vh7.c<h1>, u3 {
    public static final a Companion = null;
    public static final int LINKER_APPLY = 4;
    public static final int LINKER_BAN = 15;
    public static final int LINKER_CANCEL_APPLY = 14;
    public static final int LINKER_CANCEL_INVITE = 9;
    public static final int LINKER_CLOSE = 2;
    public static final int LINKER_CREATE = 1;
    public static final int LINKER_DISPATCH_ITEM = 16;
    public static final int LINKER_ENTER = 6;
    public static final int LINKER_INVITE = 3;
    public static final int LINKER_KICK_OUT = 13;
    public static final int LINKER_LEAVE = 7;
    public static final int LINKER_LINKED_CHANGE = 11;
    public static final int LINKER_LOCK_POSITION = 26;
    public static final int LINKER_PERMIT = 8;
    public static final int LINKER_REPLY = 5;
    public static final int LINKER_SYS_KICK_OUT = 101;
    public static final int LINKER_UPDATE_USER = 12;
    public static final int LINKER_WAITING_CHANGE = 10;
    public static final int TYPE_ANCHOR_STREAM_SWITCH = 24;
    public static final int TYPE_ANCHOR_UPDATE_LAYOUT = 51;
    public static final int TYPE_ANCHOR_UPDATE_LINKMIC_CONFIG = 50;
    public static final int TYPE_APPLY_RANK_CHANGE = 52;
    public static final int TYPE_APPLY_STRONG_REMINDER = 23;
    public static final int TYPE_APPlY_EXPIRED = 22;
    public static final int TYPE_CHANGE_MEDIA_INFO = 53;
    public static final int TYPE_CROSS_ROOM_RTC_INFO = 49;
    public static final int TYPE_DEGRADE_ALERT = 35;
    public static final int TYPE_ENLARGE_GUEST_APPLY = 38;
    public static final int TYPE_ENLARGE_GUEST_INVITE = 36;
    public static final int TYPE_ENLARGE_GUEST_REPLY = 37;
    public static final int TYPE_FOLLOW_STRONG_GUIDE_CONTENT = 27;
    public static final int TYPE_FORCE_OPEN_CAMERA_CONTENT = 69;
    public static final int TYPE_GUEST_EXIT_CAST_SCREEN = 30;
    public static final int TYPE_INIT_CHAT_ROOM = 67;
    public static final int TYPE_LINKER_AUDIENCE_WAITING_LIST_CHANGE = 68;
    public static final int TYPE_LINKER_AVATAR_AUDIT_CONTENT = 20;
    public static final int TYPE_LINKER_CHANGE_MULTI_PK_TEAM_INFO = 42;
    public static final int TYPE_LINKER_CHANGE_PLAY_MODE = 33;
    public static final int TYPE_LINKER_CLICK_SCREEN = 25;
    public static final int TYPE_LINKER_CLIENT_UI_INFO_CHANGE = 71;
    public static final int TYPE_LINKER_CONFIRM_UNSILENCE = 59;
    public static final int TYPE_LINKER_CROSS_ROOM_UPDATE = 41;
    public static final int TYPE_LINKER_ENLARGE_UPDATE = 70;
    public static final int TYPE_LINKER_LIVE_CORE_BIZ_TAG_CHANGE = 72;
    public static final int TYPE_LINKER_PREPARE_INVITE = 57;
    public static final int TYPE_LINKER_PREPARE_REPLY = 58;
    public static final int TYPE_LINKER_SHARE_VIDEO_IM = 28;
    public static final int TYPE_LINKER_SWITCH_SCENE = 31;
    public static final int TYPE_LINKER_UILAYOUT_CHANGE = 54;
    public static final int TYPE_LINKER_UPDATE_LINK_TYPE_APPLY = 18;
    public static final int TYPE_LINKER_UPDATE_LINK_TYPE_REPLY = 19;
    public static final int TYPE_LINKER_VIOLATION_REMINDER = 17;
    public static final int TYPE_LINK_BATTLE_CONNECT = 47;
    public static final int TYPE_LINK_CANCEL_PREPARE_APPLY = 40;
    public static final int TYPE_LINK_PHASE = 32;
    public static final int TYPE_LINK_PREPARE_APPLY = 39;
    public static final int TYPE_LINK_RESUME_AUDIENCE = 46;
    public static final int TYPE_LINK_ROOM_FIGHT_CANCEL_INVITE = 45;
    public static final int TYPE_LINK_ROOM_FIGHT_INVITE = 43;
    public static final int TYPE_LINK_ROOM_FIGHT_REPLY = 44;
    public static final int TYPE_LINK_ROOM_FIGHT_ROOM_UPDATE = 41;
    public static final int TYPE_LOW_BALANCE_FOR_PAID_LINKMIC = 34;
    public static final int TYPE_REMOVE_WAITING_USER = 56;
    public static final int TYPE_RTC_ACTION = 64;
    public static final int TYPE_UPDATE_WAITING_USER_OFFSET = 55;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147090a = null;

        public a() {
        }

        static {
            f147090a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f147090a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "anchor_stream_switch_content")
    u5 getAnchorStreamSwitchContent();

    com.bytedance.android.livesdk.message.linker.i getApplyStrongReminderContent();

    @FieldName(name = "audience_waiting_list_change")
    LinkerAudienceWaitingListChangeContent getAudienceWaitingListChangeContent();

    LinkerAvatarAuditContent getAvatarAuditContent();

    @FieldName(name = "enter_content")
    f1 getEnter();

    /* synthetic */ String getExtraStr();

    int getFromChannelFlex();

    @FieldName(name = "guest_invite_content")
    com.bytedance.android.live.base.model.data.j getGuestInviteContent();

    @FieldName(name = "leave_content")
    ILinkerLeaveContentBridge getLeave();

    com.bytedance.android.live.base.model.data.g getLinkRoomFightCancelInviteContent();

    @FieldName(name = "cross_room_link_invite_content")
    com.bytedance.android.live.base.model.data.h getLinkRoomFightInviteContent();

    ILinkRoomFightReplyContent getLinkRoomFightReplyContent();

    @FieldName(name = "linker_base_info")
    com.bytedance.android.live.liveinteract.plantform.model.q getLinkerBaseInfo();

    @FieldName(name = "linker_battle_connect_content")
    ILinkerBattleConnectContent getLinkerBattleConnectContent();

    @FieldName(name = "change_media_content")
    ILinkerChangeMediaInfoContent getLinkerChangeMediaInfoContent();

    @FieldName(name = "linker_client_ui_info_change_content")
    ILinkerClientUIInfoChangeContent getLinkerClientUIInfoChangeContent();

    LinkerConfirmUnsilenceContent getLinkerConfirmUnsilenceContent();

    com.bytedance.android.live.base.model.data.i getLinkerCrossRoomUpdateContentExt();

    com.bytedance.android.livesdk.message.linker.j getLinkerDegradeAlertContent();

    @FieldName(name = "enlarge_guest_apply_content")
    com.bytedance.android.livesdk.message.linker.f getLinkerEnlargeGuestApplyContent();

    @FieldName(name = "enlarge_guest_invite_content")
    com.bytedance.android.livesdk.message.linker.k getLinkerEnlargeGuestInviteContent();

    @FieldName(name = "enlarge_guest_reply_content")
    com.bytedance.android.livesdk.message.linker.g getLinkerEnlargeGuestReplyContent();

    @FieldName(name = "linker_enlarge_update_content")
    LinkerEnlargeUpdateContent getLinkerEnlargeUpdateContent();

    @FieldName(name = "linker_id")
    long getLinkerId();

    @FieldName(name = "init_chat_room_content")
    LinkerInitChatRoomContent getLinkerInitChatRoomContent();

    ILinkerInvitePrepareContent getLinkerInvitePrepareContent();

    @FieldName(name = "linker_live_core_biz_tag_change_content")
    ILinkerLiveCoreBizTagChangeContent getLinkerLiveCoreBizTagChangeContent();

    @FieldName(name = "linker_prepare_invite_content")
    LinkerPrepareInviteContent getLinkerPrepareInviteContent();

    @FieldName(name = "linker_prepare_reply_content")
    LinkerPrepareReplyContent getLinkerPrepareReplyContent();

    @FieldName(name = "linker_remove_waiting_user_content")
    LinkerRemoveWaitingUserContent getLinkerRemoveWaitingUserContent();

    @FieldName(name = "linker_resume_audience_content")
    l6 getLinkerResumeAudienceContent();

    ILinkerUILayoutChangeContent getLinkerUILayoutChangeContent();

    LinkerLockPositionContent getLockPositionContent();

    @FieldName(name = "change_play_mode_content")
    com.bytedance.android.livesdk.message.linker.d getMChangePlayModeContent();

    @FieldName(name = "follow_strong_guide_content")
    ILinkerFollowStrongGuideContent getMFollowStrongGuideContent();

    @FieldName(name = "kick_out_content")
    ILinkerKickOutContent getMKickOut();

    ILinkerLinkedListChangeContent getMLinkedListChange();

    @FieldName(name = "sys_kick_out_content")
    LinkerSysKickOutContent getMLinkerSysKickOutContent();

    @FieldName(name = "low_balance_for_paid_linkmic_content")
    ILinkerLowBalanceForPaidLinkmicContent getMLowBalanceForPaidLinkContent();

    int getMType();

    @FieldName(name = "update_user_content")
    ILinkerUpdateUserContent getMUpdateUser();

    long getMessageId3();

    /* synthetic */ IPublicAreaCommon getOrInitPublicAreaCommon();

    @FieldName(name = "public_area_common")
    IPublicAreaCommon getPublicAreaCommon();

    long getReceiveNtpTimeFlex(long r100);

    @FieldName(name = "rtc_action_content")
    ILinkerRTCActionContent getRtcActionContent();

    @FieldName(name = "scene")
    long getScene();

    long getTimestampFlex();

    @FieldName(name = "message_type")
    long getType2();

    @FieldName(name = "update_link_type_apply_content")
    ILinkerUpdateLinkTypeApplyContent getUpdateLinkTypeApplyContent();

    @FieldName(name = "update_link_type_force_open_camera_content")
    ILinkerUpdateLinkTypeForceOpenCameraContent getUpdateLinkTypeForceOpenCameraContent();

    @FieldName(name = "update_link_type_reply_content")
    ILinkerUpdateLinkTypeReplyContent getUpdateLinkTypeReplyContent();

    /* synthetic */ IBaseUser getUserInMessage();

    void setLinkRoomFightCancelInviteContent(com.bytedance.android.live.base.model.data.g r100);

    @FieldName(name = "cross_room_link_invite_content#setter")
    void setLinkRoomFightInviteContent(com.bytedance.android.live.base.model.data.h r100);

    void setLinkRoomFightReplyContent(ILinkRoomFightReplyContent r100);

    void setLinkerCrossRoomUpdateContentExt(com.bytedance.android.live.base.model.data.i r100);

    @FieldName(name = "linker_live_core_biz_tag_change_content#setter")
    void setLinkerLiveCoreBizTagChangeContent(ILinkerLiveCoreBizTagChangeContent r100);
}
