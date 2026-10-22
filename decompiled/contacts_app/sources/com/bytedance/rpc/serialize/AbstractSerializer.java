package com.bytedance.rpc.serialize;

import com.bytedance.rpc.RpcDataBuilder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractSerializer implements Serializer {
    protected Object mParams;
    protected SerializeType mType;

    public abstract byte[] packet(Object r1, String r2) throws Exception;

    public AbstractSerializer(Object r1, SerializeType r2) {
        this.mParams = r1;
        this.mType = r2;
    }

    protected String getContentType() {
        return this.mType.getContentType();
    }

    @Override // com.bytedance.rpc.serialize.Serializer
    public final ByteType packet() throws Exception {
        String r0 = getContentType();
        Object r1 = unpackParams(this.mParams, false);
        if (r1 != null) goto L5;
        byte[] r3 = null;
    L7:
        return new ByteType(r3, r0);
    L5:
        r3 = packet(r1, r0);
        goto L7
    }

    public static Object unpackParams(Object r2, boolean r3) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if ((r2 instanceof Object[]) == false) goto L15;
        Object[] r0 = (Object[]) r2;
        if (r0.length != 0) goto L9;
        return null;
    L9:
        if (r3 == true) goto L13;
        if (r0.length == 1) goto L13;
        return r2;
    L13:
        return r0[0];
    L15:
        return r2;
    }

    public static RpcDataBuilder.SerializerData getSerializerData(Object r1) {
        Object r2 = unpackParams(r1, true);
        if ((r2 instanceof RpcDataBuilder) == false) goto L7;
        return ((RpcDataBuilder) r2).build();
    L7:
        if ((r2 instanceof RpcDataBuilder.SerializerData) == true) goto L9;
        return null;
    L9:
        return (RpcDataBuilder.SerializerData) r2;
    }
}
