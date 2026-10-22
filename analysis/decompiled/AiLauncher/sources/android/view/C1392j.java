package android.view;

import android.os.Bundle;
import android.view.Lifecycle;
import com.autonavi.aps.amapapi.config.Const;
import g1.e;
import g1.h;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/j;", "", "<init>", "()V", "Lg1/e;", "registry", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "", "key", "Landroid/os/Bundle;", "defaultArgs", "Landroidx/lifecycle/H;", Const.INTENT_KEY_PKGNAME, "(Lg1/e;Landroidx/lifecycle/Lifecycle;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/lifecycle/H;", "Landroidx/lifecycle/Q;", "viewModel", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/Q;Lg1/e;Landroidx/lifecycle/Lifecycle;)V", "c", "(Lg1/e;Landroidx/lifecycle/Lifecycle;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.lifecycle.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1392j {

    /* renamed from: a, reason: collision with root package name */
    public static final C1392j f14275a = new C1392j();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/j$a;", "Lg1/e$a;", "<init>", "()V", "Lg1/h;", "owner", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lg1/h;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.lifecycle.j$a */
    public static final class a implements e.a {
        @Override // g1.e.a
        public void a(h owner) throws NoSuchMethodException, SecurityException {
            p.i(owner, "owner");
            if (!(owner instanceof W)) {
                throw new IllegalStateException(("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: " + owner).toString());
            }
            V viewModelStore = ((W) owner).getViewModelStore();
            e savedStateRegistry = owner.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                Q qB = viewModelStore.b(it.next());
                if (qB != null) {
                    C1392j.a(qB, savedStateRegistry, owner.getLifecycle());
                }
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.d(a.class);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/lifecycle/j$b", "Landroidx/lifecycle/m;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "LY8/t;", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.lifecycle.j$b */
    public static final class b implements InterfaceC1395m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f14276a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f14277b;

        public b(Lifecycle lifecycle, e eVar) {
            this.f14276a = lifecycle;
            this.f14277b = eVar;
        }

        @Override // android.view.InterfaceC1395m
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) throws NoSuchMethodException, SecurityException {
            p.i(source, "source");
            p.i(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f14276a.d(this);
                this.f14277b.d(a.class);
            }
        }
    }

    public static final void a(Q viewModel, e registry, Lifecycle lifecycle) {
        p.i(viewModel, "viewModel");
        p.i(registry, "registry");
        p.i(lifecycle, "lifecycle");
        H h10 = (H) viewModel.c("androidx.lifecycle.savedstate.vm.tag");
        if (h10 == null || h10.getIsAttached()) {
            return;
        }
        h10.e(registry, lifecycle);
        f14275a.c(registry, lifecycle);
    }

    public static final H b(e registry, Lifecycle lifecycle, String key, Bundle defaultArgs) {
        p.i(registry, "registry");
        p.i(lifecycle, "lifecycle");
        p.f(key);
        H h10 = new H(key, F.INSTANCE.a(registry.a(key), defaultArgs));
        h10.e(registry, lifecycle);
        f14275a.c(registry, lifecycle);
        return h10;
    }

    public final void c(e registry, Lifecycle lifecycle) throws NoSuchMethodException, SecurityException {
        Lifecycle.State state = lifecycle.getState();
        if (state == Lifecycle.State.INITIALIZED || state.isAtLeast(Lifecycle.State.STARTED)) {
            registry.d(a.class);
        } else {
            lifecycle.a(new b(lifecycle, registry));
        }
    }
}
