package com.bytedance.android.live.network;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.livesdkapi.network.MonitorCostCallConst;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class PbRequestCallAdapterV2<R, T> implements CallAdapter<R, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f83792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f83793d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f83794e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f83795f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CallAdapter<R, T> f83796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f83797b;

    public static final class a {
        public a() {
        }
    }

    static {
        f83795f = new a();
        f83792c = new d();
        f83793d = new ConcurrentHashMap();
        f83794e = LazyKt.lazy(PbRequestCallAdapterV2$Companion$switches$2.INSTANCE);
    }

    @Override // com.bytedance.retrofit2.CallAdapter
    public final Type responseType() {
        return this.f83796a.responseType();
    }

    @JvmStatic
    public static final boolean a(Request r100) {
        f83795f.getClass();
        Intrinsics.checkNotNullParameter(r100, "request");
        Header r101 = r100.getFirstHeader(MonitorCostCallConst.TAG);
        if (r101 == null) goto L7;
        String r102 = r101.getValue();
        if (r102 == null) goto L7;
    L8:
        String r103 = (String) ((ConcurrentHashMap) f83793d).remove(r102);
        if (r103 != null) goto L12;
        return false;
    L12:
        return ((JSONObject) f83794e.getValue()).optBoolean(r103, Intrinsics.areEqual(r103, "_global_switch"));
    L7:
        r102 = "";
        goto L8
    }

    @Override // com.bytedance.retrofit2.CallAdapter
    public final T adapt(Call<R> r100) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Request r101 = r100.request();
        Map<String, String> r102 = f83793d;
        f83795f.getClass();
        ((ConcurrentHashMap) r102).put(r101.getUrl() + ", " + r101.getMethod(), this.f83797b);
        return this.f83796a.adapt(r100);
    }

    public PbRequestCallAdapterV2(CallAdapter<R, T> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "originAdapter");
        Intrinsics.checkNotNullParameter(r101, "switchType");
        this.f83796a = r100;
        this.f83797b = r101;
    }
}
