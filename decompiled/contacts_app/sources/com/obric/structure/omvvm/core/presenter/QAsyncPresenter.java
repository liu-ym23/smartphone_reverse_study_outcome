package com.obric.structure.omvvm.core.presenter;

import android.view.View;
import com.obric.structure.omvvm.core.flux.FluxComponentLifecycle;
import com.obric.structure.omvvm.core.flux.IComponent;
import com.obric.structure.omvvm.core.flux.IComponentContext;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.ui.QUIManager;
import com.obric.structure.omvvm.core.util.AsyncQuery;
import com.obric.structure.omvvm.core.util.QBindState;
import com.obric.structure.omvvm.core.util.QExecutor;
import com.obric.structure.omvvm.core.util.QIPresenterKt;
import com.obric.structure.omvvm.core.util.QUtils;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QAsyncPresenter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020#H'J\b\u0010+\u001a\u00020)H'J\"\u0010,\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010.J\n\u0010/\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\f\u001a\u00020\rJ\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0007H\u0016J\b\u00102\u001a\u00020\rH\u0004J\b\u00103\u001a\u00020\rH\u0004J\b\u00104\u001a\u00020\rH\u0004J\u0014\u00105\u001a\u0004\u0018\u00010\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u000fH'J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u000208H\u0017J\u0012\u00109\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u00010\u000fH\u0015J\b\u0010:\u001a\u00020)H\u0014J\n\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0006\u0010;\u001a\u00020)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006<"}, d2 = {"Lcom/obric/structure/omvvm/core/presenter/QAsyncPresenter;", "Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "Lcom/obric/structure/omvvm/core/flux/IComponent;", "()V", "bindingTaskId", "", "componentContext", "Lcom/obric/structure/omvvm/core/flux/IComponentContext;", "getComponentContext", "()Lcom/obric/structure/omvvm/core/flux/IComponentContext;", "setComponentContext", "(Lcom/obric/structure/omvvm/core/flux/IComponentContext;)V", "hasBind", "", "originUnsafeModel", "Lcom/obric/structure/omvvm/core/model/QModel;", "getOriginUnsafeModel", "()Lcom/obric/structure/omvvm/core/model/QModel;", "setOriginUnsafeModel", "(Lcom/obric/structure/omvvm/core/model/QModel;)V", "qContext", "Lcom/obric/structure/omvvm/core/presenter/QContext;", "getQContext", "()Lcom/obric/structure/omvvm/core/presenter/QContext;", "setQContext", "(Lcom/obric/structure/omvvm/core/presenter/QContext;)V", "query", "Lcom/obric/structure/omvvm/core/util/AsyncQuery;", "getQuery", "()Lcom/obric/structure/omvvm/core/util/AsyncQuery;", "setQuery", "(Lcom/obric/structure/omvvm/core/util/AsyncQuery;)V", "taskId", "Ljava/util/concurrent/atomic/AtomicLong;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "asyncBind", "", "model", "asyncUnBind", "bind", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "getFluxContext", "initializeContext", "context", "isQContextInitialized", "isQueryInitialized", "isViewInitialized", "modelSnapshot", "onLifecycleEvent", "event", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "syncBind", "syncUnBind", "unbind", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class QAsyncPresenter implements QIPresenter, IComponent {
    private long bindingTaskId;
    private IComponentContext componentContext;
    private boolean hasBind;
    private QModel originUnsafeModel;
    protected QContext qContext;
    protected AsyncQuery query;
    private AtomicLong taskId;
    protected View view;

    /* JADX INFO: renamed from: com.obric.structure.omvvm.core.presenter.QAsyncPresenter$onLifecycleEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: QAsyncPresenter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<QModel, View, QUIManager, Unit> {
        AnonymousClass1(Object r8) {
            super(3, r8, QAsyncPresenter.class, "bind", "bind(Lcom/obric/structure/omvvm/core/model/QModel;Landroid/view/View;Lcom/obric/structure/omvvm/core/ui/QUIManager;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(QModel r1, View r2, QUIManager r3) {
            invoke2(r1, r2, r3);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(QModel r2, View r3, QUIManager r4) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            ((QAsyncPresenter) this.receiver).bind(r2, r3, r4);
        }
    }

    /* JADX INFO: renamed from: com.obric.structure.omvvm.core.presenter.QAsyncPresenter$onLifecycleEvent$2, reason: invalid class name */
    /* JADX INFO: compiled from: QAsyncPresenter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass2(Object r8) {
            super(0, r8, QAsyncPresenter.class, "unbind", "unbind()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((QAsyncPresenter) this.receiver).unbind();
        }
    }

    public static /* synthetic */ void $r8$lambda$aE4Is4cWe6xSCGsaALhCJvJVrGc(QAsyncPresenter r0, QUIManager r1, QModel r2, View r3) {
        bind$lambda$1(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$ckW1--fX6hB_8O4Vkw2oHHVEjy0, reason: not valid java name */
    public static /* synthetic */ void m773$r8$lambda$ckW1fX6hB_8O4Vkw2oHHVEjy0(QAsyncPresenter r0) {
        unbind$lambda$2(r0);
    }

    public abstract void asyncBind(QModel r1, View r2);

    public abstract void asyncUnBind();

    public abstract QModel modelSnapshot(QModel r1);

    protected void syncBind(QModel r1) {
    }

    protected void syncUnBind() {
    }

    public QAsyncPresenter() {
        this.taskId = new AtomicLong(0);
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

    protected final AsyncQuery getQuery() {
        AsyncQuery r0 = this.query;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("query");
        return null;
    }

    protected final void setQuery(AsyncQuery r2) {
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

    protected final QModel getOriginUnsafeModel() {
        return this.originUnsafeModel;
    }

    protected final void setOriginUnsafeModel(QModel r1) {
        this.originUnsafeModel = r1;
    }

    protected final boolean isViewInitialized() {
        if (this.view == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final void bind(QModel r4, final View r5, final QUIManager r6) {
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
        setQuery(new AsyncQuery(r5));
        this.originUnsafeModel = r4;
        final QModel r7 = modelSnapshot(r4);
        syncBind(r7);
        QExecutor.INSTANCE.work().post(new QAsyncPresenter$$ExternalSyntheticLambda0(this, r6, r7, r5));
        this.hasBind = true;
    }

    private static final void bind$lambda$1(QAsyncPresenter r3, QUIManager r4, QModel r5, View r6) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$view");
        if (QIPresenterKt.checkBindState(r3, r4, r3.componentContext, QBindState.ASYNC_BIND) == true) goto L5;
        return;
    L5:
        r3.asyncBind(r5, r6);
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final void unbind() {
        if (this.hasBind == true) goto L5;
        return;
    L5:
        this.hasBind = false;
        if (QIPresenterKt.checkBindState(this, uiManager(), this.componentContext, QBindState.SYNC_UNBIND) == true) goto L8;
        return;
    L8:
        syncUnBind();
        QExecutor.INSTANCE.work().post(new QAsyncPresenter$$ExternalSyntheticLambda1(this));
    }

    private static final void unbind$lambda$2(QAsyncPresenter r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        if (QIPresenterKt.checkBindState(r4, r4.uiManager(), r4.componentContext, QBindState.ASYNC_UNBIND) == true) goto L5;
        return;
    L5:
        r4.asyncUnBind();
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final boolean hasBind() {
        return this.hasBind;
    }

    protected final boolean isQContextInitialized() {
        if (this.qContext == null) goto L5;
        return true;
    L5:
        return false;
    }

    protected final boolean isQueryInitialized() {
        if (this.query == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final QUIManager uiManager() {
        if (isQContextInitialized() == true) goto L5;
        return null;
    L5:
        return getQContext().getUiManagerSafely();
    }

    protected final IComponentContext getComponentContext() {
        return this.componentContext;
    }

    protected final void setComponentContext(IComponentContext r1) {
        this.componentContext = r1;
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
