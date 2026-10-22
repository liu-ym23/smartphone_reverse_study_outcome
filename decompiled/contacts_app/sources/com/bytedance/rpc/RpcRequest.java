package com.bytedance.rpc;

import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.internal.RequestIdMonitor;
import com.bytedance.rpc.internal.TypeUtils;
import com.bytedance.rpc.serialize.SerializeType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Map;
import org.threeten.bp.Year;

/* JADX INFO: loaded from: classes2.dex */
public class RpcRequest {
    private static RequestIdMonitor sSeqIdProducer;
    private Object[] mArgs;
    private RpcCallback mCallback;
    private RpcInvokeContext mInvokeContext;
    private int mRequestId;
    RequestModifier mRequestModify;
    protected Type mRequiredResponseType;
    protected Type mReturnType;
    private RpcMethod mRpcMethod;

    static {
        sSeqIdProducer = new RequestIdMonitor(1, Year.MAX_VALUE);
    }

    public RpcRequest(RpcRequest r2) {
        if (r2 == null) goto L6;
        this.mInvokeContext = r2.mInvokeContext;
        this.mRpcMethod = r2.mRpcMethod;
        this.mArgs = r2.mArgs;
        this.mCallback = r2.mCallback;
        this.mRequiredResponseType = r2.mRequiredResponseType;
        this.mReturnType = r2.mReturnType;
        this.mRequestId = r2.mRequestId;
        this.mRequestModify = r2.mRequestModify;
        return;
    }

    RpcRequest(RpcInvokeContext r1, RpcMethod r2, Object[] r3, RpcCallback r4, Type r5) {
        this.mInvokeContext = r1;
        this.mRpcMethod = r2;
        this.mArgs = r3;
        this.mCallback = r4;
        this.mRequestId = sSeqIdProducer.generateRingId();
        this.mReturnType = TypeUtils.normalizeType(this.mRpcMethod.getReturnType());
        if (isAsyncRequest() == false) goto L5;
        this.mRequiredResponseType = parserRequiredResponseType(r4, r5);
        return;
    L5:
        this.mRequiredResponseType = parserResponseTypeFromArguments(r3, this.mReturnType);
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public String getBaseUrl() {
        return this.mInvokeContext.getRpcConfig().getBaseUrl();
    }

    public String getPath() {
        return this.mRpcMethod.getPath();
    }

    public String getOperationType() {
        return this.mRpcMethod.getOperationType();
    }

    public boolean isPostRequest() {
        return this.mRpcMethod.isPostRequest();
    }

    public boolean isParamsNeed() {
        return this.mRpcMethod.isParamsNeed();
    }

    public SerializeType getSerializeType() {
        return this.mRpcMethod.getSerializeType();
    }

    public RpcInvokeContext getRpcInvokeContext() {
        return this.mInvokeContext;
    }

    public RpcMethod getRpcMethod() {
        return this.mRpcMethod;
    }

    public Method getMethod() {
        return this.mRpcMethod.getMethod();
    }

    public Object[] getArguments() {
        return this.mArgs;
    }

    public RpcCallback getCallback() {
        return this.mCallback;
    }

    public Class getServiceClass() {
        return this.mRpcMethod.getServiceClass();
    }

    public Type getReturnType() {
        return this.mReturnType;
    }

    public Type getRequiredResponseType() {
        return this.mRequiredResponseType;
    }

    public boolean isAsyncRequest() {
        return this.mRpcMethod.isAsyncRequest();
    }

    boolean collectCommonParams(Map<String, String> r8, Map<String, String> r9) {
        String[] r0 = this.mRpcMethod.getBizParams();
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        if (r2 == 0) goto L8;
        int r3 = 0;
        int r4 = 0;
    L10:
        if (r3 >= r2) goto L15;
        if (this.mInvokeContext.collectCommonParams(r0[r3], r8, r9) == false) goto L14;
        r4 = r4 + 1;
    L14:
        r3 = r3 + 1;
        goto L10
    L15:
        if (r4 != r2) goto L21;
        return true;
    L21:
        return false;
    L8:
        return this.mInvokeContext.collectCommonParams(null, r8, r9);
    L5:
        r2 = r0.length;
        goto L6
    }

    private Type parserResponseTypeFromArguments(Object[] r5, Type r6) {
        Type r0 = null;
        if (r6 == Object.class) goto L5;
    L12:
        if (r0 != null) goto L15;
        return r6;
    L15:
        return r0;
    L5:
        if (r5.length <= 0) goto L12;
        int r4 = r5.length;
        int r1 = 0;
    L7:
        if (r1 >= r4) goto L12;
        Object r2 = r5[r1];
        if ((r2 instanceof Class) == false) goto L11;
        r0 = (Type) r2;
    L11:
        r1 = r1 + 1;
        goto L7
    }

    private Type parserRequiredResponseType(RpcCallback r3, Type r4) {
        Type[] r1 = null;
        if ((r4 instanceof ParameterizedType) == false) goto L10;
        Type[] r2 = ((ParameterizedType) r4).getActualTypeArguments();
        if (r2 == null) goto L10;
        if (r2.length == 0) goto L10;
        Type r5 = r2[0];
    L12:
        if ((r5 instanceof WildcardType) == false) goto L23;
        if (r3 == null) goto L16;
        r1 = r3.getClass().getGenericInterfaces();
    L16:
        if (r1 != null) goto L18;
        return r5;
    L18:
        if (r1.length <= 0) goto L25;
        Type r6 = r1[0];
        if ((r6 instanceof ParameterizedType) == true) goto L22;
        return r5;
    L22:
        return ((ParameterizedType) r6).getActualTypeArguments()[0];
    L25:
        return r5;
    L23:
        return r5;
    L10:
        r5 = null;
        goto L12
    }
}
