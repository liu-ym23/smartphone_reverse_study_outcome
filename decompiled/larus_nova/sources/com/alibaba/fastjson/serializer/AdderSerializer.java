package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/* JADX INFO: loaded from: classes28.dex */
public class AdderSerializer implements ObjectSerializer {
    public static final AdderSerializer instance = null;

    public AdderSerializer() {
    }

    static {
        instance = new AdderSerializer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if ((r101 instanceof LongAdder) == false) goto L6;
        r105.writeFieldValue('{', "value", ((LongAdder) r101).longValue());
        r105.write(125);
        return;
    L6:
        if ((r101 instanceof DoubleAdder) == false) goto L10;
        r105.writeFieldValue('{', "value", ((DoubleAdder) r101).doubleValue());
        r105.write(125);
        return;
    }
}
