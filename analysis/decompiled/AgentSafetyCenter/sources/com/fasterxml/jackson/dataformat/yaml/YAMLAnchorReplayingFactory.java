package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import java.io.CharArrayReader;
import java.io.InputStream;
import java.io.Reader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class YAMLAnchorReplayingFactory extends YAMLFactory {
    private static final long serialVersionUID = 1;

    public YAMLAnchorReplayingFactory() {
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(byte[] bArr, int i, int i3, IOContext iOContext) {
        return new YAMLAnchorReplayingParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, _createReader(bArr, i, i3, null, iOContext));
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public YAMLAnchorReplayingFactory copy() {
        _checkInvalidCopy(YAMLAnchorReplayingFactory.class);
        return new YAMLAnchorReplayingFactory(this, null);
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

    public YAMLAnchorReplayingFactory(YAMLFactoryBuilder yAMLFactoryBuilder) {
        super(yAMLFactoryBuilder);
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(InputStream inputStream, IOContext iOContext) {
        return new YAMLAnchorReplayingParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, _createReader(inputStream, null, iOContext));
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(Reader reader, IOContext iOContext) {
        return new YAMLAnchorReplayingParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, reader);
    }

    @Override // com.fasterxml.jackson.dataformat.yaml.YAMLFactory, com.fasterxml.jackson.core.JsonFactory
    public YAMLParser _createParser(char[] cArr, int i, int i3, IOContext iOContext, boolean z10) {
        return new YAMLAnchorReplayingParser(iOContext, this._parserFeatures, this._yamlParserFeatures, this._loaderOptions, this._objectCodec, new CharArrayReader(cArr, i, i3));
    }
}
