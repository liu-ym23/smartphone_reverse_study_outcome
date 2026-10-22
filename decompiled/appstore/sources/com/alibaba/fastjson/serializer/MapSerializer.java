package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class MapSerializer implements ObjectSerializer {
    public MapSerializer() {
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r12, Object r13, Object r14, Type r15) throws IOException {
        SerializeWriter r11 = r12.out;
        if (r13 != null) goto L6;
        r11.writeNull();
        return;
    L6:
        Map r16 = (Map) r13;
        Class<?> r10 = r16.getClass();
        if (r10 == JSONObject.class) goto L13;
        if (r10 == HashMap.class) goto L13;
        if (r10 == LinkedHashMap.class) goto L13;
    L15:
        boolean r17 = false;
    L17:
        if ((r11.features & SerializerFeature.SortField.mask) != 0) goto L19;
    L24:
        IdentityHashMap<Object, SerialContext> r18 = r12.references;
        if (r18 != null) goto L27;
    L30:
        SerialContext r19 = r12.context;
        r12.setContext(r19, r13, r14, 0);
        r11.write(123);     // Catch: Throwable -> L35
        r12.incrementIndent();     // Catch: Throwable -> L35
        if ((r11.features & SerializerFeature.WriteClassName.mask) == 0) goto L37;
        if (r17 == true) goto L37;
        r11.writeFieldName(r12.config.typeKey, false);     // Catch: Throwable -> L35
        r11.writeString(r13.getClass().getName());     // Catch: Throwable -> L35
        boolean r110 = false;
    L38:
        Iterator r20 = r16.entrySet().iterator();     // Catch: Throwable -> L35
        Class<?> r21 = null;
        ObjectSerializer r22 = null;
    L39:
        if (r20.hasNext() == false) goto L79;
        Map.Entry r23 = (Map.Entry) r20.next();     // Catch: Throwable -> L35
        Object r24 = r23.getValue();     // Catch: Throwable -> L35
        Object r25 = r23.getKey();     // Catch: Throwable -> L35
        if (r12.applyName(r13, r25) == false) goto L39;
        if (r12.apply(r13, r25, r24) == false) goto L39;
        Object r26 = r12.processKey(r13, r25, r24);     // Catch: Throwable -> L35
        Object r27 = JSONSerializer.processValue(r12, r13, r26, r24);     // Catch: Throwable -> L35
        if (r27 != null) goto L53;
        if ((r11.features & SerializerFeature.WriteMapNullValue.mask) == 0) goto L39;
    L53:
        if ((r26 instanceof String) == false) goto L61;
        String r28 = (String) r26;     // Catch: Throwable -> L35
        if (r110 == true) goto L58;
        r11.write(44);     // Catch: Throwable -> L35
    L58:
        if ((r11.features & SerializerFeature.PrettyFormat.mask) == 0) goto L60;
        r12.println();     // Catch: Throwable -> L35
    L60:
        r11.writeFieldName(r28, true);     // Catch: Throwable -> L35
    L71:
        if (r27 != null) goto L74;
        r11.writeNull();     // Catch: Throwable -> L35
    L73:
        r110 = false;
        goto L39
    L74:
        Class<?> r111 = r27.getClass();     // Catch: Throwable -> L35
        if (r111 != r21) goto L77;
        r22.write(r12, r27, r26, null);     // Catch: Throwable -> L35
        goto L73
    L77:
        ObjectSerializer r29 = r12.config.get(r111);     // Catch: Throwable -> L35
        r29.write(r12, r27, r26, null);     // Catch: Throwable -> L35
        r22 = r29;
        r21 = r111;
        goto L73
    L61:
        if (r110 == true) goto L63;
        r11.write(44);     // Catch: Throwable -> L35
    L63:
        int r112 = r11.features;     // Catch: Throwable -> L35
        if ((SerializerFeature.BrowserCompatible.mask & r112) == 0) goto L66;
    L69:
        r12.write(JSON.toJSONString(r26));     // Catch: Throwable -> L35
    L70:
        r11.write(58);     // Catch: Throwable -> L35
        goto L71
    L66:
        if ((r112 & SerializerFeature.WriteNonStringKeyAsString.mask) != 0) goto L69;
        r12.write(r26);     // Catch: Throwable -> L35
        goto L70
    L79:
        r12.context = r19;
        r12.decrementIdent();
        if ((r11.features & SerializerFeature.PrettyFormat.mask) != 0) goto L82;
    L84:
        r11.write(125);
        return;
    L82:
        if (r16.size() <= 0) goto L84;
        r12.println();
    L37:
        r110 = true;
    L35:
        th = move-exception;
        r12.context = r19;
        throw th;
    L27:
        if (r18.containsKey(r13) == false) goto L30;
        r12.writeReference(r13);
        return;
    L19:
        if ((r16 instanceof SortedMap) == true) goto L24;
        if ((r16 instanceof LinkedHashMap) == true) goto L24;
        r16 = new TreeMap(r16);     // Catch: Exception -> L88
    L13:
        if (r16.containsKey(JSON.DEFAULT_TYPE_KEY) == false) goto L15;
        r17 = true;
        goto L17
    }
}
