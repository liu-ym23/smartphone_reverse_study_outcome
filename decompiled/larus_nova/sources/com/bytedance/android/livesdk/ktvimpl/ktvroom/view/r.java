package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes10.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile float f145259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile float f145260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile float f145261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile float f145262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile float f145263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile float f145264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f145265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f145266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f145267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Matrix f145268j;

    public final void a() {
        this.f145259a = 1.0f;
        this.f145260b = 1.0f;
        this.f145261c = 1.0f;
        this.f145264f = 0.0f;
        this.f145262d = 0.0f;
        this.f145263e = 0.0f;
        this.f145265g = false;
    }

    public r() {
        this.f145259a = 1.0f;
        this.f145260b = 1.0f;
        this.f145261c = 1.0f;
        this.f145266h = new RectF();
        this.f145267i = new RectF();
        this.f145268j = new Matrix();
    }
}
