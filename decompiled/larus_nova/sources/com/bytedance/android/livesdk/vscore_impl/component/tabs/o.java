package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159972a = 0;

    static {
    }

    public static int a(long r100, List r101) {
        if (r101 == null) goto L11;
        Iterator r102 = r101.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L11;
        if (((e) r102.next()).f159951b == r100) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return r103;
    L11:
        return 0;
    }

    public static long b(Integer r100, List r101) {
        if ((r100 instanceof Integer) == false) goto L9;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r101.size() > r100.intValue()) goto L8;
        return 0;
    L8:
        return ((e) ListProtector.get(r101, r100.intValue())).f159951b;
    L9:
        return 0;
    }
}
