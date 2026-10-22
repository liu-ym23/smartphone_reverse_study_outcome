package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONAware;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class JSONAwareSerializer implements ObjectSerializer {
    public static JSONAwareSerializer instance;

    public JSONAwareSerializer() {
    }

    static {
        instance = new JSONAwareSerializer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if (r101 != null) goto L6;
        r105.writeNull();
        return;
    L6:
        r105.write(((JSONAware) r101).toJSONString());
    }
}
