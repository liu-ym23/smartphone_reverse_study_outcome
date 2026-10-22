package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class ResolveFieldDeserializer extends FieldDeserializer {
    private final Collection collection;
    private final int index;
    private final Object key;
    private final List list;
    private final Map map;
    private final DefaultJSONParser parser;

    public ResolveFieldDeserializer(DefaultJSONParser r10, List r11, int r12) {
        super(null, null, 0);
        this.parser = r10;
        this.index = r12;
        this.list = r11;
        this.key = null;
        this.map = null;
        this.collection = null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser r10, Object r11, Type r12, Map<String, Object> r13) {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void setValue(Object r10, Object r11) {
        Map r12 = this.map;
        if (r12 == null) goto L6;
        r12.put(this.key, r11);
        return;
    L6:
        Collection r13 = this.collection;
        if (r13 == null) goto L10;
        r13.add(r11);
        return;
    L10:
        this.list.set(this.index, r11);
        List r14 = this.list;
        if ((r14 instanceof JSONArray) == false) goto L21;
        JSONArray r15 = (JSONArray) r14;
        Object r16 = r15.getRelatedArray();
        if (r16 != null) goto L15;
        return;
    L15:
        if (Array.getLength(r16) > this.index) goto L17;
        return;
    L17:
        if (r15.getComponentType() == null) goto L19;
        r11 = TypeUtils.cast(r11, r15.getComponentType(), this.parser.config);
    L19:
        Array.set(r16, this.index, r11);
        return;
    }

    public ResolveFieldDeserializer(Map r10, Object r11) {
        super(null, null, 0);
        this.parser = null;
        this.index = -1;
        this.list = null;
        this.key = r11;
        this.map = r10;
        this.collection = null;
    }

    public ResolveFieldDeserializer(Collection r10) {
        super(null, null, 0);
        this.parser = null;
        this.index = -1;
        this.list = null;
        this.key = null;
        this.map = null;
        this.collection = r10;
    }
}
