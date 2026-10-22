package com.bytedance.android.ec.core.widget;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Function1 f46083g;

    @Override // com.bytedance.android.ec.core.widget.d
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f46083g.invoke(r100);
    }

    public e(Function1 r100, Long r101, String r102) {
        this.f46083g = r100;
        super(r101, r102);
    }
}
