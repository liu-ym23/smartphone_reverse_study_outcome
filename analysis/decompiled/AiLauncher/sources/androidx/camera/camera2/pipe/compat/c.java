package androidx.camera.camera2.pipe.compat;

import A.StreamGraph;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.r;
import androidx.camera.camera2.pipe.core.Threads;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import w.InterfaceC5707m;
import w.Q;
import w.S;
import x.C5820i0;
import x.InterfaceC5808c0;
import x.OutputConfigurations;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroidx/camera/camera2/pipe/compat/c;", "Landroidx/camera/camera2/pipe/compat/r;", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "LA/q;", "streamGraph", "Lx/c0;", "camera2MetadataProvider", "Lw/S;", "strictMode", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/CameraGraph$b;LA/q;Lx/c0;Lw/S;)V", "Landroidx/camera/camera2/pipe/compat/p;", "cameraDevice", "", "Lw/Q;", "Landroid/view/Surface;", "surfaces", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "captureSessionState", "Landroidx/camera/camera2/pipe/compat/r$a;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/p;Ljava/util/Map;Landroidx/camera/camera2/pipe/compat/CaptureSessionState;)Landroidx/camera/camera2/pipe/compat/r$a;", "Landroidx/camera/camera2/pipe/core/Threads;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/CameraGraph$b;", "c", "LA/q;", Const.INTENT_KEY_UMID, "Lx/c0;", "e", "Lw/S;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c implements r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CameraGraph.b graphConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final StreamGraph streamGraph;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5808c0 camera2MetadataProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final S strictMode;

    public c(Threads threads, CameraGraph.b graphConfig, StreamGraph streamGraph, InterfaceC5808c0 camera2MetadataProvider, S strictMode) {
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(camera2MetadataProvider, "camera2MetadataProvider");
        kotlin.jvm.internal.p.i(strictMode, "strictMode");
        this.threads = threads;
        this.graphConfig = graphConfig;
        this.streamGraph = streamGraph;
        this.camera2MetadataProvider = camera2MetadataProvider;
        this.strictMode = strictMode;
    }

    @Override // androidx.camera.camera2.pipe.compat.r
    public r.a a(p cameraDevice, Map<Q, ? extends Surface> surfaces, CaptureSessionState captureSessionState) {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        kotlin.jvm.internal.p.i(surfaces, "surfaces");
        kotlin.jvm.internal.p.i(captureSessionState, "captureSessionState");
        if (!CameraGraph.e.f(this.graphConfig.getSessionMode(), CameraGraph.e.INSTANCE.b())) {
            throw new IllegalArgumentException("Unsupported session mode: " + ((Object) CameraGraph.e.h(this.graphConfig.getSessionMode())) + " for Extension CameraGraph");
        }
        Object obj = this.graphConfig.p().get(C5820i0.f43411a.b());
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num == null) {
            throw new IllegalStateException("The CameraPipeKeys.camera2ExtensionMode must be set in the sessionParameters of the CameraGraph.Config when creating an Extension CameraGraph.");
        }
        int iIntValue = num.intValue();
        if (this.graphConfig.k() != null) {
            throw new IllegalStateException("Reprocessing is not supported for Extensions");
        }
        androidx.camera.camera2.pipe.g gVarA = this.camera2MetadataProvider.a(cameraDevice.getCameraId());
        Set<Integer> setG0 = gVarA.g0();
        S s10 = this.strictMode;
        if (!setG0.contains(Integer.valueOf(iIntValue))) {
            String str = cameraDevice + " does not support extension mode " + iIntValue + ". Supported extensions are " + setG0;
            if (s10.getEnabled()) {
                throw new IllegalStateException(str);
            }
            if (z.k.f44508a.d()) {
                Log.w("CXCP", str);
            }
        }
        if (this.graphConfig.getPostviewStream() != null) {
            InterfaceC5707m interfaceC5707mB1 = gVarA.b1(iIntValue);
            S s11 = this.strictMode;
            if (!interfaceC5707mB1.i()) {
                String str2 = cameraDevice + " does not support Postview streams";
                if (s11.getEnabled()) {
                    throw new IllegalStateException(str2);
                }
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", str2);
                }
            }
            if (this.graphConfig.getPostviewStream().b().size() != 1) {
                throw new IllegalStateException("Postview streams can only have one OutputStream.config object");
            }
        }
        OutputConfigurations outputConfigurationsB = s.b(this.graphConfig, this.streamGraph, surfaces);
        if (outputConfigurationsB.a().isEmpty()) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to create OutputConfigurations for " + this.graphConfig);
            }
            captureSessionState.a();
            return r.a.C0137a.f10670a;
        }
        if (!outputConfigurationsB.b().isEmpty()) {
            throw new IllegalStateException("Deferred output is not supported for Extensions");
        }
        if (cameraDevice.T0(new ExtensionSessionConfigData(2, outputConfigurationsB.a(), new z.j(this.threads.i()), captureSessionState, this.graphConfig.getSessionTemplate(), this.graphConfig.p(), Integer.valueOf(iIntValue), new u(captureSessionState), outputConfigurationsB.getPostviewOutput()))) {
            return new r.a.Success(outputConfigurationsB.b(), outputConfigurationsB.c());
        }
        if (z.k.f44508a.d()) {
            Log.w("CXCP", "Failed to create ExtensionCaptureSession from " + cameraDevice + " for " + captureSessionState + '!');
        }
        captureSessionState.a();
        return r.a.C0137a.f10670a;
    }
}
