package com.obric.oui.constraintlayout.motion.utils;

import android.view.View;

/* JADX INFO: compiled from: ViewState.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f34813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f34814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f34816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f34817e;

    public d() {
    }

    public void a(View r2) {
        this.f34814b = r2.getLeft();
        this.f34815c = r2.getTop();
        this.f34816d = r2.getRight();
        this.f34817e = r2.getBottom();
        this.f34813a = r2.getRotation();
    }

    public int a() {
        return this.f34816d - this.f34814b;
    }

    public int b() {
        return this.f34817e - this.f34815c;
    }
}
