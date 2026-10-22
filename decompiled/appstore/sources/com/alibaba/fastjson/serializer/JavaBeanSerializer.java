package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JavaBeanSerializer implements ObjectSerializer {
    private static final char[] false_chars = null;
    private static final char[] true_chars = null;
    protected int features;
    private final FieldSerializer[] getters;
    private final FieldSerializer[] sortedGetters;
    protected String typeName;

    static {
        true_chars = new char[]{'t', 'r', 'u', 'e'};
        false_chars = new char[]{'f', 'a', 'l', 's', 'e'};
    }

    public JavaBeanSerializer(Class<?> r10) {
        this(r10, null);
    }

    private static Map<String, String> map(String... r10) {
        HashMap r11 = new HashMap();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        String r14 = r10[r13];
        r11.put(r14, r14);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public Map<String, Object> getFieldValuesMap(Object r10) throws Exception {
        LinkedHashMap r11 = new LinkedHashMap(this.sortedGetters.length);
        FieldSerializer[] r12 = this.sortedGetters;
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        FieldSerializer r15 = r12[r14];
        r11.put(r15.fieldInfo.name, r15.getPropertyValue(r10));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r33, Object r34, Object r35, Type r36) throws IOException {
        SerializeWriter r10 = r33.out;
        if (r34 != null) goto L6;
        r10.writeNull();
        return;
    L6:
        SerialContext r11 = r33.context;
        if (r11 != null) goto L9;
    L10:
        IdentityHashMap<Object, SerialContext> r12 = r33.references;
        if (r12 != null) goto L13;
    L16:
        int r13 = r10.features;
        if ((SerializerFeature.SortField.mask & r13) == 0) goto L19;
        FieldSerializer[] r14 = this.sortedGetters;
    L20:
        SerialContext r15 = r33.context;
        if ((r13 & SerializerFeature.DisableCircularReferenceDetect.mask) != 0) goto L26;
        r33.context = new SerialContext(r15, r34, r35, this.features);
        if (r33.references != null) goto L25;
        r33.references = new IdentityHashMap();
    L25:
        r33.references.put(r34, r33.context);
    L26:
        int r16 = this.features;
        int r17 = SerializerFeature.BeanToArray.mask;
        if ((r16 & r17) == 0) goto L29;
    L32:
        boolean r18 = true;
    L33:
        if (r18 == false) goto L35;
        char r19 = '[';
    L36:
        if (r18 == false) goto L38;
        char r110 = ']';
    L392:
        int r111 = r10.count + 1;     // Catch: Throwable -> L373 Exception -> L375
        if (r111 > r10.buf.length) goto L388;
    L50:
        r10.buf[r10.count] = r19;     // Catch: Throwable -> L373 Exception -> L375
        r10.count = r111;     // Catch: Throwable -> L373 Exception -> L375
        if (r14.length > 0) goto L53;
    L55:
        int r112 = this.features;     // Catch: Throwable -> L373 Exception -> L375
        int r113 = SerializerFeature.WriteClassName.mask;     // Catch: Throwable -> L373 Exception -> L375
        if ((r112 & r113) != 0) goto L66;
        int r114 = r10.features;     // Catch: Throwable -> L44 Exception -> L46
        if ((r113 & r114) == 0) goto L72;
        if (r36 != null) goto L66;
        if ((r114 & SerializerFeature.NotWriteRootClassName.mask) == 0) goto L66;
        if (r33.context.parent != null) goto L66;
    L72:
        char r20 = 0;
    L73:
        List<BeforeFilter> r21 = r33.beforeFilters;     // Catch: Throwable -> L373 Exception -> L375
        if (r21 == null) goto L80;
        Iterator<BeforeFilter> r22 = r21.iterator();     // Catch: Throwable -> L44 Exception -> L46
    L77:
        if (r22.hasNext() == false) goto L80;
        r20 = r22.next().writeBefore(r33, r34, r20);     // Catch: Throwable -> L44 Exception -> L46
    L80:
        if (r20 != ',') goto L82;
        boolean r23 = true;
    L83:
        int r24 = r10.features;     // Catch: Throwable -> L373 Exception -> L375
        if ((SerializerFeature.QuoteFieldNames.mask & r24) == 0) goto L90;
    L46:
        e = move-exception;
        Exception r25 = e;
        SerialContext r26 = r15;
    L377:
        String r27 = "write javaBean error";
        if (r35 == null) goto L383;
        r27 = "write javaBean error, fieldName : " + r35;     // Catch: Throwable -> L380
    L380:
        th = th;
    L369:
        Throwable r28 = th;
    L384:
        r33.context = r26;
        throw r28;
    L383:
        throw new JSONException(r27, r25);     // Catch: Throwable -> L380
    L44:
        th = move-exception;
        r28 = th;
        r26 = r15;
        goto L384
    L88:
        if ((SerializerFeature.UseSingleQuotes.mask & r24) != 0) goto L90;
        boolean r115 = true;
    L92:
        if ((SerializerFeature.UseSingleQuotes.mask & r24) == 0) goto L94;
        boolean r116 = true;
    L96:
        if ((r24 & SerializerFeature.NotWriteDefaultValue.mask) == 0) goto L98;
        boolean r29 = true;
    L99:
        List<PropertyFilter> r117 = r33.propertyFilters;     // Catch: Throwable -> L373 Exception -> L375
        List<NameFilter> r118 = r33.nameFilters;     // Catch: Throwable -> L373 Exception -> L375
        List<ValueFilter> r119 = r33.valueFilters;     // Catch: Throwable -> L373 Exception -> L375
        boolean r32 = r23;
        List<PropertyPreFilter> r30 = r33.propertyPreFilters;     // Catch: Throwable -> L373 Exception -> L375
        boolean r120 = r32;
        int r31 = 0;
    L390:
    L370:
        e = e;
        r26 = r15;
    L372:
        r25 = e;
    L367:
        th = th;
        r26 = r15;
        goto L369
    L102:
        if (r31 >= r14.length) goto L339;
        FieldSerializer r37 = r14[r31];     // Catch: Throwable -> L111 Exception -> L113
        char r121 = r110;
        FieldInfo r122 = r37.fieldInfo;     // Catch: Throwable -> L111 Exception -> L113
        FieldSerializer[] r210 = r14;
        Class<?> r38 = r122.fieldClass;     // Catch: Throwable -> L111 Exception -> L113
        int r39 = r31;
        String r40 = r122.name;     // Catch: Throwable -> L111 Exception -> L113
        boolean r310 = r116;
        boolean r211 = r115;
        if ((SerializerFeature.SkipTransientField.mask & r10.features) != 0) goto L106;
    L115:
        if (r30 == null) goto L122;
        Iterator<PropertyPreFilter> r123 = r30.iterator();     // Catch: Throwable -> L111 Exception -> L113
    L118:
        if (r123.hasNext() == false) goto L122;
        if (r123.next().apply(r33, r34, r40) == true) goto L118;
        boolean r124 = false;
    L123:
        if (r124 == true) goto L126;
    L109:
        List<PropertyPreFilter> r212 = r30;
    L110:
        r118 = r118;
        List<ValueFilter> r213 = r119;
        List<PropertyFilter> r311 = r117;
    L237:
        boolean r312 = r29;
    L338:
        r116 = r310;
        r31 = r39 + 1;
        r110 = r121;
        r14 = r210;
        r115 = r211;
        r30 = r212;
        r118 = r118;
        r119 = r213;
        r117 = r311;
        r29 = r312;
        goto L390
    L126:
        if (r122.fieldAccess == false) goto L139;
        Object r125 = null;
        if (r38 != Integer.TYPE) goto L131;
        long r214 = 0;
        boolean r215 = false;
        boolean r216 = false;
        int r217 = r122.field.getInt(r34);     // Catch: Throwable -> L111 Exception -> L113
        boolean r126 = true;
    L140:
        if (r117 == null) goto L161;
        if (r126 == false) goto L152;
        r212 = r30;
        if (r38 != Integer.TYPE) goto L147;
        r125 = Integer.valueOf(r217);     // Catch: Throwable -> L111 Exception -> L113
    L145:
        r215 = true;
    L153:
        Iterator<PropertyFilter> r41 = r117.iterator();     // Catch: Throwable -> L111 Exception -> L113
    L155:
        if (r41.hasNext() == false) goto L160;
        Iterator<PropertyFilter> r218 = r41;
        if (r41.next().apply(r34, r40, r125) == false) goto L158;
        r41 = r218;
        goto L155
    L158:
        boolean r42 = false;
    L162:
        if (r42 == false) goto L110;
        if (r118 == null) goto L181;
        if (r126 == false) goto L177;
        if (r215 == true) goto L177;
        if (r38 != Integer.TYPE) goto L172;
        r125 = Integer.valueOf(r217);     // Catch: Throwable -> L111 Exception -> L113
    L170:
        r215 = true;
        goto L177
    L172:
        if (r38 != Long.TYPE) goto L175;
        r125 = Long.valueOf(r214);     // Catch: Throwable -> L111 Exception -> L113
        goto L170
    L175:
        if (r38 != Boolean.TYPE) goto L177;
        r125 = Boolean.valueOf(r216);     // Catch: Throwable -> L111 Exception -> L113
    L177:
        Iterator<NameFilter> r43 = r118.iterator();     // Catch: Throwable -> L111 Exception -> L113
        String r127 = r40;
    L179:
        if (r43.hasNext() == false) goto L182;
        r127 = r43.next().process(r34, r127, r125);     // Catch: Throwable -> L111 Exception -> L113
        r43 = r43;
    L182:
        if (r119 == null) goto L200;
        if (r126 == false) goto L195;
        if (r215 == true) goto L195;
        if (r38 != Integer.TYPE) goto L190;
        r125 = Integer.valueOf(r217);     // Catch: Throwable -> L111 Exception -> L113
    L188:
        r215 = true;
        goto L195
    L190:
        if (r38 != Long.TYPE) goto L193;
        r125 = Long.valueOf(r214);     // Catch: Throwable -> L111 Exception -> L113
        goto L188
    L193:
        if (r38 != Boolean.TYPE) goto L195;
        r125 = Boolean.valueOf(r216);     // Catch: Throwable -> L111 Exception -> L113
    L195:
        Iterator<ValueFilter> r44 = r119.iterator();     // Catch: Throwable -> L111 Exception -> L113
        Object r219 = r125;
    L197:
        if (r44.hasNext() == false) goto L199;
        r125 = r44.next().process(r34, r40, r125);     // Catch: Throwable -> L111 Exception -> L113
        r44 = r44;
        goto L197
    L199:
        Object r45 = r219;
    L201:
        if (r215 == false) goto L210;
        if (r125 != null) goto L210;
        if (r18 == true) goto L210;
        r213 = r119;
        if (r37.writeNull == true) goto L209;
        r311 = r117;
        if ((r10.features & SerializerFeature.WriteMapNullValue.mask) == 0) goto L237;
    L211:
        if (r215 == false) goto L238;
        if (r125 == null) goto L238;
        if (r29 == false) goto L238;
        if (r38 == Byte.TYPE) goto L227;
        if (r38 == Short.TYPE) goto L227;
        if (r38 == Integer.TYPE) goto L227;
        if (r38 == Long.TYPE) goto L227;
        if (r38 == Float.TYPE) goto L227;
        if (r38 == Double.TYPE) goto L227;
    L232:
        if (r38 != Boolean.TYPE) goto L238;
        if ((r125 instanceof Boolean) == false) goto L238;
        if (((Boolean) r125).booleanValue() == true) goto L238;
    L227:
        if ((r125 instanceof Number) == false) goto L232;
        if (((Number) r125).byteValue() != 0) goto L232;
    L238:
        if (r120 == false) goto L248;
        int r128 = r10.count + 1;     // Catch: Throwable -> L111 Exception -> L113
        if (r128 > r10.buf.length) goto L242;
    L245:
        r312 = r29;
        r10.buf[r10.count] = ',';     // Catch: Throwable -> L111 Exception -> L113
        r10.count = r128;     // Catch: Throwable -> L111 Exception -> L113
        if ((r10.features & SerializerFeature.PrettyFormat.mask) == 0) goto L249;
        r33.println();     // Catch: Throwable -> L111 Exception -> L113
    L249:
        if (r127 == r40) goto L254;
        if (r18 == true) goto L252;
        r10.writeFieldName(r127, true);     // Catch: Throwable -> L111 Exception -> L113
    L252:
        r33.write(r125);     // Catch: Throwable -> L111 Exception -> L113
    L337:
        r120 = true;
        goto L338
    L254:
        if (r45 == r125) goto L258;
        if (r18 == true) goto L257;
        r37.writePrefix(r33);     // Catch: Throwable -> L111 Exception -> L113
    L257:
        r33.write(r125);     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L258:
        if (r18 == true) goto L272;
        if (r211 == false) goto L271;
        char[] r46 = r37.name_chars;     // Catch: Throwable -> L111 Exception -> L113
        int r47 = r46.length;     // Catch: Throwable -> L111 Exception -> L113
        int r48 = r10.count + r47;     // Catch: Throwable -> L111 Exception -> L113
        if (r48 > r10.buf.length) goto L263;
    L269:
        int r129 = 0;
    L270:
        System.arraycopy(r46, r129, r10.buf, r10.count, r47);     // Catch: Throwable -> L111 Exception -> L113
        r10.count = r48;     // Catch: Throwable -> L111 Exception -> L113
        goto L272
    L263:
        if (r10.writer != null) goto L265;
        r10.expandCapacity(r48);     // Catch: Throwable -> L111 Exception -> L113
        goto L269
    L265:
        int r49 = 0;
    L266:
        char[] r130 = r10.buf;     // Catch: Throwable -> L111 Exception -> L113
        int r131 = r130.length;     // Catch: Throwable -> L111 Exception -> L113
        int r132 = r10.count;     // Catch: Throwable -> L111 Exception -> L113
        int r133 = r131 - r132;     // Catch: Throwable -> L111 Exception -> L113
        System.arraycopy(r46, r49, r130, r132, r133);     // Catch: Throwable -> L111 Exception -> L113
        r10.count = r10.buf.length;     // Catch: Throwable -> L111 Exception -> L113
        r10.flush();     // Catch: Throwable -> L111 Exception -> L113
        r47 = r47 - r133;     // Catch: Throwable -> L111 Exception -> L113
        r49 = r49 + r133;     // Catch: Throwable -> L111 Exception -> L113
        if (r47 > r10.buf.length) goto L266;
        r129 = r49;
        r48 = r47;
        goto L270
    L271:
        r37.writePrefix(r33);     // Catch: Throwable -> L111 Exception -> L113
    L272:
        if (r126 == false) goto L306;
        if (r215 == true) goto L306;
        if (r38 != Integer.TYPE) goto L299;
        int r134 = r217;
        if (r134 != Integer.MIN_VALUE) goto L279;
        r10.write("-2147483648");     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L279:
        if (r134 >= 0) goto L281;
        int r50 = -r134;
    L282:
        int r51 = 0;
    L284:
        if (r50 <= SerializeWriter.sizeTable[r51]) goto L285;
        r51 = r51 + 1;     // Catch: Throwable -> L111 Exception -> L113
        goto L284
    L285:
        int r52 = r51 + 1;     // Catch: Throwable -> L111 Exception -> L113
        if (r134 >= 0) goto L288;
        r52 = r51 + 2;     // Catch: Throwable -> L111 Exception -> L113
    L288:
        int r53 = r10.count + r52;     // Catch: Throwable -> L111 Exception -> L113
        if (r53 > r10.buf.length) goto L291;
    L294:
        boolean r54 = false;
    L295:
        if (r54 == true) goto L337;
        SerializeWriter.getChars(r134, r53, r10.buf);     // Catch: Throwable -> L111 Exception -> L113
        r10.count = r53;     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L291:
        if (r10.writer != null) goto L293;
        r10.expandCapacity(r53);     // Catch: Throwable -> L111 Exception -> L113
        goto L294
    L293:
        char[] r55 = new char[r52];     // Catch: Throwable -> L111 Exception -> L113
        SerializeWriter.getChars(r134, r52, r55);     // Catch: Throwable -> L111 Exception -> L113
        r10.write(r55, 0, r52);     // Catch: Throwable -> L111 Exception -> L113
        r54 = true;
        goto L295
    L281:
        r50 = r134;
        goto L282
    L299:
        if (r38 != Long.TYPE) goto L302;
        r33.out.writeLong(r214);     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L302:
        if (r38 != Boolean.TYPE) goto L337;
        if (r216 == false) goto L305;
        SerializeWriter r56 = r33.out;     // Catch: Throwable -> L111 Exception -> L113
        char[] r57 = true_chars;     // Catch: Throwable -> L111 Exception -> L113
        r56.write(r57, 0, r57.length);     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L305:
        SerializeWriter r58 = r33.out;     // Catch: Throwable -> L111 Exception -> L113
        char[] r59 = false_chars;     // Catch: Throwable -> L111 Exception -> L113
        r58.write(r59, 0, r59.length);     // Catch: Throwable -> L111 Exception -> L113
    L306:
        if (r18 == false) goto L308;
        r37.writeValue(r33, r125);     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L308:
        if (r38 != String.class) goto L322;
        if (r125 != null) goto L317;
        int r60 = r10.features;     // Catch: Throwable -> L111 Exception -> L113
        int r61 = SerializerFeature.WriteNullStringAsEmpty.mask;     // Catch: Throwable -> L111 Exception -> L113
        if ((r60 & r61) == 0) goto L313;
    L316:
        r10.writeString("");     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L313:
        if ((r37.features & r61) != 0) goto L316;
        r10.writeNull();     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L317:
        String r135 = (String) r125;     // Catch: Throwable -> L111 Exception -> L113
        if (r310 == false) goto L320;
        r10.writeStringWithSingleQuote(r135);     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L320:
        r10.writeStringWithDoubleQuote(r135, 0, true);     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L322:
        if (r122.isEnum == false) goto L335;
        if (r125 != null) goto L325;
        r10.writeNull();     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L325:
        if ((r10.features & SerializerFeature.WriteEnumUsingToString.mask) == 0) goto L333;
        String r62 = ((Enum) r125).toString();     // Catch: Throwable -> L111 Exception -> L113
        if ((r10.features & SerializerFeature.UseSingleQuotes.mask) == 0) goto L329;
        boolean r136 = true;
    L330:
        if (r136 == false) goto L332;
        r10.writeStringWithSingleQuote(r62);     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L332:
        r10.writeStringWithDoubleQuote(r62, 0, false);     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L329:
        r136 = false;
        goto L330
    L333:
        r10.writeInt(((Enum) r125).ordinal());     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L335:
        r37.writeValue(r33, r125);     // Catch: Throwable -> L111 Exception -> L113
        goto L337
    L242:
        if (r10.writer != null) goto L244;
        r10.expandCapacity(r128);     // Catch: Throwable -> L111 Exception -> L113
        goto L245
    L244:
        r10.flush();     // Catch: Throwable -> L111 Exception -> L113
        r128 = 1;
        goto L245
    L248:
        r312 = r29;
    L209:
        r311 = r117;
    L210:
        r213 = r119;
        goto L209
    L200:
        r45 = r125;
        goto L201
    L181:
        r127 = r40;
    L160:
        r42 = true;
        goto L162
    L147:
        if (r38 != Long.TYPE) goto L150;
        r125 = Long.valueOf(r214);     // Catch: Throwable -> L111 Exception -> L113
        goto L145
    L150:
        if (r38 != Boolean.TYPE) goto L153;
        r125 = Boolean.valueOf(r216);     // Catch: Throwable -> L111 Exception -> L113
        goto L145
    L152:
        r212 = r30;
        goto L153
    L161:
        r212 = r30;
        goto L160
    L131:
        if (r38 != Long.TYPE) goto L135;
        r214 = r122.field.getLong(r34);     // Catch: Throwable -> L111 Exception -> L113
        r126 = true;
        r215 = false;
    L133:
        r217 = 0;
        r216 = false;
        goto L140
    L135:
        if (r38 != Boolean.TYPE) goto L137;
        r216 = r122.field.getBoolean(r34);     // Catch: Throwable -> L111 Exception -> L113
        r214 = 0;
        r126 = true;
        r215 = false;
        r217 = 0;
        goto L140
    L137:
        r125 = r122.field.get(r34);     // Catch: Throwable -> L111 Exception -> L113
    L138:
        r214 = 0;
        r126 = false;
        r215 = true;
        goto L133
    L139:
        r125 = r37.getPropertyValue(r34);     // Catch: Throwable -> L111 Exception -> L113
    L122:
        r124 = true;
        goto L123
    L106:
        if (r122.field == null) goto L115;
        if (r122.fieldTransient == false) goto L115;
    L113:
        e = move-exception;
        r25 = e;
        r26 = r15;
    L111:
        th = move-exception;
        r28 = th;
        r26 = r15;
        goto L384
    L339:
        FieldSerializer[] r220 = r14;
        char r137 = r110;
        List<AfterFilter> r63 = r33.afterFilters;     // Catch: Throwable -> L367 Exception -> L370
        if (r63 == null) goto L352;
        if (r120 == false) goto L344;
        char r138 = ',';
    L345:
        Iterator<AfterFilter> r64 = r63.iterator();     // Catch: Throwable -> L111 Exception -> L113
    L347:
        if (r64.hasNext() == false) goto L352;
        r138 = r64.next().writeAfter(r33, r34, r138);     // Catch: Throwable -> L111 Exception -> L113
        goto L347
    L344:
        r138 = 0;
    L352:
        if (r220.length > 0) goto L354;
    L356:
        int r65 = r10.count + 1;     // Catch: Throwable -> L367 Exception -> L370
        if (r65 > r10.buf.length) goto L359;
    L363:
        int r139 = r65;
    L364:
        r10.buf[r10.count] = r137;     // Catch: Throwable -> L367 Exception -> L370
        r10.count = r139;     // Catch: Throwable -> L367 Exception -> L370
        r33.context = r15;
        return;
    L359:
        if (r10.writer != null) goto L361;
        r10.expandCapacity(r65);     // Catch: Throwable -> L111 Exception -> L113
        goto L363
    L361:
        r10.flush();     // Catch: Throwable -> L111 Exception -> L113
        r139 = 1;
        goto L364
    L354:
        if ((r10.features & SerializerFeature.PrettyFormat.mask) == 0) goto L356;
        r33.decrementIdent();     // Catch: Throwable -> L111 Exception -> L113
        r33.println();     // Catch: Throwable -> L111 Exception -> L113
        goto L356
    L98:
        r29 = false;
        goto L99
    L94:
        r116 = false;
    L90:
        r115 = false;
        goto L92
    L82:
        r23 = false;
    L66:
        if (r34.getClass() == r36) goto L72;
        r10.writeFieldName(r33.config.typeKey, false);     // Catch: Throwable -> L44 Exception -> L46
        String r66 = this.typeName;     // Catch: Throwable -> L44 Exception -> L46
        if (r66 != null) goto L70;
        r66 = r34.getClass().getName();     // Catch: Throwable -> L44 Exception -> L46
    L70:
        r33.write(r66);     // Catch: Throwable -> L44 Exception -> L46
        r20 = ',';
        goto L73
    L53:
        if ((r10.features & SerializerFeature.PrettyFormat.mask) == 0) goto L55;
        r33.incrementIndent();     // Catch: Throwable -> L44 Exception -> L46
        r33.println();     // Catch: Throwable -> L44 Exception -> L46
        goto L55
    L388:
        if (r10.writer != null) goto L48;
        r10.expandCapacity(r111);     // Catch: Throwable -> L44 Exception -> L46
        goto L50
    L48:
        r10.flush();     // Catch: Throwable -> L44 Exception -> L46
        r111 = 1;
    L375:
        e = e;
        r26 = r15;
    L373:
        th = th;
        r26 = r15;
        goto L369
    L38:
        r110 = '}';
        goto L392
    L35:
        r19 = '{';
        goto L36
    L29:
        if ((r10.features & r17) != 0) goto L32;
        r18 = false;
        goto L33
    L19:
        r14 = this.getters;
        goto L20
    L13:
        if (r12.containsKey(r34) == false) goto L16;
        r33.writeReference(r34);
        return;
    L9:
        if ((r11.features & SerializerFeature.DisableCircularReferenceDetect.mask) != 0) goto L16;
        goto L10
    }

    public JavaBeanSerializer(Class<?> r10, PropertyNamingStrategy r11) {
        this(r10, r10.getModifiers(), null, false, true, true, true, r11);
    }

    public JavaBeanSerializer(Class<?> r10, String... r11) {
        this(r10, r10.getModifiers(), map(r11), false, true, true, true, null);
    }

    public JavaBeanSerializer(Class<?> r15, int r16, Map<String, String> r17, boolean r18, boolean r19, boolean r20, boolean r21, PropertyNamingStrategy r22) {
        this.features = 0;
        String[] r10 = null;
        if (r19 == false) goto L5;
        JSONType r11 = (JSONType) r15.getAnnotation(JSONType.class);
    L6:
        if (r11 == null) goto L10;
        this.features = SerializerFeature.of(r11.serialzeFeatures());
        String r12 = r11.typeName();
        this.typeName = r12;
        if (r12.length() != 0) goto L10;
        this.typeName = null;
    L10:
        List<FieldInfo> r13 = TypeUtils.computeGetters(r15, r16, r18, r11, r17, false, r20, r21, r22);
        ArrayList r14 = new ArrayList();
        Iterator<FieldInfo> r23 = r13.iterator();
    L12:
        if (r23.hasNext() == false) goto L14;
        r14.add(new FieldSerializer(r23.next()));
        goto L12
    L14:
        FieldSerializer[] r24 = (FieldSerializer[]) r14.toArray(new FieldSerializer[r14.size()]);
        this.getters = r24;
        if (r11 == null) goto L17;
        r10 = r11.orders();
    L17:
        if (r10 != null) goto L19;
    L25:
        FieldSerializer[] r25 = new FieldSerializer[r24.length];
        System.arraycopy(r24, 0, r25, 0, r24.length);
        Arrays.sort(r25);
        if (Arrays.equals(r25, r24) == false) goto L28;
        this.sortedGetters = r24;
        return;
    L28:
        this.sortedGetters = r25;
        return;
    L19:
        if (r10.length == 0) goto L25;
        List<FieldInfo> r26 = TypeUtils.computeGetters(r15, r16, r18, r11, r17, true, r20, r21, r22);
        ArrayList r27 = new ArrayList();
        Iterator<FieldInfo> r28 = r26.iterator();
    L22:
        if (r28.hasNext() == false) goto L24;
        r27.add(new FieldSerializer(r28.next()));
        goto L22
    L24:
        this.sortedGetters = (FieldSerializer[]) r27.toArray(new FieldSerializer[r27.size()]);
        return;
    L5:
        r11 = null;
        goto L6
    }
}
