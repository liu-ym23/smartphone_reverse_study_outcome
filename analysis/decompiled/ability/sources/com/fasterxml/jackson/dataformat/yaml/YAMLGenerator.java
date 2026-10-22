package com.fasterxml.jackson.dataformat.yaml;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.StreamWriteCapability;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import ea.C1428a;
import ga.c;
import ha.AbstractC1551g;
import ha.C1545a;
import ha.C1548d;
import ha.C1549e;
import ha.C1550f;
import ha.h;
import ha.i;
import ha.j;
import ha.l;
import ha.m;
import ha.n;
import ha.o;
import ha.p;
import ja.C1618a;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.DumperOptions$FlowStyle;
import org.yaml.snakeyaml.DumperOptions$LineBreak;
import org.yaml.snakeyaml.DumperOptions$ScalarStyle;
import org.yaml.snakeyaml.DumperOptions$Version;

/* loaded from: classes3.dex */
public class YAMLGenerator extends GeneratorBase {
    private static final h EXPLICIT_TAGS;
    protected static final long MAX_INT_AS_LONG = 2147483647L;
    protected static final long MIN_INT_AS_LONG = -2147483648L;
    private static final h NO_TAGS;
    private static final DumperOptions$ScalarStyle STYLE_BASE64;
    private static final DumperOptions$ScalarStyle STYLE_LITERAL;
    private static final DumperOptions$ScalarStyle STYLE_PLAIN;
    private static final DumperOptions$ScalarStyle STYLE_QUOTED;
    private static final DumperOptions$ScalarStyle STYLE_SCALAR;
    private static final DumperOptions$ScalarStyle STYLE_UNQUOTED_NAME;
    protected final DumperOptions$Version _docVersion;
    protected c _emitter;
    protected int _formatFeatures;
    protected String _objectId;
    protected C1428a _outputOptions;
    protected final StringQuotingChecker _quotingChecker;
    protected int _rootValueCount;
    protected final StreamWriteConstraints _streamWriteConstraints;
    protected String _typeId;
    protected Writer _writer;
    protected static final Pattern PLAIN_NUMBER_P = Pattern.compile("[+-]?[0-9]*(\\.[0-9]*)?");
    protected static final String TAG_BINARY = C1618a.d.f4790a;

    public enum Feature implements FormatFeature {
        WRITE_DOC_START_MARKER(true),
        USE_NATIVE_OBJECT_ID(true),
        USE_NATIVE_TYPE_ID(true),
        CANONICAL_OUTPUT(false),
        SPLIT_LINES(true),
        MINIMIZE_QUOTES(false),
        ALWAYS_QUOTE_NUMBERS_AS_STRINGS(false),
        LITERAL_BLOCK_STYLE(false),
        INDENT_ARRAYS(false),
        INDENT_ARRAYS_WITH_INDICATOR(false),
        USE_PLATFORM_LINE_BREAKS(false),
        ALLOW_LONG_KEYS(false);

        protected final boolean _defaultState;
        protected final int _mask = 1 << ordinal();

        Feature(boolean z10) {
            this._defaultState = z10;
        }

