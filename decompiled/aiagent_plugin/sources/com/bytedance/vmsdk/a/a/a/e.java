package com.bytedance.vmsdk.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: LightHttpMessage.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f11680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f11681b;

    public e() {
        this.f11680a = new ArrayList();
        this.f11681b = new ArrayList();
    }

    public void a(String r2, String r3) {
        this.f11680a.add(r2);
        this.f11681b.add(r3);
    }

    public String a(String r4) {
        int r0 = this.f11680a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r4.equals(this.f11680a.get(r1)) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return (String) ZeusTransformUtils.preCheckCast(this.f11681b.get(r1), String.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    public void a() {
        this.f11680a.clear();
        this.f11681b.clear();
    }
}
