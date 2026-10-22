package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes.dex */
public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws IOException {
        char c4;
        int i5;
        Object obj3;
        boolean zIsEnabled = jSONSerializer.out.isEnabled(SerializerFeature.WriteClassName);
        SerializeWriter serializeWriter = jSONSerializer.out;
        Type collectionItemType = zIsEnabled ? TypeUtils.getCollectionItemType(type) : null;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj;
        if (list.size() == 0) {
            serializeWriter.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            char c5 = ']';
            char c6 = ',';
            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                serializeWriter.append('[');
                jSONSerializer.incrementIndent();
                int i6 = 0;
                for (Object obj4 : list) {
                    if (i6 != 0) {
                        serializeWriter.append(c6);
                    }
                    jSONSerializer.println();
                    if (obj4 == null) {
                        jSONSerializer.out.writeNull();
                    } else if (jSONSerializer.containsReference(obj4)) {
                        jSONSerializer.writeReference(obj4);
                    } else {
                        ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(obj4.getClass());
                        jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                        objectWriter.write(jSONSerializer, obj4, Integer.valueOf(i6), collectionItemType, 0);
                    }
                    i6++;
                    c6 = ',';
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.append(']');
                jSONSerializer.context = serialContext;
                return;
            }
            serializeWriter.append('[');
            int size = list.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj5 = list.get(i7);
                if (i7 != 0) {
                    c4 = ',';
                    serializeWriter.append(',');
                } else {
                    c4 = ',';
                }
                if (obj5 == null) {
                    serializeWriter.append((CharSequence) "null");
                } else {
                    Class<?> cls = obj5.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) obj5).intValue());
                    } else if (cls == Long.class) {
                        long jLongValue = ((Long) obj5).longValue();
                        if (zIsEnabled) {
                            serializeWriter.writeLong(jLongValue);
                            serializeWriter.write(76);
                        } else {
                            serializeWriter.writeLong(jLongValue);
                        }
                    } else {
                        if ((SerializerFeature.DisableCircularReferenceDetect.mask & i4) != 0) {
                            i5 = i7;
                            jSONSerializer.getObjectWriter(obj5.getClass()).write(jSONSerializer, obj5, Integer.valueOf(i7), collectionItemType, i4);
                        } else {
                            i5 = i7;
                            if (serializeWriter.disableCircularReferenceDetect) {
                                obj3 = obj5;
                            } else {
                                obj3 = obj5;
                                jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                            }
                            if (jSONSerializer.containsReference(obj3)) {
                                jSONSerializer.writeReference(obj3);
                            } else {
                                jSONSerializer.getObjectWriter(obj3.getClass()).write(jSONSerializer, obj3, Integer.valueOf(i5), collectionItemType, 0);
                            }
                        }
                        i7 = i5 + 1;
                        c5 = ']';
                    }
                }
                i5 = i7;
                i7 = i5 + 1;
                c5 = ']';
            }
            serializeWriter.append(c5);
            jSONSerializer.context = serialContext;
        } catch (Throwable th) {
            jSONSerializer.context = serialContext;
            throw th;
        }
    }
}
