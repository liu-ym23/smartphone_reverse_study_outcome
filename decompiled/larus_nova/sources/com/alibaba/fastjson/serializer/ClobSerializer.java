package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes28.dex */
public class ClobSerializer implements ObjectSerializer {
    public static final ClobSerializer instance = null;

    public ClobSerializer() {
    }

    static {
        instance = new ClobSerializer();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        if (r101 != null) goto L5;
        r100.writeNull();     // Catch: SQLException -> L17
        return;
    L5:
        Reader r105 = ((Clob) r101).getCharacterStream();     // Catch: SQLException -> L17
        StringBuilder r106 = new StringBuilder();     // Catch: SQLException -> L17
        char[] r107 = new char[2048];     // Catch: Exception -> L14
    L8:
        int r108 = r105.read(r107, 0, 2048);     // Catch: Exception -> L14
        if (r108 < 0) goto L10;
        r106.append(r107, 0, r108);     // Catch: Exception -> L14
    L10:
        String r109 = r106.toString();     // Catch: SQLException -> L17
        r105.close();     // Catch: SQLException -> L17
        r100.write(r109);     // Catch: SQLException -> L17
        return;
    L14:
        e = move-exception;
        throw new JSONException("read string from reader error", e);     // Catch: SQLException -> L17
    L17:
        e = move-exception;
        throw new IOException("write clob error", e);
    }
}
