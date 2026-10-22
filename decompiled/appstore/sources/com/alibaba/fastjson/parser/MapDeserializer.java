package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import com.tmall.wireless.tangram.expression.TangramExprSupport;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance;

    static {
        instance = new MapDeserializer();
    }

    public MapDeserializer() {
    }

    public static Map parseMap(DefaultJSONParser r10, Map<String, Object> r11, Type r12, Object r13) {
        JSONLexer r14 = r10.lexer;
        if (r14.token != 12) goto L75;
        ParseContext r15 = r10.contex;
    L76:
        r14.skipWhitespace();     // Catch: Throwable -> L10
        char r16 = r14.ch;     // Catch: Throwable -> L10
    L7:
        if (r16 != ',') goto L13;
        r14.next();     // Catch: Throwable -> L10
        r14.skipWhitespace();     // Catch: Throwable -> L10
        r16 = r14.ch;     // Catch: Throwable -> L10
        goto L7
    L13:
        if (r16 != '\"') goto L20;
        String r17 = r14.scanSymbol(r10.symbolTable, TokenParser.DQUOTE);     // Catch: Throwable -> L10
        r14.skipWhitespace();     // Catch: Throwable -> L10
        if (r14.ch != ':') goto L18;
    L33:
        r14.next();     // Catch: Throwable -> L10
        r14.skipWhitespace();     // Catch: Throwable -> L10
        r14.sp = 0;     // Catch: Throwable -> L10
        if (r17 != JSON.DEFAULT_TYPE_KEY) goto L52;
        if (r14.isEnabled(Feature.DisableSpecialKeyDetect) == true) goto L52;
        Class<?> r18 = TypeUtils.loadClass(r14.scanSymbol(r10.symbolTable, TokenParser.DQUOTE), r10.config.defaultClassLoader);     // Catch: Throwable -> L10
        if (r18 != r11.getClass()) goto L44;
        r14.nextToken(16);     // Catch: Throwable -> L10
        if (r14.token != 13) goto L76;
        r14.nextToken(16);     // Catch: Throwable -> L10
        r10.setContext(r15);
        return r11;
    L44:
        ObjectDeserializer r19 = r10.config.getDeserializer(r18);     // Catch: Throwable -> L10
        r14.nextToken(16);     // Catch: Throwable -> L10
        r10.resolveStatus = 2;     // Catch: Throwable -> L10
        if (r15 != null) goto L47;
    L49:
        Map r110 = (Map) r19.deserialze(r10, r18, r13);     // Catch: Throwable -> L10
        r10.setContext(r15);
        return r110;
    L47:
        if ((r13 instanceof Integer) == true) goto L49;
        r10.popContext();     // Catch: Throwable -> L10
    L52:
        r14.nextToken();     // Catch: Throwable -> L10
        r10.setContext(r15);     // Catch: Throwable -> L10
        if (r14.token != 8) goto L55;
        r14.nextToken();     // Catch: Throwable -> L10
        Object r20 = null;
    L56:
        r11.put(r17, r20);     // Catch: Throwable -> L10
        if (r10.resolveStatus != 1) goto L59;
        r10.checkMapResolve(r11, r17);     // Catch: Throwable -> L10
    L59:
        r10.setContext(r15, r20, r17);     // Catch: Throwable -> L10
        int r21 = r14.token;     // Catch: Throwable -> L10
        if (r21 == 20) goto L68;
        if (r21 == 15) goto L68;
        if (r21 != 13) goto L76;
        r14.nextToken();     // Catch: Throwable -> L10
        r10.setContext(r15);
        return r11;
    L68:
        r10.setContext(r15);
        return r11;
    L55:
        r20 = r10.parseObject(r12, r17);     // Catch: Throwable -> L10
        goto L56
    L18:
        throw new JSONException("syntax error, " + r14.info());     // Catch: Throwable -> L10
    L20:
        if (r16 == '}') goto L21;
        if (r16 != '\'') goto L31;
        r17 = r14.scanSymbol(r10.symbolTable, '\'');     // Catch: Throwable -> L10
        r14.skipWhitespace();     // Catch: Throwable -> L10
        if (r14.ch == ':') goto L33;
        throw new JSONException("syntax error, " + r14.info());     // Catch: Throwable -> L10
    L31:
        r17 = r14.scanSymbolUnQuoted(r10.symbolTable);     // Catch: Throwable -> L10
        r14.skipWhitespace();     // Catch: Throwable -> L10
        char r22 = r14.ch;     // Catch: Throwable -> L10
        if (r22 == ':') goto L33;
        throw new JSONException("expect ':' at " + r14.pos + ", actual " + r22);     // Catch: Throwable -> L10
    L21:
        r14.next();     // Catch: Throwable -> L10
        r14.sp = 0;     // Catch: Throwable -> L10
        r14.nextToken(16);     // Catch: Throwable -> L10
        r10.setContext(r15);
        return r11;
    L10:
        th = move-exception;
        r10.setContext(r15);
        throw th;
    L75:
        throw new JSONException("syntax error, expect {, actual " + r14.token);
    }

    public Map<?, ?> createMap(Type r10) {
        if (r10 != Properties.class) goto L7;
        return new Properties();
    L7:
        if (r10 != Hashtable.class) goto L11;
        return new Hashtable();
    L11:
        if (r10 != IdentityHashMap.class) goto L15;
        return new IdentityHashMap();
    L15:
        if (r10 == SortedMap.class) goto L59;
        if (r10 == TreeMap.class) goto L59;
        if (r10 == ConcurrentMap.class) goto L57;
        if (r10 == ConcurrentHashMap.class) goto L57;
        if (r10 == Map.class) goto L55;
        if (r10 == HashMap.class) goto L55;
        if (r10 != LinkedHashMap.class) goto L34;
        return new LinkedHashMap();
    L34:
        if (r10 != JSONObject.class) goto L38;
        return new JSONObject();
    L38:
        if ((r10 instanceof ParameterizedType) == false) goto L45;
        ParameterizedType r11 = (ParameterizedType) r10;
        Type r12 = r11.getRawType();
        if (EnumMap.class.equals(r12) == false) goto L44;
        return new EnumMap((Class) r11.getActualTypeArguments()[0]);
    L44:
        return createMap(r12);
    L45:
        Class r13 = (Class) r10;
        if (r13.isInterface() == true) goto L53;
        return (Map) r13.newInstance();
    L49:
        e = move-exception;
        throw new JSONException("unsupport type " + r10, e);
    L53:
        throw new JSONException("unsupport type " + r10);
    L55:
        return new HashMap();
    L57:
        return new ConcurrentHashMap();
    L59:
        return new TreeMap();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        if (r11 == JSONObject.class) goto L5;
    L8:
        JSONLexer r13 = r10.lexer;
        if (r13.token != 8) goto L12;
        r13.nextToken(16);
        return null;
    L12:
        Map<?, ?> r14 = createMap(r11);
        ParseContext r15 = r10.contex;
        r10.setContext(r15, r14, r12);     // Catch: Throwable -> L20
        if ((r11 instanceof ParameterizedType) == false) goto L25;
        ParameterizedType r16 = (ParameterizedType) r11;     // Catch: Throwable -> L20
        Type r17 = r16.getActualTypeArguments()[0];     // Catch: Throwable -> L20
        Type r18 = r16.getActualTypeArguments()[1];     // Catch: Throwable -> L20
        if (String.class != r17) goto L22;
        T r19 = (T) parseMap(r10, r14, r18, r12);
        r10.setContext(r15);
        return r19;
    L22:
        T r20 = (T) parseMap(r10, r14, r17, r18, r12);
        r10.setContext(r15);
        return r20;
    L25:
        T r21 = (T) r10.parseObject(r14, r12);
        r10.setContext(r15);
        return r21;
    L20:
        th = move-exception;
        r10.setContext(r15);
        throw th;
    L5:
        if (r10.fieldTypeResolver != null) goto L8;
        return (T) r10.parseObject();
    }

    public static Object parseMap(DefaultJSONParser r16, Map<Object, Object> r17, Type r18, Type r19, Object r20) {
        JSONLexer r10 = r16.lexer;
        int r11 = r10.token;
        int r12 = 16;
        if (r11 == 12) goto L8;
        if (r11 == 16) goto L8;
        throw new JSONException("syntax error, expect {, actual " + JSONToken.name(r11));
    L8:
        ObjectDeserializer r13 = r16.config.getDeserializer(r18);
        ObjectDeserializer r14 = r16.config.getDeserializer(r19);
        r10.nextToken();
        ParseContext r15 = r16.contex;
    L72:
        int r21 = r10.token;     // Catch: Throwable -> L14
        if (r21 == 13) goto L11;
        if (r21 != 4) goto L47;
        if (r10.sp != 4) goto L47;
        if (r10.text.startsWith("$ref", r10.np + 1) == false) goto L47;
        if (r10.isEnabled(Feature.DisableSpecialKeyDetect) == true) goto L47;
        r10.nextTokenWithChar(':');     // Catch: Throwable -> L14
        if (r10.token != 4) goto L45;
        String r22 = r10.stringVal();     // Catch: Throwable -> L14
        if ("..".equals(r22) == false) goto L30;
        Object r110 = r15.parent.object;     // Catch: Throwable -> L14
    L37:
        r10.nextToken(13);     // Catch: Throwable -> L14
        if (r10.token != 13) goto L43;
        r10.nextToken(16);     // Catch: Throwable -> L14
        r16.setContext(r15);
        return r110;
    L43:
        throw new JSONException("illegal ref");     // Catch: Throwable -> L14
    L30:
        if (TangramExprSupport.VAR_START.equals(r22) == false) goto L36;
        ParseContext r23 = r15;
    L32:
        ParseContext r24 = r23.parent;     // Catch: Throwable -> L14
        if (r24 == null) goto L35;
        r23 = r24;
        goto L32
    L35:
        r110 = r23.object;     // Catch: Throwable -> L14
        goto L37
    L36:
        r16.addResolveTask(new DefaultJSONParser.ResolveTask(r15, r22));     // Catch: Throwable -> L14
        r16.resolveStatus = 1;     // Catch: Throwable -> L14
        r110 = null;
        goto L37
    L45:
        throw new JSONException("illegal ref, " + JSONToken.name(r21));     // Catch: Throwable -> L14
    L47:
        if (r17.size() != 0) goto L59;
        if (r21 != 4) goto L59;
        if (JSON.DEFAULT_TYPE_KEY.equals(r10.stringVal()) == false) goto L59;
        if (r10.isEnabled(Feature.DisableSpecialKeyDetect) == true) goto L59;
        r10.nextTokenWithChar(':');     // Catch: Throwable -> L14
        r10.nextToken(16);     // Catch: Throwable -> L14
        if (r10.token == 13) goto L55;
        r10.nextToken();     // Catch: Throwable -> L14
        goto L59
    L55:
        r10.nextToken();     // Catch: Throwable -> L14
        r16.setContext(r15);
        return r17;
    L59:
        Object r25 = r13.deserialze(r16, r18, null);     // Catch: Throwable -> L14
        if (r10.token != 17) goto L69;
        r10.nextToken();     // Catch: Throwable -> L14
        Object r26 = r14.deserialze(r16, r19, r25);     // Catch: Throwable -> L14
        if (r16.resolveStatus != 1) goto L64;
        r16.checkMapResolve(r17, r25);     // Catch: Throwable -> L14
    L64:
        r17.put(r25, r26);     // Catch: Throwable -> L14
        if (r10.token != 16) goto L67;
        r10.nextToken();     // Catch: Throwable -> L14
    L67:
        r12 = 16;
        goto L72
    L69:
        throw new JSONException("syntax error, expect :, actual " + r10.token);     // Catch: Throwable -> L14
    L11:
        r10.nextToken(r12);     // Catch: Throwable -> L14
        r16.setContext(r15);
        return r17;
    L14:
        th = move-exception;
        r16.setContext(r15);
        throw th;
    }
}
