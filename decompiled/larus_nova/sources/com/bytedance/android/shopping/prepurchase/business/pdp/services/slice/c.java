package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e73.a f182165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f182166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f182167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f182168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e f182169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j f182170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f f182171g;

    public final void a(e73.a r100) {
        if (this.f182166b == false) goto L5;
        return;
    L5:
        this.f182166b = true;
        if (r100.b() == null) goto L9;
        long r101 = System.currentTimeMillis();
        b(r100.b());
        Set<String> r102 = ECProcessMonitor.f45118a;
        ECProcessMonitor.k("pdp_before_render", System.currentTimeMillis() - r101, null, null, 24);
        return;
    }

    public final boolean b(IAction r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f182168d != null) goto L8;
        return false;
    L8:
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f.a.b(this.f182171g, null, r100, new View(this.f182168d), 9);
        return true;
    }

    public c(FragmentActivity r100, PdpDynamicFeatureService r101, com.bytedance.android.shopping.prepurchase.arch.container.component.j r102, o r103) {
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r103, "sliceAbility");
        this.f182168d = r100;
        this.f182169e = r101;
        this.f182170f = r102;
        this.f182171g = r103;
    }
}
