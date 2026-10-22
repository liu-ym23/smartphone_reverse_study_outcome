package com.android.ttcjpaysdk.base.imageloader;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"loadImageUrl", "", "Landroid/widget/ImageView;", "url", "", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImageLoaderKt {
    public static final void loadImageUrl(final ImageView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L6;
        ImageLoader.Companion.getInstance().loadImage(r101, new ImageLoaderKt$loadImageUrl$1$1(r100));
        return;
    }
}
