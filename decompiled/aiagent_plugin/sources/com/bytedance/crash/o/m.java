package com.bytedance.crash.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSONWriter.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Writer f7663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f7664b;

    /* JADX INFO: compiled from: JSONWriter.java */
    static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7665a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7666b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f7667c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f7668d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f7669e = null;
        public static final a f = null;
        private static final /* synthetic */ a[] g = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(g.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("EMPTY_ARRAY", 0);
            f7665a = r0;
            a r1 = new a("NONEMPTY_ARRAY", 1);
            f7666b = r1;
            a r3 = new a("EMPTY_OBJECT", 2);
            f7667c = r3;
            a r5 = new a("DANGLING_KEY", 3);
            f7668d = r5;
            a r7 = new a("NONEMPTY_OBJECT", 4);
            f7669e = r7;
            a r9 = new a("NULL", 5);
            f = r9;
            g = new a[]{r0, r1, r3, r5, r7, r9};
        }
    }

    public String toString() {
        return "";
    }

    private m(Writer r2) {
        this.f7664b = new ArrayList();
        this.f7663a = r2;
    }

    private m a() {
        return a(a.f7665a, "[");
    }

    private m b() {
        return a(a.f7665a, a.f7666b, "]");
    }

    private m c() {
        return a(a.f7667c, "{");
    }

    private m d() {
        return a(a.f7667c, a.f7669e, "}");
    }

    private m a(a r2, String r3) {
        g();
        this.f7664b.add(r2);
        this.f7663a.write(r3);
        return this;
    }

    private m a(a r1, a r2, String r3) {
        e();
        List<a> r4 = this.f7664b;
        r4.remove(r4.size() - 1);
        this.f7663a.write(r3);
        return this;
    }

    private a e() {
        List<a> r2 = this.f7664b;
        return (a) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), a.class, "com.obric.aiagent.plugin");
    }

    private void a(a r2) {
        List<a> r1 = this.f7664b;
        r1.set(r1.size() - 1, r2);
    }

    private m a(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, JSONArray.class) == false) goto L7;
        a((JSONArray) ZeusTransformUtils.preCheckCast(r4, JSONArray.class, "com.obric.aiagent.plugin"));
        return this;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == false) goto L10;
        a((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.aiagent.plugin"));
        return this;
    L10:
        g();
        if (r4 != null) goto L13;
    L22:
        this.f7663a.write("null");
    L23:
        return this;
    L13:
        if (r4 == JSONObject.NULL) goto L22;
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L19;
        this.f7663a.write(String.valueOf(r4));
        goto L23
    L19:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L21;
        this.f7663a.write(JSONObject.numberToString((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")));
        goto L23
    L21:
        a(r4.toString());
        goto L23
    }

    private void a(String r8) {
        this.f7663a.write("\"");
        int r0 = r8.length();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L25;
        char r4 = r8.charAt(r3);
        if (r4 != '\f') goto L7;
        this.f7663a.write("\\f");
    L24:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4 != '\r') goto L9;
        this.f7663a.write("\\r");
        goto L24
    L9:
        if (r4 != '\"') goto L11;
    L21:
        this.f7663a.write(92);
        this.f7663a.write(r4);
        goto L24
    L11:
        if (r4 == '/') goto L21;
        if (r4 == '\\') goto L21;
        switch(r4) {
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            default: goto L15;
        };
    L18:
        this.f7663a.write("\\n");
        goto L24
    L19:
        this.f7663a.write("\\t");
        goto L24
    L20:
        this.f7663a.write("\\b");
        goto L24
    L15:
        if (r4 > 31) goto L17;
        this.f7663a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(r4)}));
        goto L24
    L17:
        this.f7663a.write(r4);
        goto L24
    L25:
        this.f7663a.write("\"");
    }

    private m b(String r1) {
        f();
        a(r1);
        return this;
    }

    private void f() {
        a r0 = e();
        if (r0 != a.f7669e) goto L6;
        this.f7663a.write(44);
    L7:
        a(a.f7668d);
        return;
    L6:
        if (r0 == a.f7667c) goto L7;
        throw new JSONException("Nesting problem");
    }

    private void g() {
        if (this.f7664b.isEmpty() == false) goto L5;
        return;
    L5:
        a r0 = e();
        if (r0 != a.f7665a) goto L9;
        a(a.f7666b);
        return;
    L9:
        if (r0 != a.f7666b) goto L12;
        this.f7663a.write(44);
        return;
    L12:
        if (r0 != a.f7668d) goto L15;
        this.f7663a.write(":");
        a(a.f7669e);
        return;
    L15:
        if (r0 != a.f) goto L18;
        return;
    L18:
        throw new JSONException("Nesting problem");
    }

    public static void a(JSONObject r1, Writer r2) {
        new m(r2).a(r1);
        r2.flush();
    }

    public static void a(JSONArray r1, Writer r2) {
        new m(r2).a(r1);
        r2.flush();
    }

    private void a(JSONObject r5) {
        c();
        Iterator<String> r0 = r5.keys();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        Object r2 = r5.get(r1);
        b(r1).a(r2);
        goto L4
    L6:
        d();
    }

    private void a(JSONArray r3) {
        a();
        int r0 = 0;
    L4:
        if (r0 >= r3.length()) goto L6;
        a(r3.get(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        b();
    }
}
