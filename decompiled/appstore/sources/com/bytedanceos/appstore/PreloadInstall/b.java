package com.bytedanceos.appstore.PreloadInstall;

import androidx.appcompat.widget.p;
import com.bytedanceos.common.toolbox.j;
import retrofit2.Response;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f8267b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0107b f8268a;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.bytedanceos.appstore.PreloadInstall.b$b, reason: collision with other inner class name */
    public class C0107b extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f8269a;

        public C0107b(b r10) {
            this.f8269a = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            j.e("sync preload app error: " + r10.getMessage());
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((Response) r10);
        }

        public /* synthetic */ C0107b(b r10, a r11) {
            this(r10);
        }

        public void onNext(Response r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.a() == null) goto L9;
            p.a(r10.a());
            return;
        }
    }

    static {
    }

    public b() {
    }

    public static b a() {
        if (f8267b != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f8267b != null) goto L11;
        f8267b = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f8267b;
    }

    public static com.bytedanceos.appstore.PreloadInstall.a b() {
        return null;
    }

    public void c() {
        C0107b r10 = this.f8268a;
        if (r10 == null) goto L5;
        r10.unsubscribe();
    L5:
        this.f8268a = new C0107b(this, null);
        c.c().a(this.f8268a);
    }
}