        public static int collectDefaults() {
            int mask = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    mask |= feature.getMask();
                }
            }
            return mask;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public boolean enabledByDefault() {
            return this._defaultState;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public boolean enabledIn(int i) {
            return (this._mask & i) != 0;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public int getMask() {
            return this._mask;
        }
    }

    static {
        DumperOptions$ScalarStyle dumperOptions$ScalarStyle = DumperOptions$ScalarStyle.PLAIN;
        STYLE_UNQUOTED_NAME = dumperOptions$ScalarStyle;
        STYLE_SCALAR = dumperOptions$ScalarStyle;
        STYLE_QUOTED = DumperOptions$ScalarStyle.DOUBLE_QUOTED;
        DumperOptions$ScalarStyle dumperOptions$ScalarStyle2 = DumperOptions$ScalarStyle.LITERAL;
        STYLE_LITERAL = dumperOptions$ScalarStyle2;
        STYLE_BASE64 = dumperOptions$ScalarStyle2;
        STYLE_PLAIN = dumperOptions$ScalarStyle;
        NO_TAGS = new h(true, true);
        EXPLICIT_TAGS = new h(false, false);
    }

    public YAMLGenerator(IOContext iOContext, int i, int i6, StringQuotingChecker stringQuotingChecker, ObjectCodec objectCodec, Writer writer, DumperOptions$Version dumperOptions$Version) throws IOException {
        super(i, objectCodec, iOContext);
        this._streamWriteConstraints = iOContext.streamWriteConstraints();
        this._formatFeatures = i6;
        this._quotingChecker = stringQuotingChecker == null ? StringQuotingChecker.Default.instance() : stringQuotingChecker;
        this._writer = writer;
        this._docVersion = dumperOptions$Version;
        this._outputOptions = buildDumperOptions(i, i6, dumperOptions$Version);
        this._emitter = new c(this._writer, this._outputOptions);
        _emit(new p(null, null));
        _emitStartDocument();
    }

    private final void _writeFieldName(String str) throws IOException {
        _writeScalar(str, TypedValues.Custom.S_STRING, this._quotingChecker.needToQuoteName(str) ? STYLE_QUOTED : STYLE_UNQUOTED_NAME);
    }

    private void _writeScalarBinary(Base64Variant base64Variant, byte[] bArr) throws IOException {
        if (base64Variant == Base64Variants.getDefaultVariant()) {
            base64Variant = Base64Variants.MIME;
        }
        _emit(new l(null, TAG_BINARY, EXPLICIT_TAGS, base64Variant.encode(bArr, false, _lf()), null, null, STYLE_BASE64));
    }

    public final void _emit(AbstractC1551g abstractC1551g) throws IOException {
        c cVar = this._emitter;
        ArrayDeque arrayDeque = cVar.d;
        arrayDeque.add(abstractC1551g);
        while (true) {
            boolean zI = true;
            if (!arrayDeque.isEmpty()) {
                Iterator it = arrayDeque.iterator();
                Object next = it.next();
                while (true) {
                    AbstractC1551g abstractC1551g2 = (AbstractC1551g) next;
                    if (!(abstractC1551g2 instanceof C1548d)) {
                        zI = abstractC1551g2 instanceof C1550f ? c.i(it, 1) : abstractC1551g2 instanceof n ? c.i(it, 2) : abstractC1551g2 instanceof j ? c.i(it, 3) : abstractC1551g2 instanceof p ? c.i(it, 2) : false;
                    } else if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
            }
            if (zI) {
                return;
            }
            cVar.e = (AbstractC1551g) arrayDeque.poll();
            cVar.c.a();
            cVar.e = null;
        }
    }

    public void _emitEndDocument() throws IOException {
        _emit(new C1549e(null, null, false));
    }

    public void _emitStartDocument() throws IOException {
        _emit(new C1550f(null, null, Feature.WRITE_DOC_START_MARKER.enabledIn(this._formatFeatures), this._docVersion, Collections.EMPTY_MAP));
    }

    public String _lf() {
        return this._outputOptions.g.f5519a;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public void _releaseBuffers() {
    }

    public l _scalarEvent(String str, DumperOptions$ScalarStyle dumperOptions$ScalarStyle) {
        String str2 = this._typeId;
        if (str2 != null) {
            this._typeId = null;
        }
        String str3 = this._objectId;
        if (str3 != null) {
            this._objectId = null;
        }
        return new l(str3, str2, NO_TAGS, str, null, null, dumperOptions$ScalarStyle);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public final void _verifyValueWrite(String str) throws IOException {
        if (this._writeContext.writeValue() == 5) {
            _reportError("Can not " + str + ", expecting field name");
        }
        if (!this._writeContext.inRoot() || this._writeContext.getCurrentIndex() <= 0) {
            return;
        }
        _emitEndDocument();
        _emitStartDocument();
    }

    public void _writeScalar(String str, String str2, DumperOptions$ScalarStyle dumperOptions$ScalarStyle) throws IOException {
        _emit(_scalarEvent(str, dumperOptions$ScalarStyle));
    }

    public C1428a buildDumperOptions(int i, int i6, DumperOptions$Version dumperOptions$Version) {
        C1428a c1428a = new C1428a();
        c1428a.f4431a = DumperOptions$FlowStyle.AUTO;
        int i10 = 0;
        c1428a.b = false;
        c1428a.c = 2;
        c1428a.d = 0;
        c1428a.e = false;
        c1428a.f = true;
        DumperOptions$LineBreak dumperOptions$LineBreak = DumperOptions$LineBreak.UNIX;
        c1428a.g = dumperOptions$LineBreak;
        c1428a.h = 128;
        if (Feature.CANONICAL_OUTPUT.enabledIn(this._formatFeatures)) {
            c1428a.b = true;
        } else {
            c1428a.b = false;
            c1428a.f4431a = DumperOptions$FlowStyle.BLOCK;
        }
        c1428a.f = Feature.SPLIT_LINES.enabledIn(this._formatFeatures);
        if (Feature.INDENT_ARRAYS.enabledIn(this._formatFeatures)) {
            c1428a.d = 1;
            c1428a.c = 2;
        }
        if (Feature.INDENT_ARRAYS_WITH_INDICATOR.enabledIn(this._formatFeatures)) {
            c1428a.d = 2;
            c1428a.e = true;
        }
        if (Feature.USE_PLATFORM_LINE_BREAKS.enabledIn(this._formatFeatures)) {
            String property = System.getProperty("line.separator");
            DumperOptions$LineBreak[] dumperOptions$LineBreakArrValues = DumperOptions$LineBreak.values();
            int length = dumperOptions$LineBreakArrValues.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                DumperOptions$LineBreak dumperOptions$LineBreak2 = dumperOptions$LineBreakArrValues[i10];
                if (dumperOptions$LineBreak2.f5519a.equals(property)) {
                    dumperOptions$LineBreak = dumperOptions$LineBreak2;
                    break;
                }
                i10++;
            }
            c1428a.g = dumperOptions$LineBreak;
        }
        if (Feature.ALLOW_LONG_KEYS.enabledIn(this._formatFeatures)) {
            c1428a.h = 1024;
        }
        return c1428a;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canUseSchema(FormatSchema formatSchema) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteFormattedNumbers() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteObjectId() {
        return Feature.USE_NATIVE_OBJECT_ID.enabledIn(this._formatFeatures);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteTypeId() {
        return Feature.USE_NATIVE_TYPE_ID.enabledIn(this._formatFeatures);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (isClosed()) {
            return;
        }
        _emitEndDocument();
        _emit(new o(null, null));
        if (this._writer != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this._writer.close();
            } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this._writer.flush();
            }
        }
        super.close();
    }

    public YAMLGenerator configure(Feature feature, boolean z10) {
        if (z10) {
            enable(feature);
            return this;
        }
        disable(feature);
        return this;
    }

    public YAMLGenerator disable(Feature feature) {
        this._formatFeatures = (~feature.getMask()) & this._formatFeatures;
        return this;
    }

    public YAMLGenerator enable(Feature feature) {
        this._formatFeatures = feature.getMask() | this._formatFeatures;
        return this;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public final void flush() throws IOException {
        if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this._writer.flush();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getFormatFeatures() {
        return this._formatFeatures;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getOutputBuffered() {
        return -1;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this._writer;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JacksonFeatureSet<StreamWriteCapability> getWriteCapabilities() {
        return JsonGenerator.DEFAULT_TEXTUAL_WRITE_CAPABILITIES;
    }

    public final boolean isEnabled(Feature feature) {
        return (this._formatFeatures & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator overrideFormatFeatures(int i, int i6) {
        this._formatFeatures = (i & i6) | (this._formatFeatures & (~i6));
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public YAMLGenerator setPrettyPrinter(PrettyPrinter prettyPrinter) {
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public StreamWriteConstraints streamWriteConstraints() {
        return this._streamWriteConstraints;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public YAMLGenerator useDefaultPrettyPrinter() {
        return this;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i6) throws IOException {
        if (bArr == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write Binary value");
        if (i > 0 || i + i6 != bArr.length) {
            bArr = Arrays.copyOfRange(bArr, i, i6 + i);
        }
        _writeScalarBinary(base64Variant, bArr);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z10) throws IOException {
        _verifyValueWrite("write boolean value");
        _writeScalar(z10 ? "true" : "false", "bool", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndArray() throws IOException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not Array but " + this._writeContext.typeDesc());
        }
        this._typeId = null;
        this._writeContext = this._writeContext.getParent();
        _emit(new m(null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndObject() throws IOException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not Object but " + this._writeContext.typeDesc());
        }
        this._typeId = null;
        this._writeContext = this._writeContext.getParent();
        _emit(new i(null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldId(long j5) throws IOException {
        String string = Long.valueOf(j5).toString();
        if (this._writeContext.writeFieldName(string) == 4) {
            _reportError("Can not write a field id, expecting a value");
        }
        _writeScalar(string, "int", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(String str) throws IOException {
        if (this._writeContext.writeFieldName(str) == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        _verifyValueWrite("write null value");
        _writeScalar("null", "object", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(i), "int", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectId(Object obj) throws IOException {
        this._objectId = obj == null ? null : String.valueOf(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectRef(Object obj) throws IOException {
        _verifyValueWrite("write Object reference");
        _emit(new C1545a(String.valueOf(obj), null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i6) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartArray() throws IOException {
        _verifyValueWrite("start an array");
        JsonWriteContext jsonWriteContextCreateChildArrayContext = this._writeContext.createChildArrayContext();
        this._writeContext = jsonWriteContextCreateChildArrayContext;
        this._streamWriteConstraints.validateNestingDepth(jsonWriteContextCreateChildArrayContext.getNestingDepth());
        DumperOptions$FlowStyle dumperOptions$FlowStyle = this._outputOptions.f4431a;
        String str = this._typeId;
        boolean z10 = str == null;
        String str2 = this._objectId;
        if (str2 != null) {
            this._objectId = null;
        }
        _emit(new n(str2, str, z10, null, null, dumperOptions$FlowStyle));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject() throws IOException {
        _verifyValueWrite("start an object");
        JsonWriteContext jsonWriteContextCreateChildObjectContext = this._writeContext.createChildObjectContext();
        this._writeContext = jsonWriteContextCreateChildObjectContext;
        this._streamWriteConstraints.validateNestingDepth(jsonWriteContextCreateChildObjectContext.getNestingDepth());
        DumperOptions$FlowStyle dumperOptions$FlowStyle = this._outputOptions.f4431a;
        String str = this._typeId;
        boolean z10 = str == null;
        String str2 = this._objectId;
        if (str2 != null) {
            this._objectId = null;
        }
        _emit(new j(str2, str, z10, null, null, dumperOptions$FlowStyle));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        if (str == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write String value");
        if (str.isEmpty()) {
            _writeScalar(str, TypedValues.Custom.S_STRING, STYLE_QUOTED);
        } else {
            _writeScalar(str, TypedValues.Custom.S_STRING, Feature.MINIMIZE_QUOTES.enabledIn(this._formatFeatures) ? str.indexOf(10) >= 0 ? STYLE_LITERAL : (this._quotingChecker.needToQuoteValue(str) || (Feature.ALWAYS_QUOTE_NUMBERS_AS_STRINGS.enabledIn(this._formatFeatures) && PLAIN_NUMBER_P.matcher(str).matches())) ? STYLE_QUOTED : STYLE_PLAIN : (!Feature.LITERAL_BLOCK_STYLE.enabledIn(this._formatFeatures) || str.indexOf(10) < 0) ? STYLE_QUOTED : STYLE_LITERAL);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeTypeId(Object obj) throws IOException {
        this._typeId = String.valueOf(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeUTF8String(byte[] bArr, int i, int i6) throws IOException {
        writeString(new String(bArr, i, i6, "UTF-8"));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i6) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str, int i, int i6) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j5) throws IOException {
        if (j5 <= 2147483647L && j5 >= -2147483648L) {
            writeNumber((int) j5);
        } else {
            _verifyValueWrite("write number");
            _writeScalar(String.valueOf(j5), "long", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i6) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(char[] cArr, int i, int i6) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(SerializableString serializableString) throws IOException {
        if (this._writeContext.writeFieldName(serializableString.getValue()) == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(serializableString.getValue());
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        if (bigInteger == null) {
            writeNull();
        } else {
            _verifyValueWrite("write number");
            _writeScalar(String.valueOf(bigInteger.toString()), "java.math.BigInteger", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d) throws IOException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(d), "double", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f) throws IOException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(f), TypedValues.Custom.S_FLOAT, STYLE_SCALAR);
    }

    public YAMLGenerator(IOContext iOContext, int i, int i6, StringQuotingChecker stringQuotingChecker, ObjectCodec objectCodec, Writer writer, C1428a c1428a) throws IOException {
        super(i, objectCodec, iOContext);
        this._streamWriteConstraints = iOContext.streamWriteConstraints();
        this._formatFeatures = i6;
        this._quotingChecker = stringQuotingChecker == null ? StringQuotingChecker.Default.instance() : stringQuotingChecker;
        this._writer = writer;
        c1428a.getClass();
        this._docVersion = null;
        this._outputOptions = c1428a;
        this._emitter = new c(this._writer, this._outputOptions);
        _emit(new p(null, null));
        _emitStartDocument();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        if (bigDecimal == null) {
            writeNull();
        } else {
            _verifyValueWrite("write number");
            _writeScalar(isEnabled(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) ? bigDecimal.toPlainString() : bigDecimal.toString(), "java.math.BigDecimal", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws UnsupportedOperationException, IOException {
        if (str == null) {
            writeNull();
        } else {
            _verifyValueWrite("write number");
            _writeScalar(str, "number", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i6) throws IOException {
        writeString(new String(cArr, i, i6));
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeString(SerializableString serializableString) throws IOException {
        writeString(serializableString.toString());
    }

    @Deprecated
    public YAMLGenerator(IOContext iOContext, int i, int i6, ObjectCodec objectCodec, Writer writer, DumperOptions$Version dumperOptions$Version) throws IOException {
        this(iOContext, i, i6, (StringQuotingChecker) null, objectCodec, writer, dumperOptions$Version);
    }
}
