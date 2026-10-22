package s;

import D.C0761b0;
import K.z0;
import android.util.Log;
import android.util.Pair;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.impl.c;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.core.impl.SessionConfig;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import o.C4961A;
import o.C4981m;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import s.UseCaseCameraConfig;
import t.C5473b;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001&BC\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 JV\u0010!\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010*R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0011\u00100\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b-\u0010/¨\u00061"}, d2 = {"Ls/z;", "", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraphFactory", "Lo/A;", "graphStateToCameraStateAdapter", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "sessionConfigAdapter", "LK/z0;", "sessionProcessor", "LY8/h;", "Landroidx/camera/camera2/impl/c$a;", "lazyCreationResult", "<init>", "(Lp9/l;Lo/A;Landroidx/camera/camera2/adapter/SessionConfigAdapter;LK/z0;LY8/h;)V", "f", "()Landroidx/camera/camera2/adapter/SessionConfigAdapter;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()LK/z0;", "Lo/m;", "cameraStateAdapter", "Ls/J;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lo/m;)Ls/J;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "c", "(Lp9/l;Lo/A;Landroidx/camera/camera2/adapter/SessionConfigAdapter;LK/z0;LY8/h;)Ls/z;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lp9/l;", Const.INTENT_KEY_PKGNAME, "Lo/A;", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", Const.INTENT_KEY_UMID, "LK/z0;", "e", "LY8/h;", "()Landroidx/camera/camera2/pipe/CameraGraph$b;", "cameraGraphConfig", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: s.z, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class UseCaseCameraConfig {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final InterfaceC5074l<CameraGraph.b, CameraGraph> cameraGraphFactory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final C4961A graphStateToCameraStateAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final SessionConfigAdapter sessionConfigAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final z0 sessionProcessor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final Y8.h<c.CameraGraphCreationResult> lazyCreationResult;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ls/z$a;", "", "<init>", "()V", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "sessionConfigAdapter", "Landroidx/camera/camera2/impl/c;", "cameraGraphConfigProvider", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraphFactory", "Lo/A;", "graphStateToCameraStateAdapter", "LK/z0;", "sessionProcessor", "", "isExtensions", "Ls/z;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/adapter/SessionConfigAdapter;Landroidx/camera/camera2/impl/c;Lp9/l;Lo/A;LK/z0;Z)Ls/z;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: s.z$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final c.CameraGraphCreationResult c(SessionConfigAdapter sessionConfigAdapter, boolean z10, z0 z0Var, androidx.camera.camera2.impl.c cVar, C4961A c4961a) {
            Pair<Integer, Integer> pairF;
            SessionConfig sessionConfigN = sessionConfigAdapter.n();
            int iB = z10 ? CameraGraph.e.INSTANCE.b() : sessionConfigN == null ? CameraGraph.e.INSTANCE.d() : sessionConfigN.n() == 1 ? CameraGraph.e.INSTANCE.c() : sessionConfigN.n() == 0 ? CameraGraph.e.INSTANCE.d() : CameraGraph.e.INSTANCE.a(sessionConfigN.n());
            Integer num = null;
            if (z10 && z0Var != null && (pairF = z0Var.f()) != null) {
                num = (Integer) pairF.second;
            }
            return cVar.a(iB, sessionConfigN, false, c4961a, num, sessionConfigAdapter.j(), sessionConfigAdapter.l());
        }

        public final UseCaseCameraConfig b(final SessionConfigAdapter sessionConfigAdapter, final androidx.camera.camera2.impl.c cameraGraphConfigProvider, InterfaceC5074l<? super CameraGraph.b, ? extends CameraGraph> cameraGraphFactory, final C4961A graphStateToCameraStateAdapter, final z0 sessionProcessor, final boolean isExtensions) {
            kotlin.jvm.internal.p.i(sessionConfigAdapter, "sessionConfigAdapter");
            kotlin.jvm.internal.p.i(cameraGraphConfigProvider, "cameraGraphConfigProvider");
            kotlin.jvm.internal.p.i(cameraGraphFactory, "cameraGraphFactory");
            kotlin.jvm.internal.p.i(graphStateToCameraStateAdapter, "graphStateToCameraStateAdapter");
            return new UseCaseCameraConfig(cameraGraphFactory, graphStateToCameraStateAdapter, sessionConfigAdapter, sessionProcessor, C4848b.b(new InterfaceC5063a() { // from class: s.y
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return UseCaseCameraConfig.Companion.c(sessionConfigAdapter, isExtensions, sessionProcessor, cameraGraphConfigProvider, graphStateToCameraStateAdapter);
                }
            }));
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UseCaseCameraConfig(InterfaceC5074l<? super CameraGraph.b, ? extends CameraGraph> cameraGraphFactory, C4961A graphStateToCameraStateAdapter, SessionConfigAdapter sessionConfigAdapter, z0 z0Var, Y8.h<c.CameraGraphCreationResult> lazyCreationResult) {
        kotlin.jvm.internal.p.i(cameraGraphFactory, "cameraGraphFactory");
        kotlin.jvm.internal.p.i(graphStateToCameraStateAdapter, "graphStateToCameraStateAdapter");
        kotlin.jvm.internal.p.i(sessionConfigAdapter, "sessionConfigAdapter");
        kotlin.jvm.internal.p.i(lazyCreationResult, "lazyCreationResult");
        this.cameraGraphFactory = cameraGraphFactory;
        this.graphStateToCameraStateAdapter = graphStateToCameraStateAdapter;
        this.sessionConfigAdapter = sessionConfigAdapter;
        this.sessionProcessor = z0Var;
        this.lazyCreationResult = lazyCreationResult;
    }

    public static /* synthetic */ UseCaseCameraConfig d(UseCaseCameraConfig useCaseCameraConfig, InterfaceC5074l interfaceC5074l, C4961A c4961a, SessionConfigAdapter sessionConfigAdapter, z0 z0Var, Y8.h hVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = useCaseCameraConfig.cameraGraphFactory;
        }
        if ((i10 & 2) != 0) {
            c4961a = useCaseCameraConfig.graphStateToCameraStateAdapter;
        }
        if ((i10 & 4) != 0) {
            sessionConfigAdapter = useCaseCameraConfig.sessionConfigAdapter;
        }
        if ((i10 & 8) != 0) {
            z0Var = useCaseCameraConfig.sessionProcessor;
        }
        if ((i10 & 16) != 0) {
            hVar = useCaseCameraConfig.lazyCreationResult;
        }
        Y8.h hVar2 = hVar;
        SessionConfigAdapter sessionConfigAdapter2 = sessionConfigAdapter;
        return useCaseCameraConfig.c(interfaceC5074l, c4961a, sessionConfigAdapter2, z0Var, hVar2);
    }

    public static final CameraGraph i(UseCaseCameraConfig useCaseCameraConfig) {
        return useCaseCameraConfig.cameraGraphFactory.invoke(useCaseCameraConfig.e());
    }

    public static final Map j(UseCaseCameraConfig useCaseCameraConfig) {
        return useCaseCameraConfig.lazyCreationResult.getValue().b();
    }

    public final UseCaseCameraConfig c(InterfaceC5074l<? super CameraGraph.b, ? extends CameraGraph> cameraGraphFactory, C4961A graphStateToCameraStateAdapter, SessionConfigAdapter sessionConfigAdapter, z0 sessionProcessor, Y8.h<c.CameraGraphCreationResult> lazyCreationResult) {
        kotlin.jvm.internal.p.i(cameraGraphFactory, "cameraGraphFactory");
        kotlin.jvm.internal.p.i(graphStateToCameraStateAdapter, "graphStateToCameraStateAdapter");
        kotlin.jvm.internal.p.i(sessionConfigAdapter, "sessionConfigAdapter");
        kotlin.jvm.internal.p.i(lazyCreationResult, "lazyCreationResult");
        return new UseCaseCameraConfig(cameraGraphFactory, graphStateToCameraStateAdapter, sessionConfigAdapter, sessionProcessor, lazyCreationResult);
    }

    public final CameraGraph.b e() {
        return this.lazyCreationResult.getValue().getConfig();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.p.d(UseCaseCameraConfig.class, other != null ? other.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.p.g(other, "null cannot be cast to non-null type androidx.camera.camera2.config.UseCaseCameraConfig");
        UseCaseCameraConfig useCaseCameraConfig = (UseCaseCameraConfig) other;
        return kotlin.jvm.internal.p.d(this.sessionConfigAdapter, useCaseCameraConfig.sessionConfigAdapter) && kotlin.jvm.internal.p.d(this.graphStateToCameraStateAdapter, useCaseCameraConfig.graphStateToCameraStateAdapter) && kotlin.jvm.internal.p.d(this.sessionProcessor, useCaseCameraConfig.sessionProcessor);
    }

    /* renamed from: f, reason: from getter */
    public final SessionConfigAdapter getSessionConfigAdapter() {
        return this.sessionConfigAdapter;
    }

    /* renamed from: g, reason: from getter */
    public final z0 getSessionProcessor() {
        return this.sessionProcessor;
    }

    public final J h(C4981m cameraStateAdapter) {
        kotlin.jvm.internal.p.i(cameraStateAdapter, "cameraStateAdapter");
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Prepared UseCaseGraphContext (Deferred)");
        }
        return new J(new X8.a() { // from class: s.w
            @Override // X8.a
            public final Object get() {
                return UseCaseCameraConfig.i(this.f39987a);
            }
        }, cameraStateAdapter, this.graphStateToCameraStateAdapter, new X8.a() { // from class: s.x
            @Override // X8.a
            public final Object get() {
                return UseCaseCameraConfig.j(this.f39988a);
            }
        }, null, 16, null);
    }

    public int hashCode() {
        int iHashCode = ((this.sessionConfigAdapter.hashCode() * 31) + this.graphStateToCameraStateAdapter.hashCode()) * 31;
        z0 z0Var = this.sessionProcessor;
        return iHashCode + (z0Var != null ? z0Var.hashCode() : 0);
    }

    public String toString() {
        return "UseCaseCameraConfig(cameraGraphFactory=" + this.cameraGraphFactory + ", graphStateToCameraStateAdapter=" + this.graphStateToCameraStateAdapter + ", sessionConfigAdapter=" + this.sessionConfigAdapter + ", sessionProcessor=" + this.sessionProcessor + ", lazyCreationResult=" + this.lazyCreationResult + ')';
    }
}
