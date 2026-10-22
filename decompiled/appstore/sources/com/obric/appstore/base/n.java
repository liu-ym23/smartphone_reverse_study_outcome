package com.obric.appstore.base;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public class n extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10584e;

    public /* synthetic */ n(boolean r10, int r11, int r12, boolean r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = false;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r11 = 1;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r12 = 20;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r13 = false;
    L15:
        if ((r15 & 16) == 0) goto L17;
        r14 = false;
    L17:
        this(r10, r11, r12, r13, r14);
    }

    public final boolean c() {
        return this.f10582c;
    }

    public final int d() {
        return this.f10583d;
    }

    public n(boolean r10, int r11, int r12, boolean r13, boolean r14) {
        super(r13, r14);
        this.f10582c = r10;
        this.f10583d = r11;
        this.f10584e = r12;
    }
}
