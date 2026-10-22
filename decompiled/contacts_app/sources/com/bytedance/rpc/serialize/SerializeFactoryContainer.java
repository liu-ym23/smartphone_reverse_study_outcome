package com.bytedance.rpc.serialize;

import com.bytedance.rpc.transport.TransportInput;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
class SerializeFactoryContainer implements SerializeFactory {
    SerializeFactory[] mMultiFactories;
    SerializeType mSerializeType;

    SerializeFactoryContainer(SerializeType r1, SerializeFactory[] r2) {
        this.mSerializeType = r1;
        this.mMultiFactories = r2;
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public Deserializer getDeserializer(TransportInput r4, Type r5) {
        SerializeFactory[] r3 = this.mMultiFactories;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Deserializer r2 = r3[r1].getDeserializer(r4, r5);
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public Serializer getSerializer(Object r4, SerializeType r5) {
        SerializeFactory[] r3 = this.mMultiFactories;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Serializer r2 = r3[r1].getSerializer(r4, r5);
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public SerializeType getSerializeType() {
        return this.mSerializeType;
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public boolean isReflectSupported() {
        SerializeFactory[] r4 = this.mMultiFactories;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].isReflectSupported() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
