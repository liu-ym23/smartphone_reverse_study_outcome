package com.bytedance.android.gamecp.common.network.biz;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.gamecp.base.network.annotation.MonitorTimeCost;
import com.bytedance.android.gamecp.common.network.networklib.PbAnnotationCallAdapterFactory;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Request;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class MonitorTimeCostCallAdapterFactory extends CallAdapter.Factory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f56623b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f56624c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CallAdapter.Factory f56625a;

    public static final class a<R, T> implements CallAdapter<R, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CallAdapter<R, T> f56626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f56627b;

        @Override // com.bytedance.retrofit2.CallAdapter
        public final Type responseType() {
            return this.f56626a.responseType();
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public final T adapt(Call<R> r100) {
            Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
            Map<String, String> r101 = MonitorTimeCostCallAdapterFactory.f56623b;
            b r102 = MonitorTimeCostCallAdapterFactory.f56624c;
            Request r103 = r100.request();
            r102.getClass();
            ConcurrentHashMap r104 = (ConcurrentHashMap) r101;
            r104.put(b.a(r103), this.f56627b);
            return this.f56626a.adapt(r100);
        }

        public a(CallAdapter<R, T> r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "originalAdapter");
            Intrinsics.checkNotNullParameter(r101, "key");
            this.f56626a = r100;
            this.f56627b = r101;
        }
    }

    public static final class b {
        public b() {
        }

        public static String a(Request r100) {
            return r100.getUrl() + ", " + r100.getMethod();
        }
    }

    static {
        f56624c = new b();
        f56623b = new ConcurrentHashMap();
    }

    public MonitorTimeCostCallAdapterFactory(PbAnnotationCallAdapterFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFactory");
        this.f56625a = r100;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public final CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102) {
        Intrinsics.checkNotNullParameter(r100, "returnType");
        Intrinsics.checkNotNullParameter(r101, "annotations");
        Intrinsics.checkNotNullParameter(r102, "retrofit");
        Sequence r103 = SequencesKt.filter(ArraysKt.asSequence(r101), MonitorTimeCostCallAdapterFactory$get$$inlined$filterIsInstance$1.INSTANCE);
        if (r103 == null) goto L14;
        MonitorTimeCost r104 = (MonitorTimeCost) SequencesKt.firstOrNull(r103);
        if (r104 == null) goto L7;
        CallAdapter<?, ?> r105 = this.f56625a.get(r100, r101, r102);
        if (r105 != null) goto L15;
        return null;
    L15:
        return new a(r105, r104.key());
    L7:
        return this.f56625a.get(r100, r101, r102);
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }
}
