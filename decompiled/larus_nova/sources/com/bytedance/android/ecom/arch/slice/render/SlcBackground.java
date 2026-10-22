package com.bytedance.android.ecom.arch.slice.render;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcBackground {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f50088d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f50089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f50090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f50091c;

    static {
        f50088d = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcBackground.class), "colorInt", "getColorInt()I"))};
    }

    public SlcBackground() {
        this(null, null);
    }

    public SlcBackground(String r100, String r101) {
        this.f50090b = r100;
        this.f50091c = r101;
        this.f50089a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SlcBackground$colorInt$2(this));
    }
}
