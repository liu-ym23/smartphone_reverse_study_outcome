package com.fasterxml.jackson.dataformat.yaml;

import com.autonavi.aps.amapapi.config.Const;
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
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.emitter.Emitter;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes2.dex */
public class YAMLGenerator extends GeneratorBase {
    private static final ImplicitTuple EXPLICIT_TAGS;
    protected static final long MAX_INT_AS_LONG = 2147483647L;
    protected static final long MIN_INT_AS_LONG = -2147483648L;
    private static final ImplicitTuple NO_TAGS;
    private static final DumperOptions.ScalarStyle STYLE_BASE64;
    private static final DumperOptions.ScalarStyle STYLE_LITERAL;
    private static final DumperOptions.ScalarStyle STYLE_PLAIN;
    private static final DumperOptions.ScalarStyle STYLE_QUOTED;
    private static final DumperOptions.ScalarStyle STYLE_SCALAR;
    private static final DumperOptions.ScalarStyle STYLE_UNQUOTED_NAME;
    protected final DumperOptions.Version _docVersion;
    protected Emitter _emitter;
    protected int _formatFeatures;
    protected String _objectId;
    protected DumperOptions _outputOptions;
    protected final StringQuotingChecker _quotingChecker;
    protected int _rootValueCount;
    protected final StreamWriteConstraints _streamWriteConstraints;
    protected String _typeId;
    protected Writer _writer;
    protected static final Pattern PLAIN_NUMBER_P = Pattern.compile("[+-]?[0-9]*(\\.[0-9]*)?");
    protected static final String TAG_BINARY = Tag.BINARY.toString();

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
        public boolean enabledIn(int i10) {
            return (this._mask & i10) != 0;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public int getMask() {
            return this._mask;
        }
    }

    static {
        DumperOptions.ScalarStyle scalarStyle = DumperOptions.ScalarStyle.PLAIN;
        STYLE_UNQUOTED_NAME = scalarStyle;
        STYLE_SCALAR = scalarStyle;
        STYLE_QUOTED = DumperOptions.ScalarStyle.DOUBLE_QUOTED;
        DumperOptions.ScalarStyle scalarStyle2 = DumperOptions.ScalarStyle.LITERAL;
        STYLE_LITERAL = scalarStyle2;
        STYLE_BASE64 = scalarStyle2;
        STYLE_PLAIN = scalarStyle;
        NO_TAGS = new ImplicitTuple(true, true);
        EXPLICIT_TAGS = new ImplicitTuple(false, false);
    }

    public YAMLGenerator(IOContext iOContext, int i10, int i11, StringQuotingChecker stringQuotingChecker, ObjectCodec objectCodec, Writer writer, DumperOptions.Version version) throws IOException {
        super(i10, objectCodec, iOContext);
        this._streamWriteConstraints = iOContext.streamWriteConstraints();
        this._formatFeatures = i11;
        this._quotingChecker = stringQuotingChecker == null ? StringQuotingChecker.Default.instance() : stringQuotingChecker;
        this._writer = writer;
        this._docVersion = version;
        this._outputOptions = buildDumperOptions(i10, i11, version);
        this._emitter = new Emitter(this._writer, this._outputOptions);
        _emit(new StreamStartEvent(null, null));
        _emitStartDocument();
    }

    private final void _writeFieldName(String str) throws IOException {
        _writeScalar(str, "string", this._quotingChecker.needToQuoteName(str) ? STYLE_QUOTED : STYLE_UNQUOTED_NAME);
    }

    private void _writeScalarBinary(Base64Variant base64Variant, byte[] bArr) throws IOException {
        if (base64Variant == Base64Variants.getDefaultVariant()) {
            base64Variant = Base64Variants.MIME;
        }
        _emit(new ScalarEvent(null, TAG_BINARY, EXPLICIT_TAGS, base64Variant.encode(bArr, false, _lf()), null, null, STYLE_BASE64));
    }

    public final void _emit(Event event) throws IOException {
        this._emitter.emit(event);
    }

    public void _emitEndDocument() throws IOException {
        _emit(new DocumentEndEvent(null, null, false));
    }

    public void _emitStartDocument() throws IOException {
        _emit(new DocumentStartEvent(null, null, Feature.WRITE_DOC_START_MARKER.enabledIn(this._formatFeatures), this._docVersion, Collections.EMPTY_MAP));
    }

