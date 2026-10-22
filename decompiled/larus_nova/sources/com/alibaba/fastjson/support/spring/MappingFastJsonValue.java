package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class MappingFastJsonValue implements JSONSerializable {
    private static final int BrowserSecureMask = 0;
    private static final String SECURITY_PREFIX = "/**/";
    private String jsonpFunction;
    private Object value;

    static {
        BrowserSecureMask = SerializerFeature.BrowserSecure.mask;
    }

    public String getJsonpFunction() {
        return this.jsonpFunction;
    }

    public Object getValue() {
        return this.value;
    }

    public MappingFastJsonValue(Object r100) {
        this.value = r100;
    }

    public void setJsonpFunction(String r100) {
        this.jsonpFunction = r100;
    }

    public void setValue(Object r100) {
        this.value = r100;
    }

    @Override // com.alibaba.fastjson.serializer.JSONSerializable
    public void write(JSONSerializer r100, Object r101, Type r102, int r103) throws IOException {
        SerializeWriter r104 = r100.out;
        if (this.jsonpFunction != null) goto L6;
        r100.write(this.value);
        return;
    L6:
        int r105 = BrowserSecureMask;
        if ((r103 & r105) == 0) goto L9;
    L10:
        r104.write(SECURITY_PREFIX);
    L11:
        r104.write(this.jsonpFunction);
        r104.write(40);
        r100.write(this.value);
        r104.write(41);
        return;
    L9:
        if (r104.isEnabled(r105) == false) goto L11;
        goto L10
    }
}
