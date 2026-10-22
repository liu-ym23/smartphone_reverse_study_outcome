package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
class EngineKeyFactory {
    public EngineKeyFactory() {
    }

    public EngineKey buildKey(Object r110, Key r111, int r112, int r113, Map<Class<?>, Transformation<?>> r114, Class<?> r115, Class<?> r116, Options r117) {
        return new EngineKey(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
