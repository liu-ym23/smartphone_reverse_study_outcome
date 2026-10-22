package com.bytedance.android.live.effect.common;

import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f67851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f67852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f67853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f67854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f67855e;

    public d() {
        this(false, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (this.f67851a == r101.f67851a) goto L8;
        return false;
    L8:
        if (this.f67852b == r101.f67852b) goto L10;
        return false;
    L10:
        if (this.f67853c == r101.f67853c) goto L12;
        return false;
    L12:
        if (this.f67854d == r101.f67854d) goto L14;
        return false;
    L14:
        if (this.f67855e == r101.f67855e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((((this.f67851a * 31) + this.f67852b) * 31) + this.f67853c) * 31;
        boolean r101 = this.f67854d;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f67855e;
        if (r105 == true) goto L10;
        r102 = r105;
    L10:
        return r104 + r102;
    }

    public final String toString() {
        return "AdjustBarStyleConfig(barColor=" + this.f67851a + ", bgColor=" + this.f67852b + ", circleColor=" + this.f67853c + ", enableTitle=" + this.f67854d + ", enableSingeAdjust=" + this.f67855e + ")";
    }

    public d(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        int r102 = s1.h(R.color.ttlive_effect_tool_bar_beauty_seek_bar_progress_color);
    L7:
        if ((r101 & 2) == 0) goto L9;
        int r103 = s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_bg_color);
    L11:
        if ((r101 & 4) == 0) goto L13;
        int r104 = s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_circle_color);
    L15:
        if ((r101 & 8) == 0) goto L17;
        r100 = false;
    L17:
        this.f67851a = r102;
        this.f67852b = r103;
        this.f67853c = r104;
        this.f67854d = r100;
        this.f67855e = false;
        return;
    L13:
        r104 = 0;
        goto L15
    L9:
        r103 = 0;
        goto L11
    L5:
        r102 = 0;
        goto L7
    }
}
