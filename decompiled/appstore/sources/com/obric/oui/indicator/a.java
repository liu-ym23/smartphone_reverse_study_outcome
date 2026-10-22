package com.obric.oui.indicator;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15055b;

    public a(int r10, int r11) {
        this.f15054a = r10;
        this.f15055b = r11;
    }

    public final int a() {
        return this.f15055b;
    }

    public final int b() {
        return this.f15054a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f15054a == r11.f15054a) goto L12;
        return false;
    L12:
        if (this.f15055b == r11.f15055b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f15054a) * 31) + Integer.hashCode(this.f15055b);
    }

    public String toString() {
        return "DotSpacingSpec(startMargin=" + this.f15054a + ", endMargin=" + this.f15055b + ')';
    }
}
