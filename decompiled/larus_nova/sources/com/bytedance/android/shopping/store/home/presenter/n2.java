package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n2 extends PanelItem.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f184244a;

    public n2(Function1 r100) {
        this.f184244a = r100;
    }

    @Override // com.bytedance.android.ec.base.api.ai.framework.model.PanelItem.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f184244a.invoke(r100);
    }
}
