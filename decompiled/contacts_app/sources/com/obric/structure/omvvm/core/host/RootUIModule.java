package com.obric.structure.omvvm.core.host;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.structure.omvvm.core.presenter.QIPresenter;
import com.obric.structure.omvvm.core.ui.QUIModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootUIModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/structure/omvvm/core/host/RootUIModule;", "Lcom/obric/structure/omvvm/core/ui/QUIModule;", "root", "Landroid/view/View;", "host", "Lcom/obric/structure/omvvm/core/host/QUIModuleHost;", "(Landroid/view/View;Lcom/obric/structure/omvvm/core/host/QUIModuleHost;)V", "onCreateView", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "presenter", "Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "subModules", "", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RootUIModule extends QUIModule {
    private final QUIModuleHost host;
    private final View root;

    public RootUIModule(View r4, QUIModuleHost r5) {
        Intrinsics.checkNotNullParameter(r4, "root");
        Intrinsics.checkNotNullParameter(r5, "host");
        super(0, null, 3, null);
        this.root = r4;
        this.host = r5;
    }

    @Override // com.obric.structure.omvvm.core.ui.QUIModule
    public View onCreateView(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.root;
    }

    @Override // com.obric.structure.omvvm.core.ui.QUIModule
    public QIPresenter presenter() {
        return this.host.presenter();
    }

    @Override // com.obric.structure.omvvm.core.ui.QUIModule
    public List<QUIModule> subModules() {
        return this.host.subModules();
    }
}
