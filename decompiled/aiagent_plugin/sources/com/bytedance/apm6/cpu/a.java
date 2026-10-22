package com.bytedance.apm6.cpu;

import android.text.TextUtils;
import com.bytedance.apm6.util.f;
import com.bytedance.common.utility.i;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: ApmCpuManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f5181b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f5182a;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApmCpuManager.java */
    public interface InterfaceC0127a {
        void a(double r1, double r3, String r5, com.bytedance.watson.assist.a.c.a r6, i.b r7);
    }

    /* JADX INFO: compiled from: ApmCpuManager.java */
    public interface b {
        boolean a();
    }

    /* JADX INFO: compiled from: ApmCpuManager.java */
    public interface c {
        void a(double r1);
    }

    private a() {
        this.f5182a = new CopyOnWriteArraySet();
    }

    public static a a() {
        if (f5181b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5181b != null) goto L9;
        f5181b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5181b;
    }

    public String b() {
        String r1 = f.a(this.f5182a.toArray(), "#");
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        return "";
    }

    public CopyOnWriteArraySet<String> c() {
        return this.f5182a;
    }
}
