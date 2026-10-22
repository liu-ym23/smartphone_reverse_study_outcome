package com.bytedance.android.annie.monitor.common.performance;

import com.bytedance.android.annie.ng.g;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    public static final class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f39615a;

        public a(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f39615a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Object call() {
            return this.f39615a.invoke();
        }
    }

    public static final String a(String r100) {
        if (g.f39675g == true) goto L5;
        return r100;
    L5:
        if (g.b().f39657a.f522322a == false) goto L11;
        String r101 = UriProtector.parse(r100).getPath();
        if (r101 != null) goto L12;
        return "";
    L12:
        return r101;
    L11:
        return r100;
    }
}
