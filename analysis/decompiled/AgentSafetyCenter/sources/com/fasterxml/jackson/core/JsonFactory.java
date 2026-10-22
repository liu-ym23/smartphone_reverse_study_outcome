package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JacksonFeature;
import com.fasterxml.jackson.core.util.JsonGeneratorDecorator;
import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import com.fasterxml.jackson.core.util.RecyclerPool;
import g5.f;
import java.io.CharArrayReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class JsonFactory extends TokenStreamFactory implements Serializable {
    public static final char DEFAULT_QUOTE_CHAR = '\"';
    public static final String FORMAT_NAME_JSON = "JSON";
    private static final long serialVersionUID = 2;
    protected final transient ByteQuadsCanonicalizer _byteSymbolCanonicalizer;
    protected CharacterEscapes _characterEscapes;
    protected ErrorReportConfiguration _errorReportConfiguration;
    protected int _factoryFeatures;
    protected final List<JsonGeneratorDecorator> _generatorDecorators;
    protected int _generatorFeatures;
    protected InputDecorator _inputDecorator;
    protected int _maximumNonEscapedChar;
    protected ObjectCodec _objectCodec;
    protected OutputDecorator _outputDecorator;
    protected int _parserFeatures;
    protected final char _quoteChar;
    protected RecyclerPool<BufferRecycler> _recyclerPool;
    protected transient CharsToNameCanonicalizer _rootCharSymbols;
    protected SerializableString _rootValueSeparator;
    protected StreamReadConstraints _streamReadConstraints;
    protected StreamWriteConstraints _streamWriteConstraints;
    protected static final int DEFAULT_FACTORY_FEATURE_FLAGS = Feature.collectDefaults();
    protected static final int DEFAULT_PARSER_FEATURE_FLAGS = JsonParser.Feature.collectDefaults();
    protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS = JsonGenerator.Feature.collectDefaults();
    public static final SerializableString DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(" ");

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum Feature implements JacksonFeature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true),
        CHARSET_DETECTION(true);

        private final boolean _defaultState;

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

        @Override // com.fasterxml.jackson.core.util.JacksonFeature
        public boolean enabledByDefault() {
            return this._defaultState;
        }

        @Override // com.fasterxml.jackson.core.util.JacksonFeature
        public boolean enabledIn(int i) {
            return (getMask() & i) != 0;
        }

        @Override // com.fasterxml.jackson.core.util.JacksonFeature
        public int getMask() {
            return 1 << ordinal();
        }
    }

    public JsonFactory(JsonFactoryBuilder jsonFactoryBuilder) {
        this._byteSymbolCanonicalizer = ByteQuadsCanonicalizer.createRoot();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
        this._recyclerPool = jsonFactoryBuilder._recyclerPool;
        this._objectCodec = null;
        this._factoryFeatures = jsonFactoryBuilder._factoryFeatures;
        this._parserFeatures = jsonFactoryBuilder._streamReadFeatures;
        this._generatorFeatures = jsonFactoryBuilder._streamWriteFeatures;
        this._inputDecorator = jsonFactoryBuilder._inputDecorator;
        this._outputDecorator = jsonFactoryBuilder._outputDecorator;
        this._generatorDecorators = _copy(jsonFactoryBuilder._generatorDecorators);
        StreamReadConstraints streamReadConstraints = jsonFactoryBuilder._streamReadConstraints;
        Objects.requireNonNull(streamReadConstraints);
        this._streamReadConstraints = streamReadConstraints;
        StreamWriteConstraints streamWriteConstraints = jsonFactoryBuilder._streamWriteConstraints;
        Objects.requireNonNull(streamWriteConstraints);
        this._streamWriteConstraints = streamWriteConstraints;
        ErrorReportConfiguration errorReportConfiguration = jsonFactoryBuilder._errorReportConfiguration;
        Objects.requireNonNull(errorReportConfiguration);
        this._errorReportConfiguration = errorReportConfiguration;
        this._characterEscapes = jsonFactoryBuilder._characterEscapes;
        this._rootValueSeparator = jsonFactoryBuilder._rootValueSeparator;
        this._maximumNonEscapedChar = jsonFactoryBuilder._maximumNonEscapedChar;
        this._quoteChar = jsonFactoryBuilder._quoteChar;
        this._rootCharSymbols = CharsToNameCanonicalizer.createRoot(this);
    }

    public static <T> List<T> _copy(List<T> list) {
        return list == null ? list : new ArrayList(list);
    }

    private final boolean _isJSONFactory() {
        return getFormatName() == FORMAT_NAME_JSON;
    }

    private final void _requireJSONFactory(String str) {
        if (!_isJSONFactory()) {
            throw new UnsupportedOperationException(String.format(str, getFormatName()));
        }
    }

    public static TSFBuilder<?, ?> builder() {
        return new JsonFactoryBuilder();
    }

    public void _checkInvalidCopy(Class<?> cls) {
        if (getClass() == cls) {
            return;
        }
        f.i("Failed copy(): ", getClass().getName(), " (version: ", version(), ") does not override copy(); it has to");
    }

    public ContentReference _createContentReference(Object obj) {
        return ContentReference.construct(!canHandleBinaryNatively(), obj, this._errorReportConfiguration);
    }

    public IOContext _createContext(ContentReference contentReference, boolean z10) {
        BufferRecycler bufferRecycler = null;
        boolean z11 = false;
        if (contentReference == null) {
            contentReference = ContentReference.unknown();
        } else {
            Object rawContent = contentReference.getRawContent();
            if ((rawContent instanceof BufferRecycler.Gettable) && (bufferRecycler = ((BufferRecycler.Gettable) rawContent).bufferRecycler()) != null) {
                z11 = true;
            }
        }
        ContentReference contentReference2 = contentReference;
        if (bufferRecycler == null) {
            bufferRecycler = _getBufferRecycler();
        }
        IOContext iOContext = new IOContext(this._streamReadConstraints, this._streamWriteConstraints, this._errorReportConfiguration, bufferRecycler, contentReference2, z10);
        if (z11) {
            iOContext.markBufferRecyclerReleased();
        }
        return iOContext;
    }

    public JsonGenerator _createGenerator(Writer writer, IOContext iOContext) {
        WriterBasedJsonGenerator writerBasedJsonGenerator = new WriterBasedJsonGenerator(iOContext, this._generatorFeatures, this._objectCodec, writer, this._quoteChar);
        int i = this._maximumNonEscapedChar;
        if (i > 0) {
            writerBasedJsonGenerator.setHighestNonEscapedChar(i);
        }
        CharacterEscapes characterEscapes = this._characterEscapes;
        if (characterEscapes != null) {
            writerBasedJsonGenerator.setCharacterEscapes(characterEscapes);
        }
        SerializableString serializableString = this._rootValueSeparator;
        if (serializableString != DEFAULT_ROOT_VALUE_SEPARATOR) {
            writerBasedJsonGenerator.setRootValueSeparator(serializableString);
        }
        return _decorate(writerBasedJsonGenerator);
    }

    public IOContext _createNonBlockingContext(Object obj) {
        return new IOContext(this._streamReadConstraints, this._streamWriteConstraints, this._errorReportConfiguration, _getBufferRecycler(), _createContentReference(obj), false);
    }

    public JsonParser _createParser(InputStream inputStream, IOContext iOContext) throws IOException {
        try {
            return new ByteSourceJsonBootstrapper(iOContext, inputStream).constructParser(this._parserFeatures, this._objectCodec, this._byteSymbolCanonicalizer, this._rootCharSymbols, this._factoryFeatures);
        } catch (IOException | RuntimeException e10) {
            if (iOContext.isResourceManaged()) {
                try {
                    inputStream.close();
                } catch (Exception e11) {
                    e10.addSuppressed(e11);
                }
            }
            iOContext.close();
            throw e10;
        }
    }

    public JsonGenerator _createUTF8Generator(OutputStream outputStream, IOContext iOContext) {
        UTF8JsonGenerator uTF8JsonGenerator = new UTF8JsonGenerator(iOContext, this._generatorFeatures, this._objectCodec, outputStream, this._quoteChar);
        int i = this._maximumNonEscapedChar;
        if (i > 0) {
            uTF8JsonGenerator.setHighestNonEscapedChar(i);
        }
        CharacterEscapes characterEscapes = this._characterEscapes;
        if (characterEscapes != null) {
            uTF8JsonGenerator.setCharacterEscapes(characterEscapes);
        }
        SerializableString serializableString = this._rootValueSeparator;
        if (serializableString != DEFAULT_ROOT_VALUE_SEPARATOR) {
            uTF8JsonGenerator.setRootValueSeparator(serializableString);
        }
        return _decorate(uTF8JsonGenerator);
    }

    public Writer _createWriter(OutputStream outputStream, JsonEncoding jsonEncoding, IOContext iOContext) {
        return jsonEncoding == JsonEncoding.UTF8 ? new UTF8Writer(iOContext, outputStream) : new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }

    public JsonGenerator _decorate(JsonGenerator jsonGenerator) {
        List<JsonGeneratorDecorator> list = this._generatorDecorators;
        if (list != null) {
            Iterator<JsonGeneratorDecorator> it = list.iterator();
            while (it.hasNext()) {
                jsonGenerator = it.next().decorate(this, jsonGenerator);
            }
        }
        return jsonGenerator;
    }

    public BufferRecycler _getBufferRecycler() {
        return (BufferRecycler) _getRecyclerPool().acquireAndLinkPooled();
    }

    public RecyclerPool<BufferRecycler> _getRecyclerPool() {
        return !Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.enabledIn(this._factoryFeatures) ? JsonRecyclerPools.nonRecyclingPool() : this._recyclerPool;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public boolean canHandleBinaryNatively() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public boolean canParseAsync() {
        return _isJSONFactory();
    }

    public boolean canUseCharArrays() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public boolean canUseSchema(FormatSchema formatSchema) {
        String formatName;
        return (formatSchema == null || (formatName = getFormatName()) == null || !formatName.equals(formatSchema.getSchemaType())) ? false : true;
    }

    @Deprecated
    public final JsonFactory configure(Feature feature, boolean z10) {
        return z10 ? enable(feature) : disable(feature);
    }

    public JsonFactory copy() {
        _checkInvalidCopy(JsonFactory.class);
        return new JsonFactory(this, (ObjectCodec) null);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) {
        OutputStream outputStream_fileOutputStream = _fileOutputStream(file);
        IOContext iOContext_createContext = _createContext(_createContentReference(outputStream_fileOutputStream), true);
        iOContext_createContext.setEncoding(jsonEncoding);
        return jsonEncoding == JsonEncoding.UTF8 ? _createUTF8Generator(_decorate(outputStream_fileOutputStream, iOContext_createContext), iOContext_createContext) : _createGenerator(_decorate(_createWriter(outputStream_fileOutputStream, jsonEncoding, iOContext_createContext), iOContext_createContext), iOContext_createContext);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(OutputStream outputStream) {
        return createGenerator(outputStream, JsonEncoding.UTF8);
    }

    @Deprecated
    public JsonParser createJsonParser(File file) {
        return createParser(file);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createNonBlockingByteArrayParser() {
        _requireJSONFactory("Non-blocking source not (yet?) supported for this format (%s)");
        return new NonBlockingJsonParser(_createNonBlockingContext(null), this._parserFeatures, this._byteSymbolCanonicalizer.makeChildOrPlaceholder(this._factoryFeatures));
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createNonBlockingByteBufferParser() {
        _requireJSONFactory("Non-blocking source not (yet?) supported for this format (%s)");
        return new NonBlockingByteBufferJsonParser(_createNonBlockingContext(null), this._parserFeatures, this._byteSymbolCanonicalizer.makeChildOrPlaceholder(this._factoryFeatures));
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(String str) {
        int length = str.length();
        if (this._inputDecorator != null || length > 32768 || !canUseCharArrays()) {
            return createParser(new StringReader(str));
        }
        IOContext iOContext_createContext = _createContext(_createContentReference(str), true);
        char[] cArrAllocTokenBuffer = iOContext_createContext.allocTokenBuffer(length);
        str.getChars(0, length, cArrAllocTokenBuffer, 0);
        return _createParser(cArrAllocTokenBuffer, 0, length, iOContext_createContext, true);
    }

    @Deprecated
    public JsonFactory disable(Feature feature) {
        this._factoryFeatures = (~feature.getMask()) & this._factoryFeatures;
        return this;
    }

    @Deprecated
    public JsonFactory enable(Feature feature) {
        this._factoryFeatures = feature.getMask() | this._factoryFeatures;
        return this;
    }

    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }

    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final int getFactoryFeatures() {
        return this._factoryFeatures;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public int getFormatGeneratorFeatures() {
        return 0;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public String getFormatName() {
        if (getClass() == JsonFactory.class) {
            return FORMAT_NAME_JSON;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public int getFormatParserFeatures() {
        return 0;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public Class<? extends FormatFeature> getFormatReadFeatureType() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public Class<? extends FormatFeature> getFormatWriteFeatureType() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final int getGeneratorFeatures() {
        return this._generatorFeatures;
    }

    public InputDecorator getInputDecorator() {
        return this._inputDecorator;
    }

    public OutputDecorator getOutputDecorator() {
        return this._outputDecorator;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final int getParserFeatures() {
        return this._parserFeatures;
    }

    public String getRootValueSeparator() {
        SerializableString serializableString = this._rootValueSeparator;
        if (serializableString == null) {
            return null;
        }
        return serializableString.getValue();
    }

    public MatchStrength hasFormat(InputAccessor inputAccessor) {
        if (getClass() == JsonFactory.class) {
            return hasJSONFormat(inputAccessor);
        }
        return null;
    }

    public MatchStrength hasJSONFormat(InputAccessor inputAccessor) {
        return ByteSourceJsonBootstrapper.hasJSONFormat(inputAccessor);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final boolean isEnabled(StreamReadFeature streamReadFeature) {
        return (this._parserFeatures & streamReadFeature.mappedFeature().getMask()) != 0;
    }

    public Object readResolve() {
        return new JsonFactory(this, this._objectCodec);
    }

    public TSFBuilder<?, ?> rebuild() {
        _requireJSONFactory("Factory implementation for format (%s) MUST override `rebuild()` method");
        return new JsonFactoryBuilder(this);
    }

    public boolean requiresCustomCodec() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public boolean requiresPropertyOrdering() {
        return false;
    }

    public JsonFactory setCharacterEscapes(CharacterEscapes characterEscapes) {
        this._characterEscapes = characterEscapes;
        return this;
    }

    public JsonFactory setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
        return this;
    }

    public JsonFactory setErrorReportConfiguration(ErrorReportConfiguration errorReportConfiguration) {
        Objects.requireNonNull(errorReportConfiguration, "Cannot pass null ErrorReportConfiguration");
        this._errorReportConfiguration = errorReportConfiguration;
        return this;
    }

    @Deprecated
    public JsonFactory setInputDecorator(InputDecorator inputDecorator) {
        this._inputDecorator = inputDecorator;
        return this;
    }

    @Deprecated
    public JsonFactory setOutputDecorator(OutputDecorator outputDecorator) {
        this._outputDecorator = outputDecorator;
        return this;
    }

    public JsonFactory setRecyclerPool(RecyclerPool<BufferRecycler> recyclerPool) {
        Objects.requireNonNull(recyclerPool);
        this._recyclerPool = recyclerPool;
        return this;
    }

    public JsonFactory setRootValueSeparator(String str) {
        this._rootValueSeparator = str == null ? null : new SerializedString(str);
        return this;
    }

    public JsonFactory setStreamReadConstraints(StreamReadConstraints streamReadConstraints) {
        int maxNameLength = this._streamReadConstraints.getMaxNameLength();
        Objects.requireNonNull(streamReadConstraints);
        this._streamReadConstraints = streamReadConstraints;
        if (streamReadConstraints.getMaxNameLength() != maxNameLength) {
            this._rootCharSymbols = CharsToNameCanonicalizer.createRoot(this);
        }
        return this;
    }

    public JsonFactory setStreamWriteConstraints(StreamWriteConstraints streamWriteConstraints) {
        Objects.requireNonNull(streamWriteConstraints);
        this._streamWriteConstraints = streamWriteConstraints;
        return this;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public StreamReadConstraints streamReadConstraints() {
        return this._streamReadConstraints;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public StreamWriteConstraints streamWriteConstraints() {
        return this._streamWriteConstraints;
    }

    @Override // com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Deprecated
    public JsonParser createJsonParser(URL url) {
        return createParser(url);
    }

    @Deprecated
    public JsonParser createJsonParser(InputStream inputStream) {
        return createParser(inputStream);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(Writer writer) {
        return createGenerator(writer);
    }

    @Deprecated
    public JsonParser createJsonParser(Reader reader) {
        return createParser(reader);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) {
        return createGenerator(outputStream, jsonEncoding);
    }

    @Deprecated
    public JsonParser createJsonParser(byte[] bArr) {
        return createParser(bArr);
    }

    @Deprecated
    public JsonParser createJsonParser(byte[] bArr, int i, int i3) {
        return createParser(bArr, i, i3);
    }

    @Deprecated
    public JsonParser createJsonParser(String str) {
        return createParser(str);
    }

    public JsonFactory enable(JsonParser.Feature feature) {
        this._parserFeatures = feature.getMask() | this._parserFeatures;
        return this;
    }

    public JsonFactory disable(JsonParser.Feature feature) {
        this._parserFeatures = (~feature.getMask()) & this._parserFeatures;
        return this;
    }

    public JsonFactory enable(JsonGenerator.Feature feature) {
        this._generatorFeatures = feature.getMask() | this._generatorFeatures;
        return this;
    }

    public final JsonFactory configure(JsonParser.Feature feature, boolean z10) {
        return z10 ? enable(feature) : disable(feature);
    }

    public JsonFactory disable(JsonGenerator.Feature feature) {
        this._generatorFeatures = (~feature.getMask()) & this._generatorFeatures;
        return this;
    }

    public ContentReference _createContentReference(Object obj, int i, int i3) {
        return ContentReference.construct(!canHandleBinaryNatively(), obj, i, i3, this._errorReportConfiguration);
    }

    public final JsonFactory configure(JsonGenerator.Feature feature, boolean z10) {
        return z10 ? enable(feature) : disable(feature);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final boolean isEnabled(JsonParser.Feature feature) {
        return (this._parserFeatures & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final boolean isEnabled(Feature feature) {
        return (this._factoryFeatures & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final boolean isEnabled(JsonGenerator.Feature feature) {
        return (this._generatorFeatures & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final boolean isEnabled(StreamWriteFeature streamWriteFeature) {
        return (this._generatorFeatures & streamWriteFeature.mappedFeature().getMask()) != 0;
    }

    public final Reader _decorate(Reader reader, IOContext iOContext) {
        Reader readerDecorate;
        InputDecorator inputDecorator = this._inputDecorator;
        return (inputDecorator == null || (readerDecorate = inputDecorator.decorate(iOContext, reader)) == null) ? reader : readerDecorate;
    }

    public final DataInput _decorate(DataInput dataInput, IOContext iOContext) {
        DataInput dataInputDecorate;
        InputDecorator inputDecorator = this._inputDecorator;
        return (inputDecorator == null || (dataInputDecorate = inputDecorator.decorate(iOContext, dataInput)) == null) ? dataInput : dataInputDecorate;
    }

    public final OutputStream _decorate(OutputStream outputStream, IOContext iOContext) {
        OutputStream outputStreamDecorate;
        OutputDecorator outputDecorator = this._outputDecorator;
        return (outputDecorator == null || (outputStreamDecorate = outputDecorator.decorate(iOContext, outputStream)) == null) ? outputStream : outputStreamDecorate;
    }

    public final Writer _decorate(Writer writer, IOContext iOContext) {
        Writer writerDecorate;
        OutputDecorator outputDecorator = this._outputDecorator;
        return (outputDecorator == null || (writerDecorate = outputDecorator.decorate(iOContext, writer)) == null) ? writer : writerDecorate;
    }

    public final InputStream _decorate(InputStream inputStream, IOContext iOContext) {
        InputStream inputStreamDecorate;
        InputDecorator inputDecorator = this._inputDecorator;
        return (inputDecorator == null || (inputStreamDecorate = inputDecorator.decorate(iOContext, inputStream)) == null) ? inputStream : inputStreamDecorate;
    }

    public JsonParser _createParser(Reader reader, IOContext iOContext) {
        return new ReaderBasedJsonParser(iOContext, this._parserFeatures, reader, this._objectCodec, this._rootCharSymbols.makeChild());
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(OutputStream outputStream) {
        return createGenerator(outputStream, JsonEncoding.UTF8);
    }

    public JsonParser _createParser(char[] cArr, int i, int i3, IOContext iOContext, boolean z10) {
        return new ReaderBasedJsonParser(iOContext, this._parserFeatures, null, this._objectCodec, this._rootCharSymbols.makeChild(), cArr, i, i + i3, z10);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(Writer writer) {
        IOContext iOContext_createContext = _createContext(_createContentReference(writer), false);
        return _createGenerator(_decorate(writer, iOContext_createContext), iOContext_createContext);
    }

    public JsonParser _createParser(byte[] bArr, int i, int i3, IOContext iOContext) {
        return new ByteSourceJsonBootstrapper(iOContext, bArr, i, i3).constructParser(this._parserFeatures, this._objectCodec, this._byteSymbolCanonicalizer, this._rootCharSymbols, this._factoryFeatures);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) {
        IOContext iOContext_createContext = _createContext(_createContentReference(outputStream), false);
        iOContext_createContext.setEncoding(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            return _createUTF8Generator(_decorate(outputStream, iOContext_createContext), iOContext_createContext);
        }
        return _createGenerator(_decorate(_createWriter(outputStream, jsonEncoding, iOContext_createContext), iOContext_createContext), iOContext_createContext);
    }

    public JsonParser _createParser(DataInput dataInput, IOContext iOContext) {
        _requireJSONFactory("InputData source not (yet?) supported for this format (%s)");
        int iSkipUTF8BOM = ByteSourceJsonBootstrapper.skipUTF8BOM(dataInput);
        return new UTF8DataInputJsonParser(iOContext, this._parserFeatures, dataInput, this._objectCodec, this._byteSymbolCanonicalizer.makeChildOrPlaceholder(this._factoryFeatures), iSkipUTF8BOM);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(DataOutput dataOutput, JsonEncoding jsonEncoding) {
        return createGenerator(_createDataOutputWrapper(dataOutput), jsonEncoding);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(DataOutput dataOutput) {
        return createGenerator(_createDataOutputWrapper(dataOutput), JsonEncoding.UTF8);
    }

    @Deprecated
    public IOContext _createContext(Object obj, boolean z10) {
        return new IOContext(this._streamReadConstraints, this._streamWriteConstraints, this._errorReportConfiguration, _getBufferRecycler(), _createContentReference(obj), z10);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(URL url) {
        IOContext iOContext_createContext = _createContext(_createContentReference(url), true);
        return _createParser(_decorate(_optimizedStreamFromURL(url), iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(InputStream inputStream) {
        IOContext iOContext_createContext = _createContext(_createContentReference(inputStream), false);
        return _createParser(_decorate(inputStream, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(Reader reader) {
        IOContext iOContext_createContext = _createContext(_createContentReference(reader), false);
        return _createParser(_decorate(reader, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(byte[] bArr) {
        InputStream inputStreamDecorate;
        IOContext iOContext_createContext = _createContext(_createContentReference(bArr), true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (inputStreamDecorate = inputDecorator.decorate(iOContext_createContext, bArr, 0, bArr.length)) != null) {
            return _createParser(inputStreamDecorate, iOContext_createContext);
        }
        return _createParser(bArr, 0, bArr.length, iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(byte[] bArr, int i, int i3) {
        InputStream inputStreamDecorate;
        _checkRangeBoundsForByteArray(bArr, i, i3);
        IOContext iOContext_createContext = _createContext(_createContentReference(bArr, i, i3), true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (inputStreamDecorate = inputDecorator.decorate(iOContext_createContext, bArr, i, i3)) != null) {
            return _createParser(inputStreamDecorate, iOContext_createContext);
        }
        return _createParser(bArr, i, i3, iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(File file) {
        IOContext iOContext_createContext = _createContext(_createContentReference(file), true);
        return _createParser(_decorate(_fileInputStream(file), iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(char[] cArr) {
        return createParser(cArr, 0, cArr.length);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(char[] cArr, int i, int i3) {
        _checkRangeBoundsForCharArray(cArr, i, i3);
        if (this._inputDecorator != null) {
            return createParser(new CharArrayReader(cArr, i, i3));
        }
        return _createParser(cArr, i, i3, _createContext(_createContentReference(cArr, i, i3), true), false);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(DataInput dataInput) {
        IOContext iOContext_createContext = _createContext(_createContentReference(dataInput), false);
        return _createParser(_decorate(dataInput, iOContext_createContext), iOContext_createContext);
    }

    public JsonFactory(ObjectCodec objectCodec) {
        this._byteSymbolCanonicalizer = ByteQuadsCanonicalizer.createRoot();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
        this._recyclerPool = JsonRecyclerPools.defaultPool();
        this._objectCodec = objectCodec;
        this._quoteChar = DEFAULT_QUOTE_CHAR;
        this._streamReadConstraints = StreamReadConstraints.defaults();
        this._streamWriteConstraints = StreamWriteConstraints.defaults();
        this._errorReportConfiguration = ErrorReportConfiguration.defaults();
        this._generatorDecorators = null;
        this._rootCharSymbols = CharsToNameCanonicalizer.createRoot(this);
    }

    public JsonFactory(JsonFactory jsonFactory, ObjectCodec objectCodec) {
        this._byteSymbolCanonicalizer = ByteQuadsCanonicalizer.createRoot();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
        this._recyclerPool = jsonFactory._recyclerPool;
        this._objectCodec = objectCodec;
        this._factoryFeatures = jsonFactory._factoryFeatures;
        this._parserFeatures = jsonFactory._parserFeatures;
        this._generatorFeatures = jsonFactory._generatorFeatures;
        this._inputDecorator = jsonFactory._inputDecorator;
        this._outputDecorator = jsonFactory._outputDecorator;
        this._generatorDecorators = _copy(jsonFactory._generatorDecorators);
        StreamReadConstraints streamReadConstraints = jsonFactory._streamReadConstraints;
        Objects.requireNonNull(streamReadConstraints);
        this._streamReadConstraints = streamReadConstraints;
        StreamWriteConstraints streamWriteConstraints = jsonFactory._streamWriteConstraints;
        Objects.requireNonNull(streamWriteConstraints);
        this._streamWriteConstraints = streamWriteConstraints;
        ErrorReportConfiguration errorReportConfiguration = jsonFactory._errorReportConfiguration;
        Objects.requireNonNull(errorReportConfiguration);
        this._errorReportConfiguration = errorReportConfiguration;
        this._characterEscapes = jsonFactory._characterEscapes;
        this._rootValueSeparator = jsonFactory._rootValueSeparator;
        this._maximumNonEscapedChar = jsonFactory._maximumNonEscapedChar;
        this._quoteChar = jsonFactory._quoteChar;
        this._rootCharSymbols = CharsToNameCanonicalizer.createRoot(this);
    }

    public JsonFactory() {
        this((ObjectCodec) null);
    }

    public JsonFactory(TSFBuilder<?, ?> tSFBuilder, boolean z10) {
        this._byteSymbolCanonicalizer = ByteQuadsCanonicalizer.createRoot();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
        this._recyclerPool = tSFBuilder._recyclerPool;
        this._objectCodec = null;
        this._factoryFeatures = tSFBuilder._factoryFeatures;
        this._parserFeatures = tSFBuilder._streamReadFeatures;
        this._generatorFeatures = tSFBuilder._streamWriteFeatures;
        this._inputDecorator = tSFBuilder._inputDecorator;
        this._outputDecorator = tSFBuilder._outputDecorator;
        this._generatorDecorators = _copy(tSFBuilder._generatorDecorators);
        StreamReadConstraints streamReadConstraints = tSFBuilder._streamReadConstraints;
        Objects.requireNonNull(streamReadConstraints);
        this._streamReadConstraints = streamReadConstraints;
        StreamWriteConstraints streamWriteConstraints = tSFBuilder._streamWriteConstraints;
        Objects.requireNonNull(streamWriteConstraints);
        this._streamWriteConstraints = streamWriteConstraints;
        ErrorReportConfiguration errorReportConfiguration = tSFBuilder._errorReportConfiguration;
        Objects.requireNonNull(errorReportConfiguration);
        this._errorReportConfiguration = errorReportConfiguration;
        this._characterEscapes = null;
        this._rootValueSeparator = null;
        this._maximumNonEscapedChar = 0;
        this._quoteChar = DEFAULT_QUOTE_CHAR;
        this._rootCharSymbols = CharsToNameCanonicalizer.createRoot(this);
    }
}
