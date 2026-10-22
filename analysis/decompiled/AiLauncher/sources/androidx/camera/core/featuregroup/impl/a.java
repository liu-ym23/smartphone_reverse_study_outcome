package androidx.camera.core.featuregroup.impl;

import D.B;
import O.f;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.z;
import com.autonavi.aps.amapapi.config.Const;
import g3.InterfaceFutureC4095a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/core/featuregroup/impl/a;", "", "Landroidx/camera/core/impl/SessionConfig;", "sessionConfig", "", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/SessionConfig;)Z", Const.INTENT_KEY_PKGNAME, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f11305a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f11304b = new C0147a();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/camera/core/featuregroup/impl/a$a", "Landroidx/camera/core/featuregroup/impl/a;", "Landroidx/camera/core/impl/SessionConfig;", "sessionConfig", "", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/SessionConfig;)Z", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.core.featuregroup.impl.a$a, reason: collision with other inner class name */
    public static final class C0147a implements a {
        @Override // androidx.camera.core.featuregroup.impl.a
        public boolean a(SessionConfig sessionConfig) {
            p.i(sessionConfig, "sessionConfig");
            return false;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0001¨\u0006\u000f"}, d2 = {"Landroidx/camera/core/featuregroup/impl/a$b;", "", "<init>", "()V", "Landroidx/camera/core/impl/z;", "Landroid/util/Size;", "resolution", "LD/B;", "dynamicRange", "Landroidx/camera/core/impl/SessionConfig$b;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/z;Landroid/util/Size;LD/B;)Landroidx/camera/core/impl/SessionConfig$b;", "Landroidx/camera/core/featuregroup/impl/a;", "NO_OP_FEATURE_COMBINATION_QUERY", "Landroidx/camera/core/featuregroup/impl/a;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.core.featuregroup.impl.a$b, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f11305a = new Companion();

        @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/camera/core/featuregroup/impl/a$b$a", "Landroidx/camera/core/impl/DeferrableSurface;", "Lg3/a;", "Landroid/view/Surface;", "o", "()Lg3/a;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.core.featuregroup.impl.a$b$a, reason: collision with other inner class name */
        public static final class C0148a extends DeferrableSurface {
            public C0148a(Size size, int i10) {
                super(size, i10);
            }

            @Override // androidx.camera.core.impl.DeferrableSurface
            public InterfaceFutureC4095a<Surface> o() {
                InterfaceFutureC4095a<Surface> interfaceFutureC4095aH = f.h(null);
                p.h(interfaceFutureC4095aH, "immediateFuture(...)");
                return interfaceFutureC4095aH;
            }
        }

        public final SessionConfig.b a(z<?> zVar, Size resolution, B dynamicRange) {
            p.i(zVar, "<this>");
            p.i(resolution, "resolution");
            p.i(dynamicRange, "dynamicRange");
            C0148a c0148a = new C0148a(resolution, zVar.o());
            Class<?> surfaceClass = UseCaseType.INSTANCE.c(zVar).getSurfaceClass();
            if (surfaceClass != null) {
                c0148a.p(surfaceClass);
            }
            SessionConfig.b bVarM = SessionConfig.b.p(zVar, resolution).m(c0148a, dynamicRange);
            p.h(bVarM, "addSurface(...)");
            return bVarM;
        }
    }

    boolean a(SessionConfig sessionConfig);
}
