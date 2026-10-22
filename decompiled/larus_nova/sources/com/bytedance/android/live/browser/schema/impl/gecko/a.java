package com.bytedance.android.live.browser.schema.impl.gecko;

import com.bytedance.android.live.browser.schema.core.RedirectRuleCreator;
import com.bytedance.android.live.browser.schema.core.RedirectRuleSettingsHandler;
import com.bytedance.android.live.browser.webview.config.LiveHybridSettingKeys;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import com.bytedance.apm.constant.UploadTypeInf;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements com.bytedance.android.live.schema.api.c, la1.a.InterfaceC6666a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.bytedance.android.live.browser.schema.core.c f64226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f64227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f64228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f64229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.browser.schema.core.strategy.d f64230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f64231f;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.schema.impl.gecko.a$a, reason: collision with other inner class name */
    public static final class C1059a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f64232a;

        public b(a r100) {
            this.f64232a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.browser.schema.core.d r101 = (com.bytedance.android.live.browser.schema.core.d) r100;
            com.bytedance.android.live.schema.api.utils.a.d("GeckoCDNCacheInterceptor", "update from self");
            Object r102 = this.f64232a.f64227b;
            monitor-enter(r102);
            this.f64232a.f64231f.a(r101);     // Catch: Throwable -> L7
            a r103 = this.f64232a;     // Catch: Throwable -> L7
            int r104 = com.bytedance.android.live.browser.schema.core.c.f64200d;     // Catch: Throwable -> L7
            r103.f64226a = com.bytedance.android.live.browser.schema.core.c.b.b(r101, r103.f64230e);     // Catch: Throwable -> L7
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r102);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f64233a = null;

        static {
            f64233a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.schema.api.utils.a.b("GeckoCDNCacheInterceptor", "refresh gecko cache fail", (Throwable) r100);
        }
    }

    static {
    }

    @Override // la1.a.InterfaceC6666a
    public final boolean a() {
        return LiveHybridSettingKeys.LIVE_ROMA_SDK_POLL_CONFIG.getValue().booleanValue();
    }

    @Override // la1.a.InterfaceC6666a
    public final long d() {
        return LiveHybridSettingKeys.LIVE_ROMA_SDK_POLL_INTERNAL_CONFIG.getValue().longValue();
    }

    public final void e() {
        com.bytedance.android.live.schema.api.utils.a.a("GeckoCDNCacheInterceptor", "refresh cache");
        d r100 = this.f64229d;
        r100.getClass();
        Observable.create(new e(r100)).subscribeOn(Schedulers.io()).subscribe(new b(this), c.f64233a);
    }

    @Override // la1.a.InterfaceC6666a
    public final void b() {
        e();
    }

    public a(d r100, com.bytedance.android.live.browser.schema.core.strategy.d r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "geckoDataSource");
        Intrinsics.checkNotNullParameter(r101, "strategyRegister");
        Intrinsics.checkNotNullParameter(r102, "diskStorage");
        this.f64229d = r100;
        this.f64230e = r101;
        this.f64231f = r102;
        this.f64227b = new Object();
        Lazy r103 = LazyKt.lazy(GeckoCDNCacheInterceptor$cacheUpdater$2.INSTANCE);
        this.f64228c = r103;
        ((Subject) r103.getValue()).subscribe(new com.bytedance.android.live.browser.schema.impl.gecko.b(this), com.bytedance.android.live.browser.schema.impl.gecko.c.f64235a);
    }

    @Override // com.bytedance.android.live.schema.api.c
    public final void c(com.bytedance.android.live.schema.api.b r100, WebcastRedirectReportInfo r101, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r102, Function3<? super Integer, ? super String, ? super Boolean, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "reportInfo");
        Intrinsics.checkNotNullParameter(r102, "success");
        Intrinsics.checkNotNullParameter(r103, "fail");
        r101.a("schema_source", "api");
        Object r104 = this.f64227b;
        monitor-enter(r104);
        com.bytedance.android.live.browser.schema.core.c r105 = this.f64226a;     // Catch: Throwable -> L9
        com.bytedance.android.live.browser.schema.core.c r106 = null;
        if (r105 != null) goto L7;
        r105 = null;
    L12:
        if (r105 == null) goto L14;
        r101.a("get_type", "memory");     // Catch: Throwable -> L9
    L21:
        monitor-exit(r104);
        if (r105 == null) goto L32;
        String r107 = r105.f64201a.f64208b;
        if (r107 != null) goto L27;
        r107 = "";
    L27:
        r101.a("version", r107);
        com.bytedance.android.live.schema.api.a r108 = new RedirectRuleSettingsHandler(r105, r101).a(r100.f100495c);
        if (r108 == null) goto L30;
        r102.invoke(r108);
        return;
    L30:
        Unit r109 = r103.invoke(1001, "cache exists", Boolean.FALSE);
        return;
    L32:
        r101.a("rule_type", "-1");
        r103.invoke(1001, "cache not exists", Boolean.FALSE);
        return;
    L14:
        com.bytedance.android.live.browser.schema.core.d r110 = this.f64231f.restore();     // Catch: Throwable -> L9
        if (r110 == null) goto L17;
        int r111 = com.bytedance.android.live.browser.schema.core.c.f64200d;     // Catch: Throwable -> L9
        com.bytedance.android.live.browser.schema.core.strategy.d r112 = this.f64230e;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r110, "ruleSpec");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r112, "strategyRegister");     // Catch: Throwable -> L9
        r106 = new com.bytedance.android.live.browser.schema.core.c(r110, com.bytedance.android.live.browser.schema.core.c.a.C1057c.f64206b, new RedirectRuleCreator(r110, r112));     // Catch: Throwable -> L9
    L17:
        this.f64226a = r106;     // Catch: Throwable -> L9
        if (r106 == null) goto L20;
        r101.a("get_type", UploadTypeInf.DISK);     // Catch: Throwable -> L9
    L20:
        r105 = r106;
        goto L21
    L7:
        if (r105.f64202b.a() == false) goto L12;
        e();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
