package com.bytedance.android.live.revenue.platform.hybrid.impl.component;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.revenue.common.j;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public class b<VIEW extends View> extends j implements xy0.a<VIEW> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IHybridComponent f91413b;

    @Override // xy0.a
    public final void load() {
        load(null, null);
    }

    @Override // com.bytedance.android.live.revenue.common.j
    public final void d() {
        this.f91413b.release();
    }

    @Override // xy0.a
    public VIEW getHybridView() {
        VIEW r100 = (VIEW) this.f91413b.getHybridView();
        if ((r100 instanceof View) == true) goto L6;
        return null;
    L6:
        return r100;
    }

    @Override // xy0.a
    public HybridType o() {
        IHybridComponent.HybridType r100 = this.f91413b.hybridType();
        int r101 = a.f91412a[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return HybridType.LYNX;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return HybridType.H5;
    }

    public b(IHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "originalIComponent");
        this.f91413b = r100;
    }

    @Override // xy0.a
    public final void load(String r100) {
        load(r100, null);
    }

    @Override // xy0.a
    public void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f91413b.updateData(r100);
    }

    @Override // xy0.a
    public void updateGlobalProps(Map<String, ? extends Object> r100) {
        this.f91413b.updateGlobalProps(r100);
    }

    @Override // xy0.a
    public final void load(String r100, Map<String, ? extends Object> r101) {
        this.f91413b.load(r100, r101);
    }

    @Override // xy0.a, wy0.e
    public void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "methodProvider");
        this.f91413b.registerMethod(r100, r101);
    }

    @Override // xy0.a, wy0.e
    public final void sendJsEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f91413b.sendJsEvent(r100, r101);
    }

    @Override // xy0.a
    public void updateScreenMetrics(int r100, int r101) {
        throw new IllegalStateException("not implemented".toString());
    }

    @Override // xy0.a, wy0.e
    public void registerMethod(String r100, g<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f91413b.registerMethod(r100, r101);
    }
}
