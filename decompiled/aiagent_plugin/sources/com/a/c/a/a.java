package com.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: CronConstraint.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3075a;

    public abstract boolean a(com.a.c.b r1);

    public a(String r1) {
        this.f3075a = r1;
    }

    public String a() {
        return this.f3075a;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() != r3.getClass()) goto L13;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
        return Objects.equals(this.f3075a, r4.f3075a);
    L13:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f3075a});
    }
}
