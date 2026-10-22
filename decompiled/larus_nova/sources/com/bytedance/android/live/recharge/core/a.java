package com.bytedance.android.live.recharge.core;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import e33.k;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements o, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f89682a;

    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        cy0.e.f465759a.getClass();
        g r100 = new g(cy0.e.a.f465760a);
        Intrinsics.checkNotNullParameter(r100, "scope");
        Object r101 = k.f470908a;
        l.a(r100);
        Unit r102 = Unit.INSTANCE;
        this.f89682a = r100;
    }

    @Override // com.bytedance.android.live.recharge.core.d
    public final <T extends c> T a(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceTypeKey);
        m r101 = m.f163449e;
        g r102 = this.f89682a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_rechargeScope");
    L6:
        return (T) r101.d(r102, JvmClassMappingKt.getJavaClass(r100));
    }

    @Override // com.bytedance.android.live.recharge.core.d
    public final <T extends c> T f(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceTypeKey);
        m r101 = m.f163449e;
        g r102 = this.f89682a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_rechargeScope");
    L5:
        T r103 = (T) r101.d(r102, JvmClassMappingKt.getJavaClass(r100));
        if (r103 == null) goto L9;
        return r103;
    L9:
        throw new IllegalStateException(("Required service " + r100 + " not found").toString());
    }
}
