package com.bytedance.bdinstall.d;

import android.content.Context;
import android.os.Environment;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: DeprecatedFileCleaner.java */
/* JADX INFO: loaded from: classes.dex */
final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final an f6223a;

    public k(an r1) {
        this.f6223a = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList r2 = new ArrayList();
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        if (this.f6223a.F() == false) goto L34;
    L21:
        Iterator r7 = r2.iterator();
    L23:
        if (r7.hasNext() == false) goto L29;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        com.bytedance.common.utility.c.b.a(r0);     // Catch: Throwable -> L27
        com.bytedance.bdinstall.t.b("dt " + r0);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L29:
        return;
    L34:
        r2.add(Environment.getExternalStorageDirectory().getPath() + com.bytedance.bdinstall.j.s.a("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));     // Catch: Throwable -> L15
    L30:
        r2.add(Environment.getExternalStorageDirectory().getPath() + "/" + com.bytedance.bdinstall.j.s.a());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L30
    L4:
        if (this.f6223a.F() == false) goto L6;
        String r3 = "device_id";
    L7:
        r2.add(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6223a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getExternalCacheDir().getParent() + "/" + r3);     // Catch: Throwable -> L9
        goto L12
    L6:
        r3 = com.bytedance.bdinstall.j.s.a();     // Catch: Throwable -> L9
        goto L7
    }
}
