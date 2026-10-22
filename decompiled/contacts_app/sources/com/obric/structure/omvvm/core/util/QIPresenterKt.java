package com.obric.structure.omvvm.core.util;

import com.obric.structure.omvvm.core.flux.IComponentContext;
import com.obric.structure.omvvm.core.presenter.QIPresenter;
import com.obric.structure.omvvm.core.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QIPresenter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"checkBindState", "", "Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "componentContext", "Lcom/obric/structure/omvvm/core/flux/IComponentContext;", "bindFuncState", "Lcom/obric/structure/omvvm/core/util/QBindState;", "omvvm-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class QIPresenterKt {

    /* JADX INFO: compiled from: QIPresenter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[QBindState.values().length];
            r0[QBindState.SYNC_BIND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[QBindState.ASYNC_BIND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[QBindState.SYNC_UNBIND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[QBindState.ASYNC_UNBIND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final boolean checkBindState(QIPresenter r1, QUIManager r2, IComponentContext r3, QBindState r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "bindFuncState");
        if (r2 != null) goto L5;
        return true;
    L5:
        if (r3 == null) goto L8;
        return true;
    L8:
        if (r2.getInnerCheckBindState() == true) goto L10;
        return true;
    L10:
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L23;
        if (r5 == 3) goto L20;
        if (r5 == 4) goto L20;
    L25:
        return true;
    L20:
        if (r2.getHasSyncBind() == false) goto L25;
        return false;
    L23:
        if (r2.getHasSyncBind() == true) goto L25;
        return false;
    }
}
