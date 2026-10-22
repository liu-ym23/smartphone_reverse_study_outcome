package com.amap.api.col.jmsl;

import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;

/* renamed from: com.amap.api.col.jmsl.j2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1569j2 {

    /* renamed from: a, reason: collision with root package name */
    public String f16681a;

    /* renamed from: b, reason: collision with root package name */
    public String f16682b;

    /* renamed from: c, reason: collision with root package name */
    public int f16683c;

    /* renamed from: d, reason: collision with root package name */
    public String f16684d;

    /* renamed from: e, reason: collision with root package name */
    public String f16685e;

    /* renamed from: f, reason: collision with root package name */
    public String f16686f;

    /* renamed from: g, reason: collision with root package name */
    public String f16687g;

    /* renamed from: h, reason: collision with root package name */
    public String f16688h;

    /* renamed from: i, reason: collision with root package name */
    public String f16689i;

    /* renamed from: j, reason: collision with root package name */
    public String f16690j;

    /* renamed from: k, reason: collision with root package name */
    public String f16691k;

    /* renamed from: l, reason: collision with root package name */
    public String[] f16692l;

    /* renamed from: com.amap.api.col.jmsl.j2$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f16693a;

        /* renamed from: b, reason: collision with root package name */
        public String f16694b;

        /* renamed from: c, reason: collision with root package name */
        public String f16695c;

        /* renamed from: d, reason: collision with root package name */
        public String f16696d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f16697e = true;

        /* renamed from: f, reason: collision with root package name */
        public String[] f16698f = null;

        public a(String str, String str2, String str3) {
            this.f16693a = str2;
            this.f16694b = str2;
            this.f16696d = str3;
            this.f16695c = str;
        }

        public static /* synthetic */ String j(a aVar) {
            aVar.getClass();
            return "standard";
        }

        public a a(String str) {
            this.f16694b = str;
            return this;
        }

        public a b(boolean z10) {
            this.f16697e = z10;
            return this;
        }

        public a c(String[] strArr) {
            if (strArr != null) {
                this.f16698f = (String[]) strArr.clone();
            }
            return this;
        }

        public C1569j2 d() throws g5 {
            if (this.f16698f != null) {
                return new C1569j2(this, (byte) 0);
            }
            throw new g5("sdk packages is null");
        }
    }

    public /* synthetic */ C1569j2(a aVar, byte b10) {
        this(aVar);
    }

    public static String b(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            for (String str : strArr) {
                sb2.append(str);
                sb2.append(Const.STR_MART_SEMICOLON);
            }
            return sb2.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f16691k) && !TextUtils.isEmpty(this.f16686f)) {
            this.f16691k = C1604s2.m(this.f16686f);
        }
        if (TextUtils.isEmpty(this.f16691k)) {
            this.f16691k = "standard";
        }
        return this.f16691k;
    }

    public void c(boolean z10) {
        this.f16683c = z10 ? 1 : 0;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f16688h) && !TextUtils.isEmpty(this.f16682b)) {
            this.f16688h = C1604s2.m(this.f16682b);
        }
        return this.f16688h;
    }

    public String[] e() {
        String[] strArrSplit;
        String[] strArr = this.f16692l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f16685e)) {
            try {
                strArrSplit = C1604s2.m(this.f16685e).split(Const.STR_MART_SEMICOLON);
            } catch (Throwable th) {
                th.printStackTrace();
                strArrSplit = null;
            }
            this.f16692l = strArrSplit;
        }
        return (String[]) this.f16692l.clone();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (C1569j2.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.f16690j.equals(((C1569j2) obj).f16690j) && this.f16687g.equals(((C1569j2) obj).f16687g)) {
                if (this.f16688h.equals(((C1569j2) obj).f16688h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public String f() {
        if (TextUtils.isEmpty(this.f16689i) && !TextUtils.isEmpty(this.f16684d)) {
            this.f16689i = C1604s2.m(this.f16684d);
        }
        return this.f16689i;
    }

    public String g() {
        if (TextUtils.isEmpty(this.f16690j) && !TextUtils.isEmpty(this.f16681a)) {
            this.f16690j = C1604s2.m(this.f16681a);
        }
        return this.f16690j;
    }

    public String h() {
        return this.f16687g;
    }

    public boolean i() {
        return this.f16683c == 1;
    }

    public C1569j2() {
        this.f16683c = 1;
        this.f16692l = null;
    }

    public C1569j2(a aVar) {
        this.f16683c = 1;
        this.f16692l = null;
        this.f16687g = aVar.f16693a;
        this.f16688h = aVar.f16694b;
        this.f16690j = aVar.f16695c;
        this.f16689i = aVar.f16696d;
        this.f16683c = aVar.f16697e ? 1 : 0;
        a.j(aVar);
        this.f16691k = "standard";
        this.f16692l = aVar.f16698f;
        this.f16682b = C1604s2.v(this.f16688h);
        this.f16681a = C1604s2.v(this.f16690j);
        this.f16684d = C1604s2.v(this.f16689i);
        this.f16685e = C1604s2.v(b(this.f16692l));
        this.f16686f = C1604s2.v(this.f16691k);
    }
}
