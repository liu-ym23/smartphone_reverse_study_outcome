package a0;

import D.InterfaceC0771h;
import a0.n;
import android.content.Context;
import android.view.LifecycleOwner;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import com.autonavi.aps.amapapi.config.Const;
import g3.InterfaceFutureC4095a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m.InterfaceC4887a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\n\u001a\u00020\t2\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"La0/n;", "", "La0/i;", "lifecycleCameraProvider", "<init>", "(La0/i;)V", "", "Landroidx/camera/core/UseCase;", "useCases", "LY8/t;", "e", "([Landroidx/camera/core/UseCase;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/camera/core/CameraSelector;", "cameraSelector", "LD/h;", "c", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;[Landroidx/camera/core/UseCase;)LD/h;", "Landroid/content/Context;", "context", "Lg3/a;", "Ljava/lang/Void;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)Lg3/a;", Const.INTENT_KEY_APIKEY, "La0/i;", Const.INTENT_KEY_PKGNAME, "camera-lifecycle"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final n f7819c = new n(new i());

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final i lifecycleCameraProvider;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"La0/n$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lg3/a;", "La0/n;", "c", "(Landroid/content/Context;)Lg3/a;", "sAppInstance", "La0/n;", "camera-lifecycle"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: a0.n$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final n d(Void r02) {
            return n.f7819c;
        }

        public static final n e(InterfaceC5074l interfaceC5074l, Object obj) {
            return (n) interfaceC5074l.invoke(obj);
        }

        public final InterfaceFutureC4095a<n> c(Context context) {
            p.i(context, "context");
            B0.h.f(context);
            InterfaceFutureC4095a interfaceFutureC4095aD = n.f7819c.d(context);
            final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: a0.l
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return n.Companion.d((Void) obj);
                }
            };
            InterfaceFutureC4095a<n> interfaceFutureC4095aN = O.f.n(interfaceFutureC4095aD, new InterfaceC4887a() { // from class: a0.m
                @Override // m.InterfaceC4887a
                public final Object apply(Object obj) {
                    return n.Companion.e(interfaceC5074l, obj);
                }
            }, N.a.a());
            p.h(interfaceFutureC4095aN, "transform(...)");
            return interfaceFutureC4095aN;
        }

        public Companion() {
        }
    }

    public n(i iVar) {
        this.lifecycleCameraProvider = iVar;
    }

    public final InterfaceC0771h c(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCases) {
        p.i(lifecycleOwner, "lifecycleOwner");
        p.i(cameraSelector, "cameraSelector");
        p.i(useCases, "useCases");
        return this.lifecycleCameraProvider.q(lifecycleOwner, cameraSelector, (UseCase[]) Arrays.copyOf(useCases, useCases.length));
    }

    public final InterfaceFutureC4095a<Void> d(Context context) {
        return this.lifecycleCameraProvider.z(context, null);
    }

    public final void e(UseCase... useCases) {
        p.i(useCases, "useCases");
        this.lifecycleCameraProvider.L((UseCase[]) Arrays.copyOf(useCases, useCases.length));
    }
}
