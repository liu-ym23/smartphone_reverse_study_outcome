package androidx.camera.camera2.pipe.compat;

import Ua.C1060i;
import Ua.M;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.C4109a;
import kotlin.Metadata;
import w.C5706l;
import x.AbstractC5824k0;
import x.CameraStateClosed;
import x.CameraStateClosing;
import x.K0;
import x.L0;
import x.o0;
import z.z;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0080@¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u00101R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00106R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010C¨\u0006E"}, d2 = {"Landroidx/camera/camera2/pipe/compat/VirtualCameraState;", "Lx/K0;", "Lw/n;", "cameraId", "LA/e;", "graphListener", "LUa/M;", "scope", "<init>", "(Ljava/lang/String;LA/e;LUa/M;Lkotlin/jvm/internal/i;)V", "LXa/b;", "Lx/k0;", VoiceWakeupReceiver.EXTRA_STATE, "Lz/z;", "wakelockToken", "LY8/t;", "f", "(LXa/b;Lz/z;Le9/c;)Ljava/lang/Object;", "Lw/l;", "lastCameraError", Const.INTENT_KEY_PKGNAME, "(Lw/l;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lx/k0;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LA/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LA/e;", "c", "LUa/M;", "getScope", "()LUa/M;", "", Const.INTENT_KEY_UMID, "I", "debugId", "", "e", "Ljava/lang/Object;", "lock", "", "Z", AlipayXuiIsland.REASON_CLOSED, "Landroidx/camera/camera2/pipe/compat/w;", "Landroidx/camera/camera2/pipe/compat/w;", "currentVirtualAndroidCamera", "LXa/j;", "LXa/j;", "_stateFlow", "LXa/b;", "_states", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lx/k0;", "_lastState", "Lkotlinx/coroutines/g;", "k", "Lkotlinx/coroutines/g;", "job", "l", "Lz/z;", "getState", "()LXa/b;", "()Lx/k0;", UxipConstants.f30680s, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VirtualCameraState implements K0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String cameraId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final A.e graphListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int debugId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public w currentVirtualAndroidCamera;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Xa.j<AbstractC5824k0> _stateFlow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Xa.b<AbstractC5824k0> _states;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public AbstractC5824k0 _lastState;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g job;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public z wakelockToken;

    public /* synthetic */ VirtualCameraState(String str, A.e eVar, M m10, kotlin.jvm.internal.i iVar) {
        this(str, eVar, m10);
    }

    @Override // x.K0
    public void b(C5706l lastCameraError) {
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                if (z.k.f44508a.c()) {
                    Log.i("CXCP", "Disconnecting " + this);
                }
                w wVar = this.currentVirtualAndroidCamera;
                if (wVar != null) {
                    wVar.c();
                }
                kotlinx.coroutines.g gVar = this.job;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                z zVar = this.wakelockToken;
                if (zVar != null) {
                    zVar.release();
                }
                if (!(j() instanceof CameraStateClosed)) {
                    if (!(this._lastState instanceof CameraStateClosing)) {
                        g(new CameraStateClosing(null, 1, null));
                    }
                    g(new CameraStateClosed(this.cameraId, ClosedReason.APP_DISCONNECTED, null, null, null, null, null, null, lastCameraError, 252, null));
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object f(Xa.b<? extends AbstractC5824k0> bVar, z zVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        synchronized (this.lock) {
            try {
                if (!this.closed) {
                    this.job = C1060i.d(this.scope, null, null, new VirtualCameraState$connect$2$1(bVar, this, null), 3, null);
                    this.wakelockToken = zVar;
                    return Y8.t.f7040a;
                }
                if (zVar != null) {
                    C4109a.a(zVar.release());
                }
                return Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(AbstractC5824k0 state) {
        this._lastState = state;
        if (this._stateFlow.a(state)) {
            return;
        }
        throw new IllegalStateException(("Failed to emit " + state + " in " + this).toString());
    }

    @Override // x.K0
    public Xa.b<AbstractC5824k0> getState() {
        return this._states;
    }

    /* renamed from: h, reason: from getter */
    public final String getCameraId() {
        return this.cameraId;
    }

    /* renamed from: i, reason: from getter */
    public final A.e getGraphListener() {
        return this.graphListener;
    }

    public AbstractC5824k0 j() {
        AbstractC5824k0 abstractC5824k0;
        synchronized (this.lock) {
            abstractC5824k0 = this._lastState;
        }
        return abstractC5824k0;
    }

    public String toString() {
        return "VirtualCamera-" + this.debugId;
    }

    public VirtualCameraState(String cameraId, A.e graphListener, M scope) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(graphListener, "graphListener");
        kotlin.jvm.internal.p.i(scope, "scope");
        this.cameraId = cameraId;
        this.graphListener = graphListener;
        this.scope = scope;
        this.debugId = L0.b().d();
        this.lock = new Object();
        Xa.j<AbstractC5824k0> jVarB = Xa.p.b(1, 3, null, 4, null);
        this._stateFlow = jVarB;
        this._states = Xa.d.q(jVarB);
        o0 o0Var = o0.f43432a;
        this._lastState = o0Var;
        if (!jVarB.a(o0Var)) {
            throw new IllegalStateException("Check failed.");
        }
    }
}
