package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import android.content.Context;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements g42.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f138860a;

    @Override // g42.e
    public final void c(DataCenter r100, g42.c r101, HighlightItem r102) {
        Intrinsics.checkNotNullParameter(r101, "pinContainer");
        Intrinsics.checkNotNullParameter(r102, "highlightItem");
    }

    @Override // g42.e
    public final int getContentHeight() {
        return this.f138860a.getHeight();
    }

    @Override // g42.e
    public final int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(72);
    }

    @Override // g42.e
    public final View getView() {
        return this.f138860a;
    }

    public i(Context r100) {
        this.f138860a = new View(r100);
    }

    @Override // g42.e
    public final void a(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
    }

    @Override // g42.e
    public final void b(g42.c r100, HighlightItem r101) {
        Intrinsics.checkNotNullParameter(r100, "pinContainer");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        g42.e.a.a(r100, r101);
    }

    @Override // g42.e
    public void update(g42.c r100, HighlightItem r101) {
        Intrinsics.checkNotNullParameter(r100, "pinContainer");
        Intrinsics.checkNotNullParameter(r101, "highlightItem");
        g42.e.a.update(this, r100, r101);
    }
}
