package com.bytedance.android.livesdk.coupon.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f121923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f121924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f121925c;

    public interface a {
        List<Long> a();

        void b(List<Long> r100);
    }

    public static long a() {
        Calendar r100 = Calendar.getInstance();
        r100.set(10, 0);
        r100.set(12, 0);
        r100.set(13, 0);
        r100.set(14, 0);
        r100.set(9, 0);
        return r100.getTimeInMillis();
    }

    public final void call() {
        long r100 = a();
        int r101 = 1 - this.f121923a;
        Calendar r102 = Calendar.getInstance();
        r102.setTime(new Date(r100));
        r102.add(5, r101);
        long r103 = r102.getTimeInMillis();
        List<Long> r104 = this.f121925c.a();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L11;
        Object r107 = r106.next();
        if (((Number) r107).longValue() <= r103) goto L8;
        boolean r108 = true;
    L9:
        if (r108 == false) goto L4;
        r105.add(r107);
        goto L4
    L8:
        r108 = false;
        goto L9
    L11:
        List<Long> r109 = CollectionsKt.toMutableList(r105);
        r109.add(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
        this.f121925c.b(r109);
    }

    public b(int r100, int r101, UgCouponNewDialogFrequencyController$frequencyController$2.a r102) {
        Intrinsics.checkNotNullParameter(r102, "callTimeHolder");
        this.f121923a = r100;
        this.f121924b = r101;
        this.f121925c = r102;
    }
}
