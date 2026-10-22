package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import Y8.j;
import Y8.t;
import Z8.F;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.impl.State3AControl;
import androidx.camera.camera2.impl.g;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.l;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import r.InterfaceC5183a;
import t.C5473b;
import t.C5492t;
import t.InterfaceC5494v;
import t.j0;
import t.y0;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u001b\u0010,\u001a\u00020\u000e2\n\u0010+\u001a\u00060)j\u0002`*H\u0002¢\u0006\u0004\b,\u0010-J)\u00101\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000bH\u0002¢\u0006\u0004\b4\u00105R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\b7\u00108R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010BR \u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0E0D8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010R\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010TR(\u0010Z\u001a\u0004\u0018\u00010A2\b\u0010\f\u001a\u0004\u0018\u00010A8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\b9\u0010Y¨\u0006["}, d2 = {"Landroidx/camera/camera2/impl/State3AControl;", "Lt/j0;", "Landroidx/camera/camera2/impl/g$a;", "Lt/v;", "cameraProperties", "Lr/a;", "aeModeDisabler", "Lt/y0;", "threads", "<init>", "(Lt/v;Lr/a;Lt/y0;)V", "", UxipConstants.f30680s, "LUa/Q;", "LY8/t;", "r", "(I)LUa/Q;", "", "u", "(Z)LUa/Q;", "s", "(Ljava/lang/Integer;)LUa/Q;", "t", "reset", "()V", "", "Landroidx/camera/core/UseCase;", "runningUseCases", Const.INTENT_KEY_APIKEY, "(Ljava/util/Set;)V", "p", "()I", "useCases", "l", "(Ljava/util/Set;)I", "v", "()LUa/Q;", "", "myRevision", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "m", "(Ljava/lang/Exception;)V", "flashMode", "tryExternalFlashAeMode", "preferredAeMode", "o", "(IZLjava/lang/Integer;)I", M5.e.FAIL_TEMPLATE, "n", "(I)I", "Lt/v;", "getCameraProperties", "()Lt/v;", Const.INTENT_KEY_PKGNAME, "Lr/a;", "c", "Lt/y0;", "", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "lock", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "_requestControl", "", "LUa/u;", "f", "Ljava/util/List;", "pendingSignals", Const.INTENT_KEY_BACKGROUND_COMMAND, "J", "currentRevision", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "I", "_flashMode", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "_template", "Z", "_tryExternalFlashAeMode", "k", "Ljava/lang/Integer;", "_preferredAeMode", "_preferredFocusMode", "q", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "requestControl", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class State3AControl implements j0, g.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5183a aeModeDisabler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraRequestControl _requestControl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final List<InterfaceC1083u<t>> pendingSignals;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public long currentRevision;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int _flashMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int _template;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean _tryExternalFlashAeMode;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public Integer _preferredAeMode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public Integer _preferredFocusMode;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u0015\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u0017\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/impl/State3AControl$a;", "", "", "flashMode", M5.e.FAIL_TEMPLATE, "", "tryExternalFlashAeMode", "preferredAeMode", "preferredFocusMode", "<init>", "(IIZLjava/lang/Integer;Ljava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "c", "Z", "e", "()Z", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.impl.State3AControl$a, reason: from toString */
    public static final /* data */ class StateSnapshot {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int flashMode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int template;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean tryExternalFlashAeMode;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final Integer preferredAeMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final Integer preferredFocusMode;

        public StateSnapshot(int i10, int i11, boolean z10, Integer num, Integer num2) {
            this.flashMode = i10;
            this.template = i11;
            this.tryExternalFlashAeMode = z10;
            this.preferredAeMode = num;
            this.preferredFocusMode = num2;
        }

        /* renamed from: a, reason: from getter */
        public final int getFlashMode() {
            return this.flashMode;
        }

        /* renamed from: b, reason: from getter */
        public final Integer getPreferredAeMode() {
            return this.preferredAeMode;
        }

        /* renamed from: c, reason: from getter */
        public final Integer getPreferredFocusMode() {
            return this.preferredFocusMode;
        }

        /* renamed from: d, reason: from getter */
        public final int getTemplate() {
            return this.template;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getTryExternalFlashAeMode() {
            return this.tryExternalFlashAeMode;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateSnapshot)) {
                return false;
            }
            StateSnapshot stateSnapshot = (StateSnapshot) other;
            return this.flashMode == stateSnapshot.flashMode && this.template == stateSnapshot.template && this.tryExternalFlashAeMode == stateSnapshot.tryExternalFlashAeMode && p.d(this.preferredAeMode, stateSnapshot.preferredAeMode) && p.d(this.preferredFocusMode, stateSnapshot.preferredFocusMode);
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.flashMode) * 31) + Integer.hashCode(this.template)) * 31) + Boolean.hashCode(this.tryExternalFlashAeMode)) * 31;
            Integer num = this.preferredAeMode;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.preferredFocusMode;
            return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "StateSnapshot(flashMode=" + this.flashMode + ", template=" + this.template + ", tryExternalFlashAeMode=" + this.tryExternalFlashAeMode + ", preferredAeMode=" + this.preferredAeMode + ", preferredFocusMode=" + this.preferredFocusMode + ')';
        }
    }

    public State3AControl(InterfaceC5494v cameraProperties, InterfaceC5183a aeModeDisabler, y0 threads) {
        p.i(cameraProperties, "cameraProperties");
        p.i(aeModeDisabler, "aeModeDisabler");
        p.i(threads, "threads");
        this.cameraProperties = cameraProperties;
        this.aeModeDisabler = aeModeDisabler;
        this.threads = threads;
        this.lock = new Object();
        this.pendingSignals = new ArrayList();
        this._flashMode = 2;
        this._template = 1;
    }

    public static final t k(List list, State3AControl state3AControl, Throwable th) {
        if (th != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((InterfaceC1083u) it.next()).e(th);
            }
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((InterfaceC1083u) it2.next()).complete(t.f7040a);
            }
        }
        synchronized (state3AControl.lock) {
            state3AControl.pendingSignals.removeAll(list);
        }
        return t.f7040a;
    }

    @Override // androidx.camera.camera2.impl.g.a
    public void a(Set<? extends UseCase> runningUseCases) {
        p.i(runningUseCases, "runningUseCases");
        C1060i.d(this.threads.getSequentialScope(), null, null, new State3AControl$onRunningUseCasesChanged$$inlined$confineLaunch$1(null, F.r1(runningUseCases), this), 3, null);
    }

    @Override // t.j0
    public void b(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        v();
    }

    public final void j(long myRevision) {
        boolean z10;
        StateSnapshot stateSnapshot;
        final List listM1;
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_requestControl();
        if (useCaseCameraRequestControl == null) {
            m(new CameraControl$OperationCanceledException("Camera is not active."));
            return;
        }
        synchronized (this.lock) {
            z10 = myRevision == this.currentRevision;
        }
        if (z10) {
            synchronized (this.lock) {
                stateSnapshot = new StateSnapshot(this._flashMode, this._template, this._tryExternalFlashAeMode, this._preferredAeMode, this._preferredFocusMode);
            }
            int iO = o(stateSnapshot.getFlashMode(), stateSnapshot.getTryExternalFlashAeMode(), stateSnapshot.getPreferredAeMode());
            Integer preferredFocusMode = stateSnapshot.getPreferredFocusMode();
            try {
                Q qM = UseCaseCameraRequestControl.m(useCaseCameraRequestControl, kotlin.collections.a.m(j.a(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(C5492t.d(this.cameraProperties.getMetadata(), iO))), j.a(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(C5492t.e(this.cameraProperties.getMetadata(), preferredFocusMode != null ? preferredFocusMode.intValue() : n(stateSnapshot.getTemplate())))), j.a(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(C5492t.f(this.cameraProperties.getMetadata(), 1)))), null, null, 6, null);
                synchronized (this.lock) {
                    listM1 = F.m1(this.pendingSignals);
                }
                qM.J(new InterfaceC5074l() { // from class: t.d0
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return State3AControl.k(listM1, this, (Throwable) obj);
                    }
                });
            } catch (Exception e10) {
                m(e10);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int l(Set<? extends UseCase> useCases) {
        l lVarL;
        SessionConfig sessionConfigN = new SessionConfigAdapter(useCases, false, 2, 0 == true ? 1 : 0).n();
        if (sessionConfigN == null || (lVarL = sessionConfigN.l()) == null) {
            return 1;
        }
        Integer numValueOf = Integer.valueOf(lVarL.j());
        Integer num = numValueOf.intValue() != -1 ? numValueOf : null;
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public final void m(Exception e10) {
        List listM1;
        synchronized (this.lock) {
            listM1 = F.m1(this.pendingSignals);
            this.pendingSignals.clear();
        }
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            ((InterfaceC1083u) it.next()).e(e10);
        }
    }

    public final int n(int template) {
        return (template == 1 || template != 3) ? 4 : 3;
    }

    public final int o(int flashMode, boolean tryExternalFlashAeMode, Integer preferredAeMode) {
        int iIntValue = preferredAeMode != null ? preferredAeMode.intValue() : flashMode != 0 ? flashMode != 1 ? 1 : 3 : this.aeModeDisabler.a(2);
        if (tryExternalFlashAeMode && C5492t.h(this.cameraProperties.getMetadata())) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "State3AControl.invalidate: trying external flash AE mode.");
            }
            iIntValue = 5;
        }
        C5473b c5473b2 = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "State3AControl.getFinalPreferredAeMode: preferAeMode = " + iIntValue);
        }
        return iIntValue;
    }

    public final int p() {
        int iD;
        synchronized (this.lock) {
            iD = C5492t.d(this.cameraProperties.getMetadata(), o(this._flashMode, this._tryExternalFlashAeMode, this._preferredAeMode));
        }
        return iD;
    }

    /* renamed from: q, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    public final Q<t> r(int value) {
        synchronized (this.lock) {
            this._flashMode = value;
            t tVar = t.f7040a;
        }
        return v();
    }

    @Override // t.j0
    public void reset() {
        synchronized (this.lock) {
            this._tryExternalFlashAeMode = false;
            this._preferredAeMode = null;
            this._preferredFocusMode = null;
            this._flashMode = 2;
            this._template = 1;
            t tVar = t.f7040a;
        }
        v();
    }

    public final Q<t> s(Integer value) {
        synchronized (this.lock) {
            this._preferredAeMode = value;
            t tVar = t.f7040a;
        }
        return v();
    }

    public final Q<t> t(Integer value) {
        synchronized (this.lock) {
            this._preferredFocusMode = value;
            t tVar = t.f7040a;
        }
        return v();
    }

    public final Q<t> u(boolean value) {
        synchronized (this.lock) {
            this._tryExternalFlashAeMode = value;
            t tVar = t.f7040a;
        }
        return v();
    }

    public final Q<t> v() {
        InterfaceC1083u<t> interfaceC1083uC = C1087w.c(null, 1, null);
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        synchronized (this.lock) {
            this.pendingSignals.add(interfaceC1083uC);
            long j10 = this.currentRevision + 1;
            this.currentRevision = j10;
            ref$LongRef.f34819a = j10;
            t tVar = t.f7040a;
        }
        C1060i.d(this.threads.getSequentialScope(), null, null, new State3AControl$update$$inlined$confineLaunch$1(null, this, ref$LongRef), 3, null);
        return interfaceC1083uC;
    }
}
