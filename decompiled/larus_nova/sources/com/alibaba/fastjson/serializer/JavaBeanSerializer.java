package com.alibaba.fastjson.serializer;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes28.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected final SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final FieldSerializer[] sortedGetters;

    public JSONType getJSONType() {
        return this.beanInfo.jsonType;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public JavaBeanSerializer(SerializeBeanInfo r100) {
        this.beanInfo = r100;
        this.sortedGetters = new FieldSerializer[r100.sortedFields.length];
        int r101 = 0;
    L3:
        FieldSerializer[] r102 = this.sortedGetters;
        if (r101 >= r102.length) goto L6;
        r102[r101] = new FieldSerializer(r100.beanType, r100.sortedFields[r101]);
        r101 = r101 + 1;
        goto L3
    L6:
        FieldInfo[] r103 = r100.fields;
        if (r103 != r100.sortedFields) goto L9;
        this.getters = r102;
    L19:
        JSONType r104 = r100.jsonType;
        if (r104 == null) goto L26;
        Class<? extends SerializeFilter>[] r105 = r104.serialzeFilters();
        int r106 = r105.length;
        int r107 = 0;
    L22:
        if (r107 >= r106) goto L35;
        addFilter(r105[r107].getConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: Exception -> L27
    L25:
        r107 = r107 + 1;
        goto L22
    L35:
        return;
    L26:
        return;
    L9:
        this.getters = new FieldSerializer[r103.length];
        int r108 = 0;
    L11:
        if (r108 >= this.getters.length) goto L16;
        FieldSerializer r109 = getFieldSerializer(r100.fields[r108].name);
        if (r109 == null) goto L14;
        this.getters[r108] = r109;
        r108 = r108 + 1;
        goto L11
    L14:
        boolean r110 = true;
    L17:
        if (r110 == false) goto L19;
        FieldSerializer[] r111 = this.sortedGetters;
        System.arraycopy(r111, 0, this.getters, 0, r111.length);
        goto L19
    L16:
        r110 = false;
        goto L17
    }

    public static Map<String, String> createAliasMap(String... r100) {
        HashMap r101 = new HashMap();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        String r104 = r100[r103];
        r101.put(r104, r104);
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public BeanContext getBeanContext(int r100) {
        return this.sortedGetters[r100].fieldContext;
    }

    public Set<String> getFieldNames(Object r100) throws Exception {
        HashSet r101 = new HashSet();
        FieldSerializer[] r102 = this.sortedGetters;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        FieldSerializer r105 = r102[r104];
        if (r105.getPropertyValueDirect(r100) == null) goto L7;
        r101.add(r105.fieldInfo.name);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r101;
    }

    public FieldSerializer getFieldSerializer(long r110) {
        if (this.hashArray != null) goto L17;
        PropertyNamingStrategy[] r100 = PropertyNamingStrategy.values();
        long[] r101 = new long[this.sortedGetters.length * r100.length];
        int r102 = 0;
        int r103 = 0;
    L5:
        FieldSerializer[] r104 = this.sortedGetters;
        if (r102 >= r104.length) goto L16;
        String r105 = r104[r102].fieldInfo.name;
        r101[r103] = TypeUtils.fnv1a_64(r105);
        r103 = r103 + 1;
        int r106 = 0;
    L9:
        if (r106 >= r100.length) goto L15;
        String r107 = r100[r106].translate(r105);
        if (r105.equals(r107) == true) goto L14;
        r101[r103] = TypeUtils.fnv1a_64(r107);
        r103 = r103 + 1;
    L14:
        r106 = r106 + 1;
        goto L9
    L15:
        r102 = r102 + 1;
        goto L5
    L16:
        Arrays.sort(r101, 0, r103);
        this.hashArray = new long[r103];
        System.arraycopy(r101, 0, this.hashArray, 0, r103);
    L18:
        int r111 = Arrays.binarySearch(this.hashArray, r110);
        if (r111 >= 0) goto L22;
        return null;
    L22:
        if (this.hashArrayMapping != null) goto L43;
        if (r100 != null) goto L25;
        r100 = PropertyNamingStrategy.values();
    L25:
        short[] r112 = new short[this.hashArray.length];
        Arrays.fill(r112, -1);
        int r108 = 0;
    L26:
        FieldSerializer[] r109 = this.sortedGetters;
        if (r108 >= r109.length) goto L42;
        String r113 = r109[r108].fieldInfo.name;
        int r114 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(r113));
        if (r114 < 0) goto L31;
        r112[r114] = (short) r108;
    L31:
        int r115 = 0;
    L33:
        if (r115 >= r100.length) goto L41;
        String r116 = r100[r115].translate(r113);
        if (r113.equals(r116) == true) goto L40;
        int r117 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(r116));
        if (r117 < 0) goto L40;
        r112[r117] = (short) r108;
    L40:
        r115 = r115 + 1;
        goto L33
    L41:
        r108 = r108 + 1;
        goto L26
    L42:
        this.hashArrayMapping = r112;
    L43:
        short r118 = this.hashArrayMapping[r111];
        if (r118 != (-1)) goto L46;
        return null;
    L46:
        return this.sortedGetters[r118];
    L17:
        r100 = null;
        goto L18
    }

    public Type getFieldType(int r100) {
        return this.sortedGetters[r100].fieldInfo.fieldType;
    }

    public List<Object> getFieldValues(Object r100) throws Exception {
        ArrayList r101 = new ArrayList(this.sortedGetters.length);
        FieldSerializer[] r102 = this.sortedGetters;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.add(r102[r104].getPropertyValue(r100));
        r104 = r104 + 1;
        goto L3
    L5:
        return r101;
    }

    public Map<String, Object> getFieldValuesMap(Object r100) throws Exception {
        LinkedHashMap r101 = new LinkedHashMap(this.sortedGetters.length);
        FieldSerializer[] r102 = this.sortedGetters;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L18;
        FieldSerializer r105 = r102[r104];
        boolean r106 = SerializerFeature.isEnabled(r105.features, SerializerFeature.SkipTransientField);
        FieldInfo r107 = r105.fieldInfo;
        if (r106 == false) goto L11;
        if (r107 == null) goto L11;
        if (r107.fieldTransient == false) goto L11;
    L17:
        r104 = r104 + 1;
    L11:
        if (r107.unwrapped == false) goto L16;
        Object r108 = JSON.toJSON(r105.getPropertyValue(r100));
        if ((r108 instanceof Map) == false) goto L15;
        r101.putAll((Map) r108);
        goto L17
    L15:
        r101.put(r105.fieldInfo.name, r105.getPropertyValue(r100));
        goto L17
    L16:
        r101.put(r107.name, r105.getPropertyValue(r100));
        goto L17
    L18:
        return r101;
    }

    public List<Object> getObjectFieldValues(Object r100) throws Exception {
        ArrayList r101 = new ArrayList(this.sortedGetters.length);
        FieldSerializer[] r102 = this.sortedGetters;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L12;
        FieldSerializer r105 = r102[r104];
        Class<?> r106 = r105.fieldInfo.fieldClass;
        if (r106.isPrimitive() == true) goto L11;
        if (r106.getName().startsWith("java.lang.") == true) goto L11;
        r101.add(r105.getPropertyValue(r100));
    L11:
        r104 = r104 + 1;
        goto L3
    L12:
        return r101;
    }

    public int getSize(Object r100) throws Exception {
        FieldSerializer[] r101 = this.sortedGetters;
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r101[r103].getPropertyValueDirect(r100) == null) goto L7;
        r104 = r104 + 1;
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r104;
    }

    public boolean isWriteAsArray(JSONSerializer r100) {
        return isWriteAsArray(r100, 0);
    }

    public JavaBeanSerializer(Class<?> r100) {
        this(r100, null);
    }

    public FieldSerializer getFieldSerializer(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = this.sortedGetters.length - 1;
        int r102 = 0;
    L6:
        if (r102 > r101) goto L14;
        int r103 = (r102 + r101) >>> 1;
        int r104 = this.sortedGetters[r103].fieldInfo.name.compareTo(r100);
        if (r104 < 0) goto L9;
        if (r104 <= 0) goto L13;
        r101 = r103 - 1;
        goto L6
    L13:
        return this.sortedGetters[r103];
    L9:
        r102 = r103 + 1;
        goto L6
    L14:
        return null;
    }

    public JavaBeanSerializer(Class<?> r100, Map<String, String> r101) {
        this(TypeUtils.buildBeanInfo(r100, r101, null));
    }

    public boolean applyLabel(JSONSerializer r100, String r101) {
        List<LabelFilter> r102 = r100.labelFilters;
        if (r102 == null) goto L10;
        Iterator<LabelFilter> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        if (r103.next().apply(r101) == true) goto L6;
        return false;
    L10:
        List<LabelFilter> r104 = this.labelFilters;
        if (r104 == null) goto L18;
        Iterator<LabelFilter> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L26;
        if (r105.next().apply(r101) == true) goto L14;
        return false;
    L26:
        return true;
    L18:
        return true;
    }

    public Object getFieldValue(Object r100, String r101) {
        FieldSerializer r102 = getFieldSerializer(r101);
        if (r102 == null) goto L13;
        return r102.getPropertyValue(r100);
    L6:
        e = move-exception;
        throw new JSONException("getFieldValue error." + r101, e);
    L9:
        e = move-exception;
        throw new JSONException("getFieldValue error." + r101, e);
    L13:
        throw new JSONException("field not found. " + r101);
    }

    public boolean isWriteAsArray(JSONSerializer r100, int r101) {
        int r102 = SerializerFeature.BeanToArray.mask;
        if ((this.beanInfo.features & r102) == 0) goto L5;
    L10:
        return true;
    L5:
        if (r100.out.beanToArray == true) goto L10;
        if ((r101 & r102) != 0) goto L10;
        return false;
    }

    public JavaBeanSerializer(Class<?> r100, String... r101) {
        this(r100, createAliasMap(r101));
    }

    public char writeAfter(JSONSerializer r100, Object r101, char r102) {
        List<AfterFilter> r103 = r100.afterFilters;
        if (r103 == null) goto L8;
        Iterator<AfterFilter> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r102 = r104.next().writeAfter(r100, r101, r102);
    L8:
        List<AfterFilter> r105 = this.afterFilters;
        if (r105 == null) goto L14;
        Iterator<AfterFilter> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r102 = r106.next().writeAfter(r100, r101, r102);
    L14:
        return r102;
    }

    public char writeBefore(JSONSerializer r100, Object r101, char r102) {
        List<BeforeFilter> r103 = r100.beforeFilters;
        if (r103 == null) goto L8;
        Iterator<BeforeFilter> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r102 = r104.next().writeBefore(r100, r101, r102);
    L8:
        List<BeforeFilter> r105 = this.beforeFilters;
        if (r105 == null) goto L14;
        Iterator<BeforeFilter> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r102 = r106.next().writeBefore(r100, r101, r102);
    L14:
        return r102;
    }

    public void writeClassName(JSONSerializer r100, String r101, Object r102) {
        if (r101 != null) goto L4;
        r101 = r100.config.typeKey;
    L4:
        r100.out.writeFieldName(r101, false);
        String r103 = this.beanInfo.typeName;
        if (r103 != null) goto L10;
        Class<?> r104 = r102.getClass();
        if (TypeUtils.isProxy(r104) == false) goto L9;
        r104 = r104.getSuperclass();
    L9:
        r103 = r104.getName();
    L10:
        r100.write(r103);
    }

    public boolean writeReference(JSONSerializer r100, Object r101, int r102) {
        SerialContext r103 = r100.context;
        int r104 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (r103 != null) goto L5;
    L15:
        return false;
    L5:
        if ((r103.features & r104) != 0) goto L15;
        if ((r102 & r104) != 0) goto L15;
        IdentityHashMap<Object, SerialContext> r105 = r100.references;
        if (r105 == null) goto L15;
        if (r105.containsKey(r101) == false) goto L15;
        r100.writeReference(r101);
        return true;
    }

    public Object getFieldValue(Object r100, String r101, long r102, boolean r103) {
        FieldSerializer r104 = getFieldSerializer(r102);
        if (r104 != null) goto L17;
        if (r103 == true) goto L8;
        return null;
    L8:
        throw new JSONException("field not found. " + r101);
    L17:
        return r104.getPropertyValue(r100);
    L11:
        e = move-exception;
        throw new JSONException("getFieldValue error." + r101, e);
    L14:
        e = move-exception;
        throw new JSONException("getFieldValue error." + r101, e);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r110, Type r111, int r112) throws IOException {
        write(r100, r101, r110, r111, r112, false);
    }

    public void writeAsArray(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        write(r100, r101, r102, r103, r104);
    }

    public void writeAsArrayNonContext(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        write(r100, r101, r102, r103, r104);
    }

    public void writeDirectNonContext(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        write(r100, r101, r102, r103, r104);
    }

    public void writeNoneASM(JSONSerializer r100, Object r101, Object r110, Type r111, int r112) throws IOException {
        write(r100, r101, r110, r111, r112, false);
    }

    public void write(JSONSerializer r310, Object r311, Object r312, Type r313, int r314, boolean r315) throws IOException {
        Type r110 = r313;
        SerializeWriter r111 = r310.out;
        if (r311 != null) goto L7;
        r111.writeNull();
        return;
    L7:
        if (writeReference(r310, r311, r314) == false) goto L10;
        return;
    L10:
        if (r111.sortField == false) goto L12;
        FieldSerializer[] r100 = this.sortedGetters;
    L13:
        FieldSerializer[] r112 = r100;
        SerialContext r101 = r310.context;
        if (this.beanInfo.beanType.isEnum() == true) goto L16;
        r310.setContext(r101, r311, r312, this.beanInfo.features, r314);
    L16:
        boolean r113 = isWriteAsArray(r310, r314);
        if (r113 == false) goto L19;
        char r102 = '[';
    L20:
        if (r113 == false) goto L22;
        char r103 = ']';
    L23:
        Throwable r114 = null;
        if (r315 == true) goto L27;
        r111.append(r102);     // Catch: Throwable -> L379 Exception -> L381
    L381:
        e = move-exception;
        SerialContext r104 = r101;
        FieldSerializer r105 = null;
        Exception r106 = e;
    L427:
        String r107 = "write javaBean error, fastjson version 1.2.83, class " + r311.getClass().getName();     // Catch: Throwable -> L405
        if (r312 == null) goto L387;
        r107 = r107 + ", fieldName : " + r312;     // Catch: Throwable -> L405
    L395:
        if (r106.getMessage() == null) goto L398;
        r107 = r107 + ", " + r106.getMessage();     // Catch: Throwable -> L405
    L398:
        if ((r106 instanceof InvocationTargetException) == false) goto L400;
        r114 = r106.getCause();     // Catch: Throwable -> L405
    L400:
        if (r114 != null) goto L402;
        Throwable r108 = r106;
    L404:
        throw new JSONException(r107, r108);     // Catch: Throwable -> L405
    L402:
        r108 = r114;
        goto L404
    L387:
        if (r105 == null) goto L395;
        FieldInfo r109 = r105.fieldInfo;     // Catch: Throwable -> L405
        if (r109 == null) goto L395;
        if (r109.method == null) goto L393;
        r107 = r107 + ", method : " + r109.method.getName();     // Catch: Throwable -> L405
        goto L395
    L393:
        r107 = r107 + ", fieldName : " + r105.fieldInfo.name;     // Catch: Throwable -> L405
    L405:
        th = th;
    L406:
        r310.context = r104;
        throw th;
    L379:
        th = th;
        r104 = r101;
    L27:
        if (r112.length > 0) goto L29;
    L31:
        int r115 = this.beanInfo.features;     // Catch: Throwable -> L379 Exception -> L381
        SerializerFeature r116 = SerializerFeature.WriteClassName;     // Catch: Throwable -> L379 Exception -> L381
        int r117 = r116.mask;     // Catch: Throwable -> L379 Exception -> L381
        if ((r115 & r117) == 0) goto L34;
    L37:
        Class<?> r118 = r311.getClass();     // Catch: Throwable -> L379 Exception -> L381
        if (r118 != r110) goto L40;
    L42:
        Type r119 = r110;
    L43:
        if (r118 == r119) goto L45;
        writeClassName(r310, this.beanInfo.typeKey, r311);     // Catch: Throwable -> L379 Exception -> L381
        boolean r120 = true;
    L47:
        if (r120 == false) goto L49;
        char r121 = ',';
    L50:
        boolean r122 = r111.isEnabled(r116);     // Catch: Throwable -> L379 Exception -> L381
        if (writeBefore(r310, r311, r121) != ',') goto L53;
        boolean r123 = true;
    L54:
        boolean r124 = r111.isEnabled(SerializerFeature.SkipTransientField);     // Catch: Throwable -> L379 Exception -> L381
        boolean r210 = r111.isEnabled(SerializerFeature.IgnoreNonFieldGetter);     // Catch: Throwable -> L379 Exception -> L381
        boolean r211 = r123;
        r105 = null;
        int r125 = 0;
    L408:
        if (r125 >= r112.length) goto L360;
        FieldSerializer r126 = r112[r125];     // Catch: Exception -> L377 Throwable -> L379
        FieldInfo r127 = r126.fieldInfo;     // Catch: Exception -> L377 Throwable -> L379
        Field r128 = r127.field;     // Catch: Exception -> L377 Throwable -> L379
        FieldSerializer[] r212 = r112;
        String r129 = r127.name;     // Catch: Exception -> L377 Throwable -> L379
        SerialContext r213 = r101;
        Class<?> r130 = r127.fieldClass;     // Catch: Throwable -> L356 Exception -> L358
        boolean r214 = SerializerFeature.isEnabled(r111.features, r127.serialzeFeatures, SerializerFeature.UseSingleQuotes);     // Catch: Throwable -> L356 Exception -> L358
        if (r111.quoteFieldNames == false) goto L64;
        if (r214 == true) goto L64;
        boolean r215 = true;
    L65:
        if (r124 == true) goto L67;
    L69:
        if (r210 == false) goto L73;
        if (r128 != null) goto L73;
    L71:
        int r216 = r125;
        char r316 = r103;
        SerialContext r317 = r213;
    L355:
        r125 = r216 + 1;
        r110 = r313;
        r112 = r212;
        r103 = r316;
        r101 = r317;
    L73:
        if (applyName(r310, r311, r129) == true) goto L75;
    L78:
        if (r113 == false) goto L71;
        boolean r131 = true;
    L81:
        if (r129.equals(this.beanInfo.typeKey) == true) goto L83;
    L85:
        if (r131 == false) goto L420;
        FieldSerializer r217 = r105;
    L87:
        Object r132 = null;
    L410:
        if (apply(r310, r311, r129, r132) == true) goto L100;
        r216 = r125;
        r316 = r103;
        r317 = r213;
    L344:
        r105 = r217;
        goto L355
    L100:
        if (r130 == String.class) goto L102;
    L105:
        String r133 = processKey(r310, r311, r129, r132);     // Catch: Exception -> L347 Throwable -> L356
        r216 = r125;
        r316 = r103;
        r317 = r213;
        Object r134 = processValue(r310, r126.fieldContext, r311, r129, r132, r314);     // Catch: Exception -> L345 Throwable -> L373
        if (r134 != null) goto L193;
        int r135 = r127.serialzeFeatures;     // Catch: Exception -> L345 Throwable -> L373
        JSONField r136 = r127.getAnnotation();     // Catch: Exception -> L345 Throwable -> L373
        JSONType r137 = this.beanInfo.jsonType;     // Catch: Exception -> L345 Throwable -> L373
        if (r137 == null) goto L113;
        r135 = r135 | SerializerFeature.of(r137.serialzeFeatures());     // Catch: Exception -> L345 Throwable -> L373
    L113:
        if (r136 == null) goto L118;
        if ("".equals(r136.defaultValue()) == true) goto L118;
        r134 = r136.defaultValue();     // Catch: Exception -> L345 Throwable -> L373
    L118:
        if (r130 != Boolean.class) goto L135;
        int r138 = SerializerFeature.WriteNullBooleanAsFalse.mask;     // Catch: Exception -> L345 Throwable -> L373
        int r139 = SerializerFeature.WriteMapNullValue.mask;     // Catch: Exception -> L345 Throwable -> L373
        int r140 = r138 | r139;     // Catch: Exception -> L345 Throwable -> L373
        if (r113 == true) goto L127;
        if ((r135 & r140) != 0) goto L127;
        if ((r140 & r111.features) == 0) goto L344;
    L127:
        if ((r135 & r138) == 0) goto L130;
        r134 = Boolean.FALSE;     // Catch: Exception -> L345 Throwable -> L373
        goto L193
    L130:
        if ((r138 & r111.features) == 0) goto L193;
        if ((r135 & r139) != 0) goto L193;
        r134 = Boolean.FALSE;     // Catch: Exception -> L345 Throwable -> L373
        goto L193
    L135:
        if (r130 != String.class) goto L152;
        int r141 = SerializerFeature.WriteNullStringAsEmpty.mask;     // Catch: Exception -> L345 Throwable -> L373
        int r142 = SerializerFeature.WriteMapNullValue.mask;     // Catch: Exception -> L345 Throwable -> L373
        int r143 = r141 | r142;     // Catch: Exception -> L345 Throwable -> L373
        if (r113 == true) goto L144;
        if ((r135 & r143) != 0) goto L144;
        if ((r143 & r111.features) == 0) goto L344;
    L144:
        if ((r135 & r141) == 0) goto L147;
    L145:
        r134 = "";
        goto L193
    L147:
        if ((r141 & r111.features) == 0) goto L193;
        if ((r135 & r142) != 0) goto L193;
    L152:
        if (Number.class.isAssignableFrom(r130) == false) goto L169;
        int r144 = SerializerFeature.WriteNullNumberAsZero.mask;     // Catch: Exception -> L345 Throwable -> L373
        int r145 = SerializerFeature.WriteMapNullValue.mask;     // Catch: Exception -> L345 Throwable -> L373
        int r146 = r144 | r145;     // Catch: Exception -> L345 Throwable -> L373
        if (r113 == true) goto L161;
        if ((r135 & r146) != 0) goto L161;
        if ((r146 & r111.features) == 0) goto L344;
    L161:
        if ((r135 & r144) == 0) goto L164;
        r134 = 0;     // Catch: Exception -> L345 Throwable -> L373
        goto L193
    L164:
        if ((r144 & r111.features) == 0) goto L193;
        if ((r135 & r145) != 0) goto L193;
        r134 = 0;     // Catch: Exception -> L345 Throwable -> L373
        goto L193
    L169:
        if (Collection.class.isAssignableFrom(r130) == false) goto L185;
        int r147 = SerializerFeature.WriteNullListAsEmpty.mask;     // Catch: Exception -> L345 Throwable -> L373
        int r148 = SerializerFeature.WriteMapNullValue.mask;     // Catch: Exception -> L345 Throwable -> L373
        int r149 = r147 | r148;     // Catch: Exception -> L345 Throwable -> L373
        if (r113 == true) goto L178;
        if ((r135 & r149) != 0) goto L178;
        if ((r149 & r111.features) == 0) goto L344;
    L178:
        if ((r135 & r147) == 0) goto L181;
        r134 = Collections.emptyList();     // Catch: Exception -> L345 Throwable -> L373
        goto L193
    L181:
        if ((r147 & r111.features) == 0) goto L193;
        if ((r135 & r148) != 0) goto L193;
        r134 = Collections.emptyList();     // Catch: Exception -> L345 Throwable -> L373
        goto L193
    L185:
        if (r113 == true) goto L193;
        if (r126.writeNull == true) goto L193;
        SerializerFeature r150 = SerializerFeature.WriteMapNullValue;     // Catch: Exception -> L345 Throwable -> L373
        if (r111.isEnabled(r150.mask) == true) goto L193;
        if ((r135 & r150.mask) == 0) goto L344;
    L193:
        if (r134 != null) goto L195;
    L249:
        if (r211 == false) goto L262;
        if (r127.unwrapped == true) goto L253;
    L257:
        r111.write(44);     // Catch: Exception -> L345 Throwable -> L373
        if (r111.isEnabled(SerializerFeature.PrettyFormat) == false) goto L262;
        r310.println();     // Catch: Exception -> L345 Throwable -> L373
        goto L262
    L253:
        if ((r134 instanceof Map) == false) goto L257;
        if (((Map) r134).size() != 0) goto L257;
    L262:
        if (r133 == r129) goto L269;
        if (r113 == true) goto L266;
        r111.writeFieldName(r133, true);     // Catch: Exception -> L345 Throwable -> L373
    L266:
        r310.write(r134);     // Catch: Exception -> L345 Throwable -> L373
    L324:
        if (r127.unwrapped == true) goto L326;
    L341:
        boolean r151 = false;
    L342:
        if (r151 == true) goto L344;
        r105 = r217;
        r211 = true;
        goto L355
    L326:
        if ((r134 instanceof Map) == false) goto L341;
        Map r152 = (Map) r134;     // Catch: Exception -> L345 Throwable -> L373
        if (r152.size() != 0) goto L331;
    L329:
        r151 = true;
        goto L342
    L331:
        if (r310.isEnabled(SerializerFeature.WriteMapNullValue) == true) goto L341;
        Iterator r153 = r152.values().iterator();     // Catch: Exception -> L345 Throwable -> L373
    L334:
        if (r153.hasNext() == false) goto L338;
        if (r153.next() == null) goto L334;
        boolean r154 = true;
    L339:
        if (r154 == true) goto L341;
    L338:
        r154 = false;
        goto L339
    L269:
        if (r132 == r134) goto L273;
        if (r113 == true) goto L272;
        r126.writePrefix(r310);     // Catch: Exception -> L345 Throwable -> L373
    L272:
        r310.write(r134);     // Catch: Exception -> L345 Throwable -> L373
        goto L324
    L273:
        if (r113 == true) goto L290;
        boolean r155 = Map.class.isAssignableFrom(r130);     // Catch: Exception -> L345 Throwable -> L373
        if (r130.isPrimitive() == true) goto L279;
        if (r130.getName().startsWith("java.") == true) goto L279;
    L280:
        boolean r156 = true;
    L282:
        if (r122 == false) goto L284;
    L287:
        if (r215 == false) goto L289;
        char[] r157 = r127.name_chars;     // Catch: Exception -> L345 Throwable -> L373
        char r158 = 0;
        r111.write(r157, 0, r157.length);     // Catch: Exception -> L345 Throwable -> L373
    L291:
        if (r113 == true) goto L322;
        JSONField r159 = r127.getAnnotation();     // Catch: Exception -> L345 Throwable -> L373
        if (r130 != String.class) goto L315;
        if (r159 != null) goto L296;
    L297:
        if (r134 != null) goto L310;
        int r160 = r126.features;     // Catch: Exception -> L345 Throwable -> L373
        JSONType r161 = this.beanInfo.jsonType;     // Catch: Exception -> L345 Throwable -> L373
        if (r161 == null) goto L301;
        r160 = r160 | SerializerFeature.of(r161.serialzeFeatures());     // Catch: Exception -> L345 Throwable -> L373
    L301:
        int r162 = r111.features;     // Catch: Exception -> L345 Throwable -> L373
        int r163 = SerializerFeature.WriteNullStringAsEmpty.mask;     // Catch: Exception -> L345 Throwable -> L373
        if ((r162 & r163) == 0) goto L307;
        if ((SerializerFeature.WriteMapNullValue.mask & r160) != 0) goto L307;
        r111.writeString("");     // Catch: Exception -> L345 Throwable -> L373
    L307:
        if ((r160 & r163) == 0) goto L309;
        r111.writeString("");     // Catch: Exception -> L345 Throwable -> L373
        goto L324
    L309:
        r111.writeNull();     // Catch: Exception -> L345 Throwable -> L373
        goto L324
    L310:
        String r164 = (String) r134;     // Catch: Exception -> L345 Throwable -> L373
        if (r214 == false) goto L313;
        r111.writeStringWithSingleQuote(r164);     // Catch: Exception -> L345 Throwable -> L373
        goto L324
    L313:
        r111.writeStringWithDoubleQuote(r164, r158);     // Catch: Exception -> L345 Throwable -> L373
        goto L324
    L296:
        if (r159.serializeUsing() == Void.class) goto L297;
    L315:
        if (r127.unwrapped == true) goto L317;
    L321:
        r126.writeValue(r310, r134);     // Catch: Exception -> L345 Throwable -> L373
        goto L324
    L317:
        if ((r134 instanceof Map) == false) goto L321;
        if (((Map) r134).size() != 0) goto L321;
        r105 = r217;
        r211 = false;
        goto L355
    L322:
        r126.writeValue(r310, r134);     // Catch: Exception -> L345 Throwable -> L373
        goto L324
    L289:
        r158 = 0;
        r126.writePrefix(r310);     // Catch: Exception -> L345 Throwable -> L373
        goto L291
    L284:
        if (r127.unwrapped == false) goto L287;
        if (r155 == true) goto L290;
        if (r156 == true) goto L290;
    L279:
        if (r130 == Object.class) goto L280;
        r156 = false;
    L290:
        r158 = 0;
        goto L291
    L195:
        if (r111.notWriteDefaultValue == true) goto L200;
        int r165 = r127.serialzeFeatures;     // Catch: Exception -> L345 Throwable -> L373
        int r166 = SerializerFeature.NotWriteDefaultValue.mask;     // Catch: Exception -> L345 Throwable -> L373
        if ((r165 & r166) != 0) goto L200;
        if ((this.beanInfo.features & r166) == 0) goto L249;
    L200:
        Class<?> r167 = r127.fieldClass;     // Catch: Exception -> L345 Throwable -> L373
        if (r167 != Byte.TYPE) goto L208;
        if ((r134 instanceof Byte) == false) goto L208;
        if (((Byte) r134).byteValue() == 0) goto L344;
    L208:
        if (r167 != Short.TYPE) goto L215;
        if ((r134 instanceof Short) == false) goto L215;
        if (((Short) r134).shortValue() == 0) goto L344;
    L215:
        if (r167 != Integer.TYPE) goto L222;
        if ((r134 instanceof Integer) == false) goto L222;
        if (((Integer) r134).intValue() == 0) goto L344;
    L222:
        if (r167 != Long.TYPE) goto L229;
        if ((r134 instanceof Long) == false) goto L229;
        if (((Long) r134).longValue() == 0) goto L344;
    L229:
        if (r167 != Float.TYPE) goto L236;
        if ((r134 instanceof Float) == false) goto L236;
        if (((Float) r134).floatValue() == 0.0f) goto L344;
    L236:
        if (r167 != Double.TYPE) goto L243;
        if ((r134 instanceof Double) == false) goto L243;
        if (((Double) r134).doubleValue() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L344;
    L243:
        if (r167 != Boolean.TYPE) goto L249;
        if ((r134 instanceof Boolean) == false) goto L249;
        if (((Boolean) r134).booleanValue() == true) goto L249;
    L345:
        e = e;
        r105 = r217;
    L376:
        r104 = r317;
        r106 = e;
    L373:
        th = th;
        r104 = r317;
        goto L406
    L102:
        if ("trim".equals(r127.format) == false) goto L105;
        if (r132 == null) goto L105;
        r132 = ((String) r132).trim();     // Catch: Exception -> L347 Throwable -> L356
    L347:
        e = move-exception;
        r104 = r213;
        r105 = r217;
        r106 = e;
        goto L427
    L420:
        r132 = r126.getPropertyValueDirect(r311);     // Catch: InvocationTargetException -> L90 Throwable -> L356 Exception -> L358
        r217 = r105;
    L90:
        e = move-exception;
        if (r111.isEnabled(SerializerFeature.IgnoreErrorGetter) == false) goto L349;
        r217 = r126;
        goto L87
    L349:
        r317 = r213;
        throw e;     // Catch: Exception -> L351 Throwable -> L373
    L351:
        e = e;
        r105 = r126;
    L353:
        e = e;
        r105 = r126;
    L359:
        r104 = r213;
        r106 = e;
        goto L427
    L83:
        if (r310.isWriteClassName(r110, r311) == false) goto L85;
    L75:
        if (applyLabel(r310, r127.label) == false) goto L78;
        r131 = false;
        goto L81
    L67:
        if (r127.fieldTransient == false) goto L69;
    L64:
        r215 = false;
        goto L65
    L358:
        e = e;
    L356:
        th = th;
        r104 = r213;
        goto L406
    L360:
        char r318 = r103;
        r317 = r101;
        FieldSerializer[] r218 = r112;
        if (r211 == false) goto L363;
        char r168 = ',';
    L412:
        writeAfter(r310, r311, r168);     // Catch: Throwable -> L373 Exception -> L375
        if (r218.length > 0) goto L367;
    L369:
        if (r315 == true) goto L371;
        r111.append(r318);     // Catch: Throwable -> L373 Exception -> L375
    L371:
        r310.context = r317;
        return;
    L367:
        if (r111.isEnabled(SerializerFeature.PrettyFormat) == false) goto L369;
        r310.decrementIdent();     // Catch: Throwable -> L373 Exception -> L375
        r310.println();     // Catch: Throwable -> L373 Exception -> L375
    L375:
        e = e;
        goto L376
    L363:
        r168 = 0;
    L377:
        e = move-exception;
        r104 = r101;
        r106 = e;
        goto L427
    L53:
        r123 = false;
        goto L54
    L49:
        r121 = 0;
    L45:
        r120 = false;
        goto L47
    L40:
        if ((r110 instanceof WildcardType) == false) goto L42;
        r119 = TypeUtils.getClass(r313);     // Catch: Throwable -> L379 Exception -> L381
        goto L43
    L34:
        if ((r314 & r117) != 0) goto L37;
        if (r310.isWriteClassName(r110, r311) == false) goto L45;
    L29:
        if (r111.isEnabled(SerializerFeature.PrettyFormat) == false) goto L31;
        r310.incrementIndent();     // Catch: Throwable -> L379 Exception -> L381
        r310.println();     // Catch: Throwable -> L379 Exception -> L381
        goto L31
    L22:
        r103 = '}';
        goto L23
    L19:
        r102 = '{';
        goto L20
    L12:
        r100 = this.getters;
        goto L13
    }
}
