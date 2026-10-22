package com.stepos.agentframework.adapter.coze.repository;

import H7.c;
import S7.a;
import S7.k;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.coze.HttpResult;
import com.stepos.agentframework.adapter.coze.bean.ErrorResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00012\u001e\u0010\u0007\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u000e\b\b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\f\u0010\rJB\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00012\u001e\u0010\u0007\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0086H¢\u0006\u0004\b\f\u0010\u000eJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/repository/LlmRepository;", "", AppAgent.CONSTRUCT, "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "LH7/c;", "request", "Lkotlin/Function0;", "LC7/r;", "localCache", "Lcom/stepos/agentframework/adapter/coze/HttpResult;", "call", "(LS7/k;LS7/a;LH7/c;)Ljava/lang/Object;", "(LS7/k;LH7/c;)Ljava/lang/Object;", "response", "executeResponse", "(Ljava/lang/Object;)Lcom/stepos/agentframework/adapter/coze/HttpResult;", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LlmRepository {
    public final <T> Object call(k kVar, a aVar, c<? super HttpResult<? extends T>> cVar) {
        if (aVar != null) {
            try {
                aVar.invoke();
            } catch (Exception e) {
                return new HttpResult.Error(e);
            }
        }
        Object objInvoke = kVar.invoke(cVar);
        if (objInvoke == null || !(objInvoke instanceof ErrorResult)) {
            ErrorResult errorResult = new ErrorResult(null, null, null, 0, 15, null);
            errorResult.setStatus(-1);
            errorResult.setCode("unknow");
            errorResult.setMessage("unknow");
            return new HttpResult.Failure(errorResult);
        }
        if (((ErrorResult) objInvoke).getStatus() != null) {
            Integer status = ((ErrorResult) objInvoke).getStatus();
            kotlin.jvm.internal.k.c(status);
            if (status.intValue() >= 400) {
                return new HttpResult.Failure((ErrorResult) objInvoke);
            }
        }
        kotlin.jvm.internal.k.m();
        throw null;
    }

    public final <T> HttpResult<T> executeResponse(Object response) {
        if (response == null || !(response instanceof ErrorResult)) {
            ErrorResult errorResult = new ErrorResult(null, null, null, 0, 15, null);
            errorResult.setStatus(-1);
            errorResult.setCode("unknow");
            errorResult.setMessage("unknow");
            return new HttpResult.Failure(errorResult);
        }
        ErrorResult errorResult2 = (ErrorResult) response;
        if (errorResult2.getStatus() != null) {
            Integer status = errorResult2.getStatus();
            kotlin.jvm.internal.k.c(status);
            if (status.intValue() >= 400) {
                return new HttpResult.Failure(errorResult2);
            }
        }
        kotlin.jvm.internal.k.m();
        throw null;
    }

    public final <T> Object call(k kVar, c<? super HttpResult<? extends T>> cVar) {
        try {
            Object objInvoke = kVar.invoke(cVar);
            if (objInvoke != null && (objInvoke instanceof ErrorResult)) {
                if (((ErrorResult) objInvoke).getStatus() != null) {
                    Integer status = ((ErrorResult) objInvoke).getStatus();
                    kotlin.jvm.internal.k.c(status);
                    if (status.intValue() >= 400) {
                        return new HttpResult.Failure((ErrorResult) objInvoke);
                    }
                }
                kotlin.jvm.internal.k.m();
                throw null;
            }
            ErrorResult errorResult = new ErrorResult(null, null, null, 0, 15, null);
            errorResult.setStatus(-1);
            errorResult.setCode("unknow");
            errorResult.setMessage("unknow");
            return new HttpResult.Failure(errorResult);
        } catch (Exception e) {
            return new HttpResult.Error(e);
        }
    }
}
