package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.nio.charset.Charset;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements Converter<TypedInput, NativePrefetchResponse> {

    public static final class a {
    }

    public m() {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchResponse, java.lang.Object] */
    @Override // com.bytedance.retrofit2.Converter
    public final /* synthetic */ NativePrefetchResponse convertWithRequestBuilder(TypedInput r100, RequestBuilder r101) {
        return Converter.CC.$default$convertWithRequestBuilder(this, r100, r101);
    }

    @Override // com.bytedance.retrofit2.Converter
    public final /* synthetic */ boolean needRequestBuilder() {
        return Converter.CC.$default$needRequestBuilder(this);
    }

    static {
    }

    @Override // com.bytedance.retrofit2.Converter
    public final NativePrefetchResponse convert(TypedInput r100) {
        TypedInput r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        if ((r101 instanceof TypedByteArray) == false) goto L9;
        String r103 = "UTF-8";
        if (r101.mimeType() == null) goto L8;
        r103 = MimeUtil.parseCharset(r101.mimeType(), "UTF-8");     // Catch: Throwable -> L11
    L8:
        NativePrefetchResponse r104 = new NativePrefetchResponse();     // Catch: Throwable -> L11
        r104.setData(new String(((TypedByteArray) r101).getBytes(), Charset.forName(r103)));     // Catch: Throwable -> L11
        return r104;
    L9:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        return null;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
