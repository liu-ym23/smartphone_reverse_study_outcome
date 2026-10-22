package com.obric.structure.omvvm.core.presenter;

import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.ui.QUIManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: QIMust.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/obric/structure/omvvm/core/presenter/QIMust;", "", "mustBind", "", "model", "Lcom/obric/structure/omvvm/core/model/QModel;", "uiManager", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "mustUnbind", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface QIMust {

    /* JADX INFO: compiled from: QIMust.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void mustBind$default(QIMust r0, QModel r1, QUIManager r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            r0.mustBind(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mustBind");
        }
    }

    void mustBind(QModel r1, QUIManager r2);

    void mustUnbind();
}
