package com.obric.autogui.agents.vlm.models.omni;

import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: compiled from: NotifyListTransferOptimizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f28421a = null;

    static {
        f28421a = new j();
    }

    private final boolean a(char r3) {
        if ('0' <= r3) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        if ('a' <= r3) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L17;
        return true;
    L17:
        if ('A' <= r3) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L25;
        return true;
    L25:
        return false;
    L19:
        if (r3 >= 'G') goto L21;
        r4 = true;
        goto L22
    L12:
        if (r3 >= 'g') goto L14;
        r2 = true;
        goto L15
    L5:
        if (r3 >= ':') goto L7;
        r1 = true;
        goto L8
    }

    private j() {
    }

    public final boolean a(JsonElement r2, String r3) {
        d.h.b.o.e(r2, "payload");
        String r4 = b(r3);
        if (r4 != null) goto L6;
        return false;
    L6:
        String r5 = r2.toString();
        d.h.b.o.c(r5, "toString(...)");
        return d.h.b.o.a(r4, a(r5));
    }

    public final String a(String r8) {
        d.h.b.o.e(r8, "value");
        MessageDigest r7 = MessageDigest.getInstance("SHA-256");
        byte[] r9 = r8.getBytes(d.o.d.f38623b);
        d.h.b.o.c(r9, "getBytes(...)");
        byte[] r10 = r7.digest(r9);
        char[] r11 = new char[r10.length * 2];
        d.h.b.o.a(r10);
        int r0 = r10.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L6;
        int r4 = r2 + 1;
        int r3 = r10[r1] & 255;
        int r5 = r2 * 2;
        r11[r5] = "0123456789abcdef".charAt(r3 >>> 4);
        r11[r5 + 1] = "0123456789abcdef".charAt(r3 & 15);
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    L6:
        return new String(r11);
    }

    private final String b(String r7) {
        if (r7 == null) goto L33;
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r8 == null) goto L34;
        boolean r2 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r8 = null;
    L13:
        if (r8 != null) goto L16;
        return null;
    L16:
        if (d.o.o.b(r8, "sha256:", true) == false) goto L19;
        r8 = r8.substring(7);
        d.h.b.o.c(r8, "substring(...)");
    L19:
        if (r8.length() != 64) goto L35;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        int r3 = 0;
    L22:
        if (r3 >= r1.length()) goto L27;
        if ((!f28421a.a(r1.charAt(r3))) == true) goto L25;
        r3 = r3 + 1;
        goto L22
    L25:
        r2 = true;
    L27:
        if (r2 == true) goto L37;
        String r6 = r8.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r6, "toLowerCase(...)");
        return r6;
    L37:
        return null;
    L35:
        return null;
    L9:
        r0 = false;
        goto L10
    L34:
        return null;
    L33:
        return null;
    }
}
