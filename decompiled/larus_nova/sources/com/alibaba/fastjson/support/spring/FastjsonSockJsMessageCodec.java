package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.socket.sockjs.frame.AbstractSockJsMessageCodec;

/* JADX INFO: loaded from: classes28.dex */
public class FastjsonSockJsMessageCodec extends AbstractSockJsMessageCodec {
    public FastjsonSockJsMessageCodec() {
    }

    public char[] applyJsonQuoting(String r100) {
        SerializeWriter r101 = new SerializeWriter();
        new JSONSerializer(r101).write(r100);     // Catch: Throwable -> L6
        char[] r102 = r101.toCharArrayForSpringWebSocket();     // Catch: Throwable -> L6
        r101.close();
        return r102;
    L6:
        th = move-exception;
        r101.close();
        throw th;
    }

    public String[] decode(String r100) throws IOException {
        return (String[]) JSON.parseObject(r100, String[].class);
    }

    public String[] decodeInputStream(InputStream r100) throws IOException {
        return (String[]) JSON.parseObject(r100, String[].class, new Feature[0]);
    }
}
