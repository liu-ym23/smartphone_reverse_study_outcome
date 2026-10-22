package com.obric.autogui.net.ttnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o.o;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: TtLogId.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f29244a = null;

    static {
        f29244a = new e();
    }

    private e() {
    }

    public final String a(List<com.bytedance.retrofit2.b.b> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L31;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L5:
        boolean r2 = false;
        if (r8.hasNext() == false) goto L15;
        Object r1 = r8.next();
        String r4 = ((com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r1, com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin")).a();
        if (r4 != null) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L5;
    L16:
        com.bytedance.retrofit2.b.b r9 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r1, com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L32;
        String r10 = r9.b();
        if (r10 != null) goto L21;
        return null;
    L21:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L23;
        r2 = true;
    L23:
        if (r2 == true) goto L25;
        return null;
    L25:
        return r10;
    L32:
        return null;
    L10:
        if (o.a(r4, "x-tt-logid", true) != true) goto L12;
        r5 = true;
        goto L13
    L15:
        r1 = null;
        goto L16
    L31:
        return null;
    }

    public final String a(String r7) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r6 != null) goto L5;
    L8:
        boolean r8 = true;
    L10:
        if (r8 == false) goto L25;
        return null;
    L25:
        JSONObject r9 = new JSONObject(r7);     // Catch: Throwable -> L24
        Iterator<String> r10 = r9.keys();
    L15:
        if (r10.hasNext() == false) goto L32;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        if (o.a(r4, "x-tt-logid", true) == false) goto L15;
        String r11 = r9.optString(r4);
        d.h.b.o.a(r11);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L21;
        r1 = true;
    L21:
        if (r1 == true) goto L23;
        return null;
    L23:
        return r11;
    L32:
        return null;
    L31:
        return null;
    L5:
        if (r6.length() == 0) goto L8;
        r8 = false;
        goto L10
    }
}
