package com.google.android.material.appbar;

import K.S;
import android.view.View;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final View f10333a;

    /* renamed from: b, reason: collision with root package name */
    public int f10334b;

    /* renamed from: c, reason: collision with root package name */
    public int f10335c;

    /* renamed from: d, reason: collision with root package name */
    public int f10336d;

    /* renamed from: e, reason: collision with root package name */
    public int f10337e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10338f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10339g = true;

    public n(View view) {
        this.f10333a = view;
    }

    public final void a() {
        int i4 = this.f10336d;
        View view = this.f10333a;
        int top = i4 - (view.getTop() - this.f10334b);
        WeakHashMap weakHashMap = S.f939a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(this.f10337e - (view.getLeft() - this.f10335c));
    }
}
