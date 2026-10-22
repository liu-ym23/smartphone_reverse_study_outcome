package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
class EnumSerializer implements ObjectSerializer {
    public EnumSerializer() {
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r10, Object r11, Object r12, Type r13) throws IOException {
        SerializeWriter r14 = r10.out;
        if ((r14.features & SerializerFeature.WriteEnumUsingToString.mask) == 0) goto L8;
        String r15 = ((Enum) r11).toString();
        if ((r14.features & SerializerFeature.UseSingleQuotes.mask) == 0) goto L7;
        r14.writeStringWithSingleQuote(r15);
        return;
    L7:
        r14.writeStringWithDoubleQuote(r15, 0, false);
        return;
    L8:
        r14.writeInt(((Enum) r11).ordinal());
    }
}
