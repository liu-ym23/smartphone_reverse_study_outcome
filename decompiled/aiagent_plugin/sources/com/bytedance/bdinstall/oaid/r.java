package com.bytedance.bdinstall.oaid;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PicoOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class r implements k {

    /* JADX INFO: compiled from: PicoOaidImpl.java */
    static class a extends k.a {
        a() {
        }
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public String b() {
        return "Pico";
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public boolean b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return true;
    }

    public r() {
    }

    @Override // com.bytedance.bdinstall.oaid.k
    public k.a c(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        a r5 = new a();
        ContentProviderClient r0 = null;
        ContentProviderClient r6 = r3.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.pico.idprovider"));     // Catch: Throwable -> L13 RemoteException -> L15
    L11:
        e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r6 == null) goto L20;
        r6.close();
    L20:
        Bundle r1 = null;
    L21:
        if (r1 == null) goto L23;
        r5.f6412b = r1.getString("oaid", null);
        r5.f6413c = r1.getBoolean("forbidden", false);
    L23:
        return r5;
    L24:
        th = th;
        r0 = r6;
    L26:
        if (r0 == null) goto L28;
        r0.close();
    L28:
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 17) goto L8;
        r1 = r6.call("request_oaid", null, null);     // Catch: RemoteException -> L11 Throwable -> L24
    L9:
        if (r6 == null) goto L21;
        r6.close();
        goto L21
    L8:
        r1 = null;
        goto L9
    L15:
        e = e;
        r6 = null;
    L13:
        th = th;
        goto L26
    }
}
