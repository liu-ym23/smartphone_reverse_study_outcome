package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f144250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f144251b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f144250a == r101.f144250a) goto L8;
        return false;
    L8:
        if (this.f144251b == r101.f144251b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f144250a * 31) + this.f144251b;
    }

    public final String toString() {
        return "PauseResumeIcons(pauseIcon=" + this.f144250a + ", resumeIcon=" + this.f144251b + ")";
    }

    public /* synthetic */ a(int r100) {
        this(R.drawable.ttlive_ktv_component_top_bar_pause_ic, R.drawable.ttlive_ktv_component_top_bar_start_ic);
    }

    public a(int r100, int r101) {
        this.f144250a = r100;
        this.f144251b = r101;
    }
}
