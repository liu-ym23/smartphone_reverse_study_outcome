package com.bytedance.android.livesdk.behavior;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.bytedance.android.ec.slice.SliceInitService;
import com.google.gson.Gson;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pair<Float, Float> f104276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f104277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f104278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f104279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, String> f104280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f104281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final VelocityTracker f104282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String[] f104283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f104284i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f104285j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f104286k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f104287l;

    public final String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(new Gson().toJson(this.f104280e));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L15;
        return SliceInitService.DEFAULT_SWITCH;
    L15:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void a(int r100) {
        this.f104280e.put("respond", String.valueOf(r100));
        this.f104280e.put("actionDuration", String.valueOf(System.currentTimeMillis() - this.f104281f));
    }

    public final void b(float r100, float r101, int r102) {
        this.f104284i = true;
        if (r102 != 1) goto L6;
        String[] r103 = this.f104283h;
        StringBuilder r104 = new StringBuilder();
        r104.append(this.f104276a.getFirst().floatValue());
        r104.append(';');
        r104.append(this.f104276a.getSecond().floatValue());
        r104.append(':');
        r103[0] = r104.toString();
    L6:
        if (r102 >= 3) goto L9;
        String[] r105 = this.f104283h;
        StringBuilder r106 = new StringBuilder();
        r106.append(r100);
        r106.append(';');
        r106.append(r101);
        r106.append(':');
        r105[r102] = r106.toString();
        return;
    }

    public final void c(float r100, float r101, int r102) {
        if (r102 >= 3) goto L6;
        this.f104283h[r102] = this.f104283h[r102] + r100 + ';' + r101;
        return;
    }

    public a(MotionEvent r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        this.f104285j = r102;
        this.f104286k = r103;
        this.f104287l = r104;
        this.f104276a = new Pair(Float.valueOf(r100.getX()), Float.valueOf(r100.getY()));
        this.f104277b = r100.getX();
        this.f104278c = r100.getY();
        this.f104279d = -1;
        this.f104280e = new HashMap();
        this.f104281f = System.currentTimeMillis();
        this.f104282g = VelocityTracker.obtain();
        String[] r105 = new String[3];
        int r106 = 0;
    L3:
        if (r106 >= 3) goto L5;
        r105[r106] = "";
        r106 = r106 + 1;
        goto L3
    L5:
        this.f104283h = r105;
        this.f104282g.addMovement(r100);
        this.f104280e.put("respond", "1");
        this.f104280e.put("timestamp", String.valueOf(this.f104281f));
        this.f104280e.put("respond", "1");
        HashMap<String, String> r107 = this.f104280e;
        StringBuilder r108 = new StringBuilder();
        r108.append(r100.getX());
        r108.append(';');
        r108.append(r100.getY());
        r107.put("downEv", r108.toString());
        if (this.f104286k > 3) goto L8;
    L20:
        this.f104280e.put("downArea", "0");
        return;
    L8:
        if (this.f104287l <= 6) goto L20;
        if (r100.getX() >= this.f104286k) goto L20;
        float r109 = r100.getY();
        int r110 = this.f104287l;
        if (r109 >= r110) goto L20;
        int r111 = ((((int) (r100.getY() / (r110 / 6))) * 3) + ((int) (r100.getX() / (this.f104286k / 3)))) + 1;
        if (1 <= r111) goto L17;
    L19:
        this.f104280e.put("downArea", "0");
        return;
    L17:
        if (18 < r111) goto L19;
        this.f104280e.put("downArea", String.valueOf(r111));
    }
}
