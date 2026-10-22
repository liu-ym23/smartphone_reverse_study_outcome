package com.baidu.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.b.e.a;
import com.baidu.b.h;
import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Comparator f4736a = new com.baidu.b.b.b();

    /* renamed from: b, reason: collision with root package name */
    protected C0005a f4737b;

    /* renamed from: c, reason: collision with root package name */
    protected a.C0007a f4738c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4739d;

    /* renamed from: e, reason: collision with root package name */
    private long f4740e;

    /* renamed from: com.baidu.b.b.a$a, reason: collision with other inner class name */
    public static class C0005a {

        /* renamed from: a, reason: collision with root package name */
        public Context f4741a;

        /* renamed from: b, reason: collision with root package name */
        public com.baidu.b.e.a f4742b;
    }

    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private a.C0007a f4743a;

        /* renamed from: b, reason: collision with root package name */
        private String f4744b;

        /* renamed from: c, reason: collision with root package name */
        private String f4745c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f4746d = true;

        public b(a.C0007a c0007a, String str) {
            this.f4743a = c0007a;
            this.f4744b = str;
            this.f4745c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject) throws JSONException;

        public void a(boolean z4) {
            this.f4746d = z4;
        }

        public abstract void b(JSONObject jSONObject) throws JSONException;

        public boolean b() {
            if (this.f4746d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    b(jSONObject);
                    this.f4743a.a(this.f4745c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean a() {
            String strA = this.f4743a.a(this.f4745c, true);
            if (!TextUtils.isEmpty(strA)) {
                try {
                    a(new JSONObject(strA));
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public static class c {
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4747a;
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public h.a f4748a;

        /* renamed from: b, reason: collision with root package name */
        public int f4749b;

        /* renamed from: c, reason: collision with root package name */
        public Exception f4750c;

        public e(int i4, h.a aVar, Exception exc) {
            this.f4749b = i4;
            this.f4748a = aVar;
            this.f4750c = exc;
        }

        public static e a() {
            return new e(-1, null, null);
        }

        public boolean b() {
            return this.f4749b == 0;
        }

        public static e a(int i4) {
            return new e(i4, null, null);
        }

        public static e a(h.a aVar) {
            return new e(0, aVar, null);
        }
    }

    public a(String str, long j4) {
        this.f4739d = str;
        this.f4740e = j4;
    }

    public abstract e a(String str, d dVar);

    public String a() {
        return this.f4739d;
    }

    public abstract void a(c cVar);

    public long b() {
        return this.f4740e;
    }

    public final void a(C0005a c0005a) {
        this.f4737b = c0005a;
        this.f4738c = c0005a.f4742b.b().a("cs");
    }
}
