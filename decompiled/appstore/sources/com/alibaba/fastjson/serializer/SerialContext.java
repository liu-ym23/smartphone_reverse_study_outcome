package com.alibaba.fastjson.serializer;

import com.bytedance.librarian.LibrarianImpl;
import com.tmall.wireless.tangram.expression.TangramExprSupport;

/* JADX INFO: loaded from: classes.dex */
public class SerialContext {
    public final int features;
    public final Object fieldName;
    public final Object object;
    public final SerialContext parent;

    public SerialContext(SerialContext r10, Object r11, Object r12, int r13) {
        this.parent = r10;
        this.object = r11;
        this.fieldName = r12;
        this.features = r13;
    }

    public String toString() {
        if (this.parent != null) goto L7;
        return TangramExprSupport.VAR_START;
    L7:
        if ((this.fieldName instanceof Integer) == false) goto L11;
        return this.parent.toString() + "[" + this.fieldName + "]";
    L11:
        return this.parent.toString() + LibrarianImpl.Constants.DOT + this.fieldName;
    }
}
