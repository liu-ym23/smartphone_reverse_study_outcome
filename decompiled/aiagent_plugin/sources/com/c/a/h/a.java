package com.c.a.h;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.c;
import com.bytedance.apm.h.e;
import com.c.a.h.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: CloudMessageUploadManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ArrayList<com.c.a.h.b.a> f11938a;

    static {
        f11938a = new ArrayList();
    }

    public static void a(com.c.a.h.b.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.b() != null) goto L6;
        return;
    L6:
        if (r3.b().c().size() != 0) goto L9;
        return;
    L9:
        if (b(r3) == true) goto L12;
        return;
    L12:
        if (r3.d() == true) goto L14;
        r3.a(r3.b().c());
    L15:
        boolean r0 = com.c.a.h.c.a.a(r3);
        if (r3.f() == false) goto L31;
        if (r0 == false) goto L32;
        Iterator<String> r4 = r3.b().c().iterator();
    L20:
        if (r4.hasNext() == false) goto L34;
        File r1 = new File((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin"));
        if (r1.exists() == false) goto L20;
        r1.delete();
        goto L20
    L34:
        return;
    L32:
        return;
    L31:
        return;
    L14:
        c(r3);
        goto L15
    }

    public static void a(b r4) {
        if (c.i() == false) goto L5;
        e.d("cloudmessage", new String[]{"uploadInfo=" + r4});
    L5:
        if (r4 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r4.k()) == true) goto L12;
        com.c.a.h.c.a.a(r4);
        return;
    }

    private static boolean b(com.c.a.h.b.a r6) {
        if (r6.j() == false) goto L6;
        return false;
    L6:
        if (r6.c() == true) goto L11;
        if ((System.currentTimeMillis() - r6.i()) >= 0) goto L11;
        return false;
    L11:
        if (com.c.a.i.c.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L13;
        return false;
    L13:
        return true;
    }

    private static void c(com.c.a.h.b.a r9) {
        if (r9.b().c().size() != 1) goto L5;
    L15:
        File r0 = new File((String) ZeusTransformUtils.preCheckCast(r9.b().c().get(0), String.class, "com.obric.aiagent.plugin"));
        File r1 = new File(r0.getParent(), a(r0.getName()));
        if (r1.exists() == false) goto L18;
        r1.delete();
    L18:
        com.c.a.i.b.a(r1.getAbsolutePath(), (String[]) ZeusTransformUtils.preCheckCast(r9.b().c().toArray(new String[r9.b().c().size()]), String[].class, "com.obric.aiagent.plugin"));
        ArrayList r2 = new ArrayList(1);
        r2.add(r1.getAbsolutePath());
        r9.a(r2);
        return;
    L5:
        if (r9.e() == true) goto L15;
        ArrayList r3 = new ArrayList();
        Iterator<String> r4 = r9.b().c().iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        File r6 = new File(r5);
        File r7 = new File(r6.getParent(), a(r6.getName()));
        if (r7.exists() == false) goto L13;
        r7.delete();
    L13:
        com.c.a.i.b.a(r7.getAbsolutePath(), new String[]{r5});
        r3.add(r7.getAbsolutePath());
        goto L9
    L14:
        r9.a(r3);
    }

    private static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.lastIndexOf(".");
        if (r0 != (-1)) goto L11;
        return r4 + "-cloudMsg.zip";
    L11:
        return r4.substring(0, r0) + "-cloudMsg.zip";
    }
}
