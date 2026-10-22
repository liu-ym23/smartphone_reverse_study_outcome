package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.live.base.model.longpresspanel.ItemConfig;
import com.bytedance.android.live.base.model.longpresspanel.ItemIdentity;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o {
    static {
    }

    @JvmStatic
    public static final ItemConfig a(ItemIdentity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, DownloadHelper.IDENTITY);
        if (r101 == false) goto L5;
        List<ItemConfig> r102 = com.bytedance.android.livesdk.config.setting.l.a();
    L6:
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();
        String r105 = ((ItemConfig) r104).getIdentity();
        String r106 = r100.name();
        Locale r107 = Locale.ROOT;
        if (r106 == null) goto L15;
        if (Intrinsics.areEqual(r105, r106.toLowerCase(r107)) == false) goto L8;
    L17:
        ItemConfig r108 = (ItemConfig) r104;
        if (r108 == null) goto L20;
        return r108;
    L20:
        return new ItemConfig();
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L16:
        r104 = null;
        goto L17
    L5:
        r102 = com.bytedance.android.livesdk.config.setting.l.b();
        goto L6
    }
}
