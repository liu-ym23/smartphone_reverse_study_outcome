package com.bytedance.android.shopping.slice.elements.projectionview;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends SlcFlexElementView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f183324e;

    public final ImageView getImageView() {
        return this.f183324e;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        ImageView r101 = new ImageView(r100);
        this.f183324e = r101;
        addView(r101, -1, -1);
    }

    public final void setImageBitmap(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f183324e.setImageBitmap(r100);
        this.f183324e.requestLayout();
    }
}
