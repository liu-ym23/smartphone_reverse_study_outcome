package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes28.dex */
public abstract class BeforeFilter implements SerializeFilter {
    private static final Character COMMA = null;
    private static final ThreadLocal<Character> seperatorLocal = null;
    private static final ThreadLocal<JSONSerializer> serializerLocal = null;

    public BeforeFilter() {
    }

    public abstract void writeBefore(Object r100);

    static {
        serializerLocal = new ThreadLocal();
        seperatorLocal = new ThreadLocal();
        COMMA = ',';
    }

    public final void writeKeyValue(String r100, Object r101) {
        JSONSerializer r102 = serializerLocal.get();
        ThreadLocal<Character> r103 = seperatorLocal;
        char r104 = r103.get().charValue();
        boolean r105 = r102.references.containsKey(r101);
        r102.writeKeyValue(r104, r100, r101);
        if (r105 == true) goto L6;
        r102.references.remove(r101);
    L6:
        if (r104 == ',') goto L9;
        r103.set(COMMA);
        return;
    }

    public final char writeBefore(JSONSerializer r100, Object r101, char r102) {
        ThreadLocal<JSONSerializer> r103 = serializerLocal;
        JSONSerializer r104 = r103.get();
        r103.set(r100);
        ThreadLocal<Character> r105 = seperatorLocal;
        r105.set(Character.valueOf(r102));
        writeBefore(r101);
        r103.set(r104);
        return r105.get().charValue();
    }
}
