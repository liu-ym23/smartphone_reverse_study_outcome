package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class BeforeFilter implements SerializeFilter {
    private static final Character COMMA = null;
    private static final ThreadLocal<Character> seperatorLocal = null;
    private static final ThreadLocal<JSONSerializer> serializerLocal = null;

    static {
        serializerLocal = new ThreadLocal();
        seperatorLocal = new ThreadLocal();
        COMMA = ',';
    }

    public BeforeFilter() {
    }

    public final char writeBefore(JSONSerializer r10, Object r11, char r12) {
        ThreadLocal<JSONSerializer> r13 = serializerLocal;
        r13.set(r10);
        ThreadLocal<Character> r14 = seperatorLocal;
        r14.set(Character.valueOf(r12));
        writeBefore(r11);
        r13.set(null);
        return r14.get().charValue();
    }

    public abstract void writeBefore(Object r10);

    public final void writeKeyValue(String r10, Object r11) {
        JSONSerializer r12 = serializerLocal.get();
        ThreadLocal<Character> r13 = seperatorLocal;
        char r14 = r13.get().charValue();
        r12.writeKeyValue(r14, r10, r11);
        if (r14 == ',') goto L6;
        r13.set(COMMA);
        return;
    }
}
