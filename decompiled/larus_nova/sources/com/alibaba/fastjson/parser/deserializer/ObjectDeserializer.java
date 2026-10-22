package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public interface ObjectDeserializer {
    <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102);

    int getFastMatchToken();
}
