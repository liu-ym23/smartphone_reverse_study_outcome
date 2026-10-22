package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Triple;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECCustomizedElementView f148992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f148993b;

    public d(ECCustomizedElementView r100, ArrayList r101) {
        this.f148992a = r100;
        this.f148993b = r101;
    }

    public final void a() {
        Iterator r100 = this.f148993b.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L15;
        Triple r102 = (Triple) r100.next();
        int r103 = ((Number) r102.getFirst()).intValue();
        boolean r104 = ((Boolean) r102.getSecond()).booleanValue();
        View r105 = (View) r102.getThird();
        int r106 = r103 - r101;
        if (r104 == true) goto L7;
        if (r105 == null) goto L4;
        if (r106 < this.f148992a.getChildCount()) goto L4;
        this.f148992a.addView(r105);
        goto L4
    L7:
        this.f148992a.removeViewAt(r106);
        if (r105 != null) goto L9;
        r101 = r101 + 1;
        goto L4
    L9:
        this.f148992a.addView(r105, r106);
        goto L4
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
