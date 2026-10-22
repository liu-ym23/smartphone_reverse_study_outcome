package com.bytedance.android.shopping.anchorv4.helper;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpIndexActionHelper f166974a;

    public s(PdpIndexActionHelper r100) {
        this.f166974a = r100;
    }

    public final void a() {
        PdpIndexActionHelper r100 = this.f166974a;
        j r101 = r100.f166918b;
        if (r101 == null) goto L8;
        IAction r102 = r100.f166917a.get(r101.f166956a);
        if (r102 == null) goto L7;
        PdpIndexActionHelper r103 = this.f166974a;
        View r104 = r101.f166958c;
        com.bytedance.android.ecom.arch.slice.g r105 = r101.f166959d;
        r103.f166922f.invoke(r102, r104, r105);
        goto L8
    L7:
        this.f166974a.b(r101.f166956a, r101.f166957b, true);
    L8:
        Iterator r106 = ((List) this.f166974a.f166919c.getValue()).iterator();
    L10:
        if (r106.hasNext() == false) goto L15;
        j r107 = (j) r106.next();
        IAction r108 = this.f166974a.f166917a.get(r107.f166956a);
        if (r108 != null) goto L13;
        this.f166974a.b(r107.f166956a, r107.f166957b, true);
        goto L10
    L13:
        PdpIndexActionHelper r109 = this.f166974a;
        View r110 = r107.f166958c;
        com.bytedance.android.ecom.arch.slice.g r111 = r107.f166959d;
        r109.f166922f.invoke(r108, r110, r111);
        goto L10
    L15:
        PdpIndexActionHelper r112 = this.f166974a;
        r112.f166918b = null;
        ((List) r112.f166919c.getValue()).clear();
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
