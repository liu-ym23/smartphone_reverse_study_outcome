package com.bytedance.android.shopping.anchorv4.ai;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d0 implements g0 {

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f165652a = null;

        static {
            f165652a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.f
        public final void dispose() {
        }
    }

    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f165653a = null;

        static {
            f165653a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.ai.f
        public final void dispose() {
        }
    }

    public d0() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.g0
    public final f b(Function1<? super u, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        return a.f165652a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.g0
    public final f c(Function1 r100) {
        Intrinsics.checkNotNullParameter("ecom.pdp.add_cart", "eventName");
        Intrinsics.checkNotNullParameter(r100, "listener");
        return e0.f165656a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.ai.g0
    public final f a(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        return b.f165653a;
    }
}
