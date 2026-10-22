package com.alibaba.fastjson.parser;

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
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes28.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = null;
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
    private int objectKeyLevel;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext r100, String r101) {
            this.context = r100;
            this.referenceValue = r101;
        }
    }

    public Object parse() {
        return parse(null);
    }

    static {
        HashSet r100 = new HashSet();
        primitiveClasses = r100;
        r100.addAll(Arrays.asList(new Class[]{Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class}));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer r100 = this.lexer;
    L12:
        th = move-exception;
        r100.close();
        throw th;
    L4:
        if (r100.isEnabled(Feature.AutoCloseSource) == true) goto L6;
    L10:
        r100.close();
        return;
    L6:
        if (r100.token() == 20) goto L10;
        throw new JSONException("not close json text, token : " + JSONToken.name(r100.token()));     // Catch: Throwable -> L12
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat != null) goto L6;
        SimpleDateFormat r100 = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
        this.dateFormat = r100;
        r100.setTimeZone(this.lexer.getTimeZone());
    L6:
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors != null) goto L6;
        this.extraProcessors = new ArrayList(2);
    L6:
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders != null) goto L6;
        this.extraTypeProviders = new ArrayList(2);
    L6:
        return this.extraTypeProviders;
    }

    public String getInput() {
        Object r100 = this.input;
        if ((r100 instanceof char[]) == false) goto L7;
        return new String((char[]) r100);
    L7:
        return r100.toString();
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> r100 = this.resolveTaskList;
        return (ResolveTask) ListProtector.get(r100, r100.size() - 1);
    }

    public ParseContext getOwnerContext() {
        return this.context.parent;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList != null) goto L6;
        this.resolveTaskList = new ArrayList(2);
    L6:
        return this.resolveTaskList;
    }

    public Object parseKey() {
        if (this.lexer.token() != 18) goto L7;
        String r100 = this.lexer.stringVal();
        this.lexer.nextToken(16);
        return r100;
    L7:
        return parse(null);
    }

    public JSONObject parseObject() {
        Object r100 = parseObject(new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
        if ((r100 instanceof JSONObject) == true) goto L5;
        if (r100 != null) goto L10;
        return null;
    L10:
        return new JSONObject((Map) r100);
    L5:
        return (JSONObject) r100;
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect) == false) goto L5;
        return;
    L5:
        this.context = this.context.parent;
        int r100 = this.contextArrayIndex;
        if (r100 > 0) goto L8;
        return;
    L8:
        int r101 = r100 - 1;
        this.contextArrayIndex = r101;
        this.contextArray[r101] = null;
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

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public DefaultJSONParser(String r100) {
        this(r100, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    private void addContext(ParseContext r100) {
        int r101 = this.contextArrayIndex;
        this.contextArrayIndex = r101 + 1;
        ParseContext[] r102 = this.contextArray;
        if (r102 != null) goto L6;
        this.contextArray = new ParseContext[8];
    L8:
        this.contextArray[r101] = r100;
        return;
    L6:
        if (r101 < r102.length) goto L8;
        ParseContext[] r103 = new ParseContext[(r102.length * 3) / 2];
        System.arraycopy(r102, 0, r103, 0, r102.length);
        this.contextArray = r103;
        goto L8
    }

    public final void accept(int r100) {
        JSONLexer r101 = this.lexer;
        if (r101.token() != r100) goto L7;
        r101.nextToken();
        return;
    L7:
        throw new JSONException("syntax error, expect " + JSONToken.name(r100) + ", actual " + JSONToken.name(r101.token()));
    }

    public void acceptType(String r100) {
        JSONLexer r101 = this.lexer;
        r101.nextTokenWithColon();
        if (r101.token() != 4) goto L13;
        if (r100.equals(r101.stringVal()) == false) goto L11;
        r101.nextToken();
        if (r101.token() != 16) goto L14;
        r101.nextToken();
        return;
    L14:
        return;
    L11:
        throw new JSONException("type not match error");
    L13:
        throw new JSONException("type not match error");
    }

    public void addResolveTask(ResolveTask r100) {
        if (this.resolveTaskList != null) goto L5;
        this.resolveTaskList = new ArrayList(2);
    L5:
        this.resolveTaskList.add(r100);
    }

    public void checkListResolve(Collection r100) {
        if (this.resolveStatus == 1) goto L5;
        return;
    L5:
        if ((r100 instanceof List) == false) goto L7;
        int r101 = r100.size() - 1;
        ResolveTask r102 = getLastResolveTask();
        r102.fieldDeserializer = new ResolveFieldDeserializer(this, (List) r100, r101);
        r102.ownerContext = this.context;
        setResolveStatus(0);
        return;
    L7:
        ResolveTask r103 = getLastResolveTask();
        r103.fieldDeserializer = new ResolveFieldDeserializer(r100);
        r103.ownerContext = this.context;
        setResolveStatus(0);
    }

    public Object getObject(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.contextArrayIndex) goto L10;
        if (r100.equals(this.contextArray[r101].toString()) == true) goto L8;
        r101 = r101 + 1;
        goto L4
    L8:
        return this.contextArray[r101].object;
    L10:
        return null;
    }

    public void handleResovleTask(Object r110) {
        List<ResolveTask> r100 = this.resolveTaskList;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L46;
        ResolveTask r103 = (ResolveTask) ListProtector.get(this.resolveTaskList, r102);
        String r104 = r103.referenceValue;
        ParseContext r105 = r103.ownerContext;
        if (r105 == null) goto L10;
        Object r106 = r105.object;
    L12:
        if (r104.startsWith("$") == false) goto L20;
        Object r107 = getObject(r104);
        if (r107 == null) goto L47;
    L21:
        FieldDeserializer r108 = r103.fieldDeserializer;
        if (r108 == null) goto L45;
        if (r107 == null) goto L34;
        if (r107.getClass() != JSONObject.class) goto L34;
        FieldInfo r109 = r108.fieldInfo;
        if (r109 == null) goto L34;
        if (Map.class.isAssignableFrom(r109.fieldClass) == true) goto L34;
        Object r111 = this.contextArray[0].object;
        JSONPath r112 = JSONPath.compile(r104);
        if (r112.isRef() == false) goto L34;
        r107 = r112.eval(r111);
    L34:
        if (r108.getOwnerClass() != null) goto L36;
    L44:
        r108.setValue(r106, r107);
        goto L45
    L36:
        if (r108.getOwnerClass().isInstance(r106) == true) goto L44;
        ParseContext r113 = r103.ownerContext.parent;
        if (r113 == null) goto L44;
    L39:
        if (r113 == null) goto L44;
        if (r108.getOwnerClass().isInstance(r113.object) == true) goto L42;
        r113 = r113.parent;
        goto L39
    L42:
        r106 = r113.object;
    L45:
        r102 = r102 + 1;
        goto L6
    L47:
        JSONPath r114 = new JSONPath(r104, SerializeConfig.getGlobalInstance(), this.config, true);     // Catch: JSONPathException -> L19
        if (r114.isRef() == false) goto L21;
        r107 = r114.eval(r110);     // Catch: JSONPathException -> L19
        goto L21
    L20:
        r107 = r103.context.object;
        goto L21
    L10:
        r106 = null;
        goto L12
    }

    public boolean isEnabled(Feature r100) {
        return this.lexer.isEnabled(r100);
    }

    public Object parse(Object r100) {
        JSONLexer r101 = this.lexer;
        int r102 = r101.token();
        if (r102 != 2) goto L5;
        Number r103 = r101.integerValue();
        r101.nextToken();
        return r103;
    L5:
        if (r102 != 3) goto L7;
        Number r104 = r101.decimalValue(r101.isEnabled(Feature.UseBigDecimal));
        r101.nextToken();
        return r104;
    L7:
        if (r102 != 4) goto L9;
        String r105 = r101.stringVal();
        r101.nextToken(16);
        if (r101.isEnabled(Feature.AllowISO8601DateFormat) == false) goto L81;
        JSONScanner r106 = new JSONScanner(r105);
    L78:
        th = move-exception;
        r106.close();
        throw th;
    L73:
        if (r106.scanISO8601DateIfMatch() == false) goto L77;
        Date r107 = r106.getCalendar().getTime();     // Catch: Throwable -> L78
        r106.close();
        return r107;
    L77:
        r106.close();
    L81:
        return r105;
    L9:
        if (r102 == 12) goto L61;
        if (r102 == 14) goto L52;
        if (r102 == 18) goto L46;
        if (r102 == 26) goto L43;
        switch(r102) {
            case 6: goto L41;
            case 7: goto L39;
            case 8: goto L37;
            case 9: goto L31;
            default: goto L17;
        };
    L17:
        switch(r102) {
            case 20: goto L27;
            case 21: goto L24;
            case 22: goto L22;
            case 23: goto L20;
            default: goto L19;
        };
    L20:
        r101.nextToken();
        return null;
    L22:
        r101.nextToken();
        TreeSet r108 = new TreeSet();
        parseArray(r108, r100);
        return r108;
    L24:
        r101.nextToken();
        HashSet r109 = new HashSet();
        parseArray(r109, r100);
        return r109;
    L19:
        throw new JSONException("syntax error, " + r101.info());
    L27:
        if (r101.isBlankInput() == false) goto L30;
        return null;
    L30:
        throw new JSONException("unterminated json string, " + r101.info());
    L31:
        r101.nextToken(18);
        if (r101.token() != 18) goto L36;
        r101.nextToken(10);
        accept(10);
        long r110 = r101.integerValue().longValue();
        accept(2);
        accept(11);
        return new Date(r110);
    L36:
        throw new JSONException("syntax error");
    L37:
        r101.nextToken();
        return null;
    L39:
        r101.nextToken();
        return Boolean.FALSE;
    L41:
        r101.nextToken();
        return Boolean.TRUE;
    L43:
        byte[] r111 = r101.bytesValue();
        r101.nextToken();
        return r111;
    L46:
        if ("NaN".equals(r101.stringVal()) == false) goto L50;
        r101.nextToken();
        return null;
    L50:
        throw new JSONException("syntax error, " + r101.info());
    L52:
        if (isEnabled(Feature.UseNativeJavaObject) == false) goto L54;
        Collection r112 = new ArrayList();
    L55:
        parseArray(r112, r100);
        if (r101.isEnabled(Feature.UseObjectArray) == true) goto L58;
        return r112;
    L58:
        return r112.toArray();
    L54:
        r112 = new JSONArray();
        goto L55
    L61:
        if (isEnabled(Feature.UseNativeJavaObject) == true) goto L63;
        Map r113 = new JSONObject(r101.isEnabled(Feature.OrderedField));
    L68:
        return parseObject(r113, r100);
    L63:
        if (r101.isEnabled(Feature.OrderedField) == false) goto L65;
        r113 = new HashMap();
        goto L68
    L65:
        r113 = new LinkedHashMap();
        goto L68
    }

    public Object[] parseArray(Type[] r110) {
        int r100 = 8;
        if (this.lexer.token() != 8) goto L6;
        this.lexer.nextToken(16);
        return null;
    L6:
        int r101 = 14;
        if (this.lexer.token() != 14) goto L83;
        Object[] r102 = new Object[r110.length];
        if (r110.length != 0) goto L16;
        this.lexer.nextToken(15);
        if (this.lexer.token() != 15) goto L15;
        this.lexer.nextToken(16);
        return new Object[0];
    L15:
        throw new JSONException("syntax error");
    L16:
        this.lexer.nextToken(2);
        int r103 = 0;
    L18:
        if (r103 >= r110.length) goto L77;
        if (this.lexer.token() != r100) goto L22;
        this.lexer.nextToken(16);
        Object r111 = null;
    L64:
        r102[r103] = r111;
        if (this.lexer.token() == 15) goto L77;
        if (this.lexer.token() != 16) goto L75;
        if (r103 != (r110.length - 1)) goto L72;
        this.lexer.nextToken(15);
    L73:
        r103 = r103 + 1;
        r100 = 8;
        r101 = 14;
        goto L18
    L72:
        this.lexer.nextToken(2);
        goto L73
    L75:
        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
    L22:
        Type r112 = r110[r103];
        if (r112 == Integer.TYPE) goto L61;
        if (r112 == Integer.class) goto L61;
        if (r112 != String.class) goto L34;
        if (this.lexer.token() != 4) goto L32;
        r111 = this.lexer.stringVal();
        this.lexer.nextToken(16);
        goto L64
    L32:
        r111 = TypeUtils.cast(parse(), r112, this.config);
        goto L64
    L34:
        if (r103 == (r110.length - 1)) goto L36;
    L44:
        Class<?> r113 = null;
        boolean r104 = false;
    L45:
        if (r104 == true) goto L47;
    L59:
        r111 = this.config.getDeserializer(r112).deserialze(this, r112, Integer.valueOf(r103));
        goto L64
    L47:
        if (this.lexer.token() == r101) goto L59;
        ArrayList r105 = new ArrayList();
        ObjectDeserializer r114 = this.config.getDeserializer(r113);
        int r115 = r114.getFastMatchToken();
        if (this.lexer.token() == 15) goto L58;
    L50:
        r105.add(r114.deserialze(this, r112, null));
        if (this.lexer.token() != 16) goto L54;
        this.lexer.nextToken(r115);
        goto L50
    L54:
        if (this.lexer.token() == 15) goto L58;
        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
    L58:
        r111 = TypeUtils.cast(r105, r112, this.config);
        goto L64
    L36:
        if ((r112 instanceof Class) == false) goto L44;
        Class r116 = (Class) r112;
        if (r116 == byte[].class) goto L42;
        if (r116 == char[].class) goto L42;
    L43:
        r104 = r116.isArray();
        r113 = r116.getComponentType();
    L42:
        if (this.lexer.token() == 4) goto L44;
    L61:
        if (this.lexer.token() != 2) goto L63;
        r111 = Integer.valueOf(this.lexer.intValue());
        this.lexer.nextToken(16);
        goto L64
    L63:
        r111 = TypeUtils.cast(parse(), r112, this.config);
    L77:
        if (this.lexer.token() != 15) goto L81;
        this.lexer.nextToken(16);
        return r102;
    L81:
        throw new JSONException("syntax error");
    L83:
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    public Object parseArrayWithType(Type r100) {
        if (this.lexer.token() != 8) goto L6;
        this.lexer.nextToken();
        return null;
    L6:
        Type[] r101 = ((ParameterizedType) r100).getActualTypeArguments();
        if (r101.length != 1) goto L41;
        Type r102 = r101[0];
        if ((r102 instanceof Class) == false) goto L13;
        ArrayList r103 = new ArrayList();
        parseArray((Class) r102, r103);
        return r103;
    L13:
        if ((r102 instanceof WildcardType) == false) goto L25;
        WildcardType r104 = (WildcardType) r102;
        Type r105 = r104.getUpperBounds()[0];
        if (Object.class.equals(r105) == true) goto L17;
        ArrayList r106 = new ArrayList();
        parseArray((Class) r105, r106);
        return r106;
    L17:
        if (r104.getLowerBounds().length != 0) goto L21;
        return parse();
    L21:
        throw new JSONException("not support type : " + r100);
    L25:
        if ((r102 instanceof TypeVariable) == false) goto L35;
        TypeVariable r107 = (TypeVariable) r102;
        Type[] r108 = r107.getBounds();
        if (r108.length != 1) goto L33;
        Type r109 = r108[0];
        if ((r109 instanceof Class) == false) goto L35;
        ArrayList r110 = new ArrayList();
        parseArray((Class) r109, r110);
        return r110;
    L33:
        throw new JSONException("not support : " + r107);
    L35:
        if ((r102 instanceof ParameterizedType) == false) goto L39;
        ArrayList r111 = new ArrayList();
        parseArray((ParameterizedType) r102, r111);
        return r111;
    L39:
        throw new JSONException("TODO : " + r100);
    L41:
        throw new JSONException("not support type " + r100);
    }

    public void parseObject(Object r110) {
        Class<?> r100 = r110.getClass();
        ObjectDeserializer r101 = this.config.getDeserializer(r100);
        if ((r101 instanceof JavaBeanDeserializer) == false) goto L5;
        JavaBeanDeserializer r102 = (JavaBeanDeserializer) r101;
    L7:
        if (this.lexer.token() == 12) goto L13;
        if (this.lexer.token() == 16) goto L13;
        throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
    L13:
        String r103 = this.lexer.scanSymbol(this.symbolTable);
        if (r103 != null) goto L24;
        if (this.lexer.token() == 13) goto L17;
        if (this.lexer.token() != 16) goto L24;
        if (this.lexer.isEnabled(Feature.AllowArbitraryCommas) == false) goto L24;
    L17:
        this.lexer.nextToken(16);
        return;
    L24:
        if (r102 == null) goto L26;
        FieldDeserializer r104 = r102.getFieldDeserializer(r103);
    L27:
        if (r104 == null) goto L29;
        FieldInfo r105 = r104.fieldInfo;
        Class<?> r106 = r105.fieldClass;
        Type r107 = r105.fieldType;
        if (r106 != Integer.TYPE) goto L40;
        this.lexer.nextTokenWithColon(2);
        Object r108 = IntegerCodec.instance.deserialze(this, r107, null);
    L46:
        r104.setValue(r110, r108);
        if (this.lexer.token() == 16) goto L13;
        if (this.lexer.token() != 13) goto L13;
        this.lexer.nextToken(16);
        return;
    L40:
        if (r106 != String.class) goto L43;
        this.lexer.nextTokenWithColon(4);
        r108 = StringCodec.deserialze(this);
        goto L46
    L43:
        if (r106 != Long.TYPE) goto L45;
        this.lexer.nextTokenWithColon(2);
        r108 = LongCodec.instance.deserialze(this, r107, null);
        goto L46
    L45:
        ObjectDeserializer r109 = this.config.getDeserializer(r106, r107);
        this.lexer.nextTokenWithColon(r109.getFastMatchToken());
        r108 = r109.deserialze(this, r107, null);
        goto L46
    L29:
        if (this.lexer.isEnabled(Feature.IgnoreNotMatch) == false) goto L35;
        this.lexer.nextTokenWithColon();
        parse();
        if (this.lexer.token() != 13) goto L13;
        this.lexer.nextToken();
        return;
    L35:
        throw new JSONException("setter not found, class " + r100.getName() + ", property " + r103);
    L26:
        r104 = null;
        goto L27
    L5:
        r102 = null;
        goto L7
    }

    public Object resolveReference(String r100) {
        if (this.contextArray != null) goto L5;
        return null;
    L5:
        int r101 = 0;
    L6:
        ParseContext[] r102 = this.contextArray;
        if (r101 >= r102.length) goto L15;
        if (r101 >= this.contextArrayIndex) goto L15;
        ParseContext r103 = r102[r101];
        if (r103.toString().equals(r100) == true) goto L13;
        r101 = r101 + 1;
        goto L6
    L13:
        return r103.object;
    L15:
        return null;
    }

    public void setConfig(ParserConfig r100) {
        this.config = r100;
    }

    public void setContext(ParseContext r100) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect) == false) goto L5;
        return;
    L5:
        this.context = r100;
    }

    public void setDateFomrat(DateFormat r100) {
        setDateFormat(r100);
    }

    public void setDateFormat(String r100) {
        this.dateFormatPattern = r100;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver r100) {
        this.fieldTypeResolver = r100;
    }

    public void setResolveStatus(int r100) {
        this.resolveStatus = r100;
    }

    public void throwException(int r100) {
        throw new JSONException("syntax error, expect " + JSONToken.name(r100) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(JSONLexer r100) {
        this(r100, ParserConfig.getGlobalInstance());
    }

    public <T> List<T> parseArray(Class<T> r100) {
        ArrayList r101 = new ArrayList();
        parseArray(r100, r101);
        return r101;
    }

    public <T> T parseObject(Class<T> r100) {
        return (T) parseObject(r100, null);
    }

    public void setDateFormat(DateFormat r100) {
        this.dateFormat = r100;
    }

    public final void parseArray(Collection r100) {
        parseArray(r100, null);
    }

    public <T> T parseObject(Type r100) {
        return (T) parseObject(r100, null);
    }

    public Object parseObject(Map r100) {
        return parseObject(r100, null);
    }

    public DefaultJSONParser(String r100, ParserConfig r101) {
        this(r100, new JSONScanner(r100, JSON.DEFAULT_PARSER_FEATURE), r101);
    }

    public final void accept(int r100, int r101) {
        JSONLexer r102 = this.lexer;
        if (r102.token() != r100) goto L5;
        r102.nextToken(r101);
        return;
    L5:
        throwException(r100);
    }

    public void checkMapResolve(Map r100, Object r101) {
        if (this.resolveStatus != 1) goto L6;
        ResolveFieldDeserializer r102 = new ResolveFieldDeserializer(r100, r101);
        ResolveTask r103 = getLastResolveTask();
        r103.fieldDeserializer = r102;
        r103.ownerContext = this.context;
        setResolveStatus(0);
        return;
    }

    public void config(Feature r100, boolean r101) {
        this.lexer.config(r100, r101);
    }

    public Object parse(PropertyProcessable r110, Object r111) {
        int r100 = 0;
        if (this.lexer.token() == 12) goto L15;
        String r112 = "syntax error, expect {, actual " + this.lexer.tokenName();
        if ((r111 instanceof String) == false) goto L7;
        r112 = (r112 + ", fieldName ") + r111;
    L7:
        String r113 = (r112 + ", ") + this.lexer.info();
        JSONArray r101 = new JSONArray();
        parseArray(r101, r111);
        if (r101.size() != 1) goto L14;
        Object r114 = r101.get(0);
        if ((r114 instanceof JSONObject) == false) goto L14;
        return (JSONObject) r114;
    L14:
        throw new JSONException(r113);
    L15:
        ParseContext r102 = this.context;
    L94:
        this.lexer.skipWhitespace();     // Catch: Throwable -> L91
        char r103 = this.lexer.getCurrent();     // Catch: Throwable -> L91
        if (this.lexer.isEnabled(Feature.AllowArbitraryCommas) == false) goto L23;
    L19:
        if (r103 != ',') goto L23;
        this.lexer.next();     // Catch: Throwable -> L91
        this.lexer.skipWhitespace();     // Catch: Throwable -> L91
        r103 = this.lexer.getCurrent();     // Catch: Throwable -> L91
    L23:
        if (r103 != '\"') goto L30;
        String r104 = this.lexer.scanSymbol(this.symbolTable, Typography.quote);     // Catch: Throwable -> L91
        this.lexer.skipWhitespace();     // Catch: Throwable -> L91
        if (this.lexer.getCurrent() != ':') goto L28;
    L49:
        this.lexer.next();     // Catch: Throwable -> L91
        this.lexer.skipWhitespace();     // Catch: Throwable -> L91
        this.lexer.getCurrent();     // Catch: Throwable -> L91
        this.lexer.resetStringPosition();     // Catch: Throwable -> L91
        Object r105 = null;
        if (r104 == JSON.DEFAULT_TYPE_KEY) goto L52;
    L68:
        this.lexer.nextToken();     // Catch: Throwable -> L91
        if (r100 == 0) goto L71;
        setContext(r102);     // Catch: Throwable -> L91
    L71:
        Type r106 = r110.getType(r104);     // Catch: Throwable -> L91
        if (this.lexer.token() != 8) goto L74;
        this.lexer.nextToken();     // Catch: Throwable -> L91
    L75:
        r110.apply(r104, r105);     // Catch: Throwable -> L91
        setContext(r102, r105, r104);     // Catch: Throwable -> L91
        setContext(r102);     // Catch: Throwable -> L91
        int r107 = this.lexer.token();     // Catch: Throwable -> L91
        if (r107 == 20) goto L85;
        if (r107 == 15) goto L85;
        if (r107 != 13) goto L84;
        this.lexer.nextToken();     // Catch: Throwable -> L91
        setContext(r102);
        return r110;
    L84:
        r100 = r100 + 1;
    L85:
        setContext(r102);
        return r110;
    L74:
        r105 = parseObject(r106, r104);     // Catch: Throwable -> L91
        goto L75
    L52:
        if (this.lexer.isEnabled(Feature.DisableSpecialKeyDetect) == true) goto L68;
        Class<?> r108 = this.config.checkAutoType(this.lexer.scanSymbol(this.symbolTable, Typography.quote), null, this.lexer.getFeatures());     // Catch: Throwable -> L91
        if (Map.class.isAssignableFrom(r108) == false) goto L60;
        this.lexer.nextToken(16);     // Catch: Throwable -> L91
        if (this.lexer.token() != 13) goto L84;
        this.lexer.nextToken(16);     // Catch: Throwable -> L91
        setContext(r102);
        return r110;
    L60:
        ObjectDeserializer r115 = this.config.getDeserializer(r108);     // Catch: Throwable -> L91
        this.lexer.nextToken(16);     // Catch: Throwable -> L91
        setResolveStatus(2);     // Catch: Throwable -> L91
        if (r102 != null) goto L63;
    L65:
        Map r116 = (Map) r115.deserialze(this, r108, r111);     // Catch: Throwable -> L91
        setContext(r102);
        return r116;
    L63:
        if ((r111 instanceof Integer) == true) goto L65;
        popContext();     // Catch: Throwable -> L91
        goto L65
    L28:
        throw new JSONException("expect ':' at " + this.lexer.pos());     // Catch: Throwable -> L91
    L30:
        if (r103 == '}') goto L31;
        if (r103 != '\'') goto L46;
        if (this.lexer.isEnabled(Feature.AllowSingleQuotes) == false) goto L44;
        r104 = this.lexer.scanSymbol(this.symbolTable, '\'');     // Catch: Throwable -> L91
        this.lexer.skipWhitespace();     // Catch: Throwable -> L91
        if (this.lexer.getCurrent() == ':') goto L49;
        throw new JSONException("expect ':' at " + this.lexer.pos());     // Catch: Throwable -> L91
    L44:
        throw new JSONException("syntax error");     // Catch: Throwable -> L91
    L46:
        if (this.lexer.isEnabled(Feature.AllowUnQuotedFieldNames) == false) goto L90;
        r104 = this.lexer.scanSymbolUnQuoted(this.symbolTable);     // Catch: Throwable -> L91
        this.lexer.skipWhitespace();     // Catch: Throwable -> L91
        char r109 = this.lexer.getCurrent();     // Catch: Throwable -> L91
        if (r109 == ':') goto L49;
        throw new JSONException("expect ':' at " + this.lexer.pos() + ", actual " + r109);     // Catch: Throwable -> L91
    L90:
        throw new JSONException("syntax error");     // Catch: Throwable -> L91
    L31:
        this.lexer.next();     // Catch: Throwable -> L91
        this.lexer.resetStringPosition();     // Catch: Throwable -> L91
        this.lexer.nextToken(16);     // Catch: Throwable -> L91
        setContext(r102);
        return r110;
    L91:
        th = move-exception;
        setContext(r102);
        throw th;
    }

    public final void parseArray(Collection r110, Object r111) {
        JSONLexer r100 = this.lexer;
        if (r100.token() != 21) goto L5;
    L6:
        r100.nextToken();
    L8:
        if (r100.token() != 14) goto L80;
        r100.nextToken(4);
        ParseContext r101 = this.context;
        if (r101 != null) goto L12;
    L16:
        setContext(r110, r111);
        int r102 = 0;
    L81:
    L74:
        e = move-exception;
        throw new JSONException("unkown error", e);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        setContext(r101);
        throw th;
    L18:
        if (r100.isEnabled(Feature.AllowArbitraryCommas) == true) goto L20;
    L22:
        int r103 = r100.token();     // Catch: Throwable -> L72 ClassCastException -> L74
        if (r103 != 2) goto L25;
        Number r104 = r100.integerValue();     // Catch: Throwable -> L72 ClassCastException -> L74
        r100.nextToken(16);     // Catch: Throwable -> L72 ClassCastException -> L74
        Object r105 = r104;
    L68:
        r110.add(r105);     // Catch: Throwable -> L72 ClassCastException -> L74
        checkListResolve(r110);     // Catch: Throwable -> L72 ClassCastException -> L74
        if (r100.token() != 16) goto L71;
        r100.nextToken(4);     // Catch: Throwable -> L72 ClassCastException -> L74
    L71:
        r102 = r102 + 1;
        goto L81
    L25:
        if (r103 == 3) goto L63;
        if (r103 != 4) goto L28;
        String r106 = r100.stringVal();     // Catch: Throwable -> L72 ClassCastException -> L74
        r100.nextToken(16);     // Catch: Throwable -> L72 ClassCastException -> L74
        r105 = r106;
        if (r100.isEnabled(Feature.AllowISO8601DateFormat) == false) goto L68;
        JSONScanner r107 = new JSONScanner(r106);     // Catch: Throwable -> L72 ClassCastException -> L74
        Object r108 = r106;
        if (r107.scanISO8601DateIfMatch() == false) goto L61;
        r108 = r107.getCalendar().getTime();     // Catch: Throwable -> L72 ClassCastException -> L74
    L61:
        r107.close();     // Catch: Throwable -> L72 ClassCastException -> L74
        r105 = r108;
        goto L68
    L28:
        if (r103 != 6) goto L30;
        Boolean r109 = Boolean.TRUE;     // Catch: Throwable -> L72 ClassCastException -> L74
        r100.nextToken(16);     // Catch: Throwable -> L72 ClassCastException -> L74
        r105 = r109;
        goto L68
    L30:
        if (r103 == 7) goto L54;
        r105 = null;
        r105 = null;
        if (r103 != 8) goto L34;
        r100.nextToken(4);     // Catch: Throwable -> L72 ClassCastException -> L74
        goto L68
    L34:
        if (r103 != 12) goto L36;
        r105 = parseObject(new JSONObject(r100.isEnabled(Feature.OrderedField)), Integer.valueOf(r102));     // Catch: Throwable -> L72 ClassCastException -> L74
        goto L68
    L36:
        if (r103 == 20) goto L51;
        if (r103 == 23) goto L49;
        if (r103 != 14) goto L41;
        JSONArray r112 = new JSONArray();     // Catch: Throwable -> L72 ClassCastException -> L74
        parseArray(r112, Integer.valueOf(r102));     // Catch: Throwable -> L72 ClassCastException -> L74
        r105 = r112;
        if (r100.isEnabled(Feature.UseObjectArray) == false) goto L68;
        r105 = r112.toArray();     // Catch: Throwable -> L72 ClassCastException -> L74
        goto L68
    L41:
        if (r103 == 15) goto L43;
        r105 = parse();     // Catch: Throwable -> L72 ClassCastException -> L74
        goto L68
    L43:
        r100.nextToken(16);     // Catch: Throwable -> L72 ClassCastException -> L74
        setContext(r101);
        return;
    L49:
        r100.nextToken(4);     // Catch: Throwable -> L72 ClassCastException -> L74
        goto L68
    L51:
        throw new JSONException("unclosed jsonArray");     // Catch: Throwable -> L72 ClassCastException -> L74
    L54:
        Boolean r113 = Boolean.FALSE;     // Catch: Throwable -> L72 ClassCastException -> L74
        r100.nextToken(16);     // Catch: Throwable -> L72 ClassCastException -> L74
        r105 = r113;
        goto L68
    L63:
        if (r100.isEnabled(Feature.UseBigDecimal) == false) goto L65;
        Number r114 = r100.decimalValue(true);     // Catch: Throwable -> L72 ClassCastException -> L74
    L66:
        r105 = r114;
        r100.nextToken(16);     // Catch: Throwable -> L72 ClassCastException -> L74
        goto L68
    L65:
        r114 = r100.decimalValue(false);     // Catch: Throwable -> L72 ClassCastException -> L74
    L20:
        if (r100.token() != 16) goto L22;
        r100.nextToken();     // Catch: Throwable -> L72 ClassCastException -> L74
        goto L20
    L12:
        if (r101.level <= 512) goto L16;
        throw new JSONException("array level > 512");
    L80:
        throw new JSONException("syntax error, expect [, actual " + JSONToken.name(r100.token()) + ", pos " + r100.pos() + ", fieldName " + r111);
    L5:
        if (r100.token() != 22) goto L8;
        goto L6
    }

    public void parseExtra(Object r100, String r101) {
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> r102 = this.extraTypeProviders;
        Type r103 = null;
        if (r102 == null) goto L8;
        Iterator<ExtraTypeProvider> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r103 = r104.next().getExtraType(r100, r101);
    L8:
        if (r103 != null) goto L10;
        Object r105 = parse();
    L12:
        if ((r100 instanceof ExtraProcessable) == false) goto L15;
        ((ExtraProcessable) r100).processExtra(r101, r105);
        return;
    L15:
        List<ExtraProcessor> r106 = this.extraProcessors;
        if (r106 == null) goto L22;
        Iterator<ExtraProcessor> r107 = r106.iterator();
    L19:
        if (r107.hasNext() == false) goto L22;
        r107.next().processExtra(r100, r101, r105);
    L22:
        if (this.resolveStatus != 1) goto L27;
        this.resolveStatus = 0;
        return;
    L27:
        return;
    L10:
        r105 = parseObject(r103);
        goto L12
    }

    public final Object parseObject(Map r110, Object r111) {
        JSONLexer r100 = this.lexer;
        if (r100.token() != 8) goto L7;
        r100.nextToken();
        return null;
    L7:
        if (r100.token() != 13) goto L11;
        r100.nextToken();
        return r110;
    L11:
        if (r100.token() != 4) goto L17;
        if (r100.stringVal().length() != 0) goto L17;
        r100.nextToken();
        return r110;
    L17:
        if (r100.token() != 12) goto L19;
    L23:
        ParseContext r101 = this.context;
        boolean r102 = r110 instanceof JSONObject;     // Catch: Throwable -> L388
        if (r102 == false) goto L27;
        Map r112 = ((JSONObject) r110).getInnerMap();     // Catch: Throwable -> L388
    L28:
        boolean r113 = false;
    L29:
        r100.skipWhitespace();     // Catch: Throwable -> L388
        char r114 = r100.getCurrent();     // Catch: Throwable -> L388
        if (r100.isEnabled(Feature.AllowArbitraryCommas) == false) goto L34;
    L31:
        if (r114 != ',') goto L34;
        r100.next();     // Catch: Throwable -> L388
        r100.skipWhitespace();     // Catch: Throwable -> L388
        r114 = r100.getCurrent();     // Catch: Throwable -> L388
    L34:
        boolean r115 = true;
        if (r114 != '\"') goto L42;
        Object r116 = r100.scanSymbol(this.symbolTable, Typography.quote);     // Catch: Throwable -> L388
        r100.skipWhitespace();     // Catch: Throwable -> L388
        if (r100.getCurrent() != ':') goto L40;
    L38:
        boolean r103 = false;
    L114:
        if (r103 == true) goto L116;
        r100.next();     // Catch: Throwable -> L388
        r100.skipWhitespace();     // Catch: Throwable -> L388
    L116:
        char r104 = r100.getCurrent();     // Catch: Throwable -> L388
        r100.resetStringPosition();     // Catch: Throwable -> L388
        if (r116 != JSON.DEFAULT_TYPE_KEY) goto L199;
        if (r100.isEnabled(Feature.DisableSpecialKeyDetect) == true) goto L199;
        String r105 = r100.scanSymbol(this.symbolTable, Typography.quote);     // Catch: Throwable -> L388
        if (r100.isEnabled(Feature.IgnoreAutoType) == true) goto L29;
        if (r110 == null) goto L128;
        if (r110.getClass().getName().equals(r105) == false) goto L128;
        Class<?> r106 = r110.getClass();     // Catch: Throwable -> L388
    L130:
        Object r117 = null;
    L147:
        if (r106 != null) goto L149;
        r112.put(JSON.DEFAULT_TYPE_KEY, r105);     // Catch: Throwable -> L388
        goto L29
    L149:
        r100.nextToken(16);     // Catch: Throwable -> L388
        if (r100.token() != 13) goto L172;
        r100.nextToken(16);     // Catch: Throwable -> L388
    L169:
        e = move-exception;
        throw new JSONException("create instance error", e);     // Catch: Throwable -> L388
    L153:
        if ((this.config.getDeserializer(r106) instanceof JavaBeanDeserializer) == false) goto L155;
        Object r107 = TypeUtils.cast(r110, r106, this.config);     // Catch: Exception -> L169 Throwable -> L388
    L156:
        if (r107 == null) goto L158;
    L167:
        setContext(r101);
        return r107;
    L158:
        if (r106 != Cloneable.class) goto L161;
        r107 = new HashMap();     // Catch: Exception -> L169 Throwable -> L388
        goto L167
    L161:
        if ("java.util.Collections$EmptyMap".equals(r105) == false) goto L164;
        r107 = Collections.emptyMap();     // Catch: Exception -> L169 Throwable -> L388
        goto L167
    L164:
        if ("java.util.Collections$UnmodifiableMap".equals(r105) == false) goto L166;
        r107 = Collections.unmodifiableMap(new HashMap());     // Catch: Exception -> L169 Throwable -> L388
        goto L167
    L166:
        r107 = r106.newInstance();     // Catch: Exception -> L169 Throwable -> L388
        goto L167
    L155:
        r107 = r117;
        goto L156
    L172:
        setResolveStatus(2);     // Catch: Throwable -> L388
        ParseContext r108 = this.context;     // Catch: Throwable -> L388
        if (r108 == null) goto L181;
        if (r111 == null) goto L181;
        if ((r111 instanceof Integer) == true) goto L181;
        if ((r108.fieldName instanceof Integer) == true) goto L181;
        popContext();     // Catch: Throwable -> L388
    L181:
        if (r110.size() <= 0) goto L185;
        Object r109 = TypeUtils.cast(r110, r106, this.config);     // Catch: Throwable -> L388
        setResolveStatus(0);     // Catch: Throwable -> L388
        parseObject(r109);     // Catch: Throwable -> L388
        setContext(r101);
        return r109;
    L185:
        ObjectDeserializer r118 = this.config.getDeserializer(r106);     // Catch: Throwable -> L388
        Class<?> r119 = r118.getClass();     // Catch: Throwable -> L388
        if (JavaBeanDeserializer.class.isAssignableFrom(r119) == false) goto L193;
        if (r119 == JavaBeanDeserializer.class) goto L193;
        if (r119 == ThrowableDeserializer.class) goto L193;
        setResolveStatus(0);     // Catch: Throwable -> L388
    L195:
        Object r120 = r118.deserialze(this, r106, r111);     // Catch: Throwable -> L388
        setContext(r101);
        return r120;
    L193:
        if ((r118 instanceof MapDeserializer) == false) goto L195;
        setResolveStatus(0);     // Catch: Throwable -> L388
    L128:
        if ("java.util.HashMap".equals(r105) == false) goto L132;
        r106 = HashMap.class;
        goto L130
    L132:
        if ("java.util.LinkedHashMap".equals(r105) == false) goto L134;
        r106 = LinkedHashMap.class;
        goto L130
    L134:
        int r121 = 0;
    L136:
        if (r121 >= r105.length()) goto L144;
        char r122 = r105.charAt(r121);     // Catch: Throwable -> L388
        if (r122 < '0') goto L143;
        if (r122 > '9') goto L143;
        r121 = r121 + 1;     // Catch: Throwable -> L388
    L143:
        r115 = false;
    L144:
        if (r115 == true) goto L146;
        r117 = null;
        r106 = this.config.checkAutoType(r105, null, r100.getFeatures());     // Catch: Throwable -> L388
        goto L147
    L146:
        r117 = null;
        r106 = null;
    L199:
        if (r116 != "$ref") goto L256;
        if (r101 == null) goto L256;
        if (r110 == null) goto L205;
        if (r110.size() != 0) goto L256;
    L205:
        if (r100.isEnabled(Feature.DisableSpecialKeyDetect) == true) goto L256;
        r100.nextToken(4);     // Catch: Throwable -> L388
        if (r100.token() != 4) goto L254;
        String r123 = r100.stringVal();     // Catch: Throwable -> L388
        r100.nextToken(13);     // Catch: Throwable -> L388
        if (r100.token() != 16) goto L213;
        r112.put(r116, r123);     // Catch: Throwable -> L388
        goto L29
    L213:
        if ("@".equals(r123) == false) goto L226;
        ParseContext r124 = this.context;     // Catch: Throwable -> L388
        if (r124 == null) goto L244;
        Object r125 = r124.object;     // Catch: Throwable -> L388
        if ((r125 instanceof Object[]) == false) goto L219;
    L224:
        Object r126 = r125;
    L247:
        if (r100.token() != 13) goto L252;
        r100.nextToken(16);     // Catch: Throwable -> L388
        setContext(r101);
        return r126;
    L252:
        throw new JSONException("syntax error, " + r100.info());     // Catch: Throwable -> L388
    L219:
        if ((r125 instanceof Collection) == true) goto L224;
        ParseContext r127 = r124.parent;     // Catch: Throwable -> L388
        if (r127 == null) goto L244;
        r126 = r127.object;     // Catch: Throwable -> L388
    L244:
        r126 = null;
        goto L247
    L226:
        if (DownloadConstants.VULNERABILITY_PATH.equals(r123) == false) goto L232;
        Object r128 = r101.object;     // Catch: Throwable -> L388
        if (r128 == null) goto L230;
        r126 = r128;
        goto L247
    L230:
        addResolveTask(new ResolveTask(r101, r123));     // Catch: Throwable -> L388
        setResolveStatus(1);     // Catch: Throwable -> L388
        goto L244
    L232:
        if ("$".equals(r123) == false) goto L242;
        ParseContext r129 = r101;
    L234:
        ParseContext r130 = r129.parent;     // Catch: Throwable -> L388
        if (r130 == null) goto L237;
        r129 = r130;
        goto L234
    L237:
        r125 = r129.object;     // Catch: Throwable -> L388
        if (r125 != null) goto L224;
        addResolveTask(new ResolveTask(r129, r123));     // Catch: Throwable -> L388
        setResolveStatus(1);     // Catch: Throwable -> L388
        goto L244
    L242:
        if (JSONPath.compile(r123).isRef() == false) goto L245;
        addResolveTask(new ResolveTask(r101, r123));     // Catch: Throwable -> L388
        setResolveStatus(1);     // Catch: Throwable -> L388
        goto L244
    L245:
        r126 = new JSONObject().fluentPut("$ref", r123);     // Catch: Throwable -> L388
        goto L247
    L254:
        throw new JSONException("illegal ref, " + JSONToken.name(r100.token()));     // Catch: Throwable -> L388
    L256:
        if (r113 == true) goto L269;
        ParseContext r131 = this.context;     // Catch: Throwable -> L388
        if (r131 != null) goto L260;
    L264:
        ParseContext r132 = setContext(r110, r111);     // Catch: Throwable -> L388
        if (r101 != null) goto L267;
        r101 = r132;
    L267:
        r113 = true;
        goto L269
    L260:
        if (r111 != r131.fieldName) goto L264;
        if (r110 != r131.object) goto L264;
        r101 = r131;
    L269:
        if (r110.getClass() != JSONObject.class) goto L273;
        if (r116 != null) goto L273;
        r116 = "null";
    L273:
        if (r104 != '\"') goto L282;
        r100.scanString();     // Catch: Throwable -> L388
        String r133 = r100.stringVal();     // Catch: Throwable -> L388
        Object r134 = r133;
        if (r100.isEnabled(Feature.AllowISO8601DateFormat) == false) goto L280;
        JSONScanner r135 = new JSONScanner(r133);     // Catch: Throwable -> L388
        Object r136 = r133;
        if (r135.scanISO8601DateIfMatch() == false) goto L279;
        r136 = r135.getCalendar().getTime();     // Catch: Throwable -> L388
    L279:
        r135.close();     // Catch: Throwable -> L388
        r134 = r136;
    L280:
        r112.put(r116, r134);     // Catch: Throwable -> L388
        Object r137 = r134;
    L292:
        r100.skipWhitespace();     // Catch: Throwable -> L388
        char r138 = r100.getCurrent();     // Catch: Throwable -> L388
        if (r138 != ',') goto L297;
        r100.next();     // Catch: Throwable -> L388
        goto L29
    L297:
        if (r138 != '}') goto L302;
        r100.next();     // Catch: Throwable -> L388
        r100.resetStringPosition();     // Catch: Throwable -> L388
        r100.nextToken();     // Catch: Throwable -> L388
        setContext(r137, r116);     // Catch: Throwable -> L388
        setContext(r101);
        return r110;
    L302:
        throw new JSONException("syntax error, position at " + r100.pos() + ", name " + r116);     // Catch: Throwable -> L388
    L282:
        if (r104 < '0') goto L286;
        if (r104 > '9') goto L286;
    L287:
        r100.scanNumber();     // Catch: Throwable -> L388
        if (r100.token() != 2) goto L290;
        Number r139 = r100.integerValue();     // Catch: Throwable -> L388
    L291:
        r112.put(r116, r139);     // Catch: Throwable -> L388
        r137 = r139;
        goto L292
    L290:
        r139 = r100.decimalValue(r100.isEnabled(Feature.UseBigDecimal));     // Catch: Throwable -> L388
    L286:
        if (r104 == '-') goto L287;
        if (r104 != '[') goto L324;
        r100.nextToken();     // Catch: Throwable -> L388
        JSONArray r140 = new JSONArray();     // Catch: Throwable -> L388
        if (r111 == null) goto L308;
        r111.getClass();     // Catch: Throwable -> L388
    L308:
        if (r111 != null) goto L310;
        setContext(r101);     // Catch: Throwable -> L388
    L310:
        parseArray(r140, r116);     // Catch: Throwable -> L388
        JSONArray r141 = r140;
        if (r100.isEnabled(Feature.UseObjectArray) == false) goto L313;
        r141 = r140.toArray();     // Catch: Throwable -> L388
    L313:
        r112.put(r116, r141);     // Catch: Throwable -> L388
        if (r100.token() == 13) goto L315;
        if (r100.token() == 16) goto L29;
        throw new JSONException("syntax error");     // Catch: Throwable -> L388
    L315:
        r100.nextToken();     // Catch: Throwable -> L388
        setContext(r101);
        return r110;
    L324:
        if (r104 != '{') goto L372;
        r100.nextToken();     // Catch: Throwable -> L388
        if (r111 != null) goto L328;
    L330:
        boolean r142 = false;
    L332:
        if (r100.isEnabled(Feature.CustomMapDeserializer) == false) goto L337;
        MapDeserializer r143 = (MapDeserializer) this.config.getDeserializer(Map.class);     // Catch: Throwable -> L388
        if ((r100.getFeatures() & Feature.OrderedField.mask) == 0) goto L336;
        Map r144 = r143.createMap(Map.class, r100.getFeatures());     // Catch: Throwable -> L388
    L338:
        if (r142 == true) goto L340;
        ParseContext r145 = setContext(this.context, r144, r116);     // Catch: Throwable -> L388
    L342:
        if (this.fieldTypeResolver == null) goto L349;
        if (r116 == null) goto L345;
        String r146 = r116.toString();     // Catch: Throwable -> L388
    L346:
        Type r147 = this.fieldTypeResolver.resolve(r110, r146);     // Catch: Throwable -> L388
        if (r147 == null) goto L349;
        Object r148 = this.config.getDeserializer(r147).deserialze(this, r147, r116);     // Catch: Throwable -> L388
        boolean r149 = true;
    L350:
        if (r149 == true) goto L352;
        r148 = parseObject(r144, r116);     // Catch: Throwable -> L388
    L352:
        if (r145 == null) goto L355;
        if (r144 == r148) goto L355;
        r145.object = r110;     // Catch: Throwable -> L388
    L355:
        if (r116 == null) goto L357;
        checkMapResolve(r110, r116.toString());     // Catch: Throwable -> L388
    L357:
        r112.put(r116, r148);     // Catch: Throwable -> L388
        if (r142 == false) goto L361;
        setContext(r148, r116);     // Catch: Throwable -> L388
    L361:
        if (r100.token() == 13) goto L362;
        if (r100.token() != 16) goto L371;
        if (r142 == false) goto L369;
        popContext();     // Catch: Throwable -> L388
        goto L29
    L369:
        setContext(r101);     // Catch: Throwable -> L388
        goto L29
    L371:
        throw new JSONException("syntax error, " + r100.tokenName());     // Catch: Throwable -> L388
    L362:
        r100.nextToken();     // Catch: Throwable -> L388
        setContext(r101);     // Catch: Throwable -> L388
        setContext(r101);
        return r110;
    L345:
        r146 = null;
    L349:
        r149 = false;
        r148 = null;
        goto L350
    L340:
        r145 = null;
        goto L342
    L336:
        r144 = r143.createMap(Map.class);     // Catch: Throwable -> L388
        goto L338
    L337:
        r144 = new JSONObject(r100.isEnabled(Feature.OrderedField));     // Catch: Throwable -> L388
        goto L338
    L328:
        if (r111.getClass() != Integer.class) goto L330;
        r142 = true;
        goto L332
    L372:
        r100.nextToken();     // Catch: Throwable -> L388
        r112.put(r116, parse());     // Catch: Throwable -> L388
        if (r100.token() == 13) goto L374;
        if (r100.token() == 16) goto L29;
        throw new JSONException("syntax error, position at " + r100.pos() + ", name " + r116);     // Catch: Throwable -> L388
    L374:
        r100.nextToken();     // Catch: Throwable -> L388
        setContext(r101);
        return r110;
    L40:
        throw new JSONException("expect ':' at " + r100.pos() + ", name " + r116);     // Catch: Throwable -> L388
    L42:
        if (r114 == '}') goto L43;
        if (r114 != '\'') goto L69;
        if (r100.isEnabled(Feature.AllowSingleQuotes) == false) goto L67;
        r116 = r100.scanSymbol(this.symbolTable, '\'');     // Catch: Throwable -> L388
        r100.skipWhitespace();     // Catch: Throwable -> L388
        if (r100.getCurrent() == ':') goto L38;
        throw new JSONException("expect ':' at " + r100.pos());     // Catch: Throwable -> L388
    L67:
        throw new JSONException("syntax error");     // Catch: Throwable -> L388
    L69:
        if (r114 == 26) goto L387;
        if (r114 == ',') goto L385;
        if (r114 < '0') goto L77;
        if (r114 > '9') goto L77;
    L78:
        r100.resetStringPosition();     // Catch: Throwable -> L388
        r100.scanNumber();     // Catch: Throwable -> L388
        if (r100.token() != 2) goto L82;
        Object r150 = r100.integerValue();     // Catch: NumberFormatException -> L95 Throwable -> L388
    L84:
        if (r100.isEnabled(Feature.NonStringKeyAsString) == true) goto L88;
        if (r102 == true) goto L88;
    L87:
        r116 = r150;
        if (r100.getCurrent() == ':') goto L38;
        throw new JSONException("parse number key error" + r100.info());     // Catch: Throwable -> L388
    L88:
        r150 = r150.toString();     // Catch: NumberFormatException -> L95 Throwable -> L388
        goto L87
    L82:
        r150 = r100.decimalValue(true);     // Catch: NumberFormatException -> L95 Throwable -> L388
        goto L84
    L96:
        throw new JSONException("parse number key error" + r100.info());     // Catch: Throwable -> L388
    L77:
        if (r114 == '-') goto L78;
        if (r114 != '{') goto L100;
    L111:
        int r151 = this.objectKeyLevel;     // Catch: Throwable -> L388
        this.objectKeyLevel = r151 + 1;     // Catch: Throwable -> L388
        if (r151 > 512) goto L383;
        r100.nextToken();     // Catch: Throwable -> L388
        r116 = parse();     // Catch: Throwable -> L388
        r103 = true;
        goto L114
    L383:
        throw new JSONException("object key level > 512");     // Catch: Throwable -> L388
    L100:
        if (r114 == '[') goto L111;
        if (r100.isEnabled(Feature.AllowUnQuotedFieldNames) == false) goto L110;
        r116 = r100.scanSymbolUnQuoted(this.symbolTable);     // Catch: Throwable -> L388
        r100.skipWhitespace();     // Catch: Throwable -> L388
        char r152 = r100.getCurrent();     // Catch: Throwable -> L388
        if (r152 == ':') goto L38;
        throw new JSONException("expect ':' at " + r100.pos() + ", actual " + r152);     // Catch: Throwable -> L388
    L110:
        throw new JSONException("syntax error");     // Catch: Throwable -> L388
    L385:
        throw new JSONException("syntax error");     // Catch: Throwable -> L388
    L387:
        throw new JSONException("syntax error");     // Catch: Throwable -> L388
    L43:
        r100.next();     // Catch: Throwable -> L388
        r100.resetStringPosition();     // Catch: Throwable -> L388
        r100.nextToken();     // Catch: Throwable -> L388
        if (r113 == true) goto L55;
        ParseContext r153 = this.context;     // Catch: Throwable -> L388
        if (r153 != null) goto L48;
    L52:
        ParseContext r154 = setContext(r110, r111);     // Catch: Throwable -> L388
        if (r101 != null) goto L55;
        r101 = r154;
        goto L55
    L48:
        if (r111 != r153.fieldName) goto L52;
        if (r110 != r153.object) goto L52;
        r101 = r153;
    L55:
        setContext(r101);
        return r110;
    L27:
        r112 = r110;
    L388:
        th = move-exception;
        setContext(r101);
        throw th;
    L19:
        if (r100.token() == 16) goto L23;
        throw new JSONException("syntax error, expect {, actual " + r100.tokenName() + ", " + r100.info());
    }

    public ParseContext setContext(Object r100, Object r101) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect) == false) goto L7;
        return null;
    L7:
        return setContext(this.context, r100, r101);
    }

    public DefaultJSONParser(JSONLexer r100, ParserConfig r101) {
        this(null, r100, r101);
    }

    public void parseArray(Type r100, Collection r101) {
        parseArray(r100, r101, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type r100, Object r101) {
        int r102 = this.lexer.token();
        if (r102 != 8) goto L7;
        this.lexer.nextToken();
        return (T) TypeUtils.optionalEmpty(r100);
    L7:
        if (r102 == 4) goto L9;
    L16:
        ObjectDeserializer r103 = this.config.getDeserializer(r100);
    L33:
        e = move-exception;
        throw e;
    L30:
        th = move-exception;
        throw new JSONException(th.getMessage(), th);
    L18:
        if (r103.getClass() != JavaBeanDeserializer.class) goto L29;
        if (this.lexer.token() == 12) goto L27;
        if (this.lexer.token() == 14) goto L27;
        throw new JSONException("syntax error,expect start with { or [,but actually start with " + this.lexer.tokenName());     // Catch: Throwable -> L30 JSONException -> L33
    L27:
        return (T) ((JavaBeanDeserializer) r103).deserialze(this, r100, r101, 0);
    L29:
        return (T) r103.deserialze(this, r100, r101);
    L9:
        if (r100 != byte[].class) goto L13;
        T r104 = (T) this.lexer.bytesValue();
        this.lexer.nextToken();
        return r104;
    L13:
        if (r100 != char[].class) goto L16;
        String r105 = this.lexer.stringVal();
        this.lexer.nextToken();
        return (T) r105.toCharArray();
    }

    public void parseArray(Class<?> r100, Collection r101) {
        parseArray(r100, r101);
    }

    public DefaultJSONParser(Object r100, JSONLexer r101, ParserConfig r102) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.objectKeyLevel = 0;
        this.autoTypeAccept = null;
        this.lexer = r101;
        this.input = r100;
        this.config = r102;
        this.symbolTable = r102.symbolTable;
        char r103 = r101.getCurrent();
        if (r103 != '{') goto L6;
        r101.next();
        ((JSONLexerBase) r101).token = 12;
        return;
    L6:
        if (r103 != '[') goto L8;
        r101.next();
        ((JSONLexerBase) r101).token = 14;
        return;
    L8:
        r101.nextToken();
    }

    public void parseArray(Type r100, Collection r101, Object r110) {
        int r102 = this.lexer.token();
        if (r102 != 21) goto L5;
    L6:
        this.lexer.nextToken();
        r102 = this.lexer.token();
    L8:
        if (r102 != 14) goto L53;
        if (Integer.TYPE != r100) goto L13;
        ObjectDeserializer r103 = IntegerCodec.instance;
        this.lexer.nextToken(2);
    L16:
        ParseContext r104 = this.context;
        setContext(r101, r110);
        int r111 = 0;
    L54:
        if (this.lexer.isEnabled(Feature.AllowArbitraryCommas) == false) goto L24;
    L20:
        if (this.lexer.token() != 16) goto L24;
        this.lexer.nextToken();     // Catch: Throwable -> L49
    L24:
        if (this.lexer.token() == 15) goto L25;
        Object r105 = null;
        if (Integer.TYPE != r100) goto L31;
        r101.add(IntegerCodec.instance.deserialze(this, null, null));     // Catch: Throwable -> L49
    L46:
        if (this.lexer.token() != 16) goto L48;
        this.lexer.nextToken(r103.getFastMatchToken());     // Catch: Throwable -> L49
    L48:
        r111 = r111 + 1;
        goto L54
    L31:
        if (String.class != r100) goto L41;
        if (this.lexer.token() != 4) goto L35;
        r105 = this.lexer.stringVal();     // Catch: Throwable -> L49
        this.lexer.nextToken(16);     // Catch: Throwable -> L49
    L39:
        r101.add(r105);     // Catch: Throwable -> L49
        goto L46
    L35:
        Object r106 = parse();     // Catch: Throwable -> L49
        if (r106 == null) goto L39;
        r105 = r106.toString();     // Catch: Throwable -> L49
        goto L39
    L41:
        if (this.lexer.token() != 8) goto L43;
        this.lexer.nextToken();     // Catch: Throwable -> L49
    L44:
        r101.add(r105);     // Catch: Throwable -> L49
        checkListResolve(r101);     // Catch: Throwable -> L49
        goto L46
    L43:
        r105 = r103.deserialze(this, r100, Integer.valueOf(r111));     // Catch: Throwable -> L49
        goto L44
    L25:
        setContext(r104);
        this.lexer.nextToken(16);
        return;
    L49:
        th = move-exception;
        setContext(r104);
        throw th;
    L13:
        if (String.class != r100) goto L15;
        r103 = StringCodec.instance;
        this.lexer.nextToken(4);
        goto L16
    L15:
        r103 = this.config.getDeserializer(r100);
        this.lexer.nextToken(r103.getFastMatchToken());
        goto L16
    L53:
        throw new JSONException("field " + r110 + " expect '[', but " + JSONToken.name(r102) + ", " + this.lexer.info());
    L5:
        if (r102 != 22) goto L8;
        goto L6
    }

    public ParseContext setContext(ParseContext r100, Object r101, Object r102) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect) == false) goto L6;
        return null;
    L6:
        ParseContext r103 = new ParseContext(r100, r101, r102);
        this.context = r103;
        addContext(r103);
        return this.context;
    }

    public DefaultJSONParser(String r100, ParserConfig r101, int r102) {
        this(r100, new JSONScanner(r100, r102), r101);
    }

    public DefaultJSONParser(char[] r100, int r101, ParserConfig r102, int r103) {
        this(r100, new JSONScanner(r100, r101, r103), r102);
    }
}
