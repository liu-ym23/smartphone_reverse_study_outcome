package com.bytedance.android.livesdk.dsl.recyclerview;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements yt1.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleDSLViewHolder.a f122802a;

    public i(SingleDSLViewHolder.a r100) {
        this.f122802a = r100;
    }

    @Override // yt1.i
    public final boolean a(IAction r100, View r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Intrinsics.checkNotNullParameter(r102, "curTemplateHolder");
        SingleDSLViewHolder.a r103 = this.f122802a;
        c r104 = r103.f122779a.f122778e;
        b r105 = r103.f122780b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Intrinsics.checkNotNullParameter(r102, "curTemplateHolder");
        bu1.a r106 = r104.f122792a.get(r100.getType());
        if (r106 == null) goto L5;
        r106.a(r105, r100, r101, r102);
        return true;
    L5:
        return false;
    }
}
