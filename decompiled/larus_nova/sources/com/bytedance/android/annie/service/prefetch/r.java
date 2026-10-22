package com.bytedance.android.annie.service.prefetch;

import com.bytedance.android.annie.Annie;
import com.ss.android.lark.inv.export.router.InvRouter;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes43.dex */
public final class r implements o {

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f39977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f39978b;

        public a(n r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "loader");
            Intrinsics.checkNotNullParameter(r101, "channel");
            this.f39977a = r100;
            this.f39978b = r101;
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f39979a;

        public b(r r100) {
            this.f39979a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            n r101 = (n) r100;
            Intrinsics.checkNotNullParameter(r101, "loader");
            return Observable.fromIterable(((com.bytedance.android.annie.service.resource.f) Annie.getService$default(com.bytedance.android.annie.service.resource.f.class, null, 2, null)).r()).map(new s(this.f39979a, r101));
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f39980a;

        public c(r r100) {
            this.f39980a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "channelLoader");
            n r102 = r101.f39977a;
            String r103 = r101.f39978b;
            this.f39980a.getClass();
            InputStream r104 = r102.a("prefetch." + r103 + InvRouter.FLOW_SUFFIX, r103);
            if (r104 == null) goto L18;
            Reader r105 = new InputStreamReader(r104, Charsets.UTF_8);
            if ((r105 instanceof BufferedReader) == false) goto L7;
            BufferedReader r106 = (BufferedReader) r105;
        L21:
            String r107 = TextStreamsKt.readText(r106);     // Catch: Throwable -> L12
            CloseableKt.closeFinally(r106, null);
            if (r107 == null) goto L18;
            return new o.a(r103, r107);
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            CloseableKt.closeFinally(r106, th);
            throw th;
        L7:
            r106 = new BufferedReader(r105, 8192);
        L18:
            return o.a.f39971c;
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T, R> f39981a = null;

        static {
            f39981a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Throwable) r100, "it");
            return o.a.f39971c;
        }
    }

    public static final class e<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f39982a = null;

        static {
            f39982a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            o.a r101 = (o.a) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101 == o.a.f39971c) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public r() {
    }

    @Override // com.bytedance.android.annie.service.prefetch.o
    public final Observable<o.a> getConfig() {
        return Observable.fromIterable(((p) Annie.getService$default(p.class, null, 2, null)).o()).flatMap(new b(this)).subscribeOn(Schedulers.io()).map(new c(this)).onErrorReturn(d.f39981a).filter(e.f39982a);
    }
}
