package com.alibaba.fastjson;

/* JADX INFO: loaded from: classes28.dex */
class JSONStreamContext {
    static final int ArrayValue = 1005;
    static final int PropertyKey = 1002;
    static final int PropertyValue = 1003;
    static final int StartArray = 1004;
    static final int StartObject = 1001;
    protected final JSONStreamContext parent;
    protected int state;

    public JSONStreamContext(JSONStreamContext r100, int r101) {
        this.parent = r100;
        this.state = r101;
    }
}
