package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements com.bytedance.android.live.browser.jsbridge.g {

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f63803a = null;

        static {
            f63803a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            File r101 = (File) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return new PolarisFileWrapper(r101, "test.prefetch.json");
        }
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f63804a = null;

        static {
            f63804a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            File r101 = (File) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return r101.exists();
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f63805a = null;

        static {
            f63805a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            File r101 = (File) r100;
            Intrinsics.checkNotNullParameter(r101, "file");
            Reader r102 = new InputStreamReader(new PolarisFileInputStreamWrapper(r101), Charsets.UTF_8);
            if ((r102 instanceof BufferedReader) == false) goto L5;
            BufferedReader r103 = (BufferedReader) r102;
        L14:
            String r104 = TextStreamsKt.readText(r103);     // Catch: Throwable -> L9
            CloseableKt.closeFinally(r103, null);
            return new com.bytedance.android.live.browser.jsbridge.g.a(null, r104);
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r103, th);
            throw th;
        L5:
            r103 = new BufferedReader(r102, 8192);
            goto L14
        }
    }

    public i() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.g
    public final Observable<com.bytedance.android.live.browser.jsbridge.g.a> getConfig() {
        File r100 = ((IHostContext) jc1.k.n(IHostContext.class)).context().getExternalCacheDir();
        if (r100 == null) goto L12;
        if (v.a() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        Observable<com.bytedance.android.live.browser.jsbridge.g.a> r101 = Observable.just(r100).subscribeOn(Schedulers.io()).map(a.f63803a).filter(b.f63804a).map(c.f63805a);
        if (r101 == null) goto L12;
        return r101;
    L12:
        return Observable.empty();
    }
}
