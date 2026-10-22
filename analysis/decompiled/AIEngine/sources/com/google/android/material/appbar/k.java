package com.google.android.material.appbar;

import android.view.View;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final View f4601a;

    /* renamed from: b, reason: collision with root package name */
    public int f4602b;

    /* renamed from: c, reason: collision with root package name */
    public int f4603c;

    /* renamed from: d, reason: collision with root package name */
    public int f4604d;

    /* renamed from: e, reason: collision with root package name */
    public int f4605e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4606f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4607g = true;

    public k(View view) {
        this.f4601a = view;
    }

    public final void a() {
        int i10 = this.f4604d;
        View view = this.f4601a;
        int top = i10 - (view.getTop() - this.f4602b);
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(this.f4605e - (view.getLeft() - this.f4603c));
    }
}
