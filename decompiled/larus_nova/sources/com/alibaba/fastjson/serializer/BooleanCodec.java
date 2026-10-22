package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class BooleanCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BooleanCodec instance = null;

    public BooleanCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 6;
    }

    static {
        instance = new BooleanCodec();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        JSONLexer r103 = r100.lexer;
    L25:
        e = move-exception;
        throw new JSONException("parseBoolean error, field : " + r102, e);
    L4:
        if (r103.token() != 6) goto L7;
        r103.nextToken(16);     // Catch: Exception -> L25
        Object r104 = (T) Boolean.TRUE;
    L21:
        if (r101 == AtomicBoolean.class) goto L23;
        return (T) r104;
    L23:
        return (T) new AtomicBoolean(((Boolean) r104).booleanValue());
    L7:
        if (r103.token() != 7) goto L10;
        r103.nextToken(16);     // Catch: Exception -> L25
        r104 = (T) Boolean.FALSE;
        goto L21
    L10:
        if (r103.token() != 2) goto L15;
        int r105 = r103.intValue();     // Catch: Exception -> L25
        r103.nextToken(16);     // Catch: Exception -> L25
        if (r105 != 1) goto L14;
        r104 = (T) Boolean.TRUE;
        goto L21
    L14:
        r104 = (T) Boolean.FALSE;
        goto L21
    L15:
        Object r106 = r100.parse();     // Catch: Exception -> L25
        if (r106 != null) goto L19;
        return null;
    L19:
        r104 = (T) TypeUtils.castToBoolean(r106);
        goto L21
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        Boolean r106 = (Boolean) r101;
        if (r106 != null) goto L7;
        r105.writeNull(SerializerFeature.WriteNullBooleanAsFalse);
        return;
    L7:
        if (r106.booleanValue() == false) goto L9;
        r105.write("true");
        return;
    L9:
        r105.write("false");
    }
}
