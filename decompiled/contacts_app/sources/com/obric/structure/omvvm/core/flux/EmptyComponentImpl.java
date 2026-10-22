package com.obric.structure.omvvm.core.flux;

import kotlin.Metadata;

/* JADX INFO: compiled from: IComponent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/EmptyComponentImpl;", "Lcom/obric/structure/omvvm/core/flux/IComponent;", "()V", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EmptyComponentImpl implements IComponent {
    public static final EmptyComponentImpl INSTANCE = null;

    static {
        INSTANCE = new EmptyComponentImpl();
    }

    private EmptyComponentImpl() {
    }

    @Override // com.obric.structure.omvvm.core.flux.IComponent
    public IComponentContext getFluxContext() {
        return IComponent.DefaultImpls.getFluxContext(this);
    }

    @Override // com.obric.structure.omvvm.core.flux.IComponent
    public void initializeContext(IComponentContext r1) {
        IComponent.DefaultImpls.initializeContext(this, r1);
    }

    @Override // com.obric.structure.omvvm.core.flux.FluxLifecycleObserver
    public void onLifecycleEvent(FluxComponentLifecycle.Event r1) {
        IComponent.DefaultImpls.onLifecycleEvent(this, r1);
    }
}
