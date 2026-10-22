package com.obric.structure.omvvm.core.flux;

import android.view.View;
import android.view.ViewGroup;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.ui.QUIManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: IComponentContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/IComponentContext;", "", "qModel", "Lcom/obric/structure/omvvm/core/model/QModel;", "getQModel", "()Lcom/obric/structure/omvvm/core/model/QModel;", "setQModel", "(Lcom/obric/structure/omvvm/core/model/QModel;)V", "quiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "getQuiManager", "()Lcom/obric/structure/omvvm/core/ui/QUIManager;", "setQuiManager", "(Lcom/obric/structure/omvvm/core/ui/QUIManager;)V", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IComponentContext {
    QModel getQModel();

    QUIManager getQuiManager();

    ViewGroup getRootView();

    View getView();

    void setQModel(QModel r1);

    void setQuiManager(QUIManager r1);

    void setRootView(ViewGroup r1);

    void setView(View r1);
}
