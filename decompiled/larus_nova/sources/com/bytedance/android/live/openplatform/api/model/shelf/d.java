package com.bytedance.android.live.openplatform.api.model.shelf;

import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.live.datacontext.n;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f83974a = null;

    static {
        f83974a = new AtomicLong(1);
    }

    public static final int a(long r100) {
        MiniAppDataContext.Companion.getClass();
        MiniAppDataContext r101 = MiniAppDataContext.a.a();
        if (r101 == null) goto L23;
        n<ShelfInfo> r102 = r101.m8183getShelfInfo();
        if (r102 == null) goto L23;
        ShelfInfo r103 = r102.getValue();
        if (r103 == null) goto L23;
        List<ShelfCardInfo> r104 = r103.cardInfoList;
        if (r104 == null) goto L23;
        ListIterator<ShelfCardInfo> r105 = r104.listIterator(r104.size());
    L12:
        if (r105.hasPrevious() == false) goto L19;
        ShelfCardInfo r106 = r105.previous();
        if (r106.cardId != r100) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L12;
    L20:
        ShelfCardInfo r108 = r106;
        if (r108 == null) goto L23;
        return r104.indexOf(r108) + 1;
    L16:
        r107 = false;
        goto L17
    L19:
        r106 = null;
    L23:
        return -1;
    }
}
