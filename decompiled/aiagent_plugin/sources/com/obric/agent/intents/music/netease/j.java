package com.obric.agent.intents.music.netease;

import android.util.Base64;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: EncryptHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f14836a = null;

    static {
        f14836a = new j();
    }

    private j() {
    }

    public final String a(String r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L19;
        byte[] r2 = r7.getBytes(d.o.d.f38623b);     // Catch: Exception -> L12
        o.c(r2, "getBytes(...)");     // Catch: Exception -> L12
        String r3 = m.a(r2, e.f14798a.a());     // Catch: Exception -> L12
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L12
        r4.put("appId", "a3010100000000003a8e52bf0b4677ce");     // Catch: Exception -> L12
        r4.put("ts", r7);     // Catch: Exception -> L12
        r4.put("sign", r3);     // Catch: Exception -> L12
        String r8 = r4.toString();     // Catch: Exception -> L12
        o.c(r8, "toString(...)");     // Catch: Exception -> L12
        byte[] r9 = r8.getBytes(d.o.d.f38623b);     // Catch: Exception -> L12
        o.c(r9, "getBytes(...)");     // Catch: Exception -> L12
        return Base64.encodeToString(m.b(r9, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3JtUeSfqIx+1ZPiVmnSypdp0KJT+OXyVuG7yUEXg2eH++8N8qdScB4XjIZifmO0ysdh6Cf3oYyNZONAlgd4DAT2QL8ffQkEl0qge/j7Y/5k1sZIJgLtCDhlrSgIcdtSeNFtQgn9RM5++eMjKlkPDk1E7cUGKcNIbvOobosU3l7/VxGgdP2l6uoo09FPvAAslPWdfBGhWQzROWehcEaLWaA2da4J0Arj8+A6POD7zx0gKZGkIFhohzZ+v3bJBvJ/24U26GUieBS/fIVxhoTzVr5uaJhzDnxyUoSpKE/Nn0Nz7u5BBNORZZnqKtf3DdVu0DADisaTVqh8hA20+uh0qSwIDAQAB"), 0);
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L19:
        return null;
    L7:
        r1 = false;
        goto L8
    }

    public final String b(String r3) {
        byte[] r2 = m.c(Base64.decode(r3, 0), e.f14798a.a());     // Catch: Exception -> L5
        o.a(r2);     // Catch: Exception -> L5
        return new String(r2, d.o.d.f38623b);
    L5:
        e = move-exception;
        ILogDepend.Companion.e("EncryptHelper", "APP_PRIVATE_KEY error");
        e.printStackTrace();
        return null;
    }

    public final boolean a(String r2, String r3) {
        if (r2 == null) goto L10;
        if (r3 == null) goto L10;
        byte[] r4 = r3.getBytes(d.o.d.f38623b);     // Catch: Exception -> L8
        o.c(r4, "getBytes(...)");     // Catch: Exception -> L8
        return m.a(r4, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3JtUeSfqIx+1ZPiVmnSypdp0KJT+OXyVuG7yUEXg2eH++8N8qdScB4XjIZifmO0ysdh6Cf3oYyNZONAlgd4DAT2QL8ffQkEl0qge/j7Y/5k1sZIJgLtCDhlrSgIcdtSeNFtQgn9RM5++eMjKlkPDk1E7cUGKcNIbvOobosU3l7/VxGgdP2l6uoo09FPvAAslPWdfBGhWQzROWehcEaLWaA2da4J0Arj8+A6POD7zx0gKZGkIFhohzZ+v3bJBvJ/24U26GUieBS/fIVxhoTzVr5uaJhzDnxyUoSpKE/Nn0Nz7u5BBNORZZnqKtf3DdVu0DADisaTVqh8hA20+uh0qSwIDAQAB", r2);
    L8:
        e = move-exception;
        e.printStackTrace();
    L10:
        return false;
    }
}
