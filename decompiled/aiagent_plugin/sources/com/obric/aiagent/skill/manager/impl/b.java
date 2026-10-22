package com.obric.aiagent.skill.manager.impl;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: AndroidPrivateSkillFileStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f19539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f19540b;

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        Context r5 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f19539a = r5;
        dv r0 = dv.f19775a;
        d.h.b.o.c(r5, "appContext");
        this.f19540b = r0.a(r5);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public void a(File r1, File r2) {
        ca.a.a(this, r1, r2);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public void a(File r3, File r4, boolean r5, d.h.a.a<d.x> r6) {
        ca.a.a(this, r3, r4, r5, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public boolean a(File r1) {
        return ca.a.a(this, r1);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public boolean b(File r1) {
        return ca.a.b(this, r1);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public boolean c(File r1) {
        return ca.a.c(this, r1);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public boolean d(File r1) {
        return ca.a.d(this, r1);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public List<File> e(File r1) {
        return ca.a.e(this, r1);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public String f(File r1) {
        return ca.a.f(this, r1);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public boolean g(File r1) {
        return ca.a.g(this, r1);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public File a() {
        File r0 = this.f19540b;
        r0.mkdirs();
        return r0;
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public File b() {
        File r0 = new File(a(), "skills");
        r0.mkdirs();
        return r0;
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public File a(String r2) {
        d.h.b.o.e(r2, "slug");
        return new File(b(), r2);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public File b(String r2) {
        d.h.b.o.e(r2, "slug");
        return new File(a(r2), ".versions");
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public void a(File r2, String r3) {
        d.h.b.o.e(r2, "file");
        d.h.b.o.e(r3, "content");
        File r1 = r2.getParentFile();
        if (r1 == null) goto L5;
        r1.mkdirs();
    L5:
        d.f.k.a(r2, r3, null, 2, null);
    }

    @Override // com.obric.aiagent.skill.manager.impl.ca
    public void a(File r7, File r8, boolean r9) {
        d.h.b.o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r8, "target");
        File r6 = r8.getParentFile();
        if (r6 == null) goto L5;
        r6.mkdirs();
    L5:
        d.f.k.a(r7, r8, r9, null, 4, null);
    }
}
