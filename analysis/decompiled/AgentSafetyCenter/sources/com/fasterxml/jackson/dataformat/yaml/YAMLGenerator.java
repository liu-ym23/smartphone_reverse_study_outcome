package com.fasterxml.jackson.dataformat.yaml;

import be.a;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.StreamWriteCapability;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;
import vd.b;
import vd.c;
import vd.d;
import zd.e;
import zd.f;
import zd.g;
import zd.h;
import zd.i;
import zd.j;
import zd.l;
import zd.m;
import zd.n;
import zd.o;
import zd.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class YAMLGenerator extends GeneratorBase {
    private static final h EXPLICIT_TAGS;
    protected static final long MAX_INT_AS_LONG = 2147483647L;
    protected static final long MIN_INT_AS_LONG = -2147483648L;
    private static final h NO_TAGS;
    private static final b STYLE_BASE64;
    private static final b STYLE_LITERAL;
    private static final b STYLE_PLAIN;
    private static final b STYLE_QUOTED;
    private static final b STYLE_SCALAR;
    private static final b STYLE_UNQUOTED_NAME;
    protected final c _docVersion;
    protected xd.c _emitter;
    protected int _formatFeatures;
    protected String _objectId;
    protected d _outputOptions;
    protected final StringQuotingChecker _quotingChecker;
    protected int _rootValueCount;
    protected final StreamWriteConstraints _streamWriteConstraints;
    protected String _typeId;
    protected Writer _writer;
    protected static final Pattern PLAIN_NUMBER_P = Pattern.compile("[+-]?[0-9]*(\\.[0-9]*)?");
    protected static final String TAG_BINARY = a.f2083d.f2090a;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
        b bVar = b.PLAIN;
        STYLE_UNQUOTED_NAME = bVar;
        STYLE_SCALAR = bVar;
        STYLE_QUOTED = b.DOUBLE_QUOTED;
        b bVar2 = b.LITERAL;
        STYLE_LITERAL = bVar2;
        STYLE_BASE64 = bVar2;
        STYLE_PLAIN = bVar;
        NO_TAGS = new h(true, true);
        EXPLICIT_TAGS = new h(false, false);
    }

    public YAMLGenerator(IOContext iOContext, int i, int i3, StringQuotingChecker stringQuotingChecker, ObjectCodec objectCodec, Writer writer, c cVar) {
        super(i, objectCodec, iOContext);
        this._streamWriteConstraints = iOContext.streamWriteConstraints();
        this._formatFeatures = i3;
        this._quotingChecker = stringQuotingChecker == null ? StringQuotingChecker.Default.instance() : stringQuotingChecker;
        this._writer = writer;
        this._docVersion = cVar;
        this._outputOptions = buildDumperOptions(i, i3, cVar);
        this._emitter = new xd.c(this._writer, this._outputOptions);
        _emit(new p(null, null));
        _emitStartDocument();
    }

    private final void _writeFieldName(String str) {
        _writeScalar(str, "string", this._quotingChecker.needToQuoteName(str) ? STYLE_QUOTED : STYLE_UNQUOTED_NAME);
    }

    private void _writeScalarBinary(Base64Variant base64Variant, byte[] bArr) {
        if (base64Variant == Base64Variants.getDefaultVariant()) {
            base64Variant = Base64Variants.MIME;
        }
        _emit(new l(null, TAG_BINARY, EXPLICIT_TAGS, base64Variant.encode(bArr, false, _lf()), null, null, STYLE_BASE64));
    }

    public final void _emit(g gVar) {
        xd.c cVar = this._emitter;
        ArrayDeque arrayDeque = cVar.f15690d;
        arrayDeque.add(gVar);
        while (true) {
            boolean zI = true;
            if (!arrayDeque.isEmpty()) {
                Iterator it = arrayDeque.iterator();
                Object next = it.next();
                while (true) {
                    g gVar2 = (g) next;
                    if (!(gVar2 instanceof zd.d)) {
                        zI = gVar2 instanceof f ? xd.c.i(it, 1) : gVar2 instanceof n ? xd.c.i(it, 2) : gVar2 instanceof j ? xd.c.i(it, 3) : gVar2 instanceof p ? xd.c.i(it, 2) : false;
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
            cVar.f15691e = (g) arrayDeque.poll();
            cVar.f15689c.a();
            cVar.f15691e = null;
        }
    }

    public void _emitEndDocument() {
        _emit(new e(null, null, false));
    }

    public void _emitStartDocument() {
        _emit(new f(null, null, Feature.WRITE_DOC_START_MARKER.enabledIn(this._formatFeatures), this._docVersion, Collections.EMPTY_MAP));
    }

    public String _lf() {
        return k0.a.e(this._outputOptions.f14916g);
    }

    public l _scalarEvent(String str, b bVar) {
        String str2 = this._typeId;
        if (str2 != null) {
            this._typeId = null;
        }
        String str3 = this._objectId;
        if (str3 != null) {
            this._objectId = null;
        }
        return new l(str3, str2, NO_TAGS, str, null, null, bVar);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public final void _verifyValueWrite(String str) throws JsonGenerationException {
        if (this._writeContext.writeValue() == 5) {
            _reportError("Can not " + str + ", expecting field name");
        }
        if (!this._writeContext.inRoot() || this._writeContext.getCurrentIndex() <= 0) {
            return;
        }
        _emitEndDocument();
        _emitStartDocument();
    }

    public void _writeScalar(String str, String str2, b bVar) {
        _emit(_scalarEvent(str, bVar));
    }

    public d buildDumperOptions(int i, int i3, c cVar) {
        d dVar = new d();
        dVar.f14910a = vd.a.AUTO;
        int i10 = 0;
        dVar.f14911b = false;
        dVar.f14912c = 2;
        dVar.f14913d = 0;
        dVar.f14914e = false;
        dVar.f14915f = true;
        int i11 = 3;
        dVar.f14916g = 3;
        dVar.f14917h = 128;
        if (Feature.CANONICAL_OUTPUT.enabledIn(this._formatFeatures)) {
            dVar.f14911b = true;
        } else {
            dVar.f14911b = false;
            dVar.f14910a = vd.a.BLOCK;
        }
        dVar.f14915f = Feature.SPLIT_LINES.enabledIn(this._formatFeatures);
        if (Feature.INDENT_ARRAYS.enabledIn(this._formatFeatures)) {
            dVar.f14913d = 1;
            dVar.f14912c = 2;
        }
        if (Feature.INDENT_ARRAYS_WITH_INDICATOR.enabledIn(this._formatFeatures)) {
            dVar.f14913d = 2;
            dVar.f14914e = true;
        }
        if (Feature.USE_PLATFORM_LINE_BREAKS.enabledIn(this._formatFeatures)) {
            String property = System.getProperty("line.separator");
            int[] iArrD = s.f.d(3);
            int length = iArrD.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                int i12 = iArrD[i10];
                if (k0.a.e(i12).equals(property)) {
                    i11 = i12;
                    break;
                }
                i10++;
            }
            dVar.f14916g = i11;
        }
        if (Feature.ALLOW_LONG_KEYS.enabledIn(this._formatFeatures)) {
            dVar.f14917h = 1024;
        }
        return dVar;
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
    public JsonGenerator overrideFormatFeatures(int i, int i3) {
        this._formatFeatures = (i & i3) | (this._formatFeatures & (~i3));
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public StreamWriteConstraints streamWriteConstraints() {
        return this._streamWriteConstraints;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i3) throws JsonGenerationException {
        if (bArr == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write Binary value");
        if (i > 0 || i + i3 != bArr.length) {
            bArr = Arrays.copyOfRange(bArr, i, i3 + i);
        }
        _writeScalarBinary(base64Variant, bArr);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z10) throws JsonGenerationException {
        _verifyValueWrite("write boolean value");
        _writeScalar(z10 ? "true" : "false", "bool", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndArray() throws JsonGenerationException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not Array but " + this._writeContext.typeDesc());
        }
        this._typeId = null;
        this._writeContext = this._writeContext.getParent();
        _emit(new m(null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndObject() throws JsonGenerationException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not Object but " + this._writeContext.typeDesc());
        }
        this._typeId = null;
        this._writeContext = this._writeContext.getParent();
        _emit(new i(null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldId(long j10) throws JsonGenerationException {
        String string = Long.valueOf(j10).toString();
        if (this._writeContext.writeFieldName(string) == 4) {
            _reportError("Can not write a field id, expecting a value");
        }
        _writeScalar(string, "int", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(SerializableString serializableString) throws JsonGenerationException {
        if (this._writeContext.writeFieldName(serializableString.getValue()) == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(serializableString.getValue());
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws JsonGenerationException {
        _verifyValueWrite("write null value");
        _writeScalar("null", "object", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j10) throws JsonGenerationException {
        if (j10 <= MAX_INT_AS_LONG && j10 >= MIN_INT_AS_LONG) {
            writeNumber((int) j10);
        } else {
            _verifyValueWrite("write number");
            _writeScalar(String.valueOf(j10), "long", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectId(Object obj) {
        this._objectId = obj == null ? null : String.valueOf(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectRef(Object obj) throws JsonGenerationException {
        _verifyValueWrite("write Object reference");
        _emit(new zd.a(String.valueOf(obj), null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i3) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartArray() throws JsonGenerationException, StreamConstraintsException {
        _verifyValueWrite("start an array");
        JsonWriteContext jsonWriteContextCreateChildArrayContext = this._writeContext.createChildArrayContext();
        this._writeContext = jsonWriteContextCreateChildArrayContext;
        this._streamWriteConstraints.validateNestingDepth(jsonWriteContextCreateChildArrayContext.getNestingDepth());
        vd.a aVar = this._outputOptions.f14910a;
        String str = this._typeId;
        boolean z10 = str == null;
        String str2 = this._objectId;
        if (str2 != null) {
            this._objectId = null;
        }
        _emit(new n(str2, str, z10, null, null, aVar));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject() throws JsonGenerationException, StreamConstraintsException {
        _verifyValueWrite("start an object");
        JsonWriteContext jsonWriteContextCreateChildObjectContext = this._writeContext.createChildObjectContext();
        this._writeContext = jsonWriteContextCreateChildObjectContext;
        this._streamWriteConstraints.validateNestingDepth(jsonWriteContextCreateChildObjectContext.getNestingDepth());
        vd.a aVar = this._outputOptions.f14910a;
        String str = this._typeId;
        boolean z10 = str == null;
        String str2 = this._objectId;
        if (str2 != null) {
            this._objectId = null;
        }
        _emit(new j(str2, str, z10, null, null, aVar));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws JsonGenerationException {
        if (str == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write String value");
        if (str.isEmpty()) {
            _writeScalar(str, "string", STYLE_QUOTED);
        } else {
            _writeScalar(str, "string", Feature.MINIMIZE_QUOTES.enabledIn(this._formatFeatures) ? str.indexOf(10) >= 0 ? STYLE_LITERAL : (this._quotingChecker.needToQuoteValue(str) || (Feature.ALWAYS_QUOTE_NUMBERS_AS_STRINGS.enabledIn(this._formatFeatures) && PLAIN_NUMBER_P.matcher(str).matches())) ? STYLE_QUOTED : STYLE_PLAIN : (!Feature.LITERAL_BLOCK_STYLE.enabledIn(this._formatFeatures) || str.indexOf(10) < 0) ? STYLE_QUOTED : STYLE_LITERAL);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeTypeId(Object obj) {
        this._typeId = String.valueOf(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeUTF8String(byte[] bArr, int i, int i3) throws JsonGenerationException {
        writeString(new String(bArr, i, i3, "UTF-8"));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i3) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str, int i, int i3) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public YAMLGenerator setPrettyPrinter(PrettyPrinter prettyPrinter) {
        return this;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public YAMLGenerator useDefaultPrettyPrinter() {
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i3) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(char[] cArr, int i, int i3) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c9) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public void _releaseBuffers() {
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(String str) throws JsonGenerationException {
        if (this._writeContext.writeFieldName(str) == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws JsonGenerationException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(i), "int", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws JsonGenerationException {
        if (bigInteger == null) {
            writeNull();
        } else {
            _verifyValueWrite("write number");
            _writeScalar(String.valueOf(bigInteger.toString()), "java.math.BigInteger", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d7) throws JsonGenerationException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(d7), "double", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f5) throws JsonGenerationException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(f5), "float", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws JsonGenerationException {
        if (bigDecimal == null) {
            writeNull();
        } else {
            _verifyValueWrite("write number");
            _writeScalar(isEnabled(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) ? bigDecimal.toPlainString() : bigDecimal.toString(), "java.math.BigDecimal", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws JsonGenerationException {
        if (str == null) {
            writeNull();
        } else {
            _verifyValueWrite("write number");
            _writeScalar(str, "number", STYLE_SCALAR);
        }
    }

    public YAMLGenerator(IOContext iOContext, int i, int i3, StringQuotingChecker stringQuotingChecker, ObjectCodec objectCodec, Writer writer, d dVar) {
        super(i, objectCodec, iOContext);
        this._streamWriteConstraints = iOContext.streamWriteConstraints();
        this._formatFeatures = i3;
        this._quotingChecker = stringQuotingChecker == null ? StringQuotingChecker.Default.instance() : stringQuotingChecker;
        this._writer = writer;
        dVar.getClass();
        this._docVersion = null;
        this._outputOptions = dVar;
        this._emitter = new xd.c(this._writer, this._outputOptions);
        _emit(new p(null, null));
        _emitStartDocument();
    }

    @Deprecated
    public YAMLGenerator(IOContext iOContext, int i, int i3, ObjectCodec objectCodec, Writer writer, c cVar) {
        this(iOContext, i, i3, (StringQuotingChecker) null, objectCodec, writer, cVar);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i3) throws JsonGenerationException {
        writeString(new String(cArr, i, i3));
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeString(SerializableString serializableString) throws JsonGenerationException {
        writeString(serializableString.toString());
    }
}
