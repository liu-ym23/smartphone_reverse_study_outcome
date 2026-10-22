package com.alibaba.fastjson.serializer;

import B0.g;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public static Map<String, String> createAliasMap(String... strArr) {
        HashMap map = new HashMap();
        for (String str : strArr) {
            map.put(str, str);
        }
        return map;
    }

    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        List<LabelFilter> list = jSONSerializer.labelFilters;
        if (list != null) {
            Iterator<LabelFilter> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(str)) {
                    return false;
                }
            }
        }
        List<LabelFilter> list2 = this.labelFilters;
        if (list2 == null) {
            return true;
        }
        Iterator<LabelFilter> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(str)) {
                return false;
            }
        }
        return true;
    }

    public BeanContext getBeanContext(int i4) {
        return this.sortedGetters[i4].fieldContext;
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int length = this.sortedGetters.length - 1;
        int i4 = 0;
        while (i4 <= length) {
            int i5 = (i4 + length) >>> 1;
            int iCompareTo = this.sortedGetters[i5].fieldInfo.name.compareTo(str);
            if (iCompareTo < 0) {
                i4 = i5 + 1;
            } else {
                if (iCompareTo <= 0) {
                    return this.sortedGetters[i5];
                }
                length = i5 - 1;
            }
        }
        return null;
    }

    public Type getFieldType(int i4) {
        return this.sortedGetters[i4].fieldInfo.fieldType;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer == null) {
            throw new JSONException(g.m("field not found. ", str));
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e4) {
            throw new JSONException(g.m("getFieldValue error.", str), e4);
        } catch (InvocationTargetException e5) {
            throw new JSONException(g.m("getFieldValue error.", str), e5);
        }
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i4 = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i4++;
            }
        }
        return i4;
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i4, false);
    }

    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c4) {
        List<AfterFilter> list = jSONSerializer.afterFilters;
        if (list != null) {
            Iterator<AfterFilter> it = list.iterator();
            while (it.hasNext()) {
                c4 = it.next().writeAfter(jSONSerializer, obj, c4);
            }
        }
        List<AfterFilter> list2 = this.afterFilters;
        if (list2 != null) {
            Iterator<AfterFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                c4 = it2.next().writeAfter(jSONSerializer, obj, c4);
            }
        }
        return c4;
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i4);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i4);
    }

    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c4) {
        List<BeforeFilter> list = jSONSerializer.beforeFilters;
        if (list != null) {
            Iterator<BeforeFilter> it = list.iterator();
            while (it.hasNext()) {
                c4 = it.next().writeBefore(jSONSerializer, obj, c4);
            }
        }
        List<BeforeFilter> list2 = this.beforeFilters;
        if (list2 != null) {
            Iterator<BeforeFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                c4 = it2.next().writeBefore(jSONSerializer, obj, c4);
            }
        }
        return c4;
    }

    public void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String name = this.beanInfo.typeName;
        if (name == null) {
            Class<?> superclass = obj.getClass();
            if (TypeUtils.isProxy(superclass)) {
                superclass = superclass.getSuperclass();
            }
            name = superclass.getName();
        }
        jSONSerializer.write(name);
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i4) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i4);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i4) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext = jSONSerializer.context;
        int i5 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i5) != 0 || (i4 & i5) != 0 || (identityHashMap = jSONSerializer.references) == null || !identityHashMap.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i4) {
        int i5 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i5) == 0 && !jSONSerializer.out.beanToArray && (i4 & i5) == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x018e A[Catch: all -> 0x00e3, Exception -> 0x0173, TryCatch #2 {all -> 0x00e3, blocks: (B:61:0x00cc, B:64:0x00d6, B:76:0x00f3, B:78:0x00f9, B:81:0x0102, B:83:0x0108, B:85:0x010e, B:88:0x0115, B:95:0x0125, B:100:0x0130, B:103:0x013c, B:104:0x0142, B:107:0x0165, B:109:0x0169, B:115:0x017a, B:117:0x017e, B:119:0x0187, B:121:0x018e, B:123:0x0194, B:125:0x0198, B:128:0x01a2, B:130:0x01a6, B:132:0x01aa, B:135:0x01b4, B:137:0x01b8, B:139:0x01bc, B:142:0x01c6, B:144:0x01ca, B:146:0x01ce, B:149:0x01dc, B:151:0x01e0, B:153:0x01e4, B:156:0x01f1, B:158:0x01f5, B:160:0x01f9, B:163:0x0208, B:165:0x020c, B:167:0x0210, B:171:0x021d, B:173:0x0221, B:175:0x0225, B:178:0x022f, B:180:0x023a, B:184:0x0243, B:186:0x0249, B:191:0x0254, B:192:0x0257, B:194:0x025d, B:197:0x0263, B:201:0x0273, B:204:0x027d, B:207:0x0287, B:209:0x0290, B:212:0x0296, B:213:0x029a, B:214:0x02a0, B:216:0x02a6, B:217:0x02aa, B:218:0x02ae, B:220:0x02b2, B:222:0x02b6, B:225:0x02c2, B:226:0x02c6, B:198:0x026b, B:92:0x011c, B:228:0x02cc, B:238:0x02f7, B:240:0x02ff, B:242:0x0307, B:246:0x0313), top: B:263:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021d A[Catch: all -> 0x00e3, Exception -> 0x0173, TryCatch #2 {all -> 0x00e3, blocks: (B:61:0x00cc, B:64:0x00d6, B:76:0x00f3, B:78:0x00f9, B:81:0x0102, B:83:0x0108, B:85:0x010e, B:88:0x0115, B:95:0x0125, B:100:0x0130, B:103:0x013c, B:104:0x0142, B:107:0x0165, B:109:0x0169, B:115:0x017a, B:117:0x017e, B:119:0x0187, B:121:0x018e, B:123:0x0194, B:125:0x0198, B:128:0x01a2, B:130:0x01a6, B:132:0x01aa, B:135:0x01b4, B:137:0x01b8, B:139:0x01bc, B:142:0x01c6, B:144:0x01ca, B:146:0x01ce, B:149:0x01dc, B:151:0x01e0, B:153:0x01e4, B:156:0x01f1, B:158:0x01f5, B:160:0x01f9, B:163:0x0208, B:165:0x020c, B:167:0x0210, B:171:0x021d, B:173:0x0221, B:175:0x0225, B:178:0x022f, B:180:0x023a, B:184:0x0243, B:186:0x0249, B:191:0x0254, B:192:0x0257, B:194:0x025d, B:197:0x0263, B:201:0x0273, B:204:0x027d, B:207:0x0287, B:209:0x0290, B:212:0x0296, B:213:0x029a, B:214:0x02a0, B:216:0x02a6, B:217:0x02aa, B:218:0x02ae, B:220:0x02b2, B:222:0x02b6, B:225:0x02c2, B:226:0x02c6, B:198:0x026b, B:92:0x011c, B:228:0x02cc, B:238:0x02f7, B:240:0x02ff, B:242:0x0307, B:246:0x0313), top: B:263:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x033f A[Catch: all -> 0x0354, TryCatch #3 {all -> 0x0354, blocks: (B:249:0x031d, B:251:0x033f, B:254:0x0356, B:256:0x035c, B:257:0x0374, B:258:0x0379), top: B:264:0x031d }] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x035c A[Catch: all -> 0x0354, TryCatch #3 {all -> 0x0354, blocks: (B:249:0x031d, B:251:0x033f, B:254:0x0356, B:256:0x035c, B:257:0x0374, B:258:0x0379), top: B:264:0x031d }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r27, java.lang.Object r28, java.lang.Object r29, java.lang.reflect.Type r30, int r31, boolean r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 893
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i5 >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i5] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i5]);
            i5++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
            return;
        }
        this.getters = new FieldSerializer[fieldInfoArr.length];
        while (true) {
            FieldSerializer[] fieldSerializerArr2 = this.getters;
            if (i4 >= fieldSerializerArr2.length) {
                return;
            }
            fieldSerializerArr2[i4] = getFieldSerializer(serializeBeanInfo.fields[i4].name);
            i4++;
        }
    }

    public FieldSerializer getFieldSerializer(long j4) {
        PropertyNamingStrategy[] propertyNamingStrategyArrValues;
        int iBinarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArrValues = PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArrValues.length];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i4 >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i4].fieldInfo.name;
                jArr[i5] = TypeUtils.fnv1a_64(str);
                i5++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArrValues) {
                    String strTranslate = propertyNamingStrategy.translate(str);
                    if (!str.equals(strTranslate)) {
                        jArr[i5] = TypeUtils.fnv1a_64(strTranslate);
                        i5++;
                    }
                }
                i4++;
            }
            Arrays.sort(jArr, 0, i5);
            this.hashArray = new long[i5];
            System.arraycopy(jArr, 0, this.hashArray, 0, i5);
        } else {
            propertyNamingStrategyArrValues = null;
        }
        int iBinarySearch2 = Arrays.binarySearch(this.hashArray, j4);
        if (iBinarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArrValues == null) {
                propertyNamingStrategyArrValues = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            int i6 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i6 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i6].fieldInfo.name;
                int iBinarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (iBinarySearch3 >= 0) {
                    sArr[iBinarySearch3] = (short) i6;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArrValues) {
                    String strTranslate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(strTranslate2) && (iBinarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(strTranslate2))) >= 0) {
                        sArr[iBinarySearch] = (short) i6;
                    }
                }
                i6++;
            }
            this.hashArrayMapping = sArr;
        }
        short s4 = this.hashArrayMapping[iBinarySearch2];
        if (s4 != -1) {
            return this.sortedGetters[s4];
        }
        return null;
    }

    public Object getFieldValue(Object obj, String str, long j4, boolean z4) {
        FieldSerializer fieldSerializer = getFieldSerializer(j4);
        if (fieldSerializer == null) {
            if (z4) {
                throw new JSONException(g.m("field not found. ", str));
            }
            return null;
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e4) {
            throw new JSONException(g.m("getFieldValue error.", str), e4);
        } catch (InvocationTargetException e5) {
            throw new JSONException(g.m("getFieldValue error.", str), e5);
        }
    }
}
