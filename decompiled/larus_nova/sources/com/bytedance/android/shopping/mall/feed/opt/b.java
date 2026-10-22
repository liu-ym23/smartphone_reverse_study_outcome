package com.bytedance.android.shopping.mall.feed.opt;

import com.bytedance.android.ec.hybrid.list.entity.dto.ChipData;
import com.bytedance.android.ec.hybrid.list.entity.dto.ChipViewConfig;
import com.bytedance.android.ec.hybrid.list.opt.ImageRequestOpt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f177184a;

    public b(List r100) {
        this.f177184a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = this.f177184a.iterator();     // Catch: Throwable -> L9
    L4:
        if (r100.hasNext() == false) goto L21;
        ChipData r101 = ((ChipViewConfig) r100.next()).getChipData();     // Catch: Throwable -> L9
        if (r101 == null) goto L4;
        Set<String> r102 = ImageRequestOpt.f47208a;     // Catch: Throwable -> L9
        ImageRequestOpt.a(r101.getImageUrl(), r101.getBizTag(), r101.getSceneTag());     // Catch: Throwable -> L9
        goto L4
    L21:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
