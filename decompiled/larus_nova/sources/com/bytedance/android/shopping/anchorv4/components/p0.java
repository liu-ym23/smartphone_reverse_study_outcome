package com.bytedance.android.shopping.anchorv4.components;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p0 implements BackComponent.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WireframeComponent f166121a;

    public p0(WireframeComponent r100) {
        this.f166121a = r100;
    }

    @Override // com.bytedance.android.ec.base.api.ai.framework.component.BackComponent.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.bytedance.android.shopping.anchorv4.containers.g r101 = this.f166121a.f166056o;
        if (r101 == null) goto L6;
        r101.b(true, true, false);
        return;
    }
}
