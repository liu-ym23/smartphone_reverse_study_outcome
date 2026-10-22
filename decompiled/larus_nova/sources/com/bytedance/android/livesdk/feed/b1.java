package com.bytedance.android.livesdk.feed;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f123620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f123621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f123622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f123623d;

    public final int hashCode() {
        int r100 = 1;
        Object[] r101 = {Boolean.valueOf(this.f123620a), this.f123621b, Integer.valueOf(this.f123622c), Integer.valueOf(this.f123623d)};
        int r102 = 0;
    L3:
        if (r102 >= 4) goto L9;
        Object r103 = r101[r102];
        int r104 = r100 * 31;
        if (r103 != null) goto L7;
        int r105 = 0;
    L8:
        r100 = r104 + r105;
        r102 = r102 + 1;
        goto L3
    L7:
        r105 = r103.hashCode();
        goto L8
    L9:
        return r100;
    }

    public b1() {
        this.f123620a = false;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (b1.class != r100.getClass()) goto L21;
        b1 r101 = (b1) r100;
        if (this.f123620a == r101.f123620a) goto L13;
    L19:
        return false;
    L13:
        if (this.f123622c != r101.f123622c) goto L19;
        if (this.f123623d != r101.f123623d) goto L19;
        if (TextUtils.equals(this.f123621b, r101.f123621b) == false) goto L19;
        return true;
    }
}
