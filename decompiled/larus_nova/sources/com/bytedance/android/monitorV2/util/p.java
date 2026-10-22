package com.bytedance.android.monitorV2.util;

import com.vivo.push.PushClientConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f163243a = 0;

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f163244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f163245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<?>[] f163246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Method f163247d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public WeakReference<Object> f163248e;

        public final Method a() {
            if (this.f163247d != null) goto L9;
            Class<T> r100 = this.f163244a;     // Catch: Throwable -> L6
            String r101 = this.f163245b;     // Catch: Throwable -> L6
            Class<?>[] r102 = this.f163246c;     // Catch: Throwable -> L6
            this.f163247d = r100.getDeclaredMethod(r101, (Class[]) Arrays.copyOf(r102, r102.length));     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            f.b(th);
        L9:
            return this.f163247d;
        }

        public final Object b(Object... r100) {
            Intrinsics.checkNotNullParameter(r100, "args");
            if (a() == null) goto L5;
            boolean r101 = true;
        L7:
            if ((!r101) == false) goto L20;
            return null;
        L20:
            Method r102 = a();     // Catch: Throwable -> L17
            if (r102 == null) goto L22;
            WeakReference<Object> r103 = this.f163248e;     // Catch: Throwable -> L17
            if (r103 == null) goto L14;
            Object r104 = r103.get();     // Catch: Throwable -> L17
        L15:
            return r102.invoke(r104, Arrays.copyOf(r100, r100.length));
        L14:
            r104 = null;
            goto L15
        L22:
            return null;
        L17:
            th = move-exception;
            f.b(th);
            return null;
        L5:
            r101 = false;
            goto L7
        }

        public a(Class<T> r100, String r101, Class<?>[] r102, Object r103) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            Intrinsics.checkNotNullParameter(r101, "methodName");
            Intrinsics.checkNotNullParameter(r102, PushClientConstants.TAG_PARAM_TYPES);
            this.f163244a = r100;
            this.f163245b = r101;
            this.f163246c = r102;
            this.f163248e = new WeakReference(r103);
        }
    }

    static {
    }
}
