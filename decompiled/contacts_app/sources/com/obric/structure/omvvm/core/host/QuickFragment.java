package com.obric.structure.omvvm.core.host;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.presenter.QIPresenter;
import com.obric.structure.omvvm.core.ui.QUIManager;
import com.obric.structure.omvvm.core.ui.QUIModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuickFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058eX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/structure/omvvm/core/host/QuickFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/obric/structure/omvvm/core/host/QUIModuleHost;", "()V", "layoutId", "", "getLayoutId", "()I", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "buildQModel", "Lcom/obric/structure/omvvm/core/model/QModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class QuickFragment extends Fragment implements QUIModuleHost {
    private final QUIManager uiManager;

    protected QModel buildQModel() {
        return null;
    }

    protected abstract int getLayoutId();

    public QuickFragment() {
        this.uiManager = new QUIManager();
    }

    @Override // com.obric.structure.omvvm.core.host.QUIModuleHost
    public boolean getSync() {
        return QUIModuleHost.DefaultImpls.getSync(this);
    }

    @Override // com.obric.structure.omvvm.core.host.QUIModuleHost
    public QIPresenter presenter() {
        return QUIModuleHost.DefaultImpls.presenter(this);
    }

    @Override // com.obric.structure.omvvm.core.host.QUIModuleHost
    public List<QUIModule> subModules() {
        return QUIModuleHost.DefaultImpls.subModules(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(getLayoutId(), r4, false);
        QUIManager r7 = this.uiManager;
        Intrinsics.checkNotNullExpressionValue(r6, "root");
        RootUIModule r8 = new RootUIModule(r6, this);
        Context r0 = requireContext();
        Intrinsics.checkNotNullExpressionValue(r0, "requireContext()");
        r7.init(r8, r0, this, getSync());
        return r6;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.uiManager.bind(RootUIModule.class, buildQModel());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.uiManager.unbind(RootUIModule.class);
        super.onDestroyView();
    }
}
