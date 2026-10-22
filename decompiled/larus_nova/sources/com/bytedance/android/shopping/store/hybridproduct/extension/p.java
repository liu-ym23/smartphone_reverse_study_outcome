package com.bytedance.android.shopping.store.hybridproduct.extension;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f185021c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f185022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Object, String, d> f185023b;

    public static final class a {
        public static p a(Class r100, Function2 r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "transformer");
            return new p(r100, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r101, 2));
        }
    }

    static {
    }

    public p() {
        throw null;
    }

    public p(Class r100, Function2 r101) {
        this.f185022a = r100;
        this.f185023b = r101;
    }
}
