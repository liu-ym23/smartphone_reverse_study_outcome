package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public interface JSONSerializable {
    void write(JSONSerializer r100, Object r101, Type r102, int r103) throws IOException;
}
