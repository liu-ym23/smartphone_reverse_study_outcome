package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.internal.C1669j;

/* renamed from: com.google.android.gms.common.api.internal.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1641g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19621a;

    public C1641g(Activity activity) {
        C1669j.l(activity, "Activity must not be null");
        this.f19621a = activity;
    }

    public final Activity a() {
        return (Activity) this.f19621a;
    }

    public final androidx.fragment.app.r b() {
        return (androidx.fragment.app.r) this.f19621a;
    }

    public final boolean c() {
        return this.f19621a instanceof Activity;
    }

    public final boolean d() {
        return this.f19621a instanceof androidx.fragment.app.r;
    }
}
