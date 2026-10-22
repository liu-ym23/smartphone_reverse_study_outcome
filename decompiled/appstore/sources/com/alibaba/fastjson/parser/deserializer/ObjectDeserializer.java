package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface ObjectDeserializer {
    <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12);
}
