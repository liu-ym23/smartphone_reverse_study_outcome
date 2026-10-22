package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import android.view.View;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.opt.asyncInflate.AsyncInflaterImpl;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes10.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f150320a = 0;

    static {
    }

    public static boolean a(ShoppingAsyncInflater r100, com.bytedance.android.ec.opt.asyncInflate.d r101, int r102, int r103) {
        AsyncInflaterImpl r104 = r100.f45269a;
        if (r104 == null) goto L14;
        LinkedList<View> r105 = r104.f48009a.get(Integer.valueOf(r102));
        if (r105 == null) goto L13;
        monitor-enter(r105);
        int r106 = r105.size();     // Catch: Throwable -> L10
        monitor-exit(r105);
    L15:
        if (r106 >= r103) goto L18;
        r101.a(r102, r103 - r106);
        return true;
    L18:
        return false;
    L10:
        th = move-exception;
        throw th;
    L13:
        r106 = 0;
        goto L15
    L14:
        r106 = 1;
        goto L15
    }
}
