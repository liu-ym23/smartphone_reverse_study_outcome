package com.alibaba.fastjson.parser;

import com.bytedance.librarian.LibrarianImpl;
import com.tmall.wireless.tangram.expression.TangramExprSupport;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class ParseContext {
    public final Object fieldName;
    public Object object;
    public final ParseContext parent;
    private transient String path;
    public Type type;

    public ParseContext(ParseContext r10, Object r11, Object r12) {
        this.parent = r10;
        this.object = r11;
        this.fieldName = r12;
    }

    public String toString() {
        if (this.path != null) goto L12;
        if (this.parent != null) goto L8;
        this.path = TangramExprSupport.VAR_START;
        goto L12
    L8:
        if ((this.fieldName instanceof Integer) == false) goto L10;
        this.path = this.parent.toString() + "[" + this.fieldName + "]";
        goto L12
    L10:
        this.path = this.parent.toString() + LibrarianImpl.Constants.DOT + this.fieldName;
    L12:
        return this.path;
    }
}
