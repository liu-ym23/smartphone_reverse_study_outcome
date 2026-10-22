package com.bytedance.android.livesdkapi.service;

import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveRetrofitFacade;", "", "createMultiTypeRequestConverterFactory", "Lcom/bytedance/retrofit2/CallAdapter$Factory;", "createPbAnnotationCallAdapterFactory", "Lcom/bytedance/retrofit2/Converter$Factory;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRetrofitFacade {
    CallAdapter.Factory createMultiTypeRequestConverterFactory();

    Converter.Factory createPbAnnotationCallAdapterFactory();
}
