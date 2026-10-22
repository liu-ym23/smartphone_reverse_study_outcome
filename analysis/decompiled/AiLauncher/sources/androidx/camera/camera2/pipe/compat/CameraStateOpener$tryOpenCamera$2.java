package androidx.camera.camera2.pipe.compat;

import Ua.M;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import x.OpenCameraResult;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lx/v0;", "<anonymous>", "(LUa/M;)Lx/v0;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2", f = "RetryingCameraStateOpener.kt", l = {670}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraStateOpener$tryOpenCamera$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super OpenCameraResult>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f10426a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10427b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10428c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10429d;

    /* renamed from: e, reason: collision with root package name */
    public int f10430e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10431f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ CameraStateOpener f10432g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f10433h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ AndroidCameraState f10434i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStateOpener$tryOpenCamera$2(CameraStateOpener cameraStateOpener, String str, AndroidCameraState androidCameraState, InterfaceC4014c<? super CameraStateOpener$tryOpenCamera$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10432g = cameraStateOpener;
        this.f10433h = str;
        this.f10434i = androidCameraState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        CameraStateOpener$tryOpenCamera$2 cameraStateOpener$tryOpenCamera$2 = new CameraStateOpener$tryOpenCamera$2(this.f10432g, this.f10433h, this.f10434i, interfaceC4014c);
        cameraStateOpener$tryOpenCamera$2.f10431f = obj;
        return cameraStateOpener$tryOpenCamera$2;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super OpenCameraResult> interfaceC4014c) {
        return ((CameraStateOpener$tryOpenCamera$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0097 A[Catch: all -> 0x0027, TRY_ENTER, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x00ff, B:15:0x0097, B:17:0x00aa, B:18:0x00b6, B:20:0x00bc, B:21:0x00c8, B:23:0x00ce, B:24:0x00da, B:26:0x00e0, B:27:0x00ec, B:32:0x0103, B:34:0x010b, B:35:0x011f, B:37:0x0125, B:38:0x0128, B:40:0x012e, B:41:0x0131, B:43:0x0137, B:44:0x013a, B:46:0x0140), top: B:54:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0103 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0022, B:30:0x00ff, B:15:0x0097, B:17:0x00aa, B:18:0x00b6, B:20:0x00bc, B:21:0x00c8, B:23:0x00ce, B:24:0x00da, B:26:0x00e0, B:27:0x00ec, B:32:0x0103, B:34:0x010b, B:35:0x011f, B:37:0x0125, B:38:0x0128, B:40:0x012e, B:41:0x0131, B:43:0x0137, B:44:0x013a, B:46:0x0140), top: B:54:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0152  */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, Ua.Q] */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, Ua.Q] */
    /* JADX WARN: Type inference failed for: r6v6, types: [T, kotlinx.coroutines.g] */
    /* JADX WARN: Type inference failed for: r6v9, types: [T, kotlinx.coroutines.g] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00fc -> B:30:0x00ff). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
