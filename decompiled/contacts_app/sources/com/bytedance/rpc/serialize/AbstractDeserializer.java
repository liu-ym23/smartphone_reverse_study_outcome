package com.bytedance.rpc.serialize;

import com.bytedance.rpc.transport.TransportInput;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractDeserializer implements Deserializer {
    protected TransportInput mInput;
    protected Type mType;

    protected abstract Object parser(TransportInput r1, Type r2) throws Exception;

    public AbstractDeserializer(TransportInput r1, Type r2) {
        this.mType = r2;
        this.mInput = r1;
    }

    @Override // com.bytedance.rpc.serialize.Deserializer
    public final Object parser() throws Exception {
        return parser(this.mInput, this.mType);
    }
}
