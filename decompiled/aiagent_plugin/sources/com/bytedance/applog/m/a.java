package com.bytedance.applog.m;

import com.bytedance.applog.c;
import com.bytedance.keva.KevaImpl;
import java.util.Collections;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: BackoffController.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5725e;
    private int f;
    private final c g;
    private final com.bytedance.applog.j.b h;
    private long i;

    public a(c r4, com.bytedance.applog.j.b r5, long r6) {
        this.f5721a = 0;
        this.f5723c = 0;
        this.f5724d = 0;
        this.f5725e = 0;
        this.f = 0;
        this.g = r4;
        this.h = r5;
        this.i = r6;
    }

    public void a(JSONObject r5, long r6, com.bytedance.applog.priority.b r8) {
        this.i = r6;
        int r7 = r5.optInt("backoff_ratio", 0);
        this.f5721a = r7;
        if (r7 >= 0) goto L5;
    L6:
        this.f5721a = 0;
    L7:
        int r9 = r5.optInt("max_request_frequency", a(r8));
        this.f5722b = r9;
        if (r9 > 0) goto L10;
        this.f5722b = 12;
    L10:
        int r10 = this.f5721a;
        if (r10 > 0) goto L13;
    L15:
        if (r10 != 0) goto L17;
        this.f5723c = 0;
        this.f5724d = 0;
    L17:
        this.f5725e = r5.optInt("disable_session_start_request", 0);
        this.f = r5.optInt("disable_session_end_request", 0);
        if (this.f5721a != 0) goto L22;
        int r11 = this.f5722b;
        if (r11 <= 0) goto L22;
        this.h.a(r8, r11);
    L22:
        this.g.Z().b(Collections.singletonList("BackoffController"), "parseBackoffControllerFromResp mEventInterval: " + this.i + ", mBackoffRatio: " + this.f5721a + ", mMaxRequestFrequency: " + this.f5722b + ", mBackoffWindowStartTime: " + this.f5723c + ", mBackoffWindowSendCount: " + this.f5724d + ", mDisableSessionStartRequest: " + this.f5725e + ", mDisableSessionEndRequest: " + this.f, new Object[0]);
        return;
    L13:
        if (this.f5723c != 0) goto L15;
        this.f5723c = System.currentTimeMillis();
        this.f5724d = 1;
        goto L17
    L5:
        if (r7 <= 10000) goto L7;
        goto L6
    }

    public boolean a(int r11) {
        if (this.f5721a <= 0) goto L11;
        long r2 = System.currentTimeMillis();
        long r4 = this.f5723c;
        long r6 = this.i;
        if (r2 >= (r4 + r6)) goto L10;
        int r0 = this.f5724d;
        if (r0 < this.f5722b) goto L9;
        return true;
    L9:
        this.f5724d = r0 + 1;
        goto L11
    L10:
        this.f5723c = r4 + (((r2 - r4) / r6) * r6);
        this.f5724d = 1;
    L11:
        int r1 = this.f5721a;
        if (r1 < 10000) goto L14;
        return true;
    L14:
        if (r1 <= 0) goto L20;
        if (r1 >= 10000) goto L20;
        if (new Random().nextInt(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) >= this.f5721a) goto L20;
        return true;
    L20:
        if (this.f5725e <= 0) goto L23;
        if (1 != r11) goto L23;
    L26:
        return true;
    L23:
        if (this.f > 0) goto L25;
        return false;
    L25:
        if (3 == r11) goto L26;
        return false;
    }

    private int a(com.bytedance.applog.priority.b r2) {
        if (r2 != null) goto L4;
        return 12;
    L4:
        if ((-1) != r2.a()) goto L7;
        return 12;
    L7:
        if (r2.a() != 0) goto L10;
        return Integer.MAX_VALUE;
    L10:
        return 60;
    }
}
