package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class JSONPDeserializer implements ObjectDeserializer {
    public static final JSONPDeserializer instance = null;

    public JSONPDeserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 0;
    }

    static {
        instance = new JSONPDeserializer();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.alibaba.fastjson.JSONPObject] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        JSONLexerBase r103 = (JSONLexerBase) r100.getLexer();
        String r104 = r103.scanSymbolUnQuoted(r100.getSymbolTable());
        r103.nextToken();
        int r105 = r103.token();
        if (r105 != 25) goto L5;
        String r106 = r104 + ".";
        r104 = r106 + r103.scanSymbolUnQuoted(r100.getSymbolTable());
        r103.nextToken();
        r105 = r103.token();
    L5:
        ?? r107 = (T) new JSONPObject(r104);
        if (r105 != 10) goto L20;
        r103.nextToken();
    L8:
        r107.addParameter(r100.parse());
        int r108 = r103.token();
        if (r108 != 16) goto L12;
        r103.nextToken();
        goto L8
    L12:
        if (r108 != 11) goto L18;
        r103.nextToken();
        if (r103.token() != 24) goto L16;
        r103.nextToken();
    L16:
        return r107;
    L18:
        throw new JSONException("illegal jsonp : " + r103.info());
    L20:
        throw new JSONException("illegal jsonp : " + r103.info());
    }
}
