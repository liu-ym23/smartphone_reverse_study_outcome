package com.bytedance.android.gamecp.business.gamedetail.component;

import com.bytedance.android.gamecp.base.gamedetail.GameDetailComponent;
import com.bytedance.ies.sve_core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<P extends p> extends GameDetailComponent<P> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f53521k;

    public a(f r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "componentFactory");
        Intrinsics.checkNotNullParameter(r101, "componentClass");
        super(r101);
        this.f53521k = r100;
    }
}
