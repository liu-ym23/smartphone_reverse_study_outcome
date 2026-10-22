package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public interface PropertyProcessable extends ParseProcess {
    void apply(String r100, Object r101);

    Type getType(String r100);
}
