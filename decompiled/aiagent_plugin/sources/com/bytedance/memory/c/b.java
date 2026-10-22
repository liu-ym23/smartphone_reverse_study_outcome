package com.bytedance.memory.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.memory.b.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: DumpFileProvider.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f8779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f8780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f8781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f8782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f8783e;
    private final File f;
    private final File g;
    private final File h;
    private final String i;

    public File a() {
        return this.f;
    }

    public File b() {
        return this.h;
    }

    public File c() {
        return this.f8783e;
    }

    public File d() {
        return this.g;
    }

    private b(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        this.f8780b = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        String r0 = com.bytedance.memory.a.a.c().a();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        this.i = new File(r0).getAbsolutePath();
    L6:
        String r1 = com.bytedance.apm.c.c();
        if (r1 == null) goto L9;
        this.g = new File(this.i + "/memorywidgets", r1);
        this.h = new File(this.i + "/memory", r1);
    L11:
        if (this.g.exists() == true) goto L14;
        this.g.mkdirs();
    L14:
        if (this.h.exists() == true) goto L16;
        this.h.mkdirs();
    L16:
        File r9 = new File(this.g, "cache");
        this.f8783e = r9;
        if (r9.exists() == true) goto L19;
        r9.mkdirs();
    L19:
        this.f8781c = new File(this.g, "festival.jpg");
        this.f8782d = new File(this.g, "festival.jpg.heap");
        File r10 = new File(this.g, "shrink");
        this.f = r10;
        if (r10.exists() == true) goto L22;
        r10.mkdirs();
    L22:
        k();
        return;
    L9:
        this.g = new File(this.i + "/memorywidgets", r8.getPackageName());
        this.h = new File(this.i + "/memory", r8.getPackageName());
        goto L11
    L5:
        this.i = r8.getExternalFilesDir(null).getParentFile().getAbsolutePath();
        goto L6
    }

    private void k() {
        d.a(new File(this.i, "memorywidget"));     // Catch: Exception -> L4
        return;
    }

    public boolean e() {
        return new File(this.g, "festival.jpg.heap").exists();
    }

    public File f() {
        return this.f8782d;
    }

    public File g() {
        return this.f8781c;
    }

    public void h() {
        if (this.f8781c.exists() == false) goto L6;
        this.f8781c.delete();
        return;
    }

    public static b i() {
        if (f8779a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8779a != null) goto L9;
        f8779a = new b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.memory.a.a.c().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f8779a;
    }

    public File j() {
        return this.f8781c;
    }
}
