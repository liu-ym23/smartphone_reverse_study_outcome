package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f189493c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f189494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> f189495b;

    public static final class a {
        public static f a(Class r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "transformer");
            return new f(r100, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r101, 1));
        }
    }

    static {
    }

    public f() {
        throw null;
    }

    public f(Class r100, Function1 r101) {
        this.f189494a = r100;
        this.f189495b = r101;
    }
}
