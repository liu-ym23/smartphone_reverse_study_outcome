package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig r10, Class<?> r11) {
        super(r10, r11, r11);
    }

    @Override // com.alibaba.fastjson.parser.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r18, Type r19, Object r20) {
        JSONLexer r10 = r18.lexer;
        int r11 = r10.token;
        Throwable r12 = null;
        if (r11 != 8) goto L7;
        r10.nextToken();
        return null;
    L7:
        if (r18.resolveStatus != 2) goto L10;
        r18.resolveStatus = 0;
    L12:
        if (r19 != null) goto L14;
    L18:
        Class<?> r13 = null;
    L19:
        HashMap r14 = new HashMap();
        Throwable r15 = null;
        String r16 = null;
        StackTraceElement[] r17 = null;
    L20:
        String r110 = r10.scanSymbol(r18.symbolTable);
        if (r110 != null) goto L27;
        int r21 = r10.token;
        if (r21 == 13) goto L24;
        if (r21 != 16) goto L27;
    L24:
        r10.nextToken(16);
    L54:
        if (r13 != null) goto L97;
        Object r22 = (T) new Exception(r16, r15);
    L89:
        if (r17 == null) goto L91;
        ((Throwable) r22).setStackTrace(r17);
    L91:
        return (T) r22;
    L97:
        Constructor<?>[] r23 = r13.getConstructors();     // Catch: Exception -> L69
        int r24 = r23.length;     // Catch: Exception -> L69
        Constructor<?> r25 = null;
        Constructor<?> r26 = null;
        Constructor<?> r27 = null;
        int r28 = 0;
    L57:
        if (r28 >= r24) goto L79;
        Constructor<?> r29 = r23[r28];     // Catch: Exception -> L69
        if (r29.getParameterTypes().length != 0) goto L65;
        r27 = r29;
    L78:
        r28 = r28 + 1;     // Catch: Exception -> L69
        goto L57
    L65:
        if (r29.getParameterTypes().length != 1) goto L72;
        if (r29.getParameterTypes()[0] != String.class) goto L72;
        r26 = r29;
    L72:
        if (r29.getParameterTypes().length != 2) goto L78;
        if (r29.getParameterTypes()[0] != String.class) goto L78;
        if (r29.getParameterTypes()[1] != Throwable.class) goto L78;
        r25 = r29;
        goto L78
    L79:
        if (r25 == null) goto L81;
        r12 = (Throwable) r25.newInstance(new Object[]{r16, r15});     // Catch: Exception -> L69
    L85:
        if (r12 != null) goto L88;
        r22 = (T) new Exception(r16, r15);
        goto L89
    L88:
        r22 = (T) r12;
        goto L89
    L81:
        if (r26 == null) goto L83;
        r12 = (Throwable) r26.newInstance(new Object[]{r16});     // Catch: Exception -> L69
        goto L85
    L83:
        if (r27 == null) goto L85;
        r12 = (Throwable) r27.newInstance(null);     // Catch: Exception -> L69
    L69:
        e = move-exception;
        throw new JSONException("create instance error", e);
    L27:
        r10.nextTokenWithChar(':');
        if (JSON.DEFAULT_TYPE_KEY.equals(r110) == false) goto L35;
        if (r10.token != 4) goto L33;
        r13 = TypeUtils.loadClass(r10.stringVal(), r18.config.defaultClassLoader);
        r10.nextToken(16);
    L52:
        if (r10.token != 13) goto L20;
        r10.nextToken(16);
        goto L54
    L33:
        throw new JSONException("syntax error");
    L35:
        if ("message".equals(r110) == false) goto L45;
        int r30 = r10.token;
        if (r30 != 8) goto L39;
        String r31 = null;
    L41:
        r10.nextToken();
        r16 = r31;
        goto L52
    L39:
        if (r30 != 4) goto L43;
        r31 = r10.stringVal();
        goto L41
    L43:
        throw new JSONException("syntax error");
    L45:
        if ("cause".equals(r110) == false) goto L48;
        r15 = (Throwable) deserialze(r18, null, "cause");
        goto L52
    L48:
        if ("stackTrace".equals(r110) == false) goto L50;
        r17 = (StackTraceElement[]) r18.parseObject(StackTraceElement[].class);
        goto L52
    L50:
        r14.put(r110, r18.parse());
        goto L52
    L14:
        if ((r19 instanceof Class) == false) goto L18;
        r13 = (Class) r19;
        if (Throwable.class.isAssignableFrom(r13) == false) goto L18;
    L10:
        if (r11 == 12) goto L12;
        throw new JSONException("syntax error");
    }
}
