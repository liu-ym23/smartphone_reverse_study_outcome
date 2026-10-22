package com.obric.structure.omvvm.core.ui;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.presenter.QIPresenter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QUIAsyncManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0003J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0003R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/obric/structure/omvvm/core/ui/QUIAsyncManager;", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "()V", "asyncBindInner", "", "getAsyncBindInner", "()Z", "setAsyncBindInner", "(Z)V", "", "uiModule", "Lcom/obric/structure/omvvm/core/ui/QUIModule;", "model", "Lcom/obric/structure/omvvm/core/model/QModel;", "bindInner", "executeAfterBindView", "executeAfterCreateView", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QUIAsyncManager extends QUIManager {
    private boolean asyncBindInner;

    public QUIAsyncManager() {
    }

    public static final /* synthetic */ void access$asyncBindInner(QUIAsyncManager r0, QUIModule r1, QModel r2) {
        r0.asyncBindInner(r1, r2);
    }

    public static final /* synthetic */ void access$executeAfterBindView(QUIAsyncManager r0, QUIModule r1, QModel r2) {
        r0.executeAfterBindView(r1, r2);
    }

    public static final /* synthetic */ void access$executeAfterCreateView(QUIAsyncManager r0, QUIModule r1, QModel r2) {
        r0.executeAfterCreateView(r1, r2);
    }

    public final boolean getAsyncBindInner() {
        return this.asyncBindInner;
    }

    public final void setAsyncBindInner(boolean r1) {
        this.asyncBindInner = r1;
    }

    @Override // com.obric.structure.omvvm.core.ui.QUIManager
    protected void bindInner(final QUIModule r4, final QModel r5) {
        Intrinsics.checkNotNullParameter(r4, "uiModule");
        if (getFragment() == null) goto L7;
        Fragment r0 = getFragment();
        Intrinsics.checkNotNull(r0);
        if (r0.getActivity() == null) goto L7;
    L8:
        r4.setModel$omvvm_core_release(r5);
        if (r4.getVisibility$omvvm_core_release() != 8) goto L11;
        pendingBind(r4, r5);
    L36:
        executeAfterBindView(r4, r5);
        return;
    L11:
        if (r4.getViewCreated$omvvm_core_release() == false) goto L19;
        if (getBindScatterOpt() == false) goto L15;
        scatterBind(r4, r5, r4.getPresenter$omvvm_core_release());
        goto L36
    L15:
        QIPresenter r1 = r4.getPresenter$omvvm_core_release();
        if (r1 == null) goto L36;
        View r2 = r4.getView();
        Intrinsics.checkNotNull(r2);
        r1.bind(r5, r2, this);
        goto L36
    L19:
        if (this.asyncBindInner == false) goto L29;
        if (getWork().getSync$omvvm_core_release() == true) goto L29;
        if (getBindInnerOpt() == true) goto L25;
    L26:
        getWork().post(new C03901(this, r4, r5));
        return;
    L25:
        if (r4.getView() == null) goto L26;
    L34:
        executeAfterCreateView(r4, r5);
    L29:
        if (getBindInnerOpt() == true) goto L31;
        r4.setView(createView(r4));
        goto L34
    L31:
        if (r4.getView() != null) goto L34;
        r4.setView(createView(r4));
    L7:
        if (getFragment() == null) goto L8;
    }

    private final void asyncBindInner(final QUIModule r3, final QModel r4) {
        r3.setView(createView(r3));
        getMain().post(new AnonymousClass1(this, r3, r4));
    }

    private final void executeAfterCreateView(QUIModule r2, QModel r3) {
        addModuleView(r2);
        r2.setViewCreated$omvvm_core_release(true);
        View r0 = r2.getView();
        Intrinsics.checkNotNull(r0);
        r2.onViewCreated(r0);
        if (getBindScatterOpt() == false) goto L5;
        scatterBind(r2, r3, r2.getPresenter$omvvm_core_release());
        return;
    L5:
        QIPresenter r1 = r2.getPresenter$omvvm_core_release();
        if (r1 == null) goto L10;
        View r4 = r2.getView();
        Intrinsics.checkNotNull(r4);
        r1.bind(r3, r4, this);
        return;
    }

    private final void executeAfterBindView(final QUIModule r3, QModel r4) {
        if (r3.getViewCreated$omvvm_core_release() == false) goto L9;
        if (getBindScatterOpt() == false) goto L7;
        postBind(new C03911(this, r3));
        goto L9
    L7:
        setVisibility(r3, r3.getVisibility$omvvm_core_release());
    L9:
        if (r3.getVisibility$omvvm_core_release() != 8) goto L11;
        return;
    L11:
        if (r3.getSubModules() == null) goto L18;
        List<QUIModule> r5 = r3.getSubModules();
        Intrinsics.checkNotNull(r5);
        Iterator<QUIModule> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        bindInner(r6.next(), r4);
        goto L14
    L19:
        return;
    }
}
