package com.bytedance.android.ec.window.base.dynamicview.renderer;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import to.a;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<V extends View, VO extends to.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<V> f49263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<VO> f49264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f49265c;

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.renderer.a$a, reason: collision with other inner class name */
    public static final class C0844a {
    }

    static {
    }

    public abstract void b(V r100, VO r101);

    public abstract void c(V r100);

    public abstract VO d(String r100);

    public final VO a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        return (VO) uo.a.b(r100, this.f49264b);
    }

    public a(Class<V> r100, Class<VO> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "viewClazz");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "renderTargetType");
        this.f49263a = r100;
        this.f49264b = r101;
        this.f49265c = r102;
    }
}
