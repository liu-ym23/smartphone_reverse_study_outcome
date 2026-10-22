package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class CharacterCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CharacterCodec instance = null;

    public CharacterCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    static {
        instance = new CharacterCodec();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        Object r103 = r100.parse();
        if (r103 != null) goto L6;
        return null;
    L6:
        return (T) TypeUtils.castToChar(r103);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        Character r106 = (Character) r101;
        if (r106 != null) goto L7;
        r105.writeString("");
        return;
    L7:
        if (r106.charValue() != 0) goto L9;
        r105.writeString("\u0000");
        return;
    L9:
        r105.writeString(r106.toString());
    }
}
