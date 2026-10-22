package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import java.util.Map;

/* loaded from: classes2.dex */
class EngineKeyFactory {
    public EngineKey buildKey(Object obj, Key key, int i, int i6, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        return new EngineKey(obj, key, i, i6, map, cls, cls2, options);
    }
}
