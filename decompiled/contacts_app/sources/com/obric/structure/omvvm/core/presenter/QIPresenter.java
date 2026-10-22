package com.obric.structure.omvvm.core.presenter;

import android.view.View;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.ui.QUIManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: QIPresenter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/obric/structure/omvvm/core/presenter/QIPresenter;", "", "bind", "", "model", "Lcom/obric/structure/omvvm/core/model/QModel;", "view", "Landroid/view/View;", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "hasBind", "", "unbind", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface QIPresenter {

    /* JADX INFO: compiled from: QIPresenter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void bind$default(QIPresenter r0, QModel r1, View r2, QUIManager r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
        L6:
            r0.bind(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bind");
        }
    }

    void bind(QModel r1, View r2, QUIManager r3);

    boolean hasBind();

    void unbind();
}
