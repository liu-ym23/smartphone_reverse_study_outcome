package com.bytedance.android.live.core.utils.fresco;

import android.app.ActivityManager;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements Supplier<MemoryCacheParams> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ActivityManager> f66138a;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.utils.fresco.a$a, reason: collision with other inner class name */
    public static final class C1096a {
    }

    static {
    }

    @Override // com.facebook.common.internal.Supplier
    public final MemoryCacheParams get() {
        ActivityManager r100 = this.f66138a.get();
        if (r100 == null) goto L5;
        int r101 = r100.getMemoryClass();
    L6:
        int r102 = Math.min(r101 * 1048576, Integer.MAX_VALUE);
        if (r102 >= 33554432) goto L10;
        int r103 = 4194304;
    L14:
        return new MemoryCacheParams(r103, 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    L10:
        if (r102 >= 67108864) goto L12;
        r103 = BmLocated.ALIGN_LEFT_BOTTOM;
        goto L14
    L12:
        r103 = r102 / 4;
        goto L14
    L5:
        r101 = 256;
        goto L6
    }

    public a(ActivityManager r100) {
        Intrinsics.checkNotNullParameter(r100, "activityManager");
        this.f66138a = new WeakReference(r100);
    }
}
