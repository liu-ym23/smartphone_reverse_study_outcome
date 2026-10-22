package com.alibaba.fastjson.serializer;

import java.util.IdentityHashMap;

/* JADX INFO: loaded from: classes28.dex */
public abstract class AfterFilter implements SerializeFilter {
    private static final Character COMMA = null;
    private static final ThreadLocal<Character> seperatorLocal = null;
    private static final ThreadLocal<JSONSerializer> serializerLocal = null;

    public AfterFilter() {
    }

    public abstract void writeAfter(Object r100);

    static {
        serializerLocal = new ThreadLocal();
        seperatorLocal = new ThreadLocal();
        COMMA = ',';
    }

    public final void writeKeyValue(String r100, Object r101) {
        JSONSerializer r102 = serializerLocal.get();
        ThreadLocal<Character> r103 = seperatorLocal;
        char r104 = r103.get().charValue();
        boolean r105 = r102.containsReference(r101);
        r102.writeKeyValue(r104, r100, r101);
        if (r105 == true) goto L8;
        IdentityHashMap<Object, SerialContext> r106 = r102.references;
        if (r106 == null) goto L8;
        r106.remove(r101);
    L8:
        if (r104 == ',') goto L11;
        r103.set(COMMA);
        return;
    }

    public final char writeAfter(JSONSerializer r100, Object r101, char r102) {
        ThreadLocal<JSONSerializer> r103 = serializerLocal;
        JSONSerializer r104 = r103.get();
        r103.set(r100);
        ThreadLocal<Character> r105 = seperatorLocal;
        r105.set(Character.valueOf(r102));
        writeAfter(r101);
        r103.set(r104);
        return r105.get().charValue();
    }
}
