package com.bytedance.ttnet.a;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ShareCookieHostsSync.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private static final String TAG = "ShareCookieHostsSync";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f11283a;

    public h() {
    }

    static /* synthetic */ void a(h r0, String r1, String r2) {
        r0.b(r1, r2);
    }

    public static h a() {
        if (f11283a != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11283a != null) goto L9;
        f11283a = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f11283a;
    }

    public void a(final String r3, final String r4) {
        if (r4.equals(r3) == false) goto L5;
        return;
    L5:
        final String r1 = "Sync-Cookie";
        new AnonymousClass1(this, r1, r3, r4).a();
    }

    private void b(String r11, String r12) {
        CookieHandler r0 = CookieHandler.getDefault();
        if (r0 != null) goto L6;
        Logger.e(TAG, "Default CookieHandler is null.");
        return;
    L6:
        List<String> r13 = a(r11);
        List<String> r14 = a(r12);
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator<String> r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L20;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        if (com.bytedance.ttnet.utils.e.a(r4, r13) == true) goto L12;
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "added hosts add: " + r4);
    L18:
        r3.add(r4);
        goto L8
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "kept hosts add: " + r4);
    L14:
        r2.add(r4);
        goto L8
    L20:
        if (r3.isEmpty() == false) goto L23;
        return;
    L23:
        if (r2.isEmpty() == false) goto L26;
        r2 = r3;
    L26:
        Map<String, List<String>> r16 = new HashMap();
        Iterator r17 = r2.iterator();
    L28:
        if (r17.hasNext() == false) goto L38;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");
        r16 = r0.get(new URI("https://" + r5 + "/"), null);     // Catch: Throwable -> L36
        if (r16.size() <= 0) goto L28;
        if (Logger.debug() == false) goto L38;
        Logger.d(TAG, "Sync cookie from host: " + r5 + " sync cookies: " + r16.toString());     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.printStackTrace();
    L38:
        if (r16 != null) goto L40;
        return;
    L40:
        if (r16.isEmpty() == true) goto L94;
        List<String> r18 = (List) ZeusTransformUtils.preCheckCast(r16.get("Cookie"), List.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L45;
    L46:
        r18 = (List) ZeusTransformUtils.preCheckCast(r16.get("cookie"), List.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L49;
        return;
    L49:
        if (r18.isEmpty() == true) goto L95;
    L51:
        LinkedHashMap r19 = new LinkedHashMap();
        List<String> r10 = a(r18);
        Iterator r110 = r3.iterator();
    L53:
        if (r110.hasNext() == false) goto L96;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.aiagent.plugin");
        ArrayList r6 = new ArrayList();
        URI r7 = new URI("https://" + r1 + "/");     // Catch: Throwable -> L63
        Iterator<String> r8 = r10.iterator();     // Catch: Throwable -> L63
    L57:
        if (r8.hasNext() == false) goto L61;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        if (com.bytedance.common.utility.j.a(r9) == true) goto L57;
        r6.add(r9 + "; Domain=" + r1);     // Catch: Throwable -> L63
        goto L57
    L61:
        r19.put("Set-Cookie", r6);     // Catch: Throwable -> L63
        r0.put(r7, r19);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L96:
        return;
    L95:
        return;
    L45:
        if (r18.isEmpty() == false) goto L51;
    }

    private List<String> a(List<String> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        String[] r1 = ((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin")).split(";");
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L4;
        String r4 = r1[r3];
        if (com.bytedance.common.utility.j.a(r4) == true) goto L10;
        r8.add(r4.trim());
    L10:
        r3 = r3 + 1;
        goto L6
    L11:
        return r8;
    }

    private List<String> a(String r5) {
        ArrayList r4 = new ArrayList();
        if (com.bytedance.common.utility.j.a(r5) == false) goto L5;
        return r4;
    L5:
        String[] r6 = r5.split(",");
        int r0 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        String r2 = r6[r1];
        if (com.bytedance.common.utility.j.a(r2) == true) goto L10;
        r4.add(r2.trim());
    L10:
        r1 = r1 + 1;
        goto L6
    L11:
        return r4;
    }
}
