package com.bytedance.android.shopping.mall.feed;

import android.util.LruCache;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedDataReuseConfig;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallFeedDataReuseHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f176820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, LruCache<ECHybridListItemDTO, ECHybridListItemVO>> f176821b = null;

    public static ECMallFeedDataReuseConfig a() {
        return (ECMallFeedDataReuseConfig) f176820a.getValue();
    }

    static {
        f176820a = LazyKt.lazy(ECMallFeedDataReuseHelper$reuseConfig$2.INSTANCE);
        f176821b = new HashMap();
    }

    public static void b(final String r100, final String r101) {
        if (r100 == null) goto L33;
        boolean r102 = false;
        if (r100.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        Integer r104 = null;
        if (r103 == false) goto L10;
        String r105 = r100;
    L11:
        if (r105 == null) goto L36;
        Integer r106 = a().getMaxSize();
        if (r106 != null) goto L16;
        return;
    L16:
        if (r106.intValue() <= 0) goto L18;
        r102 = true;
    L18:
        if (r102 == false) goto L20;
        r104 = r106;
    L20:
        if (r104 == null) goto L35;
        final int r107 = r104.intValue();
        List<String> r108 = a().getEnabledPages();
        if (r108 != null) goto L24;
    L30:
        kk.d.c(new ECMallFeedDataReuseHelper$writeUnexposedDataToDiskCache$2(r100, r101, r107));
        return;
    L24:
        if ((!r108.isEmpty()) != true) goto L30;
        List<String> r109 = a().getEnabledPages();
        if (r109 != null) goto L28;
        return;
    L28:
        if (r109.contains(r100) == true) goto L30;
        return;
    L35:
        return;
    L36:
        return;
    L10:
        r105 = null;
        goto L11
    L6:
        r103 = false;
        goto L7
    }
}
