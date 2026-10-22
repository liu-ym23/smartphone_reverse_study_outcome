package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OaidVivoImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class p implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.bdinstall.j.r<Boolean> f6425a = null;

    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "Vivo";
    }

    static /* synthetic */ String a(String r0, String r1) {
        return b(r0, r1);
    }

    static {
        f6425a = new AnonymousClass1();
    }

    p(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
    }

    static boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f6425a.c(new Object[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public boolean b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return a();
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public k.a c(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        k.a r4 = new k.a();
        r4.f6412b = query(r2, 0, null);
        return r4;
    }

    private static String b(String r0, String r1) {
        return SystemProperties.get(r0, r1);
    L7:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    private static String query(Context r9, int r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        String r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        ?? r2 = 0;
        if (r10 != 0) goto L5;
        Uri r13 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    L12:
        Uri r3 = r13;
    L53:
        if (r3 != null) goto L56;
    L46:
        return r1;
    L56:
        Cursor r14 = ZeusProviderTransform.query(r12.getContentResolver(), r3, null, null, null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28 Exception -> L30
        if (r14 != null) goto L54;
    L22:
        if (r14 == null) goto L46;
        r14.close();     // Catch: Exception -> L25
    L25:
        e = e;
        e.printStackTrace();
        StringBuilder r15 = new StringBuilder();
    L27:
        com.bytedance.bdinstall.t.a(r15.append("OaidVivo#query close cursor exception.").append(e).toString());
        goto L46
    L54:
    L20:
        e = e;
    L32:
        e.printStackTrace();     // Catch: Throwable -> L38
        com.bytedance.bdinstall.t.a("OaidVivo#query" + e);     // Catch: Throwable -> L38
        if (r14 == null) goto L46;
        r14.close();     // Catch: Exception -> L36
    L36:
        e = e;
        e.printStackTrace();
        r15 = new StringBuilder();
        goto L27
    L17:
        if (r14.moveToNext() == false) goto L22;
        r1 = r14.getString(r14.getColumnIndex("value"));     // Catch: Exception -> L20 Throwable -> L38
        goto L22
    L30:
        e = e;
        r14 = null;
    L28:
        th = th;
    L40:
        if (r2 != 0) goto L49;
    L45:
        throw th;
    L49:
        r2.close();     // Catch: Exception -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.bdinstall.t.a("OaidVivo#query close cursor exception." + e);
    L38:
        th = th;
        r2 = r12;
        goto L40
    L5:
        if (r10 != 1) goto L7;
        r13 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + r11);
        goto L12
    L7:
        if (r10 == 2) goto L9;
        r3 = null;
        goto L53
    L9:
        r13 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r11);
        goto L12
    }
}
