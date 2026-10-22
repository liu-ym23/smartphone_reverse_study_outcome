package androidx.constraintlayout.motion.utils;

import android.view.View;

/* JADX INFO: compiled from: ViewState.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f835e;

    public d() {
    }

    public void a(View r2) {
        this.f832b = r2.getLeft();
        this.f833c = r2.getTop();
        this.f834d = r2.getRight();
        this.f835e = r2.getBottom();
        this.f831a = r2.getRotation();
    }

    public int a() {
        return this.f834d - this.f832b;
    }

    public int b() {
        return this.f835e - this.f833c;
    }
}
