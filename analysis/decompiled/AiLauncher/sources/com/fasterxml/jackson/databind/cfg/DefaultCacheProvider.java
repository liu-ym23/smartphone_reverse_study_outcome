package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.databind.util.LookupCache;
import com.fasterxml.jackson.databind.util.TypeKey;

/* loaded from: classes2.dex */
public class DefaultCacheProvider implements CacheProvider {
    private static final DefaultCacheProvider DEFAULT = new DefaultCacheProvider(2000, 4000, 200);
    private static final long serialVersionUID = 1;
    protected final int _maxDeserializerCacheSize;
    protected final int _maxSerializerCacheSize;
    protected final int _maxTypeFactoryCacheSize;

    public static class Builder {
        private int _maxDeserializerCacheSize;
        private int _maxSerializerCacheSize;
        private int _maxTypeFactoryCacheSize;

        public DefaultCacheProvider build() {
            return new DefaultCacheProvider(this._maxDeserializerCacheSize, this._maxSerializerCacheSize, this._maxTypeFactoryCacheSize);
        }

        public Builder maxDeserializerCacheSize(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Cannot set maxDeserializerCacheSize to a negative value");
            }
            this._maxDeserializerCacheSize = i10;
            return this;
        }

        public Builder maxSerializerCacheSize(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Cannot set maxSerializerCacheSize to a negative value");
            }
            this._maxSerializerCacheSize = i10;
            return this;
        }

        public Builder maxTypeFactoryCacheSize(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Cannot set maxTypeFactoryCacheSize to a negative value");
            }
            this._maxTypeFactoryCacheSize = i10;
            return this;
        }
    }

    public DefaultCacheProvider(int i10, int i11, int i12) {
        this._maxDeserializerCacheSize = i10;
        this._maxSerializerCacheSize = i11;
        this._maxTypeFactoryCacheSize = i12;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static CacheProvider defaultInstance() {
        return DEFAULT;
    }

    public <K, V> LookupCache<K, V> _buildCache(int i10) {
        return new LRUMap(Math.min(64, i10 >> 2), i10);
    }

    @Override // com.fasterxml.jackson.databind.cfg.CacheProvider
    public LookupCache<JavaType, JsonDeserializer<Object>> forDeserializerCache(DeserializationConfig deserializationConfig) {
        return _buildCache(this._maxDeserializerCacheSize);
    }

    @Override // com.fasterxml.jackson.databind.cfg.CacheProvider
    public LookupCache<TypeKey, JsonSerializer<Object>> forSerializerCache(SerializationConfig serializationConfig) {
        return _buildCache(this._maxSerializerCacheSize);
    }

    @Override // com.fasterxml.jackson.databind.cfg.CacheProvider
    public LookupCache<Object, JavaType> forTypeFactory() {
        return _buildCache(this._maxTypeFactoryCacheSize);
    }
}
