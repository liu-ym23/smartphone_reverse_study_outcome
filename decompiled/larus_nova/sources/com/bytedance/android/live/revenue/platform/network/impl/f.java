package com.bytedance.android.live.revenue.platform.network.impl;

import am3.g;
import am3.h;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.i;
import com.bytedance.android.scope.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.network.a f91564a;

    public static final class a<T> implements am3.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f91565a;

        public a(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f91565a = r100;
        }

        @Override // am3.c
        public final T decode(g r100) {
            Intrinsics.checkNotNullParameter(r100, "reader");
            long r101 = r100.c();
        L4:
            if (r100.f() == (-1)) goto L5;
            h.e(r100);
            goto L4
        L5:
            r100.d(r101);
            Class<T> r102 = this.f91565a;
            if (Intrinsics.areEqual(r102, Unit.class) == false) goto L9;
            return (T) Unit.INSTANCE;
        L9:
            if (Intrinsics.areEqual(r102, Object.class) == false) goto L12;
            return (T) new Object();
        L12:
            return r102.newInstance();
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public f(com.bytedance.android.livesdk.revenue.service.network.a r100) {
        Intrinsics.checkNotNullParameter(r100, "networkService");
        this.f91564a = r100;
    }

    public final <T> T a(g r100, Class<T> r101) {
        if (Intrinsics.areEqual(r101, Object.class) == false) goto L6;
        am3.c<T> r102 = new a(Object.class);
    L10:
        return r102.decode(r100);
    L6:
        if (Intrinsics.areEqual(r101, Unit.class) == false) goto L8;
        r102 = new a(Unit.class);
        goto L10
    L8:
        r102 = this.f91564a.getProtoDecoder(r101);
        goto L10
    }

    public final <T extends Extra> T c(Extra r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r101, "extraType");
        if ((r100 instanceof i) == false) goto L13;
        i r102 = (i) r100;
        byte[] r103 = r102.f58837a;
        if (r103 == null) goto L13;
        if (r103.length != 0) goto L9;
        boolean r104 = true;
    L11:
        if ((!r104) != true) goto L13;
        g r105 = new g();
        r105.k(new am3.b(r102.f58837a));
        T r106 = (T) a(r105, r101);
    L14:
        r106.now = r100.now;
        r106.hasMore = r100.hasMore;
        return r106;
    L9:
        r104 = false;
    L13:
        r106 = r101.newInstance();
        goto L14
    }
}
