package com.media.cache.http;

import com.android.volley.toolbox.HttpClientStack;

/* JADX INFO: loaded from: classes3.dex */
public final enum Method extends Enum<Method> {
    private static final /* synthetic */ Method[] $VALUES = null;
    public static final Method CONNECT = null;
    public static final Method COPY = null;
    public static final Method DELETE = null;
    public static final Method GET = null;
    public static final Method HEAD = null;
    public static final Method LOCK = null;
    public static final Method MKCOL = null;
    public static final Method MOVE = null;
    public static final Method OPTIONS = null;
    public static final Method PATCH = null;
    public static final Method POST = null;
    public static final Method PROPFIND = null;
    public static final Method PROPPATCH = null;
    public static final Method PUT = null;
    public static final Method TRACE = null;
    public static final Method UNLOCK = null;

    static {
        Method r10 = new Method("GET", 0);
        GET = r10;
        Method r11 = new Method("PUT", 1);
        PUT = r11;
        Method r12 = new Method("POST", 2);
        POST = r12;
        Method r13 = new Method("DELETE", 3);
        DELETE = r13;
        Method r14 = new Method("HEAD", 4);
        HEAD = r14;
        Method r15 = new Method("OPTIONS", 5);
        OPTIONS = r15;
        Method r16 = new Method("TRACE", 6);
        TRACE = r16;
        Method r17 = new Method("CONNECT", 7);
        CONNECT = r17;
        Method r18 = new Method(HttpClientStack.HttpPatch.METHOD_NAME, 8);
        PATCH = r18;
        Method r19 = new Method("PROPFIND", 9);
        PROPFIND = r19;
        Method r110 = new Method("PROPPATCH", 10);
        PROPPATCH = r110;
        Method r111 = new Method("MKCOL", 11);
        MKCOL = r111;
        Method r112 = new Method("MOVE", 12);
        MOVE = r112;
        Method r113 = new Method("COPY", 13);
        COPY = r113;
        Method r114 = new Method("LOCK", 14);
        LOCK = r114;
        Method r115 = new Method("UNLOCK", 15);
        UNLOCK = r115;
        $VALUES = new Method[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115};
    }

    private Method(String r10, int r11) {
        super(r10, r11);
    }

    public static Method lookup(String r10) {
        if (r10 != null) goto L8;
        return null;
    L8:
        return valueOf(r10);
    L7:
        return null;
    }

    public static Method valueOf(String r10) {
        return (Method) Enum.valueOf(Method.class, r10);
    }

    public static Method[] values() {
        return (Method[]) $VALUES.clone();
    }
}
