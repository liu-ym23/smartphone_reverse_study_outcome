package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import vd.c;
import vd.d;
import vd.e;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class YAMLFactoryBuilder extends TSFBuilder<YAMLFactory, YAMLFactoryBuilder> {
    protected d _dumperOptions;
    protected int _formatGeneratorFeatures;
    protected int _formatParserFeatures;
    protected e _loaderOptions;
    protected StringQuotingChecker _quotingChecker;
    protected c _version;

    public YAMLFactoryBuilder(YAMLFactory yAMLFactory) {
        super(yAMLFactory);
        this._formatGeneratorFeatures = yAMLFactory._yamlGeneratorFeatures;
        this._formatParserFeatures = yAMLFactory._yamlParserFeatures;
        this._version = yAMLFactory._version;
        this._quotingChecker = yAMLFactory._quotingChecker;
    }

    @Override // com.fasterxml.jackson.core.TSFBuilder
    public YAMLFactory build() {
        return new YAMLFactory(this);
    }

    public YAMLFactoryBuilder configure(YAMLParser.Feature feature, boolean z10) {
        return z10 ? enable(feature) : disable(feature);
    }

    public YAMLFactoryBuilder disable(YAMLParser.Feature feature, YAMLParser.Feature... featureArr) {
        this._formatParserFeatures = (~feature.getMask()) & this._formatParserFeatures;
        for (YAMLParser.Feature feature2 : featureArr) {
            this._formatParserFeatures = (~feature2.getMask()) & this._formatParserFeatures;
        }
        return this;
    }

    public YAMLFactoryBuilder dumperOptions(d dVar) {
        this._dumperOptions = dVar;
        return this;
    }

    public YAMLFactoryBuilder enable(YAMLParser.Feature feature, YAMLParser.Feature... featureArr) {
        this._formatParserFeatures = feature.getMask() | this._formatParserFeatures;
        for (YAMLParser.Feature feature2 : featureArr) {
            this._formatParserFeatures = feature2.getMask() | this._formatParserFeatures;
        }
        return this;
    }

    public int formatGeneratorFeaturesMask() {
        return this._formatGeneratorFeatures;
    }

    public int formatParserFeaturesMask() {
        return this._formatParserFeatures;
    }

    public YAMLFactoryBuilder loaderOptions(e eVar) {
        this._loaderOptions = eVar;
        eVar.getClass();
        return this;
    }

    public StringQuotingChecker stringQuotingChecker() {
        StringQuotingChecker stringQuotingChecker = this._quotingChecker;
        return stringQuotingChecker != null ? stringQuotingChecker : StringQuotingChecker.Default.instance();
    }

    public YAMLFactoryBuilder yamlVersionToWrite(c cVar) {
        this._version = cVar;
        return this;
    }

    public d dumperOptions() {
        return this._dumperOptions;
    }

    public c yamlVersionToWrite() {
        return this._version;
    }

    public e loaderOptions() {
        return this._loaderOptions;
    }

    public YAMLFactoryBuilder stringQuotingChecker(StringQuotingChecker stringQuotingChecker) {
        this._quotingChecker = stringQuotingChecker;
        return this;
    }

    public YAMLFactoryBuilder configure(YAMLGenerator.Feature feature, boolean z10) {
        return z10 ? enable(feature) : disable(feature);
    }

    public YAMLFactoryBuilder() {
        this._formatGeneratorFeatures = YAMLFactory.DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
    }

    public YAMLFactoryBuilder enable(YAMLParser.Feature feature) {
        this._formatParserFeatures = feature.getMask() | this._formatParserFeatures;
        return this;
    }

    public YAMLFactoryBuilder enable(YAMLGenerator.Feature feature) {
        this._formatGeneratorFeatures = feature.getMask() | this._formatGeneratorFeatures;
        return this;
    }

    public YAMLFactoryBuilder disable(YAMLParser.Feature feature) {
        this._formatParserFeatures = (~feature.getMask()) & this._formatParserFeatures;
        return this;
    }

    public YAMLFactoryBuilder enable(YAMLGenerator.Feature feature, YAMLGenerator.Feature... featureArr) {
        this._formatGeneratorFeatures = feature.getMask() | this._formatGeneratorFeatures;
        for (YAMLGenerator.Feature feature2 : featureArr) {
            this._formatGeneratorFeatures = feature2.getMask() | this._formatGeneratorFeatures;
        }
        return this;
    }

    public YAMLFactoryBuilder disable(YAMLGenerator.Feature feature) {
        this._formatGeneratorFeatures = (~feature.getMask()) & this._formatGeneratorFeatures;
        return this;
    }

    public YAMLFactoryBuilder disable(YAMLGenerator.Feature feature, YAMLGenerator.Feature... featureArr) {
        this._formatGeneratorFeatures = (~feature.getMask()) & this._formatGeneratorFeatures;
        for (YAMLGenerator.Feature feature2 : featureArr) {
            this._formatGeneratorFeatures = (~feature2.getMask()) & this._formatGeneratorFeatures;
        }
        return this;
    }
}
