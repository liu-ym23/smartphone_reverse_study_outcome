package I6;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f3363a;

    /* renamed from: b, reason: collision with root package name */
    public String f3364b;

    /* renamed from: c, reason: collision with root package name */
    public String f3365c;

    /* renamed from: d, reason: collision with root package name */
    public String f3366d;

    /* renamed from: e, reason: collision with root package name */
    public String f3367e;

    /* renamed from: f, reason: collision with root package name */
    public String f3368f;

    /* renamed from: g, reason: collision with root package name */
    public String f3369g;

    /* renamed from: I6.a$a, reason: collision with other inner class name */
    public static class C0054a {

        /* renamed from: a, reason: collision with root package name */
        public String f3370a;

        /* renamed from: b, reason: collision with root package name */
        public String f3371b;

        /* renamed from: c, reason: collision with root package name */
        public String f3372c;

        /* renamed from: d, reason: collision with root package name */
        public String f3373d;

        /* renamed from: e, reason: collision with root package name */
        public String f3374e;

        /* renamed from: f, reason: collision with root package name */
        public String f3375f;

        /* renamed from: g, reason: collision with root package name */
        public String f3376g;

        public a a() {
            a aVar = new a();
            aVar.f3369g = this.f3376g;
            aVar.f3366d = this.f3373d;
            aVar.f3365c = this.f3372c;
            aVar.f3367e = this.f3374e;
            aVar.f3363a = this.f3370a;
            aVar.f3364b = this.f3371b;
            aVar.f3368f = this.f3375f;
            return aVar;
        }

        public C0054a b(String str) {
            this.f3376g = str;
            return this;
        }

        public C0054a c(String str) {
            this.f3373d = str;
            return this;
        }

        public C0054a d(String str) {
            this.f3374e = str;
            return this;
        }

        public C0054a e(String str) {
            this.f3372c = str;
            return this;
        }

        public C0054a f(String str) {
            this.f3370a = str;
            return this;
        }

        public C0054a g(String str) {
            this.f3371b = str;
            return this;
        }

        public C0054a h(String str) {
            this.f3375f = str;
            return this;
        }
    }

    public static C0054a i() {
        return new C0054a();
    }

    public Map<String, String> h() {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.f3363a)) {
            map.put("position_id", this.f3363a);
        }
        if (!TextUtils.isEmpty(this.f3364b)) {
            map.put("request_id", this.f3364b);
        }
        if (!TextUtils.isEmpty(this.f3365c)) {
            map.put("kw", this.f3365c);
        }
        if (!TextUtils.isEmpty(this.f3366d)) {
            map.put("biz", this.f3366d);
        }
        if (!TextUtils.isEmpty(this.f3367e)) {
            map.put("download_pkg", this.f3367e);
        }
        if (!TextUtils.isEmpty(this.f3368f)) {
            map.put("status", this.f3368f);
        }
        if (!TextUtils.isEmpty(this.f3369g)) {
            map.put("action", this.f3369g);
        }
        return map;
    }
}
