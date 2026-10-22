package com.alibaba.fastjson.support.springfox;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import springfox.documentation.spring.web.json.Json;

/* JADX INFO: loaded from: classes28.dex */
public class SwaggerJsonSerializer implements ObjectSerializer {
    public static final SwaggerJsonSerializer instance = null;

    public SwaggerJsonSerializer() {
    }

    static {
        instance = new SwaggerJsonSerializer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        r100.getWriter().write(((Json) r101).value());
    }
}
