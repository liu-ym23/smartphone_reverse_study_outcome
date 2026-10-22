package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.model.h1;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public final class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f127460f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h1 f127461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f127462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f127463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f127464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f127465e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f127466a;

        public b(n r100) {
            this.f127466a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            n r102 = this.f127466a;
            long r103 = r102.f127462b + 1000;
            r102.f127462b = r103;
            int r104 = (((int) (r103 / ((long) 1000))) * 3) + 5;
            if (r104 <= 50) goto L8;
            Disposable r105 = r102.f127464d;
            if (r105 == null) goto L7;
            r105.dispose();
        L7:
            r104 = 50;
        L8:
            int r106 = 1000 / r104;
            Disposable r107 = r102.f127465e;
            if (r107 == null) goto L11;
            r107.dispose();
        L11:
            com.bytedance.android.live.core.utils.rxutils.j.a r108 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
            r102.f127465e = com.bytedance.android.live.core.utils.rxutils.j.a(0, r106, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(r102), s.f127481a, t.f127482a);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f127467a = null;

        static {
            f127467a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f127468a = null;

        static {
            f127468a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    static {
    }

    public n() {
    }

    public final void a() {
        this.f127461a = null;
        this.f127463c = 0;
        this.f127462b = 0;
        Disposable r100 = this.f127465e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f127464d;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public final void b(boolean r100) {
        if (r100 == true) goto L5;
        this.f127462b = 0;
    L5:
        Disposable r101 = this.f127464d;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        com.bytedance.android.live.core.utils.rxutils.j.a r102 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        this.f127464d = com.bytedance.android.live.core.utils.rxutils.j.a(0, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.f127467a, d.f127468a);
    }
}
