package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ListTypeFieldDeserializer extends FieldDeserializer {
    private final boolean array;
    private ObjectDeserializer deserializer;
    private final Type itemType;

    public ListTypeFieldDeserializer(ParserConfig r10, Class<?> r11, FieldInfo r12) {
        super(r11, r12, 14);
        Type r13 = r12.fieldType;
        Class<?> r14 = r12.fieldClass;
        if ((r13 instanceof ParameterizedType) == false) goto L6;
        this.itemType = ((ParameterizedType) r13).getActualTypeArguments()[0];
        this.array = false;
        return;
    L6:
        if (r14.isArray() == false) goto L8;
        this.itemType = r14.getComponentType();
        this.array = true;
        return;
    L8:
        this.itemType = Object.class;
        this.array = false;
    }

    public final void parseArray(DefaultJSONParser r18, Type r19, Collection r20) {
        Type r10 = this.itemType;
        ObjectDeserializer r11 = this.deserializer;
        if ((r19 instanceof ParameterizedType) == false) goto L40;
        Class r12 = null;
        if ((r10 instanceof TypeVariable) == false) goto L22;
        TypeVariable r13 = (TypeVariable) r10;
        ParameterizedType r14 = (ParameterizedType) r19;
        if ((r14.getRawType() instanceof Class) == false) goto L9;
        r12 = (Class) r14.getRawType();
    L9:
        if (r12 == null) goto L16;
        int r15 = r12.getTypeParameters().length;
        int r16 = 0;
    L11:
        if (r16 >= r15) goto L16;
        if (r12.getTypeParameters()[r16].getName().equals(r13.getName()) == true) goto L17;
        r16 = r16 + 1;
    L17:
        if (r16 == (-1)) goto L40;
        r10 = r14.getActualTypeArguments()[r16];
        if (r10.equals(this.itemType) == true) goto L40;
        r11 = r18.config.getDeserializer(r10);
    L16:
        r16 = -1;
        goto L17
    L22:
        if ((r10 instanceof ParameterizedType) == false) goto L40;
        ParameterizedType r17 = (ParameterizedType) r10;
        Type[] r110 = r17.getActualTypeArguments();
        if (r110.length != 1) goto L40;
        Type r111 = r110[0];
        if ((r111 instanceof TypeVariable) == false) goto L40;
        TypeVariable r112 = (TypeVariable) r111;
        ParameterizedType r113 = (ParameterizedType) r19;
        if ((r113.getRawType() instanceof Class) == false) goto L30;
        r12 = (Class) r113.getRawType();
    L30:
        if (r12 == null) goto L37;
        int r114 = r12.getTypeParameters().length;
        int r115 = 0;
    L32:
        if (r115 >= r114) goto L37;
        if (r12.getTypeParameters()[r115].getName().equals(r112.getName()) == true) goto L38;
        r115 = r115 + 1;
    L38:
        if (r115 == (-1)) goto L40;
        r110[0] = r113.getActualTypeArguments()[r115];
        r10 = new ParameterizedTypeImpl(r110, r17.getOwnerType(), r17.getRawType());
    L37:
        r115 = -1;
    L40:
        JSONLexer r21 = r18.lexer;
        if (r11 != null) goto L43;
        r11 = r18.config.getDeserializer(r10);
        this.deserializer = r11;
    L43:
        int r22 = r21.token;
        if (r22 == 14) goto L53;
        if (r22 != 12) goto L48;
        r20.add(r11.deserialze(r18, r10, 0));
        return;
    L48:
        String r23 = "exepct '[', but " + JSONToken.name(r21.token);
        if (r19 == null) goto L52;
        r23 = r23 + ", type : " + r19;
    L52:
        throw new JSONException(r23);
    L53:
        int r24 = 0;
        char r25 = r21.ch;
        char r116 = JSONLexer.EOI;
        if (r25 != '[') goto L60;
        int r26 = r21.bp + 1;
        r21.bp = r26;
        if (r26 < r21.len) goto L58;
        char r27 = 26;
    L59:
        r21.ch = r27;
        r21.token = 14;
    L76:
        int r28 = r21.token;
        if (r28 == 16) goto L78;
        if (r28 == 15) goto L81;
        r20.add(r11.deserialze(r18, r10, Integer.valueOf(r24)));
        if (r18.resolveStatus != 1) goto L93;
        r18.checkListResolve(r20);
    L93:
        if (r21.token != 16) goto L112;
        char r29 = r21.ch;
        if (r29 != '[') goto L101;
        int r30 = r21.bp + 1;
        r21.bp = r30;
        if (r30 < r21.len) goto L99;
        char r31 = 26;
    L100:
        r21.ch = r31;
        r21.token = 14;
        goto L112
    L99:
        r31 = r21.text.charAt(r30);
        goto L100
    L101:
        if (r29 != '{') goto L108;
        int r32 = r21.bp + 1;
        r21.bp = r32;
        if (r32 < r21.len) goto L105;
        char r33 = 26;
    L106:
        r21.ch = r33;
        r21.token = 12;
        goto L112
    L105:
        r33 = r21.text.charAt(r32);
        goto L106
    L108:
        if (r29 != '\"') goto L110;
        r21.scanString();
        goto L112
    L110:
        r21.nextToken();
    L112:
        r24 = r24 + 1;
        goto L76
    L81:
        if (r21.ch != ',') goto L87;
        int r34 = r21.bp + 1;
        r21.bp = r34;
        if (r34 >= r21.len) goto L86;
        r116 = r21.text.charAt(r34);
    L86:
        r21.ch = r116;
        r21.token = 16;
        return;
    L87:
        r21.nextToken();
        return;
    L78:
        r21.nextToken();
        goto L76
    L58:
        r27 = r21.text.charAt(r26);
        goto L59
    L60:
        if (r25 != '{') goto L66;
        int r35 = r21.bp + 1;
        r21.bp = r35;
        if (r35 < r21.len) goto L64;
        char r36 = 26;
    L65:
        r21.ch = r36;
        r21.token = 12;
        goto L76
    L64:
        r36 = r21.text.charAt(r35);
        goto L65
    L66:
        if (r25 != '\"') goto L69;
        r21.scanString();
        goto L76
    L69:
        if (r25 != ']') goto L75;
        int r37 = r21.bp + 1;
        r21.bp = r37;
        if (r37 < r21.len) goto L73;
        char r38 = 26;
    L74:
        r21.ch = r38;
        r21.token = 15;
        goto L76
    L73:
        r38 = r21.text.charAt(r37);
        goto L74
    L75:
        r21.nextToken();
        goto L76
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser r10, Object r11, Type r12, Map<String, Object> r13) {
        if (r10.lexer.token != 8) goto L7;
        setValue(r11, null);
        r10.lexer.nextToken();
        return;
    L7:
        if (this.array == false) goto L9;
        JSONArray r14 = new JSONArray();
        r14.setComponentType(this.itemType);
        JSONArray r15 = r14;
        List r16 = r14;
    L10:
        ParseContext r17 = r10.contex;
        r10.setContext(r17, r11, this.fieldInfo.name);
        parseArray(r10, r12, r16);
        r10.setContext(r17);
        Object r18 = r16;
        if (this.array == false) goto L13;
        Object r19 = r16.toArray((Object[]) Array.newInstance((Class) this.itemType, r16.size()));
        r15.setRelatedArray(r19);
        r18 = r19;
    L13:
        if (r11 != null) goto L15;
        r13.put(this.fieldInfo.name, r18);
        return;
    L15:
        setValue(r11, r18);
        return;
    L9:
        r16 = new ArrayList();
        r15 = null;
        goto L10
    }
}
