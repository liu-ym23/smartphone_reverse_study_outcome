package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class EngineKeyFactory {
    public EngineKeyFactory() {
    }

    public EngineKey buildKey(Object r11, Key r12, int r13, int r14, Map<Class<?>, Transformation<?>> r15, Class<?> r16, Class<?> r17, Options r18) {
        return new EngineKey(r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
