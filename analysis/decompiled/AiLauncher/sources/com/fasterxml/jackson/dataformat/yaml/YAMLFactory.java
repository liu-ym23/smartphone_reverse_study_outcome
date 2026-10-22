package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.net.URL;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;

/* loaded from: classes2.dex */
public class YAMLFactory extends JsonFactory {
    public static final String FORMAT_NAME_YAML = "YAML";
    private static final byte UTF8_BOM_1 = -17;
    private static final byte UTF8_BOM_2 = -69;
    private static final byte UTF8_BOM_3 = -65;
    private static final long serialVersionUID = 1;
    protected final DumperOptions _dumperOptions;
    protected final LoaderOptions _loaderOptions;
    protected final StringQuotingChecker _quotingChecker;
    protected final DumperOptions.Version _version;
    protected int _yamlGeneratorFeatures;
    protected int _yamlParserFeatures;
    protected static final int DEFAULT_YAML_PARSER_FEATURE_FLAGS = YAMLParser.Feature.collectDefaults();
    protected static final int DEFAULT_YAML_GENERATOR_FEATURE_FLAGS = YAMLGenerator.Feature.collectDefaults();

    public YAMLFactory() {
        this((ObjectCodec) null);
    }

    public static YAMLFactoryBuilder builder() {
        return new YAMLFactoryBuilder();
    }

