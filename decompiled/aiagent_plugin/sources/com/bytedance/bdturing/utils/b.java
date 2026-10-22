package com.bytedance.bdturing.utils;

import android.app.Activity;
import d.h.b.o;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ContextHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Activity> f6632a;

    public final void a(WeakReference<Activity> r2) {
        o.d(r2, "<set-?>");
        this.f6632a = r2;
    }
}
