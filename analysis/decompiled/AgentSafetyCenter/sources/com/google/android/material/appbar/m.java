package com.google.android.material.appbar;

import android.view.View;
import java.util.WeakHashMap;
import n3.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public View f2375a;

    /* renamed from: b, reason: collision with root package name */
    public int f2376b;

    /* renamed from: c, reason: collision with root package name */
    public int f2377c;

    /* renamed from: d, reason: collision with root package name */
    public int f2378d;

    /* renamed from: e, reason: collision with root package name */
    public int f2379e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2380f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2381g;

    public final void a() {
        View view = this.f2375a;
        int top = this.f2378d - (view.getTop() - this.f2376b);
        WeakHashMap weakHashMap = k0.f8724a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(this.f2379e - (view.getLeft() - this.f2377c));
    }
}
