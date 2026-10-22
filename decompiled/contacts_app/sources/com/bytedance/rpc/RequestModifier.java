package com.bytedance.rpc;

import com.bytedance.rpc.serialize.SerializeType;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RequestModifier extends RpcRequestModifier {
    private static final int OPERATE_FIELD = 4;
    private static final int OPERATE_HEADER = 2;
    private static final int OPERATE_PARAM_NEED = 8;
    private static final int OPERATE_QUERY = 1;
    private static final int OPERATE_REQUEST_GZIP = 16;
    private static final int OPERATE_SERIALIZE = 256;
    private static final int OPERATE_TIMEOUT = 128;
    private static final int OPERATE_URL_BASE = 32;
    private static final int OPERATE_URL_PATH = 64;
    private int mOperate;

    RequestModifier() {
        super(null);
        this.mOperate = 0;
    }

    void apply(RpcRequestModifier r5) {
        int r0 = this.mOperate;
        if (r0 != 0) goto L5;
    L39:
        this.mOperate = 0;
        return;
    L5:
        if ((r0 & 2) != 2) goto L10;
        if (this.mOperatorHeader.isEmpty() == true) goto L10;
        applyMap(this.mOperatorHeader, r5.mOperatorHeader);
    L10:
        if ((this.mOperate & 1) != 1) goto L15;
        if (this.mOperatorQuery.isEmpty() == true) goto L15;
        applyMap(this.mOperatorQuery, r5.mOperatorQuery);
    L15:
        if ((this.mOperate & 4) != 4) goto L20;
        if (this.mOperatorField.isEmpty() == true) goto L20;
        applyMap(this.mOperatorField, r5.mOperatorField);
    L20:
        if ((this.mOperate & 8) != 8) goto L23;
        r5.mParamsNeed = this.mParamsNeed;
    L23:
        if ((this.mOperate & 16) != 16) goto L26;
        r5.mRequestGzip = this.mRequestGzip;
    L26:
        if ((this.mOperate & 32) != 32) goto L29;
        r5.setBaseUrl(this.mUrls[0]);
    L29:
        if ((this.mOperate & 64) != 64) goto L32;
        r5.setPathUrl(this.mUrls[1]);
    L32:
        if ((this.mOperate & 128) != 128) goto L35;
        r5.mConnectTimeout = this.mConnectTimeout;
        r5.mReadTimeout = this.mReadTimeout;
        r5.mWriteTimeout = this.mWriteTimeout;
    L35:
        if ((this.mOperate & 256) != 256) goto L39;
        if (this.mSerializeType == null) goto L39;
        r5.mSerializeType = this.mSerializeType;
        goto L39
    }

    private void applyMap(Map<Integer, Map<String, String>> r4, Map<Integer, Map<String, String>> r5) {
        Iterator<String> r0 = get(0, r4).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        put(r5, r0.next(), null);
        goto L4
    L6:
        Iterator<Map.Entry<String, String>> r6 = get(1, r4).entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry<String, String> r1 = r6.next();
        put(r5, r1.getKey(), r1.getValue());
        goto L8
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setTimeout(long r1, long r3, long r5) {
        super.setTimeout(r1, r3, r5);
        this.mOperate |= 128;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setBaseUrl(String r1) {
        super.setBaseUrl(r1);
        this.mOperate |= 32;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setPathUrl(String r1) {
        super.setPathUrl(r1);
        this.mOperate |= 64;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void addHeader(String r1, String r2) {
        super.addHeader(r1, r2);
        this.mOperate |= 2;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setSerializeType(SerializeType r1) {
        super.setSerializeType(r1);
        this.mOperate |= 256;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setParamsNeed(boolean r1) {
        super.setParamsNeed(r1);
        this.mOperate |= 8;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setRequestGzip(boolean r1) {
        super.setRequestGzip(r1);
        this.mOperate |= 16;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void addQuery(String r1, String r2) {
        super.addQuery(r1, r2);
        this.mOperate |= 1;
    }

    public boolean hasOperate() {
        if (this.mOperate == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
