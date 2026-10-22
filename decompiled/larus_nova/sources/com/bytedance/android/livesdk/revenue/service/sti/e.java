package com.bytedance.android.livesdk.revenue.service.sti;

import com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager;
import com.bytedance.android.livesdkapi.sti.ShortTermIcon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xr2.i;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements xr2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IShortTermIndicatorManager f157454a;

    @Override // xr2.e
    public final List<i> getIcons() {
        List<ShortTermIcon> r100 = this.f157454a.getIcons();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(g.a((ShortTermIcon) r102.next()));
        goto L4
    L6:
        return r101;
    }

    public e(IShortTermIndicatorManager r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f157454a = r100;
    }
}
