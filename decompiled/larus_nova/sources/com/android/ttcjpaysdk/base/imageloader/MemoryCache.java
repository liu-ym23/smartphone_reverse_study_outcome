package com.android.ttcjpaysdk.base.imageloader;

import android.graphics.Bitmap;
import android.text.TextUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/imageloader/MemoryCache;", "Lcom/android/ttcjpaysdk/base/imageloader/Cache;", "()V", "lruCache", "com/android/ttcjpaysdk/base/imageloader/MemoryCache$lruCache$1", "Lcom/android/ttcjpaysdk/base/imageloader/MemoryCache$lruCache$1;", "getBitmap", "Landroid/graphics/Bitmap;", "key", "", "setBitmap", "", "value", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MemoryCache implements Cache {
    private final MemoryCache$lruCache$1 lruCache;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.android.ttcjpaysdk.base.imageloader.MemoryCache$lruCache$1] */
    public MemoryCache() {
        final int r100 = ((int) (Runtime.getRuntime().maxMemory() / ((long) 1024))) / 8;
        this.lruCache = new MemoryCache$lruCache$1(r100);
    }

    @Override // com.android.ttcjpaysdk.base.imageloader.Cache
    public Bitmap getBitmap(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Bitmap r101 = get(r100);
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L13;
        return r101;
    L13:
        return null;
    L7:
        if (r101.isRecycled() == true) goto L9;
        r102 = true;
        goto L9
    L11:
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.imageloader.Cache
    public void setBitmap(String r100, Bitmap r101) {
        if (this.lruCache == null) goto L12;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L13;
        put(r100, r101);
        return;
    L13:
        return;
    L7:
        if (r101.isRecycled() == true) goto L9;
        r102 = true;
        goto L9
    }
}
