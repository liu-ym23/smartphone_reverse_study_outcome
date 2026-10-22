package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.Q;
import Y8.t;
import android.util.Log;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import s.J;
import t.C5473b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/Q;", "LY8/t;", "<anonymous>", "()LUa/Q;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$updateRepeatingRequestAsync$1$1", f = "UseCaseCameraRequestControl.kt", l = {428}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl$updateRepeatingRequestAsync$1$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Q<? extends t>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9969a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Collection<UseCase> f9970b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f9971c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControlImpl f9972d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UseCaseCameraRequestControlImpl$updateRepeatingRequestAsync$1$1(Collection<? extends UseCase> collection, boolean z10, UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, InterfaceC4014c<? super UseCaseCameraRequestControlImpl$updateRepeatingRequestAsync$1$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f9970b = collection;
        this.f9971c = z10;
        this.f9972d = useCaseCameraRequestControlImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraRequestControlImpl$updateRepeatingRequestAsync$1$1(this.f9970b, this.f9971c, this.f9972d, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<? super Q<t>> interfaceC4014c) {
        return ((UseCaseCameraRequestControlImpl$updateRepeatingRequestAsync$1$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9969a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraRequestControlImpl: Building SessionConfig...");
        }
        SessionConfig sessionConfigN = new SessionConfigAdapter(this.f9970b, this.f9971c).n();
        if (sessionConfigN == null) {
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "Using default SessionConfig");
            }
            SessionConfig.b bVar = new SessionConfig.b();
            bVar.x(1);
            sessionConfigN = bVar.o();
            p.h(sessionConfigN, "build(...)");
        }
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraRequestControlImpl: SessionConfig built. Updating state...");
        }
        this.f9972d.infoBundleMap.put(UseCaseCameraRequestControl.Type.SESSION_CONFIG, UseCaseCameraRequestControlImpl.INSTANCE.h(sessionConfigN, this.f9972d.threads.getSequentialExecutor()));
        J j10 = this.f9972d.useCaseGraphContext;
        List<DeferrableSurface> listH = sessionConfigN.l().h();
        p.h(listH, "getSurfaces(...)");
        Set<w.Q> setG = j10.g(listH);
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraRequestControlImpl: State update processing.");
        }
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.f9972d;
        UseCaseCameraRequestControlImpl.InfoBundle infoBundleI = useCaseCameraRequestControlImpl.I(useCaseCameraRequestControlImpl.infoBundleMap);
        this.f9969a = 1;
        Object objN = useCaseCameraRequestControlImpl.N(infoBundleI, setG, this);
        return objN == objG ? objG : objN;
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super Q<? extends t>> interfaceC4014c) {
        return invoke2((InterfaceC4014c<? super Q<t>>) interfaceC4014c);
    }
}
