package com.bytedance.android.shopping.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f187070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f187071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f187072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f187073d;

    public interface a {
        void onPageTranslucent();

        void onPageTranslucentError();
    }

    public static final class b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f187074a;

        public b(com.bytedance.android.shopping.anchorv4.containers.l r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f187074a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            Intrinsics.checkNotNullParameter(r100, "proxy");
            Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
            Intrinsics.checkNotNullParameter(r102, "args");
            Object r103 = r102[0];     // Catch: Throwable -> L11
            if (r103 == null) goto L10;
            if (((Boolean) r103).booleanValue() == false) goto L8;
            int r104 = z.f187162a;     // Catch: Throwable -> L11
            z.b("onPageTranslucent", null, null);     // Catch: Throwable -> L11
            this.f187074a.onPageTranslucent();     // Catch: Throwable -> L11
        L13:
            return null;
        L8:
            int r105 = z.f187162a;     // Catch: Throwable -> L11
            z.b("onPageTranslucentError", null, null);     // Catch: Throwable -> L11
            this.f187074a.onPageTranslucentError();     // Catch: Throwable -> L11
            goto L13
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            int r106 = z.f187162a;
            z.a("TranslucentConversionHandler error ", th, "PdpTranslucentUtil");
            a r107 = this.f187074a;
            th.getMessage();
            r107.onPageTranslucentError();
            goto L13
        }
    }

    static {
    }
}
