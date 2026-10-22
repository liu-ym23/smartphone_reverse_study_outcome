package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class ParseContext {
    public final Object fieldName;
    public final int level;
    public Object object;
    public final ParseContext parent;
    private transient String path;
    public Type type;

    public String toString() {
        if (this.path != null) goto L12;
        if (this.parent != null) goto L8;
        this.path = "$";
        goto L12
    L8:
        if ((this.fieldName instanceof Integer) == false) goto L10;
        this.path = this.parent.toString() + "[" + this.fieldName + "]";
        goto L12
    L10:
        this.path = this.parent.toString() + "." + this.fieldName;
    L12:
        return this.path;
    }

    public ParseContext(ParseContext r100, Object r101, Object r102) {
        this.parent = r100;
        this.object = r101;
        this.fieldName = r102;
        if (r100 != null) goto L5;
        int r103 = 0;
    L6:
        this.level = r103;
        return;
    L5:
        r103 = r100.level + 1;
        goto L6
    }
}
