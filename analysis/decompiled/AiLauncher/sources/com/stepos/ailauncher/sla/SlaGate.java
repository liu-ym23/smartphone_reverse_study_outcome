package com.stepos.ailauncher.sla;

import Ua.C1060i;
import Ua.L0;
import Ua.Y;
import Z8.C1173v;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.aiengine.algorithm.sla.SlaAlternative;
import com.stepos.aiengine.algorithm.sla.SlaDecision;
import com.stepos.aiengine.algorithm.sla.SlaExecution;
import com.stepos.aiengine.algorithm.sla.SlaListener;
import com.stepos.aiengine.algorithm.sla.SlaRejectReason;
import com.stepos.aiengine.algorithm.sla.SlaResult;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.sla.SlaAtomicDispatcher;
import com.stepos.ailauncher.sla.SlaGate;
import com.stepos.ailauncher.sla.SlaRouter;
import com.stepos.ailauncher.sla.SlaVoiceBridge;
import com.stepos.ailauncher.sla.x;
import com.stepos.core.download.ModelFlowMeta;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 G2\u00020\u0001:\u0007HIJKLMNBc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J?\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u001a¢\u0006\u0004\b \u0010\u001fJ\r\u0010!\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u0014J+\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006¢\u0006\u0004\b\"\u0010#J=\u0010*\u001a\b\u0018\u00010)R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00072 \u0010(\u001a\u001c\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010'0$¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b,\u0010-JH\u0010/\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b/\u00100J \u00104\u001a\u0004\u0018\u0001032\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000701H\u0082@¢\u0006\u0004\b4\u00105J \u00106\u001a\u0004\u0018\u0001032\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000701H\u0082@¢\u0006\u0004\b6\u00105J7\u00108\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0004\b8\u00109J!\u0010=\u001a\u00020<2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010;\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0007H\u0002¢\u0006\u0004\b?\u0010\u0014J\u000f\u0010@\u001a\u00020\u0007H\u0002¢\u0006\u0004\b@\u0010\u0014J\u000f\u0010A\u001a\u00020\u001aH\u0002¢\u0006\u0004\bA\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010BR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010CR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010DR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010DR\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010ER\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00106R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010F¨\u0006O"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaGate;", "", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/sla/SlaGate$d;", "callbacks", "Lkotlin/Function0;", "", "sessionIdProvider", "traceIdFactory", "Lkotlin/Function1;", "", "conversationRoundProvider", "", "bufferMs", "LUa/M;", "scope", "<init>", "(Landroid/content/Context;Lcom/stepos/ailauncher/sla/SlaGate$d;Lp9/a;Lp9/a;Lp9/l;JLUa/M;)V", "H", "()Ljava/lang/String;", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "decision", DidiCardProvider.KEY_TRACE_ID, "sessionId", "query", "LY8/t;", "proceed", ExifInterface.LONGITUDE_EAST, "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/a;)V", "I", "()V", "Q", "M", "N", "(Ljava/lang/String;Ljava/lang/String;Lp9/a;)V", "Lkotlin/Function3;", "Lcom/stepos/aiengine/algorithm/sla/SlaListener;", "", "Lcom/stepos/ailauncher/sla/SlaRouter$a;", "audioStart", "Lcom/stepos/ailauncher/sla/SlaGate$e;", "B", "(Ljava/lang/String;Lp9/q;)Lcom/stepos/ailauncher/sla/SlaGate$e;", "G", "(Ljava/lang/String;)Ljava/lang/Integer;", "function", "R", "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/a;Le9/c;)Ljava/lang/Object;", "", "functions", "Lcom/stepos/ability/bean/SlaPermissionResult;", "F", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "J", "reason", "P", "(Lp9/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", "dr", "Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "D", "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;)Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "K", "L", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Context;", "Lcom/stepos/ailauncher/sla/SlaGate$d;", "Lp9/a;", "Lp9/l;", "LUa/M;", "Companion", "Winner", "CancelReason", "e", "Race", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_PKGNAME, "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlaGate {
    private static final int CANCELLED = -1003;
    private static final int EXECUTION_TIMEOUT = -1004;
    private static final long EXECUTION_TIMEOUT_BASE_MS = 31000;
    private static final String KEY_SESSION_ID = "session_id";
    public static final String KEY_SLA_ACTIONS = "slaActions";
    private static final long LATE_ASR_GRACE_MS = 600;
    private static final long LEDGER_CHECK_RETRY_MS = 250;
    public static final String TAG = "SLA";
    private static final int TIMEOUT = -1001;
    private static final int UNAVAILABLE = -1002;
    private static volatile SlaDecision cachedDecisionForUnlock;
    private static volatile InterfaceC5063a<Y8.t> cachedProceedForUnlock;
    private final long bufferMs;
    private final d callbacks;
    private final Context context;
    private final InterfaceC5074l<String, Integer> conversationRoundProvider;
    private final Ua.M scope;
    private final InterfaceC5063a<String> sessionIdProvider;
    private final InterfaceC5063a<String> traceIdFactory;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile String cachedTraceIdForUnlock = "";
    private static volatile String cachedSessionIdForUnlock = "";
    private static volatile String cachedQueryForUnlock = "";
    private static final Object unlockCacheLock = new Object();
    private static final AtomicInteger raceSeq = new AtomicInteger(0);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaGate$CancelReason;", "", "<init>", "(Ljava/lang/String;I)V", "ROUND_ENDED", "SUPERSEDED", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CancelReason {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ CancelReason[] $VALUES;
        public static final CancelReason ROUND_ENDED = new CancelReason("ROUND_ENDED", 0);
        public static final CancelReason SUPERSEDED = new CancelReason("SUPERSEDED", 1);

        private static final /* synthetic */ CancelReason[] $values() {
            return new CancelReason[]{ROUND_ENDED, SUPERSEDED};
        }

        static {
            CancelReason[] cancelReasonArr$values = $values();
            $VALUES = cancelReasonArr$values;
            $ENTRIES = kotlin.enums.a.a(cancelReasonArr$values);
        }

        private CancelReason(String str, int i10) {
        }

        public static InterfaceC4149a<CancelReason> getEntries() {
            return $ENTRIES;
        }

        public static CancelReason valueOf(String str) {
            return (CancelReason) Enum.valueOf(CancelReason.class, str);
        }

        public static CancelReason[] values() {
            return (CancelReason[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0005*\u0002\u0082\u0001\b\u0086\u0004\u0018\u00002\u00020\u0001B5\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u0016\u0010\u0015J#\u0010\u001b\u001a\u00020\u00032\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0000¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0000¢\u0006\u0004\b)\u0010\u000fJ\u0017\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0005H\u0000¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0003¢\u0006\u0004\b-\u0010(J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u0010(J\u000f\u00102\u001a\u00020\u0003H\u0002¢\u0006\u0004\b2\u0010(J\u000f\u00103\u001a\u00020\u0003H\u0002¢\u0006\u0004\b3\u0010(J\u000f\u00104\u001a\u00020\u0003H\u0002¢\u0006\u0004\b4\u0010(J+\u0010:\u001a\u00020\u00032\u0006\u00106\u001a\u0002052\b\b\u0002\u00108\u001a\u0002072\b\b\u0002\u00109\u001a\u00020\bH\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u00032\u0006\u0010<\u001a\u000207H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00032\u0006\u0010<\u001a\u000207H\u0002¢\u0006\u0004\b?\u0010>J\u0017\u0010B\u001a\u00020\u00032\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ-\u0010J\u001a\u00020@2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010G\u001a\u00020\u00052\u0006\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\bJ\u0010KJ\u001d\u0010L\u001a\u00020\u00052\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0DH\u0002¢\u0006\u0004\bL\u0010MJG\u0010R\u001a\u00020\u00052\u0006\u00106\u001a\u0002052\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020H2\u0006\u0010I\u001a\u00020H2\u000e\b\u0002\u0010F\u001a\b\u0012\u0004\u0012\u00020E0DH\u0002¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0003H\u0002¢\u0006\u0004\bT\u0010(J\u0017\u0010V\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\u0019H\u0002¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\u0005H\u0002¢\u0006\u0004\bY\u0010\u001fJ\u0017\u0010Z\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\bZ\u0010\u001fJ\u001d\u0010\\\u001a\u00020\u00032\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\\\u0010\"R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010]R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010^R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010_R\u0014\u0010`\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010)R\u0014\u0010a\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010\u001eR\u0016\u0010b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010^R\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u001e\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010]R\u0018\u0010i\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010gR\u001e\u0010l\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010]R\"\u0010p\u001a\u0010\u0012\f\u0012\n o*\u0004\u0018\u00010n0n0m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010r\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010eR\u0014\u0010s\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010eR\u0014\u0010t\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010eR\u0014\u0010u\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010eR\u001c\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010qR\u0018\u0010w\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010^R\u0018\u0010y\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010{\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010_R\u0018\u0010|\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010_R\u0016\u0010\u007f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010_R\u001a\u0010\u0080\u0001\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010zR\u0016\u0010\u0081\u0001\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010eR\u0018\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0015\u0010\u0085\u0001\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\r¨\u0006\u0086\u0001"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaGate$Race;", "", "Lkotlin/Function0;", "LY8/t;", "proceed", "", "seedSessionId", DidiCardProvider.KEY_TRACE_ID, "", "localDispatch", "<init>", "(Lcom/stepos/ailauncher/sla/SlaGate;Lp9/a;Ljava/lang/String;Ljava/lang/String;Z)V", "g0", "()Ljava/lang/String;", "a0", "()Z", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$VoiceSendBind;", "n0", "()Lcom/stepos/ailauncher/sla/SlaVoiceBridge$VoiceSendBind;", "onSettled", "o0", "(Lp9/a;)Z", "p0", "Lkotlin/Function1;", "Lcom/stepos/aiengine/algorithm/sla/SlaListener;", "Lcom/stepos/ailauncher/sla/SlaRouter$a;", "starter", "j0", "(Lp9/l;)V", "q", "J", "(Ljava/lang/String;)V", "p", "G", "(Lp9/a;)V", "Lcom/stepos/ailauncher/sla/SlaGate$CancelReason;", "reason", "O", "(Lcom/stepos/ailauncher/sla/SlaGate$CancelReason;)V", "l0", "()V", "I", "text", "K", "(Ljava/lang/String;)Z", "h0", "staysLocal", "d0", "(Z)V", "e0", "f0", "P", "k0", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "decision", "", "actionCount", "awaitLedger", "q0", "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;IZ)V", "errorCode", "m0", "(I)V", ExifInterface.LATITUDE_SOUTH, "Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "result", "R", "(Lcom/stepos/aiengine/algorithm/sla/SlaResult;)V", "", "Lcom/stepos/ailauncher/sla/SlaGate$b;", "outcomes", "rawOutput", "", "modelInferMs", "N", "(Ljava/util/List;Ljava/lang/String;J)Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "L", "(Ljava/util/List;)Ljava/lang/String;", "Lcom/stepos/aiengine/algorithm/sla/SlaExecution;", "execution", "asrText", "totalElapsedMs", "M", "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;Lcom/stepos/aiengine/algorithm/sla/SlaExecution;Ljava/lang/String;JJLjava/util/List;)Ljava/lang/String;", "U", "newSession", "H", "(Lcom/stepos/ailauncher/sla/SlaRouter$a;)V", "callback", "b0", "Q", "block", "c0", "Lp9/a;", "Ljava/lang/String;", "Z", "id", "startedAtMs", "resolvedSessionId", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ledgerPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ledgerWaitLock", "Ljava/lang/Object;", "ledgerWaiter", "localExecStaysLocal", "Ljava/lang/Boolean;", "execWaitLock", "execWaiter", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/stepos/ailauncher/sla/SlaGate$Winner;", "kotlin.jvm.PlatformType", "winner", "Ljava/util/concurrent/atomic/AtomicReference;", "backendRouted", "resultDelivered", "localOutputHandled", "sdkTerminalCallbackReceived", "session", "query", "Lkotlinx/coroutines/g;", "timerJob", "Lkotlinx/coroutines/g;", "pendingBackend", "pendingResult", "Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "pendingRouteBackend", "cancelledAfterSlaWin", "lateAsrGraceJob", "resultDispatchedToHost", "com/stepos/ailauncher/sla/SlaGate$Race$listener$1", "listener", "Lcom/stepos/ailauncher/sla/SlaGate$Race$listener$1;", "sessionId", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class Race {
        private final AtomicBoolean backendRouted;
        private volatile boolean cancelledAfterSlaWin;
        private final Object execWaitLock;
        private InterfaceC5063a<Y8.t> execWaiter;
        private final int id;
        private volatile kotlinx.coroutines.g lateAsrGraceJob;
        private final AtomicBoolean ledgerPending;
        private final Object ledgerWaitLock;
        private InterfaceC5063a<Y8.t> ledgerWaiter;
        private final SlaGate$Race$listener$1 listener;
        private final boolean localDispatch;
        private volatile Boolean localExecStaysLocal;
        private final AtomicBoolean localOutputHandled;
        private volatile boolean pendingBackend;
        private volatile SlaResult pendingResult;
        private volatile boolean pendingRouteBackend;
        private volatile InterfaceC5063a<Y8.t> proceed;
        private volatile String query;
        private volatile String resolvedSessionId;
        private final AtomicBoolean resultDelivered;
        private final AtomicBoolean resultDispatchedToHost;
        private final AtomicBoolean sdkTerminalCallbackReceived;
        private final AtomicReference<SlaRouter.a> session;
        private final long startedAtMs;
        final /* synthetic */ SlaGate this$0;
        private volatile kotlinx.coroutines.g timerJob;
        private final String traceId;
        private final AtomicReference<Winner> winner;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Winner.values().length];
                try {
                    iArr[Winner.PENDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Winner.SLA.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Winner.BACKEND.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Winner.CANCELLED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Race(SlaGate slaGate, InterfaceC5063a<Y8.t> interfaceC5063a, String seedSessionId, String traceId, boolean z10) {
            kotlin.jvm.internal.p.i(seedSessionId, "seedSessionId");
            kotlin.jvm.internal.p.i(traceId, "traceId");
            this.this$0 = slaGate;
            this.proceed = interfaceC5063a;
            this.traceId = traceId;
            this.localDispatch = z10;
            this.id = SlaGate.raceSeq.incrementAndGet();
            this.startedAtMs = SystemClock.elapsedRealtime();
            this.resolvedSessionId = seedSessionId;
            this.ledgerPending = new AtomicBoolean(false);
            this.ledgerWaitLock = new Object();
            this.execWaitLock = new Object();
            this.winner = new AtomicReference<>(Winner.PENDING);
            this.backendRouted = new AtomicBoolean(false);
            this.resultDelivered = new AtomicBoolean(false);
            this.localOutputHandled = new AtomicBoolean(false);
            this.sdkTerminalCallbackReceived = new AtomicBoolean(false);
            this.session = new AtomicReference<>(null);
            this.resultDispatchedToHost = new AtomicBoolean(false);
            this.listener = new SlaGate$Race$listener$1(this, slaGate);
        }

        public static final Y8.t T(SlaGate slaGate, Race race, int i10) {
            d dVar = slaGate.callbacks;
            String str = race.traceId;
            String str2 = race.query;
            if (str2 == null) {
                str2 = "";
            }
            dVar.b(str, str2, i10);
            return Y8.t.f7040a;
        }

        public static final Y8.t V(InterfaceC5063a interfaceC5063a) {
            interfaceC5063a.invoke();
            return Y8.t.f7040a;
        }

        public static final Y8.t W(final Race race, SlaResult slaResult, SlaGate slaGate, String str) {
            if (race.winner.get() == Winner.SLA) {
                int i10 = race.id;
                String str2 = race.traceId;
                String function = slaResult.getDecision().getFunction();
                if (function == null) {
                    function = "";
                }
                C4148a.k(SlaGate.TAG, "[LOCAL][ABILITY_CALLBACK] raceId=" + i10 + " traceId=" + str2 + " ability=" + function + " status=" + slaResult.getExecution().getStatus() + " errorCode=" + slaResult.getExecution().getErrorCode() + " totalMs=" + slaResult.getTotalElapsedMs() + " target=SlaUiCallbacks.onSlaResult", false, 4, null);
                slaGate.callbacks.f(race.traceId, str, slaResult, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.o
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return SlaGate.Race.X(this.f28321a);
                    }
                });
            }
            return Y8.t.f7040a;
        }

        public static final Y8.t X(Race race) {
            race.h0();
            return Y8.t.f7040a;
        }

        public static final Y8.t Y(InterfaceC5063a interfaceC5063a) {
            interfaceC5063a.invoke();
            return Y8.t.f7040a;
        }

        public static final Y8.t i0(InterfaceC5063a interfaceC5063a) {
            interfaceC5063a.invoke();
            return Y8.t.f7040a;
        }

        public static /* synthetic */ void r0(Race race, SlaDecision slaDecision, int i10, boolean z10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = 1;
            }
            if ((i11 & 4) != 0) {
                z10 = false;
            }
            race.q0(slaDecision, i10, z10);
        }

        public static final Y8.t s0(SlaGate slaGate, Race race, int i10, long j10) {
            slaGate.callbacks.g(race.traceId, i10, j10);
            return Y8.t.f7040a;
        }

        public final void G(InterfaceC5063a<Y8.t> p10) {
            boolean z10;
            kotlin.jvm.internal.p.i(p10, "p");
            this.proceed = p10;
            synchronized (SlaGate.unlockCacheLock) {
                if (SlaGate.cachedDecisionForUnlock != null && kotlin.jvm.internal.p.d(SlaGate.cachedTraceIdForUnlock, this.traceId) && SlaGate.cachedProceedForUnlock == null) {
                    SlaGate.cachedProceedForUnlock = p10;
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                C4148a.k(SlaGate.TAG, "[#" + this.id + "] attachProceed 回填锁屏缓存 proceed", false, 4, null);
            }
            U();
        }

        public final void H(SlaRouter.a newSession) {
            if (this.sdkTerminalCallbackReceived.get()) {
                C4148a.d(SlaGate.TAG, "[#" + this.id + "] recognize 返回时 SDK 已终态 -> 不保存/不 cancel session", false, 4, null);
                return;
            }
            this.session.set(newSession);
            if (this.sdkTerminalCallbackReceived.get()) {
                this.session.compareAndSet(newSession, null);
                C4148a.d(SlaGate.TAG, "[#" + this.id + "] SDK 终态与 session attach 竞态 -> 释放句柄且不 cancel", false, 4, null);
                return;
            }
            if (this.winner.get() == Winner.BACKEND || this.winner.get() == Winner.CANCELLED) {
                Q("winner=" + this.winner.get() + " before session attached");
            }
        }

        public final boolean I() {
            return this.winner.get() == Winner.SLA && this.query == null && !this.resultDispatchedToHost.get();
        }

        public final void J(String q10) {
            boolean z10;
            kotlin.jvm.internal.p.i(q10, "q");
            this.query = q10;
            synchronized (SlaGate.unlockCacheLock) {
                if (SlaGate.cachedDecisionForUnlock == null || !kotlin.jvm.internal.p.d(SlaGate.cachedTraceIdForUnlock, this.traceId) || SlaGate.cachedQueryForUnlock.length() != 0 || q10.length() <= 0) {
                    z10 = false;
                } else {
                    SlaGate.cachedQueryForUnlock = q10;
                    z10 = true;
                }
            }
            if (z10) {
                C4148a.k(SlaGate.TAG, "[#" + this.id + "] bind 回填锁屏缓存 query len=" + q10.length(), false, 4, null);
            }
            U();
        }

        public final synchronized boolean K(String text) {
            kotlin.jvm.internal.p.i(text, "text");
            boolean z10 = true;
            if (text.length() != 0 && I()) {
                C4148a.k(SlaGate.TAG, "[#" + this.id + "] 迟到 ASR 文案回填 traceId=" + this.traceId + " textLen=" + text.length(), false, 4, null);
                E5.a.a("[SLA][traceId=" + this.traceId + "] lateAsrBound textLen=" + text.length());
                J(text);
                return true;
            }
            int i10 = this.id;
            String str = this.traceId;
            Winner winner = this.winner.get();
            if (this.query == null) {
                z10 = false;
            }
            C4148a.k(SlaGate.TAG, "[#" + i10 + "] 迟到 ASR 文案无处可补 traceId=" + str + " winner=" + winner + " asrBound=" + z10 + " dispatched=" + this.resultDispatchedToHost.get() + " textLen=" + text.length(), false, 4, null);
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0011, B:9:0x0017, B:18:0x0036, B:21:0x003d, B:27:0x004c, B:28:0x0058, B:30:0x005e, B:32:0x009f, B:34:0x00a5, B:36:0x00b0, B:38:0x00b6, B:40:0x00c1, B:42:0x00c8, B:44:0x00d1, B:49:0x00dd, B:56:0x00ff, B:58:0x0105, B:59:0x0108, B:61:0x0111, B:55:0x00f5, B:60:0x010c, B:62:0x0116, B:17:0x002c, B:26:0x0046, B:52:0x00e4, B:14:0x0021), top: B:78:0x0001, inners: #1, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x005e A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0011, B:9:0x0017, B:18:0x0036, B:21:0x003d, B:27:0x004c, B:28:0x0058, B:30:0x005e, B:32:0x009f, B:34:0x00a5, B:36:0x00b0, B:38:0x00b6, B:40:0x00c1, B:42:0x00c8, B:44:0x00d1, B:49:0x00dd, B:56:0x00ff, B:58:0x0105, B:59:0x0108, B:61:0x0111, B:55:0x00f5, B:60:0x010c, B:62:0x0116, B:17:0x002c, B:26:0x0046, B:52:0x00e4, B:14:0x0021), top: B:78:0x0001, inners: #1, #2 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String L(java.util.List<com.stepos.ailauncher.sla.SlaGate.ActionOutcome> r10) {
            /*
                Method dump skipped, instructions count: 377
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaGate.Race.L(java.util.List):java.lang.String");
        }

        public final String M(SlaDecision decision, SlaExecution execution, String asrText, long totalElapsedMs, long modelInferMs, List<ActionOutcome> outcomes) throws JSONException {
            Object objB;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", "v1");
            jSONObject.put("phase", "execution");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("function", decision.getFunction());
            jSONObject2.put("text", decision.getText());
            jSONObject2.put("params", new JSONObject(decision.getParams()));
            jSONObject2.putOpt("priority", decision.getPriority());
            jSONObject2.put("confidence", decision.getConfidence());
            JSONArray jSONArray = new JSONArray();
            for (SlaAlternative slaAlternative : decision.getAlternatives()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("function", slaAlternative.getFunction());
                jSONObject3.put("text", slaAlternative.getText());
                jSONObject3.put("params", new JSONObject(slaAlternative.getParams()));
                jSONObject3.put("confidence", slaAlternative.getConfidence());
                jSONArray.put(jSONObject3);
            }
            Y8.t tVar = Y8.t.f7040a;
            jSONObject2.put("alternatives", jSONArray);
            SlaRejectReason rejectReason = decision.getRejectReason();
            jSONObject2.putOpt("rejectReason", rejectReason != null ? rejectReason.name() : null);
            jSONObject.put("decision", jSONObject2);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("dispatched", execution.getDispatched());
            jSONObject4.put("executor", execution.getExecutor());
            jSONObject4.put("status", execution.getStatus().name());
            jSONObject4.put("errorCode", execution.getErrorCode());
            jSONObject4.putOpt(C3081a.ERROR_MSG, execution.getErrorMsg());
            String resultJson = execution.getResultJson();
            if (resultJson != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(jSONObject4.put("result", new JSONObject(resultJson)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.e(objB) != null) {
                    jSONObject4.put("result", resultJson);
                }
                Result.a(objB);
            }
            jSONObject4.put("elapsedMs", execution.getElapsedMs());
            Y8.t tVar2 = Y8.t.f7040a;
            jSONObject.put("execution", jSONObject4);
            if (!La.H.x0(asrText)) {
                jSONObject.put("asrText", asrText);
            }
            jSONObject.put("totalElapsedMs", totalElapsedMs);
            jSONObject.put("modelInferMs", modelInferMs);
            if (outcomes.size() > 1) {
                JSONArray jSONArray2 = new JSONArray();
                for (ActionOutcome actionOutcome : outcomes) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.putOpt("function", actionOutcome.getDecision().getFunction());
                    jSONObject5.put("params", new JSONObject(actionOutcome.getDecision().getParams()));
                    jSONObject5.put("status", actionOutcome.c().name());
                    SlaAtomicDispatcher.DispatchResult dispatchResult = actionOutcome.getDispatchResult();
                    jSONObject5.put("errorCode", dispatchResult != null ? dispatchResult.getErrorCode() : -1);
                    SlaAtomicDispatcher.DispatchResult dispatchResult2 = actionOutcome.getDispatchResult();
                    jSONObject5.putOpt(C3081a.ERROR_MSG, dispatchResult2 != null ? dispatchResult2.getErrorMsg() : null);
                    SlaAtomicDispatcher.DispatchResult dispatchResult3 = actionOutcome.getDispatchResult();
                    jSONObject5.put("elapsedMs", dispatchResult3 != null ? dispatchResult3.getElapsedMs() : 0L);
                    jSONArray2.put(jSONObject5);
                }
                Y8.t tVar3 = Y8.t.f7040a;
                jSONObject.put("actions", jSONArray2);
            }
            String string = jSONObject.toString();
            kotlin.jvm.internal.p.h(string, "toString(...)");
            return string;
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0113  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.stepos.aiengine.algorithm.sla.SlaResult N(java.util.List<com.stepos.ailauncher.sla.SlaGate.ActionOutcome> r29, java.lang.String r30, long r31) {
            /*
                Method dump skipped, instructions count: 430
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaGate.Race.N(java.util.List, java.lang.String, long):com.stepos.aiengine.algorithm.sla.SlaResult");
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00cb, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void O(com.stepos.ailauncher.sla.SlaGate.CancelReason r9) {
            /*
                r8 = this;
                java.lang.String r0 = "reason"
                kotlin.jvm.internal.p.i(r9, r0)
                monitor-enter(r8)
            L7:
                java.util.concurrent.atomic.AtomicReference<com.stepos.ailauncher.sla.SlaGate$Winner> r0 = r8.winner     // Catch: java.lang.Throwable -> L28
                java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L28
                com.stepos.ailauncher.sla.SlaGate$Winner r0 = (com.stepos.ailauncher.sla.SlaGate.Winner) r0     // Catch: java.lang.Throwable -> L28
                com.stepos.ailauncher.sla.SlaGate$Winner r1 = com.stepos.ailauncher.sla.SlaGate.Winner.CANCELLED     // Catch: java.lang.Throwable -> L28
                if (r0 == r1) goto Lca
                com.stepos.ailauncher.sla.SlaGate$Winner r2 = com.stepos.ailauncher.sla.SlaGate.Winner.BACKEND     // Catch: java.lang.Throwable -> L28
                if (r0 != r2) goto L19
                goto Lca
            L19:
                com.stepos.ailauncher.sla.SlaGate$Winner r2 = com.stepos.ailauncher.sla.SlaGate.Winner.SLA     // Catch: java.lang.Throwable -> L28
                r3 = 0
                r4 = 0
                if (r0 != r2) goto L2b
                com.stepos.ailauncher.sla.SlaGate$CancelReason r2 = com.stepos.ailauncher.sla.SlaGate.CancelReason.ROUND_ENDED     // Catch: java.lang.Throwable -> L28
                if (r9 != r2) goto L2b
                r8.P()     // Catch: java.lang.Throwable -> L28
                goto Lbb
            L28:
                r9 = move-exception
                goto Lcc
            L2b:
                java.util.concurrent.atomic.AtomicReference<com.stepos.ailauncher.sla.SlaGate$Winner> r2 = r8.winner     // Catch: java.lang.Throwable -> L28
                boolean r1 = r2.compareAndSet(r0, r1)     // Catch: java.lang.Throwable -> L28
                if (r1 == 0) goto L7
                kotlin.jvm.internal.p.f(r0)     // Catch: java.lang.Throwable -> L28
                java.lang.String r1 = "SLA"
                int r2 = r8.id     // Catch: java.lang.Throwable -> L28
                java.lang.String r5 = r8.traceId     // Catch: java.lang.Throwable -> L28
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
                r6.<init>()     // Catch: java.lang.Throwable -> L28
                java.lang.String r7 = "[#"
                r6.append(r7)     // Catch: java.lang.Throwable -> L28
                r6.append(r2)     // Catch: java.lang.Throwable -> L28
                java.lang.String r2 = "] cancel traceId="
                r6.append(r2)     // Catch: java.lang.Throwable -> L28
                r6.append(r5)     // Catch: java.lang.Throwable -> L28
                java.lang.String r2 = " previous="
                r6.append(r2)     // Catch: java.lang.Throwable -> L28
                r6.append(r0)     // Catch: java.lang.Throwable -> L28
                java.lang.String r2 = " reason="
                r6.append(r2)     // Catch: java.lang.Throwable -> L28
                r6.append(r9)     // Catch: java.lang.Throwable -> L28
                java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L28
                r5 = 4
                h8.C4148a.k(r1, r2, r4, r5, r3)     // Catch: java.lang.Throwable -> L28
                java.lang.String r1 = r8.traceId     // Catch: java.lang.Throwable -> L28
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
                r2.<init>()     // Catch: java.lang.Throwable -> L28
                java.lang.String r5 = "[SLA][traceId="
                r2.append(r5)     // Catch: java.lang.Throwable -> L28
                r2.append(r1)     // Catch: java.lang.Throwable -> L28
                java.lang.String r1 = "] ticketCancelled previous="
                r2.append(r1)     // Catch: java.lang.Throwable -> L28
                r2.append(r0)     // Catch: java.lang.Throwable -> L28
                java.lang.String r0 = " reason="
                r2.append(r0)     // Catch: java.lang.Throwable -> L28
                r2.append(r9)     // Catch: java.lang.Throwable -> L28
                java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L28
                E5.a.a(r0)     // Catch: java.lang.Throwable -> L28
                kotlinx.coroutines.g r0 = r8.timerJob     // Catch: java.lang.Throwable -> L28
                r1 = 1
                if (r0 == 0) goto L97
                kotlinx.coroutines.g.Y0(r0, r3, r1, r3)     // Catch: java.lang.Throwable -> L28
            L97:
                kotlinx.coroutines.g r0 = r8.lateAsrGraceJob     // Catch: java.lang.Throwable -> L28
                if (r0 == 0) goto L9e
                kotlinx.coroutines.g.Y0(r0, r3, r1, r3)     // Catch: java.lang.Throwable -> L28
            L9e:
                r8.pendingBackend = r4     // Catch: java.lang.Throwable -> L28
                r8.pendingResult = r3     // Catch: java.lang.Throwable -> L28
                r8.pendingRouteBackend = r4     // Catch: java.lang.Throwable -> L28
                r8.proceed = r3     // Catch: java.lang.Throwable -> L28
                r8.query = r3     // Catch: java.lang.Throwable -> L28
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L28
                r0.<init>()     // Catch: java.lang.Throwable -> L28
                java.lang.String r2 = "race cancel reason="
                r0.append(r2)     // Catch: java.lang.Throwable -> L28
                r0.append(r9)     // Catch: java.lang.Throwable -> L28
                java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L28
                r4 = r1
            Lbb:
                monitor-exit(r8)
                if (r4 == 0) goto Lc4
                r8.f0()
                r8.e0()
            Lc4:
                if (r3 == 0) goto Lc9
                r8.Q(r3)
            Lc9:
                return
            Lca:
                monitor-exit(r8)
                return
            Lcc:
                monitor-exit(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaGate.Race.O(com.stepos.ailauncher.sla.SlaGate$CancelReason):void");
        }

        public final void P() {
            C4148a.k(SlaGate.TAG, "[#" + this.id + "] cancel 到达但 SLA 已胜出 traceId=" + this.traceId + " -> 保留终态, 结果照常配信", false, 4, null);
            E5.a.a("[SLA][traceId=" + this.traceId + "] cancelIgnored reason=slaAlreadyWon asrBound=" + (this.query != null));
            if (this.query != null) {
                this.cancelledAfterSlaWin = true;
                U();
                return;
            }
            if (this.lateAsrGraceJob == null) {
                C4148a.k(SlaGate.TAG, "[#" + this.id + "] query 仍为空 -> 等迟到 ASR 文案 600ms 再兜空串 traceId=" + this.traceId, false, 4, null);
                E5.a.a("[SLA][traceId=" + this.traceId + "] lateAsrGraceArmed graceMs=600");
                this.lateAsrGraceJob = C1060i.d(this.this$0.scope, null, null, new SlaGate$Race$cancelAfterSlaWon$1(this, null), 3, null);
            }
            U();
        }

        public final void Q(String reason) {
            if (this.sdkTerminalCallbackReceived.get()) {
                this.session.set(null);
                C4148a.d(SlaGate.TAG, "[#" + this.id + "] skip cancel after SDK terminal callback, reason=" + reason, false, 4, null);
                return;
            }
            SlaRouter.a andSet = this.session.getAndSet(null);
            if (andSet == null) {
                return;
            }
            if (this.sdkTerminalCallbackReceived.get()) {
                C4148a.d(SlaGate.TAG, "[#" + this.id + "] skip raced cancel after SDK terminal callback, reason=" + reason, false, 4, null);
                return;
            }
            C4148a.d(SlaGate.TAG, "[#" + this.id + "] cancel active SDK session, reason=" + reason, false, 4, null);
            andSet.a();
        }

        public final void R(SlaResult result) {
            kotlinx.coroutines.g gVar = this.timerJob;
            boolean z10 = true;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            if (!this.resultDelivered.compareAndSet(false, true)) {
                C4148a.u(SlaGate.TAG, "[#" + this.id + "] duplicate SLA result ignored status=" + result.getExecution().getStatus(), false, 4, null);
                return;
            }
            if (result.getExecution().getStatus() != SlaExecution.Status.SUCCESS && result.getExecution().getStatus() != SlaExecution.Status.DISPATCHED) {
                z10 = false;
            }
            d0(z10);
            this.pendingResult = result;
            if (this.query == null) {
                E5.a.a("[SLA][traceId=" + this.traceId + "] waitAsr pending=result");
            }
            U();
        }

        public final void S(final int errorCode) {
            if (this.winner.compareAndSet(Winner.PENDING, Winner.BACKEND)) {
                C4148a.k(SlaGate.TAG, "[#" + this.id + "] 原通路胜出 (code=" + errorCode + ") -> 放行后端", false, 4, null);
                E5.a.a("[SLA][traceId=" + this.traceId + "] fallback code=" + errorCode + " asrBound=" + (this.proceed != null));
                kotlinx.coroutines.g gVar = this.timerJob;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                Q("fallback code=" + errorCode);
                this.pendingBackend = true;
                if (errorCode != -1001 && errorCode != -1002 && errorCode != -1003) {
                    final SlaGate slaGate = this.this$0;
                    c0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.n
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return SlaGate.Race.T(slaGate, this, errorCode);
                        }
                    });
                }
                U();
            }
        }

        public final synchronized void U() {
            final String str = this.query;
            if (this.pendingRouteBackend) {
                final InterfaceC5063a<Y8.t> interfaceC5063a = this.proceed;
                if (interfaceC5063a != null) {
                    this.pendingRouteBackend = false;
                    C4148a.k(SlaGate.TAG, "[#" + this.id + "] routeToBackend(flush) -> 放行云端", false, 4, null);
                    E5.a.a("[SLA][traceId=" + this.traceId + "] routeCloud source=afterAsr");
                    c0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.j
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return SlaGate.Race.V(interfaceC5063a);
                        }
                    });
                }
                return;
            }
            Winner winner = this.winner.get();
            int i10 = winner == null ? -1 : a.$EnumSwitchMapping$0[winner.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    final SlaResult slaResult = this.pendingResult;
                    if (str == null) {
                        str = "";
                        if (!this.cancelledAfterSlaWin) {
                            str = null;
                        }
                    }
                    if (slaResult != null && str != null) {
                        this.pendingResult = null;
                        this.resultDispatchedToHost.set(true);
                        kotlinx.coroutines.g gVar = this.lateAsrGraceJob;
                        if (gVar != null) {
                            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                        }
                        final SlaGate slaGate = this.this$0;
                        c0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.k
                            @Override // p9.InterfaceC5063a
                            public final Object invoke() {
                                return SlaGate.Race.W(this.f28309a, slaResult, slaGate, str);
                            }
                        });
                    }
                } else if (i10 == 3) {
                    final InterfaceC5063a<Y8.t> interfaceC5063a2 = this.proceed;
                    if (this.pendingBackend && interfaceC5063a2 != null) {
                        this.pendingBackend = false;
                        E5.a.a("[SLA][traceId=" + this.traceId + "] fallbackReleased afterAsr=true");
                        c0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.l
                            @Override // p9.InterfaceC5063a
                            public final Object invoke() {
                                return SlaGate.Race.Y(interfaceC5063a2);
                            }
                        });
                    }
                } else if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }

        public final String Z() {
            String str = this.resolvedSessionId;
            if (str.length() > 0) {
                return str;
            }
            String strH = this.this$0.H();
            if (strH.length() > 0) {
                this.resolvedSessionId = strH;
                C4148a.k(SlaGate.TAG, "[#" + this.id + "] sessionId 懒解析到 " + strH + " (起跑时为空)", false, 4, null);
            }
            return strH;
        }

        public final boolean a0() {
            return this.winner.get() == Winner.SLA;
        }

        public final void b0(String callback) {
            if (this.sdkTerminalCallbackReceived.compareAndSet(false, true)) {
                this.session.set(null);
                C4148a.d(SlaGate.TAG, "[#" + this.id + "] SDK terminal callback=" + callback + " -> session released", false, 4, null);
            }
        }

        public final void c0(InterfaceC5063a<Y8.t> block) {
            C1060i.d(this.this$0.scope, Y.c(), null, new SlaGate$Race$onMain$1(block, null), 2, null);
        }

        public final void d0(boolean staysLocal) {
            synchronized (this.execWaitLock) {
                if (this.localExecStaysLocal != null) {
                    return;
                }
                this.localExecStaysLocal = Boolean.valueOf(staysLocal);
                InterfaceC5063a<Y8.t> interfaceC5063a = this.execWaiter;
                this.execWaiter = null;
                if (interfaceC5063a == null) {
                    return;
                }
                c0(interfaceC5063a);
            }
        }

        public final void e0() {
            InterfaceC5063a<Y8.t> interfaceC5063a;
            synchronized (this.execWaitLock) {
                interfaceC5063a = this.execWaiter;
                this.execWaiter = null;
            }
            if (interfaceC5063a == null) {
                return;
            }
            c0(interfaceC5063a);
        }

        public final void f0() {
            synchronized (this.ledgerWaitLock) {
                if (this.ledgerPending.compareAndSet(true, false)) {
                    InterfaceC5063a<Y8.t> interfaceC5063a = this.ledgerWaiter;
                    this.ledgerWaiter = null;
                    if (interfaceC5063a == null) {
                        return;
                    }
                    c0(interfaceC5063a);
                }
            }
        }

        public final String g0() {
            return Z();
        }

        public final void h0() {
            kotlinx.coroutines.g gVar = this.timerJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            if (this.winner.get() == Winner.CANCELLED) {
                f0();
                return;
            }
            if (this.backendRouted.compareAndSet(false, true)) {
                e0();
                final InterfaceC5063a<Y8.t> interfaceC5063a = this.proceed;
                if (interfaceC5063a != null) {
                    C4148a.k(SlaGate.TAG, "[#" + this.id + "] routeToBackend -> 放行云端", false, 4, null);
                    E5.a.a("[SLA][traceId=" + this.traceId + "] routeCloud source=resultFailure");
                    if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
                        interfaceC5063a.invoke();
                    } else {
                        c0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.p
                            @Override // p9.InterfaceC5063a
                            public final Object invoke() {
                                return SlaGate.Race.i0(interfaceC5063a);
                            }
                        });
                    }
                } else {
                    C4148a.u(SlaGate.TAG, "[#" + this.id + "] routeToBackend pending: proceed == null", false, 4, null);
                    E5.a.a("[SLA][traceId=" + this.traceId + "] waitAsr pending=routeCloud");
                    this.pendingRouteBackend = true;
                }
                f0();
            }
        }

        public final void j0(InterfaceC5074l<? super SlaListener, SlaRouter.a> starter) {
            kotlin.jvm.internal.p.i(starter, "starter");
            k0();
            C1060i.d(this.this$0.scope, null, null, new SlaGate$Race$start$1(this, starter, null), 3, null);
        }

        public final void k0() {
            this.timerJob = C1060i.d(this.this$0.scope, null, null, new SlaGate$Race$startTimer$1(this.this$0, this, null), 3, null);
        }

        public final synchronized void l0() {
            try {
                kotlinx.coroutines.g gVar = this.lateAsrGraceJob;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                if (this.query == null && !this.resultDispatchedToHost.get()) {
                    C4148a.k(SlaGate.TAG, "[#" + this.id + "] 放弃等迟到 ASR 文案 traceId=" + this.traceId + " -> 空 query 配信", false, 4, null);
                    String str = this.traceId;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[SLA][traceId=");
                    sb2.append(str);
                    sb2.append("] lateAsrGraceGiveUp");
                    E5.a.a(sb2.toString());
                    this.cancelledAfterSlaWin = true;
                    U();
                }
            } finally {
            }
        }

        public final void m0(int errorCode) {
            Winner winner = this.winner.get();
            int i10 = winner == null ? -1 : a.$EnumSwitchMapping$0[winner.ordinal()];
            if (i10 == 1) {
                S(errorCode);
                return;
            }
            if (i10 != 2) {
                if (i10 != 3 && i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                return;
            }
            if (this.resultDelivered.get()) {
                C4148a.k(SlaGate.TAG, "[#" + this.id + "] 结果已配信后才终止 (code=" + errorCode + ") -> 忽略", false, 4, null);
                return;
            }
            C4148a.k(SlaGate.TAG, "[#" + this.id + "] SLA 胜出后无结果终止 (code=" + errorCode + ") -> routeToBackend", false, 4, null);
            h0();
        }

        public final SlaVoiceBridge.VoiceSendBind n0() {
            return this.backendRouted.get() ? SlaVoiceBridge.VoiceSendBind.BOUND : this.ledgerPending.get() ? SlaVoiceBridge.VoiceSendBind.LEDGER_PENDING : (a0() && kotlin.jvm.internal.p.d(this.localExecStaysLocal, Boolean.FALSE)) ? SlaVoiceBridge.VoiceSendBind.EXEC_FAILED : (a0() && this.localExecStaysLocal == null) ? SlaVoiceBridge.VoiceSendBind.RESULT_PENDING : a0() ? SlaVoiceBridge.VoiceSendBind.LOCAL_WON : SlaVoiceBridge.VoiceSendBind.BOUND;
        }

        public final boolean o0(InterfaceC5063a<Y8.t> onSettled) {
            kotlin.jvm.internal.p.i(onSettled, "onSettled");
            synchronized (this.execWaitLock) {
                if (this.localExecStaysLocal == null && !this.backendRouted.get()) {
                    this.execWaiter = onSettled;
                    if (this.localExecStaysLocal == null && !this.backendRouted.get()) {
                        return true;
                    }
                    this.execWaiter = null;
                    return false;
                }
                return false;
            }
        }

        public final boolean p0(InterfaceC5063a<Y8.t> onSettled) {
            kotlin.jvm.internal.p.i(onSettled, "onSettled");
            synchronized (this.ledgerWaitLock) {
                if (!this.ledgerPending.get()) {
                    return false;
                }
                this.ledgerWaiter = onSettled;
                if (this.ledgerPending.get()) {
                    return true;
                }
                this.ledgerWaiter = null;
                return false;
            }
        }

        public final void q0(SlaDecision decision, int actionCount, boolean awaitLedger) {
            final int i10;
            final long j10;
            final Race race;
            if (this.winner.compareAndSet(Winner.PENDING, Winner.SLA)) {
                if (awaitLedger) {
                    this.ledgerPending.set(true);
                }
                C4148a.k(SlaGate.TAG, "[#" + this.id + "] SLA 胜出 -> 吞掉原发送, function=" + decision.getFunction() + " actionCount=" + actionCount, false, 4, null);
                kotlinx.coroutines.g gVar = this.timerJob;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                long jF = C5685n.f(actionCount, 1) * SlaGate.EXECUTION_TIMEOUT_BASE_MS;
                if (actionCount > 1) {
                    j10 = jF;
                    final SlaGate slaGate = this.this$0;
                    race = this;
                    i10 = actionCount;
                    race.c0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.m
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return SlaGate.Race.s0(slaGate, race, i10, j10);
                        }
                    });
                } else {
                    i10 = actionCount;
                    j10 = jF;
                    race = this;
                }
                long j11 = j10;
                int i11 = i10;
                Race race2 = race;
                race2.timerJob = C1060i.d(race.this$0.scope, null, null, new SlaGate$Race$winSla$2(j11, race2, i11, null), 3, null);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaGate$Winner;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", SlaGate.TAG, "BACKEND", "CANCELLED", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Winner {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Winner[] $VALUES;
        public static final Winner PENDING = new Winner("PENDING", 0);
        public static final Winner SLA = new Winner(SlaGate.TAG, 1);
        public static final Winner BACKEND = new Winner("BACKEND", 2);
        public static final Winner CANCELLED = new Winner("CANCELLED", 3);

        private static final /* synthetic */ Winner[] $values() {
            return new Winner[]{PENDING, SLA, BACKEND, CANCELLED};
        }

        static {
            Winner[] winnerArr$values = $values();
            $VALUES = winnerArr$values;
            $ENTRIES = kotlin.enums.a.a(winnerArr$values);
        }

        private Winner(String str, int i10) {
        }

        public static InterfaceC4149a<Winner> getEntries() {
            return $ENTRIES;
        }

        public static Winner valueOf(String str) {
            return (Winner) Enum.valueOf(Winner.class, str);
        }

        public static Winner[] values() {
            return (Winner[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC5074l {
        public static final a INSTANCE = new a();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(String it) {
            kotlin.jvm.internal.p.i(it, "it");
            return null;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaGate$b;", "", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "decision", "Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", "dispatchResult", "<init>", "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;)V", "Lcom/stepos/aiengine/algorithm/sla/SlaExecution$Status;", "c", "()Lcom/stepos/aiengine/algorithm/sla/SlaExecution$Status;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sla.SlaGate$b, reason: from toString */
    public static final /* data */ class ActionOutcome {
        private final SlaDecision decision;
        private final SlaAtomicDispatcher.DispatchResult dispatchResult;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.sla.SlaGate$b$a */
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SlaAtomicDispatcher.DispatchResult.Status.values().length];
                try {
                    iArr[SlaAtomicDispatcher.DispatchResult.Status.SUCCESS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SlaAtomicDispatcher.DispatchResult.Status.UNAVAILABLE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SlaAtomicDispatcher.DispatchResult.Status.NOT_DISPATCHED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public ActionOutcome(SlaDecision decision, SlaAtomicDispatcher.DispatchResult dispatchResult) {
            kotlin.jvm.internal.p.i(decision, "decision");
            this.decision = decision;
            this.dispatchResult = dispatchResult;
        }

        /* renamed from: a, reason: from getter */
        public final SlaDecision getDecision() {
            return this.decision;
        }

        /* renamed from: b, reason: from getter */
        public final SlaAtomicDispatcher.DispatchResult getDispatchResult() {
            return this.dispatchResult;
        }

        public final SlaExecution.Status c() {
            SlaAtomicDispatcher.DispatchResult dispatchResult = this.dispatchResult;
            SlaAtomicDispatcher.DispatchResult.Status statusH = dispatchResult != null ? dispatchResult.getStatus() : null;
            int i10 = statusH == null ? -1 : a.$EnumSwitchMapping$0[statusH.ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? SlaExecution.Status.FAILED : SlaExecution.Status.NOT_DISPATCHED : SlaExecution.Status.UNAVAILABLE : SlaExecution.Status.SUCCESS;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionOutcome)) {
                return false;
            }
            ActionOutcome actionOutcome = (ActionOutcome) other;
            return kotlin.jvm.internal.p.d(this.decision, actionOutcome.decision) && kotlin.jvm.internal.p.d(this.dispatchResult, actionOutcome.dispatchResult);
        }

        public int hashCode() {
            int iHashCode = this.decision.hashCode() * 31;
            SlaAtomicDispatcher.DispatchResult dispatchResult = this.dispatchResult;
            return iHashCode + (dispatchResult == null ? 0 : dispatchResult.hashCode());
        }

        public String toString() {
            return "ActionOutcome(decision=" + this.decision + ", dispatchResult=" + this.dispatchResult + ")";
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0014\u0010\u001d\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0010R\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010%\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaGate$c;", "", "<init>", "()V", "", Const.INTENT_KEY_UMID, "()Z", "Lcom/stepos/ailauncher/sla/SlaGate$c$a;", "c", "()Lcom/stepos/ailauncher/sla/SlaGate$c$a;", "Lcom/stepos/ailauncher/sla/x$a;", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "e", "(Lcom/stepos/ailauncher/sla/x$a;)Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "", "TAG", "Ljava/lang/String;", "cachedDecisionForUnlock", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "cachedTraceIdForUnlock", "cachedSessionIdForUnlock", "cachedQueryForUnlock", "Lkotlin/Function0;", "LY8/t;", "cachedProceedForUnlock", "Lp9/a;", "unlockCacheLock", "Ljava/lang/Object;", "KEY_SESSION_ID", "KEY_SLA_ACTIONS", "", "TIMEOUT", "I", ModelFlowMeta.PLAN_UNAVAILABLE, "CANCELLED", "EXECUTION_TIMEOUT", "", "EXECUTION_TIMEOUT_BASE_MS", "J", "LATE_ASR_GRACE_MS", "LEDGER_CHECK_RETRY_MS", "Ljava/util/concurrent/atomic/AtomicInteger;", "raceSeq", "Ljava/util/concurrent/atomic/AtomicInteger;", Const.INTENT_KEY_APIKEY, "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sla.SlaGate$c, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000eR\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001e\u0010\u000eR\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001f\u0010\u000e¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/sla/SlaGate$c$a;", "", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "decision", "Lkotlin/Function0;", "LY8/t;", "proceed", "", DidiCardProvider.KEY_TRACE_ID, "sessionId", "query", "<init>", "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;Lp9/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "Lp9/a;", Const.INTENT_KEY_PKGNAME, "()Lp9/a;", "Ljava/lang/String;", "e", Const.INTENT_KEY_UMID, "c", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.sla.SlaGate$c$a, reason: from toString */
        public static final /* data */ class UnlockCache {
            private final SlaDecision decision;
            private final InterfaceC5063a<Y8.t> proceed;
            private final String query;
            private final String sessionId;
            private final String traceId;

            public UnlockCache(SlaDecision slaDecision, InterfaceC5063a<Y8.t> interfaceC5063a, String traceId, String sessionId, String query) {
                kotlin.jvm.internal.p.i(traceId, "traceId");
                kotlin.jvm.internal.p.i(sessionId, "sessionId");
                kotlin.jvm.internal.p.i(query, "query");
                this.decision = slaDecision;
                this.proceed = interfaceC5063a;
                this.traceId = traceId;
                this.sessionId = sessionId;
                this.query = query;
            }

            /* renamed from: a, reason: from getter */
            public final SlaDecision getDecision() {
                return this.decision;
            }

            public final InterfaceC5063a<Y8.t> b() {
                return this.proceed;
            }

            /* renamed from: c, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            /* renamed from: d, reason: from getter */
            public final String getSessionId() {
                return this.sessionId;
            }

            /* renamed from: e, reason: from getter */
            public final String getTraceId() {
                return this.traceId;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UnlockCache)) {
                    return false;
                }
                UnlockCache unlockCache = (UnlockCache) other;
                return kotlin.jvm.internal.p.d(this.decision, unlockCache.decision) && kotlin.jvm.internal.p.d(this.proceed, unlockCache.proceed) && kotlin.jvm.internal.p.d(this.traceId, unlockCache.traceId) && kotlin.jvm.internal.p.d(this.sessionId, unlockCache.sessionId) && kotlin.jvm.internal.p.d(this.query, unlockCache.query);
            }

            public int hashCode() {
                SlaDecision slaDecision = this.decision;
                int iHashCode = (slaDecision == null ? 0 : slaDecision.hashCode()) * 31;
                InterfaceC5063a<Y8.t> interfaceC5063a = this.proceed;
                return ((((((iHashCode + (interfaceC5063a != null ? interfaceC5063a.hashCode() : 0)) * 31) + this.traceId.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.query.hashCode();
            }

            public String toString() {
                return "UnlockCache(decision=" + this.decision + ", proceed=" + this.proceed + ", traceId=" + this.traceId + ", sessionId=" + this.sessionId + ", query=" + this.query + ")";
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final UnlockCache c() {
            synchronized (SlaGate.unlockCacheLock) {
                if (SlaGate.cachedDecisionForUnlock == null && SlaGate.cachedProceedForUnlock == null) {
                    return null;
                }
                UnlockCache unlockCache = new UnlockCache(SlaGate.cachedDecisionForUnlock, SlaGate.cachedProceedForUnlock, SlaGate.cachedTraceIdForUnlock, SlaGate.cachedSessionIdForUnlock, SlaGate.cachedQueryForUnlock);
                SlaGate.cachedDecisionForUnlock = null;
                SlaGate.cachedTraceIdForUnlock = "";
                SlaGate.cachedSessionIdForUnlock = "";
                SlaGate.cachedQueryForUnlock = "";
                SlaGate.cachedProceedForUnlock = null;
                return unlockCache;
            }
        }

        public final boolean d() {
            boolean z10;
            synchronized (SlaGate.unlockCacheLock) {
                z10 = SlaGate.cachedDecisionForUnlock != null;
            }
            return z10;
        }

        public final SlaDecision e(x.Parsed aVar) {
            return new SlaDecision(aVar.getFunction(), aVar.getText(), aVar.c(), null, 1.0f, C1173v.m(), null);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J5\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaGate$d;", "", "", DidiCardProvider.KEY_TRACE_ID, "query", "Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "result", "Lkotlin/Function0;", "LY8/t;", "routeToBackend", "f", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaResult;Lp9/a;)V", "", "errorCode", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;I)V", "actionCount", "", "executionBudgetMs", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;IJ)V", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "decision", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaDecision;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "reason", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface d {
        default void a(String traceId) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
        }

        default void b(String traceId, String query, int errorCode) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
            kotlin.jvm.internal.p.i(query, "query");
        }

        default void c(String traceId, String query, String reason) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
            kotlin.jvm.internal.p.i(query, "query");
            kotlin.jvm.internal.p.i(reason, "reason");
        }

        void f(String traceId, String query, SlaResult result, InterfaceC5063a<Y8.t> routeToBackend);

        default void g(String traceId, int actionCount, long executionBudgetMs) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
        }

        default void h(String traceId, String query, SlaDecision decision) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
            kotlin.jvm.internal.p.i(query, "query");
            kotlin.jvm.internal.p.i(decision, "decision");
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000¢\u0006\u0004\b!\u0010 R\u0018\u0010\u0004\u001a\u00060\u0002R\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaGate$e;", "", "Lcom/stepos/ailauncher/sla/SlaGate$Race;", "Lcom/stepos/ailauncher/sla/SlaGate;", "race", "", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Lcom/stepos/ailauncher/sla/SlaGate;Lcom/stepos/ailauncher/sla/SlaGate$Race;Ljava/lang/String;)V", "asrText", "Lkotlin/Function0;", "LY8/t;", "proceed", "e", "(Ljava/lang/String;Lp9/a;)V", "Lcom/stepos/ailauncher/sla/SlaGate$CancelReason;", "reason", "c", "(Lcom/stepos/ailauncher/sla/SlaGate$CancelReason;)V", "", Const.INTENT_KEY_APIKEY, "()Z", "text", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "f", "()V", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$VoiceSendBind;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/ailauncher/sla/SlaVoiceBridge$VoiceSendBind;", "onSettled", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lp9/a;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/ailauncher/sla/SlaGate$Race;", "Ljava/lang/String;", "getTraceId", "()Ljava/lang/String;", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class e {
        private final Race race;
        final /* synthetic */ SlaGate this$0;
        private final String traceId;

        public e(SlaGate slaGate, Race race, String traceId) {
            kotlin.jvm.internal.p.i(race, "race");
            kotlin.jvm.internal.p.i(traceId, "traceId");
            this.this$0 = slaGate;
            this.race = race;
            this.traceId = traceId;
        }

        public static /* synthetic */ void d(e eVar, CancelReason cancelReason, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                cancelReason = CancelReason.ROUND_ENDED;
            }
            eVar.c(cancelReason);
        }

        public final boolean a() {
            return this.race.I();
        }

        public final boolean b(String text) {
            kotlin.jvm.internal.p.i(text, "text");
            return this.race.K(text);
        }

        public final void c(CancelReason reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            this.race.O(reason);
        }

        public final void e(String asrText, InterfaceC5063a<Y8.t> proceed) {
            kotlin.jvm.internal.p.i(asrText, "asrText");
            kotlin.jvm.internal.p.i(proceed, "proceed");
            C4148a.k(SlaGate.TAG, "voice complete: bind asrText=\"" + asrText + "\"", false, 4, null);
            E5.a.a("[SLA][traceId=" + this.traceId + "] asrBound textLen=" + asrText.length());
            this.race.G(proceed);
            this.race.J(asrText);
        }

        public final void f() {
            this.race.l0();
        }

        public final SlaVoiceBridge.VoiceSendBind g() {
            return this.race.n0();
        }

        public final boolean h(InterfaceC5063a<Y8.t> onSettled) {
            kotlin.jvm.internal.p.i(onSettled, "onSettled");
            return this.race.o0(onSettled);
        }

        public final boolean i(InterfaceC5063a<Y8.t> onSettled) {
            kotlin.jvm.internal.p.i(onSettled, "onSettled");
            return this.race.p0(onSettled);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class f {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SlaAtomicDispatcher.DispatchResult.Status.values().length];
            try {
                iArr[SlaAtomicDispatcher.DispatchResult.Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SlaAtomicDispatcher.DispatchResult.Status.UNAVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SlaAtomicDispatcher.DispatchResult.Status.NOT_DISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SlaGate(Context context, d callbacks, InterfaceC5063a<String> sessionIdProvider, InterfaceC5063a<String> traceIdFactory, InterfaceC5074l<? super String, Integer> conversationRoundProvider, long j10, Ua.M scope) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callbacks, "callbacks");
        kotlin.jvm.internal.p.i(sessionIdProvider, "sessionIdProvider");
        kotlin.jvm.internal.p.i(traceIdFactory, "traceIdFactory");
        kotlin.jvm.internal.p.i(conversationRoundProvider, "conversationRoundProvider");
        kotlin.jvm.internal.p.i(scope, "scope");
        this.context = context;
        this.callbacks = callbacks;
        this.sessionIdProvider = sessionIdProvider;
        this.traceIdFactory = traceIdFactory;
        this.conversationRoundProvider = conversationRoundProvider;
        this.bufferMs = j10;
        this.scope = scope;
    }

    public static final SlaRouter.a C(p9.q qVar, boolean z10, Race race, SlaListener listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        return (SlaRouter.a) qVar.invoke(listener, Boolean.valueOf(z10), race.g0());
    }

    public static final SlaRouter.a O(SlaGate slaGate, String str, String str2, String str3, boolean z10, SlaListener listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        return SlaRouter.INSTANCE.I(slaGate.context, str, str2, str3, listener, z10);
    }

    public static final Y8.t S(SlaGate slaGate, String str, String str2) {
        slaGate.callbacks.c(str, str2, "replay-result-no-proceed");
        return Y8.t.f7040a;
    }

    public static final String f() {
        return "";
    }

    public static final String g() {
        return "";
    }

    public final e B(String traceId, final p9.q<? super SlaListener, ? super Boolean, ? super String, SlaRouter.a> audioStart) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(audioStart, "audioStart");
        if (!SlaRouter.INSTANCE.v(this.context)) {
            C4148a.k(TAG, "beginVoiceRace skip: SLA unavailable", false, 4, null);
            E5.a.a("[SLA][traceId=" + traceId + "] bypass channel=voice reason=unavailable");
            return null;
        }
        T();
        C4148a.k(TAG, "beginVoiceRace start (audio, parallel with ASR) traceId=" + traceId, false, 4, null);
        E5.a.a("[SLA][traceId=" + traceId + "] start channel=voice waitForAsr=true");
        String strH = H();
        G.INSTANCE.g(strH, traceId, "voice", L(), K(), G(strH), C3475d.INSTANCE.b());
        final boolean zC = C3474c.INSTANCE.c();
        final Race race = new Race(this, null, strH, traceId, zC);
        race.j0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.sla.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SlaGate.C(audioStart, zC, race, (SlaListener) obj);
            }
        });
        return new e(this, race, traceId);
    }

    public final SlaResult D(SlaDecision decision, SlaAtomicDispatcher.DispatchResult dr) {
        String strF;
        String strE;
        SlaAtomicDispatcher.DispatchResult.Status statusH = dr != null ? dr.getStatus() : null;
        int i10 = statusH == null ? -1 : f.$EnumSwitchMapping$0[statusH.ordinal()];
        SlaExecution.Status status = i10 != 1 ? i10 != 2 ? i10 != 3 ? SlaExecution.Status.FAILED : SlaExecution.Status.NOT_DISPATCHED : SlaExecution.Status.UNAVAILABLE : SlaExecution.Status.SUCCESS;
        boolean z10 = status != SlaExecution.Status.NOT_DISPATCHED;
        if (dr == null || (strF = dr.getExecutor()) == null) {
            strF = SlaAtomicDispatcher.EXECUTOR_ID;
        }
        String str = strF;
        int iD = dr != null ? dr.getErrorCode() : -1;
        if (dr == null || (strE = dr.getErrorMsg()) == null) {
            strE = "dispatch threw";
        }
        SlaExecution slaExecution = new SlaExecution(z10, str, status, iD, strE, dr != null ? dr.getResultJson() : null, dr != null ? dr.getElapsedMs() : 0L);
        String text = decision.getText();
        if (text == null) {
            text = "";
        }
        return new SlaResult(decision, slaExecution, text, 0L, 0L, "");
    }

    public final void E(SlaDecision decision, String traceId, String sessionId, String query, InterfaceC5063a<Y8.t> proceed) {
        kotlin.jvm.internal.p.i(decision, "decision");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(query, "query");
        synchronized (unlockCacheLock) {
            cachedDecisionForUnlock = decision;
            cachedTraceIdForUnlock = traceId;
            cachedSessionIdForUnlock = sessionId;
            cachedQueryForUnlock = query;
            cachedProceedForUnlock = proceed;
            Y8.t tVar = Y8.t.f7040a;
        }
        C4148a.k(TAG, "cacheForUnlock: function=" + decision.getFunction() + " traceId=" + traceId + " sessionId=" + sessionId + " proceed=" + (proceed != null ? "held" : "null"), false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(java.util.List<java.lang.String> r18, e9.InterfaceC4014c<? super com.stepos.ability.bean.SlaPermissionResult> r19) throws java.lang.Throwable {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r2 instanceof com.stepos.ailauncher.sla.SlaGate$checkSlaPermissionSafe$1
            if (r3 == 0) goto L19
            r3 = r2
            com.stepos.ailauncher.sla.SlaGate$checkSlaPermissionSafe$1 r3 = (com.stepos.ailauncher.sla.SlaGate$checkSlaPermissionSafe$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.stepos.ailauncher.sla.SlaGate$checkSlaPermissionSafe$1 r3 = new com.stepos.ailauncher.sla.SlaGate$checkSlaPermissionSafe$1
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = f9.C4063a.g()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L51
            if (r5 == r8) goto L49
            if (r5 == r7) goto L41
            if (r5 != r6) goto L39
            java.lang.Object r0 = r3.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.C4849c.b(r2)
            return r2
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L41:
            java.lang.Object r1 = r3.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.C4849c.b(r2)
            goto L9c
        L49:
            java.lang.Object r1 = r3.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.C4849c.b(r2)
            goto L5f
        L51:
            kotlin.C4849c.b(r2)
            r3.L$0 = r1
            r3.label = r8
            java.lang.Object r2 = r0.J(r1, r3)
            if (r2 != r4) goto L5f
            goto Laa
        L5f:
            com.stepos.ability.bean.SlaPermissionResult r2 = (com.stepos.ability.bean.SlaPermissionResult) r2
            if (r2 == 0) goto L64
            return r2
        L64:
            r8 = r1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r15 = 62
            r16 = 0
            java.lang.String r9 = ","
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            java.lang.String r2 = Z8.F.A0(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "checkSlaPermission 失败, 250ms 后重试 functions="
            r5.append(r8)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r5 = 4
            r8 = 0
            java.lang.String r9 = "SLA"
            r10 = 0
            h8.C4148a.u(r9, r2, r10, r5, r8)
            r3.L$0 = r1
            r3.label = r7
            r7 = 250(0xfa, double:1.235E-321)
            java.lang.Object r2 = Ua.U.a(r7, r3)
            if (r2 != r4) goto L9c
            goto Laa
        L9c:
            java.lang.Object r2 = g9.h.a(r1)
            r3.L$0 = r2
            r3.label = r6
            java.lang.Object r0 = r0.J(r1, r3)
            if (r0 != r4) goto Lab
        Laa:
            return r4
        Lab:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaGate.F(java.util.List, e9.c):java.lang.Object");
    }

    public final Integer G(String sessionId) {
        Object objB;
        if (sessionId.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.conversationRoundProvider.invoke(sessionId));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "conversationRoundProvider 异常: " + thE.getMessage(), false, 4, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Integer num = (Integer) objB;
        if (num != null) {
            return Integer.valueOf(num.intValue() + 1);
        }
        return null;
    }

    public final String H() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.sessionIdProvider.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = "";
        }
        return (String) objB;
    }

    public final void I() {
        Companion.UnlockCache unlockCacheC = INSTANCE.c();
        if (unlockCacheC == null) {
            C4148a.d(TAG, "dropCachedDecision: no cached decision", false, 4, null);
            return;
        }
        SlaDecision decision = unlockCacheC.getDecision();
        C4148a.k(TAG, "dropCachedDecision: function=" + (decision != null ? decision.getFunction() : null) + " traceId=" + unlockCacheC.getTraceId() + " proceed=" + (unlockCacheC.b() != null ? "held" : "null") + " -> abandon", false, 4, null);
        C1060i.d(this.scope, Y.c(), null, new SlaGate$dropCachedDecision$1(this, unlockCacheC, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(java.util.List<java.lang.String> r13, e9.InterfaceC4014c<? super com.stepos.ability.bean.SlaPermissionResult> r14) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.stepos.ailauncher.sla.SlaGate$invokeCheckSlaPermission$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.ailauncher.sla.SlaGate$invokeCheckSlaPermission$1 r0 = (com.stepos.ailauncher.sla.SlaGate$invokeCheckSlaPermission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.sla.SlaGate$invokeCheckSlaPermission$1 r0 = new com.stepos.ailauncher.sla.SlaGate$invokeCheckSlaPermission$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r12 = r0.L$1
            com.stepos.ailauncher.sla.SlaGate r12 = (com.stepos.ailauncher.sla.SlaGate) r12
            java.lang.Object r12 = r0.L$0
            r13 = r12
            java.util.List r13 = (java.util.List) r13
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L32
            goto L58
        L32:
            r0 = move-exception
            r12 = r0
            goto L5f
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            kotlin.C4849c.b(r14)
            kotlin.Result$a r14 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.ability.sdk.client.AgentServiceClient r14 = com.stepos.ability.sdk.client.AgentServiceClient.f22085a     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r13     // Catch: java.lang.Throwable -> L32
            java.lang.Object r12 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L32
            r12 = 0
            r0.I$0 = r12     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r14 = r14.L(r13, r0)     // Catch: java.lang.Throwable -> L32
            if (r14 != r1) goto L58
            return r1
        L58:
            com.stepos.ability.bean.SlaPermissionResult r14 = (com.stepos.ability.bean.SlaPermissionResult) r14     // Catch: java.lang.Throwable -> L32
            java.lang.Object r12 = kotlin.Result.b(r14)     // Catch: java.lang.Throwable -> L32
            goto L69
        L5f:
            kotlin.Result$a r14 = kotlin.Result.INSTANCE
            java.lang.Object r12 = kotlin.C4849c.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L69:
            java.lang.Throwable r2 = kotlin.Result.e(r12)
            if (r2 == 0) goto Lcd
            r3 = r13
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r10 = 62
            r11 = 0
            java.lang.String r4 = ","
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r13 = Z8.F.A0(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            java.lang.String r14 = r2.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkSlaPermission 抛异常 functions="
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = ": "
            r0.append(r13)
            r0.append(r14)
            java.lang.String r1 = r0.toString()
            r4 = 8
            java.lang.String r0 = "SLA"
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
            java.lang.Class r13 = r2.getClass()
            java.lang.String r13 = r13.getSimpleName()
            java.lang.String r14 = r2.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[SLA] checkSlaPermission crashed: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = " "
            r0.append(r13)
            r0.append(r14)
            java.lang.String r13 = r0.toString()
            E5.a.b(r13)
        Lcd:
            boolean r13 = kotlin.Result.g(r12)
            if (r13 == 0) goto Ld4
            r12 = 0
        Ld4:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaGate.J(java.util.List, e9.c):java.lang.Object");
    }

    public final String K() {
        return v.INSTANCE.b(this.context) ? G.LOCK_LOCKED : G.LOCK_UNLOCKED;
    }

    public final String L() {
        return com.stepos.ailauncher.common.utils.I.INSTANCE.b(this.context) ? G.NETWORK_ONLINE : "offline";
    }

    public final String M() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.traceIdFactory.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.h(TAG, "newTraceId traceIdFactory 异常: " + thE.getMessage(), false, 4, null);
        }
        if (Result.g(objB)) {
            objB = "";
        }
        String str = (String) objB;
        if (str.length() == 0) {
            C4148a.h(TAG, "newTraceId 生成为空 -> trace 链路将缺失，需排查 traceIdFactory", false, 4, null);
        } else {
            C4148a.d(TAG, "newTraceId=" + str, false, 4, null);
        }
        return str;
    }

    public final void N(final String query, final String traceId, InterfaceC5063a<Y8.t> proceed) {
        kotlin.jvm.internal.p.i(query, "query");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(proceed, "proceed");
        C4148a.d(TAG, "onTextSend: query=" + query + " traceId=" + traceId, false, 4, null);
        if (La.H.x0(query) || !SlaRouter.INSTANCE.v(this.context)) {
            C4148a.k(TAG, "onTextSend pass-through (blank=" + La.H.x0(query) + " unavailable) -> 走原通路", false, 4, null);
            E5.a.a("[SLA][traceId=" + traceId + "] bypass channel=text reason=" + (La.H.x0(query) ? "blank" : "unavailable"));
            proceed.invoke();
            return;
        }
        T();
        Companion companion = INSTANCE;
        if (companion.d()) {
            C4148a.k(TAG, "onTextSend: clear stale lockMiss cache (new race supersedes)", false, 4, null);
            companion.c();
        }
        C4148a.k(TAG, "onTextSend start race, query=, traceId=" + traceId, false, 4, null);
        E5.a.a("[SLA][traceId=" + traceId + "] start channel=text textLen=" + query.length());
        final String strH = H();
        G.INSTANCE.g(strH, traceId, "text", L(), K(), G(strH), C3475d.INSTANCE.b());
        final boolean zC = C3474c.INSTANCE.c();
        Race race = new Race(this, proceed, strH, traceId, zC);
        race.J(query);
        race.j0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.sla.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SlaGate.O(this.f28300a, query, strH, traceId, zC, (SlaListener) obj);
            }
        });
    }

    public final void P(InterfaceC5063a<Y8.t> proceed, String traceId, String query, String reason) {
        C1060i.d(this.scope, Y.c(), null, new SlaGate$releaseCachedProceedToCloudOrAbandon$1(proceed, reason, traceId, this, query, null), 2, null);
    }

    public final void Q() {
        Companion.UnlockCache unlockCacheC = INSTANCE.c();
        if (unlockCacheC == null) {
            C4148a.d(TAG, "replayCachedDecision: no cached decision, skip", false, 4, null);
            return;
        }
        SlaDecision decision = unlockCacheC.getDecision();
        if (decision == null) {
            C4148a.u(TAG, "replayCachedDecision: cache has proceed but no decision -> 回云/放弃", false, 4, null);
            P(unlockCacheC.b(), unlockCacheC.getTraceId(), unlockCacheC.getQuery(), "no-decision");
            return;
        }
        String traceId = unlockCacheC.getTraceId();
        String sessionId = unlockCacheC.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = H();
            C4148a.k(TAG, "replayCachedDecision: 缓存 sessionId 为空 -> 重新解析得 " + sessionId, false, 4, null);
        }
        String query = unlockCacheC.getQuery();
        InterfaceC5063a<Y8.t> interfaceC5063aB = unlockCacheC.b();
        String function = decision.getFunction();
        if (function == null) {
            C4148a.u(TAG, "replayCachedDecision: cached decision has no function -> 回云/放弃", false, 4, null);
            P(interfaceC5063aB, traceId, query, "no-function");
            return;
        }
        C4148a.k(TAG, "replayCachedDecision: function=" + function + " traceId=" + traceId + " sessionId=" + sessionId + " proceed=" + (interfaceC5063aB != null ? "held" : "null"), false, 4, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[SLA][traceId=");
        sb2.append(traceId);
        sb2.append("] replayCachedDecision function=");
        sb2.append(function);
        E5.a.a(sb2.toString());
        C1060i.d(this.scope, Y.c(), null, new SlaGate$replayCachedDecision$1(this, traceId, null), 2, null);
        C1060i.d(this.scope, null, null, new SlaGate$replayCachedDecision$2(this, decision, function, sessionId, traceId, query, interfaceC5063aB, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x023b A[Catch: all -> 0x0233, TryCatch #1 {all -> 0x0233, blocks: (B:49:0x0226, B:54:0x0235, B:56:0x023b, B:57:0x023f, B:61:0x025b), top: B:113:0x0226 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R(com.stepos.aiengine.algorithm.sla.SlaDecision r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, p9.InterfaceC5063a<Y8.t> r30, e9.InterfaceC4014c<? super Y8.t> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 946
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaGate.R(com.stepos.aiengine.algorithm.sla.SlaDecision, java.lang.String, java.lang.String, java.lang.String, java.lang.String, p9.a, e9.c):java.lang.Object");
    }

    public final void T() {
        AgentServiceClient agentServiceClient = AgentServiceClient.f22085a;
        if (agentServiceClient.W()) {
            return;
        }
        AgentServiceClient.T(agentServiceClient, this.context, null, 2, null);
    }

    public /* synthetic */ SlaGate(Context context, d dVar, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, InterfaceC5074l interfaceC5074l, long j10, Ua.M m10, int i10, kotlin.jvm.internal.i iVar) {
        this(context, dVar, (i10 & 4) != 0 ? new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SlaGate.f();
            }
        } : interfaceC5063a, (i10 & 8) != 0 ? new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SlaGate.g();
            }
        } : interfaceC5063a2, (i10 & 16) != 0 ? a.INSTANCE : interfaceC5074l, (i10 & 32) != 0 ? 1000L : j10, (i10 & 64) != 0 ? kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b())) : m10);
    }
}
