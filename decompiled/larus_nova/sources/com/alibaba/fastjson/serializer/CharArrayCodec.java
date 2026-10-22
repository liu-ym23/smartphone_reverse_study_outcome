package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class CharArrayCodec implements ObjectDeserializer {
    public CharArrayCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T deserialze(DefaultJSONParser r100) {
        JSONLexer r101 = r100.lexer;
        if (r101.token() != 4) goto L7;
        String r102 = r101.stringVal();
        r101.nextToken(16);
        return (T) r102.toCharArray();
    L7:
        if (r101.token() != 2) goto L10;
        Number r103 = r101.integerValue();
        r101.nextToken(16);
        return (T) r103.toString().toCharArray();
    L10:
        Object r104 = r100.parse();
        if ((r104 instanceof String) == false) goto L15;
        return (T) ((String) r104).toCharArray();
    L15:
        if ((r104 instanceof Collection) == false) goto L32;
        Collection r105 = (Collection) r104;
        Iterator r106 = r105.iterator();
    L17:
        boolean r107 = true;
        if (r106.hasNext() == false) goto L24;
        Object r108 = r106.next();
        if ((r108 instanceof String) == false) goto L17;
        if (((String) r108).length() == 1) goto L17;
        r107 = false;
    L24:
        if (r107 == false) goto L31;
        char[] r109 = new char[r105.size()];
        Iterator r110 = r105.iterator();
        int r111 = 0;
    L27:
        if (r110.hasNext() == false) goto L29;
        r109[r111] = ((String) r110.next()).charAt(0);
        r111 = r111 + 1;
        goto L27
    L29:
        return r109;
    L31:
        throw new JSONException("can not cast to char[]");
    L32:
        if (r104 != null) goto L35;
        return null;
    L35:
        return (T) JSON.toJSONString(r104).toCharArray();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        return (T) deserialze(r100);
    }
}
