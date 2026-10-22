package A1;

import android.view.InterfaceC1397o;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import coil.util.Lifecycles;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"LA1/s;", "LA1/m;", "Lcoil/c;", "imageLoader", "LA1/g;", "initialRequest", "LC1/d;", "target", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlinx/coroutines/g;", "job", "<init>", "(Lcoil/c;LA1/g;LC1/d;Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/g;)V", "LY8/t;", "c", "()V", "l", "start", Const.INTENT_KEY_APIKEY, "Landroidx/lifecycle/LifecycleOwner;", "owner", "onDestroy", "(Landroidx/lifecycle/LifecycleOwner;)V", "Lcoil/c;", Const.INTENT_KEY_PKGNAME, "LA1/g;", "LC1/d;", Const.INTENT_KEY_UMID, "Landroidx/lifecycle/Lifecycle;", "e", "Lkotlinx/coroutines/g;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class s implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final coil.c imageLoader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final g initialRequest;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C1.d<?> target;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Lifecycle lifecycle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final kotlinx.coroutines.g job;

    public s(coil.c cVar, g gVar, C1.d<?> dVar, Lifecycle lifecycle, kotlinx.coroutines.g gVar2) {
        this.imageLoader = cVar;
        this.initialRequest = gVar;
        this.target = dVar;
        this.lifecycle = lifecycle;
        this.job = gVar2;
    }

    public void a() {
        kotlinx.coroutines.g.Y0(this.job, null, 1, null);
        C1.d<?> dVar = this.target;
        if (dVar instanceof InterfaceC1397o) {
            this.lifecycle.d((InterfaceC1397o) dVar);
        }
        this.lifecycle.d(this);
    }

    public final void c() {
        this.imageLoader.c(this.initialRequest);
    }

    @Override // A1.m
    public void l() {
        if (this.target.getView().isAttachedToWindow()) {
            return;
        }
        F1.j.l(this.target.getView()).c(this);
        throw new CancellationException("'ViewTarget.view' must be attached to a window.");
    }

    @Override // android.view.InterfaceC1387e
    public void onDestroy(LifecycleOwner owner) {
        F1.j.l(this.target.getView()).a();
    }

    @Override // A1.m
    public void start() {
        this.lifecycle.a(this);
        C1.d<?> dVar = this.target;
        if (dVar instanceof InterfaceC1397o) {
            Lifecycles.b(this.lifecycle, (InterfaceC1397o) dVar);
        }
        F1.j.l(this.target.getView()).c(this);
    }
}
