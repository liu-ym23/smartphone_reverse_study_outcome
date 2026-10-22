package com.ss.android.deviceregister.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.j.j;
import com.bytedance.bdinstall.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;

/* JADX INFO: compiled from: Cdid.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f<String> f37412a;

    /* JADX INFO: renamed from: com.ss.android.deviceregister.c.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: Cdid.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.ss.android.deviceregister.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Cdid.java */
    private static class C1018a extends f<String> {
        private C1018a() {
        }

        /* synthetic */ C1018a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.ss.android.deviceregister.c.f
        public /* synthetic */ String b(Object[] r1) {
            return a(r1);
        }

        public String a(Object... r4) {
            if (r4 != null) goto L4;
            return null;
        L4:
            if (r4[0] == null) goto L13;
            String r0 = j.a();
            SharedPreferences r3 = ((Context) ZeusTransformUtils.preCheckCast(r4[0], Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(r0, 0);
            String r1 = r3.getString("cdid", "");
            if (TextUtils.isEmpty(r1) == false) goto L12;
            String r2 = UUID.randomUUID().toString();
            r3.edit().putString("cdid", r2).apply();
            return r2;
        L12:
            return r1;
        L13:
            return null;
        }
    }

    static {
        f37412a = new C1018a(null);
    }

    public static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        an r0 = i.a().l();
        if (r0 == null) goto L5;
        String r1 = n.a(r0);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return c(r3);
    L5:
        r1 = null;
        goto L6
    }

    public static void b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        an r0 = i.a().l();
        if (r0 == null) goto L5;
        n.a(r3, r0);
        return;
    L5:
        r3.getSharedPreferences(j.a(), 0).edit().putString("cdid", null).apply();
        f37412a = new C1018a(null);
    }

    private static String c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (String) ZeusTransformUtils.preCheckCast(f37412a.c(new Object[]{r5}), String.class, "com.obric.aiagent.plugin");
    }
}
