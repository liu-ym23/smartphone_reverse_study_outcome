package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes28.dex */
public class SimpleDateFormatSerializer implements ObjectSerializer {
    private final String pattern;

    public SimpleDateFormatSerializer(String r100) {
        this.pattern = r100;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        if (r101 != null) goto L5;
        r100.out.writeNull();
        return;
    L5:
        SimpleDateFormat r105 = new SimpleDateFormat(this.pattern, r100.locale);
        r105.setTimeZone(r100.timeZone);
        r100.write(r105.format((Date) r101));
    }
}
