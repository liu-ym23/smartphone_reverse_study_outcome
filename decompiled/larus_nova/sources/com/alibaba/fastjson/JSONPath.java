package com.alibaba.fastjson;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.n.a;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes28.dex */
public class JSONPath implements JSONAware {
    static final long LENGTH = -1580386065683472715L;
    static final long SIZE = 5614464919154503228L;
    private static ConcurrentMap<String, JSONPath> pathCache;
    private boolean hasRefSegment;
    private boolean ignoreNullValue;
    private ParserConfig parserConfig;
    private final String path;
    private Segment[] segments;
    private SerializeConfig serializeConfig;

    /* JADX INFO: renamed from: com.alibaba.fastjson.JSONPath$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$JSONPath$Operator = null;

        static {
            int[] r100 = new int[Operator.values().length];
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator = r100;
            r100[Operator.EQ.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.NE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.GE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.GT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.LE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.LT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class ArrayAccessSegment implements Segment {
        private final int index;

        public ArrayAccessSegment(int r100) {
            this.index = r100;
        }

        public static /* synthetic */ int access$200(ArrayAccessSegment r100) {
            return r100.index;
        }

        public boolean remove(JSONPath r100, Object r101) {
            return r100.removeArrayItem(r100, r101, this.index);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            return r100.getArrayItem(r102, this.index);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            if (((JSONLexerBase) r101.lexer).seekArrayToItem(this.index) == true) goto L5;
            return;
        L5:
            if (r102.eval == false) goto L9;
            r102.object = r101.parse();
            return;
        }

