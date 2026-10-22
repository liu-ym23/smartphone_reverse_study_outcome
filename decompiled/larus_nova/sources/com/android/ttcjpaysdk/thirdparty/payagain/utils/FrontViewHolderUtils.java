package com.android.ttcjpaysdk.thirdparty.payagain.utils;

import android.text.TextUtils;
import android.widget.ImageView;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ(\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/utils/FrontViewHolderUtils;", "", "()V", "loadImage", "", "url", "", "view", "Landroid/widget/ImageView;", "maskView", "isEnable", "", "setIconUrl", "iconView", "iconMaskView", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FrontViewHolderUtils {
    public static final FrontViewHolderUtils INSTANCE = null;

    static {
        INSTANCE = new FrontViewHolderUtils();
    }

    private FrontViewHolderUtils() {
    }

    public final void loadImage(final String r100, final ImageView r101, final ImageView r102, final boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "maskView");
        r101.setImageBitmap(null);
        r101.setImageResource(R.drawable.cj_pay_bg_payment_icon_unable);
        ImageLoader.Companion.getInstance().loadImage(r100, new AnonymousClass1(r100, r101, r102, r103));
    }

    public final void setIconUrl(ImageView r100, ImageView r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "iconView");
        Intrinsics.checkNotNullParameter(r101, "iconMaskView");
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r100.setTag(r102);
        r101.setTag(r102);
        loadImage(r102, r100, r101, r103);
        return;
    L5:
        r100.setTag(null);
        r101.setTag(null);
        r100.setImageBitmap(null);
        r101.setVisibility(8);
    }
}
