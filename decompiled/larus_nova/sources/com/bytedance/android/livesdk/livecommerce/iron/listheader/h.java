package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.event.d2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f148834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gi2.a f148835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f148836c;

    public h(List r100, gi2.a r101, String r102) {
        this.f148834a = r100;
        this.f148835b = r101;
        this.f148836c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List r100 = this.f148834a;     // Catch: Throwable -> L12
        if (r100 == null) goto L15;
        Iterator r101 = r100.iterator();     // Catch: Throwable -> L12
    L6:
        if (r101.hasNext() == false) goto L27;
        RitTagTrack r102 = ((ECRitTag) r101.next()).getTagTrack();     // Catch: Throwable -> L12
        gi2.a r103 = this.f148835b;     // Catch: Throwable -> L12
        if (r103 == null) goto L6;
        if (r102 == null) goto L6;
        int r104 = d2.f147723a;     // Catch: Throwable -> L12
        d2.d(r103, "live_shop_entrance_cart_list", r102, null, "a1.b0715.c9204.d7082", this.f148836c);     // Catch: Throwable -> L12
        goto L6
    L27:
        return;
    L15:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L26;
        throw th;
    }
}
