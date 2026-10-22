package com.obric.android.agilelogger.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DefaultBorderFormatter.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements a {
    public b() {
    }

    @Override // com.obric.android.agilelogger.a.b
    public /* synthetic */ String a(Object r3) {
        return a((String[]) ZeusTransformUtils.preCheckCast(r3, String[].class, "com.obric.aiagent.plugin"));
    }

    public String a(String[] r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        if (r8.length == 0) goto L31;
        String[] r0 = new String[r8.length];
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= r1) goto L13;
        String r5 = r8[r3];
        if (r5 == null) goto L12;
        r0[r4] = r5;
        r4 = r4 + 1;
    L12:
        r3 = r3 + 1;
        goto L8
    L13:
        if (r4 != 0) goto L15;
        return "";
    L15:
        StringBuilder r7 = new StringBuilder();
        r7.append("╔═══════════════════════════════════════════════════════════════════════════════════════════════════").append("\n");
    L16:
        if (r2 >= r4) goto L23;
        r7.append(a(r0[r2]));
        if (r2 == (r4 - 1)) goto L20;
        r7.append("\n").append("╟───────────────────────────────────────────────────────────────────────────────────────────────────").append("\n");
    L21:
        r2 = r2 + 1;
        goto L16
    L20:
        r7.append("\n").append("╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
        goto L21
    L23:
        return r7.toString();
    L31:
        return "";
    }

    private static String a(String r6) {
        StringBuilder r0 = new StringBuilder(r6.length() + 10);
        String[] r7 = r6.split("\n");
        int r2 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        if (r3 == 0) goto L6;
        r0.append("\n");
    L6:
        String r4 = r7[r3];
        r0.append(9553).append(r4);
        r3 = r3 + 1;
        goto L3
    L8:
        return r0.toString();
    }
}
