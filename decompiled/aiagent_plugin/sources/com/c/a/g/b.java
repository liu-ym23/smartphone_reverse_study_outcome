package com.c.a.g;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CommandResultUploader.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Boolean> f11934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile File f11935b;

    /* JADX INFO: compiled from: CommandResultUploader.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f11937a = null;

        static /* synthetic */ b a() {
            return f11937a;
        }

        static {
            f11937a = new b();
        }
    }

    public b() {
        this.f11934a = new HashMap();
    }

    public static b a() {
        return a.a();
    }

    public File b() {
        if (this.f11935b == null) goto L5;
    L9:
        c();
        return this.f11935b;
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L7;
        this.f11935b = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir(), "cloud_uploading");
        goto L9
    L7:
        return null;
    }

    public boolean a(String r1) {
        if (this.f11934a.get(r1) != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    public synchronized void a(com.c.a.c.a r11, File r12, String r13) {
        monitor-enter(this);
        com.c.a.g.a.a("命令产物已生成，等待上传", r11);     // Catch: Throwable -> L38
        c();     // Catch: Throwable -> L38
        String r0 = r11.d();     // Catch: Throwable -> L38
        File r1 = b();     // Catch: Throwable -> L38
        if (r1 == null) goto L37;
        File r2 = new File(r1, r0);     // Catch: Throwable -> L38
        if (r2.exists() == false) goto L8;
        com.c.a.i.b.b(r2);     // Catch: Throwable -> L38
    L8:
        r12.renameTo(r2);     // Catch: Throwable -> L38
        long r3 = com.bytedance.apm.util.b.b(r2);     // Catch: Throwable -> L38
        boolean r4 = true;
        if (r11.c() == true) goto L11;
    L13:
        boolean r14 = false;
    L14:
        this.f11934a.put(r0, Boolean.valueOf(r14));     // Catch: Throwable -> L38
        if (r14 == true) goto L17;
    L21:
        File[] r15 = r2.listFiles(new AnonymousClass1(this));     // Catch: Throwable -> L38
        int r5 = r15.length;     // Catch: Throwable -> L38
        int r6 = 0;
    L22:
        if (r6 >= r5) goto L31;
        File r7 = r15[r6];     // Catch: Throwable -> L38
        boolean r8 = com.c.a.g.a.a(r0, r7, r13, "正在上传:" + r7.getName());     // Catch: Throwable -> L38
        StringBuilder r9 = new StringBuilder().append("文件上传");     // Catch: Throwable -> L38
        if (r8 == false) goto L26;
        String r10 = "成功";
    L27:
        com.c.a.g.a.a(r9.append(r10).append(":").append(r7.getName()).toString(), r11);     // Catch: Throwable -> L38
        if (r8 == true) goto L30;
        r4 = false;
    L30:
        r6 = r6 + 1;     // Catch: Throwable -> L38
        goto L22
    L26:
        r10 = "失败";
        goto L27
    L31:
        if (r4 == false) goto L33;
        com.c.a.g.a.a(r0);     // Catch: Throwable -> L38
    L33:
        com.c.a.i.b.b(r2);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L17:
        if (com.c.a.i.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L21;
        com.c.a.g.a.a("产物超过阈值，等待WiFi环境执行. fileTotalSize=" + r3, r11);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L11:
        if (r3 <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) goto L13;
        r14 = true;
        goto L14
    L37:
        throw new com.c.a.c.b("pending目录因拿不到context而未设置");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }

    private void c() {
        if (this.f11935b != null) goto L5;
        return;
    L5:
        if (this.f11935b.exists() == true) goto L9;
        this.f11935b.mkdirs();
        return;
    }
}
