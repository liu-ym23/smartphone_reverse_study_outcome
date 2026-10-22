package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = null;

    public ListSerializer() {
    }

    static {
        instance = new ListSerializer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer r210, Object r211, Object r212, Type r213, int r214) throws IOException {
        SerializeWriter r100 = r210.out;
        SerializerFeature r101 = SerializerFeature.WriteClassName;
        if (r100.isEnabled(r101) == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        SerializeWriter r110 = r210.out;
        if (r102 == false) goto L12;
        Type r103 = TypeUtils.getCollectionItemType(r213);
    L13:
        Type r111 = r103;
        if (r211 != null) goto L17;
        r110.writeNull(SerializerFeature.WriteNullListAsEmpty);
        return;
    L17:
        List r112 = (List) r211;
        if (r112.size() != 0) goto L21;
        r110.append("[]");
        return;
    L21:
        SerialContext r113 = r210.context;
        r210.setContext(r113, r211, r212, 0);
        char r114 = ',';
        if (r110.isEnabled(SerializerFeature.PrettyFormat) == false) goto L41;
        r110.append('[');     // Catch: Throwable -> L80
        r210.incrementIndent();     // Catch: Throwable -> L80
        Iterator r104 = r112.iterator();     // Catch: Throwable -> L80
        int r115 = 0;
    L26:
        if (r104.hasNext() == false) goto L38;
        Object r105 = r104.next();     // Catch: Throwable -> L80
        if (r115 == 0) goto L30;
        r110.append(r114);     // Catch: Throwable -> L80
    L30:
        r210.println();     // Catch: Throwable -> L80
        if (r105 != null) goto L33;
        r210.out.writeNull();     // Catch: Throwable -> L80
    L37:
        r115 = r115 + 1;     // Catch: Throwable -> L80
        r114 = ',';
        goto L26
    L33:
        if (r210.containsReference(r105) == false) goto L35;
        r210.writeReference(r105);     // Catch: Throwable -> L80
        goto L37
    L35:
        ObjectSerializer r116 = r210.getObjectWriter(r105.getClass());     // Catch: Throwable -> L80
        r210.context = new SerialContext(r113, r211, r212, 0, 0);     // Catch: Throwable -> L80
        r116.write(r210, r105, Integer.valueOf(r115), r111, r214);     // Catch: Throwable -> L80
        goto L37
    L38:
        r210.decrementIdent();     // Catch: Throwable -> L80
        r210.println();     // Catch: Throwable -> L80
        r110.append(']');     // Catch: Throwable -> L80
        r210.context = r113;
        return;
    L41:
        char r106 = ']';
        r110.append('[');     // Catch: Throwable -> L80
        int r117 = r112.size();     // Catch: Throwable -> L80
        int r107 = 0;
    L43:
        if (r107 >= r117) goto L77;
        Object r108 = r112.get(r107);     // Catch: Throwable -> L80
        if (r107 == 0) goto L48;
        r110.append(',');     // Catch: Throwable -> L80
    L48:
        if (r108 != null) goto L51;
        r110.append("null");     // Catch: Throwable -> L80
    L50:
        int r118 = r107;
        r102 = r102;
    L76:
        r107 = r118 + 1;     // Catch: Throwable -> L80
        r102 = r102;
        r106 = ']';
        goto L43
    L51:
        Class<?> r109 = r108.getClass();     // Catch: Throwable -> L80
        if (r109 != Integer.class) goto L55;
        r110.writeInt(((Integer) r108).intValue());     // Catch: Throwable -> L80
        goto L50
    L55:
        if (r109 != Long.class) goto L61;
        long r119 = ((Long) r108).longValue();     // Catch: Throwable -> L80
        if (r102 == false) goto L59;
        r110.writeLong(r119);     // Catch: Throwable -> L80
        r110.write(76);     // Catch: Throwable -> L80
        goto L50
    L59:
        r110.writeLong(r119);     // Catch: Throwable -> L80
        goto L50
    L61:
        if ((SerializerFeature.DisableCircularReferenceDetect.mask & r214) == 0) goto L63;
        r118 = r107;
        r210.getObjectWriter(r108.getClass()).write(r210, r108, Integer.valueOf(r107), r111, r214);     // Catch: Throwable -> L80
        r102 = r102;
        goto L76
    L63:
        r118 = r107;
        if (r110.disableCircularReferenceDetect == true) goto L68;
        r210.context = new SerialContext(r113, r211, r212, 0, 0);     // Catch: Throwable -> L80
    L68:
        if (r210.containsReference(r108) == false) goto L70;
        r210.writeReference(r108);     // Catch: Throwable -> L80
        goto L76
    L70:
        ObjectSerializer r120 = r210.getObjectWriter(r108.getClass());     // Catch: Throwable -> L80
        if ((SerializerFeature.WriteClassName.mask & r214) != 0) goto L73;
    L75:
        r120.write(r210, r108, Integer.valueOf(r118), r111, r214);     // Catch: Throwable -> L80
        goto L76
    L73:
        if ((r120 instanceof JavaBeanSerializer) == false) goto L75;
        ((JavaBeanSerializer) r120).writeNoneASM(r210, r108, Integer.valueOf(r118), r111, r214);     // Catch: Throwable -> L80
        goto L76
    L77:
        r110.append(r106);     // Catch: Throwable -> L80
        r210.context = r113;
        return;
    L80:
        th = move-exception;
        r210.context = r113;
        throw th;
    L12:
        r103 = null;
        goto L13
    L5:
        if (SerializerFeature.isEnabled(r214, r101) == true) goto L8;
        r102 = false;
        goto L9
    }
}
