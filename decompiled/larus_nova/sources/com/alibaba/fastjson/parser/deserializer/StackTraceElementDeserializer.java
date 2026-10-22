package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.ss.texturerender.TextureRenderKeys;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class StackTraceElementDeserializer implements ObjectDeserializer {
    public static final StackTraceElementDeserializer instance = null;

    public StackTraceElementDeserializer() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    static {
        instance = new StackTraceElementDeserializer();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r110, Type r111, Object r112) {
        JSONLexer r100 = r110.lexer;
        if (r100.token() != 8) goto L7;
        r100.nextToken();
        return null;
    L7:
        if (r100.token() != 12) goto L9;
    L13:
        String r101 = null;
        String r102 = null;
        String r103 = null;
        int r104 = 0;
    L14:
        String r113 = r100.scanSymbol(r110.getSymbolTable());
        if (r113 != null) goto L24;
        if (r100.token() == 13) goto L18;
        if (r100.token() != 16) goto L24;
        if (r100.isEnabled(Feature.AllowArbitraryCommas) == false) goto L24;
    L18:
        r100.nextToken(16);
    L123:
        return (T) new StackTraceElement(r101, r102, r103, r104);
    L24:
        r100.nextTokenWithColon(4);
        if (PushClientConstants.TAG_CLASS_NAME.equals(r113) == false) goto L35;
        if (r100.token() != 8) goto L30;
        r101 = null;
    L120:
        if (r100.token() != 13) goto L14;
        r100.nextToken(16);
        goto L123
    L30:
        if (r100.token() != 4) goto L33;
        r101 = r100.stringVal();
        goto L120
    L33:
        throw new JSONException("syntax error");
    L35:
        if ("methodName".equals(r113) == false) goto L45;
        if (r100.token() != 8) goto L40;
        r102 = null;
        goto L120
    L40:
        if (r100.token() != 4) goto L43;
        r102 = r100.stringVal();
        goto L120
    L43:
        throw new JSONException("syntax error");
    L45:
        if ("fileName".equals(r113) == false) goto L55;
        if (r100.token() != 8) goto L50;
        r103 = null;
        goto L120
    L50:
        if (r100.token() != 4) goto L53;
        r103 = r100.stringVal();
        goto L120
    L53:
        throw new JSONException("syntax error");
    L55:
        if ("lineNumber".equals(r113) == false) goto L65;
        if (r100.token() != 8) goto L60;
        r104 = 0;
        goto L120
    L60:
        if (r100.token() != 2) goto L63;
        r104 = r100.intValue();
        goto L120
    L63:
        throw new JSONException("syntax error");
    L65:
        if ("nativeMethod".equals(r113) == false) goto L78;
        if (r100.token() != 8) goto L70;
        r100.nextToken(16);
        goto L120
    L70:
        if (r100.token() != 6) goto L73;
        r100.nextToken(16);
        goto L120
    L73:
        if (r100.token() != 7) goto L76;
        r100.nextToken(16);
        goto L120
    L76:
        throw new JSONException("syntax error");
    L78:
        if (r113 != JSON.DEFAULT_TYPE_KEY) goto L92;
        if (r100.token() != 4) goto L87;
        String r114 = r100.stringVal();
        if (r114.equals("java.lang.StackTraceElement") == true) goto L120;
        throw new JSONException("syntax error : ".concat(r114));
    L87:
        if (r100.token() == 8) goto L120;
        throw new JSONException("syntax error");
    L92:
        if (TextureRenderKeys.KEY_MODULE_NAME.equals(r113) == false) goto L102;
        if (r100.token() == 8) goto L120;
        if (r100.token() != 4) goto L100;
        r100.stringVal();
        goto L120
    L100:
        throw new JSONException("syntax error");
    L102:
        if ("moduleVersion".equals(r113) == false) goto L112;
        if (r100.token() == 8) goto L120;
        if (r100.token() != 4) goto L110;
        r100.stringVal();
        goto L120
    L110:
        throw new JSONException("syntax error");
    L112:
        if ("classLoaderName".equals(r113) == false) goto L127;
        if (r100.token() == 8) goto L120;
        if (r100.token() != 4) goto L125;
        r100.stringVal();
        goto L120
    L125:
        throw new JSONException("syntax error");
    L127:
        throw new JSONException("syntax error : " + r113);
    L9:
        if (r100.token() == 16) goto L13;
        throw new JSONException("syntax error: " + JSONToken.name(r100.token()));
    }
}
