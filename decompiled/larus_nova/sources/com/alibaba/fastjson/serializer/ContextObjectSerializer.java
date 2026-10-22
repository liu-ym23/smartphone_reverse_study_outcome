package com.alibaba.fastjson.serializer;

import java.io.IOException;

/* JADX INFO: loaded from: classes28.dex */
public interface ContextObjectSerializer extends ObjectSerializer {
    void write(JSONSerializer r100, Object r101, BeanContext r102) throws IOException;
}
