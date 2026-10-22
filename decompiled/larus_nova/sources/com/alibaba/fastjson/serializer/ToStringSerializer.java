package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class ToStringSerializer implements ObjectSerializer {
    public static final ToStringSerializer instance = null;

    public ToStringSerializer() {
    }

    static {
        instance = new ToStringSerializer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if (r101 != null) goto L6;
        r105.writeNull();
        return;
    L6:
        r105.writeString(r101.toString());
    }
}
