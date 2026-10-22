package com.bytedance.android.shopping.new_cart.yata.abilities;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yj.h;

/* JADX INFO: loaded from: classes13.dex */
public final class CartYataLogImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f179583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f179584b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f179585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f179586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f179587c;

        public a(h r100, int r101, String r102, Function0 r103) {
            this.f179585a = r100;
            this.f179586b = r102;
            this.f179587c = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f179585a.log(this.f179586b, (String) this.f179587c.invoke());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public CartYataLogImpl() {
        this.f179583a = LazyKt.lazy(CartYataLogImpl$hostALogService$2.INSTANCE);
        this.f179584b = LazyKt.lazy(CartYataLogImpl$isDebugOrLocalTest$2.INSTANCE);
    }

    public final void a(int r100, String r101, Function0<String> r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "message");
        if (((Boolean) this.f179584b.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        h r103 = (h) this.f179583a.getValue();
        if (r103 != null) goto L8;
        return;
    L8:
        com.bytedance.android.ec.hybrid.card.util.a.a(new a(r103, r100, r101, r102));
    }
}
