package com.bytedance.reparo.core.g;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: LocalRecord.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<h> f9224b;

    public e() {
    }

    public Set<h> a() {
        if (this.f9224b != null) goto L6;
        this.f9224b = new HashSet();
    L6:
        return this.f9224b;
    }

    public void a(Set<h> r3) {
        this.f9224b = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
    }

    public String b() {
        if (this.f9223a != null) goto L6;
        this.f9223a = "";
    L6:
        return this.f9223a;
    }

    public void a(String r1) {
        this.f9223a = r1;
    }

    public void a(h r1) {
        a().add(r1);
    }

    public void a(f r1) {
        r1.a(this);
    }

    public boolean b(h r2) {
        if (r2.q() == false) goto L5;
    L10:
        return true;
    L5:
        if (TextUtils.equals(this.f9223a, r2.o()) == true) goto L7;
    L9:
        return false;
    L7:
        if (r2.t() == false) goto L9;
        goto L9
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("hostAppVersion=").append(b()).append("\n");
        Iterator<h> r5 = a().iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r0.append(((h) ZeusTransformUtils.preCheckCast(r5.next(), h.class, "com.obric.aiagent.plugin")).toString()).append("\n");
        goto L4
    L7:
        return r0.toString();
    }
}
