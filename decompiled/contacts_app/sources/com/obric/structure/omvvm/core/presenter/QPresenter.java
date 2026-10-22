package com.obric.structure.omvvm.core.presenter;

import android.view.View;
import com.obric.structure.omvvm.core.flux.FluxComponentLifecycle;
import com.obric.structure.omvvm.core.flux.IComponent;
import com.obric.structure.omvvm.core.flux.IComponentContext;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.ui.QUIManager;
import com.obric.structure.omvvm.core.util.QBindState;
import com.obric.structure.omvvm.core.util.QIPresenterKt;
import com.obric.structure.omvvm.core.util.QUtils;
import com.obric.structure.omvvm.core.util.Query;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QPresenter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010$J\n\u0010%\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0005H\u0016J\u0012\u0010(\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H&J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0017J\b\u0010,\u001a\u00020 H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0006\u0010-\u001a\u00020 R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/obric/structure/omvvm/core/presenter/QPresenter;", "Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "Lcom/obric/structure/omvvm/core/flux/IComponent;", "()V", "<set-?>", "Lcom/obric/structure/omvvm/core/flux/IComponentContext;", "componentContext", "getComponentContext", "()Lcom/obric/structure/omvvm/core/flux/IComponentContext;", "hasBind", "", "isViewInitialized", "()Z", "qContext", "Lcom/obric/structure/omvvm/core/presenter/QContext;", "getQContext", "()Lcom/obric/structure/omvvm/core/presenter/QContext;", "setQContext", "(Lcom/obric/structure/omvvm/core/presenter/QContext;)V", "query", "Lcom/obric/structure/omvvm/core/util/Query;", "getQuery", "()Lcom/obric/structure/omvvm/core/util/Query;", "setQuery", "(Lcom/obric/structure/omvvm/core/util/Query;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "bind", "", "model", "Lcom/obric/structure/omvvm/core/model/QModel;", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "getFluxContext", "initializeContext", "context", "onBind", "onLifecycleEvent", "event", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "onUnBind", "unbind", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class QPresenter implements QIPresenter, IComponent {
    private IComponentContext componentContext;
    private boolean hasBind;
    public QContext qContext;
    protected Query query;
    protected View view;

    /* JADX INFO: renamed from: com.obric.structure.omvvm.core.presenter.QPresenter$onLifecycleEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: QPresenter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<QModel, View, QUIManager, Unit> {
        AnonymousClass1(Object r8) {
            super(3, r8, QPresenter.class, "bind", "bind(Lcom/obric/structure/omvvm/core/model/QModel;Landroid/view/View;Lcom/obric/structure/omvvm/core/ui/QUIManager;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(QModel r1, View r2, QUIManager r3) {
            invoke2(r1, r2, r3);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(QModel r2, View r3, QUIManager r4) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            ((QPresenter) this.receiver).bind(r2, r3, r4);
        }
    }

    /* JADX INFO: renamed from: com.obric.structure.omvvm.core.presenter.QPresenter$onLifecycleEvent$2, reason: invalid class name */
    /* JADX INFO: compiled from: QPresenter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass2(Object r8) {
            super(0, r8, QPresenter.class, "unbind", "unbind()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((QPresenter) this.receiver).unbind();
        }
    }

    public abstract void onBind(QModel r1);

    public void onUnBind() {
    }

    public QPresenter() {
    }

    public final QContext getQContext() {
        QContext r0 = this.qContext;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("qContext");
        return null;
    }

    public final void setQContext(QContext r2) {
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

    protected final boolean isViewInitialized() {
        if (this.view == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final void bind(QModel r4, View r5, QUIManager r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (QIPresenterKt.checkBindState(this, r6, this.componentContext, QBindState.SYNC_BIND) == true) goto L5;
        return;
    L5:
        setView(r5);
        setQContext(new QContext(r5));
        if (r6 == null) goto L12;
        getQContext().setUiManager(r6);
        if (r6.getQContextLifecycleLeakFix() == false) goto L12;
        if (r6.getFragment() == null) goto L12;
        getQContext().setFragment(r6.getFragment());
    L12:
        setQuery(new Query(r5));
        getQuery().setQContext(getQContext());
        onBind(r4);
        this.hasBind = true;
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final void unbind() {
        if (this.hasBind == true) goto L5;
        return;
    L5:
        if (QIPresenterKt.checkBindState(this, uiManager(), this.componentContext, QBindState.SYNC_UNBIND) == true) goto L8;
        this.hasBind = false;
        return;
    L8:
        onUnBind();
        this.hasBind = false;
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final boolean hasBind() {
        return this.hasBind;
    }

    private final QUIManager uiManager() {
        if (this.qContext != null) goto L5;
        return null;
    L5:
        return getQContext().getUiManagerSafely();
    }

    protected final IComponentContext getComponentContext() {
        return this.componentContext;
    }

    @Override // com.obric.structure.omvvm.core.flux.IComponent
    public void initializeContext(IComponentContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.componentContext = r2;
    }

    @Override // com.obric.structure.omvvm.core.flux.IComponent
    public IComponentContext getFluxContext() {
        return this.componentContext;
    }

    @Override // com.obric.structure.omvvm.core.flux.FluxLifecycleObserver
    public void onLifecycleEvent(FluxComponentLifecycle.Event r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        QUtils.INSTANCE.dispatchFluxLifecycleEvent(this, this.componentContext, r8, new AnonymousClass1(this), new AnonymousClass2(this));
    }
}
