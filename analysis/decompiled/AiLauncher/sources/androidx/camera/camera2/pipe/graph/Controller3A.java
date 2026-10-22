package androidx.camera.camera2.pipe.graph;

import A.f;
import A.j;
import A.m;
import A.o;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Log;
import androidx.camera.camera2.pipe.g;
import androidx.camera.camera2.pipe.graph.Controller3A;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.JobKt__JobKt;
import p9.InterfaceC5074l;
import w.C5694F;
import w.C5695a;
import w.C5696b;
import w.C5697c;
import w.C5713t;
import w.Result3A;
import w.x;
import z.k;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0001\u0018\u0000 a2\u00020\u0001:\u0001YB)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJi\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b$\u0010%J=\u0010+\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010*0\f2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011H\u0002¢\u0006\u0004\b+\u0010,J=\u00100\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010*0\f2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0011H\u0002¢\u0006\u0004\b0\u0010,J+\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0011H\u0002¢\u0006\u0004\b3\u00104J=\u00108\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010*0\f2\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0011H\u0002¢\u0006\u0004\b8\u0010,J?\u0010A\u001a\u00020@2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0004\bA\u0010BJy\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\n\b\u0002\u00109\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>2\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010*2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010*2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010*¢\u0006\u0004\bG\u0010HJÎ\u0001\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010*2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010*2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010*2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\u0016\b\u0002\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0004\bL\u0010MJe\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00112\u0016\b\u0002\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bO\u0010PJ;\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010Q\u001a\u00020\u00112\b\b\u0002\u00102\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\bR\u0010SJ\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\bT\u0010\u001dJ\u0013\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\bU\u0010VJ\u001f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\n\b\u0002\u00109\u001a\u0004\u0018\u00010\"¢\u0006\u0004\bW\u0010XR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010]R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010^R\u001e\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b3\u0010_¨\u0006b"}, d2 = {"Landroidx/camera/camera2/pipe/graph/Controller3A;", "", "LA/f;", "graphProcessor", "Landroidx/camera/camera2/pipe/g;", "metadata", "LA/j;", "graphState3A", "Landroidx/camera/camera2/pipe/graph/c;", "graphListener3A", "<init>", "(LA/f;Landroidx/camera/camera2/pipe/g;LA/j;Landroidx/camera/camera2/pipe/graph/c;)V", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "triggerCondition", "Lkotlin/Function1;", "Lw/x;", "", "lockedCondition", "", "frameLimit", "", "timeLimitNs", "LUa/Q;", "Lw/N;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/Map;Lp9/l;IJ)LUa/Q;", "cancelAf", "q", "(Z)LUa/Q;", "Lw/F;", "aeLockBehavior", "afLockBehavior", "awbLockBehavior", "Lw/a;", "afTriggerStartAeMode", "l", "(Lw/F;Lw/F;Lw/F;Lw/a;Lp9/l;Ljava/lang/Integer;Ljava/lang/Long;)LUa/Q;", "waitForAeToConverge", "waitForAfToConverge", "waitForAwbToConverge", "Landroid/hardware/camera2/CaptureResult$Key;", "", "c", "(ZZZ)Ljava/util/Map;", "waitForAeToLock", "waitForAfToLock", "waitForAwbToLock", Const.INTENT_KEY_BACKGROUND_COMMAND, "isAfTriggered", "waitForAwb", "e", "(ZZ)Lp9/l;", "ae", "af", "awb", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "aeMode", "Lw/b;", "afMode", "Lw/c;", "awbMode", "Lw/t;", "flashMode", "LA/m;", Const.INTENT_KEY_UMID, "(Lw/a;Lw/b;Lw/c;Lw/t;)LA/m;", "Landroid/hardware/camera2/params/MeteringRectangle;", "aeRegions", "afRegions", "awbRegions", "r", "(Lw/a;Lw/b;Lw/c;Lw/t;Ljava/util/List;Ljava/util/List;Ljava/util/List;)LUa/Q;", "convergedCondition", "convergedTimeLimitNs", "lockedTimeLimitNs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lw/F;Lw/F;Lw/F;Lw/a;Lp9/l;Lp9/l;ILjava/lang/Long;Ljava/lang/Long;Le9/c;)Ljava/lang/Object;", "unlockedCondition", "o", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;ILjava/lang/Long;)LUa/Q;", "triggerAf", "k", "(ZZIJ)LUa/Q;", "p", "n", "()LUa/Q;", "m", "(Lw/a;)LUa/Q;", Const.INTENT_KEY_APIKEY, "LA/f;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/g;", "LA/j;", "Landroidx/camera/camera2/pipe/graph/c;", "LUa/Q;", "lastUpdate3AResult", "f", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Controller3A {

    /* renamed from: A, reason: collision with root package name */
    public static final Map<CaptureRequest.Key<?>, Object> f10810A;

    /* renamed from: B, reason: collision with root package name */
    public static final InterfaceC5074l<x, Boolean> f10811B;

    /* renamed from: g, reason: collision with root package name */
    public static final List<Integer> f10813g = C1173v.p(2, 4, 3);

    /* renamed from: h, reason: collision with root package name */
    public static final List<Integer> f10814h = C1173v.p(2, 3);

    /* renamed from: i, reason: collision with root package name */
    public static final List<Integer> f10815i = C1173v.p(2, 6, 4, 5);

    /* renamed from: j, reason: collision with root package name */
    public static final List<Integer> f10816j = C1172u.e(3);

    /* renamed from: k, reason: collision with root package name */
    public static final List<Integer> f10817k = C1172u.e(3);

    /* renamed from: l, reason: collision with root package name */
    public static final List<Integer> f10818l = C1173v.p(4, 5);

    /* renamed from: m, reason: collision with root package name */
    public static final List<Integer> f10819m = C1173v.p(2, 4, 3);

    /* renamed from: n, reason: collision with root package name */
    public static final List<Integer> f10820n = C1173v.p(2, 3);

    /* renamed from: o, reason: collision with root package name */
    public static final Map<CaptureRequest.Key<?>, Object> f10821o;

    /* renamed from: p, reason: collision with root package name */
    public static final Map<CaptureRequest.Key<?>, Object> f10822p;

    /* renamed from: q, reason: collision with root package name */
    public static final Map<CaptureRequest.Key<?>, Object> f10823q;

    /* renamed from: r, reason: collision with root package name */
    public static final Map<CaptureRequest.Key<?>, Object> f10824r;

    /* renamed from: s, reason: collision with root package name */
    public static final InterfaceC1083u<Result3A> f10825s;

    /* renamed from: t, reason: collision with root package name */
    public static final List<Integer> f10826t;

    /* renamed from: u, reason: collision with root package name */
    public static final List<Integer> f10827u;

    /* renamed from: v, reason: collision with root package name */
    public static final List<Integer> f10828v;

    /* renamed from: w, reason: collision with root package name */
    public static final Map<CaptureRequest.Key<Boolean>, Boolean> f10829w;

    /* renamed from: x, reason: collision with root package name */
    public static final Map<? extends CaptureRequest.Key<? extends Object>, Object> f10830x;

    /* renamed from: y, reason: collision with root package name */
    public static final Map<CaptureRequest.Key<?>, Object> f10831y;

    /* renamed from: z, reason: collision with root package name */
    public static final Map<CaptureRequest.Key<?>, Object> f10832z;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final f graphProcessor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final g metadata;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final j graphState3A;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final c graphListener3A;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Q<Result3A> lastUpdate3AResult;

    static {
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_TRIGGER;
        f10821o = Z8.Q.f(Y8.j.a(key, 1));
        f10822p = Z8.Q.f(Y8.j.a(key, 2));
        CaptureRequest.Key key2 = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
        f10823q = Z8.Q.f(Y8.j.a(key2, 1));
        f10824r = kotlin.collections.a.m(Y8.j.a(key, 1), Y8.j.a(key2, 1));
        f10825s = C1087w.a(new Result3A(Result3A.a.INSTANCE.d(), null, 2, null));
        f10826t = C1173v.p(0, 1, 2, 4);
        List<Integer> listP = C1173v.p(0, 3, 1, 2, 6);
        f10827u = listP;
        f10828v = C1173v.p(0, 1, 2);
        CaptureRequest.Key key3 = CaptureRequest.CONTROL_AE_LOCK;
        Boolean bool = Boolean.TRUE;
        f10829w = Z8.Q.f(Y8.j.a(key3, bool));
        f10830x = kotlin.collections.a.m(Y8.j.a(key, 2), Y8.j.a(key3, bool));
        f10831y = Z8.Q.f(Y8.j.a(key3, Boolean.FALSE));
        f10832z = Z8.Q.f(Y8.j.a(key2, 2));
        f10810A = kotlin.collections.a.m(Y8.j.a(key, 2), Y8.j.a(key2, 2));
        f10811B = o.b(Z8.Q.f(Y8.j.a(CaptureResult.CONTROL_AF_STATE, listP)));
    }

    public Controller3A(f graphProcessor, g metadata, j graphState3A, c graphListener3A) {
        p.i(graphProcessor, "graphProcessor");
        p.i(metadata, "metadata");
        p.i(graphState3A, "graphState3A");
        p.i(graphListener3A, "graphListener3A");
        this.graphProcessor = graphProcessor;
        this.metadata = metadata;
        this.graphState3A = graphState3A;
        this.graphListener3A = graphListener3A;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean f(boolean r6, boolean r7, w.x r8) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.Controller3A.f(boolean, boolean, w.x):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Q s(Controller3A controller3A, C5695a c5695a, C5696b c5696b, C5697c c5697c, C5713t c5713t, List list, List list2, List list3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            c5695a = null;
        }
        if ((i10 & 2) != 0) {
            c5696b = null;
        }
        if ((i10 & 4) != 0) {
            c5697c = null;
        }
        if ((i10 & 8) != 0) {
            c5713t = null;
        }
        if ((i10 & 16) != 0) {
            list = null;
        }
        if ((i10 & 32) != 0) {
            list2 = null;
        }
        if ((i10 & 64) != 0) {
            list3 = null;
        }
        return controller3A.r(c5695a, c5696b, c5697c, c5713t, list, list2, list3);
    }

    public final Map<CaptureResult.Key<?>, List<Object>> c(boolean waitForAeToConverge, boolean waitForAfToConverge, boolean waitForAwbToConverge) {
        if (!waitForAeToConverge && !waitForAfToConverge && !waitForAwbToConverge) {
            return kotlin.collections.a.i();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (waitForAeToConverge) {
            linkedHashMap.put(CaptureResult.CONTROL_AE_STATE, f10813g);
        }
        if (waitForAwbToConverge) {
            linkedHashMap.put(CaptureResult.CONTROL_AWB_STATE, f10814h);
        }
        if (waitForAfToConverge) {
            linkedHashMap.put(CaptureResult.CONTROL_AF_STATE, f10815i);
        }
        return linkedHashMap;
    }

    public final m d(C5695a aeMode, C5696b afMode, C5697c awbMode, C5713t flashMode) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (aeMode != null) {
            int value = aeMode.getValue();
            CaptureResult.Key CONTROL_AE_MODE = CaptureResult.CONTROL_AE_MODE;
            p.h(CONTROL_AE_MODE, "CONTROL_AE_MODE");
        }
        if (afMode != null) {
            int value2 = afMode.getValue();
            CaptureResult.Key CONTROL_AF_MODE = CaptureResult.CONTROL_AF_MODE;
            p.h(CONTROL_AF_MODE, "CONTROL_AF_MODE");
        }
        if (awbMode != null) {
            int value3 = awbMode.getValue();
            CaptureResult.Key CONTROL_AWB_MODE = CaptureResult.CONTROL_AWB_MODE;
            p.h(CONTROL_AWB_MODE, "CONTROL_AWB_MODE");
        }
        if (flashMode != null) {
            int value4 = flashMode.getValue();
            CaptureResult.Key FLASH_MODE = CaptureResult.FLASH_MODE;
            p.h(FLASH_MODE, "FLASH_MODE");
        }
        return new m(kotlin.collections.a.A(linkedHashMap), (Integer) null, (Long) null, 6, (i) null);
    }

    public final InterfaceC5074l<x, Boolean> e(final boolean isAfTriggered, final boolean waitForAwb) {
        return new InterfaceC5074l() { // from class: A.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(Controller3A.f(waitForAwb, isAfTriggered, (x) obj));
            }
        };
    }

    public final Map<CaptureResult.Key<?>, List<Object>> g(boolean waitForAeToLock, boolean waitForAfToLock, boolean waitForAwbToLock) {
        if (!waitForAeToLock && !waitForAfToLock && !waitForAwbToLock) {
            return kotlin.collections.a.i();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (waitForAeToLock) {
            linkedHashMap.put(CaptureResult.CONTROL_AE_STATE, f10816j);
        }
        if (waitForAfToLock) {
            linkedHashMap.put(CaptureResult.CONTROL_AF_STATE, f10818l);
        }
        if (waitForAwbToLock) {
            linkedHashMap.put(CaptureResult.CONTROL_AWB_STATE, f10817k);
        }
        return linkedHashMap;
    }

    public final Map<CaptureResult.Key<?>, List<Object>> h(boolean ae, boolean af, boolean awb) {
        if (!ae && !af && !awb) {
            return kotlin.collections.a.i();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (ae) {
            linkedHashMap.put(CaptureResult.CONTROL_AE_STATE, f10826t);
        }
        if (af) {
            linkedHashMap.put(CaptureResult.CONTROL_AF_STATE, f10827u);
        }
        if (awb) {
            linkedHashMap.put(CaptureResult.CONTROL_AWB_STATE, f10828v);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.util.List<android.hardware.camera2.params.MeteringRectangle> r26, java.util.List<android.hardware.camera2.params.MeteringRectangle> r27, java.util.List<android.hardware.camera2.params.MeteringRectangle> r28, w.C5694F r29, w.C5694F r30, w.C5694F r31, w.C5695a r32, p9.InterfaceC5074l<? super w.x, java.lang.Boolean> r33, p9.InterfaceC5074l<? super w.x, java.lang.Boolean> r34, int r35, java.lang.Long r36, java.lang.Long r37, e9.InterfaceC4014c<? super Ua.Q<w.Result3A>> r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.Controller3A.i(java.util.List, java.util.List, java.util.List, w.F, w.F, w.F, w.a, p9.l, p9.l, int, java.lang.Long, java.lang.Long, e9.c):java.lang.Object");
    }

    public final Q<Result3A> j(Map<CaptureRequest.Key<?>, ? extends Object> triggerCondition, InterfaceC5074l<? super x, Boolean> lockedCondition, int frameLimit, long timeLimitNs) {
        if (this.graphProcessor.s() == null) {
            return f10825s;
        }
        if (triggerCondition == null) {
            triggerCondition = f10824r;
        }
        Iterator<Map.Entry<CaptureRequest.Key<?>, ? extends Object>> it = triggerCondition.entrySet().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (p.d(it.next().getValue(), 1)) {
                z10 = true;
            }
        }
        if (lockedCondition == null) {
            lockedCondition = e(z10, false);
        }
        m mVar = new m(lockedCondition, Integer.valueOf(frameLimit), Long.valueOf(timeLimitNs));
        this.graphListener3A.j(mVar);
        if (k.f44508a.a()) {
            Log.d("CXCP", "lock3AForCapture - sending a request to trigger ae precapture metering and af.");
        }
        if (this.graphProcessor.u(triggerCondition)) {
            this.graphProcessor.t(this.graphState3A.b());
            return mVar.b();
        }
        this.graphListener3A.k(mVar);
        return f10825s;
    }

    public final Q<Result3A> k(boolean triggerAf, boolean waitForAwb, int frameLimit, long timeLimitNs) {
        return j(triggerAf ? f10824r : f10823q, e(triggerAf, waitForAwb), frameLimit, timeLimitNs);
    }

    public final Q<Result3A> l(C5694F aeLockBehavior, C5694F afLockBehavior, C5694F awbLockBehavior, C5695a afTriggerStartAeMode, InterfaceC5074l<? super x, Boolean> lockedCondition, Integer frameLimit, Long timeLimitNs) {
        String str;
        Q<Result3A> qB;
        C5695a c5695a = null;
        Boolean bool = aeLockBehavior == null ? null : Boolean.TRUE;
        Boolean bool2 = awbLockBehavior == null ? null : Boolean.TRUE;
        Map<CaptureResult.Key<?>, List<Object>> mapG = g(bool != null, afLockBehavior != null, bool2 != null);
        if (lockedCondition == null && mapG.isEmpty()) {
            str = "CXCP";
            qB = null;
        } else {
            m mVar = new m(lockedCondition == null ? o.b(mapG) : lockedCondition, frameLimit, timeLimitNs);
            this.graphListener3A.j(mVar);
            str = "CXCP";
            j.d(this.graphState3A, null, null, null, null, null, null, null, bool, null, bool2, 383, null);
            if (k.f44508a.a()) {
                Log.d(str, "lock3A - submitting request with aeLock=" + bool + " , awbLock=" + bool2);
            }
            this.graphProcessor.t(this.graphState3A.b());
            qB = mVar.b();
        }
        if (afLockBehavior == null) {
            p.f(qB);
            return qB;
        }
        if (afTriggerStartAeMode != null) {
            int value = afTriggerStartAeMode.getValue();
            C5695a aeMode = this.graphState3A.a().getAeMode();
            j.d(this.graphState3A, C5695a.d(value), null, null, null, null, null, null, null, null, null, 1022, null);
            this.graphProcessor.t(this.graphState3A.b());
            c5695a = aeMode;
        }
        if (k.f44508a.a()) {
            Log.d(str, "lock3A - submitting a request to lock af.");
        }
        if (!this.graphProcessor.u(f10821o)) {
            return f10825s;
        }
        j.d(this.graphState3A, null, null, null, null, null, null, null, null, Boolean.TRUE, null, 767, null);
        if (c5695a != null) {
            j.d(this.graphState3A, C5695a.d(c5695a.getValue()), null, null, null, null, null, null, null, null, null, 1022, null);
            this.graphProcessor.t(this.graphState3A.b());
        }
        p.f(qB);
        return qB;
    }

    public final Q<Result3A> m(C5695a aeMode) {
        return s(this, aeMode, null, null, C5713t.c(C5713t.INSTANCE.a()), null, null, null, 118, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final Ua.Q<w.Result3A> n() {
        /*
            r11 = this;
            A.j r0 = r11.graphState3A
            A.p r0 = r0.a()
            w.a r0 = r0.getAeMode()
            w.a$a r1 = w.C5695a.INSTANCE
            int r2 = r1.c()
            r3 = 0
            if (r0 != 0) goto L15
            r2 = r3
            goto L1d
        L15:
            int r4 = r0.getValue()
            boolean r2 = w.C5695a.g(r4, r2)
        L1d:
            if (r2 != 0) goto L3b
            int r2 = r1.b()
            if (r0 != 0) goto L26
            goto L2e
        L26:
            int r0 = r0.getValue()
            boolean r3 = w.C5695a.g(r0, r2)
        L2e:
            if (r3 == 0) goto L31
            goto L3b
        L31:
            int r0 = r1.c()
            w.a r0 = w.C5695a.d(r0)
        L39:
            r2 = r0
            goto L3d
        L3b:
            r0 = 0
            goto L39
        L3d:
            w.t$a r0 = w.C5713t.INSTANCE
            int r0 = r0.b()
            w.t r5 = w.C5713t.c(r0)
            r9 = 118(0x76, float:1.65E-43)
            r10 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r11
            Ua.Q r11 = s(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.Controller3A.n():Ua.Q");
    }

    public final Q<Result3A> o(Boolean ae, Boolean af, Boolean awb, InterfaceC5074l<? super x, Boolean> unlockedCondition, int frameLimit, Long timeLimitNs) {
        Boolean bool = !g.INSTANCE.e(this.metadata) ? null : af;
        Boolean bool2 = Boolean.TRUE;
        if (!p.d(ae, bool2) && !p.d(bool, bool2) && !p.d(awb, bool2)) {
            return C1087w.a(new Result3A(Result3A.a.INSTANCE.b(), null, null));
        }
        if (this.graphProcessor.s() == null) {
            return f10825s;
        }
        if (p.d(bool, bool2)) {
            k kVar = k.f44508a;
            if (kVar.a()) {
                Log.d("CXCP", "unlock3A - sending a request to unlock af first.");
            }
            if (!this.graphProcessor.u(f10822p)) {
                if (kVar.a()) {
                    Log.d("CXCP", "unlock3A - failed to send a request to unlock af first.");
                }
                return f10825s;
            }
            j.d(this.graphState3A, null, null, null, null, null, null, null, null, Boolean.FALSE, null, 767, null);
        }
        m mVar = new m(unlockedCondition == null ? o.b(h(p.d(ae, bool2), p.d(bool, bool2), p.d(awb, bool2))) : unlockedCondition, Integer.valueOf(frameLimit), timeLimitNs);
        this.graphListener3A.j(mVar);
        Boolean bool3 = p.d(ae, bool2) ? Boolean.FALSE : null;
        Boolean bool4 = p.d(awb, bool2) ? Boolean.FALSE : null;
        if (bool3 != null || bool4 != null) {
            if (k.f44508a.a()) {
                Log.d("CXCP", "unlock3A - updating graph state, aeLock=" + bool3 + ", awbLock=" + bool4);
            }
            j.d(this.graphState3A, null, null, null, null, null, null, null, bool3, null, bool4, 383, null);
        }
        this.graphProcessor.t(this.graphState3A.b());
        return mVar.b();
    }

    public final Q<Result3A> p(boolean cancelAf) {
        return this.graphProcessor.s() == null ? f10825s : q(cancelAf);
    }

    public final Q<Result3A> q(boolean cancelAf) {
        if (k.f44508a.a()) {
            Log.d("CXCP", "unlock3APostCapture - sending a request to reset af and ae precapture metering.");
        }
        if (!this.graphProcessor.u(cancelAf ? f10810A : f10832z)) {
            return f10825s;
        }
        m mVar = cancelAf ? new m(f10811B, (Integer) null, (Long) null, 6, (i) null) : new m(kotlin.collections.a.i(), (Integer) null, (Long) null, 6, (i) null);
        this.graphListener3A.j(mVar);
        this.graphProcessor.t(this.graphState3A.b());
        return mVar.b();
    }

    public final Q<Result3A> r(C5695a aeMode, C5696b afMode, C5697c awbMode, C5713t flashMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        if (this.graphProcessor.s() == null) {
            j.d(this.graphState3A, aeMode, afMode, awbMode, flashMode, aeRegions, afRegions, awbRegions, null, null, null, 896, null);
            this.graphProcessor.t(this.graphState3A.b());
            return f10825s;
        }
        m mVarD = d(aeMode, afMode, awbMode, flashMode);
        this.graphListener3A.j(mVarD);
        j.d(this.graphState3A, aeMode, afMode, awbMode, flashMode, aeRegions, afRegions, awbRegions, null, null, null, 896, null);
        this.graphProcessor.t(this.graphState3A.b());
        Q<Result3A> qB = mVarD.b();
        synchronized (this) {
            try {
                if (k.f44508a.a()) {
                    Log.d("CXCP", "Controller3A#update3A: cancelling previous request " + this.lastUpdate3AResult);
                }
                Q<Result3A> q10 = this.lastUpdate3AResult;
                if (q10 != null) {
                    JobKt__JobKt.f(q10, "A newer call for 3A state update initiated.", null, 2, null);
                }
                this.lastUpdate3AResult = qB;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qB;
    }
}
