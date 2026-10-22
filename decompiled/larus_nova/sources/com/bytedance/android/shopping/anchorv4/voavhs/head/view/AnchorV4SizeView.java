package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/AnchorV4SizeView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4SizeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f168895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f168896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f168897c;

    public AnchorV4SizeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4SizeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public AnchorV4SizeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168897c = 1.0f;
        th.a.c(r100, R.layout.shopping_anchor_v4_head_view_size_layout, this, true);
        SimpleDraweeView r103 = (SimpleDraweeView) findViewById(R.id.size_image);
        this.f168895a = r103;
        this.f168896b = findViewById(R.id.size_image_layer);
        ImageExtensionsKt.D(r103, new com.bytedance.android.ec.core.imagex.r("ec_detail", "ec_product_header_image"));
    }

    public /* synthetic */ AnchorV4SizeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
