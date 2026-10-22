package com.bytedance.vmsdk.a.a.b;

import android.util.Base64;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: WebSocketHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements com.bytedance.vmsdk.a.a.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f11706a;

    public i(f r3) {
        this.f11706a = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.vmsdk.a.a.a.c
    public boolean a(com.bytedance.vmsdk.a.a.d r2, com.bytedance.vmsdk.a.a.a.f r3, com.bytedance.vmsdk.a.a.a.g r4) {
        if (a(r3) == true) goto L6;
        r4.f11685c = 501;
        r4.f11686d = "Not Implemented";
        r4.f11687e = com.bytedance.vmsdk.a.a.a.d.a("Not a supported WebSocket upgrade request\n", "text/plain");
        return true;
    L6:
        b(r2, r3, r4);
        return false;
    }

    private static boolean a(com.bytedance.vmsdk.a.a.a.f r3) {
        if ("websocket".equalsIgnoreCase(a(r3, "Upgrade")) == true) goto L5;
    L9:
        return false;
    L5:
        if ("Upgrade".equals(a(r3, "Connection")) == false) goto L9;
        if ("13".equals(a(r3, "Sec-WebSocket-Version")) == false) goto L9;
        return true;
    }

    private void b(com.bytedance.vmsdk.a.a.d r3, com.bytedance.vmsdk.a.a.a.f r4, com.bytedance.vmsdk.a.a.a.g r5) {
        r5.f11685c = 101;
        r5.f11686d = "Switching Protocols";
        r5.a("Upgrade", "websocket");
        r5.a("Connection", "Upgrade");
        r5.f11687e = null;
        String r6 = a(r4, "Sec-WebSocket-Key");
        if (r6 == null) goto L5;
        r5.a("Sec-WebSocket-Accept", a(r6));
    L5:
        InputStream r7 = r3.a();
        OutputStream r8 = r3.b();
        com.bytedance.vmsdk.a.a.a.h.a(r5, new com.bytedance.vmsdk.a.a.a.h.b(new BufferedOutputStream(r8)));
        new j(r7, r8, this.f11706a).a();
    }

    private static String a(String r1) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L4
        r0.update(h.a(r1 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11"));     // Catch: NoSuchAlgorithmException -> L4
        return Base64.encodeToString(r0.digest(), 2);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static String a(com.bytedance.vmsdk.a.a.a.e r0, String r1) {
        return r0.a(r1);
    }
}
