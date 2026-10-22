package com.bytedance.android.scope;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f163452a;

    public p(j r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f163452a = r100;
    }

    public final <T> T a(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        m r101 = m.f163449e;
        j r102 = this.f163452a;
        r101.getClass();
        com.bytedance.android.scope.tree.d r103 = m.c(r102);
        if (r103 != null) goto L7;
        return null;
    L7:
        return (T) r103.b(r100);
    }

    public final <T> T b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "typeId");
        Intrinsics.checkNotNullParameter(r100, "typeId");
        KClass<T> r101 = JvmClassMappingKt.getKotlinClass(r100);
        if (r101 != null) goto L10;
        Intrinsics.checkNotNullParameter(r100, "key");
        m r102 = m.f163449e;
        j r103 = this.f163452a;
        r102.getClass();
        com.bytedance.android.scope.tree.d r104 = m.c(r103);
        if (r104 != null) goto L11;
        return null;
    L11:
        return (T) r104.d(r100);
    L10:
        return (T) a(r101);
    }
}
