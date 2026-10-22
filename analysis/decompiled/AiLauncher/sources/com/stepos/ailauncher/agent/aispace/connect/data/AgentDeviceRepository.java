package com.stepos.ailauncher.agent.aispace.connect.data;

import La.D;
import La.H;
import La.K;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.common.utils.I;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.network.RetrofitProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.Result;
import kotlinx.coroutines.channels.BufferOverflow;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0081\u0001\u0082\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\u00020\u0014*\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u0014*\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010#\u001a\u00020\u00042\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\u001cJ.\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b.\u0010/J.\u00103\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b3\u0010/J\u001c\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0,H\u0086@¢\u0006\u0004\b4\u00105J\u001c\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\b0,H\u0086@¢\u0006\u0004\b6\u00105J\u0010\u00107\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b7\u00105J.\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0,2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b9\u0010/J6\u0010=\u001a\b\u0012\u0004\u0012\u00020<0,2\u0006\u0010:\u001a\u00020\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0004\b=\u0010/J.\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000e0,2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b?\u0010@J \u0010B\u001a\b\u0012\u0004\u0012\u00020A0,2\b\b\u0002\u0010*\u001a\u00020\u0006H\u0086@¢\u0006\u0004\bB\u0010\u000bJR\u0010H\u001a\b\u0012\u0004\u0012\u00020G0,2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0004\bH\u0010IJ&\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000e0,2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0086@¢\u0006\u0004\bJ\u0010KJ\u001e\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000e0,2\u0006\u0010*\u001a\u00020\u0006H\u0086@¢\u0006\u0004\bL\u0010\u000bJ\u0011\u0010N\u001a\u00020M*\u00020\t¢\u0006\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010QR&\u0010[\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060Z0Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\t0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010WR\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00040a8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR$\u0010g\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bg\u0010Q\u001a\u0004\bh\u0010\u0012R$\u0010i\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bi\u0010Q\u001a\u0004\bj\u0010\u0012R(\u0010k\u001a\u0004\u0018\u00010\u00062\b\u0010f\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bk\u0010Q\u001a\u0004\bl\u0010\u0012R\u001b\u0010r\u001a\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR$\u0010s\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bs\u0010Q\u001a\u0004\bt\u0010\u0012R(\u0010u\u001a\u0004\u0018\u00010\u00062\b\u0010f\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bu\u0010Q\u001a\u0004\bv\u0010\u0012R$\u0010w\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bw\u0010Q\u001a\u0004\bx\u0010\u0012R$\u0010y\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\by\u0010Q\u001a\u0004\bz\u0010\u0012R(\u0010{\u001a\u0004\u0018\u00010\u00062\b\u0010f\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b{\u0010Q\u001a\u0004\b|\u0010\u0012R,\u0010~\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060Z\u0012\u0004\u0012\u00020\u00060}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0016\u0010\u0080\u0001\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010T¨\u0006\u0083\u0001"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/AgentDeviceRepository;", "", "<init>", "()V", "LY8/t;", "M", "", "requestAccountId", "", "Lcom/stepos/ailauncher/agent/aispace/connect/data/p;", "O", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "accountId", "P", "", "C", "(Ljava/lang/String;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/w;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "R", "(Lcom/stepos/ailauncher/agent/aispace/connect/data/w;)Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/v;", "Q", "(Lcom/stepos/ailauncher/agent/aispace/connect/data/v;)Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", M5.b.CREDENTIAL_TOKEN, "k", "(Ljava/lang/String;)Ljava/lang/String;", "Ltb/u;", "headers", "s", "(Ltb/u;)Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/l;", "envelope", "N", "(Lcom/stepos/ailauncher/agent/aispace/connect/data/l;)V", "item", "U", "(Lcom/stepos/ailauncher/agent/aispace/connect/data/p;)V", ExifInterface.GPS_DIRECTION_TRUE, "pairId", "deviceId", "agent", "Lkotlin/Result;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/q;", "q", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "stepaiDeviceId", "stepaiDeviceName", "stepaiUserId", "l", "D", "(Le9/c;)Ljava/lang/Object;", "H", "I", "displayName", "L", "fileId", "sessionId", "Lcom/stepos/ailauncher/agent/aispace/connect/data/u;", "w", x5.d.EXTRA_ENABLED, "n", "(Ljava/lang/String;Ljava/lang/String;ZLe9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/connect/data/j;", "t", "", "limit", "cursor", "keyword", "Lcom/stepos/ailauncher/agent/aispace/connect/data/B;", "F", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "J", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "K", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/ailauncher/agent/aispace/connect/data/p;)Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "TAG", "Ljava/lang/String;", "Leb/a;", "cacheMutex", "Leb/a;", "", "cache", "Ljava/util/List;", "cacheAccountId", "", "Lkotlin/Pair;", "recentlyDisabled", "Ljava/util/Set;", "recentlyConfirmed", "LXa/j;", "_devicesUpdates", "LXa/j;", "LXa/o;", "devicesUpdates", "LXa/o;", "v", "()LXa/o;", UxipConstants.f30680s, "lastConfirmHeaders", "z", "lastListHeaders", "B", "lastListError", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/stepos/ailauncher/agent/aispace/connect/data/a;", "api$delegate", "LY8/h;", "u", "()Lcom/stepos/ailauncher/agent/aispace/connect/data/a;", "api", "lastBindStepaiHeaders", "y", "lastSidebarListError", "getLastSidebarListError", "lastListSessionsHeaders", "getLastListSessionsHeaders", "lastListSessionsBody", "getLastListSessionsBody", "lastListSessionsError", "getLastListSessionsError", "", "sessionCache", "Ljava/util/Map;", "sessionCacheMutex", "ConfirmDeviceHttpError", "ConfirmDeviceBizError", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentDeviceRepository {
    private static final String TAG = "AgentDeviceRepo";
    private static final Xa.j<Y8.t> _devicesUpdates;

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final Y8.h api;
    private static String cacheAccountId;
    private static final Xa.o<Y8.t> devicesUpdates;
    private static volatile String lastBindStepaiHeaders;
    private static volatile String lastConfirmHeaders;
    private static volatile String lastListError;
    private static volatile String lastListHeaders;
    private static volatile String lastListSessionsBody;
    private static volatile String lastListSessionsError;
    private static volatile String lastListSessionsHeaders;
    private static volatile String lastSidebarListError;
    private static final Map<Pair<String, String>, String> sessionCache;
    private static final InterfaceC4021a sessionCacheMutex;
    public static final AgentDeviceRepository INSTANCE = new AgentDeviceRepository();
    private static final InterfaceC4021a cacheMutex = eb.f.b(false, 1, null);
    private static final List<DeviceAgentItem> cache = new ArrayList();
    private static final Set<Pair<String, String>> recentlyDisabled = new LinkedHashSet();
    private static final List<DeviceAgentItem> recentlyConfirmed = new ArrayList();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/AgentDeviceRepository$ConfirmDeviceBizError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "bizCode", "", "bizMsg", DidiCardProvider.KEY_TRACE_ID, "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "I", Const.INTENT_KEY_APIKEY, "()I", "Ljava/lang/String;", "getBizMsg", "()Ljava/lang/String;", "getTraceId", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ConfirmDeviceBizError extends RuntimeException {
        private final int bizCode;
        private final String bizMsg;
        private final String traceId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfirmDeviceBizError(int i10, String str, String traceId) {
            super("biz error: code=" + i10 + " msg=" + str + " (traceId=" + traceId + ")");
            kotlin.jvm.internal.p.i(traceId, "traceId");
            this.bizCode = i10;
            this.bizMsg = str;
            this.traceId = traceId;
        }

        /* renamed from: a, reason: from getter */
        public final int getBizCode() {
            return this.bizCode;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/AgentDeviceRepository$ConfirmDeviceHttpError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "httpStatus", "", "errorBody", DidiCardProvider.KEY_TRACE_ID, "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "I", Const.INTENT_KEY_PKGNAME, "()I", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "c", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ConfirmDeviceHttpError extends RuntimeException {
        private final String errorBody;
        private final int httpStatus;
        private final String traceId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfirmDeviceHttpError(int i10, String errorBody, String traceId) {
            super("HTTP " + i10 + " traceId=" + traceId + ": " + errorBody);
            kotlin.jvm.internal.p.i(errorBody, "errorBody");
            kotlin.jvm.internal.p.i(traceId, "traceId");
            this.httpStatus = i10;
            this.errorBody = errorBody;
            this.traceId = traceId;
        }

        /* renamed from: a, reason: from getter */
        public final String getErrorBody() {
            return this.errorBody;
        }

        /* renamed from: b, reason: from getter */
        public final int getHttpStatus() {
            return this.httpStatus;
        }

        /* renamed from: c, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }
    }

    static {
        Xa.j<Y8.t> jVarA = Xa.p.a(0, 16, BufferOverflow.DROP_OLDEST);
        _devicesUpdates = jVarA;
        devicesUpdates = Xa.d.b(jVarA);
        lastConfirmHeaders = "";
        lastListHeaders = "";
        api = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.data.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentDeviceRepository.j();
            }
        });
        lastBindStepaiHeaders = "";
        lastListSessionsHeaders = "";
        lastListSessionsBody = "";
        sessionCache = new LinkedHashMap();
        sessionCacheMutex = eb.f.b(false, 1, null);
    }

    public static final boolean E(Set set, Pair it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !set.contains(it);
    }

    public static /* synthetic */ Object G(AgentDeviceRepository agentDeviceRepository, String str, String str2, Integer num, String str3, String str4, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            str4 = null;
        }
        return agentDeviceRepository.F(str, str2, num, str3, str4, interfaceC4014c);
    }

    public static final InterfaceC2198a j() {
        return (InterfaceC2198a) RetrofitProvider.newRetrofit$default(H5.a.INSTANCE.a(C3197a.INSTANCE.a()).p(), null, false, false, false, 30, null).c(InterfaceC2198a.class);
    }

    public static final boolean m(DeviceAgentItem deviceAgentItem, DeviceAgentItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getDeviceId(), deviceAgentItem.getDeviceId()) && kotlin.jvm.internal.p.d(it.getAgent(), deviceAgentItem.getAgent());
    }

    public static final boolean o(String str, String str2, DeviceAgentItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getDeviceId(), str) && kotlin.jvm.internal.p.d(it.getAgent(), str2);
    }

    public static final boolean p(String str, String str2, DeviceAgentItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getDeviceId(), str) && kotlin.jvm.internal.p.d(it.getAgent(), str2);
    }

    public static final boolean r(DeviceAgentItem deviceAgentItem, DeviceAgentItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getDeviceId(), deviceAgentItem.getDeviceId()) && kotlin.jvm.internal.p.d(it.getAgent(), deviceAgentItem.getAgent());
    }

    public static /* synthetic */ Object x(AgentDeviceRepository agentDeviceRepository, String str, String str2, String str3, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        return agentDeviceRepository.w(str, str2, str3, interfaceC4014c);
    }

    public final String A() {
        return lastListError;
    }

    public final String B() {
        return lastListHeaders;
    }

    public final boolean C(String accountId) {
        return kotlin.jvm.internal.p.d(i(), accountId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x05c1, code lost:
    
        if (r1 != r3) goto L173;
     */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0510 A[Catch: all -> 0x05cc, TryCatch #4 {all -> 0x05cc, blocks: (B:13:0x0061, B:154:0x050b, B:156:0x0510, B:174:0x05c7, B:157:0x0516, B:159:0x0556, B:160:0x055c, B:161:0x055f, B:16:0x007f, B:98:0x034f, B:19:0x009c, B:92:0x02c7, B:22:0x00b9, B:86:0x026e, B:25:0x00ce, B:173:0x05c4, B:57:0x017c, B:59:0x0182, B:60:0x0188, B:64:0x01aa, B:76:0x01eb, B:79:0x01f2, B:83:0x01f8, B:87:0x0273, B:89:0x027b, B:93:0x02cc, B:95:0x02d2, B:99:0x0354, B:101:0x0360, B:104:0x0368, B:105:0x036c, B:106:0x0377, B:108:0x037d, B:110:0x038e, B:112:0x0398, B:113:0x039c, B:75:0x01e1, B:166:0x0569, B:170:0x0584, B:33:0x00fd, B:48:0x0147, B:50:0x014f, B:36:0x010d, B:44:0x012e, B:45:0x0134, B:39:0x0114, B:67:0x01cc, B:69:0x01d4, B:73:0x01dc, B:117:0x03de, B:119:0x03e6, B:122:0x03ee, B:123:0x0400, B:125:0x0406, B:128:0x0420, B:129:0x043c, B:131:0x0442, B:133:0x045d, B:134:0x0461, B:135:0x0481, B:137:0x0487, B:138:0x049d, B:139:0x04ae, B:141:0x04b4, B:143:0x04cd, B:146:0x04d6, B:147:0x04da, B:148:0x04f0, B:150:0x04f6, B:151:0x0504), top: B:190:0x002e, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0516 A[Catch: all -> 0x05cc, TryCatch #4 {all -> 0x05cc, blocks: (B:13:0x0061, B:154:0x050b, B:156:0x0510, B:174:0x05c7, B:157:0x0516, B:159:0x0556, B:160:0x055c, B:161:0x055f, B:16:0x007f, B:98:0x034f, B:19:0x009c, B:92:0x02c7, B:22:0x00b9, B:86:0x026e, B:25:0x00ce, B:173:0x05c4, B:57:0x017c, B:59:0x0182, B:60:0x0188, B:64:0x01aa, B:76:0x01eb, B:79:0x01f2, B:83:0x01f8, B:87:0x0273, B:89:0x027b, B:93:0x02cc, B:95:0x02d2, B:99:0x0354, B:101:0x0360, B:104:0x0368, B:105:0x036c, B:106:0x0377, B:108:0x037d, B:110:0x038e, B:112:0x0398, B:113:0x039c, B:75:0x01e1, B:166:0x0569, B:170:0x0584, B:33:0x00fd, B:48:0x0147, B:50:0x014f, B:36:0x010d, B:44:0x012e, B:45:0x0134, B:39:0x0114, B:67:0x01cc, B:69:0x01d4, B:73:0x01dc, B:117:0x03de, B:119:0x03e6, B:122:0x03ee, B:123:0x0400, B:125:0x0406, B:128:0x0420, B:129:0x043c, B:131:0x0442, B:133:0x045d, B:134:0x0461, B:135:0x0481, B:137:0x0487, B:138:0x049d, B:139:0x04ae, B:141:0x04b4, B:143:0x04cd, B:146:0x04d6, B:147:0x04da, B:148:0x04f0, B:150:0x04f6, B:151:0x0504), top: B:190:0x002e, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012e A[Catch: all -> 0x05cc, TryCatch #4 {all -> 0x05cc, blocks: (B:13:0x0061, B:154:0x050b, B:156:0x0510, B:174:0x05c7, B:157:0x0516, B:159:0x0556, B:160:0x055c, B:161:0x055f, B:16:0x007f, B:98:0x034f, B:19:0x009c, B:92:0x02c7, B:22:0x00b9, B:86:0x026e, B:25:0x00ce, B:173:0x05c4, B:57:0x017c, B:59:0x0182, B:60:0x0188, B:64:0x01aa, B:76:0x01eb, B:79:0x01f2, B:83:0x01f8, B:87:0x0273, B:89:0x027b, B:93:0x02cc, B:95:0x02d2, B:99:0x0354, B:101:0x0360, B:104:0x0368, B:105:0x036c, B:106:0x0377, B:108:0x037d, B:110:0x038e, B:112:0x0398, B:113:0x039c, B:75:0x01e1, B:166:0x0569, B:170:0x0584, B:33:0x00fd, B:48:0x0147, B:50:0x014f, B:36:0x010d, B:44:0x012e, B:45:0x0134, B:39:0x0114, B:67:0x01cc, B:69:0x01d4, B:73:0x01dc, B:117:0x03de, B:119:0x03e6, B:122:0x03ee, B:123:0x0400, B:125:0x0406, B:128:0x0420, B:129:0x043c, B:131:0x0442, B:133:0x045d, B:134:0x0461, B:135:0x0481, B:137:0x0487, B:138:0x049d, B:139:0x04ae, B:141:0x04b4, B:143:0x04cd, B:146:0x04d6, B:147:0x04da, B:148:0x04f0, B:150:0x04f6, B:151:0x0504), top: B:190:0x002e, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0134 A[Catch: all -> 0x05cc, TryCatch #4 {all -> 0x05cc, blocks: (B:13:0x0061, B:154:0x050b, B:156:0x0510, B:174:0x05c7, B:157:0x0516, B:159:0x0556, B:160:0x055c, B:161:0x055f, B:16:0x007f, B:98:0x034f, B:19:0x009c, B:92:0x02c7, B:22:0x00b9, B:86:0x026e, B:25:0x00ce, B:173:0x05c4, B:57:0x017c, B:59:0x0182, B:60:0x0188, B:64:0x01aa, B:76:0x01eb, B:79:0x01f2, B:83:0x01f8, B:87:0x0273, B:89:0x027b, B:93:0x02cc, B:95:0x02d2, B:99:0x0354, B:101:0x0360, B:104:0x0368, B:105:0x036c, B:106:0x0377, B:108:0x037d, B:110:0x038e, B:112:0x0398, B:113:0x039c, B:75:0x01e1, B:166:0x0569, B:170:0x0584, B:33:0x00fd, B:48:0x0147, B:50:0x014f, B:36:0x010d, B:44:0x012e, B:45:0x0134, B:39:0x0114, B:67:0x01cc, B:69:0x01d4, B:73:0x01dc, B:117:0x03de, B:119:0x03e6, B:122:0x03ee, B:123:0x0400, B:125:0x0406, B:128:0x0420, B:129:0x043c, B:131:0x0442, B:133:0x045d, B:134:0x0461, B:135:0x0481, B:137:0x0487, B:138:0x049d, B:139:0x04ae, B:141:0x04b4, B:143:0x04cd, B:146:0x04d6, B:147:0x04da, B:148:0x04f0, B:150:0x04f6, B:151:0x0504), top: B:190:0x002e, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014f A[Catch: all -> 0x05cc, TRY_LEAVE, TryCatch #4 {all -> 0x05cc, blocks: (B:13:0x0061, B:154:0x050b, B:156:0x0510, B:174:0x05c7, B:157:0x0516, B:159:0x0556, B:160:0x055c, B:161:0x055f, B:16:0x007f, B:98:0x034f, B:19:0x009c, B:92:0x02c7, B:22:0x00b9, B:86:0x026e, B:25:0x00ce, B:173:0x05c4, B:57:0x017c, B:59:0x0182, B:60:0x0188, B:64:0x01aa, B:76:0x01eb, B:79:0x01f2, B:83:0x01f8, B:87:0x0273, B:89:0x027b, B:93:0x02cc, B:95:0x02d2, B:99:0x0354, B:101:0x0360, B:104:0x0368, B:105:0x036c, B:106:0x0377, B:108:0x037d, B:110:0x038e, B:112:0x0398, B:113:0x039c, B:75:0x01e1, B:166:0x0569, B:170:0x0584, B:33:0x00fd, B:48:0x0147, B:50:0x014f, B:36:0x010d, B:44:0x012e, B:45:0x0134, B:39:0x0114, B:67:0x01cc, B:69:0x01d4, B:73:0x01dc, B:117:0x03de, B:119:0x03e6, B:122:0x03ee, B:123:0x0400, B:125:0x0406, B:128:0x0420, B:129:0x043c, B:131:0x0442, B:133:0x045d, B:134:0x0461, B:135:0x0481, B:137:0x0487, B:138:0x049d, B:139:0x04ae, B:141:0x04b4, B:143:0x04cd, B:146:0x04d6, B:147:0x04da, B:148:0x04f0, B:150:0x04f6, B:151:0x0504), top: B:190:0x002e, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0182 A[Catch: all -> 0x05cc, TryCatch #4 {all -> 0x05cc, blocks: (B:13:0x0061, B:154:0x050b, B:156:0x0510, B:174:0x05c7, B:157:0x0516, B:159:0x0556, B:160:0x055c, B:161:0x055f, B:16:0x007f, B:98:0x034f, B:19:0x009c, B:92:0x02c7, B:22:0x00b9, B:86:0x026e, B:25:0x00ce, B:173:0x05c4, B:57:0x017c, B:59:0x0182, B:60:0x0188, B:64:0x01aa, B:76:0x01eb, B:79:0x01f2, B:83:0x01f8, B:87:0x0273, B:89:0x027b, B:93:0x02cc, B:95:0x02d2, B:99:0x0354, B:101:0x0360, B:104:0x0368, B:105:0x036c, B:106:0x0377, B:108:0x037d, B:110:0x038e, B:112:0x0398, B:113:0x039c, B:75:0x01e1, B:166:0x0569, B:170:0x0584, B:33:0x00fd, B:48:0x0147, B:50:0x014f, B:36:0x010d, B:44:0x012e, B:45:0x0134, B:39:0x0114, B:67:0x01cc, B:69:0x01d4, B:73:0x01dc, B:117:0x03de, B:119:0x03e6, B:122:0x03ee, B:123:0x0400, B:125:0x0406, B:128:0x0420, B:129:0x043c, B:131:0x0442, B:133:0x045d, B:134:0x0461, B:135:0x0481, B:137:0x0487, B:138:0x049d, B:139:0x04ae, B:141:0x04b4, B:143:0x04cd, B:146:0x04d6, B:147:0x04da, B:148:0x04f0, B:150:0x04f6, B:151:0x0504), top: B:190:0x002e, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0188 A[Catch: all -> 0x05cc, TryCatch #4 {all -> 0x05cc, blocks: (B:13:0x0061, B:154:0x050b, B:156:0x0510, B:174:0x05c7, B:157:0x0516, B:159:0x0556, B:160:0x055c, B:161:0x055f, B:16:0x007f, B:98:0x034f, B:19:0x009c, B:92:0x02c7, B:22:0x00b9, B:86:0x026e, B:25:0x00ce, B:173:0x05c4, B:57:0x017c, B:59:0x0182, B:60:0x0188, B:64:0x01aa, B:76:0x01eb, B:79:0x01f2, B:83:0x01f8, B:87:0x0273, B:89:0x027b, B:93:0x02cc, B:95:0x02d2, B:99:0x0354, B:101:0x0360, B:104:0x0368, B:105:0x036c, B:106:0x0377, B:108:0x037d, B:110:0x038e, B:112:0x0398, B:113:0x039c, B:75:0x01e1, B:166:0x0569, B:170:0x0584, B:33:0x00fd, B:48:0x0147, B:50:0x014f, B:36:0x010d, B:44:0x012e, B:45:0x0134, B:39:0x0114, B:67:0x01cc, B:69:0x01d4, B:73:0x01dc, B:117:0x03de, B:119:0x03e6, B:122:0x03ee, B:123:0x0400, B:125:0x0406, B:128:0x0420, B:129:0x043c, B:131:0x0442, B:133:0x045d, B:134:0x0461, B:135:0x0481, B:137:0x0487, B:138:0x049d, B:139:0x04ae, B:141:0x04b4, B:143:0x04cd, B:146:0x04d6, B:147:0x04da, B:148:0x04f0, B:150:0x04f6, B:151:0x0504), top: B:190:0x002e, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(e9.InterfaceC4014c<? super kotlin.Result<? extends java.util.List<com.stepos.ailauncher.agent.aispace.connect.data.DeviceAgentItem>>> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.D(e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0143, code lost:
    
        if (r6 == r5) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(java.lang.String r23, java.lang.String r24, java.lang.Integer r25, java.lang.String r26, java.lang.String r27, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.connect.data.SessionListResponseData>> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1008
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.F(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac A[Catch: all -> 0x0308, TRY_LEAVE, TryCatch #1 {all -> 0x0308, blocks: (B:46:0x00d2, B:48:0x00d8, B:109:0x0303, B:49:0x00de, B:52:0x00ec, B:64:0x0119, B:67:0x0120, B:71:0x0126, B:72:0x016f, B:74:0x0177, B:75:0x0195, B:77:0x019b, B:78:0x01ec, B:80:0x01f6, B:81:0x01fb, B:82:0x020a, B:84:0x0210, B:86:0x0221, B:88:0x022b, B:89:0x022f, B:90:0x023e, B:92:0x0244, B:93:0x0252, B:94:0x0261, B:96:0x0267, B:98:0x0278, B:99:0x027c, B:100:0x0289, B:102:0x028f, B:103:0x029d, B:63:0x010f, B:104:0x02c8, B:108:0x02e3, B:21:0x0056, B:37:0x00a4, B:39:0x00ac, B:24:0x0069, B:32:0x008a, B:33:0x0090, B:27:0x0072, B:55:0x00fa, B:57:0x0102, B:61:0x010a, B:14:0x003a, B:45:0x00d0, B:41:0x00b2), top: B:119:0x0026, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[Catch: all -> 0x003f, TRY_ENTER, TryCatch #2 {all -> 0x003f, blocks: (B:14:0x003a, B:45:0x00d0, B:41:0x00b2), top: B:119:0x0026, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8 A[Catch: all -> 0x0308, TryCatch #1 {all -> 0x0308, blocks: (B:46:0x00d2, B:48:0x00d8, B:109:0x0303, B:49:0x00de, B:52:0x00ec, B:64:0x0119, B:67:0x0120, B:71:0x0126, B:72:0x016f, B:74:0x0177, B:75:0x0195, B:77:0x019b, B:78:0x01ec, B:80:0x01f6, B:81:0x01fb, B:82:0x020a, B:84:0x0210, B:86:0x0221, B:88:0x022b, B:89:0x022f, B:90:0x023e, B:92:0x0244, B:93:0x0252, B:94:0x0261, B:96:0x0267, B:98:0x0278, B:99:0x027c, B:100:0x0289, B:102:0x028f, B:103:0x029d, B:63:0x010f, B:104:0x02c8, B:108:0x02e3, B:21:0x0056, B:37:0x00a4, B:39:0x00ac, B:24:0x0069, B:32:0x008a, B:33:0x0090, B:27:0x0072, B:55:0x00fa, B:57:0x0102, B:61:0x010a, B:14:0x003a, B:45:0x00d0, B:41:0x00b2), top: B:119:0x0026, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de A[Catch: all -> 0x0308, TryCatch #1 {all -> 0x0308, blocks: (B:46:0x00d2, B:48:0x00d8, B:109:0x0303, B:49:0x00de, B:52:0x00ec, B:64:0x0119, B:67:0x0120, B:71:0x0126, B:72:0x016f, B:74:0x0177, B:75:0x0195, B:77:0x019b, B:78:0x01ec, B:80:0x01f6, B:81:0x01fb, B:82:0x020a, B:84:0x0210, B:86:0x0221, B:88:0x022b, B:89:0x022f, B:90:0x023e, B:92:0x0244, B:93:0x0252, B:94:0x0261, B:96:0x0267, B:98:0x0278, B:99:0x027c, B:100:0x0289, B:102:0x028f, B:103:0x029d, B:63:0x010f, B:104:0x02c8, B:108:0x02e3, B:21:0x0056, B:37:0x00a4, B:39:0x00ac, B:24:0x0069, B:32:0x008a, B:33:0x0090, B:27:0x0072, B:55:0x00fa, B:57:0x0102, B:61:0x010a, B:14:0x003a, B:45:0x00d0, B:41:0x00b2), top: B:119:0x0026, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H(e9.InterfaceC4014c<? super kotlin.Result<? extends java.util.List<com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.SidebarAgent>>> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.H(e9.c):java.lang.Object");
    }

    public final Object I(InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objP = P(i(), interfaceC4014c);
        return objP == C4063a.g() ? objP : Y8.t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ad, code lost:
    
        if (r11 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(java.lang.String r9, java.lang.String r10, e9.InterfaceC4014c<? super kotlin.Result<java.lang.Boolean>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.J(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final Object K(String str, InterfaceC4014c<? super Result<Boolean>> interfaceC4014c) {
        Result.Companion companion = Result.INSTANCE;
        return Result.b(C4849c.a(new NotImplementedError("reconnectDevice: §6.2 未定义对应 server endpoint")));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00bd, code lost:
    
        if (r13 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(java.lang.String r10, java.lang.String r11, java.lang.String r12, e9.InterfaceC4014c<? super kotlin.Result<java.lang.Boolean>> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.L(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final void M() throws NetworkUnavailableException {
        if (!I.INSTANCE.b(C3197a.INSTANCE.a())) {
            throw new NetworkUnavailableException();
        }
    }

    public final void N(ApiEnvelope<?> envelope) {
        if (envelope.d()) {
            return;
        }
        throw new IllegalStateException(("biz error: code=" + envelope.getCode() + " msg=" + envelope.getMessage()).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(java.lang.String r6, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.agent.aispace.connect.data.DeviceAgentItem>> r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.O(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object P(java.lang.String r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository$syncAccount$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository$syncAccount$1 r0 = (com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository$syncAccount$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository$syncAccount$1 r0 = new com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository$syncAccount$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r7 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L3d
            if (r1 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            eb.a r6 = (eb.InterfaceC4021a) r6
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r5)
            r5 = r6
            r6 = r7
            goto L51
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.C4849c.b(r5)
            eb.a r5 = com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.cacheMutex
            r0.L$0 = r6
            r0.L$1 = r5
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r0 = r5.m(r4, r0)
            if (r0 != r7) goto L51
            return r7
        L51:
            java.lang.String r7 = com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.cacheAccountId     // Catch: java.lang.Throwable -> L77
            boolean r7 = kotlin.jvm.internal.p.d(r7, r6)     // Catch: java.lang.Throwable -> L77
            if (r7 != 0) goto L79
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.cacheAccountId = r6     // Catch: java.lang.Throwable -> L77
            java.util.List<com.stepos.ailauncher.agent.aispace.connect.data.p> r7 = com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.cache     // Catch: java.lang.Throwable -> L77
            r7.clear()     // Catch: java.lang.Throwable -> L77
            java.util.List<com.stepos.ailauncher.agent.aispace.connect.data.p> r7 = com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.recentlyConfirmed     // Catch: java.lang.Throwable -> L77
            r7.clear()     // Catch: java.lang.Throwable -> L77
            java.util.Set<kotlin.Pair<java.lang.String, java.lang.String>> r7 = com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.recentlyDisabled     // Catch: java.lang.Throwable -> L77
            r7.clear()     // Catch: java.lang.Throwable -> L77
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.lastListError = r4     // Catch: java.lang.Throwable -> L77
            com.stepos.ailauncher.agent.aispace.w r7 = com.stepos.ailauncher.agent.aispace.w.INSTANCE     // Catch: java.lang.Throwable -> L77
            java.util.List r0 = Z8.C1173v.m()     // Catch: java.lang.Throwable -> L77
            r7.c(r0)     // Catch: java.lang.Throwable -> L77
            r7 = r3
            goto L7a
        L77:
            r6 = move-exception
            goto La8
        L79:
            r7 = r2
        L7a:
            r5.l(r4)
            if (r7 == 0) goto La5
            kotlin.jvm.internal.y r5 = kotlin.jvm.internal.y.f34840a
            if (r6 != 0) goto L85
            java.lang.String r6 = ""
        L85:
            java.lang.Object[] r5 = new java.lang.Object[]{r6}
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r3)
            java.lang.String r6 = "external Agent account changed: account=%s"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            java.lang.String r6 = "format(...)"
            kotlin.jvm.internal.p.h(r5, r6)
            r6 = 4
            java.lang.String r7 = "AgentDeviceRepo"
            h8.C4148a.k(r7, r5, r2, r6, r4)
            Xa.j<Y8.t> r5 = com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository._devicesUpdates
            Y8.t r6 = Y8.t.f7040a
            r5.a(r6)
        La5:
            Y8.t r5 = Y8.t.f7040a
            return r5
        La8:
            r5.l(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.P(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.SidebarAgent Q(com.stepos.ailauncher.agent.aispace.connect.data.OpenClawAgentInfo r17) {
        /*
            r16 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r17.getAssetId()
            r0.append(r1)
            java.lang.String r1 = r17.getSemver()
            boolean r1 = La.H.x0(r1)
            if (r1 != 0) goto L28
            int r1 = r0.length()
            if (r1 <= 0) goto L21
            r1 = 32
            r0.append(r1)
        L21:
            java.lang.String r1 = r17.getSemver()
            r0.append(r1)
        L28:
            java.lang.String r0 = r0.toString()
            boolean r1 = La.H.x0(r0)
            if (r1 == 0) goto L36
            java.lang.String r0 = r17.getAssetId()
        L36:
            r2 = r0
            java.lang.String r0 = r17.getDisplayName()
            if (r0 == 0) goto L4a
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L44
            goto L45
        L44:
            r0 = 0
        L45:
            if (r0 != 0) goto L48
            goto L4a
        L48:
            r4 = r0
            goto L4b
        L4a:
            r4 = r2
        L4b:
            com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent r1 = new com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent
            java.lang.String r3 = r17.getAgentId()
            boolean r6 = r17.getEnabled()
            int r0 = r17.getPinned()
            if (r0 == 0) goto L5e
            r0 = 1
        L5c:
            r7 = r0
            goto L60
        L5e:
            r0 = 0
            goto L5c
        L60:
            long r8 = r17.getUpdateAt()
            boolean r11 = r17.getEnabled()
            java.lang.String r12 = r17.getAssetId()
            java.lang.String r13 = r17.getReversionId()
            java.lang.String r14 = r17.getSemver()
            java.lang.String r15 = r17.getIcon()
            java.lang.String r5 = ""
            r10 = 1
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.Q(com.stepos.ailauncher.agent.aispace.connect.data.v):com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.SidebarAgent R(com.stepos.ailauncher.agent.aispace.connect.data.ProxyAgentInfo r21) {
        /*
            r20 = this;
            java.lang.String r0 = r21.getAgentId()
            boolean r1 = La.H.x0(r0)
            r2 = 0
            if (r1 != 0) goto Lc
            goto Ld
        Lc:
            r0 = r2
        Ld:
            if (r0 != 0) goto L2b
            java.lang.String r0 = r21.getDeviceId()
            java.lang.String r1 = r21.getAgent()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "#"
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
        L2b:
            r4 = r0
            java.lang.String r5 = r21.getDeviceId()
            java.lang.String r0 = r21.getDisplayName()
            if (r0 == 0) goto L42
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L3d
            r2 = r0
        L3d:
            if (r2 != 0) goto L40
            goto L42
        L40:
            r6 = r2
            goto L47
        L42:
            java.lang.String r2 = r21.getDeviceId()
            goto L40
        L47:
            java.lang.String r7 = r21.getAgent()
            boolean r8 = r21.getOnline()
            int r0 = r21.getPinned()
            if (r0 == 0) goto L58
            r0 = 1
        L56:
            r9 = r0
            goto L5a
        L58:
            r0 = 0
            goto L56
        L5a:
            long r10 = r21.getUpdateAt()
            java.lang.String r17 = r21.getIcon()
            com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent r3 = new com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 3840(0xf00, float:5.381E-42)
            r19 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.R(com.stepos.ailauncher.agent.aispace.connect.data.w):com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.ConnectedDevice S(com.stepos.ailauncher.agent.aispace.connect.data.DeviceAgentItem r4) {
        /*
            r3 = this;
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.p.i(r4, r3)
            java.lang.String r3 = r4.getDeviceId()
            java.lang.String r0 = r4.getDisplayName()
            if (r0 == 0) goto L19
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L16
            goto L17
        L16:
            r0 = 0
        L17:
            if (r0 != 0) goto L1d
        L19:
            java.lang.String r0 = r4.getDeviceId()
        L1d:
            java.lang.String r1 = r4.getAgent()
            boolean r4 = r4.getOnline()
            com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$ConnectedDevice r2 = new com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$ConnectedDevice
            r2.<init>(r3, r0, r1, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.S(com.stepos.ailauncher.agent.aispace.connect.data.p):com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$ConnectedDevice");
    }

    public final String T(String token) {
        if (token.length() == 0) {
            return "(empty)";
        }
        if (token.length() <= 16) {
            return token;
        }
        return K.R1(token, 12) + "…" + K.S1(token, 4) + " (len=" + token.length() + ")";
    }

    public final void U(DeviceAgentItem item) {
        Iterator<DeviceAgentItem> it = cache.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            DeviceAgentItem next = it.next();
            if (kotlin.jvm.internal.p.d(next.getDeviceId(), item.getDeviceId()) && kotlin.jvm.internal.p.d(next.getAgent(), item.getAgent())) {
                break;
            } else {
                i10++;
            }
        }
        List<DeviceAgentItem> list = cache;
        if (i10 >= 0) {
            list.set(i10, item);
        } else {
            list.add(item);
        }
    }

    public final String i() {
        Object objB;
        com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
        if (!fVar.v()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(fVar.k());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null || H.x0(str)) {
            return null;
        }
        return str;
    }

    public final String k(String token) {
        return "Bearer " + H.D1(H.R0(token, "Bearer ")).toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x022a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0287 A[Catch: all -> 0x0409, TRY_LEAVE, TryCatch #2 {all -> 0x0409, blocks: (B:14:0x0074, B:86:0x0365, B:88:0x03aa, B:89:0x03ae, B:45:0x01e2, B:49:0x0224, B:60:0x0249, B:63:0x0250, B:67:0x0263, B:71:0x0283, B:72:0x0286, B:73:0x0287, B:76:0x0291, B:78:0x0297, B:80:0x029f, B:90:0x03af, B:91:0x03cc, B:92:0x03cd, B:93:0x03dc, B:94:0x03dd, B:95:0x03fa, B:59:0x023f, B:97:0x03fc, B:98:0x0408, B:22:0x00c2, B:29:0x00ff, B:31:0x0125, B:33:0x012b, B:34:0x0130, B:35:0x0133, B:39:0x0142, B:25:0x00d5, B:51:0x022a, B:53:0x0232, B:57:0x023a, B:84:0x0340, B:19:0x00a8, B:44:0x01e0, B:40:0x018e), top: B:109:0x002c, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.lang.String r36, java.lang.String r37, java.lang.String r38, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.connect.data.DeviceInfoDto>> r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.l(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014a A[Catch: all -> 0x0150, TRY_ENTER, TryCatch #0 {all -> 0x0150, blocks: (B:38:0x014a, B:42:0x016c, B:43:0x0188, B:45:0x018e, B:47:0x01a7, B:48:0x01ab, B:49:0x01b4, B:51:0x01ba, B:53:0x01d5, B:41:0x0153), top: B:68:0x0148, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0153 A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:38:0x014a, B:42:0x016c, B:43:0x0188, B:45:0x018e, B:47:0x01a7, B:48:0x01ab, B:49:0x01b4, B:51:0x01ba, B:53:0x01d5, B:41:0x0153), top: B:68:0x0148, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018e A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:38:0x014a, B:42:0x016c, B:43:0x0188, B:45:0x018e, B:47:0x01a7, B:48:0x01ab, B:49:0x01b4, B:51:0x01ba, B:53:0x01d5, B:41:0x0153), top: B:68:0x0148, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ba A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:38:0x014a, B:42:0x016c, B:43:0x0188, B:45:0x018e, B:47:0x01a7, B:48:0x01ab, B:49:0x01b4, B:51:0x01ba, B:53:0x01d5, B:41:0x0153), top: B:68:0x0148, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f3 A[Catch: all -> 0x0218, LOOP:2: B:56:0x01ed->B:58:0x01f3, LOOP_END, TryCatch #1 {all -> 0x0218, blocks: (B:14:0x0057, B:55:0x01d9, B:56:0x01ed, B:58:0x01f3, B:59:0x0201, B:60:0x0214, B:61:0x0217, B:19:0x007e, B:33:0x0107, B:22:0x009e, B:29:0x00d1, B:25:0x00ab, B:38:0x014a, B:42:0x016c, B:43:0x0188, B:45:0x018e, B:47:0x01a7, B:48:0x01ab, B:49:0x01b4, B:51:0x01ba, B:53:0x01d5, B:41:0x0153), top: B:70:0x0029, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.lang.String r18, java.lang.String r19, boolean r20, e9.InterfaceC4014c<? super kotlin.Result<java.lang.Boolean>> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.n(java.lang.String, java.lang.String, boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ff A[Catch: all -> 0x0366, TRY_LEAVE, TryCatch #1 {all -> 0x0366, blocks: (B:14:0x0069, B:76:0x02c4, B:78:0x0309, B:79:0x030d, B:35:0x0161, B:39:0x019e, B:50:0x01c3, B:53:0x01ca, B:57:0x01dd, B:61:0x01fb, B:62:0x01fe, B:63:0x01ff, B:66:0x0209, B:68:0x020f, B:70:0x0219, B:80:0x030e, B:81:0x032b, B:82:0x032c, B:83:0x0339, B:84:0x033a, B:85:0x0357, B:49:0x01b9, B:87:0x0359, B:88:0x0365, B:22:0x00ac, B:29:0x00e2, B:25:0x00be, B:41:0x01a4, B:43:0x01ac, B:47:0x01b4, B:19:0x0092, B:34:0x015f, B:30:0x0121, B:74:0x029f), top: B:97:0x002d, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r27, java.lang.String r28, java.lang.String r29, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.connect.data.DeviceInfoDto>> r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 899
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.q(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final String s(tb.u headers) {
        StringBuilder sb2 = new StringBuilder();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strF = headers.f(i10);
            String strK = headers.k(i10);
            if (D.L(strF, "Authorization", true) && strK.length() > 20) {
                strK = K.R1(strK, 16) + "…" + K.S1(strK, 4) + " (len=" + strK.length() + ")";
            }
            sb2.append("  " + strF + ": " + strK);
            sb2.append('\n');
        }
        return sb2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
    
        if (r10 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(java.lang.String r9, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceResponseData>> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository$getAgentEntrance$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository$getAgentEntrance$1 r0 = (com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository$getAgentEntrance$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository$getAgentEntrance$1 r0 = new com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository$getAgentEntrance$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L52
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r8 = r0.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.L$1
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository r8 = (com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository) r8
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> La9
            goto L8f
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository r9 = (com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository) r9
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> La9
            r7 = r2
            r2 = r8
            r8 = r9
            r9 = r7
            goto L6c
        L52:
            kotlin.C4849c.b(r10)
            kotlin.Result$a r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> La9
            r8.M()     // Catch: java.lang.Throwable -> La9
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuAuth r10 = com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuAuth.INSTANCE     // Catch: java.lang.Throwable -> La9
            r0.L$0 = r9     // Catch: java.lang.Throwable -> La9
            r0.L$1 = r8     // Catch: java.lang.Throwable -> La9
            r2 = 0
            r0.I$0 = r2     // Catch: java.lang.Throwable -> La9
            r0.label = r4     // Catch: java.lang.Throwable -> La9
            java.lang.Object r10 = r10.b(r0)     // Catch: java.lang.Throwable -> La9
            if (r10 != r1) goto L6c
            goto L8e
        L6c:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> La9
            com.stepos.ailauncher.agent.aispace.connect.data.a r4 = r8.u()     // Catch: java.lang.Throwable -> La9
            java.lang.String r5 = r8.k(r10)     // Catch: java.lang.Throwable -> La9
            java.lang.Object r6 = g9.h.a(r9)     // Catch: java.lang.Throwable -> La9
            r0.L$0 = r6     // Catch: java.lang.Throwable -> La9
            r0.L$1 = r8     // Catch: java.lang.Throwable -> La9
            java.lang.Object r10 = g9.h.a(r10)     // Catch: java.lang.Throwable -> La9
            r0.L$2 = r10     // Catch: java.lang.Throwable -> La9
            r0.I$0 = r2     // Catch: java.lang.Throwable -> La9
            r0.label = r3     // Catch: java.lang.Throwable -> La9
            java.lang.Object r10 = r4.d(r5, r9, r0)     // Catch: java.lang.Throwable -> La9
            if (r10 != r1) goto L8f
        L8e:
            return r1
        L8f:
            com.stepos.ailauncher.agent.aispace.connect.data.l r10 = (com.stepos.ailauncher.agent.aispace.connect.data.ApiEnvelope) r10     // Catch: java.lang.Throwable -> La9
            r8.N(r10)     // Catch: java.lang.Throwable -> La9
            java.lang.Object r8 = r10.b()     // Catch: java.lang.Throwable -> La9
            com.stepos.ailauncher.agent.aispace.connect.data.j r8 = (com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceResponseData) r8     // Catch: java.lang.Throwable -> La9
            if (r8 == 0) goto La1
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> La9
            goto Lb5
        La1:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La9
            java.lang.String r9 = "getAgentEntrance: empty data"
            r8.<init>(r9)     // Catch: java.lang.Throwable -> La9
            throw r8     // Catch: java.lang.Throwable -> La9
        La9:
            r0 = move-exception
            r8 = r0
            kotlin.Result$a r9 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        Lb5:
            java.lang.Throwable r2 = kotlin.Result.e(r8)
            if (r2 == 0) goto Lc6
            r4 = 8
            r5 = 0
            java.lang.String r0 = "AgentDeviceRepo"
            java.lang.String r1 = "getAgentEntrance failed"
            r3 = 0
            h8.C4148a.t(r0, r1, r2, r3, r4, r5)
        Lc6:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.t(java.lang.String, e9.c):java.lang.Object");
    }

    public final InterfaceC2198a u() {
        Object value = api.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (InterfaceC2198a) value;
    }

    public final Xa.o<Y8.t> v() {
        return devicesUpdates;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:4|(1:6)(1:7))(0)|8|78|(1:(1:(4:12|13|34|(2:36|(2:38|(2:40|(6:42|54|(9:56|(1:58)|59|(1:61)|62|(1:65)|66|(1:69)|70)(1:71)|72|(1:74)|75)(2:43|44))(2:45|46))(2:47|48))(2:49|50))(2:17|18))(4:19|76|20|21))(4:25|26|(1:29)|32)|22|79|30|(3:33|34|(0)(0))|32|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x014b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014c, code lost:
    
        r11 = r0;
        r12 = r5;
        r13 = r6;
        r14 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6 A[Catch: all -> 0x0048, TryCatch #1 {all -> 0x0048, blocks: (B:13:0x0043, B:34:0x00ce, B:36:0x00d6, B:38:0x00de, B:40:0x00e4, B:42:0x00ec, B:43:0x00f1, B:44:0x00f8, B:45:0x00f9, B:46:0x0123, B:47:0x0124, B:48:0x012b, B:49:0x012c, B:50:0x014a, B:26:0x0078), top: B:78:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012c A[Catch: all -> 0x0048, TryCatch #1 {all -> 0x0048, blocks: (B:13:0x0043, B:34:0x00ce, B:36:0x00d6, B:38:0x00de, B:40:0x00e4, B:42:0x00ec, B:43:0x00f1, B:44:0x00f8, B:45:0x00f9, B:46:0x0123, B:47:0x0124, B:48:0x012b, B:49:0x012c, B:50:0x014a, B:26:0x0078), top: B:78:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(java.lang.String r12, java.lang.String r13, java.lang.String r14, e9.InterfaceC4014c<? super kotlin.Result<com.stepos.ailauncher.agent.aispace.connect.data.GetFileSyncResponseData>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 555
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.w(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final String y() {
        return lastBindStepaiHeaders;
    }

    public final String z() {
        return lastConfirmHeaders;
    }
}
