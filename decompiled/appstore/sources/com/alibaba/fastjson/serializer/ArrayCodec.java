package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ArrayCodec implements ObjectSerializer, ObjectDeserializer {
    public static final ArrayCodec instance = null;

    static {
        instance = new ArrayCodec();
    }

    private ArrayCodec() {
    }

    private <T> T toObjectArray(DefaultJSONParser r10, Class<?> r11, JSONArray r12) {
        if (r12 != null) goto L5;
        return null;
    L5:
        int r13 = r12.size();
        T r14 = (T) Array.newInstance(r11, r13);
        int r15 = 0;
    L6:
        if (r15 >= r13) goto L19;
        Object r16 = r12.get(r15);
        if (r16 != r12) goto L11;
        Array.set(r14, r15, r14);
    L18:
        r15 = r15 + 1;
        goto L6
    L11:
        if (r11.isArray() == true) goto L13;
        r16 = TypeUtils.cast(r16, r11, r10.config);
    L17:
        Array.set(r14, r15, r16);
        goto L18
    L13:
        if (r11.isInstance(r16) == true) goto L17;
        r16 = toObjectArray(r10, r11, (JSONArray) r16);
        goto L17
    L19:
        r12.setRelatedArray(r14);
        r12.setComponentType(r11);
        return r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        JSONLexer r13 = r10.lexer;
        int r14 = r13.token();
        if (r14 != 8) goto L7;
        r13.nextToken(16);
        return null;
    L7:
        if (r11 != char[].class) goto L17;
        if (r14 != 4) goto L12;
        String r15 = r13.stringVal();
        r13.nextToken(16);
        return (T) r15.toCharArray();
    L12:
        if (r14 != 2) goto L16;
        Number r16 = r13.integerValue();
        r13.nextToken(16);
        return (T) r16.toString().toCharArray();
    L16:
        return (T) JSON.toJSONString(r10.parse()).toCharArray();
    L17:
        if (r14 != 4) goto L20;
        T r17 = (T) r13.bytesValue();
        r13.nextToken(16);
        return r17;
    L20:
        Class<?> r18 = ((Class) r11).getComponentType();
        JSONArray r19 = new JSONArray();
        r10.parseArray(r18, r19, r12);
        return (T) toObjectArray(r10, r18, r19);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer r10, Object r11, Object r12, Type r13) throws IOException {
        SerializeWriter r14 = r10.out;
        Object[] r15 = (Object[]) r11;
        if (r11 == null) goto L5;
        int r16 = r15.length;
        int r17 = r16 - 1;
        if (r17 != (-1)) goto L13;
        r14.append("[]");
        return;
    L13:
        SerialContext r18 = r10.context;
        int r19 = 0;
        r10.setContext(r18, r11, r12, 0);
        r14.write(91);     // Catch: Throwable -> L20
        if ((r14.features & SerializerFeature.PrettyFormat.mask) == 0) goto L26;
        r10.incrementIndent();     // Catch: Throwable -> L20
        r10.println();     // Catch: Throwable -> L20
    L17:
        if (r19 >= r16) goto L23;
        if (r19 == 0) goto L22;
        r14.write(44);     // Catch: Throwable -> L20
        r10.println();     // Catch: Throwable -> L20
    L22:
        r10.write(r15[r19]);     // Catch: Throwable -> L20
        r19 = r19 + 1;     // Catch: Throwable -> L20
        goto L17
    L23:
        r10.decrementIdent();     // Catch: Throwable -> L20
        r10.println();     // Catch: Throwable -> L20
        r14.write(93);     // Catch: Throwable -> L20
        r10.context = r18;
        return;
    L26:
        Class<?> r20 = null;
        ObjectSerializer r21 = null;
    L27:
        if (r19 >= r17) goto L42;
        Object r22 = r15[r19];     // Catch: Throwable -> L20
        if (r22 != null) goto L31;
        r14.append("null,");     // Catch: Throwable -> L20
    L41:
        r19 = r19 + 1;     // Catch: Throwable -> L20
        goto L27
    L31:
        IdentityHashMap<Object, SerialContext> r23 = r10.references;     // Catch: Throwable -> L20
        if (r23 != null) goto L34;
    L36:
        Class<?> r24 = r22.getClass();     // Catch: Throwable -> L20
        if (r24 != r20) goto L39;
        r21.write(r10, r22, null, null);     // Catch: Throwable -> L20
    L40:
        r14.write(44);     // Catch: Throwable -> L20
        goto L41
    L39:
        r21 = r10.config.get(r24);     // Catch: Throwable -> L20
        r21.write(r10, r22, null, null);     // Catch: Throwable -> L20
        r20 = r24;
        goto L40
    L34:
        if (r23.containsKey(r22) == false) goto L36;
        r10.writeReference(r22);     // Catch: Throwable -> L20
        goto L40
    L42:
        Object r110 = r15[r17];     // Catch: Throwable -> L20
        if (r110 != null) goto L45;
        r14.append("null]");     // Catch: Throwable -> L20
    L52:
        r10.context = r18;
        return;
    L45:
        IdentityHashMap<Object, SerialContext> r111 = r10.references;     // Catch: Throwable -> L20
        if (r111 != null) goto L48;
    L50:
        r10.writeWithFieldName(r110, Integer.valueOf(r17));     // Catch: Throwable -> L20
    L51:
        r14.write(93);     // Catch: Throwable -> L20
        goto L52
    L48:
        if (r111.containsKey(r110) == false) goto L50;
        r10.writeReference(r110);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r10.context = r18;
        throw th;
    L5:
        if ((r14.features & SerializerFeature.WriteNullListAsEmpty.mask) == 0) goto L7;
        r14.write("[]");
        return;
    L7:
        r14.writeNull();
    }
}
