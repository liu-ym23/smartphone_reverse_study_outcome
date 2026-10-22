package com.bytedance.android.shopping.yata.biz.popup.component;

import android.view.View;
import com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f187558a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f187559a;

        public a(b r100) {
            this.f187559a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SheetBaseBehavior<?> r100 = this.f187559a.f187558a.f187562g;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            r100.setState(3);     // Catch: Throwable -> L8
            if (r100.f187549c == true) goto L15;
            r100.setState(4);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public b(c r100) {
        this.f187558a = r100;
    }

    public final void a() {
        com.bytedance.android.shopping.yata.biz.popup.a r100 = this.f187558a.f187554a;
        if (r100 == null) goto L11;
        hl3.e r101 = r100.f187507b;
        if (r101 == null) goto L7;
        r101.f(r100);
    L7:
        Iterator<hl3.b> r102 = r100.f187508c.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r102.next().f(r100);
    L11:
        SheetBaseBehavior<?> r103 = this.f187558a.f187562g;
        if (r103 == null) goto L14;
        r103.setState(5);
    L14:
        this.f187558a.e(true);
        View r104 = this.f187558a.f187560e;
        if (r104 == null) goto L19;
        r104.post(new a(this));
        return;
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
