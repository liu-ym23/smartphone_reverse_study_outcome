package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.stepos.alphame.utils.Property;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] hashArray;
    private transient short[] hashArrayMapping;
    private transient long[] smartMatchHashArray;
    private transient short[] smartMatchHashArrayMapping;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    public static boolean isSetFlag(int i4, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i5 = i4 / 32;
        int i6 = i4 % 32;
        if (i5 < iArr.length) {
            if (((1 << i6) & iArr[i5]) != 0) {
                return true;
            }
        }
        return false;
    }

    public static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i4 = jSONLexerBase.token();
        if (i4 == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i4 != 14) {
            defaultJSONParser.throwException(i4);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i5 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i5)));
            i5++;
            if (jSONLexerBase.token() != 16) {
                break;
            }
            if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i6 = jSONLexerBase.token();
        if (i6 != 15) {
            defaultJSONParser.throwException(i6);
        }
        if (jSONLexerBase.getCurrent() != ',') {
            jSONLexerBase.nextToken(16);
        } else {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
        }
    }

    public void check(JSONLexer jSONLexer, int i4) {
        if (jSONLexer.token() != i4) {
            throw new JSONException("syntax error");
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo.defaultConstructor;
        Object obj = null;
        if (constructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        Method method = javaBeanInfo.factoryMethod;
        if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            if (javaBeanInfo.defaultConstructorParameterSize == 0) {
                objNewInstance = constructor != null ? constructor.newInstance(new Object[0]) : method.invoke(null, new Object[0]);
            } else {
                ParseContext context = defaultJSONParser.getContext();
                if (context == null || context.object == null) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                if (!(type instanceof Class)) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                String name = ((Class) type).getName();
                String strSubstring = name.substring(0, name.lastIndexOf(36));
                Object obj2 = context.object;
                String name2 = obj2.getClass().getName();
                if (!name2.equals(strSubstring)) {
                    ParseContext parseContext = context.parent;
                    if (parseContext != null && parseContext.object != null && (("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2)) && parseContext.object.getClass().getName().equals(strSubstring))) {
                        obj = parseContext.object;
                    }
                    obj2 = obj;
                }
                if (obj2 == null) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                objNewInstance = constructor.newInstance(obj2);
            }
            if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                for (FieldInfo fieldInfo : this.beanInfo.fields) {
                    if (fieldInfo.fieldClass == String.class) {
                        try {
                            fieldInfo.set(objNewInstance, "");
                        } catch (Exception e4) {
                            throw new JSONException("create instance error, class ".concat(this.clazz.getName()), e4);
                        }
                    }
                }
            }
            return objNewInstance;
        } catch (JSONException e5) {
            throw e5;
        } catch (Exception e6) {
            throw new JSONException("create instance error, class ".concat(this.clazz.getName()), e6);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() != 14) {
            throw new JSONException("error");
        }
        T t4 = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            char c4 = i4 == length + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i4];
            Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
            if (cls == Integer.TYPE) {
                fieldDeserializer.setValue((Object) t4, jSONLexer.scanInt(c4));
            } else if (cls == String.class) {
                fieldDeserializer.setValue((Object) t4, jSONLexer.scanString(c4));
            } else if (cls == Long.TYPE) {
                fieldDeserializer.setValue(t4, jSONLexer.scanLong(c4));
            } else if (cls.isEnum()) {
                char current = jSONLexer.getCurrent();
                fieldDeserializer.setValue(t4, (current == '\"' || current == 'n') ? jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c4) : (current < '0' || current > '9') ? scanEnum(jSONLexer, c4) : ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c4)));
            } else if (cls == Boolean.TYPE) {
                fieldDeserializer.setValue(t4, jSONLexer.scanBoolean(c4));
            } else if (cls == Float.TYPE) {
                fieldDeserializer.setValue(t4, Float.valueOf(jSONLexer.scanFloat(c4)));
            } else if (cls == Double.TYPE) {
                fieldDeserializer.setValue(t4, Double.valueOf(jSONLexer.scanDouble(c4)));
            } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                fieldDeserializer.setValue(t4, new Date(jSONLexer.scanLong(c4)));
            } else if (cls == BigDecimal.class) {
                fieldDeserializer.setValue(t4, jSONLexer.scanDecimal(c4));
            } else {
                jSONLexer.nextToken(14);
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                fieldDeserializer.setValue(t4, defaultJSONParser.parseObject(fieldInfo.fieldType, fieldInfo.name));
                if (jSONLexer.token() == 15) {
                    break;
                }
                check(jSONLexer, c4 == ']' ? 15 : 16);
            }
            i4++;
        }
        jSONLexer.nextToken(16);
        return t4;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public Type getFieldType(int i4) {
        return this.sortedFieldDeserializers[i4].fieldInfo.fieldType;
    }

    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i4) {
        return parseRest(defaultJSONParser, type, obj, obj2, i4, new int[0]);
    }

    public Enum<?> scanEnum(JSONLexer jSONLexer, char c4) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i4) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i4, null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        if (str == null) {
            return null;
        }
        int length = this.sortedFieldDeserializers.length - 1;
        int i4 = 0;
        while (i4 <= length) {
            int i5 = (i4 + length) >>> 1;
            int iCompareTo = this.sortedFieldDeserializers[i5].fieldInfo.name.compareTo(str);
            if (iCompareTo < 0) {
                i4 = i5 + 1;
            } else {
                if (iCompareTo <= 0) {
                    if (isSetFlag(i5, iArr)) {
                        return null;
                    }
                    return this.sortedFieldDeserializers[i5];
                }
                length = i5 - 1;
            }
        }
        Map<String, FieldDeserializer> map = this.alterNameFieldDeserializers;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0088 A[PHI: r2
      0x0088: PHI (r2v4 com.alibaba.fastjson.parser.deserializer.FieldDeserializer) = 
      (r2v3 com.alibaba.fastjson.parser.deserializer.FieldDeserializer)
      (r2v3 com.alibaba.fastjson.parser.deserializer.FieldDeserializer)
      (r2v15 com.alibaba.fastjson.parser.deserializer.FieldDeserializer)
      (r2v3 com.alibaba.fastjson.parser.deserializer.FieldDeserializer)
     binds: [B:10:0x0032, B:31:0x007f, B:34:0x0085, B:14:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean parseField(com.alibaba.fastjson.parser.DefaultJSONParser r22, java.lang.String r23, java.lang.Object r24, java.lang.reflect.Type r25, java.util.Map<java.lang.String, java.lang.Object> r26, int[] r27) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseField(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i4, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i4, iArr);
    }

    public Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long jScanFieldSymbol = jSONLexerBase.scanFieldSymbol(cArr);
        if (jSONLexerBase.matchStat > 0) {
            return enumDeserializer.getEnumByHashCode(jScanFieldSymbol);
        }
        return null;
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        if (fieldDeserializer == null) {
            long jFnv1a_64_lower = TypeUtils.fnv1a_64_lower(str);
            int i4 = 0;
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i5 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i5 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i5] = TypeUtils.fnv1a_64_lower(fieldDeserializerArr[i5].fieldInfo.name);
                    i5++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int iBinarySearch = Arrays.binarySearch(this.smartMatchHashArray, jFnv1a_64_lower);
            if (iBinarySearch < 0 && str.startsWith("is")) {
                iBinarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str.substring(2)));
            }
            if (iBinarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i4 >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int iBinarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(fieldDeserializerArr2[i4].fieldInfo.name));
                        if (iBinarySearch2 >= 0) {
                            sArr[iBinarySearch2] = (short) i4;
                        }
                        i4++;
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s4 = this.smartMatchHashArrayMapping[iBinarySearch];
                if (s4 != -1 && !isSetFlag(s4, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s4];
                }
            }
            if (fieldDeserializer != null && (fieldDeserializer.fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                return null;
            }
        }
        return fieldDeserializer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:297:0x03e9, code lost:
    
        r13 = r1;
        r0 = r16;
        r24 = r19;
        r30 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x04ea, code lost:
    
        r5 = r16;
        r0 = r0;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x04ec, code lost:
    
        if (r13 != null) goto L466;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x04ee, code lost:
    
        if (r0 != null) goto L370;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x04f0, code lost:
    
        r1 = (T) createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r26, r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x04f4, code lost:
    
        if (r5 != null) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x04f6, code lost:
    
        r5 = r26.setContext(r15, r1, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x04fa, code lost:
    
        if (r5 == null) goto L366;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x04fc, code lost:
    
        r5.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x04fe, code lost:
    
        r26.setContext(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x0501, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0502, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0503, code lost:
    
        r14 = r5;
        r1 = (T) r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0507, code lost:
    
        r1 = r25.beanInfo;
        r2 = r1.creatorConstructorParameters;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x050f, code lost:
    
        if (r2 == null) goto L406;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x0511, code lost:
    
        r1 = new java.lang.Object[r2.length];
        r12 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0517, code lost:
    
        if (r12 >= r2.length) goto L530;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0519, code lost:
    
        r14 = r0.remove(r2[r12]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x051f, code lost:
    
        if (r14 != null) goto L381;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0521, code lost:
    
        r6 = r25.beanInfo;
        r7 = r6.creatorConstructorParameterTypes[r12];
        r6 = r6.fields[r12];
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x052d, code lost:
    
        if (r7 != java.lang.Byte.TYPE) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x052f, code lost:
    
        r14 = java.lang.Byte.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0533, code lost:
    
        r4 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0538, code lost:
    
        if (r7 != java.lang.Short.TYPE) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x053a, code lost:
    
        r14 = java.lang.Short.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0541, code lost:
    
        if (r7 != java.lang.Integer.TYPE) goto L388;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x0543, code lost:
    
        r14 = java.lang.Integer.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x054a, code lost:
    
        if (r7 != java.lang.Long.TYPE) goto L391;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x054c, code lost:
    
        r14 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0553, code lost:
    
        if (r7 != java.lang.Float.TYPE) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0555, code lost:
    
        r14 = java.lang.Float.valueOf(com.stepos.alphame.utils.Property.DEFAULT_FLOAT_VALUE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x055d, code lost:
    
        if (r7 != java.lang.Double.TYPE) goto L397;
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x055f, code lost:
    
        r14 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0568, code lost:
    
        if (r7 != java.lang.Boolean.TYPE) goto L400;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x056a, code lost:
    
        r14 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x056d, code lost:
    
        r4 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x056f, code lost:
    
        if (r7 != r4) goto L533;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0578, code lost:
    
        if ((r6.parserFeatures & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L534;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x057a, code lost:
    
        r14 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x057b, code lost:
    
        r1[r12] = r14;
        r12 = r12 + 1;
        r24 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x0582, code lost:
    
        r4 = r24;
        r1 = r1.fields;
        r6 = r1.length;
        r7 = new java.lang.Object[r6];
        r12 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x058b, code lost:
    
        if (r12 >= r6) goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x058d, code lost:
    
        r14 = r1[r12];
        r10 = r0.get(r14.name);
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0595, code lost:
    
        if (r10 != null) goto L437;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0597, code lost:
    
        r11 = r14.fieldType;
        r16 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x059d, code lost:
    
        if (r11 != java.lang.Byte.TYPE) goto L415;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x059f, code lost:
    
        r10 = java.lang.Byte.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x05a3, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x05aa, code lost:
    
        if (r11 != java.lang.Short.TYPE) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x05ac, code lost:
    
        r10 = java.lang.Short.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x05b3, code lost:
    
        if (r11 != java.lang.Integer.TYPE) goto L421;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x05b5, code lost:
    
        r10 = java.lang.Integer.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x05bc, code lost:
    
        if (r11 != java.lang.Long.TYPE) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x05be, code lost:
    
        r17 = 0;
        r10 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x05c5, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x05c9, code lost:
    
        if (r11 != java.lang.Float.TYPE) goto L427;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x05cb, code lost:
    
        r10 = java.lang.Float.valueOf(com.stepos.alphame.utils.Property.DEFAULT_FLOAT_VALUE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x05d3, code lost:
    
        if (r11 != java.lang.Double.TYPE) goto L430;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x05d5, code lost:
    
        r10 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x05e0, code lost:
    
        if (r11 != java.lang.Boolean.TYPE) goto L433;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x05e2, code lost:
    
        r10 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x05e5, code lost:
    
        if (r11 != r4) goto L544;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x05ee, code lost:
    
        if ((r14.parserFeatures & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x05f0, code lost:
    
        r10 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x05f2, code lost:
    
        r16 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x05f5, code lost:
    
        r7[r12] = r10;
        r12 = r12 + 1;
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x05fe, code lost:
    
        r1 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x05ff, code lost:
    
        r3 = r25.beanInfo;
        r4 = r3.creatorConstructor;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x0603, code lost:
    
        if (r4 == null) goto L456;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x0605, code lost:
    
        r1 = r4.newInstance(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x0609, code lost:
    
        if (r2 == null) goto L451;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x060b, code lost:
    
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x0617, code lost:
    
        if (r0.hasNext() == false) goto L536;
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x0619, code lost:
    
        r2 = r0.next();
        r3 = getFieldDeserializer(r2.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x0629, code lost:
    
        if (r3 == null) goto L538;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x062b, code lost:
    
        r3.setValue(r1, r2.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x0633, code lost:
    
        r13 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:452:0x0635, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x0655, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r25.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x0656, code lost:
    
        r0 = r3.factoryMethod;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:457:0x0658, code lost:
    
        if (r0 == null) goto L465;
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x065f, code lost:
    
        r13 = r0.invoke(null, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x0661, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x0681, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r25.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:465:0x0682, code lost:
    
        r5.object = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x0684, code lost:
    
        r0 = r25.beanInfo.buildMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x0688, code lost:
    
        if (r0 != null) goto L472;
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x068a, code lost:
    
        if (r5 == null) goto L470;
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x068c, code lost:
    
        r5.object = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:470:0x068e, code lost:
    
        r26.setContext(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x0691, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x0694, code lost:
    
        r0 = (T) r0.invoke(r13, new java.lang.Object[r30]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:474:0x069a, code lost:
    
        if (r5 == null) goto L476;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x069c, code lost:
    
        r5.object = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x069e, code lost:
    
        r26.setContext(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x06a1, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x06a2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x06aa, code lost:
    
        throw new com.alibaba.fastjson.JSONException("build object error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x015e, code lost:
    
        if (r3 == (-2)) goto L99;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0297 A[Catch: all -> 0x0128, TryCatch #5 {all -> 0x0128, blocks: (B:75:0x0118, B:77:0x011d, B:84:0x0137, B:89:0x0146, B:95:0x0152, B:215:0x0297, B:217:0x02a1, B:219:0x02ad, B:363:0x04f6, B:444:0x060b, B:445:0x0613, B:447:0x0619, B:449:0x062b, B:222:0x02b8, B:229:0x02cc, B:231:0x02d6, B:233:0x02e2, B:255:0x0338, B:257:0x0341, B:262:0x0351, B:263:0x0358, B:235:0x02e8, B:237:0x02f0, B:240:0x02f8, B:241:0x0304, B:244:0x030d, B:247:0x0313, B:250:0x0318, B:251:0x0324, B:254:0x032c, B:264:0x0359, B:265:0x0373, B:267:0x0376, B:274:0x0384, B:276:0x038d, B:278:0x03a0, B:281:0x03a9, B:283:0x03b1, B:285:0x03c3, B:287:0x03cb, B:289:0x03cf, B:294:0x03de, B:296:0x03e6, B:299:0x03fe, B:300:0x0405, B:271:0x037f, B:305:0x0416, B:307:0x041c, B:308:0x0426, B:310:0x042c, B:104:0x016c, B:106:0x0170, B:113:0x0180, B:120:0x0190, B:125:0x019c, B:130:0x01a6, B:135:0x01b0, B:140:0x01ba, B:142:0x01c0, B:145:0x01ce, B:147:0x01d6, B:149:0x01da, B:157:0x01f2, B:165:0x0205, B:173:0x0218, B:179:0x0227, B:182:0x0231, B:188:0x0244, B:194:0x0257, B:200:0x026a, B:206:0x027d), top: B:508:0x0118 }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0414 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x041c A[Catch: all -> 0x0128, TryCatch #5 {all -> 0x0128, blocks: (B:75:0x0118, B:77:0x011d, B:84:0x0137, B:89:0x0146, B:95:0x0152, B:215:0x0297, B:217:0x02a1, B:219:0x02ad, B:363:0x04f6, B:444:0x060b, B:445:0x0613, B:447:0x0619, B:449:0x062b, B:222:0x02b8, B:229:0x02cc, B:231:0x02d6, B:233:0x02e2, B:255:0x0338, B:257:0x0341, B:262:0x0351, B:263:0x0358, B:235:0x02e8, B:237:0x02f0, B:240:0x02f8, B:241:0x0304, B:244:0x030d, B:247:0x0313, B:250:0x0318, B:251:0x0324, B:254:0x032c, B:264:0x0359, B:265:0x0373, B:267:0x0376, B:274:0x0384, B:276:0x038d, B:278:0x03a0, B:281:0x03a9, B:283:0x03b1, B:285:0x03c3, B:287:0x03cb, B:289:0x03cf, B:294:0x03de, B:296:0x03e6, B:299:0x03fe, B:300:0x0405, B:271:0x037f, B:305:0x0416, B:307:0x041c, B:308:0x0426, B:310:0x042c, B:104:0x016c, B:106:0x0170, B:113:0x0180, B:120:0x0190, B:125:0x019c, B:130:0x01a6, B:135:0x01b0, B:140:0x01ba, B:142:0x01c0, B:145:0x01ce, B:147:0x01d6, B:149:0x01da, B:157:0x01f2, B:165:0x0205, B:173:0x0218, B:179:0x0227, B:182:0x0231, B:188:0x0244, B:194:0x0257, B:200:0x026a, B:206:0x027d), top: B:508:0x0118 }] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x042c A[Catch: all -> 0x0128, TRY_LEAVE, TryCatch #5 {all -> 0x0128, blocks: (B:75:0x0118, B:77:0x011d, B:84:0x0137, B:89:0x0146, B:95:0x0152, B:215:0x0297, B:217:0x02a1, B:219:0x02ad, B:363:0x04f6, B:444:0x060b, B:445:0x0613, B:447:0x0619, B:449:0x062b, B:222:0x02b8, B:229:0x02cc, B:231:0x02d6, B:233:0x02e2, B:255:0x0338, B:257:0x0341, B:262:0x0351, B:263:0x0358, B:235:0x02e8, B:237:0x02f0, B:240:0x02f8, B:241:0x0304, B:244:0x030d, B:247:0x0313, B:250:0x0318, B:251:0x0324, B:254:0x032c, B:264:0x0359, B:265:0x0373, B:267:0x0376, B:274:0x0384, B:276:0x038d, B:278:0x03a0, B:281:0x03a9, B:283:0x03b1, B:285:0x03c3, B:287:0x03cb, B:289:0x03cf, B:294:0x03de, B:296:0x03e6, B:299:0x03fe, B:300:0x0405, B:271:0x037f, B:305:0x0416, B:307:0x041c, B:308:0x0426, B:310:0x042c, B:104:0x016c, B:106:0x0170, B:113:0x0180, B:120:0x0190, B:125:0x019c, B:130:0x01a6, B:135:0x01b0, B:140:0x01ba, B:142:0x01c0, B:145:0x01ce, B:147:0x01d6, B:149:0x01da, B:157:0x01f2, B:165:0x0205, B:173:0x0218, B:179:0x0227, B:182:0x0231, B:188:0x0244, B:194:0x0257, B:200:0x026a, B:206:0x027d), top: B:508:0x0118 }] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x049e A[Catch: all -> 0x0451, TryCatch #0 {all -> 0x0451, blocks: (B:487:0x06c1, B:316:0x0442, B:352:0x04d6, B:355:0x04e1, B:357:0x04e7, B:482:0x06ae, B:484:0x06b6, B:488:0x06d0, B:489:0x06ee, B:322:0x045b, B:338:0x0486, B:340:0x0494, B:325:0x0467, B:327:0x046d, B:329:0x0471, B:331:0x0475, B:333:0x0479, B:335:0x047d, B:336:0x0481, B:343:0x049e, B:345:0x04bd, B:347:0x04c3, B:350:0x04ce, B:490:0x06ef, B:491:0x06f6), top: B:501:0x06c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x04e1 A[Catch: all -> 0x0451, TryCatch #0 {all -> 0x0451, blocks: (B:487:0x06c1, B:316:0x0442, B:352:0x04d6, B:355:0x04e1, B:357:0x04e7, B:482:0x06ae, B:484:0x06b6, B:488:0x06d0, B:489:0x06ee, B:322:0x045b, B:338:0x0486, B:340:0x0494, B:325:0x0467, B:327:0x046d, B:329:0x0471, B:331:0x0475, B:333:0x0479, B:335:0x047d, B:336:0x0481, B:343:0x049e, B:345:0x04bd, B:347:0x04c3, B:350:0x04ce, B:490:0x06ef, B:491:0x06f6), top: B:501:0x06c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:495:0x06fd  */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r26, java.lang.reflect.Type r27, java.lang.Object r28, java.lang.Object r29, int r30, int[] r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap map = null;
        for (int i4 = 0; i4 < length; i4++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i4];
            FieldDeserializer fieldDeserializerCreateFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i4] = fieldDeserializerCreateFieldDeserializer;
            for (String str : fieldInfo.alternateNames) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(str, fieldDeserializerCreateFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = map;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i5 = 0; i5 < length2; i5++) {
            this.fieldDeserializers[i5] = getFieldDeserializer(javaBeanInfo.fields[i5].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(long j4) {
        int i4 = 0;
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i5 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i5 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i5] = TypeUtils.fnv1a_64(fieldDeserializerArr[i5].fieldInfo.name);
                i5++;
            }
            Arrays.sort(jArr);
            this.hashArray = jArr;
        }
        int iBinarySearch = Arrays.binarySearch(this.hashArray, j4);
        if (iBinarySearch < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i4 >= fieldDeserializerArr2.length) {
                    break;
                }
                int iBinarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i4].fieldInfo.name));
                if (iBinarySearch2 >= 0) {
                    sArr[iBinarySearch2] = (short) i4;
                }
                i4++;
            }
            this.hashArrayMapping = sArr;
        }
        short s4 = this.hashArrayMapping[iBinarySearch];
        if (s4 != -1) {
            return this.sortedFieldDeserializers[s4];
        }
        return null;
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor == null && javaBeanInfo.factoryMethod == null) {
            Object objCreateInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                FieldDeserializer fieldDeserializerSmartMatch = smartMatch(key);
                if (fieldDeserializerSmartMatch != null) {
                    fieldDeserializerSmartMatch.setValue(objCreateInstance, TypeUtils.cast(value, fieldDeserializerSmartMatch.fieldInfo.fieldType, parserConfig));
                }
            }
            Method method = this.beanInfo.buildMethod;
            if (method == null) {
                return objCreateInstance;
            }
            try {
                return method.invoke(objCreateInstance, new Object[0]);
            } catch (Exception e4) {
                throw new JSONException("build object error", e4);
            }
        }
        FieldInfo[] fieldInfoArr = javaBeanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i4 = 0; i4 < length; i4++) {
            FieldInfo fieldInfo = fieldInfoArr[i4];
            Object objValueOf = map.get(fieldInfo.name);
            if (objValueOf == null) {
                Class<?> cls = fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    objValueOf = 0;
                } else if (cls == Long.TYPE) {
                    objValueOf = 0L;
                } else if (cls == Short.TYPE) {
                    objValueOf = (short) 0;
                } else if (cls == Byte.TYPE) {
                    objValueOf = (byte) 0;
                } else if (cls == Float.TYPE) {
                    objValueOf = Float.valueOf(Property.DEFAULT_FLOAT_VALUE);
                } else if (cls == Double.TYPE) {
                    objValueOf = Double.valueOf(0.0d);
                } else if (cls == Character.TYPE) {
                    objValueOf = '0';
                } else if (cls == Boolean.TYPE) {
                    objValueOf = Boolean.FALSE;
                }
            }
            objArr[i4] = objValueOf;
        }
        JavaBeanInfo javaBeanInfo2 = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo2.creatorConstructor;
        if (constructor != null) {
            try {
                return constructor.newInstance(objArr);
            } catch (Exception e5) {
                throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e5);
            }
        }
        Method method2 = javaBeanInfo2.factoryMethod;
        if (method2 == null) {
            return null;
        }
        try {
            return method2.invoke(null, objArr);
        } catch (Exception e6) {
            throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e6);
        }
    }
}
