package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageBinderType;
import com.bytedance.android.livesdk.interactivity.square.common.common.CommonSquarePublicScreenViewHolder;
import com.bytedance.android.livesdk.interactivity.square.plugin.SquareModelSpanClickListener;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements h52.b<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageBinderType f141147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k52.a f141148b;

    public k(MessageBinderType r100, k52.a r101) {
        Intrinsics.checkNotNullParameter(r100, "binderType");
        Intrinsics.checkNotNullParameter(r101, "pipelineConfig");
        this.f141147a = r100;
        this.f141148b = r101;
    }

    @Override // h52.b
    public final CommonSquarePublicScreenViewHolder a(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutInflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = r100.inflate(R.layout.ttlive_item_public_screen_common_message_layout, r101, false);
        if (r102.getLayoutParams() != null) goto L6;
        r102.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L6:
        return new CommonSquarePublicScreenViewHolder(r102, this.f141148b);
    }

    @Override // h52.b
    public final void b(AbsPublicScreenMessageViewHolder r100, h52.c r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if (r101 == null) goto L7;
        c(r100, r101, r102);
        return;
    L7:
        throw new IllegalArgumentException("Invalid type ".concat(r101.getClass().getName()));
    }

    public final void c(AbsPublicScreenMessageViewHolder r100, h52.c r101, int r102) {
        j r103 = (j) r101;
        Intrinsics.checkNotNullParameter(r100, "viewholder");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        r100.f133721a = r103;
        if (r103 == null) goto L16;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r104 = m.a(null);
        if (r104 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r105 = r104.getValue();
        if (r105 == null) goto L16;
        Intrinsics.checkNotNullParameter(r105, "$this$getPlugin");
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        h52.a<h52.d, ? extends h52.c> r106 = r105.getMessagePluginByType(r103.f488289l);
        if (r106 == null) goto L16;
        SquareModelSpanClickListener r107 = r106.b();
        if (r107 == null) goto L16;
        View.OnClickListener r108 = r100.f133725e.f501830f.c(r107);
        NoMoreSpaceTextView r109 = r100.f133724d;
        if (r109 == null) goto L16;
        r109.setOnClickListener(new i52.c(r108, r100));
    L16:
        NoMoreSpaceTextView r110 = r100.f133724d;
        if (r110 == null) goto L19;
        r110.setOnLongClickListener(new i52.d(r100));
    L19:
        r100.T3(r103);
    }
}
