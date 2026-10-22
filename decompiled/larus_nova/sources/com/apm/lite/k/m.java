package com.apm.lite.k;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f30003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f30004b;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f30005a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f30006b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f30007c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f30008d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f30009e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f30010f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ a[] f30011g = null;

        static {
            a r100 = new a("EMPTY_ARRAY", 0);
            f30005a = r100;
            a r101 = new a("NONEMPTY_ARRAY", 1);
            f30006b = r101;
            a r102 = new a("EMPTY_OBJECT", 2);
            f30007c = r102;
            a r103 = new a("DANGLING_KEY", 3);
            f30008d = r103;
            a r104 = new a("NONEMPTY_OBJECT", 4);
            f30009e = r104;
            a r105 = new a("NULL", 5);
            f30010f = r105;
            f30011g = new a[]{r100, r101, r102, r103, r104, r105};
        }

        public a(String r100, int r101) {
            super(r100, r101);
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        public static a[] values() {
            return (a[]) f30011g.clone();
        }
    }

    public m(Writer r100) {
        this.f30004b = new ArrayList();
        this.f30003a = r100;
    }

    public final void a(a r100) {
        List<a> r101 = this.f30004b;
        ListProtector.set(r101, ((ArrayList) r101).size() - 1, r100);
    }

    public final void b(Object r100) {
        if ((r100 instanceof JSONArray) == false) goto L7;
        c((JSONArray) r100);
        return;
    L7:
        if ((r100 instanceof JSONObject) == false) goto L10;
        d((JSONObject) r100);
        return;
    L10:
        g();
        if (r100 != null) goto L13;
    L23:
        this.f30003a.write("null");
        return;
    L13:
        if (r100 == JSONObject.NULL) goto L23;
        if ((r100 instanceof Boolean) == false) goto L19;
        Writer r101 = this.f30003a;
        String r102 = String.valueOf(r100);
    L21:
        r101.write(r102);
        return;
    L19:
        if ((r100 instanceof Number) == false) goto L22;
        r101 = this.f30003a;
        r102 = JSONObject.numberToString((Number) r100);
        goto L21
    L22:
        e(r100.toString());
    }

    public final void e(String r100) {
        this.f30003a.write("\"");
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L26;
        char r103 = r100.charAt(r102);
        if (r103 != '\f') goto L7;
        Writer r104 = this.f30003a;
        String r105 = "\\f";
    L20:
        r104.write(r105);
    L25:
        r102 = r102 + 1;
        goto L3
    L7:
        if (r103 != '\r') goto L9;
        r104 = this.f30003a;
        r105 = "\\r";
        goto L20
    L9:
        if (r103 != '\"') goto L11;
    L21:
        this.f30003a.write(92);
    L22:
        this.f30003a.write(r103);
        goto L25
    L11:
        if (r103 == '/') goto L21;
        if (r103 == '\\') goto L21;
        switch(r103) {
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L15;
        };
    L17:
        r104 = this.f30003a;
        r105 = "\\n";
        goto L20
    L18:
        r104 = this.f30003a;
        r105 = "\\t";
        goto L20
    L19:
        r104 = this.f30003a;
        r105 = "\\b";
        goto L20
    L15:
        if (r103 > 31) goto L22;
        this.f30003a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(r103)}));
        goto L25
    L26:
        this.f30003a.write("\"");
    }

    public final a f() {
        List<a> r100 = this.f30004b;
        return (a) ListProtector.get(r100, ((ArrayList) r100).size() - 1);
    }

    public final void g() {
        if (((ArrayList) this.f30004b).isEmpty() == false) goto L5;
        return;
    L5:
        a r100 = f();
        if (r100 != a.f30005a) goto L10;
        a r101 = a.f30006b;
    L8:
        a(r101);
        return;
    L10:
        if (r100 != a.f30006b) goto L13;
        this.f30003a.write(44);
        return;
    L13:
        if (r100 != a.f30008d) goto L16;
        this.f30003a.write(":");
        r101 = a.f30009e;
        goto L8
    L16:
        if (r100 != a.f30010f) goto L19;
        return;
    L19:
        throw new JSONException("Nesting problem");
    }

    public final String toString() {
        return "";
    }

    public final void c(JSONArray r100) {
        a r101 = a.f30005a;
        g();
        ((ArrayList) this.f30004b).add(r101);
        this.f30003a.write("[");
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L6;
        b(r100.get(r102));
        r102 = r102 + 1;
        goto L4
    L6:
        a r103 = a.f30005a;
        f();
        List<a> r104 = this.f30004b;
        ListProtector.remove(r104, ((ArrayList) r104).size() - 1);
        this.f30003a.write("]");
    }

    public final void d(JSONObject r100) {
        a r101 = a.f30007c;
        g();
        ((ArrayList) this.f30004b).add(r101);
        this.f30003a.write("{");
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        a r105 = f();
        if (r105 != a.f30009e) goto L9;
        this.f30003a.write(44);
    L10:
        a(a.f30008d);
        e(r103);
        b(r104);
        goto L4
    L9:
        if (r105 == a.f30007c) goto L10;
        throw new JSONException("Nesting problem");
    L13:
        a r106 = a.f30005a;
        f();
        List<a> r107 = this.f30004b;
        ListProtector.remove(r107, ((ArrayList) r107).size() - 1);
        this.f30003a.write(com.alipay.sdk.m.u.i.f25855d);
    }
}
