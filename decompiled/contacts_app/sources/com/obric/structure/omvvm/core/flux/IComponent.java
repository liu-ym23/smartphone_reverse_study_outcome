package com.obric.structure.omvvm.core.flux;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IComponent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/IComponent;", "Lcom/obric/structure/omvvm/core/flux/FluxLifecycleObserver;", "getFluxContext", "Lcom/obric/structure/omvvm/core/flux/IComponentContext;", "initializeContext", "", "context", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IComponent extends FluxLifecycleObserver {

    /* JADX INFO: compiled from: IComponent.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static IComponentContext getFluxContext(IComponent r0) {
            return null;
        }

        public static void initializeContext(IComponent r0, IComponentContext r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
        }

        public static void onLifecycleEvent(IComponent r1, FluxComponentLifecycle.Event r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            FluxLifecycleObserver.DefaultImpls.onLifecycleEvent(r1, r2);
        }
    }

    IComponentContext getFluxContext();

    void initializeContext(IComponentContext r1);
}
