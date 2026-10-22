package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    public final JavaBeanInfo beanInfo;
    private final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    private final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig r10, Class<?> r11, Type r12) {
        this(r10, r11, r12, JavaBeanInfo.build(r11, r11.getModifiers(), r12, false, true, true, true, r10.propertyNamingStrategy));
    }

    private <T> T deserialzeArrayMapping(DefaultJSONParser r17, Type r18, Object r19, Object r20) {
        JSONLexer r10 = r17.lexer;
        T r11 = (T) createInstance(r17, r18);
        int r12 = this.sortedFieldDeserializers.length;
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L187;
        if (r13 != (r12 - 1)) goto L8;
        char r14 = ']';
    L9:
        FieldDeserializer r15 = this.sortedFieldDeserializers[r13];
        FieldInfo r16 = r15.fieldInfo;
        Class<?> r110 = r16.fieldClass;
    L15:
        e = move-exception;
        throw new JSONException("set " + r16.name + "error", e);
    L11:
        if (r110 != Integer.TYPE) goto L34;
        int r21 = (int) r10.scanLongValue();     // Catch: IllegalAccessException -> L15
        if (r16.fieldAccess == false) goto L17;
        r16.field.setInt(r11, r21);     // Catch: IllegalAccessException -> L15
    L18:
        char r22 = r10.ch;     // Catch: IllegalAccessException -> L15
        if (r22 != ',') goto L25;
        int r23 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r23;     // Catch: IllegalAccessException -> L15
        if (r23 < r10.len) goto L23;
        char r24 = JSONLexer.EOI;
    L24:
        r10.ch = r24;     // Catch: IllegalAccessException -> L15
        r10.token = 16;     // Catch: IllegalAccessException -> L15
    L183:
        r13 = r13 + 1;
        goto L4
    L23:
        r24 = r10.text.charAt(r23);     // Catch: IllegalAccessException -> L15
        goto L24
    L25:
        if (r22 != ']') goto L31;
        int r25 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r25;     // Catch: IllegalAccessException -> L15
        if (r25 < r10.len) goto L29;
        char r26 = JSONLexer.EOI;
    L30:
        r10.ch = r26;     // Catch: IllegalAccessException -> L15
        r10.token = 15;     // Catch: IllegalAccessException -> L15
        goto L183
    L29:
        r26 = r10.text.charAt(r25);     // Catch: IllegalAccessException -> L15
        goto L30
    L31:
        r10.nextToken();     // Catch: IllegalAccessException -> L15
        goto L183
    L17:
        r15.setValue(r11, new Integer(r21));     // Catch: IllegalAccessException -> L15
        goto L18
    L34:
        if (r110 != String.class) goto L68;
        char r27 = r10.ch;     // Catch: IllegalAccessException -> L15
        if (r27 != '\"') goto L39;
        String r28 = r10.scanStringValue(TokenParser.DQUOTE);     // Catch: IllegalAccessException -> L15
    L48:
        if (r16.fieldAccess == false) goto L50;
        r16.field.set(r11, r28);     // Catch: IllegalAccessException -> L15
    L51:
        char r29 = r10.ch;     // Catch: IllegalAccessException -> L15
        if (r29 != ',') goto L58;
        int r30 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r30;     // Catch: IllegalAccessException -> L15
        if (r30 < r10.len) goto L56;
        char r31 = JSONLexer.EOI;
    L57:
        r10.ch = r31;     // Catch: IllegalAccessException -> L15
        r10.token = 16;     // Catch: IllegalAccessException -> L15
        goto L183
    L56:
        r31 = r10.text.charAt(r30);     // Catch: IllegalAccessException -> L15
        goto L57
    L58:
        if (r29 != ']') goto L64;
        int r32 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r32;     // Catch: IllegalAccessException -> L15
        if (r32 < r10.len) goto L62;
        char r33 = JSONLexer.EOI;
    L63:
        r10.ch = r33;     // Catch: IllegalAccessException -> L15
        r10.token = 15;     // Catch: IllegalAccessException -> L15
        goto L183
    L62:
        r33 = r10.text.charAt(r32);     // Catch: IllegalAccessException -> L15
        goto L63
    L64:
        r10.nextToken();     // Catch: IllegalAccessException -> L15
        goto L183
    L50:
        r15.setValue(r11, r28);     // Catch: IllegalAccessException -> L15
        goto L51
    L39:
        if (r27 != 'n') goto L66;
        if (r10.text.startsWith("null", r10.bp) == false) goto L66;
        int r34 = r10.bp + 4;     // Catch: IllegalAccessException -> L15
        r10.bp = r34;     // Catch: IllegalAccessException -> L15
        if (r34 < r10.len) goto L45;
        char r35 = JSONLexer.EOI;
    L46:
        r10.ch = r35;     // Catch: IllegalAccessException -> L15
        r28 = null;
        goto L48
    L45:
        r35 = r10.text.charAt(r34);     // Catch: IllegalAccessException -> L15
    L66:
        throw new JSONException("not match string. feild : " + r19);     // Catch: IllegalAccessException -> L15
    L68:
        if (r110 != Long.TYPE) goto L88;
        long r36 = r10.scanLongValue();     // Catch: IllegalAccessException -> L15
        if (r16.fieldAccess == false) goto L72;
        r16.field.setLong(r11, r36);     // Catch: IllegalAccessException -> L15
    L73:
        char r37 = r10.ch;     // Catch: IllegalAccessException -> L15
        if (r37 != ',') goto L80;
        int r38 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r38;     // Catch: IllegalAccessException -> L15
        if (r38 < r10.len) goto L78;
        char r39 = JSONLexer.EOI;
    L79:
        r10.ch = r39;     // Catch: IllegalAccessException -> L15
        r10.token = 16;     // Catch: IllegalAccessException -> L15
        goto L183
    L78:
        r39 = r10.text.charAt(r38);     // Catch: IllegalAccessException -> L15
        goto L79
    L80:
        if (r37 != ']') goto L86;
        int r40 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r40;     // Catch: IllegalAccessException -> L15
        if (r40 < r10.len) goto L84;
        char r41 = JSONLexer.EOI;
    L85:
        r10.ch = r41;     // Catch: IllegalAccessException -> L15
        r10.token = 15;     // Catch: IllegalAccessException -> L15
        goto L183
    L84:
        r41 = r10.text.charAt(r40);     // Catch: IllegalAccessException -> L15
        goto L85
    L86:
        r10.nextToken();     // Catch: IllegalAccessException -> L15
        goto L183
    L72:
        r15.setValue(r11, new Long(r36));     // Catch: IllegalAccessException -> L15
        goto L73
    L88:
        if (r110 != Boolean.TYPE) goto L108;
        boolean r42 = r10.scanBoolean();     // Catch: IllegalAccessException -> L15
        if (r16.fieldAccess == false) goto L92;
        r16.field.setBoolean(r11, r42);     // Catch: IllegalAccessException -> L15
    L93:
        char r43 = r10.ch;     // Catch: IllegalAccessException -> L15
        if (r43 != ',') goto L100;
        int r44 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r44;     // Catch: IllegalAccessException -> L15
        if (r44 < r10.len) goto L98;
        char r45 = JSONLexer.EOI;
    L99:
        r10.ch = r45;     // Catch: IllegalAccessException -> L15
        r10.token = 16;     // Catch: IllegalAccessException -> L15
        goto L183
    L98:
        r45 = r10.text.charAt(r44);     // Catch: IllegalAccessException -> L15
        goto L99
    L100:
        if (r43 != ']') goto L106;
        int r46 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r46;     // Catch: IllegalAccessException -> L15
        if (r46 < r10.len) goto L104;
        char r47 = JSONLexer.EOI;
    L105:
        r10.ch = r47;     // Catch: IllegalAccessException -> L15
        r10.token = 15;     // Catch: IllegalAccessException -> L15
        goto L183
    L104:
        r47 = r10.text.charAt(r46);     // Catch: IllegalAccessException -> L15
        goto L105
    L106:
        r10.nextToken();     // Catch: IllegalAccessException -> L15
        goto L183
    L92:
        r15.setValue(r11, Boolean.valueOf(r42));     // Catch: IllegalAccessException -> L15
        goto L93
    L108:
        if (r110.isEnum() == false) goto L137;
        char r48 = r10.ch;     // Catch: IllegalAccessException -> L15
        if (r48 != '\"') goto L116;
        String r49 = r10.scanSymbol(r17.symbolTable);     // Catch: IllegalAccessException -> L15
        if (r49 != null) goto L114;
        Enum r50 = null;
    L120:
        r15.setValue(r11, r50);     // Catch: IllegalAccessException -> L15
        char r51 = r10.ch;     // Catch: IllegalAccessException -> L15
        if (r51 != ',') goto L127;
        int r52 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r52;     // Catch: IllegalAccessException -> L15
        if (r52 < r10.len) goto L125;
        char r53 = JSONLexer.EOI;
    L126:
        r10.ch = r53;     // Catch: IllegalAccessException -> L15
        r10.token = 16;     // Catch: IllegalAccessException -> L15
        goto L183
    L125:
        r53 = r10.text.charAt(r52);     // Catch: IllegalAccessException -> L15
        goto L126
    L127:
        if (r51 != ']') goto L133;
        int r54 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r54;     // Catch: IllegalAccessException -> L15
        if (r54 < r10.len) goto L131;
        char r55 = JSONLexer.EOI;
    L132:
        r10.ch = r55;     // Catch: IllegalAccessException -> L15
        r10.token = 15;     // Catch: IllegalAccessException -> L15
        goto L183
    L131:
        r55 = r10.text.charAt(r54);     // Catch: IllegalAccessException -> L15
        goto L132
    L133:
        r10.nextToken();     // Catch: IllegalAccessException -> L15
        goto L183
    L114:
        r50 = Enum.valueOf(r110, r49);     // Catch: IllegalAccessException -> L15
        goto L120
    L116:
        if (r48 < '0') goto L135;
        if (r48 > '9') goto L135;
        r50 = ((EnumDeserializer) ((DefaultFieldDeserializer) r15).getFieldValueDeserilizer(r17.config)).values[(int) r10.scanLongValue()];     // Catch: IllegalAccessException -> L15
    L135:
        throw new JSONException("illegal enum." + r10.info());     // Catch: IllegalAccessException -> L15
    L137:
        if (r110 == Date.class) goto L139;
    L154:
        char r56 = r10.ch;     // Catch: IllegalAccessException -> L15
        if (r56 != '[') goto L162;
        int r57 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r57;     // Catch: IllegalAccessException -> L15
        if (r57 < r10.len) goto L159;
        char r58 = JSONLexer.EOI;
    L160:
        r10.ch = r58;     // Catch: IllegalAccessException -> L15
        r10.token = 14;     // Catch: IllegalAccessException -> L15
    L169:
        r15.parseField(r17, r11, r16.fieldType, null);     // Catch: IllegalAccessException -> L15
        if (r14 == ']') goto L173;
        if (r14 != ',') goto L183;
        if (r10.token == 16) goto L183;
        throw new JSONException("syntax error");     // Catch: IllegalAccessException -> L15
    L173:
        if (r10.token == 15) goto L183;
        throw new JSONException("syntax error");     // Catch: IllegalAccessException -> L15
    L159:
        r58 = r10.text.charAt(r57);     // Catch: IllegalAccessException -> L15
        goto L160
    L162:
        if (r56 != '{') goto L168;
        int r59 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r59;     // Catch: IllegalAccessException -> L15
        if (r59 < r10.len) goto L166;
        char r60 = JSONLexer.EOI;
    L167:
        r10.ch = r60;     // Catch: IllegalAccessException -> L15
        r10.token = 12;     // Catch: IllegalAccessException -> L15
        goto L169
    L166:
        r60 = r10.text.charAt(r59);     // Catch: IllegalAccessException -> L15
        goto L167
    L168:
        r10.nextToken();     // Catch: IllegalAccessException -> L15
        goto L169
    L139:
        if (r10.ch != '1') goto L154;
        r15.setValue(r11, new Date(r10.scanLongValue()));     // Catch: IllegalAccessException -> L15
        char r61 = r10.ch;     // Catch: IllegalAccessException -> L15
        if (r61 != ',') goto L147;
        int r62 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r62;     // Catch: IllegalAccessException -> L15
        if (r62 < r10.len) goto L145;
        char r63 = JSONLexer.EOI;
    L146:
        r10.ch = r63;     // Catch: IllegalAccessException -> L15
        r10.token = 16;     // Catch: IllegalAccessException -> L15
        goto L183
    L145:
        r63 = r10.text.charAt(r62);     // Catch: IllegalAccessException -> L15
        goto L146
    L147:
        if (r61 != ']') goto L153;
        int r64 = r10.bp + 1;     // Catch: IllegalAccessException -> L15
        r10.bp = r64;     // Catch: IllegalAccessException -> L15
        if (r64 < r10.len) goto L151;
        char r65 = JSONLexer.EOI;
    L152:
        r10.ch = r65;     // Catch: IllegalAccessException -> L15
        r10.token = 15;     // Catch: IllegalAccessException -> L15
        goto L183
    L151:
        r65 = r10.text.charAt(r64);     // Catch: IllegalAccessException -> L15
        goto L152
    L153:
        r10.nextToken();     // Catch: IllegalAccessException -> L15
        goto L183
    L8:
        r14 = ',';
        goto L9
    L187:
        if (r10.ch != ',') goto L193;
        int r66 = r10.bp + 1;
        r10.bp = r66;
        if (r66 < r10.len) goto L191;
        char r67 = JSONLexer.EOI;
    L192:
        r10.ch = r67;
        r10.token = 16;
    L194:
        return r11;
    L191:
        r67 = r10.text.charAt(r66);
        goto L192
    L193:
        r10.nextToken();
        goto L194
    }

    private boolean parseField(DefaultJSONParser r17, String r18, Object r19, Type r20, Map<String, Object> r21) {
        JSONLexer r12 = r17.lexer;
        FieldDeserializer r10 = getFieldDeserializer(r18);
        if (r10 != null) goto L18;
        boolean r11 = r18.startsWith("is");
        FieldDeserializer[] r13 = this.sortedFieldDeserializers;
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L18;
        FieldDeserializer r16 = r13[r15];
        FieldInfo r22 = r16.fieldInfo;
        Class<?> r23 = r22.fieldClass;
        String r24 = r22.name;
        if (r24.equalsIgnoreCase(r18) == true) goto L16;
        if (r11 == false) goto L17;
        if (r23 == Boolean.TYPE) goto L15;
        if (r23 != Boolean.class) goto L17;
    L15:
        if (r24.equalsIgnoreCase(r18.substring(2)) == true) goto L16;
    L17:
        r15 = r15 + 1;
    L16:
        r10 = r16;
    L18:
        int r25 = Feature.SupportNonPublicField.mask;
        if (r10 == null) goto L21;
    L45:
        if (r10 != null) goto L48;
        parseExtra(r17, r19, r18);
        return false;
    L48:
        r12.nextTokenWithChar(':');
        r10.parseField(r17, r19, r20, r21);
        return true;
    L21:
        if ((r17.lexer.features & r25) != 0) goto L25;
        if ((r25 & this.beanInfo.parserFeatures) == 0) goto L45;
    L25:
        if (this.extraFieldDeserializers != null) goto L39;
        ConcurrentHashMap r26 = new ConcurrentHashMap(1, 0.75f, 1);
        Field[] r27 = this.clazz.getDeclaredFields();
        int r28 = r27.length;
        int r29 = 0;
    L27:
        if (r29 >= r28) goto L38;
        Field r30 = r27[r29];
        String r31 = r30.getName();
        if (getFieldDeserializer(r31) != null) goto L37;
        int r32 = r30.getModifiers();
        if ((r32 & 16) != 0) goto L37;
        if ((r32 & 8) != 0) goto L37;
        r26.put(r31, r30);
    L37:
        r29 = r29 + 1;
        goto L27
    L38:
        this.extraFieldDeserializers = r26;
    L39:
        Object r33 = this.extraFieldDeserializers.get(r18);
        if (r33 == null) goto L45;
        if ((r33 instanceof FieldDeserializer) == false) goto L44;
        r10 = (FieldDeserializer) r33;
        goto L45
    L44:
        Field r34 = (Field) r33;
        r34.setAccessible(true);
        r10 = new DefaultFieldDeserializer(r17.config, this.clazz, new FieldInfo(r18, r34.getDeclaringClass(), r34.getType(), r34.getGenericType(), r34, 0, 0));
        this.extraFieldDeserializers.put(r18, r10);
        goto L45
    }

    public Object createInstance(DefaultJSONParser r10, Type r11) {
        int r12 = 0;
        boolean r13 = false;
        if ((r11 instanceof Class) == true) goto L5;
    L11:
        JavaBeanInfo r14 = this.beanInfo;
        Constructor<?> r15 = r14.defaultConstructor;
        if (r15 != null) goto L32;
        return null;
    L32:
    L17:
        e = move-exception;
        throw new JSONException("create instance error, class " + this.clazz.getName(), e);
    L15:
        if (r14.defaultConstructorParameterSize != 0) goto L19;
        Object r16 = r15.newInstance(null);     // Catch: Exception -> L17
    L20:
        if (r10 != null) goto L22;
    L29:
        return r16;
    L22:
        if ((r10.lexer.features & Feature.InitStringFieldAsEmpty.mask) == 0) goto L29;
        FieldInfo[] r17 = this.beanInfo.fields;     // Catch: Exception -> L17
        int r18 = r17.length;     // Catch: Exception -> L17
    L24:
        if (r12 >= r18) goto L29;
        FieldInfo r19 = r17[r12];     // Catch: Exception -> L17
        if (r19.fieldClass != String.class) goto L28;
        r19.set(r16, "");     // Catch: Exception -> L17
    L28:
        r12 = r12 + 1;
        goto L24
    L19:
        r16 = r15.newInstance(new Object[]{r10.contex.object});     // Catch: Exception -> L17
        goto L20
    L5:
        if (this.clazz.isInterface() == false) goto L11;
        Class r20 = (Class) r11;
        ClassLoader r21 = Thread.currentThread().getContextClassLoader();
        if ((r10.lexer.features & Feature.OrderedField.mask) == 0) goto L10;
        r13 = true;
    L10:
        return Proxy.newProxyInstance(r21, new Class[]{r20}, new JSONObject(r13));
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        return (T) deserialze(r10, r11, r12, null);
    }

    public FieldDeserializer getFieldDeserializer(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = 0;
        if (this.beanInfo.ordered == false) goto L15;
    L7:
        FieldDeserializer[] r12 = this.sortedFieldDeserializers;
        if (r11 >= r12.length) goto L14;
        if (r12[r11].fieldInfo.name.equalsIgnoreCase(r10) == true) goto L12;
        r11 = r11 + 1;
        goto L7
    L12:
        return this.sortedFieldDeserializers[r11];
    L14:
        return null;
    L15:
        int r13 = this.sortedFieldDeserializers.length - 1;
    L16:
        if (r11 > r13) goto L24;
        int r14 = (r11 + r13) >>> 1;
        int r15 = this.sortedFieldDeserializers[r14].fieldInfo.name.compareTo(r10);
        if (r15 < 0) goto L19;
        if (r15 <= 0) goto L23;
        r13 = r14 - 1;
        goto L16
    L23:
        return this.sortedFieldDeserializers[r14];
    L19:
        r11 = r14 + 1;
        goto L16
    L24:
        return null;
    }

    public JavaBeanDeserializer getSeeAlso(ParserConfig r10, JavaBeanInfo r11, String r12) {
        JSONType r13 = r11.jsonType;
        if (r13 != null) goto L5;
        return null;
    L5:
        Class<?>[] r14 = r13.seeAlso();
        int r15 = r14.length;
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L16;
        ObjectDeserializer r17 = r10.getDeserializer(r14[r16]);
        if ((r17 instanceof JavaBeanDeserializer) == false) goto L15;
        JavaBeanDeserializer r18 = (JavaBeanDeserializer) r17;
        JavaBeanInfo r19 = r18.beanInfo;
        if (r19.typeName.equals(r12) == true) goto L11;
        JavaBeanDeserializer r20 = getSeeAlso(r10, r19, r12);
        if (r20 == null) goto L15;
        return r20;
    L11:
        return r18;
    L15:
        r16 = r16 + 1;
        goto L6
    L16:
        return null;
    }

    public void parseExtra(DefaultJSONParser r10, Object r11, String r12) {
        JSONLexer r13 = r10.lexer;
        if ((r13.features & Feature.IgnoreNotMatch.mask) == 0) goto L25;
        r13.nextTokenWithChar(':');
        List<ExtraTypeProvider> r14 = r10.extraTypeProviders;
        Type r15 = null;
        if (r14 == null) goto L10;
        Iterator<ExtraTypeProvider> r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        r15 = r16.next().getExtraType(r11, r12);
    L10:
        if (r15 != null) goto L12;
        Object r17 = r10.parse();
    L14:
        if ((r11 instanceof ExtraProcessable) == false) goto L17;
        ((ExtraProcessable) r11).processExtra(r12, r17);
        return;
    L17:
        List<ExtraProcessor> r18 = r10.extraProcessors;
        if (r18 == null) goto L23;
        Iterator<ExtraProcessor> r19 = r18.iterator();
    L21:
        if (r19.hasNext() == false) goto L28;
        r19.next().processExtra(r11, r12, r17);
        goto L21
    L28:
        return;
    L23:
        return;
    L12:
        r17 = r10.parseObject(r15);
        goto L14
    L25:
        throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + r12);
    }

    public JavaBeanDeserializer(ParserConfig r10, Class<?> r11, Type r12, JavaBeanInfo r13) {
        this.clazz = r11;
        this.beanInfo = r13;
        FieldInfo[] r14 = r13.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[r14.length];
        int r15 = r14.length;
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r17 >= r15) goto L5;
        this.sortedFieldDeserializers[r17] = r10.createFieldDeserializer(r10, r11, r13.sortedFields[r17]);
        r17 = r17 + 1;
        goto L3
    L5:
        FieldInfo[] r18 = r13.fields;
        this.fieldDeserializers = new FieldDeserializer[r18.length];
        int r19 = r18.length;
    L6:
        if (r16 >= r19) goto L8;
        this.fieldDeserializers[r16] = getFieldDeserializer(r13.fields[r16].name);
        r16 = r16 + 1;
        goto L6
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16621. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r33, java.lang.reflect.Type r34, java.lang.Object r35, java.lang.Object r36) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: MOVE (r0v0 ?? I:??[OBJECT, ARRAY]) = (r34v0 ?? I:??[OBJECT, ARRAY]) A[DECLARE_VAR] in method: com.alibaba.fastjson.parser.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):T, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public Object createInstance(Map<String, Object> r10, ParserConfig r11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        JavaBeanInfo r12 = this.beanInfo;
        int r13 = 0;
        if (r12.creatorConstructor != null) goto L15;
        Object r14 = createInstance(null, this.clazz);
        Iterator<Map.Entry<String, Object>> r15 = r10.entrySet().iterator();
    L6:
        if (r15.hasNext() == false) goto L14;
        Map.Entry<String, Object> r16 = r15.next();
        FieldDeserializer r17 = getFieldDeserializer(r16.getKey());
        if (r17 == null) goto L6;
        Object r18 = r16.getValue();
        FieldInfo r19 = r17.fieldInfo;
        Method r20 = r19.method;
        if (r20 != null) goto L12;
        r19.field.set(r14, TypeUtils.cast(r18, r19.fieldType, r11));
        goto L6
    L12:
        r20.invoke(r14, new Object[]{TypeUtils.cast(r18, r20.getGenericParameterTypes()[0], r11)});
        goto L6
    L14:
        return r14;
    L15:
        FieldInfo[] r21 = r12.fields;
        int r22 = r21.length;
        Object[] r23 = new Object[r22];
    L16:
        if (r13 >= r22) goto L18;
        r23[r13] = r10.get(r21[r13].name);
        r13 = r13 + 1;
        goto L16
    L18:
        Constructor<?> r24 = this.beanInfo.creatorConstructor;
        if (r24 != null) goto L26;
        return null;
    L26:
        return r24.newInstance(r23);
    L22:
        e = move-exception;
        throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e);
    }
}
