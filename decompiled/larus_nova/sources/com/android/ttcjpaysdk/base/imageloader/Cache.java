package com.android.ttcjpaysdk.base.imageloader;

import android.graphics.Bitmap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/imageloader/Cache;", "", "getBitmap", "Landroid/graphics/Bitmap;", "key", "", "setBitmap", "", "value", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Cache {
    Bitmap getBitmap(String r100);

    void setBitmap(String r100, Bitmap r101);
}
