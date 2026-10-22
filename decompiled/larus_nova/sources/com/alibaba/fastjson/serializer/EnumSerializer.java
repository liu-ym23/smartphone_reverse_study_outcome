package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class EnumSerializer implements ObjectSerializer {
    public static final EnumSerializer instance = null;
    private final Member member;

    static {
        instance = new EnumSerializer();
    }

    public EnumSerializer() {
        this.member = null;
    }

    public EnumSerializer(Member r100) {
        this.member = r100;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        Member r105 = this.member;
        if (r105 != null) goto L15;
        r100.out.writeEnum((Enum) r101);
        return;
    L15:
    L12:
        e = move-exception;
        throw new JSONException("getEnumValue error", e);
    L7:
        if ((r105 instanceof Field) == false) goto L9;
        Object r106 = ((Field) r105).get(r101);     // Catch: Exception -> L12
    L10:
        r100.write(r106);
        return;
    L9:
        r106 = ((Method) r105).invoke(r101, new Object[0]);     // Catch: Exception -> L12
        goto L10
    }
}
