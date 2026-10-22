package com.bytedance.android.shopping.slice.elements.overlay;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SimpleDraweeView f183317a;

    public final SimpleDraweeView getSkuImgView() {
        return this.f183317a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(r100).inflate(R.layout.ec_anchor_v4_base_info_sku_node_view, this);
        this.f183317a = (SimpleDraweeView) findViewById(R.id.sku_node_img);
    }

    public final void setSkuImgView(SimpleDraweeView r100) {
        this.f183317a = r100;
    }
}
