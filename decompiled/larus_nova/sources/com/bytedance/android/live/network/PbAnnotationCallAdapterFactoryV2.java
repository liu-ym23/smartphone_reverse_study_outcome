package com.bytedance.android.live.network;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.rxjava2.adapter.RxJava2CallAdapterFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes46.dex */
public final class PbAnnotationCallAdapterFactoryV2 extends CallAdapter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CallAdapter.Factory f83785a;

    public PbAnnotationCallAdapterFactoryV2(RxJava2CallAdapterFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "originFactory");
        this.f83785a = r100;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public final CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102) {
        Intrinsics.checkNotNullParameter(r100, "returnType");
        Intrinsics.checkNotNullParameter(r101, "annotations");
        Intrinsics.checkNotNullParameter(r102, "retrofit");
        if ((r100 instanceof ParameterizedType) == false) goto L5;
        Sequence r103 = SequencesKt.filter(ArraysKt.asSequence(r101), PbAnnotationCallAdapterFactoryV2$get$$inlined$filterIsInstance$1.INSTANCE);
        if (r103 == null) goto L33;
        PbRequest r104 = (PbRequest) SequencesKt.firstOrNull(r103);
        if (r104 == null) goto L11;
        String r105 = r104.value();
    L12:
        if (r105 != null) goto L28;
        Type r106 = ((ParameterizedType) r100).getActualTypeArguments()[0];
        if ((r106 instanceof ParameterizedType) == false) goto L23;
        Type r107 = ((ParameterizedType) r106).getRawType();
        if (r107 == null) goto L21;
        if (ExtraResponse.class.isAssignableFrom((Class) r107) == false) goto L23;
    L24:
        CallAdapter<?, ?> r108 = this.f83785a.get(r100, r101, r102);
        if (r108 != null) goto L35;
        return null;
    L35:
        return new PbRequestCallAdapterV2(r108, "_global_switch");
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L23:
        if (Intrinsics.areEqual(r106, com.bytedance.android.live.network.response.a.class) == true) goto L24;
        return this.f83785a.get(r100, r101, r102);
    L28:
        CallAdapter<?, ?> r109 = this.f83785a.get(r100, r101, r102);
        if (r109 != null) goto L31;
        return null;
    L31:
        return new PbRequestCallAdapterV2(r109, r105);
    L11:
        r105 = null;
        goto L12
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    L5:
        return this.f83785a.get(r100, r101, r102);
    }
}
