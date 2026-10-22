package com.bytedance.android.livesdk.message.model;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareInviteContent;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent;
import com.bytedance.android.livesdk.link.model.ILinkerUpdateLinkTypeApplyContent;
import com.bytedance.android.livesdk.message.linker.LinkerAnchorStreamSwitchContent;
import com.bytedance.android.livesdk.message.linker.LinkerChangePlayModeContent;
import com.bytedance.android.livesdk.message.linker.LinkerCloseContent;
import com.bytedance.android.livesdk.message.linker.LinkerEnlargeGuestApplyContent;
import com.bytedance.android.livesdk.message.linker.LinkerLockPositionContent;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.linker.BattleLinkerInviteMessageExtra;
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
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkMicAudienceEnterMessageExtra;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightCancelInviteContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightInviteContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerApplyRankChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerAudienceWaitingListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerAvatarAuditContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerClickScreenContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerCreateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnlargeUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerEnterContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerFollowStrongGuideContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerGuestExitCastScreenContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInitChatRoomContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInviteContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInvitePrepareContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLeaveContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLowBalanceForPaidLinkmicContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerRemoveWaitingUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerResumeApplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerResumeAudienceContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerUILayoutChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerUpdateLinkTypeApplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerUpdateLinkTypeReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerViolationReminderContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker._LinkerUpdateLinkTypeApplyContent_ProtoDecoder;
import com.bytedance.android.livesdkapi.depend.model.live.linker._LinkerUpdateLinkTypeReplyContent_ProtoDecoder;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.bytedance.android.livesdk.message.model.if, reason: invalid class name */
/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Ä\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 ©\u00032\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0004:\u0002ª\u0003B\t¢\u0006\u0006\b§\u0003\u0010¨\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J-\u0010\r\u001a\u00028\u0000\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001cR\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001c\u0010H\u001a\u0004\u0018\u00010G8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bf\u0010gR$\u0010i\u001a\u0004\u0018\u00010h8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bp\u0010qR$\u0010s\u001a\u0004\u0018\u00010r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR$\u0010z\u001a\u0004\u0018\u00010y8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR,\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R,\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R,\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R,\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R,\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R\u001c\u0010ª\u0001\u001a\u0005\u0018\u00010©\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R,\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R,\u0010´\u0001\u001a\u0005\u0018\u00010³\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R,\u0010»\u0001\u001a\u0005\u0018\u00010º\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R,\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R\u001c\u0010É\u0001\u001a\u0005\u0018\u00010È\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u001c\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R,\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÏ\u0001\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R,\u0010Ö\u0001\u001a\u0005\u0018\u00010Õ\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÖ\u0001\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R,\u0010Ý\u0001\u001a\u0005\u0018\u00010Ü\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÝ\u0001\u0010Þ\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R,\u0010ä\u0001\u001a\u0005\u0018\u00010ã\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bä\u0001\u0010å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001\"\u0006\bè\u0001\u0010é\u0001R,\u0010ë\u0001\u001a\u0005\u0018\u00010ê\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0006\bí\u0001\u0010î\u0001\"\u0006\bï\u0001\u0010ð\u0001R,\u0010ò\u0001\u001a\u0005\u0018\u00010ñ\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bò\u0001\u0010ó\u0001\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R,\u0010ù\u0001\u001a\u0005\u0018\u00010ø\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bù\u0001\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R,\u0010\u0080\u0002\u001a\u0005\u0018\u00010ÿ\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R,\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0086\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0006\b\u008b\u0002\u0010\u008c\u0002R,\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008d\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u008e\u0002\u0010\u008f\u0002\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R0\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0094\u00022\n\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0094\u00028F@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0096\u0002\u0010\u0097\u0002\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002R+\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009a\u0002\u0010\u009b\u0002\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002\"\u0006\b\u009e\u0002\u0010\u009f\u0002R,\u0010¡\u0002\u001a\u0005\u0018\u00010 \u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¡\u0002\u0010¢\u0002\u001a\u0006\b£\u0002\u0010¤\u0002\"\u0006\b¥\u0002\u0010¦\u0002R,\u0010¨\u0002\u001a\u0005\u0018\u00010§\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¨\u0002\u0010©\u0002\u001a\u0006\bª\u0002\u0010«\u0002\"\u0006\b¬\u0002\u0010\u00ad\u0002R,\u0010¯\u0002\u001a\u0005\u0018\u00010®\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¯\u0002\u0010°\u0002\u001a\u0006\b±\u0002\u0010²\u0002\"\u0006\b³\u0002\u0010´\u0002R,\u0010¶\u0002\u001a\u0005\u0018\u00010µ\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¶\u0002\u0010·\u0002\u001a\u0006\b¸\u0002\u0010¹\u0002\"\u0006\bº\u0002\u0010»\u0002R,\u0010½\u0002\u001a\u0005\u0018\u00010¼\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b½\u0002\u0010¾\u0002\u001a\u0006\b¿\u0002\u0010À\u0002\"\u0006\bÁ\u0002\u0010Â\u0002R,\u0010Ä\u0002\u001a\u0005\u0018\u00010Ã\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÄ\u0002\u0010Å\u0002\u001a\u0006\bÆ\u0002\u0010Ç\u0002\"\u0006\bÈ\u0002\u0010É\u0002R,\u0010Ë\u0002\u001a\u0005\u0018\u00010Ê\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bË\u0002\u0010Ì\u0002\u001a\u0006\bÍ\u0002\u0010Î\u0002\"\u0006\bÏ\u0002\u0010Ð\u0002R0\u0010Ò\u0002\u001a\u0005\u0018\u00010Ñ\u00022\n\u0010\u0095\u0002\u001a\u0005\u0018\u00010Ñ\u00028F@BX\u0086\u000e¢\u0006\u0010\n\u0006\bÒ\u0002\u0010Ó\u0002\u001a\u0006\bÔ\u0002\u0010Õ\u0002R\u0018\u0010Ù\u0002\u001a\u00030Ö\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b×\u0002\u0010Ø\u0002R\u0016\u0010Û\u0002\u001a\u00020L8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÚ\u0002\u0010PR\u0018\u0010Þ\u0002\u001a\u00030\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÜ\u0002\u0010Ý\u0002R\u0018\u0010á\u0002\u001a\u00030\u0098\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bß\u0002\u0010à\u0002R\u0016\u0010ã\u0002\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bâ\u0002\u0010$R\u0016\u0010å\u0002\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bä\u0002\u0010$R0\u0010ì\u0002\u001a\u0005\u0018\u00010æ\u00022\n\u0010ç\u0002\u001a\u0005\u0018\u00010æ\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bè\u0002\u0010é\u0002\"\u0006\bê\u0002\u0010ë\u0002R0\u0010ò\u0002\u001a\u0005\u0018\u00010í\u00022\n\u0010ç\u0002\u001a\u0005\u0018\u00010í\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bî\u0002\u0010ï\u0002\"\u0006\bð\u0002\u0010ñ\u0002R0\u0010ø\u0002\u001a\u0005\u0018\u00010ó\u00022\n\u0010ç\u0002\u001a\u0005\u0018\u00010ó\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bô\u0002\u0010õ\u0002\"\u0006\bö\u0002\u0010÷\u0002R.\u0010û\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010ç\u0002\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bù\u0002\u0010\u009d\u0002\"\u0006\bú\u0002\u0010\u009f\u0002R\u0016\u0010ý\u0002\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bü\u0002\u0010$R\u0016\u0010ÿ\u0002\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bþ\u0002\u0010\u001eR\u0016\u0010\u0081\u0003\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0003\u0010$R\u001a\u0010\u0085\u0003\u001a\u0005\u0018\u00010\u0082\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0083\u0003\u0010\u0084\u0003R\u0019\u0010\u0088\u0003\u001a\u0004\u0018\u00010V8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0086\u0003\u0010\u0087\u0003R\u0019\u0010\u008b\u0003\u001a\u0004\u0018\u00010Y8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0003\u0010\u008a\u0003R\u001a\u0010\u008f\u0003\u001a\u0005\u0018\u00010\u008c\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008d\u0003\u0010\u008e\u0003R\u0019\u0010\u0092\u0003\u001a\u0004\u0018\u00010b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0090\u0003\u0010\u0091\u0003R0\u0010\u0094\u0003\u001a\u0005\u0018\u00010\u0093\u00032\n\u0010\u0094\u0003\u001a\u0005\u0018\u00010\u0093\u00038V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0095\u0003\u0010\u0096\u0003\"\u0006\b\u0097\u0003\u0010\u0098\u0003R\u0019\u0010\u009b\u0003\u001a\u0004\u0018\u00010\\8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0099\u0003\u0010\u009a\u0003R\u001a\u0010\u009f\u0003\u001a\u0005\u0018\u00010\u009c\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009d\u0003\u0010\u009e\u0003R\u0019\u0010¢\u0003\u001a\u0004\u0018\u00010o8VX\u0096\u0004¢\u0006\b\u001a\u0006\b \u0003\u0010¡\u0003R\u001a\u0010¤\u0003\u001a\u0005\u0018\u00010®\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b£\u0003\u0010²\u0002R\u001a\u0010¦\u0003\u001a\u0005\u0018\u00010¼\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b¥\u0003\u0010À\u0002¨\u0006«\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/if;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/t;", "Lvh7/c$a;", "Lcom/bytedance/android/livesdk/link/model/bridge/h1;", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "getOrInitPublicAreaCommon", "", "canText", "Lvh7/e;", "R", "Ljava/lang/Class;", "aClass", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "ntpDiff", "getReceiveNtpTimeFlex", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUserInMessage", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "", "mType", "I", "getMType", "()I", "setMType", "(I)V", "linkerId", "J", "getLinkerId", "()J", "setLinkerId", "(J)V", NativeDownloadModel.JsonKey.SCENE, "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInviteContent;", "mInvite", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInviteContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerReplyContent;", "mReply", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerReplyContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerCreateContent;", "mCreate", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerCreateContent;", "Lcom/bytedance/android/livesdk/message/linker/LinkerCloseContent;", "mClose", "Lcom/bytedance/android/livesdk/message/linker/LinkerCloseContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnterContent;", "mEnter", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnterContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLeaveContent;", "mLeave", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLeaveContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerKickOutContent;", "mKickOut", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerKickOutContent;", "getMKickOut", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerKickOutContent;", "setMKickOut", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerKickOutContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerClickScreenContent;", "mClickScreen", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerClickScreenContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLinkedListChangeContent;", "_mLinkedListChange", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLinkedListChangeContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;", "mUpdateUser", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;", "getMUpdateUser", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;", "_mLinkerSysKickOutContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;", "get_mLinkerSysKickOutContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;", "set_mLinkerSysKickOutContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerViolationReminderContent;", "mLinkerViolationReminderContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerViolationReminderContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerUpdateLinkTypeApplyContent;", "mUpdateLinkTypeApplyContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerUpdateLinkTypeApplyContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerUpdateLinkTypeReplyContent;", "mUpdateLinkTypeReplyContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerUpdateLinkTypeReplyContent;", "Lcom/bytedance/android/livesdk/message/linker/i;", "mApplyStrongReminderContent", "Lcom/bytedance/android/livesdk/message/linker/i;", "Lcom/bytedance/android/livesdk/message/linker/LinkerAnchorStreamSwitchContent;", "mAnchorStreamSwitchContent", "Lcom/bytedance/android/livesdk/message/linker/LinkerAnchorStreamSwitchContent;", "Lcom/bytedance/android/live/base/model/data/j;", "mGuestInviteContent", "Lcom/bytedance/android/live/base/model/data/j;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerGuestExitCastScreenContent;", "mGuestExitCastScreenContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerGuestExitCastScreenContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerFollowStrongGuideContent;", "mFollowStrongGuideContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerFollowStrongGuideContent;", "getMFollowStrongGuideContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerFollowStrongGuideContent;", "setMFollowStrongGuideContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerFollowStrongGuideContent;)V", "Lcom/bytedance/android/livesdk/message/linker/LinkerLockPositionContent;", "mLockPositionContent", "Lcom/bytedance/android/livesdk/message/linker/LinkerLockPositionContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLowBalanceForPaidLinkmicContent;", "mLowBalanceForPaidLinkContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLowBalanceForPaidLinkmicContent;", "getMLowBalanceForPaidLinkContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLowBalanceForPaidLinkmicContent;", "setMLowBalanceForPaidLinkContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerLowBalanceForPaidLinkmicContent;)V", "Lcom/bytedance/android/livesdk/message/linker/LinkerChangePlayModeContent;", "mChangePlayModeContent", "Lcom/bytedance/android/livesdk/message/linker/LinkerChangePlayModeContent;", "getMChangePlayModeContent", "()Lcom/bytedance/android/livesdk/message/linker/LinkerChangePlayModeContent;", "setMChangePlayModeContent", "(Lcom/bytedance/android/livesdk/message/linker/LinkerChangePlayModeContent;)V", "", "extraStr", "Ljava/lang/String;", "getExtraStr", "()Ljava/lang/String;", "setExtraStr", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAvatarAuditContent;", "_avatarAuditContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAvatarAuditContent;", "Lcom/bytedance/android/livesdk/message/linker/j;", "linkerDegradeAlertContent", "Lcom/bytedance/android/livesdk/message/linker/j;", "getLinkerDegradeAlertContent", "()Lcom/bytedance/android/livesdk/message/linker/j;", "setLinkerDegradeAlertContent", "(Lcom/bytedance/android/livesdk/message/linker/j;)V", "Lcom/bytedance/android/livesdk/message/linker/k;", "linkerEnlargeGuestInviteContent", "Lcom/bytedance/android/livesdk/message/linker/k;", "getLinkerEnlargeGuestInviteContent", "()Lcom/bytedance/android/livesdk/message/linker/k;", "setLinkerEnlargeGuestInviteContent", "(Lcom/bytedance/android/livesdk/message/linker/k;)V", "Lcom/bytedance/android/livesdk/message/linker/g;", "_linkerEnlargeGuestReplyContent", "Lcom/bytedance/android/livesdk/message/linker/g;", "Lcom/bytedance/android/livesdk/message/linker/LinkerEnlargeGuestApplyContent;", "linkerEnlargeGuestApplyContent", "Lcom/bytedance/android/livesdk/message/linker/LinkerEnlargeGuestApplyContent;", "getLinkerEnlargeGuestApplyContent", "()Lcom/bytedance/android/livesdk/message/linker/LinkerEnlargeGuestApplyContent;", "setLinkerEnlargeGuestApplyContent", "(Lcom/bytedance/android/livesdk/message/linker/LinkerEnlargeGuestApplyContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInvitePrepareContent;", "linkerInvitePrepareContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInvitePrepareContent;", "getLinkerInvitePrepareContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInvitePrepareContent;", "setLinkerInvitePrepareContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInvitePrepareContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightUpdateContent;", "linkerCrossRoomUpdateContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightUpdateContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightInviteContent;", "_linkRoomFightInviteContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightInviteContent;", "get_linkRoomFightInviteContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightInviteContent;", "set_linkRoomFightInviteContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightInviteContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyContent;", "_linkRoomFightReplyContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyContent;", "get_linkRoomFightReplyContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyContent;", "set_linkRoomFightReplyContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightCancelInviteContent;", "_linkRoomFightCancelInviteContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightCancelInviteContent;", "get_linkRoomFightCancelInviteContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightCancelInviteContent;", "set_linkRoomFightCancelInviteContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightCancelInviteContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerResumeAudienceContent;", "linkerResumeAudienceContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerResumeAudienceContent;", "getLinkerResumeAudienceContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerResumeAudienceContent;", "setLinkerResumeAudienceContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerResumeAudienceContent;)V", "Lcom/bytedance/android/livesdk/message/model/CrossRoomRTCInfoContent;", "crossRoomRTCInfoContent", "Lcom/bytedance/android/livesdk/message/model/CrossRoomRTCInfoContent;", "Lcom/bytedance/android/livesdk/message/model/AnchorUpdateLayoutContent;", "anchorUpdateLayoutContent", "Lcom/bytedance/android/livesdk/message/model/AnchorUpdateLayoutContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerBattleConnectContent;", "linkerBattleConnectContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerBattleConnectContent;", "getLinkerBattleConnectContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerBattleConnectContent;", "setLinkerBattleConnectContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerBattleConnectContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerResumeApplyContent;", "linkerResumeApplyContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerResumeApplyContent;", "getLinkerResumeApplyContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerResumeApplyContent;", "setLinkerResumeApplyContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerResumeApplyContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerApplyRankChangeContent;", "linkerApplyRankChangeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerApplyRankChangeContent;", "getLinkerApplyRankChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerApplyRankChangeContent;", "setLinkerApplyRankChangeContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerApplyRankChangeContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerChangeMediaInfoContent;", "linkerChangeMediaInfoContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerChangeMediaInfoContent;", "getLinkerChangeMediaInfoContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerChangeMediaInfoContent;", "setLinkerChangeMediaInfoContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerChangeMediaInfoContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerUILayoutChangeContent;", "linkerUILayoutChangeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerUILayoutChangeContent;", "getLinkerUILayoutChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerUILayoutChangeContent;", "setLinkerUILayoutChangeContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerUILayoutChangeContent;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkerBaseInfo;", "linkerBaseInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkerBaseInfo;", "getLinkerBaseInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/LinkerBaseInfo;", "setLinkerBaseInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/LinkerBaseInfo;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRemoveWaitingUserContent;", "linkerRemoveWaitingUserContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRemoveWaitingUserContent;", "getLinkerRemoveWaitingUserContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRemoveWaitingUserContent;", "setLinkerRemoveWaitingUserContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerRemoveWaitingUserContent;)V", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareInviteContent;", "linkerPrepareInviteContent", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareInviteContent;", "getLinkerPrepareInviteContent", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareInviteContent;", "setLinkerPrepareInviteContent", "(Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareInviteContent;)V", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContent;", "linkerPrepareReplyContent", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContent;", "getLinkerPrepareReplyContent", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContent;", "setLinkerPrepareReplyContent", "(Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContent;)V", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContent;", "linkerConfirmUnsilenceContent", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContent;", "getLinkerConfirmUnsilenceContent", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContent;", "setLinkerConfirmUnsilenceContent", "(Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BattleLinkerInviteMessageExtra;", "<set-?>", "battleLinkerInviteMessageExtra", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BattleLinkerInviteMessageExtra;", "getBattleLinkerInviteMessageExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BattleLinkerInviteMessageExtra;", "mPublicAreaCommon", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "getMPublicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "setMPublicAreaCommon", "(Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent;", "rtcActionContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent;", "getRtcActionContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent;", "setRtcActionContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerRTCActionContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInitChatRoomContent;", "linkerInitChatRoomContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInitChatRoomContent;", "getLinkerInitChatRoomContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInitChatRoomContent;", "setLinkerInitChatRoomContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInitChatRoomContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAudienceWaitingListChangeContent;", "linkerAudienceWaitingListChangeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAudienceWaitingListChangeContent;", "getLinkerAudienceWaitingListChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAudienceWaitingListChangeContent;", "setLinkerAudienceWaitingListChangeContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAudienceWaitingListChangeContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContent;", "updateLinkTypeForceOpenCameraContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContent;", "getUpdateLinkTypeForceOpenCameraContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContent;", "setUpdateLinkTypeForceOpenCameraContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnlargeUpdateContent;", "enlargeUpdateContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnlargeUpdateContent;", "getEnlargeUpdateContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnlargeUpdateContent;", "setEnlargeUpdateContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnlargeUpdateContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerClientUIInfoChangeContent;", "linkerClientUIInfoChangeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerClientUIInfoChangeContent;", "getLinkerClientUIInfoChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerClientUIInfoChangeContent;", "setLinkerClientUIInfoChangeContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerClientUIInfoChangeContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLiveCoreBizTagChangeContent;", "linkerLiveCoreBizTagChangeContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLiveCoreBizTagChangeContent;", "getLinkerLiveCoreBizTagChangeContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLiveCoreBizTagChangeContent;", "setLinkerLiveCoreBizTagChangeContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLiveCoreBizTagChangeContent;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkMicAudienceEnterMessageExtra;", "audienceEnterMessageExtra", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkMicAudienceEnterMessageExtra;", "getAudienceEnterMessageExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkMicAudienceEnterMessageExtra;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLinkedListChangeContent;", "getMLinkedListChange", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLinkedListChangeContent;", "mLinkedListChange", "getMLinkerSysKickOutContent", "mLinkerSysKickOutContent", "getAvatarAuditContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerAvatarAuditContent;", "avatarAuditContent", "getLinkerEnlargeGuestReplyContent", "()Lcom/bytedance/android/livesdk/message/linker/g;", "linkerEnlargeGuestReplyContent", "getType2", "type2", "getMessageId3", "messageId3", "Lcom/bytedance/android/live/base/model/data/h;", "value", "getLinkRoomFightInviteContent", "()Lcom/bytedance/android/live/base/model/data/h;", "setLinkRoomFightInviteContent", "(Lcom/bytedance/android/live/base/model/data/h;)V", "linkRoomFightInviteContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkRoomFightReplyContent;", "getLinkRoomFightReplyContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkRoomFightReplyContent;", "setLinkRoomFightReplyContent", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkRoomFightReplyContent;)V", "linkRoomFightReplyContent", "Lcom/bytedance/android/live/base/model/data/g;", "getLinkRoomFightCancelInviteContent", "()Lcom/bytedance/android/live/base/model/data/g;", "setLinkRoomFightCancelInviteContent", "(Lcom/bytedance/android/live/base/model/data/g;)V", "linkRoomFightCancelInviteContent", "getPublicAreaCommon", "setPublicAreaCommon", "publicAreaCommon", "getTimestampFlex", "timestampFlex", "getFromChannelFlex", "fromChannelFlex", "getScene", "scene", "Lcom/bytedance/android/livesdk/link/model/bridge/f1;", "getEnter", "()Lcom/bytedance/android/livesdk/link/model/bridge/f1;", "enter", "getUpdateLinkTypeApplyContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerUpdateLinkTypeApplyContent;", "updateLinkTypeApplyContent", "getUpdateLinkTypeReplyContent", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerUpdateLinkTypeReplyContent;", "updateLinkTypeReplyContent", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;", "getLeave", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLeaveContentBridge;", "leave", "getGuestInviteContent", "()Lcom/bytedance/android/live/base/model/data/j;", "guestInviteContent", "Lcom/bytedance/android/live/base/model/data/i;", "linkerCrossRoomUpdateContentExt", "getLinkerCrossRoomUpdateContentExt", "()Lcom/bytedance/android/live/base/model/data/i;", "setLinkerCrossRoomUpdateContentExt", "(Lcom/bytedance/android/live/base/model/data/i;)V", "getApplyStrongReminderContent", "()Lcom/bytedance/android/livesdk/message/linker/i;", "applyStrongReminderContent", "Lcom/bytedance/android/livesdk/link/model/u5;", "getAnchorStreamSwitchContent", "()Lcom/bytedance/android/livesdk/link/model/u5;", "anchorStreamSwitchContent", "getLockPositionContent", "()Lcom/bytedance/android/livesdk/message/linker/LinkerLockPositionContent;", "lockPositionContent", "getAudienceWaitingListChangeContent", "audienceWaitingListChangeContent", "getLinkerEnlargeUpdateContent", "linkerEnlargeUpdateContent", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Cif extends o0 implements vh7.c.a<com.bytedance.android.livesdk.link.model.bridge.h1>, com.bytedance.android.livesdk.link.model.bridge.h1, vh7.h {
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
    public static final int TYPE_GUEST_EXIT_CAST_SCREEN = 30;
    private static final long TYPE_GUEST_INVITE = 0;
    public static final int TYPE_LINKER_AVATAR_AUDIT_CONTENT = 20;
    public static final int TYPE_LINKER_CHANGE_MULTI_PK_TEAM_INFO = 42;
    public static final int TYPE_LINKER_CHANGE_PLAY_MODE = 33;
    public static final int TYPE_LINKER_CLICK_SCREEN = 25;
    public static final int TYPE_LINKER_CONFIRM_UNSILENCE = 59;
    public static final int TYPE_LINKER_CROSS_ROOM_UPDATE = 41;
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

    @SerializedName("avatar_audit_content")
    public LinkerAvatarAuditContent _avatarAuditContent;

    @SerializedName("cross_room_link_cancel_invite_content")
    protected LinkRoomFightCancelInviteContent _linkRoomFightCancelInviteContent;

    @SerializedName("cross_room_link_invite_content")
    protected LinkRoomFightInviteContent _linkRoomFightInviteContent;

    @SerializedName("cross_room_link_reply_content")
    protected LinkRoomFightReplyContent _linkRoomFightReplyContent;

    @SerializedName("enlarge_guest_reply_content")
    public com.bytedance.android.livesdk.message.linker.g _linkerEnlargeGuestReplyContent;

    @SerializedName("linked_list_change_content")
    public LinkerLinkedListChangeContent _mLinkedListChange;

    @SerializedName("sys_kick_out_content")
    protected LinkerSysKickOutContent _mLinkerSysKickOutContent;

    @SerializedName("anchor_update_layout_content")
    public AnchorUpdateLayoutContent anchorUpdateLayoutContent;
    private LinkMicAudienceEnterMessageExtra audienceEnterMessageExtra;
    private BattleLinkerInviteMessageExtra battleLinkerInviteMessageExtra;

    @SerializedName("cross_room_rtc_info_content")
    public CrossRoomRTCInfoContent crossRoomRTCInfoContent;
    private final transient FlexModelDelegate<com.bytedance.android.livesdk.link.model.bridge.h1> delegate;

    @SerializedName("linker_enlarge_update_content")
    protected LinkerEnlargeUpdateContent enlargeUpdateContent;

    @SerializedName("extra")
    protected String extraStr;

    @SerializedName("apply_rank_change_content")
    protected LinkerApplyRankChangeContent linkerApplyRankChangeContent;

    @SerializedName("audience_waiting_list_change")
    protected LinkerAudienceWaitingListChangeContent linkerAudienceWaitingListChangeContent;

    @SerializedName("linker_base_info")
    protected LinkerBaseInfo linkerBaseInfo;

    @SerializedName("linker_battle_connect_content")
    protected LinkerBattleConnectContent linkerBattleConnectContent;

    @SerializedName("change_media_content")
    protected LinkerChangeMediaInfoContent linkerChangeMediaInfoContent;

    @SerializedName("linker_client_ui_info_change_content")
    protected ILinkerClientUIInfoChangeContent linkerClientUIInfoChangeContent;

    @SerializedName("linker_confirm_unsilence_content")
    protected LinkerConfirmUnsilenceContent linkerConfirmUnsilenceContent;

    @SerializedName("cross_room_update_content")
    public LinkRoomFightUpdateContent linkerCrossRoomUpdateContent;

    @SerializedName("degrade_alert_content")
    protected com.bytedance.android.livesdk.message.linker.j linkerDegradeAlertContent;

    @SerializedName("enlarge_guest_apply_content")
    protected LinkerEnlargeGuestApplyContent linkerEnlargeGuestApplyContent;

    @SerializedName("enlarge_guest_invite_content")
    protected com.bytedance.android.livesdk.message.linker.k linkerEnlargeGuestInviteContent;

    @SerializedName("linker_id")
    protected long linkerId;

    @SerializedName("init_chat_room_content")
    protected LinkerInitChatRoomContent linkerInitChatRoomContent;

    @SerializedName("prepare_apply_content")
    protected LinkerInvitePrepareContent linkerInvitePrepareContent;

    @SerializedName("linker_live_core_biz_tag_change_content")
    protected ILinkerLiveCoreBizTagChangeContent linkerLiveCoreBizTagChangeContent;

    @SerializedName("linker_prepare_invite_content")
    protected LinkerPrepareInviteContent linkerPrepareInviteContent;

    @SerializedName("linker_prepare_reply_content")
    protected LinkerPrepareReplyContent linkerPrepareReplyContent;

    @SerializedName("linker_remove_waiting_user_content")
    protected LinkerRemoveWaitingUserContent linkerRemoveWaitingUserContent;

    @SerializedName("linker_resume_apply_content")
    protected LinkerResumeApplyContent linkerResumeApplyContent;

    @SerializedName("linker_resume_audience_content")
    protected LinkerResumeAudienceContent linkerResumeAudienceContent;

    @SerializedName("linker_ui_layout_change_content")
    protected LinkerUILayoutChangeContent linkerUILayoutChangeContent;

    @SerializedName("anchor_stream_switch_content")
    public LinkerAnchorStreamSwitchContent mAnchorStreamSwitchContent;

    @SerializedName("apply_strong_reminder_content")
    public com.bytedance.android.livesdk.message.linker.i mApplyStrongReminderContent;

    @SerializedName("change_play_mode_content")
    protected LinkerChangePlayModeContent mChangePlayModeContent;

    @SerializedName("click_screen_content")
    public LinkerClickScreenContent mClickScreen;

    @SerializedName("close_content")
    public LinkerCloseContent mClose;

    @SerializedName("create_content")
    public LinkerCreateContent mCreate;

    @SerializedName("enter_content")
    public LinkerEnterContent mEnter;

    @SerializedName("follow_strong_guide_content")
    protected LinkerFollowStrongGuideContent mFollowStrongGuideContent;

    @SerializedName("exit_cast_screen_content")
    public LinkerGuestExitCastScreenContent mGuestExitCastScreenContent;

    @SerializedName("guest_invite_content")
    public com.bytedance.android.live.base.model.data.j mGuestInviteContent;

    @SerializedName("invite_content")
    public LinkerInviteContent mInvite;

    @SerializedName("kick_out_content")
    protected LinkerKickOutContent mKickOut;

    @SerializedName("leave_content")
    public LinkerLeaveContent mLeave;

    @SerializedName("violation_reminder_content")
    public LinkerViolationReminderContent mLinkerViolationReminderContent;

    @SerializedName("lock_position_content")
    public LinkerLockPositionContent mLockPositionContent;

    @SerializedName("low_balance_for_paid_linkmic_content")
    protected LinkerLowBalanceForPaidLinkmicContent mLowBalanceForPaidLinkContent;

    @SerializedName("public_area_common")
    protected PublicAreaCommon mPublicAreaCommon;

    @SerializedName("reply_content")
    public LinkerReplyContent mReply;

    @SerializedName("scene")
    public int mScene;

    @SerializedName("message_type")
    protected int mType;

    @SerializedName("update_link_type_apply_content")
    public LinkerUpdateLinkTypeApplyContent mUpdateLinkTypeApplyContent;

    @SerializedName("update_link_type_reply_content")
    public LinkerUpdateLinkTypeReplyContent mUpdateLinkTypeReplyContent;

    @SerializedName("update_user_content")
    protected ILinkerUpdateUserContent mUpdateUser;

    @SerializedName("rtc_action_content")
    protected ILinkerRTCActionContent rtcActionContent;

    @SerializedName("update_link_type_force_open_camera_content")
    protected ILinkerUpdateLinkTypeForceOpenCameraContent updateLinkTypeForceOpenCameraContent;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.message.model.if$a */
    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1, com.bytedance.android.live.base.model.message.u3
    public IBaseUser getUserInMessage() {
        return null;
    }

    static {
        Companion = new a();
        TYPE_GUEST_INVITE = 29;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean canText() {
        if (this.mGuestInviteContent == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final LinkMicAudienceEnterMessageExtra getAudienceEnterMessageExtra() {
        LinkMicAudienceEnterMessageExtra r100 = this.audienceEnterMessageExtra;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (TextUtils.isEmpty(getExtraStr()) == false) goto L11;
        return null;
    L11:
        LinkMicAudienceEnterMessageExtra r101 = (LinkMicAudienceEnterMessageExtra) vh7.f.b(Base64.decode(getExtraStr(), 0), LinkMicAudienceEnterMessageExtra.class);     // Catch: Exception -> L10
        this.audienceEnterMessageExtra = r101;     // Catch: Exception -> L10
        return r101;
    L10:
        return null;
    }

    public final BattleLinkerInviteMessageExtra getBattleLinkerInviteMessageExtra() {
        BattleLinkerInviteMessageExtra r100 = this.battleLinkerInviteMessageExtra;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (getExtraStr() != null) goto L11;
        return null;
    L11:
        BattleLinkerInviteMessageExtra r101 = (BattleLinkerInviteMessageExtra) vh7.f.b(Base64.decode(getExtraStr(), 0), BattleLinkerInviteMessageExtra.class);     // Catch: Exception -> L10
        this.battleLinkerInviteMessageExtra = r101;     // Catch: Exception -> L10
        return r101;
    L10:
        return null;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public long getScene() {
        return this.mScene;
    }

    public Cif() {
        this.delegate = new FlexModelDelegate(com.bytedance.android.livesdk.link.model.bridge.h1.class, this);
        this.type = MessageType.LINKER;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.q getLinkerBaseInfo() {
        return getLinkerBaseInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ ILinkerBattleConnectContent getLinkerBattleConnectContent() {
        return getLinkerBattleConnectContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ ILinkerChangeMediaInfoContent getLinkerChangeMediaInfoContent() {
        return getLinkerChangeMediaInfoContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.message.linker.f getLinkerEnlargeGuestApplyContent() {
        return getLinkerEnlargeGuestApplyContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ ILinkerInvitePrepareContent getLinkerInvitePrepareContent() {
        return getLinkerInvitePrepareContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.link.model.l6 getLinkerResumeAudienceContent() {
        return getLinkerResumeAudienceContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ ILinkerUILayoutChangeContent getLinkerUILayoutChangeContent() {
        return getLinkerUILayoutChangeContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.message.linker.d getMChangePlayModeContent() {
        return getMChangePlayModeContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ ILinkerFollowStrongGuideContent getMFollowStrongGuideContent() {
        return getMFollowStrongGuideContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ ILinkerKickOutContent getMKickOut() {
        return getMKickOut();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ ILinkerLowBalanceForPaidLinkmicContent getMLowBalanceForPaidLinkContent() {
        return getMLowBalanceForPaidLinkContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public long getMessageId3() {
        return getMessageId();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1, com.bytedance.android.live.base.model.message.u3
    public PublicAreaCommon getOrInitPublicAreaCommon() {
        if (getPublicAreaCommon() != null) goto L6;
        setPublicAreaCommon(new PublicAreaCommon());
    L6:
        return getPublicAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ IPublicAreaCommon getPublicAreaCommon() {
        return getPublicAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public long getType2() {
        return getMType();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ ILinkerUpdateLinkTypeApplyContent getUpdateLinkTypeApplyContent() {
        return getUpdateLinkTypeApplyContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public /* bridge */ /* synthetic */ ILinkerUpdateLinkTypeReplyContent getUpdateLinkTypeReplyContent() {
        return getUpdateLinkTypeReplyContent();
    }

    public static final /* synthetic */ long access$getTYPE_GUEST_INVITE$cp() {
        return TYPE_GUEST_INVITE;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.link.model.u5 getAnchorStreamSwitchContent() {
        return this.mAnchorStreamSwitchContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.message.linker.i getApplyStrongReminderContent() {
        return this.mApplyStrongReminderContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerAudienceWaitingListChangeContent getAudienceWaitingListChangeContent() {
        return this.linkerAudienceWaitingListChangeContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerAvatarAuditContent getAvatarAuditContent() {
        return this._avatarAuditContent;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<com.bytedance.android.livesdk.link.model.bridge.h1> getDelegate() {
        return this.delegate;
    }

    public final LinkerEnlargeUpdateContent getEnlargeUpdateContent() {
        return this.enlargeUpdateContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.link.model.bridge.f1 getEnter() {
        return this.mEnter;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public String getExtraStr() {
        return this.extraStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public int getFromChannelFlex() {
        return this.fromChannel;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.live.base.model.data.j getGuestInviteContent() {
        return this.mGuestInviteContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerLeaveContentBridge getLeave() {
        return this.mLeave;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.live.base.model.data.g getLinkRoomFightCancelInviteContent() {
        return this._linkRoomFightCancelInviteContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.live.base.model.data.h getLinkRoomFightInviteContent() {
        return this._linkRoomFightInviteContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkRoomFightReplyContent getLinkRoomFightReplyContent() {
        return this._linkRoomFightReplyContent;
    }

    public final LinkerApplyRankChangeContent getLinkerApplyRankChangeContent() {
        return this.linkerApplyRankChangeContent;
    }

    public final LinkerAudienceWaitingListChangeContent getLinkerAudienceWaitingListChangeContent() {
        return this.linkerAudienceWaitingListChangeContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerClientUIInfoChangeContent getLinkerClientUIInfoChangeContent() {
        return this.linkerClientUIInfoChangeContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerConfirmUnsilenceContent getLinkerConfirmUnsilenceContent() {
        return this.linkerConfirmUnsilenceContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.live.base.model.data.i getLinkerCrossRoomUpdateContentExt() {
        return this.linkerCrossRoomUpdateContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.message.linker.j getLinkerDegradeAlertContent() {
        return this.linkerDegradeAlertContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.message.linker.k getLinkerEnlargeGuestInviteContent() {
        return this.linkerEnlargeGuestInviteContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public com.bytedance.android.livesdk.message.linker.g getLinkerEnlargeGuestReplyContent() {
        return this._linkerEnlargeGuestReplyContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerEnlargeUpdateContent getLinkerEnlargeUpdateContent() {
        return this.enlargeUpdateContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public long getLinkerId() {
        return this.linkerId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerInitChatRoomContent getLinkerInitChatRoomContent() {
        return this.linkerInitChatRoomContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerLiveCoreBizTagChangeContent getLinkerLiveCoreBizTagChangeContent() {
        return this.linkerLiveCoreBizTagChangeContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerPrepareInviteContent getLinkerPrepareInviteContent() {
        return this.linkerPrepareInviteContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerPrepareReplyContent getLinkerPrepareReplyContent() {
        return this.linkerPrepareReplyContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerRemoveWaitingUserContent getLinkerRemoveWaitingUserContent() {
        return this.linkerRemoveWaitingUserContent;
    }

    public final LinkerResumeApplyContent getLinkerResumeApplyContent() {
        return this.linkerResumeApplyContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerLockPositionContent getLockPositionContent() {
        return this.mLockPositionContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerLinkedListChangeContent getMLinkedListChange() {
        return this._mLinkedListChange;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerSysKickOutContent getMLinkerSysKickOutContent() {
        return this._mLinkerSysKickOutContent;
    }

    public final PublicAreaCommon getMPublicAreaCommon() {
        return this.mPublicAreaCommon;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public int getMType() {
        return this.mType;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerUpdateUserContent getMUpdateUser() {
        return this.mUpdateUser;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerRTCActionContent getRtcActionContent() {
        return this.rtcActionContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public long getTimestampFlex() {
        return this.timestamp;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public ILinkerUpdateLinkTypeForceOpenCameraContent getUpdateLinkTypeForceOpenCameraContent() {
        return this.updateLinkTypeForceOpenCameraContent;
    }

    public final LinkRoomFightCancelInviteContent get_linkRoomFightCancelInviteContent() {
        return this._linkRoomFightCancelInviteContent;
    }

    public final LinkRoomFightInviteContent get_linkRoomFightInviteContent() {
        return this._linkRoomFightInviteContent;
    }

    public final LinkRoomFightReplyContent get_linkRoomFightReplyContent() {
        return this._linkRoomFightReplyContent;
    }

    public final LinkerSysKickOutContent get_mLinkerSysKickOutContent() {
        return this._mLinkerSysKickOutContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerBaseInfo getLinkerBaseInfo() {
        return this.linkerBaseInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerBattleConnectContent getLinkerBattleConnectContent() {
        return this.linkerBattleConnectContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerChangeMediaInfoContent getLinkerChangeMediaInfoContent() {
        return this.linkerChangeMediaInfoContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerEnlargeGuestApplyContent getLinkerEnlargeGuestApplyContent() {
        return this.linkerEnlargeGuestApplyContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerInvitePrepareContent getLinkerInvitePrepareContent() {
        return this.linkerInvitePrepareContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerResumeAudienceContent getLinkerResumeAudienceContent() {
        return this.linkerResumeAudienceContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerUILayoutChangeContent getLinkerUILayoutChangeContent() {
        return this.linkerUILayoutChangeContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerChangePlayModeContent getMChangePlayModeContent() {
        return this.mChangePlayModeContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerFollowStrongGuideContent getMFollowStrongGuideContent() {
        return this.mFollowStrongGuideContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerKickOutContent getMKickOut() {
        return this.mKickOut;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerLowBalanceForPaidLinkmicContent getMLowBalanceForPaidLinkContent() {
        return this.mLowBalanceForPaidLinkContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1, com.bytedance.android.live.base.model.message.u3
    public /* bridge */ /* synthetic */ IPublicAreaCommon getOrInitPublicAreaCommon() {
        return getOrInitPublicAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public PublicAreaCommon getPublicAreaCommon() {
        return this.mPublicAreaCommon;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerUpdateLinkTypeApplyContent getUpdateLinkTypeApplyContent() {
        return this.mUpdateLinkTypeApplyContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public LinkerUpdateLinkTypeReplyContent getUpdateLinkTypeReplyContent() {
        return this.mUpdateLinkTypeReplyContent;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLiveCoreBizTagChangeContent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.livesdk.chatroom.model.LinkerPrepareInviteContent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v31, types: [com.bytedance.android.livesdk.message.linker.j, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v33, types: [com.bytedance.android.livesdk.message.linker.k, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v35, types: [com.bytedance.android.livesdk.message.linker.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v40, types: [com.bytedance.android.livesdk.message.linker.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v44, types: [com.bytedance.android.livesdk.message.linker.LinkerLockPositionContent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateLinkTypeForceOpenCameraContent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v53, types: [com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v59, types: [com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerRTCActionContent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v61, types: [com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent, java.lang.Object] */
    public Cif(am3.g r100) {
        this.delegate = new FlexModelDelegate(com.bytedance.android.livesdk.link.model.bridge.h1.class, this);
        getDelegate().setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L91;
        am3.g.a r103 = getDelegate().decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.mType = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.linkerId = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.mScene = (int) r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.mInvite = new LinkerInviteContent(r100);
        goto L3
    L16:
        if (r102 != 6) goto L18;
        this.mReply = new LinkerReplyContent(r100);
        goto L3
    L18:
        if (r102 == 7) goto L84;
        if (r102 != 29) goto L22;
        this.mGuestInviteContent = new com.bytedance.android.live.base.model.data.j(r100);
        goto L3
    L22:
        if (r102 != 30) goto L23;
        this.mGuestExitCastScreenContent = new LinkerGuestExitCastScreenContent(r100);
        goto L3
    L23:
        switch(r102) {
            case 7: goto L84;
            case 8: goto L81;
            case 9: goto L80;
            case 10: goto L79;
            case 50: goto L78;
            case 64: goto L77;
            case 101: goto L76;
            case 200: goto L75;
            case 201: goto L74;
            case 202: goto L73;
            default: goto L24;
        };
    L73:
        this.mPublicAreaCommon = new PublicAreaCommon(r100);
        goto L3
    L74:
        this.linkerBaseInfo = new LinkerBaseInfo(r100);
        goto L3
    L75:
        this.extraStr = am3.h.c(r100);
        goto L3
    L76:
        this._mLinkerSysKickOutContent = vh7.f.a(r100, LinkerSysKickOutContent.class);
        goto L3
    L77:
        this.rtcActionContent = vh7.f.a(r100, ILinkerRTCActionContent.class);
        goto L3
    L78:
        this.anchorUpdateLayoutContent = new AnchorUpdateLayoutContent(r100);
        goto L3
    L79:
        this.mLeave = new LinkerLeaveContent(r100);
        goto L3
    L80:
        this.mEnter = new LinkerEnterContent(r100);
        goto L3
    L81:
        this.mClose = new LinkerCloseContent(r100);
        goto L3
    L24:
        switch(r102) {
            case 12: goto L72;
            case 13: goto L71;
            case 14: goto L70;
            default: goto L25;
        };
    L70:
        this.mUpdateUser = vh7.f.a(r100, ILinkerUpdateUserContent.class);
        goto L3
    L71:
        this._mLinkedListChange = new LinkerLinkedListChangeContent(r100);
        goto L3
    L72:
        this.mKickOut = new LinkerKickOutContent(r100);
        goto L3
    L25:
        switch(r102) {
            case 18: goto L69;
            case 19: goto L68;
            case 20: goto L67;
            case 21: goto L66;
            default: goto L26;
        };
    L66:
        this._avatarAuditContent = new LinkerAvatarAuditContent(r100);
        goto L3
    L67:
        this.mUpdateLinkTypeReplyContent = _LinkerUpdateLinkTypeReplyContent_ProtoDecoder.decodeStatic(r100);
        goto L3
    L68:
        this.mUpdateLinkTypeApplyContent = _LinkerUpdateLinkTypeApplyContent_ProtoDecoder.decodeStatic(r100);
        goto L3
    L69:
        this.mLinkerViolationReminderContent = new LinkerViolationReminderContent(r100);
        goto L3
    L26:
        switch(r102) {
            case 23: goto L65;
            case 24: goto L64;
            case 25: goto L63;
            case 26: goto L62;
            case 27: goto L61;
            default: goto L27;
        };
    L61:
        this.mFollowStrongGuideContent = new LinkerFollowStrongGuideContent(r100);
        goto L3
    L62:
        this.mLockPositionContent = vh7.f.a(r100, LinkerLockPositionContent.class);
        goto L3
    L63:
        this.mClickScreen = new LinkerClickScreenContent(r100);
        goto L3
    L64:
        this.mAnchorStreamSwitchContent = new LinkerAnchorStreamSwitchContent(r100);
        goto L3
    L65:
        this.mApplyStrongReminderContent = vh7.f.a(r100, com.bytedance.android.livesdk.message.linker.i.class);
        goto L3
    L27:
        switch(r102) {
            case 33: goto L60;
            case 34: goto L59;
            case 35: goto L58;
            case 36: goto L57;
            case 37: goto L56;
            case 38: goto L55;
            case 39: goto L54;
            case 40: goto L53;
            default: goto L28;
        };
    L53:
        this.linkerCrossRoomUpdateContent = new LinkRoomFightUpdateContent(r100);
        goto L3
    L54:
        this.linkerInvitePrepareContent = new LinkerInvitePrepareContent(r100);
        goto L3
    L55:
        this.linkerEnlargeGuestApplyContent = new LinkerEnlargeGuestApplyContent(r100);
        goto L3
    L56:
        this._linkerEnlargeGuestReplyContent = vh7.f.a(r100, com.bytedance.android.livesdk.message.linker.g.class);
        goto L3
    L57:
        this.linkerEnlargeGuestInviteContent = vh7.f.a(r100, com.bytedance.android.livesdk.message.linker.k.class);
        goto L3
    L58:
        this.linkerDegradeAlertContent = vh7.f.a(r100, com.bytedance.android.livesdk.message.linker.j.class);
        goto L3
    L59:
        this.mLowBalanceForPaidLinkContent = new LinkerLowBalanceForPaidLinkmicContent(r100);
        goto L3
    L60:
        this.mChangePlayModeContent = new LinkerChangePlayModeContent(r100);
        goto L3
    L28:
        switch(r102) {
            case 42: goto L52;
            case 43: goto L51;
            case 44: goto L50;
            case 45: goto L49;
            case 46: goto L48;
            case 47: goto L47;
            case 48: goto L46;
            default: goto L29;
        };
    L46:
        this.crossRoomRTCInfoContent = new CrossRoomRTCInfoContent(r100);
        goto L3
    L47:
        this.linkerResumeApplyContent = new LinkerResumeApplyContent(r100);
        goto L3
    L48:
        this.linkerBattleConnectContent = new LinkerBattleConnectContent(r100);
        goto L3
    L49:
        this.linkerResumeAudienceContent = new LinkerResumeAudienceContent(r100);
        goto L3
    L50:
        this._linkRoomFightCancelInviteContent = new LinkRoomFightCancelInviteContent(r100);
        goto L3
    L51:
        this._linkRoomFightReplyContent = new LinkRoomFightReplyContent(r100);
        goto L3
    L52:
        this._linkRoomFightInviteContent = new LinkRoomFightInviteContent(r100);
        goto L3
    L29:
        switch(r102) {
            case 52: goto L45;
            case 53: goto L44;
            case 54: goto L43;
            default: goto L30;
        };
    L43:
        this.linkerUILayoutChangeContent = new LinkerUILayoutChangeContent(r100);
        goto L3
    L44:
        this.linkerChangeMediaInfoContent = new LinkerChangeMediaInfoContent(r100);
        goto L3
    L45:
        this.linkerApplyRankChangeContent = new LinkerApplyRankChangeContent(r100);
        goto L3
    L30:
        switch(r102) {
            case 56: goto L42;
            case 57: goto L41;
            case 58: goto L40;
            case 59: goto L39;
            default: goto L31;
        };
    L39:
        this.linkerConfirmUnsilenceContent = vh7.f.a(r100, LinkerConfirmUnsilenceContent.class);
        goto L3
    L40:
        this.linkerPrepareReplyContent = vh7.f.a(r100, LinkerPrepareReplyContent.class);
        goto L3
    L41:
        this.linkerPrepareInviteContent = vh7.f.a(r100, LinkerPrepareInviteContent.class);
        goto L3
    L42:
        this.linkerRemoveWaitingUserContent = new LinkerRemoveWaitingUserContent(r100);
        goto L3
    L31:
        switch(r102) {
            case 67: goto L38;
            case 68: goto L37;
            case 69: goto L36;
            case 70: goto L35;
            case 71: goto L34;
            case 72: goto L33;
            default: goto L32;
        };
    L33:
        this.linkerLiveCoreBizTagChangeContent = vh7.f.a(r100, ILinkerLiveCoreBizTagChangeContent.class);
        goto L3
    L34:
        this.linkerClientUIInfoChangeContent = vh7.f.a(r100, ILinkerClientUIInfoChangeContent.class);
        goto L3
    L35:
        this.enlargeUpdateContent = new LinkerEnlargeUpdateContent(r100);
        goto L3
    L36:
        this.updateLinkTypeForceOpenCameraContent = vh7.f.a(r100, ILinkerUpdateLinkTypeForceOpenCameraContent.class);
        goto L3
    L37:
        this.linkerAudienceWaitingListChangeContent = new LinkerAudienceWaitingListChangeContent(r100);
        goto L3
    L38:
        this.linkerInitChatRoomContent = new LinkerInitChatRoomContent(r100);
        goto L3
    L32:
        am3.h.d(r103, r100);
    L84:
        this.mCreate = new LinkerCreateContent(r100);
        goto L3
    L91:
        r100.d(r101);
        getDelegate().setThreadSafe(true);
        this.type = MessageType.LINKER;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.h1>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.h1>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public long getReceiveNtpTimeFlex(long r100) {
        return getReceiveNtpTime(r100);
    }

    public final void setEnlargeUpdateContent(LinkerEnlargeUpdateContent r100) {
        this.enlargeUpdateContent = r100;
    }

    public void setExtraStr(String r100) {
        this.extraStr = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public void setLinkRoomFightCancelInviteContent(com.bytedance.android.live.base.model.data.g r100) {
        vh7.c r101 = jm2.a.d(r100);
        if ((r101 instanceof LinkRoomFightCancelInviteContent) == true) goto L5;
        r101 = null;
    L5:
        this._linkRoomFightCancelInviteContent = (LinkRoomFightCancelInviteContent) r101;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public void setLinkRoomFightInviteContent(com.bytedance.android.live.base.model.data.h r100) {
        vh7.c r101 = jm2.a.d(r100);
        if ((r101 instanceof LinkRoomFightInviteContent) == true) goto L5;
        r101 = null;
    L5:
        this._linkRoomFightInviteContent = (LinkRoomFightInviteContent) r101;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public void setLinkRoomFightReplyContent(ILinkRoomFightReplyContent r100) {
        vh7.c r101 = jm2.a.d(r100);
        if ((r101 instanceof LinkRoomFightReplyContent) == true) goto L5;
        r101 = null;
    L5:
        this._linkRoomFightReplyContent = (LinkRoomFightReplyContent) r101;
    }

    public final void setLinkerApplyRankChangeContent(LinkerApplyRankChangeContent r100) {
        this.linkerApplyRankChangeContent = r100;
    }

    public final void setLinkerAudienceWaitingListChangeContent(LinkerAudienceWaitingListChangeContent r100) {
        this.linkerAudienceWaitingListChangeContent = r100;
    }

    public void setLinkerBaseInfo(LinkerBaseInfo r100) {
        this.linkerBaseInfo = r100;
    }

    public void setLinkerBattleConnectContent(LinkerBattleConnectContent r100) {
        this.linkerBattleConnectContent = r100;
    }

    public void setLinkerChangeMediaInfoContent(LinkerChangeMediaInfoContent r100) {
        this.linkerChangeMediaInfoContent = r100;
    }

    public void setLinkerClientUIInfoChangeContent(ILinkerClientUIInfoChangeContent r100) {
        this.linkerClientUIInfoChangeContent = r100;
    }

    public void setLinkerConfirmUnsilenceContent(LinkerConfirmUnsilenceContent r100) {
        this.linkerConfirmUnsilenceContent = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public void setLinkerCrossRoomUpdateContentExt(com.bytedance.android.live.base.model.data.i r100) {
        vh7.c r101 = jm2.a.d(r100);
        if ((r101 instanceof LinkRoomFightUpdateContent) == true) goto L5;
        r101 = null;
    L5:
        this.linkerCrossRoomUpdateContent = (LinkRoomFightUpdateContent) r101;
    }

    public void setLinkerDegradeAlertContent(com.bytedance.android.livesdk.message.linker.j r100) {
        this.linkerDegradeAlertContent = r100;
    }

    public void setLinkerEnlargeGuestApplyContent(LinkerEnlargeGuestApplyContent r100) {
        this.linkerEnlargeGuestApplyContent = r100;
    }

    public void setLinkerEnlargeGuestInviteContent(com.bytedance.android.livesdk.message.linker.k r100) {
        this.linkerEnlargeGuestInviteContent = r100;
    }

    public void setLinkerId(long r100) {
        this.linkerId = r100;
    }

    public void setLinkerInitChatRoomContent(LinkerInitChatRoomContent r100) {
        this.linkerInitChatRoomContent = r100;
    }

    public void setLinkerInvitePrepareContent(LinkerInvitePrepareContent r100) {
        this.linkerInvitePrepareContent = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h1
    public void setLinkerLiveCoreBizTagChangeContent(ILinkerLiveCoreBizTagChangeContent r100) {
        this.linkerLiveCoreBizTagChangeContent = r100;
    }

    public void setLinkerPrepareInviteContent(LinkerPrepareInviteContent r100) {
        this.linkerPrepareInviteContent = r100;
    }

    public void setLinkerPrepareReplyContent(LinkerPrepareReplyContent r100) {
        this.linkerPrepareReplyContent = r100;
    }

    public void setLinkerRemoveWaitingUserContent(LinkerRemoveWaitingUserContent r100) {
        this.linkerRemoveWaitingUserContent = r100;
    }

    public final void setLinkerResumeApplyContent(LinkerResumeApplyContent r100) {
        this.linkerResumeApplyContent = r100;
    }

    public void setLinkerResumeAudienceContent(LinkerResumeAudienceContent r100) {
        this.linkerResumeAudienceContent = r100;
    }

    public void setLinkerUILayoutChangeContent(LinkerUILayoutChangeContent r100) {
        this.linkerUILayoutChangeContent = r100;
    }

    public void setMChangePlayModeContent(LinkerChangePlayModeContent r100) {
        this.mChangePlayModeContent = r100;
    }

    public void setMFollowStrongGuideContent(LinkerFollowStrongGuideContent r100) {
        this.mFollowStrongGuideContent = r100;
    }

    public void setMKickOut(LinkerKickOutContent r100) {
        this.mKickOut = r100;
    }

    public void setMLowBalanceForPaidLinkContent(LinkerLowBalanceForPaidLinkmicContent r100) {
        this.mLowBalanceForPaidLinkContent = r100;
    }

    public final void setMPublicAreaCommon(PublicAreaCommon r100) {
        this.mPublicAreaCommon = r100;
    }

    public void setMType(int r100) {
        this.mType = r100;
    }

    public void setPublicAreaCommon(PublicAreaCommon r100) {
        this.mPublicAreaCommon = r100;
    }

    public void setRtcActionContent(ILinkerRTCActionContent r100) {
        this.rtcActionContent = r100;
    }

    public void setUpdateLinkTypeForceOpenCameraContent(ILinkerUpdateLinkTypeForceOpenCameraContent r100) {
        this.updateLinkTypeForceOpenCameraContent = r100;
    }

    public final void set_linkRoomFightCancelInviteContent(LinkRoomFightCancelInviteContent r100) {
        this._linkRoomFightCancelInviteContent = r100;
    }

    public final void set_linkRoomFightInviteContent(LinkRoomFightInviteContent r100) {
        this._linkRoomFightInviteContent = r100;
    }

    public final void set_linkRoomFightReplyContent(LinkRoomFightReplyContent r100) {
        this._linkRoomFightReplyContent = r100;
    }

    public final void set_mLinkerSysKickOutContent(LinkerSysKickOutContent r100) {
        this._mLinkerSysKickOutContent = r100;
    }
}
