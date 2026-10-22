package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.databind.util.LookupCache;
import com.fasterxml.jackson.databind.util.TypeKey;
import g5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DefaultCacheProvider implements CacheProvider {
    private static final DefaultCacheProvider DEFAULT = new DefaultCacheProvider(DeserializerCache.DEFAULT_MAX_CACHE_SIZE, 4000, 200);
    private static final long serialVersionUID = 1;
    protected final int _maxDeserializerCacheSize;
    protected final int _maxSerializerCacheSize;
    protected final int _maxTypeFactoryCacheSize;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Builder {
        private int _maxDeserializerCacheSize;
        private int _maxSerializerCacheSize;
        private int _maxTypeFactoryCacheSize;

        public DefaultCacheProvider build() {
            return new DefaultCacheProvider(this._maxDeserializerCacheSize, this._maxSerializerCacheSize, this._maxTypeFactoryCacheSize);
        }

        public Builder maxDeserializerCacheSize(int i) {
            if (i >= 0) {
                this._maxDeserializerCacheSize = i;
                return this;
            }
            f.s("Cannot set maxDeserializerCacheSize to a negative value");
            return null;
        }

        public Builder maxSerializerCacheSize(int i) {
            if (i >= 0) {
                this._maxSerializerCacheSize = i;
                return this;
            }
            f.s("Cannot set maxSerializerCacheSize to a negative value");
            return null;
        }

        public Builder maxTypeFactoryCacheSize(int i) {
            if (i >= 0) {
                this._maxTypeFactoryCacheSize = i;
                return this;
            }
            f.s("Cannot set maxTypeFactoryCacheSize to a negative value");
            return null;
        }
    }

    public DefaultCacheProvider(int i, int i3, int i10) {
        this._maxDeserializerCacheSize = i;
        this._maxSerializerCacheSize = i3;
        this._maxTypeFactoryCacheSize = i10;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static CacheProvider defaultInstance() {
        return DEFAULT;
    }

    public <K, V> LookupCache<K, V> _buildCache(int i) {
        return new LRUMap(Math.min(64, i >> 2), i);
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
