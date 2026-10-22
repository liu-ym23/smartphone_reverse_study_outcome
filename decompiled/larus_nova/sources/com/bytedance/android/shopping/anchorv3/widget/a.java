package com.bytedance.android.shopping.anchorv3.widget;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4SearchEditView;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.android.ec.core.widget.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AnchorV3SearchEditView f165598g;

    public a(AnchorV4SearchEditView r100) {
        this.f165598g = r100;
        super(null, null, 3);
    }

    @Override // com.bytedance.android.ec.core.widget.d
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f165598g.a(r100);
    }
}
