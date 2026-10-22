package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    private static final int NON_STRINGKEY_AS_STRING = 0;
    public static MapSerializer instance;

    static {
        instance = new MapSerializer();
        NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});
    }

    public MapSerializer() {
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r110, Type r111, int r112) throws IOException {
        write(r100, r101, r110, r111, r112, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void write(JSONSerializer r210, Object r211, Object r212, Type r213, int r214, boolean r215) throws IOException {
        r211 = r211;
        SerializeWriter r110 = r210.out;
        if (r211 != null) goto L6;
        r110.writeNull();
        return;
    L6:
        Map<String, Object> r100 = (Map) r211;
        int r101 = SerializerFeature.MapSortField.mask;
        if ((r110.features & r101) != 0) goto L13;
        if ((r101 & r214) != 0) goto L13;
    L11:
        Map<String, Object> r111 = r100;
    L23:
        if (r210.containsReference(r211) == false) goto L26;
        r210.writeReference(r211);
        return;
    L26:
        SerialContext r112 = r210.context;
        r210.setContext(r112, r211, r212, 0);
        if (r215 == false) goto L222;
    L30:
        r210.incrementIndent();     // Catch: Throwable -> L217
        if (r110.isEnabled(SerializerFeature.WriteClassName) == false) goto L44;
        String r102 = r210.config.typeKey;     // Catch: Throwable -> L217
        Class<?> r103 = r111.getClass();     // Catch: Throwable -> L217
        if (r103 == JSONObject.class) goto L39;
        if (r103 == HashMap.class) goto L39;
        if (r103 == LinkedHashMap.class) goto L39;
    L41:
        boolean r104 = false;
    L42:
        if (r104 == true) goto L44;
        r110.writeFieldName(r102);     // Catch: Throwable -> L217
        r110.writeString(r211.getClass().getName());     // Catch: Throwable -> L217
        boolean r105 = false;
    L45:
        Iterator<Map.Entry<String, Object>> r113 = r111.entrySet().iterator();     // Catch: Throwable -> L217
        boolean r114 = r105;
        Class<?> r106 = null;
        ObjectSerializer r115 = null;
    L46:
        if (r113.hasNext() == false) goto L209;
        Map.Entry<String, Object> r107 = r113.next();     // Catch: Throwable -> L217
        Object r108 = r107.getValue();     // Catch: Throwable -> L217
        String r109 = r107.getKey();     // Catch: Throwable -> L217
        List<PropertyPreFilter> r116 = r210.propertyPreFilters;     // Catch: Throwable -> L217
        if (r116 != null) goto L51;
    L66:
        List<PropertyPreFilter> r117 = this.propertyPreFilters;     // Catch: Throwable -> L217
        if (r117 != null) goto L69;
    L84:
        List<PropertyFilter> r118 = r210.propertyFilters;     // Catch: Throwable -> L217
        if (r118 != null) goto L87;
    L102:
        List<PropertyFilter> r119 = this.propertyFilters;     // Catch: Throwable -> L217
        if (r119 != null) goto L105;
    L120:
        List<NameFilter> r120 = r210.nameFilters;     // Catch: Throwable -> L217
        if (r120 != null) goto L123;
    L134:
        List<NameFilter> r121 = this.nameFilters;     // Catch: Throwable -> L217
        if (r121 != null) goto L137;
    L148:
        String r122 = r109;
        if (r122 != null) goto L151;
    L163:
        String r123 = r122;
        boolean r124 = true;
        Object r125 = processValue(r210, null, r211, r123, r108, r214);     // Catch: Throwable -> L217
    L164:
        Object r126 = r125;
        ?? r127 = r124;
    L165:
        if (r126 != null) goto L170;
        if (SerializerFeature.isEnabled(r110.features, r214, SerializerFeature.WriteMapNullValue) == true) goto L170;
    L168:
        r211 = r211;
        r106 = r106;
    L170:
        if ((r123 instanceof String) == false) goto L178;
        String r128 = r123;     // Catch: Throwable -> L217
        if (r114 == true) goto L175;
        r110.write(44);     // Catch: Throwable -> L217
    L175:
        if (r110.isEnabled(SerializerFeature.PrettyFormat) == false) goto L177;
        r210.println();     // Catch: Throwable -> L217
    L177:
        r110.writeFieldName(r128, r127);     // Catch: Throwable -> L217
    L189:
        if (r126 != null) goto L192;
        r110.writeNull();     // Catch: Throwable -> L217
        r106 = r106;
    L191:
        r114 = false;
        goto L46
    L192:
        Class<?> r129 = r126.getClass();     // Catch: Throwable -> L217
        Class<?> r130 = r106;
        if (r129 == r130) goto L195;
        r115 = r210.getObjectWriter(r129);     // Catch: Throwable -> L217
        Class<?> r131 = r129;
    L196:
        ObjectSerializer r132 = r115;
        if (SerializerFeature.isEnabled(r214, SerializerFeature.WriteClassName) == true) goto L199;
    L207:
        r115 = r132;
        r115.write(r210, r126, r123, null, r214);     // Catch: Throwable -> L217
    L208:
        r106 = r131;
        goto L191
    L199:
        if ((r132 instanceof JavaBeanSerializer) == false) goto L207;
        if ((r213 instanceof ParameterizedType) == false) goto L205;
        Type[] r133 = ((ParameterizedType) r213).getActualTypeArguments();     // Catch: Throwable -> L217
        if (r133.length != 2) goto L205;
        Type r134 = r133[r127];     // Catch: Throwable -> L217
    L206:
        r115 = r132;
        ((JavaBeanSerializer) r132).writeNoneASM(r210, r126, r123, r134, r214);     // Catch: Throwable -> L217
    L205:
        r134 = null;
        goto L206
    L195:
        r131 = r130;
        goto L196
    L178:
        if (r114 == true) goto L181;
        r110.write(44);     // Catch: Throwable -> L217
    L181:
        if (r110.isEnabled(NON_STRINGKEY_AS_STRING) == true) goto L185;
        if (SerializerFeature.isEnabled(r214, SerializerFeature.WriteNonStringKeyAsString) == true) goto L185;
    L187:
        r210.write(r123);     // Catch: Throwable -> L217
    L188:
        r110.write(58);     // Catch: Throwable -> L217
    L185:
        if ((r123 instanceof Enum) == true) goto L187;
        r210.write(JSON.toJSONString(r123));     // Catch: Throwable -> L217
        goto L188
    L151:
        if ((r122 instanceof String) == true) goto L163;
        if ((r122 instanceof Map) == false) goto L156;
    L159:
        boolean r135 = true;
    L160:
        if (r135 == true) goto L162;
        r123 = r122;
        r124 = true;
        r125 = processValue(r210, null, r211, JSON.toJSONString(r122), r108, r214);     // Catch: Throwable -> L217
        goto L164
    L162:
        r123 = r122;
        r106 = r106;
        r127 = 1;
        r126 = r108;
        goto L165
    L156:
        if ((r122 instanceof Collection) == true) goto L159;
        r135 = false;
        goto L160
    L137:
        if (r121.size() <= 0) goto L148;
        if (r109 != null) goto L140;
    L147:
        r109 = processKey(r210, r211, r109, r108);     // Catch: Throwable -> L217
        goto L148
    L140:
        if ((r109 instanceof String) == true) goto L147;
        if (r109.getClass().isPrimitive() == false) goto L145;
    L146:
        r109 = processKey(r210, r211, JSON.toJSONString(r109), r108);     // Catch: Throwable -> L217
        goto L148
    L145:
        if ((r109 instanceof Number) == false) goto L148;
    L123:
        if (r120.size() <= 0) goto L134;
        if (r109 != null) goto L126;
    L133:
        r109 = processKey(r210, r211, r109, r108);     // Catch: Throwable -> L217
        goto L134
    L126:
        if ((r109 instanceof String) == true) goto L133;
        if (r109.getClass().isPrimitive() == false) goto L131;
    L132:
        r109 = processKey(r210, r211, JSON.toJSONString(r109), r108);     // Catch: Throwable -> L217
        goto L134
    L131:
        if ((r109 instanceof Number) == false) goto L134;
    L105:
        if (r119.size() <= 0) goto L120;
        if (r109 == null) goto L118;
        if ((r109 instanceof String) == true) goto L118;
        if (r109.getClass().isPrimitive() == true) goto L115;
        if ((r109 instanceof Number) == false) goto L120;
    L115:
        if (apply(r210, r211, JSON.toJSONString(r109), r108) == true) goto L120;
    L65:
        r106 = r106;
    L118:
        if (apply(r210, r211, r109, r108) == true) goto L120;
    L87:
        if (r118.size() <= 0) goto L102;
        if (r109 == null) goto L100;
        if ((r109 instanceof String) == true) goto L100;
        if (r109.getClass().isPrimitive() == true) goto L97;
        if ((r109 instanceof Number) == false) goto L102;
    L97:
        if (apply(r210, r211, JSON.toJSONString(r109), r108) == true) goto L102;
    L100:
        if (apply(r210, r211, r109, r108) == true) goto L102;
    L69:
        if (r117.size() <= 0) goto L84;
        if (r109 == null) goto L82;
        if ((r109 instanceof String) == true) goto L82;
        if (r109.getClass().isPrimitive() == true) goto L79;
        if ((r109 instanceof Number) == false) goto L84;
    L79:
        if (applyName(r210, r211, JSON.toJSONString(r109)) == true) goto L84;
    L82:
        if (applyName(r210, r211, r109) == true) goto L84;
    L51:
        if (r116.size() <= 0) goto L66;
        if (r109 == null) goto L64;
        if ((r109 instanceof String) == true) goto L64;
        if (r109.getClass().isPrimitive() == true) goto L61;
        if ((r109 instanceof Number) == false) goto L66;
    L61:
        if (applyName(r210, r211, JSON.toJSONString(r109)) == true) goto L66;
    L64:
        if (applyName(r210, r211, r109) == true) goto L66;
    L209:
        r210.context = r112;
        r210.decrementIdent();
        if (r110.isEnabled(SerializerFeature.PrettyFormat) == true) goto L212;
    L214:
        if (r215 == true) goto L239;
        r110.write(125);
        return;
    L239:
        return;
    L212:
        if (r111.size() <= 0) goto L214;
        r210.println();
    L217:
        th = move-exception;
        r210.context = r112;
        throw th;
    L39:
        if (r111.containsKey(r102) == false) goto L41;
        r104 = true;
    L44:
        r105 = true;
        goto L45
    L222:
        r110.write(123);     // Catch: Throwable -> L217
    L13:
        if ((r100 instanceof JSONObject) == false) goto L16;
        r100 = ((JSONObject) r100).getInnerMap();
    L16:
        if ((r100 instanceof SortedMap) == true) goto L11;
        if ((r100 instanceof LinkedHashMap) == true) goto L11;
        r111 = new TreeMap(r100);     // Catch: Exception -> L21
        goto L23
    }
}
