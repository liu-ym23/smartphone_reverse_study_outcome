package com.alipay.android.phone.mrpc.core;

/* JADX INFO: loaded from: classes28.dex */
public class RpcException extends RuntimeException {
    public static final long serialVersionUID = -2875437994101380406L;
    public int mCode;
    public String mMsg;
    public String mOperationType;

    public RpcException(Integer r100, String r101) {
        super(a(r100, r101));
        this.mCode = r100.intValue();
        this.mMsg = r101;
    }

    public RpcException(Integer r100, String r101, Throwable r102) {
        super(a(r100, r101), r102);
        this.mCode = r100.intValue();
        this.mMsg = r101;
    }

    public RpcException(Integer r100, Throwable r101) {
        super(r101);
        this.mCode = r100.intValue();
    }

    public RpcException(String r100) {
        super(r100);
        this.mCode = 0;
        this.mMsg = r100;
    }

    public static String a(Integer r100, String r101) {
        StringBuilder r102 = new StringBuilder("RPCException: ");
        if (r100 == null) goto L5;
        r102.append("[");
        r102.append(r100);
        r102.append("]");
    L5:
        r102.append(" : ");
        if (r101 == null) goto L9;
        r102.append(r101);
    L9:
        return r102.toString();
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public String getOperationType() {
        return this.mOperationType;
    }

    public void setOperationType(String r100) {
        this.mOperationType = r100;
    }
}
