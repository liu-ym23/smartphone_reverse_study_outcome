package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public abstract class ContextObjectDeserializer implements ObjectDeserializer {
    public ContextObjectDeserializer() {
    }

    public abstract <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102, String r103, int r104);

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        return (T) deserialze(r100, r101, r102, null, 0);
    }
}
