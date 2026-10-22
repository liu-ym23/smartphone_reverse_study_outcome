package com.bytedance.android.live.broadcastgame;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget;
import com.bytedance.android.live.broadcastgame.api.IAudienceGameWidget;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.JsFuncInjector;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.network.BroadcastGameApi;
import com.bytedance.android.live.broadcastgame.xplay.XplayGlobalServiceImpl;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.a2;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0096\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 Þ\u00012\u00020\u0001:\u0002ß\u0001B\t¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J,\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u001a\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0010H\u0016J<\u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0010H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\u0018\u00105\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u001eH\u0016J6\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0:092\u0006\u00106\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u00010\u00102\u0006\u00108\u001a\u00020\u0002H\u0016JN\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0:092\u0006\u00106\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020.2\u0006\u00108\u001a\u00020\u0002H\u0016J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0010H\u0016J\b\u0010E\u001a\u00020\u0004H\u0016J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0010H\u0016J&\u0010J\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00102\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010A0HH\u0016J\u0016\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010HH\u0016J\u0011\u0010L\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0010H\u0016J\u001a\u0010P\u001a\u0004\u0018\u00010O2\u0006\u0010C\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001eH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010AH\u0016J\n\u0010S\u001a\u0004\u0018\u00010RH\u0016J \u0010W\u001a\u00020V2\u0006\u0010U\u001a\u00020T2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J@\u0010]\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020.2\u0006\u0010[\u001a\u00020Z2\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0016J0\u0010_\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020ZH\u0016J\u001a\u0010`\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016Jb\u0010l\u001a\u0004\u0018\u00010R2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2>\u0010i\u001a:\u0012\u0013\u0012\u00110b¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b(e\u0012\u0015\u0012\u0013\u0018\u00010f¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b(g\u0012\u0006\u0012\u0004\u0018\u00010R0aj\u0002`h2\u0006\u0010k\u001a\u00020jH\u0016J\u001c\u0010p\u001a\u0004\u0018\u00010R2\u0006\u0010m\u001a\u00020\u00062\b\u0010o\u001a\u0004\u0018\u00010nH\u0016J\u0012\u0010r\u001a\u0004\u0018\u00010\u00102\u0006\u0010q\u001a\u00020\u0010H\u0016J,\u0010u\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010s\u001a\u00020\u00102\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100HH\u0016J \u0010x\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020w\u0018\u00010v2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010z\u001a\u00020\u00042\u0006\u0010y\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010}\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u001e2\b\u0010g\u001a\u0004\u0018\u00010|H\u0016J\u001a\u0010~\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u001e2\b\u0010g\u001a\u0004\u0018\u00010|H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\u001eH\u0016J\u0013\u0010\u0081\u0001\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u0010H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0004H\u0016J\u0015\u0010\u0085\u0001\u001a\u000e\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u0084\u00010\u0083\u0001H\u0016J\u0011\u0010\u0086\u0001\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0010H\u0016J\u0011\u0010\u0087\u0001\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0010H\u0016J'\u0010\u008c\u0001\u001a\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020\u001e2\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00012\u0007\u0010\u008b\u0001\u001a\u00020.H\u0016J\u0012\u0010\u008d\u0001\u001a\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020\u001eH\u0016J\u0011\u0010\u008e\u0001\u001a\u00020.2\u0006\u0010C\u001a\u00020\u0010H\u0016J\u001a\u0010\u0090\u0001\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020.H\u0016J\u001b\u0010\u0091\u0001\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001b\u0010\u0094\u0001\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00102\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001H\u0016J\t\u0010\u0095\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0096\u0001\u001a\u00020\u001eH\u0016J\u0012\u0010\u0097\u0001\u001a\u00020\u00042\u0007\u0010\u0096\u0001\u001a\u00020\u001eH\u0016J\u0011\u0010\u0098\u0001\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u001eH\u0016J\u0011\u0010\u0099\u0001\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u001eH\u0016J#\u0010\u009a\u0001\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u009b\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0006H\u0016J\f\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0016J\t\u0010\u009f\u0001\u001a\u00020\u0010H\u0016J\u0011\u0010 \u0001\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001eH\u0016J\t\u0010¡\u0001\u001a\u00020\u0010H\u0016J\f\u0010£\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0016J\u0013\u0010¦\u0001\u001a\u00020\u00042\b\u0010¥\u0001\u001a\u00030¤\u0001H\u0016J\t\u0010§\u0001\u001a\u00020\u001eH\u0016J5\u0010\u00ad\u0001\u001a\u00020\u00042\u0007\u0010¨\u0001\u001a\u00020\u00102\b\u0010ª\u0001\u001a\u00030©\u00012\u0017\u0010¬\u0001\u001a\u0012\u0012\u0005\u0012\u00030©\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010«\u0001H\u0016J\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010°\u0001\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R(\u0010¸\u0001\u001a\n\u0012\u0005\u0012\u00030³\u00010²\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010¹\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001b\u0010»\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R;\u0010¿\u0001\u001a$\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020.\u0018\u00010½\u0001j\u0011\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020.\u0018\u0001`¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R=\u0010Á\u0001\u001a&\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010½\u0001j\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u0001`¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010À\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010º\u0001R8\u0010Ä\u0001\u001a\u0005\u0018\u00010Â\u00012\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u00018\u0006@GX\u0086\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R:\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u00012\f\b\u0001\u0010Ã\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0006@GX\u0086\u000e¢\u0006\u0018\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R:\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00012\f\b\u0001\u0010Ã\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0006@GX\u0086\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R#\u0010Ú\u0001\u001a\f\u0012\u0005\u0012\u00030Ù\u0001\u0018\u00010Ø\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001¨\u0006à\u0001"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/InteractGameService;", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/IInteractGameService;", "", "roomId", "", "runAnchorEnterRoomTask", "Lcom/bytedance/android/live/broadcastgame/api/model/u;", "game", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/p;", "sonicPluginListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "realLaunchGame", "stopRunningPlugin", "", "reason", "Lcom/bytedance/android/live/pushstream/d;", "liveStream", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bytedance/android/live/broadcastgame/api/IAnchorGameWidget;", "getAnchorGameWidget", "seiMsg", "onSei", "", "isDegrade", "Lcom/bytedance/android/live/broadcastgame/api/IAudienceGameWidget;", "getAudienceGameWidget", "from", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/h;", "getGameExitConformDialog", "gameItem", "Lkotlin/Function0;", "onSuccess", "onFail", "tryGetSwitchGameConfirmDialog", "getCurrentPlayingGame", "isPlayingGame", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractID;", "gameType", "", "getCurrentPlayingGameId", "guideParams", "setGameGuideHelper", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/d;", "getGameGuideHelper", "isAnchor", "initGameContext", "gameId", "openType", "gameToken", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/api/model/e0;", "notifyServerGameStart", "playId", "gameData", "isCutShort", "stopReason", "", "notifyServerGameStop", "appId", "anchorLaunchGame", "audienceLaunchGame", "schema", "preloadOpenPlatformGame", "", "startParmaMap", "openOpenPlatformGame", "getOpenPlatformGameCommonLogMap", "isOpenPlatformGameOpeningLynxPanelInGame", "()Ljava/lang/Boolean;", "closeOpenPlatformGame", "Lcom/bytedance/android/live/broadcastgame/api/model/h;", "fetchGameIconInfo", "createOpenToolbarEntBehavior", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "createOpenGameBehaivor", "Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeManager;", "jsBridgeManager", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/JsFuncInjector;", "createOpenJsFuncInject", "ctx", "code", "", "e", EventConstant.Value.RETRY, "confirmGameStartFailed", "anchor", "confirmGameException", "executeEnterRoomTask", "Lkotlin/Function2;", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "Lkotlin/ParameterName;", "name", "data", "Lcom/bytedance/android/live/broadcastgame/api/model/z;", "extra", "Lcom/bytedance/android/live/broadcastgame/api/model/LiveOpenFeatureBehaviorFactory;", "behaviorFactory", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/g;", "createFactory", "getOpenPlatformBehavior", MapController.ITEM_LAYER_TAG, "Lmh1/p;", "miniAppHelper", "getOpenPlatformItemBehavior", "cipherText", "decryptUserInfo", "location", "liveParams", "openMiniApp", "Le10/b;", "Le10/a$a;", "getLiveOpenFeatureSceneFilter", "key", "sendGameSeiData", "inCast", "Lorg/json/JSONObject;", "sendGameCastStatusSEI", "sendServerMergeCastStatusSEI", "isReady", "setAudienceMiniAppReady", "setAudienceMiniAppSchema", "stopGameCastToAudience", "", "Ljava/lang/Class;", "getAllOpenPlatformActivity", "addItemToDataCacheHelper", "deleteData", "success", "Landroid/view/Surface;", "surface", "fps", "notifyStartLinkCastResult", "notifyStopLinkCastResult", "getEntranceVisibility", RemoteMessageConst.Notification.VISIBILITY, "cacheEntranceVisibility", "consumeCacheOpenPlatformMessage", "Lcom/bytedance/android/live/base/model/message/t;", "message", "cacheOpenPlatformMessage", "clearCache", "isGameCasting", "setGameCasting", "hidePlugin", "showPlugin", "startOpenPlatformSonicPlugin", "Lio/reactivex/Single;", "showOpenGameAuthDialog", "Lcom/bytedance/android/live/broadcastgame/api/openplatform/c;", "getOpenGameClient", "getCurrentSonicGameAppId", "getGameCategory", "getCurrentGameName", "Lcom/bytedance/android/live/broadcastgame/api/xplay/e;", "getXplayGlobalService", "Landroid/view/ViewGroup;", "view", "setAnchorInteractPlayContainer", "isInteractPlayRunning", com.alipay.sdk.m.p.e.f25671s, "Lcom/google/gson/JsonObject;", "param", "Lkotlin/Function1;", "callback", "handleAnchorPanelJSBInvoke", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/a0;", "createToolbarComponentConfig", "gameGuideHelper", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/d;", "", "Lcom/bytedance/android/live/browser/jsbridge/f;", "jsEventSender$delegate", "Lkotlin/Lazy;", "getJsEventSender", "()Ljava/util/List;", "jsEventSender", "isAudienceMiniAppReady", "Z", "audienceMiniAppSchema", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "entanceVisibilityMap", "Ljava/util/HashMap;", "cacheMessage", "Lcom/bytedance/android/live/broadcastgame/api/e;", "<set-?>", "gameAnchorService", "Lcom/bytedance/android/live/broadcastgame/api/e;", "getGameAnchorService", "()Lcom/bytedance/android/live/broadcastgame/api/e;", "setGameAnchorService", "(Lcom/bytedance/android/live/broadcastgame/api/e;)V", "Lcom/bytedance/android/live/broadcastgame/api/f;", "gameAudienceService", "Lcom/bytedance/android/live/broadcastgame/api/f;", "getGameAudienceService", "()Lcom/bytedance/android/live/broadcastgame/api/f;", "setGameAudienceService", "(Lcom/bytedance/android/live/broadcastgame/api/f;)V", "Lcom/bytedance/android/live/broadcastgame/f0;", "openPlatformService", "Lcom/bytedance/android/live/broadcastgame/f0;", "getOpenPlatformService", "()Lcom/bytedance/android/live/broadcastgame/f0;", "setOpenPlatformService", "(Lcom/bytedance/android/live/broadcastgame/f0;)V", "Ljava/lang/ref/WeakReference;", "Landroid/app/Dialog;", "exceptionDialog", "Ljava/lang/ref/WeakReference;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InteractGameService implements IInteractGameService {
    public static final a Companion = null;
    private static final i10.h diComponent = null;
    private static InteractGameService interactGameService;
    private String audienceMiniAppSchema;
    private HashMap<String, com.bytedance.android.live.base.model.message.t> cacheMessage;
    private HashMap<String, Integer> entanceVisibilityMap;
    private WeakReference<Dialog> exceptionDialog;
    private com.bytedance.android.live.broadcastgame.api.e gameAnchorService;
    private com.bytedance.android.live.broadcastgame.api.f gameAudienceService;
    private com.bytedance.android.live.broadcastgame.api.interactgame.d gameGuideHelper;
    private boolean isAudienceMiniAppReady;
    private boolean isGameCasting;
    private final Lazy jsEventSender$delegate;
    private f0 openPlatformService;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f59250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.model.u f59251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f59252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DataCenter f59253d;

        public b(Throwable r100, com.bytedance.android.live.broadcastgame.api.model.u r101, boolean r102, DataCenter r103) {
            this.f59250a = r100;
            this.f59251b = r101;
            this.f59252c = r102;
            this.f59253d = r103;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            ALogger.i("AAM.InteractGameService", "game exit by error: " + this.f59250a + ' ' + this.f59251b);
            if (this.f59252c == false) goto L5;
            this.f59253d.put("cmd_broadcast_game_finish", 1000);
            this.f59253d.put("cmd_interact_game_exception_exit", this.f59251b);
        L5:
            r100.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f59254a;

        public c(Function0 r100) {
            this.f59254a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            this.f59254a.invoke();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f59255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.model.u f59256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DataCenter f59257c;

        public d(Throwable r100, com.bytedance.android.live.broadcastgame.api.model.u r101, DataCenter r102) {
            this.f59255a = r100;
            this.f59256b = r101;
            this.f59257c = r102;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            ALogger.i("AAM.InteractGameService", "game exit by error: " + this.f59255a + ' ' + this.f59256b);
            this.f59257c.put("cmd_broadcast_game_finish", 1000);
            this.f59257c.put("cmd_interact_game_exception_exit", this.f59256b);
            r100.dismiss();
        }
    }

    public static final class e implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractGameService f59258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.interactgame.p f59259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f59260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DataCenter f59261d;

        @Override // com.bytedance.android.live.broadcastgame.w
        public final void onFail() {
            com.bytedance.android.live.broadcastgame.api.interactgame.p r100 = this.f59259b;
            if (r100 == null) goto L6;
            r100.onFail(new Throwable("load sonic plugin failed：game not found"));
            return;
        }

        @Override // com.bytedance.android.live.broadcastgame.w
        public final void a(com.bytedance.android.live.broadcastgame.api.model.u r100) {
            Intrinsics.checkNotNullParameter(r100, "gameItem");
            InteractGameService.access$realLaunchGame(this.f59258a, r100, this.f59259b, this.f59260c, this.f59261d);
        }

        public e(InteractGameService r100, com.bytedance.android.live.broadcastgame.api.interactgame.p r101, Context r102, DataCenter r103) {
            this.f59258a = r100;
            this.f59259b = r101;
            this.f59260c = r102;
            this.f59261d = r103;
        }
    }

    private final List<com.bytedance.android.live.browser.jsbridge.f> getJsEventSender() {
        return (List) this.jsEventSender$delegate.getValue();
    }

    static {
        Companion = new a();
        diComponent = new i10.f(new i10.b(), new i10.c(), new p10.a(), new i10.a());
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void audienceLaunchGame() {
        com.bytedance.android.live.broadcastgame.api.openplatform.f r100 = new com.bytedance.android.live.broadcastgame.api.openplatform.f("other");
        xs2.b.a().post(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void clearCache() {
        HashMap<String, com.bytedance.android.live.base.model.message.t> r100 = this.cacheMessage;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        HashMap<String, Integer> r101 = this.entanceVisibilityMap;
        if (r101 == null) goto L9;
        r101.clear();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b createOpenGameBehaivor() {
        f0 r100 = this.openPlatformService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.j();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Object createOpenToolbarEntBehavior() {
        f0 r100 = this.openPlatformService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public List<Class<?>> getAllOpenPlatformActivity() {
        f0 r100 = this.openPlatformService;
        if (r100 == null) goto L7;
        List<Class<?>> r101 = r100.getAllOpenPlatformActivity();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String getCurrentGameName() {
        return InteractGameContext.Companion.i();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.model.u getCurrentPlayingGame() {
        com.bytedance.android.live.broadcastgame.api.e r100 = this.gameAnchorService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentPlayingGame();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public int getCurrentPlayingGameId() {
        com.bytedance.android.live.broadcastgame.api.e r100 = this.gameAnchorService;
        if (r100 == null) goto L7;
        com.bytedance.android.live.broadcastgame.api.model.u r101 = r100.getCurrentPlayingGame();
        if (r101 == null) goto L7;
        return r101.interactId;
    L7:
        return 0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String getCurrentSonicGameAppId() {
        InteractGameContext r100 = InteractGameContext.Companion.getContext();
        if (r100 == null) goto L10;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.i0> r101 = r100.getCurrentOpenPlatformAppInfo();
        if (r101 == null) goto L10;
        com.bytedance.android.live.broadcastgame.api.model.i0 r102 = r101.getValue();
        if (r102 == null) goto L10;
        String r103 = r102.f59359b;
        if (r103 == null) goto L10;
        return r103;
    L10:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.interactgame.d getGameGuideHelper() {
        com.bytedance.android.live.broadcastgame.api.interactgame.d r100 = this.gameGuideHelper;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.f59302b == false) goto L8;
        return r100;
    L8:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.openplatform.c getOpenGameClient() {
        f0 r100 = this.openPlatformService;
        if (r100 == null) goto L5;
        r100.getOpenGameClient();
        return com.bytedance.android.live.broadcastgame.opengame.network.x.f60300a;
    L5:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Map<String, String> getOpenPlatformGameCommonLogMap() {
        IOpenPlatformMgAnchorService r100 = (IOpenPlatformMgAnchorService) jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMiniGameLotteryCommonLogMap();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public com.bytedance.android.live.broadcastgame.api.xplay.e getXplayGlobalService() {
        f0 r100 = this.openPlatformService;
        if (r100 == null) goto L5;
        r100.getXplayGlobalService();
        return XplayGlobalServiceImpl.f61917c;
    L5:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public boolean isInteractPlayRunning() {
        return InteractGameContext.Companion.g();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Boolean isOpenPlatformGameOpeningLynxPanelInGame() {
        IOpenPlatformMgAnchorService r100 = (IOpenPlatformMgAnchorService) jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.isOpeningLynxPanelInGame());
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public boolean isPlayingGame() {
        com.bytedance.android.live.broadcastgame.api.e r100 = this.gameAnchorService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isPlayingGame();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void stopGameCastToAudience() {
        com.bytedance.android.live.broadcastgame.api.e r100 = this.gameAnchorService;
        if (r100 == null) goto L6;
        r100.stopGameCastToAudience();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void stopRunningPlugin() {
        stopRunningPlugin("");
        com.bytedance.android.live.broadcastgame.api.xplay.n.f59498b.e("");
    }

    public InteractGameService() {
        this.jsEventSender$delegate = LazyKt.lazy(InteractGameService$jsEventSender$2.INSTANCE);
        i10.f r100 = (i10.f) diComponent;
        setGameAnchorService(r100.f487926b.get());
        setGameAudienceService(r100.f487927c.get());
        setOpenPlatformService(r100.f487928d.get());
        jc1.k.l(IInteractGameService.class, this);
        jc1.k.l(IMiddlewareInteractGameService.class, this);
        LinkedHashMap r101 = new LinkedHashMap();
        wb.a.call("modelx");
        ((INetworkService) jc1.k.n(INetworkService.class)).injectProtoDecoders(r101);
        this.entanceVisibilityMap = new HashMap();
        this.cacheMessage = new HashMap();
    }

    public static final /* synthetic */ i10.h access$getDiComponent$cp() {
        return diComponent;
    }

    public static final /* synthetic */ InteractGameService access$getInteractGameService$cp() {
        return interactGameService;
    }

    public final com.bytedance.android.live.broadcastgame.api.e getGameAnchorService() {
        return this.gameAnchorService;
    }

    public final com.bytedance.android.live.broadcastgame.api.f getGameAudienceService() {
        return this.gameAudienceService;
    }

    public final f0 getOpenPlatformService() {
        return this.openPlatformService;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public boolean isGameCasting() {
        return this.isGameCasting;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_broadcastgame_InteractGameService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(x0 r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static final /* synthetic */ void access$setInteractGameService$cp(InteractGameService r100) {
        interactGameService = r100;
    }

    private final void runAnchorEnterRoomTask(long r100) {
        InteractGameLocalStatusUtils.b(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void addItemToDataCacheHelper(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        f0 r101 = this.openPlatformService;
        if (r101 == null) goto L6;
        r101.addItemToDataCacheHelper(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void anchorLaunchGame(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        a2 r101 = new a2(null, r100, null, 5);
        xs2.b.a().post(r101);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void closeOpenPlatformGame(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        f0 r101 = this.openPlatformService;
        if (r101 == null) goto L6;
        r101.closeOpenPlatformGame(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String decryptUserInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cipherText");
        f0 r101 = this.openPlatformService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.decryptUserInfo(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void deleteData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        f0 r101 = this.openPlatformService;
        if (r101 == null) goto L6;
        r101.deleteData(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public IAudienceGameWidget getAudienceGameWidget(boolean r100) {
        com.bytedance.android.live.broadcastgame.api.f r101 = this.gameAudienceService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getAudienceGameWidget(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public int getEntranceVisibility(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        if (Intrinsics.areEqual(r100, "") == false) goto L5;
        return -1;
    L5:
        HashMap<String, Integer> r101 = this.entanceVisibilityMap;
        if (r101 == null) goto L11;
        Integer r102 = r101.remove(r100);
        if (r102 != null) goto L10;
        return -1;
    L10:
        return r102.intValue();
    L11:
        return -1;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public String getGameCategory(boolean r100) {
        if (r100 == false) goto L9;
        com.bytedance.android.live.broadcastgame.api.e r101 = this.gameAnchorService;
        if (r101 == null) goto L16;
        String r102 = r101.getGameCategory();
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L16:
        return "";
    L9:
        com.bytedance.android.live.broadcastgame.api.f r103 = this.gameAudienceService;
        if (r103 == null) goto L17;
        r102 = r103.getGameCategory();
        if (r102 != null) goto L15;
        return "";
    L17:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public e10.b<com.bytedance.android.live.broadcastgame.api.model.u, e10.a.C5727a> getLiveOpenFeatureSceneFilter(DataCenter r100) {
        com.bytedance.android.live.broadcastgame.api.e r101 = this.gameAnchorService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getLiveOpenFeatureSceneFilter(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void hidePlugin(boolean r100) {
        if (r100 == false) goto L6;
        com.bytedance.android.live.broadcastgame.api.e r101 = this.gameAnchorService;
        if (r101 == null) goto L10;
        r101.a();
        return;
    L10:
        return;
    L6:
        com.bytedance.android.live.broadcastgame.api.f r102 = this.gameAudienceService;
        if (r102 == null) goto L12;
        r102.a();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public boolean isPlayingGame(InteractID r100) {
        Intrinsics.checkNotNullParameter(r100, "gameType");
        com.bytedance.android.live.broadcastgame.api.e r101 = this.gameAnchorService;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isPlayingGame(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void notifyStopLinkCastResult(boolean r100) {
        com.bytedance.android.live.broadcastgame.api.e r101 = this.gameAnchorService;
        if (r101 == null) goto L6;
        r101.notifyStopLinkCastResult(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void onSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "seiMsg");
        com.bytedance.android.live.broadcastgame.api.f r101 = this.gameAudienceService;
        if (r101 == null) goto L6;
        r101.onSei(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void preloadOpenPlatformGame(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        f0 r101 = this.openPlatformService;
        if (r101 == null) goto L6;
        r101.preloadOpenPlatformGame(r100);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setAnchorInteractPlayContainer(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        XplayExternalContext r101 = XplayExternalContext.Companion.getContext();
        if (r101 == null) goto L8;
        com.bytedance.live.datacontext.n<ViewGroup> r102 = r101.getInteractPlayContainer();
        if (r102 == null) goto L9;
        r102.setValue(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setAudienceMiniAppReady(boolean r100) {
        this.isAudienceMiniAppReady = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setAudienceMiniAppSchema(String r100) {
        this.audienceMiniAppSchema = r100;
    }

    @Inject
    public final void setGameAnchorService(com.bytedance.android.live.broadcastgame.api.e r100) {
        this.gameAnchorService = r100;
    }

    @Inject
    public final void setGameAudienceService(com.bytedance.android.live.broadcastgame.api.f r100) {
        this.gameAudienceService = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setGameCasting(boolean r100) {
        this.isGameCasting = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void setGameGuideHelper(String r100) {
        Intrinsics.checkNotNullParameter(r100, "guideParams");
        this.gameGuideHelper = new com.bytedance.android.live.broadcastgame.api.interactgame.d(r100);
    }

    @Inject
    public final void setOpenPlatformService(f0 r100) {
        this.openPlatformService = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void showPlugin(boolean r100) {
        if (r100 == false) goto L6;
        com.bytedance.android.live.broadcastgame.api.e r101 = this.gameAnchorService;
        if (r101 == null) goto L10;
        r101.b();
        return;
    L10:
        return;
    L6:
        com.bytedance.android.live.broadcastgame.api.f r102 = this.gameAudienceService;
        if (r102 == null) goto L12;
        r102.b();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void stopRunningPlugin(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.bytedance.android.live.broadcastgame.api.e r101 = this.gameAnchorService;
        if (r101 == null) goto L5;
        r101.stopRunningPlugin(r100);
    L5:
        com.bytedance.android.live.broadcastgame.api.f r102 = this.gameAudienceService;
        if (r102 == null) goto L8;
        r102.stopRunningPlugin(r100);
    L8:
        com.bytedance.android.live.broadcastgame.api.xplay.n.f59498b.e(r100);
        IOpenPlatformMgAnchorService r103 = (IOpenPlatformMgAnchorService) jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r103 == null) goto L12;
        r103.unmount();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void cacheEntranceVisibility(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        if (Intrinsics.areEqual(r100, "") == false) goto L5;
        return;
    L5:
        HashMap<String, Integer> r102 = this.entanceVisibilityMap;
        if (r102 == null) goto L9;
        r102.put(r100, Integer.valueOf(r101));
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void cacheOpenPlatformMessage(String r100, com.bytedance.android.live.base.model.message.t r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "message");
        if (Intrinsics.areEqual(r100, "") == false) goto L5;
        return;
    L5:
        HashMap<String, com.bytedance.android.live.base.model.message.t> r102 = this.cacheMessage;
        if (r102 == null) goto L9;
        r102.put(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void consumeCacheOpenPlatformMessage(String r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        if (Intrinsics.areEqual(r100, "") == false) goto L5;
        return;
    L5:
        HashMap<String, com.bytedance.android.live.base.model.message.t> r102 = this.cacheMessage;
        if (r102 == null) goto L21;
        com.bytedance.android.live.base.model.message.t r103 = r102.remove(r100);
        if (r103 == null) goto L24;
        HashMap<String, Integer> r104 = this.entanceVisibilityMap;
        if (r104 == null) goto L13;
        Integer r105 = r104.remove(r100);
    L14:
        if (r105 != null) goto L17;
        return;
    L17:
        if (r105.intValue() != 1) goto L22;
        if (r101 == null) goto L23;
        r101.put("data_push_to_public_screen_open_platfrom_message", r103);
        return;
    L23:
        return;
    L22:
        return;
    L13:
        r105 = null;
        goto L14
    L24:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 createToolbarComponentConfig(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new com.bytedance.android.live.broadcastgame.opengame.behavior.g(r100, r101);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void executeEnterRoomTask(boolean r100, Room r101) {
        if (r100 == false) goto L14;
        if (r101 == null) goto L15;
        Long r102 = Long.valueOf(r101.f162599id);
        if (r102.longValue() == 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L16;
        runAnchorEnterRoomTask(r102.longValue());
        return;
    L16:
        return;
    L7:
        r103 = false;
        goto L8
    L15:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public com.bytedance.android.live.broadcastgame.api.model.h fetchGameIconInfo(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        if (r101 == false) goto L16;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r102 = AnchorGameContext.a.a();
        if (r102 == null) goto L9;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.i0> r103 = r102.getCurrentOpenPlatformAppInfo();
        if (r103 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.model.i0 r104 = r103.getValue();
    L10:
        if (r104 != null) goto L12;
        return null;
    L12:
        if ((!Intrinsics.areEqual(r104.f59359b, r100)) == false) goto L15;
        return null;
    L15:
        return new com.bytedance.android.live.broadcastgame.api.model.h(r100, r104.f59360c, r104.f59358a);
    L9:
        r104 = null;
        goto L10
    L16:
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r105 = AudienceGameContext.a.a();
        if (r105 == null) goto L21;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.h> r106 = r105.getAnchorCurrentGameIconInfo();
        if (r106 == null) goto L21;
        com.bytedance.android.live.broadcastgame.api.model.h r107 = r106.getValue();
    L22:
        if (r107 != null) goto L24;
    L27:
        return null;
    L24:
        if ((!Intrinsics.areEqual(r107.f59344a, r100)) == true) goto L27;
        return r107;
    L21:
        r107 = null;
        goto L22
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.live.broadcastgame.api.interactgame.h getGameExitConformDialog(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        com.bytedance.android.live.broadcastgame.api.e r102 = this.gameAnchorService;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getGameExitConformDialog(r100, r101);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b getOpenPlatformItemBehavior(com.bytedance.android.live.broadcastgame.api.model.u r100, mh1.p r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        f0 r102 = this.openPlatformService;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.a(r100, r101);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void initGameContext(Fragment r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        com.bytedance.live.datacontext.d.c((XplayExternalContext) com.bytedance.live.datacontext.d.b(r100, null).a(XplayExternalContext.class), XplayExternalContext.CONTEXT_KEY);
        if (r101 == false) goto L5;
        com.bytedance.live.datacontext.d.c((AnchorGameContext) com.bytedance.live.datacontext.d.b(r100, null).a(AnchorGameContext.class), InteractGameContext.CONTEXT_KEY);
        return;
    L5:
        com.bytedance.live.datacontext.d.c((AudienceGameContext) com.bytedance.live.datacontext.d.b(r100, null).a(AudienceGameContext.class), InteractGameContext.CONTEXT_KEY);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void openOpenPlatformGame(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "startParmaMap");
        f0 r102 = this.openPlatformService;
        if (r102 == null) goto L6;
        r102.openOpenPlatformGame(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void sendGameCastStatusSEI(boolean r100, JSONObject r101) {
        com.bytedance.android.live.broadcastgame.api.e r102 = this.gameAnchorService;
        if (r102 == null) goto L6;
        r102.sendGameCastStatusSEI(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void sendGameSeiData(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.live.broadcastgame.api.e r102 = this.gameAnchorService;
        if (r102 == null) goto L6;
        r102.sendGameSeiData(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void sendServerMergeCastStatusSEI(boolean r100, JSONObject r101) {
        com.bytedance.android.live.broadcastgame.api.e r102 = this.gameAnchorService;
        if (r102 == null) goto L6;
        r102.sendServerMergeCastStatusSEI(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public JsFuncInjector createOpenJsFuncInject(IJsBridgeManager r100, DataCenter r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new com.bytedance.android.live.broadcastgame.channel.d(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void handleAnchorPanelJSBInvoke(String r100, JsonObject r101, Function1<? super JsonObject, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "param");
        f0 r103 = this.openPlatformService;
        if (r103 == null) goto L6;
        r103.getXplayGlobalService();
        XplayGlobalServiceImpl.f61917c.p(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService, com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService
    public void notifyStartLinkCastResult(boolean r100, Surface r101, int r102) {
        com.bytedance.android.live.broadcastgame.api.e r103 = this.gameAnchorService;
        if (r103 == null) goto L6;
        r103.notifyStartLinkCastResult(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public boolean openMiniApp(Context r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "location");
        Intrinsics.checkNotNullParameter(r102, "liveParams");
        if (this.isAudienceMiniAppReady == true) goto L6;
        return false;
    L6:
        ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).openMountedMiniApp(r101);
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Single<Boolean> showOpenGameAuthDialog(Context r100, DataCenter r101, com.bytedance.android.live.broadcastgame.api.model.u r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "gameItem");
        f0 r103 = this.openPlatformService;
        if (r103 == null) goto L7;
        Single<Boolean> r104 = r103.showOpenGameAuthDialog(r100, r101, r102);
        if (r104 == null) goto L7;
        return r104;
    L7:
        return Single.just(Boolean.FALSE);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void startOpenPlatformSonicPlugin(Context r100, String r101, com.bytedance.android.live.broadcastgame.api.interactgame.p r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "appId");
        if (InteractGameContext.Companion.h(r101) == false) goto L7;
        if (r102 == null) goto L23;
        r102.onSuccess();
        return;
    L23:
        return;
    L7:
        DataCenter r103 = null;
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r104 == null) goto L12;
        com.bytedance.live.datacontext.n<DataCenter> r105 = r104.getDataCenter();
        if (r105 == null) goto L12;
        r103 = r105.getValue();
    L12:
        if (r103 != null) goto L16;
        if (r102 == null) goto L24;
        r102.onFail(new Throwable("load sonic plugin failed：dataCenter is null"));
        return;
    L24:
        return;
    L16:
        com.bytedance.android.live.broadcastgame.api.model.u r106 = com.bytedance.android.live.broadcastgame.api.interactgame.j.d(r101, r103);
        if (r106 == null) goto L19;
        realLaunchGame(r106, r102, r100, r103);
        return;
    L19:
        f0 r107 = this.openPlatformService;
        if (r107 == null) goto L26;
        r107.f(r100, r101, new e(this, r102, r100, r103));
        return;
    }

    private final void realLaunchGame(final com.bytedance.android.live.broadcastgame.api.model.u r100, final com.bytedance.android.live.broadcastgame.api.interactgame.p r101, Context r110, final DataCenter r111) {
        r100.getClass();
        Intrinsics.checkNotNullParameter("invite", "<set-?>");
        r100.f59377i = "invite";
        ((IInteractGameService) jc1.k.n(IInteractGameService.class)).tryGetSwitchGameConfirmDialog(r100, r110, r111, new AnonymousClass1(r100, r101, r111), new AnonymousClass2(r101));
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public IAnchorGameWidget getAnchorGameWidget(com.bytedance.android.live.pushstream.d r100, Room r101, Fragment r102, FragmentManager r103) {
        Intrinsics.checkNotNullParameter(r101, "room");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, "fragmentManager");
        com.bytedance.android.live.broadcastgame.api.e r104 = this.gameAnchorService;
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.getAnchorGameWidget(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b getOpenPlatformBehavior(Context r100, DataCenter r101, Function2<? super InteractEntranceCell, ? super com.bytedance.android.live.broadcastgame.api.model.z, ? extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b> r102, com.bytedance.android.live.broadcastgame.api.interactgame.g r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "behaviorFactory");
        Intrinsics.checkNotNullParameter(r103, "createFactory");
        f0 r104 = this.openPlatformService;
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.b(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.live.broadcastgame.api.model.e0>> notifyServerGameStart(long r110, long r111, String r112, long r113) {
        ALogger.d(IInteractGameService.TAG, "game/status/start: gameId " + r110 + ", roomId: " + r111 + ", gameToken: " + r113);
        int r100 = g0.f59628a;
        Intrinsics.checkNotNullParameter(BroadcastGameApi.class, "cls");
        BroadcastGameApi r101 = (BroadcastGameApi) com.bytedance.android.live.network.c.b().e(BroadcastGameApi.class);
        if (r112 != null) goto L5;
        String r102 = "";
    L7:
        return r101.notifyServerGameStart(r110, r111, r102, r113);
    L5:
        r102 = r112;
        goto L7
    }

    public static final /* synthetic */ void access$realLaunchGame(InteractGameService r100, com.bytedance.android.live.broadcastgame.api.model.u r101, com.bytedance.android.live.broadcastgame.api.interactgame.p r102, Context r103, DataCenter r104) {
        r100.realLaunchGame(r101, r102, r103, r104);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void confirmGameException(Context r100, DataCenter r101, com.bytedance.android.live.broadcastgame.api.model.u r102, boolean r103, Throwable r104) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "gameItem");
        Intrinsics.checkNotNullParameter(r104, "e");
        if ((r104 instanceof ApiException) == false) goto L5;
        int r105 = ((ApiException) r104).getErrorCode();
    L7:
        if (r105 == 4014029) goto L9;
        return;
    L9:
        WeakReference<Dialog> r106 = this.exceptionDialog;
        if (r106 == null) goto L16;
        Dialog r107 = r106.get();
        if (r107 == null) goto L16;
        if (r107.isShowing() != true) goto L16;
        return;
    L16:
        x0.d r108 = new x0.d();
        r108.f162243b = r100;
        r108.f162242a = 0;
        r108.f162242a = 0;
        r108.f162245d = r108.f162243b.getText(R.string.ttlive_wgame_launcher_error);
        r108.f162244c = r108.f162243b.getText(R.string.ttlive_wgame_limit_game_title);
        b r109 = new b(r104, r102, r103, r101);
        CharSequence r110 = r108.f162243b.getText(R.string.ttlive_wgame_launcher_error_close_tips);
        x0.c[] r111 = r108.f162248g;
        x0.c r112 = r111[0];
        if (r112 != null) goto L19;
        r112 = new x0.c();
        r111[0] = r112;
    L19:
        r112.f162239a = r110;
        r112.f162240b = r109;
        r108.f162253l = false;
        x0 r113 = new x0(r108.f162243b, r108);
        this.exceptionDialog = new WeakReference(r113);
        INVOKEVIRTUAL_com_bytedance_android_live_broadcastgame_InteractGameService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r113);
        return;
    L5:
        r105 = -1;
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void tryGetSwitchGameConfirmDialog(com.bytedance.android.live.broadcastgame.api.model.u r100, Context r101, DataCenter r110, Function0<Unit> r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "gameItem");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        Intrinsics.checkNotNullParameter(r111, "onSuccess");
        Intrinsics.checkNotNullParameter(r112, "onFail");
        com.bytedance.android.live.broadcastgame.api.e r102 = this.gameAnchorService;
        if (r102 == null) goto L6;
        r102.tryGetSwitchGameConfirmDialog(r100, r101, r110, r111, r112);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public void confirmGameStartFailed(Context r100, DataCenter r101, com.bytedance.android.live.broadcastgame.api.model.u r102, int r103, Throwable r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "gameItem");
        Intrinsics.checkNotNullParameter(r104, "e");
        if (r103 != 4014029) goto L5;
        int r106 = R.string.ttlive_wgame_limit_game_error;
    L6:
        if (r103 != 4014029) goto L8;
        int r107 = R.string.ttlive_wgame_launcher_error_close_confirm;
    L9:
        x0.b r108 = new x0.b(r100, 0);
        r108.f162238a.f162242a = 0;
        r108.l(r106);
        r108.m(R.string.ttlive_wgame_limit_game_title);
        r108.i(1, r107, new d(r104, r102, r101));
        r108.f162238a.f162253l = false;
        if (r105 == null) goto L12;
        r108.i(0, R.string.ttlive_wgame_launcher_error_retry, new c(r105));
    L12:
        r108.n();
        return;
    L8:
        r107 = R.string.ttlive_wgame_launcher_error_close_tips;
        goto L9
    L5:
        r106 = R.string.ttlive_wgame_launcher_error;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService
    public Observable<com.bytedance.android.live.network.response.e<Object>> notifyServerGameStop(long r110, long r111, long r112, String r210, boolean r211, int r212, long r213) {
        ALogger.d(IInteractGameService.TAG, "game/status/stop: gameId " + r110 + ", roomId: " + r111 + ", gameToken: " + r213 + ", stopReason: " + r212);
        int r100 = g0.f59628a;
        Intrinsics.checkNotNullParameter(BroadcastGameApi.class, "cls");
        BroadcastGameApi r101 = (BroadcastGameApi) com.bytedance.android.live.network.c.b().e(BroadcastGameApi.class);
        if (r210 != null) goto L5;
        String r102 = "";
    L7:
        return r101.notifyServerGameStop(r110, r111, r112, r102, r211, r212, r213);
    L5:
        r102 = r210;
        goto L7
    }
}
