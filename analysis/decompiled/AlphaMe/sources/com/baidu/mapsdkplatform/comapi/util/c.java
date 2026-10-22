package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import com.alibaba.fastjson.util.UTF8Decoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f8196a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    private static int f8197b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static int f8198c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f8199d;

    /* renamed from: e, reason: collision with root package name */
    private int f8200e;

    /* renamed from: f, reason: collision with root package name */
    private Context f8201f;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8202a;

        public a(String str) {
            this.f8202a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int unused = c.f8197b = c.this.f8201f.getSharedPreferences("ad_auth", 0).getInt(this.f8202a, 0);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8204a;

        public b(String str) {
            this.f8204a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int unused = c.f8198c = c.this.f8201f.getSharedPreferences("ad_auth", 0).getInt(this.f8204a, 0);
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.util.c$c, reason: collision with other inner class name */
    public class RunnableC0032c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8206a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8207b;

        public RunnableC0032c(String str, int i4) {
            this.f8206a = str;
            this.f8207b = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f8201f.getSharedPreferences("ad_auth", 0).edit().putInt(this.f8206a, this.f8207b).apply();
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8209a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8210b;

        public d(String str, int i4) {
            this.f8209a = str;
            this.f8210b = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f8201f.getSharedPreferences("ad_auth", 0).edit().putInt(this.f8209a, this.f8210b).apply();
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final c f8212a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public void c(int i4) {
        if (i4 == -1 && (i4 = a("ad_key")) == -101) {
            return;
        }
        this.f8199d = i4;
        a("ad_key", i4);
    }

    public void d(int i4) {
        if (i4 == -1 && (i4 = b("ad_key_user")) == -101) {
            return;
        }
        this.f8200e = i4;
        b("ad_key_user", i4);
    }

    public boolean e() {
        int i4 = this.f8199d;
        return i4 >= 0 && (i4 & UTF8Decoder.Surrogate.UCS4_MIN) == 65536;
    }

    public boolean f() {
        int i4 = this.f8199d;
        return i4 >= 0 && (i4 & 1073741824) == 1073741824;
    }

    public boolean g() {
        int i4 = this.f8199d;
        return i4 >= 0 && (i4 & 1) == 1;
    }

    public boolean h() {
        int i4 = this.f8200e;
        return i4 >= 0 && (i4 & SQLiteDatabase.CREATE_IF_NECESSARY) == 268435456;
    }

    public boolean i() {
        int i4 = this.f8199d;
        return i4 >= 0 && (i4 & 1024) == 1024;
    }

    private c() {
    }

    private int b(String str) {
        if (this.f8201f == null) {
            return -101;
        }
        if (f8198c == -1) {
            f8196a.execute(new b(str));
        }
        return f8198c;
    }

    public static c a() {
        return e.f8212a;
    }

    public void a(Context context) {
        this.f8201f = context;
    }

    public boolean c() {
        int i4 = this.f8199d;
        return i4 >= 0 && (i4 & 67108864) == 67108864;
    }

    public boolean d() {
        int i4 = this.f8199d;
        return i4 >= 0 && (i4 & 134217728) == 134217728;
    }

    private int a(String str) {
        if (this.f8201f == null) {
            return -101;
        }
        if (f8197b == -1) {
            f8196a.execute(new a(str));
        }
        return f8197b;
    }

    private void b(String str, int i4) {
        if (this.f8201f == null) {
            return;
        }
        f8198c = i4;
        f8196a.execute(new d(str, i4));
    }

    private void a(String str, int i4) {
        if (this.f8201f == null) {
            return;
        }
        f8197b = i4;
        f8196a.execute(new RunnableC0032c(str, i4));
    }

    public boolean b() {
        int i4 = this.f8199d;
        return i4 >= 0 && (i4 & 33554432) == 33554432;
    }
}
