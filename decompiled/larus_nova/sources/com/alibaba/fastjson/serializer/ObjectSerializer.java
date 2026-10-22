package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public interface ObjectSerializer {
    void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException;
}
