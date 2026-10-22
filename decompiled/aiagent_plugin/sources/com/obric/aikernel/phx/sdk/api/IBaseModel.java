package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.response.Response;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import kotlinx.coroutines.b.h;

/* JADX INFO: compiled from: IBaseModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IBaseModel extends AutoCloseable {

    /* JADX INFO: compiled from: IBaseModel.kt */
    public static final class DefaultImpls {
        public static void close(IBaseModel r2) {
            IBaseModel r3 = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r2, IBaseModel.class, "com.obric.aiagent.plugin");
        }
    }

    @Override // java.lang.AutoCloseable
    void close();

    Object infer(RequestParams r1, d<? super Response<Object>> r2);

    Object inferAsFlow(RequestParams r1, d<? super h<Response<Object>>> r2);
}
