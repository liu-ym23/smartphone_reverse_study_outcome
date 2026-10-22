package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DynamicViewWidgetOpt f180938c;

    @Override // java.lang.Runnable
    public final void run() {
        List<? extends com.bytedance.android.ecom.arch.slice.g> r100 = this.f180938c.f180920d;
        if (r100 == null) goto L13;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L19;
        com.bytedance.android.ecom.arch.slice.g r102 = (com.bytedance.android.ecom.arch.slice.g) r101.next();
        IAction r103 = r102.getShowAction();
        if (r103 == null) goto L6;
        e r104 = this.f180938c.f180917a;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
    L12:
        r104.d(r102, r103, this.f180938c.f180918b);
        goto L6
    L19:
        return;
    }

    public d(DynamicViewWidgetOpt r100) {
        this.f180938c = r100;
        super("delay_report_show_event");
    }
}
