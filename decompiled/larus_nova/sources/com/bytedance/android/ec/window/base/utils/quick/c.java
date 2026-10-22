package com.bytedance.android.ec.window.base.utils.quick;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes44.dex */
public abstract class c<E extends QModel> extends QPresenter {
    public abstract void D(E r100);

    public c() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    @Deprecated(level = DeprecationLevel.WARNING, message = "别用这个，类型不安全", replaceWith = @ReplaceWith(expression = "bindModel(model, view, uiManager)", imports = {"com.bytedance.android.shopping.common.utils.quick.ECPresenter.bindModel"}))
    public final void A(QModel r100) {
        if ((r100 instanceof QModel) == true) goto L5;
        r100 = null;
    L5:
        D(r100);
    }
}
