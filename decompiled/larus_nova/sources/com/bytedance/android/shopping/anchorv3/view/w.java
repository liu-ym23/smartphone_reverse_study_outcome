package com.bytedance.android.shopping.anchorv3.view;

import android.text.style.ClickableSpan;
import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f165564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnchorV3UnifiedTipsSubView f165565b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(this.f165565b.getContext(), (String) this.f165564a.getValue());
    }

    public w(Map.Entry r100, AnchorV3UnifiedTipsSubView r101) {
        this.f165564a = r100;
        this.f165565b = r101;
    }
}
