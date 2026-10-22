package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface JSONSerializable {
    void write(JSONSerializer r10, Object r11, Type r12) throws IOException;
}
