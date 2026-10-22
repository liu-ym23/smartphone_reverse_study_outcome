package com.airbnb.lottie;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes28.dex */
public abstract class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<e> f24814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<b> f24815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<Context> f24816c;

    public m(e r100, b r101, Context r102) {
        this.f24814a = new WeakReference(r100);
        this.f24815b = new WeakReference(r101);
        this.f24816c = new WeakReference(r102);
    }
}
