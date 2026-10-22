package x;

import e9.InterfaceC4014c;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H¦@¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lx/G0;", "", "Lw/n;", "cameraId", "Lx/W;", "camera2DeviceCloser", "Lkotlin/Function1;", "LY8/t;", "", "isForegroundObserver", "Lx/v0;", "f", "(Ljava/lang/String;Lx/W;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lx/x;", "e", "(Ljava/lang/String;Lx/W;)Lx/x;", "c", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface G0 {
    static boolean a(Y8.t tVar) {
        kotlin.jvm.internal.p.i(tVar, "<unused var>");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object d(G0 g02, String str, W w10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openCameraWithRetry-aeCOTgg");
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: x.F0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(G0.a((Y8.t) obj2));
                }
            };
        }
        return g02.f(str, w10, interfaceC5074l, interfaceC4014c);
    }

    void c();

    AwaitOpenCameraResult e(String cameraId, W camera2DeviceCloser);

    Object f(String str, W w10, InterfaceC5074l<? super Y8.t, Boolean> interfaceC5074l, InterfaceC4014c<? super OpenCameraResult> interfaceC4014c);
}
