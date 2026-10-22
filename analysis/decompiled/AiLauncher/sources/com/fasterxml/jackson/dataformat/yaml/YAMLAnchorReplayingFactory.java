package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: classes2.dex */
public class YAMLAnchorReplayingFactory extends YAMLFactory {
    private static final long serialVersionUID = 1;

    public YAMLAnchorReplayingFactory() {
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public Object readResolve() {
        return new YAMLAnchorReplayingFactory(this, this._objectCodec);
    }

    public YAMLAnchorReplayingFactory(ObjectCodec objectCodec) {
        super(objectCodec);
    }

    public YAMLAnchorReplayingFactory(YAMLFactory yAMLFactory, ObjectCodec objectCodec) {
        super(yAMLFactory, objectCodec);
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public YAMLAnchorReplayingFactory copy() {
        _checkInvalidCopy(YAMLAnchorReplayingFactory.class);
        return new YAMLAnchorReplayingFactory(this, null);
    }

    public YAMLAnchorReplayingFactory(YAMLFactoryBuilder yAMLFactoryBuilder) {
        super(yAMLFactoryBuilder);
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(InputStream inputStream, IOContext iOContext) throws IOException {
        return new YAMLAnchorReplayingParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, _createReader(inputStream, null, iOContext));
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(Reader reader, IOContext iOContext) throws IOException {
        return new YAMLAnchorReplayingParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, reader);
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(char[] cArr, int i10, int i11, IOContext iOContext, boolean z10) throws IOException {
        return new YAMLAnchorReplayingParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, new CharArrayReader(cArr, i10, i11));
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(byte[] bArr, int i10, int i11, IOContext iOContext) throws IOException {
        return new YAMLAnchorReplayingParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, _createReader(bArr, i10, i11, null, iOContext));
    }
}
