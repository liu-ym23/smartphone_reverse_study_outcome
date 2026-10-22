package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class JSONObjectCodec implements ObjectSerializer {
    public static final JSONObjectCodec instance = null;

    public JSONObjectCodec() {
    }

    static {
        instance = new JSONObjectCodec();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r110, Type r111, int r112) throws IOException {
        SerializeWriter r102 = r100.out;
        MapSerializer r103 = MapSerializer.instance;
        Field r104 = r101.getClass().getDeclaredField("map");     // Catch: Exception -> L8
        if (Modifier.isPrivate(r104.getModifiers()) == false) goto L6;
        r104.setAccessible(true);     // Catch: Exception -> L8
    L6:
        r103.write(r100, r104.get(r101), r110, r111, r112);     // Catch: Exception -> L8
        return;
    L8:
        r102.writeNull();
    }
}
