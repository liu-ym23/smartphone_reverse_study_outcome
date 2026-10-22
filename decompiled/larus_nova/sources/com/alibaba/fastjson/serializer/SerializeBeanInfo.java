package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;

/* JADX INFO: loaded from: classes28.dex */
public class SerializeBeanInfo {
    protected final Class<?> beanType;
    protected int features;
    protected final FieldInfo[] fields;
    protected final JSONType jsonType;
    protected final FieldInfo[] sortedFields;
    protected final String typeKey;
    protected final String typeName;

    public SerializeBeanInfo(Class<?> r100, JSONType r101, String r102, String r103, int r104, FieldInfo[] r105, FieldInfo[] r106) {
        this.beanType = r100;
        this.jsonType = r101;
        this.typeName = r102;
        this.typeKey = r103;
        this.features = r104;
        this.fields = r105;
        this.sortedFields = r106;
    }
}
