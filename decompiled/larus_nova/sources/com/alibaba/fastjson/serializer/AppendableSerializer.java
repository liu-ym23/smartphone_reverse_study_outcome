package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class AppendableSerializer implements ObjectSerializer {
    public static final AppendableSerializer instance = null;

    public AppendableSerializer() {
    }

    static {
        instance = new AppendableSerializer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        if (r101 != null) goto L5;
        r100.out.writeNull(SerializerFeature.WriteNullStringAsEmpty);
        return;
    L5:
        r100.write(r101.toString());
    }
}
