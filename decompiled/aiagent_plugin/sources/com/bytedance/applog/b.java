package com.bytedance.applog;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: AppLogHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f5511a;

    /* JADX INFO: compiled from: AppLogHelper.java */
    public interface a {
        boolean a(c r1);
    }

    static {
        f5511a = new AnonymousClass1();
    }

    public static boolean a(final String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (a(new AnonymousClass2(r1)) == false) goto L7;
        return true;
    }

    public static c b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        Iterator<c> r0 = c.a().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");
        if (r5.equals(r2.b()) == false) goto L7;
        return r2;
    L11:
        return null;
    }

    public static void a(String[] r5) {
        Iterator<c> r0 = c.a().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin")).a((String[]) ZeusTransformUtils.preCheckCast(r5.clone(), String[].class, "com.obric.aiagent.plugin"));
        goto L4
    }

    public static boolean a(a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        Iterator<c> r0 = c.a().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r5.a((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin")) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static boolean a(h r2) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        if (com.bytedance.applog.a.a() != r3) goto L5;
        return true;
    L5:
        return false;
    }

    public static String a(h r2, String r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        if (a(r4) == false) goto L6;
        return r3;
    L6:
        return r3 + "_" + r4.b();
    }
}
