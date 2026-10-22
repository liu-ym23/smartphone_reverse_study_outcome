package aq6;

import android.content.Context;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.host.perf.PerfStandard;
import en6.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f15905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f15906b;

    static {
        Dito r100 = Dito.f257280a;
        nq6.a r101 = com.bytedance.locallife.dito.utils.l.i();
        if (r101 == null) goto L5;
        m r102 = (m) r101;
        int r103 = r102.b(PerfStandard.UNKNOWN);
    L6:
        f15905a = r103;
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public static int a(Context r100) {
        if (f15906b == true) goto L14;
        if (r100 == null) goto L14;
        Intrinsics.checkNotNullParameter(r100, "ctx");
        if (f15906b == true) goto L14;
        Dito r101 = Dito.f257280a;
        nq6.a r102 = com.bytedance.locallife.dito.utils.l.i();
        if (r102 == null) goto L11;
        int r103 = ((m) r102).a(r100);
    L12:
        f15905a = r103;
        f15906b = true;
        goto L14
    L11:
        r103 = 0;
    L14:
        return f15905a;
    }
}
