package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.UserHighScoreSongTag;
import com.bytedance.android.livesdk.message.model.fc;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 Ç\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002È\u0001B\t¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003J\u0013\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\f\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u0010+\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b+\u0010#\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\"\u0010.\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R\"\u00101\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R$\u00105\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R*\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bA\u0010\u001a\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010\u001eR\"\u0010D\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bD\u0010\u001a\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010\u001eR$\u0010G\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bG\u00106\u001a\u0004\bH\u00108\"\u0004\bI\u0010:R\"\u0010J\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bJ\u0010#\u001a\u0004\bK\u0010%\"\u0004\bL\u0010'R\"\u0010M\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bM\u0010#\u001a\u0004\bN\u0010%\"\u0004\bO\u0010'R\"\u0010P\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bP\u0010\r\u001a\u0004\bQ\u0010\u000e\"\u0004\bR\u0010\u0010R\"\u0010S\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bS\u0010\r\u001a\u0004\bS\u0010\u000e\"\u0004\bT\u0010\u0010R$\u0010U\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bU\u00106\u001a\u0004\bV\u00108\"\u0004\bW\u0010:R$\u0010X\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bX\u00106\u001a\u0004\bY\u00108\"\u0004\bZ\u0010:R$\u0010[\u001a\u0004\u0018\u0001048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b[\u00106\u001a\u0004\b\\\u00108\"\u0004\b]\u0010:R\"\u0010^\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b^\u0010\u001a\u001a\u0004\b_\u0010\u001c\"\u0004\b`\u0010\u001eR\"\u0010a\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\ba\u0010\u001a\u001a\u0004\bb\u0010\u001c\"\u0004\bc\u0010\u001eR\"\u0010d\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bd\u0010\r\u001a\u0004\bd\u0010\u000e\"\u0004\be\u0010\u0010R\"\u0010f\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bf\u0010\u001a\u001a\u0004\bg\u0010\u001c\"\u0004\bh\u0010\u001eR\"\u0010i\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bi\u0010\r\u001a\u0004\bi\u0010\u000e\"\u0004\bj\u0010\u0010R$\u0010l\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR$\u0010r\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\br\u0010\u0013\u001a\u0004\bs\u0010\u0015\"\u0004\bt\u0010\u0017R\"\u0010u\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bu\u0010#\u001a\u0004\bv\u0010%\"\u0004\bw\u0010'R\"\u0010x\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bx\u0010\u001a\u001a\u0004\by\u0010\u001c\"\u0004\bz\u0010\u001eR&\u0010|\u001a\u0004\u0018\u00010{8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R,\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R&\u0010\u0089\u0001\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010\r\u001a\u0005\b\u008a\u0001\u0010\u000e\"\u0005\b\u008b\u0001\u0010\u0010R/\u0010\u008d\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010<\u001a\u0005\b\u008e\u0001\u0010>\"\u0005\b\u008f\u0001\u0010@R,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u0097\u0001\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010\u001a\u001a\u0005\b\u0098\u0001\u0010\u001c\"\u0005\b\u0099\u0001\u0010\u001eR&\u0010\u009a\u0001\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010\r\u001a\u0005\b\u009a\u0001\u0010\u000e\"\u0005\b\u009b\u0001\u0010\u0010R&\u0010\u009c\u0001\u001a\u0002048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u00106\u001a\u0005\b\u009d\u0001\u00108\"\u0005\b\u009e\u0001\u0010:R,\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R,\u0010©\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b§\u0001\u0010\u0015\"\u0005\b¨\u0001\u0010\u0017R<\u0010¬\u0001\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00032\u0011\u0010¦\u0001\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bª\u0001\u0010>\"\u0005\b«\u0001\u0010@R0\u0010²\u0001\u001a\u0005\u0018\u00010\u00ad\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010\u00ad\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R,\u0010µ\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b³\u0001\u0010\u0015\"\u0005\b´\u0001\u0010\u0017R0\u0010»\u0001\u001a\u0005\u0018\u00010¶\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010¶\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R0\u0010Á\u0001\u001a\u0005\u0018\u00010¼\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010¼\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R0\u0010Ä\u0001\u001a\u0005\u0018\u00010\u0090\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010\u0090\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÂ\u0001\u0010\u0094\u0001\"\u0006\bÃ\u0001\u0010\u0096\u0001¨\u0006É\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "other", "", "isSameKtvMusic", "", "equals", "", "hashCode", "isHasApplied", "Z", "()Z", "setHasApplied", "(Z)V", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "linkmicId", "J", "getLinkmicId", "()J", "setLinkmicId", "(J)V", "modifyTime", "getModifyTime", "setModifyTime", "mLinkStatus", "I", "getMLinkStatus", "()I", "setMLinkStatus", "(I)V", "mLinkType", "getMLinkType", "setMLinkType", "mRoleType", "getMRoleType", "setMRoleType", "userPosition", "getUserPosition", "setUserPosition", "silenceStatus", "getSilenceStatus", "setSilenceStatus", "", "linkmicIdStr", "Ljava/lang/String;", "getLinkmicIdStr", "()Ljava/lang/String;", "setLinkmicIdStr", "(Ljava/lang/String;)V", "songList", "Ljava/util/List;", "getSongList", "()Ljava/util/List;", "setSongList", "(Ljava/util/List;)V", "appId", "getAppId", "setAppId", "clientVersion", "getClientVersion", "setClientVersion", "devicePlatform", "getDevicePlatform", "setDevicePlatform", "listUserType", "getListUserType", "setListUserType", "listUserFromType", "getListUserFromType", "setListUserFromType", "hasExpired", "getHasExpired", "setHasExpired", "isMutualFollow", "setMutualFollow", "applyReason", "getApplyReason", "setApplyReason", "last7DaysGiftCountTxt", "getLast7DaysGiftCountTxt", "setLast7DaysGiftCountTxt", "fanTicket", "getFanTicket", "setFanTicket", "offset", "getOffset", "setOffset", "rank", "getRank", "setRank", "isAddPrice", "setAddPrice", "addPriceTime", "getAddPriceTime", "setAddPriceTime", "isAnonymous", "setAnonymous", "Lcom/bytedance/android/live/liveinteract/plantform/model/MicPosTagInfo;", "micPosTag", "Lcom/bytedance/android/live/liveinteract/plantform/model/MicPosTagInfo;", "getMicPosTag", "()Lcom/bytedance/android/live/liveinteract/plantform/model/MicPosTagInfo;", "setMicPosTag", "(Lcom/bytedance/android/live/liveinteract/plantform/model/MicPosTagInfo;)V", "invitor", "getInvitor", "setInvitor", "applyType", "getApplyType", "setApplyType", "paidAmount", "getPaidAmount", "setPaidAmount", "Lcom/bytedance/android/live/liveinteract/plantform/model/TeamFightJoinTeamInfo;", "joinTeamFightInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/TeamFightJoinTeamInfo;", "getJoinTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/TeamFightJoinTeamInfo;", "setJoinTeamFightInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/TeamFightJoinTeamInfo;)V", "Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "userHighScoreSongTag", "Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "getUserHighScoreSongTag", "()Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "setUserHighScoreSongTag", "(Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;)V", "alreadyInvited", "getAlreadyInvited", "setAlreadyInvited", "Lcom/bytedance/android/live/liveinteract/plantform/model/v;", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "eventInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "getEventInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "setEventInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/c0;)V", "orderedSongCount", "getOrderedSongCount", "setOrderedSongCount", "isActive", "setActive", "buttonText", "getButtonText", "setButtonText", "Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "tag", "Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "getTag", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "setTag", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;)V", "value", "getUserFlex", "setUserFlex", "userFlex", "getSongListFlex", "setSongListFlex", "songListFlex", "Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "getMicPosTagFlex", "()Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "setMicPosTagFlex", "(Lcom/bytedance/android/live/liveinteract/plantform/model/g0;)V", "micPosTagFlex", "getInvitorFlex", "setInvitorFlex", "invitorFlex", "Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "getJoinTeamFightInfoFlex", "()Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "setJoinTeamFightInfoFlex", "(Lcom/bytedance/android/live/liveinteract/plantform/model/j0;)V", "joinTeamFightInfoFlex", "Lcom/bytedance/android/livesdk/message/model/fc;", "getUserHighScoreSongTagFlex", "()Lcom/bytedance/android/livesdk/message/model/fc;", "setUserHighScoreSongTagFlex", "(Lcom/bytedance/android/livesdk/message/model/fc;)V", "userHighScoreSongTagFlex", "getEventInfoFlex", "setEventInfoFlex", "eventInfoFlex", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class WaitingListUser extends FlexModelBase<n0> implements n0, vh7.h {
    public static final a Companion = null;
    private static final int HASH_CODE_37 = 37;

    @SerializedName("add_price_time_ms")
    protected long addPriceTime;

    @IgnoreProtoFieldCheck
    @SerializedName("already_invited")
    protected boolean alreadyInvited;

    @SerializedName("app_id")
    protected long appId;

    @SerializedName("application_reason")
    protected String applyReason;

    @SerializedName(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE)
    protected int applyType;

    @SerializedName("button_text")
    protected String buttonText;

    @SerializedName("client_version")
    protected long clientVersion;

    @SerializedName("device_platform")
    protected String devicePlatform;

    @SerializedName("event_info")
    protected c0 eventInfo;

    @SerializedName("fan_ticket")
    protected String fanTicket;

    @SerializedName("application_has_expired")
    protected boolean hasExpired;

    @SerializedName("invitor")
    protected IBaseUser invitor;

    @SerializedName("is_active")
    protected boolean isActive;

    @SerializedName("is_add_price")
    protected boolean isAddPrice;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS)
    protected boolean isAnonymous;
    private transient boolean isHasApplied;

    @SerializedName("is_mutual_following")
    protected boolean isMutualFollow;

    @SerializedName("join_teamfight_info")
    protected TeamFightJoinTeamInfo joinTeamFightInfo;

    @SerializedName("last_7_days_gift_count_text")
    protected String last7DaysGiftCountTxt;

    @SerializedName("linkmic_id")
    protected long linkmicId;

    @SerializedName("linkmic_id_str")
    protected String linkmicIdStr;

    @SerializedName("list_user_from_type")
    protected int listUserFromType;

    @SerializedName("list_user_type")
    protected int listUserType;

    @SerializedName("link_status")
    protected int mLinkStatus;

    @SerializedName("link_type")
    protected int mLinkType;

    @SerializedName("role_type")
    protected int mRoleType;

    @SerializedName("mic_pos_tag_info")
    protected MicPosTagInfo micPosTag;

    @SerializedName("modify_time")
    protected long modifyTime;

    @SerializedName("offset")
    protected long offset;

    @SerializedName("order_song_count")
    protected long orderedSongCount;

    @SerializedName("paid_amount")
    protected long paidAmount;

    @SerializedName("rank")
    protected long rank;

    @SerializedName("silence_status")
    protected int silenceStatus;

    @SerializedName("song_list")
    protected List<KtvMusic> songList;

    @SerializedName("tag")
    protected ListUserTag tag;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    protected List<? extends v> tags;

    @SerializedName("user")
    protected IBaseUser user;

    @SerializedName("high_score_song_tag")
    protected UserHighScoreSongTag userHighScoreSongTag;

    @SerializedName("user_position")
    protected int userPosition;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public WaitingListUser() {
        super(n0.class);
        this.linkmicIdStr = "";
        this.devicePlatform = "";
        this.buttonText = "";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public c0 getEventInfoFlex() {
        return getEventInfo();
    }

    public int hashCode() {
        int r100 = 1231;
        if (isHasApplied() == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 37;
        IBaseUser r103 = this.user;
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.hashCode();
    L10:
        long r106 = getLinkmicId();
        int r107 = (((r102 + r105) * 37) + ((int) (r106 ^ (r106 >>> 32)))) * 37;
        long r108 = getModifyTime();
        int r109 = (((((((((((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 37) + getMLinkStatus()) * 37) + getMLinkType()) * 37) + getMRoleType()) * 37) + getUserPosition()) * 37) + getSilenceStatus()) * 37;
        String r110 = getLinkmicIdStr();
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 37;
        List<KtvMusic> r113 = this.songList;
        if (r113 == null) goto L17;
        int r114 = r113.hashCode();
    L18:
        int r115 = (r112 + r114) * 37;
        long r116 = getAppId();
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 37;
        long r118 = getClientVersion();
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 37;
        String r120 = getDevicePlatform();
        if (r120 == null) goto L21;
        int r121 = r120.hashCode();
    L22:
        int r122 = (((((r119 + r121) * 37) + getListUserType()) * 37) + getListUserFromType()) * 37;
        if (getHasExpired() == false) goto L25;
        int r123 = 1231;
    L26:
        int r124 = (r122 + r123) * 37;
        if (isMutualFollow() == false) goto L29;
        int r125 = 1231;
    L30:
        int r126 = (r124 + r125) * 37;
        String r127 = getApplyReason();
        if (r127 == null) goto L33;
        int r128 = r127.hashCode();
    L34:
        int r129 = (r126 + r128) * 37;
        String r130 = getLast7DaysGiftCountTxt();
        if (r130 == null) goto L37;
        int r131 = r130.hashCode();
    L38:
        int r132 = (r129 + r131) * 37;
        String r133 = getFanTicket();
        if (r133 == null) goto L41;
        int r134 = r133.hashCode();
    L42:
        int r135 = (r132 + r134) * 37;
        long r136 = getOffset();
        int r137 = (r135 + ((int) (r136 ^ (r136 >>> 32)))) * 37;
        long r138 = getRank();
        int r139 = (r137 + ((int) (r138 ^ (r138 >>> 32)))) * 37;
        if (isAddPrice() == false) goto L45;
        int r140 = 1231;
    L46:
        int r141 = (r139 + r140) * 37;
        long r142 = getAddPriceTime();
        int r143 = (r141 + ((int) (r142 ^ (r142 >>> 32)))) * 37;
        if (isAnonymous() == true) goto L50;
        r100 = 1237;
    L50:
        int r144 = (r143 + r100) * 37;
        MicPosTagInfo r145 = this.micPosTag;
        if (r145 == null) goto L53;
        int r146 = r145.hashCode();
    L54:
        int r147 = (r144 + r146) * 37;
        IBaseUser r148 = this.invitor;
        if (r148 == null) goto L57;
        int r149 = r148.hashCode();
    L58:
        int r150 = (((r147 + r149) * 37) + getApplyType()) * 37;
        TeamFightJoinTeamInfo r151 = this.joinTeamFightInfo;
        if (r151 == null) goto L62;
        r104 = r151.hashCode();
    L62:
        return r150 + r104;
    L57:
        r149 = 0;
        goto L58
    L53:
        r146 = 0;
        goto L54
    L45:
        r140 = 1237;
        goto L46
    L41:
        r134 = 0;
        goto L42
    L37:
        r131 = 0;
        goto L38
    L33:
        r128 = 0;
        goto L34
    L29:
        r125 = 1237;
        goto L30
    L25:
        r123 = 1237;
        goto L26
    L21:
        r121 = 0;
        goto L22
    L17:
        r114 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getAddPriceTime() {
        return this.addPriceTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean getAlreadyInvited() {
        return this.alreadyInvited;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getAppId() {
        return this.appId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getApplyReason() {
        return this.applyReason;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getApplyType() {
        return this.applyType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getButtonText() {
        return this.buttonText;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getClientVersion() {
        return this.clientVersion;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getDevicePlatform() {
        return this.devicePlatform;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public c0 getEventInfo() {
        return this.eventInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getFanTicket() {
        return this.fanTicket;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean getHasExpired() {
        return this.hasExpired;
    }

    public final IBaseUser getInvitor() {
        return this.invitor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public IBaseUser getInvitorFlex() {
        return this.invitor;
    }

    public final TeamFightJoinTeamInfo getJoinTeamFightInfo() {
        return this.joinTeamFightInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public j0 getJoinTeamFightInfoFlex() {
        return this.joinTeamFightInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getLast7DaysGiftCountTxt() {
        return this.last7DaysGiftCountTxt;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getLinkmicId() {
        return this.linkmicId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public String getLinkmicIdStr() {
        return this.linkmicIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getListUserFromType() {
        return this.listUserFromType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getListUserType() {
        return this.listUserType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getMLinkStatus() {
        return this.mLinkStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getMLinkType() {
        return this.mLinkType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getMRoleType() {
        return this.mRoleType;
    }

    public final MicPosTagInfo getMicPosTag() {
        return this.micPosTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public g0 getMicPosTagFlex() {
        return this.micPosTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getModifyTime() {
        return this.modifyTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getOffset() {
        return this.offset;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getOrderedSongCount() {
        return this.orderedSongCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getPaidAmount() {
        return this.paidAmount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public long getRank() {
        return this.rank;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getSilenceStatus() {
        return this.silenceStatus;
    }

    public final List<KtvMusic> getSongList() {
        return this.songList;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public List<KtvMusic> getSongListFlex() {
        return this.songList;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public ListUserTag getTag() {
        return this.tag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public List<v> getTags() {
        return this.tags;
    }

    public final IBaseUser getUser() {
        return this.user;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public IBaseUser getUserFlex() {
        return this.user;
    }

    public final UserHighScoreSongTag getUserHighScoreSongTag() {
        return this.userHighScoreSongTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public fc getUserHighScoreSongTagFlex() {
        return this.userHighScoreSongTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public int getUserPosition() {
        return this.userPosition;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean isAddPrice() {
        return this.isAddPrice;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean isHasApplied() {
        return this.isHasApplied;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public boolean isMutualFollow() {
        return this.isMutualFollow;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v31, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v39, types: [com.bytedance.android.live.liveinteract.plantform.model.c0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v43, types: [com.bytedance.android.live.liveinteract.plantform.model.ListUserTag, java.lang.Object] */
    public WaitingListUser(am3.g r100) {
        super(n0.class);
        this.songList = new ArrayList();
        this.tags = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L47;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L46;
            case 2: goto L45;
            case 3: goto L44;
            case 4: goto L43;
            case 5: goto L42;
            case 6: goto L41;
            case 7: goto L40;
            case 8: goto L39;
            case 9: goto L38;
            case 10: goto L36;
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L33;
            case 14: goto L32;
            case 15: goto L31;
            case 16: goto L30;
            case 17: goto L29;
            case 18: goto L28;
            case 19: goto L27;
            case 20: goto L26;
            case 21: goto L25;
            case 22: goto L24;
            case 23: goto L23;
            case 24: goto L22;
            case 25: goto L7;
            case 26: goto L21;
            case 27: goto L20;
            case 28: goto L19;
            case 29: goto L18;
            case 30: goto L17;
            case 31: goto L16;
            case 32: goto L15;
            case 33: goto L14;
            case 34: goto L13;
            case 35: goto L12;
            case 36: goto L11;
            case 37: goto L10;
            case 38: goto L9;
            case 39: goto L8;
            default: goto L7;
        };
    L8:
        this.tag = vh7.f.a(r100, ListUserTag.class);
        goto L3
    L9:
        this.buttonText = am3.h.c(r100);
        goto L3
    L10:
        this.isActive = am3.h.a(r100);
        goto L3
    L11:
        this.eventInfo = vh7.f.a(r100, c0.class);
        goto L3
    L12:
        List r104 = this.tags;
        Object r105 = vh7.f.a(r100, v.class);
    L37:
        r104.add(r105);
        goto L3
    L13:
        this.orderedSongCount = r100.j();
        goto L3
    L14:
        this.alreadyInvited = am3.h.a(r100);
        goto L3
    L15:
        this.userHighScoreSongTag = new UserHighScoreSongTag(r100);
        goto L3
    L16:
        this.applyType = r100.i();
        goto L3
    L17:
        this.invitor = vh7.f.a(r100, IBaseUser.class);
        goto L3
    L18:
        this.joinTeamFightInfo = q1.a(r100);
        goto L3
    L19:
        this.paidAmount = r100.j();
        goto L3
    L20:
        this.isAnonymous = am3.h.a(r100);
        goto L3
    L21:
        this.micPosTag = new MicPosTagInfo(r100);
        goto L3
    L22:
        this.addPriceTime = r100.j();
        goto L3
    L23:
        this.isAddPrice = am3.h.a(r100);
        goto L3
    L24:
        this.rank = r100.j();
        goto L3
    L25:
        this.offset = r100.j();
        goto L3
    L26:
        this.fanTicket = am3.h.c(r100);
        goto L3
    L27:
        this.last7DaysGiftCountTxt = am3.h.c(r100);
        goto L3
    L28:
        this.applyReason = am3.h.c(r100);
        goto L3
    L29:
        this.isMutualFollow = am3.h.a(r100);
        goto L3
    L30:
        this.hasExpired = am3.h.a(r100);
        goto L3
    L31:
        this.listUserFromType = r100.i();
        goto L3
    L32:
        this.listUserType = r100.i();
        goto L3
    L33:
        this.devicePlatform = am3.h.c(r100);
        goto L3
    L34:
        this.clientVersion = r100.j();
        goto L3
    L35:
        this.appId = r100.j();
        goto L3
    L36:
        r104 = this.songList;
        r105 = new KtvMusic(r100);
        goto L37
    L38:
        this.linkmicIdStr = am3.h.c(r100);
        goto L3
    L39:
        this.silenceStatus = r100.i();
        goto L3
    L40:
        this.userPosition = (int) r100.j();
        goto L3
    L41:
        this.mRoleType = r100.i();
        goto L3
    L42:
        this.mLinkType = r100.i();
        goto L3
    L43:
        this.mLinkStatus = r100.i();
        goto L3
    L44:
        this.modifyTime = r100.j();
        goto L3
    L45:
        this.linkmicId = r100.j();
        goto L3
    L46:
        this.user = vh7.f.a(r100, IBaseUser.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L47:
        r100.d(r101);
        setThreadSafe(true);
        if (this.linkmicIdStr != null) goto L51;
        this.linkmicIdStr = "";
    L51:
        if (this.devicePlatform != null) goto L54;
        this.devicePlatform = "";
    L54:
        if (this.buttonText != null) goto L136;
        this.buttonText = "";
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(WaitingListUser.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L105;
        n0 r102 = (n0) r100;
        if (isHasApplied() == r102.isHasApplied()) goto L16;
    L19:
        IBaseUser r103 = this.user;
        if (r103 != null) goto L22;
    L77:
        MicPosTagInfo r104 = this.micPosTag;
        if (r104 != null) goto L80;
    L85:
        IBaseUser r105 = this.invitor;
        if (r105 == null) goto L97;
        Intrinsics.checkNotNull(r105);
        if (Intrinsics.areEqual(r105, r102.getInvitorFlex()) == false) goto L97;
        if (getApplyType() != r102.getApplyType()) goto L97;
        if (getPaidAmount() != r102.getPaidAmount()) goto L97;
        if (this.joinTeamFightInfo != null) goto L97;
        if (r102.getJoinTeamFightInfoFlex() != null) goto L97;
        return true;
    L97:
        TeamFightJoinTeamInfo r106 = this.joinTeamFightInfo;
        if (r106 != null) goto L100;
    L102:
        return false;
    L100:
        if (Intrinsics.areEqual(r106, r102.getJoinTeamFightInfoFlex()) == false) goto L102;
        return true;
    L80:
        if (Intrinsics.areEqual(r104, r102.getMicPosTagFlex()) == false) goto L85;
        if (this.invitor != null) goto L85;
        if (r102.getInvitorFlex() != null) goto L85;
        return true;
    L22:
        if (Intrinsics.areEqual(r103, r102.getUserFlex()) == false) goto L77;
        if (getLinkmicId() != r102.getLinkmicId()) goto L77;
        if (getModifyTime() != r102.getModifyTime()) goto L77;
        if (getMLinkStatus() != r102.getMLinkStatus()) goto L77;
        if (getMLinkType() != r102.getMLinkType()) goto L77;
        if (getMRoleType() != r102.getMRoleType()) goto L77;
        if (getUserPosition() != r102.getUserPosition()) goto L77;
        if (getSilenceStatus() != r102.getSilenceStatus()) goto L77;
        if (Intrinsics.areEqual(getLinkmicIdStr(), r102.getLinkmicIdStr()) == false) goto L77;
        if (isSameKtvMusic(r102.getSongListFlex()) == false) goto L77;
        if (getOrderedSongCount() != r102.getOrderedSongCount()) goto L77;
        if (getAppId() != r102.getAppId()) goto L77;
        if (getClientVersion() != r102.getClientVersion()) goto L77;
        if (Intrinsics.areEqual(getDevicePlatform(), r102.getDevicePlatform()) == false) goto L77;
        if (getListUserType() != r102.getListUserType()) goto L77;
        if (getListUserFromType() != r102.getListUserFromType()) goto L77;
        if (getHasExpired() != r102.getHasExpired()) goto L77;
        if (isMutualFollow() != r102.isMutualFollow()) goto L77;
        if (TextUtils.equals(getApplyReason(), r102.getApplyReason()) == false) goto L77;
        if (TextUtils.equals(getLast7DaysGiftCountTxt(), r102.getLast7DaysGiftCountTxt()) == false) goto L77;
        if (TextUtils.equals(getFanTicket(), r102.getFanTicket()) == false) goto L77;
        if (getOffset() != r102.getOffset()) goto L77;
        if (getRank() != r102.getRank()) goto L77;
        if (isAddPrice() != r102.isAddPrice()) goto L77;
        if (getAddPriceTime() != r102.getAddPriceTime()) goto L77;
        if (isAnonymous() != r102.isAnonymous()) goto L77;
        if (this.micPosTag != null) goto L77;
        if (r102.getMicPosTagFlex() != null) goto L77;
        return true;
    L16:
        if (this.user != null) goto L19;
        if (r102.getUserFlex() != null) goto L19;
        return true;
    L105:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.IWaitingListUser");
    L8:
        r101 = null;
        goto L10
    }

    public final boolean isSameKtvMusic(List<KtvMusic> r100) {
        List<KtvMusic> r101 = this.songList;
        if (r101 != null) goto L7;
        if (r100 != null) goto L7;
        return true;
    L7:
        if (r101 == null) goto L17;
        if (r100 == null) goto L17;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.size();
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L16;
        List<KtvMusic> r104 = this.songList;
        Intrinsics.checkNotNull(r104);
        if (((KtvMusic) ListProtector.get(r104, r103)).isSameKtvMusic((KtvMusic) ListProtector.get(r100, r103)) == false) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L17:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setActive(boolean r100) {
        this.isActive = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setAddPrice(boolean r100) {
        this.isAddPrice = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setAddPriceTime(long r100) {
        this.addPriceTime = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setAlreadyInvited(boolean r100) {
        this.alreadyInvited = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setAnonymous(boolean r100) {
        this.isAnonymous = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setAppId(long r100) {
        this.appId = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setApplyReason(String r100) {
        this.applyReason = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setApplyType(int r100) {
        this.applyType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setButtonText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.buttonText = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setClientVersion(long r100) {
        this.clientVersion = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setDevicePlatform(String r100) {
        this.devicePlatform = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setEventInfo(c0 r100) {
        this.eventInfo = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setEventInfoFlex(c0 r100) {
        setEventInfo((ListUserEventInfo) r100);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setFanTicket(String r100) {
        this.fanTicket = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setHasApplied(boolean r100) {
        this.isHasApplied = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setHasExpired(boolean r100) {
        this.hasExpired = r100;
    }

    public final void setInvitor(IBaseUser r100) {
        this.invitor = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setInvitorFlex(IBaseUser r100) {
        if (r100 == null) goto L6;
        this.invitor = r100;
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUser");
    }

    public final void setJoinTeamFightInfo(TeamFightJoinTeamInfo r100) {
        this.joinTeamFightInfo = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setJoinTeamFightInfoFlex(j0 r100) {
        if ((r100 instanceof TeamFightJoinTeamInfo) == true) goto L5;
        r100 = null;
    L5:
        this.joinTeamFightInfo = (TeamFightJoinTeamInfo) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setLast7DaysGiftCountTxt(String r100) {
        this.last7DaysGiftCountTxt = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setLinkmicId(long r100) {
        this.linkmicId = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setLinkmicIdStr(String r100) {
        this.linkmicIdStr = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setListUserFromType(int r100) {
        this.listUserFromType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setListUserType(int r100) {
        this.listUserType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setMLinkStatus(int r100) {
        this.mLinkStatus = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setMLinkType(int r100) {
        this.mLinkType = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setMRoleType(int r100) {
        this.mRoleType = r100;
    }

    public final void setMicPosTag(MicPosTagInfo r100) {
        this.micPosTag = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setMicPosTagFlex(g0 r100) {
        if (r100 == null) goto L6;
        this.micPosTag = (MicPosTagInfo) r100;
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setModifyTime(long r100) {
        this.modifyTime = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setMutualFollow(boolean r100) {
        this.isMutualFollow = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setOffset(long r100) {
        this.offset = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setOrderedSongCount(long r100) {
        this.orderedSongCount = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setPaidAmount(long r100) {
        this.paidAmount = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setRank(long r100) {
        this.rank = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setSilenceStatus(int r100) {
        this.silenceStatus = r100;
    }

    public final void setSongList(List<KtvMusic> r100) {
        this.songList = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setSongListFlex(List<KtvMusic> r100) {
        this.songList = KotlinTypeUtilsKt.castElementType(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setTag(ListUserTag r100) {
        this.tag = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setTags(List<? extends v> r100) {
        this.tags = r100;
    }

    public final void setUser(IBaseUser r100) {
        this.user = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setUserFlex(IBaseUser r100) {
        this.user = r100;
    }

    public final void setUserHighScoreSongTag(UserHighScoreSongTag r100) {
        this.userHighScoreSongTag = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setUserHighScoreSongTagFlex(fc r100) {
        if ((r100 instanceof UserHighScoreSongTag) == true) goto L5;
        r100 = null;
    L5:
        this.userHighScoreSongTag = (UserHighScoreSongTag) r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.n0
    public void setUserPosition(int r100) {
        this.userPosition = r100;
    }
}
