package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ListSerializer implements ObjectSerializer {
    public ListSerializer() {
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer r17, Object r18, Object r19, Type r20) throws IOException {
        SerializeWriter r10 = r17.out;
        int r11 = 1;
        if ((r10.features & SerializerFeature.WriteClassName.mask) == 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
    L10:
        Type r13 = null;
    L12:
        if (r18 == null) goto L14;
        List r14 = (List) r18;
        int r15 = r14.size();
        if (r15 != 0) goto L22;
        r10.append("[]");
        return;
    L22:
        SerialContext r16 = r17.context;
        if ((r10.features & SerializerFeature.DisableCircularReferenceDetect.mask) != 0) goto L107;
        r17.context = new SerialContext(r16, r18, r19, 0);
        if (r17.references != null) goto L27;
        r17.references = new IdentityHashMap();
    L27:
        r17.references.put(r18, r16);
    L107:
    L35:
        th = move-exception;
        r17.context = r16;
        throw th;
    L29:
        if ((r10.features & SerializerFeature.PrettyFormat.mask) == 0) goto L50;
        r10.write(91);     // Catch: Throwable -> L35
        r17.incrementIndent();     // Catch: Throwable -> L35
        int r21 = 0;
    L31:
        if (r21 >= r15) goto L47;
        Object r22 = r14.get(r21);     // Catch: Throwable -> L35
        if (r21 == 0) goto L37;
        r10.write(44);     // Catch: Throwable -> L35
    L37:
        r17.println();     // Catch: Throwable -> L35
        if (r22 == null) goto L45;
        IdentityHashMap<Object, SerialContext> r110 = r17.references;     // Catch: Throwable -> L35
        if (r110 != null) goto L42;
    L44:
        ObjectSerializer r111 = r17.config.get(r22.getClass());     // Catch: Throwable -> L35
        r17.context = new SerialContext(r16, r18, r19, 0);     // Catch: Throwable -> L35
        r111.write(r17, r22, Integer.valueOf(r21), r13);     // Catch: Throwable -> L35
    L46:
        r21 = r21 + 1;     // Catch: Throwable -> L35
        goto L31
    L42:
        if (r110.containsKey(r22) == false) goto L44;
        r17.writeReference(r22);     // Catch: Throwable -> L35
        goto L46
    L45:
        r17.out.writeNull();     // Catch: Throwable -> L35
        goto L46
    L47:
        r17.decrementIdent();     // Catch: Throwable -> L35
        r17.println();     // Catch: Throwable -> L35
        r10.write(93);     // Catch: Throwable -> L35
        r17.context = r16;
        return;
    L50:
        int r112 = r10.count + 1;     // Catch: Throwable -> L35
        if (r112 > r10.buf.length) goto L53;
    L56:
        r10.buf[r10.count] = '[';     // Catch: Throwable -> L35
        r10.count = r112;     // Catch: Throwable -> L35
        int r113 = 0;
    L58:
        if (r113 >= r14.size()) goto L95;
        Object r114 = r14.get(r113);     // Catch: Throwable -> L35
        if (r113 == 0) goto L68;
        int r115 = r10.count + 1;     // Catch: Throwable -> L35
        if (r115 > r10.buf.length) goto L64;
    L67:
        r10.buf[r10.count] = ',';     // Catch: Throwable -> L35
        r10.count = r115;     // Catch: Throwable -> L35
        goto L68
    L64:
        if (r10.writer != null) goto L66;
        r10.expandCapacity(r115);     // Catch: Throwable -> L35
        goto L67
    L66:
        r10.flush();     // Catch: Throwable -> L35
        r115 = 1;
    L68:
        if (r114 != null) goto L70;
        r10.append("null");     // Catch: Throwable -> L35
    L94:
        r113 = r113 + 1;     // Catch: Throwable -> L35
        goto L58
    L70:
        Class<?> r116 = r114.getClass();     // Catch: Throwable -> L35
        if (r116 != Integer.class) goto L74;
        r10.writeInt(((Integer) r114).intValue());     // Catch: Throwable -> L35
        goto L94
    L74:
        if (r116 != Long.class) goto L80;
        long r117 = ((Long) r114).longValue();     // Catch: Throwable -> L35
        if (r12 == false) goto L78;
        r10.writeLong(r117);     // Catch: Throwable -> L35
        r10.write(76);     // Catch: Throwable -> L35
        goto L94
    L78:
        r10.writeLong(r117);     // Catch: Throwable -> L35
        goto L94
    L80:
        if (r116 != String.class) goto L86;
        String r118 = (String) r114;     // Catch: Throwable -> L35
        if ((r10.features & SerializerFeature.UseSingleQuotes.mask) == 0) goto L84;
        r10.writeStringWithSingleQuote(r118);     // Catch: Throwable -> L35
        goto L94
    L84:
        r10.writeStringWithDoubleQuote(r118, 0, true);     // Catch: Throwable -> L35
        goto L94
    L86:
        if ((r10.features & SerializerFeature.DisableCircularReferenceDetect.mask) != 0) goto L88;
        r17.context = new SerialContext(r16, r18, r19, 0);     // Catch: Throwable -> L35
    L88:
        IdentityHashMap<Object, SerialContext> r119 = r17.references;     // Catch: Throwable -> L35
        if (r119 != null) goto L91;
    L93:
        r17.config.get(r114.getClass()).write(r17, r114, Integer.valueOf(r113), r13);     // Catch: Throwable -> L35
        goto L94
    L91:
        if (r119.containsKey(r114) == false) goto L93;
        r17.writeReference(r114);     // Catch: Throwable -> L35
        goto L94
    L95:
        int r23 = r10.count + 1;     // Catch: Throwable -> L35
        if (r23 > r10.buf.length) goto L98;
    L101:
        r11 = r23;
    L102:
        r10.buf[r10.count] = ']';     // Catch: Throwable -> L35
        r10.count = r11;     // Catch: Throwable -> L35
        r17.context = r16;
        return;
    L98:
        if (r10.writer != null) goto L100;
        r10.expandCapacity(r23);     // Catch: Throwable -> L35
        goto L101
    L100:
        r10.flush();     // Catch: Throwable -> L35
        goto L102
    L53:
        if (r10.writer != null) goto L55;
        r10.expandCapacity(r112);     // Catch: Throwable -> L35
        goto L56
    L55:
        r10.flush();     // Catch: Throwable -> L35
        r112 = 1;
        goto L56
    L14:
        if ((r10.features & SerializerFeature.WriteNullListAsEmpty.mask) == 0) goto L16;
        r10.write("[]");
        return;
    L16:
        r10.writeNull();
        return;
    L8:
        if ((r20 instanceof ParameterizedType) == false) goto L10;
        r13 = ((ParameterizedType) r20).getActualTypeArguments()[0];
        goto L12
    L5:
        r12 = false;
        goto L6
    }
}
