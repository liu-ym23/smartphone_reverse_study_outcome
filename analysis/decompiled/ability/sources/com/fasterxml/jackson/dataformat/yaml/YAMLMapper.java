package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

/* loaded from: classes3.dex */
public class YAMLMapper extends ObjectMapper {
    private static final long serialVersionUID = 1;

    public YAMLMapper() {
        this(new YAMLFactory());
    }

    public static Builder builder() {
        return new Builder(new YAMLMapper());
    }

    public YAMLMapper configure(YAMLGenerator.Feature feature, boolean z10) {
        return z10 ? enable(feature) : disable(feature);
    }

    public YAMLMapper disable(YAMLGenerator.Feature feature) {
        ((YAMLFactory) this._jsonFactory).disable(feature);
        return this;
    }

    public YAMLMapper enable(YAMLGenerator.Feature feature) {
        ((YAMLFactory) this._jsonFactory).enable(feature);
        return this;
    }

    public static class Builder extends MapperBuilder<YAMLMapper, Builder> {
        public Builder(YAMLMapper yAMLMapper) {
            super(yAMLMapper);
        }

        public Builder configure(YAMLParser.Feature feature, boolean z10) {
            if (z10) {
                ((YAMLMapper) this._mapper).enable(feature);
                return this;
            }
            ((YAMLMapper) this._mapper).disable(feature);
            return this;
        }

        public Builder disable(YAMLParser.Feature... featureArr) {
            for (YAMLParser.Feature feature : featureArr) {
                ((YAMLMapper) this._mapper).disable(feature);
            }
            return this;
        }

        public Builder enable(YAMLParser.Feature... featureArr) {
            for (YAMLParser.Feature feature : featureArr) {
                ((YAMLMapper) this._mapper).enable(feature);
            }
            return this;
        }

        public Builder configure(YAMLGenerator.Feature feature, boolean z10) {
            if (z10) {
                ((YAMLMapper) this._mapper).enable(feature);
                return this;
            }
            ((YAMLMapper) this._mapper).disable(feature);
            return this;
        }

        public Builder disable(YAMLGenerator.Feature... featureArr) {
            for (YAMLGenerator.Feature feature : featureArr) {
                ((YAMLMapper) this._mapper).disable(feature);
            }
            return this;
        }

        public Builder enable(YAMLGenerator.Feature... featureArr) {
            for (YAMLGenerator.Feature feature : featureArr) {
                ((YAMLMapper) this._mapper).enable(feature);
            }
            return this;
        }
    }

    public YAMLMapper(YAMLFactory yAMLFactory) {
        super(yAMLFactory);
    }

    public static Builder builder(YAMLFactory yAMLFactory) {
        return new Builder(new YAMLMapper(yAMLFactory));
    }

    public YAMLMapper configure(YAMLParser.Feature feature, boolean z10) {
        return z10 ? enable(feature) : disable(feature);
    }

    @Override // com.fasterxml.jackson.databind.ObjectMapper
    public YAMLMapper copy() {
        _checkInvalidCopy(YAMLMapper.class);
        return new YAMLMapper(this);
    }

    public YAMLMapper disable(YAMLParser.Feature feature) {
        ((YAMLFactory) this._jsonFactory).disable(feature);
        return this;
    }

    public YAMLMapper enable(YAMLParser.Feature feature) {
        ((YAMLFactory) this._jsonFactory).enable(feature);
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ObjectMapper, com.fasterxml.jackson.core.ObjectCodec
    public final YAMLFactory getFactory() {
        return (YAMLFactory) this._jsonFactory;
    }

    public YAMLMapper(YAMLMapper yAMLMapper) {
        super(yAMLMapper);
    }
}
