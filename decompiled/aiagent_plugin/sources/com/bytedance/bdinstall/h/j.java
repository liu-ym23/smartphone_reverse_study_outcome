package com.bytedance.bdinstall.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SPCache.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f6285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final an f6286c;

    public j(Context r3, SharedPreferences r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        SharedPreferences r7 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r4, SharedPreferences.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L7;
        this.f6284a = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f6285b = r7;
        this.f6286c = r5;
        return;
    L7:
        throw new IllegalArgumentException("context can't be null");
    }

    @Override // com.bytedance.bdinstall.h.d, com.bytedance.bdinstall.h.i
    public void a(String r1, String r2) {
        g(r1, r2);
    }

    @Override // com.bytedance.bdinstall.h.d, com.bytedance.bdinstall.h.i
    public String a(String r1) {
        return c(r1);
    }

    @Override // com.bytedance.bdinstall.h.d
    public String[] b(String r1) {
        String r0 = c(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }

    @Override // com.bytedance.bdinstall.h.d
    public void a(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        g(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    private String c(String r2) {
        return d(r2).getString(r2, null);
    }

    private void g(String r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = d(r2).edit();
        r1.putString(r2, r3);
        r1.apply();
    }

    private SharedPreferences d(String r2) {
        if ("device_id".equals(r2) == true) goto L12;
        if ("install_id".equals(r2) == true) goto L12;
        if ("bd_did".equals(r2) == true) goto L12;
        return com.bytedance.bdinstall.j.j.a(this.f6284a, this.f6286c);
    L12:
        return this.f6285b;
    }

    @Override // com.bytedance.bdinstall.h.d
    public void a(List<String> r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        Iterator<String> r2 = r9.iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r3) == true) goto L7;
        SharedPreferences r4 = d(r3);
        SharedPreferences.Editor r5 = (SharedPreferences.Editor) ZeusTransformUtils.preCheckCast(r0.get(r4), SharedPreferences.Editor.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L13;
        r5 = d(r3).edit();
        r0.put(r4, r5);
    L13:
        if (r4 == null) goto L7;
        if (r4.contains(r3) == false) goto L7;
        r5.remove(r3);
        goto L7
    L17:
        Iterator r1 = r0.entrySet().iterator();
    L19:
        if (r1.hasNext() == false) goto L21;
        ((SharedPreferences.Editor) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), SharedPreferences.Editor.class, "com.obric.aiagent.plugin")).apply();
        goto L19
    L21:
        super.a(r9);
    }
}
