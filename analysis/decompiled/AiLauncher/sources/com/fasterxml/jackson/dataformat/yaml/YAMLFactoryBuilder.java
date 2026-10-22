package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;

/* loaded from: classes2.dex */
public class YAMLFactoryBuilder extends TSFBuilder<YAMLFactory, YAMLFactoryBuilder> {
    protected DumperOptions _dumperOptions;
    protected int _formatGeneratorFeatures;
    protected int _formatParserFeatures;
    protected LoaderOptions _loaderOptions;
    protected StringQuotingChecker _quotingChecker;
    protected DumperOptions.Version _version;

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

    public YAMLFactoryBuilder dumperOptions(DumperOptions dumperOptions) {
        this._dumperOptions = dumperOptions;
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

    public YAMLFactoryBuilder loaderOptions(LoaderOptions loaderOptions) {
        this._loaderOptions = loaderOptions;
        if (!loaderOptions.isAllowDuplicateKeys()) {
            enable(StreamReadFeature.STRICT_DUPLICATE_DETECTION);
        }
        return this;
    }

    public YAMLFactoryBuilder stringQuotingChecker(StringQuotingChecker stringQuotingChecker) {
        this._quotingChecker = stringQuotingChecker;
        return this;
    }

    public YAMLFactoryBuilder yamlVersionToWrite(DumperOptions.Version version) {
        this._version = version;
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

    public DumperOptions dumperOptions() {
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

    public DumperOptions.Version yamlVersionToWrite() {
        return this._version;
    }

    public YAMLFactoryBuilder(YAMLFactory yAMLFactory) {
        super(yAMLFactory);
        this._formatGeneratorFeatures = yAMLFactory._yamlGeneratorFeatures;
        this._formatParserFeatures = yAMLFactory._yamlParserFeatures;
        this._version = yAMLFactory._version;
        this._quotingChecker = yAMLFactory._quotingChecker;
    }

    public LoaderOptions loaderOptions() {
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
