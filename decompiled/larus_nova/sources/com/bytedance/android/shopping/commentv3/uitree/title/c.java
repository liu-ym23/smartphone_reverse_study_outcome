package com.bytedance.android.shopping.commentv3.uitree.title;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements CapsuleComponent.OnClickCloseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IECAIHostService f172909a;

    public c(IECAIHostService r100) {
        this.f172909a = r100;
    }

    @Override // com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent.OnClickCloseListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f172909a.closeApplet(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE);
    }
}
