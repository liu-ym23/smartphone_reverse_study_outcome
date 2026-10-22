package com.fasterxml.jackson.core;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonGeneratorDecorator;
import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import com.fasterxml.jackson.core.util.RecyclerPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class TSFBuilder<F extends JsonFactory, B extends TSFBuilder<F, B>> {
    protected ErrorReportConfiguration _errorReportConfiguration;
    protected int _factoryFeatures;
    protected List<JsonGeneratorDecorator> _generatorDecorators;
    protected InputDecorator _inputDecorator;
    protected OutputDecorator _outputDecorator;
    protected RecyclerPool<BufferRecycler> _recyclerPool;
    protected StreamReadConstraints _streamReadConstraints;
    protected int _streamReadFeatures;
    protected StreamWriteConstraints _streamWriteConstraints;
    protected int _streamWriteFeatures;
    protected static final int DEFAULT_FACTORY_FEATURE_FLAGS = JsonFactory.Feature.collectDefaults();
    protected static final int DEFAULT_PARSER_FEATURE_FLAGS = JsonParser.Feature.collectDefaults();
    protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS = JsonGenerator.Feature.collectDefaults();

    public TSFBuilder() {
        this(DEFAULT_FACTORY_FEATURE_FLAGS, DEFAULT_PARSER_FEATURE_FLAGS, DEFAULT_GENERATOR_FEATURE_FLAGS);
    }

    public static <T> List<T> _copy(List<T> list) {
        return list == null ? list : new ArrayList(list);
    }

    private B _failNonJSON(Object obj) {
        throw new IllegalArgumentException("Feature " + obj.getClass().getName() + Const.STR_MART_WELL + obj.toString() + " not supported for non-JSON backend");
    }

    public void _legacyDisable(JsonParser.Feature feature) {
        if (feature != null) {
            this._streamReadFeatures = (~feature.getMask()) & this._streamReadFeatures;
        }
    }

    public void _legacyEnable(JsonParser.Feature feature) {
        if (feature != null) {
            this._streamReadFeatures = feature.getMask() | this._streamReadFeatures;
        }
    }

    public final B _this() {
        return this;
    }

    public B addDecorator(JsonGeneratorDecorator jsonGeneratorDecorator) {
        if (this._generatorDecorators == null) {
            this._generatorDecorators = new ArrayList();
        }
        this._generatorDecorators.add(jsonGeneratorDecorator);
        return (B) _this();
    }

    public abstract F build();

    public B configure(JsonFactory.Feature feature, boolean z10) {
        return z10 ? (B) enable(feature) : (B) disable(feature);
    }

    public B disable(JsonFactory.Feature feature) {
        this._factoryFeatures = (~feature.getMask()) & this._factoryFeatures;
        return (B) _this();
    }

    public B enable(JsonFactory.Feature feature) {
        this._factoryFeatures = feature.getMask() | this._factoryFeatures;
        return (B) _this();
    }

    public B errorReportConfiguration(ErrorReportConfiguration errorReportConfiguration) {
        Objects.requireNonNull(errorReportConfiguration);
        this._errorReportConfiguration = errorReportConfiguration;
        return (B) _this();
    }

    public int factoryFeaturesMask() {
        return this._factoryFeatures;
    }

    public InputDecorator inputDecorator() {
        return this._inputDecorator;
    }

    public OutputDecorator outputDecorator() {
        return this._outputDecorator;
    }

    public RecyclerPool<BufferRecycler> recyclerPool() {
        return this._recyclerPool;
    }

    public B streamReadConstraints(StreamReadConstraints streamReadConstraints) {
        Objects.requireNonNull(streamReadConstraints);
        this._streamReadConstraints = streamReadConstraints;
        return (B) _this();
    }

    public int streamReadFeatures() {
        return this._streamReadFeatures;
    }

    public B streamWriteConstraints(StreamWriteConstraints streamWriteConstraints) {
        Objects.requireNonNull(streamWriteConstraints);
        this._streamWriteConstraints = streamWriteConstraints;
        return (B) _this();
    }

    public int streamWriteFeatures() {
        return this._streamWriteFeatures;
    }

    public TSFBuilder(JsonFactory jsonFactory) {
        this(jsonFactory._factoryFeatures, jsonFactory._parserFeatures, jsonFactory._generatorFeatures);
        this._inputDecorator = jsonFactory._inputDecorator;
        this._outputDecorator = jsonFactory._outputDecorator;
        this._streamReadConstraints = jsonFactory._streamReadConstraints;
        this._streamWriteConstraints = jsonFactory._streamWriteConstraints;
        this._errorReportConfiguration = jsonFactory._errorReportConfiguration;
        this._generatorDecorators = _copy(jsonFactory._generatorDecorators);
    }

    public void _legacyDisable(JsonGenerator.Feature feature) {
        if (feature != null) {
            this._streamWriteFeatures = (~feature.getMask()) & this._streamWriteFeatures;
        }
    }

    public void _legacyEnable(JsonGenerator.Feature feature) {
        if (feature != null) {
            this._streamWriteFeatures = feature.getMask() | this._streamWriteFeatures;
        }
    }

    public B configure(StreamReadFeature streamReadFeature, boolean z10) {
        return z10 ? (B) enable(streamReadFeature) : (B) disable(streamReadFeature);
    }

    public B inputDecorator(InputDecorator inputDecorator) {
        this._inputDecorator = inputDecorator;
        return (B) _this();
    }

    public B outputDecorator(OutputDecorator outputDecorator) {
        this._outputDecorator = outputDecorator;
        return (B) _this();
    }

    public B recyclerPool(RecyclerPool<BufferRecycler> recyclerPool) {
        Objects.requireNonNull(recyclerPool);
        this._recyclerPool = recyclerPool;
        return (B) _this();
    }

    public B configure(StreamWriteFeature streamWriteFeature, boolean z10) {
        return z10 ? (B) enable(streamWriteFeature) : (B) disable(streamWriteFeature);
    }

    public B disable(StreamReadFeature streamReadFeature) {
        this._streamReadFeatures = (~streamReadFeature.mappedFeature().getMask()) & this._streamReadFeatures;
        return (B) _this();
    }

    public B enable(StreamReadFeature streamReadFeature) {
        this._streamReadFeatures = streamReadFeature.mappedFeature().getMask() | this._streamReadFeatures;
        return (B) _this();
    }

    public B configure(JsonReadFeature jsonReadFeature, boolean z10) {
        return (B) _failNonJSON(jsonReadFeature);
    }

    public B configure(JsonWriteFeature jsonWriteFeature, boolean z10) {
        return (B) _failNonJSON(jsonWriteFeature);
    }

    public B disable(StreamReadFeature streamReadFeature, StreamReadFeature... streamReadFeatureArr) {
        this._streamReadFeatures = (~streamReadFeature.mappedFeature().getMask()) & this._streamReadFeatures;
        for (StreamReadFeature streamReadFeature2 : streamReadFeatureArr) {
            this._streamReadFeatures = (~streamReadFeature2.mappedFeature().getMask()) & this._streamReadFeatures;
        }
        return (B) _this();
    }

    public B enable(StreamReadFeature streamReadFeature, StreamReadFeature... streamReadFeatureArr) {
        this._streamReadFeatures = streamReadFeature.mappedFeature().getMask() | this._streamReadFeatures;
        for (StreamReadFeature streamReadFeature2 : streamReadFeatureArr) {
            this._streamReadFeatures = streamReadFeature2.mappedFeature().getMask() | this._streamReadFeatures;
        }
        return (B) _this();
    }

    public TSFBuilder(int i10, int i11, int i12) {
        this._recyclerPool = JsonRecyclerPools.defaultPool();
        this._factoryFeatures = i10;
        this._streamReadFeatures = i11;
        this._streamWriteFeatures = i12;
        this._inputDecorator = null;
        this._outputDecorator = null;
        this._streamReadConstraints = StreamReadConstraints.defaults();
        this._streamWriteConstraints = StreamWriteConstraints.defaults();
        this._errorReportConfiguration = ErrorReportConfiguration.defaults();
        this._generatorDecorators = null;
    }

    public B disable(StreamWriteFeature streamWriteFeature) {
        this._streamWriteFeatures = (~streamWriteFeature.mappedFeature().getMask()) & this._streamWriteFeatures;
        return (B) _this();
    }

    public B enable(StreamWriteFeature streamWriteFeature) {
        this._streamWriteFeatures = streamWriteFeature.mappedFeature().getMask() | this._streamWriteFeatures;
        return (B) _this();
    }

    public B disable(StreamWriteFeature streamWriteFeature, StreamWriteFeature... streamWriteFeatureArr) {
        this._streamWriteFeatures = (~streamWriteFeature.mappedFeature().getMask()) & this._streamWriteFeatures;
        for (StreamWriteFeature streamWriteFeature2 : streamWriteFeatureArr) {
            this._streamWriteFeatures = (~streamWriteFeature2.mappedFeature().getMask()) & this._streamWriteFeatures;
        }
        return (B) _this();
    }

    public B enable(StreamWriteFeature streamWriteFeature, StreamWriteFeature... streamWriteFeatureArr) {
        this._streamWriteFeatures = streamWriteFeature.mappedFeature().getMask() | this._streamWriteFeatures;
        for (StreamWriteFeature streamWriteFeature2 : streamWriteFeatureArr) {
            this._streamWriteFeatures = streamWriteFeature2.mappedFeature().getMask() | this._streamWriteFeatures;
        }
        return (B) _this();
    }

    public B disable(JsonReadFeature jsonReadFeature) {
        return (B) _failNonJSON(jsonReadFeature);
    }

    public B enable(JsonReadFeature jsonReadFeature) {
        return (B) _failNonJSON(jsonReadFeature);
    }

    public B disable(JsonReadFeature jsonReadFeature, JsonReadFeature... jsonReadFeatureArr) {
        return (B) _failNonJSON(jsonReadFeature);
    }

    public B enable(JsonReadFeature jsonReadFeature, JsonReadFeature... jsonReadFeatureArr) {
        return (B) _failNonJSON(jsonReadFeature);
    }

    public B disable(JsonWriteFeature jsonWriteFeature) {
        return (B) _failNonJSON(jsonWriteFeature);
    }

    public B enable(JsonWriteFeature jsonWriteFeature) {
        return (B) _failNonJSON(jsonWriteFeature);
    }

    public B disable(JsonWriteFeature jsonWriteFeature, JsonWriteFeature... jsonWriteFeatureArr) {
        return (B) _failNonJSON(jsonWriteFeature);
    }

    public B enable(JsonWriteFeature jsonWriteFeature, JsonWriteFeature... jsonWriteFeatureArr) {
        return (B) _failNonJSON(jsonWriteFeature);
    }
}
