package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class JSONPObject implements JSONSerializable {
    public static String SECURITY_PREFIX = "/**/";
    private String function;
    private final List<Object> parameters;

    public JSONPObject() {
        this.parameters = new ArrayList();
    }

    public String toJSONString() {
        return toString();
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getFunction() {
        return this.function;
    }

    public List<Object> getParameters() {
        return this.parameters;
    }

    public JSONPObject(String r100) {
        this.parameters = new ArrayList();
        this.function = r100;
    }

    public void addParameter(Object r100) {
        this.parameters.add(r100);
    }

    public void setFunction(String r100) {
        this.function = r100;
    }

    @Override // com.alibaba.fastjson.serializer.JSONSerializable
    public void write(JSONSerializer r100, Object r101, Type r102, int r103) throws IOException {
        SerializeWriter r104 = r100.out;
        int r105 = SerializerFeature.BrowserSecure.mask;
        if ((r103 & r105) == 0) goto L5;
    L6:
        r104.write(SECURITY_PREFIX);
    L7:
        r104.write(this.function);
        r104.write(40);
        int r106 = 0;
    L9:
        if (r106 >= this.parameters.size()) goto L13;
        if (r106 == 0) goto L12;
        r104.write(44);
    L12:
        r100.write(ListProtector.get(this.parameters, r106));
        r106 = r106 + 1;
        goto L9
    L13:
        r104.write(41);
        return;
    L5:
        if (r104.isEnabled(r105) == false) goto L7;
        goto L6
    }
}
