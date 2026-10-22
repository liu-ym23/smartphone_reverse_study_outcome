package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.view.View;
import com.lynx.tasm.LynxView;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e0 extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f86514a;

    public e0(String r100) {
        this.f86514a = r100;
    }

    @Override // b7.a, b7.b
    public final void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        super.onBeforeCreateRenderData(r100);
        if ((r100 instanceof LynxView) == false) goto L6;
        ((LynxView) r100).updateGlobalProps(MapsKt.mapOf(TuplesKt.to("my_live_extra", this.f86514a)));
        return;
    }
}
