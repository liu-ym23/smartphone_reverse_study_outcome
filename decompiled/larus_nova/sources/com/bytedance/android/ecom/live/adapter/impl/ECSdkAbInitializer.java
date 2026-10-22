package com.bytedance.android.ecom.live.adapter.impl;

import android.app.Application;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.dataplatform.s;
import com.bytedance.dataplatform.t;
import com.bytedance.dataplatform.u;
import com.bytedance.dataplatform.w;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Url;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECSdkAbInitializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f51170a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bc\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ecom/live/adapter/impl/ECSdkAbInitializer$ABApi;", "", "doGet", "Lcom/bytedance/retrofit2/Call;", "", "url", "ec-live-adapter_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ABApi {
        @GET("")
        Call<String> doGet(@Url String r100);
    }

    public static final class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Gson f51171a;

        public a(Gson r100) {
            this.f51171a = r100;
        }

        @Override // com.bytedance.dataplatform.u
        public final <T> T a(String r100, Type r101) {
            Intrinsics.checkNotNullParameter(r100, "input");
            Intrinsics.checkNotNullParameter(r101, "clazz");
            return (T) GsonProtectorUtils.fromJson(this.f51171a, r100, r101);
        }
    }

    public static final class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f51172a = null;

        static {
            f51172a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.dataplatform.s
        public final void a(String r100) {
            com.bytedance.android.ec.sdk.helper.g.f48122a.a(r100);
        }
    }

    public static final class c implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f51173a = null;

        static {
            f51173a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.dataplatform.t
        public final String a(String r100) {
            return ((ABApi) com.bytedance.android.ec.sdk.helper.n.f48128a.create("https://abtest-ch.snssdk.com/", ABApi.class)).doGet(com.bytedance.android.ec.sdk.helper.g.f48122a.addCommonParams(r100)).execute().body();
        L4:
            e = move-exception;
            ECExceptionMonitor.f(e, "ab net fail");
            System.out.println("ab test net error: " + e);
            return null;
        }
    }

    static {
        f51170a = "";
    }

    public static void a(Application r100) {
        com.bytedance.dataplatform.o.a(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("ecomterm_sdk_version", String.valueOf(44700))}));
        Gson r101 = new Gson();
        Application r102 = (Application) ECAppInfoService.f48114e.getApplicationContext();
        if (r100 != null) goto L6;
        r100 = r102;
    L6:
        dm.a.a("ec init absdk").i("use " + r100 + " init absdk");
        a r103 = new a(r101);
        if (com.bytedance.dataplatform.o.f204347f == true) goto L19;
        Object r104 = com.bytedance.dataplatform.o.f204350i;
        monitor-enter(r104);
    L16:
        th = move-exception;
        throw th;
    L11:
        if (com.bytedance.dataplatform.o.f204347f == true) goto L13;
        com.bytedance.dataplatform.o.f204345d = w.a(new com.bytedance.dataplatform.m(r100, r103));     // Catch: Throwable -> L16
        com.bytedance.dataplatform.o.f204347f = true;     // Catch: Throwable -> L16
    L13:
        r104.notifyAll();     // Catch: Throwable -> L16
        monitor-exit(r104);     // Catch: Throwable -> L16
        return;
    }

    public static void b(boolean r100) {
        System.out.println("Django: ===> updateUid");
        String r101 = String.valueOf(r.f48132a.a());
        com.bytedance.dataplatform.o.g(r101);
        if ((!Intrinsics.areEqual(r101, "0")) == true) goto L5;
        return;
    L5:
        if ((!Intrinsics.areEqual(r101, f51170a)) == false) goto L11;
        f51170a = r101;
        if (r100 == true) goto L12;
        System.out.println("Django: ===> ExperimentManager.refresh()");
        com.bytedance.dataplatform.o.b();
        com.bytedance.dataplatform.o.f204343b.c(null);
        return;
    L12:
        return;
    }
}
