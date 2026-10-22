package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class JSONSerializableSerializer implements ObjectSerializer {
    public static JSONSerializableSerializer instance;

    public JSONSerializableSerializer() {
    }

    static {
        instance = new JSONSerializableSerializer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        JSONSerializable r105 = (JSONSerializable) r101;
        if (r105 != null) goto L6;
        r100.writeNull();
        return;
    L6:
        r105.write(r100, r102, r103, r104);
    }
}
