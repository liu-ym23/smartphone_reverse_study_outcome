package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f69209a = null;

    static {
        f69209a = new a();
    }

    public a() {
    }

    public static void a() {
        Pair r100 = TuplesKt.to(Integer.valueOf(s1.q(s1.getContext()).widthPixels), Integer.valueOf(s1.q(s1.getContext()).heightPixels));
        StringBuilder r101 = new StringBuilder();
        r101.append(((Number) r100.getFirst()).intValue());
        r101.append('*');
        r101.append(((Number) r100.getSecond()).intValue());
        String r102 = r101.toString();
        FeatureManager r103 = FeatureManager.f69275u;
        if (z90.a.C8431a.a(r103, "real_metrics", r102) == false) goto L6;
        int r104 = ((Number) r100.getFirst()).intValue();
        int r105 = ((Number) r100.getSecond()).intValue();
        z90.a.C8431a.a(r103, "real_metrics_width", Integer.valueOf(r104));
        z90.a.C8431a.a(r103, "real_metrics_height", Integer.valueOf(r105));
        int r106 = Math.max(r104, r105);
        int r107 = Math.min(r104, r105);
        z90.a.C8431a.a(r103, "real_metrics_long", Integer.valueOf(r106));
        z90.a.C8431a.a(r103, "real_metrics_short", Integer.valueOf(r107));
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
