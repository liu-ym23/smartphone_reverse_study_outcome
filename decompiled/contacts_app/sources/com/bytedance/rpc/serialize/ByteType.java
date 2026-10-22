package com.bytedance.rpc.serialize;

import com.bytedance.rpc.internal.RpcUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ByteType {
    private String mContentType;
    private byte[] mData;
    private String mFileName;
    private String mName;

    public ByteType(byte[] r2, String r3) {
        this(r2, r3, null);
    }

    public ByteType(byte[] r2, String r3, String r4) {
        this(r2, r3, r4, null);
    }

    public ByteType(byte[] r1, String r2, String r3, String r4) {
        if (r1 != null) goto L5;
        r1 = RpcUtils.EMPTY_BYTE_ARR;
    L5:
        this.mData = r1;
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        this.mContentType = r2;
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        this.mName = r3;
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        this.mFileName = r4;
    }

    public byte[] getData() {
        return this.mData;
    }

    public String getName() {
        return this.mName;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public int getContentLength() {
        return this.mData.length;
    }
}
