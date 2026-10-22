package androidx.camera.camera2.compat.workaround;

import J.InterfaceC0857l;
import M5.e;
import X8.a;
import Y8.h;
import androidx.camera.camera2.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection;
import androidx.camera.camera2.impl.CapturePipelineImpl;
import androidx.camera.camera2.impl.f;
import androidx.camera.camera2.pipe.g;
import androidx.camera.core.impl.l;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import o.C4984p;
import p9.InterfaceC5063a;
import t.InterfaceC5494v;
import t.InterfaceC5495w;
import t.y0;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0007\u0018\u0000 92\u00020\u0001:\u0001\u001dB/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJT\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00180\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010!\u001a\u00020 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0002¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010%R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010(R\u001b\u0010,\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010$R#\u00101\u001a\n -*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u00100R*\u00108\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00148\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b&\u00107¨\u0006:"}, d2 = {"Landroidx/camera/camera2/compat/workaround/CapturePipelineTorchCorrection;", "Lt/w;", "Lt/v;", "cameraProperties", "LX8/a;", "Landroidx/camera/camera2/impl/CapturePipelineImpl;", "capturePipelineImplProvider", "Lt/y0;", "threads", "Landroidx/camera/camera2/impl/f;", "torchControl", "<init>", "(Lt/v;LX8/a;Lt/y0;Landroidx/camera/camera2/impl/f;)V", "", "Landroidx/camera/core/impl/l;", "configs", "Lw/M;", "requestTemplate", "Landroidx/camera/core/impl/Config;", "sessionConfigOptions", "", "captureMode", "flashType", "flashMode", "LUa/Q;", "Ljava/lang/Void;", "c", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;IIILe9/c;)Ljava/lang/Object;", "LJ/l;", Const.INTENT_KEY_APIKEY, "(IIILe9/c;)Ljava/lang/Object;", "captureConfigs", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/List;I)Z", "m", "()Z", "LX8/a;", Const.INTENT_KEY_PKGNAME, "Lt/y0;", "Landroidx/camera/camera2/impl/f;", Const.INTENT_KEY_UMID, "LY8/h;", "k", "isLegacyDevice", "kotlin.jvm.PlatformType", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Landroidx/camera/camera2/impl/CapturePipelineImpl;", "capturePipelineImpl", UxipConstants.f30680s, "f", "I", "getTemplate", "()I", "(I)V", e.FAIL_TEMPLATE, Const.INTENT_KEY_BACKGROUND_COMMAND, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineTorchCorrection implements InterfaceC5495w {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f9508h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final a<CapturePipelineImpl> capturePipelineImplProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final f torchControl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final h isLegacyDevice;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final h capturePipelineImpl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int template;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/compat/workaround/CapturePipelineTorchCorrection$a;", "", "<init>", "()V", "", "isEnabled", "Z", Const.INTENT_KEY_APIKEY, "()Z", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a() {
            return CapturePipelineTorchCorrection.f9508h;
        }

        public Companion() {
        }
    }

    static {
        f9508h = q.f.f38470a.c(TorchIsClosedAfterImageCapturingQuirk.class) != null;
    }

    public CapturePipelineTorchCorrection(final InterfaceC5494v cameraProperties, a<CapturePipelineImpl> capturePipelineImplProvider, y0 threads, f torchControl) {
        p.i(cameraProperties, "cameraProperties");
        p.i(capturePipelineImplProvider, "capturePipelineImplProvider");
        p.i(threads, "threads");
        p.i(torchControl, "torchControl");
        this.capturePipelineImplProvider = capturePipelineImplProvider;
        this.threads = threads;
        this.torchControl = torchControl;
        this.isLegacyDevice = C4848b.b(new InterfaceC5063a() { // from class: r.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(CapturePipelineTorchCorrection.l(cameraProperties));
            }
        });
        this.capturePipelineImpl = C4848b.b(new InterfaceC5063a() { // from class: r.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CapturePipelineTorchCorrection.h(this.f38700a);
            }
        });
        this.template = 1;
    }

    public static final CapturePipelineImpl h(CapturePipelineTorchCorrection capturePipelineTorchCorrection) {
        return capturePipelineTorchCorrection.capturePipelineImplProvider.get();
    }

    public static final boolean l(InterfaceC5494v interfaceC5494v) {
        return g.INSTANCE.l(interfaceC5494v.getMetadata());
    }

    @Override // t.InterfaceC5495w
    public Object a(int i10, int i11, int i12, InterfaceC4014c<? super InterfaceC0857l> interfaceC4014c) {
        return i().a(i10, i11, i12, interfaceC4014c);
    }

    @Override // t.InterfaceC5495w
    public void b(int i10) {
        i().b(i10);
        this.template = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // t.InterfaceC5495w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.util.List<androidx.camera.core.impl.l> r12, int r13, androidx.camera.core.impl.Config r14, int r15, int r16, int r17, e9.InterfaceC4014c<? super java.util.List<? extends Ua.Q<java.lang.Void>>> r18) throws java.lang.Throwable {
        /*
            r11 = this;
            r0 = r18
            boolean r1 = r0 instanceof androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$1 r1 = (androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$1) r1
            int r2 = r1.f9518d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.f9518d = r2
        L14:
            r9 = r1
            goto L1c
        L16:
            androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$1 r1 = new androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$1
            r1.<init>(r11, r0)
            goto L14
        L1c:
            java.lang.Object r0 = r9.f9516b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r9.f9518d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            boolean r12 = r9.f9515a
            kotlin.C4849c.b(r0)
            goto L58
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            kotlin.C4849c.b(r0)
            boolean r0 = r11.j(r12, r13)
            androidx.camera.camera2.impl.CapturePipelineImpl r2 = r11.i()
            r9.f9515a = r0
            r9.f9518d = r3
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            java.lang.Object r12 = r2.c(r3, r4, r5, r6, r7, r8, r9)
            if (r12 != r1) goto L55
            return r1
        L55:
            r10 = r0
            r0 = r12
            r12 = r10
        L58:
            java.util.List r0 = (java.util.List) r0
            if (r12 == 0) goto L76
            t.y0 r12 = r11.threads
            Ua.M r13 = r12.getSequentialScope()
            androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$2 r12 = new androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$2
            r14 = 0
            r12.<init>(r0, r11, r14)
            r11 = 3
            r15 = 0
            r1 = 0
            r17 = r11
            r16 = r12
            r18 = r14
            r14 = r15
            r15 = r1
            Ua.C1056g.d(r13, r14, r15, r16, r17, r18)
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection.c(java.util.List, int, androidx.camera.core.impl.Config, int, int, int, e9.c):java.lang.Object");
    }

    public final CapturePipelineImpl i() {
        return (CapturePipelineImpl) this.capturePipelineImpl.getValue();
    }

    public final boolean j(List<l> captureConfigs, int requestTemplate) {
        List<l> list = captureConfigs;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (C4984p.INSTANCE.a((l) it.next(), requestTemplate, k()) == 2) {
                return m();
            }
        }
        return false;
    }

    public final boolean k() {
        return ((Boolean) this.isLegacyDevice.getValue()).booleanValue();
    }

    public final boolean m() {
        Integer numE = this.torchControl.g().e();
        return numE != null && numE.intValue() == 1;
    }
}
