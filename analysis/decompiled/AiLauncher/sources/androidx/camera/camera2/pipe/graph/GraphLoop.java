package androidx.camera.camera2.pipe.graph;

import A.h;
import Ua.C1060i;
import Ua.CoroutineName;
import Ua.I;
import Ua.M;
import Z8.C1172u;
import Z8.C1173v;
import Z8.F;
import Z8.Q;
import android.util.Log;
import androidx.camera.camera2.pipe.core.ProcessingQueue;
import androidx.camera.camera2.pipe.e;
import androidx.camera.camera2.pipe.graph.b;
import androidx.camera.camera2.pipe.t;
import androidx.camera.camera2.pipe.u;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.io.Closeable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.CoroutineStart;
import z.k;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b,\b\u0000\u0018\u0000 \u0099\u00012\u00020\u0001:\u0002:MBc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0017\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00192\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010!\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J-\u0010$\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J/\u0010'\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u001fH\u0002¢\u0006\u0004\b'\u0010(J-\u0010*\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010+J-\u0010-\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.J.\u00100\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020/H\u0082@¢\u0006\u0004\b0\u00101J%\u00102\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001c\u001a\u00020\u0019H\u0002¢\u0006\u0004\b2\u00103J%\u00104\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001c\u001a\u00020\u0019H\u0002¢\u0006\u0004\b4\u00103J\u001e\u00105\u001a\u00020\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0082@¢\u0006\u0004\b5\u0010\u0018J\u000f\u00106\u001a\u00020\u001fH\u0002¢\u0006\u0004\b6\u00107J\u001d\u0010:\u001a\u00020\u00162\f\u00109\u001a\b\u0012\u0004\u0012\u0002080\bH\u0002¢\u0006\u0004\b:\u0010;J\u001d\u0010=\u001a\u00020\u00162\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\bH\u0002¢\u0006\u0004\b=\u0010;J;\u0010@\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u001f2\f\u00109\u001a\b\u0012\u0004\u0012\u0002080\b2\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002¢\u0006\u0004\b@\u0010AJ\u001b\u0010B\u001a\u00020\u001f2\f\u00109\u001a\b\u0012\u0004\u0012\u0002080\b¢\u0006\u0004\bB\u0010CJ!\u0010E\u001a\u00020\u001f2\u0012\u0010D\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0016H\u0016¢\u0006\u0004\bI\u0010HJ\u000f\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bK\u0010LR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR \u0010\u0006\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010OR \u0010\u0007\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010OR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010RR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010UR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00140X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010^\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\"\u0010i\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b@\u0010OR\"\u0010k\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bj\u0010OR\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bl\u0010RR\u0014\u0010q\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010s\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010gR\"\u0010u\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010OR\"\u0010w\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010OR\"\u0010y\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010OR\u001c\u0010{\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010RR\u0018\u0010}\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010dR,\u0010\u0083\u0001\u001a\u0004\u0018\u00010b2\b\u0010~\u001a\u0004\u0018\u00010b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R-\u0010\u0088\u0001\u001a\u0004\u0018\u0001082\b\u0010~\u001a\u0004\u0018\u0001088F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001RA\u0010\u008d\u0001\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0012\u0010~\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001RA\u0010\u0090\u0001\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0012\u0010~\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0001\u0010\u008a\u0001\"\u0006\b\u008f\u0001\u0010\u008c\u0001R4\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020\t0\b8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0005\b\u0093\u0001\u0010;R(\u0010\u0098\u0001\u001a\u00020\u001f2\u0006\u0010~\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0095\u0001\u00107\"\u0006\b\u0096\u0001\u0010\u0097\u0001¨\u0006\u009a\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphLoop;", "Ljava/io/Closeable;", "Landroidx/camera/camera2/pipe/e;", "cameraGraphId", "", "", "defaultParameters", "requiredParameters", "", "Landroidx/camera/camera2/pipe/t$a;", "requiredListeners", "Landroidx/camera/camera2/pipe/graph/GraphLoop$b;", "listeners", "LUa/M;", "shutdownScope", "LUa/I;", "dispatcher", "<init>", "(Landroidx/camera/camera2/pipe/e;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;LUa/M;LUa/I;)V", "", "Landroidx/camera/camera2/pipe/graph/b;", "commands", "LY8/t;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "b1", "(Ljava/util/List;)I", "idx", "Landroidx/camera/camera2/pipe/graph/b$b;", "command", "", "repeatAllowed", "e0", "(Ljava/util/List;ILandroidx/camera/camera2/pipe/graph/b$b;Z)V", "Landroidx/camera/camera2/pipe/graph/b$j;", "Y0", "(Ljava/util/List;ILandroidx/camera/camera2/pipe/graph/b$j;)V", "captureAllowed", "D0", "(Ljava/util/List;IZ)V", "Landroidx/camera/camera2/pipe/graph/b$e;", "v0", "(Ljava/util/List;ILandroidx/camera/camera2/pipe/graph/b$e;)V", "Landroidx/camera/camera2/pipe/graph/b$d;", "k0", "(Ljava/util/List;ILandroidx/camera/camera2/pipe/graph/b$d;)V", "Landroidx/camera/camera2/pipe/graph/b$g;", "N0", "(Ljava/util/List;ILandroidx/camera/camera2/pipe/graph/b$g;Le9/c;)Ljava/lang/Object;", "T0", "(Ljava/util/List;I)V", "Y", "R0", SdCardDbCreator.FIELD_LASTLOC_ID, "()Z", "Landroidx/camera/camera2/pipe/t;", "requests", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)V", "unprocessedCommands", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isRepeating", "oneTimeRequiredParameters", "m", "(ZLjava/util/List;Ljava/util/Map;)Z", "t1", "(Ljava/util/List;)Z", "parameters", "u1", "(Ljava/util/Map;)Z", "U", "()V", "close", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/e;", "Ljava/util/Map;", "c", Const.INTENT_KEY_UMID, "Ljava/util/List;", "e", "f", "LUa/M;", Const.INTENT_KEY_BACKGROUND_COMMAND, "graphLoopScope", "Landroidx/camera/camera2/pipe/core/ProcessingQueue;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/camera/camera2/pipe/core/ProcessingQueue;", "processingQueue", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/lang/Object;", "lock", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Z", AlipayXuiIsland.REASON_CLOSED, "LA/h;", "k", "LA/h;", "_requestProcessor", "l", "Landroidx/camera/camera2/pipe/t;", "_repeatingRequest", "_graphParameters", "n", "_graph3AParameters", "o", "_requestListeners", "LOa/a;", "p", "LOa/a;", "_captureProcessingEnabled", "q", "currentRepeatingRequest", "r", "currentGraphParameters", "s", "currentGraph3AParameters", "t", "currentRequiredParameters", "u", "currentRequestListeners", "v", "currentRequestProcessor", UxipConstants.f30680s, "getRequestProcessor", "()LA/h;", "s1", "(LA/h;)V", "requestProcessor", "J", "()Landroidx/camera/camera2/pipe/t;", "l1", "(Landroidx/camera/camera2/pipe/t;)V", "repeatingRequest", "getGraphParameters", "()Ljava/util/Map;", "k1", "(Ljava/util/Map;)V", "graphParameters", "getGraph3AParameters", "h1", "graph3AParameters", "getRequestListeners", "()Ljava/util/List;", "m1", "requestListeners", "G", "f1", "(Z)V", "captureProcessingEnabled", "w", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphLoop implements Closeable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final e cameraGraphId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<?, Object> defaultParameters;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<?, Object> requiredParameters;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<t.a> requiredListeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final List<b> listeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final M shutdownScope;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final M graphLoopScope;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final ProcessingQueue<androidx.camera.camera2.pipe.graph.b> processingQueue;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public volatile boolean closed;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public h _requestProcessor;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public t _repeatingRequest;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public Map<?, ? extends Object> _graphParameters;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public Map<?, ? extends Object> _graph3AParameters;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public List<? extends t.a> _requestListeners;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final Oa.a _captureProcessingEnabled;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public t currentRepeatingRequest;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public Map<?, ? extends Object> currentGraphParameters;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public Map<?, ? extends Object> currentGraph3AParameters;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public Map<?, ? extends Object> currentRequiredParameters;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public List<? extends t.a> currentRequestListeners;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public h currentRequestProcessor;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphLoop$b;", "", "LY8/t;", "f", "()V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        void d();

        void f();

        void h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GraphLoop(e cameraGraphId, Map<?, ? extends Object> defaultParameters, Map<?, ? extends Object> requiredParameters, List<? extends t.a> requiredListeners, List<? extends b> listeners, M shutdownScope, I dispatcher) {
        p.i(cameraGraphId, "cameraGraphId");
        p.i(defaultParameters, "defaultParameters");
        p.i(requiredParameters, "requiredParameters");
        p.i(requiredListeners, "requiredListeners");
        p.i(listeners, "listeners");
        p.i(shutdownScope, "shutdownScope");
        p.i(dispatcher, "dispatcher");
        this.cameraGraphId = cameraGraphId;
        this.defaultParameters = defaultParameters;
        this.requiredParameters = requiredParameters;
        this.requiredListeners = requiredListeners;
        this.listeners = listeners;
        this.shutdownScope = shutdownScope;
        M mA = kotlinx.coroutines.d.a(dispatcher.plus(new CoroutineName("CXCP-GraphLoop")));
        this.graphLoopScope = mA;
        this.processingQueue = ProcessingQueue.INSTANCE.a(new ProcessingQueue(0, new GraphLoop$processingQueue$1(this), new GraphLoop$processingQueue$2(this), 1, null), mA);
        this.lock = new Object();
        this._graphParameters = kotlin.collections.a.i();
        this._graph3AParameters = kotlin.collections.a.i();
        this._requestListeners = C1173v.m();
        this._captureProcessingEnabled = Oa.b.a(true);
        this.currentGraphParameters = kotlin.collections.a.i();
        this.currentGraph3AParameters = kotlin.collections.a.i();
        this.currentRequiredParameters = requiredParameters;
        this.currentRequestListeners = requiredListeners;
    }

    public static /* synthetic */ void I0(GraphLoop graphLoop, List list, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        graphLoop.D0(list, i10, z10);
    }

    public static /* synthetic */ void g0(GraphLoop graphLoop, List list, int i10, b.C0138b c0138b, boolean z10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z10 = true;
        }
        graphLoop.e0(list, i10, c0138b, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean n(GraphLoop graphLoop, boolean z10, List list, Map map, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            map = kotlin.collections.a.i();
        }
        return graphLoop.m(z10, list, map);
    }

    public final void A(List<? extends androidx.camera.camera2.pipe.graph.b> unprocessedCommands) {
        for (androidx.camera.camera2.pipe.graph.b bVar : unprocessedCommands) {
            if (bVar instanceof b.C0138b) {
                b(((b.C0138b) bVar).a());
            } else if (bVar instanceof b.g) {
                C1060i.d(this.shutdownScope, null, CoroutineStart.UNDISPATCHED, new GraphLoop$finalizeUnprocessedCommands$1(bVar, null), 1, null);
            }
        }
    }

    public final void D0(List<androidx.camera.camera2.pipe.graph.b> commands, int idx, boolean captureAllowed) {
        int i10;
        GraphLoop graphLoop;
        int i11 = idx;
        while (true) {
            int i12 = 0;
            if (-1 >= i11) {
                GraphLoop graphLoop2 = this;
                if (!captureAllowed || (i10 = idx + 1) >= commands.size()) {
                    return;
                }
                androidx.camera.camera2.pipe.graph.b bVar = commands.get(i10);
                if (bVar instanceof b.C0138b) {
                    graphLoop2.e0(commands, i10, (b.C0138b) bVar, false);
                    return;
                } else {
                    if (bVar instanceof b.j) {
                        graphLoop2.Y0(commands, i10, (b.j) bVar);
                        return;
                    }
                    return;
                }
            }
            androidx.camera.camera2.pipe.graph.b bVar2 = commands.get(i11);
            if (bVar2 instanceof b.f) {
                b.f fVar = (b.f) bVar2;
                graphLoop = this;
                if (n(graphLoop, true, C1172u.e(fVar.getRequest()), null, 4, null)) {
                    graphLoop.currentRepeatingRequest = fVar.getRequest();
                    commands.remove(i11);
                    while (i12 < i11) {
                        if (commands.get(i12) instanceof b.f) {
                            commands.remove(i12);
                            i11--;
                        } else {
                            i12++;
                        }
                    }
                    return;
                }
            } else {
                graphLoop = this;
            }
            i11--;
            this = graphLoop;
        }
    }

    public final boolean G() {
        return this._captureProcessingEnabled.b();
    }

    public final t J() {
        t tVar;
        synchronized (this.lock) {
            tVar = this._repeatingRequest;
        }
        return tVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00de -> B:37:0x00f9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00f7 -> B:36:0x00f8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0106 -> B:39:0x0107). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N0(java.util.List<androidx.camera.camera2.pipe.graph.b> r18, int r19, androidx.camera.camera2.pipe.graph.b.g r20, e9.InterfaceC4014c<? super Y8.t> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.GraphLoop.N0(java.util.List, int, androidx.camera.camera2.pipe.graph.b$g, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0098, code lost:
    
        if (r12.e(r0) == r1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e9, code lost:
    
        if (r12.e(r0) == r1) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b0 -> B:48:0x00ee). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d9 -> B:47:0x00ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e9 -> B:47:0x00ec). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R0(java.util.List<androidx.camera.camera2.pipe.graph.b> r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.GraphLoop.R0(java.util.List, e9.c):java.lang.Object");
    }

    public final void T0(List<androidx.camera.camera2.pipe.graph.b> commands, int idx) {
        h hVar = this.currentRequestProcessor;
        if (hVar != null) {
            hVar.f();
        }
        this.currentRepeatingRequest = null;
        commands.remove(idx);
        int i10 = 0;
        while (i10 < idx) {
            androidx.camera.camera2.pipe.graph.b bVar = commands.get(i10);
            if (p.d(bVar, b.i.f10908a) || (bVar instanceof b.f)) {
                commands.remove(i10);
                idx--;
            } else {
                i10++;
            }
        }
    }

    public final void U() {
        this.processingQueue.j(b.c.f10900a);
    }

    public final Object V(List<androidx.camera.camera2.pipe.graph.b> list, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        int iB1 = b1(list);
        androidx.camera.camera2.pipe.graph.b bVar = list.get(iB1);
        if (p.d(bVar, b.c.f10900a)) {
            list.remove(iB1);
        } else {
            if (p.d(bVar, b.h.f10907a)) {
                Object objR0 = R0(list, interfaceC4014c);
                return objR0 == C4063a.g() ? objR0 : Y8.t.f7040a;
            }
            if (p.d(bVar, b.a.f10898a)) {
                Y(list, iB1);
            } else if (p.d(bVar, b.i.f10908a)) {
                T0(list, iB1);
            } else {
                if (bVar instanceof b.g) {
                    Object objN0 = N0(list, iB1, (b.g) bVar, interfaceC4014c);
                    return objN0 == C4063a.g() ? objN0 : Y8.t.f7040a;
                }
                if (bVar instanceof b.C0138b) {
                    g0(this, list, iB1, (b.C0138b) bVar, false, 8, null);
                } else if (bVar instanceof b.j) {
                    Y0(list, iB1, (b.j) bVar);
                } else if (bVar instanceof b.e) {
                    v0(list, iB1, (b.e) bVar);
                } else if (bVar instanceof b.d) {
                    k0(list, iB1, (b.d) bVar);
                } else {
                    if (!(bVar instanceof b.f)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    I0(this, list, iB1, false, 4, null);
                }
            }
        }
        return Y8.t.f7040a;
    }

    public final void Y(List<androidx.camera.camera2.pipe.graph.b> commands, int idx) {
        h hVar = this.currentRequestProcessor;
        if (hVar != null) {
            hVar.a();
        }
        this.currentRepeatingRequest = null;
        commands.remove(idx);
        int i10 = 0;
        while (i10 < idx) {
            androidx.camera.camera2.pipe.graph.b bVar = commands.get(i10);
            if (!p.d(bVar, b.i.f10908a) && !p.d(bVar, b.a.f10898a) && !(bVar instanceof b.f) && !(bVar instanceof b.j)) {
                if (bVar instanceof b.C0138b) {
                    b(((b.C0138b) bVar).a());
                } else {
                    i10++;
                }
            }
            commands.remove(i10);
            idx--;
        }
    }

    public final void Y0(List<androidx.camera.camera2.pipe.graph.b> commands, int idx, b.j command) {
        t tVar = this.currentRepeatingRequest;
        if (tVar == null && idx == 0) {
            commands.remove(idx);
            return;
        }
        if (G() && tVar != null && m(false, C1172u.e(tVar), command.a())) {
            commands.remove(idx);
        } else if (idx > 0) {
            int i10 = idx - 1;
            if (!(commands.get(i10) instanceof b.f)) {
                throw new IllegalStateException("Check failed.");
            }
            D0(commands, i10, false);
        }
    }

    public final boolean a1() {
        h hVar = this.currentRequestProcessor;
        if (hVar == null) {
            return false;
        }
        t tVar = this.currentRepeatingRequest;
        return p.d(tVar != null ? Boolean.valueOf(hVar.g(true, C1172u.e(tVar), this.defaultParameters, this.currentGraphParameters, this.currentRequiredParameters, this.currentRequestListeners)) : null, Boolean.TRUE);
    }

    public final void b(List<t> requests) {
        List<t> list = requests;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            t tVar = requests.get(i10);
            int size2 = this.currentRequestListeners.size();
            for (int i11 = 0; i11 < size2; i11++) {
                this.currentRequestListeners.get(i11).G(tVar);
            }
        }
        int size3 = list.size();
        for (int i12 = 0; i12 < size3; i12++) {
            t tVar2 = requests.get(i12);
            int size4 = tVar2.d().size();
            for (int i13 = 0; i13 < size4; i13++) {
                tVar2.d().get(i13).G(tVar2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b1(java.util.List<androidx.camera.camera2.pipe.graph.b> r11) {
        /*
            r10 = this;
            int r0 = r11.size()
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L9
            return r2
        L9:
            r0 = r11
            java.util.Collection r0 = (java.util.Collection) r0
            int r1 = r0.size()
            r3 = -1
            int r1 = r1 + r3
            r4 = r3
            if (r1 < 0) goto L4b
        L15:
            int r5 = r1 + (-1)
            java.lang.Object r6 = r11.get(r1)
            androidx.camera.camera2.pipe.graph.b r6 = (androidx.camera.camera2.pipe.graph.b) r6
            androidx.camera.camera2.pipe.graph.b$a r7 = androidx.camera.camera2.pipe.graph.b.a.f10898a
            boolean r7 = kotlin.jvm.internal.p.d(r6, r7)
            if (r7 != 0) goto L4a
            androidx.camera.camera2.pipe.graph.b$c r7 = androidx.camera.camera2.pipe.graph.b.c.f10900a
            boolean r7 = kotlin.jvm.internal.p.d(r6, r7)
            if (r7 != 0) goto L4a
            androidx.camera.camera2.pipe.graph.b$i r7 = androidx.camera.camera2.pipe.graph.b.i.f10908a
            boolean r7 = kotlin.jvm.internal.p.d(r6, r7)
            if (r7 != 0) goto L4a
            androidx.camera.camera2.pipe.graph.b$h r7 = androidx.camera.camera2.pipe.graph.b.h.f10907a
            boolean r7 = kotlin.jvm.internal.p.d(r6, r7)
            if (r7 == 0) goto L3e
            goto L4a
        L3e:
            boolean r6 = r6 instanceof androidx.camera.camera2.pipe.graph.b.g
            if (r6 == 0) goto L45
            if (r4 >= 0) goto L45
            r4 = r1
        L45:
            if (r5 >= 0) goto L48
            goto L4b
        L48:
            r1 = r5
            goto L15
        L4a:
            return r1
        L4b:
            if (r4 < 0) goto L4e
            return r4
        L4e:
            int r1 = r0.size()
            r4 = r2
            r5 = r3
            r6 = r5
        L55:
            if (r4 >= r1) goto L71
            java.lang.Object r7 = r11.get(r4)
            androidx.camera.camera2.pipe.graph.b r7 = (androidx.camera.camera2.pipe.graph.b) r7
            boolean r8 = r7 instanceof androidx.camera.camera2.pipe.graph.b.e
            if (r8 == 0) goto L63
            r5 = r4
            goto L6e
        L63:
            boolean r8 = r7 instanceof androidx.camera.camera2.pipe.graph.b.d
            if (r8 == 0) goto L69
            r6 = r4
            goto L6e
        L69:
            boolean r7 = r7 instanceof androidx.camera.camera2.pipe.graph.b.f
            if (r7 != 0) goto L6e
            goto L71
        L6e:
            int r4 = r4 + 1
            goto L55
        L71:
            if (r5 < 0) goto L74
            return r5
        L74:
            if (r6 < 0) goto L77
            return r6
        L77:
            androidx.camera.camera2.pipe.t r1 = r10.currentRepeatingRequest
            if (r1 == 0) goto L9b
            boolean r10 = r10.G()
            if (r10 == 0) goto L9b
            int r10 = r0.size()
            r1 = r2
        L86:
            if (r1 >= r10) goto L9b
            java.lang.Object r4 = r11.get(r1)
            androidx.camera.camera2.pipe.graph.b r4 = (androidx.camera.camera2.pipe.graph.b) r4
            boolean r5 = r4 instanceof androidx.camera.camera2.pipe.graph.b.C0138b
            if (r5 != 0) goto L9a
            boolean r4 = r4 instanceof androidx.camera.camera2.pipe.graph.b.j
            if (r4 == 0) goto L97
            goto L9a
        L97:
            int r1 = r1 + 1
            goto L86
        L9a:
            return r1
        L9b:
            int r10 = r0.size()
            r0 = r3
            r3 = r2
        La1:
            if (r3 >= r10) goto Lb3
            java.lang.Object r1 = r11.get(r3)
            androidx.camera.camera2.pipe.graph.b r1 = (androidx.camera.camera2.pipe.graph.b) r1
            boolean r1 = r1 instanceof androidx.camera.camera2.pipe.graph.b.f
            if (r1 == 0) goto Lb3
            int r0 = r3 + 1
            r9 = r3
            r3 = r0
            r0 = r9
            goto La1
        Lb3:
            if (r0 < 0) goto Lb6
            return r0
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.GraphLoop.b1(java.util.List):int");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                h hVar = this._requestProcessor;
                if (hVar != null) {
                    C1060i.d(this.shutdownScope, null, null, new GraphLoop$close$1$1$1(hVar, null), 3, null);
                }
                this._requestProcessor = null;
                this.processingQueue.j(b.h.f10907a);
                int size = this.listeners.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.listeners.get(i10).h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e0(List<androidx.camera.camera2.pipe.graph.b> commands, int idx, b.C0138b command, boolean repeatAllowed) {
        GraphLoop graphLoop;
        if (G()) {
            graphLoop = this;
            if (n(graphLoop, false, command.a(), null, 4, null)) {
                commands.remove(idx);
                return;
            }
        } else {
            graphLoop = this;
        }
        if (!repeatAllowed || idx <= 0) {
            return;
        }
        int i10 = idx - 1;
        if (!(commands.get(i10) instanceof b.f)) {
            throw new IllegalStateException("Check failed.");
        }
        graphLoop.D0(commands, i10, false);
    }

    public final void f1(boolean z10) {
        this._captureProcessingEnabled.c(z10);
        if (z10) {
            U();
        }
    }

    public final void h1(Map<?, ? extends Object> value) {
        p.i(value, "value");
        synchronized (this.lock) {
            this._graph3AParameters = value;
            this.processingQueue.j(new b.e(this._graphParameters, value));
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void k0(List<androidx.camera.camera2.pipe.graph.b> commands, int idx, b.d command) {
        this.currentRequestListeners = F.g0(F.S0(command.a(), this.requiredListeners));
        commands.remove(idx);
        int i10 = 0;
        while (i10 < idx) {
            if (commands.get(i10) instanceof b.d) {
                commands.remove(i10);
                idx--;
            } else {
                i10++;
            }
        }
        a1();
    }

    public final void k1(Map<?, ? extends Object> value) {
        p.i(value, "value");
        synchronized (this.lock) {
            this._graphParameters = value;
            this.processingQueue.j(new b.e(value, this._graph3AParameters));
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void l1(t tVar) {
        synchronized (this.lock) {
            try {
                t tVar2 = this._repeatingRequest;
                this._repeatingRequest = tVar;
                if (tVar2 != null || tVar != null) {
                    if (tVar != null) {
                        this.processingQueue.j(new b.f(tVar));
                    } else {
                        this.processingQueue.j(b.i.f10908a);
                    }
                }
                Y8.t tVar3 = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (tVar == null) {
            int size = this.listeners.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.listeners.get(i10).f();
            }
        }
    }

    public final boolean m(boolean isRepeating, List<t> requests, Map<?, ? extends Object> oneTimeRequiredParameters) throws Exception {
        Map<?, ? extends Object> mapB;
        h hVar = this.currentRequestProcessor;
        if (hVar == null) {
            return false;
        }
        Map<?, ? extends Object> map = this.defaultParameters;
        Map<?, ? extends Object> map2 = this.currentGraphParameters;
        if (oneTimeRequiredParameters.isEmpty()) {
            mapB = this.currentRequiredParameters;
        } else {
            Map mapC = Q.c();
            u.a(mapC, this.currentGraph3AParameters);
            u.a(mapC, oneTimeRequiredParameters);
            u.a(mapC, this.requiredParameters);
            Y8.t tVar = Y8.t.f7040a;
            mapB = Q.b(mapC);
        }
        boolean zG = hVar.g(isRepeating, requests, map, map2, mapB, this.currentRequestListeners);
        if (!zG) {
            if (isRepeating) {
                if (k.f44508a.d()) {
                    Log.w("CXCP", "Failed to repeat with " + F.X0(requests));
                    return zG;
                }
            } else if (oneTimeRequiredParameters.isEmpty()) {
                if (k.f44508a.d()) {
                    Log.w("CXCP", "Failed to submit capture with " + requests);
                    return zG;
                }
            } else if (k.f44508a.d()) {
                Log.w("CXCP", "Failed to trigger with " + F.X0(requests) + " and " + oneTimeRequiredParameters);
            }
        }
        return zG;
    }

    public final void m1(List<? extends t.a> value) {
        p.i(value, "value");
        synchronized (this.lock) {
            this._requestListeners = value;
            this.processingQueue.j(new b.d(value));
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void s1(h hVar) {
        synchronized (this.lock) {
            h hVar2 = this._requestProcessor;
            this._requestProcessor = hVar;
            if (this.closed) {
                this._requestProcessor = null;
                if (hVar != null) {
                    C1060i.d(this.shutdownScope, null, null, new GraphLoop$requestProcessor$2$1(hVar, null), 3, null);
                }
                return;
            }
            if (hVar2 != hVar) {
                this.processingQueue.j(new b.g(hVar2, hVar));
            }
            Y8.t tVar = Y8.t.f7040a;
            if (hVar == null) {
                int size = this.listeners.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.listeners.get(i10).d();
                }
            }
        }
    }

    public final boolean t1(List<t> requests) {
        p.i(requests, "requests");
        if (this.processingQueue.j(new b.C0138b(requests))) {
            return true;
        }
        b(requests);
        return false;
    }

    public String toString() {
        return "GraphLoop(" + this.cameraGraphId + ')';
    }

    public final boolean u1(Map<?, ? extends Object> parameters) {
        p.i(parameters, "parameters");
        if (J() != null) {
            return this.processingQueue.j(new b.j(parameters));
        }
        throw new IllegalStateException("Cannot submit parameters without an active repeating request!");
    }

    public final void v0(List<androidx.camera.camera2.pipe.graph.b> commands, int idx, b.e command) {
        Map<?, ? extends Object> mapB;
        this.currentGraphParameters = command.b();
        this.currentGraph3AParameters = command.a();
        if (command.a().isEmpty()) {
            mapB = this.requiredParameters;
        } else {
            Map mapC = Q.c();
            u.a(mapC, command.a());
            u.a(mapC, this.requiredParameters);
            mapB = Q.b(mapC);
        }
        this.currentRequiredParameters = mapB;
        commands.remove(idx);
        int i10 = 0;
        while (i10 < idx) {
            if (commands.get(i10) instanceof b.e) {
                commands.remove(i10);
                idx--;
            } else {
                i10++;
            }
        }
        a1();
    }
}
