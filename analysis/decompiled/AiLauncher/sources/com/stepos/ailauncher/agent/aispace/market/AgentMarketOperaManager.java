package com.stepos.ailauncher.agent.aispace.market;

import Ua.C1060i;
import Z8.C1174w;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.market.data.GetAgentStatusData;
import com.stepos.ailauncher.agent.aispace.market.data.GetInstallProgressData;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import eb.InterfaceC4021a;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import org.json.JSONException;
import org.json.JSONObject;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0080\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u0004*\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0006J!\u0010\"\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010)J \u0010+\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u0014H\u0082@¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b-\u0010\u0013J'\u0010/\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00142\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b5\u00106J\u001b\u00109\u001a\u00020\u00112\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000f07¢\u0006\u0004\b9\u0010:J\u001d\u0010<\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\f¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b>\u0010?J\u0015\u0010@\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\bB\u0010\u001eJ\u0015\u0010C\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\bC\u0010?JA\u0010I\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u00142\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110G¢\u0006\u0004\bI\u0010JJA\u0010K\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u00142\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110G¢\u0006\u0004\bK\u0010JJ\u0015\u0010L\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\bL\u0010?J\u0015\u0010M\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\bM\u0010?J\u001d\u0010O\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u0004¢\u0006\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082T¢\u0006\u0006\n\u0004\bT\u0010\u0012R\u0014\u0010U\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\bU\u0010@R\u0014\u0010V\u001a\u00020S8\u0002X\u0082T¢\u0006\u0006\n\u0004\bV\u0010\u0012R\u0014\u0010W\u001a\u00020S8\u0002X\u0082T¢\u0006\u0006\n\u0004\bW\u0010\u0012R\u0014\u0010X\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\bX\u0010@R\u0014\u0010Z\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R&\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0`0_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR)\u0010d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0`0c8\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR!\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00140h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR&\u0010n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00190`0_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010bR)\u0010o\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00190`0c8\u0006¢\u0006\f\n\u0004\bo\u0010e\u001a\u0004\bp\u0010gR0\u0010t\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020r0qj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020r`s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020w0v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u001d\u0010{\u001a\b\u0012\u0004\u0012\u00020w0z8\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~RH\u0010\u007f\u001a6\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110G0qj\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110G`s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010u¨\u0006\u0081\u0001"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager;", "", "<init>", "()V", "", "B", "()Z", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Throwable;)Z", "Lcom/stepos/ailauncher/agent/aispace/market/data/l;", "data", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", ExifInterface.LONGITUDE_EAST, "(Lcom/stepos/ailauncher/agent/aispace/market/data/l;)Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "item", "LY8/t;", "J", "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;Le9/c;)Ljava/lang/Object;", "", "assetId", "status", "M", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;)V", "", "pct", "O", "(Ljava/lang/String;I)V", "r", "(Ljava/lang/String;)V", "P", "C", "finalPct", "R", "(Ljava/lang/String;Ljava/lang/Integer;)V", "ok", "t", "(Ljava/lang/String;Z)V", "success", ExifInterface.GPS_DIRECTION_TRUE, "(Z)V", "installType", "G", "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "X", "message", "s", "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/agent/aispace/market/data/p;", "p", "H", "(Lcom/stepos/ailauncher/agent/aispace/market/data/p;)Ljava/lang/String;", "D", "(Ljava/lang/String;)Z", "", DidiCardProvider.KEY_ITEMS, "L", "(Ljava/util/List;)V", "fallback", "Q", "(Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;)Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "K", "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;)V", "I", "(Ljava/lang/String;)I", "F", "y", "reversionId", "semver", "displayName", "Lkotlin/Function1;", "onDone", "z", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/l;)V", ExifInterface.LONGITUDE_WEST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "U", x5.d.EXTRA_ENABLED, "N", "(Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;Z)V", "TAG", "Ljava/lang/String;", "", "POLL_INTERVAL_MS", "MAX_POLL_FAIL", "INSTALL_PROGRESS_BUDGET_MS", "PROGRESS_TICK_MS", "PROGRESS_CAP", "LUa/M;", "scope", "LUa/M;", "Leb/a;", "opLock", "Leb/a;", "LXa/k;", "", "_statusTable", "LXa/k;", "LXa/t;", "statusTable", "LXa/t;", "w", "()LXa/t;", "", "testingAssetIds$delegate", "LY8/h;", "x", "()Ljava/util/Set;", "testingAssetIds", "_progressTable", "progressTable", "v", "Ljava/util/HashMap;", "Lkotlinx/coroutines/g;", "Lkotlin/collections/HashMap;", "progressJobs", "Ljava/util/HashMap;", "LXa/j;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a;", "_events", "LXa/j;", "LXa/o;", "events", "LXa/o;", "u", "()LXa/o;", "pendingInstallCallbacks", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketOperaManager {
    private static final long INSTALL_PROGRESS_BUDGET_MS = 40000;
    private static final int MAX_POLL_FAIL = 5;
    private static final long POLL_INTERVAL_MS = 2000;
    private static final int PROGRESS_CAP = 99;
    private static final long PROGRESS_TICK_MS = 400;
    private static final String TAG = "AgentMarketOpera";
    private static final Xa.j<a> _events;
    private static final Xa.k<Map<String, Integer>> _progressTable;
    private static final Xa.k<Map<String, AgentMarketStatus>> _statusTable;
    private static final Xa.o<a> events;
    private static final HashMap<String, InterfaceC5074l<Boolean, Y8.t>> pendingInstallCallbacks;
    private static final HashMap<String, kotlinx.coroutines.g> progressJobs;
    private static final Xa.t<Map<String, Integer>> progressTable;
    private static final Xa.t<Map<String, AgentMarketStatus>> statusTable;

    /* renamed from: testingAssetIds$delegate, reason: from kotlin metadata */
    private static final Y8.h testingAssetIds;
    public static final AgentMarketOperaManager INSTANCE = new AgentMarketOperaManager();
    private static final Ua.M scope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
    private static final InterfaceC4021a opLock = eb.f.b(false, 1, null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a;", "", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a$a;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a$b;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a$c;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a$d;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a$a;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a;", "", "assetId", "message", "", "isNetworkError", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAssetId", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_PKGNAME, "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$a$a, reason: collision with other inner class name and from toString */
        public static final /* data */ class Failed implements a {
            private final String assetId;
            private final boolean isNetworkError;
            private final String message;

            public Failed(String assetId, String message, boolean z10) {
                kotlin.jvm.internal.p.i(assetId, "assetId");
                kotlin.jvm.internal.p.i(message, "message");
                this.assetId = assetId;
                this.message = message;
                this.isNetworkError = z10;
            }

            /* renamed from: a, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            /* renamed from: b, reason: from getter */
            public final boolean getIsNetworkError() {
                return this.isNetworkError;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Failed)) {
                    return false;
                }
                Failed failed = (Failed) other;
                return kotlin.jvm.internal.p.d(this.assetId, failed.assetId) && kotlin.jvm.internal.p.d(this.message, failed.message) && this.isNetworkError == failed.isNetworkError;
            }

            public int hashCode() {
                return (((this.assetId.hashCode() * 31) + this.message.hashCode()) * 31) + Boolean.hashCode(this.isNetworkError);
            }

            public String toString() {
                return "Failed(assetId=" + this.assetId + ", message=" + this.message + ", isNetworkError=" + this.isNetworkError + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a$b;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a;", "", "assetId", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$a$b, reason: from toString */
        public static final /* data */ class InstallSucceeded implements a {
            private final String assetId;

            public InstallSucceeded(String assetId) {
                kotlin.jvm.internal.p.i(assetId, "assetId");
                this.assetId = assetId;
            }

            /* renamed from: a, reason: from getter */
            public final String getAssetId() {
                return this.assetId;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InstallSucceeded) && kotlin.jvm.internal.p.d(this.assetId, ((InstallSucceeded) other).assetId);
            }

            public int hashCode() {
                return this.assetId.hashCode();
            }

            public String toString() {
                return "InstallSucceeded(assetId=" + this.assetId + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a$c;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a;", "", "assetId", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAssetId", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$a$c, reason: from toString */
        public static final /* data */ class UninstallSucceeded implements a {
            private final String assetId;

            public UninstallSucceeded(String assetId) {
                kotlin.jvm.internal.p.i(assetId, "assetId");
                this.assetId = assetId;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UninstallSucceeded) && kotlin.jvm.internal.p.d(this.assetId, ((UninstallSucceeded) other).assetId);
            }

            public int hashCode() {
                return this.assetId.hashCode();
            }

            public String toString() {
                return "UninstallSucceeded(assetId=" + this.assetId + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a$d;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketOperaManager$a;", "", "assetId", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$a$d, reason: from toString */
        public static final /* data */ class UpdateSucceeded implements a {
            private final String assetId;

            public UpdateSucceeded(String assetId) {
                kotlin.jvm.internal.p.i(assetId, "assetId");
                this.assetId = assetId;
            }

            /* renamed from: a, reason: from getter */
            public final String getAssetId() {
                return this.assetId;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateSucceeded) && kotlin.jvm.internal.p.d(this.assetId, ((UpdateSucceeded) other).assetId);
            }

            public int hashCode() {
                return this.assetId.hashCode();
            }

            public String toString() {
                return "UpdateSucceeded(assetId=" + this.assetId + ")";
            }
        }
    }

    static {
        Xa.k<Map<String, AgentMarketStatus>> kVarA = Xa.u.a(kotlin.collections.a.i());
        _statusTable = kVarA;
        statusTable = Xa.d.c(kVarA);
        testingAssetIds = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.market.v0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentMarketOperaManager.S();
            }
        });
        Xa.k<Map<String, Integer>> kVarA2 = Xa.u.a(kotlin.collections.a.i());
        _progressTable = kVarA2;
        progressTable = Xa.d.c(kVarA2);
        progressJobs = new HashMap<>();
        Xa.j<a> jVarB = Xa.p.b(0, 8, null, 5, null);
        _events = jVarB;
        events = Xa.d.b(jVarB);
        pendingInstallCallbacks = new HashMap<>();
    }

    public static final Set S() {
        return Z8.F.q1(U0.INSTANCE.a());
    }

    public final boolean A(Throwable th) {
        if (!B()) {
            return true;
        }
        while (th != null) {
            if ((th instanceof UnknownHostException) || (th instanceof ConnectException) || (th instanceof SocketTimeoutException) || (th instanceof InterruptedIOException)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public final boolean B() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(com.stepos.ailauncher.common.utils.I.INSTANCE.b(C3197a.INSTANCE.a())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.TRUE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean C() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(com.stepos.ailauncher.common.utils.I.INSTANCE.a(C3197a.INSTANCE.a())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.TRUE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean D(String assetId) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        return x().contains(assetId);
    }

    public final AgentMarketStatus E(GetAgentStatusData data) {
        return AgentMarketStatus.INSTANCE.a(data.getStatus(), data.getEnabled());
    }

    public final void F(String assetId) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        if (La.H.x0(assetId)) {
            return;
        }
        M(assetId, AgentMarketStatus.NOT_INSTALLED);
        r(assetId);
        x().remove(assetId);
        U0.INSTANCE.g(assetId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x01c0, code lost:
    
        if (Ua.U.a(2000, r2) == r3) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01c4, code lost:
    
        r5 = r15;
        r15 = r8;
        r8 = r5;
        r5 = r14;
        r14 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0259, code lost:
    
        if (Ua.U.a(2000, r2) == r3) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x04bb -> B:107:0x04bd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x01c9 -> B:108:0x04c5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(com.stepos.ailauncher.agent.aispace.market.AgentMarketItem r25, java.lang.String r26, e9.InterfaceC4014c<? super Y8.t> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager.G(com.stepos.ailauncher.agent.aispace.market.AgentMarketItem, java.lang.String, e9.c):java.lang.Object");
    }

    public final String H(GetInstallProgressData p10) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("task_id", p10.getTaskId());
        jSONObject.put("status", p10.getStatus());
        jSONObject.put("total_steps", p10.getTotalSteps());
        jSONObject.put("current_step", p10.getCurrentStep());
        jSONObject.put("completed_steps", p10.getCompletedSteps());
        jSONObject.put("error_message", p10.getErrorMessage());
        String string = jSONObject.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public final int I(String assetId) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        Integer num = _progressTable.getValue().get(assetId);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(com.stepos.ailauncher.agent.aispace.market.AgentMarketItem r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$reconcileFromServer$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$reconcileFromServer$1 r0 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$reconcileFromServer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$reconcileFromServer$1 r0 = new com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$reconcileFromServer$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.L$0
            com.stepos.ailauncher.agent.aispace.market.AgentMarketItem r7 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketItem) r7
            kotlin.C4849c.b(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.getValue()
            goto L4f
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.C4849c.b(r8)
            com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository r8 = com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository.INSTANCE
            java.lang.String r2 = r7.getAssetId()
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r8.p(r2, r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            boolean r0 = kotlin.Result.g(r8)
            r1 = 0
            if (r0 == 0) goto L57
            r8 = r1
        L57:
            com.stepos.ailauncher.agent.aispace.market.data.l r8 = (com.stepos.ailauncher.agent.aispace.market.data.GetAgentStatusData) r8
            com.stepos.ailauncher.agent.aispace.market.j r0 = com.stepos.ailauncher.agent.aispace.market.C2277j.INSTANCE
            if (r8 == 0) goto L62
            java.lang.String r2 = r8.getStatus()
            goto L63
        L62:
            r2 = r1
        L63:
            if (r8 == 0) goto L6e
            boolean r3 = r8.getEnabled()
            java.lang.Boolean r3 = g9.C4109a.a(r3)
            goto L6f
        L6e:
            r3 = r1
        L6f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "reconcile §3.4 返回 status="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " enabled="
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            r3 = 2
            com.stepos.ailauncher.agent.aispace.market.C2277j.b(r0, r2, r1, r3, r1)
            java.lang.String r7 = r7.getAssetId()
            if (r8 == 0) goto L9b
            com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager r0 = com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager.INSTANCE
            com.stepos.ailauncher.agent.aispace.market.AgentMarketStatus r8 = r0.E(r8)
            if (r8 != 0) goto L9d
        L9b:
            com.stepos.ailauncher.agent.aispace.market.AgentMarketStatus r8 = com.stepos.ailauncher.agent.aispace.market.AgentMarketStatus.INSTALLED_ENABLED
        L9d:
            r6.M(r7, r8)
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager.J(com.stepos.ailauncher.agent.aispace.market.AgentMarketItem, e9.c):java.lang.Object");
    }

    public final void K(AgentMarketItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        C1060i.d(scope, null, null, new AgentMarketOperaManager$refreshStatus$1(item, null), 3, null);
    }

    public final void L(List<AgentMarketItem> items) {
        Map<String, AgentMarketStatus> value;
        Map<String, AgentMarketStatus> mapC;
        kotlin.jvm.internal.p.i(items, "items");
        com.stepos.ailauncher.chat.wake.L l10 = com.stepos.ailauncher.chat.wake.L.INSTANCE;
        List<AgentMarketItem> list = items;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
        for (AgentMarketItem agentMarketItem : list) {
            Pair pairA = Y8.j.a(agentMarketItem.getAssetId(), agentMarketItem.getDisplayName());
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        l10.d(linkedHashMap);
        Xa.k<Map<String, AgentMarketStatus>> kVar = _statusTable;
        do {
            value = kVar.getValue();
            mapC = kotlin.collections.a.C(value);
            for (AgentMarketItem agentMarketItem2 : list) {
                AgentMarketStatus agentMarketStatus = mapC.get(agentMarketItem2.getAssetId());
                if (agentMarketStatus == null || !agentMarketStatus.isInFlight()) {
                    mapC.put(agentMarketItem2.getAssetId(), agentMarketItem2.getInitialStatus());
                }
            }
        } while (!kVar.d(value, mapC));
    }

    public final void M(String assetId, AgentMarketStatus status) {
        Map<String, AgentMarketStatus> value;
        Xa.k<Map<String, AgentMarketStatus>> kVar = _statusTable;
        do {
            value = kVar.getValue();
        } while (!kVar.d(value, kotlin.collections.a.s(value, Y8.j.a(assetId, status))));
    }

    public final void N(AgentMarketItem item, boolean enabled) {
        kotlin.jvm.internal.p.i(item, "item");
        AgentMarketStatus initialStatus = _statusTable.getValue().get(item.getAssetId());
        if (initialStatus == null) {
            initialStatus = item.getInitialStatus();
        }
        if (initialStatus.isInstalled()) {
            if (!B()) {
                _events.a(new a.Failed(item.getAssetId(), "", true));
                return;
            }
            M(item.getAssetId(), enabled ? AgentMarketStatus.INSTALLED_ENABLED : AgentMarketStatus.INSTALLED_DISABLED);
            C2277j.b(C2277j.INSTANCE, "SetAgentEnabled 触发 asset_id=" + item.getAssetId() + " enabled=" + enabled, null, 2, null);
            C1060i.d(scope, null, null, new AgentMarketOperaManager$setEnabled$1(item, enabled, null), 3, null);
        }
    }

    public final void O(String assetId, int pct) {
        Map<String, Integer> value;
        Xa.k<Map<String, Integer>> kVar = _progressTable;
        do {
            value = kVar.getValue();
        } while (!kVar.d(value, kotlin.collections.a.s(value, Y8.j.a(assetId, Integer.valueOf(pct)))));
    }

    public final void P(String assetId) {
        HashMap<String, kotlinx.coroutines.g> map = progressJobs;
        kotlinx.coroutines.g gVarRemove = map.remove(assetId);
        if (gVarRemove != null) {
            kotlinx.coroutines.g.Y0(gVarRemove, null, 1, null);
        }
        O(assetId, 0);
        map.put(assetId, C1060i.d(scope, null, null, new AgentMarketOperaManager$startProgress$1(assetId, null), 3, null));
    }

    public final AgentMarketStatus Q(String assetId, AgentMarketStatus fallback) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(fallback, "fallback");
        AgentMarketStatus agentMarketStatus = _statusTable.getValue().get(assetId);
        return agentMarketStatus == null ? fallback : agentMarketStatus;
    }

    public final void R(String assetId, Integer finalPct) {
        kotlinx.coroutines.g gVarRemove = progressJobs.remove(assetId);
        if (gVarRemove != null) {
            kotlinx.coroutines.g.Y0(gVarRemove, null, 1, null);
        }
        if (finalPct != null) {
            O(assetId, finalPct.intValue());
        } else {
            r(assetId);
        }
    }

    public final void T(boolean success) {
        Toast.makeText(C3197a.INSTANCE.a(), success ? R$string.store_install_success_toast : R$string.store_install_failed_toast, 0).show();
    }

    public final void U(AgentMarketItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        AgentMarketStatus initialStatus = _statusTable.getValue().get(item.getAssetId());
        if (initialStatus == null) {
            initialStatus = item.getInitialStatus();
        }
        if (initialStatus.isInstalled()) {
            if (!B()) {
                _events.a(new a.Failed(item.getAssetId(), "", true));
                return;
            }
            M(item.getAssetId(), AgentMarketStatus.UNINSTALLING);
            C2277j.b(C2277j.INSTANCE, "uninstall 触发 display_name=[" + item.getDisplayName() + "] asset_id=" + item.getAssetId(), null, 2, null);
            C1060i.d(scope, null, null, new AgentMarketOperaManager$uninstall$1(item, null), 3, null);
        }
    }

    public final void V(AgentMarketItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        AgentMarketStatus initialStatus = _statusTable.getValue().get(item.getAssetId());
        if (initialStatus == null) {
            initialStatus = item.getInitialStatus();
        }
        if (initialStatus.isInFlight() || !initialStatus.isInstalled()) {
            return;
        }
        if (!B()) {
            _events.a(new a.Failed(item.getAssetId(), "", true));
            return;
        }
        M(item.getAssetId(), AgentMarketStatus.UPDATING);
        P(item.getAssetId());
        C2277j.b(C2277j.INSTANCE, "update 触发 display_name=[" + item.getDisplayName() + "] asset_id=" + item.getAssetId() + " reversion_id=" + item.getReversionId() + " semver=" + item.getVersion() + " testing=" + item.getTesting(), null, 2, null);
        C1060i.d(scope, null, null, new AgentMarketOperaManager$update$1(item, null), 3, null);
    }

    public final void W(String assetId, String reversionId, String semver, String displayName, InterfaceC5074l<? super Boolean, Y8.t> onDone) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(semver, "semver");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(onDone, "onDone");
        pendingInstallCallbacks.put(assetId, onDone);
        AgentMarketStatus agentMarketStatus = _statusTable.getValue().get(assetId);
        if (agentMarketStatus == null || !agentMarketStatus.isInstalled()) {
            M(assetId, AgentMarketStatus.INSTALLED_ENABLED);
        }
        V(new AgentMarketItem(assetId, reversionId, semver, displayName, "", "", 0L, "", true, AgentMarketStatus.INSTALLED_ENABLED, null, false, null, 7168, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X(com.stepos.ailauncher.agent.aispace.market.AgentMarketItem r6, e9.InterfaceC4014c<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$verifyUpdatedVersion$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$verifyUpdatedVersion$1 r0 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$verifyUpdatedVersion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$verifyUpdatedVersion$1 r0 = new com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$verifyUpdatedVersion$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r5 = r0.L$1
            com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager r5 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager) r5
            java.lang.Object r5 = r0.L$0
            r6 = r5
            com.stepos.ailauncher.agent.aispace.market.AgentMarketItem r6 = (com.stepos.ailauncher.agent.aispace.market.AgentMarketItem) r6
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L39
            kotlin.Result r7 = (kotlin.Result) r7     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = r7.getValue()     // Catch: java.lang.Throwable -> L39
            goto L5f
        L39:
            r5 = move-exception
            goto Lb4
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.C4849c.b(r7)
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L39
            com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository r7 = com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository.INSTANCE     // Catch: java.lang.Throwable -> L39
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L39
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L39
            r5 = 0
            r0.I$0 = r5     // Catch: java.lang.Throwable -> L39
            r0.label = r3     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = r7.H(r0)     // Catch: java.lang.Throwable -> L39
            if (r5 != r1) goto L5f
            return r1
        L5f:
            boolean r7 = kotlin.Result.g(r5)     // Catch: java.lang.Throwable -> L39
            if (r7 == 0) goto L66
            r5 = r4
        L66:
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto Lae
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L39
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L39
        L70:
            boolean r7 = r5.hasNext()     // Catch: java.lang.Throwable -> L39
            if (r7 == 0) goto L92
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L39
            r0 = r7
            com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent r0 = (com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.SidebarAgent) r0     // Catch: java.lang.Throwable -> L39
            boolean r1 = r0.getInstalled()     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L70
            java.lang.String r0 = r0.getAssetId()     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = r6.getAssetId()     // Catch: java.lang.Throwable -> L39
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)     // Catch: java.lang.Throwable -> L39
            if (r0 == 0) goto L70
            goto L93
        L92:
            r7 = r4
        L93:
            com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService$SidebarAgent r7 = (com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.SidebarAgent) r7     // Catch: java.lang.Throwable -> L39
            if (r7 == 0) goto Lae
            java.lang.String r5 = r7.getSemver()     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto Lae
            java.lang.CharSequence r5 = La.H.D1(r5)     // Catch: java.lang.Throwable -> L39
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto Lae
            int r6 = r5.length()     // Catch: java.lang.Throwable -> L39
            if (r6 <= 0) goto Lae
            goto Laf
        Lae:
            r5 = r4
        Laf:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L39
            goto Lbe
        Lb4:
            kotlin.Result$a r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        Lbe:
            boolean r6 = kotlin.Result.g(r5)
            if (r6 == 0) goto Lc5
            goto Lc6
        Lc5:
            r4 = r5
        Lc6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager.X(com.stepos.ailauncher.agent.aispace.market.AgentMarketItem, e9.c):java.lang.Object");
    }

    public final void r(String assetId) {
        Map<String, Integer> value;
        Xa.k<Map<String, Integer>> kVar = _progressTable;
        do {
            value = kVar.getValue();
        } while (!kVar.d(value, kotlin.collections.a.o(value, assetId)));
    }

    public final void s(AgentMarketItem item, String installType, String message) {
        if (!kotlin.jvm.internal.p.d(installType, "uninstall")) {
            R(item.getAssetId(), null);
        }
        M(item.getAssetId(), kotlin.jvm.internal.p.d(installType, W4.b.STEP_INSTALL) ? AgentMarketStatus.INSTALL_FAILED : AgentMarketStatus.INSTALLED_ENABLED);
        _events.a(new a.Failed(item.getAssetId(), message, !B()));
        int iHashCode = installType.hashCode();
        if (iHashCode != -838846263) {
            if (iHashCode != -625596190) {
                if (iHashCode == 1957569947 && installType.equals(W4.b.STEP_INSTALL)) {
                    W4.a.INSTANCE.e(item.getAssetId(), item.getVersion(), false, message);
                }
            } else if (installType.equals("uninstall")) {
                W4.a.INSTANCE.i(item.getAssetId(), false, W4.a.SOURCE_DETAIL, null, message);
            }
        } else if (installType.equals(com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE)) {
            W4.a.INSTANCE.k(item.getAssetId(), item.getInstallVersion(), item.getVersion(), false, message);
        }
        if (kotlin.jvm.internal.p.d(installType, W4.b.STEP_INSTALL)) {
            T(false);
        }
        if (kotlin.jvm.internal.p.d(installType, W4.b.STEP_INSTALL) || kotlin.jvm.internal.p.d(installType, com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE)) {
            t(item.getAssetId(), false);
        }
    }

    public final void t(String assetId, boolean ok) {
        InterfaceC5074l<Boolean, Y8.t> interfaceC5074lRemove = pendingInstallCallbacks.remove(assetId);
        if (interfaceC5074lRemove != null) {
            interfaceC5074lRemove.invoke(Boolean.valueOf(ok));
        }
    }

    public final Xa.o<a> u() {
        return events;
    }

    public final Xa.t<Map<String, Integer>> v() {
        return progressTable;
    }

    public final Xa.t<Map<String, AgentMarketStatus>> w() {
        return statusTable;
    }

    public final Set<String> x() {
        return (Set) testingAssetIds.getValue();
    }

    public final void y(AgentMarketItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        AgentMarketStatus initialStatus = _statusTable.getValue().get(item.getAssetId());
        if (initialStatus == null) {
            initialStatus = item.getInitialStatus();
        }
        if (initialStatus.isInFlight() || initialStatus.isInstalled()) {
            return;
        }
        if (item.getTesting()) {
            x().add(item.getAssetId());
            U0.INSTANCE.e(item.getAssetId(), item.getDisplayName(), item.getDescription(), item.getIconUrl(), item.getVersion(), item.getInstallVersion());
        }
        if (!B()) {
            _events.a(new a.Failed(item.getAssetId(), "", true));
            T(false);
            t(item.getAssetId(), false);
            return;
        }
        M(item.getAssetId(), AgentMarketStatus.INSTALLING);
        P(item.getAssetId());
        C2277j.b(C2277j.INSTANCE, "install 触发 display_name=[" + item.getDisplayName() + "] asset_id=" + item.getAssetId() + " reversion_id=" + item.getReversionId() + " semver=" + item.getVersion() + " testing=" + item.getTesting(), null, 2, null);
        C1060i.d(scope, null, null, new AgentMarketOperaManager$install$1(item, null), 3, null);
    }

    public final void z(String assetId, String reversionId, String semver, String displayName, InterfaceC5074l<? super Boolean, Y8.t> onDone) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(semver, "semver");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(onDone, "onDone");
        pendingInstallCallbacks.put(assetId, onDone);
        AgentMarketStatus agentMarketStatus = _statusTable.getValue().get(assetId);
        if (agentMarketStatus != null && agentMarketStatus.isInstalled()) {
            M(assetId, AgentMarketStatus.NOT_INSTALLED);
        }
        y(new AgentMarketItem(assetId, reversionId, semver, displayName, "", "", 0L, "", false, AgentMarketStatus.NOT_INSTALLED, null, false, null, 7168, null));
    }
}
