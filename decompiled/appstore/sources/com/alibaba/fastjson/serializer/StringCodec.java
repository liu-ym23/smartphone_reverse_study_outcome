package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class StringCodec implements ObjectSerializer, ObjectDeserializer {
    public static StringCodec instance;

    static {
        instance = new StringCodec();
    }

    private StringCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        return (T) r10.parseString();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r10, Object r11, Object r12, Type r13) throws IOException {
        String r14 = (String) r11;
        SerializeWriter r15 = r10.out;
        if (r14 != null) goto L6;
        r15.writeNull();
        return;
    L6:
        r15.writeString(r14);
    }
}
