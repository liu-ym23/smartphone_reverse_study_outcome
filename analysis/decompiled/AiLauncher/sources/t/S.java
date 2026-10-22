package t;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import android.util.Range;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.core.CameraControl$OperationCanceledException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import o.EvCompValue;
import p.InterfaceC5030l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R$\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010&R(\u0010*\u001a\u0004\u0018\u00010%2\b\u0010\u0017\u001a\u0004\u0018\u00010%8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010(\"\u0004\b\u0018\u0010)¨\u0006+"}, d2 = {"Lt/S;", "Lt/j0;", "Lp/l;", "compat", "<init>", "(Lp/l;)V", "LY8/t;", "reset", "()V", "", "exposureIndex", "", "cancelPreviousTask", "LUa/Q;", "e", "(IZ)LUa/Q;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "LUa/u;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Exception;)LUa/u;", "Lp/l;", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_UMID, "(I)V", "evCompIndex", "Lo/z;", "c", "Lo/z;", "getExposureState", "()Lo/z;", "setExposureState", "(Lo/z;)V", "exposureState", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "_requestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "requestControl", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class S implements j0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5030l compat;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int evCompIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public EvCompValue exposureState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraRequestControl _requestControl;

    public S(InterfaceC5030l compat) {
        kotlin.jvm.internal.p.i(compat, "compat");
        this.compat = compat;
        this.exposureState = new EvCompValue(compat.c(), this.evCompIndex, compat.a(), compat.e());
    }

    public static /* synthetic */ Ua.Q f(S s10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        return s10.e(i10, z10);
    }

    public final InterfaceC1083u<Integer> a(Exception exception) {
        InterfaceC1083u<Integer> interfaceC1083uC = C1087w.c(null, 1, null);
        interfaceC1083uC.e(exception);
        return interfaceC1083uC;
    }

    @Override // t.j0
    public void b(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        e(this.evCompIndex, false);
    }

    /* renamed from: c, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    public final void d(int i10) {
        this.evCompIndex = i10;
        this.exposureState = this.exposureState.c(i10);
    }

    public final Ua.Q<Integer> e(int exposureIndex, boolean cancelPreviousTask) {
        if (!this.compat.c()) {
            return a(new IllegalArgumentException("ExposureCompensation is not supported"));
        }
        if (this.compat.a().contains((Range<Integer>) Integer.valueOf(exposureIndex))) {
            UseCaseCameraRequestControl useCaseCameraRequestControl = get_requestControl();
            if (useCaseCameraRequestControl != null) {
                d(exposureIndex);
                Ua.Q<Integer> qB = this.compat.b(exposureIndex, useCaseCameraRequestControl, cancelPreviousTask);
                if (qB != null) {
                    return qB;
                }
            }
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera is not active.");
            this.compat.d(cameraControl$OperationCanceledException);
            return a(cameraControl$OperationCanceledException);
        }
        return a(new IllegalArgumentException("Requested ExposureCompensation " + exposureIndex + " is not within valid range [" + this.compat.a().getUpper() + " .. " + this.compat.a().getLower() + ']'));
    }

    @Override // t.j0
    public void reset() {
        d(0);
        f(this, 0, false, 2, null);
    }
}
