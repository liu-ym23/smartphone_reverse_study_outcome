package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class StringCodec implements ObjectSerializer, ObjectDeserializer {
    public static StringCodec instance;

    public StringCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    static {
        instance = new StringCodec();
    }

    public static <T> T deserialze(DefaultJSONParser r100) {
        JSONLexer r101 = r100.getLexer();
        if (r101.token() != 4) goto L7;
        T r102 = (T) r101.stringVal();
        r101.nextToken(16);
        return r102;
    L7:
        if (r101.token() != 2) goto L10;
        T r103 = (T) r101.numberString();
        r101.nextToken(16);
        return r103;
    L10:
        Object r104 = r100.parse();
        if (r104 != null) goto L15;
        return null;
    L15:
        return (T) r104.toString();
    }

    public void write(JSONSerializer r100, String r101) {
        SerializeWriter r102 = r100.out;
        if (r101 != null) goto L6;
        r102.writeNull(SerializerFeature.WriteNullStringAsEmpty);
        return;
    L6:
        r102.writeString(r101);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        if (r101 != StringBuffer.class) goto L14;
        JSONLexer r103 = r100.lexer;
        if (r103.token() != 4) goto L8;
        String r104 = r103.stringVal();
        r103.nextToken(16);
        return (T) new StringBuffer(r104);
    L8:
        Object r105 = r100.parse();
        if (r105 != null) goto L12;
        return null;
    L12:
        return (T) new StringBuffer(r105.toString());
    L14:
        if (r101 != StringBuilder.class) goto L25;
        JSONLexer r106 = r100.lexer;
        if (r106.token() != 4) goto L19;
        String r107 = r106.stringVal();
        r106.nextToken(16);
        return (T) new StringBuilder(r107);
    L19:
        Object r108 = r100.parse();
        if (r108 != null) goto L23;
        return null;
    L23:
        return (T) new StringBuilder(r108.toString());
    L25:
        return (T) deserialze(r100);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        write(r100, (String) r101);
    }
}
