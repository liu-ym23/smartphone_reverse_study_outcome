package com.networknt.schema.path;

import A3.b;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
public enum PathType {
    LEGACY("$", new b(0), new b(1)),
    JSON_PATH("$", new b(2), new b(3)),
    JSON_POINTER("", new b(4), new b(5)),
    URI_REFERENCE("", new b(6), new b(7));


    /* renamed from: a, reason: collision with root package name */
    public final String f3055a;
    public final BiConsumer b;
    public final BiConsumer c;

    PathType(String str, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.f3055a = str;
        this.b = biConsumer;
        this.c = biConsumer2;
    }

    public static String a(String str) {
        if (str.indexOf(10) != -1) {
            str = str.replace("\n", "\\n");
        }
        if (str.indexOf(9) != -1) {
            str = str.replace("\t", "\\t");
        }
        if (str.indexOf(13) != -1) {
            str = str.replace("\r", "\\r");
        }
        if (str.indexOf(8) != -1) {
            str = str.replace("\b", "\\b");
        }
        return str.indexOf(12) != -1 ? str.replace("\f", "\\f") : str;
    }
}
