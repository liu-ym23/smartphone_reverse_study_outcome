package com.bytedance.crash.dumper.a;

/* JADX INFO: compiled from: JsonDumper.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends i {
    public f(String r1) {
        super(r1);
    }

    public f a() {
        a('{');
        return this;
    }

    public f b() {
        a('}');
        return this;
    }

    public f c() {
        a('[');
        return this;
    }

    public f d() {
        a(']');
        return this;
    }

    public f e() {
        a(',');
        return this;
    }

    public f a(String r3) {
        a('\"').c(r3).a('\"').a(':').a(' ');
        return this;
    }

    public f a(boolean r1) {
        b(r1);
        return this;
    }

    public f a(long r1) {
        b(r1);
        return this;
    }

    public f a(int r1) {
        b(r1);
        return this;
    }

    public f b(String r9) {
        a('\"');
        if (r9 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L32;
        char r4 = r9.charAt(r3);
        if (r4 != '\f') goto L11;
        c("\\f");
    L31:
        r3 = r3 + 1;
        goto L7
    L11:
        if (r4 != '\r') goto L13;
        c("\\r");
        goto L31
    L13:
        if (r4 == '\"') goto L28;
        if (r4 == '\\') goto L28;
        if (r4 != 8232) goto L18;
    L27:
        c(String.format("\\u%04x", new Object[]{Integer.valueOf(r4)}));
        goto L31
    L18:
        if (r4 == 8233) goto L27;
        switch(r4) {
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L24;
            default: goto L21;
        };
    L24:
        c("\\n");
        goto L31
    L25:
        c("\\t");
        goto L31
    L26:
        c("\\b");
        goto L31
    L21:
        if (r4 > 31) goto L23;
        c(String.format("\\u%04x", new Object[]{Integer.valueOf(r4)}));
        goto L31
    L23:
        a(r4);
    L28:
        a('\\');
        a(r4);
        goto L31
    L32:
        a('\"');
        return this;
    L5:
        r2 = r9.length();
        goto L6
    }
}
