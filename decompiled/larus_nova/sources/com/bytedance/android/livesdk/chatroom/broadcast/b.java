package com.bytedance.android.livesdk.chatroom.broadcast;

import android.view.MotionEvent;
import com.bytedance.android.livesdk.config.zc;
import com.bytedance.android.livesdk.utils.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f105280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f105281b;

    public b() {
        this.f105280a = Float.MIN_VALUE;
        this.f105281b = Float.MIN_VALUE;
    }

    public final void a(MotionEvent r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "panel");
        int r102 = r100.getAction();
        if (r102 == 0) goto L29;
        boolean r103 = true;
        if (r102 == 1) goto L8;
        return;
    L8:
        if (this.f105280a != Float.MIN_VALUE) goto L10;
        return;
    L10:
        if (this.f105281b != Float.MIN_VALUE) goto L13;
        return;
    L13:
        if (r100.getX() >= this.f105280a) goto L15;
        boolean r104 = true;
    L17:
        if (r100.getX() > this.f105280a) goto L20;
        r103 = false;
    L20:
        float r105 = Math.abs(r100.getX() - this.f105280a);
        int r106 = p.f159110a;
        int r107 = zc.f121751a.getValue().intValue();
        if (r104 == true) goto L23;
    L25:
        if (r103 == true) goto L27;
        return;
    L27:
        if (r105 <= r107) goto L34;
        r101.b();
        this.f105280a = Float.MIN_VALUE;
        this.f105281b = Float.MIN_VALUE;
        return;
    L34:
        return;
    L23:
        if (r105 <= r107) goto L25;
        r101.a();
        this.f105280a = Float.MIN_VALUE;
        this.f105281b = Float.MIN_VALUE;
        return;
    L15:
        r104 = false;
        goto L17
    L29:
        this.f105280a = r100.getX();
        this.f105281b = r100.getY();
    }
}
