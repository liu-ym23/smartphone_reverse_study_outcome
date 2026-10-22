package com.alibaba.fastjson.parser;

import B0.g;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    protected transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    static {
        Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i4 = 0; i4 < 17; i4++) {
            primitiveClasses.add(clsArr[i4]);
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    private void addContext(ParseContext parseContext) {
        int i4 = this.contextArrayIndex;
        this.contextArrayIndex = i4 + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i4 >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i4] = parseContext;
    }

    public final void accept(int i4) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i4) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i4) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        }
        if (!str.equals(jSONLexer.stringVal())) {
            throw new JSONException("type not match error");
        }
        jSONLexer.nextToken();
        if (jSONLexer.token() == 16) {
            jSONLexer.nextToken();
        }
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (!(collection instanceof List)) {
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(collection);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            int size = collection.size() - 1;
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, size);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
            }
        } finally {
            jSONLexer.close();
        }
    }

    public void config(Feature feature, boolean z4) {
        this.lexer.config(feature, z4);
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public ParseContext getContext() {
        return this.context;
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public String getInput() {
        Object obj = this.input;
        return obj instanceof char[] ? new String((char[]) obj) : obj.toString();
    }

    public ResolveTask getLastResolveTask() {
        return (ResolveTask) g.h(this.resolveTaskList, 1);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public Object getObject(String str) {
        for (int i4 = 0; i4 < this.contextArrayIndex; i4++) {
            if (str.equals(this.contextArray[i4].toString())) {
                return this.contextArray[i4].object;
            }
        }
        return null;
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void handleResovleTask(Object obj) {
        Object objEval;
        FieldInfo fieldInfo;
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i4);
            String str = resolveTask.referenceValue;
            ParseContext parseContext = resolveTask.ownerContext;
            Object obj2 = parseContext != null ? parseContext.object : null;
            if (str.startsWith("$")) {
                objEval = getObject(str);
                if (objEval == null) {
                    try {
                        objEval = JSONPath.eval(obj, str);
                    } catch (JSONPathException unused) {
                    }
                }
            } else {
                objEval = resolveTask.context.object;
            }
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                if (objEval != null && objEval.getClass() == JSONObject.class && (fieldInfo = fieldDeserializer.fieldInfo) != null && !Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    objEval = JSONPath.eval(this.contextArray[0].object, str);
                }
                fieldDeserializer.setValue(obj2, objEval);
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new JSONException("not support type " + type);
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class<?>) type2, (Collection) arrayList);
            return arrayList;
        }
        if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type type3 = wildcardType.getUpperBounds()[0];
            if (!Object.class.equals(type3)) {
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class<?>) type3, (Collection) arrayList2);
                return arrayList2;
            }
            if (wildcardType.getLowerBounds().length == 0) {
                return parse();
            }
            throw new JSONException("not support type : " + type);
        }
        if (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 1) {
                throw new JSONException("not support : " + typeVariable);
            }
            Type type4 = bounds[0];
            if (type4 instanceof Class) {
                ArrayList arrayList3 = new ArrayList();
                parseArray((Class<?>) type4, (Collection) arrayList3);
                return arrayList3;
            }
        }
        if (type2 instanceof ParameterizedType) {
            ArrayList arrayList4 = new ArrayList();
            parseArray((ParameterizedType) type2, arrayList4);
            return arrayList4;
        }
        throw new JSONException("TODO : " + type);
    }

    public void parseExtra(Object obj, String str) {
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type extraType = null;
        if (list != null) {
            Iterator<ExtraTypeProvider> it = list.iterator();
            while (it.hasNext()) {
                extraType = it.next().getExtraType(obj, str);
            }
        }
        Object object = extraType == null ? parse() : parseObject(extraType);
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, object);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            Iterator<ExtraProcessor> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().processExtra(obj, str, object);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    public Object parseKey() {
        if (this.lexer.token() != 18) {
            return parse(null);
        }
        String strStringVal = this.lexer.stringVal();
        this.lexer.nextToken(16);
        return strStringVal;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0219, code lost:
    
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0224, code lost:
    
        if (r4.token() != 13) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0226, code lost:
    
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0229, code lost:
    
        r0 = r16.config.getDeserializer(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0231, code lost:
    
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0233, code lost:
    
        r0 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0;
        r2 = r0.createInstance(r16, r7);
        r3 = r8.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0245, code lost:
    
        if (r3.hasNext() == false) goto L355;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0247, code lost:
    
        r4 = (java.util.Map.Entry) r3.next();
        r8 = r4.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0253, code lost:
    
        if ((r8 instanceof java.lang.String) == false) goto L359;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0255, code lost:
    
        r8 = r0.getFieldDeserializer((java.lang.String) r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x025b, code lost:
    
        if (r8 == null) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x025d, code lost:
    
        r8.setValue(r2, r4.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0265, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0267, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0268, code lost:
    
        if (r2 != null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x026c, code lost:
    
        if (r7 != java.lang.Cloneable.class) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x026e, code lost:
    
        r2 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x027a, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x027c, code lost:
    
        r2 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0281, code lost:
    
        r2 = r7.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0285, code lost:
    
        setContext(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0288, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0290, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0291, code lost:
    
        setResolveStatus(2);
        r3 = r16.context;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0297, code lost:
    
        if (r3 == null) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0299, code lost:
    
        if (r18 == null) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x029d, code lost:
    
        if ((r18 instanceof java.lang.Integer) != false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02a3, code lost:
    
        if ((r3.fieldName instanceof java.lang.Integer) != false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02a5, code lost:
    
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02ac, code lost:
    
        if (r17.size() <= 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02ae, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r17, (java.lang.Class<java.lang.Object>) r7, r16.config);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02b7, code lost:
    
        setContext(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02ba, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02bb, code lost:
    
        r0 = r16.config.getDeserializer(r7).deserialze(r16, r7, r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02c5, code lost:
    
        setContext(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02c8, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e3 A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:18:0x005a, B:20:0x005e, B:25:0x006b, B:28:0x007e, B:32:0x0098, B:103:0x01e3, B:104:0x01e9, B:106:0x01f4, B:108:0x01fc, B:110:0x020d, B:111:0x0219, B:113:0x0226, B:114:0x0229, B:116:0x0233, B:117:0x0241, B:119:0x0247, B:121:0x0255, B:123:0x025d, B:130:0x026e, B:131:0x0274, B:133:0x027c, B:134:0x0281, B:137:0x0289, B:138:0x0290, B:139:0x0291, B:142:0x029b, B:144:0x029f, B:146:0x02a5, B:147:0x02a8, B:149:0x02ae, B:152:0x02bb, B:159:0x02d0, B:161:0x02d8, B:163:0x02e2, B:165:0x02f3, B:167:0x02f7, B:169:0x02fd, B:172:0x0302, B:174:0x0306, B:193:0x0350, B:195:0x0358, B:198:0x0361, B:199:0x0366, B:175:0x0309, B:177:0x0311, B:180:0x0317, B:181:0x0323, B:184:0x032c, B:187:0x0332, B:190:0x0338, B:191:0x0344, B:200:0x0367, B:201:0x0385, B:203:0x0388, B:205:0x038c, B:207:0x0390, B:210:0x0396, B:214:0x039e, B:220:0x03b0, B:222:0x03bf, B:224:0x03ca, B:225:0x03d2, B:226:0x03d5, B:238:0x0401, B:240:0x040c, B:243:0x0417, B:246:0x0427, B:247:0x0445, B:233:0x03e5, B:235:0x03ef, B:237:0x03fe, B:236:0x03f4, B:250:0x044a, B:252:0x0454, B:254:0x045c, B:255:0x045f, B:257:0x046a, B:258:0x046e, B:260:0x0479, B:263:0x0480, B:266:0x048d, B:267:0x0492, B:270:0x0497, B:272:0x049c, B:276:0x04a7, B:278:0x04b4, B:280:0x04ba, B:283:0x04c0, B:285:0x04c6, B:287:0x04ce, B:290:0x04dd, B:293:0x04e5, B:294:0x04e7, B:296:0x04f3, B:297:0x04f6, B:299:0x04fe, B:302:0x0508, B:305:0x0512, B:306:0x0517, B:307:0x051c, B:308:0x0536, B:309:0x0537, B:311:0x0549, B:314:0x0550, B:317:0x055c, B:318:0x057a, B:35:0x00aa, B:36:0x00c8, B:38:0x00cb, B:40:0x00d6, B:42:0x00da, B:44:0x00de, B:47:0x00e4, B:54:0x00f3, B:56:0x00fb, B:59:0x010b, B:60:0x0123, B:61:0x0124, B:62:0x0129, B:73:0x013e, B:74:0x0144, B:76:0x014b, B:80:0x0156, B:83:0x015e, B:84:0x0176, B:78:0x0151, B:85:0x0177, B:86:0x018f, B:92:0x0199, B:94:0x01a1, B:97:0x01b2, B:98:0x01d2, B:99:0x01d3, B:100:0x01d8, B:101:0x01d9, B:319:0x057b, B:320:0x0580, B:321:0x0581, B:322:0x0586), top: B:327:0x005a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0388 A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:18:0x005a, B:20:0x005e, B:25:0x006b, B:28:0x007e, B:32:0x0098, B:103:0x01e3, B:104:0x01e9, B:106:0x01f4, B:108:0x01fc, B:110:0x020d, B:111:0x0219, B:113:0x0226, B:114:0x0229, B:116:0x0233, B:117:0x0241, B:119:0x0247, B:121:0x0255, B:123:0x025d, B:130:0x026e, B:131:0x0274, B:133:0x027c, B:134:0x0281, B:137:0x0289, B:138:0x0290, B:139:0x0291, B:142:0x029b, B:144:0x029f, B:146:0x02a5, B:147:0x02a8, B:149:0x02ae, B:152:0x02bb, B:159:0x02d0, B:161:0x02d8, B:163:0x02e2, B:165:0x02f3, B:167:0x02f7, B:169:0x02fd, B:172:0x0302, B:174:0x0306, B:193:0x0350, B:195:0x0358, B:198:0x0361, B:199:0x0366, B:175:0x0309, B:177:0x0311, B:180:0x0317, B:181:0x0323, B:184:0x032c, B:187:0x0332, B:190:0x0338, B:191:0x0344, B:200:0x0367, B:201:0x0385, B:203:0x0388, B:205:0x038c, B:207:0x0390, B:210:0x0396, B:214:0x039e, B:220:0x03b0, B:222:0x03bf, B:224:0x03ca, B:225:0x03d2, B:226:0x03d5, B:238:0x0401, B:240:0x040c, B:243:0x0417, B:246:0x0427, B:247:0x0445, B:233:0x03e5, B:235:0x03ef, B:237:0x03fe, B:236:0x03f4, B:250:0x044a, B:252:0x0454, B:254:0x045c, B:255:0x045f, B:257:0x046a, B:258:0x046e, B:260:0x0479, B:263:0x0480, B:266:0x048d, B:267:0x0492, B:270:0x0497, B:272:0x049c, B:276:0x04a7, B:278:0x04b4, B:280:0x04ba, B:283:0x04c0, B:285:0x04c6, B:287:0x04ce, B:290:0x04dd, B:293:0x04e5, B:294:0x04e7, B:296:0x04f3, B:297:0x04f6, B:299:0x04fe, B:302:0x0508, B:305:0x0512, B:306:0x0517, B:307:0x051c, B:308:0x0536, B:309:0x0537, B:311:0x0549, B:314:0x0550, B:317:0x055c, B:318:0x057a, B:35:0x00aa, B:36:0x00c8, B:38:0x00cb, B:40:0x00d6, B:42:0x00da, B:44:0x00de, B:47:0x00e4, B:54:0x00f3, B:56:0x00fb, B:59:0x010b, B:60:0x0123, B:61:0x0124, B:62:0x0129, B:73:0x013e, B:74:0x0144, B:76:0x014b, B:80:0x0156, B:83:0x015e, B:84:0x0176, B:78:0x0151, B:85:0x0177, B:86:0x018f, B:92:0x0199, B:94:0x01a1, B:97:0x01b2, B:98:0x01d2, B:99:0x01d3, B:100:0x01d8, B:101:0x01d9, B:319:0x057b, B:320:0x0580, B:321:0x0581, B:322:0x0586), top: B:327:0x005a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03b0 A[Catch: all -> 0x0066, TRY_ENTER, TryCatch #1 {all -> 0x0066, blocks: (B:18:0x005a, B:20:0x005e, B:25:0x006b, B:28:0x007e, B:32:0x0098, B:103:0x01e3, B:104:0x01e9, B:106:0x01f4, B:108:0x01fc, B:110:0x020d, B:111:0x0219, B:113:0x0226, B:114:0x0229, B:116:0x0233, B:117:0x0241, B:119:0x0247, B:121:0x0255, B:123:0x025d, B:130:0x026e, B:131:0x0274, B:133:0x027c, B:134:0x0281, B:137:0x0289, B:138:0x0290, B:139:0x0291, B:142:0x029b, B:144:0x029f, B:146:0x02a5, B:147:0x02a8, B:149:0x02ae, B:152:0x02bb, B:159:0x02d0, B:161:0x02d8, B:163:0x02e2, B:165:0x02f3, B:167:0x02f7, B:169:0x02fd, B:172:0x0302, B:174:0x0306, B:193:0x0350, B:195:0x0358, B:198:0x0361, B:199:0x0366, B:175:0x0309, B:177:0x0311, B:180:0x0317, B:181:0x0323, B:184:0x032c, B:187:0x0332, B:190:0x0338, B:191:0x0344, B:200:0x0367, B:201:0x0385, B:203:0x0388, B:205:0x038c, B:207:0x0390, B:210:0x0396, B:214:0x039e, B:220:0x03b0, B:222:0x03bf, B:224:0x03ca, B:225:0x03d2, B:226:0x03d5, B:238:0x0401, B:240:0x040c, B:243:0x0417, B:246:0x0427, B:247:0x0445, B:233:0x03e5, B:235:0x03ef, B:237:0x03fe, B:236:0x03f4, B:250:0x044a, B:252:0x0454, B:254:0x045c, B:255:0x045f, B:257:0x046a, B:258:0x046e, B:260:0x0479, B:263:0x0480, B:266:0x048d, B:267:0x0492, B:270:0x0497, B:272:0x049c, B:276:0x04a7, B:278:0x04b4, B:280:0x04ba, B:283:0x04c0, B:285:0x04c6, B:287:0x04ce, B:290:0x04dd, B:293:0x04e5, B:294:0x04e7, B:296:0x04f3, B:297:0x04f6, B:299:0x04fe, B:302:0x0508, B:305:0x0512, B:306:0x0517, B:307:0x051c, B:308:0x0536, B:309:0x0537, B:311:0x0549, B:314:0x0550, B:317:0x055c, B:318:0x057a, B:35:0x00aa, B:36:0x00c8, B:38:0x00cb, B:40:0x00d6, B:42:0x00da, B:44:0x00de, B:47:0x00e4, B:54:0x00f3, B:56:0x00fb, B:59:0x010b, B:60:0x0123, B:61:0x0124, B:62:0x0129, B:73:0x013e, B:74:0x0144, B:76:0x014b, B:80:0x0156, B:83:0x015e, B:84:0x0176, B:78:0x0151, B:85:0x0177, B:86:0x018f, B:92:0x0199, B:94:0x01a1, B:97:0x01b2, B:98:0x01d2, B:99:0x01d3, B:100:0x01d8, B:101:0x01d9, B:319:0x057b, B:320:0x0580, B:321:0x0581, B:322:0x0586), top: B:327:0x005a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x040c A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:18:0x005a, B:20:0x005e, B:25:0x006b, B:28:0x007e, B:32:0x0098, B:103:0x01e3, B:104:0x01e9, B:106:0x01f4, B:108:0x01fc, B:110:0x020d, B:111:0x0219, B:113:0x0226, B:114:0x0229, B:116:0x0233, B:117:0x0241, B:119:0x0247, B:121:0x0255, B:123:0x025d, B:130:0x026e, B:131:0x0274, B:133:0x027c, B:134:0x0281, B:137:0x0289, B:138:0x0290, B:139:0x0291, B:142:0x029b, B:144:0x029f, B:146:0x02a5, B:147:0x02a8, B:149:0x02ae, B:152:0x02bb, B:159:0x02d0, B:161:0x02d8, B:163:0x02e2, B:165:0x02f3, B:167:0x02f7, B:169:0x02fd, B:172:0x0302, B:174:0x0306, B:193:0x0350, B:195:0x0358, B:198:0x0361, B:199:0x0366, B:175:0x0309, B:177:0x0311, B:180:0x0317, B:181:0x0323, B:184:0x032c, B:187:0x0332, B:190:0x0338, B:191:0x0344, B:200:0x0367, B:201:0x0385, B:203:0x0388, B:205:0x038c, B:207:0x0390, B:210:0x0396, B:214:0x039e, B:220:0x03b0, B:222:0x03bf, B:224:0x03ca, B:225:0x03d2, B:226:0x03d5, B:238:0x0401, B:240:0x040c, B:243:0x0417, B:246:0x0427, B:247:0x0445, B:233:0x03e5, B:235:0x03ef, B:237:0x03fe, B:236:0x03f4, B:250:0x044a, B:252:0x0454, B:254:0x045c, B:255:0x045f, B:257:0x046a, B:258:0x046e, B:260:0x0479, B:263:0x0480, B:266:0x048d, B:267:0x0492, B:270:0x0497, B:272:0x049c, B:276:0x04a7, B:278:0x04b4, B:280:0x04ba, B:283:0x04c0, B:285:0x04c6, B:287:0x04ce, B:290:0x04dd, B:293:0x04e5, B:294:0x04e7, B:296:0x04f3, B:297:0x04f6, B:299:0x04fe, B:302:0x0508, B:305:0x0512, B:306:0x0517, B:307:0x051c, B:308:0x0536, B:309:0x0537, B:311:0x0549, B:314:0x0550, B:317:0x055c, B:318:0x057a, B:35:0x00aa, B:36:0x00c8, B:38:0x00cb, B:40:0x00d6, B:42:0x00da, B:44:0x00de, B:47:0x00e4, B:54:0x00f3, B:56:0x00fb, B:59:0x010b, B:60:0x0123, B:61:0x0124, B:62:0x0129, B:73:0x013e, B:74:0x0144, B:76:0x014b, B:80:0x0156, B:83:0x015e, B:84:0x0176, B:78:0x0151, B:85:0x0177, B:86:0x018f, B:92:0x0199, B:94:0x01a1, B:97:0x01b2, B:98:0x01d2, B:99:0x01d3, B:100:0x01d8, B:101:0x01d9, B:319:0x057b, B:320:0x0580, B:321:0x0581, B:322:0x0586), top: B:327:0x005a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04dd A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:18:0x005a, B:20:0x005e, B:25:0x006b, B:28:0x007e, B:32:0x0098, B:103:0x01e3, B:104:0x01e9, B:106:0x01f4, B:108:0x01fc, B:110:0x020d, B:111:0x0219, B:113:0x0226, B:114:0x0229, B:116:0x0233, B:117:0x0241, B:119:0x0247, B:121:0x0255, B:123:0x025d, B:130:0x026e, B:131:0x0274, B:133:0x027c, B:134:0x0281, B:137:0x0289, B:138:0x0290, B:139:0x0291, B:142:0x029b, B:144:0x029f, B:146:0x02a5, B:147:0x02a8, B:149:0x02ae, B:152:0x02bb, B:159:0x02d0, B:161:0x02d8, B:163:0x02e2, B:165:0x02f3, B:167:0x02f7, B:169:0x02fd, B:172:0x0302, B:174:0x0306, B:193:0x0350, B:195:0x0358, B:198:0x0361, B:199:0x0366, B:175:0x0309, B:177:0x0311, B:180:0x0317, B:181:0x0323, B:184:0x032c, B:187:0x0332, B:190:0x0338, B:191:0x0344, B:200:0x0367, B:201:0x0385, B:203:0x0388, B:205:0x038c, B:207:0x0390, B:210:0x0396, B:214:0x039e, B:220:0x03b0, B:222:0x03bf, B:224:0x03ca, B:225:0x03d2, B:226:0x03d5, B:238:0x0401, B:240:0x040c, B:243:0x0417, B:246:0x0427, B:247:0x0445, B:233:0x03e5, B:235:0x03ef, B:237:0x03fe, B:236:0x03f4, B:250:0x044a, B:252:0x0454, B:254:0x045c, B:255:0x045f, B:257:0x046a, B:258:0x046e, B:260:0x0479, B:263:0x0480, B:266:0x048d, B:267:0x0492, B:270:0x0497, B:272:0x049c, B:276:0x04a7, B:278:0x04b4, B:280:0x04ba, B:283:0x04c0, B:285:0x04c6, B:287:0x04ce, B:290:0x04dd, B:293:0x04e5, B:294:0x04e7, B:296:0x04f3, B:297:0x04f6, B:299:0x04fe, B:302:0x0508, B:305:0x0512, B:306:0x0517, B:307:0x051c, B:308:0x0536, B:309:0x0537, B:311:0x0549, B:314:0x0550, B:317:0x055c, B:318:0x057a, B:35:0x00aa, B:36:0x00c8, B:38:0x00cb, B:40:0x00d6, B:42:0x00da, B:44:0x00de, B:47:0x00e4, B:54:0x00f3, B:56:0x00fb, B:59:0x010b, B:60:0x0123, B:61:0x0124, B:62:0x0129, B:73:0x013e, B:74:0x0144, B:76:0x014b, B:80:0x0156, B:83:0x015e, B:84:0x0176, B:78:0x0151, B:85:0x0177, B:86:0x018f, B:92:0x0199, B:94:0x01a1, B:97:0x01b2, B:98:0x01d2, B:99:0x01d3, B:100:0x01d8, B:101:0x01d9, B:319:0x057b, B:320:0x0580, B:321:0x0581, B:322:0x0586), top: B:327:0x005a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x04f3 A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:18:0x005a, B:20:0x005e, B:25:0x006b, B:28:0x007e, B:32:0x0098, B:103:0x01e3, B:104:0x01e9, B:106:0x01f4, B:108:0x01fc, B:110:0x020d, B:111:0x0219, B:113:0x0226, B:114:0x0229, B:116:0x0233, B:117:0x0241, B:119:0x0247, B:121:0x0255, B:123:0x025d, B:130:0x026e, B:131:0x0274, B:133:0x027c, B:134:0x0281, B:137:0x0289, B:138:0x0290, B:139:0x0291, B:142:0x029b, B:144:0x029f, B:146:0x02a5, B:147:0x02a8, B:149:0x02ae, B:152:0x02bb, B:159:0x02d0, B:161:0x02d8, B:163:0x02e2, B:165:0x02f3, B:167:0x02f7, B:169:0x02fd, B:172:0x0302, B:174:0x0306, B:193:0x0350, B:195:0x0358, B:198:0x0361, B:199:0x0366, B:175:0x0309, B:177:0x0311, B:180:0x0317, B:181:0x0323, B:184:0x032c, B:187:0x0332, B:190:0x0338, B:191:0x0344, B:200:0x0367, B:201:0x0385, B:203:0x0388, B:205:0x038c, B:207:0x0390, B:210:0x0396, B:214:0x039e, B:220:0x03b0, B:222:0x03bf, B:224:0x03ca, B:225:0x03d2, B:226:0x03d5, B:238:0x0401, B:240:0x040c, B:243:0x0417, B:246:0x0427, B:247:0x0445, B:233:0x03e5, B:235:0x03ef, B:237:0x03fe, B:236:0x03f4, B:250:0x044a, B:252:0x0454, B:254:0x045c, B:255:0x045f, B:257:0x046a, B:258:0x046e, B:260:0x0479, B:263:0x0480, B:266:0x048d, B:267:0x0492, B:270:0x0497, B:272:0x049c, B:276:0x04a7, B:278:0x04b4, B:280:0x04ba, B:283:0x04c0, B:285:0x04c6, B:287:0x04ce, B:290:0x04dd, B:293:0x04e5, B:294:0x04e7, B:296:0x04f3, B:297:0x04f6, B:299:0x04fe, B:302:0x0508, B:305:0x0512, B:306:0x0517, B:307:0x051c, B:308:0x0536, B:309:0x0537, B:311:0x0549, B:314:0x0550, B:317:0x055c, B:318:0x057a, B:35:0x00aa, B:36:0x00c8, B:38:0x00cb, B:40:0x00d6, B:42:0x00da, B:44:0x00de, B:47:0x00e4, B:54:0x00f3, B:56:0x00fb, B:59:0x010b, B:60:0x0123, B:61:0x0124, B:62:0x0129, B:73:0x013e, B:74:0x0144, B:76:0x014b, B:80:0x0156, B:83:0x015e, B:84:0x0176, B:78:0x0151, B:85:0x0177, B:86:0x018f, B:92:0x0199, B:94:0x01a1, B:97:0x01b2, B:98:0x01d2, B:99:0x01d3, B:100:0x01d8, B:101:0x01d9, B:319:0x057b, B:320:0x0580, B:321:0x0581, B:322:0x0586), top: B:327:0x005a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0508 A[Catch: all -> 0x0066, TRY_ENTER, TryCatch #1 {all -> 0x0066, blocks: (B:18:0x005a, B:20:0x005e, B:25:0x006b, B:28:0x007e, B:32:0x0098, B:103:0x01e3, B:104:0x01e9, B:106:0x01f4, B:108:0x01fc, B:110:0x020d, B:111:0x0219, B:113:0x0226, B:114:0x0229, B:116:0x0233, B:117:0x0241, B:119:0x0247, B:121:0x0255, B:123:0x025d, B:130:0x026e, B:131:0x0274, B:133:0x027c, B:134:0x0281, B:137:0x0289, B:138:0x0290, B:139:0x0291, B:142:0x029b, B:144:0x029f, B:146:0x02a5, B:147:0x02a8, B:149:0x02ae, B:152:0x02bb, B:159:0x02d0, B:161:0x02d8, B:163:0x02e2, B:165:0x02f3, B:167:0x02f7, B:169:0x02fd, B:172:0x0302, B:174:0x0306, B:193:0x0350, B:195:0x0358, B:198:0x0361, B:199:0x0366, B:175:0x0309, B:177:0x0311, B:180:0x0317, B:181:0x0323, B:184:0x032c, B:187:0x0332, B:190:0x0338, B:191:0x0344, B:200:0x0367, B:201:0x0385, B:203:0x0388, B:205:0x038c, B:207:0x0390, B:210:0x0396, B:214:0x039e, B:220:0x03b0, B:222:0x03bf, B:224:0x03ca, B:225:0x03d2, B:226:0x03d5, B:238:0x0401, B:240:0x040c, B:243:0x0417, B:246:0x0427, B:247:0x0445, B:233:0x03e5, B:235:0x03ef, B:237:0x03fe, B:236:0x03f4, B:250:0x044a, B:252:0x0454, B:254:0x045c, B:255:0x045f, B:257:0x046a, B:258:0x046e, B:260:0x0479, B:263:0x0480, B:266:0x048d, B:267:0x0492, B:270:0x0497, B:272:0x049c, B:276:0x04a7, B:278:0x04b4, B:280:0x04ba, B:283:0x04c0, B:285:0x04c6, B:287:0x04ce, B:290:0x04dd, B:293:0x04e5, B:294:0x04e7, B:296:0x04f3, B:297:0x04f6, B:299:0x04fe, B:302:0x0508, B:305:0x0512, B:306:0x0517, B:307:0x051c, B:308:0x0536, B:309:0x0537, B:311:0x0549, B:314:0x0550, B:317:0x055c, B:318:0x057a, B:35:0x00aa, B:36:0x00c8, B:38:0x00cb, B:40:0x00d6, B:42:0x00da, B:44:0x00de, B:47:0x00e4, B:54:0x00f3, B:56:0x00fb, B:59:0x010b, B:60:0x0123, B:61:0x0124, B:62:0x0129, B:73:0x013e, B:74:0x0144, B:76:0x014b, B:80:0x0156, B:83:0x015e, B:84:0x0176, B:78:0x0151, B:85:0x0177, B:86:0x018f, B:92:0x0199, B:94:0x01a1, B:97:0x01b2, B:98:0x01d2, B:99:0x01d3, B:100:0x01d8, B:101:0x01d9, B:319:0x057b, B:320:0x0580, B:321:0x0581, B:322:0x0586), top: B:327:0x005a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x04fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0415 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parseObject(java.util.Map r17, java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 1419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        int i4 = this.contextArrayIndex;
        if (i4 <= 0) {
            return;
        }
        int i5 = i4 - 1;
        this.contextArrayIndex = i5;
        this.contextArray[i5] = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object resolveReference(java.lang.String r5) {
        /*
            r4 = this;
            com.alibaba.fastjson.parser.ParseContext[] r0 = r4.contextArray
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            r0 = 0
        L7:
            com.alibaba.fastjson.parser.ParseContext[] r2 = r4.contextArray
            int r3 = r2.length
            if (r0 >= r3) goto L22
            int r3 = r4.contextArrayIndex
            if (r0 >= r3) goto L22
            r2 = r2[r0]
            java.lang.String r3 = r2.toString()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L1f
            java.lang.Object r4 = r2.object
            return r4
        L1f:
            int r0 = r0 + 1
            goto L7
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.resolveReference(java.lang.String):java.lang.Object");
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setResolveStatus(int i4) {
        this.resolveStatus = i4;
    }

    public void throwException(int i4) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i4) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i4 = jSONLexer.token();
        if (i4 == 2) {
            Number numberIntegerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return numberIntegerValue;
        }
        if (i4 == 3) {
            Number numberDecimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return numberDecimalValue;
        }
        if (i4 == 4) {
            String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(strStringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                } finally {
                    jSONScanner.close();
                }
            }
            return strStringVal;
        }
        if (i4 == 12) {
            return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        }
        if (i4 == 14) {
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
        }
        if (i4 == 26) {
            byte[] bArrBytesValue = jSONLexer.bytesValue();
            jSONLexer.nextToken();
            return bArrBytesValue;
        }
        switch (i4) {
            case 6:
                jSONLexer.nextToken();
                return Boolean.TRUE;
            case 7:
                jSONLexer.nextToken();
                return Boolean.FALSE;
            case 8:
                jSONLexer.nextToken();
                return null;
            case 9:
                jSONLexer.nextToken(18);
                if (jSONLexer.token() != 18) {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken(10);
                accept(10);
                long jLongValue = jSONLexer.integerValue().longValue();
                accept(2);
                accept(11);
                return new Date(jLongValue);
            default:
                switch (i4) {
                    case 20:
                        if (jSONLexer.isBlankInput()) {
                            return null;
                        }
                        throw new JSONException("unterminated json string, " + jSONLexer.info());
                    case 21:
                        jSONLexer.nextToken();
                        HashSet hashSet = new HashSet();
                        parseArray(hashSet, obj);
                        return hashSet;
                    case 22:
                        jSONLexer.nextToken();
                        TreeSet treeSet = new TreeSet();
                        parseArray(treeSet, obj);
                        return treeSet;
                    case 23:
                        jSONLexer.nextToken();
                        return null;
                    default:
                        throw new JSONException("syntax error, " + jSONLexer.info());
                }
        }
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i4) {
        this(str, new JSONScanner(str, i4), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public DefaultJSONParser(char[] cArr, int i4, ParserConfig parserConfig, int i5) {
        this(cArr, new JSONScanner(cArr, i4, i5), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i4 = this.lexer.token();
        if (i4 == 21 || i4 == 22) {
            this.lexer.nextToken();
            i4 = this.lexer.token();
        }
        if (i4 == 14) {
            if (Integer.TYPE == type) {
                deserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            } else if (String.class == type) {
                deserializer = StringCodec.instance;
                this.lexer.nextToken(4);
            } else {
                deserializer = this.config.getDeserializer(type);
                this.lexer.nextToken(deserializer.getFastMatchToken());
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i5 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object objDeserialze = null;
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    } else if (String.class == type) {
                        if (this.lexer.token() == 4) {
                            objDeserialze = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object obj2 = parse();
                            if (obj2 != null) {
                                objDeserialze = obj2.toString();
                            }
                        }
                        collection.add(objDeserialze);
                    } else {
                        if (this.lexer.token() == 8) {
                            this.lexer.nextToken();
                        } else {
                            objDeserialze = deserializer.deserialze(this, type, Integer.valueOf(i5));
                        }
                        collection.add(objDeserialze);
                        checkListResolve(collection);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i5++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.name(i4) + ", " + this.lexer.info());
        }
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public final void accept(int i4, int i5) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i4) {
            jSONLexer.nextToken(i5);
        } else {
            throwException(i4);
        }
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object objCast;
        Class<?> componentType;
        boolean zIsArray;
        int i4 = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i5 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i6 = 0;
            while (i6 < typeArr.length) {
                if (this.lexer.token() == i4) {
                    this.lexer.nextToken(16);
                    objCast = null;
                } else {
                    Type type = typeArr[i6];
                    if (type != Integer.TYPE && type != Integer.class) {
                        if (type == String.class) {
                            if (this.lexer.token() == 4) {
                                objCast = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                objCast = TypeUtils.cast(parse(), type, this.config);
                            }
                        } else {
                            if (i6 == typeArr.length - 1 && (type instanceof Class)) {
                                Class cls = (Class) type;
                                zIsArray = cls.isArray();
                                componentType = cls.getComponentType();
                            } else {
                                componentType = null;
                                zIsArray = false;
                            }
                            if (zIsArray && this.lexer.token() != i5) {
                                ArrayList arrayList = new ArrayList();
                                ObjectDeserializer deserializer = this.config.getDeserializer(componentType);
                                int fastMatchToken = deserializer.getFastMatchToken();
                                if (this.lexer.token() != 15) {
                                    while (true) {
                                        arrayList.add(deserializer.deserialze(this, type, null));
                                        if (this.lexer.token() != 16) {
                                            break;
                                        }
                                        this.lexer.nextToken(fastMatchToken);
                                    }
                                    if (this.lexer.token() != 15) {
                                        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                    }
                                }
                                objCast = TypeUtils.cast(arrayList, type, this.config);
                            } else {
                                objCast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i6));
                            }
                        }
                    } else if (this.lexer.token() == 2) {
                        objCast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        objCast = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i6] = objCast;
                if (this.lexer.token() == 15) {
                    break;
                }
                if (this.lexer.token() == 16) {
                    if (i6 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i6++;
                    i4 = 8;
                    i5 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0216, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable, java.lang.Object):java.lang.Object");
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Object object;
        Number numberDecimalValue;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() == 14) {
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i4 = 0;
            while (true) {
                try {
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (jSONLexer.token() == 16) {
                            jSONLexer.nextToken();
                        }
                    }
                    int i5 = jSONLexer.token();
                    if (i5 == 2) {
                        Number numberIntegerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        object = numberIntegerValue;
                    } else if (i5 == 3) {
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            numberDecimalValue = jSONLexer.decimalValue(true);
                        } else {
                            numberDecimalValue = jSONLexer.decimalValue(false);
                        }
                        object = numberDecimalValue;
                        jSONLexer.nextToken(16);
                    } else if (i5 == 4) {
                        String strStringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken(16);
                        object = strStringVal;
                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner jSONScanner = new JSONScanner(strStringVal);
                            Object time = strStringVal;
                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                time = jSONScanner.getCalendar().getTime();
                            }
                            jSONScanner.close();
                            object = time;
                        }
                    } else if (i5 == 6) {
                        Boolean bool = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        object = bool;
                    } else if (i5 != 7) {
                        object = null;
                        object = null;
                        if (i5 == 8) {
                            jSONLexer.nextToken(4);
                        } else if (i5 == 12) {
                            object = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i4));
                        } else {
                            if (i5 == 20) {
                                throw new JSONException("unclosed jsonArray");
                            }
                            if (i5 == 23) {
                                jSONLexer.nextToken(4);
                            } else if (i5 == 14) {
                                JSONArray jSONArray = new JSONArray();
                                parseArray(jSONArray, Integer.valueOf(i4));
                                object = jSONArray;
                                if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                    object = jSONArray.toArray();
                                }
                            } else if (i5 != 15) {
                                object = parse();
                            } else {
                                jSONLexer.nextToken(16);
                                setContext(parseContext);
                                return;
                            }
                        }
                    } else {
                        Boolean bool2 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        object = bool2;
                    }
                    collection.add(object);
                    checkListResolve(collection);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                    i4++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type type, Object obj) {
        int i4 = this.lexer.token();
        if (i4 == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i4 == 4) {
            if (type == byte[].class) {
                T t4 = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t4;
            }
            if (type == char[].class) {
                String strStringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) strStringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e4) {
            throw e4;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public void parseObject(Object obj) {
        Object objDeserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String strScanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (strScanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() != 16 || !this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(strScanSymbol) : null;
            if (fieldDeserializer == null) {
                if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + strScanSymbol);
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    objDeserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    objDeserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    objDeserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    objDeserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, objDeserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
    }
}
