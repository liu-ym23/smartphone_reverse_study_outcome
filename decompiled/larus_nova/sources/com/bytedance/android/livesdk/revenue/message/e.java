package com.bytedance.android.livesdk.revenue.message;

import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public interface e<T> {

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f157181a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f157181a = r100;
        }
    }

    Observable<a<T>> a();
}
