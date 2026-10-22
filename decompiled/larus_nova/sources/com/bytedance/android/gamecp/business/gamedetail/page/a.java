package com.bytedance.android.gamecp.business.gamedetail.page;

import com.bytedance.android.gamecp.base.gamedetail.GameDetailComponent;
import com.bytedance.android.gamecp.business.gamedetail.component.f;
import com.bytedance.ies.sve_core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<P extends p> extends GameDetailComponent<P> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f55328k;

    public final f g() {
        f r100 = this.f55328k;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("componentFactory");
    L5:
        return r100;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        super(r100);
    }
}
