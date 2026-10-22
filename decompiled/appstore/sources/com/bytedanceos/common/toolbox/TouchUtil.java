package com.bytedanceos.common.toolbox;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public class TouchUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TouchListener f9983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f9984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9985d;

    public interface TouchListener {
        void onTouch();
    }

    public TouchUtil() {
        this.f9982a = 0;
        this.f9983b = null;
        this.f9984c = 0;
        this.f9985d = 0;
    }

    public void a(TouchListener r10) {
        this.f9982a = 5;
        this.f9983b = r10;
    }

    public void b() {
        if (this.f9982a >= 1) goto L5;
        return;
    L5:
        long r10 = SystemClock.elapsedRealtime();
        long r11 = this.f9984c;
        if ((r10 - r11) >= 1000) goto L14;
        int r12 = this.f9985d + 1;
        this.f9985d = r12;
        if (r12 <= (this.f9982a - 1)) goto L17;
        TouchListener r13 = this.f9983b;
        if (r13 == null) goto L12;
        r13.onTouch();
    L12:
        this.f9985d = 0;
        this.f9984c = 0;
    L17:
        this.f9984c = r10;
        return;
    L14:
        if (r11 != 0) goto L16;
        this.f9985d++;
        goto L17
    L16:
        this.f9985d = 1;
        goto L17
    }
}
