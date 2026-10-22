package okhttp3.internal.http2;

import Bb.p;
import Bb.r;
import Bb.s;
import Cb.WindowCounter;
import Mb.C0966d;
import Mb.InterfaceC0968f;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.utils.Utils;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import okhttp3.internal.http2.a;
import okhttp3.internal.http2.c;
import okhttp3.internal.http2.d;
import okio.ByteString;
import p9.InterfaceC5063a;
import tb.u;
import ub.n;
import ub.q;
import xb.C5872c;
import xb.C5873d;
import yb.InterfaceC6020a;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0005\u0018\u0000 Ê\u00012\u00020\u00012\u00020\u0002:\u0004Uga[B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J-\u0010#\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0004\b#\u0010$J/\u0010(\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u001b¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010.\u001a\u00020*H\u0000¢\u0006\u0004\b/\u0010-J\u001f\u00101\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u001bH\u0000¢\u0006\u0004\b1\u00102J%\u00106\u001a\u00020\u00132\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u0013¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u00132\u0006\u0010.\u001a\u00020*¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0013H\u0016¢\u0006\u0004\b<\u00109J)\u0010@\u001a\u00020\u00132\u0006\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b@\u0010AJ\u0019\u0010C\u001a\u00020\u00132\b\b\u0002\u0010B\u001a\u00020\fH\u0007¢\u0006\u0004\bC\u0010DJ\u0015\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u001b¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0013H\u0000¢\u0006\u0004\bH\u00109J\u0017\u0010I\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0007H\u0000¢\u0006\u0004\bI\u0010JJ%\u0010K\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0004\bK\u0010LJ-\u0010N\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010M\u001a\u00020\fH\u0000¢\u0006\u0004\bN\u0010OJ/\u0010R\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020P2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\fH\u0000¢\u0006\u0004\bR\u0010SJ\u001f\u0010T\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\bT\u0010-R\u001a\u0010Y\u001a\u00020\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001a\u0010_\u001a\u00020Z8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R&\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0`8\u0000X\u0080\u0004¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001a\u0010k\u001a\u00020f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\"\u0010q\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010u\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\br\u0010l\u001a\u0004\bs\u0010n\"\u0004\bt\u0010pR\u0016\u0010w\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010VR\u0014\u0010{\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0016\u0010\u0081\u0001\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010~R\u0016\u0010\u0083\u0001\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010~R\u0018\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0089\u0001R\u0019\u0010\u008e\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u0089\u0001R\u0019\u0010\u0090\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0089\u0001R\u0019\u0010\u0092\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0089\u0001R\u0019\u0010\u0094\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0089\u0001R \u0010\u009a\u0001\u001a\u00030\u0095\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001d\u0010 \u0001\u001a\u00030\u009b\u00018\u0006¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R*\u0010¥\u0001\u001a\u00030\u009b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010\u009d\u0001\u001a\u0006\b¢\u0001\u0010\u009f\u0001\"\u0006\b£\u0001\u0010¤\u0001R\u001d\u0010«\u0001\u001a\u00030¦\u00018\u0006¢\u0006\u0010\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001R*\u0010°\u0001\u001a\u00020\u001b2\u0007\u0010¬\u0001\u001a\u00020\u001b8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u00ad\u0001\u0010\u0089\u0001\u001a\u0006\b®\u0001\u0010¯\u0001R*\u0010³\u0001\u001a\u00020\u001b2\u0007\u0010¬\u0001\u001a\u00020\u001b8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b±\u0001\u0010\u0089\u0001\u001a\u0006\b²\u0001\u0010¯\u0001R \u0010¹\u0001\u001a\u00030´\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001R\u001d\u0010¿\u0001\u001a\u00030º\u00018\u0006¢\u0006\u0010\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001R!\u0010Å\u0001\u001a\u00070À\u0001R\u00020\u00008\u0006¢\u0006\u0010\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u001e\u0010É\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070Æ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001¨\u0006Ë\u0001"}, d2 = {"Lokhttp3/internal/http2/c;", "Ljava/io/Closeable;", "", "Lokhttp3/internal/http2/c$a;", "builder", "<init>", "(Lokhttp3/internal/http2/c$a;)V", "", "associatedStreamId", "", "LBb/a;", "requestHeaders", "", "out", "LBb/p;", "A1", "(ILjava/util/List;Z)LBb/p;", "Ljava/io/IOException;", "e", "LY8/t;", "b1", "(Ljava/io/IOException;)V", "id", "v1", "(I)LBb/p;", "streamId", "L1", "", "read", "T1", "(J)V", "B1", "(Ljava/util/List;Z)LBb/p;", "outFinished", "alternating", "V1", "(IZLjava/util/List;)V", "LMb/d;", "buffer", "byteCount", "U1", "(IZLMb/d;J)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Z1", "(ILokhttp3/internal/http2/ErrorCode;)V", "statusCode", "X1", "unacknowledgedBytesRead", "b2", "(IJ)V", Constants.PARAM_REPLY, "payload1", "payload2", "W1", "(ZII)V", "flush", "()V", "Q1", "(Lokhttp3/internal/http2/ErrorCode;)V", "close", "connectionCode", "streamCode", "cause", SdCardDbCreator.FIELD_LASTLOC_ID, "(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "sendConnectionPreface", "R1", "(Z)V", "nowNs", "z1", "(J)Z", "N1", "K1", "(I)Z", "H1", "(ILjava/util/List;)V", "inFinished", "F1", "(ILjava/util/List;Z)V", "LMb/f;", "source", "D1", "(ILMb/f;IZ)V", "J1", Const.INTENT_KEY_APIKEY, "Z", "f1", "()Z", "client", "Lokhttp3/internal/http2/c$c;", Const.INTENT_KEY_PKGNAME, "Lokhttp3/internal/http2/c$c;", "m1", "()Lokhttp3/internal/http2/c$c;", "listener", "", "c", "Ljava/util/Map;", "w1", "()Ljava/util/Map;", "streams", "", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "h1", "()Ljava/lang/String;", "connectionName", "I", "l1", "()I", "O1", "(I)V", "lastGoodStreamId", "f", "s1", "setNextStreamId$okhttp", "nextStreamId", Const.INTENT_KEY_BACKGROUND_COMMAND, "isShutdown", "Lxb/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lxb/d;", "taskRunner", "Lxb/c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lxb/c;", "writerQueue", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "pushQueue", "k", "settingsListenerQueue", "LBb/r;", "l", "LBb/r;", "pushObserver", "m", "J", "intervalPingsSent", "n", "intervalPongsReceived", "o", "degradedPingsSent", "p", "degradedPongsReceived", "q", "awaitPongsReceived", "r", "degradedPongDeadlineNs", "Lokhttp3/internal/http2/a;", "s", "Lokhttp3/internal/http2/a;", "k1", "()Lokhttp3/internal/http2/a;", "flowControlListener", "LBb/s;", "t", "LBb/s;", "t1", "()LBb/s;", "okHttpSettings", "u", "u1", "P1", "(LBb/s;)V", "peerSettings", "LCb/a;", "v", "LCb/a;", "getReadBytes", "()LCb/a;", "readBytes", UxipConstants.f30680s, "w", "getWriteBytesTotal", "()J", "writeBytesTotal", "x", "x1", "writeBytesMaximum", "Lyb/a;", "y", "Lyb/a;", "getSocket$okhttp", "()Lyb/a;", "socket", "Lokhttp3/internal/http2/e;", "z", "Lokhttp3/internal/http2/e;", "y1", "()Lokhttp3/internal/http2/e;", "writer", "Lokhttp3/internal/http2/c$d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lokhttp3/internal/http2/c$d;", "getReaderRunnable", "()Lokhttp3/internal/http2/c$d;", "readerRunnable", "", "B", "Ljava/util/Set;", "currentPushRequests", "C", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class c implements Closeable {

    /* renamed from: C, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: collision with root package name */
    public static final s f37671D;

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public final d readerRunnable;

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public final Set<Integer> currentPushRequests;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean client;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AbstractC0484c listener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<Integer, p> streams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String connectionName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int lastGoodStreamId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int nextStreamId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean isShutdown;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final C5873d taskRunner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final C5872c writerQueue;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final C5872c pushQueue;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final C5872c settingsListenerQueue;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final r pushObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public long intervalPingsSent;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public long intervalPongsReceived;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public long degradedPingsSent;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public long degradedPongsReceived;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public long awaitPongsReceived;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public long degradedPongDeadlineNs;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final okhttp3.internal.http2.a flowControlListener;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public final s okHttpSettings;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public s peerSettings;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public final WindowCounter readBytes;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public long writeBytesTotal;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public long writeBytesMaximum;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6020a socket;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final e writer;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b#\u0010$R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u001e\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010/\u001a\u00020\n8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010<\u001a\u0002068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0013\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b=\u0010?\"\u0004\b@\u0010AR\"\u0010\u0017\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b8\u0010B\u001a\u0004\b0\u0010C\"\u0004\bD\u0010E¨\u0006F"}, d2 = {"Lokhttp3/internal/http2/c$a;", "", "", "client", "Lxb/d;", "taskRunner", "<init>", "(ZLxb/d;)V", "Lyb/a;", "socket", "", "peerName", "o", "(Lyb/a;Ljava/lang/String;)Lokhttp3/internal/http2/c$a;", "Lokhttp3/internal/http2/c$c;", "listener", "k", "(Lokhttp3/internal/http2/c$c;)Lokhttp3/internal/http2/c$a;", "", "pingIntervalMillis", "l", "(I)Lokhttp3/internal/http2/c$a;", "Lokhttp3/internal/http2/a;", "flowControlListener", Const.INTENT_KEY_PKGNAME, "(Lokhttp3/internal/http2/a;)Lokhttp3/internal/http2/c$a;", "Lokhttp3/internal/http2/c;", Const.INTENT_KEY_APIKEY, "()Lokhttp3/internal/http2/c;", "Z", "c", "()Z", "setClient$okhttp", "(Z)V", "Lxb/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lxb/d;", "Lyb/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lyb/a;", "n", "(Lyb/a;)V", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "()Ljava/lang/String;", "m", "(Ljava/lang/String;)V", "connectionName", "e", "Lokhttp3/internal/http2/c$c;", "f", "()Lokhttp3/internal/http2/c$c;", "setListener$okhttp", "(Lokhttp3/internal/http2/c$c;)V", "LBb/r;", "LBb/r;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()LBb/r;", "setPushObserver$okhttp", "(LBb/r;)V", "pushObserver", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", "()I", "setPingIntervalMillis$okhttp", "(I)V", "Lokhttp3/internal/http2/a;", "()Lokhttp3/internal/http2/a;", "setFlowControlListener$okhttp", "(Lokhttp3/internal/http2/a;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public boolean client;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final C5873d taskRunner;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public InterfaceC6020a socket;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public String connectionName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public AbstractC0484c listener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public r pushObserver;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public int pingIntervalMillis;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public okhttp3.internal.http2.a flowControlListener;

        public a(boolean z10, C5873d taskRunner) {
            kotlin.jvm.internal.p.i(taskRunner, "taskRunner");
            this.client = z10;
            this.taskRunner = taskRunner;
            this.listener = AbstractC0484c.f37709b;
            this.pushObserver = r.f1572b;
            this.flowControlListener = a.C0482a.f37647a;
        }

        public final c a() {
            return new c(this);
        }

        public final a b(okhttp3.internal.http2.a flowControlListener) {
            kotlin.jvm.internal.p.i(flowControlListener, "flowControlListener");
            this.flowControlListener = flowControlListener;
            return this;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getClient() {
            return this.client;
        }

        public final String d() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            kotlin.jvm.internal.p.A("connectionName");
            return null;
        }

        /* renamed from: e, reason: from getter */
        public final okhttp3.internal.http2.a getFlowControlListener() {
            return this.flowControlListener;
        }

        /* renamed from: f, reason: from getter */
        public final AbstractC0484c getListener() {
            return this.listener;
        }

        /* renamed from: g, reason: from getter */
        public final int getPingIntervalMillis() {
            return this.pingIntervalMillis;
        }

        /* renamed from: h, reason: from getter */
        public final r getPushObserver() {
            return this.pushObserver;
        }

        public final InterfaceC6020a i() {
            InterfaceC6020a interfaceC6020a = this.socket;
            if (interfaceC6020a != null) {
                return interfaceC6020a;
            }
            kotlin.jvm.internal.p.A("socket");
            return null;
        }

        /* renamed from: j, reason: from getter */
        public final C5873d getTaskRunner() {
            return this.taskRunner;
        }

        public final a k(AbstractC0484c listener) {
            kotlin.jvm.internal.p.i(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final a l(int pingIntervalMillis) {
            this.pingIntervalMillis = pingIntervalMillis;
            return this;
        }

        public final void m(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.connectionName = str;
        }

        public final void n(InterfaceC6020a interfaceC6020a) {
            kotlin.jvm.internal.p.i(interfaceC6020a, "<set-?>");
            this.socket = interfaceC6020a;
        }

        public final a o(InterfaceC6020a socket, String peerName) throws IOException {
            String str;
            kotlin.jvm.internal.p.i(socket, "socket");
            kotlin.jvm.internal.p.i(peerName, "peerName");
            n(socket);
            if (this.client) {
                str = q.f42675c + ' ' + peerName;
            } else {
                str = "MockWebServer " + peerName;
            }
            m(str);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/c$b;", "", "<init>", "()V", "LBb/s;", "DEFAULT_SETTINGS", "LBb/s;", Const.INTENT_KEY_APIKEY, "()LBb/s;", "", "OKHTTP_CLIENT_WINDOW_SIZE", "I", "INTERVAL_PING", "DEGRADED_PING", "AWAIT_PING", "DEGRADED_PONG_TIMEOUT_NS", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.internal.http2.c$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final s a() {
            return c.f37671D;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/http2/c$c;", "", "<init>", "()V", "LBb/p;", "stream", "LY8/t;", "f", "(LBb/p;)V", "Lokhttp3/internal/http2/c;", "connection", "LBb/s;", "settings", "c", "(Lokhttp3/internal/http2/c;LBb/s;)V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.internal.http2.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0484c {

        /* renamed from: b, reason: collision with root package name */
        public static final AbstractC0484c f37709b = new a();

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"okhttp3/internal/http2/c$c$a", "Lokhttp3/internal/http2/c$c;", "LBb/p;", "stream", "LY8/t;", "f", "(LBb/p;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: okhttp3.internal.http2.c$c$a */
        public static final class a extends AbstractC0484c {
            @Override // okhttp3.internal.http2.c.AbstractC0484c
            public void f(p stream) throws IOException {
                kotlin.jvm.internal.p.i(stream, "stream");
                stream.g(ErrorCode.REFUSED_STREAM, null);
            }
        }

        public void c(c connection, s settings) {
            kotlin.jvm.internal.p.i(connection, "connection");
            kotlin.jvm.internal.p.i(settings, "settings");
        }

        public abstract void f(p stream) throws IOException;
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010\tJ'\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010(J'\u0010,\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J/\u00105\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\nH\u0016¢\u0006\u0004\b5\u00106J-\u00109\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b9\u0010:R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010;\u001a\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lokhttp3/internal/http2/c$d;", "Lokhttp3/internal/http2/d$c;", "Lkotlin/Function0;", "LY8/t;", "Lokhttp3/internal/http2/d;", "reader", "<init>", "(Lokhttp3/internal/http2/c;Lokhttp3/internal/http2/d;)V", "t", "()V", "", "inFinished", "", "streamId", "LMb/f;", "source", "length", Const.INTENT_KEY_PKGNAME, "(ZILMb/f;I)V", "associatedStreamId", "", "LBb/a;", "headerBlock", "c", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "LBb/s;", "settings", Const.INTENT_KEY_APIKEY, "(ZLBb/s;)V", "p", "f", "ack", "payload1", "payload2", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ZII)V", "lastGoodStreamId", "Lokio/ByteString;", "debugData", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "", "windowSizeIncrement", Const.INTENT_KEY_UMID, "(IJ)V", "streamDependency", "weight", "exclusive", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(IIIZ)V", "promisedStreamId", "requestHeaders", "e", "(IILjava/util/List;)V", "Lokhttp3/internal/http2/d;", "getReader$okhttp", "()Lokhttp3/internal/http2/d;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class d implements d.c, InterfaceC5063a<t> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final okhttp3.internal.http2.d reader;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f37711b;

        public d(c cVar, okhttp3.internal.http2.d reader) {
            kotlin.jvm.internal.p.i(reader, "reader");
            this.f37711b = cVar;
            this.reader = reader;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final t q(c cVar, Ref$ObjectRef ref$ObjectRef) {
            cVar.getListener().c(cVar, (s) ref$ObjectRef.f34820a);
            return t.f7040a;
        }

        public static final t r(c cVar, p pVar) {
            try {
                cVar.getListener().f(pVar);
            } catch (IOException e10) {
                okhttp3.internal.platform.c.INSTANCE.e().log("Http2Connection.Listener failure for " + cVar.getConnectionName(), 4, e10);
                try {
                    pVar.g(ErrorCode.PROTOCOL_ERROR, e10);
                } catch (IOException unused) {
                }
            }
            return t.f7040a;
        }

        public static final t v(c cVar, int i10, int i11) {
            cVar.W1(true, i10, i11);
            return t.f7040a;
        }

        public static final t w(d dVar, boolean z10, s sVar) {
            dVar.p(z10, sVar);
            return t.f7040a;
        }

        @Override // okhttp3.internal.http2.d.c
        public void a(final boolean clearPrevious, final s settings) {
            kotlin.jvm.internal.p.i(settings, "settings");
            C5872c.d(this.f37711b.writerQueue, this.f37711b.getConnectionName() + " applyAndAckSettings", 0L, false, new InterfaceC5063a() { // from class: Bb.m
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return c.d.w(this.f1523a, clearPrevious, settings);
                }
            }, 6, null);
        }

        @Override // okhttp3.internal.http2.d.c
        public void b(boolean inFinished, int streamId, InterfaceC0968f source, int length) throws IOException {
            kotlin.jvm.internal.p.i(source, "source");
            if (this.f37711b.K1(streamId)) {
                this.f37711b.D1(streamId, source, length, inFinished);
                return;
            }
            p pVarV1 = this.f37711b.v1(streamId);
            if (pVarV1 == null) {
                this.f37711b.Z1(streamId, ErrorCode.PROTOCOL_ERROR);
                long j10 = length;
                this.f37711b.T1(j10);
                source.skip(j10);
                return;
            }
            pVarV1.z(source, length);
            if (inFinished) {
                pVarV1.A(u.f42241c, true);
            }
        }

        @Override // okhttp3.internal.http2.d.c
        public void c(boolean inFinished, int streamId, int associatedStreamId, List<Bb.a> headerBlock) {
            kotlin.jvm.internal.p.i(headerBlock, "headerBlock");
            if (this.f37711b.K1(streamId)) {
                this.f37711b.F1(streamId, headerBlock, inFinished);
                return;
            }
            final c cVar = this.f37711b;
            synchronized (cVar) {
                p pVarV1 = cVar.v1(streamId);
                if (pVarV1 != null) {
                    t tVar = t.f7040a;
                    pVarV1.A(q.t(headerBlock), inFinished);
                    return;
                }
                if (cVar.isShutdown) {
                    return;
                }
                if (streamId <= cVar.getLastGoodStreamId()) {
                    return;
                }
                if (streamId % 2 == cVar.getNextStreamId() % 2) {
                    return;
                }
                final p pVar = new p(streamId, cVar, false, inFinished, q.t(headerBlock));
                cVar.O1(streamId);
                cVar.w1().put(Integer.valueOf(streamId), pVar);
                C5872c.d(cVar.taskRunner.k(), cVar.getConnectionName() + '[' + streamId + "] onStream", 0L, false, new InterfaceC5063a() { // from class: Bb.l
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return c.d.r(cVar, pVar);
                    }
                }, 6, null);
            }
        }

        @Override // okhttp3.internal.http2.d.c
        public void d(int streamId, long windowSizeIncrement) {
            if (streamId == 0) {
                c cVar = this.f37711b;
                synchronized (cVar) {
                    cVar.writeBytesMaximum = cVar.getWriteBytesMaximum() + windowSizeIncrement;
                    kotlin.jvm.internal.p.g(cVar, "null cannot be cast to non-null type java.lang.Object");
                    cVar.notifyAll();
                    t tVar = t.f7040a;
                }
                return;
            }
            p pVarV1 = this.f37711b.v1(streamId);
            if (pVarV1 != null) {
                synchronized (pVarV1) {
                    pVarV1.c(windowSizeIncrement);
                    t tVar2 = t.f7040a;
                }
            }
        }

        @Override // okhttp3.internal.http2.d.c
        public void e(int streamId, int promisedStreamId, List<Bb.a> requestHeaders) {
            kotlin.jvm.internal.p.i(requestHeaders, "requestHeaders");
            this.f37711b.H1(promisedStreamId, requestHeaders);
        }

        @Override // okhttp3.internal.http2.d.c
        public void f() {
        }

        @Override // okhttp3.internal.http2.d.c
        public void g(boolean ack, final int payload1, final int payload2) {
            if (!ack) {
                C5872c c5872c = this.f37711b.writerQueue;
                String str = this.f37711b.getConnectionName() + " ping";
                final c cVar = this.f37711b;
                C5872c.d(c5872c, str, 0L, false, new InterfaceC5063a() { // from class: Bb.k
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return c.d.v(cVar, payload1, payload2);
                    }
                }, 6, null);
                return;
            }
            c cVar2 = this.f37711b;
            synchronized (cVar2) {
                try {
                    if (payload1 == 1) {
                        cVar2.intervalPongsReceived++;
                    } else if (payload1 != 2) {
                        if (payload1 == 3) {
                            cVar2.awaitPongsReceived++;
                            kotlin.jvm.internal.p.g(cVar2, "null cannot be cast to non-null type java.lang.Object");
                            cVar2.notifyAll();
                        }
                        t tVar = t.f7040a;
                    } else {
                        cVar2.degradedPongsReceived++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okhttp3.internal.http2.d.c
        public void h(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        @Override // okhttp3.internal.http2.d.c
        public void i(int streamId, ErrorCode errorCode) {
            kotlin.jvm.internal.p.i(errorCode, "errorCode");
            if (this.f37711b.K1(streamId)) {
                this.f37711b.J1(streamId, errorCode);
                return;
            }
            p pVarL1 = this.f37711b.L1(streamId);
            if (pVarL1 != null) {
                pVarL1.B(errorCode);
            }
        }

        @Override // p9.InterfaceC5063a
        public /* bridge */ /* synthetic */ t invoke() throws Throwable {
            t();
            return t.f7040a;
        }

        @Override // okhttp3.internal.http2.d.c
        public void j(int lastGoodStreamId, ErrorCode errorCode, ByteString debugData) {
            int i10;
            Object[] array;
            kotlin.jvm.internal.p.i(errorCode, "errorCode");
            kotlin.jvm.internal.p.i(debugData, "debugData");
            debugData.K();
            c cVar = this.f37711b;
            synchronized (cVar) {
                array = cVar.w1().values().toArray(new p[0]);
                cVar.isShutdown = true;
                t tVar = t.f7040a;
            }
            for (p pVar : (p[]) array) {
                if (pVar.getId() > lastGoodStreamId && pVar.v()) {
                    pVar.B(ErrorCode.REFUSED_STREAM);
                    this.f37711b.L1(pVar.getId());
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r15v1 */
        /* JADX WARN: Type inference failed for: r15v2, types: [Bb.s, T] */
        /* JADX WARN: Type inference failed for: r15v3 */
        public final void p(boolean clearPrevious, s settings) {
            ?? r15;
            long jC;
            int i10;
            p[] pVarArr;
            kotlin.jvm.internal.p.i(settings, "settings");
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            e writer = this.f37711b.getWriter();
            final c cVar = this.f37711b;
            synchronized (writer) {
                synchronized (cVar) {
                    try {
                        s peerSettings = cVar.getPeerSettings();
                        if (clearPrevious) {
                            r15 = settings;
                        } else {
                            s sVar = new s();
                            sVar.g(peerSettings);
                            sVar.g(settings);
                            r15 = sVar;
                        }
                        ref$ObjectRef.f34820a = r15;
                        jC = r15.c() - peerSettings.c();
                        pVarArr = (jC == 0 || cVar.w1().isEmpty()) ? null : (p[]) cVar.w1().values().toArray(new p[0]);
                        cVar.P1((s) ref$ObjectRef.f34820a);
                        C5872c.d(cVar.settingsListenerQueue, cVar.getConnectionName() + " onSettings", 0L, false, new InterfaceC5063a() { // from class: Bb.n
                            @Override // p9.InterfaceC5063a
                            public final Object invoke() {
                                return c.d.q(cVar, ref$ObjectRef);
                            }
                        }, 6, null);
                        t tVar = t.f7040a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    cVar.getWriter().b((s) ref$ObjectRef.f34820a);
                } catch (IOException e10) {
                    cVar.b1(e10);
                }
                t tVar2 = t.f7040a;
            }
            if (pVarArr != null) {
                for (p pVar : pVarArr) {
                    synchronized (pVar) {
                        pVar.c(jC);
                        t tVar3 = t.f7040a;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable, okhttp3.internal.http2.d] */
        public void t() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e10 = null;
            try {
                try {
                    this.reader.g(this);
                    while (this.reader.e(false, this)) {
                    }
                    ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                    try {
                        errorCode2 = ErrorCode.CANCEL;
                        this.f37711b.a1(errorCode3, errorCode2, null);
                        errorCode = errorCode3;
                    } catch (IOException e11) {
                        e10 = e11;
                        errorCode2 = ErrorCode.PROTOCOL_ERROR;
                        c cVar = this.f37711b;
                        cVar.a1(errorCode2, errorCode2, e10);
                        errorCode = cVar;
                        this = this.reader;
                        n.f(this);
                    }
                } catch (Throwable th) {
                    th = th;
                    this.f37711b.a1(errorCode, errorCode2, e10);
                    n.f(this.reader);
                    throw th;
                }
            } catch (IOException e12) {
                e10 = e12;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                this.f37711b.a1(errorCode, errorCode2, e10);
                n.f(this.reader);
                throw th;
            }
            this = this.reader;
            n.f(this);
        }
    }

    static {
        s sVar = new s();
        sVar.h(4, 65535);
        sVar.h(5, 16384);
        f37671D = sVar;
    }

    public c(a builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        boolean client = builder.getClient();
        this.client = client;
        this.listener = builder.getListener();
        this.streams = new LinkedHashMap();
        String strD = builder.d();
        this.connectionName = strD;
        this.nextStreamId = builder.getClient() ? 3 : 2;
        C5873d taskRunner = builder.getTaskRunner();
        this.taskRunner = taskRunner;
        C5872c c5872cK = taskRunner.k();
        this.writerQueue = c5872cK;
        this.pushQueue = taskRunner.k();
        this.settingsListenerQueue = taskRunner.k();
        this.pushObserver = builder.getPushObserver();
        this.flowControlListener = builder.getFlowControlListener();
        s sVar = new s();
        if (builder.getClient()) {
            sVar.h(4, 16777216);
        }
        this.okHttpSettings = sVar;
        this.peerSettings = f37671D;
        this.readBytes = new WindowCounter(0);
        this.writeBytesMaximum = this.peerSettings.c();
        InterfaceC6020a interfaceC6020aI = builder.i();
        this.socket = interfaceC6020aI;
        this.writer = new e(interfaceC6020aI.getSink(), client);
        this.readerRunnable = new d(this, new okhttp3.internal.http2.d(interfaceC6020aI.getSource(), client));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis() != 0) {
            final long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis());
            c5872cK.k(strD + " ping", nanos, new InterfaceC5063a() { // from class: Bb.c
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Long.valueOf(okhttp3.internal.http2.c.G(this.f1494a, nanos));
                }
            });
        }
    }

    public static final t C1(c cVar, int i10, C0966d c0966d, int i11, boolean z10) {
        try {
            boolean zD = cVar.pushObserver.d(i10, c0966d, i11, z10);
            if (zD) {
                cVar.writer.U(i10, ErrorCode.CANCEL);
            }
            if (zD || z10) {
                synchronized (cVar) {
                    cVar.currentPushRequests.remove(Integer.valueOf(i10));
                    t tVar = t.f7040a;
                }
            }
        } catch (IOException unused) {
        }
        return t.f7040a;
    }

    public static final t E1(c cVar, int i10, List list, boolean z10) {
        boolean zC = cVar.pushObserver.c(i10, list, z10);
        if (zC) {
            try {
                cVar.writer.U(i10, ErrorCode.CANCEL);
            } catch (IOException unused) {
            }
        }
        if (zC || z10) {
            synchronized (cVar) {
                cVar.currentPushRequests.remove(Integer.valueOf(i10));
                t tVar = t.f7040a;
            }
        }
        return t.f7040a;
    }

    public static final long G(c cVar, long j10) {
        boolean z10;
        synchronized (cVar) {
            long j11 = cVar.intervalPongsReceived;
            long j12 = cVar.intervalPingsSent;
            if (j11 < j12) {
                z10 = true;
            } else {
                cVar.intervalPingsSent = j12 + 1;
                z10 = false;
            }
        }
        if (z10) {
            cVar.b1(null);
            return -1L;
        }
        cVar.W1(false, 1, 0);
        return j10;
    }

    public static final t G1(c cVar, int i10, List list) {
        if (cVar.pushObserver.b(i10, list)) {
            try {
                cVar.writer.U(i10, ErrorCode.CANCEL);
                synchronized (cVar) {
                    cVar.currentPushRequests.remove(Integer.valueOf(i10));
                    t tVar = t.f7040a;
                }
            } catch (IOException unused) {
            }
        }
        return t.f7040a;
    }

    public static final t I1(c cVar, int i10, ErrorCode errorCode) {
        cVar.pushObserver.a(i10, errorCode);
        synchronized (cVar) {
            cVar.currentPushRequests.remove(Integer.valueOf(i10));
        }
        return t.f7040a;
    }

    public static final t M1(c cVar) {
        cVar.W1(false, 2, 0);
        return t.f7040a;
    }

    public static /* synthetic */ void S1(c cVar, boolean z10, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        cVar.R1(z10);
    }

    public static final t Y1(c cVar, int i10, ErrorCode errorCode) {
        try {
            cVar.X1(i10, errorCode);
        } catch (IOException e10) {
            cVar.b1(e10);
        }
        return t.f7040a;
    }

    public static final t a2(c cVar, int i10, long j10) {
        try {
            cVar.writer.Y(i10, j10);
        } catch (IOException e10) {
            cVar.b1(e10);
        }
        return t.f7040a;
    }

    public final p A1(int associatedStreamId, List<Bb.a> requestHeaders, boolean out) throws IOException {
        c cVar;
        Throwable th;
        int i10;
        p pVar;
        boolean z10;
        boolean z11 = !out;
        synchronized (this.writer) {
            try {
                synchronized (this) {
                    try {
                        if (this.nextStreamId > 1073741823) {
                            try {
                                Q1(ErrorCode.REFUSED_STREAM);
                            } catch (Throwable th2) {
                                th = th2;
                                cVar = this;
                                throw th;
                            }
                        }
                        try {
                            if (this.isShutdown) {
                                throw new ConnectionShutdownException();
                            }
                            i10 = this.nextStreamId;
                            this.nextStreamId = i10 + 2;
                            pVar = new p(i10, this, z11, false, null);
                            z10 = !out || this.writeBytesTotal >= this.writeBytesMaximum || pVar.getWriteBytesTotal() >= pVar.getWriteBytesMaximum();
                            if (pVar.w()) {
                                this.streams.put(Integer.valueOf(i10), pVar);
                            }
                            t tVar = t.f7040a;
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cVar = this;
                    }
                }
                if (associatedStreamId == 0) {
                    this.writer.n(z11, i10, requestHeaders);
                } else {
                    if (this.client) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                    }
                    this.writer.J(associatedStreamId, i10, requestHeaders);
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        if (z10) {
            this.writer.flush();
        }
        return pVar;
    }

    public final p B1(List<Bb.a> requestHeaders, boolean out) throws IOException {
        kotlin.jvm.internal.p.i(requestHeaders, "requestHeaders");
        return A1(0, requestHeaders, out);
    }

    public final void D1(final int streamId, InterfaceC0968f source, final int byteCount, final boolean inFinished) throws IOException {
        kotlin.jvm.internal.p.i(source, "source");
        final C0966d c0966d = new C0966d();
        long j10 = byteCount;
        source.j(j10);
        source.u0(c0966d, j10);
        C5872c.d(this.pushQueue, this.connectionName + '[' + streamId + "] onData", 0L, false, new InterfaceC5063a() { // from class: Bb.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return okhttp3.internal.http2.c.C1(this.f1503a, streamId, c0966d, byteCount, inFinished);
            }
        }, 6, null);
    }

    public final void F1(final int streamId, final List<Bb.a> requestHeaders, final boolean inFinished) {
        kotlin.jvm.internal.p.i(requestHeaders, "requestHeaders");
        C5872c.d(this.pushQueue, this.connectionName + '[' + streamId + "] onHeaders", 0L, false, new InterfaceC5063a() { // from class: Bb.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return okhttp3.internal.http2.c.E1(this.f1514a, streamId, requestHeaders, inFinished);
            }
        }, 6, null);
    }

    public final void H1(final int streamId, final List<Bb.a> requestHeaders) {
        kotlin.jvm.internal.p.i(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(streamId))) {
                Z1(streamId, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(streamId));
            C5872c.d(this.pushQueue, this.connectionName + '[' + streamId + "] onRequest", 0L, false, new InterfaceC5063a() { // from class: Bb.h
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return okhttp3.internal.http2.c.G1(this.f1508a, streamId, requestHeaders);
                }
            }, 6, null);
        }
    }

    public final void J1(final int streamId, final ErrorCode errorCode) {
        kotlin.jvm.internal.p.i(errorCode, "errorCode");
        C5872c.d(this.pushQueue, this.connectionName + '[' + streamId + "] onReset", 0L, false, new InterfaceC5063a() { // from class: Bb.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return okhttp3.internal.http2.c.I1(this.f1511a, streamId, errorCode);
            }
        }, 6, null);
    }

    public final boolean K1(int streamId) {
        return streamId != 0 && (streamId & 1) == 0;
    }

    public final p L1(int streamId) {
        p pVarRemove;
        synchronized (this) {
            pVarRemove = this.streams.remove(Integer.valueOf(streamId));
            kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
        return pVarRemove;
    }

    public final void N1() {
        synchronized (this) {
            long j10 = this.degradedPongsReceived;
            long j11 = this.degradedPingsSent;
            if (j10 < j11) {
                return;
            }
            this.degradedPingsSent = j11 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + Utils.SECOND_IN_NANOS;
            t tVar = t.f7040a;
            C5872c.d(this.writerQueue, this.connectionName + " ping", 0L, false, new InterfaceC5063a() { // from class: Bb.e
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return okhttp3.internal.http2.c.M1(this.f1499a);
                }
            }, 6, null);
        }
    }

    public final void O1(int i10) {
        this.lastGoodStreamId = i10;
    }

    public final void P1(s sVar) {
        kotlin.jvm.internal.p.i(sVar, "<set-?>");
        this.peerSettings = sVar;
    }

    public final void Q1(ErrorCode statusCode) throws IOException {
        kotlin.jvm.internal.p.i(statusCode, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int i10 = this.lastGoodStreamId;
                t tVar = t.f7040a;
                this.writer.m(i10, statusCode, n.f42668a);
            }
        }
    }

    public final void R1(boolean sendConnectionPreface) throws IOException {
        if (sendConnectionPreface) {
            this.writer.e();
            this.writer.V(this.okHttpSettings);
            if (this.okHttpSettings.c() != 65535) {
                this.writer.Y(0, r9 - 65535);
            }
        }
        C5872c.d(this.taskRunner.k(), this.connectionName, 0L, false, this.readerRunnable, 6, null);
    }

    public final void T1(long read) {
        synchronized (this) {
            try {
                WindowCounter.c(this.readBytes, read, 0L, 2, null);
                long jA = this.readBytes.a();
                if (jA >= this.okHttpSettings.c() / 2) {
                    b2(0, jA);
                    WindowCounter.c(this.readBytes, 0L, jA, 1, null);
                }
                this.flowControlListener.b(this.readBytes);
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.writer.A());
        r6 = r2;
        r8.writeBytesTotal += r6;
        r4 = Y8.t.f7040a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U1(int r9, boolean r10, Mb.C0966d r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            okhttp3.internal.http2.e r8 = r8.writer
            r8.g(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L71
            monitor-enter(r8)
        L12:
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            long r6 = r8.writeBytesMaximum     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L39
            java.util.Map<java.lang.Integer, Bb.p> r2 = r8.streams     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            if (r2 == 0) goto L31
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.Object"
            kotlin.jvm.internal.p.g(r8, r2)     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            r8.wait()     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            goto L12
        L2f:
            r9 = move-exception
            goto L6f
        L31:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
            throw r9     // Catch: java.lang.Throwable -> L2f java.lang.InterruptedException -> L62
        L39:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L2f
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L2f
            okhttp3.internal.http2.e r4 = r8.writer     // Catch: java.lang.Throwable -> L2f
            int r4 = r4.getMaxFrameSize()     // Catch: java.lang.Throwable -> L2f
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2f
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L2f
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2f
            long r4 = r4 + r6
            r8.writeBytesTotal = r4     // Catch: java.lang.Throwable -> L2f
            Y8.t r4 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.e r4 = r8.writer
            if (r10 == 0) goto L5d
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L5d
            r5 = 1
            goto L5e
        L5d:
            r5 = r3
        L5e:
            r4.g(r5, r9, r11, r2)
            goto Ld
        L62:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2f
            r9.interrupt()     // Catch: java.lang.Throwable -> L2f
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2f
            r9.<init>()     // Catch: java.lang.Throwable -> L2f
            throw r9     // Catch: java.lang.Throwable -> L2f
        L6f:
            monitor-exit(r8)
            throw r9
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.c.U1(int, boolean, Mb.d, long):void");
    }

    public final void V1(int streamId, boolean outFinished, List<Bb.a> alternating) throws IOException {
        kotlin.jvm.internal.p.i(alternating, "alternating");
        this.writer.n(outFinished, streamId, alternating);
    }

    public final void W1(boolean reply, int payload1, int payload2) {
        try {
            this.writer.G(reply, payload1, payload2);
        } catch (IOException e10) {
            b1(e10);
        }
    }

    public final void X1(int streamId, ErrorCode statusCode) throws IOException {
        kotlin.jvm.internal.p.i(statusCode, "statusCode");
        this.writer.U(streamId, statusCode);
    }

    public final void Z1(final int streamId, final ErrorCode errorCode) {
        kotlin.jvm.internal.p.i(errorCode, "errorCode");
        C5872c.d(this.writerQueue, this.connectionName + '[' + streamId + "] writeSynReset", 0L, false, new InterfaceC5063a() { // from class: Bb.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return okhttp3.internal.http2.c.Y1(this.f1500a, streamId, errorCode);
            }
        }, 6, null);
    }

    public final void a1(ErrorCode connectionCode, ErrorCode streamCode, IOException cause) {
        int i10;
        Object[] array;
        kotlin.jvm.internal.p.i(connectionCode, "connectionCode");
        kotlin.jvm.internal.p.i(streamCode, "streamCode");
        if (q.f42674b && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            Q1(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.streams.isEmpty()) {
                    array = null;
                } else {
                    array = this.streams.values().toArray(new p[0]);
                    this.streams.clear();
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        p[] pVarArr = (p[]) array;
        if (pVarArr != null) {
            for (p pVar : pVarArr) {
                try {
                    pVar.g(streamCode, cause);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.cancel();
        } catch (IOException unused4) {
        }
        this.writerQueue.q();
        this.pushQueue.q();
        this.settingsListenerQueue.q();
    }

    public final void b1(IOException e10) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        a1(errorCode, errorCode, e10);
    }

    public final void b2(final int streamId, final long unacknowledgedBytesRead) {
        C5872c.d(this.writerQueue, this.connectionName + '[' + streamId + "] windowUpdate", 0L, false, new InterfaceC5063a() { // from class: Bb.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return okhttp3.internal.http2.c.a2(this.f1496a, streamId, unacknowledgedBytesRead);
            }
        }, 6, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a1(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    /* renamed from: f1, reason: from getter */
    public final boolean getClient() {
        return this.client;
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    /* renamed from: h1, reason: from getter */
    public final String getConnectionName() {
        return this.connectionName;
    }

    /* renamed from: k1, reason: from getter */
    public final okhttp3.internal.http2.a getFlowControlListener() {
        return this.flowControlListener;
    }

    /* renamed from: l1, reason: from getter */
    public final int getLastGoodStreamId() {
        return this.lastGoodStreamId;
    }

    /* renamed from: m1, reason: from getter */
    public final AbstractC0484c getListener() {
        return this.listener;
    }

    /* renamed from: s1, reason: from getter */
    public final int getNextStreamId() {
        return this.nextStreamId;
    }

    /* renamed from: t1, reason: from getter */
    public final s getOkHttpSettings() {
        return this.okHttpSettings;
    }

    /* renamed from: u1, reason: from getter */
    public final s getPeerSettings() {
        return this.peerSettings;
    }

    public final p v1(int id) {
        p pVar;
        synchronized (this) {
            pVar = this.streams.get(Integer.valueOf(id));
        }
        return pVar;
    }

    public final Map<Integer, p> w1() {
        return this.streams;
    }

    /* renamed from: x1, reason: from getter */
    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    /* renamed from: y1, reason: from getter */
    public final e getWriter() {
        return this.writer;
    }

    public final boolean z1(long nowNs) {
        synchronized (this) {
            if (this.isShutdown) {
                return false;
            }
            if (this.degradedPongsReceived < this.degradedPingsSent) {
                if (nowNs >= this.degradedPongDeadlineNs) {
                    return false;
                }
            }
            return true;
        }
    }
}
