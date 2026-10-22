package com.bytedance.reparo.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: PatchConfiguration.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f9206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f9207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f9208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f9209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f9210e;
    private File f;
    private boolean g;
    private boolean h;

    public g(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        this.g = true;
        this.h = false;
        this.f9206a = r4;
    }

    public Application a() {
        return this.f9206a;
    }

    public File b() {
        if (this.f9207b != null) goto L6;
        this.f9207b = new File(this.f9206a.getFilesDir(), "reparo-root");
    L6:
        return this.f9207b;
    }

    public File a(File r2, com.bytedance.reparo.core.g.i r3) {
        return new File(a(r2), r3.f9240c);
    }

    private File a(File r2) {
        return new File(r2, "c");
    }

    public File a(File r2, String r3) {
        return new File(b(r2), r3);
    }

    private File b(File r2) {
        return new File(r2, DBHelper.BATTERY_COL_SOURCE);
    }

    public File b(File r3, String r4) {
        return new File(a(r3), "lib/" + r4);
    }

    public File c() {
        if (this.f9208c != null) goto L6;
        this.f9208c = new File(b(), "local-record.info");
    L6:
        return this.f9208c;
    }

    public File d() {
        if (this.f9209d != null) goto L6;
        this.f9209d = new File(b(), "public.lock");
    L6:
        return this.f9209d;
    }

    public File a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (this.f != null) goto L6;
        this.f = new File(r5.getFilesDir(), com.bytedance.reparo.core.i.i.a(r5) + "_init.info");
    L6:
        return this.f;
    }

    public File e() {
        if (this.f9210e != null) goto L6;
        this.f9210e = new File(b(), "install");
    L6:
        return this.f9210e;
    }

    public File a(n r2) {
        return new File(e(), r2.d());
    }

    public void a(boolean r1) {
        this.g = r1;
    }

    public boolean f() {
        return this.g;
    }

    public void b(boolean r1) {
        this.h = r1;
    }

    public boolean g() {
        return this.h;
    }
}
