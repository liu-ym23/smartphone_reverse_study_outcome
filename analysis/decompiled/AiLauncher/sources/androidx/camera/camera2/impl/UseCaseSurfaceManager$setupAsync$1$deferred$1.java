package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.M;
import Y8.t;
import Z8.C1174w;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.core.impl.DeferrableSurface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.TimeoutCancellationException;
import p9.p;
import t.C5473b;
import v9.C5685n;
import w.Q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseSurfaceManager$setupAsync$1$deferred$1", f = "UseCaseSurfaceManager.kt", l = {97}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseSurfaceManager$setupAsync$1$deferred$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10021a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10022b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SessionConfigAdapter f10023c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UseCaseSurfaceManager f10024d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List<DeferrableSurface> f10025e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f10026f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Map<DeferrableSurface, Q> f10027g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ CameraGraph f10028h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UseCaseSurfaceManager$setupAsync$1$deferred$1(SessionConfigAdapter sessionConfigAdapter, UseCaseSurfaceManager useCaseSurfaceManager, List<? extends DeferrableSurface> list, long j10, Map<DeferrableSurface, Q> map, CameraGraph cameraGraph, InterfaceC4014c<? super UseCaseSurfaceManager$setupAsync$1$deferred$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10023c = sessionConfigAdapter;
        this.f10024d = useCaseSurfaceManager;
        this.f10025e = list;
        this.f10026f = j10;
        this.f10027g = map;
        this.f10028h = cameraGraph;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        UseCaseSurfaceManager$setupAsync$1$deferred$1 useCaseSurfaceManager$setupAsync$1$deferred$1 = new UseCaseSurfaceManager$setupAsync$1$deferred$1(this.f10023c, this.f10024d, this.f10025e, this.f10026f, this.f10027g, this.f10028h, interfaceC4014c);
        useCaseSurfaceManager$setupAsync$1$deferred$1.f10022b = obj;
        return useCaseSurfaceManager$setupAsync$1$deferred$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((UseCaseSurfaceManager$setupAsync$1$deferred$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        M m10;
        Object objG = C4063a.g();
        int i10 = this.f10021a;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                M m11 = (M) this.f10022b;
                if (!this.f10023c.p()) {
                    throw new IllegalStateException("Check failed.");
                }
                UseCaseSurfaceManager useCaseSurfaceManager = this.f10024d;
                List<DeferrableSurface> list = this.f10025e;
                long j10 = this.f10026f;
                this.f10022b = m11;
                this.f10021a = 1;
                Object objM = useCaseSurfaceManager.m(list, j10, this);
                if (objM == objG) {
                    return objG;
                }
                m10 = m11;
                obj = objM;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                m10 = (M) this.f10022b;
                C4849c.b(obj);
            }
            List list2 = (List) obj;
            if (!kotlinx.coroutines.d.h(m10) || list2.isEmpty()) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.h("CXCP")) {
                    Log.i(C5473b.TRUNCATED_TAG, "Failed to get Surfaces: isActive=" + kotlinx.coroutines.d.h(m10) + ", surfaces=" + list2);
                }
                return C4109a.a(false);
            }
            if (!this.f10024d.j(list2)) {
                C5473b c5473b2 = C5473b.f41865a;
                if (C0761b0.k("CXCP")) {
                    Log.w(C5473b.TRUNCATED_TAG, "Surface setup failed: Some Surfaces are invalid");
                }
                this.f10023c.q(this.f10025e.get(list2.indexOf(null)));
                return C4109a.a(false);
            }
            Object obj2 = this.f10024d.lock;
            UseCaseSurfaceManager useCaseSurfaceManager2 = this.f10024d;
            List<DeferrableSurface> list3 = this.f10025e;
            synchronized (obj2) {
                try {
                    List<DeferrableSurface> list4 = list3;
                    LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list4, 10)), 16));
                    for (Object obj3 : list4) {
                        Object obj4 = list2.get(list3.indexOf((DeferrableSurface) obj3));
                        if (obj4 == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        linkedHashMap.put((Surface) obj4, obj3);
                    }
                    useCaseSurfaceManager2.configuredSurfaceMap = linkedHashMap;
                    useCaseSurfaceManager2.n();
                    t tVar = t.f7040a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Map<DeferrableSurface, Q> map = this.f10027g;
            List<DeferrableSurface> list5 = this.f10025e;
            CameraGraph cameraGraph = this.f10028h;
            UseCaseSurfaceManager useCaseSurfaceManager3 = this.f10024d;
            for (Map.Entry<DeferrableSurface, Q> entry : map.entrySet()) {
                int value = entry.getValue().getValue();
                Surface surface = (Surface) list2.get(list5.indexOf(entry.getKey()));
                C5473b c5473b3 = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    Log.d(C5473b.TRUNCATED_TAG, "Configured " + surface + " for " + ((Object) Q.f(value)));
                }
                cameraGraph.a0(value, surface);
                useCaseSurfaceManager3.inactiveSurfaceCloser.c(value, entry.getKey(), cameraGraph);
            }
            C5473b c5473b4 = C5473b.f41865a;
            if (C0761b0.h("CXCP")) {
                Log.i(C5473b.TRUNCATED_TAG, "Surface setup complete");
            }
            return C4109a.a(true);
        } catch (DeferrableSurface.SurfaceClosedException e10) {
            C5473b c5473b5 = C5473b.f41865a;
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "Failed to get Surfaces: Surfaces closed", e10);
            }
            SessionConfigAdapter sessionConfigAdapter = this.f10023c;
            DeferrableSurface deferrableSurfaceA = e10.a();
            kotlin.jvm.internal.p.h(deferrableSurfaceA, "getDeferrableSurface(...)");
            sessionConfigAdapter.q(deferrableSurfaceA);
            return C4109a.a(false);
        } catch (TimeoutCancellationException unused) {
            C5473b c5473b6 = C5473b.f41865a;
            long j11 = this.f10026f;
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "Failed to get Surfaces within " + j11 + " ms");
            }
            return C4109a.a(false);
        }
    }
}
