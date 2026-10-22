package com.apm.insight.o;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedWriter f2194a;
    public final ArrayList b = new ArrayList();

    public a(BufferedWriter bufferedWriter) {
        this.f2194a = bufferedWriter;
    }

    public final void a(Object obj) throws JSONException, IOException {
        if (obj instanceof JSONArray) {
            b((JSONArray) obj);
            return;
        }
        if (obj instanceof JSONObject) {
            c((JSONObject) obj);
            return;
        }
        f();
        BufferedWriter bufferedWriter = this.f2194a;
        if (obj == null || obj == JSONObject.NULL) {
            bufferedWriter.write("null");
            return;
        }
        if (obj instanceof Boolean) {
            bufferedWriter.write(String.valueOf(obj));
        } else if (obj instanceof Number) {
            bufferedWriter.write(JSONObject.numberToString((Number) obj));
        } else {
            d(obj.toString());
        }
    }

    public final void b(JSONArray jSONArray) throws IOException {
        f();
        ArrayList arrayList = this.b;
        arrayList.add(n$a.f2195a);
        BufferedWriter bufferedWriter = this.f2194a;
        bufferedWriter.write("[");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(jSONArray.get(i));
        }
        e();
        arrayList.remove(arrayList.size() - 1);
        bufferedWriter.write("]");
    }

    public final void c(JSONObject jSONObject) throws JSONException, IOException {
        f();
        ArrayList arrayList = this.b;
        n$a n_a = n$a.c;
        arrayList.add(n_a);
        BufferedWriter bufferedWriter = this.f2194a;
        bufferedWriter.write("{");
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            n$a n_aE = e();
            if (n_aE == n$a.e) {
                bufferedWriter.write(44);
            } else if (n_aE != n_a) {
                throw new JSONException("Nesting problem");
            }
            arrayList.set(arrayList.size() - 1, n$a.d);
            d(next);
            a(obj);
        }
        e();
        arrayList.remove(arrayList.size() - 1);
        bufferedWriter.write("}");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0026. Please report as an issue. */
    public final void d(String str) throws IOException {
        String str2;
        BufferedWriter bufferedWriter = this.f2194a;
        bufferedWriter.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                str2 = "\\f";
            } else if (cCharAt != '\r') {
                if (cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                    bufferedWriter.write(92);
                } else {
                    switch (cCharAt) {
                        case '\b':
                            str2 = "\\b";
                            break;
                        case '\t':
                            str2 = "\\t";
                            break;
                        case '\n':
                            str2 = "\\n";
                            break;
                        default:
                            if (cCharAt <= 31) {
                                str2 = String.format("\\u%04x", Integer.valueOf(cCharAt));
                                break;
                            }
                            break;
                    }
                }
                bufferedWriter.write(cCharAt);
            } else {
                str2 = "\\r";
            }
            bufferedWriter.write(str2);
        }
        bufferedWriter.write("\"");
    }

    public final n$a e() {
        return (n$a) this.b.get(r1.size() - 1);
    }

    public final void f() throws IOException {
        ArrayList arrayList = this.b;
        if (arrayList.isEmpty()) {
            return;
        }
        n$a n_aE = e();
        n$a n_a = n$a.f2195a;
        n$a n_a2 = n$a.b;
        if (n_aE == n_a) {
            arrayList.set(arrayList.size() - 1, n_a2);
            return;
        }
        BufferedWriter bufferedWriter = this.f2194a;
        if (n_aE == n_a2) {
            bufferedWriter.write(44);
        } else if (n_aE == n$a.d) {
            bufferedWriter.write(":");
            arrayList.set(arrayList.size() - 1, n$a.e);
        } else if (n_aE != n$a.f) {
            throw new JSONException("Nesting problem");
        }
    }

    public final String toString() {
        return "";
    }
}
