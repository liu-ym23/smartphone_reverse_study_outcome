package A1;

import android.view.Lifecycle;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"LA1/a;", "LA1/m;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlinx/coroutines/g;", "job", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/g;)V", "LY8/t;", "start", "()V", "complete", Const.INTENT_KEY_APIKEY, "Landroidx/lifecycle/LifecycleOwner;", "owner", "onDestroy", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/Lifecycle;", Const.INTENT_KEY_PKGNAME, "Lkotlinx/coroutines/g;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lifecycle lifecycle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final kotlinx.coroutines.g job;

    public a(Lifecycle lifecycle, kotlinx.coroutines.g gVar) {
        this.lifecycle = lifecycle;
        this.job = gVar;
    }

    public void a() {
        kotlinx.coroutines.g.Y0(this.job, null, 1, null);
    }

    @Override // A1.m
    public void complete() {
        this.lifecycle.d(this);
    }

    @Override // android.view.InterfaceC1387e
    public void onDestroy(LifecycleOwner owner) {
        a();
    }

    @Override // A1.m
    public void start() {
        this.lifecycle.a(this);
    }
}
