package com.bytedance.android.live.network;

import com.bytedance.android.live.base.annotation.SkipLivePBCheck;
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
public final class PbAnnotationCallAdapterFactory extends CallAdapter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CallAdapter.Factory f83784a;

    public PbAnnotationCallAdapterFactory(RxJava2CallAdapterFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "originFactory");
        this.f83784a = r100;
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public final CallAdapter<?, ?> get(Type r100, Annotation[] r101, Retrofit r102) {
        Intrinsics.checkNotNullParameter(r100, "returnType");
        Intrinsics.checkNotNullParameter(r101, "annotations");
        Intrinsics.checkNotNullParameter(r102, "retrofit");
        if ((r100 instanceof ParameterizedType) == false) goto L5;
        Sequence r103 = SequencesKt.filter(ArraysKt.asSequence(r101), PbAnnotationCallAdapterFactory$get$$inlined$filterIsInstance$1.INSTANCE);
        if (r103 == null) goto L47;
        if (((SkipLivePBCheck) SequencesKt.firstOrNull(r103)) != null) goto L11;
        Sequence r104 = SequencesKt.filter(ArraysKt.asSequence(r101), PbAnnotationCallAdapterFactory$get$$inlined$filterIsInstance$2.INSTANCE);
        if (r104 == null) goto L45;
        PbRequest r105 = (PbRequest) SequencesKt.firstOrNull(r104);
        if (r105 == null) goto L17;
        String r106 = r105.value();
    L18:
        if (r106 != null) goto L40;
        Type r107 = ((ParameterizedType) r100).getActualTypeArguments()[0];
        if ((r107 instanceof ParameterizedType) == false) goto L35;
        ParameterizedType r108 = (ParameterizedType) r107;
        Type r109 = r108.getRawType();
        if (r109 == null) goto L33;
        if (ExtraResponse.class.isAssignableFrom((Class) r109) == true) goto L36;
        Type r110 = r108.getRawType();
        if (r110 == null) goto L31;
        if (zn0.f.class.isAssignableFrom((Class) r110) == true) goto L36;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L36:
        CallAdapter<?, ?> r111 = this.f83784a.get(r100, r101, r102);
        if (r111 != null) goto L49;
        return null;
    L49:
        return new PbRequestCallAdapter(r111, "_global_switch");
    L33:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L35:
        if (Intrinsics.areEqual(r107, com.bytedance.android.live.network.response.a.class) == true) goto L36;
        return this.f83784a.get(r100, r101, r102);
    L40:
        CallAdapter<?, ?> r112 = this.f83784a.get(r100, r101, r102);
        if (r112 != null) goto L43;
        return null;
    L43:
        return new PbRequestCallAdapter(r112, r106);
    L17:
        r106 = null;
        goto L18
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    L11:
        return this.f83784a.get(r100, r101, r102);
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    L5:
        return this.f83784a.get(r100, r101, r102);
    }
}
