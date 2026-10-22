package com.bytedance.rpc;

import com.bytedance.rpc.annotation.RpcPath;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.serialize.SerializeType;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RpcRequestModifier {
    protected long mConnectTimeout;
    protected final Map<Integer, Map<String, String>> mOperatorField;
    protected final Map<Integer, Map<String, String>> mOperatorHeader;
    protected final Map<Integer, Map<String, String>> mOperatorQuery;
    protected boolean mParamsNeed;
    protected long mReadTimeout;
    protected boolean mRequestGzip;
    protected SerializeType mSerializeType;
    protected final String[] mUrls;
    protected long mWriteTimeout;

    RpcRequestModifier(RpcContext r3) {
        this.mParamsNeed = true;
        this.mRequestGzip = true;
        this.mUrls = new String[2];
        this.mOperatorHeader = new HashMap(2);
        this.mOperatorQuery = new HashMap(2);
        this.mOperatorField = new HashMap(2);
        if (r3 != null) goto L5;
        RpcConfig r4 = null;
    L6:
        if (r4 == null) goto L9;
        updateConfig(r4);
        return;
    L9:
        return;
    L5:
        r4 = r3.getRpcConfig();
        goto L6
    }

    void updateConfig(RpcConfig r3) {
        this.mConnectTimeout = r3.getConnectTimeout();
        this.mReadTimeout = r3.getReadTimeout();
        this.mWriteTimeout = r3.getWriteTimeout();
        this.mRequestGzip = r3.isRequestGzip();
        this.mUrls[0] = r3.getBaseUrl();
    }

    RpcRequestModifier reset(RpcRequest r6) {
        RpcRequestModifier r0 = r6.getRpcInvokeContext().getModifier();
        this.mConnectTimeout = r0.getConnectTimeout();
        this.mReadTimeout = r0.getReadTimeout();
        this.mWriteTimeout = r0.getWriteTimeout();
        this.mUrls[0] = r0.getBaseUrl();
        this.mUrls[1] = r6.getPath();
        this.mParamsNeed = r6.isParamsNeed();
        this.mSerializeType = r6.getSerializeType();
        this.mRequestGzip = r6.getRpcInvokeContext().getRpcConfig().isRequestGzip();
        resetOperator(r0.mOperatorHeader, this.mOperatorHeader, 0);
        resetOperator(r0.mOperatorHeader, this.mOperatorHeader, 1);
        resetOperator(r0.mOperatorQuery, this.mOperatorQuery, 0);
        resetOperator(r0.mOperatorQuery, this.mOperatorQuery, 1);
        resetOperator(r0.mOperatorField, this.mOperatorField, 0);
        resetOperator(r0.mOperatorField, this.mOperatorField, 1);
        return this;
    }

    public void setTimeout(long r1, long r3, long r5) {
        this.mConnectTimeout = r1;
        this.mReadTimeout = r3;
        this.mWriteTimeout = r5;
    }

    public void setBaseUrl(String r2) {
        this.mUrls[0] = r2;
    }

    public void setPathUrl(String r2) {
        this.mUrls[1] = r2;
    }

    public void addHeader(String r2, String r3) {
        put(this.mOperatorHeader, r2, r3);
    }

    public void setSerializeType(SerializeType r1) {
        if (r1 == null) goto L5;
        this.mSerializeType = r1;
        return;
    }

    public void setParamsNeed(boolean r1) {
        this.mParamsNeed = r1;
    }

    public void setRequestGzip(boolean r1) {
        this.mRequestGzip = r1;
    }

    public void addField(String r2, String r3) {
        put(this.mOperatorField, r2, r3);
    }

    public void addQuery(String r2, String r3) {
        put(this.mOperatorQuery, r2, r3);
    }

    long getConnectTimeout() {
        return this.mConnectTimeout;
    }

    long getReadTimeout() {
        return this.mReadTimeout;
    }

    long getWriteTimeout() {
        return this.mWriteTimeout;
    }

    String getBaseUrl() {
        return this.mUrls[0];
    }

    String getPathUrl() {
        return this.mUrls[1];
    }

    boolean isParamsNeed() {
        return this.mParamsNeed;
    }

    boolean isRequestGzip() {
        return this.mRequestGzip;
    }

    SerializeType getSerializeType() {
        return this.mSerializeType;
    }

    Map<String, String> applyHeader(Map<String, String> r2) {
        return apply(this.mOperatorHeader, r2);
    }

    Map<String, String> applyQuery(Map<String, String> r2) {
        return apply(this.mOperatorQuery, r2);
    }

    Map<String, String> applyField(Map<String, String> r2) {
        return apply(this.mOperatorField, r2);
    }

    Object[] filterArgs(Object[] r6, Annotation[][] r7, Map<String, String> r8) {
        int r5 = r7.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r5) goto L15;
        Annotation[] r3 = r7[r1];
        if (r3 != null) goto L7;
    L11:
        Object r4 = r6[r1];
        if ((r4 instanceof Class) == true) goto L14;
        r6[r2] = r4;
        r2 = r2 + 1;
    L14:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r3.length <= 0) goto L11;
        Annotation r9 = r3[0];
        if ((r9 instanceof RpcPath) == false) goto L11;
        r8.put(((RpcPath) r9).value(), String.valueOf(r6[r1]));
        goto L14
    L15:
        if (r2 > r5) goto L20;
        Object[] r10 = new Object[r2];
        if (r2 <= 0) goto L19;
        System.arraycopy(r6, 0, r10, 0, r2);
    L19:
        return r10;
    L20:
        return r6;
    }

    protected Map<String, String> get(Integer r2, Map<Integer, Map<String, String>> r3) {
        Map<String, String> r1 = r3.get(r2);
        if (r1 != null) goto L6;
        HashMap r4 = new HashMap(4);
        r3.put(r2, r4);
        return r4;
    L6:
        return r1;
    }

    protected void put(Map<Integer, Map<String, String>> r3, String r4, String r5) {
        if (RpcUtils.isVisible(r4) == false) goto L9;
        Map<String, String> r0 = get(1, r3);
        Map<String, String> r2 = get(0, r3);
        if (r5 != null) goto L7;
        r0.remove(r4);
        r2.put(r4, "");
        return;
    L7:
        r2.remove(r4);
        r0.put(r4, r5);
        return;
    }

    private void resetOperator(Map<Integer, Map<String, String>> r2, Map<Integer, Map<String, String>> r3, int r4) {
        Map<String, String> r5 = r2.get(Integer.valueOf(r4));
        if (r5 != null) goto L5;
    L8:
        Map<String, String> r1 = r3.get(Integer.valueOf(r4));
        if (r1 == null) goto L13;
        r1.clear();
        return;
    L13:
        return;
    L5:
        if (r5.isEmpty() == true) goto L8;
        Map<String, String> r6 = get(Integer.valueOf(r4), r3);
        r6.clear();
        r6.putAll(r5);
    }

    private Map<String, String> apply(Map<Integer, Map<String, String>> r2, Map<String, String> r3) {
        if (r3 != null) goto L4;
        r3 = new HashMap();
    L4:
        Map<String, String> r1 = r2.get(1);
        if (r1 != null) goto L7;
    L9:
        Map<String, String> r4 = r2.get(0);
        if (r4 != null) goto L12;
    L17:
        return r3;
    L12:
        if (r4.isEmpty() == true) goto L17;
        Iterator<String> r5 = r4.keySet().iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r3.remove(r5.next());
        goto L15
    L7:
        if (r1.isEmpty() == true) goto L9;
        r3.putAll(r1);
        goto L9
    }
}
