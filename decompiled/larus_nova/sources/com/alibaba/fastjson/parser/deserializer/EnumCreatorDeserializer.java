package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class EnumCreatorDeserializer implements ObjectDeserializer {
    private final Method creator;
    private final Class paramType;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 0;
    }

    public EnumCreatorDeserializer(Method r100) {
        this.creator = r100;
        this.paramType = r100.getParameterTypes()[0];
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        Object r103 = r100.parseObject(this.paramType);
        return (T) this.creator.invoke(null, new Object[]{r103});
    L8:
        e = move-exception;
        throw new JSONException("parse enum error", e);
    L5:
        e = move-exception;
        throw new JSONException("parse enum error", e);
    }
}
