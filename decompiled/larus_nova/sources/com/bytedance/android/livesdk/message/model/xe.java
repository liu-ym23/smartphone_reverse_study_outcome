package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.AudienceActionSource;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.plantform.model.LinkmicMediaInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MCUContent;
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.livesdk.chatroom.interact.model.RivalExtraInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdk.message.linker.AnchorLinkmicInfo;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LinkerGame;
import com.bytedance.android.livesdkapi.depend.model.live.linker.BanUser;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkMicMethod")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b]\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 É\u00032\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0003:\u0002Ê\u0003B\t¢\u0006\u0006\bÇ\u0003\u0010È\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J-\u0010\f\u001a\u00028\u0000\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u0010\u0014\u001a\u00020\u000fR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\"\u0010-\u001a\u00020,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\"\u00106\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010.\u001a\u0004\b7\u00100\"\u0004\b8\u00102R\"\u00109\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010.\u001a\u0004\b:\u00100\"\u0004\b;\u00102R\"\u0010<\u001a\u00020,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b<\u0010.\u001a\u0004\b=\u00100\"\u0004\b>\u00102R\"\u0010?\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b?\u0010$\u001a\u0004\b@\u0010&\"\u0004\bA\u0010(R\"\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010$\u001a\u0004\bC\u0010&\"\u0004\bD\u0010(R\"\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010$\u001a\u0004\bF\u0010&\"\u0004\bG\u0010(R$\u0010H\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u001b\u001a\u0004\bI\u0010\u001d\"\u0004\bJ\u0010\u001fR\"\u0010K\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010.\u001a\u0004\bL\u00100\"\u0004\bM\u00102R\"\u0010N\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010$\u001a\u0004\bO\u0010&\"\u0004\bP\u0010(R\"\u0010Q\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bQ\u0010$\u001a\u0004\bR\u0010&\"\u0004\bS\u0010(R$\u0010T\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bT\u0010\u001b\u001a\u0004\bU\u0010\u001d\"\u0004\bV\u0010\u001fR\"\u0010W\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010.\u001a\u0004\bX\u00100\"\u0004\bY\u00102R\"\u0010Z\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010$\u001a\u0004\b[\u0010&\"\u0004\b\\\u0010(R\"\u0010]\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010c\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bc\u0010\u001b\u001a\u0004\bd\u0010\u001d\"\u0004\be\u0010\u001fR$\u0010f\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bf\u0010\u001b\u001a\u0004\bg\u0010\u001d\"\u0004\bh\u0010\u001fR\"\u0010i\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u0010.\u001a\u0004\bj\u00100\"\u0004\bk\u00102R$\u0010l\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010\u001b\u001a\u0004\bm\u0010\u001d\"\u0004\bn\u0010\u001fR$\u0010o\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bo\u0010\u001b\u001a\u0004\bp\u0010\u001d\"\u0004\bq\u0010\u001fR\"\u0010r\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\br\u0010.\u001a\u0004\bs\u00100\"\u0004\bt\u00102R$\u0010u\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010\u001b\u001a\u0004\bv\u0010\u001d\"\u0004\bw\u0010\u001fR\"\u0010x\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bx\u0010\u001b\u001a\u0004\by\u0010\u001d\"\u0004\bz\u0010\u001fR\"\u0010{\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b{\u0010.\u001a\u0004\b|\u00100\"\u0004\b}\u00102R#\u0010~\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0004\b~\u0010$\u001a\u0004\b\u007f\u0010&\"\u0005\b\u0080\u0001\u0010(R&\u0010\u0081\u0001\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010.\u001a\u0005\b\u0082\u0001\u00100\"\u0005\b\u0083\u0001\u00102R&\u0010\u0084\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010$\u001a\u0005\b\u0085\u0001\u0010&\"\u0005\b\u0086\u0001\u0010(R(\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u001b\u001a\u0005\b\u0088\u0001\u0010\u001d\"\u0005\b\u0089\u0001\u0010\u001fR,\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R,\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R(\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010\u001b\u001a\u0005\b\u0099\u0001\u0010\u001d\"\u0005\b\u009a\u0001\u0010\u001fR,\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R(\u0010¢\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u0010\u001b\u001a\u0005\b£\u0001\u0010\u001d\"\u0005\b¤\u0001\u0010\u001fR(\u0010¥\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¥\u0001\u0010\u001b\u001a\u0005\b¦\u0001\u0010\u001d\"\u0005\b§\u0001\u0010\u001fR(\u0010¨\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u0010\u001b\u001a\u0005\b©\u0001\u0010\u001d\"\u0005\bª\u0001\u0010\u001fR(\u0010«\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b«\u0001\u0010\u001b\u001a\u0005\b¬\u0001\u0010\u001d\"\u0005\b\u00ad\u0001\u0010\u001fR&\u0010®\u0001\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010.\u001a\u0005\b¯\u0001\u00100\"\u0005\b°\u0001\u00102R(\u0010±\u0001\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010\u001b\u001a\u0005\b²\u0001\u0010\u001d\"\u0005\b³\u0001\u0010\u001fR&\u0010´\u0001\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010.\u001a\u0005\bµ\u0001\u00100\"\u0005\b¶\u0001\u00102R(\u0010·\u0001\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b·\u0001\u0010\u001b\u001a\u0005\b¸\u0001\u0010\u001d\"\u0005\b¹\u0001\u0010\u001fR(\u0010º\u0001\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bº\u0001\u0010\u001b\u001a\u0005\b»\u0001\u0010\u001d\"\u0005\b¼\u0001\u0010\u001fR(\u0010½\u0001\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010\u001b\u001a\u0005\b¾\u0001\u0010\u001d\"\u0005\b¿\u0001\u0010\u001fR,\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R,\u0010È\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R(\u0010Î\u0001\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÎ\u0001\u0010\u001b\u001a\u0005\bÏ\u0001\u0010\u001d\"\u0005\bÐ\u0001\u0010\u001fR(\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÑ\u0001\u0010\u001b\u001a\u0005\bÒ\u0001\u0010\u001d\"\u0005\bÓ\u0001\u0010\u001fR,\u0010Õ\u0001\u001a\u0005\u0018\u00010Ô\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÕ\u0001\u0010Ö\u0001\u001a\u0006\b×\u0001\u0010Ø\u0001\"\u0006\bÙ\u0001\u0010Ú\u0001R,\u0010Ü\u0001\u001a\u0005\u0018\u00010Û\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÜ\u0001\u0010Ý\u0001\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R,\u0010ã\u0001\u001a\u0005\u0018\u00010â\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0006\bå\u0001\u0010æ\u0001\"\u0006\bç\u0001\u0010è\u0001R&\u0010é\u0001\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bé\u0001\u0010$\u001a\u0005\bê\u0001\u0010&\"\u0005\bë\u0001\u0010(R&\u0010ì\u0001\u001a\u00020,8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bì\u0001\u0010.\u001a\u0005\bí\u0001\u00100\"\u0005\bî\u0001\u00102R&\u0010ï\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bï\u0001\u0010$\u001a\u0005\bð\u0001\u0010&\"\u0005\bñ\u0001\u0010(R&\u0010ò\u0001\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bò\u0001\u0010^\u001a\u0005\bò\u0001\u0010`\"\u0005\bó\u0001\u0010bR2\u0010õ\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010ô\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bõ\u0001\u0010ö\u0001\u001a\u0006\b÷\u0001\u0010ø\u0001\"\u0006\bù\u0001\u0010ú\u0001R&\u0010û\u0001\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bû\u0001\u0010$\u001a\u0005\bü\u0001\u0010&\"\u0005\bý\u0001\u0010(R)\u0010\u0080\u0002\u001a\f\u0012\u0005\u0012\u00030ÿ\u0001\u0018\u00010þ\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0080\u0002\u0010ö\u0001\u001a\u0006\b\u0081\u0002\u0010ø\u0001R3\u0010\u0083\u0002\u001a\f\u0012\u0005\u0012\u00030\u0082\u0002\u0018\u00010þ\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0083\u0002\u0010ö\u0001\u001a\u0006\b\u0084\u0002\u0010ø\u0001\"\u0006\b\u0085\u0002\u0010ú\u0001R&\u0010\u0086\u0002\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0086\u0002\u0010^\u001a\u0005\b\u0087\u0002\u0010`\"\u0005\b\u0088\u0002\u0010bR,\u0010\u008a\u0002\u001a\u0005\u0018\u00010\u0089\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008a\u0002\u0010\u008b\u0002\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002\"\u0006\b\u008e\u0002\u0010\u008f\u0002R,\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u0090\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0091\u0002\u0010\u0092\u0002\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002\"\u0006\b\u0095\u0002\u0010\u0096\u0002R&\u0010\u0097\u0002\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0097\u0002\u0010$\u001a\u0005\b\u0098\u0002\u0010&\"\u0005\b\u0099\u0002\u0010(R&\u0010\u009a\u0002\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u009a\u0002\u0010$\u001a\u0005\b\u009b\u0002\u0010&\"\u0005\b\u009c\u0002\u0010(R&\u0010\u009d\u0002\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009d\u0002\u0010$\u001a\u0005\b\u009e\u0002\u0010&\"\u0005\b\u009f\u0002\u0010(R,\u0010¡\u0002\u001a\u0005\u0018\u00010 \u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b¡\u0002\u0010¢\u0002\u001a\u0006\b£\u0002\u0010¤\u0002\"\u0006\b¥\u0002\u0010¦\u0002R&\u0010§\u0002\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b§\u0002\u0010$\u001a\u0005\b¨\u0002\u0010&\"\u0005\b©\u0002\u0010(R,\u0010«\u0002\u001a\u0005\u0018\u00010ª\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b«\u0002\u0010¬\u0002\u001a\u0006\b\u00ad\u0002\u0010®\u0002\"\u0006\b¯\u0002\u0010°\u0002R&\u0010±\u0002\u001a\u00020,8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b±\u0002\u0010.\u001a\u0005\b²\u0002\u00100\"\u0005\b³\u0002\u00102R,\u0010µ\u0002\u001a\u0005\u0018\u00010´\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bµ\u0002\u0010¶\u0002\u001a\u0006\b·\u0002\u0010¸\u0002\"\u0006\b¹\u0002\u0010º\u0002R&\u0010»\u0002\u001a\u00020,8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b»\u0002\u0010.\u001a\u0005\b¼\u0002\u00100\"\u0005\b½\u0002\u00102R&\u0010¾\u0002\u001a\u00020,8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b¾\u0002\u0010.\u001a\u0005\b¿\u0002\u00100\"\u0005\bÀ\u0002\u00102R,\u0010Â\u0002\u001a\u0005\u0018\u00010Á\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÂ\u0002\u0010Ã\u0002\u001a\u0006\bÄ\u0002\u0010Å\u0002\"\u0006\bÆ\u0002\u0010Ç\u0002R,\u0010É\u0002\u001a\u0005\u0018\u00010È\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÉ\u0002\u0010Ê\u0002\u001a\u0006\bË\u0002\u0010Ì\u0002\"\u0006\bÍ\u0002\u0010Î\u0002R,\u0010Ð\u0002\u001a\u0005\u0018\u00010Ï\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÐ\u0002\u0010Ñ\u0002\u001a\u0006\bÒ\u0002\u0010Ó\u0002\"\u0006\bÔ\u0002\u0010Õ\u0002R&\u0010Ö\u0002\u001a\u00020\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÖ\u0002\u0010$\u001a\u0005\b×\u0002\u0010&\"\u0005\bØ\u0002\u0010(R(\u0010Ù\u0002\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÙ\u0002\u0010\u001b\u001a\u0005\bÚ\u0002\u0010\u001d\"\u0005\bÛ\u0002\u0010\u001fR(\u0010Ü\u0002\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÜ\u0002\u0010\u001b\u001a\u0005\bÝ\u0002\u0010\u001d\"\u0005\bÞ\u0002\u0010\u001fR9\u0010á\u0002\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030à\u0002\u0018\u00010ß\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bá\u0002\u0010â\u0002\u001a\u0006\bã\u0002\u0010ä\u0002\"\u0006\bå\u0002\u0010æ\u0002R,\u0010è\u0002\u001a\u0005\u0018\u00010ç\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bè\u0002\u0010é\u0002\u001a\u0006\bê\u0002\u0010ë\u0002\"\u0006\bì\u0002\u0010í\u0002R(\u0010î\u0002\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bî\u0002\u0010\u001b\u001a\u0005\bï\u0002\u0010\u001d\"\u0005\bð\u0002\u0010\u001fR,\u0010ò\u0002\u001a\u0005\u0018\u00010ñ\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bò\u0002\u0010ó\u0002\u001a\u0006\bô\u0002\u0010õ\u0002\"\u0006\bö\u0002\u0010÷\u0002R,\u0010ù\u0002\u001a\u0005\u0018\u00010ø\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bù\u0002\u0010ú\u0002\u001a\u0006\bû\u0002\u0010ü\u0002\"\u0006\bý\u0002\u0010þ\u0002R,\u0010\u0080\u0003\u001a\u0005\u0018\u00010ÿ\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0080\u0003\u0010\u0081\u0003\u001a\u0006\b\u0082\u0003\u0010\u0083\u0003\"\u0006\b\u0084\u0003\u0010\u0085\u0003R,\u0010\u0087\u0003\u001a\u0005\u0018\u00010\u0086\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0087\u0003\u0010\u0088\u0003\u001a\u0006\b\u0089\u0003\u0010\u008a\u0003\"\u0006\b\u008b\u0003\u0010\u008c\u0003R(\u0010\u008d\u0003\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u008d\u0003\u0010\u001b\u001a\u0005\b\u008e\u0003\u0010\u001d\"\u0005\b\u008f\u0003\u0010\u001fR(\u0010\u0090\u0003\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u0090\u0003\u0010\u001b\u001a\u0005\b\u0091\u0003\u0010\u001d\"\u0005\b\u0092\u0003\u0010\u001fR(\u0010\u0096\u0003\u001a\u00020\u000f2\u0007\u0010\u0093\u0003\u001a\u00020\u000f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0003\u0010\u001d\"\u0005\b\u0095\u0003\u0010\u001fR,\u0010\u009c\u0003\u001a\u00030\u0097\u00032\b\u0010\u0093\u0003\u001a\u00030\u0097\u00038V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0098\u0003\u0010\u0099\u0003\"\u0006\b\u009a\u0003\u0010\u009b\u0003R\u0016\u0010\u009e\u0003\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009d\u0003\u0010\u001dR\u0016\u0010 \u0003\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009f\u0003\u0010\u001dR\u0016\u0010¢\u0003\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¡\u0003\u0010\u001dR\u001e\u0010¤\u0003\u001a\t\u0012\u0004\u0012\u00020\u00040ô\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b£\u0003\u0010ø\u0001R!\u0010§\u0003\u001a\f\u0012\u0005\u0012\u00030¥\u0003\u0018\u00010þ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¦\u0003\u0010ø\u0001R!\u0010©\u0003\u001a\f\u0012\u0005\u0012\u00030\u0082\u0002\u0018\u00010þ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¨\u0003\u0010ø\u0001R,\u0010¬\u0003\u001a\u00030\u0089\u00022\b\u0010\u0093\u0003\u001a\u00030\u0089\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bª\u0003\u0010\u008d\u0002\"\u0006\b«\u0003\u0010\u008f\u0002R\u0016\u0010®\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u00ad\u0003\u0010&R\u0016\u0010°\u0003\u001a\u00020,8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¯\u0003\u00100R\u0015\u0010s\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b±\u0003\u0010\u001dR\u0013\u0010³\u0003\u001a\u00020\u000f8F¢\u0006\u0007\u001a\u0005\b²\u0003\u0010\u001dR\u0016\u0010µ\u0003\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b´\u0003\u0010\u001dR\u0015\u0010\u0014\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¶\u0003\u0010\u001dR\u001b\u0010¹\u0003\u001a\u00070,j\u0003`·\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¸\u0003\u00100R\u001d\u0010¾\u0003\u001a\b0º\u0003j\u0003`»\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b¼\u0003\u0010½\u0003R\u0018\u0010Â\u0003\u001a\u00030¿\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\bÀ\u0003\u0010Á\u0003R\u001a\u0010Æ\u0003\u001a\u0005\u0018\u00010Ã\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\bÄ\u0003\u0010Å\u0003¨\u0006Ë\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/xe;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lvh7/c$a;", "Lcom/bytedance/android/livesdk/link/model/bridge/z0;", "", "type", "", "setType", "Lvh7/e;", "R", "Ljava/lang/Class;", "aClass", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "uid", "", "isToUser", "isFromUser", "sceneLayoutInfo", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "openId", "Ljava/lang/String;", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "InviteOpenId", "getInviteOpenId", "setInviteOpenId", "mType", "I", "getMType", "()I", "setMType", "(I)V", "accessKey", "getAccessKey", "setAccessKey", "", "anchorLinkMicId", "J", "getAnchorLinkMicId", "()J", "setAnchorLinkMicId", "(J)V", "userId", "getUserId", "setUserId", "fanTicket", "getFanTicket", "setFanTicket", "totalFanTicket", "getTotalFanTicket", "setTotalFanTicket", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelId", "setChannelId", "layout", "getLayout", "setLayout", Constants.OperatorKey.KEY_VENDOR, "getVendor", "setVendor", "dimension", "getDimension", "setDimension", "theme", "getTheme", "setTheme", "inviteUid", "getInviteUid", "setInviteUid", "reply", "getReply", "setReply", "replyType", "getReplyType", "setReplyType", "replyPrompts", "getReplyPrompts", "setReplyPrompts", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "duration", "getDuration", "setDuration", "win", "Z", "getWin", "()Z", "setWin", "(Z)V", "prompts", "getPrompts", "setPrompts", "bizTag", "getBizTag", "setBizTag", "_toUserId", "get_toUserId", "set_toUserId", "toOpenId", "getToOpenId", "setToOpenId", "secToUserId", "getSecToUserId", "setSecToUserId", "fromUserId", "getFromUserId", "setFromUserId", "fromOpenId", "getFromOpenId", "setFromOpenId", "secFromUserId", "getSecFromUserId", "setSecFromUserId", "fromRoomId", "getFromRoomId", "setFromRoomId", "inviteType", "getInviteType", "setInviteType", "subType", "getSubType", "setSubType", "confluenceType", "getConfluenceType", "setConfluenceType", "rtcExtInfo", "getRtcExtInfo", "setRtcExtInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/MultiLiveCoreInfo;", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/MultiLiveCoreInfo;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/MultiLiveCoreInfo;", "setMultiLiveCoreInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/MultiLiveCoreInfo;)V", "Lcom/bytedance/android/livesdk/chatroom/model/interact/MultiRtcInfo;", "_multiRtcInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/MultiRtcInfo;", "get_multiRtcInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/MultiRtcInfo;", "set_multiRtcInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/MultiRtcInfo;)V", "liveCoreExtInfo", "getLiveCoreExtInfo", "setLiveCoreExtInfo", "Lcom/bytedance/android/livesdk/chatroom/interact/model/RivalExtraInfo;", "inviterRivalExtra", "Lcom/bytedance/android/livesdk/chatroom/interact/model/RivalExtraInfo;", "getInviterRivalExtra", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/RivalExtraInfo;", "setInviterRivalExtra", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/RivalExtraInfo;)V", "rtcAppId", "getRtcAppId", "setRtcAppId", "appId", "getAppId", "setAppId", "appSign", "getAppSign", "setAppSign", "_anchorLinkMicIdStr", "get_anchorLinkMicIdStr", "set_anchorLinkMicIdStr", "guestId", "getGuestId", "setGuestId", "guestOpenId", "getGuestOpenId", "setGuestOpenId", "rivalLinkmicId", "getRivalLinkmicId", "setRivalLinkmicId", "rivalLinkmicIdStr", "getRivalLinkmicIdStr", "setRivalLinkmicIdStr", "linkerSessionId", "getLinkerSessionId", "setLinkerSessionId", "remoteLinkerSessionId", "getRemoteLinkerSessionId", "setRemoteLinkerSessionId", "Lcom/bytedance/android/livesdkapi/depend/model/live/LinkerGame;", "gameInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/LinkerGame;", "getGameInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LinkerGame;", "setGameInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LinkerGame;)V", "Lpy/k;", "inviteImage", "Lpy/k;", "getInviteImage", "()Lpy/k;", "setInviteImage", "(Lpy/k;)V", "invitePrompt", "getInvitePrompt", "setInvitePrompt", "inviteSubtitle", "getInviteSubtitle", "setInviteSubtitle", "Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "joinChannelData", "Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "getJoinChannelData", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "setJoinChannelData", "(Lcom/bytedance/android/live/liveinteract/plantform/model/q0;)V", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "chorusCDNInfo", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "getChorusCDNInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/v;", "setChorusCDNInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/v;)V", "Lcom/bytedance/android/livesdk/chatroom/model/t;", "chorusAccompanimentInfo", "Lcom/bytedance/android/livesdk/chatroom/model/t;", "getChorusAccompanimentInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/t;", "setChorusAccompanimentInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/t;)V", "pushRtcType", "getPushRtcType", "setPushRtcType", "scene", "getScene", "setScene", "subScene", "getSubScene", "setSubScene", "isSupportCamera", "setSupportCamera", "", "_playModes", "Ljava/util/List;", "get_playModes", "()Ljava/util/List;", "set_playModes", "(Ljava/util/List;)V", "uiLayout", "getUiLayout", "setUiLayout", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkUser;", "_linkedListUsers", "get_linkedListUsers", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "_lockedPositions", "get_lockedPositions", "set_lockedPositions", "switchToSilence", "getSwitchToSilence", "setSwitchToSilence", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "_clientUIInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "get_clientUIInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "set_clientUIInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "Lcom/bytedance/android/livesdk/message/model/InvitorInfo;", "invitorInfo", "Lcom/bytedance/android/livesdk/message/model/InvitorInfo;", "getInvitorInfo", "()Lcom/bytedance/android/livesdk/message/model/InvitorInfo;", "setInvitorInfo", "(Lcom/bytedance/android/livesdk/message/model/InvitorInfo;)V", "linkType", "getLinkType", "setLinkType", "initSource", "getInitSource", "setInitSource", "endReason", "getEndReason", "setEndReason", "Lcom/bytedance/android/livesdk/message/linker/AnchorLinkmicInfo;", "backupInfo", "Lcom/bytedance/android/livesdk/message/linker/AnchorLinkmicInfo;", "getBackupInfo", "()Lcom/bytedance/android/livesdk/message/linker/AnchorLinkmicInfo;", "setBackupInfo", "(Lcom/bytedance/android/livesdk/message/linker/AnchorLinkmicInfo;)V", "controlType", "getControlType", "setControlType", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BanUser;", "banAnchorInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BanUser;", "getBanAnchorInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BanUser;", "setBanAnchorInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/BanUser;)V", "version", "getVersion", "setVersion", "Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "joinTeamFightInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "getJoinTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "setJoinTeamFightInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/j0;)V", "paidCount", "getPaidCount", "setPaidCount", "linkDuration", "getLinkDuration", "setLinkDuration", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "multiChannelInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "setMultiChannelInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "gameInviteInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "getGameInviteInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "setGameInviteInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/e;)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "inviteMsg", "Lcom/bytedance/android/livesdkapi/message/Text;", "getInviteMsg", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setInviteMsg", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "kickOutSource", "getKickOutSource", "setKickOutSource", "openSource", "getOpenSource", "setOpenSource", "functionType2", "getFunctionType2", "setFunctionType2", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/RoomLinkerContent;", "linkerContentMap", "Ljava/util/Map;", "getLinkerContentMap", "()Ljava/util/Map;", "setLinkerContentMap", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/MessageBoardInfo;", "messageBoardInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/MessageBoardInfo;", "getMessageBoardInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/MessageBoardInfo;", "setMessageBoardInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/MessageBoardInfo;)V", "ackMessage", "getAckMessage", "setAckMessage", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkerBaseInfo;", "linkerBaseInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkerBaseInfo;", "getLinkerBaseInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/LinkerBaseInfo;", "setLinkerBaseInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/LinkerBaseInfo;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfo;", "guestLinkMicInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfo;", "getGuestLinkMicInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfo;", "setGuestLinkMicInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfo;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/MCUContent;", "mcuContent", "Lcom/bytedance/android/live/liveinteract/plantform/model/MCUContent;", "getMcuContent", "()Lcom/bytedance/android/live/liveinteract/plantform/model/MCUContent;", "setMcuContent", "(Lcom/bytedance/android/live/liveinteract/plantform/model/MCUContent;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/AudienceActionSource;", "_actionSource", "Lcom/bytedance/android/live/liveinteract/plantform/model/AudienceActionSource;", "get_actionSource", "()Lcom/bytedance/android/live/liveinteract/plantform/model/AudienceActionSource;", "set_actionSource", "(Lcom/bytedance/android/live/liveinteract/plantform/model/AudienceActionSource;)V", "trackingData", "getTrackingData", "setTrackingData", "gameBarrageLinkerFinishReason", "getGameBarrageLinkerFinishReason", "setGameBarrageLinkerFinishReason", "value", "getToUserId", "setToUserId", "toUserId", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "setMultiRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/v1;)V", "multiRtcInfo", "getAnchorLinkMicIdStr", "anchorLinkMicIdStr", "get_guestId", "_guestId", "get_fromUserId", "_fromUserId", "getPlayModes", "playModes", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getLinkedListUsers", "linkedListUsers", "getLockedPositions", "lockedPositions", "getClientUIInfo", "setClientUIInfo", "clientUIInfo", "getValidScene", "validScene", "getMessageId2", "messageId2", "getGetFromUserId", "getToUserIdStr", "toUserIdStr", "getFromUserIdStr", "fromUserIdStr", "getSceneLayoutInfo", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getType2", "type2", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getBaseMessage2", "()Lcom/bytedance/android/live/base/model/message/m0;", "baseMessage2", "Lcom/bytedance/android/live/liveinteract/plantform/model/f;", "getActionSource", "()Lcom/bytedance/android/live/liveinteract/plantform/model/f;", "actionSource", "Lcom/bytedance/android/livesdk/link/model/c6;", "getLinkGameInfo", "()Lcom/bytedance/android/livesdk/link/model/c6;", "linkGameInfo", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class xe extends o0 implements vh7.c.a<com.bytedance.android.livesdk.link.model.bridge.z0>, com.bytedance.android.livesdk.link.model.bridge.z0, vh7.h {
    public static final int BattleScoreUpdateFromType_AUDIENCE_P2P = 1;
    public static final int BattleScoreUpdateFromType_DEFAULT = 0;
    public static final a Companion = null;
    public static final int TYPE_AGREE_ADMIN_FIRST_INVITE = 15;
    public static final int TYPE_ALL_LIST_CHANGED = 7;
    public static final int TYPE_ANCHOR_INTERACT_TURN_ON = 100;
    public static final int TYPE_APPLY = 109;
    public static final int TYPE_APPLY_CLEAN = 111;
    public static final int TYPE_APPLY_PERMIT = 110;
    public static final int TYPE_AUDIENCE_INVITED = 12;
    public static final int TYPE_AUDIENCE_REPLY = 13;
    public static final int TYPE_AUTO_JOIN = 14;
    public static final int TYPE_BATTLE_CUT_SHORT = 205;
    public static final int TYPE_BATTLE_DATA = 202;
    public static final int TYPE_BATTLE_INVITE = 203;
    public static final int TYPE_BATTLE_REJECT = 204;
    public static final int TYPE_CANCELED_BY_SERVER = 105;
    public static final int TYPE_FAN_TICKET_CHANGED = 8;
    public static final int TYPE_FINISH = 4;
    public static final int TYPE_INROOM_NOTIFY = 106;
    public static final int TYPE_INVITE = 101;
    public static final int TYPE_INVITE_CLEAN = 104;
    public static final int TYPE_INVITE_NOTIFY_JOIN = 103;
    public static final int TYPE_INVITE_REPLY = 102;
    public static final int TYPE_KICKED_OUT = 3;
    public static final int TYPE_LINKED_LIST_CHANGED = 6;
    public static final int TYPE_PERMIT = 2;
    public static final int TYPE_SILENCE = 10;
    public static final int TYPE_SILENCE_PASSIVE = 16;
    public static final int TYPE_SWITCH_SCENE = 17;
    public static final int TYPE_TURN_ON = 1;
    public static final int TYPE_UNSILENCE = 11;
    public static final int TYPE_WAITING_LIST_CHANGED = 5;

    @SerializedName("invite_open_id")
    protected String InviteOpenId;

    @SerializedName("action_source")
    protected AudienceActionSource _actionSource;

    @SerializedName("anchor_linkmic_id_str")
    protected String _anchorLinkMicIdStr;

    @SerializedName("client_ui_info")
    protected ClientUIInfo _clientUIInfo;

    @SerializedName("linked_list_users")
    protected List<AnchorLinkUser> _linkedListUsers;

    @SerializedName("locked_positions")
    protected List<LinkmicPositionItem> _lockedPositions;

    @SerializedName("multi_rtc_info")
    protected MultiRtcInfo _multiRtcInfo;

    @SerializedName("play_modes")
    protected List<Integer> _playModes;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    protected long _toUserId;

    @SerializedName("access_key")
    protected String accessKey;

    @SerializedName("ack_message")
    protected String ackMessage;

    @SerializedName("anchor_linkmic_id")
    protected long anchorLinkMicId;

    @SerializedName("app_id")
    protected String appId;

    @SerializedName("app_sign")
    protected String appSign;

    @SerializedName("backup_anchor_linkmic_info")
    protected AnchorLinkmicInfo backupInfo;

    @SerializedName("ban_anchor_info")
    protected BanUser banAnchorInfo;

    @SerializedName("biz_tag")
    protected String bizTag;

    @SerializedName("channel_id")
    protected long channelId;

    @IgnoreProtoFieldCheck
    @SerializedName("chorus_accompaniment_info")
    private com.bytedance.android.livesdk.chatroom.model.t chorusAccompanimentInfo;

    @SerializedName("chorus_cdn_info")
    protected com.bytedance.android.livesdk.chatroom.model.v chorusCDNInfo;

    @SerializedName("confluence_type")
    protected int confluenceType;

    @SerializedName("control_type")
    protected int controlType;
    private final transient FlexModelDelegate<com.bytedance.android.livesdk.link.model.bridge.z0> delegate;

    @SerializedName("dimension")
    protected int dimension;

    @SerializedName("duration")
    protected int duration;

    @SerializedName("end_reason")
    protected int endReason;

    @SerializedName("fan_ticket")
    protected long fanTicket;

    @SerializedName("from_open_id")
    protected String fromOpenId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    protected long fromRoomId;

    @SerializedName("from_user_id")
    protected long fromUserId;

    @SerializedName("function_type")
    protected String functionType2;

    @SerializedName("game_barrage_linker_finish_reason")
    protected String gameBarrageLinkerFinishReason;

    @SerializedName("link_game_info")
    protected LinkerGame gameInfo;

    @SerializedName("game_invite_info")
    protected com.bytedance.android.live.liveinteract.plantform.model.e gameInviteInfo;

    @SerializedName("rival_anchor_id")
    protected long guestId;

    @SerializedName("guest_linkmic_info")
    protected LinkmicMediaInfo guestLinkMicInfo;

    @SerializedName("rival_anchor_open_id")
    protected String guestOpenId;

    @SerializedName("source")
    protected int initSource;

    @SerializedName("invite_image")
    protected py.k inviteImage;

    @SerializedName(InvHitPoint.ShareMethod.INVITE_MESSAGE)
    protected Text inviteMsg;

    @SerializedName("invite_prompt")
    protected String invitePrompt;

    @SerializedName("invite_subtitle")
    protected String inviteSubtitle;

    @SerializedName("invite_type")
    protected int inviteType;

    @SerializedName("invite_uid")
    protected long inviteUid;

    @SerializedName("inviter_rival_extra")
    protected RivalExtraInfo inviterRivalExtra;

    @SerializedName("invitor_info")
    protected InvitorInfo invitorInfo;

    @SerializedName("support_update_link_type")
    protected boolean isSupportCamera;

    @SerializedName("join_channel_data")
    protected com.bytedance.android.live.liveinteract.plantform.model.q0 joinChannelData;

    @SerializedName("join_teamfight_info")
    protected com.bytedance.android.live.liveinteract.plantform.model.j0 joinTeamFightInfo;

    @SerializedName("kick_out_source")
    protected int kickOutSource;

    @SerializedName("layout")
    protected int layout;

    @SerializedName("link_duration")
    protected long linkDuration;

    @SerializedName("link_type")
    protected int linkType;

    @SerializedName("linker_base_info")
    protected LinkerBaseInfo linkerBaseInfo;

    @SerializedName("linker_content_map")
    protected Map<Long, ? extends RoomLinkerContent> linkerContentMap;

    @SerializedName("linker_session_id")
    protected String linkerSessionId;

    @SerializedName("live_core_ext_info")
    protected String liveCoreExtInfo;

    @SerializedName("message_type")
    protected int mType;

    @SerializedName("mcu_content")
    protected MCUContent mcuContent;

    @SerializedName("msg_board_item")
    protected MessageBoardInfo messageBoardInfo;

    @SerializedName("multi_channel_info")
    protected MultiChannelInfo multiChannelInfo;

    @SerializedName("multi_live_core_info")
    protected MultiLiveCoreInfo multiLiveCoreInfo;

    @SerializedName(com.tencent.connect.common.Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    @SerializedName("init_source")
    protected String openSource;

    @SerializedName("paid_count")
    protected long paidCount;

    @SerializedName("prompts")
    protected String prompts;

    @SerializedName("push_rtc_type")
    protected int pushRtcType;

    @SerializedName("remote_linker_session_id")
    protected String remoteLinkerSessionId;

    @SerializedName("answer")
    protected int reply;

    @SerializedName("reply_prompts")
    protected String replyPrompts;

    @SerializedName("reply_type")
    protected int replyType;

    @SerializedName("rival_linkmic_id")
    protected long rivalLinkmicId;

    @SerializedName("rival_linkmic_id_str")
    protected String rivalLinkmicIdStr;

    @SerializedName("rtc_app_id")
    protected String rtcAppId;

    @SerializedName("rtc_ext_info")
    protected String rtcExtInfo;

    @SerializedName("scene")
    protected long scene;

    @SerializedName("sec_from_user_id")
    protected String secFromUserId;

    @SerializedName("sec_to_user_id")
    protected String secToUserId;

    @SerializedName("start_time_ms")
    protected long startTimeMs;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_SCENE)
    protected int subScene;

    @SerializedName("sub_type")
    protected long subType;

    @IgnoreProtoFieldCheck
    @SerializedName("switch_to_silence")
    protected boolean switchToSilence;

    @SerializedName("theme")
    protected String theme;

    @SerializedName("to_open_id")
    protected String toOpenId;

    @SerializedName("total_linkmic_fan_ticket")
    protected long totalFanTicket;

    @SerializedName("tracking_data")
    protected String trackingData;

    @SerializedName("ui_layout")
    protected int uiLayout;

    @SerializedName("user_id")
    protected long userId;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    protected int f153703vendor;

    @SerializedName("version")
    protected long version;

    @SerializedName("win")
    protected boolean win;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getAnchorLinkMicIdStr() {
        String r100 = this._anchorLinkMicIdStr;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        if (r100.length() == 0) goto L9;
        return this._anchorLinkMicIdStr;
    L9:
        return String.valueOf(getAnchorLinkMicId());
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getFromUserIdStr() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.fromUserId);
        String r102 = this.fromOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getGetFromUserId() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.fromUserId);
        String r102 = this.fromOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedListUsers() {
        return new ArrayList(this._linkedListUsers);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getToUserId() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this._toUserId);
        String r102 = this.toOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    public final String getToUserIdStr() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        getToUserId();
        String r101 = this.toOpenId;
        r100.getClass();
        if (r101 != null) goto L6;
        return "0";
    L6:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public long getType2() {
        return this.mType;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String get_fromUserId() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.fromUserId);
        String r102 = this.fromOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String get_guestId() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.guestId);
        String r102 = this.guestOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    public final String sceneLayoutInfo() {
        return "LinkMicMsg{scene=" + getScene() + ", uiLayout=" + getUiLayout() + ", playModes=" + getPlayModes() + ", supportCamera=" + isSupportCamera() + ", type=" + this.type + ", messageId=" + getMessageId() + '}';
    }

    public xe() {
        this.delegate = new FlexModelDelegate(com.bytedance.android.livesdk.link.model.bridge.z0.class, this);
        this.secFromUserId = "";
        this._anchorLinkMicIdStr = "";
        this.type = MessageType.LINK_MIC;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.message.linker.b getBackupInfo() {
        return getBackupInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public /* bridge */ /* synthetic */ IBanUser getBanAnchorInfo() {
        return getBanAnchorInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.j1 getGuestLinkMicInfo() {
        return getGuestLinkMicInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public /* bridge */ /* synthetic */ com.bytedance.android.live.base.model.message.a5 getInviteMsg() {
        return getInviteMsg();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public /* bridge */ /* synthetic */ c8 getInvitorInfo() {
        return getInvitorInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public /* bridge */ /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.q getLinkerBaseInfo() {
        return getLinkerBaseInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public /* bridge */ /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.e0 getMcuContent() {
        return getMcuContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public /* bridge */ /* synthetic */ IMessageBoardInfo getMessageBoardInfo() {
        return getMessageBoardInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public long getMessageId2() {
        return getMessageId();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.u1 getMultiLiveCoreInfo() {
        return getMultiLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getSceneLayoutInfo() {
        return sceneLayoutInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public int getValidScene() {
        if (((int) getScene()) == 0) goto L6;
        return (int) getScene();
    L6:
        return this.subScene;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getAckMessage() {
        return this.ackMessage;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.liveinteract.plantform.model.f getActionSource() {
        return this._actionSource;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public long getAnchorLinkMicId() {
        return this.anchorLinkMicId;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppSign() {
        return this.appSign;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.base.model.message.m0 getBaseMessage2() {
        return this.baseMessage;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getBizTag() {
        return this.bizTag;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public long getChannelId() {
        return this.channelId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.chatroom.model.t getChorusAccompanimentInfo() {
        return this.chorusAccompanimentInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.chatroom.model.v getChorusCDNInfo() {
        return this.chorusCDNInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public ClientUIInfo getClientUIInfo() {
        return this._clientUIInfo;
    }

    public final int getConfluenceType() {
        return this.confluenceType;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public int getControlType() {
        return this.controlType;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<com.bytedance.android.livesdk.link.model.bridge.z0> getDelegate() {
        return this.delegate;
    }

    public final int getDimension() {
        return this.dimension;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getEndReason() {
        return this.endReason;
    }

    public final long getFanTicket() {
        return this.fanTicket;
    }

    public final String getFromOpenId() {
        return this.fromOpenId;
    }

    public final long getFromRoomId() {
        return this.fromRoomId;
    }

    public final long getFromUserId() {
        return this.fromUserId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getFunctionType2() {
        return this.functionType2;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getGameBarrageLinkerFinishReason() {
        return this.gameBarrageLinkerFinishReason;
    }

    public final LinkerGame getGameInfo() {
        return this.gameInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.liveinteract.plantform.model.e getGameInviteInfo() {
        return this.gameInviteInfo;
    }

    public final long getGuestId() {
        return this.guestId;
    }

    public final String getGuestOpenId() {
        return this.guestOpenId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public int getInitSource() {
        return this.initSource;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public py.k getInviteImage() {
        return this.inviteImage;
    }

    public final String getInviteOpenId() {
        return this.InviteOpenId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getInvitePrompt() {
        return this.invitePrompt;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getInviteSubtitle() {
        return this.inviteSubtitle;
    }

    public final int getInviteType() {
        return this.inviteType;
    }

    public final long getInviteUid() {
        return this.inviteUid;
    }

    public final RivalExtraInfo getInviterRivalExtra() {
        return this.inviterRivalExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.liveinteract.plantform.model.q0 getJoinChannelData() {
        return this.joinChannelData;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.live.liveinteract.plantform.model.j0 getJoinTeamFightInfo() {
        return this.joinTeamFightInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public int getKickOutSource() {
        return this.kickOutSource;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public int getLayout() {
        return this.layout;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public long getLinkDuration() {
        return this.linkDuration;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.link.model.c6 getLinkGameInfo() {
        return this.gameInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public int getLinkType() {
        return this.linkType;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public Map<Long, RoomLinkerContent> getLinkerContentMap() {
        return this.linkerContentMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getLinkerSessionId() {
        return this.linkerSessionId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getLiveCoreExtInfo() {
        return this.liveCoreExtInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public List<LinkmicPositionItem> getLockedPositions() {
        return this._lockedPositions;
    }

    public final int getMType() {
        return this.mType;
    }

    public final MultiChannelInfo getMultiChannelInfo() {
        return this.multiChannelInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo() {
        return this._multiRtcInfo;
    }

    public final String getOpenId() {
        return this.openId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getOpenSource() {
        return this.openSource;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public long getPaidCount() {
        return this.paidCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public List<Integer> getPlayModes() {
        return this._playModes;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getPrompts() {
        return this.prompts;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public int getPushRtcType() {
        return this.pushRtcType;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getRemoteLinkerSessionId() {
        return this.remoteLinkerSessionId;
    }

    public final int getReply() {
        return this.reply;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getReplyPrompts() {
        return this.replyPrompts;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public int getReplyType() {
        return this.replyType;
    }

    public final long getRivalLinkmicId() {
        return this.rivalLinkmicId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getRivalLinkmicIdStr() {
        return this.rivalLinkmicIdStr;
    }

    public final String getRtcAppId() {
        return this.rtcAppId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getRtcExtInfo() {
        return this.rtcExtInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public long getScene() {
        return this.scene;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getSecFromUserId() {
        return this.secFromUserId;
    }

    public final String getSecToUserId() {
        return this.secToUserId;
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final int getSubScene() {
        return this.subScene;
    }

    public final long getSubType() {
        return this.subType;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public boolean getSwitchToSilence() {
        return this.switchToSilence;
    }

    public final String getTheme() {
        return this.theme;
    }

    public final String getToOpenId() {
        return this.toOpenId;
    }

    public final long getTotalFanTicket() {
        return this.totalFanTicket;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public String getTrackingData() {
        return this.trackingData;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public int getUiLayout() {
        return this.uiLayout;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final int getVendor() {
        return this.f153703vendor;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public long getVersion() {
        return this.version;
    }

    public final boolean getWin() {
        return this.win;
    }

    public final AudienceActionSource get_actionSource() {
        return this._actionSource;
    }

    public final String get_anchorLinkMicIdStr() {
        return this._anchorLinkMicIdStr;
    }

    public final ClientUIInfo get_clientUIInfo() {
        return this._clientUIInfo;
    }

    public final List<AnchorLinkUser> get_linkedListUsers() {
        return this._linkedListUsers;
    }

    public final List<LinkmicPositionItem> get_lockedPositions() {
        return this._lockedPositions;
    }

    public final MultiRtcInfo get_multiRtcInfo() {
        return this._multiRtcInfo;
    }

    public final List<Integer> get_playModes() {
        return this._playModes;
    }

    public final long get_toUserId() {
        return this._toUserId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public boolean isSupportCamera() {
        return this.isSupportCamera;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public AnchorLinkmicInfo getBackupInfo() {
        return this.backupInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public BanUser getBanAnchorInfo() {
        return this.banAnchorInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public LinkmicMediaInfo getGuestLinkMicInfo() {
        return this.guestLinkMicInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public Text getInviteMsg() {
        return this.inviteMsg;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public InvitorInfo getInvitorInfo() {
        return this.invitorInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public LinkerBaseInfo getLinkerBaseInfo() {
        return this.linkerBaseInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public MCUContent getMcuContent() {
        return this.mcuContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public MessageBoardInfo getMessageBoardInfo() {
        return this.messageBoardInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public MultiLiveCoreInfo getMultiLiveCoreInfo() {
        return this.multiLiveCoreInfo;
    }

    /* JADX WARN: Type inference failed for: r2v42, types: [com.bytedance.android.live.liveinteract.plantform.model.j0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v47, types: [com.bytedance.android.live.liveinteract.plantform.model.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v62, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v65, types: [com.bytedance.android.live.liveinteract.plantform.model.q0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v69, types: [com.bytedance.android.livesdk.chatroom.model.v, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v73, types: [com.bytedance.android.livesdkapi.depend.message.ClientUIInfo, java.lang.Object] */
    public xe(am3.g r110) {
        this._playModes = new ArrayList();
        this._linkedListUsers = new ArrayList();
        this._lockedPositions = new ArrayList();
        this.linkerContentMap = new HashMap();
        this.delegate = new FlexModelDelegate(com.bytedance.android.livesdk.link.model.bridge.z0.class, this);
        getDelegate().setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L132;
        am3.g.a r102 = getDelegate().decodeExtensionFields(r101, r110);
        if (r101 != 80) goto L8;
        this.ackMessage = am3.h.c(r110);
        goto L3
    L8:
        if (r101 != 81) goto L10;
        this.openSource = am3.h.c(r110);
        goto L3
    L10:
        if (r101 != 85) goto L12;
        this.guestLinkMicInfo = new LinkmicMediaInfo(r110);
        goto L3
    L12:
        if (r101 != 86) goto L14;
        this.mcuContent = new MCUContent(r110);
        goto L3
    L14:
        if (r101 != 88) goto L16;
        this.linkerBaseInfo = new LinkerBaseInfo(r110);
        goto L3
    L16:
        if (r101 != 89) goto L17;
        this._actionSource = new AudienceActionSource(r110);
        goto L3
    L17:
        switch(r101) {
            case 1: goto L125;
            case 2: goto L124;
            case 3: goto L123;
            case 4: goto L122;
            case 5: goto L121;
            case 6: goto L120;
            case 7: goto L119;
            case 8: goto L118;
            case 9: goto L117;
            case 10: goto L116;
            case 11: goto L115;
            case 12: goto L114;
            case 13: goto L113;
            case 14: goto L112;
            default: goto L18;
        };
    L112:
        this.reply = (int) r110.j();
        goto L3
    L113:
        this.inviteUid = r110.j();
        goto L3
    L114:
        this.theme = am3.h.c(r110);
        goto L3
    L115:
        this.dimension = (int) r110.j();
        goto L3
    L116:
        this.f153703vendor = (int) r110.j();
        goto L3
    L117:
        this.layout = (int) r110.j();
        goto L3
    L118:
        this.channelId = r110.j();
        goto L3
    L119:
        this.totalFanTicket = r110.j();
        goto L3
    L120:
        this.fanTicket = r110.j();
        goto L3
    L121:
        this.userId = r110.j();
        goto L3
    L122:
        this.anchorLinkMicId = r110.j();
        goto L3
    L123:
        this.accessKey = am3.h.c(r110);
        goto L3
    L124:
        this.mType = (int) r110.j();
        goto L3
    L125:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L18:
        switch(r101) {
            case 16: goto L111;
            case 24: goto L110;
            case 43: goto L109;
            case 64: goto L108;
            case 65: goto L107;
            case 66: goto L106;
            case 67: goto L105;
            case 68: goto L104;
            case 69: goto L103;
            case 70: goto L102;
            case 71: goto L101;
            case 72: goto L100;
            case 73: goto L99;
            case 74: goto L98;
            case 75: goto L97;
            case 76: goto L80;
            case 77: goto L79;
            case 78: goto L78;
            case 93: goto L77;
            case 94: goto L76;
            case 95: goto L75;
            case 96: goto L74;
            case 97: goto L73;
            case 98: goto L72;
            case 99: goto L71;
            case 102: goto L70;
            case 103: goto L69;
            case 105: goto L68;
            case 106: goto L67;
            case 108: goto L66;
            case 109: goto L65;
            case 112: goto L64;
            case 5000: goto L63;
            case 5001: goto L62;
            case 5002: goto L61;
            case 5003: goto L60;
            case 5004: goto L59;
            default: goto L19;
        };
    L59:
        this.guestOpenId = am3.h.c(r110);
        goto L3
    L60:
        this.fromOpenId = am3.h.c(r110);
        goto L3
    L61:
        this.toOpenId = am3.h.c(r110);
        goto L3
    L62:
        this.InviteOpenId = am3.h.c(r110);
        goto L3
    L63:
        this.openId = am3.h.c(r110);
        goto L3
    L64:
        this.bizTag = am3.h.c(r110);
        goto L3
    L65:
        this.trackingData = am3.h.c(r110);
        goto L3
    L66:
        this._clientUIInfo = vh7.f.a(r110, ClientUIInfo.class);
        goto L3
    L67:
        this.pushRtcType = r110.i();
        goto L3
    L68:
        this.inviteSubtitle = am3.h.c(r110);
        goto L3
    L69:
        this.chorusCDNInfo = vh7.f.a(r110, com.bytedance.android.livesdk.chatroom.model.v.class);
        goto L3
    L70:
        this.gameBarrageLinkerFinishReason = am3.h.c(r110);
        goto L3
    L71:
        this.switchToSilence = am3.h.a(r110);
        goto L3
    L72:
        this.joinChannelData = vh7.f.a(r110, com.bytedance.android.live.liveinteract.plantform.model.q0.class);
        goto L3
    L73:
        this.invitePrompt = am3.h.c(r110);
        goto L3
    L74:
        this.inviteImage = vh7.f.a(r110, py.k.class);
        goto L3
    L75:
        this.gameInfo = new LinkerGame(r110);
        goto L3
    L76:
        this.remoteLinkerSessionId = am3.h.c(r110);
        goto L3
    L77:
        this.linkerSessionId = am3.h.c(r110);
        goto L3
    L78:
        this.messageBoardInfo = new MessageBoardInfo(r110);
        goto L3
    L79:
        this.functionType2 = am3.h.c(r110);
        goto L3
    L80:
        long r103 = r110.c();
        Long r104 = null;
        RoomLinkerContent r105 = null;
    L81:
        int r106 = r110.f();
        if (r106 == (-1)) goto L89;
        if (r106 != 1) goto L85;
        r104 = Long.valueOf(r110.j());
        goto L81
    L85:
        if (r106 != 2) goto L86;
        r105 = com.bytedance.android.live.liveinteract.plantform.model.p1.a(r110);
        goto L81
    L86:
        am3.h.e(r110);
        goto L81
    L89:
        r110.d(r103);
        Map<Long, ? extends RoomLinkerContent> r107 = this.linkerContentMap;
        if (r104 == null) goto L96;
        if (r105 == null) goto L94;
        r107.put(r104, r105);
        goto L3
    L94:
        throw new IllegalStateException("Value must not be null");
    L96:
        throw new IllegalStateException("Key must not be null");
    L97:
        this.kickOutSource = r110.i();
        goto L3
    L98:
        this.multiChannelInfo = new MultiChannelInfo(r110);
        goto L3
    L99:
        this.inviteMsg = _Text_ProtoDecoder.decodeStatic(r110);
        goto L3
    L100:
        this.uiLayout = r110.i();
        goto L3
    L101:
        this.gameInviteInfo = vh7.f.a(r110, com.bytedance.android.live.liveinteract.plantform.model.e.class);
        goto L3
    L102:
        this.liveCoreExtInfo = am3.h.c(r110);
        goto L3
    L103:
        this.linkDuration = r110.j();
        goto L3
    L104:
        this.paidCount = r110.j();
        goto L3
    L105:
        this.joinTeamFightInfo = vh7.f.a(r110, com.bytedance.android.live.liveinteract.plantform.model.j0.class);
        goto L3
    L106:
        this.version = r110.j();
        goto L3
    L107:
        this.banAnchorInfo = new BanUser(r110);
        goto L3
    L108:
        this.controlType = r110.i();
        goto L3
    L109:
        this.scene = r110.j();
        goto L3
    L110:
        this.fromUserId = r110.j();
        goto L3
    L111:
        this.duration = (int) r110.j();
        goto L3
    L19:
        switch(r101) {
            case 19: goto L58;
            case 20: goto L57;
            case 21: goto L56;
            default: goto L20;
        };
    L56:
        this._toUserId = r110.j();
        goto L3
    L57:
        this.prompts = am3.h.c(r110);
        goto L3
    L58:
        this.win = am3.h.a(r110);
        goto L3
    L20:
        switch(r101) {
            case 26: goto L55;
            case 27: goto L54;
            case 28: goto L53;
            case 29: goto L52;
            case 30: goto L51;
            case 31: goto L50;
            case 32: goto L49;
            case 33: goto L48;
            case 34: goto L47;
            case 35: goto L46;
            default: goto L21;
        };
    L46:
        this.appSign = am3.h.c(r110);
        goto L3
    L47:
        this.appId = am3.h.c(r110);
        goto L3
    L48:
        this.rtcAppId = am3.h.c(r110);
        goto L3
    L49:
        this.rtcExtInfo = am3.h.c(r110);
        goto L3
    L50:
        this.inviterRivalExtra = new RivalExtraInfo(r110);
        goto L3
    L51:
        this.subType = r110.j();
        goto L3
    L52:
        this.inviteType = (int) r110.j();
        goto L3
    L53:
        this.fromRoomId = r110.j();
        goto L3
    L54:
        this.confluenceType = r110.i();
        goto L3
    L55:
        this.startTimeMs = r110.j();
        goto L3
    L21:
        switch(r101) {
            case 37: goto L45;
            case 38: goto L44;
            case 39: goto L43;
            case 40: goto L42;
            default: goto L22;
        };
    L42:
        this.rivalLinkmicIdStr = am3.h.c(r110);
        goto L3
    L43:
        this.rivalLinkmicId = r110.j();
        goto L3
    L44:
        this.guestId = r110.j();
        goto L3
    L45:
        this._anchorLinkMicIdStr = am3.h.c(r110);
        goto L3
    L22:
        switch(r101) {
            case 46: goto L41;
            case 47: goto L40;
            case 48: goto L39;
            case 49: goto L38;
            case 50: goto L37;
            default: goto L23;
        };
    L37:
        this.invitorInfo = new InvitorInfo(r110);
        goto L3
    L38:
        this.secToUserId = am3.h.c(r110);
        goto L3
    L39:
        this.replyPrompts = am3.h.c(r110);
        goto L3
    L40:
        this.replyType = r110.i();
        goto L3
    L41:
        this.secFromUserId = am3.h.c(r110);
        goto L3
    L23:
        switch(r101) {
            case 52: goto L36;
            case 53: goto L35;
            case 54: goto L34;
            case 55: goto L33;
            case 56: goto L32;
            case 57: goto L30;
            case 58: goto L29;
            case 59: goto L28;
            case 60: goto L27;
            case 61: goto L26;
            case 62: goto L25;
            default: goto L24;
        };
    L25:
        this.multiLiveCoreInfo = com.bytedance.android.livesdk.chatroom.model.interact.d3.a(r110);
        goto L3
    L26:
        this._multiRtcInfo = com.bytedance.android.livesdk.chatroom.model.interact.e3.a(r110);
        goto L3
    L27:
        this.endReason = r110.i();
        goto L3
    L28:
        List r108 = this._lockedPositions;
        Object r109 = vh7.f.a(r110, LinkmicPositionItem.class);
    L31:
        r108.add(r109);
        goto L3
    L29:
        r108 = this._linkedListUsers;
        r109 = new AnchorLinkUser(r110);
        goto L31
    L30:
        r108 = this._playModes;
        r109 = Integer.valueOf(r110.i());
        goto L31
    L32:
        this.backupInfo = com.bytedance.android.livesdk.message.linker.n.a(r110);
        goto L3
    L33:
        this.initSource = r110.i();
        goto L3
    L34:
        this.linkType = r110.i();
        goto L3
    L35:
        this.isSupportCamera = am3.h.a(r110);
        goto L3
    L36:
        this.subScene = r110.i();
        goto L3
    L24:
        am3.h.d(r102, r110);
        goto L3
    L132:
        r110.d(r100);
        getDelegate().setThreadSafe(true);
        if (this.secFromUserId != null) goto L136;
        this.secFromUserId = "";
    L136:
        if (this._anchorLinkMicIdStr != null) goto L138;
        this._anchorLinkMicIdStr = "";
    L138:
        this.type = MessageType.LINK_MIC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.z0>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.z0>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public boolean isFromUser(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return Intrinsics.areEqual(get_fromUserId(), r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public boolean isToUser(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return Intrinsics.areEqual(getToUserId(), r100);
    }

    public final void setAccessKey(String r100) {
        this.accessKey = r100;
    }

    public void setAckMessage(String r100) {
        this.ackMessage = r100;
    }

    public void setAnchorLinkMicId(long r100) {
        this.anchorLinkMicId = r100;
    }

    public final void setAppId(String r100) {
        this.appId = r100;
    }

    public final void setAppSign(String r100) {
        this.appSign = r100;
    }

    public void setBackupInfo(AnchorLinkmicInfo r100) {
        this.backupInfo = r100;
    }

    public void setBanAnchorInfo(BanUser r100) {
        this.banAnchorInfo = r100;
    }

    public void setBizTag(String r100) {
        this.bizTag = r100;
    }

    public void setChannelId(long r100) {
        this.channelId = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setChorusAccompanimentInfo(com.bytedance.android.livesdk.chatroom.model.t r100) {
        this.chorusAccompanimentInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setChorusCDNInfo(com.bytedance.android.livesdk.chatroom.model.v r100) {
        this.chorusCDNInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setClientUIInfo(ClientUIInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this._clientUIInfo = r100;
    }

    public final void setConfluenceType(int r100) {
        this.confluenceType = r100;
    }

    public void setControlType(int r100) {
        this.controlType = r100;
    }

    public final void setDimension(int r100) {
        this.dimension = r100;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setEndReason(int r100) {
        this.endReason = r100;
    }

    public final void setFanTicket(long r100) {
        this.fanTicket = r100;
    }

    public final void setFromOpenId(String r100) {
        this.fromOpenId = r100;
    }

    public final void setFromRoomId(long r100) {
        this.fromRoomId = r100;
    }

    public final void setFromUserId(long r100) {
        this.fromUserId = r100;
    }

    public void setFunctionType2(String r100) {
        this.functionType2 = r100;
    }

    public void setGameBarrageLinkerFinishReason(String r100) {
        this.gameBarrageLinkerFinishReason = r100;
    }

    public final void setGameInfo(LinkerGame r100) {
        this.gameInfo = r100;
    }

    public void setGameInviteInfo(com.bytedance.android.live.liveinteract.plantform.model.e r100) {
        this.gameInviteInfo = r100;
    }

    public final void setGuestId(long r100) {
        this.guestId = r100;
    }

    public void setGuestLinkMicInfo(LinkmicMediaInfo r100) {
        this.guestLinkMicInfo = r100;
    }

    public final void setGuestOpenId(String r100) {
        this.guestOpenId = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setInitSource(int r100) {
        this.initSource = r100;
    }

    public void setInviteImage(py.k r100) {
        this.inviteImage = r100;
    }

    public void setInviteMsg(Text r100) {
        this.inviteMsg = r100;
    }

    public final void setInviteOpenId(String r100) {
        this.InviteOpenId = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setInvitePrompt(String r100) {
        this.invitePrompt = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setInviteSubtitle(String r100) {
        this.inviteSubtitle = r100;
    }

    public final void setInviteType(int r100) {
        this.inviteType = r100;
    }

    public final void setInviteUid(long r100) {
        this.inviteUid = r100;
    }

    public final void setInviterRivalExtra(RivalExtraInfo r100) {
        this.inviterRivalExtra = r100;
    }

    public void setInvitorInfo(InvitorInfo r100) {
        this.invitorInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setJoinChannelData(com.bytedance.android.live.liveinteract.plantform.model.q0 r100) {
        this.joinChannelData = r100;
    }

    public void setJoinTeamFightInfo(com.bytedance.android.live.liveinteract.plantform.model.j0 r100) {
        this.joinTeamFightInfo = r100;
    }

    public void setKickOutSource(int r100) {
        this.kickOutSource = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setLayout(int r100) {
        this.layout = r100;
    }

    public void setLinkDuration(long r100) {
        this.linkDuration = r100;
    }

    public void setLinkType(int r100) {
        this.linkType = r100;
    }

    public void setLinkerBaseInfo(LinkerBaseInfo r100) {
        this.linkerBaseInfo = r100;
    }

    public void setLinkerContentMap(Map<Long, ? extends RoomLinkerContent> r100) {
        this.linkerContentMap = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setLinkerSessionId(String r100) {
        this.linkerSessionId = r100;
    }

    public void setLiveCoreExtInfo(String r100) {
        this.liveCoreExtInfo = r100;
    }

    public final void setMType(int r100) {
        this.mType = r100;
    }

    public void setMcuContent(MCUContent r100) {
        this.mcuContent = r100;
    }

    public void setMessageBoardInfo(MessageBoardInfo r100) {
        this.messageBoardInfo = r100;
    }

    public final void setMultiChannelInfo(MultiChannelInfo r100) {
        this.multiChannelInfo = r100;
    }

    public void setMultiLiveCoreInfo(MultiLiveCoreInfo r100) {
        this.multiLiveCoreInfo = r100;
    }

    public void setMultiRtcInfo(com.bytedance.android.livesdk.link.model.bridge.v1 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this._multiRtcInfo = (MultiRtcInfo) r100;
    }

    public final void setOpenId(String r100) {
        this.openId = r100;
    }

    public void setOpenSource(String r100) {
        this.openSource = r100;
    }

    public void setPaidCount(long r100) {
        this.paidCount = r100;
    }

    public void setPrompts(String r100) {
        this.prompts = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setPushRtcType(int r100) {
        this.pushRtcType = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setRemoteLinkerSessionId(String r100) {
        this.remoteLinkerSessionId = r100;
    }

    public final void setReply(int r100) {
        this.reply = r100;
    }

    public void setReplyPrompts(String r100) {
        this.replyPrompts = r100;
    }

    public void setReplyType(int r100) {
        this.replyType = r100;
    }

    public final void setRivalLinkmicId(long r100) {
        this.rivalLinkmicId = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setRivalLinkmicIdStr(String r100) {
        this.rivalLinkmicIdStr = r100;
    }

    public final void setRtcAppId(String r100) {
        this.rtcAppId = r100;
    }

    public void setRtcExtInfo(String r100) {
        this.rtcExtInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setScene(long r100) {
        this.scene = r100;
    }

    public void setSecFromUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secFromUserId = r100;
    }

    public final void setSecToUserId(String r100) {
        this.secToUserId = r100;
    }

    public final void setStartTimeMs(long r100) {
        this.startTimeMs = r100;
    }

    public final void setSubScene(int r100) {
        this.subScene = r100;
    }

    public final void setSubType(long r100) {
        this.subType = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setSupportCamera(boolean r100) {
        this.isSupportCamera = r100;
    }

    public void setSwitchToSilence(boolean r100) {
        this.switchToSilence = r100;
    }

    public final void setTheme(String r100) {
        this.theme = r100;
    }

    public final void setToOpenId(String r100) {
        this.toOpenId = r100;
    }

    public void setToUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        long r101 = CastLongProtector.parseLong(r100);     // Catch: NumberFormatException -> L5
    L6:
        this._toUserId = r101;
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public final void setTotalFanTicket(long r100) {
        this.totalFanTicket = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setTrackingData(String r100) {
        this.trackingData = r100;
    }

    @SerializedName("message_type")
    public final void setType(int r100) {
        this.mType = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.z0
    public void setUiLayout(int r100) {
        this.uiLayout = r100;
    }

    public final void setUserId(long r100) {
        this.userId = r100;
    }

    public final void setVendor(int r100) {
        this.f153703vendor = r100;
    }

    public void setVersion(long r100) {
        this.version = r100;
    }

    public final void setWin(boolean r100) {
        this.win = r100;
    }

    public final void set_actionSource(AudienceActionSource r100) {
        this._actionSource = r100;
    }

    public final void set_anchorLinkMicIdStr(String r100) {
        this._anchorLinkMicIdStr = r100;
    }

    public final void set_clientUIInfo(ClientUIInfo r100) {
        this._clientUIInfo = r100;
    }

    public final void set_lockedPositions(List<LinkmicPositionItem> r100) {
        this._lockedPositions = r100;
    }

    public final void set_multiRtcInfo(MultiRtcInfo r100) {
        this._multiRtcInfo = r100;
    }

    public final void set_playModes(List<Integer> r100) {
        this._playModes = r100;
    }

    public final void set_toUserId(long r100) {
        this._toUserId = r100;
    }
}
