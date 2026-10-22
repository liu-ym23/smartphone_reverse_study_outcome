package com.obric.structure.omvvm.core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.structure.omvvm.core.insight.QInsight;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.presenter.QIPresenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QUIModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010E\u001a\u00020\nH\u0016J\b\u0010F\u001a\u000204H\u0016J\b\u0010G\u001a\u000204H\u0016J*\u0010H\u001a\u00020I2\u0016\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u00000Kj\b\u0012\u0004\u0012\u00020\u0000`L2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010M\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u0003H\u0016J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0016J \u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010-\u001a\u00020.2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0000J\u0014\u0010R\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010S\u001a\u000204H\u0016J\u001a\u0010T\u001a\u00020:2\u0006\u0010P\u001a\u00020Q2\b\u0010\u0017\u001a\u0004\u0018\u00010UH&J\u0010\u0010V\u001a\u00020O2\u0006\u00109\u001a\u00020:H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H&J\u0010\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010(H\u0016J\u0014\u0010B\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\f\"\u0004\bA\u0010\u000eR\u001a\u0010B\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001d\"\u0004\bD\u0010\u0004¨\u0006W"}, d2 = {"Lcom/obric/structure/omvvm/core/ui/QUIModule;", "", "parentId", "", "(I)V", "params", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "(ILandroid/view/ViewGroup$LayoutParams;)V", "isChildOnly", "", "isChildOnly$omvvm_core_release", "()Z", "setChildOnly$omvvm_core_release", "(Z)V", "model", "Lcom/obric/structure/omvvm/core/model/QModel;", "getModel$omvvm_core_release", "()Lcom/obric/structure/omvvm/core/model/QModel;", "setModel$omvvm_core_release", "(Lcom/obric/structure/omvvm/core/model/QModel;)V", "getParams$omvvm_core_release", "()Landroid/view/ViewGroup$LayoutParams;", "parent", "getParent", "()Lcom/obric/structure/omvvm/core/ui/QUIModule;", "setParent", "(Lcom/obric/structure/omvvm/core/ui/QUIModule;)V", "getParentId$omvvm_core_release", "()I", "pendingBind", "getPendingBind$omvvm_core_release", "setPendingBind$omvvm_core_release", "presenter", "Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "getPresenter$omvvm_core_release", "()Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "setPresenter$omvvm_core_release", "(Lcom/obric/structure/omvvm/core/presenter/QIPresenter;)V", "subModules", "", "getSubModules", "()Ljava/util/List;", "setSubModules", "(Ljava/util/List;)V", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "getUiManager", "()Lcom/obric/structure/omvvm/core/ui/QUIManager;", "setUiManager", "(Lcom/obric/structure/omvvm/core/ui/QUIManager;)V", "uiModuleKey", "", "getUiModuleKey", "()Ljava/lang/String;", "uiModuleKey$delegate", "Lkotlin/Lazy;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "viewCreated", "getViewCreated$omvvm_core_release", "setViewCreated$omvvm_core_release", "visibility", "getVisibility$omvvm_core_release", "setVisibility$omvvm_core_release", "asyncUIOperated", "getModuleKey", "groupId", "handleConflict", "Lcom/obric/structure/omvvm/core/ui/QUIAction;", "conflictModule", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "handleVisibility", "init", "", "context", "Landroid/content/Context;", "isOnly", "moduleName", "onCreateView", "Landroid/view/ViewGroup;", "onViewCreated", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class QUIModule {
    private boolean isChildOnly;
    private QModel model;
    private final ViewGroup.LayoutParams params;
    private QUIModule parent;
    private final int parentId;
    private boolean pendingBind;
    private QIPresenter presenter;
    private List<? extends QUIModule> subModules;
    public QUIManager uiManager;
    private final Lazy uiModuleKey$delegate;
    private View view;
    private boolean viewCreated;
    private int visibility;

    /* JADX WARN: Multi-variable type inference failed */
    public QUIModule() {
        int r2 = 0;
        this(r2, null, 3, 0 == true ? 1 : 0);
    }

    public boolean asyncUIOperated() {
        return false;
    }

    public String groupId() {
        return "";
    }

    public boolean handleVisibility(int r1) {
        return false;
    }

    public void init(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public boolean isOnly(QModel r1) {
        return false;
    }

    public abstract View onCreateView(Context r1, ViewGroup r2);

    public void onViewCreated(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public abstract QIPresenter presenter();

    public List<QUIModule> subModules() {
        return null;
    }

    public int visibility(QModel r1) {
        return 0;
    }

    public QUIModule(int r1, ViewGroup.LayoutParams r2) {
        this.parentId = r1;
        this.params = r2;
        this.uiModuleKey$delegate = LazyKt.lazy(new QUIModule$uiModuleKey$2(this));
    }

    public /* synthetic */ QUIModule(int r1, ViewGroup.LayoutParams r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = -1;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }

    public final ViewGroup.LayoutParams getParams$omvvm_core_release() {
        return this.params;
    }

    public final int getParentId$omvvm_core_release() {
        return this.parentId;
    }

    public final QUIManager getUiManager() {
        QUIManager r0 = this.uiManager;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("uiManager");
        return null;
    }

    public final void setUiManager(QUIManager r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uiManager = r2;
    }

    public final QModel getModel$omvvm_core_release() {
        return this.model;
    }

    public final void setModel$omvvm_core_release(QModel r1) {
        this.model = r1;
    }

    public final QIPresenter getPresenter$omvvm_core_release() {
        return this.presenter;
    }

    public final void setPresenter$omvvm_core_release(QIPresenter r1) {
        this.presenter = r1;
    }

    public final boolean getPendingBind$omvvm_core_release() {
        return this.pendingBind;
    }

    public final void setPendingBind$omvvm_core_release(boolean r1) {
        this.pendingBind = r1;
    }

    public final boolean getViewCreated$omvvm_core_release() {
        return this.viewCreated;
    }

    public final void setViewCreated$omvvm_core_release(boolean r1) {
        this.viewCreated = r1;
    }

    public final boolean isChildOnly$omvvm_core_release() {
        return this.isChildOnly;
    }

    public final void setChildOnly$omvvm_core_release(boolean r1) {
        this.isChildOnly = r1;
    }

    public final int getVisibility$omvvm_core_release() {
        return this.visibility;
    }

    public final void setVisibility$omvvm_core_release(int r1) {
        this.visibility = r1;
    }

    public final View getView() {
        return this.view;
    }

    public final void setView(View r1) {
        this.view = r1;
    }

    public final QUIModule getParent() {
        return this.parent;
    }

    public final void setParent(QUIModule r1) {
        this.parent = r1;
    }

    public final List<QUIModule> getSubModules() {
        return this.subModules;
    }

    public final void setSubModules(List<? extends QUIModule> r1) {
        this.subModules = r1;
    }

    private final String getUiModuleKey() {
        return (String) this.uiModuleKey$delegate.getValue();
    }

    public QUIModule(int r2) {
        this(r2, null);
    }

    public QUIModule(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this(-1, r2);
    }

    public final void init(Context r3, final QUIManager r4, QUIModule r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uiManager");
        QInsight.INSTANCE.runIfEnabled(new AnonymousClass1(r4, this));
        setUiManager(r4);
        this.parent = r5;
        init(r3);
        this.presenter = presenter();
        this.subModules = subModules();
    }

    public static /* synthetic */ int visibility$default(QUIModule r0, QModel r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = null;
    L7:
        return r0.visibility(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: visibility");
    }

    public QUIAction handleConflict(ArrayList<QUIModule> r1, QModel r2) {
        Intrinsics.checkNotNullParameter(r1, "conflictModule");
        return QUIAction.NONE;
    }

    public static /* synthetic */ boolean isOnly$default(QUIModule r0, QModel r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = null;
    L7:
        return r0.isOnly(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isOnly");
    }

    public String getModuleKey() {
        return getUiModuleKey();
    }

    public String moduleName() {
        String r1 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r1, "this.javaClass.simpleName");
        return r1;
    }
}
