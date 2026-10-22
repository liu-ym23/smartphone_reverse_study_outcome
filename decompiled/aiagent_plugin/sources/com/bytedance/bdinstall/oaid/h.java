package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MeizuOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class h implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.bdinstall.j.r<Boolean> f6403a;

    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "Meizu";
    }

    h() {
        this.f6403a = new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public boolean b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f6403a.c(new Object[]{r5}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public k.a c(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        Cursor r0 = ZeusProviderTransform.query(r10.getContentResolver(), Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r0 != null) goto L26;
        if (r0 == null) goto L7;
        r0.close();
    L7:
        return null;
    L26:
        k.a r1 = new k.a();     // Catch: Throwable -> L12
        r1.f6412b = a(r0);     // Catch: Throwable -> L12
        if (r0 == null) goto L11;
        r0.close();
    L11:
        return r1;
    L12:
        th = th;
    L24:
        th.printStackTrace();     // Catch: Throwable -> L20
        if (r0 == null) goto L19;
        r0.close();
    L19:
        return null;
    L20:
        th = move-exception;
        if (r0 == null) goto L23;
        r0.close();
    L23:
        throw th;
    L14:
        th = th;
        r0 = null;
        goto L24
    }

    private String a(Cursor r2) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.isClosed() == false) goto L8;
        return null;
    L8:
        r1.moveToFirst();
        int r0 = r1.getColumnIndex("value");
        if (r0 >= 0) goto L11;
        return null;
    L11:
        return r1.getString(r0);
    }
}
