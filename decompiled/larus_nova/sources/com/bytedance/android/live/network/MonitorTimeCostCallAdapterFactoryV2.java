package com.bytedance.android.live.network;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.live.network.annotation.MonitorTimeCost;
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

/* JADX INFO: loaded from: classes46.dex */
public final class MonitorTimeCostCallAdapterFactoryV2 extends CallAdapter.Factory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f83777b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CallAdapter.Factory f83778a;

    public static final class a<R, T> implements CallAdapter<R, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CallAdapter<R, T> f83779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f83780b;

        @Override // com.bytedance.retrofit2.CallAdapter
        public final Type responseType() {
            return this.f83779a.responseType();
        }

        @Override // com.bytedance.retrofit2.CallAdapter
        public final T adapt(Call<R> r100) {
            Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
            Map<String, String> r101 = MonitorTimeCostCallAdapterFactoryV2.f83777b;
            Map<String, String> r102 = MonitorTimeCostCallAdapterFactoryV2.f83777b;
            Request r103 = r100.request();
            ((ConcurrentHashMap) r101).put(r103.getUrl() + ", " + r103.getMethod(), this.f83780b);
            return this.f83779a.adapt(r100);
        }

        public a(CallAdapter<R, T> r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "originalAdapter");
            Intrinsics.checkNotNullParameter(r101, "key");
            this.f83779a = r100;
            this.f83780b = r101;
        }
    }

    public static final class b {
    }

    static {
        f83777b = new ConcurrentHashMap();
    }

    public MonitorTimeCostCallAdapterFactoryV2(PbAnnotationCallAdapterFactoryV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFactory");
        this.f83778a = r100;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public final CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102) {
        Intrinsics.checkNotNullParameter(r100, "returnType");
        Intrinsics.checkNotNullParameter(r101, "annotations");
        Intrinsics.checkNotNullParameter(r102, "retrofit");
        Sequence r103 = SequencesKt.filter(ArraysKt.asSequence(r101), MonitorTimeCostCallAdapterFactoryV2$get$$inlined$filterIsInstance$1.INSTANCE);
        if (r103 == null) goto L14;
        MonitorTimeCost r104 = (MonitorTimeCost) SequencesKt.firstOrNull(r103);
        if (r104 == null) goto L7;
        CallAdapter<?, ?> r105 = this.f83778a.get(r100, r101, r102);
        if (r105 != null) goto L15;
        return null;
    L15:
        return new a(r105, r104.key());
    L7:
        return this.f83778a.get(r100, r101, r102);
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }
}
