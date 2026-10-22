package com.bytedance.applog.k;

import android.content.Context;
import com.bytedance.applog.c;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.q;
import com.bytedance.applog.util.g;
import com.bytedance.bdinstall.ar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApiParamsUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f5694a;

    public b(c r1) {
        this.f5694a = r1;
    }

    public String[] a(Engine r2, boolean r3, com.bytedance.applog.priority.b r4) {
        q r0 = r2.getUriConfig();
        if (r3 == false) goto L5;
        String[] r5 = r0.d();
    L6:
        if (r4 == null) goto L13;
        String[] r6 = r4.a(r5, "/service/2/app_log/");
        if (r6 == null) goto L13;
        if (r6.length <= 0) goto L13;
        r5 = r6;
    L13:
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    L5:
        r5 = r0.c();
        goto L6
    }

    public String[] a(Context r5, String[] r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        int r0 = r6.length;
        String[] r1 = new String[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = a(r7, r6[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public String a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (this.f5694a.k() == false) goto L6;
        r4 = r4 + "?tt_data=a";
    L6:
        return a.a(this.f5694a.a(r5, r4, true, ar.f6145b), g.f6036a);
    }
}
