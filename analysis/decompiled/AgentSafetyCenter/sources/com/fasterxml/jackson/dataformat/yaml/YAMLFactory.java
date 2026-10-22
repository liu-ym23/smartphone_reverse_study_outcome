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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.net.URL;
import vd.c;
import vd.d;
import vd.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class YAMLFactory extends JsonFactory {
    public static final String FORMAT_NAME_YAML = "YAML";
    private static final byte UTF8_BOM_1 = -17;
    private static final byte UTF8_BOM_2 = -69;
    private static final byte UTF8_BOM_3 = -65;
    private static final long serialVersionUID = 1;
    protected final d _dumperOptions;
    protected final e _loaderOptions;
    protected final StringQuotingChecker _quotingChecker;
    protected final c _version;
    protected int _yamlGeneratorFeatures;
    protected int _yamlParserFeatures;
    protected static final int DEFAULT_YAML_PARSER_FEATURE_FLAGS = YAMLParser.Feature.collectDefaults();
    protected static final int DEFAULT_YAML_GENERATOR_FEATURE_FLAGS = YAMLGenerator.Feature.collectDefaults();

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

    public static YAMLFactoryBuilder builder() {
        return new YAMLFactoryBuilder();
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLGenerator _createGenerator(Writer writer, IOContext iOContext) {
        int i = this._yamlGeneratorFeatures;
        return this._dumperOptions == null ? new YAMLGenerator(iOContext, this._generatorFeatures, i, this._quotingChecker, this._objectCodec, writer, this._version) : new YAMLGenerator(iOContext, this._generatorFeatures, i, this._quotingChecker, this._objectCodec, writer, this._dumperOptions);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(byte[] bArr, int i, int i3, IOContext iOContext) {
        return new YAMLParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, _createReader(bArr, i, i3, null, iOContext));
    }

    public Reader _createReader(InputStream inputStream, JsonEncoding jsonEncoding, IOContext iOContext) {
        if (jsonEncoding == null) {
            jsonEncoding = JsonEncoding.UTF8;
        }
        if (jsonEncoding == JsonEncoding.UTF8) {
            return new UTF8Reader(inputStream, iOContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE));
        }
        return new InputStreamReader(inputStream, jsonEncoding.getJavaName());
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLGenerator _createUTF8Generator(OutputStream outputStream, IOContext iOContext) {
        throw new IllegalStateException();
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public Writer _createWriter(OutputStream outputStream, JsonEncoding jsonEncoding, IOContext iOContext) {
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

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLFactory copy() {
        _checkInvalidCopy(YAMLFactory.class);
        return new YAMLFactory(this, null);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOContext iOContext_createContext = _createContext(_createContentReference(file), true);
        iOContext_createContext.setEncoding(jsonEncoding);
        return _createGenerator(_createWriter(_decorate(fileOutputStream, iOContext_createContext), jsonEncoding, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(byte[] bArr) {
        InputStream inputStreamDecorate;
        IOContext iOContext_createContext = _createContext(_createContentReference(bArr), true);
        InputDecorator inputDecorator = this._inputDecorator;
        return (inputDecorator == null || (inputStreamDecorate = inputDecorator.decorate(iOContext_createContext, bArr, 0, bArr.length)) == null) ? _createParser(bArr, 0, bArr.length, iOContext_createContext) : _createParser(inputStreamDecorate, iOContext_createContext);
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
    public MatchStrength hasFormat(InputAccessor inputAccessor) {
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

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLFactoryBuilder rebuild() {
        return new YAMLFactoryBuilder(this);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    public final YAMLFactory configure(YAMLParser.Feature feature, boolean z10) {
        if (z10) {
            enable(feature);
            return this;
        }
        disable(feature);
        return this;
    }

    public YAMLFactory enable(YAMLParser.Feature feature) {
        this._yamlParserFeatures = feature.getMask() | this._yamlParserFeatures;
        return this;
    }

    public YAMLFactory disable(YAMLParser.Feature feature) {
        this._yamlParserFeatures = (~feature.getMask()) & this._yamlParserFeatures;
        return this;
    }

    public final boolean isEnabled(YAMLParser.Feature feature) {
        return (this._yamlParserFeatures & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) {
        IOContext iOContext_createContext = _createContext(_createContentReference(outputStream), false);
        iOContext_createContext.setEncoding(jsonEncoding);
        return _createGenerator(_createWriter(_decorate(outputStream, iOContext_createContext), jsonEncoding, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(InputStream inputStream, IOContext iOContext) {
        return new YAMLParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, _createReader(inputStream, null, iOContext));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLGenerator createGenerator(OutputStream outputStream) {
        IOContext iOContext_createContext = _createContext(_createContentReference(outputStream), false);
        return _createGenerator(_createWriter(_decorate(outputStream, iOContext_createContext), JsonEncoding.UTF8, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(Reader reader, IOContext iOContext) {
        return new YAMLParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, reader);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLGenerator createGenerator(Writer writer) {
        IOContext iOContext_createContext = _createContext(_createContentReference(writer), false);
        return _createGenerator(_decorate(writer, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(char[] cArr, int i, int i3, IOContext iOContext, boolean z10) {
        return new YAMLParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, new CharArrayReader(cArr, i, i3));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(String str) {
        return createParser((Reader) new StringReader(str));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(File file) {
        IOContext iOContext_createContext = _createContext(_createContentReference(file), true);
        return _createParser(_decorate(new FileInputStream(file), iOContext_createContext), iOContext_createContext);
    }

    public Reader _createReader(byte[] bArr, int i, int i3, JsonEncoding jsonEncoding, IOContext iOContext) {
        if (jsonEncoding == null) {
            jsonEncoding = JsonEncoding.UTF8;
        }
        if (jsonEncoding != null && jsonEncoding != JsonEncoding.UTF8) {
            return new InputStreamReader(new ByteArrayInputStream(bArr, i, i3), jsonEncoding.getJavaName());
        }
        return new UTF8Reader(bArr, i, i3, true);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(URL url) {
        IOContext iOContext_createContext = _createContext(_createContentReference(url), true);
        return _createParser(_decorate(_optimizedStreamFromURL(url), iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(InputStream inputStream) {
        IOContext iOContext_createContext = _createContext(_createContentReference(inputStream), false);
        return _createParser(_decorate(inputStream, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(Reader reader) {
        IOContext iOContext_createContext = _createContext(_createContentReference(reader), false);
        return _createParser(_decorate(reader, iOContext_createContext), iOContext_createContext);
    }

    public YAMLFactory(ObjectCodec objectCodec) {
        super(objectCodec);
        int i = DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
        int i3 = DEFAULT_YAML_PARSER_FEATURE_FLAGS;
        this._yamlGeneratorFeatures = i;
        this._yamlParserFeatures = i3;
        this._version = null;
        this._quotingChecker = StringQuotingChecker.Default.instance();
        this._loaderOptions = null;
        this._dumperOptions = null;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(char[] cArr) {
        return createParser(cArr, 0, cArr.length);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(char[] cArr, int i, int i3) {
        return createParser((Reader) new CharArrayReader(cArr, i, i3));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public YAMLParser createParser(byte[] bArr, int i, int i3) {
        InputStream inputStreamDecorate;
        IOContext iOContext_createContext = _createContext(_createContentReference(bArr, i, i3), true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (inputStreamDecorate = inputDecorator.decorate(iOContext_createContext, bArr, i, i3)) != null) {
            return _createParser(inputStreamDecorate, iOContext_createContext);
        }
        return _createParser(bArr, i, i3, iOContext_createContext);
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

    public YAMLFactory() {
        this((ObjectCodec) null);
    }
}
