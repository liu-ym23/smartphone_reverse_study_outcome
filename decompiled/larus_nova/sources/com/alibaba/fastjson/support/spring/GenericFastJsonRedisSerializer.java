package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/* JADX INFO: loaded from: classes28.dex */
public class GenericFastJsonRedisSerializer implements RedisSerializer<Object> {
    private static final ParserConfig defaultRedisConfig = null;

    public GenericFastJsonRedisSerializer() {
    }

    static {
        ParserConfig r100 = new ParserConfig();
        defaultRedisConfig = r100;
        r100.setAutoTypeSupport(true);
    }

    public Object deserialize(byte[] r100) throws SerializationException {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length == 0) goto L15;
        return JSON.parseObject(new String(r100, IOUtils.UTF8), Object.class, defaultRedisConfig, new Feature[0]);
    L8:
        e = move-exception;
        throw new SerializationException("Could not deserialize: " + e.getMessage(), e);
    L15:
        return null;
    }

    public byte[] serialize(Object r100) throws SerializationException {
        if (r100 != null) goto L12;
        return new byte[0];
    L12:
        return JSON.toJSONBytes(r100, new SerializerFeature[]{SerializerFeature.WriteClassName});
    L9:
        e = move-exception;
        throw new SerializationException("Could not serialize: " + e.getMessage(), e);
    }
}
