package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes3.dex */
public class AtomicCodec implements ObjectSerializer, ObjectDeserializer {
    public static final AtomicCodec instance = null;

    public AtomicCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    static {
        instance = new AtomicCodec();
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.util.concurrent.atomic.AtomicIntegerArray] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        if (r100.lexer.token() != 8) goto L6;
        r100.lexer.nextToken(16);
        return null;
    L6:
        JSONArray r103 = new JSONArray();
        r100.parseArray(r103);
        int r104 = 0;
        if (r101 != AtomicIntegerArray.class) goto L13;
        ?? r105 = (T) new AtomicIntegerArray(r103.size());
    L10:
        if (r104 >= r103.size()) goto L12;
        r105.set(r104, r103.getInteger(r104).intValue());
        r104 = r104 + 1;
        goto L10
    L12:
        return r105;
    L13:
        ?? r106 = (T) new AtomicLongArray(r103.size());
    L15:
        if (r104 >= r103.size()) goto L17;
        r106.set(r104, r103.getLong(r104).longValue());
        r104 = r104 + 1;
        goto L15
    L17:
        return r106;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if ((r101 instanceof AtomicInteger) == false) goto L7;
        r105.writeInt(((AtomicInteger) r101).get());
        return;
    L7:
        if ((r101 instanceof AtomicLong) == false) goto L11;
        r105.writeLong(((AtomicLong) r101).get());
        return;
    L11:
        if ((r101 instanceof AtomicBoolean) == true) goto L13;
        if (r101 != null) goto L21;
        r105.writeNull(SerializerFeature.WriteNullListAsEmpty);
        return;
    L21:
        int r106 = 0;
        if ((r101 instanceof AtomicIntegerArray) == false) goto L31;
        AtomicIntegerArray r107 = (AtomicIntegerArray) r101;
        int r108 = r107.length();
        r105.write(91);
    L24:
        if (r106 >= r108) goto L29;
        int r109 = r107.get(r106);
        if (r106 == 0) goto L28;
        r105.write(44);
    L28:
        r105.writeInt(r109);
        r106 = r106 + 1;
        goto L24
    L29:
        r105.write(93);
        return;
    L31:
        AtomicLongArray r110 = (AtomicLongArray) r101;
        int r111 = r110.length();
        r105.write(91);
    L32:
        if (r106 >= r111) goto L37;
        long r112 = r110.get(r106);
        if (r106 == 0) goto L36;
        r105.write(44);
    L36:
        r105.writeLong(r112);
        r106 = r106 + 1;
        goto L32
    L37:
        r105.write(93);
        return;
    L13:
        if (((AtomicBoolean) r101).get() == false) goto L15;
        String r113 = "true";
    L16:
        r105.append(r113);
        return;
    L15:
        r113 = "false";
        goto L16
    }
}
