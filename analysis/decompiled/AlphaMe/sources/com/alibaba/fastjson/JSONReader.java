package com.alibaba.fastjson;

import androidx.room.AbstractC0351g;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public class JSONReader implements Closeable {
    private JSONStreamContext context;
    private final DefaultJSONParser parser;

    public JSONReader(Reader reader) {
        this(reader, new Feature[0]);
    }

    private void endStructure() {
        int i4;
        JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext == null) {
            return;
        }
        switch (jSONStreamContext.state) {
            case 1001:
            case 1003:
                i4 = 1002;
                break;
            case 1002:
                i4 = 1003;
                break;
            case 1004:
                i4 = WebSocketProtocol.CLOSE_NO_STATUS_CODE;
                break;
            default:
                i4 = -1;
                break;
        }
        if (i4 != -1) {
            jSONStreamContext.state = i4;
        }
    }

    private void readAfter() {
        JSONStreamContext jSONStreamContext = this.context;
        int i4 = jSONStreamContext.state;
        int i5 = 1002;
        switch (i4) {
            case 1001:
            case 1003:
                break;
            case 1002:
                i5 = 1003;
                break;
            case 1004:
                i5 = WebSocketProtocol.CLOSE_NO_STATUS_CODE;
                break;
            case WebSocketProtocol.CLOSE_NO_STATUS_CODE /* 1005 */:
                i5 = -1;
                break;
            default:
                throw new JSONException(AbstractC0351g.m("illegal state : ", i4));
        }
        if (i5 != -1) {
            jSONStreamContext.state = i5;
        }
    }

    private void readBefore() {
        int i4 = this.context.state;
        switch (i4) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.parser.accept(17);
                return;
            case 1003:
                this.parser.accept(16, 18);
                return;
            case WebSocketProtocol.CLOSE_NO_STATUS_CODE /* 1005 */:
                this.parser.accept(16);
                return;
            default:
                throw new JSONException(AbstractC0351g.m("illegal state : ", i4));
        }
    }

    private void startStructure() {
        switch (this.context.state) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.parser.accept(17);
                return;
            case 1003:
            case WebSocketProtocol.CLOSE_NO_STATUS_CODE /* 1005 */:
                this.parser.accept(16);
                return;
            default:
                throw new JSONException("illegal state : " + this.context.state);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.parser.close();
    }

    public void config(Feature feature, boolean z4) {
        this.parser.config(feature, z4);
    }

    public void endArray() {
        this.parser.accept(15);
        endStructure();
    }

    public void endObject() {
        this.parser.accept(13);
        endStructure();
    }

    public Locale getLocal() {
        return this.parser.lexer.getLocale();
    }

    public TimeZone getTimzeZone() {
        return this.parser.lexer.getTimeZone();
    }

    public boolean hasNext() {
        if (this.context == null) {
            throw new JSONException("context is null");
        }
        int i4 = this.parser.lexer.token();
        int i5 = this.context.state;
        switch (i5) {
            case 1001:
            case 1003:
                return i4 != 13;
            case 1002:
            default:
                throw new JSONException(AbstractC0351g.m("illegal state : ", i5));
            case 1004:
            case WebSocketProtocol.CLOSE_NO_STATUS_CODE /* 1005 */:
                return i4 != 15;
        }
    }

    public int peek() {
        return this.parser.lexer.token();
    }

    public Integer readInteger() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            Object obj2 = this.parser.parse();
            readAfter();
            obj = obj2;
        }
        return TypeUtils.castToInt(obj);
    }

    public Long readLong() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            Object obj2 = this.parser.parse();
            readAfter();
            obj = obj2;
        }
        return TypeUtils.castToLong(obj);
    }

    public <T> T readObject(TypeReference<T> typeReference) {
        return (T) readObject(typeReference.getType());
    }

    public String readString() {
        Object obj;
        Object obj2;
        if (this.context == null) {
            obj2 = this.parser.parse();
        } else {
            readBefore();
            JSONLexer jSONLexer = this.parser.lexer;
            if (this.context.state == 1001 && jSONLexer.token() == 18) {
                String strStringVal = jSONLexer.stringVal();
                jSONLexer.nextToken();
                obj = strStringVal;
            } else {
                obj = this.parser.parse();
            }
            readAfter();
            obj2 = obj;
        }
        return TypeUtils.castToString(obj2);
    }

    public void setLocale(Locale locale) {
        this.parser.lexer.setLocale(locale);
    }

    public void setTimzeZone(TimeZone timeZone) {
        this.parser.lexer.setTimeZone(timeZone);
    }

    public void startArray() {
        if (this.context == null) {
            this.context = new JSONStreamContext(null, 1004);
        } else {
            startStructure();
            this.context = new JSONStreamContext(this.context, 1004);
        }
        this.parser.accept(14);
    }

    public void startObject() {
        if (this.context == null) {
            this.context = new JSONStreamContext(null, 1001);
        } else {
            startStructure();
            this.context = new JSONStreamContext(this.context, 1001);
        }
        this.parser.accept(12, 18);
    }

    public JSONReader(Reader reader, Feature... featureArr) {
        this(new JSONReaderScanner(reader));
        for (Feature feature : featureArr) {
            config(feature, true);
        }
    }

    public <T> T readObject(Type type) {
        if (this.context == null) {
            return (T) this.parser.parseObject(type);
        }
        readBefore();
        T t4 = (T) this.parser.parseObject(type);
        readAfter();
        return t4;
    }

    public JSONReader(JSONLexer jSONLexer) {
        this(new DefaultJSONParser(jSONLexer));
    }

    public JSONReader(DefaultJSONParser defaultJSONParser) {
        this.parser = defaultJSONParser;
    }

    public <T> T readObject(Class<T> cls) {
        if (this.context == null) {
            return (T) this.parser.parseObject((Class) cls);
        }
        readBefore();
        T t4 = (T) this.parser.parseObject((Class) cls);
        readAfter();
        return t4;
    }

    public void readObject(Object obj) {
        if (this.context == null) {
            this.parser.parseObject(obj);
            return;
        }
        readBefore();
        this.parser.parseObject(obj);
        readAfter();
    }

    public Object readObject() {
        Object key;
        if (this.context == null) {
            return this.parser.parse();
        }
        readBefore();
        int i4 = this.context.state;
        if (i4 != 1001 && i4 != 1003) {
            key = this.parser.parse();
        } else {
            key = this.parser.parseKey();
        }
        readAfter();
        return key;
    }

    public Object readObject(Map map) {
        if (this.context == null) {
            return this.parser.parseObject(map);
        }
        readBefore();
        Object object = this.parser.parseObject(map);
        readAfter();
        return object;
    }
}
