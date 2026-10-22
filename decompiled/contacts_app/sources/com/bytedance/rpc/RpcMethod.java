package com.bytedance.rpc;

import com.bytedance.rpc.annotation.RpcBizParams;
import com.bytedance.rpc.annotation.RpcOperation;
import com.bytedance.rpc.annotation.RpcOption;
import com.bytedance.rpc.annotation.RpcParams;
import com.bytedance.rpc.annotation.RpcSerializer;
import com.bytedance.rpc.callback.RpcCallback;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.serialize.SerializeType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class RpcMethod {
    private String[] mBizParams;
    private int mCallbackIndex;
    private Type mCallbackType;
    private Method mMethod;
    private Annotation[] mMethodAnnotation;
    private String mOperationType;
    private Annotation[][] mParameterAnnotations;
    private int mParameterLength;
    private Type[] mParameterTypes;
    private boolean mParamsNeed;
    private String mPath;
    private boolean mPostRequest;
    private SerializeType mSerializeType;
    private Class mServiceClass;

    RpcMethod(Class r2, Method r3) {
        this.mCallbackIndex = -1;
        this.mMethod = r3;
        this.mServiceClass = r2;
        Type[] r4 = r3.getGenericParameterTypes();
        if (r4 != null) goto L5;
        int r5 = 0;
    L6:
        this.mParameterLength = r5;
        parserCallback(r4, r5);
        return;
    L5:
        r5 = r4.length;
        goto L6
    }

    public String getPath() {
        if (this.mMethodAnnotation != null) goto L5;
        getMethodAnnotations();
    L5:
        String r1 = this.mPath;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    }

    public String getOperationType() {
        if (this.mMethodAnnotation != null) goto L5;
        getMethodAnnotations();
    L5:
        String r1 = this.mOperationType;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    }

    public boolean isPostRequest() {
        if (this.mMethodAnnotation != null) goto L6;
        getMethodAnnotations();
    L6:
        return this.mPostRequest;
    }

    public boolean isParamsNeed() {
        if (this.mMethodAnnotation != null) goto L6;
        getMethodAnnotations();
    L6:
        return this.mParamsNeed;
    }

    public String[] getBizParams() {
        return this.mBizParams;
    }

    public SerializeType getSerializeType() {
        if (this.mMethodAnnotation != null) goto L5;
        getMethodAnnotations();
    L5:
        SerializeType r1 = this.mSerializeType;
        if (r1 == null) goto L8;
        return r1;
    L8:
        return SerializeType.JSON;
    }

    public Method getMethod() {
        return this.mMethod;
    }

    public Class getServiceClass() {
        return this.mServiceClass;
    }

    public Type getReturnType() {
        return this.mMethod.getGenericReturnType();
    }

    public boolean isAsyncRequest() {
        if (this.mCallbackIndex < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Type[] getParameterTypes() {
        if (this.mParameterTypes != null) goto L19;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.mParameterTypes != null) goto L13;
        Type[] r0 = this.mMethod.getGenericParameterTypes();     // Catch: Throwable -> L15
        int r1 = this.mCallbackIndex;     // Catch: Throwable -> L15
        if (r1 >= 0) goto L12;
        if (r0 != null) goto L11;
        r0 = new Type[0];     // Catch: Throwable -> L15
    L11:
        this.mParameterTypes = r0;     // Catch: Throwable -> L15
        goto L13
    L12:
        Type[] r2 = new Type[r0.length - 1];     // Catch: Throwable -> L15
        this.mParameterTypes = r2;     // Catch: Throwable -> L15
        copyExcludeIndex(r0, r2, r1);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
    L19:
        return this.mParameterTypes;
    }

    public Annotation[][] getParameterAnnotations() {
        if (this.mParameterAnnotations != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (this.mParameterAnnotations != null) goto L17;
        Annotation[][] r0 = this.mMethod.getParameterAnnotations();     // Catch: Throwable -> L19
        int r1 = this.mCallbackIndex;     // Catch: Throwable -> L19
        if (r1 < 0) goto L14;
        if (r0 == null) goto L14;
        if (r0.length < this.mParameterLength) goto L14;
        Annotation[][] r2 = new Annotation[r0.length - 1][];     // Catch: Throwable -> L19
        this.mParameterAnnotations = r2;     // Catch: Throwable -> L19
        copyExcludeIndex(r0, r2, r1);     // Catch: Throwable -> L19
    L14:
        if (r0 != null) goto L16;
        r0 = new Annotation[0][];     // Catch: Throwable -> L19
    L16:
        this.mParameterAnnotations = r0;     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return this.mParameterAnnotations;
    }

    public Annotation[] getMethodAnnotations() {
        if (this.mMethodAnnotation != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (this.mMethodAnnotation != null) goto L17;
        checkControlAnnotation(this.mMethod);     // Catch: Throwable -> L19
        Annotation[] r0 = this.mMethod.getAnnotations();     // Catch: Throwable -> L19
        if (r0 == null) goto L15;
        if (r0.length <= 0) goto L15;
        List<Annotation> r1 = filterMethodAnnotation(r0);     // Catch: Throwable -> L19
        if (r1.size() <= 0) goto L15;
        this.mMethodAnnotation = (Annotation[]) r1.toArray(new Annotation[r1.size()]);     // Catch: Throwable -> L19
    L15:
        if (this.mMethodAnnotation != null) goto L17;
        this.mMethodAnnotation = new Annotation[0];     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return this.mMethodAnnotation;
    }

    private List<Annotation> filterMethodAnnotation(Annotation[] r6) {
        ArrayList r5 = new ArrayList(r6.length);
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        Annotation r2 = r6[r1];
        Class<? extends Annotation> r3 = r2.annotationType();
        if (r3 == RpcOperation.class) goto L14;
        if (r3 == RpcOption.class) goto L14;
        if (r3 == RpcParams.class) goto L14;
        if (r3 == RpcBizParams.class) goto L14;
        r5.add(r2);
    L14:
        r1 = r1 + 1;
        goto L3
    L15:
        return r5;
    }

    private void checkControlAnnotation(Method r9) {
        RpcOperation r0 = (RpcOperation) r9.getAnnotation(RpcOperation.class);
        RpcSerializer r1 = (RpcSerializer) r9.getAnnotation(RpcSerializer.class);
        RpcParams r2 = (RpcParams) r9.getAnnotation(RpcParams.class);
        RpcOption r3 = (RpcOption) r9.getAnnotation(RpcOption.class);
        RpcBizParams r4 = (RpcBizParams) r9.getAnnotation(RpcBizParams.class);
        if (r3 != null) goto L5;
        boolean r6 = true;
    L6:
        if (r3 != null) goto L8;
        SerializeType r7 = SerializeType.JSON;
    L9:
        if (r3 != null) goto L11;
        String[] r5 = RpcUtils.EMPTY_STR_ARR;
    L12:
        if (r4 == null) goto L15;
        r5 = r4.value();
    L15:
        this.mBizParams = r5;
        if (r2 == null) goto L19;
        r6 = r2.value();
    L19:
        this.mParamsNeed = r6;
        if (r1 == null) goto L23;
        r7 = r1.value();
    L23:
        this.mSerializeType = r7;
        if (r0 != null) goto L26;
        String r8 = "";
    L27:
        this.mOperationType = r8;
        if (RpcUtils.isInvisible(r8) == true) goto L35;
        int r10 = r8.indexOf(36) + 1;
        int r11 = r8.indexOf(32, r10);
        if (r10 < 0) goto L36;
        if (r11 <= r10) goto L37;
        this.mPostRequest = "POST".equalsIgnoreCase(r8.substring(r10, r11).trim());
        this.mPath = r8.substring(r11 + 1).trim();
        return;
    L37:
        return;
    L36:
        return;
    L35:
        throw new RuntimeException(String.format("%s#%s should use annotation with RpcOperation", new Object[]{this.mServiceClass.getSimpleName(), r9.getName()}));
    L26:
        r8 = r0.value();
        goto L27
    L11:
        r5 = r3.bizParams();
        goto L12
    L8:
        r7 = r3.serialize();
        goto L9
    L5:
        r6 = r3.commonParams();
        goto L6
    }

    private void copyExcludeIndex(Object[] r2, Object[] r3, int r4) {
        int r1 = r3.length;
        if (r1 > 0) goto L5;
        return;
    L5:
        if (r4 == 0) goto L9;
        if (r4 == r1) goto L9;
        System.arraycopy(r2, 0, r3, 0, r4);
        System.arraycopy(r2, r4 + 1, r3, r4, r1 - r4);
        return;
    L9:
        if (r4 <= 0) goto L11;
        System.arraycopy(r2, 0, r3, 0, r1);
        return;
    L11:
        System.arraycopy(r2, 1, r3, 0, r1);
    }

    private void parserCallback(Type[] r5, int r6) {
        if (r6 <= 0) goto L18;
        int r0 = 0;
    L4:
        if (r0 >= r6) goto L28;
        Type r1 = r5[r0];
        if ((r1 instanceof Class) == false) goto L11;
        if (RpcCallback.class.isAssignableFrom((Class) r1) == false) goto L17;
        this.mCallbackIndex = r0;
        this.mCallbackType = r1;
        return;
    L17:
        r0 = r0 + 1;
        goto L4
    L11:
        if ((r1 instanceof ParameterizedType) == false) goto L17;
        Type r2 = ((ParameterizedType) r1).getRawType();
        if ((r2 instanceof Class) == false) goto L17;
        if (RpcCallback.class.isAssignableFrom((Class) r2) == false) goto L17;
        this.mCallbackIndex = r0;
        this.mCallbackType = r1;
        return;
    L28:
        return;
    }

    public RpcRequest toRequest(RpcInvokeContext r8, Object[] r9) {
        int r0 = this.mCallbackIndex;
        if (r0 < 0) goto L8;
        if (r9 == null) goto L8;
        if (r9.length < this.mParameterLength) goto L8;
        RpcCallback r1 = (RpcCallback) r9[r0];
        Object[] r2 = new Object[r9.length - 1];
        copyExcludeIndex(r9, r2, r0);
        RpcCallback r4 = r1;
        r9 = r2;
    L10:
        if (r9 != null) goto L13;
        r9 = RpcUtils.EMPTY_OBJ_ARR;
    L13:
        return new RpcRequest(r8, this, r9, r4, this.mCallbackType);
    L8:
        r4 = null;
        goto L10
    }
}
