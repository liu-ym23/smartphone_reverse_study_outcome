package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.utils.z1;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f60726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f60727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f60728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile JSONArray f60729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f60730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ z1 f60731f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f60732a = null;

        static {
            f60732a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.performance.c$c, reason: collision with other inner class name */
    public static final class C0999c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0999c f60733a = null;

        static {
            f60733a = new C0999c();
        }

        public C0999c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if ((r101 instanceof CustomApiServerException) == false) goto L8;
            CustomApiServerException r102 = (CustomApiServerException) r101;
            if (r102.getErrorCode() != 4014051) goto L7;
            f2.c("数据异常，未产生报告", 0);
        L9:
            ALogger.d("OpenPlatformPerfReporter", "/task/finish/ error: " + r101.getMessage());
            return;
        L7:
            f2.c(r102.getPrompt(), 0);
            goto L9
        L8:
            f2.c("请求失败，可尝试在开发者平台停止", 0);
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.utils.z1
    public final void V1(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f60731f.V1(r100);
    }

    public final void a() {
        boolean r100 = false;
        if (this.f60726a.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
    L14:
        ALogger.d("OpenPlatformPerfReporter", "appId: " + this.f60726a + " or taskId: " + this.f60727b + " is empty!!");
        return;
    L8:
        if (this.f60727b.length() != 0) goto L10;
        r100 = true;
    L10:
        if (r100 == true) goto L14;
        Lazy r102 = LiveOpenGameClient.f60290d;
        V1(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).submitPerfTestTask(this.f60726a, this.f60730e, this.f60727b).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(b.f60732a, C0999c.f60733a));
        return;
    L5:
        r101 = false;
        goto L6
    }

    public c(OpenPlatformPerfRuntime r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "disposer");
        this.f60731f = r100;
        this.f60730e = r101;
        this.f60726a = "";
        this.f60727b = "";
        this.f60728c = "";
        this.f60729d = new JSONArray();
    }
}
