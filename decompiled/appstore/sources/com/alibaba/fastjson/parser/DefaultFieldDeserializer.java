package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    protected ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig r10, Class<?> r11, FieldInfo r12) {
        super(r11, r12, 2);
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig r10) {
        if (this.fieldValueDeserilizer != null) goto L6;
        FieldInfo r11 = this.fieldInfo;
        this.fieldValueDeserilizer = r10.getDeserializer(r11.fieldClass, r11.fieldType);
    L6:
        return this.fieldValueDeserilizer;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser r10, Object r11, Type r12, Map<String, Object> r13) {
        if (this.fieldValueDeserilizer != null) goto L6;
        ParserConfig r14 = r10.config;
        FieldInfo r15 = this.fieldInfo;
        this.fieldValueDeserilizer = r14.getDeserializer(r15.fieldClass, r15.fieldType);
    L6:
        if ((r12 instanceof ParameterizedType) == false) goto L8;
        r10.contex.type = r12;
    L8:
        FieldInfo r16 = this.fieldInfo;
        String r17 = r16.format;
        if (r17 == null) goto L13;
        ObjectDeserializer r18 = this.fieldValueDeserilizer;
        if ((r18 instanceof DateCodec) == false) goto L13;
        Object r19 = ((DateCodec) r18).deserialze(r10, r16.fieldType, r16.name, r17);
    L15:
        if (r10.resolveStatus != 1) goto L17;
        DefaultJSONParser.ResolveTask r20 = r10.getLastResolveTask();
        r20.fieldDeserializer = this;
        r20.ownerContext = r10.contex;
        r10.resolveStatus = 0;
        return;
    L17:
        if (r11 != null) goto L19;
        r13.put(this.fieldInfo.name, r19);
        return;
    L19:
        if (r19 != null) goto L29;
        Class<?> r21 = this.fieldInfo.fieldClass;
        if (r21 != Byte.TYPE) goto L23;
        return;
    L23:
        if (r21 != Short.TYPE) goto L25;
        return;
    L25:
        if (r21 != Float.TYPE) goto L27;
        return;
    L27:
        if (r21 != Double.TYPE) goto L29;
        return;
    L29:
        setValue(r11, r19);
        return;
    L13:
        r19 = this.fieldValueDeserilizer.deserialze(r10, r16.fieldType, r16.name);
        goto L15
    }
}
