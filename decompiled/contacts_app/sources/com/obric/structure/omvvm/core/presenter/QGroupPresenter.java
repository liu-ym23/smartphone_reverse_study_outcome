package com.obric.structure.omvvm.core.presenter;

import android.view.View;
import com.obric.contactsdk.loader.ContractKt;
import com.obric.structure.omvvm.core.flux.FluxComponentLifecycle;
import com.obric.structure.omvvm.core.flux.IComponent;
import com.obric.structure.omvvm.core.flux.IComponentContext;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.performance.QVsyncFrameCaller;
import com.obric.structure.omvvm.core.ui.QUIManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QGroupPresenter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0001J\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0001J\u0018\u0010\u0013\u001a\u00020\u00002\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0014J$\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\b2\u000e\b\u0004\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0086\bø\u0001\u0000J\"\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\n\u0010!\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0006H\u0016J\u001c\u0010$\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0016J*\u0010)\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010*\u001a\u00020\bJ\u0006\u0010+\u001a\u00020\u001aR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00010\nj\b\u0012\u0004\u0012\u00020\u0001`\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\nj\b\u0012\u0004\u0012\u00020\u000f`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006,"}, d2 = {"Lcom/obric/structure/omvvm/core/presenter/QGroupPresenter;", "Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "Lcom/obric/structure/omvvm/core/flux/IComponent;", "Lcom/obric/structure/omvvm/core/presenter/QIMust;", "()V", "componentContext", "Lcom/obric/structure/omvvm/core/flux/IComponentContext;", "hasBind", "", "presenters", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPresenters", "()Ljava/util/ArrayList;", "viewIds", "", "add", "presenter", "viewId", "addAll", "", "addIf", "condition", ContractKt.OBRIC_ACTION_CREATE, "Lkotlin/Function0;", "bind", "", "model", "Lcom/obric/structure/omvvm/core/model/QModel;", "view", "Landroid/view/View;", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "getFluxContext", "initializeContext", "context", "mustBind", "mustUnbind", "onLifecycleEvent", "event", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "scatterBind", "isPostScatter", "unbind", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class QGroupPresenter implements QIPresenter, IComponent, QIMust {
    private IComponentContext componentContext;
    private boolean hasBind;
    private final ArrayList<QIPresenter> presenters;
    private final ArrayList<Integer> viewIds;

    public QGroupPresenter() {
        this.presenters = new ArrayList();
        this.viewIds = new ArrayList();
    }

    public static final /* synthetic */ ArrayList access$getViewIds$p(QGroupPresenter r0) {
        return r0.viewIds;
    }

    public static final /* synthetic */ void access$setHasBind$p(QGroupPresenter r0, boolean r1) {
        r0.hasBind = r1;
    }

    protected final ArrayList<QIPresenter> getPresenters() {
        return this.presenters;
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final void bind(QModel r6, View r7, QUIManager r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        int r0 = this.presenters.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        Integer r2 = this.viewIds.get(r1);
        if (r2 != null) goto L8;
    L10:
        QIPresenter r3 = this.presenters.get(r1);
        Integer r4 = this.viewIds.get(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "viewIds[i]");
        View r5 = r7.findViewById(r4.intValue());
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.View");
        r3.bind(r6, r5, r8);
    L11:
        r1 = r1 + 1;
        goto L3
    L8:
        if (r2.intValue() != 0) goto L10;
        this.presenters.get(r1).bind(r6, r7, r8);
        goto L11
    L12:
        this.hasBind = true;
    }

    public final void scatterBind(final QModel r11, final View r12, final QUIManager r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "view");
        int r0 = this.presenters.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        Integer r2 = this.viewIds.get(r1);
        if (r2 != null) goto L8;
    L10:
        final int r4 = r1;
        QVsyncFrameCaller.INSTANCE.postBind(new AnonymousClass2(this, r4, r11, r12, r13), r14);
    L11:
        r1 = r1 + 1;
        goto L3
    L8:
        if (r2.intValue() != 0) goto L10;
        final int r5 = r1;
        QVsyncFrameCaller.INSTANCE.postBind(new AnonymousClass1(this, r5, r11, r12, r13), r14);
        goto L11
    L12:
        QVsyncFrameCaller.INSTANCE.postBind(new AnonymousClass3(this), r14);
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final void unbind() {
        if (this.hasBind == false) goto L11;
        Iterator<QIPresenter> r0 = this.presenters.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().unbind();
        goto L6
    L8:
        this.hasBind = false;
        return;
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIPresenter
    public final boolean hasBind() {
        return this.hasBind;
    }

    public final QGroupPresenter addIf(boolean r2, Function0<? extends QIPresenter> r3) {
        Intrinsics.checkNotNullParameter(r3, ContractKt.OBRIC_ACTION_CREATE);
        if (r2 == true) goto L6;
        return this;
    L6:
        return add(r3.invoke());
    }

    public final QGroupPresenter addAll(List<? extends QIPresenter> r2) {
        if (r2 == null) goto L9;
        Iterator<T> r3 = r2.iterator();
    L5:
        if (r3.hasNext() == false) goto L9;
        QIPresenter r0 = (QIPresenter) r3.next();
        if (r0 == null) goto L5;
        add(r0);
    L9:
        return this;
    }

    public final QGroupPresenter add(QIPresenter r2) {
        Intrinsics.checkNotNullParameter(r2, "presenter");
        return add(0, r2);
    }

    public final QGroupPresenter add(int r2, QIPresenter r3) {
        Intrinsics.checkNotNullParameter(r3, "presenter");
        this.presenters.add(r3);
        this.viewIds.add(Integer.valueOf(r2));
        return this;
    }

    @Override // com.obric.structure.omvvm.core.flux.IComponent
    public void initializeContext(IComponentContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.componentContext = r3;
        Iterator<T> r2 = this.presenters.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        QIPresenter r0 = (QIPresenter) r2.next();
        if ((r0 instanceof IComponent) == false) goto L4;
        ((IComponent) r0).initializeContext(r3);
        goto L4
    }

    @Override // com.obric.structure.omvvm.core.flux.IComponent
    public IComponentContext getFluxContext() {
        return this.componentContext;
    }

    @Override // com.obric.structure.omvvm.core.flux.FluxLifecycleObserver
    public void onLifecycleEvent(FluxComponentLifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Iterator<T> r2 = this.presenters.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        QIPresenter r0 = (QIPresenter) r2.next();
        if ((r0 instanceof IComponent) == false) goto L4;
        ((IComponent) r0).onLifecycleEvent(r3);
        goto L4
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIMust
    public void mustBind(QModel r3, QUIManager r4) {
        Iterator<QIPresenter> r2 = this.presenters.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        QIPresenter r0 = r2.next();
        if ((r0 instanceof QIMust) == false) goto L4;
        ((QIMust) r0).mustBind(r3, r4);
        goto L4
    }

    @Override // com.obric.structure.omvvm.core.presenter.QIMust
    public void mustUnbind() {
        Iterator<QIPresenter> r2 = this.presenters.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        QIPresenter r0 = r2.next();
        if ((r0 instanceof QIMust) == false) goto L4;
        ((QIMust) r0).mustUnbind();
        goto L4
    }
}
