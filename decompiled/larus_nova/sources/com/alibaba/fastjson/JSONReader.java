package com.alibaba.fastjson;

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

/* JADX INFO: loaded from: classes28.dex */
public class JSONReader implements Closeable {
    private JSONStreamContext context;
    private transient JSONStreamContext lastContext;
    private final DefaultJSONParser parser;

    private void endStructure() {
        JSONStreamContext r100 = this.context;
        this.lastContext = r100;
        JSONStreamContext r101 = r100.parent;
        this.context = r101;
        if (r101 != null) goto L6;
        return;
    L6:
        switch(r101.state) {
            case 1001: goto L10;
            case 1002: goto L9;
            case 1003: goto L10;
            case 1004: goto L8;
            default: goto L7;
        };
    L7:
        int r102 = -1;
    L11:
        if (r102 == (-1)) goto L14;
        r101.state = r102;
        return;
    L14:
        return;
    L8:
        r102 = 1005;
        goto L11
    L9:
        r102 = 1003;
        goto L11
    L10:
        r102 = 1002;
        goto L11
    }

    private void readAfter() {
        JSONStreamContext r100 = this.context;
        int r101 = r100.state;
        int r102 = 1002;
        switch(r101) {
            case 1001: goto L9;
            case 1002: goto L8;
            case 1003: goto L9;
            case 1004: goto L7;
            case 1005: goto L6;
            default: goto L5;
        };
    L6:
        r102 = -1;
        goto L9
    L7:
        r102 = 1005;
        goto L9
    L8:
        r102 = 1003;
    L9:
        if (r102 == (-1)) goto L12;
        r100.state = r102;
        return;
    L12:
        return;
    L5:
        throw new JSONException("illegal state : " + r101);
    }

    private void readBefore() {
        int r100 = this.context.state;
        switch(r100) {
            case 1001: goto L10;
            case 1002: goto L8;
            case 1003: goto L7;
            case 1004: goto L10;
            case 1005: goto L6;
            default: goto L5;
        };
    L6:
        this.parser.accept(16);
        return;
    L7:
        this.parser.accept(16, 18);
        return;
    L8:
        this.parser.accept(17);
        return;
    L10:
        return;
    L5:
        throw new JSONException("illegal state : " + r100);
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
        this.parser.close();
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
        if (this.context == null) goto L19;
        int r100 = this.parser.lexer.token();
        int r101 = this.context.state;
        switch(r101) {
            case 1001: goto L14;
            case 1002: goto L7;
            case 1003: goto L14;
            case 1004: goto L9;
            case 1005: goto L9;
            default: goto L7;
        };
    L7:
        throw new JSONException("illegal state : " + r101);
    L9:
        if (r100 != 15) goto L20;
        return false;
    L20:
        return true;
    L14:
        if (r100 != 13) goto L21;
        return false;
    L21:
        return true;
    L19:
        throw new JSONException("context is null");
    }

    public int peek() {
        return this.parser.lexer.token();
    }

    public Integer readInteger() {
        if (this.context != null) goto L5;
        Object r100 = this.parser.parse();
    L7:
        return TypeUtils.castToInt(r100);
    L5:
        readBefore();
        r100 = this.parser.parse();
        readAfter();
        goto L7
    }

    public Long readLong() {
        if (this.context != null) goto L5;
        Object r100 = this.parser.parse();
    L7:
        return TypeUtils.castToLong(r100);
    L5:
        readBefore();
        r100 = this.parser.parse();
        readAfter();
        goto L7
    }

    public Object readObject() {
        if (this.context == null) goto L5;
        readBefore();
        int r100 = this.context.state;
        if (r100 != 1001) goto L9;
    L11:
        Object r101 = this.parser.parseKey();
    L12:
        readAfter();
        return r101;
    L9:
        if (r100 == 1003) goto L11;
        r101 = this.parser.parse();
        goto L12
    L5:
        return this.parser.parse();
    }

    public String readString() {
        if (this.context != null) goto L5;
        Object r100 = this.parser.parse();
    L13:
        return TypeUtils.castToString(r100);
    L5:
        readBefore();
        JSONLexer r101 = this.parser.lexer;
        if (this.context.state == 1001) goto L8;
    L10:
        r100 = this.parser.parse();
    L11:
        readAfter();
        goto L13
    L8:
        if (r101.token() != 18) goto L10;
        String r102 = r101.stringVal();
        r101.nextToken();
        r100 = r102;
        goto L11
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
    L13:
        this.parser.accept(12, 18);
        return;
    L5:
        startStructure();
        JSONStreamContext r100 = this.lastContext;
        if (r100 != null) goto L8;
    L12:
        this.context = new JSONStreamContext(this.context, 1001);
        goto L13
    L8:
        if (r100.parent != this.context) goto L12;
        this.context = r100;
        if (r100.state == 1001) goto L13;
        r100.state = 1001;
        goto L13
    }

    public JSONReader(JSONLexer r100) {
        this(new DefaultJSONParser(r100));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T> T readObject(Class<T> r100) {
        if (this.context == null) goto L5;
        readBefore();
        T r101 = (T) this.parser.parseObject(r100);
        this.parser.handleResovleTask(r101);
        readAfter();
        return r101;
    L5:
        return (T) this.parser.parseObject(r100);
    }

    public void setLocale(Locale r100) {
        this.parser.lexer.setLocale(r100);
    }

    public void setTimzeZone(TimeZone r100) {
        this.parser.lexer.setTimeZone(r100);
    }

    public JSONReader(Reader r100) {
        this(r100, new Feature[0]);
    }

    public <T> T readObject(Type r100) {
        if (this.context == null) goto L5;
        readBefore();
        T r101 = (T) this.parser.parseObject(r100);
        readAfter();
        return r101;
    L5:
        return (T) this.parser.parseObject(r100);
    }

    public JSONReader(DefaultJSONParser r100) {
        this.parser = r100;
    }

    public Object readObject(Map r100) {
        if (this.context == null) goto L5;
        readBefore();
        Object r101 = this.parser.parseObject(r100);
        readAfter();
        return r101;
    L5:
        return this.parser.parseObject(r100);
    }

    public void readObject(Object r100) {
        if (this.context != null) goto L6;
        this.parser.parseObject(r100);
        return;
    L6:
        readBefore();
        this.parser.parseObject(r100);
        readAfter();
    }

    public <T> T readObject(TypeReference<T> r100) {
        return (T) readObject(r100.getType());
    }

    public JSONReader(Reader r100, Feature... r101) {
        this(new JSONReaderScanner(r100));
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        config(r101[r103], true);
        r103 = r103 + 1;
        goto L3
    }

    public void config(Feature r100, boolean r101) {
        this.parser.config(r100, r101);
    }
}
