package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.tmall.wireless.tangram.expression.TangramExprSupport;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public ParserConfig config;
    protected ParseContext contex;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    protected List<ExtraProcessor> extraProcessors;
    protected List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    public static class ResolveTask {
        private final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        private final String referenceValue;

        public ResolveTask(ParseContext r10, String r11) {
            this.context = r10;
            this.referenceValue = r11;
        }

        public static /* synthetic */ String access$000(ResolveTask r10) {
            return r10.referenceValue;
        }

        public static /* synthetic */ ParseContext access$100(ResolveTask r10) {
            return r10.context;
        }
    }

    public DefaultJSONParser(String r10) {
        this(r10, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE);
    }

    public final void accept(int r10) {
        JSONLexer r11 = this.lexer;
        if (r11.token != r10) goto L7;
        r11.nextToken();
        return;
    L7:
        throw new JSONException("syntax error, expect " + JSONToken.name(r10) + ", actual " + JSONToken.name(this.lexer.token));
    }

    public void addResolveTask(ResolveTask r10) {
        if (this.resolveTaskList != null) goto L5;
        this.resolveTaskList = new ArrayList(2);
    L5:
        this.resolveTaskList.add(r10);
    }

    public void checkListResolve(Collection r10) {
        if ((r10 instanceof List) == false) goto L5;
        ResolveTask r11 = getLastResolveTask();
        r11.fieldDeserializer = new ResolveFieldDeserializer(this, (List) r10, r10.size() - 1);
        r11.ownerContext = this.contex;
        this.resolveStatus = 0;
        return;
    L5:
        ResolveTask r12 = getLastResolveTask();
        r12.fieldDeserializer = new ResolveFieldDeserializer(r10);
        r12.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    public void checkMapResolve(Map r10, Object r11) {
        ResolveFieldDeserializer r12 = new ResolveFieldDeserializer(r10, r11);
        ResolveTask r13 = getLastResolveTask();
        r13.fieldDeserializer = r12;
        r13.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer r10 = this.lexer;     // Catch: Throwable -> L9
        if (r10.token != 20) goto L8;
        r10.close();
        return;
    L8:
        throw new JSONException("not close json text, token : " + JSONToken.name(this.lexer.token));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.lexer.close();
        throw th;
    }

    public void config(Feature r10, boolean r11) {
        this.lexer.config(r10, r11);
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat != null) goto L6;
        SimpleDateFormat r10 = new SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
        this.dateFormat = r10;
        r10.setTimeZone(this.lexer.timeZone);
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

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> r10 = this.resolveTaskList;
        return r10.get(r10.size() - 1);
    }

    public void handleResovleTask(Object r10) {
        List<ResolveTask> r11 = this.resolveTaskList;
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = r11.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L26;
        ResolveTask r14 = this.resolveTaskList.get(r13);
        FieldDeserializer r15 = r14.fieldDeserializer;
        if (r15 == null) goto L25;
        ParseContext r16 = r14.ownerContext;
        Object r17 = null;
        if (r16 == null) goto L13;
        Object r18 = r16.object;
    L14:
        String r19 = ResolveTask.access$000(r14);
        if (r19.startsWith(TangramExprSupport.VAR_START) == false) goto L23;
        int r20 = 0;
    L18:
        if (r20 >= this.contextArrayIndex) goto L24;
        if (r19.equals(this.contextArray[r20].toString()) == false) goto L22;
        r17 = this.contextArray[r20].object;
    L22:
        r20 = r20 + 1;
    L24:
        r15.setValue(r18, r17);
        goto L25
    L23:
        r17 = ResolveTask.access$100(r14).object;
        goto L24
    L13:
        r18 = null;
    L25:
        r13 = r13 + 1;
        goto L6
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> r10) {
        ArrayList r11 = new ArrayList();
        parseArray(r10, r11);
        return r11;
    }

    public Object parseArrayWithType(Type r10) {
        JSONLexer r11 = this.lexer;
        if (r11.token != 8) goto L6;
        r11.nextToken();
        return null;
    L6:
        Type[] r12 = ((ParameterizedType) r10).getActualTypeArguments();
        if (r12.length != 1) goto L41;
        Type r13 = r12[0];
        if ((r13 instanceof Class) == false) goto L13;
        ArrayList r14 = new ArrayList();
        parseArray((Class) r13, r14);
        return r14;
    L13:
        if ((r13 instanceof WildcardType) == false) goto L25;
        WildcardType r15 = (WildcardType) r13;
        Type r16 = r15.getUpperBounds()[0];
        if (Object.class.equals(r16) == true) goto L17;
        ArrayList r17 = new ArrayList();
        parseArray((Class) r16, r17);
        return r17;
    L17:
        if (r15.getLowerBounds().length != 0) goto L21;
        return parse();
    L21:
        throw new JSONException("not support type : " + r10);
    L25:
        if ((r13 instanceof TypeVariable) == false) goto L35;
        TypeVariable r18 = (TypeVariable) r13;
        Type[] r19 = r18.getBounds();
        if (r19.length != 1) goto L33;
        Type r20 = r19[0];
        if ((r20 instanceof Class) == false) goto L35;
        ArrayList r21 = new ArrayList();
        parseArray((Class) r20, r21);
        return r21;
    L33:
        throw new JSONException("not support : " + r18);
    L35:
        if ((r13 instanceof ParameterizedType) == false) goto L39;
        ArrayList r22 = new ArrayList();
        parseArray((ParameterizedType) r13, r22);
        return r22;
    L39:
        throw new JSONException("TODO : " + r10);
    L41:
        throw new JSONException("not support type " + r10);
    }

    public final Object parseObject(Map r20, Object r21) {
        String r10 = "parse number key error, ";
        JSONLexer r11 = this.lexer;
        int r12 = r11.token;
        if (r12 != 8) goto L7;
        r11.nextToken();
        return null;
    L7:
        if (r12 == 12) goto L13;
        if (r12 == 16) goto L13;
        throw new JSONException("syntax error, expect {, actual " + JSONToken.name(r12) + ", " + r11.info());
    L13:
        if ((r20 instanceof JSONObject) == false) goto L15;
        Map r13 = ((JSONObject) r20).getInnerMap();
        boolean r14 = true;
    L17:
        if ((r11.features & Feature.AllowISO8601DateFormat.mask) == 0) goto L19;
        boolean r15 = true;
    L20:
        boolean r16 = r11.disableCircularReferenceDetect;
        ParseContext r17 = this.contex;
        boolean r18 = false;
    L400:
        char r19 = r11.ch;     // Catch: Throwable -> L25
        if (r19 == '\"') goto L28;
        if (r19 == '}') goto L28;
        r11.skipWhitespace();     // Catch: Throwable -> L25
        r19 = r11.ch;     // Catch: Throwable -> L25
    L28:
        if (r19 != ',') goto L31;
        r11.next();     // Catch: Throwable -> L25
        r11.skipWhitespace();     // Catch: Throwable -> L25
        r19 = r11.ch;     // Catch: Throwable -> L25
        goto L28
    L31:
        char r22 = JSONLexer.EOI;
        if (r19 != '\"') goto L42;
        Object r23 = r11.scanSymbol(this.symbolTable, TokenParser.DQUOTE);     // Catch: Throwable -> L25
        Object r24 = r23;
        if (r11.ch == ':') goto L40;
        r11.skipWhitespace();     // Catch: Throwable -> L25
        if (r11.ch != ':') goto L39;
        r24 = r23;
        goto L40
    L39:
        throw new JSONException("expect ':' at " + r11.pos + ", name " + r23);     // Catch: Throwable -> L25
    L40:
        boolean r25 = false;
    L102:
        if (r25 == true) goto L126;
        int r26 = r11.bp + 1;     // Catch: Throwable -> L25
        r11.bp = r26;     // Catch: Throwable -> L25
        if (r26 < r11.len) goto L106;
        char r27 = 26;
    L107:
        r11.ch = r27;     // Catch: Throwable -> L25
    L109:
        if (r27 > ' ') goto L124;
        if (r27 == ' ') goto L123;
        if (r27 == '\n') goto L123;
        if (r27 == '\r') goto L123;
        if (r27 == '\t') goto L123;
        if (r27 == '\f') goto L123;
        char r110 = '\b';
        if (r27 == '\b') goto L123;
    L127:
        r11.sp = 0;     // Catch: Throwable -> L25
        if (r24 != JSON.DEFAULT_TYPE_KEY) goto L172;
        if (r11.isEnabled(Feature.DisableSpecialKeyDetect) == true) goto L172;
        String r28 = r11.scanSymbol(this.symbolTable, TokenParser.DQUOTE);     // Catch: Throwable -> L25
        Class<?> r29 = TypeUtils.loadClass(r28, this.config.defaultClassLoader);     // Catch: Throwable -> L25
        if (r29 != null) goto L134;
        r20.put(JSON.DEFAULT_TYPE_KEY, r28);     // Catch: Throwable -> L25
        goto L400
    L134:
        r11.nextToken(16);     // Catch: Throwable -> L25
        if (r11.token != 13) goto L156;
        r11.nextToken(16);     // Catch: Throwable -> L25
        ObjectDeserializer r30 = this.config.getDeserializer(r29);     // Catch: Throwable -> L25 Exception -> L140
        if ((r30 instanceof JavaBeanDeserializer) == false) goto L142;
        Object r31 = ((JavaBeanDeserializer) r30).createInstance(this, r29);     // Catch: Throwable -> L25 Exception -> L140
    L143:
        if (r31 == null) goto L145;
    L151:
        if (r16 == true) goto L153;
        this.contex = r17;
    L153:
        return r31;
    L145:
        if (r29 != Cloneable.class) goto L148;
        r31 = new HashMap();     // Catch: Throwable -> L25 Exception -> L140
        goto L151
    L148:
        if ("java.util.Collections$EmptyMap".equals(r28) == false) goto L150;
        r31 = Collections.emptyMap();     // Catch: Throwable -> L25 Exception -> L140
        goto L151
    L150:
        r31 = r29.newInstance();     // Catch: Throwable -> L25 Exception -> L140
        goto L151
    L142:
        r31 = null;
    L140:
        e = move-exception;
        throw new JSONException("create instance error", e);     // Catch: Throwable -> L25
    L156:
        this.resolveStatus = 2;     // Catch: Throwable -> L25
        if (this.contex == null) goto L162;
        if ((r21 instanceof Integer) == true) goto L162;
        popContext();     // Catch: Throwable -> L25
    L162:
        if (r20.size() <= 0) goto L167;
        Object r32 = TypeUtils.cast(r20, r29, this.config);     // Catch: Throwable -> L25
        parseObject(r32);     // Catch: Throwable -> L25
        if (r16 == true) goto L166;
        this.contex = r17;
    L166:
        return r32;
    L167:
        Object r33 = this.config.getDeserializer(r29).deserialze(this, r29, r21);     // Catch: Throwable -> L25
        if (r16 == true) goto L170;
        this.contex = r17;
    L170:
        return r33;
    L172:
        if (r24 == "$ref") goto L174;
    L217:
        if (r16 == true) goto L223;
        if (r18 == true) goto L223;
        ParseContext r34 = setContext(this.contex, r20, r21);     // Catch: Throwable -> L25
        if (r17 != null) goto L222;
        r17 = r34;
    L222:
        char r35 = TokenParser.DQUOTE;
        r18 = true;
    L224:
        if (r27 != r35) goto L236;
        String r36 = r11.scanStringValue(r35);     // Catch: Throwable -> L25
        Object r37 = r36;
        if (r15 == false) goto L231;
        JSONLexer r38 = new JSONLexer(r36);     // Catch: Throwable -> L25
        Object r39 = r36;
        if (r38.scanISO8601DateIfMatch(true) == false) goto L230;
        r39 = r38.calendar.getTime();     // Catch: Throwable -> L25
    L230:
        r38.close();     // Catch: Throwable -> L25
        r37 = r39;
    L231:
        if (r13 == null) goto L233;
        r13.put(r24, r37);     // Catch: Throwable -> L25
    L234:
        r10 = r10;
    L330:
        char r40 = r11.ch;     // Catch: Throwable -> L25
        if (r40 == ',') goto L336;
        if (r40 == '}') goto L336;
        r11.skipWhitespace();     // Catch: Throwable -> L25
        r40 = r11.ch;     // Catch: Throwable -> L25
    L336:
        if (r40 != ',') goto L343;
        int r41 = r11.bp + 1;     // Catch: Throwable -> L25
        r11.bp = r41;     // Catch: Throwable -> L25
        if (r41 < r11.len) goto L340;
        char r42 = JSONLexer.EOI;
    L341:
        r11.ch = r42;     // Catch: Throwable -> L25
        char r43 = 16;
    L388:
        r10 = r10;
        goto L400
    L340:
        r42 = r11.text.charAt(r41);     // Catch: Throwable -> L25
        goto L341
    L343:
        if (r40 != '}') goto L376;
        int r44 = r11.bp + 1;     // Catch: Throwable -> L25
        r11.bp = r44;     // Catch: Throwable -> L25
        if (r44 < r11.len) goto L347;
        char r45 = JSONLexer.EOI;
    L348:
        r11.ch = r45;     // Catch: Throwable -> L25
        r11.sp = 0;     // Catch: Throwable -> L25
        if (r45 != ',') goto L356;
        int r46 = r11.bp + 1;     // Catch: Throwable -> L25
        r11.bp = r46;     // Catch: Throwable -> L25
        if (r46 < r11.len) goto L353;
        char r47 = JSONLexer.EOI;
    L354:
        r11.ch = r47;     // Catch: Throwable -> L25
        r11.token = 16;     // Catch: Throwable -> L25
    L370:
        if (r16 == true) goto L372;
        setContext(this.contex, r20, r21);     // Catch: Throwable -> L25
    L372:
        if (r16 == true) goto L374;
        this.contex = r17;
    L374:
        return r20;
    L353:
        r47 = r11.text.charAt(r46);     // Catch: Throwable -> L25
        goto L354
    L356:
        if (r45 != '}') goto L363;
        int r48 = r11.bp + 1;     // Catch: Throwable -> L25
        r11.bp = r48;     // Catch: Throwable -> L25
        if (r48 < r11.len) goto L360;
        char r49 = JSONLexer.EOI;
    L361:
        r11.ch = r49;     // Catch: Throwable -> L25
        r11.token = 13;     // Catch: Throwable -> L25
        goto L370
    L360:
        r49 = r11.text.charAt(r48);     // Catch: Throwable -> L25
        goto L361
    L363:
        if (r45 != ']') goto L369;
        int r50 = r11.bp + 1;     // Catch: Throwable -> L25
        r11.bp = r50;     // Catch: Throwable -> L25
        if (r50 < r11.len) goto L367;
        char r51 = JSONLexer.EOI;
    L368:
        r11.ch = r51;     // Catch: Throwable -> L25
        r11.token = 15;     // Catch: Throwable -> L25
        goto L370
    L367:
        r51 = r11.text.charAt(r50);     // Catch: Throwable -> L25
        goto L368
    L369:
        r11.nextToken();     // Catch: Throwable -> L25
        goto L370
    L347:
        r45 = r11.text.charAt(r44);     // Catch: Throwable -> L25
        goto L348
    L376:
        throw new JSONException("syntax error, " + r11.info());     // Catch: Throwable -> L25
    L233:
        r20.put(r24, r37);     // Catch: Throwable -> L25
        goto L234
    L236:
        if (r27 < '0') goto L240;
        if (r27 > '9') goto L240;
    L241:
        r20.put(r24, r11.scanNumberValue());     // Catch: Throwable -> L25
    L240:
        if (r27 == '-') goto L241;
        if (r27 != '[') goto L271;
        r11.token = 14;     // Catch: Throwable -> L25
        int r52 = r11.bp + 1;     // Catch: Throwable -> L25
        r11.bp = r52;     // Catch: Throwable -> L25
        if (r52 < r11.len) goto L247;
        char r53 = JSONLexer.EOI;
    L248:
        r11.ch = r53;     // Catch: Throwable -> L25
        ArrayList r54 = new ArrayList();     // Catch: Throwable -> L25
        if (r21 != null) goto L251;
    L253:
        setContext(r17);     // Catch: Throwable -> L25
    L254:
        parseArray(r54, r24);     // Catch: Throwable -> L25
        JSONArray r55 = new JSONArray(r54);     // Catch: Throwable -> L25
        if (r13 == null) goto L257;
        r13.put(r24, r55);     // Catch: Throwable -> L25
    L258:
        int r56 = r11.token;     // Catch: Throwable -> L25
        if (r56 == 13) goto L260;
        if (r56 != 16) goto L269;
        r10 = r10;
        r43 = 16;
        goto L388
    L269:
        throw new JSONException("syntax error, " + r11.info());     // Catch: Throwable -> L25
    L260:
        r11.nextToken(16);     // Catch: Throwable -> L25
        if (r16 == true) goto L263;
        this.contex = r17;
    L263:
        return r20;
    L257:
        r20.put(r24, r55);     // Catch: Throwable -> L25
        goto L258
    L251:
        if (r21.getClass() != Integer.class) goto L253;
    L247:
        r53 = r11.text.charAt(r52);     // Catch: Throwable -> L25
        goto L248
    L271:
        if (r27 != '{') goto L320;
        int r57 = r11.bp + 1;     // Catch: Throwable -> L25
        r11.bp = r57;     // Catch: Throwable -> L25
        if (r57 < r11.len) goto L275;
        char r58 = JSONLexer.EOI;
    L276:
        r11.ch = r58;     // Catch: Throwable -> L25
        r11.token = 12;     // Catch: Throwable -> L25
        boolean r59 = r21 instanceof Integer;     // Catch: Throwable -> L25
        if ((Feature.OrderedField.mask & r11.features) == 0) goto L279;
        Map r60 = new JSONObject(new LinkedHashMap());     // Catch: Throwable -> L25
    L280:
        if (r16 == true) goto L283;
        if (r59 == true) goto L283;
        ParseContext r111 = setContext(r17, r60, r24);     // Catch: Throwable -> L25
    L285:
        if (this.fieldTypeResolver == null) goto L292;
        if (r24 == null) goto L288;
        String r61 = r24.toString();     // Catch: Throwable -> L25
    L289:
        Type r62 = this.fieldTypeResolver.resolve(r20, r61);     // Catch: Throwable -> L25
        if (r62 == null) goto L293;
        Object r63 = this.config.getDeserializer(r62).deserialze(this, r62, r24);     // Catch: Throwable -> L25
        boolean r64 = true;
    L294:
        if (r64 == true) goto L296;
        r63 = parseObject(r60, r24);     // Catch: Throwable -> L25
    L296:
        if (r111 == null) goto L300;
        if (r60 == r63) goto L300;
        r111.object = r20;     // Catch: Throwable -> L25
    L300:
        if (this.resolveStatus != 1) goto L302;
        checkMapResolve(r20, r24.toString());     // Catch: Throwable -> L25
    L302:
        if (r13 == null) goto L304;
        r13.put(r24, r63);     // Catch: Throwable -> L25
    L305:
        if (r59 == false) goto L307;
        setContext(r17, r63, r24);     // Catch: Throwable -> L25
    L307:
        int r65 = r11.token;     // Catch: Throwable -> L25
        if (r65 == 13) goto L309;
        r43 = 16;
        if (r65 == 16) goto L388;
        throw new JSONException("syntax error, " + r11.info());     // Catch: Throwable -> L25
    L309:
        r11.nextToken(16);     // Catch: Throwable -> L25
        if (r16 == true) goto L312;
        this.contex = r17;     // Catch: Throwable -> L25
    L312:
        if (r16 == true) goto L314;
        this.contex = r17;
    L314:
        return r20;
    L304:
        r20.put(r24, r63);     // Catch: Throwable -> L25
    L293:
        r63 = null;
        r64 = false;
        goto L294
    L288:
        r61 = null;
        goto L289
    L292:
        r10 = r10;
    L283:
        r111 = null;
        goto L285
    L279:
        r60 = new JSONObject();     // Catch: Throwable -> L25
        goto L280
    L275:
        r58 = r11.text.charAt(r57);     // Catch: Throwable -> L25
        goto L276
    L320:
        r10 = r10;
        if (r27 != 't') goto L326;
        if (r11.text.startsWith("true", r11.bp) == false) goto L330;
        r11.bp += 3;     // Catch: Throwable -> L25
        r11.next();     // Catch: Throwable -> L25
        r20.put(r24, Boolean.TRUE);     // Catch: Throwable -> L25
        goto L330
    L326:
        if (r27 == 'f') goto L328;
        r11.nextToken();     // Catch: Throwable -> L25
        Object r66 = parse();     // Catch: Throwable -> L25
        if (r20.getClass() != JSONObject.class) goto L380;
        r24 = r24.toString();     // Catch: Throwable -> L25
    L380:
        r20.put(r24, r66);     // Catch: Throwable -> L25
        int r67 = r11.token;     // Catch: Throwable -> L25
        if (r67 == 13) goto L382;
        r43 = 16;
        if (r67 == 16) goto L388;
        throw new JSONException("syntax error, " + r11.info());     // Catch: Throwable -> L25
    L382:
        r11.nextToken(16);     // Catch: Throwable -> L25
        if (r16 == true) goto L385;
        this.contex = r17;
    L385:
        return r20;
    L328:
        if (r11.text.startsWith("false", r11.bp) == false) goto L330;
        r11.bp += 4;     // Catch: Throwable -> L25
        r11.next();     // Catch: Throwable -> L25
        r20.put(r24, Boolean.FALSE);     // Catch: Throwable -> L25
    L223:
        r35 = TokenParser.DQUOTE;
        goto L224
    L174:
        if (r11.isEnabled(Feature.DisableSpecialKeyDetect) == true) goto L217;
        r11.nextToken(4);     // Catch: Throwable -> L25
        if (r11.token != 4) goto L216;
        String r68 = r11.stringVal();     // Catch: Throwable -> L25
        r11.nextToken(13);     // Catch: Throwable -> L25
        if ("@".equals(r68) == false) goto L190;
        ParseContext r69 = this.contex;     // Catch: Throwable -> L25
        if (r69 == null) goto L206;
        Object r70 = r69.object;     // Catch: Throwable -> L25
        if ((r70 instanceof Object[]) == false) goto L184;
    L193:
        Object r71 = r70;
    L208:
        if (r11.token != 13) goto L214;
        r11.nextToken(16);     // Catch: Throwable -> L25
        if (r16 == true) goto L212;
        this.contex = r17;
    L212:
        return r71;
    L214:
        throw new JSONException("syntax error, " + r11.info());     // Catch: Throwable -> L25
    L184:
        if ((r70 instanceof Collection) == true) goto L193;
        ParseContext r72 = r69.parent;     // Catch: Throwable -> L25
        if (r72 == null) goto L206;
        r71 = r72.object;     // Catch: Throwable -> L25
    L206:
        r71 = null;
        goto L208
    L190:
        if ("..".equals(r68) == false) goto L196;
        r70 = r17.object;     // Catch: Throwable -> L25
        if (r70 != null) goto L193;
        addResolveTask(new ResolveTask(r17, r68));     // Catch: Throwable -> L25
        this.resolveStatus = 1;     // Catch: Throwable -> L25
        goto L206
    L196:
        if (TangramExprSupport.VAR_START.equals(r68) == false) goto L205;
        ParseContext r73 = r17;
    L198:
        ParseContext r74 = r73.parent;     // Catch: Throwable -> L25
        if (r74 == null) goto L201;
        r73 = r74;
        goto L198
    L201:
        Object r75 = r73.object;     // Catch: Throwable -> L25
        if (r75 == null) goto L204;
        r71 = r75;
        goto L208
    L204:
        addResolveTask(new ResolveTask(r73, r68));     // Catch: Throwable -> L25
        this.resolveStatus = 1;     // Catch: Throwable -> L25
        goto L206
    L205:
        addResolveTask(new ResolveTask(r17, r68));     // Catch: Throwable -> L25
        this.resolveStatus = 1;     // Catch: Throwable -> L25
        goto L206
    L216:
        throw new JSONException("illegal ref, " + JSONToken.name(r11.token));     // Catch: Throwable -> L25
    L123:
        r11.next();     // Catch: Throwable -> L25
        r27 = r11.ch;     // Catch: Throwable -> L25
        goto L109
    L124:
        r110 = '\b';
        goto L127
    L106:
        r27 = r11.text.charAt(r26);     // Catch: Throwable -> L25
        goto L107
    L126:
        r110 = '\b';
        r27 = r11.ch;     // Catch: Throwable -> L25
        goto L127
    L42:
        if (r19 == '}') goto L43;
        if (r19 != '\'') goto L61;
        Object r76 = r11.scanSymbol(this.symbolTable, '\'');     // Catch: Throwable -> L25
        if (r11.ch == ':') goto L57;
        r11.skipWhitespace();     // Catch: Throwable -> L25
    L57:
        if (r11.ch != ':') goto L60;
        r24 = r76;
        goto L40
    L60:
        throw new JSONException("expect ':' at " + r11.pos);     // Catch: Throwable -> L25
    L61:
        if (r19 == 26) goto L394;
        if (r19 == ',') goto L392;
        if (r19 < '0') goto L70;
        if (r19 > '9') goto L70;
    L72:
        r11.sp = 0;     // Catch: Throwable -> L25
        r11.scanNumber();     // Catch: Throwable -> L25
        if (r11.token != 2) goto L76;
        Object r77 = r11.integerValue();     // Catch: Throwable -> L25 NumberFormatException -> L84
    L77:
        if (r14 == false) goto L80;
        r77 = r77.toString();     // Catch: Throwable -> L25 NumberFormatException -> L84
    L80:
        if (r11.ch != ':') goto L83;
        r24 = r77;
        goto L40
    L83:
        throw new JSONException(r10 + r11.info());     // Catch: Throwable -> L25
    L76:
        r77 = r11.decimalValue(true);     // Catch: Throwable -> L25 NumberFormatException -> L84
        goto L77
    L85:
        throw new JSONException(r10 + r11.info());     // Catch: Throwable -> L25
    L70:
        if (r19 == '-') goto L72;
        if (r19 != '{') goto L89;
    L97:
        r11.nextToken();     // Catch: Throwable -> L25
        r24 = parse();     // Catch: Throwable -> L25
        if (r14 == false) goto L100;
        r24 = r24.toString();     // Catch: Throwable -> L25
    L100:
        r25 = true;
        goto L102
    L89:
        if (r19 == '[') goto L97;
        Object r78 = r11.scanSymbolUnQuoted(this.symbolTable);     // Catch: Throwable -> L25
        r11.skipWhitespace();     // Catch: Throwable -> L25
        char r79 = r11.ch;     // Catch: Throwable -> L25
        r24 = r78;
        if (r79 != ':') goto L96;
        if (r14 == false) goto L40;
        r24 = r78.toString();     // Catch: Throwable -> L25
        goto L40
    L96:
        throw new JSONException("expect ':' at " + r11.bp + ", actual " + r79);     // Catch: Throwable -> L25
    L392:
        throw new JSONException("syntax error, " + r11.info());     // Catch: Throwable -> L25
    L394:
        throw new JSONException("syntax error, " + r11.info());     // Catch: Throwable -> L25
    L43:
        int r80 = r11.bp + 1;     // Catch: Throwable -> L25
        r11.bp = r80;     // Catch: Throwable -> L25
        if (r80 >= r11.len) goto L47;
        r22 = r11.text.charAt(r80);     // Catch: Throwable -> L25
    L47:
        r11.ch = r22;     // Catch: Throwable -> L25
        r11.sp = 0;     // Catch: Throwable -> L25
        r11.nextToken(16);     // Catch: Throwable -> L25
        if (r16 == true) goto L50;
        this.contex = r17;
    L50:
        return r20;
    L25:
        th = move-exception;
        if (r16 == true) goto L397;
        this.contex = r17;
    L397:
        throw th;
    L19:
        r15 = false;
        goto L20
    L15:
        r13 = null;
        r14 = false;
        goto L17
    }

    public String parseString() {
        JSONLexer r10 = this.lexer;
        int r11 = r10.token;
        if (r11 != 4) goto L28;
        String r12 = r10.stringVal();
        JSONLexer r13 = this.lexer;
        char r14 = r13.ch;
        char r15 = JSONLexer.EOI;
        if (r14 != ',') goto L12;
        int r16 = r13.bp + 1;
        r13.bp = r16;
        if (r16 >= r13.len) goto L10;
        r15 = r13.text.charAt(r16);
    L10:
        r13.ch = r15;
        this.lexer.token = 16;
    L26:
        return r12;
    L12:
        if (r14 != ']') goto L19;
        int r17 = r13.bp + 1;
        r13.bp = r17;
        if (r17 >= r13.len) goto L17;
        r15 = r13.text.charAt(r17);
    L17:
        r13.ch = r15;
        this.lexer.token = 15;
        goto L26
    L19:
        if (r14 != '}') goto L25;
        int r18 = r13.bp + 1;
        r13.bp = r18;
        if (r18 >= r13.len) goto L24;
        r15 = r13.text.charAt(r18);
    L24:
        r13.ch = r15;
        this.lexer.token = 13;
        goto L26
    L25:
        r13.nextToken();
        goto L26
    L28:
        if (r11 != 2) goto L31;
        String r19 = r10.numberString();
        this.lexer.nextToken(16);
        return r19;
    L31:
        Object r20 = parse();
        if (r20 != null) goto L36;
        return null;
    L36:
        return r20.toString();
    }

    public void popContext() {
        this.contex = this.contex.parent;
        ParseContext[] r10 = this.contextArray;
        int r11 = this.contextArrayIndex;
        r10[r11 - 1] = null;
        this.contextArrayIndex = r11 - 1;
    }

    public void setContext(ParseContext r10) {
        if (this.lexer.disableCircularReferenceDetect == false) goto L5;
        return;
    L5:
        this.contex = r10;
    }

    public void setDateFomrat(DateFormat r10) {
        this.dateFormat = r10;
    }

    public void setDateFormat(String r10) {
        this.dateFormatPattern = r10;
        this.dateFormat = null;
    }

    public DefaultJSONParser(String r10, ParserConfig r11) {
        this(new JSONLexer(r10, JSON.DEFAULT_PARSER_FEATURE), r11);
    }

    public Object parse(Object r10) {
        JSONLexer r11 = this.lexer;
        int r12 = r11.token;
        if (r12 == 2) goto L66;
        boolean r13 = true;
        if (r12 == 3) goto L61;
        if (r12 != 4) goto L9;
        String r14 = r11.stringVal();
        this.lexer.nextToken(16);
        if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) == 0) goto L59;
        JSONLexer r15 = new JSONLexer(r14);
    L54:
        th = move-exception;
        r15.close();
        throw th;
    L50:
        if (r15.scanISO8601DateIfMatch(true) == false) goto L56;
        Date r16 = r15.calendar.getTime();     // Catch: Throwable -> L54
        r15.close();
        return r16;
    L56:
        r15.close();
    L59:
        return r14;
    L9:
        if (r12 == 12) goto L41;
        if (r12 != 14) goto L13;
        JSONArray r17 = new JSONArray();
        parseArray(r17, r10);
        return r17;
    L13:
        switch(r12) {
            case 6: goto L36;
            case 7: goto L34;
            case 8: goto L32;
            case 9: goto L26;
            default: goto L14;
        };
    L14:
        switch(r12) {
            case 20: goto L22;
            case 21: goto L19;
            case 22: goto L17;
            case 23: goto L32;
            default: goto L16;
        };
    L17:
        r11.nextToken();
        TreeSet r18 = new TreeSet();
        parseArray(r18, r10);
        return r18;
    L19:
        r11.nextToken();
        HashSet r19 = new HashSet();
        parseArray(r19, r10);
        return r19;
    L16:
        throw new JSONException("syntax error, " + this.lexer.info());
    L22:
        if (r11.isBlankInput() == false) goto L25;
        return null;
    L25:
        throw new JSONException("syntax error, " + this.lexer.info());
    L26:
        r11.nextToken(18);
        JSONLexer r20 = this.lexer;
        if (r20.token != 18) goto L31;
        r20.nextToken(10);
        accept(10);
        long r21 = this.lexer.integerValue().longValue();
        accept(2);
        accept(11);
        return new Date(r21);
    L31:
        throw new JSONException("syntax error, " + this.lexer.info());
    L32:
        r11.nextToken();
        return null;
    L34:
        r11.nextToken(16);
        return Boolean.FALSE;
    L36:
        r11.nextToken(16);
        return Boolean.TRUE;
    L41:
        if ((r11.features & Feature.OrderedField.mask) == 0) goto L43;
        JSONObject r22 = new JSONObject(new LinkedHashMap());
    L45:
        return parseObject(r22, r10);
    L43:
        r22 = new JSONObject();
        goto L45
    L61:
        if ((r11.features & Feature.UseBigDecimal.mask) != 0) goto L64;
        r13 = false;
    L64:
        Number r23 = r11.decimalValue(r13);
        this.lexer.nextToken();
        return r23;
    L66:
        Number r24 = r11.integerValue();
        this.lexer.nextToken();
        return r24;
    }

    public DefaultJSONParser(String r10, ParserConfig r11, int r12) {
        this(new JSONLexer(r10, r12), r11);
    }

    public void parseArray(Class<?> r10, Collection r11) {
        parseArray(r10, r11);
    }

    public ParseContext setContext(ParseContext r10, Object r11, Object r12) {
        if (this.lexer.disableCircularReferenceDetect == false) goto L6;
        return null;
    L6:
        this.contex = new ParseContext(r10, r11, r12);
        int r13 = this.contextArrayIndex;
        this.contextArrayIndex = r13 + 1;
        ParseContext[] r14 = this.contextArray;
        if (r14 != null) goto L10;
        this.contextArray = new ParseContext[8];
    L12:
        ParseContext[] r15 = this.contextArray;
        ParseContext r16 = this.contex;
        r15[r13] = r16;
        return r16;
    L10:
        if (r13 < r14.length) goto L12;
        ParseContext[] r17 = new ParseContext[(r14.length * 3) / 2];
        System.arraycopy(r14, 0, r17, 0, r14.length);
        this.contextArray = r17;
        goto L12
    }

    public DefaultJSONParser(char[] r10, int r11, ParserConfig r12, int r13) {
        this(new JSONLexer(r10, r11, r13), r12);
    }

    public void parseArray(Type r10, Collection r11) {
        parseArray(r10, r11, null);
    }

    public DefaultJSONParser(JSONLexer r10) {
        this(r10, ParserConfig.global);
    }

    public void parseArray(Type r10, Collection r11, Object r12) {
        JSONLexer r13 = this.lexer;
        int r14 = r13.token;
        if (r14 != 21) goto L5;
    L6:
        r13.nextToken();
    L7:
        JSONLexer r15 = this.lexer;
        if (r15.token != 14) goto L55;
        if (Integer.TYPE != r10) goto L12;
        ObjectDeserializer r16 = IntegerCodec.instance;
        r15.nextToken(2);
    L15:
        ParseContext r17 = this.contex;
        if (this.lexer.disableCircularReferenceDetect == true) goto L18;
        setContext(r17, r11, r12);
    L18:
        int r18 = 0;
    L56:
        JSONLexer r19 = this.lexer;     // Catch: Throwable -> L23
        int r20 = r19.token;     // Catch: Throwable -> L23
        if (r20 == 16) goto L21;
        if (r20 == 15) goto L27;
        Object r21 = null;
        if (Integer.TYPE != r10) goto L32;
        r11.add(IntegerCodec.instance.deserialze(this, null, null));     // Catch: Throwable -> L23
    L48:
        JSONLexer r22 = this.lexer;     // Catch: Throwable -> L23
        if (r22.token != 16) goto L51;
        r22.nextToken();     // Catch: Throwable -> L23
    L51:
        r18 = r18 + 1;
        goto L56
    L32:
        if (String.class != r10) goto L42;
        if (r20 != 4) goto L35;
        Object r23 = r19.stringVal();     // Catch: Throwable -> L23
        this.lexer.nextToken(16);     // Catch: Throwable -> L23
    L40:
        r11.add(r23);     // Catch: Throwable -> L23
        goto L48
    L35:
        Object r24 = parse();     // Catch: Throwable -> L23
        if (r24 == null) goto L39;
        r21 = r24.toString();     // Catch: Throwable -> L23
    L39:
        r23 = r21;
        goto L40
    L42:
        if (r20 != 8) goto L44;
        r19.nextToken();     // Catch: Throwable -> L23
    L45:
        r11.add(r21);     // Catch: Throwable -> L23
        if (this.resolveStatus != 1) goto L48;
        checkListResolve(r11);     // Catch: Throwable -> L23
        goto L48
    L44:
        r21 = r16.deserialze(this, r10, Integer.valueOf(r18));     // Catch: Throwable -> L23
        goto L45
    L27:
        this.contex = r17;
        r19.nextToken(16);
        return;
    L21:
        r19.nextToken();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        this.contex = r17;
        throw th;
    L12:
        if (String.class != r10) goto L14;
        r16 = StringCodec.instance;
        r15.nextToken(4);
        goto L15
    L14:
        r16 = this.config.getDeserializer(r10);
        this.lexer.nextToken(12);
        goto L15
    L55:
        throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token) + ", " + this.lexer.info());
    L5:
        if (r14 != 22) goto L7;
        goto L6
    }

    public DefaultJSONParser(JSONLexer r10, ParserConfig r11) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = r10;
        this.config = r11;
        this.symbolTable = r11.symbolTable;
        char r12 = r10.ch;
        char r13 = JSONLexer.EOI;
        if (r12 != '{') goto L10;
        int r14 = r10.bp + 1;
        r10.bp = r14;
        if (r14 >= r10.len) goto L8;
        r13 = r10.text.charAt(r14);
    L8:
        r10.ch = r13;
        r10.token = 12;
        return;
    L10:
        if (r12 != '[') goto L16;
        int r15 = r10.bp + 1;
        r10.bp = r15;
        if (r15 >= r10.len) goto L15;
        r13 = r10.text.charAt(r15);
    L15:
        r10.ch = r13;
        r10.token = 14;
        return;
    L16:
        r10.nextToken();
    }

    public Object[] parseArray(Type[] r17) {
        JSONLexer r10 = this.lexer;
        int r11 = r10.token;
        int r12 = 8;
        if (r11 != 8) goto L7;
        r10.nextToken(16);
        return null;
    L7:
        if (r11 != 14) goto L74;
        Object[] r13 = new Object[r17.length];
        if (r17.length != 0) goto L16;
        r10.nextToken(15);
        JSONLexer r14 = this.lexer;
        if (r14.token != 15) goto L15;
        r14.nextToken(16);
        return new Object[0];
    L15:
        throw new JSONException("syntax error, " + this.lexer.info());
    L16:
        r10.nextToken(2);
        int r15 = 0;
    L18:
        if (r15 >= r17.length) goto L67;
        JSONLexer r16 = this.lexer;
        int r18 = r16.token;
        if (r18 != r12) goto L22;
        r16.nextToken(16);
        Object r19 = null;
    L56:
        r13[r15] = r19;
        JSONLexer r20 = this.lexer;
        int r110 = r20.token;
        if (r110 == 15) goto L67;
        if (r110 != 16) goto L66;
        if (r15 != (r17.length - 1)) goto L63;
        r20.nextToken(15);
    L64:
        r15 = r15 + 1;
        r12 = 8;
        goto L18
    L63:
        r20.nextToken(2);
        goto L64
    L66:
        throw new JSONException("syntax error, " + this.lexer.info());
    L22:
        Type r111 = r17[r15];
        if (r111 != Integer.TYPE) goto L25;
    L53:
        if (r18 != 2) goto L55;
        r19 = Integer.valueOf(r16.intValue());
        this.lexer.nextToken(16);
        goto L56
    L55:
        r19 = TypeUtils.cast(parse(), r111, this.config);
        goto L56
    L25:
        if (r111 == Integer.class) goto L53;
        if (r111 != String.class) goto L34;
        if (r18 != 4) goto L32;
        r19 = r16.stringVal();
        this.lexer.nextToken(16);
        goto L56
    L32:
        r19 = TypeUtils.cast(parse(), r111, this.config);
        goto L56
    L34:
        if (r15 == (r17.length - 1)) goto L36;
    L38:
        Class<?> r112 = null;
        boolean r113 = false;
    L39:
        if (r113 == true) goto L41;
    L52:
        r19 = this.config.getDeserializer(r111).deserialze(this, r111, null);
        goto L56
    L41:
        if (this.lexer.token == 14) goto L52;
        ArrayList r114 = new ArrayList();
        ObjectDeserializer r115 = this.config.getDeserializer(r112);
        if (this.lexer.token == 15) goto L51;
    L44:
        r114.add(r115.deserialze(this, r111, null));
        JSONLexer r116 = this.lexer;
        int r21 = r116.token;
        if (r21 != 16) goto L47;
        r116.nextToken(12);
        goto L44
    L47:
        if (r21 == 15) goto L51;
        throw new JSONException("syntax error, " + this.lexer.info());
    L51:
        r19 = TypeUtils.cast(r114, r111, this.config);
        goto L56
    L36:
        if ((r111 instanceof Class) == false) goto L38;
        Class r117 = (Class) r111;
        r113 = r117.isArray();
        r112 = r117.getComponentType();
    L67:
        JSONLexer r22 = this.lexer;
        if (r22.token != 15) goto L72;
        r22.nextToken(16);
        return r13;
    L72:
        throw new JSONException("syntax error, " + this.lexer.info());
    L74:
        throw new JSONException("syntax error, " + this.lexer.info());
    }

    public final void parseArray(Collection r10) {
        parseArray(r10, null);
    }

    public final void parseArray(Collection r17, Object r18) {
        JSONLexer r10 = this.lexer;
        int r11 = r10.token;
        if (r11 != 21) goto L5;
    L6:
        r10.nextToken();
        r11 = this.lexer.token;
    L8:
        if (r11 != 14) goto L141;
        boolean r12 = this.lexer.disableCircularReferenceDetect;
        ParseContext r13 = this.contex;
        if (r12 == true) goto L142;
        setContext(r13, r17, r18);
    L142:
        JSONLexer r14 = this.lexer;     // Catch: Throwable -> L19
        char r15 = r14.ch;     // Catch: Throwable -> L19
        if (r15 == '\"') goto L30;
        if (r15 != ']') goto L21;
        r14.next();     // Catch: Throwable -> L19
        this.lexer.nextToken(16);     // Catch: Throwable -> L19
        if (r12 == true) goto L153;
        this.contex = r13;
        return;
    L153:
        return;
    L21:
        if (r15 != '{') goto L27;
        int r16 = r14.bp + 1;     // Catch: Throwable -> L19
        r14.bp = r16;     // Catch: Throwable -> L19
        if (r16 < r14.len) goto L25;
        char r19 = JSONLexer.EOI;
    L26:
        r14.ch = r19;     // Catch: Throwable -> L19
        this.lexer.token = 12;     // Catch: Throwable -> L19
    L28:
        boolean r20 = false;
    L33:
        int r21 = 0;
    L34:
        if (r20 == false) goto L62;
        JSONLexer r110 = this.lexer;     // Catch: Throwable -> L19
        if (r110.ch != '\"') goto L62;
        String r22 = r110.scanStringValue(TokenParser.DQUOTE);     // Catch: Throwable -> L19
        JSONLexer r111 = this.lexer;     // Catch: Throwable -> L19
        char r112 = r111.ch;     // Catch: Throwable -> L19
        if (r112 != ',') goto L49;
        int r23 = r111.bp + 1;     // Catch: Throwable -> L19
        r111.bp = r23;     // Catch: Throwable -> L19
        if (r23 < r111.len) goto L42;
        char r24 = JSONLexer.EOI;
    L43:
        r111.ch = r24;     // Catch: Throwable -> L19
        r17.add(r22);     // Catch: Throwable -> L19
        if (this.resolveStatus != 1) goto L46;
        checkListResolve(r17);     // Catch: Throwable -> L19
    L46:
        if (r24 == '\"') goto L136;
        this.lexer.nextToken();     // Catch: Throwable -> L19
        r20 = false;
    L136:
        r21 = r21 + 1;
        goto L34
    L42:
        r24 = r111.text.charAt(r23);     // Catch: Throwable -> L19
        goto L43
    L49:
        if (r112 == ']') goto L50;
        r111.nextToken();     // Catch: Throwable -> L19
        goto L62
    L50:
        int r25 = r111.bp + 1;     // Catch: Throwable -> L19
        r111.bp = r25;     // Catch: Throwable -> L19
        if (r25 < r111.len) goto L53;
        char r26 = JSONLexer.EOI;
    L54:
        r111.ch = r26;     // Catch: Throwable -> L19
        r17.add(r22);     // Catch: Throwable -> L19
        if (this.resolveStatus != 1) goto L57;
        checkListResolve(r17);     // Catch: Throwable -> L19
    L57:
        this.lexer.nextToken(16);     // Catch: Throwable -> L19
        if (r12 == true) goto L154;
        this.contex = r13;
        return;
    L154:
        return;
    L53:
        r26 = r111.text.charAt(r25);     // Catch: Throwable -> L19
    L62:
        int r27 = this.lexer.token;     // Catch: Throwable -> L19
    L63:
        if (r27 != 16) goto L66;
        this.lexer.nextToken();     // Catch: Throwable -> L19
        r27 = this.lexer.token;     // Catch: Throwable -> L19
        goto L63
    L66:
        if (r27 != 2) goto L68;
        Number r28 = this.lexer.integerValue();     // Catch: Throwable -> L19
        this.lexer.nextToken(16);     // Catch: Throwable -> L19
        Object r29 = r28;
    L115:
        r17.add(r29);     // Catch: Throwable -> L19
        if (this.resolveStatus != 1) goto L118;
        checkListResolve(r17);     // Catch: Throwable -> L19
    L118:
        JSONLexer r30 = this.lexer;     // Catch: Throwable -> L19
        if (r30.token != 16) goto L136;
        char r113 = r30.ch;     // Catch: Throwable -> L19
        if (r113 != '\"') goto L124;
        r30.pos = r30.bp;     // Catch: Throwable -> L19
        r30.scanString();     // Catch: Throwable -> L19
        goto L136
    L124:
        if (r113 < '0') goto L129;
        if (r113 > '9') goto L129;
        r30.pos = r30.bp;     // Catch: Throwable -> L19
        r30.scanNumber();     // Catch: Throwable -> L19
    L129:
        if (r113 != '{') goto L135;
        r30.token = 12;     // Catch: Throwable -> L19
        int r114 = r30.bp + 1;     // Catch: Throwable -> L19
        r30.bp = r114;     // Catch: Throwable -> L19
        if (r114 < r30.len) goto L133;
        char r31 = JSONLexer.EOI;
    L134:
        r30.ch = r31;     // Catch: Throwable -> L19
        goto L136
    L133:
        r31 = r30.text.charAt(r114);     // Catch: Throwable -> L19
        goto L134
    L135:
        r30.nextToken();     // Catch: Throwable -> L19
        goto L136
    L68:
        if (r27 == 3) goto L109;
        if (r27 != 4) goto L71;
        String r115 = this.lexer.stringVal();     // Catch: Throwable -> L19
        this.lexer.nextToken(16);     // Catch: Throwable -> L19
        Object r116 = r115;
        if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) goto L105;
    L86:
        r29 = r116;
        goto L115
    L105:
        JSONLexer r32 = new JSONLexer(r115);     // Catch: Throwable -> L19
        Object r117 = r115;
        if (r32.scanISO8601DateIfMatch(true) == false) goto L108;
        r117 = r32.calendar.getTime();     // Catch: Throwable -> L19
    L108:
        r32.close();     // Catch: Throwable -> L19
        r116 = r117;
        goto L86
    L71:
        if (r27 != 6) goto L73;
        Boolean r118 = Boolean.TRUE;     // Catch: Throwable -> L19
        this.lexer.nextToken(16);     // Catch: Throwable -> L19
        r116 = r118;
        goto L86
    L73:
        if (r27 == 7) goto L101;
        r116 = null;
        r116 = null;
        if (r27 == 8) goto L100;
        if (r27 == 12) goto L96;
        if (r27 == 20) goto L94;
        if (r27 != 23) goto L82;
        this.lexer.nextToken(4);     // Catch: Throwable -> L19
        goto L86
    L82:
        if (r27 != 14) goto L84;
        JSONArray r119 = new JSONArray();     // Catch: Throwable -> L19
        parseArray(r119, Integer.valueOf(r21));     // Catch: Throwable -> L19
        r116 = r119;
        goto L86
    L84:
        if (r27 == 15) goto L87;
        r116 = parse();     // Catch: Throwable -> L19
        goto L86
    L87:
        this.lexer.nextToken(16);     // Catch: Throwable -> L19
        if (r12 == true) goto L155;
        this.contex = r13;
        return;
    L155:
        return;
    L94:
        throw new JSONException("unclosed jsonArray");     // Catch: Throwable -> L19
    L96:
        if ((this.lexer.features & Feature.OrderedField.mask) == 0) goto L98;
        JSONObject r33 = new JSONObject(new LinkedHashMap());     // Catch: Throwable -> L19
    L99:
        r116 = parseObject(r33, Integer.valueOf(r21));     // Catch: Throwable -> L19
        goto L86
    L98:
        r33 = new JSONObject();     // Catch: Throwable -> L19
        goto L99
    L100:
        this.lexer.nextToken(4);     // Catch: Throwable -> L19
        goto L86
    L101:
        Boolean r120 = Boolean.FALSE;     // Catch: Throwable -> L19
        this.lexer.nextToken(16);     // Catch: Throwable -> L19
        r116 = r120;
        goto L86
    L109:
        JSONLexer r34 = this.lexer;     // Catch: Throwable -> L19
        if ((r34.features & Feature.UseBigDecimal.mask) == 0) goto L112;
        Number r35 = r34.decimalValue(true);     // Catch: Throwable -> L19
    L113:
        this.lexer.nextToken(16);     // Catch: Throwable -> L19
        r29 = r35;
        goto L115
    L112:
        r35 = r34.decimalValue(false);     // Catch: Throwable -> L19
        goto L113
    L25:
        r19 = r14.text.charAt(r16);     // Catch: Throwable -> L19
        goto L26
    L27:
        r14.nextToken(12);     // Catch: Throwable -> L19
        goto L28
    L30:
        if ((r14.features & Feature.AllowISO8601DateFormat.mask) != 0) goto L32;
        r20 = true;
        goto L33
    L32:
        r14.nextToken(4);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (r12 == true) goto L139;
        this.contex = r13;
    L139:
        throw th;
    L141:
        throw new JSONException("syntax error, expect [, actual " + JSONToken.name(r11) + ", pos " + this.lexer.pos);
    L5:
        if (r11 != 22) goto L8;
        goto L6
    }

    public <T> T parseObject(Class<T> r10) {
        return (T) parseObject(r10, null);
    }

    public <T> T parseObject(Type r10) {
        return (T) parseObject(r10, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type r10, Object r11) {
        JSONLexer r12 = this.lexer;
        int r13 = r12.token;
        if (r13 != 8) goto L7;
        r12.nextToken();
        return null;
    L7:
        if (r13 != 4) goto L24;
        if (r10 != byte[].class) goto L13;
        T r14 = (T) r12.bytesValue();
        this.lexer.nextToken();
        return r14;
    L13:
        if (r10 != char[].class) goto L24;
        String r15 = r12.stringVal();
        this.lexer.nextToken();
        return (T) r15.toCharArray();
    L24:
        return (T) this.config.getDeserializer(r10).deserialze(this, r10, r11);
    L22:
        e = move-exception;
        throw e;
    L19:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    public void parseObject(Object r11) {
        Class<?> r10 = r11.getClass();
        ObjectDeserializer r12 = this.config.getDeserializer(r10);
        if ((r12 instanceof JavaBeanDeserializer) == false) goto L5;
        JavaBeanDeserializer r13 = (JavaBeanDeserializer) r12;
    L6:
        int r14 = this.lexer.token;
        if (r14 == 12) goto L12;
        if (r14 == 16) goto L12;
        throw new JSONException("syntax error, expect {, actual " + JSONToken.name(r14));
    L12:
        String r15 = this.lexer.scanSymbol(this.symbolTable);
        if (r15 != null) goto L20;
        JSONLexer r16 = this.lexer;
        int r17 = r16.token;
        if (r17 == 13) goto L16;
        if (r17 != 16) goto L20;
    L16:
        r16.nextToken(16);
        return;
    L20:
        if (r13 == null) goto L22;
        FieldDeserializer r18 = r13.getFieldDeserializer(r15);
    L24:
        if (r18 == null) goto L25;
        FieldInfo r19 = r18.fieldInfo;
        Class<?> r20 = r19.fieldClass;
        Type r21 = r19.fieldType;
        if (r20 != Integer.TYPE) goto L37;
        this.lexer.nextTokenWithChar(':');
        Object r22 = IntegerCodec.instance.deserialze(this, r21, null);
    L43:
        r18.setValue(r11, r22);
        JSONLexer r23 = this.lexer;
        int r24 = r23.token;
        if (r24 == 16) goto L12;
        if (r24 != 13) goto L12;
        r23.nextToken(16);
        return;
    L37:
        if (r20 != String.class) goto L40;
        this.lexer.nextTokenWithChar(':');
        r22 = parseString();
        goto L43
    L40:
        if (r20 != Long.TYPE) goto L42;
        this.lexer.nextTokenWithChar(':');
        r22 = IntegerCodec.instance.deserialze(this, r21, null);
        goto L43
    L42:
        ObjectDeserializer r25 = this.config.getDeserializer(r20, r21);
        this.lexer.nextTokenWithChar(':');
        r22 = r25.deserialze(this, r21, null);
        goto L43
    L25:
        JSONLexer r26 = this.lexer;
        if ((r26.features & Feature.IgnoreNotMatch.mask) == 0) goto L32;
        r26.nextTokenWithChar(':');
        parse();
        JSONLexer r27 = this.lexer;
        if (r27.token != 13) goto L12;
        r27.nextToken();
        return;
    L32:
        throw new JSONException("setter not found, class " + r10.getName() + ", property " + r15);
    L22:
        r18 = null;
        goto L24
    L5:
        r13 = null;
        goto L6
    }

    public Object parseObject(Map r10) {
        return parseObject(r10, null);
    }

    public JSONObject parseObject() {
        if ((this.lexer.features & Feature.OrderedField.mask) == 0) goto L5;
        JSONObject r10 = new JSONObject(new LinkedHashMap());
    L7:
        return (JSONObject) parseObject(r10, null);
    L5:
        r10 = new JSONObject();
        goto L7
    }
}
