package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.livesdk.chatroom.helper.DataContextExtKt;
import com.bytedance.android.livesdk.chatroom.model.d3;
import com.bytedance.android.livesdk.config.ge1;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.landscape.ILandscapeSpiltManager;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.viewmodel.DrawCleanScreenViewModel;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdk.wrds.OpenPlatformMicroAppSyncModel;
import com.bytedance.android.livesdk.wrds.syncdata.HighlightContainerSyncModel;
import com.bytedance.android.livesdk.wrds.syncdata.effect.AnchorEffectStatusSyncModel;
import com.bytedance.android.livesdkapi.arch.INewShareContext;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.live.vs.listener.IVsVideoListManager;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.gamecp.AnchorFloatBallDownloadData;
import com.bytedance.android.livesdkapi.depend.model.gamecp.AnchorFloatBallGamePromoteNoticeData;
import com.bytedance.android.livesdkapi.depend.model.gamecp.AnchorFloatWindowPerfData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.WelfareProjectInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.feedback.event.IFeedbackRoomAction;
import com.bytedance.android.livesdkapi.focus.IFocusContext;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.android.livesdkapi.model.LiveBroadcastMusicEffectInfo;
import com.bytedance.android.livesdkapi.model.LiveFloatWindowStatus;
import com.bytedance.android.livesdkapi.multicamera.IMultiCameraLiveRtcManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Ô\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0002£\u0001\u0018\u0000 µ\u00022\u00020\u00012\u00020\u0002:\u0002¶\u0002B\t¢\u0006\u0006\b³\u0002\u0010´\u0002J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J-\u0010\f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u001cR!\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010\u001cR!\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0014\u001a\u0004\b,\u0010\u001cR!\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u001cR!\u00105\u001a\b\u0012\u0004\u0012\u0002020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010\u001cR!\u00109\u001a\b\u0012\u0004\u0012\u0002060\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u001cR!\u0010=\u001a\b\u0012\u0004\u0012\u00020:0\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u001cR!\u0010A\u001a\b\u0012\u0004\u0012\u00020>0\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u001cR!\u0010G\u001a\b\u0012\u0004\u0012\u00020C0B8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0014\u001a\u0004\bE\u0010FR!\u0010K\u001a\b\u0012\u0004\u0012\u00020H0B8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u0014\u001a\u0004\bJ\u0010FR!\u0010O\u001a\b\u0012\u0004\u0012\u00020L0B8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0014\u001a\u0004\bN\u0010FR!\u0010R\u001a\b\u0012\u0004\u0012\u00020C0B8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0014\u001a\u0004\bQ\u0010FR!\u0010V\u001a\b\u0012\u0004\u0012\u00020S0\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u0014\u001a\u0004\bU\u0010\u001cR!\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u0014\u001a\u0004\bY\u0010\u001cR!\u0010^\u001a\b\u0012\u0004\u0012\u00020[0\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0014\u001a\u0004\b]\u0010\u0016R!\u0010b\u001a\b\u0012\u0004\u0012\u00020_0\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u0014\u001a\u0004\ba\u0010\u0016R!\u0010f\u001a\b\u0012\u0004\u0012\u00020c0\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\u0014\u001a\u0004\be\u0010\u0016R!\u0010j\u001a\b\u0012\u0004\u0012\u00020g0\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u0014\u001a\u0004\bi\u0010\u0016R!\u0010n\u001a\b\u0012\u0004\u0012\u00020k0\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u0010\u0014\u001a\u0004\bm\u0010\u0016R!\u0010r\u001a\b\u0012\u0004\u0012\u00020o0\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\u0014\u001a\u0004\bq\u0010\u0016R!\u0010u\u001a\b\u0012\u0004\u0012\u00020C0s8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0014\u001a\u0004\bu\u0010vR!\u0010x\u001a\b\u0012\u0004\u0012\u00020C0s8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\u0014\u001a\u0004\bx\u0010vR!\u0010z\u001a\b\u0012\u0004\u0012\u00020C0s8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\by\u0010\u0014\u001a\u0004\bz\u0010vR\"\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020|0{8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b}\u0010\u0014\u001a\u0004\b~\u0010\u007fR%\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010\u00188FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u0014\u001a\u0005\b\u0083\u0001\u0010\u001cR%\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\u00188FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0014\u001a\u0005\b\u0087\u0001\u0010\u001cR%\u0010\u008c\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u0014\u001a\u0005\b\u008b\u0001\u0010\u0016R$\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010\u0014\u001a\u0005\b\u008e\u0001\u0010FR)\u0010\u0090\u0001\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0090\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R)\u0010\u0095\u0001\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0091\u0001\u001a\u0006\b\u0095\u0001\u0010\u0092\u0001\"\u0006\b\u0096\u0001\u0010\u0094\u0001R)\u0010\u0097\u0001\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0091\u0001\u001a\u0006\b\u0097\u0001\u0010\u0092\u0001\"\u0006\b\u0098\u0001\u0010\u0094\u0001R)\u0010\u0099\u0001\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u0091\u0001\u001a\u0006\b\u009a\u0001\u0010\u0092\u0001\"\u0006\b\u009b\u0001\u0010\u0094\u0001R%\u0010\u009f\u0001\u001a\t\u0012\u0005\u0012\u00030\u009c\u00010B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009d\u0001\u0010\u0014\u001a\u0005\b\u009e\u0001\u0010FR%\u0010¢\u0001\u001a\t\u0012\u0005\u0012\u00030\u009c\u00010B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b \u0001\u0010\u0014\u001a\u0005\b¡\u0001\u0010FR\u0018\u0010¤\u0001\u001a\u00030£\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R%\u0010©\u0001\u001a\t\u0012\u0005\u0012\u00030¦\u00010B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b§\u0001\u0010\u0014\u001a\u0005\b¨\u0001\u0010FR$\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\t0B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bª\u0001\u0010\u0014\u001a\u0005\b«\u0001\u0010FR$\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020C0s8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u00ad\u0001\u0010\u0014\u001a\u0005\b®\u0001\u0010vR$\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\t0B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b°\u0001\u0010\u0014\u001a\u0005\b±\u0001\u0010FR%\u0010¶\u0001\u001a\t\u0012\u0005\u0012\u00030³\u00010\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b´\u0001\u0010\u0014\u001a\u0005\bµ\u0001\u0010\u0016R$\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\t0B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b·\u0001\u0010\u0014\u001a\u0005\b¸\u0001\u0010FR)\u0010º\u0001\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bº\u0001\u0010\u0091\u0001\u001a\u0006\b»\u0001\u0010\u0092\u0001\"\u0006\b¼\u0001\u0010\u0094\u0001R)\u0010½\u0001\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b½\u0001\u0010\u0091\u0001\u001a\u0006\b¾\u0001\u0010\u0092\u0001\"\u0006\b¿\u0001\u0010\u0094\u0001R$\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\t0B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÀ\u0001\u0010\u0014\u001a\u0005\bÁ\u0001\u0010FR$\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÃ\u0001\u0010\u0014\u001a\u0005\bÄ\u0001\u0010\u0016R$\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÆ\u0001\u0010\u0014\u001a\u0005\bÇ\u0001\u0010\u0016R$\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u00020C0B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÉ\u0001\u0010\u0014\u001a\u0005\bÊ\u0001\u0010FR%\u0010Ï\u0001\u001a\t\u0012\u0005\u0012\u00030Ì\u00010\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÍ\u0001\u0010\u0014\u001a\u0005\bÎ\u0001\u0010\u0016R%\u0010Ó\u0001\u001a\t\u0012\u0005\u0012\u00030Ð\u00010B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÑ\u0001\u0010\u0014\u001a\u0005\bÒ\u0001\u0010FR%\u0010×\u0001\u001a\t\u0012\u0005\u0012\u00030Ô\u00010\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÕ\u0001\u0010\u0014\u001a\u0005\bÖ\u0001\u0010\u0016R3\u0010Ý\u0001\u001a\u0017\u0012\u0013\u0012\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030Ú\u00010Ù\u00010Ø\u00010B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÛ\u0001\u0010\u0014\u001a\u0005\bÜ\u0001\u0010FR%\u0010á\u0001\u001a\t\u0012\u0005\u0012\u00030Þ\u00010{8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bß\u0001\u0010\u0014\u001a\u0005\bà\u0001\u0010\u007fR3\u0010â\u0001\u001a\f\u0012\u0005\u0012\u00030Þ\u0001\u0018\u00010Ø\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bâ\u0001\u0010ã\u0001\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001R%\u0010ë\u0001\u001a\t\u0012\u0005\u0012\u00030è\u00010\u00188FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bé\u0001\u0010\u0014\u001a\u0005\bê\u0001\u0010\u001cR%\u0010ï\u0001\u001a\t\u0012\u0005\u0012\u00030ì\u00010\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bí\u0001\u0010\u0014\u001a\u0005\bî\u0001\u0010\u0016R%\u0010ó\u0001\u001a\t\u0012\u0005\u0012\u00030ð\u00010\u00188FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bñ\u0001\u0010\u0014\u001a\u0005\bò\u0001\u0010\u001cR%\u0010÷\u0001\u001a\t\u0012\u0005\u0012\u00030ô\u00010\u00188FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bõ\u0001\u0010\u0014\u001a\u0005\bö\u0001\u0010\u001cR+\u0010û\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020C0ø\u00010B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bù\u0001\u0010\u0014\u001a\u0005\bú\u0001\u0010FR%\u0010ÿ\u0001\u001a\t\u0012\u0005\u0012\u00030ü\u00010\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bý\u0001\u0010\u0014\u001a\u0005\bþ\u0001\u0010\u0016R%\u0010\u0083\u0002\u001a\t\u0012\u0005\u0012\u00030\u0080\u00020B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0002\u0010\u0014\u001a\u0005\b\u0082\u0002\u0010FR%\u0010\u0087\u0002\u001a\t\u0012\u0005\u0012\u00030\u0084\u00020\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0085\u0002\u0010\u0014\u001a\u0005\b\u0086\u0002\u0010\u0016R$\u0010\u008a\u0002\u001a\b\u0012\u0004\u0012\u00020\t0\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0088\u0002\u0010\u0014\u001a\u0005\b\u0089\u0002\u0010\u0016R$\u0010\u008d\u0002\u001a\b\u0012\u0004\u0012\u00020C0B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008b\u0002\u0010\u0014\u001a\u0005\b\u008c\u0002\u0010FR%\u0010\u0091\u0002\u001a\t\u0012\u0005\u0012\u00030\u008e\u00020\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008f\u0002\u0010\u0014\u001a\u0005\b\u0090\u0002\u0010\u0016R%\u0010\u0095\u0002\u001a\t\u0012\u0005\u0012\u00030\u0092\u00020\u00188FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0093\u0002\u0010\u0014\u001a\u0005\b\u0094\u0002\u0010\u001cR%\u0010\u0099\u0002\u001a\t\u0012\u0005\u0012\u00030\u0096\u00020B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0097\u0002\u0010\u0014\u001a\u0005\b\u0098\u0002\u0010FR%\u0010\u009d\u0002\u001a\t\u0012\u0005\u0012\u00030\u009a\u00020B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009b\u0002\u0010\u0014\u001a\u0005\b\u009c\u0002\u0010FR%\u0010¡\u0002\u001a\t\u0012\u0005\u0012\u00030\u009e\u00020\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009f\u0002\u0010\u0014\u001a\u0005\b \u0002\u0010\u0016R%\u0010¥\u0002\u001a\t\u0012\u0005\u0012\u00030¢\u00020\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b£\u0002\u0010\u0014\u001a\u0005\b¤\u0002\u0010\u0016R$\u0010¨\u0002\u001a\b\u0012\u0004\u0012\u00020C0B8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¦\u0002\u0010\u0014\u001a\u0005\b§\u0002\u0010FR\u0014\u0010©\u0002\u001a\u00020C8F¢\u0006\b\u001a\u0006\b©\u0002\u0010\u0092\u0001R\u0014\u0010ª\u0002\u001a\u00020C8F¢\u0006\b\u001a\u0006\bª\u0002\u0010\u0092\u0001R\u0014\u0010«\u0002\u001a\u00020C8F¢\u0006\b\u001a\u0006\b«\u0002\u0010\u0092\u0001R\u0014\u0010¬\u0002\u001a\u00020C8F¢\u0006\b\u001a\u0006\b¬\u0002\u0010\u0092\u0001R\u0014\u0010¯\u0002\u001a\u00020\u00058F¢\u0006\b\u001a\u0006\b\u00ad\u0002\u0010®\u0002R\u0014\u0010°\u0002\u001a\u00020C8F¢\u0006\b\u001a\u0006\b°\u0002\u0010\u0092\u0001R\u0014\u0010±\u0002\u001a\u00020C8F¢\u0006\b\u001a\u0006\b±\u0002\u0010\u0092\u0001R\u0014\u0010²\u0002\u001a\u00020C8F¢\u0006\b\u001a\u0006\b²\u0002\u0010\u0092\u0001¨\u0006·\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "Lcom/bytedance/android/livesdkapi/arch/INewShareContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "roomId", "", "share", "", "uniqueId", "shareByUniqueId", "shareToScope", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Ljava/lang/Long;Ljava/lang/String;)V", "shareGlobalSingleInstance", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/live/datacontext/n;", "Luf2/d0;", "guestLiveCore$delegate", "Lcom/bytedance/live/datacontext/p;", "getGuestLiveCore", "()Lcom/bytedance/live/datacontext/n;", "guestLiveCore", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/live/kmp/core/a;", "liveRoomInstance$delegate", "getLiveRoomInstance", "()Lcom/bytedance/live/datacontext/j;", "liveRoomInstance", "Lbn0/b;", "multiLinkRoomScope$delegate", "getMultiLinkRoomScope", "multiLinkRoomScope", "Lcom/bytedance/android/livesdk/chatroom/InteractionWidgetPosTransformer;", "giftTrayPosTransformer$delegate", "getGiftTrayPosTransformer", "giftTrayPosTransformer", "Lcom/bytedance/android/livesdk/wrds/syncdata/HighlightContainerSyncModel;", "highlightSyncModel$delegate", "getHighlightSyncModel", "highlightSyncModel", "Lcom/bytedance/android/livesdk/wrds/syncdata/effect/AnchorEffectStatusSyncModel;", "anchorEffectStatusSyncModel$delegate", "getAnchorEffectStatusSyncModel", "anchorEffectStatusSyncModel", "Lcom/bytedance/android/livesdkapi/focus/IFocusContext;", "focusContext$delegate", "getFocusContext", "focusContext", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext;", "dynamicStrategy$delegate", "getDynamicStrategy", "dynamicStrategy", "Lyt1/n;", "dslManager$delegate", "getDslManager", "dslManager", "Lzt1/c;", "dslTemplateCenter$delegate", "getDslTemplateCenter", "dslTemplateCenter", "Lzr1/c;", "wgameXInviteManager$delegate", "getWgameXInviteManager", "wgameXInviteManager", "Lcom/bytedance/live/datacontext/m;", "", "vsVerticalStream$delegate", "getVsVerticalStream", "()Lcom/bytedance/live/datacontext/m;", "vsVerticalStream", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/b;", "commonPopupModel$delegate", "getCommonPopupModel", "commonPopupModel", "", "visibleRange$delegate", "getVisibleRange", "visibleRange", "anchorAnnounceStickerShow$delegate", "getAnchorAnnounceStickerShow", "anchorAnnounceStickerShow", "Lcq1/a;", "businessConfigureData$delegate", "getBusinessConfigureData", "businessConfigureData", "Lcom/bytedance/android/livesdkapi/depend/live/vs/listener/IVsVideoListManager;", "videoListener$delegate", "getVideoListener", "videoListener", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRoomPlayFragment$CaptureBitmapListener;", "captureBitmapListener$delegate", "getCaptureBitmapListener", "captureBitmapListener", "Lcom/bytedance/android/livesdk/chatroom/model/d3;", "imChannelInviteId$delegate", "getImChannelInviteId", "imChannelInviteId", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "pixCurrentEffect$delegate", "getPixCurrentEffect", "pixCurrentEffect", "Lcom/bytedance/android/livesdk/viewmodel/MergeDrawerViewModel;", "mergeDrawViewModel$delegate", "getMergeDrawViewModel", "mergeDrawViewModel", "Lcom/bytedance/android/livesdk/viewmodel/DrawCleanScreenViewModel;", "drawCleanScreenViewModel$delegate", "getDrawCleanScreenViewModel", "drawCleanScreenViewModel", "Lcom/bytedance/android/livesdkapi/depend/model/live/WelfareProjectInfo;", "welfareProjectInfo$delegate", "getWelfareProjectInfo", "welfareProjectInfo", "Lcom/bytedance/live/datacontext/i;", "isEnterFromPreviewLiveMix$delegate", "isEnterFromPreviewLiveMix", "()Lcom/bytedance/live/datacontext/i;", "isFromLiveTab$delegate", "isFromLiveTab", "isFirstEnterRoom$delegate", "isFirstEnterRoom", "Lcom/bytedance/live/datacontext/k;", "Lzg1/d;", "anchorLinkMicFinishEvent$delegate", "getAnchorLinkMicFinishEvent", "()Lcom/bytedance/live/datacontext/k;", "anchorLinkMicFinishEvent", "Lxa6/d;", "gameCpInstance$delegate", "getGameCpInstance", "gameCpInstance", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "previewSourceParam$delegate", "getPreviewSourceParam", "previewSourceParam", "Lcom/bytedance/android/livesdk/message/model/kj;", "mediaReviewRemindMessage$delegate", "getMediaReviewRemindMessage", "mediaReviewRemindMessage", "enterRoomStartTime$delegate", "getEnterRoomStartTime", "enterRoomStartTime", "isInSlideClean", "Z", "()Z", "setInSlideClean", "(Z)V", "isLiveEnableSwitchLandscape", "setLiveEnableSwitchLandscape", "isLiveLoggedEntraceSupport", "setLiveLoggedEntraceSupport", "gameCpToolbarHasError", "getGameCpToolbarHasError", "setGameCpToolbarHasError", "Lig1/b;", "castScreenEntryDismissTimer$delegate", "getCastScreenEntryDismissTimer", "castScreenEntryDismissTimer", "csGuideTimer$delegate", "getCsGuideTimer", "csGuideTimer", "com/bytedance/android/livesdk/chatroom/RoomContext$fallbackVM$1", "fallbackVM", "Lcom/bytedance/android/livesdk/chatroom/RoomContext$fallbackVM$1;", "Lcom/bytedance/android/livesdkapi/depend/model/gamecp/AnchorFloatBallDownloadData;", "anchorFloatBallDownloadData$delegate", "getAnchorFloatBallDownloadData", "anchorFloatBallDownloadData", "playId$delegate", "getPlayId", "playId", "needQueryHistoryMentionChat$delegate", "getNeedQueryHistoryMentionChat", "needQueryHistoryMentionChat", "teamStatus$delegate", "getTeamStatus", "teamStatus", "Lcom/bytedance/android/live/pushstream/d;", "liveStreamGame$delegate", "getLiveStreamGame", "liveStreamGame", "teamApplyNickName$delegate", "getTeamApplyNickName", "teamApplyNickName", "teamApplyNotify", "getTeamApplyNotify", "setTeamApplyNotify", "enableSchedulerAsyncTask", "getEnableSchedulerAsyncTask", "setEnableSchedulerAsyncTask", "teamApplyUserId$delegate", "getTeamApplyUserId", "teamApplyUserId", "sourceEnterFromMerge$delegate", "getSourceEnterFromMerge", "sourceEnterFromMerge", "sourceEnterMethod$delegate", "getSourceEnterMethod", "sourceEnterMethod", "moreLiveShowMarqueeShown$delegate", "getMoreLiveShowMarqueeShown", "moreLiveShowMarqueeShown", "Lcom/bytedance/android/livesdkapi/depend/model/gamecp/AnchorFloatBallGamePromoteNoticeData;", "anchorFloatBallGamePromoteNoticeData$delegate", "getAnchorFloatBallGamePromoteNoticeData", "anchorFloatBallGamePromoteNoticeData", "Lcom/bytedance/android/livesdk/chatroom/model/o0;", "inFold$delegate", "getInFold", "inFold", "Lcom/bytedance/android/livesdkapi/depend/model/gamecp/AnchorFloatWindowPerfData;", "perfData$delegate", "getPerfData", "perfData", "", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/livesdkapi/feedback/event/IFeedbackRoomAction;", "feedbackInterceptClose$delegate", "getFeedbackInterceptClose", "feedbackInterceptClose", "Lgh1/a;", "gestureLayoutBehaviorEvent$delegate", "getGestureLayoutBehaviorEvent", "gestureLayoutBehaviorEvent", "stickyBehaviorEvents", "Ljava/util/List;", "getStickyBehaviorEvents", "()Ljava/util/List;", "setStickyBehaviorEvents", "(Ljava/util/List;)V", "Lnz/f;", "anchorStatusPanelViewModel$delegate", "getAnchorStatusPanelViewModel", "anchorStatusPanelViewModel", "Lcom/bytedance/android/livesdk/landscape/ILandscapeSpiltManager;", "landscapeSpiltManager$delegate", "getLandscapeSpiltManager", "landscapeSpiltManager", "Lcom/bytedance/android/livesdk/chatroom/msgboard/a;", "vsMsgBoardDataContext$delegate", "getVsMsgBoardDataContext", "vsMsgBoardDataContext", "Lcom/bytedance/android/live/room/c;", "anchorUnionLiveDataContext$delegate", "getAnchorUnionLiveDataContext", "anchorUnionLiveDataContext", "Lh80/c;", "anchorRecordEnableTempState$delegate", "getAnchorRecordEnableTempState", "anchorRecordEnableTempState", "Lis2/d;", "roomEngine$delegate", "getRoomEngine", "roomEngine", "Lch1/b;", "reconnectMonitorMessage$delegate", "getReconnectMonitorMessage", "reconnectMonitorMessage", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "anchorPermeateSticker$delegate", "getAnchorPermeateSticker", "anchorPermeateSticker", "downLoadingInteractEffectId$delegate", "getDownLoadingInteractEffectId", "downLoadingInteractEffectId", "giftMessageChannelStatus$delegate", "getGiftMessageChannelStatus", "giftMessageChannelStatus", "Lcom/bytedance/android/livesdkapi/model/LiveBroadcastMusicEffectInfo;", "broadcastMusicEffectInfo$delegate", "getBroadcastMusicEffectInfo", "broadcastMusicEffectInfo", "Lcom/bytedance/android/livesdk/wrds/OpenPlatformMicroAppSyncModel;", "openPlatformMicroAppSyncModel$delegate", "getOpenPlatformMicroAppSyncModel", "openPlatformMicroAppSyncModel", "Lcom/bytedance/android/livesdkapi/model/ListenLiveStatus;", "listenLiveStatus$delegate", "getListenLiveStatus", "listenLiveStatus", "Lcom/bytedance/android/livesdkapi/model/LiveFloatWindowStatus;", "floatWindowStatus$delegate", "getFloatWindowStatus", "floatWindowStatus", "Lcom/bytedance/android/livesdk/config/ge1;", "playerTips$delegate", "getPlayerTips", "playerTips", "Lcom/bytedance/android/livesdkapi/multicamera/IMultiCameraLiveRtcManager;", "multiCameraRtcManager$delegate", "getMultiCameraRtcManager", "multiCameraRtcManager", "paymentPanelShowing$delegate", "getPaymentPanelShowing", "paymentPanelShowing", "isCommentaryRoom", "isPrivateRoom", "isVSLive", "isVSVerticalStream", "getEpisodeId", "()J", "episodeId", "isBroadcastMedia", "isAnchorMusicEffectOpen", "isPaidLive", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomContext extends MiddlewareRoomContext implements INewShareContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int MEDIA_STATUS_LIVE_STARTED = 5;
    public static final int MEDIA_STATUS_LIVE_STARTED_REVIEW_FAIL = 6;
    public static final int MEDIA_STATUS_REVIEWING = 1;
    public static final int MEDIA_STATUS_REVIEW_FAIL = 3;
    public static final int MEDIA_STATUS_REVIEW_SUCCESS = 2;
    public static final int MEDIA_STATUS_START_LIVE = 4;
    public static final int PIX_LEVEL_INIT = -2;
    public static final int PIX_LEVEL_PIX_PROP_ADDED = -1;
    private final com.bytedance.live.datacontext.p anchorAnnounceStickerShow$delegate;
    private final com.bytedance.live.datacontext.p anchorEffectStatusSyncModel$delegate;
    private final com.bytedance.live.datacontext.p anchorFloatBallDownloadData$delegate;
    private final com.bytedance.live.datacontext.p anchorFloatBallGamePromoteNoticeData$delegate;
    private final com.bytedance.live.datacontext.p anchorLinkMicFinishEvent$delegate;
    private final com.bytedance.live.datacontext.p anchorPermeateSticker$delegate;
    private final com.bytedance.live.datacontext.p anchorRecordEnableTempState$delegate;
    private final com.bytedance.live.datacontext.p anchorStatusPanelViewModel$delegate;
    private final com.bytedance.live.datacontext.p anchorUnionLiveDataContext$delegate;
    private final com.bytedance.live.datacontext.p broadcastMusicEffectInfo$delegate;
    private final com.bytedance.live.datacontext.p businessConfigureData$delegate;
    private final com.bytedance.live.datacontext.p captureBitmapListener$delegate;
    private final com.bytedance.live.datacontext.p castScreenEntryDismissTimer$delegate;
    private final com.bytedance.live.datacontext.p commonPopupModel$delegate;
    private final com.bytedance.live.datacontext.p csGuideTimer$delegate;
    private final com.bytedance.live.datacontext.p downLoadingInteractEffectId$delegate;
    private final com.bytedance.live.datacontext.p drawCleanScreenViewModel$delegate;
    private final com.bytedance.live.datacontext.p dslManager$delegate;
    private final com.bytedance.live.datacontext.p dslTemplateCenter$delegate;
    private final com.bytedance.live.datacontext.p dynamicStrategy$delegate;
    private boolean enableSchedulerAsyncTask;
    private final com.bytedance.live.datacontext.p enterRoomStartTime$delegate;
    private final RoomContext$fallbackVM$1 fallbackVM;
    private final com.bytedance.live.datacontext.p feedbackInterceptClose$delegate;
    private final com.bytedance.live.datacontext.p floatWindowStatus$delegate;
    private final com.bytedance.live.datacontext.p focusContext$delegate;
    private final com.bytedance.live.datacontext.p gameCpInstance$delegate;
    private boolean gameCpToolbarHasError;
    private final com.bytedance.live.datacontext.p gestureLayoutBehaviorEvent$delegate;
    private final com.bytedance.live.datacontext.p giftMessageChannelStatus$delegate;
    private final com.bytedance.live.datacontext.p giftTrayPosTransformer$delegate;
    private final com.bytedance.live.datacontext.p guestLiveCore$delegate;
    private final com.bytedance.live.datacontext.p highlightSyncModel$delegate;
    private final com.bytedance.live.datacontext.p imChannelInviteId$delegate;
    private final com.bytedance.live.datacontext.p inFold$delegate;
    private final com.bytedance.live.datacontext.p isEnterFromPreviewLiveMix$delegate;
    private final com.bytedance.live.datacontext.p isFirstEnterRoom$delegate;
    private final com.bytedance.live.datacontext.p isFromLiveTab$delegate;
    private boolean isInSlideClean;
    private boolean isLiveEnableSwitchLandscape;
    private boolean isLiveLoggedEntraceSupport;
    private final com.bytedance.live.datacontext.p landscapeSpiltManager$delegate;
    private final com.bytedance.live.datacontext.p listenLiveStatus$delegate;
    private final com.bytedance.live.datacontext.p liveRoomInstance$delegate;
    private final com.bytedance.live.datacontext.p liveStreamGame$delegate;
    private final com.bytedance.live.datacontext.p mediaReviewRemindMessage$delegate;
    private final com.bytedance.live.datacontext.p mergeDrawViewModel$delegate;
    private final com.bytedance.live.datacontext.p moreLiveShowMarqueeShown$delegate;
    private final com.bytedance.live.datacontext.p multiCameraRtcManager$delegate;
    private final com.bytedance.live.datacontext.p multiLinkRoomScope$delegate;
    private final com.bytedance.live.datacontext.p needQueryHistoryMentionChat$delegate;
    private final com.bytedance.live.datacontext.p openPlatformMicroAppSyncModel$delegate;
    private final com.bytedance.live.datacontext.p paymentPanelShowing$delegate;
    private final com.bytedance.live.datacontext.p perfData$delegate;
    private final com.bytedance.live.datacontext.p pixCurrentEffect$delegate;
    private final com.bytedance.live.datacontext.p playId$delegate;
    private final com.bytedance.live.datacontext.p playerTips$delegate;
    private final com.bytedance.live.datacontext.p previewSourceParam$delegate;
    private final com.bytedance.live.datacontext.p reconnectMonitorMessage$delegate;
    private final com.bytedance.live.datacontext.p roomEngine$delegate;
    private final com.bytedance.live.datacontext.p sourceEnterFromMerge$delegate;
    private final com.bytedance.live.datacontext.p sourceEnterMethod$delegate;
    private List<gh1.a> stickyBehaviorEvents;
    private final com.bytedance.live.datacontext.p teamApplyNickName$delegate;
    private boolean teamApplyNotify;
    private final com.bytedance.live.datacontext.p teamApplyUserId$delegate;
    private final com.bytedance.live.datacontext.p teamStatus$delegate;
    private final com.bytedance.live.datacontext.p videoListener$delegate;
    private final com.bytedance.live.datacontext.p visibleRange$delegate;
    private final com.bytedance.live.datacontext.p vsMsgBoardDataContext$delegate;
    private final com.bytedance.live.datacontext.p vsVerticalStream$delegate;
    private final com.bytedance.live.datacontext.p welfareProjectInfo$delegate;
    private final com.bytedance.live.datacontext.p wgameXInviteManager$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static RoomContext a(DataCenter r100, long r101) {
            MiddlewareRoomContext.Companion.getClass();
            MiddlewareRoomContext r102 = MiddlewareRoomContext.a.a(r100, r101);
            if ((r102 instanceof RoomContext) == true) goto L6;
            r102 = null;
        L6:
            return (RoomContext) r102;
        }

        @JvmStatic
        public static RoomContext b(DataCenter r100, String r101) {
            MiddlewareRoomContext.Companion.getClass();
            MiddlewareRoomContext r102 = MiddlewareRoomContext.a.b(r100, r101);
            if ((r102 instanceof RoomContext) == true) goto L6;
            r102 = null;
        L6:
            return (RoomContext) r102;
        }

        public static /* synthetic */ RoomContext c(a r100, DataCenter r101, long r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = 0;
        L8:
            r100.getClass();
            return a(r101, r102);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RoomContext.class, "guestLiveCore", "getGuestLiveCore()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "liveRoomInstance", "getLiveRoomInstance()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "multiLinkRoomScope", "getMultiLinkRoomScope()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "giftTrayPosTransformer", "getGiftTrayPosTransformer()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "highlightSyncModel", "getHighlightSyncModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "anchorEffectStatusSyncModel", "getAnchorEffectStatusSyncModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "focusContext", "getFocusContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "dynamicStrategy", "getDynamicStrategy()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "dslManager", "getDslManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "dslTemplateCenter", "getDslTemplateCenter()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "wgameXInviteManager", "getWgameXInviteManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "vsVerticalStream", "getVsVerticalStream()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "commonPopupModel", "getCommonPopupModel()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "visibleRange", "getVisibleRange()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "anchorAnnounceStickerShow", "getAnchorAnnounceStickerShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "businessConfigureData", "getBusinessConfigureData()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "videoListener", "getVideoListener()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "captureBitmapListener", "getCaptureBitmapListener()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "imChannelInviteId", "getImChannelInviteId()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "pixCurrentEffect", "getPixCurrentEffect()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "mergeDrawViewModel", "getMergeDrawViewModel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "drawCleanScreenViewModel", "getDrawCleanScreenViewModel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "welfareProjectInfo", "getWelfareProjectInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "isEnterFromPreviewLiveMix", "isEnterFromPreviewLiveMix()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "isFromLiveTab", "isFromLiveTab()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "isFirstEnterRoom", "isFirstEnterRoom()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "anchorLinkMicFinishEvent", "getAnchorLinkMicFinishEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "gameCpInstance", "getGameCpInstance()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "previewSourceParam", "getPreviewSourceParam()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "mediaReviewRemindMessage", "getMediaReviewRemindMessage()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "enterRoomStartTime", "getEnterRoomStartTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "castScreenEntryDismissTimer", "getCastScreenEntryDismissTimer()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "csGuideTimer", "getCsGuideTimer()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "anchorFloatBallDownloadData", "getAnchorFloatBallDownloadData()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "playId", "getPlayId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "needQueryHistoryMentionChat", "getNeedQueryHistoryMentionChat()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "teamStatus", "getTeamStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "liveStreamGame", "getLiveStreamGame()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "teamApplyNickName", "getTeamApplyNickName()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "teamApplyUserId", "getTeamApplyUserId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "sourceEnterFromMerge", "getSourceEnterFromMerge()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "sourceEnterMethod", "getSourceEnterMethod()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "moreLiveShowMarqueeShown", "getMoreLiveShowMarqueeShown()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "anchorFloatBallGamePromoteNoticeData", "getAnchorFloatBallGamePromoteNoticeData()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "inFold", "getInFold()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "perfData", "getPerfData()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "feedbackInterceptClose", "getFeedbackInterceptClose()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "gestureLayoutBehaviorEvent", "getGestureLayoutBehaviorEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "anchorStatusPanelViewModel", "getAnchorStatusPanelViewModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "landscapeSpiltManager", "getLandscapeSpiltManager()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "vsMsgBoardDataContext", "getVsMsgBoardDataContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "anchorUnionLiveDataContext", "getAnchorUnionLiveDataContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "anchorRecordEnableTempState", "getAnchorRecordEnableTempState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "roomEngine", "getRoomEngine()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "reconnectMonitorMessage", "getReconnectMonitorMessage()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "anchorPermeateSticker", "getAnchorPermeateSticker()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "downLoadingInteractEffectId", "getDownLoadingInteractEffectId()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "giftMessageChannelStatus", "getGiftMessageChannelStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "broadcastMusicEffectInfo", "getBroadcastMusicEffectInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "openPlatformMicroAppSyncModel", "getOpenPlatformMicroAppSyncModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "listenLiveStatus", "getListenLiveStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "floatWindowStatus", "getFloatWindowStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "playerTips", "getPlayerTips()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "multiCameraRtcManager", "getMultiCameraRtcManager()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(RoomContext.class, "paymentPanelShowing", "getPaymentPanelShowing()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final RoomContext getShared() {
        return a.c(Companion, null, 0, 3);
    }

    @JvmStatic
    public static final RoomContext getShared(DataCenter r100) {
        return a.c(Companion, r100, 0, 2);
    }

    @JvmStatic
    public static final RoomContext getShared(DataCenter r100, long r101) {
        Companion.getClass();
        return a.a(r100, r101);
    }

    @JvmStatic
    public static final RoomContext getShared(DataCenter r100, String r101) {
        Companion.getClass();
        return a.b(r100, r101);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getAnchorAnnounceStickerShow() {
        return (com.bytedance.live.datacontext.m) this.anchorAnnounceStickerShow$delegate.a(this, $$delegatedProperties[14]);
    }

    public final com.bytedance.live.datacontext.j<AnchorEffectStatusSyncModel> getAnchorEffectStatusSyncModel() {
        return (com.bytedance.live.datacontext.j) this.anchorEffectStatusSyncModel$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.m<AnchorFloatBallDownloadData> getAnchorFloatBallDownloadData() {
        return (com.bytedance.live.datacontext.m) this.anchorFloatBallDownloadData$delegate.a(this, $$delegatedProperties[33]);
    }

    public final com.bytedance.live.datacontext.n<AnchorFloatBallGamePromoteNoticeData> getAnchorFloatBallGamePromoteNoticeData() {
        return (com.bytedance.live.datacontext.n) this.anchorFloatBallGamePromoteNoticeData$delegate.a(this, $$delegatedProperties[43]);
    }

    public final com.bytedance.live.datacontext.k<zg1.d> getAnchorLinkMicFinishEvent() {
        return (com.bytedance.live.datacontext.k) this.anchorLinkMicFinishEvent$delegate.a(this, $$delegatedProperties[26]);
    }

    public final com.bytedance.live.datacontext.n<Sticker> getAnchorPermeateSticker() {
        return (com.bytedance.live.datacontext.n) this.anchorPermeateSticker$delegate.a(this, $$delegatedProperties[55]);
    }

    public final com.bytedance.live.datacontext.m<h80.c<Boolean>> getAnchorRecordEnableTempState() {
        return (com.bytedance.live.datacontext.m) this.anchorRecordEnableTempState$delegate.a(this, $$delegatedProperties[52]);
    }

    public final com.bytedance.live.datacontext.j<nz.f> getAnchorStatusPanelViewModel() {
        return (com.bytedance.live.datacontext.j) this.anchorStatusPanelViewModel$delegate.a(this, $$delegatedProperties[48]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.live.room.c> getAnchorUnionLiveDataContext() {
        return (com.bytedance.live.datacontext.j) this.anchorUnionLiveDataContext$delegate.a(this, $$delegatedProperties[51]);
    }

    public final com.bytedance.live.datacontext.n<LiveBroadcastMusicEffectInfo> getBroadcastMusicEffectInfo() {
        return (com.bytedance.live.datacontext.n) this.broadcastMusicEffectInfo$delegate.a(this, $$delegatedProperties[58]);
    }

    public final com.bytedance.live.datacontext.j<cq1.a> getBusinessConfigureData() {
        return (com.bytedance.live.datacontext.j) this.businessConfigureData$delegate.a(this, $$delegatedProperties[15]);
    }

    public final com.bytedance.live.datacontext.n<ILiveRoomPlayFragment.CaptureBitmapListener> getCaptureBitmapListener() {
        return (com.bytedance.live.datacontext.n) this.captureBitmapListener$delegate.a(this, $$delegatedProperties[17]);
    }

    public final com.bytedance.live.datacontext.m<ig1.b> getCastScreenEntryDismissTimer() {
        return (com.bytedance.live.datacontext.m) this.castScreenEntryDismissTimer$delegate.a(this, $$delegatedProperties[31]);
    }

    public final com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.chatroom.viewmodel.b> getCommonPopupModel() {
        return (com.bytedance.live.datacontext.m) this.commonPopupModel$delegate.a(this, $$delegatedProperties[12]);
    }

    public final com.bytedance.live.datacontext.m<ig1.b> getCsGuideTimer() {
        return (com.bytedance.live.datacontext.m) this.csGuideTimer$delegate.a(this, $$delegatedProperties[32]);
    }

    public final com.bytedance.live.datacontext.n<String> getDownLoadingInteractEffectId() {
        return (com.bytedance.live.datacontext.n) this.downLoadingInteractEffectId$delegate.a(this, $$delegatedProperties[56]);
    }

    public final com.bytedance.live.datacontext.n<DrawCleanScreenViewModel> getDrawCleanScreenViewModel() {
        return (com.bytedance.live.datacontext.n) this.drawCleanScreenViewModel$delegate.a(this, $$delegatedProperties[21]);
    }

    @Override // com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext
    public com.bytedance.live.datacontext.j<yt1.n> getDslManager() {
        return (com.bytedance.live.datacontext.j) this.dslManager$delegate.a(this, $$delegatedProperties[8]);
    }

    @Override // com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext
    public com.bytedance.live.datacontext.j<zt1.c> getDslTemplateCenter() {
        return (com.bytedance.live.datacontext.j) this.dslTemplateCenter$delegate.a(this, $$delegatedProperties[9]);
    }

    @Override // com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext
    public com.bytedance.live.datacontext.j<IDynamicStrategyContext> getDynamicStrategy() {
        return (com.bytedance.live.datacontext.j) this.dynamicStrategy$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.m<Long> getEnterRoomStartTime() {
        return (com.bytedance.live.datacontext.m) this.enterRoomStartTime$delegate.a(this, $$delegatedProperties[30]);
    }

    public final com.bytedance.live.datacontext.m<List<WeakReference<IFeedbackRoomAction>>> getFeedbackInterceptClose() {
        return (com.bytedance.live.datacontext.m) this.feedbackInterceptClose$delegate.a(this, $$delegatedProperties[46]);
    }

    public final com.bytedance.live.datacontext.m<LiveFloatWindowStatus> getFloatWindowStatus() {
        return (com.bytedance.live.datacontext.m) this.floatWindowStatus$delegate.a(this, $$delegatedProperties[61]);
    }

    public final com.bytedance.live.datacontext.j<IFocusContext> getFocusContext() {
        return (com.bytedance.live.datacontext.j) this.focusContext$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.j<xa6.d> getGameCpInstance() {
        return (com.bytedance.live.datacontext.j) this.gameCpInstance$delegate.a(this, $$delegatedProperties[27]);
    }

    public final com.bytedance.live.datacontext.k<gh1.a> getGestureLayoutBehaviorEvent() {
        return (com.bytedance.live.datacontext.k) this.gestureLayoutBehaviorEvent$delegate.a(this, $$delegatedProperties[47]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getGiftMessageChannelStatus() {
        return (com.bytedance.live.datacontext.m) this.giftMessageChannelStatus$delegate.a(this, $$delegatedProperties[57]);
    }

    public final com.bytedance.live.datacontext.j<InteractionWidgetPosTransformer> getGiftTrayPosTransformer() {
        return (com.bytedance.live.datacontext.j) this.giftTrayPosTransformer$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.n<uf2.d0> getGuestLiveCore() {
        return (com.bytedance.live.datacontext.n) this.guestLiveCore$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.j<HighlightContainerSyncModel> getHighlightSyncModel() {
        return (com.bytedance.live.datacontext.j) this.highlightSyncModel$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.n<d3> getImChannelInviteId() {
        return (com.bytedance.live.datacontext.n) this.imChannelInviteId$delegate.a(this, $$delegatedProperties[18]);
    }

    public final com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.chatroom.model.o0> getInFold() {
        return (com.bytedance.live.datacontext.m) this.inFold$delegate.a(this, $$delegatedProperties[44]);
    }

    public final com.bytedance.live.datacontext.n<ILandscapeSpiltManager> getLandscapeSpiltManager() {
        return (com.bytedance.live.datacontext.n) this.landscapeSpiltManager$delegate.a(this, $$delegatedProperties[49]);
    }

    public final com.bytedance.live.datacontext.m<ListenLiveStatus> getListenLiveStatus() {
        return (com.bytedance.live.datacontext.m) this.listenLiveStatus$delegate.a(this, $$delegatedProperties[60]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.live.kmp.core.a> getLiveRoomInstance() {
        return (com.bytedance.live.datacontext.j) this.liveRoomInstance$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.n<com.bytedance.android.live.pushstream.d> getLiveStreamGame() {
        return (com.bytedance.live.datacontext.n) this.liveStreamGame$delegate.a(this, $$delegatedProperties[37]);
    }

    public final com.bytedance.live.datacontext.n<kj> getMediaReviewRemindMessage() {
        return (com.bytedance.live.datacontext.n) this.mediaReviewRemindMessage$delegate.a(this, $$delegatedProperties[29]);
    }

    public final com.bytedance.live.datacontext.n<MergeDrawerViewModel> getMergeDrawViewModel() {
        return (com.bytedance.live.datacontext.n) this.mergeDrawViewModel$delegate.a(this, $$delegatedProperties[20]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getMoreLiveShowMarqueeShown() {
        return (com.bytedance.live.datacontext.m) this.moreLiveShowMarqueeShown$delegate.a(this, $$delegatedProperties[42]);
    }

    public final com.bytedance.live.datacontext.n<IMultiCameraLiveRtcManager> getMultiCameraRtcManager() {
        return (com.bytedance.live.datacontext.n) this.multiCameraRtcManager$delegate.a(this, $$delegatedProperties[63]);
    }

    public final com.bytedance.live.datacontext.n<bn0.b> getMultiLinkRoomScope() {
        return (com.bytedance.live.datacontext.n) this.multiLinkRoomScope$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.i<Boolean> getNeedQueryHistoryMentionChat() {
        return (com.bytedance.live.datacontext.i) this.needQueryHistoryMentionChat$delegate.a(this, $$delegatedProperties[35]);
    }

    public final com.bytedance.live.datacontext.j<OpenPlatformMicroAppSyncModel> getOpenPlatformMicroAppSyncModel() {
        return (com.bytedance.live.datacontext.j) this.openPlatformMicroAppSyncModel$delegate.a(this, $$delegatedProperties[59]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getPaymentPanelShowing() {
        return (com.bytedance.live.datacontext.m) this.paymentPanelShowing$delegate.a(this, $$delegatedProperties[64]);
    }

    public final com.bytedance.live.datacontext.n<AnchorFloatWindowPerfData> getPerfData() {
        return (com.bytedance.live.datacontext.n) this.perfData$delegate.a(this, $$delegatedProperties[45]);
    }

    public final com.bytedance.live.datacontext.n<Effect> getPixCurrentEffect() {
        return (com.bytedance.live.datacontext.n) this.pixCurrentEffect$delegate.a(this, $$delegatedProperties[19]);
    }

    public final com.bytedance.live.datacontext.m<String> getPlayId() {
        return (com.bytedance.live.datacontext.m) this.playId$delegate.a(this, $$delegatedProperties[34]);
    }

    public final com.bytedance.live.datacontext.n<ge1> getPlayerTips() {
        return (com.bytedance.live.datacontext.n) this.playerTips$delegate.a(this, $$delegatedProperties[62]);
    }

    public final com.bytedance.live.datacontext.j<PreviewSourceParam> getPreviewSourceParam() {
        return (com.bytedance.live.datacontext.j) this.previewSourceParam$delegate.a(this, $$delegatedProperties[28]);
    }

    public final com.bytedance.live.datacontext.m<ch1.b> getReconnectMonitorMessage() {
        return (com.bytedance.live.datacontext.m) this.reconnectMonitorMessage$delegate.a(this, $$delegatedProperties[54]);
    }

    public final com.bytedance.live.datacontext.n<is2.d> getRoomEngine() {
        return (com.bytedance.live.datacontext.n) this.roomEngine$delegate.a(this, $$delegatedProperties[53]);
    }

    public final com.bytedance.live.datacontext.n<String> getSourceEnterFromMerge() {
        return (com.bytedance.live.datacontext.n) this.sourceEnterFromMerge$delegate.a(this, $$delegatedProperties[40]);
    }

    public final com.bytedance.live.datacontext.n<String> getSourceEnterMethod() {
        return (com.bytedance.live.datacontext.n) this.sourceEnterMethod$delegate.a(this, $$delegatedProperties[41]);
    }

    public final com.bytedance.live.datacontext.m<String> getTeamApplyNickName() {
        return (com.bytedance.live.datacontext.m) this.teamApplyNickName$delegate.a(this, $$delegatedProperties[38]);
    }

    public final com.bytedance.live.datacontext.m<String> getTeamApplyUserId() {
        return (com.bytedance.live.datacontext.m) this.teamApplyUserId$delegate.a(this, $$delegatedProperties[39]);
    }

    public final com.bytedance.live.datacontext.m<String> getTeamStatus() {
        return (com.bytedance.live.datacontext.m) this.teamStatus$delegate.a(this, $$delegatedProperties[36]);
    }

    public final com.bytedance.live.datacontext.j<IVsVideoListManager> getVideoListener() {
        return (com.bytedance.live.datacontext.j) this.videoListener$delegate.a(this, $$delegatedProperties[16]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getVisibleRange() {
        return (com.bytedance.live.datacontext.m) this.visibleRange$delegate.a(this, $$delegatedProperties[13]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.msgboard.a> getVsMsgBoardDataContext() {
        return (com.bytedance.live.datacontext.j) this.vsMsgBoardDataContext$delegate.a(this, $$delegatedProperties[50]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getVsVerticalStream() {
        return (com.bytedance.live.datacontext.m) this.vsVerticalStream$delegate.a(this, $$delegatedProperties[11]);
    }

    public final com.bytedance.live.datacontext.n<WelfareProjectInfo> getWelfareProjectInfo() {
        return (com.bytedance.live.datacontext.n) this.welfareProjectInfo$delegate.a(this, $$delegatedProperties[22]);
    }

    public final com.bytedance.live.datacontext.j<zr1.c> getWgameXInviteManager() {
        return (com.bytedance.live.datacontext.j) this.wgameXInviteManager$delegate.a(this, $$delegatedProperties[10]);
    }

    public final com.bytedance.live.datacontext.i<Boolean> isEnterFromPreviewLiveMix() {
        return (com.bytedance.live.datacontext.i) this.isEnterFromPreviewLiveMix$delegate.a(this, $$delegatedProperties[23]);
    }

    public final com.bytedance.live.datacontext.i<Boolean> isFirstEnterRoom() {
        return (com.bytedance.live.datacontext.i) this.isFirstEnterRoom$delegate.a(this, $$delegatedProperties[25]);
    }

    public final com.bytedance.live.datacontext.i<Boolean> isFromLiveTab() {
        return (com.bytedance.live.datacontext.i) this.isFromLiveTab$delegate.a(this, $$delegatedProperties[24]);
    }

    @Override // com.bytedance.android.livesdkapi.arch.INewShareContext
    public void shareGlobalSingleInstance() {
        com.bytedance.live.datacontext.b.a(this, RoomContext.class);
        com.bytedance.live.datacontext.b.a(this, MiddlewareRoomContext.class);
        com.bytedance.live.datacontext.b.a(this, o.class);
    }

    /* JADX WARN: Type inference failed for: r2v26, types: [com.bytedance.android.livesdk.chatroom.RoomContext$fallbackVM$1] */
    public RoomContext() {
        this.guestLiveCore$delegate = com.bytedance.live.datacontext.q.c(this);
        this.liveRoomInstance$delegate = ConstantKt.b(this, RoomContext$liveRoomInstance$2.INSTANCE);
        this.multiLinkRoomScope$delegate = com.bytedance.live.datacontext.q.c(this);
        this.giftTrayPosTransformer$delegate = ConstantKt.b(this, RoomContext$giftTrayPosTransformer$2.INSTANCE);
        if (ht1.a.a() == false) goto L5;
        com.bytedance.live.datacontext.p r100 = DataContextExtKt.b(this, "highlightSyncModel");
    L6:
        this.highlightSyncModel$delegate = r100;
        this.anchorEffectStatusSyncModel$delegate = ConstantKt.c(this);
        this.focusContext$delegate = ConstantKt.c(this);
        this.dynamicStrategy$delegate = ConstantKt.b(this, RoomContext$dynamicStrategy$2.INSTANCE);
        this.dslManager$delegate = ConstantKt.b(this, RoomContext$dslManager$2.INSTANCE);
        this.dslTemplateCenter$delegate = ConstantKt.b(this, RoomContext$dslTemplateCenter$2.INSTANCE);
        this.wgameXInviteManager$delegate = ConstantKt.c(this);
        int r101 = 0;
        if (nm1.v.b(getVsRoom()) != 2) goto L9;
        boolean r102 = true;
    L10:
        this.vsVerticalStream$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.valueOf(r102));
        this.commonPopupModel$delegate = com.bytedance.live.datacontext.q.d(this, new com.bytedance.android.livesdk.chatroom.viewmodel.b());
        this.visibleRange$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        Boolean r103 = Boolean.FALSE;
        this.anchorAnnounceStickerShow$delegate = com.bytedance.live.datacontext.q.d(this, r103);
        this.businessConfigureData$delegate = ConstantKt.c(this);
        this.videoListener$delegate = ConstantKt.c(this);
        this.captureBitmapListener$delegate = com.bytedance.live.datacontext.q.c(this);
        this.imChannelInviteId$delegate = com.bytedance.live.datacontext.q.c(this);
        this.pixCurrentEffect$delegate = com.bytedance.live.datacontext.q.c(this);
        this.mergeDrawViewModel$delegate = com.bytedance.live.datacontext.q.b(this, RoomContext$mergeDrawViewModel$2.INSTANCE);
        this.drawCleanScreenViewModel$delegate = com.bytedance.live.datacontext.q.b(this, RoomContext$drawCleanScreenViewModel$2.INSTANCE);
        this.welfareProjectInfo$delegate = com.bytedance.live.datacontext.q.c(this);
        this.isEnterFromPreviewLiveMix$delegate = ConstantKt.d(this, r103);
        this.isFromLiveTab$delegate = ConstantKt.d(this, r103);
        this.isFirstEnterRoom$delegate = ConstantKt.d(this, r103);
        this.anchorLinkMicFinishEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.gameCpInstance$delegate = ConstantKt.c(this);
        this.previewSourceParam$delegate = ConstantKt.c(this);
        this.mediaReviewRemindMessage$delegate = com.bytedance.live.datacontext.q.c(this);
        this.enterRoomStartTime$delegate = com.bytedance.live.datacontext.q.d(this, -1L);
        this.castScreenEntryDismissTimer$delegate = com.bytedance.live.datacontext.q.d(this, new ig1.a());
        this.csGuideTimer$delegate = com.bytedance.live.datacontext.q.a(this, new ig1.c(), RoomContext$csGuideTimer$2.INSTANCE);
        this.fallbackVM = new RoomContext$fallbackVM$1();
        this.anchorFloatBallDownloadData$delegate = com.bytedance.live.datacontext.q.d(this, new AnchorFloatBallDownloadData(0, false, 0, false, false, 31, null));
        this.playId$delegate = com.bytedance.live.datacontext.q.d(this, new String());
        this.needQueryHistoryMentionChat$delegate = ConstantKt.d(this, r103);
        this.teamStatus$delegate = com.bytedance.live.datacontext.q.d(this, new String());
        this.liveStreamGame$delegate = com.bytedance.live.datacontext.q.c(this);
        this.teamApplyNickName$delegate = com.bytedance.live.datacontext.q.d(this, new String());
        this.teamApplyUserId$delegate = com.bytedance.live.datacontext.q.d(this, new String());
        this.sourceEnterFromMerge$delegate = com.bytedance.live.datacontext.q.c(this);
        this.sourceEnterMethod$delegate = com.bytedance.live.datacontext.q.c(this);
        this.moreLiveShowMarqueeShown$delegate = com.bytedance.live.datacontext.q.d(this, r103);
        this.anchorFloatBallGamePromoteNoticeData$delegate = com.bytedance.live.datacontext.q.c(this);
        this.inFold$delegate = com.bytedance.live.datacontext.q.d(this, new com.bytedance.android.livesdk.chatroom.model.o0());
        this.perfData$delegate = com.bytedance.live.datacontext.q.c(this);
        this.feedbackInterceptClose$delegate = com.bytedance.live.datacontext.q.d(this, new ArrayList());
        this.gestureLayoutBehaviorEvent$delegate = com.bytedance.live.datacontext.e.a(this, RoomContext$gestureLayoutBehaviorEvent$2.INSTANCE);
        this.stickyBehaviorEvents = new ArrayList();
        this.anchorStatusPanelViewModel$delegate = ConstantKt.c(this);
        this.landscapeSpiltManager$delegate = com.bytedance.live.datacontext.q.c(this);
        this.vsMsgBoardDataContext$delegate = ConstantKt.c(this);
        this.anchorUnionLiveDataContext$delegate = ConstantKt.c(this);
        this.anchorRecordEnableTempState$delegate = com.bytedance.live.datacontext.q.d(this, h80.c.f484054b);
        this.roomEngine$delegate = com.bytedance.live.datacontext.q.c(this);
        this.reconnectMonitorMessage$delegate = com.bytedance.live.datacontext.q.d(this, new ch1.b(r101));
        this.anchorPermeateSticker$delegate = com.bytedance.live.datacontext.q.c(this);
        this.downLoadingInteractEffectId$delegate = com.bytedance.live.datacontext.q.c(this);
        this.giftMessageChannelStatus$delegate = com.bytedance.live.datacontext.q.d(this, r103);
        this.broadcastMusicEffectInfo$delegate = com.bytedance.live.datacontext.q.c(this);
        this.openPlatformMicroAppSyncModel$delegate = ConstantKt.c(this);
        this.listenLiveStatus$delegate = com.bytedance.live.datacontext.q.d(this, new ListenLiveStatus());
        this.floatWindowStatus$delegate = com.bytedance.live.datacontext.q.d(this, new LiveFloatWindowStatus());
        this.playerTips$delegate = com.bytedance.live.datacontext.q.c(this);
        this.multiCameraRtcManager$delegate = com.bytedance.live.datacontext.q.c(this);
        this.paymentPanelShowing$delegate = com.bytedance.live.datacontext.q.d(this, r103);
        return;
    L9:
        r102 = false;
        goto L10
    L5:
        r100 = ConstantKt.c(this);
        goto L6
    }

    public final long getEpisodeId() {
        EpisodeExtraInfo r100 = getRoom().getValue().getEpisodeExtra();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getId();
    }

    public final boolean isAnchorMusicEffectOpen() {
        LiveBroadcastMusicEffectInfo r100 = getBroadcastMusicEffectInfo().getValue();
        if (r100 == null) goto L7;
        String r101 = r100.getEffectId();
        if (r101 == null) goto L7;
        return r2.a(r101);
    L7:
        return false;
    }

    public final boolean isBroadcastMedia() {
        if (isMediaRoom() == true) goto L5;
    L7:
        return false;
    L5:
        if (isAnchor().getValue().booleanValue() == false) goto L7;
        return true;
    }

    public final boolean isCommentaryRoom() {
        RoomSpecificSceneTypeInfo r100 = getRoom().getValue().getSceneTypeInfo();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isCommentaryRoom() != true) goto L7;
        return true;
    }

    public final boolean isPaidLive() {
        return getRoom().getValue().isPaidLive();
    }

    public final boolean isPrivateRoom() {
        if (getRoom().getValue().getVisibilityRange() != 16) goto L5;
    L8:
        return true;
    L5:
        if (getRoom().getValue().getVisibilityRange() == 17) goto L8;
        return false;
    }

    public final boolean isVSLive() {
        EpisodeExtraInfo r100 = getVsRoom().getEpisodeExtra();
        if (r100 == null) goto L9;
        IBaseEpisodeMod r101 = r100.getMod();
        if (r101 == null) goto L9;
        if (r101.getEpisodeStage() != EpisodeMod.EpisodeStageType.LIVE) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isVSVerticalStream() {
        return getVsVerticalStream().getValue().booleanValue();
    }

    public final boolean getEnableSchedulerAsyncTask() {
        return this.enableSchedulerAsyncTask;
    }

    public final boolean getGameCpToolbarHasError() {
        return this.gameCpToolbarHasError;
    }

    public final List<gh1.a> getStickyBehaviorEvents() {
        return this.stickyBehaviorEvents;
    }

    public final boolean getTeamApplyNotify() {
        return this.teamApplyNotify;
    }

    public final boolean isInSlideClean() {
        return this.isInSlideClean;
    }

    public final boolean isLiveEnableSwitchLandscape() {
        return this.isLiveEnableSwitchLandscape;
    }

    public final boolean isLiveLoggedEntraceSupport() {
        return this.isLiveLoggedEntraceSupport;
    }

    @JvmStatic
    public static final RoomContext getShared(String r100) {
        Companion.getClass();
        return a.b(null, r100);
    }

    public final void setEnableSchedulerAsyncTask(boolean r100) {
        this.enableSchedulerAsyncTask = r100;
    }

    public final void setGameCpToolbarHasError(boolean r100) {
        this.gameCpToolbarHasError = r100;
    }

    public final void setInSlideClean(boolean r100) {
        this.isInSlideClean = r100;
    }

    public final void setLiveEnableSwitchLandscape(boolean r100) {
        this.isLiveEnableSwitchLandscape = r100;
    }

    public final void setLiveLoggedEntraceSupport(boolean r100) {
        this.isLiveLoggedEntraceSupport = r100;
    }

    public final void setStickyBehaviorEvents(List<gh1.a> r100) {
        this.stickyBehaviorEvents = r100;
    }

    public final void setTeamApplyNotify(boolean r100) {
        this.teamApplyNotify = r100;
    }

    public final void share(DataCenter r100, Room r101) {
        if (r101 == null) goto L4;
        long r102 = r101.f162599id;
    L5:
        share(r100, r102);
        return;
    L4:
        r102 = 0;
        goto L5
    }

    @Override // com.bytedance.android.livesdkapi.arch.INewShareContext
    public void shareByUniqueId(DataCenter r100, String r101) {
        if (r101 != null) goto L4;
    L9:
        if (r100 == null) goto L12;
        com.bytedance.live.datacontext.b.a(this, Integer.valueOf(r100.hashCode()));
        return;
    L12:
        return;
    L4:
        if (r101.length() <= 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 != true) goto L9;
        com.bytedance.live.datacontext.b.a(this, r101);
        goto L9
    L6:
        r102 = false;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext
    public void share(DataCenter r100, long r101) {
        super.share(r100, r101);
        com.bytedance.live.datacontext.b.a(this, RoomContext.class);
    }

    @Override // com.bytedance.android.livesdkapi.arch.INewShareContext
    public void shareToScope(DataCenter r100, Long r101, String r102) {
        if (r102 != null) goto L4;
    L9:
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.b.a(this, Integer.valueOf(r100.hashCode()));
    L11:
        if (r101 == null) goto L14;
        com.bytedance.live.datacontext.b.a(this, r101);
        return;
    L14:
        return;
    L4:
        if (r102.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 != true) goto L9;
        com.bytedance.live.datacontext.b.a(this, r102);
        goto L9
    L6:
        r103 = false;
        goto L7
    }
}
