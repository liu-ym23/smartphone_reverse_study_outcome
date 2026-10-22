package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class MiscCodec implements ObjectSerializer, ObjectDeserializer {
    public static final MiscCodec instance = null;

    static {
        instance = new MiscCodec();
    }

    private MiscCodec() {
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [T, java.text.SimpleDateFormat] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        if (r11 == StackTraceElement.class) goto L5;
        JSONLexer r13 = r10.lexer;
        if (r10.resolveStatus != 2) goto L17;
        r10.resolveStatus = 0;
        r10.accept(16);
        if (r13.token() != 4) goto L16;
        if ("val".equals(r13.stringVal()) == false) goto L14;
        r13.nextToken();
        r10.accept(17);
        Object r14 = r10.parse();
        r10.accept(13);
    L19:
        if (r14 != null) goto L22;
        return null;
    L22:
        if ((r14 instanceof String) == false) goto L83;
        String r15 = (String) r14;
        if (r15.length() != 0) goto L27;
        return null;
    L27:
        if (r11 != UUID.class) goto L31;
        return (T) UUID.fromString(r15);
    L31:
        if (r11 != Class.class) goto L35;
        return (T) TypeUtils.loadClass(r15, r10.config.defaultClassLoader);
    L35:
        if (r11 != Locale.class) goto L47;
        String[] r16 = r15.split("_");
        if (r16.length != 1) goto L41;
        return (T) new Locale(r16[0]);
    L41:
        if (r16.length != 2) goto L45;
        return (T) new Locale(r16[0], r16[1]);
    L45:
        return (T) new Locale(r16[0], r16[1], r16[2]);
    L47:
        if (r11 != URI.class) goto L51;
        return (T) URI.create(r15);
    L51:
        if (r11 != URL.class) goto L58;
        return (T) new URL(r15);
    L54:
        e = move-exception;
        throw new JSONException("create url error", e);
    L58:
        if (r11 != Pattern.class) goto L62;
        return (T) Pattern.compile(r15);
    L62:
        if (r11 != Charset.class) goto L66;
        return (T) Charset.forName(r15);
    L66:
        if (r11 != Currency.class) goto L70;
        return (T) Currency.getInstance(r15);
    L70:
        if (r11 != SimpleDateFormat.class) goto L74;
        ?? r17 = (T) new SimpleDateFormat(r15, r10.lexer.locale);
        r17.setTimeZone(r10.lexer.timeZone);
        return r17;
    L74:
        if (r11 == Character.TYPE) goto L81;
        if (r11 == Character.class) goto L81;
        return (T) TimeZone.getTimeZone(r15);
    L81:
        return (T) TypeUtils.castToChar(r15);
    L83:
        throw new JSONException("except string value");
    L14:
        throw new JSONException("syntax error");
    L16:
        throw new JSONException("syntax error");
    L17:
        r14 = r10.parse();
        goto L19
    L5:
        return (T) parseStackTraceElement(r10);
    }

    public <T> T parseStackTraceElement(DefaultJSONParser r15) {
        JSONLexer r14 = r15.lexer;
        if (r14.token() != 8) goto L7;
        r14.nextToken();
        return null;
    L7:
        if (r14.token() != 12) goto L9;
    L13:
        int r10 = 0;
        String r11 = null;
        String r12 = null;
        String r13 = null;
    L14:
        String r16 = r14.scanSymbol(r15.symbolTable);
        if (r16 != null) goto L22;
        if (r14.token() == 13) goto L18;
        if (r14.token() != 16) goto L22;
    L18:
        r14.nextToken(16);
    L90:
        return (T) new StackTraceElement(r11, r12, r13, r10);
    L22:
        r14.nextTokenWithChar(':');
        if ("className".equals(r16) == false) goto L33;
        if (r14.token() != 8) goto L28;
        r11 = null;
    L87:
        if (r14.token() != 13) goto L14;
        r14.nextToken(16);
        goto L90
    L28:
        if (r14.token() != 4) goto L31;
        r11 = r14.stringVal();
        goto L87
    L31:
        throw new JSONException("syntax error");
    L33:
        if ("methodName".equals(r16) == false) goto L43;
        if (r14.token() != 8) goto L38;
        r12 = null;
        goto L87
    L38:
        if (r14.token() != 4) goto L41;
        r12 = r14.stringVal();
        goto L87
    L41:
        throw new JSONException("syntax error");
    L43:
        if ("fileName".equals(r16) == false) goto L53;
        if (r14.token() != 8) goto L48;
        r13 = null;
        goto L87
    L48:
        if (r14.token() != 4) goto L51;
        r13 = r14.stringVal();
        goto L87
    L51:
        throw new JSONException("syntax error");
    L53:
        if ("lineNumber".equals(r16) == false) goto L63;
        if (r14.token() != 8) goto L58;
        r10 = 0;
        goto L87
    L58:
        if (r14.token() != 2) goto L61;
        r10 = r14.intValue();
        goto L87
    L61:
        throw new JSONException("syntax error");
    L63:
        if ("nativeMethod".equals(r16) == false) goto L76;
        if (r14.token() != 8) goto L68;
        r14.nextToken(16);
        goto L87
    L68:
        if (r14.token() != 6) goto L71;
        r14.nextToken(16);
        goto L87
    L71:
        if (r14.token() != 7) goto L74;
        r14.nextToken(16);
        goto L87
    L74:
        throw new JSONException("syntax error");
    L76:
        if (r16 != JSON.DEFAULT_TYPE_KEY) goto L94;
        if (r14.token() != 4) goto L85;
        String r17 = r14.stringVal();
        if (r17.equals("java.lang.StackTraceElement") == true) goto L87;
        throw new JSONException("syntax error : " + r17);
    L85:
        if (r14.token() == 8) goto L87;
        throw new JSONException("syntax error");
    L94:
        throw new JSONException("syntax error : " + r16);
    L9:
        if (r14.token() == 16) goto L13;
        throw new JSONException("syntax error: " + JSONToken.name(r14.token()));
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r10, Object r11, Object r12, Type r13) throws IOException {
        SerializeWriter r14 = r10.out;
        if (r11 != null) goto L19;
        if (r13 != Character.TYPE) goto L7;
    L16:
        r10.write("");
        return;
    L7:
        if (r13 == Character.class) goto L16;
        if ((r14.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) goto L12;
    L15:
        r14.writeNull();
        return;
    L12:
        if (Enumeration.class.isAssignableFrom(TypeUtils.getClass(r13)) == false) goto L15;
        r14.write("[]");
        return;
    L19:
        if ((r11 instanceof Pattern) == false) goto L22;
        r10.write(((Pattern) r11).pattern());
        return;
    L22:
        if ((r11 instanceof TimeZone) == false) goto L25;
        r10.write(((TimeZone) r11).getID());
        return;
    L25:
        if ((r11 instanceof Currency) == false) goto L28;
        r10.write(((Currency) r11).getCurrencyCode());
        return;
    L28:
        if ((r11 instanceof Class) == false) goto L31;
        r10.write(((Class) r11).getName());
        return;
    L31:
        if ((r11 instanceof Character) == false) goto L36;
        Character r15 = (Character) r11;
        if (r15.charValue() != 0) goto L35;
        r10.write("\u0000");
        return;
    L35:
        r10.write(r15.toString());
        return;
    L36:
        int r16 = 0;
        if ((r11 instanceof SimpleDateFormat) == false) goto L46;
        String r17 = ((SimpleDateFormat) r11).toPattern();
        if ((r14.features & SerializerFeature.WriteClassName.mask) != 0) goto L41;
    L44:
        r14.writeString(r17);
        return;
    L41:
        if (r11.getClass() == r13) goto L44;
        r14.write(123);
        r14.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
        r10.write(r11.getClass().getName());
        r14.write(44);
        r14.writeFieldName("val", false);
        r14.writeString(r17);
        r14.write(125);
        return;
    L46:
        if ((r11 instanceof JSONStreamAware) == false) goto L49;
        ((JSONStreamAware) r11).writeJSONString(r14);
        return;
    L49:
        if ((r11 instanceof JSONAware) == false) goto L52;
        r14.write(((JSONAware) r11).toJSONString());
        return;
    L52:
        if ((r11 instanceof JSONSerializable) == false) goto L55;
        ((JSONSerializable) r11).write(r10, r12, r13);
        return;
    L55:
        if ((r11 instanceof Enumeration) == true) goto L57;
        r10.write(r11.toString());
        return;
    L57:
        if ((r14.features & SerializerFeature.WriteClassName.mask) != 0) goto L59;
    L61:
        Type r18 = null;
    L62:
        Enumeration r19 = (Enumeration) r11;
        SerialContext r20 = r10.context;
        r10.setContext(r20, r11, r12, 0);
        r14.write(91);     // Catch: Throwable -> L69
    L65:
        if (r19.hasMoreElements() == false) goto L75;
        Object r21 = r19.nextElement();     // Catch: Throwable -> L69
        int r22 = r16 + 1;     // Catch: Throwable -> L69
        if (r16 == 0) goto L71;
        r14.write(44);     // Catch: Throwable -> L69
    L71:
        if (r21 != null) goto L73;
        r14.writeNull();     // Catch: Throwable -> L69
    L74:
        r16 = r22;
        goto L65
    L73:
        Class<?> r23 = r21.getClass();     // Catch: Throwable -> L69
        r10.config.get(r23).write(r10, r21, Integer.valueOf(r16), r18);     // Catch: Throwable -> L69
        goto L74
    L75:
        r14.write(93);     // Catch: Throwable -> L69
        r10.context = r20;
        return;
    L69:
        th = move-exception;
        r10.context = r20;
        throw th;
    L59:
        if ((r13 instanceof ParameterizedType) == false) goto L61;
        r18 = ((ParameterizedType) r13).getActualTypeArguments()[0];
        goto L62
    }
}
