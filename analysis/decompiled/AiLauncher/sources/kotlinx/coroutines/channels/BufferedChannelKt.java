package kotlinx.coroutines.channels;

import Ua.InterfaceC1066l;
import Wa.k;
import Y8.t;
import Za.C;
import Za.F;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.coroutines.d;
import p9.q;
import w9.InterfaceC5748g;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b$\u001a3\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0001\"\u0004\b\u0000\u0010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\u001aK\u0010\u0013\u001a\u00020\u0012\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00028\u00002\"\b\u0002\u0010\u0011\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\"\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"\"\u0014\u0010&\u001a\u00020\u00158\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b$\u0010%\"\u0014\u0010(\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010%\"\u0014\u0010,\u001a\u00020)8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010.\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010+\"\u0014\u00100\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010+\"\u0014\u00102\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010+\"\u0014\u00104\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010+\"\u0014\u00106\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010+\"\u0014\u00108\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010+\"\u0014\u0010:\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010+\"\u001a\u0010>\u001a\u00020)8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b;\u0010+\u001a\u0004\b<\u0010=\"\u0014\u0010@\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010+\"\u0014\u0010B\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010+\"\u0014\u0010D\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010+\"\u0014\u0010F\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010+\"\u0014\u0010H\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010+\"\u0014\u0010J\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010+\"\u0014\u0010L\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010+¨\u0006M"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlin/reflect/KFunction2;", "", "LWa/k;", "y", "()Lw9/g;", "id", "prev", "x", "(JLWa/k;)LWa/k;", ExifInterface.GPS_DIRECTION_TRUE, "LUa/l;", UxipConstants.f30680s, "Lkotlin/Function3;", "", "Lkotlin/coroutines/d;", "LY8/t;", "onCancellation", "", "B", "(LUa/l;Ljava/lang/Object;Lp9/q;)Z", "", "capacity", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)J", "counter", "closeStatus", "w", "(JI)J", "pauseEB", "v", "(JZ)J", "", Const.INTENT_KEY_APIKEY, "LWa/k;", "NULL_SEGMENT", Const.INTENT_KEY_PKGNAME, "I", "SEGMENT_SIZE", "c", "EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS", "LZa/C;", Const.INTENT_KEY_UMID, "LZa/C;", "BUFFERED", "e", "IN_BUFFER", "f", "RESUMING_BY_RCV", Const.INTENT_KEY_BACKGROUND_COMMAND, "RESUMING_BY_EB", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "POISONED", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "DONE_RCV", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "INTERRUPTED_SEND", "k", "INTERRUPTED_RCV", "l", "z", "()LZa/C;", "CHANNEL_CLOSED", "m", "SUSPEND", "n", "SUSPEND_NO_WAITER", "o", "FAILED", "p", "NO_RECEIVE_RESULT", "q", "CLOSE_HANDLER_CLOSED", "r", "CLOSE_HANDLER_INVOKED", "s", "NO_CLOSE_CAUSE", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BufferedChannelKt {

    /* renamed from: a, reason: collision with root package name */
    public static final k<Object> f36317a = new k<>(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f36318b = F.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f36319c = F.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* renamed from: d, reason: collision with root package name */
    public static final C f36320d = new C("BUFFERED");

    /* renamed from: e, reason: collision with root package name */
    public static final C f36321e = new C("SHOULD_BUFFER");

    /* renamed from: f, reason: collision with root package name */
    public static final C f36322f = new C("S_RESUMING_BY_RCV");

    /* renamed from: g, reason: collision with root package name */
    public static final C f36323g = new C("RESUMING_BY_EB");

    /* renamed from: h, reason: collision with root package name */
    public static final C f36324h = new C("POISONED");

    /* renamed from: i, reason: collision with root package name */
    public static final C f36325i = new C("DONE_RCV");

    /* renamed from: j, reason: collision with root package name */
    public static final C f36326j = new C("INTERRUPTED_SEND");

    /* renamed from: k, reason: collision with root package name */
    public static final C f36327k = new C("INTERRUPTED_RCV");

    /* renamed from: l, reason: collision with root package name */
    public static final C f36328l = new C("CHANNEL_CLOSED");

    /* renamed from: m, reason: collision with root package name */
    public static final C f36329m = new C("SUSPEND");

    /* renamed from: n, reason: collision with root package name */
    public static final C f36330n = new C("SUSPEND_NO_WAITER");

    /* renamed from: o, reason: collision with root package name */
    public static final C f36331o = new C("FAILED");

    /* renamed from: p, reason: collision with root package name */
    public static final C f36332p = new C("NO_RECEIVE_RESULT");

    /* renamed from: q, reason: collision with root package name */
    public static final C f36333q = new C("CLOSE_HANDLER_CLOSED");

    /* renamed from: r, reason: collision with root package name */
    public static final C f36334r = new C("CLOSE_HANDLER_INVOKED");

    /* renamed from: s, reason: collision with root package name */
    public static final C f36335s = new C("NO_CLOSE_CAUSE");

    public static final long A(int i10) {
        if (i10 == 0) {
            return 0L;
        }
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        return Long.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean B(InterfaceC1066l<? super T> interfaceC1066l, T t10, q<? super Throwable, ? super T, ? super d, t> qVar) {
        Object objL = interfaceC1066l.l(t10, null, qVar);
        if (objL == null) {
            return false;
        }
        interfaceC1066l.x(objL);
        return true;
    }

    public static /* synthetic */ boolean C(InterfaceC1066l interfaceC1066l, Object obj, q qVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            qVar = null;
        }
        return B(interfaceC1066l, obj, qVar);
    }

    public static final long v(long j10, boolean z10) {
        return (z10 ? 4611686018427387904L : 0L) + j10;
    }

    public static final long w(long j10, int i10) {
        return (i10 << 60) + j10;
    }

    public static final <E> k<E> x(long j10, k<E> kVar) {
        return new k<>(j10, kVar, kVar.y(), 0);
    }

    public static final <E> InterfaceC5748g<k<E>> y() {
        return BufferedChannelKt$createSegmentFunction$1.f36336a;
    }

    public static final C z() {
        return f36328l;
    }
}
