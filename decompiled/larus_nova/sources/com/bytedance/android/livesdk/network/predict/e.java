package com.bytedance.android.livesdk.network.predict;

import com.bytedance.android.livesdk.config.oc0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f154030a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f154031b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f154032c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d f154033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<d> f154034e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f154035f = null;

    public e() {
    }

    public static boolean a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L17
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L17
        Iterator r102 = ((ArrayList) f154034e).iterator();     // Catch: Throwable -> L17
        int r103 = 0;
    L24:
    L15:
        th = th;
    L19:
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        if (r103 < f154032c) goto L35;
        return true;
    L35:
        return false;
    L6:
        if (r102.hasNext() == false) goto L13;
        d r105 = (d) r102.next();     // Catch: Throwable -> L15
        long r106 = System.currentTimeMillis() - r105.f154026a;     // Catch: Throwable -> L15
        if (r106 >= f154031b) goto L12;
        if (r106 <= 0) goto L12;
        r103 = r103 + 1;     // Catch: Throwable -> L15
    L12:
        r101.add(r105);     // Catch: Throwable -> L15
        goto L24
    L13:
        Result.m9449constructorimpl(Boolean.valueOf(((ArrayList) f154034e).removeAll(r101)));     // Catch: Throwable -> L15
    L17:
        th = th;
        r103 = 0;
        goto L19
    }

    static {
        f154035f = new e();
        oc0 r100 = oc0.f120893a;
        f154030a = r100.getValue().p();
        f154031b = r100.getValue().o();
        f154032c = r100.getValue().b();
        f154034e = new ArrayList();
    }
}