    public Reader _createReader(InputStream inputStream, JsonEncoding jsonEncoding, IOContext iOContext) throws IOException {
        if (jsonEncoding == null) {
            jsonEncoding = JsonEncoding.UTF8;
        }
        if (jsonEncoding == JsonEncoding.UTF8) {
            return new UTF8Reader(inputStream, iOContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE));
        }
        return new InputStreamReader(inputStream, jsonEncoding.getJavaName());
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public Writer _createWriter(OutputStream outputStream, JsonEncoding jsonEncoding, IOContext iOContext) throws IOException {
        return jsonEncoding == JsonEncoding.UTF8 ? new UTF8Writer(outputStream) : new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public boolean canUseCharArrays() {
        return false;
    }

    public final YAMLFactory configure(YAMLGenerator.Feature feature, boolean z10) {
        if (z10) {
            enable(feature);
            return this;
        }
        disable(feature);
        return this;
    }

    public YAMLFactory disable(YAMLGenerator.Feature feature) {
        this._yamlGeneratorFeatures = (~feature.getMask()) & this._yamlGeneratorFeatures;
        return this;
    }

    public YAMLFactory enable(YAMLGenerator.Feature feature) {
        this._yamlGeneratorFeatures = feature.getMask() | this._yamlGeneratorFeatures;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public int getFormatGeneratorFeatures() {
        return this._yamlGeneratorFeatures;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public String getFormatName() {
        return FORMAT_NAME_YAML;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public int getFormatParserFeatures() {
        return this._yamlParserFeatures;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public Class<YAMLParser.Feature> getFormatReadFeatureType() {
        return YAMLParser.Feature.class;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public Class<YAMLGenerator.Feature> getFormatWriteFeatureType() {
        return YAMLGenerator.Feature.class;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public MatchStrength hasFormat(InputAccessor inputAccessor) throws IOException {
        if (!inputAccessor.hasMoreBytes()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte bNextByte = inputAccessor.nextByte();
        if (bNextByte == -17) {
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (inputAccessor.nextByte() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!inputAccessor.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            bNextByte = inputAccessor.nextByte();
        }
        return (bNextByte == 45 && inputAccessor.hasMoreBytes() && inputAccessor.nextByte() == 45 && inputAccessor.hasMoreBytes() && inputAccessor.nextByte() == 45) ? MatchStrength.FULL_MATCH : MatchStrength.INCONCLUSIVE;
    }

    public final boolean isEnabled(YAMLGenerator.Feature feature) {
        return (this._yamlGeneratorFeatures & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public Object readResolve() {
        return new YAMLFactory(this, this._objectCodec);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    public YAMLFactory(ObjectCodec objectCodec) {
        super(objectCodec);
        int i10 = DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
        int i11 = DEFAULT_YAML_PARSER_FEATURE_FLAGS;
        this._yamlGeneratorFeatures = i10;
        this._yamlParserFeatures = i11;
        this._version = null;
        this._quotingChecker = StringQuotingChecker.Default.instance();
        this._loaderOptions = null;
        this._dumperOptions = null;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLGenerator _createGenerator(Writer writer, IOContext iOContext) throws IOException {
        int i10 = this._yamlGeneratorFeatures;
        return this._dumperOptions == null ? new YAMLGenerator(iOContext, this._generatorFeatures, i10, this._quotingChecker, this._objectCodec, writer, this._version) : new YAMLGenerator(iOContext, this._generatorFeatures, i10, this._quotingChecker, this._objectCodec, writer, this._dumperOptions);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLGenerator _createUTF8Generator(OutputStream outputStream, IOContext iOContext) throws IOException {
        throw new IllegalStateException();
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLFactory copy() {
        _checkInvalidCopy(YAMLFactory.class);
        return new YAMLFactory(this, null);
    }

    public YAMLFactory disable(YAMLParser.Feature feature) {
        this._yamlParserFeatures = (~feature.getMask()) & this._yamlParserFeatures;
        return this;
    }

    public YAMLFactory enable(YAMLParser.Feature feature) {
        this._yamlParserFeatures = feature.getMask() | this._yamlParserFeatures;
        return this;
    }

    public final boolean isEnabled(YAMLParser.Feature feature) {
        return (this._yamlParserFeatures & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLFactoryBuilder rebuild() {
        return new YAMLFactoryBuilder(this);
    }

    public final YAMLFactory configure(YAMLParser.Feature feature, boolean z10) {
        if (z10) {
            enable(feature);
            return this;
        }
        disable(feature);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        IOContext iOContext_createContext = _createContext(_createContentReference(outputStream), false);
        iOContext_createContext.setEncoding(jsonEncoding);
        return _createGenerator(_createWriter(_decorate(outputStream, iOContext_createContext), jsonEncoding, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(InputStream inputStream, IOContext iOContext) throws IOException {
        return new YAMLParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, _createReader(inputStream, null, iOContext));
    }

    public Reader _createReader(byte[] bArr, int i10, int i11, JsonEncoding jsonEncoding, IOContext iOContext) throws IOException {
        if (jsonEncoding == null) {
            jsonEncoding = JsonEncoding.UTF8;
        }
        if (jsonEncoding != null && jsonEncoding != JsonEncoding.UTF8) {
            return new InputStreamReader(new ByteArrayInputStream(bArr, i10, i11), jsonEncoding.getJavaName());
        }
        return new UTF8Reader(bArr, i10, i11, true);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(Reader reader, IOContext iOContext) throws IOException {
        return new YAMLParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, reader);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLGenerator createGenerator(OutputStream outputStream) throws IOException {
        IOContext iOContext_createContext = _createContext(_createContentReference(outputStream), false);
        return _createGenerator(_createWriter(_decorate(outputStream, iOContext_createContext), JsonEncoding.UTF8, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(char[] cArr, int i10, int i11, IOContext iOContext, boolean z10) throws IOException {
        return new YAMLParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, new CharArrayReader(cArr, i10, i11));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(byte[] bArr, int i10, int i11, IOContext iOContext) throws IOException {
        return new YAMLParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, _createReader(bArr, i10, i11, null, iOContext));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLGenerator createGenerator(Writer writer) throws IOException {
        IOContext iOContext_createContext = _createContext(_createContentReference(writer), false);
        return _createGenerator(_decorate(writer, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(String str) throws IOException {
        return createParser((Reader) new StringReader(str));
    }

    public YAMLFactory(YAMLFactory yAMLFactory, ObjectCodec objectCodec) {
        super(yAMLFactory, objectCodec);
        this._yamlGeneratorFeatures = DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
        this._yamlParserFeatures = DEFAULT_YAML_PARSER_FEATURE_FLAGS;
        this._yamlGeneratorFeatures = yAMLFactory._yamlGeneratorFeatures;
        this._yamlParserFeatures = yAMLFactory._yamlParserFeatures;
        this._version = yAMLFactory._version;
        this._quotingChecker = yAMLFactory._quotingChecker;
        this._loaderOptions = yAMLFactory._loaderOptions;
        this._dumperOptions = yAMLFactory._dumperOptions;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOContext iOContext_createContext = _createContext(_createContentReference(file), true);
        iOContext_createContext.setEncoding(jsonEncoding);
        return _createGenerator(_createWriter(_decorate(fileOutputStream, iOContext_createContext), jsonEncoding, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(File file) throws IOException {
        IOContext iOContext_createContext = _createContext(_createContentReference(file), true);
        return _createParser(_decorate(new FileInputStream(file), iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(URL url) throws IOException {
        IOContext iOContext_createContext = _createContext(_createContentReference(url), true);
        return _createParser(_decorate(_optimizedStreamFromURL(url), iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(InputStream inputStream) throws IOException {
        IOContext iOContext_createContext = _createContext(_createContentReference(inputStream), false);
        return _createParser(_decorate(inputStream, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(Reader reader) throws IOException {
        IOContext iOContext_createContext = _createContext(_createContentReference(reader), false);
        return _createParser(_decorate(reader, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(char[] cArr) throws IOException {
        return createParser(cArr, 0, cArr.length);
    }

    public YAMLFactory(YAMLFactoryBuilder yAMLFactoryBuilder) {
        super((TSFBuilder<?, ?>) yAMLFactoryBuilder, false);
        this._yamlGeneratorFeatures = DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
        this._yamlParserFeatures = DEFAULT_YAML_PARSER_FEATURE_FLAGS;
        this._yamlGeneratorFeatures = yAMLFactoryBuilder.formatGeneratorFeaturesMask();
        this._yamlParserFeatures = yAMLFactoryBuilder.formatParserFeaturesMask();
        this._version = yAMLFactoryBuilder.yamlVersionToWrite();
        this._quotingChecker = yAMLFactoryBuilder.stringQuotingChecker();
        this._loaderOptions = yAMLFactoryBuilder.loaderOptions();
        this._dumperOptions = yAMLFactoryBuilder.dumperOptions();
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(char[] cArr, int i10, int i11) throws IOException {
        return createParser((Reader) new CharArrayReader(cArr, i10, i11));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(byte[] bArr) throws IOException {
        InputStream inputStreamDecorate;
        IOContext iOContext_createContext = _createContext(_createContentReference(bArr), true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (inputStreamDecorate = inputDecorator.decorate(iOContext_createContext, bArr, 0, bArr.length)) != null) {
            return _createParser(inputStreamDecorate, iOContext_createContext);
        }
        return _createParser(bArr, 0, bArr.length, iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(byte[] bArr, int i10, int i11) throws IOException {
        InputStream inputStreamDecorate;
        IOContext iOContext_createContext = _createContext(_createContentReference(bArr, i10, i11), true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (inputStreamDecorate = inputDecorator.decorate(iOContext_createContext, bArr, i10, i11)) != null) {
            return _createParser(inputStreamDecorate, iOContext_createContext);
        }
        return _createParser(bArr, i10, i11, iOContext_createContext);
    }
}
