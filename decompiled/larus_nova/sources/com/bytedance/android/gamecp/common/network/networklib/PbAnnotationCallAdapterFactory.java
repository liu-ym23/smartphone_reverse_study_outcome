package com.bytedance.android.gamecp.common.network.networklib;

import com.bytedance.android.gamecp.base.network.annotation.PbRequest;
import com.bytedance.android.gamecp.base.network.response.ExtraResponse;
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

/* JADX INFO: loaded from: classes44.dex */
public final class PbAnnotationCallAdapterFactory extends CallAdapter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CallAdapter.Factory f56690a;

    public PbAnnotationCallAdapterFactory(RxJava2CallAdapterFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "originFactory");
        this.f56690a = r100;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public final CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102) {
        Intrinsics.checkNotNullParameter(r100, "returnType");
        Intrinsics.checkNotNullParameter(r101, "annotations");
        Intrinsics.checkNotNullParameter(r102, "retrofit");
        if ((r100 instanceof ParameterizedType) == false) goto L5;
        Type r103 = ((ParameterizedType) r100).getActualTypeArguments()[0];
        PbRequestCallAdapter r104 = null;
        if ((r103 instanceof ParameterizedType) == false) goto L16;
        Type r105 = ((ParameterizedType) r103).getRawType();
        if (r105 == null) goto L14;
        if (ExtraResponse.class.isAssignableFrom((Class) r105) == false) goto L16;
    L17:
        CallAdapter<?, ?> r106 = this.f56690a.get(r100, r101, r102);
        if (r106 != null) goto L20;
        return null;
    L20:
        return new PbRequestCallAdapter(r106, "_global_switch");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L16:
        if (Intrinsics.areEqual(r103, com.bytedance.android.gamecp.base.network.response.c.class) == true) goto L17;
        Sequence r107 = SequencesKt.filter(ArraysKt.asSequence(r101), PbAnnotationCallAdapterFactory$get$$inlined$filterIsInstance$1.INSTANCE);
        if (r107 == null) goto L35;
        PbRequest r108 = (PbRequest) SequencesKt.firstOrNull(r107);
        if (r108 == null) goto L26;
        String r109 = r108.value();
    L27:
        if (r109 == null) goto L37;
        CallAdapter<?, ?> r110 = this.f56690a.get(r100, r101, r102);
        if (r110 == null) goto L33;
        r104 = new PbRequestCallAdapter(r110, r109);
    L33:
        return r104;
    L37:
        return this.f56690a.get(r100, r101, r102);
    L26:
        r109 = null;
        goto L27
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    L5:
        return this.f56690a.get(r100, r101, r102);
    }
}
