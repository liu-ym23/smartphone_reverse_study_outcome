package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import ea.C1428a;
import ea.C1429b;
import org.yaml.snakeyaml.DumperOptions$Version;

/* loaded from: classes3.dex */
public class YAMLFactoryBuilder extends TSFBuilder<YAMLFactory, YAMLFactoryBuilder> {
    protected C1428a _dumperOptions;
    protected int _formatGeneratorFeatures;
    protected int _formatParserFeatures;
    protected C1429b _loaderOptions;
    protected StringQuotingChecker _quotingChecker;
    protected DumperOptions$Version _version;

    public YAMLFactoryBuilder() {
        this._formatGeneratorFeatures = YAMLFactory.DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
    }

    public YAMLFactoryBuilder configure(YAMLParser.Feature feature, boolean z10) {
        return z10 ? enable(feature) : disable(feature);
    }

    public YAMLFactoryBuilder disable(YAMLParser.Feature feature) {
        this._formatParserFeatures = (~feature.getMask()) & this._formatParserFeatures;
        return this;
    }

    public YAMLFactoryBuilder dumperOptions(C1428a c1428a) {
        this._dumperOptions = c1428a;
        return this;
    }

    public YAMLFactoryBuilder enable(YAMLParser.Feature feature) {
        this._formatParserFeatures = feature.getMask() | this._formatParserFeatures;
        return this;
    }

    public int formatGeneratorFeaturesMask() {
        return this._formatGeneratorFeatures;
    }

    public int formatParserFeaturesMask() {
        return this._formatParserFeatures;
    }

    public YAMLFactoryBuilder loaderOptions(C1429b c1429b) {
        this._loaderOptions = c1429b;
        c1429b.getClass();
        return this;
    }

    public YAMLFactoryBuilder stringQuotingChecker(StringQuotingChecker stringQuotingChecker) {
        this._quotingChecker = stringQuotingChecker;
        return this;
    }

    public YAMLFactoryBuilder yamlVersionToWrite(DumperOptions$Version dumperOptions$Version) {
        this._version = dumperOptions$Version;
        return this;
    }

    @Override // com.fasterxml.jackson.core.TSFBuilder
    public YAMLFactory build() {
        return new YAMLFactory(this);
    }

    public YAMLFactoryBuilder configure(YAMLGenerator.Feature feature, boolean z10) {
        return z10 ? enable(feature) : disable(feature);
    }

    public YAMLFactoryBuilder disable(YAMLParser.Feature feature, YAMLParser.Feature... featureArr) {
        this._formatParserFeatures = (~feature.getMask()) & this._formatParserFeatures;
        for (YAMLParser.Feature feature2 : featureArr) {
            this._formatParserFeatures = (~feature2.getMask()) & this._formatParserFeatures;
        }
        return this;
    }

    public C1428a dumperOptions() {
        return this._dumperOptions;
    }

    public YAMLFactoryBuilder enable(YAMLParser.Feature feature, YAMLParser.Feature... featureArr) {
        this._formatParserFeatures = feature.getMask() | this._formatParserFeatures;
        for (YAMLParser.Feature feature2 : featureArr) {
            this._formatParserFeatures = feature2.getMask() | this._formatParserFeatures;
        }
        return this;
    }

    public StringQuotingChecker stringQuotingChecker() {
        StringQuotingChecker stringQuotingChecker = this._quotingChecker;
        return stringQuotingChecker != null ? stringQuotingChecker : StringQuotingChecker.Default.instance();
    }

    public DumperOptions$Version yamlVersionToWrite() {
        return this._version;
    }

    public YAMLFactoryBuilder(YAMLFactory yAMLFactory) {
        super(yAMLFactory);
        this._formatGeneratorFeatures = yAMLFactory._yamlGeneratorFeatures;
        this._formatParserFeatures = yAMLFactory._yamlParserFeatures;
        this._version = yAMLFactory._version;
        this._quotingChecker = yAMLFactory._quotingChecker;
    }

    public C1429b loaderOptions() {
        return this._loaderOptions;
    }

    public YAMLFactoryBuilder disable(YAMLGenerator.Feature feature) {
        this._formatGeneratorFeatures = (~feature.getMask()) & this._formatGeneratorFeatures;
        return this;
    }

    public YAMLFactoryBuilder enable(YAMLGenerator.Feature feature) {
        this._formatGeneratorFeatures = feature.getMask() | this._formatGeneratorFeatures;
        return this;
    }

    public YAMLFactoryBuilder disable(YAMLGenerator.Feature feature, YAMLGenerator.Feature... featureArr) {
        this._formatGeneratorFeatures = (~feature.getMask()) & this._formatGeneratorFeatures;
        for (YAMLGenerator.Feature feature2 : featureArr) {
            this._formatGeneratorFeatures = (~feature2.getMask()) & this._formatGeneratorFeatures;
        }
        return this;
    }

    public YAMLFactoryBuilder enable(YAMLGenerator.Feature feature, YAMLGenerator.Feature... featureArr) {
        this._formatGeneratorFeatures = feature.getMask() | this._formatGeneratorFeatures;
        for (YAMLGenerator.Feature feature2 : featureArr) {
            this._formatGeneratorFeatures = feature2.getMask() | this._formatGeneratorFeatures;
        }
        return this;
    }
}
