package kotlinx.coroutines;

import Ua.A;
import Ua.C0;
import Ua.C1048c;
import Ua.C1070n;
import Ua.C1072o;
import Ua.C1074p;
import Ua.C1076q;
import Ua.C1091z;
import Ua.CompletedContinuation;
import Ua.D0;
import Ua.I;
import Ua.InterfaceC1045a0;
import Ua.InterfaceC1066l;
import Ua.K;
import Ua.N;
import Ua.U0;
import Ua.W;
import Y8.t;
import Za.C;
import Za.C1188h;
import Za.z;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4111c;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.b;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u000fJ\u000f\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u000fJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J!\u0010#\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010'J[\u0010/\u001a\u0004\u0018\u00010\u001e\"\u0004\b\u0001\u0010(2\u0006\u0010\"\u001a\u00020)2\u0006\u0010*\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\t2 \u0010-\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0016\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b/\u00100JK\u00102\u001a\u0004\u0018\u000101\"\u0004\b\u0001\u0010(2\u0006\u0010*\u001a\u00028\u00012\b\u0010.\u001a\u0004\u0018\u00010\u001e2 \u0010-\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0016\u0018\u00010+H\u0002¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u0002042\b\u0010*\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0016H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0016H\u0016¢\u0006\u0004\b9\u00108J\u000f\u0010(\u001a\u00020\rH\u0001¢\u0006\u0004\b(\u0010\u000fJ\u0011\u0010:\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\b:\u0010;J!\u0010=\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0010¢\u0006\u0004\b=\u0010>J\u0019\u0010?\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b?\u0010\u0013J\u0017\u0010@\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b@\u0010AJ\u001f\u0010C\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020B2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bC\u0010DJC\u0010F\u001a\u00020\u0016\"\u0004\b\u0001\u0010(2\u001e\u0010-\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00160+2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010E\u001a\u00028\u0001¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020\u00102\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u0011\u0010L\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\bL\u0010;J\u000f\u0010M\u001a\u00020\u0016H\u0000¢\u0006\u0004\bM\u00108J\u001d\u0010P\u001a\u00020\u00162\f\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000NH\u0016¢\u0006\u0004\bP\u0010!J-\u0010R\u001a\u00020\u00162\u0006\u0010E\u001a\u00028\u00002\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010QH\u0016¢\u0006\u0004\bR\u0010SJC\u0010T\u001a\u00020\u0016\"\b\b\u0001\u0010(*\u00028\u00002\u0006\u0010E\u001a\u00028\u00012 \u0010-\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0016\u0018\u00010+H\u0016¢\u0006\u0004\bT\u0010UJ#\u0010W\u001a\u00020\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010V\u001a\u00020\tH\u0016¢\u0006\u0004\bW\u0010XJ)\u0010Z\u001a\u00020\u00162\u0018\u0010\u001f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00160Qj\u0002`YH\u0016¢\u0006\u0004\bZ\u0010[J\u0017\u0010\\\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020BH\u0000¢\u0006\u0004\b\\\u0010]JI\u0010\u0001\u001a\u00020\u0016\"\u0004\b\u0001\u0010(2\u0006\u0010*\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\t2\"\b\u0002\u0010-\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0016\u0018\u00010+H\u0000¢\u0006\u0004\b\u0001\u0010^J\u000f\u0010_\u001a\u00020\u0016H\u0000¢\u0006\u0004\b_\u00108JO\u0010`\u001a\u0004\u0018\u00010\u001e\"\b\b\u0001\u0010(*\u00028\u00002\u0006\u0010E\u001a\u00028\u00012\b\u0010.\u001a\u0004\u0018\u00010\u001e2 \u0010-\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0016\u0018\u00010+H\u0016¢\u0006\u0004\b`\u0010aJ\u0019\u0010c\u001a\u0004\u0018\u00010\u001e2\u0006\u0010b\u001a\u00020\u0010H\u0016¢\u0006\u0004\bc\u0010dJ\u0017\u0010f\u001a\u00020\u00162\u0006\u0010e\u001a\u00020\u001eH\u0016¢\u0006\u0004\bf\u0010!J\u001b\u0010h\u001a\u00020\u0016*\u00020g2\u0006\u0010E\u001a\u00028\u0000H\u0016¢\u0006\u0004\bh\u0010iJ\u001f\u0010j\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bj\u0010kJ\u001b\u0010l\u001a\u0004\u0018\u00010\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bl\u0010mJ\u000f\u0010o\u001a\u00020nH\u0016¢\u0006\u0004\bo\u0010pJ\u000f\u0010q\u001a\u00020nH\u0014¢\u0006\u0004\bq\u0010pR \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\bl\u0010r\u001a\u0004\bs\u0010tR\u001a\u0010x\u001a\u00020,8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bj\u0010u\u001a\u0004\bv\u0010wR\u0016\u0010z\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\by\u0010\u001dR\u0014\u0010|\u001a\u00020n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010pR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b}\u0010;R\u0014\u0010\u007f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u000fR\u0016\u0010\u0081\u0001\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u000fR\u0016\u0010\u0082\u0001\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u000fR\u001f\u0010\u0085\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\r\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004R\u0015\u0010\u0089\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0088\u00018\u0002X\u0082\u0004R\u0015\u0010\u008a\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0088\u00018\u0002X\u0082\u0004¨\u0006\u008b\u0001"}, d2 = {"Lkotlinx/coroutines/c;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/f;", "LUa/l;", "Lg9/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "LUa/U0;", "Le9/c;", "delegate", "", "resumeMode", "<init>", "(Le9/c;I)V", "", "M", "()Z", "", "cause", "s", "(Ljava/lang/Throwable;)Z", "LZa/z;", "segment", "LY8/t;", "r", "(LZa/z;Ljava/lang/Throwable;)V", "Y", ExifInterface.LONGITUDE_WEST, "LUa/a0;", "J", "()LUa/a0;", "", "handler", "K", "(Ljava/lang/Object;)V", VoiceWakeupReceiver.EXTRA_STATE, "N", "(Ljava/lang/Object;Ljava/lang/Object;)V", "mode", "z", "(I)V", "R", "LUa/D0;", "proposedUpdate", "Lkotlin/Function3;", "Lkotlin/coroutines/d;", "onCancellation", "idempotent", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(LUa/D0;Ljava/lang/Object;ILp9/q;Ljava/lang/Object;)Ljava/lang/Object;", "LZa/C;", "X", "(Ljava/lang/Object;Ljava/lang/Object;Lp9/q;)LZa/C;", "", "n", "(Ljava/lang/Object;)Ljava/lang/Void;", "y", "()V", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/Object;", "takenState", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancel", "P", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/b;", "o", "(Lkotlinx/coroutines/b;Ljava/lang/Throwable;)V", UxipConstants.f30680s, "p", "(Lp9/q;Ljava/lang/Throwable;Ljava/lang/Object;)V", "Lkotlinx/coroutines/g;", "parent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/coroutines/g;)Ljava/lang/Throwable;", "C", "Q", "Lkotlin/Result;", "result", "resumeWith", "Lkotlin/Function1;", "v", "(Ljava/lang/Object;Lp9/l;)V", "w", "(Ljava/lang/Object;Lp9/q;)V", "index", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LZa/z;I)V", "Lkotlinx/coroutines/CompletionHandler;", "q", "(Lp9/l;)V", "L", "(Lkotlinx/coroutines/b;)V", "(Ljava/lang/Object;ILp9/q;)V", "u", "l", "(Ljava/lang/Object;Ljava/lang/Object;Lp9/q;)Ljava/lang/Object;", "exception", "k", "(Ljava/lang/Throwable;)Ljava/lang/Object;", M5.b.CREDENTIAL_TOKEN, "x", "LUa/I;", "t", "(LUa/I;Ljava/lang/Object;)V", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", "O", "Le9/c;", "c", "()Le9/c;", "Lkotlin/coroutines/d;", "getContext", "()Lkotlin/coroutines/d;", "context", "B", "parentHandle", ExifInterface.LONGITUDE_EAST, "stateDebugRepresentation", "D", Const.INTENT_KEY_PKGNAME, "isActive", Const.INTENT_KEY_BACKGROUND_COMMAND, "isCompleted", "isCancelled", "getCallerFrame", "()Lg9/c;", "callerFrame", "LOa/c;", "_decisionAndIndex", "LOa/e;", "_state", "_parentHandle", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class c<T> extends f<T> implements InterfaceC1066l<T>, InterfaceC4111c, U0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f36269f = AtomicIntegerFieldUpdater.newUpdater(c.class, "_decisionAndIndex$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36270g = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_state$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36271h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4014c<T> delegate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final kotlin.coroutines.d context;

    /* JADX WARN: Multi-variable type inference failed */
    public c(InterfaceC4014c<? super T> interfaceC4014c, int i10) {
        super(i10);
        this.delegate = interfaceC4014c;
        this.context = interfaceC4014c.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = C1048c.f6358a;
    }

    public static final t S(InterfaceC5074l interfaceC5074l, Throwable th, Object obj, kotlin.coroutines.d dVar) {
        interfaceC5074l.invoke(th);
        return t.f7040a;
    }

    public static /* synthetic */ void U(c cVar, Object obj, int i10, q qVar, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            qVar = null;
        }
        cVar.T(obj, i10, qVar);
    }

    public Throwable A(g parent) {
        return parent.G();
    }

    public final InterfaceC1045a0 B() {
        return (InterfaceC1045a0) f36271h.get(this);
    }

    public final Object C() {
        g gVar;
        boolean zM = M();
        if (Y()) {
            if (B() == null) {
                J();
            }
            if (zM) {
                Q();
            }
            return C4063a.g();
        }
        if (zM) {
            Q();
        }
        Object objD = D();
        if (objD instanceof C1091z) {
            throw ((C1091z) objD).cause;
        }
        if (!W.b(this.resumeMode) || (gVar = (g) getContext().get(g.INSTANCE)) == null || gVar.b()) {
            return e(objD);
        }
        CancellationException cancellationExceptionG = gVar.G();
        a(objD, cancellationExceptionG);
        throw cancellationExceptionG;
    }

    public final Object D() {
        return f36270g.get(this);
    }

    public final String E() {
        Object objD = D();
        return objD instanceof D0 ? "Active" : objD instanceof C1074p ? "Cancelled" : "Completed";
    }

    public void I() {
        InterfaceC1045a0 interfaceC1045a0J = J();
        if (interfaceC1045a0J != null && g()) {
            interfaceC1045a0J.dispose();
            f36271h.set(this, C0.f6325a);
        }
    }

    public final InterfaceC1045a0 J() {
        g gVar = (g) getContext().get(g.INSTANCE);
        if (gVar == null) {
            return null;
        }
        InterfaceC1045a0 interfaceC1045a0Q = JobKt__JobKt.q(gVar, false, new C1076q(this), 1, null);
        f36271h.compareAndSet(this, null, interfaceC1045a0Q);
        return interfaceC1045a0Q;
    }

    public final void K(Object handler) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36270g;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof C1048c) {
                if (f36270g.compareAndSet(this, obj, handler)) {
                    return;
                }
            } else if ((obj instanceof b) || (obj instanceof z)) {
                N(handler, obj);
            } else {
                if (obj instanceof C1091z) {
                    C1091z c1091z = (C1091z) obj;
                    if (!c1091z.c()) {
                        N(handler, obj);
                    }
                    if (obj instanceof C1074p) {
                        if (obj == null) {
                            c1091z = null;
                        }
                        Throwable th = c1091z != null ? c1091z.cause : null;
                        if (handler instanceof b) {
                            o((b) handler, th);
                            return;
                        } else {
                            p.g(handler, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            r((z) handler, th);
                            return;
                        }
                    }
                    return;
                }
                if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.cancelHandler != null) {
                        N(handler, obj);
                    }
                    if (handler instanceof z) {
                        return;
                    }
                    p.g(handler, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    b bVar = (b) handler;
                    if (completedContinuation.c()) {
                        o(bVar, completedContinuation.cancelCause);
                        return;
                    } else {
                        if (f36270g.compareAndSet(this, obj, CompletedContinuation.b(completedContinuation, null, bVar, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (handler instanceof z) {
                        return;
                    }
                    p.g(handler, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if (f36270g.compareAndSet(this, obj, new CompletedContinuation(obj, (b) handler, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    public final void L(b handler) {
        K(handler);
    }

    public final boolean M() {
        if (!W.c(this.resumeMode)) {
            return false;
        }
        InterfaceC4014c<T> interfaceC4014c = this.delegate;
        p.g(interfaceC4014c, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C1188h) interfaceC4014c).s();
    }

    public final void N(Object handler, Object state) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + handler + ", already has " + state).toString());
    }

    public String O() {
        return "CancellableContinuation";
    }

    public final void P(Throwable cause) {
        if (s(cause)) {
            return;
        }
        cancel(cause);
        y();
    }

    public final void Q() {
        Throwable thZ;
        InterfaceC4014c<T> interfaceC4014c = this.delegate;
        C1188h c1188h = interfaceC4014c instanceof C1188h ? (C1188h) interfaceC4014c : null;
        if (c1188h == null || (thZ = c1188h.z(this)) == null) {
            return;
        }
        u();
        cancel(thZ);
    }

    public final boolean R() {
        Object obj = f36270g.get(this);
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
            u();
            return false;
        }
        f36269f.set(this, 536870911);
        f36270g.set(this, C1048c.f6358a);
        return true;
    }

    public final <R> void T(R proposedUpdate, int resumeMode, q<? super Throwable, ? super R, ? super kotlin.coroutines.d, t> onCancellation) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36270g;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof D0)) {
                c<T> cVar = this;
                R r10 = proposedUpdate;
                q<? super Throwable, ? super R, ? super kotlin.coroutines.d, t> qVar = onCancellation;
                if (obj instanceof C1074p) {
                    C1074p c1074p = (C1074p) obj;
                    if (c1074p.e()) {
                        if (qVar != null) {
                            cVar.p(qVar, c1074p.cause, r10);
                            return;
                        }
                        return;
                    }
                }
                cVar.n(r10);
                throw new KotlinNothingValueException();
            }
            c<T> cVar2 = this;
            R r11 = proposedUpdate;
            int i10 = resumeMode;
            q<? super Throwable, ? super R, ? super kotlin.coroutines.d, t> qVar2 = onCancellation;
            if (f36270g.compareAndSet(cVar2, obj, cVar2.V((D0) obj, r11, i10, qVar2, null))) {
                cVar2.y();
                cVar2.z(i10);
                return;
            } else {
                this = cVar2;
                proposedUpdate = r11;
                resumeMode = i10;
                onCancellation = qVar2;
            }
        }
    }

    public final <R> Object V(D0 state, R proposedUpdate, int resumeMode, q<? super Throwable, ? super R, ? super kotlin.coroutines.d, t> onCancellation, Object idempotent) {
        if (proposedUpdate instanceof C1091z) {
            return proposedUpdate;
        }
        if ((W.b(resumeMode) || idempotent != null) && !(onCancellation == null && !(state instanceof b) && idempotent == null)) {
            return new CompletedContinuation(proposedUpdate, state instanceof b ? (b) state : null, onCancellation, idempotent, null, 16, null);
        }
        return proposedUpdate;
    }

    public final boolean W() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f36269f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f36269f.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
        return true;
    }

    public final <R> C X(R proposedUpdate, Object idempotent, q<? super Throwable, ? super R, ? super kotlin.coroutines.d, t> onCancellation) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36270g;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof D0)) {
                Object obj2 = idempotent;
                if ((obj instanceof CompletedContinuation) && obj2 != null && ((CompletedContinuation) obj).idempotentResume == obj2) {
                    return C1070n.f6390a;
                }
                return null;
            }
            c<T> cVar = this;
            R r10 = proposedUpdate;
            Object obj3 = idempotent;
            q<? super Throwable, ? super R, ? super kotlin.coroutines.d, t> qVar = onCancellation;
            if (f36270g.compareAndSet(cVar, obj, cVar.V((D0) obj, r10, this.resumeMode, qVar, obj3))) {
                cVar.y();
                return C1070n.f6390a;
            }
            this = cVar;
            proposedUpdate = r10;
            onCancellation = qVar;
            idempotent = obj3;
        }
    }

    public final boolean Y() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f36269f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f36269f.compareAndSet(this, i10, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING + (536870911 & i10)));
        return true;
    }

    @Override // kotlinx.coroutines.f
    public void a(Object takenState, Throwable cause) {
        Throwable th;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36270g;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof D0) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof C1091z) {
                return;
            }
            if (obj instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                if (completedContinuation.c()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                Throwable th2 = cause;
                th = th2;
                if (f36270g.compareAndSet(this, obj, CompletedContinuation.b(completedContinuation, null, null, null, null, th2, 15, null))) {
                    completedContinuation.d(this, th);
                    return;
                }
            } else {
                th = cause;
                if (f36270g.compareAndSet(this, obj, new CompletedContinuation(obj, null, null, null, th, 14, null))) {
                    return;
                }
            }
            cause = th;
        }
    }

    @Override // Ua.InterfaceC1066l
    public boolean b() {
        return D() instanceof D0;
    }

    @Override // kotlinx.coroutines.f
    public final InterfaceC4014c<T> c() {
        return this.delegate;
    }

    @Override // Ua.InterfaceC1066l
    public boolean cancel(Throwable cause) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36270g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof D0)) {
                return false;
            }
        } while (!f36270g.compareAndSet(this, obj, new C1074p(this, cause, (obj instanceof b) || (obj instanceof z))));
        D0 d02 = (D0) obj;
        if (d02 instanceof b) {
            o((b) obj, cause);
        } else if (d02 instanceof z) {
            r((z) obj, cause);
        }
        y();
        z(this.resumeMode);
        return true;
    }

    @Override // kotlinx.coroutines.f
    public Throwable d(Object state) {
        Throwable thD = super.d(state);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.f
    public <T> T e(Object state) {
        return state instanceof CompletedContinuation ? (T) ((CompletedContinuation) state).result : state;
    }

    @Override // Ua.InterfaceC1066l
    public boolean g() {
        return !(D() instanceof D0);
    }

    @Override // g9.InterfaceC4111c
    public InterfaceC4111c getCallerFrame() {
        InterfaceC4014c<T> interfaceC4014c = this.delegate;
        if (interfaceC4014c instanceof InterfaceC4111c) {
            return (InterfaceC4111c) interfaceC4014c;
        }
        return null;
    }

    @Override // e9.InterfaceC4014c
    public kotlin.coroutines.d getContext() {
        return this.context;
    }

    @Override // Ua.U0
    public void h(z<?> segment, int index) {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f36269f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, ((i10 >> 29) << 29) + index));
        K(segment);
    }

    @Override // kotlinx.coroutines.f
    public Object i() {
        return D();
    }

    @Override // Ua.InterfaceC1066l
    public boolean isCancelled() {
        return D() instanceof C1074p;
    }

    @Override // Ua.InterfaceC1066l
    public Object k(Throwable exception) {
        return X(new C1091z(exception, false, 2, null), null, null);
    }

    @Override // Ua.InterfaceC1066l
    public <R extends T> Object l(R value, Object idempotent, q<? super Throwable, ? super R, ? super kotlin.coroutines.d, t> onCancellation) {
        return X(value, idempotent, onCancellation);
    }

    public final Void n(Object proposedUpdate) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + proposedUpdate).toString());
    }

    public final void o(b handler, Throwable cause) {
        try {
            handler.c(cause);
        } catch (Throwable th) {
            K.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> void p(q<? super Throwable, ? super R, ? super kotlin.coroutines.d, t> onCancellation, Throwable cause, R value) {
        try {
            onCancellation.invoke(cause, value, getContext());
        } catch (Throwable th) {
            K.a(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
        }
    }

    @Override // Ua.InterfaceC1066l
    public void q(InterfaceC5074l<? super Throwable, t> handler) {
        C1072o.c(this, new b.a(handler));
    }

    public final void r(z<?> segment, Throwable cause) {
        int i10 = f36269f.get(this) & 536870911;
        if (i10 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            segment.s(i10, cause, getContext());
        } catch (Throwable th) {
            K.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    @Override // e9.InterfaceC4014c
    public void resumeWith(Object result) {
        U(this, A.c(result, this), this.resumeMode, null, 4, null);
    }

    public final boolean s(Throwable cause) {
        if (!M()) {
            return false;
        }
        InterfaceC4014c<T> interfaceC4014c = this.delegate;
        p.g(interfaceC4014c, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C1188h) interfaceC4014c).u(cause);
    }

    @Override // Ua.InterfaceC1066l
    public void t(I i10, T t10) {
        InterfaceC4014c<T> interfaceC4014c = this.delegate;
        C1188h c1188h = interfaceC4014c instanceof C1188h ? (C1188h) interfaceC4014c : null;
        U(this, t10, (c1188h != null ? c1188h.dispatcher : null) == i10 ? 4 : this.resumeMode, null, 4, null);
    }

    public String toString() {
        return O() + '(' + N.c(this.delegate) + "){" + E() + "}@" + N.b(this);
    }

    public final void u() {
        InterfaceC1045a0 interfaceC1045a0B = B();
        if (interfaceC1045a0B == null) {
            return;
        }
        interfaceC1045a0B.dispose();
        f36271h.set(this, C0.f6325a);
    }

    @Override // Ua.InterfaceC1066l
    public void v(T value, final InterfaceC5074l<? super Throwable, t> onCancellation) {
        T(value, this.resumeMode, onCancellation != null ? new q() { // from class: Ua.m
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return kotlinx.coroutines.c.S(onCancellation, (Throwable) obj, obj2, (kotlin.coroutines.d) obj3);
            }
        } : null);
    }

    @Override // Ua.InterfaceC1066l
    public <R extends T> void w(R value, q<? super Throwable, ? super R, ? super kotlin.coroutines.d, t> onCancellation) {
        T(value, this.resumeMode, onCancellation);
    }

    @Override // Ua.InterfaceC1066l
    public void x(Object token) {
        z(this.resumeMode);
    }

    public final void y() {
        if (M()) {
            return;
        }
        u();
    }

    public final void z(int mode) {
        if (W()) {
            return;
        }
        W.a(this, mode);
    }
}
