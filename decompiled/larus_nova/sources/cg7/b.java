package cg7;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import xf7.m;
import yf7.j;
import yf7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f23674e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f23675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f23676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0444b f23677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<n> f23678d;

    public static class a extends xf7.n<b> {
        public a() {
        }

        @Override // xf7.n
        public final b a(Object[] r100) {
            return new b((Context) r100[0]);
        }
    }

    /* JADX INFO: renamed from: cg7.b$b, reason: collision with other inner class name */
    public class C0444b extends xf7.n<SharedPreferences> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f23679b;

        public C0444b(b r100) {
            this.f23679b = r100;
        }

        @Override // xf7.n
        public final SharedPreferences a(Object[] r100) {
            return this.f23679b.f23675a.getSharedPreferences("byte_sync_settings", 0);
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public class c extends xf7.n<cg7.a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f23680b;

        public c(b r100) {
            this.f23680b = r100;
        }

        @Override // xf7.n
        public final cg7.a a(Object[] r100) {
            SharedPreferences r101 = this.f23680b.f23677c.b(new Object[0]);
            String r102 = null;
            if (r101 == null) goto L5;
            r102 = r101.getString("server_settings", null);
        L5:
            if (r102 == null) goto L14;
            return (cg7.a) new Gson().fromJson(r102, cg7.a.class);
        L9:
            th = move-exception;
            th.printStackTrace();
            return new cg7.a();
        L14:
            return new cg7.a();
        }
    }

    static {
        f23674e = new a();
    }

    public final cg7.a b() {
        return this.f23676b.b(new Object[0]);
    }

    public b(Context r100) {
        this.f23676b = new c(this);
        C0444b r101 = new C0444b(this);
        this.f23677c = r101;
        this.f23678d = new ArrayList();
        this.f23675a = r100;
        r101.b(new Object[0]);
    }

    public static b c(Context r100) {
        return f23674e.b(new Object[]{r100});
    }

    @Override // yf7.n
    public final void a(j.a r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = null;
        byte[] r102 = r100.f567450a;     // Catch: Exception -> L26
        if (r102 != null) goto L10;
        m.c().b(null, "data is null");     // Catch: Exception -> L26
        return;
    L10:
        String r103 = new String(r102);     // Catch: Exception -> L26
        new JSONObject(r103);     // Catch: Exception -> L24
        zf7.b.a("update local settings : ".concat(r103));     // Catch: Exception -> L24
        int r104 = 0;
        SharedPreferences r105 = this.f23677c.b(new Object[0]);     // Catch: Exception -> L24
        if (r105 == null) goto L14;
        r105.edit().putString("server_settings", r103).apply();     // Catch: Exception -> L24
    L14:
        this.f23676b = new c(this);     // Catch: Exception -> L24
        List<n> r106 = this.f23678d;     // Catch: Exception -> L24
        monitor-enter(r106);     // Catch: Exception -> L24
        int r107 = ((ArrayList) this.f23678d).size();     // Catch: Throwable -> L21
        n[] r108 = new n[r107];     // Catch: Throwable -> L21
        ((ArrayList) this.f23678d).toArray(r108);     // Catch: Throwable -> L21
    L17:
        if (r104 >= r107) goto L19;
        r108[r104].a(r100);     // Catch: Throwable -> L21
        r104 = r104 + 1;     // Catch: Throwable -> L21
        goto L17
    L19:
        monitor-exit(r106);     // Catch: Throwable -> L21
    L34:
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Exception -> L24
    L24:
        e = e;
        r101 = r103;
    L27:
        e.printStackTrace();
        m.c().b(r101, Log.getStackTraceString(e));
        return;
    L26:
        e = e;
        goto L27
    }

    public final void d(n r100) {
        List<n> r101 = this.f23678d;
        monitor-enter(r101);
        ((ArrayList) this.f23678d).remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
