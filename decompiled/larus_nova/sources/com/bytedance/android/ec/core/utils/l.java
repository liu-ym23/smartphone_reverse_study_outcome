package com.bytedance.android.ec.core.utils;

/* JADX INFO: loaded from: classes43.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f45629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45630b;

    public final String toString() {
        return new String(this.f45629a, 0, this.f45630b);
    }

    public l(int r100) {
        if (r100 < 0) goto L7;
        this.f45629a = new char[r100];
        return;
    L7:
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    public final void a(String r100) {
        if (r100 != null) goto L4;
        r100 = "null";
    L4:
        int r101 = r100.length();
        int r102 = this.f45630b + r101;
        char[] r103 = this.f45629a;
        if (r102 <= r103.length) goto L7;
        char[] r104 = new char[Math.max(r103.length << 1, r102)];
        System.arraycopy(this.f45629a, 0, r104, 0, this.f45630b);
        this.f45629a = r104;
    L7:
        r100.getChars(0, r101, this.f45629a, this.f45630b);
        this.f45630b = r102;
    }
}
