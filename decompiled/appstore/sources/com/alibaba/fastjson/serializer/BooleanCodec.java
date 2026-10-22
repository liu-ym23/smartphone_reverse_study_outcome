package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class BooleanCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BooleanCodec instance = null;

    static {
        instance = new BooleanCodec();
    }

    private BooleanCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        JSONLexer r13 = r10.lexer;
        int r14 = r13.token();
        if (r14 != 6) goto L6;
        r13.nextToken(16);
        return (T) Boolean.TRUE;
    L6:
        if (r14 != 7) goto L9;
        r13.nextToken(16);
        return (T) Boolean.FALSE;
    L9:
        if (r14 != 2) goto L14;
        int r15 = r13.intValue();
        r13.nextToken(16);
        if (r15 != 1) goto L23;
        return (T) Boolean.TRUE;
    L23:
        return (T) Boolean.FALSE;
    L14:
        Object r16 = r10.parse();
        if (r16 != null) goto L19;
        return null;
    L19:
        return (T) TypeUtils.castToBoolean(r16);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r10, Object r11, Object r12, Type r13) throws IOException {
        SerializeWriter r14 = r10.out;
        Boolean r15 = (Boolean) r11;
        if (r15 != null) goto L10;
        if ((r14.features & SerializerFeature.WriteNullBooleanAsFalse.mask) == 0) goto L7;
        r14.write("false");
        return;
    L7:
        r14.writeNull();
        return;
    L10:
        if (r15.booleanValue() == false) goto L12;
        r14.write("true");
        return;
    L12:
        r14.write("false");
    }
}
