package com.obric.structure.omvvm.core.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.ui.QUIManager;
import com.obric.structure.omvvm.core.util.Query;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QFragmentPresenter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\bJ\u0012\u0010#\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\b\u0010$\u001a\u00020\u001cH\u0016J\u0006\u0010%\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/obric/structure/omvvm/core/presenter/QFragmentPresenter;", "Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "hasBind", "", "qContext", "Lcom/obric/structure/omvvm/core/presenter/QContext;", "getQContext", "()Lcom/obric/structure/omvvm/core/presenter/QContext;", "setQContext", "(Lcom/obric/structure/omvvm/core/presenter/QContext;)V", "query", "Lcom/obric/structure/omvvm/core/util/Query;", "getQuery", "()Lcom/obric/structure/omvvm/core/util/Query;", "setQuery", "(Lcom/obric/structure/omvvm/core/util/Query;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "bind", "", "model", "Lcom/obric/structure/omvvm/core/model/QModel;", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "isQueryInitialized", "isViewInitialized", "onBind", "onUnBind", "unbind", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class QFragmentPresenter implements QIPresenter {
    private final Fragment fragment;
    private boolean hasBind;
    protected QContext qContext;
    protected Query query;
    protected View view;

    public abstract void onBind(QModel r1);

    public void onUnBind() {
    }

    public QFragmentPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.fragment = r2;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    protected final QContext getQContext() {
        QContext r0 = this.qContext;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("qContext");
        return null;
    }

    protected final void setQContext(QContext r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.qContext = r2;
    }

    protected final Query getQuery() {
        Query r0 = this.query;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("query");
        return null;
    }

    protected final void setQuery(Query r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.query = r2;
    }

    protected final View getView() {
        View r0 = this.view;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    }

    protected final void setView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.view = r2;
    }

    public final boolean isQueryInitialized() {
        if (this.query == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isViewInitialized() {
        if (this.view == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final void bind(QModel r3, View r4, QUIManager r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        setView(r4);
        setQContext(new QContext(r4));
        getQContext().setFragment(this.fragment);
        if (r5 == null) goto L5;
        getQContext().setUiManager(r5);
    L5:
        setQuery(new Query(r4));
        onBind(r3);
        this.hasBind = true;
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final void unbind() {
        if (this.hasBind == false) goto L6;
        onUnBind();
        this.hasBind = false;
        return;
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final boolean hasBind() {
        return this.hasBind;
    }
}
