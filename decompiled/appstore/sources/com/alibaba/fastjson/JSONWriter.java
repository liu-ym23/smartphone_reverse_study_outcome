package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class JSONWriter implements Closeable, Flushable {
    private JSONStreamContext context;
    private JSONSerializer serializer;
    private SerializeWriter writer;

    public JSONWriter(Writer r10) {
        SerializeWriter r11 = new SerializeWriter(r10);
        this.writer = r11;
        this.serializer = new JSONSerializer(r11);
    }

    private void afterWriter() {
        JSONStreamContext r10 = this.context;
        if (r10 != null) goto L6;
        return;
    L6:
        switch(r10.state) {
            case 1001: goto L10;
            case 1002: goto L9;
            case 1003: goto L10;
            case 1004: goto L8;
            default: goto L7;
        };
    L7:
        int r11 = -1;
    L11:
        if (r11 == (-1)) goto L14;
        r10.state = r11;
        return;
    L14:
        return;
    L8:
        r11 = 1005;
        goto L11
    L9:
        r11 = 1003;
        goto L11
    L10:
        r11 = 1002;
        goto L11
    }

    private void beforeWrite() {
        JSONStreamContext r10 = this.context;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = r10.state;
        if (r11 != 1002) goto L8;
        this.writer.write(58);
        return;
    L8:
        if (r11 != 1003) goto L10;
        this.writer.write(44);
        return;
    L10:
        if (r11 != 1005) goto L18;
        this.writer.write(44);
        return;
    }

    private void beginStructure() {
        int r10 = this.context.state;
        switch(r10) {
            case 1001: goto L9;
            case 1002: goto L7;
            case 1003: goto L5;
            case 1004: goto L9;
            case 1005: goto L6;
            default: goto L5;
        };
    L6:
        this.writer.write(44);
        return;
    L7:
        this.writer.write(58);
        return;
    L9:
        return;
    L5:
        throw new JSONException("illegal state : " + r10);
    }

    private void endStructure() {
        JSONStreamContext r10 = this.context.parent;
        this.context = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = r10.state;
        int r12 = 1002;
        if (r11 == 1001) goto L13;
        if (r11 != 1002) goto L9;
        r12 = 1003;
        goto L13
    L9:
        if (r11 == 1004) goto L11;
        r12 = -1;
        goto L13
    L11:
        r12 = 1005;
    L13:
        if (r12 == (-1)) goto L16;
        r10.state = r12;
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
    }

    public void config(SerializerFeature r10, boolean r11) {
        this.writer.config(r10, r11);
    }

    public void endArray() {
        this.writer.write(93);
        endStructure();
    }

    public void endObject() {
        this.writer.write(125);
        endStructure();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    public void startArray() {
        if (this.context == null) goto L5;
        beginStructure();
    L5:
        this.context = new JSONStreamContext(this.context, 1004);
        this.writer.write(91);
    }

    public void startObject() {
        if (this.context == null) goto L5;
        beginStructure();
    L5:
        this.context = new JSONStreamContext(this.context, 1001);
        this.writer.write(123);
    }

    public void writeKey(String r10) {
        writeObject(r10);
    }

    public void writeObject(String r10) {
        beforeWrite();
        this.serializer.write(r10);
        afterWriter();
    }

    public void writeValue(Object r10) {
        writeObject(r10);
    }

    public void writeObject(Object r10) {
        beforeWrite();
        this.serializer.write(r10);
        afterWriter();
    }
}