        public boolean setValue(JSONPath r100, Object r101, Object r102) {
            return r100.setArrayItem(r100, r101, this.index, r102);
        }
    }

    public static class Context {
        final boolean eval;
        Object object;
        final Context parent;

        public Context(Context r100, boolean r101) {
            this.parent = r100;
            this.eval = r101;
        }
    }

    public static class DoubleOpSegement extends PropertyFilter {

        /* JADX INFO: renamed from: op, reason: collision with root package name */
        private final Operator f24921op;
        private final double value;

        public DoubleOpSegement(String r100, boolean r101, double r102, Operator r103) {
            super(r100, r101);
            this.value = r102;
            this.f24921op = r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            if (r104 != null) goto L6;
            return false;
        L6:
            if ((r104 instanceof Number) == true) goto L8;
            return false;
        L8:
            double r105 = ((Number) r104).doubleValue();
            switch(AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f24921op.ordinal()]) {
                case 1: goto L32;
                case 2: goto L28;
                case 3: goto L24;
                case 4: goto L20;
                case 5: goto L16;
                case 6: goto L12;
                default: goto L10;
            };
        L10:
            return false;
        L12:
            if (r105 >= this.value) goto L35;
            return true;
        L35:
            return false;
        L16:
            if (r105 > this.value) goto L36;
            return true;
        L36:
            return false;
        L20:
            if (r105 <= this.value) goto L37;
            return true;
        L37:
            return false;
        L24:
            if (r105 < this.value) goto L38;
            return true;
        L38:
            return false;
        L28:
            if (r105 == this.value) goto L39;
            return true;
        L39:
            return false;
        L32:
            if (r105 != this.value) goto L40;
            return true;
        L40:
            return false;
        }
    }

    public interface Filter {
        boolean apply(JSONPath r100, Object r101, Object r102, Object r103);
    }

    public static class FilterGroup implements Filter {
        private boolean and;
        private List<Filter> fitlers;

        public FilterGroup(Filter r100, Filter r101, boolean r102) {
            ArrayList r103 = new ArrayList(2);
            this.fitlers = r103;
            r103.add(r100);
            this.fitlers.add(r101);
            this.and = r102;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            if (this.and == false) goto L11;
            Iterator<Filter> r104 = this.fitlers.iterator();
        L6:
            if (r104.hasNext() == false) goto L10;
            if (r104.next().apply(r100, r101, r102, r103) == true) goto L6;
            return false;
        L10:
            return true;
        L11:
            Iterator<Filter> r105 = this.fitlers.iterator();
        L13:
            if (r105.hasNext() == false) goto L17;
            if (r105.next().apply(r100, r101, r102, r103) == false) goto L13;
            return true;
        L17:
            return false;
        }
    }

    public static class FilterSegment implements Segment {
        private final Filter filter;

        public FilterSegment(Filter r100) {
            this.filter = r100;
        }

        public static /* synthetic */ Filter access$300(FilterSegment r100) {
            return r100.filter;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            if (r102 != null) goto L5;
            return null;
        L5:
            JSONArray r103 = new JSONArray();
            if ((r102 instanceof Iterable) == false) goto L15;
            Iterator r104 = ((Iterable) r102).iterator();
        L9:
            if (r104.hasNext() == false) goto L13;
            Object r105 = r104.next();
            if (this.filter.apply(r100, r101, r102, r105) == false) goto L9;
            r103.add(r105);
            goto L9
        L13:
            return r103;
        L15:
            if (this.filter.apply(r100, r101, r102, r102) == false) goto L17;
            return r102;
        L17:
            return null;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            Object r103 = r101.parse();
            r102.object = eval(r100, r103, r103);
        }

        public boolean remove(JSONPath r100, Object r101, Object r102) {
            if (r102 != null) goto L6;
            return false;
        L6:
            if ((r102 instanceof Iterable) == false) goto L15;
            Iterator r103 = ((Iterable) r102).iterator();
        L9:
            if (r103.hasNext() == false) goto L13;
            Object r104 = r103.next();
            if (this.filter.apply(r100, r101, r102, r104) == false) goto L9;
            r103.remove();
            goto L9
        L13:
            return true;
        L15:
            return false;
        }
    }

    public static class FloorSegment implements Segment {
        public static final FloorSegment instance = null;

        public FloorSegment() {
        }

        static {
            instance = new FloorSegment();
        }

        private static Object floor(Object r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            if ((r100 instanceof Float) == false) goto L10;
            return Double.valueOf(Math.floor(((Float) r100).floatValue()));
        L10:
            if ((r100 instanceof Double) == false) goto L14;
            return Double.valueOf(Math.floor(((Double) r100).doubleValue()));
        L14:
            if ((r100 instanceof BigDecimal) == false) goto L18;
            return ((BigDecimal) r100).setScale(0, RoundingMode.FLOOR);
        L18:
            if ((r100 instanceof Byte) == false) goto L20;
        L30:
            return r100;
        L20:
            if ((r100 instanceof Short) == true) goto L30;
            if ((r100 instanceof Integer) == true) goto L30;
            if ((r100 instanceof Long) == true) goto L30;
            if ((r100 instanceof BigInteger) == true) goto L30;
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            if ((r102 instanceof JSONArray) == false) goto L13;
            JSONArray r103 = (JSONArray) ((JSONArray) r102).clone();
            int r104 = 0;
        L6:
            if (r104 >= r103.size()) goto L11;
            Object r105 = r103.get(r104);
            Object r106 = floor(r105);
            if (r106 == r105) goto L10;
            r103.set(r104, r106);
        L10:
            r104 = r104 + 1;
            goto L6
        L11:
            return r103;
        L13:
            return floor(r102);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            throw new UnsupportedOperationException();
        }
    }

    public static class IntBetweenSegement extends PropertyFilter {
        private final long endValue;
        private final boolean not;
        private final long startValue;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            if (r104 != null) goto L7;
            return false;
        L7:
            if ((r104 instanceof Number) == false) goto L15;
            long r105 = TypeUtils.longExtractValue((Number) r104);
            if (r105 < this.startValue) goto L15;
            if (r105 > this.endValue) goto L15;
            return !this.not;
        L15:
            return this.not;
        }

        public IntBetweenSegement(String r100, boolean r101, long r102, long r103, boolean r104) {
            super(r100, r101);
            this.startValue = r102;
            this.endValue = r103;
            this.not = r104;
        }
    }

    public static class IntInSegement extends PropertyFilter {
        private final boolean not;
        private final long[] values;

        public IntInSegement(String r100, boolean r101, long[] r102, boolean r103) {
            super(r100, r101);
            this.values = r102;
            this.not = r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            int r105 = 0;
            if (r104 != null) goto L6;
            return false;
        L6:
            if ((r104 instanceof Number) == false) goto L15;
            long r106 = TypeUtils.longExtractValue((Number) r104);
            long[] r107 = this.values;
            int r108 = r107.length;
        L8:
            if (r105 >= r108) goto L15;
            if (r107[r105] == r106) goto L12;
            r105 = r105 + 1;
            goto L8
        L12:
            return !this.not;
        L15:
            return this.not;
        }
    }

    public static class IntObjInSegement extends PropertyFilter {
        private final boolean not;
        private final Long[] values;

        public IntObjInSegement(String r100, boolean r101, Long[] r102, boolean r103) {
            super(r100, r101);
            this.values = r102;
            this.not = r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            int r105 = 0;
            if (r104 != null) goto L14;
            Long[] r106 = this.values;
            int r107 = r106.length;
        L5:
            if (r105 >= r107) goto L12;
            if (r106[r105] == null) goto L9;
            r105 = r105 + 1;
            goto L5
        L9:
            return !this.not;
        L12:
            return this.not;
        L14:
            if ((r104 instanceof Number) == false) goto L26;
            long r108 = TypeUtils.longExtractValue((Number) r104);
            Long[] r109 = this.values;
            int r110 = r109.length;
        L16:
            if (r105 >= r110) goto L26;
            Long r111 = r109[r105];
            if (r111 == null) goto L24;
            if (r111.longValue() != r108) goto L24;
            return !this.not;
        L24:
            r105 = r105 + 1;
        L26:
            return this.not;
        }
    }

    public static class IntOpSegement extends PropertyFilter {

        /* JADX INFO: renamed from: op, reason: collision with root package name */
        private final Operator f24922op;
        private final long value;
        private BigDecimal valueDecimal;
        private Double valueDouble;
        private Float valueFloat;

        public IntOpSegement(String r100, boolean r101, long r102, Operator r103) {
            super(r100, r101);
            this.value = r102;
            this.f24922op = r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            if (r104 != null) goto L6;
            return false;
        L6:
            if ((r104 instanceof Number) == true) goto L9;
            return false;
        L9:
            if ((r104 instanceof BigDecimal) == false) goto L35;
            if (this.valueDecimal != null) goto L13;
            this.valueDecimal = BigDecimal.valueOf(this.value);
        L13:
            int r105 = this.valueDecimal.compareTo((BigDecimal) r104);
            switch(AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f24922op.ordinal()]) {
                case 1: goto L31;
                case 2: goto L28;
                case 3: goto L25;
                case 4: goto L22;
                case 5: goto L19;
                case 6: goto L16;
                default: goto L15;
            };
        L15:
            return false;
        L16:
            if (r105 <= 0) goto L113;
            return true;
        L113:
            return false;
        L19:
            if (r105 < 0) goto L114;
            return true;
        L114:
            return false;
        L22:
            if (r105 >= 0) goto L115;
            return true;
        L115:
            return false;
        L25:
            if (r105 > 0) goto L116;
            return true;
        L116:
            return false;
        L28:
            if (r105 == 0) goto L117;
            return true;
        L117:
            return false;
        L31:
            if (r105 != 0) goto L118;
            return true;
        L118:
            return false;
        L35:
            if ((r104 instanceof Float) == false) goto L61;
            if (this.valueFloat != null) goto L39;
            this.valueFloat = Float.valueOf(this.value);
        L39:
            int r106 = this.valueFloat.compareTo((Float) r104);
            switch(AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f24922op.ordinal()]) {
                case 1: goto L57;
                case 2: goto L54;
                case 3: goto L51;
                case 4: goto L48;
                case 5: goto L45;
                case 6: goto L42;
                default: goto L41;
            };
        L41:
            return false;
        L42:
            if (r106 <= 0) goto L119;
            return true;
        L119:
            return false;
        L45:
            if (r106 < 0) goto L120;
            return true;
        L120:
            return false;
        L48:
            if (r106 >= 0) goto L121;
            return true;
        L121:
            return false;
        L51:
            if (r106 > 0) goto L122;
            return true;
        L122:
            return false;
        L54:
            if (r106 == 0) goto L123;
            return true;
        L123:
            return false;
        L57:
            if (r106 != 0) goto L124;
            return true;
        L124:
            return false;
        L61:
            if ((r104 instanceof Double) == true) goto L63;
            long r107 = TypeUtils.longExtractValue((Number) r104);
            switch(AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f24922op.ordinal()]) {
                case 1: goto L110;
                case 2: goto L106;
                case 3: goto L102;
                case 4: goto L98;
                case 5: goto L94;
                case 6: goto L90;
                default: goto L88;
            };
        L88:
            return false;
        L90:
            if (r107 >= this.value) goto L131;
            return true;
        L131:
            return false;
        L94:
            if (r107 > this.value) goto L132;
            return true;
        L132:
            return false;
        L98:
            if (r107 <= this.value) goto L133;
            return true;
        L133:
            return false;
        L102:
            if (r107 < this.value) goto L134;
            return true;
        L134:
            return false;
        L106:
            if (r107 == this.value) goto L135;
            return true;
        L135:
            return false;
        L110:
            if (r107 != this.value) goto L136;
            return true;
        L136:
            return false;
        L63:
            if (this.valueDouble != null) goto L65;
            this.valueDouble = Double.valueOf(this.value);
        L65:
            int r108 = this.valueDouble.compareTo((Double) r104);
            switch(AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f24922op.ordinal()]) {
                case 1: goto L83;
                case 2: goto L80;
                case 3: goto L77;
                case 4: goto L74;
                case 5: goto L71;
                case 6: goto L68;
                default: goto L67;
            };
        L67:
            return false;
        L68:
            if (r108 <= 0) goto L125;
            return true;
        L125:
            return false;
        L71:
            if (r108 < 0) goto L126;
            return true;
        L126:
            return false;
        L74:
            if (r108 >= 0) goto L127;
            return true;
        L127:
            return false;
        L77:
            if (r108 > 0) goto L128;
            return true;
        L128:
            return false;
        L80:
            if (r108 == 0) goto L129;
            return true;
        L129:
            return false;
        L83:
            if (r108 != 0) goto L130;
            return true;
        L130:
            return false;
        }
    }

    public static class JSONPathParser {
        private static final Pattern strArrayPatternx = null;
        private static final String strArrayRegex = "'\\s*,\\s*'";

        /* JADX INFO: renamed from: ch, reason: collision with root package name */
        private char f24923ch;
        private boolean hasRefSegment;
        private int level;
        private final String path;
        private int pos;

        public static boolean isDigitFirst(char r100) {
            if (r100 != '-') goto L5;
        L12:
            return true;
        L5:
            if (r100 == '+') goto L12;
            if (r100 >= '0') goto L9;
        L11:
            return false;
        L9:
            if (r100 > '9') goto L11;
            goto L11
        }

        static {
            strArrayPatternx = PatternProtector.compile(strArrayRegex);
        }

        public Segment[] explain() {
            String r100 = this.path;
            if (r100 == null) goto L26;
            if (r100.length() == 0) goto L26;
            Segment[] r101 = new Segment[8];
        L7:
            Segment r102 = readSegement();
            if (r102 == null) goto L9;
            if ((r102 instanceof PropertySegment) == false) goto L21;
            PropertySegment r103 = (PropertySegment) r102;
            if (PropertySegment.access$100(r103) == true) goto L21;
            if (PropertySegment.access$400(r103).equals("*") == true) goto L7;
        L21:
            int r104 = this.level;
            if (r104 != r101.length) goto L24;
            Segment[] r105 = new Segment[(r104 * 3) / 2];
            System.arraycopy(r101, 0, r105, 0, r104);
            r101 = r105;
        L24:
            int r106 = this.level;
            this.level = r106 + 1;
            r101[r106] = r102;
            goto L7
        L9:
            int r107 = this.level;
            if (r107 != r101.length) goto L12;
            return r101;
        L12:
            Segment[] r108 = new Segment[r107];
            System.arraycopy(r101, 0, r108, 0, r107);
            return r108;
        L26:
            throw new IllegalArgumentException();
        }

        public char getNextChar() {
            return this.path.charAt(this.pos);
        }

        public boolean isEOF() {
            if (this.pos < this.path.length()) goto L5;
            return true;
        L5:
            return false;
        }

        public void next() {
            String r100 = this.path;
            int r101 = this.pos;
            this.pos = r101 + 1;
            this.f24923ch = r100.charAt(r101);
        }

        public long readLongValue() {
            int r100 = this.pos - 1;
            char r101 = this.f24923ch;
            if (r101 != '+') goto L5;
        L6:
            next();
        L7:
            char r102 = this.f24923ch;
            if (r102 < '0') goto L13;
            if (r102 > '9') goto L13;
            next();
        L13:
            return CastLongProtector.parseLong(this.path.substring(r100, this.pos - 1));
        L5:
            if (r101 != '-') goto L7;
            goto L6
        }

        public Operator readOp() {
            char r100 = this.f24923ch;
            if (r100 != '=') goto L11;
            next();
            char r101 = this.f24923ch;
            if (r101 != '~') goto L7;
            next();
            Operator r102 = Operator.REG_MATCH;
        L26:
            if (r102 != null) goto L60;
            String r103 = readName();
            if ("not".equalsIgnoreCase(r103) == false) goto L44;
            skipWhitespace();
            String r104 = readName();
            if (IStrategyStateSupplier.KEY_INFO_LIKE.equalsIgnoreCase(r104) == false) goto L33;
            return Operator.NOT_LIKE;
        L33:
            if ("rlike".equalsIgnoreCase(r104) == false) goto L36;
            return Operator.NOT_RLIKE;
        L36:
            if ("in".equalsIgnoreCase(r104) == false) goto L39;
            return Operator.NOT_IN;
        L39:
            if ("between".equalsIgnoreCase(r104) == false) goto L42;
            return Operator.NOT_BETWEEN;
        L42:
            throw new UnsupportedOperationException();
        L44:
            if ("nin".equalsIgnoreCase(r103) == false) goto L47;
            return Operator.NOT_IN;
        L47:
            if (IStrategyStateSupplier.KEY_INFO_LIKE.equalsIgnoreCase(r103) == false) goto L50;
            return Operator.LIKE;
        L50:
            if ("rlike".equalsIgnoreCase(r103) == false) goto L53;
            return Operator.RLIKE;
        L53:
            if ("in".equalsIgnoreCase(r103) == false) goto L56;
            return Operator.IN;
        L56:
            if ("between".equalsIgnoreCase(r103) == false) goto L59;
            return Operator.BETWEEN;
        L59:
            throw new UnsupportedOperationException();
        L60:
            return r102;
        L7:
            if (r101 != '=') goto L9;
            next();
            r102 = Operator.EQ;
            goto L26
        L9:
            r102 = Operator.EQ;
            goto L26
        L11:
            if (r100 != '!') goto L14;
            next();
            accept(a.f25612h);
            r102 = Operator.NE;
            goto L26
        L14:
            if (r100 != '<') goto L20;
            next();
            if (this.f24923ch != '=') goto L18;
            next();
            r102 = Operator.LE;
            goto L26
        L18:
            r102 = Operator.LT;
            goto L26
        L20:
            if (r100 != '>') goto L25;
            next();
            if (this.f24923ch != '=') goto L24;
            next();
            r102 = Operator.GE;
            goto L26
        L24:
            r102 = Operator.GT;
            goto L26
        L25:
            r102 = null;
            goto L26
        }

        public Segment readSegement() {
            boolean r100 = true;
            if (this.level != 0) goto L21;
            if (this.path.length() != 1) goto L21;
            if (isDigitFirst(this.f24923ch) == true) goto L9;
            char r101 = this.f24923ch;
            if (r101 < 'a') goto L15;
            if (r101 > 'z') goto L15;
        L19:
            return new PropertySegment(Character.toString(r101), false);
        L15:
            if (r101 < 'A') goto L21;
            if (r101 > 'Z') goto L21;
        L9:
            return new ArrayAccessSegment(this.f24923ch - '0');
        L21:
            if (isEOF() == true) goto L125;
            skipWhitespace();
            char r102 = this.f24923ch;
            if (r102 != '$') goto L29;
            next();
            skipWhitespace();
            if (this.f24923ch != '?') goto L21;
            return new FilterSegment((Filter) parseArrayAccessFilter(false));
        L29:
            if (r102 != '.') goto L31;
        L45:
            next();
            if (r102 == '.') goto L48;
        L61:
            boolean r103 = false;
        L62:
            char r104 = this.f24923ch;
            if (r104 == '*') goto L111;
            if (r103 == false) goto L68;
            if (r104 == '[') goto L111;
        L68:
            if (isDigitFirst(r104) == true) goto L70;
            String r105 = readName();
            if (this.f24923ch != '(') goto L110;
            next();
            if (this.f24923ch != ')') goto L108;
            if (isEOF() == true) goto L79;
            next();
        L79:
            if ("size".equals(r105) == true) goto L106;
            if ("length".equals(r105) == true) goto L106;
            if (BitableFieldEditAnalytic.ProgressFieldEditScene.MAX.equals(r105) == false) goto L88;
            return MaxSegment.instance;
        L88:
            if (BitableFieldEditAnalytic.ProgressFieldEditScene.MIN.equals(r105) == false) goto L92;
            return MinSegment.instance;
        L92:
            if ("keySet".equals(r105) == false) goto L96;
            return KeySetSegment.instance;
        L96:
            if ("type".equals(r105) == false) goto L100;
            return TypeSegment.instance;
        L100:
            if ("floor".equals(r105) == false) goto L104;
            return FloorSegment.instance;
        L104:
            throw new JSONPathException("not support jsonpath : " + this.path);
        L106:
            return SizeSegment.instance;
        L108:
            throw new JSONPathException("not support jsonpath : " + this.path);
        L110:
            return new PropertySegment(r105, r103);
        L70:
            return parseArrayAccess(false);
        L111:
            if (r104 == '[') goto L115;
            r100 = false;
        L115:
            if (isEOF() == true) goto L117;
            next();
        L117:
            if (r103 == false) goto L124;
            if (r100 == false) goto L122;
            return WildCardSegment.instance_deep_objectOnly;
        L122:
            return WildCardSegment.instance_deep;
        L124:
            return WildCardSegment.instance;
        L48:
            if (this.f24923ch != '.') goto L61;
            next();
            int r106 = this.path.length();
            int r107 = this.pos;
            if (r106 > (r107 + 3)) goto L52;
        L60:
            r103 = true;
            goto L62
        L52:
            if (this.f24923ch != '[') goto L60;
            if (this.path.charAt(r107) != '*') goto L60;
            if (this.path.charAt(this.pos + 1) != ']') goto L60;
            if (this.path.charAt(this.pos + 2) != '.') goto L60;
            next();
            next();
            next();
            next();
            goto L60
        L31:
            if (r102 == '/') goto L45;
            if (r102 != '[') goto L37;
            return parseArrayAccess(true);
        L37:
            if (this.level == 0) goto L39;
            if (r102 != '?') goto L44;
            return new FilterSegment((Filter) parseArrayAccessFilter(false));
        L44:
            throw new JSONPathException("not support jsonpath : " + this.path);
        L39:
            return new PropertySegment(readName(), false);
        L125:
            return null;
        }

        public String readString() {
            char r100 = this.f24923ch;
            next();
            int r101 = this.pos - 1;
        L4:
            if (this.f24923ch == r100) goto L8;
            if (isEOF() == true) goto L8;
            next();
        L8:
            String r102 = this.path;
            if (isEOF() == false) goto L11;
            int r103 = this.pos;
        L12:
            String r104 = r102.substring(r101, r103);
            accept(r100);
            return r104;
        L11:
            r103 = this.pos - 1;
            goto L12
        }

        public final void skipWhitespace() {
        L2:
            char r100 = this.f24923ch;
            if (r100 > ' ') goto L16;
            if (r100 == ' ') goto L15;
            if (r100 == '\r') goto L15;
            if (r100 == '\n') goto L15;
            if (r100 == '\t') goto L15;
            if (r100 == '\f') goto L15;
            if (r100 == '\b') goto L15;
            return;
        L15:
            next();
            goto L2
        }

        public String readName() {
            skipWhitespace();
            char r100 = this.f24923ch;
            if (r100 != '\\') goto L5;
        L9:
            StringBuilder r101 = new StringBuilder();
        L11:
            if (isEOF() == true) goto L24;
            char r102 = this.f24923ch;
            if (r102 == '\\') goto L14;
            if (Character.isJavaIdentifierPart(r102) == false) goto L24;
            r101.append(this.f24923ch);
            next();
            goto L11
        L14:
            next();
            r101.append(this.f24923ch);
            if (isEOF() == true) goto L17;
            next();
            goto L11
        L17:
            return r101.toString();
        L24:
            if (isEOF() == false) goto L29;
            if (Character.isJavaIdentifierPart(this.f24923ch) == false) goto L29;
            r101.append(this.f24923ch);
        L29:
            return r101.toString();
        L5:
            if (Character.isJavaIdentifierStart(r100) == true) goto L9;
            throw new JSONPathException("illeal jsonpath syntax. " + this.path);
        }

        public Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.f24923ch) == true) goto L5;
            char r100 = this.f24923ch;
            if (r100 == '\"') goto L22;
            if (r100 == '\'') goto L22;
            if (r100 != 'n') goto L20;
            if ("null".equals(readName()) == false) goto L18;
            return null;
        L18:
            throw new JSONPathException(this.path);
        L20:
            throw new UnsupportedOperationException();
        L22:
            return readString();
        L5:
            return Long.valueOf(readLongValue());
        }

        public JSONPathParser(String r100) {
            this.path = r100;
            next();
        }

        public static /* synthetic */ boolean access$000(JSONPathParser r100) {
            return r100.hasRefSegment;
        }

        public void accept(char r100) {
            if (this.f24923ch != ' ') goto L6;
            next();
        L6:
            if (this.f24923ch != r100) goto L12;
            if (isEOF() == true) goto L13;
            next();
            return;
        L13:
            return;
        L12:
            throw new JSONPathException("expect '" + r100 + ", but '" + this.f24923ch + "'");
        }

        public Segment buildArraySegement(String r110) {
            int r100 = r110.length();
            int r101 = 0;
            char r102 = r110.charAt(0);
            int r103 = 1;
            int r104 = r100 - 1;
            char r105 = r110.charAt(r104);
            int r106 = r110.indexOf(44);
            int r107 = -1;
            if (r110.length() > 2) goto L5;
        L16:
            int r108 = r110.indexOf(58);
            if (r106 != (-1)) goto L32;
            if (r108 != (-1)) goto L32;
            if (TypeUtils.isNumber(r110) == false) goto L26;
            return new ArrayAccessSegment(CastIntegerProtector.parseInt(r110));
        L24:
            return new PropertySegment(r110, false);
        L26:
            if (r110.charAt(0) != '\"') goto L31;
            if (r110.charAt(r110.length() - 1) != '\"') goto L31;
            r110 = r110.substring(1, r110.length() - 1);
        L31:
            return new PropertySegment(r110, false);
        L32:
            if (r106 == (-1)) goto L39;
            String[] r111 = r110.split(",");
            int[] r109 = new int[r111.length];
        L35:
            if (r101 >= r111.length) goto L38;
            r109[r101] = CastIntegerProtector.parseInt(r111[r101]);
            r101 = r101 + 1;
            goto L35
        L38:
            return new MultiIndexSegment(r109);
        L39:
            if (r108 == (-1)) goto L68;
            String[] r112 = r110.split(":");
            int r113 = r112.length;
            int[] r114 = new int[r113];
            int r115 = 0;
        L42:
            if (r115 >= r112.length) goto L51;
            String r116 = r112[r115];
            if (r116.length() != 0) goto L49;
            if (r115 != 0) goto L48;
            r114[r115] = 0;
        L50:
            r115 = r115 + 1;
            goto L42
        L48:
            throw new UnsupportedOperationException();
        L49:
            r114[r115] = CastIntegerProtector.parseInt(r116);
            goto L50
        L51:
            int r117 = r114[0];
            if (r113 <= 1) goto L55;
            r107 = r114[1];
        L55:
            if (r113 != 3) goto L57;
            r103 = r114[2];
        L57:
            if (r107 < 0) goto L62;
            if (r107 >= r117) goto L62;
            throw new UnsupportedOperationException("end must greater than or equals start. start " + r117 + ",  end " + r107);
        L62:
            if (r103 <= 0) goto L66;
            return new RangeSegment(r117, r107, r103);
        L66:
            throw new UnsupportedOperationException("step must greater than zero : " + r103);
        L68:
            throw new UnsupportedOperationException();
        L5:
            if (r102 != '\'') goto L16;
            if (r105 != '\'') goto L16;
            String r118 = r110.substring(1, r104);
            if (r106 == (-1)) goto L15;
            if (strArrayPatternx.matcher(r110).find() == false) goto L15;
            return new MultiPropertySegment(r118.split(strArrayRegex));
        L15:
            return new PropertySegment(r118, false);
        }

        public Filter filterRest(Filter r100) {
            char r101 = this.f24923ch;
            boolean r102 = true;
            if (r101 != '&') goto L5;
            boolean r103 = true;
        L6:
            if (r101 != '&') goto L10;
            if (getNextChar() != '&') goto L10;
        L13:
            next();
            next();
            if (this.f24923ch != '(') goto L16;
            next();
        L18:
            if (this.f24923ch != ' ') goto L20;
            next();
            goto L18
        L20:
            FilterGroup r104 = new FilterGroup(r100, (Filter) parseArrayAccessFilter(false), r103);
            if (r102 == false) goto L26;
            if (this.f24923ch != ')') goto L26;
            next();
        L26:
            return r104;
        L16:
            r102 = false;
        L10:
            if (this.f24923ch == '|') goto L12;
            return r100;
        L12:
            if (getNextChar() == '|') goto L13;
            return r100;
        L5:
            r103 = false;
            goto L6
        }

        public Segment parseArrayAccess(boolean r100) {
            Object r101 = parseArrayAccessFilter(r100);
            if ((r101 instanceof Segment) == false) goto L7;
            return (Segment) r101;
        L7:
            return new FilterSegment((Filter) r101);
        }

        public Object parseArrayAccessFilter(boolean r210) {
            if (r210 == false) goto L6;
            accept('[');
        L6:
            if (this.f24923ch != '?') goto L12;
            next();
            accept('(');
            int r100 = 1;
        L9:
            if (this.f24923ch != '(') goto L11;
            next();
            r100 = r100 + 1;
            goto L9
        L11:
            boolean r101 = true;
        L13:
            skipWhitespace();
            if (r101 == true) goto L86;
            if (IOUtils.firstIdentifier(this.f24923ch) == true) goto L86;
            if (Character.isJavaIdentifierStart(this.f24923ch) == true) goto L86;
            char r102 = this.f24923ch;
            if (r102 == '\\') goto L86;
            if (r102 == '@') goto L86;
            int r103 = this.pos - 1;
        L24:
            char r104 = this.f24923ch;
            if (r104 == ']') goto L38;
            if (r104 == '/') goto L38;
            if (isEOF() == true) goto L38;
            char r105 = this.f24923ch;
            if (r105 != '.') goto L35;
            if (r101 == true) goto L35;
            if (r101 == true) goto L35;
            if (r102 != '\'') goto L38;
        L35:
            if (r105 != '\\') goto L37;
            next();
        L37:
            next();
        L38:
            if (r210 == false) goto L41;
            int r106 = this.pos;
        L40:
            int r107 = r106 - 1;
        L47:
            String r108 = this.path.substring(r103, r107);
            if (r108.indexOf(92) == 0) goto L65;
            StringBuilder r109 = new StringBuilder(r108.length());
            int r110 = 0;
        L51:
            if (r110 >= r108.length()) goto L63;
            char r111 = r108.charAt(r110);
            if (r111 == '\\') goto L55;
        L61:
            r109.append(r111);
        L62:
            r110 = r110 + 1;
            goto L51
        L55:
            if (r110 >= (r108.length() - 1)) goto L61;
            int r112 = r110 + 1;
            char r113 = r108.charAt(r112);
            if (r113 == '@') goto L60;
            if (r111 == '\\') goto L60;
            if (r111 != '\"') goto L61;
        L60:
            r109.append(r113);
            r110 = r112;
            goto L62
        L63:
            r108 = r109.toString();
        L65:
            if (r108.indexOf(EasyGoConstant.VERSION_SEPARATIVE_SIGN) == (-1)) goto L79;
            if (r102 == '\'') goto L68;
        L72:
            String r114 = r108.replaceAll("\\\\\\.", EasyGoConstant.VERSION_SEPARATIVE_SIGN);
            if (r114.indexOf("\\-") == (-1)) goto L75;
            r114 = r114.replaceAll("\\\\-", "-");
        L75:
            if (r101 == false) goto L78;
            accept(')');
        L78:
            return new PropertySegment(r114, false);
        L68:
            if (r108.length() <= 2) goto L72;
            if (r108.charAt(r108.length() - 1) != r102) goto L72;
            r114 = r108.substring(1, r108.length() - 1);
            goto L75
        L79:
            Segment r115 = buildArraySegement(r108);
            if (r210 == true) goto L82;
        L84:
            return r115;
        L82:
            if (isEOF() == true) goto L84;
            accept(']');
            goto L84
        L41:
            char r116 = this.f24923ch;
            if (r116 == '/') goto L46;
            if (r116 == '.') goto L46;
            r107 = this.pos;
        L46:
            r106 = this.pos;
        L86:
            if (this.f24923ch != '@') goto L88;
            next();
            accept('.');
        L88:
            String r117 = readName();
            skipWhitespace();
            if (r101 == false) goto L103;
            if (this.f24923ch != ')') goto L103;
            next();
            Filter r118 = new NotNullSegement(r117, false);
        L93:
            char r119 = this.f24923ch;
            if (r119 != ' ') goto L96;
            next();
            goto L93
        L96:
            if (r119 == '&') goto L98;
            if (r119 == '|') goto L98;
        L99:
            if (r210 == false) goto L101;
            accept(']');
        L101:
            return r118;
        L98:
            r118 = filterRest(r118);
        L103:
            if (r210 == true) goto L105;
        L125:
            skipWhitespace();
            if (this.f24923ch != '(') goto L128;
            next();
            accept(')');
            skipWhitespace();
            boolean r120 = true;
        L129:
            Operator r121 = readOp();
            skipWhitespace();
            if (r121 == Operator.BETWEEN) goto L479;
            if (r121 == Operator.NOT_BETWEEN) goto L479;
            if (r121 == Operator.IN) goto L338;
            if (r121 == Operator.NOT_IN) goto L338;
            char r122 = this.f24923ch;
            if (r122 == '\'') goto L274;
            if (r122 == '\"') goto L274;
            if (isDigitFirst(r122) == false) goto L169;
            long r123 = readLongValue();
            if (this.f24923ch != '.') goto L148;
            double r211 = readDoubleValue(r123);
        L150:
            if (r211 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L152;
            Filter r124 = new IntOpSegement(r117, r120, r123, r121);
        L153:
            char r125 = this.f24923ch;
            if (r125 != ' ') goto L156;
            next();
            goto L153
        L156:
            if (r100 > 1) goto L158;
        L160:
            char r126 = this.f24923ch;
            if (r126 == '&') goto L163;
            if (r126 == '|') goto L163;
        L164:
            if (r101 == false) goto L166;
            accept(')');
        L166:
            if (r210 == false) goto L168;
            accept(']');
        L168:
            return r124;
        L163:
            r124 = filterRest(r124);
            goto L164
        L158:
            if (r125 != ')') goto L160;
            next();
            goto L160
        L152:
            r124 = new DoubleOpSegement(r117, r120, r211, r121);
            goto L153
        L148:
            r211 = 0.0d;
            goto L150
        L169:
            char r127 = this.f24923ch;
            if (r127 != '$') goto L180;
            RefOpSegement r128 = new RefOpSegement(r117, r120, readSegement(), r121);
            this.hasRefSegment = true;
        L173:
            if (this.f24923ch != ' ') goto L175;
            next();
            goto L173
        L175:
            if (r101 == false) goto L177;
            accept(')');
        L177:
            if (r210 == false) goto L179;
            accept(']');
        L179:
            return r128;
        L180:
            if (r127 != '/') goto L198;
            StringBuilder r129 = new StringBuilder();
        L182:
            next();
            char r130 = this.f24923ch;
            if (r130 == '/') goto L184;
            if (r130 == '\\') goto L195;
            r129.append(r130);
            goto L182
        L195:
            next();
            r129.append(this.f24923ch);
            goto L182
        L184:
            next();
            if (this.f24923ch != 'i') goto L187;
            next();
            int r131 = 2;
        L188:
            RegMatchSegement r132 = new RegMatchSegement(r117, r120, PatternProtector.compile(r129.toString(), r131), r121);
            if (r101 == false) goto L191;
            accept(')');
        L191:
            if (r210 == false) goto L193;
            accept(']');
        L193:
            return r132;
        L187:
            r131 = 0;
            goto L188
        L198:
            if (r127 != 'n') goto L223;
            if ("null".equals(readName()) == false) goto L273;
            if (r121 != Operator.EQ) goto L205;
            Filter r133 = new NullSegement(r117, r120);
        L208:
            if (r133 == null) goto L215;
        L209:
            char r134 = this.f24923ch;
            if (r134 != ' ') goto L212;
            next();
            goto L209
        L212:
            if (r134 == '&') goto L214;
            if (r134 != '|') goto L215;
        L214:
            r133 = filterRest(r133);
        L215:
            if (r101 == false) goto L217;
            accept(')');
        L217:
            accept(']');
            if (r133 == null) goto L221;
            return r133;
        L221:
            throw new UnsupportedOperationException();
        L205:
            if (r121 != Operator.NE) goto L207;
            r133 = new NotNullSegement(r117, r120);
            goto L208
        L207:
            r133 = null;
        L273:
            throw new UnsupportedOperationException();
        L223:
            if (r127 != 't') goto L248;
            if ("true".equals(readName()) == false) goto L273;
            if (r121 != Operator.EQ) goto L230;
            Filter r135 = new ValueSegment(r117, r120, Boolean.TRUE, true);
        L233:
            if (r135 == null) goto L240;
        L234:
            char r136 = this.f24923ch;
            if (r136 != ' ') goto L237;
            next();
            goto L234
        L237:
            if (r136 == '&') goto L239;
            if (r136 != '|') goto L240;
        L239:
            r135 = filterRest(r135);
        L240:
            if (r101 == false) goto L242;
            accept(')');
        L242:
            accept(']');
            if (r135 == null) goto L246;
            return r135;
        L246:
            throw new UnsupportedOperationException();
        L230:
            if (r121 != Operator.NE) goto L232;
            r135 = new ValueSegment(r117, r120, Boolean.TRUE, false);
            goto L233
        L232:
            r135 = null;
            goto L233
        L248:
            if (r127 != 'f') goto L273;
            if ("false".equals(readName()) == false) goto L273;
            if (r121 != Operator.EQ) goto L255;
            Filter r137 = new ValueSegment(r117, r120, Boolean.FALSE, true);
        L258:
            if (r137 == null) goto L265;
        L259:
            char r138 = this.f24923ch;
            if (r138 != ' ') goto L262;
            next();
            goto L259
        L262:
            if (r138 == '&') goto L264;
            if (r138 != '|') goto L265;
        L264:
            r137 = filterRest(r137);
        L265:
            if (r101 == false) goto L267;
            accept(')');
        L267:
            accept(']');
            if (r137 == null) goto L271;
            return r137;
        L271:
            throw new UnsupportedOperationException();
        L255:
            if (r121 != Operator.NE) goto L257;
            r137 = new ValueSegment(r117, r120, Boolean.FALSE, false);
            goto L258
        L257:
            r137 = null;
        L274:
            String r139 = readString();
            if (r121 != Operator.RLIKE) goto L278;
            Filter r140 = new RlikeSegement(r117, r120, r139, false);
        L326:
            char r141 = this.f24923ch;
            if (r141 != ' ') goto L329;
            next();
            goto L326
        L329:
            if (r141 == '&') goto L331;
            if (r141 == '|') goto L331;
        L332:
            if (r101 == false) goto L334;
            accept(')');
        L334:
            if (r210 == false) goto L336;
            accept(']');
        L336:
            return r140;
        L331:
            r140 = filterRest(r140);
            goto L332
        L278:
            if (r121 != Operator.NOT_RLIKE) goto L282;
            Filter r142 = new RlikeSegement(r117, r120, r139, true);
        L280:
            r140 = r142;
            goto L326
        L282:
            if (r121 == Operator.LIKE) goto L288;
            if (r121 == Operator.NOT_LIKE) goto L288;
            r140 = new StringOpSegement(r117, r120, r139, r121);
        L288:
            if (r139.indexOf("%%") == (-1)) goto L291;
            r139 = r139.replaceAll("%%", GXTemplateKey.GAIAX_PE);
            goto L288
        L291:
            if (r121 != Operator.NOT_LIKE) goto L293;
            boolean r212 = true;
        L294:
            int r143 = r139.indexOf(37);
            if (r143 == (-1)) goto L297;
            String[] r144 = r139.split(GXTemplateKey.GAIAX_PE);
            if (r143 != 0) goto L312;
            if (r139.charAt(r139.length() - 1) != '%') goto L307;
            int r145 = r144.length - 1;
            String[] r146 = new String[r145];
            System.arraycopy(r144, 1, r146, 0, r145);
            String[] r213 = r146;
        L306:
            String r214 = null;
            String r215 = null;
        L325:
            r140 = new MatchSegement(r117, r120, r214, r215, r213, r212);
            goto L326
        L307:
            String r147 = r144[r144.length - 1];
            if (r144.length <= 2) goto L310;
            int r148 = r144.length - 2;
            String[] r149 = new String[r148];
            System.arraycopy(r144, 1, r149, 0, r148);
            r215 = r147;
            r213 = r149;
            r214 = null;
            goto L325
        L310:
            r215 = r147;
            r214 = null;
            r213 = null;
            goto L325
        L312:
            if (r139.charAt(r139.length() - 1) != '%') goto L318;
            if (r144.length != 1) goto L316;
            String r150 = r144[0];
        L320:
            r214 = r150;
            r215 = null;
            r213 = null;
            goto L325
        L316:
            r213 = r144;
            goto L306
        L318:
            if (r144.length != 1) goto L322;
            r150 = r144[0];
            goto L320
        L322:
            if (r144.length != 2) goto L324;
            r214 = r144[0];
            r215 = r144[1];
            r213 = null;
            goto L325
        L324:
            String r151 = r144[0];
            String r152 = r144[r144.length - 1];
            int r153 = r144.length - 2;
            String[] r154 = new String[r153];
            System.arraycopy(r144, 1, r154, 0, r153);
            r214 = r151;
            r213 = r154;
            r215 = r152;
            goto L325
        L297:
            if (r121 != Operator.LIKE) goto L299;
            Operator r155 = Operator.EQ;
        L300:
            r142 = new StringOpSegement(r117, r120, r139, r155);
            goto L280
        L299:
            r155 = Operator.NE;
            goto L300
        L293:
            r212 = false;
        L338:
            if (r121 != Operator.NOT_IN) goto L340;
            boolean r156 = true;
        L341:
            accept('(');
            JSONArray r157 = new JSONArray();
            r157.add(readValue());
        L342:
            skipWhitespace();
            if (this.f24923ch != ',') goto L344;
            next();
            r157.add(readValue());
            goto L342
        L344:
            Iterator<Object> r158 = r157.iterator();
            boolean r159 = true;
            boolean r160 = true;
            boolean r161 = true;
        L346:
            if (r158.hasNext() == false) goto L367;
            Object r162 = r158.next();
            if (r162 == null) goto L349;
            Class<?> r163 = r162.getClass();
            if (r159 == true) goto L354;
        L362:
            if (r160 == false) goto L346;
            if (r163 == String.class) goto L346;
            r160 = false;
            goto L346
        L354:
            if (r163 == Byte.class) goto L362;
            if (r163 == Short.class) goto L362;
            if (r163 == Integer.class) goto L362;
            if (r163 == Long.class) goto L362;
            r159 = false;
            r161 = false;
            goto L362
        L349:
            if (r159 == false) goto L346;
            r159 = false;
            goto L346
        L367:
            if (r157.size() == 1) goto L369;
        L385:
            if (r159 == true) goto L387;
            if (r160 == true) goto L423;
            int r164 = 0;
            if (r161 == false) goto L476;
            int r165 = r157.size();
            Long[] r166 = new Long[r165];
        L457:
            if (r164 >= r165) goto L462;
            Number r167 = (Number) ListProtector.get(r157, r164);
            if (r167 == null) goto L461;
            r166[r164] = Long.valueOf(TypeUtils.longExtractValue(r167));
        L461:
            r164 = r164 + 1;
            goto L457
        L462:
            Filter r168 = new IntObjInSegement(r117, r120, r166, r156);
        L463:
            char r169 = this.f24923ch;
            if (r169 != ' ') goto L466;
            next();
            goto L463
        L466:
            if (r169 == '&') goto L468;
            if (r169 == '|') goto L468;
        L469:
            accept(')');
            if (r101 == false) goto L472;
            accept(')');
        L472:
            if (r210 == false) goto L474;
            accept(']');
        L474:
            return r168;
        L468:
            r168 = filterRest(r168);
            goto L469
        L476:
            throw new UnsupportedOperationException();
        L423:
            if (r157.size() != 1) goto L441;
            String r170 = (String) ListProtector.get(r157, 0);
            if (r156 == false) goto L427;
            Operator r171 = Operator.NE;
        L428:
            Filter r172 = new StringOpSegement(r117, r120, r170, r171);
        L429:
            char r173 = this.f24923ch;
            if (r173 != ' ') goto L432;
            next();
            goto L429
        L432:
            if (r173 == '&') goto L434;
            if (r173 == '|') goto L434;
        L435:
            accept(')');
            if (r101 == false) goto L438;
            accept(')');
        L438:
            if (r210 == false) goto L440;
            accept(']');
        L440:
            return r172;
        L434:
            r172 = filterRest(r172);
            goto L435
        L427:
            r171 = Operator.EQ;
            goto L428
        L441:
            String[] r174 = new String[r157.size()];
            r157.toArray(r174);
            Filter r175 = new StringInSegement(r117, r120, r174, r156);
        L442:
            char r176 = this.f24923ch;
            if (r176 != ' ') goto L445;
            next();
            goto L442
        L445:
            if (r176 == '&') goto L447;
            if (r176 == '|') goto L447;
        L448:
            accept(')');
            if (r101 == false) goto L451;
            accept(')');
        L451:
            if (r210 == false) goto L453;
            accept(']');
        L453:
            return r175;
        L447:
            r175 = filterRest(r175);
            goto L448
        L387:
            if (r157.size() != 1) goto L405;
            long r216 = TypeUtils.longExtractValue((Number) ListProtector.get(r157, 0));
            if (r156 == false) goto L391;
            Operator r177 = Operator.NE;
        L392:
            Filter r178 = new IntOpSegement(r117, r120, r216, r177);
        L393:
            char r179 = this.f24923ch;
            if (r179 != ' ') goto L396;
            next();
            goto L393
        L396:
            if (r179 == '&') goto L398;
            if (r179 == '|') goto L398;
        L399:
            accept(')');
            if (r101 == false) goto L402;
            accept(')');
        L402:
            if (r210 == false) goto L404;
            accept(']');
        L404:
            return r178;
        L398:
            r178 = filterRest(r178);
            goto L399
        L391:
            r177 = Operator.EQ;
            goto L392
        L405:
            int r180 = r157.size();
            long[] r181 = new long[r180];
            int r182 = 0;
        L406:
            if (r182 >= r180) goto L408;
            r181[r182] = TypeUtils.longExtractValue((Number) ListProtector.get(r157, r182));
            r182 = r182 + 1;
            goto L406
        L408:
            Filter r183 = new IntInSegement(r117, r120, r181, r156);
        L409:
            char r184 = this.f24923ch;
            if (r184 != ' ') goto L412;
            next();
            goto L409
        L412:
            if (r184 == '&') goto L414;
            if (r184 == '|') goto L414;
        L415:
            accept(')');
            if (r101 == false) goto L418;
            accept(')');
        L418:
            if (r210 == false) goto L420;
            accept(']');
        L420:
            return r183;
        L414:
            r183 = filterRest(r183);
            goto L415
        L369:
            if (ListProtector.get(r157, 0) != null) goto L385;
            if (r156 == false) goto L372;
            Filter r185 = new NotNullSegement(r117, r120);
        L373:
            char r186 = this.f24923ch;
            if (r186 != ' ') goto L376;
            next();
            goto L373
        L376:
            if (r186 == '&') goto L378;
            if (r186 == '|') goto L378;
        L379:
            accept(')');
            if (r101 == false) goto L382;
            accept(')');
        L382:
            if (r210 == false) goto L384;
            accept(']');
        L384:
            return r185;
        L378:
            r185 = filterRest(r185);
            goto L379
        L372:
            r185 = new NullSegement(r117, r120);
            goto L373
        L340:
            r156 = false;
        L479:
            if (r121 != Operator.NOT_BETWEEN) goto L481;
            boolean r217 = true;
        L482:
            Object r187 = readValue();
            if ("and".equalsIgnoreCase(readName()) == false) goto L498;
            Object r188 = readValue();
            if (r187 == null) goto L496;
            if (r188 == null) goto L496;
            if (JSONPath.isInt(r187.getClass()) == false) goto L494;
            if (JSONPath.isInt(r188.getClass()) == false) goto L494;
            return new IntBetweenSegement(r117, r120, TypeUtils.longExtractValue((Number) r187), TypeUtils.longExtractValue((Number) r188), r217);
        L494:
            throw new JSONPathException(this.path);
        L496:
            throw new JSONPathException(this.path);
        L498:
            throw new JSONPathException(this.path);
        L481:
            r217 = false;
            goto L482
        L128:
            r120 = false;
            goto L129
        L105:
            if (this.f24923ch != ']') goto L125;
            if (isEOF() == true) goto L109;
        L112:
            next();
            Filter r189 = new NotNullSegement(r117, false);
        L113:
            char r190 = this.f24923ch;
            if (r190 != ' ') goto L116;
            next();
            goto L113
        L116:
            if (r190 == '&') goto L118;
            if (r190 == '|') goto L118;
        L119:
            accept(')');
            if (r101 == false) goto L122;
            accept(')');
        L122:
            if (r210 == false) goto L124;
            accept(']');
        L124:
            return r189;
        L118:
            r189 = filterRest(r189);
            goto L119
        L109:
            if (r117.equals("last") == false) goto L112;
            return new MultiIndexSegment(new int[]{-1});
        L12:
            r100 = 0;
            r101 = false;
            goto L13
        }

        public double readDoubleValue(long r100) {
            int r101 = this.pos - 1;
            next();
        L3:
            char r102 = this.f24923ch;
            if (r102 < '0') goto L9;
            if (r102 > '9') goto L9;
            next();
        L9:
            return CastDoubleProtector.parseDouble(this.path.substring(r101, this.pos - 1)) + r100;
        }
    }

    public static class KeySetSegment implements Segment {
        public static final KeySetSegment instance = null;

        public KeySetSegment() {
        }

        static {
            instance = new KeySetSegment();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            return r100.evalKeySet(r102);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            throw new UnsupportedOperationException();
        }
    }

    public static class MatchSegement extends PropertyFilter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String startsWithValue;

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            int r105 = 0;
            if (r104 != null) goto L5;
            return false;
        L5:
            String r106 = r104.toString();
            if (r106.length() < this.minLength) goto L8;
            String r107 = this.startsWithValue;
            if (r107 != null) goto L12;
            int r108 = 0;
        L17:
            String[] r109 = this.containsValues;
            if (r109 == null) goto L26;
            int r110 = r109.length;
        L20:
            if (r105 >= r110) goto L26;
            String r111 = r109[r105];
            int r112 = r106.indexOf(r111, r108);
            if (r112 == (-1)) goto L24;
            r108 = r112 + r111.length();
            r105 = r105 + 1;
            goto L20
        L24:
            return this.not;
        L26:
            String r113 = this.endsWithValue;
            if (r113 == null) goto L33;
            if (r106.endsWith(r113) == true) goto L33;
            return this.not;
        L33:
            return !this.not;
        L12:
            if (r106.startsWith(r107) == false) goto L14;
            r108 = this.startsWithValue.length() + 0;
            goto L17
        L14:
            return this.not;
        L8:
            return this.not;
        }

        public MatchSegement(String r100, boolean r101, String r102, String r103, String[] r104, boolean r105) {
            super(r100, r101);
            this.startsWithValue = r102;
            this.endsWithValue = r103;
            this.containsValues = r104;
            this.not = r105;
            int r106 = 0;
            if (r102 == null) goto L5;
            int r107 = r102.length() + 0;
        L6:
            if (r103 == null) goto L8;
            r107 = r107 + r103.length();
        L8:
            if (r104 == null) goto L12;
            int r108 = r104.length;
        L10:
            if (r106 >= r108) goto L12;
            r107 = r107 + r104[r106].length();
            r106 = r106 + 1;
        L12:
            this.minLength = r107;
            return;
        L5:
            r107 = 0;
            goto L6
        }
    }

    public static class MaxSegment implements Segment {
        public static final MaxSegment instance = null;

        public MaxSegment() {
        }

        static {
            instance = new MaxSegment();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            if ((r102 instanceof Collection) == false) goto L17;
            Iterator r103 = ((Collection) r102).iterator();
            Object r104 = null;
        L6:
            if (r103.hasNext() == false) goto L15;
            Object r105 = r103.next();
            if (r105 == null) goto L6;
            if (r104 == null) goto L14;
            if (JSONPath.compare(r104, r105) >= 0) goto L6;
        L14:
            r104 = r105;
            goto L6
        L15:
            return r104;
        L17:
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            throw new UnsupportedOperationException();
        }
    }

    public static class MinSegment implements Segment {
        public static final MinSegment instance = null;

        public MinSegment() {
        }

        static {
            instance = new MinSegment();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            if ((r102 instanceof Collection) == false) goto L17;
            Iterator r103 = ((Collection) r102).iterator();
            Object r104 = null;
        L6:
            if (r103.hasNext() == false) goto L15;
            Object r105 = r103.next();
            if (r105 == null) goto L6;
            if (r104 == null) goto L14;
            if (JSONPath.compare(r104, r105) <= 0) goto L6;
        L14:
            r104 = r105;
            goto L6
        L15:
            return r104;
        L17:
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            throw new UnsupportedOperationException();
        }
    }

    public static class MultiIndexSegment implements Segment {
        private final int[] indexes;

        public MultiIndexSegment(int[] r100) {
            this.indexes = r100;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            JSONArray r103 = new JSONArray(this.indexes.length);
            int r104 = 0;
        L3:
            int[] r105 = this.indexes;
            if (r104 >= r105.length) goto L6;
            r103.add(r100.getArrayItem(r102, r105[r104]));
            r104 = r104 + 1;
            goto L3
        L6:
            return r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            if (r102.eval == false) goto L20;
            Object r103 = r101.parse();
            if ((r103 instanceof List) == false) goto L20;
            int[] r104 = this.indexes;
            int r105 = r104.length;
            int[] r106 = new int[r105];
            boolean r107 = false;
            System.arraycopy(r104, 0, r106, 0, r105);
            if (r106[0] < 0) goto L9;
            r107 = true;
        L9:
            List r108 = (List) r103;
            if (r107 == false) goto L20;
            int r109 = r108.size() - 1;
        L12:
            if (r109 < 0) goto L17;
            if (Arrays.binarySearch(r106, r109) >= 0) goto L16;
            ListProtector.remove(r108, r109);
        L16:
            r109 = r109 - 1;
            goto L12
        L17:
            r102.object = r108;
            return;
        L20:
            throw new UnsupportedOperationException();
        }
    }

    public static class MultiPropertySegment implements Segment {
        private final String[] propertyNames;
        private final long[] propertyNamesHash;

        public MultiPropertySegment(String[] r100) {
            this.propertyNames = r100;
            this.propertyNamesHash = new long[r100.length];
            int r101 = 0;
        L3:
            long[] r102 = this.propertyNamesHash;
            if (r101 >= r102.length) goto L6;
            r102[r101] = TypeUtils.fnv1a_64(r100[r101]);
            r101 = r101 + 1;
            goto L3
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            ArrayList r103 = new ArrayList(this.propertyNames.length);
            int r104 = 0;
        L3:
            String[] r105 = this.propertyNames;
            if (r104 >= r105.length) goto L6;
            r103.add(r100.getPropertyValue(r102, r105[r104], this.propertyNamesHash[r104]));
            r104 = r104 + 1;
            goto L3
        L6:
            return r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            JSONLexerBase r103 = (JSONLexerBase) r101.lexer;
            Object r104 = r102.object;
            if (r104 != null) goto L5;
            JSONArray r105 = new JSONArray();
            r102.object = r105;
        L6:
            int r106 = r105.size();
        L8:
            if (r106 >= this.propertyNamesHash.length) goto L10;
            r105.add(null);
            r106 = r106 + 1;
        L10:
            int r107 = r103.seekObjectToField(this.propertyNamesHash);
            if (r103.matchStat != 3) goto L24;
            int r108 = r103.token();
            if (r108 == 2) goto L20;
            if (r108 != 3) goto L16;
            Object r109 = r103.decimalValue();
            r103.nextToken(16);
        L21:
            r105.set(r107, r109);
            if (r103.token() == 16) goto L10;
            return;
        L16:
            if (r108 == 4) goto L18;
            r109 = r101.parse();
            goto L21
        L18:
            r109 = r103.stringVal();
            r103.nextToken(16);
            goto L21
        L20:
            r109 = r103.integerValue();
            r103.nextToken(16);
            goto L21
        L24:
            return;
        L5:
            r105 = (JSONArray) r104;
            goto L6
        }
    }

    public static class NotNullSegement extends PropertyFilter {
        public NotNullSegement(String r100, boolean r101) {
            super(r100, r101);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            if (r100.getPropertyValue(r103, this.propertyName, this.propertyNameHash) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static class NullSegement extends PropertyFilter {
        public NullSegement(String r100, boolean r101) {
            super(r100, r101);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            if (get(r100, r101, r103) != null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final enum Operator extends Enum<Operator> {
        private static final /* synthetic */ Operator[] $VALUES = null;
        public static final Operator And = null;
        public static final Operator BETWEEN = null;
        public static final Operator EQ = null;
        public static final Operator GE = null;
        public static final Operator GT = null;
        public static final Operator IN = null;
        public static final Operator LE = null;
        public static final Operator LIKE = null;
        public static final Operator LT = null;
        public static final Operator NE = null;
        public static final Operator NOT_BETWEEN = null;
        public static final Operator NOT_IN = null;
        public static final Operator NOT_LIKE = null;
        public static final Operator NOT_RLIKE = null;
        public static final Operator Or = null;
        public static final Operator REG_MATCH = null;
        public static final Operator RLIKE = null;

        static {
            Operator r100 = new Operator("EQ", 0);
            EQ = r100;
            Operator r101 = new Operator("NE", 1);
            NE = r101;
            Operator r102 = new Operator("GT", 2);
            GT = r102;
            Operator r103 = new Operator("GE", 3);
            GE = r103;
            Operator r104 = new Operator("LT", 4);
            LT = r104;
            Operator r105 = new Operator("LE", 5);
            LE = r105;
            Operator r110 = new Operator("LIKE", 6);
            LIKE = r110;
            Operator r111 = new Operator("NOT_LIKE", 7);
            NOT_LIKE = r111;
            Operator r112 = new Operator("RLIKE", 8);
            RLIKE = r112;
            Operator r113 = new Operator("NOT_RLIKE", 9);
            NOT_RLIKE = r113;
            Operator r114 = new Operator("IN", 10);
            IN = r114;
            Operator r115 = new Operator("NOT_IN", 11);
            NOT_IN = r115;
            Operator r106 = new Operator("BETWEEN", 12);
            BETWEEN = r106;
            Operator r107 = new Operator("NOT_BETWEEN", 13);
            NOT_BETWEEN = r107;
            Operator r108 = new Operator("And", 14);
            And = r108;
            Operator r109 = new Operator("Or", 15);
            Or = r109;
            Operator r116 = new Operator("REG_MATCH", 16);
            REG_MATCH = r116;
            $VALUES = new Operator[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
        }

        public static Operator[] values() {
            return (Operator[]) $VALUES.clone();
        }

        public static Operator valueOf(String r100) {
            return (Operator) r27.a.a(Operator.class, r100);
        }

        private Operator(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class PropertyFilter implements Filter {
        static long TYPE;
        protected final boolean function;
        protected Segment functionExpr;
        protected final String propertyName;
        protected final long propertyNameHash;

        static {
            TYPE = TypeUtils.fnv1a_64("type");
        }

        public PropertyFilter(String r100, boolean r101) {
            this.propertyName = r100;
            long r102 = TypeUtils.fnv1a_64(r100);
            this.propertyNameHash = r102;
            this.function = r101;
            if (r101 == true) goto L5;
            return;
        L5:
            if (r102 != TYPE) goto L8;
            this.functionExpr = TypeSegment.instance;
            return;
        L8:
            if (r102 != JSONPath.SIZE) goto L11;
            this.functionExpr = SizeSegment.instance;
            return;
        L11:
            throw new JSONPathException("unsupported funciton : " + r100);
        }

        public Object get(JSONPath r100, Object r101, Object r102) {
            Segment r103 = this.functionExpr;
            if (r103 == null) goto L7;
            return r103.eval(r100, r101, r102);
        L7:
            return r100.getPropertyValue(r102, this.propertyName, this.propertyNameHash);
        }
    }

    public static class PropertySegment implements Segment {
        private final boolean deep;
        private final String propertyName;
        private final long propertyNameHash;

        public static /* synthetic */ boolean access$100(PropertySegment r100) {
            return r100.deep;
        }

        public static /* synthetic */ String access$400(PropertySegment r100) {
            return r100.propertyName;
        }

        public PropertySegment(String r100, boolean r101) {
            this.propertyName = r100;
            this.propertyNameHash = TypeUtils.fnv1a_64(r100);
            this.deep = r101;
        }

        public boolean remove(JSONPath r100, Object r101) {
            return r100.removePropertyValue(r101, this.propertyName, this.deep);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            if (this.deep == false) goto L7;
            ArrayList r103 = new ArrayList();
            r100.deepScan(r102, this.propertyName, r103);
            return r103;
        L7:
            return r100.getPropertyValue(r102, this.propertyName, this.propertyNameHash);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r110, DefaultJSONParser r111, Context r112) {
            JSONLexerBase r100 = (JSONLexerBase) r111.lexer;
            if (this.deep == false) goto L8;
            if (r112.object != null) goto L8;
            r112.object = new JSONArray();
        L8:
            if (r100.token() == 14) goto L10;
            boolean r101 = this.deep;
            if (r101 == false) goto L64;
        L79:
            int r102 = r100.seekObjectToField(this.propertyNameHash, this.deep);
            if (r102 == (-1)) goto L81;
            if (r102 == 3) goto L84;
            if (r102 == 1) goto L107;
            if (r102 != 2) goto L79;
        L107:
            extract(r110, r111, r112);
            goto L79
        L84:
            if (r112.eval == false) goto L79;
            int r103 = r100.token();
            if (r103 == 2) goto L92;
            if (r103 == 3) goto L91;
            if (r103 == 4) goto L90;
            Object r104 = r111.parse();
        L94:
            if (r112.eval == false) goto L79;
            Object r105 = r112.object;
            if ((r105 instanceof List) == true) goto L97;
            r112.object = r104;
            goto L79
        L97:
            List r106 = (List) r105;
            if (r106.size() != 0) goto L102;
            if ((r104 instanceof List) == false) goto L102;
            r112.object = r104;
        L102:
            r106.add(r104);
            goto L79
        L90:
            r104 = r100.stringVal();
            r100.nextToken(16);
            goto L94
        L91:
            r104 = r100.decimalValue();
            r100.nextToken(16);
            goto L94
        L92:
            r104 = r100.integerValue();
            r100.nextToken(16);
            goto L94
        L81:
            return;
        L64:
            if (r100.seekObjectToField(this.propertyNameHash, r101) == 3) goto L66;
            return;
        L66:
            if (r112.eval == false) goto L146;
            int r107 = r100.token();
            if (r107 == 2) goto L74;
            if (r107 == 3) goto L73;
            if (r107 == 4) goto L72;
            Object r108 = r111.parse();
        L76:
            if (r112.eval == false) goto L147;
            r112.object = r108;
            return;
        L147:
            return;
        L72:
            r108 = r100.stringVal();
            r100.nextToken(16);
            goto L76
        L73:
            r108 = r100.decimalValue();
            r100.nextToken(16);
            goto L76
        L74:
            r108 = r100.integerValue();
            r100.nextToken(16);
            goto L76
        L146:
            return;
        L10:
            if ("*".equals(this.propertyName) == false) goto L12;
            return;
        L12:
            r100.nextToken();
            if (this.deep == false) goto L15;
            JSONArray r109 = (JSONArray) r112.object;
        L16:
            int r113 = r100.token();
            if (r113 != 12) goto L18;
            boolean r114 = this.deep;
            if (r114 == true) goto L28;
            int r115 = r100.seekObjectToField(this.propertyNameHash, r114);
            if (r115 == 3) goto L31;
            if (r115 == (-1)) goto L16;
            if (this.deep == true) goto L60;
            r100.skipObject(false);
        L47:
            if (r100.token() == 15) goto L48;
            if (r100.token() != 16) goto L58;
            r100.nextToken();
            goto L16
        L58:
            throw new JSONException("illegal json : " + r100.info());
        L48:
            r100.nextToken();
            if (this.deep == false) goto L51;
            return;
        L51:
            if (r109.size() <= 0) goto L144;
            r112.object = r109;
            return;
        L144:
            return;
        L60:
            throw new UnsupportedOperationException(r100.info());
        L31:
            int r116 = r100.token();
            if (r116 == 2) goto L36;
            if (r116 == 4) goto L35;
            Object r117 = r111.parse();
        L37:
            r109.add(r117);
            if (r100.token() != 13) goto L40;
            r100.nextToken();
            goto L16
        L40:
            r100.skipObject(false);
            goto L47
        L35:
            r117 = r100.stringVal();
            r100.nextToken();
            goto L37
        L36:
            r117 = r100.integerValue();
            r100.nextToken();
            goto L37
        L28:
            extract(r110, r111, r112);
            goto L47
        L18:
            if (r113 == 14) goto L23;
            switch(r113) {
                case 2: goto L21;
                case 3: goto L21;
                case 4: goto L21;
                case 5: goto L21;
                case 6: goto L21;
                case 7: goto L21;
                case 8: goto L21;
                default: goto L47;
            };
        L21:
            r100.nextToken();
            goto L47
        L23:
            if (this.deep == false) goto L25;
            extract(r110, r111, r112);
            goto L47
        L25:
            r100.skipObject(false);
            goto L47
        L15:
            r109 = new JSONArray();
            goto L16
        }

        public void setValue(JSONPath r110, Object r111, Object r112) {
            if (this.deep == false) goto L5;
            r110.deepSet(r111, this.propertyName, this.propertyNameHash, r112);
            return;
        L5:
            r110.setPropertyValue(r111, this.propertyName, this.propertyNameHash, r112);
        }
    }

    public static class RangeSegment implements Segment {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegment(int r100, int r101, int r102) {
            this.start = r100;
            this.end = r101;
            this.step = r102;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            int r103 = SizeSegment.instance.eval(r100, r101, r102).intValue();
            int r104 = this.start;
            if (r104 >= 0) goto L6;
            r104 = r104 + r103;
        L6:
            int r105 = this.end;
            if (r105 >= 0) goto L10;
            r105 = r105 + r103;
        L10:
            int r106 = ((r105 - r104) / this.step) + 1;
            if (r106 != (-1)) goto L14;
            return null;
        L14:
            ArrayList r107 = new ArrayList(r106);
        L15:
            if (r104 > r105) goto L18;
            if (r104 >= r103) goto L18;
            r107.add(r100.getArrayItem(r102, r104));
            r104 = r104 + this.step;
        L18:
            return r107;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            throw new UnsupportedOperationException();
        }
    }

    public static class RefOpSegement extends PropertyFilter {

        /* JADX INFO: renamed from: op, reason: collision with root package name */
        private final Operator f24924op;
        private final Segment refSgement;

        public RefOpSegement(String r100, boolean r101, Segment r102, Operator r103) {
            super(r100, r101);
            this.refSgement = r102;
            this.f24924op = r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            if (r104 != null) goto L6;
            return false;
        L6:
            if ((r104 instanceof Number) == true) goto L8;
            return false;
        L8:
            Object r105 = this.refSgement.eval(r100, r101, r101);
            if ((r105 instanceof Integer) == false) goto L11;
        L16:
            long r106 = TypeUtils.longExtractValue((Number) r105);
            if ((r104 instanceof Integer) == false) goto L19;
        L48:
            long r107 = TypeUtils.longExtractValue((Number) r104);
            switch(AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f24924op.ordinal()]) {
                case 1: goto L72;
                case 2: goto L68;
                case 3: goto L64;
                case 4: goto L60;
                case 5: goto L56;
                case 6: goto L52;
                default: goto L76;
            };
        L76:
            throw new UnsupportedOperationException();
        L52:
            if (r107 >= r106) goto L83;
            return true;
        L83:
            return false;
        L56:
            if (r107 > r106) goto L84;
            return true;
        L84:
            return false;
        L60:
            if (r107 <= r106) goto L85;
            return true;
        L85:
            return false;
        L64:
            if (r107 < r106) goto L86;
            return true;
        L86:
            return false;
        L68:
            if (r107 == r106) goto L87;
            return true;
        L87:
            return false;
        L72:
            if (r107 != r106) goto L88;
            return true;
        L88:
            return false;
        L19:
            if ((r104 instanceof Long) == true) goto L48;
            if ((r104 instanceof Short) == true) goto L48;
            if ((r104 instanceof Byte) == true) goto L48;
            if ((r104 instanceof BigDecimal) == false) goto L76;
            int r108 = BigDecimal.valueOf(r106).compareTo((BigDecimal) r104);
            switch(AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f24924op.ordinal()]) {
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L39;
                case 4: goto L36;
                case 5: goto L33;
                case 6: goto L30;
                default: goto L29;
            };
        L29:
            return false;
        L30:
            if (r108 <= 0) goto L77;
            return true;
        L77:
            return false;
        L33:
            if (r108 < 0) goto L78;
            return true;
        L78:
            return false;
        L36:
            if (r108 >= 0) goto L79;
            return true;
        L79:
            return false;
        L39:
            if (r108 > 0) goto L80;
            return true;
        L80:
            return false;
        L42:
            if (r108 == 0) goto L81;
            return true;
        L81:
            return false;
        L45:
            if (r108 != 0) goto L82;
            return true;
        L82:
            return false;
        L11:
            if ((r105 instanceof Long) == true) goto L16;
            if ((r105 instanceof Short) == true) goto L16;
            if ((r105 instanceof Byte) == false) goto L76;
            goto L16
        }
    }

    public static class RegMatchSegement extends PropertyFilter {

        /* JADX INFO: renamed from: op, reason: collision with root package name */
        private final Operator f24925op;
        private final Pattern pattern;

        public RegMatchSegement(String r100, boolean r101, Pattern r102, Operator r103) {
            super(r100, r101);
            this.pattern = r102;
            this.f24925op = r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            if (r104 != null) goto L6;
            return false;
        L6:
            String r105 = r104.toString();
            return this.pattern.matcher(r105).matches();
        }
    }

    public static class RlikeSegement extends PropertyFilter {
        private final boolean not;
        private final Pattern pattern;

        public RlikeSegement(String r100, boolean r101, String r102, boolean r103) {
            super(r100, r101);
            this.pattern = PatternProtector.compile(r102);
            this.not = r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            if (r104 != null) goto L6;
            return false;
        L6:
            boolean r105 = this.pattern.matcher(r104.toString()).matches();
            if (this.not == true) goto L9;
            return r105;
        L9:
            return !r105;
        }
    }

    public interface Segment {
        Object eval(JSONPath r100, Object r101, Object r102);

        void extract(JSONPath r100, DefaultJSONParser r101, Context r102);
    }

    public static class SizeSegment implements Segment {
        public static final SizeSegment instance = null;

        public SizeSegment() {
        }

        static {
            instance = new SizeSegment();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Integer eval(JSONPath r100, Object r101, Object r102) {
            return Integer.valueOf(r100.evalSize(r102));
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            r102.object = Integer.valueOf(r100.evalSize(r101.parse()));
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public /* bridge */ /* synthetic */ Object eval(JSONPath r100, Object r101, Object r102) {
            return eval(r100, r101, r102);
        }
    }

    public static class StringInSegement extends PropertyFilter {
        private final boolean not;
        private final String[] values;

        public StringInSegement(String r100, boolean r101, String[] r102, boolean r103) {
            super(r100, r101);
            this.values = r102;
            this.not = r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            String[] r105 = this.values;
            int r106 = r105.length;
            int r107 = 0;
        L3:
            if (r107 >= r106) goto L15;
            String r108 = r105[r107];
            if (r108 == r104) goto L7;
            if (r108 == null) goto L13;
            if (r108.equals(r104) == false) goto L13;
            return !this.not;
        L13:
            r107 = r107 + 1;
            goto L3
        L7:
            return !this.not;
        L15:
            return this.not;
        }
    }

    public static class StringOpSegement extends PropertyFilter {

        /* JADX INFO: renamed from: op, reason: collision with root package name */
        private final Operator f24926op;
        private final String value;

        public StringOpSegement(String r100, boolean r101, String r102, Operator r103) {
            super(r100, r101);
            this.value = r102;
            this.f24926op = r103;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            Object r104 = get(r100, r101, r103);
            Operator r105 = this.f24926op;
            if (r105 != Operator.EQ) goto L7;
            return this.value.equals(r104);
        L7:
            if (r105 != Operator.NE) goto L11;
            return !this.value.equals(r104);
        L11:
            if (r104 != null) goto L13;
            return false;
        L13:
            int r106 = this.value.compareTo(r104.toString());
            Operator r107 = this.f24926op;
            if (r107 != Operator.GE) goto L20;
            if (r106 <= 0) goto L38;
            return false;
        L38:
            return true;
        L20:
            if (r107 != Operator.GT) goto L26;
            if (r106 < 0) goto L39;
            return false;
        L39:
            return true;
        L26:
            if (r107 != Operator.LE) goto L32;
            if (r106 >= 0) goto L40;
            return false;
        L40:
            return true;
        L32:
            if (r107 != Operator.LT) goto L37;
            if (r106 > 0) goto L41;
            return false;
        L41:
            return true;
        L37:
            return false;
        }
    }

    public static class TypeSegment implements Segment {
        public static final TypeSegment instance = null;

        public TypeSegment() {
        }

        static {
            instance = new TypeSegment();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public String eval(JSONPath r100, Object r101, Object r102) {
            if (r102 != null) goto L6;
            return "null";
        L6:
            if ((r102 instanceof Collection) == false) goto L10;
            return "array";
        L10:
            if ((r102 instanceof Number) == false) goto L14;
            return "number";
        L14:
            if ((r102 instanceof Boolean) == false) goto L18;
            return "boolean";
        L18:
            if ((r102 instanceof String) == false) goto L20;
            return "string";
        L20:
            if ((r102 instanceof UUID) == false) goto L22;
            return "string";
        L22:
            if ((r102 instanceof Enum) == true) goto L29;
            return "object";
        L29:
            return "string";
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public /* bridge */ /* synthetic */ Object eval(JSONPath r100, Object r101, Object r102) {
            return eval(r100, r101, r102);
        }
    }

    public static class ValueSegment extends PropertyFilter {

        /* JADX INFO: renamed from: eq, reason: collision with root package name */
        private boolean f24927eq;
        private final Object value;

        public ValueSegment(String r100, boolean r101, Object r102, boolean r103) {
            super(r100, r101);
            this.f24927eq = true;
            if (r102 == null) goto L7;
            this.value = r102;
            this.f24927eq = r103;
            return;
        L7:
            throw new IllegalArgumentException("value is null");
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath r100, Object r101, Object r102, Object r103) {
            boolean r104 = this.value.equals(get(r100, r101, r103));
            if (this.f24927eq == false) goto L5;
            return r104;
        L5:
            return !r104;
        }
    }

    public static class WildCardSegment implements Segment {
        public static final WildCardSegment instance = null;
        public static final WildCardSegment instance_deep = null;
        public static final WildCardSegment instance_deep_objectOnly = null;
        private boolean deep;
        private boolean objectOnly;

        static {
            instance = new WildCardSegment(false, false);
            instance_deep = new WildCardSegment(true, false);
            instance_deep_objectOnly = new WildCardSegment(true, true);
        }

        private WildCardSegment(boolean r100, boolean r101) {
            this.deep = r100;
            this.objectOnly = r101;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public Object eval(JSONPath r100, Object r101, Object r102) {
            if (this.deep == false) goto L5;
            ArrayList r103 = new ArrayList();
            r100.deepGetPropertyValues(r102, r103);
            return r103;
        L5:
            return r100.getPropertyValues(r102);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(JSONPath r100, DefaultJSONParser r101, Context r102) {
            if (r102.eval == false) goto L21;
            Object r103 = r101.parse();
            if (this.deep == false) goto L13;
            ArrayList r104 = new ArrayList();
            if (this.objectOnly == false) goto L9;
            r100.deepGetObjects(r103, r104);
        L10:
            r102.object = r104;
            return;
        L9:
            r100.deepGetPropertyValues(r103, r104);
            goto L10
        L13:
            if ((r103 instanceof JSONObject) == false) goto L17;
            Collection<?> r105 = ((JSONObject) r103).values();
            JSONArray r106 = new JSONArray(r105.size());
            r106.addAll(r105);
            r102.object = r106;
            return;
        L17:
            if ((r103 instanceof JSONArray) == false) goto L21;
            r102.object = r103;
            return;
        L21:
            throw new JSONException(AlarmSessionType.TODO);
        }
    }

    public boolean isRef() {
        init();     // Catch: JSONPathException -> L15
        int r100 = 0;
    L4:
        Segment[] r101 = this.segments;     // Catch: JSONPathException -> L15
        if (r100 >= r101.length) goto L13;
        Class<?> r102 = r101[r100].getClass();     // Catch: JSONPathException -> L15
        if (r102 == ArrayAccessSegment.class) goto L12;
        if (r102 == PropertySegment.class) goto L12;
        return false;
    L12:
        r100 = r100 + 1;
        goto L4
    L13:
        return true;
    L22:
        return false;
    }

    static {
        pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    }

    public void init() {
        if (this.segments == null) goto L6;
        return;
    L6:
        if ("*".equals(this.path) == false) goto L8;
        this.segments = new Segment[]{WildCardSegment.instance};
        return;
    L8:
        JSONPathParser r100 = new JSONPathParser(this.path);
        this.segments = r100.explain();
        this.hasRefSegment = JSONPathParser.access$000(r100);
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        return JSON.toJSONString(this.path);
    }

    public String getPath() {
        return this.path;
    }

    public JSONPath(String r100) {
        this(r100, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance(), true);
    }

    public static JSONPath compile(String r100) {
        if (r100 == null) goto L10;
        JSONPath r101 = pathCache.get(r100);
        if (r101 != null) goto L11;
        JSONPath r102 = new JSONPath(r100);
        if (pathCache.size() >= 1024) goto L12;
        pathCache.putIfAbsent(r100, r102);
        return pathCache.get(r100);
    L12:
        return r102;
    L11:
        return r101;
    L10:
        throw new JSONPathException("jsonpath can not be null");
    }

    public static boolean isDouble(Class<?> r100) {
        if (r100 != Float.class) goto L5;
    L8:
        return true;
    L5:
        if (r100 == Double.class) goto L8;
        return false;
    }

    public static boolean isInt(Class<?> r100) {
        if (r100 != Byte.class) goto L5;
    L12:
        return true;
    L5:
        if (r100 == Short.class) goto L12;
        if (r100 == Integer.class) goto L12;
        if (r100 == Long.class) goto L12;
        return false;
    }

    public static Map<String, Object> paths(Object r100) {
        return paths(r100, SerializeConfig.globalInstance);
    }

    public boolean contains(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        init();
        Object r101 = r100;
        int r102 = 0;
    L6:
        Segment[] r103 = this.segments;
        if (r102 >= r103.length) goto L18;
        Object r104 = r103[r102].eval(this, r100, r101);
        if (r104 == null) goto L10;
        if (r104 != Collections.EMPTY_LIST) goto L17;
        if ((r101 instanceof List) == false) goto L17;
        return ((List) r101).contains(r104);
    L17:
        r102 = r102 + 1;
        r101 = r104;
        goto L6
    L10:
        return false;
    L18:
        return true;
    }

    public Object eval(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        init();
        int r101 = 0;
        Object r102 = r100;
    L6:
        Segment[] r103 = this.segments;
        if (r101 >= r103.length) goto L9;
        r102 = r103[r101].eval(this, r100, r102);
        r101 = r101 + 1;
        goto L6
    L9:
        return r102;
    }

    public Set<?> evalKeySet(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Map) == false) goto L10;
        return ((Map) r100).keySet();
    L10:
        if ((r100 instanceof Collection) == false) goto L12;
    L24:
        return null;
    L12:
        if ((r100 instanceof Object[]) == true) goto L24;
        if (r100.getClass().isArray() == true) goto L24;
        JavaBeanSerializer r101 = getJavaBeanSerializer(r100.getClass());
        if (r101 != null) goto L25;
        return null;
    L25:
        return r101.getFieldNames(r100);
    L21:
        e = move-exception;
        throw new JSONPathException("evalKeySet error : " + this.path, e);
    }

    public int evalSize(Object r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if ((r100 instanceof Collection) == false) goto L10;
        return ((Collection) r100).size();
    L10:
        if ((r100 instanceof Object[]) == false) goto L14;
        return ((Object[]) r100).length;
    L14:
        if (r100.getClass().isArray() == false) goto L18;
        return Array.getLength(r100);
    L18:
        if ((r100 instanceof Map) == false) goto L26;
        Iterator r101 = ((Map) r100).values().iterator();
        int r102 = 0;
    L21:
        if (r101.hasNext() == false) goto L25;
        if (r101.next() == null) goto L21;
        r102 = r102 + 1;
        goto L21
    L25:
        return r102;
    L26:
        JavaBeanSerializer r103 = getJavaBeanSerializer(r100.getClass());
        if (r103 != null) goto L34;
        return -1;
    L34:
        return r103.getSize(r100);
    L31:
        e = move-exception;
        throw new JSONPathException("evalSize error : " + this.path, e);
    }

    public Object extract(DefaultJSONParser r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        init();
        if (this.hasRefSegment == true) goto L8;
        Segment[] r100 = this.segments;
        if (r100.length == 0) goto L12;
        Segment r101 = r100[r100.length - 1];
        if ((r101 instanceof TypeSegment) == true) goto L70;
        if ((r101 instanceof FloorSegment) == true) goto L70;
        if ((r101 instanceof MultiIndexSegment) == true) goto L70;
        Context r102 = null;
        int r103 = 0;
    L21:
        Segment[] r104 = this.segments;
        if (r103 >= r104.length) goto L68;
        Segment r105 = r104[r103];
        if (r103 != (r104.length - 1)) goto L26;
        boolean r106 = true;
    L27:
        if (r102 == null) goto L31;
        Object r107 = r102.object;
        if (r107 == null) goto L31;
        r102.object = r105.eval(this, null, r107);
    L66:
        r103 = r103 + 1;
    L31:
        if (r106 == true) goto L64;
        Segment r108 = r104[r103 + 1];
        if ((r105 instanceof PropertySegment) == false) goto L50;
        if (PropertySegment.access$100((PropertySegment) r105) == false) goto L50;
        if ((r108 instanceof ArrayAccessSegment) == true) goto L64;
        if ((r108 instanceof MultiIndexSegment) == true) goto L64;
        if ((r108 instanceof MultiPropertySegment) == true) goto L64;
        if ((r108 instanceof SizeSegment) == true) goto L64;
        if ((r108 instanceof PropertySegment) == true) goto L64;
        if ((r108 instanceof FilterSegment) == true) goto L64;
    L50:
        if ((r108 instanceof ArrayAccessSegment) == false) goto L55;
        if (ArrayAccessSegment.access$200((ArrayAccessSegment) r108) < 0) goto L64;
    L55:
        if ((r108 instanceof FilterSegment) == true) goto L64;
        if ((r105 instanceof WildCardSegment) == true) goto L64;
        if ((r105 instanceof MultiIndexSegment) == true) goto L64;
        boolean r109 = false;
    L65:
        Context r111 = new Context(r102, r109);
        r105.extract(this, r110, r111);
        r102 = r111;
    L64:
        r109 = true;
        goto L65
    L26:
        r106 = false;
        goto L27
    L68:
        return r102.object;
    L70:
        return eval(r110.parse());
    L12:
        return r110.parse();
    L8:
        return eval(r110.parse());
    }

    public JavaBeanDeserializer getJavaBeanDeserializer(Class<?> r100) {
        ObjectDeserializer r101 = this.parserConfig.getDeserializer(r100);
        if ((r101 instanceof JavaBeanDeserializer) == true) goto L7;
        return null;
    L7:
        return (JavaBeanDeserializer) r101;
    }

    public JavaBeanSerializer getJavaBeanSerializer(Class<?> r100) {
        ObjectSerializer r101 = this.serializeConfig.getObjectWriter(r100);
        if ((r101 instanceof JavaBeanSerializer) == true) goto L7;
        return null;
    L7:
        return (JavaBeanSerializer) r101;
    }

    public Collection<Object> getPropertyValues(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JavaBeanSerializer r101 = getJavaBeanSerializer(r100.getClass());
        if (r101 == null) goto L13;
        return r101.getFieldValues(r100);
    L9:
        e = move-exception;
        throw new JSONPathException("jsonpath error, path " + this.path, e);
    L13:
        if ((r100 instanceof Map) == false) goto L17;
        return ((Map) r100).values();
    L17:
        if ((r100 instanceof Collection) == false) goto L21;
        return (Collection) r100;
    L21:
        throw new UnsupportedOperationException();
    }

    public Set<?> keySet(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        init();
        int r101 = 0;
        Object r102 = r100;
    L6:
        Segment[] r103 = this.segments;
        if (r101 >= r103.length) goto L10;
        r102 = r103[r101].eval(this, r100, r102);
        r101 = r101 + 1;
        goto L6
    L10:
        return evalKeySet(r102);
    }

    public boolean remove(Object r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
        return false;
    L5:
        init();
        Segment[] r101 = this.segments;
        Segment r102 = r101[r101.length - 1];
        Object r103 = r110;
        int r104 = 0;
    L6:
        Segment[] r105 = this.segments;
        if (r104 >= r105.length) goto L46;
        if (r104 == (r105.length - 1)) goto L47;
        Segment r106 = r105[r104];
        if (r104 == (r105.length - 2)) goto L14;
    L42:
        r103 = r106.eval(this, r110, r103);
        if (r103 == null) goto L46;
        r104 = r104 + 1;
        goto L6
    L14:
        if ((r102 instanceof FilterSegment) == false) goto L42;
        if ((r106 instanceof PropertySegment) == false) goto L42;
        FilterSegment r107 = (FilterSegment) r102;
        if ((r103 instanceof List) == true) goto L19;
        if ((r103 instanceof Map) == false) goto L42;
        PropertySegment r108 = (PropertySegment) r106;
        Object r109 = r108.eval(this, r110, r103);
        if (r109 == null) goto L35;
        if ((r109 instanceof Map) == false) goto L42;
        if (FilterSegment.access$300(r107).apply(this, r110, r103, r109) == false) goto L42;
        r108.remove(this, r103);
        return true;
    L35:
        return false;
    L19:
        PropertySegment r111 = (PropertySegment) r106;
        Iterator r112 = ((List) r103).iterator();
    L21:
        if (r112.hasNext() == false) goto L30;
        Object r113 = r111.eval(this, r110, r112.next());
        if ((r113 instanceof Iterable) == true) goto L24;
        if ((r113 instanceof Map) == false) goto L21;
        if (FilterSegment.access$300(r107).apply(this, r110, r103, r113) == false) goto L21;
        r112.remove();
        goto L21
    L24:
        r107.remove(this, r110, r113);
        goto L21
    L30:
        return true;
    L47:
        if (r103 != null) goto L50;
        return false;
    L50:
        if ((r102 instanceof PropertySegment) == false) goto L69;
        PropertySegment r114 = (PropertySegment) r102;
        if ((r103 instanceof Collection) == false) goto L67;
        Segment[] r115 = this.segments;
        if (r115.length <= 1) goto L67;
        Segment r116 = r115[r115.length - 2];
        if ((r116 instanceof RangeSegment) == false) goto L58;
    L59:
        Iterator r117 = ((Collection) r103).iterator();
    L61:
        if (r117.hasNext() == false) goto L65;
        if (r114.remove(this, r117.next()) == false) goto L61;
        r100 = true;
        goto L61
    L65:
        return r100;
    L58:
        if ((r116 instanceof MultiIndexSegment) == true) goto L59;
    L67:
        return r114.remove(this, r103);
    L69:
        if ((r102 instanceof ArrayAccessSegment) == false) goto L73;
        return ((ArrayAccessSegment) r102).remove(this, r103);
    L73:
        if ((r102 instanceof FilterSegment) == false) goto L77;
        return ((FilterSegment) r102).remove(this, r110, r103);
    L77:
        throw new UnsupportedOperationException();
    L46:
        r103 = null;
        goto L47
    }

    public int size(Object r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        init();
        int r101 = 0;
        Object r102 = r100;
    L6:
        Segment[] r103 = this.segments;
        if (r101 >= r103.length) goto L10;
        r102 = r103[r101].eval(this, r100, r102);
        r101 = r101 + 1;
        goto L6
    L10:
        return evalSize(r102);
    }

    public JSONPath(String r100, boolean r101) {
        this(r100, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance(), r101);
    }

    public static int compare(Object r100, Object r101) {
        if (r100.getClass() == r101.getClass()) goto L5;
        Class<?> r102 = r100.getClass();
        Class<?> r103 = r101.getClass();
        if (r102 != BigDecimal.class) goto L22;
        if (r103 != Integer.class) goto L13;
        Object r104 = new BigDecimal(((Integer) r101).intValue());
    L11:
        r101 = r104;
    L73:
        return ((Comparable) r100).compareTo(r101);
    L13:
        if (r103 != Long.class) goto L16;
        r104 = new BigDecimal(((Long) r101).longValue());
        goto L11
    L16:
        if (r103 != Float.class) goto L19;
        r104 = new BigDecimal(((Float) r101).floatValue());
        goto L11
    L19:
        if (r103 != Double.class) goto L73;
        r104 = new BigDecimal(((Double) r101).doubleValue());
        goto L11
    L22:
        if (r102 != Long.class) goto L36;
        if (r103 != Integer.class) goto L27;
        r104 = new Long(((Integer) r101).intValue());
        goto L11
    L27:
        if (r103 != BigDecimal.class) goto L30;
        Object r105 = new BigDecimal(((Long) r100).longValue());
    L40:
        r100 = r105;
        goto L73
    L30:
        if (r103 != Float.class) goto L33;
        r105 = new Float(((Long) r100).longValue());
        goto L40
    L33:
        if (r103 != Double.class) goto L73;
        r105 = new Double(((Long) r100).longValue());
        goto L40
    L36:
        if (r102 != Integer.class) goto L51;
        if (r103 != Long.class) goto L42;
        r105 = new Long(((Integer) r100).intValue());
        goto L40
    L42:
        if (r103 != BigDecimal.class) goto L45;
        r105 = new BigDecimal(((Integer) r100).intValue());
        goto L40
    L45:
        if (r103 != Float.class) goto L48;
        r105 = new Float(((Integer) r100).intValue());
        goto L40
    L48:
        if (r103 != Double.class) goto L73;
        r105 = new Double(((Integer) r100).intValue());
        goto L40
    L51:
        if (r102 != Double.class) goto L62;
        if (r103 != Integer.class) goto L56;
        r104 = new Double(((Integer) r101).intValue());
        goto L11
    L56:
        if (r103 != Long.class) goto L59;
        r104 = new Double(((Long) r101).longValue());
        goto L11
    L59:
        if (r103 != Float.class) goto L73;
        r104 = new Double(((Float) r101).floatValue());
        goto L11
    L62:
        if (r102 != Float.class) goto L73;
        if (r103 != Integer.class) goto L67;
        r104 = new Float(((Integer) r101).intValue());
        goto L11
    L67:
        if (r103 != Long.class) goto L70;
        r104 = new Float(((Long) r101).longValue());
        goto L11
    L70:
        if (r103 != Double.class) goto L73;
        r105 = new Double(((Float) r100).floatValue());
        goto L40
    L5:
        return ((Comparable) r100).compareTo(r101);
    }

    public static JSONPath compile(String r100, boolean r101) {
        if (r100 == null) goto L10;
        JSONPath r102 = pathCache.get(r100);
        if (r102 != null) goto L11;
        JSONPath r103 = new JSONPath(r100, r101);
        if (pathCache.size() >= 1024) goto L12;
        pathCache.putIfAbsent(r100, r103);
        return pathCache.get(r100);
    L12:
        return r103;
    L11:
        return r102;
    L10:
        throw new JSONPathException("jsonpath can not be null");
    }

    public static boolean contains(Object r100, String r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return compile(r101).contains(r100);
    }

    public static boolean eq(Object r100, Object r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        if (r100.getClass() != r101.getClass()) goto L14;
        return r100.equals(r101);
    L14:
        if ((r100 instanceof Number) == false) goto L21;
        if ((r101 instanceof Number) == true) goto L18;
        return false;
    L18:
        return eqNotNull((Number) r100, (Number) r101);
    L21:
        return r100.equals(r101);
    L22:
        return false;
    }

    public static boolean eqNotNull(Number r100, Number r101) {
        Class<?> r102 = r100.getClass();
        boolean r103 = isInt(r102);
        Class<?> r104 = r101.getClass();
        boolean r105 = isInt(r104);
        if ((r100 instanceof BigDecimal) == false) goto L9;
        BigDecimal r106 = (BigDecimal) r100;
        if (r105 == false) goto L9;
        return r106.equals(BigDecimal.valueOf(TypeUtils.longExtractValue(r101)));
    L9:
        if (r103 == false) goto L20;
        if (r105 == false) goto L17;
        if (r100.longValue() == r101.longValue()) goto L38;
        return false;
    L38:
        return true;
    L17:
        if ((r101 instanceof BigInteger) == false) goto L20;
        BigInteger r107 = (BigInteger) r100;
        return BigInteger.valueOf(r100.longValue()).equals(r107);
    L20:
        if (r105 == true) goto L22;
    L25:
        boolean r108 = isDouble(r102);
        boolean r109 = isDouble(r104);
        if (r108 == false) goto L28;
        if (r109 == false) goto L28;
    L33:
        if (r100.doubleValue() == r101.doubleValue()) goto L39;
        return false;
    L39:
        return true;
    L28:
        if (r108 == false) goto L30;
        if (r105 == true) goto L33;
    L30:
        if (r109 == false) goto L37;
        if (r103 == true) goto L33;
    L37:
        return false;
    L22:
        if ((r100 instanceof BigInteger) == false) goto L25;
        return ((BigInteger) r100).equals(BigInteger.valueOf(TypeUtils.longExtractValue(r101)));
    }

    public static Object eval(Object r100, String r101) {
        return compile(r101).eval(r100);
    }

    public static Object extract(String r100, String r101) {
        return extract(r100, r101, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);
    }

    public static Set<?> keySet(Object r100, String r101) {
        JSONPath r102 = compile(r101);
        return r102.evalKeySet(r102.eval(r100));
    }

    public static Map<String, Object> paths(Object r100, SerializeConfig r101) {
        IdentityHashMap r102 = new IdentityHashMap();
        HashMap r103 = new HashMap();
        paths(r102, r103, HTTP.URL_DEFAULT, r100, r101);
        return r103;
    }

    public static Object read(String r100, String r101) {
        return compile(r101).eval(JSON.parse(r100));
    }

    public static boolean remove(Object r100, String r101) {
        return compile(r101).remove(r100);
    }

    public static Object reserveToArray(Object r100, String... r101) {
        JSONArray r102 = new JSONArray();
        if (r101 != null) goto L5;
    L10:
        return r102;
    L5:
        if (r101.length == 0) goto L10;
        int r103 = r101.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        JSONPath r105 = compile(r101[r104]);
        r105.init();
        r102.add(r105.eval(r100));
        r104 = r104 + 1;
        goto L8
    }

    public static Object reserveToObject(Object r100, String... r101) {
        if (r101 != null) goto L4;
    L16:
        return r100;
    L4:
        if (r101.length == 0) goto L16;
        JSONObject r102 = new JSONObject(true);
        int r103 = r101.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L15;
        JSONPath r105 = compile(r101[r104]);
        r105.init();
        Segment[] r106 = r105.segments;
        if ((r106[r106.length - 1] instanceof PropertySegment) == false) goto L14;
        Object r107 = r105.eval(r100);
        if (r107 == null) goto L14;
        r105.set(r102, r107);
    L14:
        r104 = r104 + 1;
        goto L7
    L15:
        return r102;
    }

    public static int size(Object r100, String r101) {
        JSONPath r102 = compile(r101);
        return r102.evalSize(r102.eval(r100));
    }

    public void arrayAdd(Object r100, Object... r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.length == 0) goto L48;
        if (r100 != null) goto L8;
        return;
    L8:
        init();
        int r102 = 0;
        Object r103 = null;
        Object r104 = r100;
        int r105 = 0;
    L9:
        Segment[] r106 = this.segments;
        if (r105 >= r106.length) goto L15;
        if (r105 != (r106.length - 1)) goto L14;
        r103 = r104;
    L14:
        r104 = r106[r105].eval(this, r100, r104);
        r105 = r105 + 1;
        goto L9
    L15:
        if (r104 == null) goto L41;
        if ((r104 instanceof Collection) == false) goto L22;
        Collection r107 = (Collection) r104;
        int r108 = r101.length;
    L19:
        if (r102 >= r108) goto L21;
        r107.add(r101[r102]);
        r102 = r102 + 1;
        goto L19
    L21:
        return;
    L22:
        Class<?> r109 = r104.getClass();
        if (r109.isArray() == false) goto L39;
        int r110 = Array.getLength(r104);
        Object r111 = Array.newInstance(r109.getComponentType(), r101.length + r110);
        System.arraycopy(r104, 0, r111, 0, r110);
    L26:
        if (r102 >= r101.length) goto L28;
        Array.set(r111, r110 + r102, r101[r102]);
        r102 = r102 + 1;
        goto L26
    L28:
        Segment[] r112 = this.segments;
        Segment r113 = r112[r112.length - 1];
        if ((r113 instanceof PropertySegment) == false) goto L33;
        ((PropertySegment) r113).setValue(this, r103, r111);
        return;
    L33:
        if ((r113 instanceof ArrayAccessSegment) == false) goto L37;
        ((ArrayAccessSegment) r113).setValue(this, r103, r111);
        return;
    L37:
        throw new UnsupportedOperationException();
    L39:
        throw new JSONException("unsupported array put operation. " + r109);
    L41:
        throw new JSONPathException("value not found in path " + this.path);
    }

    public boolean containsValue(Object r100, Object r101) {
        Object r102 = eval(r100);
        if (r102 != r101) goto L6;
        return true;
    L6:
        if (r102 != null) goto L9;
        return false;
    L9:
        if ((r102 instanceof Iterable) == false) goto L18;
        Iterator r103 = ((Iterable) r102).iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        if (eq(r103.next(), r101) == false) goto L12;
        return true;
    L16:
        return false;
    L18:
        return eq(r102, r101);
    }

    public void deepGetObjects(Object r100, List<Object> r101) {
        Class<?> r102 = r100.getClass();
        JavaBeanSerializer r103 = getJavaBeanSerializer(r102);
        if (r103 == null) goto L10;
        Collection r104 = r103.getFieldValues(r100);     // Catch: Exception -> L6
        r101.add(r100);     // Catch: Exception -> L6
    L16:
        if (r104 == null) goto L28;
        Iterator r105 = r104.iterator();
    L19:
        if (r105.hasNext() == false) goto L26;
        Object r106 = r105.next();
        if (r106 == null) goto L19;
        if (ParserConfig.isPrimitive2(r106.getClass()) == true) goto L19;
        deepGetObjects(r106, r101);
        goto L19
    L26:
        return;
    L28:
        throw new UnsupportedOperationException(r102.getName());
    L6:
        e = move-exception;
        throw new JSONPathException("jsonpath error, path " + this.path, e);
    L10:
        if ((r100 instanceof Map) == false) goto L13;
        r101.add(r100);
        r104 = ((Map) r100).values();
        goto L16
    L13:
        if ((r100 instanceof Collection) == false) goto L15;
        r104 = (Collection) r100;
        goto L16
    L15:
        r104 = null;
        goto L16
    }

    public void deepGetPropertyValues(Object r100, List<Object> r101) {
        Class<?> r102 = r100.getClass();
        JavaBeanSerializer r103 = getJavaBeanSerializer(r102);
        if (r103 == null) goto L10;
        Collection r104 = r103.getFieldValues(r100);     // Catch: Exception -> L6
    L16:
        if (r104 == null) goto L29;
        Iterator r105 = r104.iterator();
    L19:
        if (r105.hasNext() == false) goto L27;
        Object r106 = r105.next();
        if (r106 == null) goto L26;
        if (ParserConfig.isPrimitive2(r106.getClass()) == true) goto L26;
        deepGetPropertyValues(r106, r101);
    L26:
        r101.add(r106);
        goto L19
    L27:
        return;
    L29:
        throw new UnsupportedOperationException(r102.getName());
    L6:
        e = move-exception;
        throw new JSONPathException("jsonpath error, path " + this.path, e);
    L10:
        if ((r100 instanceof Map) == false) goto L13;
        r104 = ((Map) r100).values();
        goto L16
    L13:
        if ((r100 instanceof Collection) == false) goto L15;
        r104 = (Collection) r100;
        goto L16
    L15:
        r104 = null;
        goto L16
    }

    public Object getArrayItem(Object r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof List) == false) goto L20;
        List r102 = (List) r100;
        if (r101 < 0) goto L15;
        if (r101 < r102.size()) goto L12;
        return null;
    L12:
        return ListProtector.get(r102, r101);
    L15:
        if (Math.abs(r101) <= r102.size()) goto L17;
        return null;
    L17:
        return ListProtector.get(r102, r102.size() + r101);
    L20:
        if (r100.getClass().isArray() == false) goto L33;
        int r103 = Array.getLength(r100);
        if (r101 < 0) goto L28;
        if (r101 < r103) goto L25;
        return null;
    L25:
        return Array.get(r100, r101);
    L28:
        if (Math.abs(r101) <= r103) goto L30;
        return null;
    L30:
        return Array.get(r100, r103 + r101);
    L33:
        if ((r100 instanceof Map) == false) goto L39;
        Map r104 = (Map) r100;
        Object r105 = r104.get(Integer.valueOf(r101));
        if (r105 == null) goto L37;
        return r105;
    L37:
        return r104.get(Integer.toString(r101));
    L39:
        if ((r100 instanceof Collection) == false) goto L48;
        Iterator r106 = ((Collection) r100).iterator();
        int r107 = 0;
    L42:
        if (r106.hasNext() == false) goto L47;
        Object r108 = r106.next();
        if (r107 == r101) goto L45;
        r107 = r107 + 1;
        goto L42
    L45:
        return r108;
    L47:
        return null;
    L48:
        if (r101 != 0) goto L51;
        return r100;
    L51:
        throw new UnsupportedOperationException();
    }

    public boolean set(Object r100, Object r101) {
        return set(r100, r101, true);
    }

    public <T> T eval(Object r100, Type r101) {
        return (T) eval(r100, r101, ParserConfig.getGlobalInstance());
    }

    public static void arrayAdd(Object r100, String r101, Object... r102) {
        compile(r101).arrayAdd(r100, r102);
    }

    public static boolean containsValue(Object r100, String r101, Object r102) {
        return compile(r101).containsValue(r100, r102);
    }

    public static Object eval(Object r100, String r101, boolean r102) {
        return compile(r101, r102).eval(r100);
    }

    public static <T> T read(String r100, String r101, Type r102) {
        return (T) read(r100, r101, r102, null);
    }

    public void deepScan(Object r100, String r101, List<Object> r102) {
        if (r100 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof Map) == false) goto L23;
        Iterator r103 = ((Map) r100).entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L21;
        Map.Entry r104 = (Map.Entry) r103.next();
        Object r105 = r104.getValue();
        if (r101.equals(r104.getKey()) == true) goto L13;
        if (r105 == null) goto L9;
        if (ParserConfig.isPrimitive2(r105.getClass()) == true) goto L9;
        deepScan(r105, r101, r102);
        goto L9
    L13:
        if ((r105 instanceof Collection) == true) goto L14;
        r102.add(r105);
        goto L9
    L14:
        r102.addAll((Collection) r105);
        goto L9
    L21:
        return;
    L23:
        if ((r100 instanceof Collection) == false) goto L32;
        Iterator r106 = ((Collection) r100).iterator();
    L26:
        if (r106.hasNext() == false) goto L31;
        Object r107 = r106.next();
        if (ParserConfig.isPrimitive2(r107.getClass()) == true) goto L26;
        deepScan(r107, r101, r102);
        goto L26
    L31:
        return;
    L32:
        JavaBeanSerializer r108 = getJavaBeanSerializer(r100.getClass());
        if (r108 == null) goto L54;
        FieldSerializer r109 = r108.getFieldSerializer(r101);     // Catch: Exception -> L50
        if (r109 != null) goto L61;
        Iterator<Object> r110 = r108.getFieldValues(r100).iterator();     // Catch: Exception -> L50
    L46:
        if (r110.hasNext() == false) goto L49;
        deepScan(r110.next(), r101, r102);     // Catch: Exception -> L50
        goto L46
    L49:
        return;
    L61:
        r102.add(r109.getPropertyValueDirect(r100));     // Catch: IllegalAccessException -> L38 InvocationTargetException -> L41 Exception -> L50
        return;
    L38:
        e = move-exception;
        throw new JSONException("getFieldValue error." + r101, e);     // Catch: Exception -> L50
    L41:
        e = move-exception;
        throw new JSONException("getFieldValue error." + r101, e);     // Catch: Exception -> L50
    L50:
        e = move-exception;
        throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + r101, e);
    L54:
        if ((r100 instanceof List) == false) goto L59;
        List r111 = (List) r100;
        int r112 = 0;
    L57:
        if (r112 >= r111.size()) goto L83;
        deepScan(ListProtector.get(r111, r112), r101, r102);
        r112 = r112 + 1;
        goto L57
    L83:
        return;
    }

    public Object getPropertyValue(Object r100, String r110, long r111) {
        JSONArray r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof String) == true) goto L122;
    L10:
        Object r102 = r100;
    L12:
        if ((r102 instanceof Map) == false) goto L21;
        Map r103 = (Map) r102;
        Object r104 = r103.get(r110);
        if (r104 == null) goto L16;
        return r104;
    L16:
        if (SIZE == r111) goto L20;
        if (LENGTH == r111) goto L20;
        return r104;
    L20:
        return Integer.valueOf(r103.size());
    L21:
        JavaBeanSerializer r105 = getJavaBeanSerializer(r102.getClass());
        if (r105 != null) goto L124;
        int r106 = 0;
        if ((r102 instanceof List) == false) goto L62;
        List r107 = (List) r102;
        if (SIZE == r111) goto L60;
        if (LENGTH == r111) goto L60;
    L37:
        if (r106 >= r107.size()) goto L56;
        Object r108 = ListProtector.get(r107, r106);
        if (r108 != r107) goto L43;
        if (r101 != null) goto L42;
        r101 = new JSONArray(r107.size());
    L42:
        r101.add(r108);
    L55:
        r106 = r106 + 1;
        goto L37
    L43:
        Object r109 = getPropertyValue(r108, r110, r111);
        if ((r109 instanceof Collection) == false) goto L49;
        Collection r112 = (Collection) r109;
        if (r101 != null) goto L48;
        r101 = new JSONArray(r107.size());
    L48:
        r101.addAll(r112);
        goto L55
    L49:
        if (r109 == null) goto L51;
    L52:
        if (r101 != null) goto L54;
        r101 = new JSONArray(r107.size());
    L54:
        r101.add(r109);
        goto L55
    L51:
        if (this.ignoreNullValue == true) goto L55;
    L56:
        if (r101 == null) goto L58;
        return r101;
    L58:
        return Collections.emptyList();
    L60:
        return Integer.valueOf(r107.size());
    L62:
        if ((r102 instanceof Object[]) == false) goto L86;
        Object[] r113 = (Object[]) r102;
        if (SIZE == r111) goto L84;
        if (LENGTH == r111) goto L84;
        JSONArray r114 = new JSONArray(r113.length);
    L70:
        if (r106 >= r113.length) goto L82;
        Object[] r115 = r113[r106];
        if (r115 != r113) goto L74;
        r114.add(r115);
    L81:
        r106 = r106 + 1;
        goto L70
    L74:
        Object r116 = getPropertyValue(r115, r110, r111);
        if ((r116 instanceof Collection) == false) goto L77;
        r114.addAll((Collection) r116);
        goto L81
    L77:
        if (r116 == null) goto L79;
    L80:
        r114.add(r116);
        goto L81
    L79:
        if (this.ignoreNullValue == true) goto L81;
    L82:
        return r114;
    L84:
        return Integer.valueOf(r113.length);
    L86:
        if ((r102 instanceof Enum) == false) goto L96;
        Enum r117 = (Enum) r102;
        if ((-4270347329889690746L) != r111) goto L92;
        return r117.name();
    L92:
        if ((-1014497654951707614L) != r111) goto L96;
        return Integer.valueOf(r117.ordinal());
    L96:
        if ((r102 instanceof Calendar) == false) goto L121;
        Calendar r118 = (Calendar) r102;
        if (8963398325558730460L != r111) goto L102;
        return Integer.valueOf(r118.get(1));
    L102:
        if ((-811277319855450459L) != r111) goto L106;
        return Integer.valueOf(r118.get(2));
    L106:
        if ((-3851359326990528739L) != r111) goto L110;
        return Integer.valueOf(r118.get(5));
    L110:
        if (4647432019745535567L != r111) goto L114;
        return Integer.valueOf(r118.get(11));
    L114:
        if (6607618197526598121L != r111) goto L118;
        return Integer.valueOf(r118.get(12));
    L118:
        if ((-6586085717218287427L) != r111) goto L121;
        return Integer.valueOf(r118.get(13));
    L121:
        return null;
    L124:
        return r105.getFieldValue(r102, r110, r111, false);
    L26:
        e = move-exception;
        throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + r110, e);
    L122:
        r102 = (JSONObject) JSON.parse((String) r100, this.parserConfig);     // Catch: Exception -> L9
        goto L12
    }

    public void patchAdd(Object r100, Object r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        init();
        Object r103 = null;
        int r104 = 0;
        Object r105 = r100;
    L5:
        Segment[] r106 = this.segments;
        if (r104 >= r106.length) goto L15;
        Segment r107 = r106[r104];
        Object r108 = r107.eval(this, r100, r105);
        if (r108 != null) goto L14;
        if (r104 == (this.segments.length - 1)) goto L14;
        if ((r107 instanceof PropertySegment) == false) goto L14;
        r108 = new JSONObject();
        ((PropertySegment) r107).setValue(this, r105, r108);
    L14:
        r104 = r104 + 1;
        r103 = r105;
        r105 = r108;
        goto L5
    L15:
        if (r102 == false) goto L17;
    L20:
        if (r105 == null) goto L30;
        if (r102 == true) goto L30;
        Class<?> r109 = r105.getClass();
        if (r109.isArray() == false) goto L26;
        int r110 = Array.getLength(r105);
        Object r111 = Array.newInstance(r109.getComponentType(), r110 + 1);
        System.arraycopy(r105, 0, r111, 0, r110);
        Array.set(r111, r110, r101);
        r101 = r111;
        goto L30
    L26:
        if (Map.class.isAssignableFrom(r109) == true) goto L30;
        throw new JSONException("unsupported array put operation. " + r109);
    L30:
        Segment[] r112 = this.segments;
        Segment r113 = r112[r112.length - 1];
        if ((r113 instanceof PropertySegment) == false) goto L35;
        ((PropertySegment) r113).setValue(this, r103, r101);
        return;
    L35:
        if ((r113 instanceof ArrayAccessSegment) == false) goto L39;
        ((ArrayAccessSegment) r113).setValue(this, r103, r101);
        return;
    L39:
        throw new UnsupportedOperationException();
    L17:
        if ((r105 instanceof Collection) == false) goto L20;
        ((Collection) r105).add(r101);
    }

    public boolean removeArrayItem(JSONPath r100, Object r101, int r102) {
        if ((r101 instanceof List) == false) goto L17;
        List r103 = (List) r101;
        if (r102 >= 0) goto L7;
        int r104 = r103.size() + r102;
        if (r104 >= 0) goto L13;
        return false;
    L13:
        ListProtector.remove(r103, r104);
        return true;
    L7:
        if (r102 < r103.size()) goto L9;
        return false;
    L9:
        ListProtector.remove(r103, r102);
        return true;
    L17:
        throw new JSONPathException("unsupported set operation." + r101.getClass());
    }

    public boolean removePropertyValue(Object r100, String r101, boolean r102) {
        boolean r103 = true;
        if ((r100 instanceof Map) == false) goto L14;
        Map r104 = (Map) r100;
        if (r104.remove(r101) != null) goto L8;
        r103 = false;
    L8:
        if (r102 == false) goto L13;
        Iterator r105 = r104.values().iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        removePropertyValue(r105.next(), r101, r102);
    L13:
        return r103;
    L14:
        ObjectDeserializer r106 = this.parserConfig.getDeserializer(r100.getClass());
        if ((r106 instanceof JavaBeanDeserializer) == false) goto L17;
        JavaBeanDeserializer r107 = (JavaBeanDeserializer) r106;
    L18:
        if (r107 == null) goto L32;
        FieldDeserializer r108 = r107.getFieldDeserializer(r101);
        if (r108 == null) goto L22;
        r108.setValue(r100, null);
    L23:
        if (r102 == false) goto L31;
        Iterator<Object> r109 = getPropertyValues(r100).iterator();
    L26:
        if (r109.hasNext() == false) goto L31;
        Object r110 = r109.next();
        if (r110 == null) goto L26;
        removePropertyValue(r110, r101, r102);
    L31:
        return r103;
    L22:
        r103 = false;
        goto L23
    L32:
        if (r102 == false) goto L35;
        return false;
    L35:
        throw new UnsupportedOperationException();
    L17:
        r107 = null;
        goto L18
    }

    public boolean set(Object r100, Object r110, boolean r111) {
        if (r100 != null) goto L5;
        return false;
    L5:
        init();
        Object r101 = r100;
        Object r102 = null;
        int r103 = 0;
    L6:
        Segment[] r104 = this.segments;
        if (r103 >= r104.length) goto L40;
        Segment r105 = r104[r103];
        Object r106 = r105.eval(this, r100, r101);
        if (r106 != null) goto L39;
        Segment[] r107 = this.segments;
        if (r103 >= (r107.length - 1)) goto L13;
        Segment r108 = r107[r103 + 1];
    L15:
        if ((r108 instanceof PropertySegment) == false) goto L29;
        if ((r105 instanceof PropertySegment) == false) goto L21;
        String r109 = PropertySegment.access$400((PropertySegment) r105);
        JavaBeanDeserializer r112 = getJavaBeanDeserializer(r101.getClass());
        if (r112 == null) goto L21;
        Class<?> r113 = r112.getFieldDeserializer(r109).fieldInfo.fieldClass;
        JavaBeanDeserializer r114 = getJavaBeanDeserializer(r113);
    L22:
        if (r114 != null) goto L24;
        r106 = new JSONObject();
    L32:
        if (r106 == null) goto L41;
        if ((r105 instanceof PropertySegment) == false) goto L37;
        ((PropertySegment) r105).setValue(this, r101, r106);
        goto L39
    L37:
        if ((r105 instanceof ArrayAccessSegment) == false) goto L41;
        ((ArrayAccessSegment) r105).setValue(this, r101, r106);
    L41:
        if (r101 != null) goto L43;
        return false;
    L43:
        Segment[] r115 = this.segments;
        Segment r116 = r115[r115.length - 1];
        if ((r116 instanceof PropertySegment) == false) goto L48;
        ((PropertySegment) r116).setValue(this, r101, r110);
        return true;
    L48:
        if ((r116 instanceof ArrayAccessSegment) == false) goto L52;
        return ((ArrayAccessSegment) r116).setValue(this, r101, r110);
    L52:
        throw new UnsupportedOperationException();
    L24:
        if (r114.beanInfo.defaultConstructor == null) goto L26;
        r106 = r114.createInstance(null, r113);
        goto L32
    L26:
        return false;
    L21:
        r113 = null;
        r114 = null;
        goto L22
    L29:
        if ((r108 instanceof ArrayAccessSegment) == false) goto L31;
        r106 = new JSONArray();
        goto L32
    L31:
        r106 = null;
        goto L32
    L13:
        r108 = null;
    L39:
        r103 = r103 + 1;
        r102 = r101;
        r101 = r106;
        goto L6
    L40:
        r101 = r102;
        goto L41
    }

    public static boolean set(Object r100, String r101, Object r102) {
        return compile(r101).set(r100, r102);
    }

    public <T> T eval(Object r100, Type r101, ParserConfig r102) {
        return (T) TypeUtils.cast(eval(r100), r101, r102);
    }

    public JSONPath(String r100, SerializeConfig r101, ParserConfig r102, boolean r103) {
        if (r100 == null) goto L9;
        if (r100.length() == 0) goto L9;
        this.path = r100;
        this.serializeConfig = r101;
        this.parserConfig = r102;
        this.ignoreNullValue = r103;
        return;
    L9:
        throw new JSONPathException("json-path can not be null or empty");
    }

    public static <T> T read(String r100, String r101, Type r102, ParserConfig r103) {
        return (T) compile(r101).eval(JSON.parse(r100), r102, r103);
    }

    public void deepSet(Object r100, String r110, long r111, Object r112) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof Map) == false) goto L15;
        Map r101 = (Map) r100;
        if (r101.containsKey(r110) == false) goto L10;
        r101.get(r110);
        r101.put(r110, r112);
        return;
    L10:
        Iterator r102 = r101.values().iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        deepSet(r102.next(), r110, r111, r112);
        goto L12
    L14:
        return;
    L15:
        Class<?> r103 = r100.getClass();
        JavaBeanDeserializer r104 = getJavaBeanDeserializer(r103);
        if (r104 == null) goto L31;
        FieldDeserializer r105 = r104.getFieldDeserializer(r110);     // Catch: Exception -> L27
        if (r105 == null) goto L21;
        r105.setValue(r100, r112);     // Catch: Exception -> L27
        return;
    L21:
        Iterator<Object> r106 = getJavaBeanSerializer(r103).getObjectFieldValues(r100).iterator();     // Catch: Exception -> L27
    L23:
        if (r106.hasNext() == false) goto L26;
        deepSet(r106.next(), r110, r111, r112);     // Catch: Exception -> L27
        goto L23
    L26:
        return;
    L27:
        e = move-exception;
        throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + r110, e);
    L31:
        if ((r100 instanceof List) == false) goto L36;
        List r107 = (List) r100;
        int r108 = 0;
    L34:
        if (r108 >= r107.size()) goto L41;
        deepSet(ListProtector.get(r107, r108), r110, r111, r112);
        r108 = r108 + 1;
        goto L34
    L41:
        return;
    }

    public boolean setArrayItem(JSONPath r100, Object r101, int r102, Object r103) {
        if ((r101 instanceof List) == false) goto L9;
        List r104 = (List) r101;
        if (r102 < 0) goto L7;
        ListProtector.set(r104, r102, r103);
    L8:
        return true;
    L7:
        ListProtector.set(r104, r104.size() + r102, r103);
        goto L8
    L9:
        Class<?> r105 = r101.getClass();
        if (r105.isArray() == false) goto L20;
        int r106 = Array.getLength(r101);
        if (r102 < 0) goto L16;
        if (r102 >= r106) goto L18;
        Array.set(r101, r102, r103);
    L18:
        return true;
    L16:
        if (Math.abs(r102) > r106) goto L18;
        Array.set(r101, r106 + r102, r103);
        goto L18
    L20:
        throw new JSONPathException("unsupported set operation." + r105);
    }

    public boolean setPropertyValue(Object r100, String r110, long r111, Object r112) {
        if ((r100 instanceof Map) == false) goto L7;
        ((Map) r100).put(r110, r112);
        return true;
    L7:
        if ((r100 instanceof List) == false) goto L16;
        Iterator r101 = ((List) r100).iterator();
    L10:
        if (r101.hasNext() == false) goto L15;
        Object r102 = r101.next();
        if (r102 == null) goto L10;
        setPropertyValue(r102, r110, r111, r112);
        goto L10
    L15:
        return true;
    L16:
        ObjectDeserializer r113 = this.parserConfig.getDeserializer(r100.getClass());
        if ((r113 instanceof JavaBeanDeserializer) == false) goto L19;
        JavaBeanDeserializer r114 = (JavaBeanDeserializer) r113;
    L20:
        if (r114 == null) goto L32;
        FieldDeserializer r115 = r114.getFieldDeserializer(r111);
        if (r115 != null) goto L25;
        return false;
    L25:
        if (r112 == null) goto L29;
        Class<?> r116 = r112.getClass();
        FieldInfo r117 = r115.fieldInfo;
        if (r116 == r117.fieldClass) goto L29;
        r112 = TypeUtils.cast(r112, r117.fieldType, this.parserConfig);
    L29:
        r115.setValue(r100, r112);
        return true;
    L32:
        throw new UnsupportedOperationException();
    L19:
        r114 = null;
        goto L20
    }

    public static Object extract(String r100, String r101, ParserConfig r102, int r103, Feature... r104) {
        DefaultJSONParser r105 = new DefaultJSONParser(r100, r102, r103 | Feature.OrderedField.mask);
        Object r106 = compile(r101).extract(r105);
        r105.lexer.close();
        return r106;
    }

    private static void paths(Map<Object, String> r100, Map<String, Object> r101, String r102, Object r103, SerializeConfig r104) {
        if (r103 != null) goto L4;
        return;
    L4:
        int r105 = 0;
        if (r100.put(r103, r102) == null) goto L25;
        Class<?> r106 = r103.getClass();
        if (r106 != String.class) goto L9;
    L22:
        boolean r107 = true;
    L23:
        if (r107 == true) goto L25;
        return;
    L9:
        if (r106 == Boolean.class) goto L22;
        if (r106 == Character.class) goto L22;
        if (r106 == UUID.class) goto L22;
        if (r106.isEnum() == true) goto L22;
        if ((r103 instanceof Number) == true) goto L22;
        if ((r103 instanceof Date) == true) goto L22;
        r107 = false;
    L25:
        r101.put(r102, r103);
        if ((r103 instanceof Map) == false) goto L39;
        Iterator r108 = ((Map) r103).entrySet().iterator();
    L29:
        if (r108.hasNext() == false) goto L37;
        Map.Entry r109 = (Map.Entry) r108.next();
        Object r110 = r109.getKey();
        if ((r110 instanceof String) == false) goto L29;
        if (r102.equals(HTTP.URL_DEFAULT) == false) goto L35;
        StringBuilder r111 = new StringBuilder(HTTP.URL_DEFAULT);
    L36:
        r111.append(r110);
        paths(r100, r101, r111.toString(), r109.getValue(), r104);
        goto L29
    L35:
        r111 = new StringBuilder();
        r111.append(r102);
        r111.append(HTTP.URL_DEFAULT);
        goto L36
    L37:
        return;
    L39:
        if ((r103 instanceof Collection) == false) goto L49;
        Iterator r112 = ((Collection) r103).iterator();
    L42:
        if (r112.hasNext() == false) goto L48;
        Object r113 = r112.next();
        if (r102.equals(HTTP.URL_DEFAULT) == false) goto L46;
        StringBuilder r114 = new StringBuilder(HTTP.URL_DEFAULT);
    L47:
        r114.append(r105);
        paths(r100, r101, r114.toString(), r113, r104);
        r105 = r105 + 1;
        goto L42
    L46:
        r114 = new StringBuilder();
        r114.append(r102);
        r114.append(HTTP.URL_DEFAULT);
        goto L47
    L48:
        return;
    L49:
        Class<?> r115 = r103.getClass();
        if (r115.isArray() == false) goto L60;
        int r116 = Array.getLength(r103);
    L52:
        if (r105 >= r116) goto L58;
        Object r117 = Array.get(r103, r105);
        if (r102.equals(HTTP.URL_DEFAULT) == false) goto L56;
        StringBuilder r118 = new StringBuilder(HTTP.URL_DEFAULT);
    L57:
        r118.append(r105);
        paths(r100, r101, r118.toString(), r117, r104);
        r105 = r105 + 1;
        goto L52
    L56:
        r118 = new StringBuilder();
        r118.append(r102);
        r118.append(HTTP.URL_DEFAULT);
        goto L57
    L58:
        return;
    L60:
        if (ParserConfig.isPrimitive2(r115) == false) goto L62;
        return;
    L62:
        if (r115.isEnum() == true) goto L103;
        ObjectSerializer r119 = r104.getObjectWriter(r115);
        if ((r119 instanceof JavaBeanSerializer) == true) goto L84;
        return;
    L84:
        Iterator<Map.Entry<String, Object>> r120 = ((JavaBeanSerializer) r119).getFieldValuesMap(r103).entrySet().iterator();     // Catch: Exception -> L80
    L68:
        if (r120.hasNext() == false) goto L79;
        Map.Entry<String, Object> r121 = r120.next();     // Catch: Exception -> L80
        String r122 = r121.getKey();     // Catch: Exception -> L80
        if ((r122 instanceof String) == false) goto L68;
        if (r102.equals(HTTP.URL_DEFAULT) == false) goto L76;
        StringBuilder r123 = new StringBuilder();     // Catch: Exception -> L80
        r123.append(HTTP.URL_DEFAULT);     // Catch: Exception -> L80
        r123.append(r122);     // Catch: Exception -> L80
    L75:
        String r124 = r123.toString();     // Catch: Exception -> L80
        paths(r100, r101, r124, r121.getValue(), r104);     // Catch: Exception -> L80
        goto L68
    L76:
        r123 = new StringBuilder();     // Catch: Exception -> L80
        r123.append(r102);     // Catch: Exception -> L80
        r123.append(HTTP.URL_DEFAULT);     // Catch: Exception -> L80
        r123.append(r122);     // Catch: Exception -> L80
        goto L75
    L79:
        return;
    L80:
        e = move-exception;
        throw new JSONException("toJSON error", e);
    }
}
