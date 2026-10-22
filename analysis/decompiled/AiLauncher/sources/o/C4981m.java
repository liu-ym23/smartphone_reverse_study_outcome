package o;

import D.C0761b0;
import K.l0;
import android.os.Looper;
import android.util.Log;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.core.CameraState;
import androidx.camera.core.impl.CameraInternal;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import t.C5473b;
import w.AbstractC5689A;
import w.C5706l;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0002\u0019\u001dB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\u0013\u0010\rJ#\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010)R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\f\u00100R&\u00106\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#03\u0012\u0004\u0012\u000204028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u00105¨\u00067"}, d2 = {"Lo/m;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraph", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/camera/camera2/pipe/CameraGraph;)V", "Lw/A;", "graphState", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/camera2/pipe/CameraGraph;Lw/A;)V", "Landroidx/camera/core/impl/CameraInternal$State;", "currentState", "Lo/m$a;", Const.INTENT_KEY_UMID, "(Landroidx/camera/core/impl/CameraInternal$State;Lw/A;)Lo/m$a;", "f", "internalState", "Landroidx/camera/core/CameraState$a;", "stateError", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroidx/camera/core/impl/CameraInternal$State;Landroidx/camera/core/CameraState$a;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "lock", "LK/l0;", Const.INTENT_KEY_PKGNAME, "LK/l0;", "getCameraInternalState$camera_camera2", "()LK/l0;", "cameraInternalState", "Landroidx/lifecycle/y;", "Landroidx/camera/core/CameraState;", "c", "Landroidx/lifecycle/y;", "e", "()Landroidx/lifecycle/y;", "cameraState", "Landroidx/camera/camera2/pipe/CameraGraph;", "currentGraph", "Landroidx/camera/core/impl/CameraInternal$State;", "currentCameraInternalState", "Landroidx/camera/core/CameraState$a;", "currentCameraStateError", "", "Z", "isRemoved", "", "LB0/a;", "Ljava/util/concurrent/Executor;", "Ljava/util/Map;", "cameraStateListeners", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4981m {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object lock = new Object();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final l0<CameraInternal.State> cameraInternalState = new l0<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final android.view.y<CameraState> cameraState = new android.view.y<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public CameraGraph currentGraph;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public CameraInternal.State currentCameraInternalState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public CameraState.a currentCameraStateError;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean isRemoved;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Map<B0.a<CameraState>, Executor> cameraStateListeners;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lo/m$b;", "", "<init>", "()V", "Lw/l;", "Landroidx/camera/core/CameraState$a;", Const.INTENT_KEY_UMID, "(I)Landroidx/camera/core/CameraState$a;", "Landroidx/camera/core/impl/CameraInternal$State;", "Landroidx/camera/core/CameraState$Type;", "c", "(Landroidx/camera/core/impl/CameraInternal$State;)Landroidx/camera/core/CameraState$Type;", "cameraError", "", Const.INTENT_KEY_APIKEY, "(I)Z", "Landroidx/lifecycle/y;", "Landroidx/camera/core/CameraState;", "cameraState", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/lifecycle/y;Landroidx/camera/core/CameraState;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.m$b, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: o.m$b$a */
        public static final /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f37412a;

            static {
                int[] iArr = new int[CameraInternal.State.values().length];
                try {
                    iArr[CameraInternal.State.CLOSED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CameraInternal.State.OPENING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CameraInternal.State.OPEN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CameraInternal.State.CLOSING.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CameraInternal.State.PENDING_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f37412a = iArr;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(int cameraError) {
            C5706l.Companion companion = C5706l.INSTANCE;
            return C5706l.r(cameraError, companion.f()) || C5706l.r(cameraError, companion.g()) || C5706l.r(cameraError, companion.h()) || C5706l.r(cameraError, companion.d());
        }

        public final void b(android.view.y<CameraState> yVar, CameraState cameraState) {
            kotlin.jvm.internal.p.i(yVar, "<this>");
            kotlin.jvm.internal.p.i(cameraState, "cameraState");
            if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
                yVar.k(cameraState);
            } else {
                yVar.i(cameraState);
            }
        }

        public final CameraState.Type c(CameraInternal.State state) {
            kotlin.jvm.internal.p.i(state, "<this>");
            int i10 = a.f37412a[state.ordinal()];
            if (i10 == 1) {
                return CameraState.Type.CLOSED;
            }
            if (i10 == 2) {
                return CameraState.Type.OPENING;
            }
            if (i10 == 3) {
                return CameraState.Type.OPEN;
            }
            if (i10 == 4) {
                return CameraState.Type.CLOSING;
            }
            if (i10 == 5) {
                return CameraState.Type.PENDING_OPEN;
            }
            throw new IllegalArgumentException("Unexpected CameraInternal state: " + state);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.camera.core.CameraState.a d(int r4) {
            /*
                r3 = this;
                w.l$a r3 = w.C5706l.INSTANCE
                int r0 = r3.p()
                boolean r0 = w.C5706l.r(r4, r0)
                r1 = 6
                if (r0 == 0) goto Lf
                goto La8
            Lf:
                int r0 = r3.g()
                boolean r0 = w.C5706l.r(r4, r0)
                r2 = 2
                if (r0 == 0) goto L1d
            L1a:
                r1 = r2
                goto La8
            L1d:
                int r0 = r3.h()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L2a
                r1 = 1
                goto La8
            L2a:
                int r0 = r3.e()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L37
                r1 = 5
                goto La8
            L37:
                int r0 = r3.d()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L44
                r1 = 3
                goto La8
            L44:
                int r0 = r3.k()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L4f
                goto La8
            L4f:
                int r0 = r3.f()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L5a
                goto L1a
            L5a:
                int r0 = r3.n()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L65
                goto La8
            L65:
                int r0 = r3.o()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L70
                goto La8
            L70:
                int r0 = r3.m()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L7c
                r1 = 4
                goto La8
            L7c:
                int r0 = r3.l()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L88
                r1 = 7
                goto La8
            L88:
                int r0 = r3.q()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L93
                goto La8
            L93:
                int r0 = r3.i()
                boolean r0 = w.C5706l.r(r4, r0)
                if (r0 == 0) goto L9e
                goto La8
            L9e:
                int r3 = r3.j()
                boolean r3 = w.C5706l.r(r4, r3)
                if (r3 == 0) goto Lb2
            La8:
                androidx.camera.core.CameraState$a r3 = androidx.camera.core.CameraState.a.a(r1)
                java.lang.String r4 = "create(...)"
                kotlin.jvm.internal.p.h(r3, r4)
                return r3
            Lb2:
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unexpected CameraError: "
                r0.append(r1)
                java.lang.String r4 = w.C5706l.u(r4)
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r3.<init>(r4)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: o.C4981m.Companion.d(int):androidx.camera.core.CameraState$a");
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.m$c */
    public static final /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37413a;

        static {
            int[] iArr = new int[CameraInternal.State.values().length];
            try {
                iArr[CameraInternal.State.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CameraInternal.State.OPENING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CameraInternal.State.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CameraInternal.State.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CameraInternal.State.PENDING_OPEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f37413a = iArr;
        }
    }

    public C4981m() {
        CameraInternal.State state = CameraInternal.State.CLOSED;
        this.currentCameraInternalState = state;
        this.cameraStateListeners = new LinkedHashMap();
        k(this, state, null, 2, null);
    }

    public static /* synthetic */ void k(C4981m c4981m, CameraInternal.State state, CameraState.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        c4981m.j(state, aVar);
    }

    public static final void l(B0.a aVar, CameraState cameraState) {
        aVar.accept(cameraState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CombinedCameraState d(CameraInternal.State currentState, AbstractC5689A graphState) {
        kotlin.jvm.internal.p.i(currentState, "currentState");
        kotlin.jvm.internal.p.i(graphState, "graphState");
        int i10 = c.f37413a[currentState.ordinal()];
        int i11 = 2;
        CameraState.a aVar = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        Object[] objArr12 = 0;
        Object[] objArr13 = 0;
        Object[] objArr14 = 0;
        Object[] objArr15 = 0;
        Object[] objArr16 = 0;
        Object[] objArr17 = 0;
        Object[] objArr18 = 0;
        Object[] objArr19 = 0;
        Object[] objArr20 = 0;
        Object[] objArr21 = 0;
        if (i10 == 1) {
            if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.c.f42887b)) {
                return new CombinedCameraState(CameraInternal.State.OPENING, objArr4 == true ? 1 : 0, i11, objArr3 == true ? 1 : 0);
            }
            if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.b.f42886b)) {
                return new CombinedCameraState(CameraInternal.State.OPEN, objArr2 == true ? 1 : 0, i11, objArr == true ? 1 : 0);
            }
            return null;
        }
        if (i10 == 2) {
            if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.b.f42886b)) {
                return new CombinedCameraState(CameraInternal.State.OPEN, objArr10 == true ? 1 : 0, i11, objArr9 == true ? 1 : 0);
            }
            if (graphState instanceof AbstractC5689A.a) {
                AbstractC5689A.a aVar2 = (AbstractC5689A.a) graphState;
                if (aVar2.getWillAttemptRetry()) {
                    return new CombinedCameraState(CameraInternal.State.OPENING, INSTANCE.d(aVar2.getCameraError()));
                }
                Companion companion = INSTANCE;
                return companion.a(aVar2.getCameraError()) ? new CombinedCameraState(CameraInternal.State.PENDING_OPEN, companion.d(aVar2.getCameraError())) : new CombinedCameraState(CameraInternal.State.CLOSING, companion.d(aVar2.getCameraError()));
            }
            if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.e.f42889b)) {
                return new CombinedCameraState(CameraInternal.State.CLOSING, objArr8 == true ? 1 : 0, i11, objArr7 == true ? 1 : 0);
            }
            if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.d.f42888b)) {
                return new CombinedCameraState(CameraInternal.State.CLOSED, objArr6 == true ? 1 : 0, i11, objArr5 == true ? 1 : 0);
            }
            return null;
        }
        if (i10 == 3) {
            if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.e.f42889b)) {
                return new CombinedCameraState(CameraInternal.State.CLOSING, objArr14 == true ? 1 : 0, i11, objArr13 == true ? 1 : 0);
            }
            if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.d.f42888b)) {
                return new CombinedCameraState(CameraInternal.State.CLOSED, objArr12 == true ? 1 : 0, i11, objArr11 == true ? 1 : 0);
            }
            if (!(graphState instanceof AbstractC5689A.a)) {
                return null;
            }
            Companion companion2 = INSTANCE;
            AbstractC5689A.a aVar3 = (AbstractC5689A.a) graphState;
            return companion2.a(aVar3.getCameraError()) ? new CombinedCameraState(CameraInternal.State.PENDING_OPEN, companion2.d(aVar3.getCameraError())) : new CombinedCameraState(CameraInternal.State.CLOSED, companion2.d(aVar3.getCameraError()));
        }
        if (i10 == 4) {
            if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.d.f42888b)) {
                return new CombinedCameraState(CameraInternal.State.CLOSED, objArr18 == true ? 1 : 0, i11, objArr17 == true ? 1 : 0);
            }
            if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.c.f42887b)) {
                return new CombinedCameraState(CameraInternal.State.OPENING, objArr16 == true ? 1 : 0, i11, objArr15 == true ? 1 : 0);
            }
            if (graphState instanceof AbstractC5689A.a) {
                return new CombinedCameraState(CameraInternal.State.CLOSING, INSTANCE.d(((AbstractC5689A.a) graphState).getCameraError()));
            }
            return null;
        }
        if (i10 != 5) {
            return null;
        }
        if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.c.f42887b)) {
            return new CombinedCameraState(CameraInternal.State.OPENING, aVar, i11, objArr21 == true ? 1 : 0);
        }
        if (kotlin.jvm.internal.p.d(graphState, AbstractC5689A.b.f42886b)) {
            return new CombinedCameraState(CameraInternal.State.OPEN, objArr20 == true ? 1 : 0, i11, objArr19 == true ? 1 : 0);
        }
        if (!(graphState instanceof AbstractC5689A.a)) {
            return null;
        }
        Companion companion3 = INSTANCE;
        AbstractC5689A.a aVar4 = (AbstractC5689A.a) graphState;
        return companion3.a(aVar4.getCameraError()) ? new CombinedCameraState(CameraInternal.State.PENDING_OPEN, companion3.d(aVar4.getCameraError())) : new CombinedCameraState(CameraInternal.State.CLOSED, companion3.d(aVar4.getCameraError()));
    }

    public final android.view.y<CameraState> e() {
        return this.cameraState;
    }

    public final void f(CameraGraph cameraGraph, AbstractC5689A graphState) {
        if (!kotlin.jvm.internal.p.d(cameraGraph, this.currentGraph)) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "Ignored stale transition " + graphState + " for " + cameraGraph);
                return;
            }
            return;
        }
        CombinedCameraState combinedCameraStateD = d(this.currentCameraInternalState, graphState);
        if (combinedCameraStateD == null) {
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "Impermissible state transition: current camera internal state: " + this.currentCameraInternalState + ", received graph state: " + graphState);
                return;
            }
            return;
        }
        this.currentCameraInternalState = combinedCameraStateD.getState();
        this.currentCameraStateError = combinedCameraStateD.getError();
        C5473b c5473b3 = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Updated current camera internal state to " + combinedCameraStateD);
        }
        j(this.currentCameraInternalState, this.currentCameraStateError);
    }

    public final void g(CameraGraph cameraGraph, AbstractC5689A graphState) {
        kotlin.jvm.internal.p.i(cameraGraph, "cameraGraph");
        kotlin.jvm.internal.p.i(graphState, "graphState");
        synchronized (this.lock) {
            if (this.isRemoved) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.k("CXCP")) {
                    Log.w(C5473b.TRUNCATED_TAG, "Ignoring graph state update " + graphState + " on removed camera.");
                }
                return;
            }
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, cameraGraph + " state updated to " + graphState);
            }
            f(cameraGraph, graphState);
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void h(CameraGraph cameraGraph) {
        kotlin.jvm.internal.p.i(cameraGraph, "cameraGraph");
        synchronized (this.lock) {
            try {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    Log.d(C5473b.TRUNCATED_TAG, "Camera graph updated from " + this.currentGraph + " to " + cameraGraph);
                }
                CameraInternal.State state = this.currentCameraInternalState;
                CameraInternal.State state2 = CameraInternal.State.CLOSED;
                if (state != state2) {
                    k(this, CameraInternal.State.CLOSING, null, 2, null);
                    k(this, state2, null, 2, null);
                }
                this.currentGraph = cameraGraph;
                this.currentCameraInternalState = state2;
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        CameraState.a aVarA = CameraState.a.a(8);
        kotlin.jvm.internal.p.h(aVarA, "create(...)");
        synchronized (this.lock) {
            try {
                if (this.isRemoved) {
                    return;
                }
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    Log.d(C5473b.TRUNCATED_TAG, "Camera is removed, forcing state to CLOSED.");
                }
                this.isRemoved = true;
                CameraInternal.State state = CameraInternal.State.CLOSED;
                this.currentCameraInternalState = state;
                this.currentCameraStateError = aVarA;
                j(state, aVarA);
                this.currentGraph = null;
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(CameraInternal.State internalState, CameraState.a stateError) {
        List<Map.Entry> listM1;
        this.cameraInternalState.m(internalState);
        Companion companion = INSTANCE;
        final CameraState cameraStateA = CameraState.a(companion.c(internalState), stateError);
        kotlin.jvm.internal.p.h(cameraStateA, "create(...)");
        companion.b(this.cameraState, cameraStateA);
        synchronized (this.lock) {
            listM1 = Z8.F.m1(this.cameraStateListeners.entrySet());
        }
        for (Map.Entry entry : listM1) {
            final B0.a aVar = (B0.a) entry.getKey();
            ((Executor) entry.getValue()).execute(new Runnable() { // from class: o.l
                @Override // java.lang.Runnable
                public final void run() {
                    C4981m.l(aVar, cameraStateA);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017¨\u0006\u0018"}, d2 = {"Lo/m$a;", "", "Landroidx/camera/core/impl/CameraInternal$State;", VoiceWakeupReceiver.EXTRA_STATE, "Landroidx/camera/core/CameraState$a;", "error", "<init>", "(Landroidx/camera/core/impl/CameraInternal$State;Landroidx/camera/core/CameraState$a;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/core/impl/CameraInternal$State;", Const.INTENT_KEY_PKGNAME, "()Landroidx/camera/core/impl/CameraInternal$State;", "Landroidx/camera/core/CameraState$a;", "()Landroidx/camera/core/CameraState$a;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.m$a, reason: from toString */
    public static final /* data */ class CombinedCameraState {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final CameraInternal.State state;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final CameraState.a error;

        public CombinedCameraState(CameraInternal.State state, CameraState.a aVar) {
            kotlin.jvm.internal.p.i(state, "state");
            this.state = state;
            this.error = aVar;
        }

        /* renamed from: a, reason: from getter */
        public final CameraState.a getError() {
            return this.error;
        }

        /* renamed from: b, reason: from getter */
        public final CameraInternal.State getState() {
            return this.state;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CombinedCameraState)) {
                return false;
            }
            CombinedCameraState combinedCameraState = (CombinedCameraState) other;
            return this.state == combinedCameraState.state && kotlin.jvm.internal.p.d(this.error, combinedCameraState.error);
        }

        public int hashCode() {
            int iHashCode = this.state.hashCode() * 31;
            CameraState.a aVar = this.error;
            return iHashCode + (aVar == null ? 0 : aVar.hashCode());
        }

        public String toString() {
            return "CombinedCameraState(state=" + this.state + ", error=" + this.error + ')';
        }

        public /* synthetic */ CombinedCameraState(CameraInternal.State state, CameraState.a aVar, int i10, kotlin.jvm.internal.i iVar) {
            this(state, (i10 & 2) != 0 ? null : aVar);
        }
    }
}
