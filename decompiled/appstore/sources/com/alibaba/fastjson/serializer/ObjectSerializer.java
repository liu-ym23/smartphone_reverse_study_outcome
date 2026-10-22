package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface ObjectSerializer {
    void write(JSONSerializer r10, Object r11, Object r12, Type r13) throws IOException;
}
