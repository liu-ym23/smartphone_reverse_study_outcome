package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes28.dex */
public class JSONWriter implements Closeable, Flushable {
    private JSONStreamContext context;
    private JSONSerializer serializer;
    private SerializeWriter writer;

    private void afterWrite() {
        JSONStreamContext r100 = this.context;
        if (r100 != null) goto L6;
        return;
    L6:
        switch(r100.state) {
            case 1001: goto L10;
            case 1002: goto L9;
            case 1003: goto L10;
            case 1004: goto L8;
            default: goto L11;
        };
    L8:
        int r101 = 1005;
    L12:
        if (r101 == (-1)) goto L15;
        r100.state = r101;
        return;
    L15:
        return;
    L9:
        r101 = 1003;
        goto L12
    L10:
        r101 = 1002;
        goto L12
    L11:
        r101 = -1;
        goto L12
    }

    private void beforeWrite() {
        JSONStreamContext r100 = this.context;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.state;
        if (r101 != 1002) goto L8;
        this.writer.write(58);
        return;
    L8:
        if (r101 != 1003) goto L10;
        this.writer.write(44);
        return;
    L10:
        if (r101 != 1005) goto L18;
        this.writer.write(44);
        return;
    }

    private void beginStructure() {
        int r100 = this.context.state;
        switch(r100) {
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
        throw new JSONException("illegal state : " + r100);
    }

    private void endStructure() {
        JSONStreamContext r100 = this.context.parent;
        this.context = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.state;
        int r102 = 1002;
        if (r101 == 1001) goto L13;
        if (r101 != 1002) goto L9;
        r102 = 1003;
        goto L13
    L9:
        if (r101 == 1004) goto L11;
        r102 = -1;
        goto L13
    L11:
        r102 = 1005;
    L13:
        if (r102 == (-1)) goto L16;
        r100.state = r102;
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
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

    public void writeEndArray() {
        endArray();
    }

    public void writeEndObject() {
        endObject();
    }

    public void writeStartArray() {
        startArray();
    }

    public void writeStartObject() {
        startObject();
    }

    public JSONWriter(Writer r100) {
        SerializeWriter r101 = new SerializeWriter(r100);
        this.writer = r101;
        this.serializer = new JSONSerializer(r101);
    }

    public void writeKey(String r100) {
        writeObject(r100);
    }

    public void writeObject(Object r100) {
        beforeWrite();
        this.serializer.write(r100);
        afterWrite();
    }

    public void writeValue(Object r100) {
        writeObject(r100);
    }

    public void writeObject(String r100) {
        beforeWrite();
        this.serializer.write(r100);
        afterWrite();
    }

    public void config(SerializerFeature r100, boolean r101) {
        this.writer.config(r100, r101);
    }
}
