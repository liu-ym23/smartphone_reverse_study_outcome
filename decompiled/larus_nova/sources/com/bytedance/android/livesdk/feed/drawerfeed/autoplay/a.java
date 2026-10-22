package com.bytedance.android.livesdk.feed.drawerfeed.autoplay;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerFeedPreviewHelper.b f123718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f123719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ uv1.a f123720c;

    public a(DrawerFeedPreviewHelper.b r100, int r101, uv1.a r102) {
        this.f123718a = r100;
        this.f123719b = r101;
        this.f123720c = r102;
    }

    public final void a() {
        this.f123718a.f123714a.c();
        int r100 = this.f123718a.f123714a.a();
        if (r100 >= 0) goto L6;
        return;
    L6:
        if (this.f123719b == 0) goto L8;
    L10:
        Object r101 = this.f123718a.f123715b.findViewHolderForAdapterPosition(r100);
        if ((r101 instanceof an2.a) == true) goto L13;
        r101 = null;
    L13:
        an2.a r102 = (an2.a) r101;
        if (r102 != null) goto L16;
    L18:
        int[] r103 = {r100};
        this.f123718a.f123714a.f123708a = r103;
        return;
    L16:
        if (r102.t7() == false) goto L18;
        r102.play();
        goto L18
    L8:
        if (this.f123720c.f551789a == false) goto L10;
        r100 = r100 + 1;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
