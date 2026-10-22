package com.stepos.common.widget;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class w extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f11972a;

    public w(D d4) {
        this.f11972a = new WeakReference(d4);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        D d4 = (D) this.f11972a.get();
        if (d4 != null) {
            d4.f11514d.computeScrollOffset();
            int currY = d4.f11514d.getCurrY();
            int i4 = d4.f11515e - currY;
            d4.f11515e = currY;
            d4.f11511a.o(i4);
            if (Math.abs(currY - d4.f11514d.getFinalY()) < 1) {
                d4.f11514d.forceFinished(true);
            }
            if (d4.f11514d.isFinished()) {
                if (message.what == 0) {
                    d4.b();
                    return;
                } else {
                    d4.a();
                    return;
                }
            }
            int i5 = message.what;
            if (i5 == 1 || i5 == 0) {
                d4.f11518h.sendEmptyMessage(i5);
            }
        }
    }
}
