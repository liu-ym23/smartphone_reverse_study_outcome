package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public interface FieldTypeResolver extends ParseProcess {
    Type resolve(Object r100, String r101);
}
