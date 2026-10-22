package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JSONReader implements Closeable {
    private JSONStreamContext context;
    private final DefaultJSONParser parser;
    private Reader reader;

    public JSONReader(Reader r10) {
        this(new JSONLexer(readAll(r10)));
        this.reader = r10;
    }

    private void endStructure() {
        JSONStreamContext r10 = this.context.parent;
        this.context = r10;
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

    private void readAfter() {
        JSONStreamContext r10 = this.context;
        int r11 = r10.state;
        int r12 = 1002;
        switch(r11) {
            case 1001: goto L9;
            case 1002: goto L8;
            case 1003: goto L9;
            case 1004: goto L7;
            case 1005: goto L6;
            default: goto L5;
        };
    L6:
        r12 = -1;
        goto L9
    L7:
        r12 = 1005;
        goto L9
    L8:
        r12 = 1003;
    L9:
        if (r12 == (-1)) goto L12;
        r10.state = r12;
        return;
    L12:
        return;
    L5:
        throw new JSONException("illegal state : " + r11);
    }

    public static String readAll(Reader r10) {
        StringBuilder r11 = new StringBuilder();
        char[] r12 = new char[2048];     // Catch: Exception -> L10
    L4:
        int r13 = r10.read(r12, 0, 2048);     // Catch: Exception -> L10
        if (r13 < 0) goto L7;
        r11.append(r12, 0, r13);     // Catch: Exception -> L10
        goto L4
    L7:
        return r11.toString();
    L10:
        e = move-exception;
        throw new JSONException("read string from reader error", e);
    }

    private void readBefore() {
        int r10 = this.context.state;
        switch(r10) {
            case 1001: goto L9;
            case 1002: goto L7;
            case 1003: goto L6;
            case 1004: goto L9;
            case 1005: goto L6;
            default: goto L5;
        };
    L6:
        this.parser.accept(16);
        return;
    L7:
        this.parser.accept(17);
        return;
    L9:
        return;
    L5:
        throw new JSONException("illegal state : " + r10);
    }

    private void startStructure() {
        switch(this.context.state) {
            case 1001: goto L9;
            case 1002: goto L7;
            case 1003: goto L6;
            case 1004: goto L9;
            case 1005: goto L6;
            default: goto L5;
        };
    L6:
        this.parser.accept(16);
        return;
    L7:
        this.parser.accept(17);
        return;
    L9:
        return;
    L5:
        throw new JSONException("illegal state : " + this.context.state);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.parser.lexer.close();
        Reader r10 = this.reader;
        if (r10 != null) goto L10;
        return;
    L10:
        r10.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new JSONException("closed reader error", e);
    }

    public void config(Feature r10, boolean r11) {
        this.parser.config(r10, r11);
    }

    public void endArray() {
        this.parser.accept(15);
        endStructure();
    }

    public void endObject() {
        this.parser.accept(13);
        endStructure();
    }

    public boolean hasNext() {
        if (this.context == null) goto L17;
        int r10 = this.parser.lexer.token();
        int r11 = this.context.state;
        switch(r11) {
            case 1001: goto L13;
            case 1002: goto L7;
            case 1003: goto L13;
            case 1004: goto L9;
            case 1005: goto L9;
            default: goto L7;
        };
    L7:
        throw new JSONException("illegal state : " + r11);
    L9:
        if (r10 != 15) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (r10 != 13) goto L15;
        return false;
    L15:
        return true;
    L17:
        throw new JSONException("context is null");
    }

    public int peek() {
        return this.parser.lexer.token();
    }

    public Integer readInteger() {
        if (this.context != null) goto L5;
        Object r10 = this.parser.parse();
    L7:
        return TypeUtils.castToInt(r10);
    L5:
        readBefore();
        Object r11 = this.parser.parse();
        readAfter();
        r10 = r11;
        goto L7
    }

    public Long readLong() {
        if (this.context != null) goto L5;
        Object r10 = this.parser.parse();
    L7:
        return TypeUtils.castToLong(r10);
    L5:
        readBefore();
        Object r11 = this.parser.parse();
        readAfter();
        r10 = r11;
        goto L7
    }

    public <T> T readObject(TypeReference<T> r10) {
        return (T) readObject(r10.type);
    }

    public String readString() {
        if (this.context != null) goto L5;
        Object r10 = this.parser.parse();
    L7:
        return TypeUtils.castToString(r10);
    L5:
        readBefore();
        Object r11 = this.parser.parse();
        readAfter();
        r10 = r11;
        goto L7
    }

    public void startArray() {
        if (this.context != null) goto L5;
        this.context = new JSONStreamContext(null, 1004);
    L6:
        this.parser.accept(14);
        return;
    L5:
        startStructure();
        this.context = new JSONStreamContext(this.context, 1004);
        goto L6
    }

    public void startObject() {
        if (this.context != null) goto L5;
        this.context = new JSONStreamContext(null, 1001);
    L6:
        this.parser.accept(12);
        return;
    L5:
        startStructure();
        this.context = new JSONStreamContext(this.context, 1001);
        goto L6
    }

    public <T> T readObject(Type r10) {
        if (this.context == null) goto L5;
        readBefore();
        T r11 = (T) this.parser.parseObject(r10);
        readAfter();
        return r11;
    L5:
        return (T) this.parser.parseObject(r10);
    }

    public JSONReader(JSONLexer r10) {
        this(new DefaultJSONParser(r10));
    }

    public JSONReader(DefaultJSONParser r10) {
        this.parser = r10;
    }

    public <T> T readObject(Class<T> r10) {
        if (this.context == null) goto L5;
        readBefore();
        T r11 = (T) this.parser.parseObject(r10);
        readAfter();
        return r11;
    L5:
        return (T) this.parser.parseObject(r10);
    }

    public void readObject(Object r10) {
        if (this.context != null) goto L6;
        this.parser.parseObject(r10);
        return;
    L6:
        readBefore();
        this.parser.parseObject(r10);
        readAfter();
    }

    public Object readObject() {
        if (this.context == null) goto L5;
        readBefore();
        Object r10 = this.parser.parse();
        readAfter();
        return r10;
    L5:
        return this.parser.parse();
    }

    public Object readObject(Map r10) {
        if (this.context == null) goto L5;
        readBefore();
        Object r11 = this.parser.parseObject(r10);
        readAfter();
        return r11;
    L5:
        return this.parser.parseObject(r10);
    }
}
