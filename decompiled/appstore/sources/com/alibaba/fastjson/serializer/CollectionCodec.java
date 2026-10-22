package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CollectionCodec instance = null;

    static {
        instance = new CollectionCodec();
    }

    private CollectionCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v28, types: [T, com.alibaba.fastjson.JSONArray, java.util.Collection] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        Type r13 = null;
        if (r10.lexer.token() != 8) goto L7;
        r10.lexer.nextToken(16);
        return null;
    L7:
        if (r11 != JSONArray.class) goto L10;
        ?? r14 = (T) new JSONArray();
        r10.parseArray(r14);
        return r14;
    L10:
        Type r15 = r11;
    L12:
        if ((r15 instanceof Class) == true) goto L13;
        if ((r15 instanceof ParameterizedType) == false) goto L61;
        r15 = ((ParameterizedType) r15).getRawType();
        goto L12
    L61:
        throw new JSONException("TODO");
    L13:
        Class r16 = (Class) r15;
        Type r17 = Object.class;
        if (r16 != AbstractCollection.class) goto L16;
    L41:
        Collection r18 = (T) new ArrayList();
    L43:
        if ((r11 instanceof ParameterizedType) == false) goto L46;
        r17 = ((ParameterizedType) r11).getActualTypeArguments()[0];
    L55:
        r10.parseArray(r17, r18, r12);
        return (T) r18;
    L46:
        if ((r11 instanceof Class) == false) goto L52;
        Class r19 = (Class) r11;
        if (r19.getName().startsWith("java.") == true) goto L52;
        Type r20 = r19.getGenericSuperclass();
        if ((r20 instanceof ParameterizedType) == false) goto L52;
        r13 = ((ParameterizedType) r20).getActualTypeArguments()[0];
    L52:
        if (r13 == null) goto L55;
        r17 = r13;
        goto L55
    L16:
        if (r16 == Collection.class) goto L41;
        if (r16.isAssignableFrom(HashSet.class) == false) goto L22;
        r18 = (T) new HashSet();
        goto L43
    L22:
        if (r16.isAssignableFrom(LinkedHashSet.class) == false) goto L25;
        r18 = (T) new LinkedHashSet();
        goto L43
    L25:
        if (r16.isAssignableFrom(TreeSet.class) == false) goto L28;
        r18 = (T) new TreeSet();
        goto L43
    L28:
        if (r16.isAssignableFrom(ArrayList.class) == false) goto L31;
        r18 = (T) new ArrayList();
        goto L43
    L31:
        if (r16.isAssignableFrom(EnumSet.class) == true) goto L33;
        r18 = (T) ((Collection) r16.newInstance());
    L40:
        throw new JSONException("create instane error, class " + r16.getName());
    L33:
        if ((r11 instanceof ParameterizedType) == false) goto L35;
        Type r21 = ((ParameterizedType) r11).getActualTypeArguments()[0];
    L36:
        r18 = (T) EnumSet.noneOf((Class) r21);
        goto L43
    L35:
        r21 = r17;
        goto L36
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r10, Object r11, Object r12, Type r13) throws IOException {
        SerializeWriter r14 = r10.out;
        if (r11 == null) goto L5;
        int r15 = r14.features;
        SerializerFeature r16 = SerializerFeature.WriteClassName;
        int r17 = 0;
        if ((r15 & r16.mask) != 0) goto L12;
    L14:
        Type r18 = null;
    L15:
        Collection r19 = (Collection) r11;
        SerialContext r20 = r10.context;
        r10.setContext(r20, r11, r12, 0);
        if ((r14.features & r16.mask) == 0) goto L49;
        if (HashSet.class != r19.getClass()) goto L21;
        r14.append("Set");
        goto L49
    L21:
        if (TreeSet.class != r19.getClass()) goto L49;
        r14.append("TreeSet");
    L49:
        r14.write(91);     // Catch: Throwable -> L30
        Iterator r21 = r19.iterator();     // Catch: Throwable -> L30
    L26:
        if (r21.hasNext() == false) goto L44;
        Object r22 = r21.next();     // Catch: Throwable -> L30
        int r23 = r17 + 1;     // Catch: Throwable -> L30
        if (r17 == 0) goto L32;
        r14.write(44);     // Catch: Throwable -> L30
    L32:
        if (r22 != null) goto L34;
        r14.writeNull();     // Catch: Throwable -> L30
    L43:
        r17 = r23;
        goto L26
    L34:
        Class<?> r24 = r22.getClass();     // Catch: Throwable -> L30
        if (r24 != Integer.class) goto L38;
        r14.writeInt(((Integer) r22).intValue());     // Catch: Throwable -> L30
        goto L43
    L38:
        if (r24 != Long.class) goto L42;
        r14.writeLong(((Long) r22).longValue());     // Catch: Throwable -> L30
        if ((r14.features & SerializerFeature.WriteClassName.mask) == 0) goto L43;
        r14.write(76);     // Catch: Throwable -> L30
        goto L43
    L42:
        r10.config.get(r24).write(r10, r22, Integer.valueOf(r17), r18);     // Catch: Throwable -> L30
        goto L43
    L44:
        r14.write(93);     // Catch: Throwable -> L30
        r10.context = r20;
        return;
    L30:
        th = move-exception;
        r10.context = r20;
        throw th;
    L12:
        if ((r13 instanceof ParameterizedType) == false) goto L14;
        r18 = ((ParameterizedType) r13).getActualTypeArguments()[0];
        goto L15
    L5:
        if ((r14.features & SerializerFeature.WriteNullListAsEmpty.mask) == 0) goto L7;
        r14.write("[]");
        return;
    L7:
        r14.writeNull();
    }
}
