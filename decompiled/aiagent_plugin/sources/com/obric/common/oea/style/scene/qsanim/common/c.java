package com.obric.common.oea.style.scene.qsanim.common;

import android.animation.Animator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PropertyAnimUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "PropertyAnimUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CubicEaseOutInterpolator f32565b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Animator> f32566c = null;

    static {
        f32564a = new c();
        f32565b = new CubicEaseOutInterpolator();
        f32566c = new ConcurrentHashMap();
    }

    private c() {
    }

    public static final /* synthetic */ ConcurrentHashMap a(c r0) {
        return f32566c;
    }
}
