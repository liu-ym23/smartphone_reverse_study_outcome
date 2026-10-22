package com.bytedance.crash.g;

import android.os.Message;
import com.bytedance.apm.block.j;
import com.bytedance.apm.block.k;
import com.bytedance.crash.o.i;
import com.bytedance.crash.o.l;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: LooperMessageRecorder.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d f7485b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f7486a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7487c;

    public d() {
        this.f7486a = new b();
    }

    static {
        f7485b = new d();
    }

    public static d a() {
        return f7485b;
    }

    public synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f7487c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f7487c = true;     // Catch: Throwable -> L11
        this.f7486a.a();     // Catch: Throwable -> L11
        k.a(null);     // Catch: Throwable -> L11
        k.a(this);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void c() {
        this.f7487c = false;
        this.f7486a.b();
        k.b(this);
    }

    @Override // com.bytedance.apm.block.j
    public void a(String r1) {
        this.f7486a.a(null);
    }

    @Override // com.bytedance.apm.block.j
    public void a(String r1, Message r2) {
        this.f7486a.a(r2);
    }

    public void a(File r1) {
        this.f7486a.a(r1);
    }

    public static void a(JSONObject r1, File r2) {
        b(r1, a.a(r2));
        b(r1, a.b(r2));
        b(r1, a.c(r2));
        b(r1, a.d(r2));
    }

    private static void b(JSONObject r1, File r2) {
        String r3 = i.d(r2);     // Catch: Exception -> L6
        if (r3 == null) goto L9;
        l.b(r1, new JSONObject(r3));     // Catch: Exception -> L6
        return;
    L9:
        return;
    }
}
