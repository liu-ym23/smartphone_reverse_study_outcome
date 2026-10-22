package com.ss.android.deviceregister.base;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OaidVivoImpl.java */
/* JADX INFO: loaded from: classes4.dex */
final class s implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.ss.android.deviceregister.c.f<Boolean> f37388a = null;

    static /* synthetic */ String a(String r0, String r1) {
        return b(r0, r1);
    }

    static {
        f37388a = new AnonymousClass1();
    }

    s() {
    }

    static boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f37388a.c(new Object[0]), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.ss.android.deviceregister.base.o
    public boolean b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return a();
    }

    @Override // com.ss.android.deviceregister.base.o
    public o.a c(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.a r4 = new o.a();
        r4.f37379a = query(r2, 0, null);
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
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    private static String query(Context r9, int r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        String r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        ?? r2 = 0;
        r1 = null;
        if (r10 != 0) goto L5;
        Uri r13 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    L12:
        Uri r3 = r13;
    L47:
        if (r3 != null) goto L51;
    L43:
        return r1;
    L51:
        Cursor r14 = ZeusProviderTransform.query(r12.getContentResolver(), r3, null, null, null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27 Exception -> L29
        if (r14 != null) goto L49;
    L22:
        if (r14 == null) goto L43;
        r14.close();     // Catch: Exception -> L25
    L46:
        goto L43
    L49:
    L20:
        e = e;
    L31:
        e.printStackTrace();     // Catch: Throwable -> L35
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "OaidVivo#query", e);     // Catch: Throwable -> L35
        if (r14 == null) goto L43;
        r14.close();     // Catch: Exception -> L25
        goto L46
    L17:
        if (r14.moveToNext() == false) goto L22;
        r1 = r14.getString(r14.getColumnIndex("value"));     // Catch: Exception -> L20 Throwable -> L35
        goto L22
    L29:
        e = e;
        r14 = null;
    L27:
        th = th;
    L37:
        if (r2 != 0) goto L44;
    L42:
        throw th;
    L44:
        r2.close();     // Catch: Exception -> L40
    L40:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "OaidVivo#query close cursor exception.", e);
    L25:
        e = move-exception;
        e.printStackTrace();
        com.ss.android.deviceregister.o.b(com.ss.android.deviceregister.o.f37441a, "OaidVivo#query close cursor exception.", e);
    L35:
        th = th;
        r2 = r12;
        goto L37
    L5:
        if (r10 != 1) goto L7;
        r13 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + r11);
        goto L12
    L7:
        if (r10 == 2) goto L9;
        r3 = null;
        goto L47
    L9:
        r13 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r11);
        goto L12
    }
}
