package com.bytedance.android.shopping.commentv3.audio;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, WeakReference<i>> f172620a = null;

    static {
        f172620a = new LinkedHashMap();
    }

    public static void a(String r100, i r101) {
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        if (r100 != null) goto L5;
        return;
    L5:
        Map<String, WeakReference<i>> r102 = f172620a;
        WeakReference r103 = (WeakReference) ((LinkedHashMap) r102).get(r100);
        if (r103 == null) goto L8;
        i r104 = (i) r103.get();
    L10:
        if (Intrinsics.areEqual(r104, r101) == false) goto L13;
        r102.remove(r100);
        return;
    L13:
        return;
    L8:
        r104 = null;
        goto L10
    }
}
