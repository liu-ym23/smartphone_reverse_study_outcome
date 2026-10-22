package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class l<T> {

    /* renamed from: a, reason: collision with root package name */
    private int f14689a = 0;

    public T a(Context context) throws InterruptedException {
        int i5;
        do {
            T tB = b(context);
            if (tB == null) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e6) {
                    e6.printStackTrace();
                }
                i5 = this.f14689a + 1;
                this.f14689a = i5;
                if (tB != null) {
                    break;
                }
            } else {
                this.f14689a = 0;
                return tB;
            }
        } while (i5 <= 4);
        this.f14689a = 0;
        return null;
    }

    protected abstract T b(Context context);
}
