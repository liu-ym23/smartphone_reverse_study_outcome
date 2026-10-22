package com.ss.android.common.applog.task;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.common.applog.TeaThread;
import com.ss.android.common.applog.ab;
import com.ss.android.common.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TaskModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37211a;

    static /* synthetic */ d a(b r0) {
        return r0.b();
    }

    b(Context r3) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f37211a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        ab.a(r5);
        TeaThread.getInst().ensureTeaThreadLite(new AnonymousClass1(this));
    }

    private d b() {
        return d.a(this.f37211a.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).getString("key_task_session", ""));
    }

    public void a(d r1) {
        ab.a(this.f37211a).a(r1);
    }

    public void b(d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        f.a.c("saveTaskSessionToSp : " + r3);
        a(r3.e());
    }

    private void a(String r3) {
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        SharedPreferences.Editor r2 = this.f37211a.getSharedPreferences(com.ss.android.deviceregister.base.b.a(), 0).edit();     // Catch: Throwable -> L6
        r2.putString("key_task_session", r3);     // Catch: Throwable -> L6
        r2.apply();     // Catch: Throwable -> L6
        return;
    }

    public void a() {
        f.a.c("clear task session sp");
        a("");
    }
}
