package com.bytedance.android.ec.hybrid.data.network;

import com.bytedance.android.chunkstreamprediction.network.h;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Converter<TypedInput, com.bytedance.android.chunkstreamprediction.network.b<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f46815a;

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.android.chunkstreamprediction.network.b<java.lang.String>, java.lang.Object] */
    @Override // com.bytedance.retrofit2.Converter
    public final /* synthetic */ com.bytedance.android.chunkstreamprediction.network.b<String> convertWithRequestBuilder(TypedInput r100, RequestBuilder r101) {
        return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
    }

    @Override // com.bytedance.retrofit2.Converter
    public final /* synthetic */ boolean needRequestBuilder() {
        return Converter.CC.$default$needRequestBuilder(this);
    }

    public b(h r100) {
        this.f46815a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.String] */
    @Override // com.bytedance.retrofit2.Converter
    public final com.bytedance.android.chunkstreamprediction.network.b<String> convert(TypedInput r100) {
        TypedInput r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Ref.ObjectRef r103 = new Ref.ObjectRef();     // Catch: Throwable -> L8
        r103.element = "UTF-8";     // Catch: Throwable -> L8
        if (r101.mimeType() == null) goto L6;
        r103.element = MimeUtil.parseCharset(r101.mimeType(), (String) r103.element);     // Catch: Throwable -> L8
    L6:
        Object r104 = Result.m9449constructorimpl(new com.bytedance.android.chunkstreamprediction.network.b(new a(this, new id.e(r101.in()), r103)));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r104) == false) goto L14;
        r104 = null;
    L14:
        return (com.bytedance.android.chunkstreamprediction.network.b) r104;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
