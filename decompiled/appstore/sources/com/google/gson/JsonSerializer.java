package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T r10, Type r11, JsonSerializationContext r12);
}