    public String _lf() {
        return this._outputOptions.getLineBreak().getString();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public void _releaseBuffers() {
    }

    public ScalarEvent _scalarEvent(String str, DumperOptions.ScalarStyle scalarStyle) {
        String str2 = this._typeId;
        if (str2 != null) {
            this._typeId = null;
        }
        String str3 = this._objectId;
        if (str3 != null) {
            this._objectId = null;
        }
        return new ScalarEvent(str3, str2, NO_TAGS, str, null, null, scalarStyle);
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

    public void _writeScalar(String str, String str2, DumperOptions.ScalarStyle scalarStyle) throws IOException {
        _emit(_scalarEvent(str, scalarStyle));
    }

    public DumperOptions buildDumperOptions(int i10, int i11, DumperOptions.Version version) {
        DumperOptions dumperOptions = new DumperOptions();
        if (Feature.CANONICAL_OUTPUT.enabledIn(this._formatFeatures)) {
            dumperOptions.setCanonical(true);
        } else {
            dumperOptions.setCanonical(false);
            dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        }
        dumperOptions.setSplitLines(Feature.SPLIT_LINES.enabledIn(this._formatFeatures));
        if (Feature.INDENT_ARRAYS.enabledIn(this._formatFeatures)) {
            dumperOptions.setIndicatorIndent(1);
            dumperOptions.setIndent(2);
        }
        if (Feature.INDENT_ARRAYS_WITH_INDICATOR.enabledIn(this._formatFeatures)) {
            dumperOptions.setIndicatorIndent(2);
            dumperOptions.setIndentWithIndicator(true);
        }
        if (Feature.USE_PLATFORM_LINE_BREAKS.enabledIn(this._formatFeatures)) {
            dumperOptions.setLineBreak(DumperOptions.LineBreak.getPlatformLineBreak());
        }
        if (Feature.ALLOW_LONG_KEYS.enabledIn(this._formatFeatures)) {
            dumperOptions.setMaxSimpleKeyLength(1024);
        }
        return dumperOptions;
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
        _emit(new StreamEndEvent(null, null));
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
    public JsonGenerator overrideFormatFeatures(int i10, int i11) {
        this._formatFeatures = (i10 & i11) | (this._formatFeatures & (~i11));
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
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i10, int i11) throws IOException {
        if (bArr == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write Binary value");
        if (i10 > 0 || i10 + i11 != bArr.length) {
            bArr = Arrays.copyOfRange(bArr, i10, i11 + i10);
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
        _emit(new SequenceEndEvent(null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndObject() throws IOException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not Object but " + this._writeContext.typeDesc());
        }
        this._typeId = null;
        this._writeContext = this._writeContext.getParent();
        _emit(new MappingEndEvent(null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldId(long j10) throws IOException {
        String string = Long.valueOf(j10).toString();
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
    public void writeNumber(int i10) throws IOException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(i10), "int", STYLE_SCALAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectId(Object obj) throws IOException {
        this._objectId = obj == null ? null : String.valueOf(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectRef(Object obj) throws IOException {
        _verifyValueWrite("write Object reference");
        _emit(new AliasEvent(String.valueOf(obj), null, null));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i10, int i11) throws IOException {
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
        DumperOptions.FlowStyle defaultFlowStyle = this._outputOptions.getDefaultFlowStyle();
        String str = this._typeId;
        boolean z10 = str == null;
        String str2 = this._objectId;
        if (str2 != null) {
            this._objectId = null;
        }
        _emit(new SequenceStartEvent(str2, str, z10, null, null, defaultFlowStyle));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject() throws IOException {
        _verifyValueWrite("start an object");
        JsonWriteContext jsonWriteContextCreateChildObjectContext = this._writeContext.createChildObjectContext();
        this._writeContext = jsonWriteContextCreateChildObjectContext;
        this._streamWriteConstraints.validateNestingDepth(jsonWriteContextCreateChildObjectContext.getNestingDepth());
        DumperOptions.FlowStyle defaultFlowStyle = this._outputOptions.getDefaultFlowStyle();
        String str = this._typeId;
        boolean z10 = str == null;
        String str2 = this._objectId;
        if (str2 != null) {
            this._objectId = null;
        }
        _emit(new MappingStartEvent(str2, str, z10, null, null, defaultFlowStyle));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
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
    public void writeTypeId(Object obj) throws IOException {
        this._typeId = String.valueOf(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeUTF8String(byte[] bArr, int i10, int i11) throws IOException {
        writeString(new String(bArr, i10, i11, "UTF-8"));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i10, int i11) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str, int i10, int i11) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j10) throws IOException {
        if (j10 <= MAX_INT_AS_LONG && j10 >= MIN_INT_AS_LONG) {
            writeNumber((int) j10);
        } else {
            _verifyValueWrite("write number");
            _writeScalar(String.valueOf(j10), "long", STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i10, int i11) throws IOException {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(char[] cArr, int i10, int i11) throws IOException {
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
    public void writeRaw(char c10) throws IOException {
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
    public void writeNumber(double d10) throws IOException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(d10), "double", STYLE_SCALAR);
    }

    public YAMLGenerator(IOContext iOContext, int i10, int i11, StringQuotingChecker stringQuotingChecker, ObjectCodec objectCodec, Writer writer, DumperOptions dumperOptions) throws IOException {
        super(i10, objectCodec, iOContext);
        this._streamWriteConstraints = iOContext.streamWriteConstraints();
        this._formatFeatures = i11;
        this._quotingChecker = stringQuotingChecker == null ? StringQuotingChecker.Default.instance() : stringQuotingChecker;
        this._writer = writer;
        this._docVersion = dumperOptions.getVersion();
        this._outputOptions = dumperOptions;
        this._emitter = new Emitter(this._writer, this._outputOptions);
        _emit(new StreamStartEvent(null, null));
        _emitStartDocument();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f10) throws IOException {
        _verifyValueWrite("write number");
        _writeScalar(String.valueOf(f10), "float", STYLE_SCALAR);
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
            _writeScalar(str, Const.JSON_KEY_NUMBER, STYLE_SCALAR);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i10, int i11) throws IOException {
        writeString(new String(cArr, i10, i11));
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeString(SerializableString serializableString) throws IOException {
        writeString(serializableString.toString());
    }

    @Deprecated
    public YAMLGenerator(IOContext iOContext, int i10, int i11, ObjectCodec objectCodec, Writer writer, DumperOptions.Version version) throws IOException {
        this(iOContext, i10, i11, (StringQuotingChecker) null, objectCodec, writer, version);
    }
}
