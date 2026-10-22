package com.bytedance.android.gamecp.common.network.networklib;

import androidx.core.app.NotificationCompat;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.client.Request;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class PbRequestCallAdapter<R, T> implements CallAdapter<R, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f56691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f56692d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f56693e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f56694f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CallAdapter<R, T> f56695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56696b;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static String a(Request r100) {
            return r100.getUrl() + ", " + r100.getMethod();
        }
    }

    static {
        f56694f = new a();
        f56691c = new b("");
        f56692d = new ConcurrentHashMap();
        f56693e = LazyKt.lazy(PbRequestCallAdapter$Companion$switches$2.INSTANCE);
    }

    @Override // com.bytedance.retrofit2.CallAdapter
    public final Type responseType() {
        return this.f56695a.responseType();
    }

    @Override // com.bytedance.retrofit2.CallAdapter
    public final T adapt(Call<R> r100) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Request r101 = r100.request();
        Map<String, String> r102 = f56692d;
        f56694f.getClass();
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(a.a(r101), this.f56696b);
        return this.f56695a.adapt(r100);
    }

    public PbRequestCallAdapter(CallAdapter<R, T> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "originAdapter");
        Intrinsics.checkNotNullParameter(r101, "switchType");
        this.f56695a = r100;
        this.f56696b = r101;
    }
}
